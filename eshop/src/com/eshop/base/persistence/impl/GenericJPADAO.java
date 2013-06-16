package com.eshop.base.persistence.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.base.model.EntityBase;
import com.eshop.base.persistence.GenericDAO;

/**
 * Implementation class for GenericDAO
 * 
 * @author 501200C250
 * 
 */

@Transactional(propagation = Propagation.REQUIRED)
public abstract class GenericJPADAO<T extends EntityBase, PK extends Serializable> implements GenericDAO<T, PK> {

	protected Class<T> type;

	public Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext
	private EntityManager entityManager = null;

	public GenericJPADAO() {

	}

	/**
	 * Class Constructor.
	 * 
	 * @param aType type of class this generic dao is used for
	 */
	public GenericJPADAO(Class<T> type) {
		this.type = type;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	private void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public T save(T o, Boolean flush) {
		entityManager.persist(o);
		if (flush) {
			// to get a StaleObjectException immediately
			entityManager.flush();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Persisted entity " + o.toString() + " of class " + type);
		}
		return o;
	}

	@Override
	public T save(T o) {
		save(o, false);
		return o;
	}


	@Override
	public T findById(PK id) {
		T entity = entityManager.find(type, id);
		if (null == entity) {
			if (logger.isDebugEnabled()) {
				logger.debug("No entity found with \"" + id + "\" of class " + type);
			}
			throw new EntityNotFoundException("No entity found with \"" + id + "\" of class " + type);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Found entity with \"" + id + "\" of class " + type);
		}
		return entity;
	}

	@Override
	public List<T> findAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("Getting all persistent entites of class " + type);
		}
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(type);
		cq.from(type);
		Query query = entityManager.createQuery(cq);
		List<T> entities = query.getResultList();
		if (null == entities || entities.isEmpty()) {
			if (logger.isDebugEnabled()) {
				logger.debug("No persistent entities of class " + type + " found.");
			}
		}
		return entities;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Set<T> findAllUnique() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(type);
		cq.from(type);
		cq.distinct(true);
		Query query = entityManager.createQuery(cq);
		List<T> entities = query.getResultList();
		if (null == entities || entities.isEmpty()) {
			if (logger.isDebugEnabled()) {
				logger.debug("No persistent entities of class " + type + " found.");
			}
			throw new NoResultException("No persistent entities of class " + type + " found.");
		}
		if (logger.isDebugEnabled()) {
			logger.debug(entities.size() + " persistent entites of class " + type + " found.");
		}
		return new LinkedHashSet<T>(entities);
	}

	public T findForUpdate(PK id, Integer version) {
		T entity = findById(id);
		if (logger.isDebugEnabled()) {
			logger.debug("Found entity with \"" + id + "\" of class " + type);
		}
		if (version != entity.getVersion()) {
			if (logger.isDebugEnabled()) {
				logger.debug("The entity of type " + type + " with id " + id + " has been edited by another transaction");
			}
			throw new OptimisticLockException("The entity of type " + type + " with id " + id + " has been edited by another transaction");
		}
		return entity;
	}

	@Override
	public void delete(T o) {
		entityManager.remove(o);
		// to get a StaleObjectException immediately
		entityManager.flush();
		if (logger.isDebugEnabled()) {
			logger.debug("Deleted entity " + o.toString() + " of class " + type);
		}
	}

	@Override
	public void deleteAll() {
		String classname = type.getCanonicalName();
		entityManager.createQuery("delete from " + classname).executeUpdate();
		entityManager.flush();

		if (logger.isDebugEnabled()) {
			logger.debug("Deleted all entities  of class " + type);
		}
	}

	@Override
	public T getReference(PK id) {
		return entityManager.getReference(type, id);
	}

	@Override
	public T saveOrUpdate(T o, Boolean flush) {
		T ret = entityManager.merge(o);
		if (flush) {
			// to get a StaleObjectException immediately
			entityManager.flush();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Persisted entity " + o.toString() + " of class " + type);
		}
		return ret;
	}

	@Override
	public T saveOrUpdate(T o) {
		T ret = saveOrUpdate(o, false);
		return ret;
	}

	@Override
	public List<T> saveOrUpdateAll(List<T> newOrDetachedObjects, Boolean flush) {
		List<T> mergedObjects = new ArrayList<T>();
		for (T o : newOrDetachedObjects) {
			T ret = entityManager.merge(o);
			mergedObjects.add(ret);
			if (logger.isDebugEnabled()) {
				logger.debug("Merged entity " + o.toString() + " of class " + type);
			}
		}
		if (flush) {
			// to get a StaleObjectException immediately
			entityManager.flush();
		}
		return mergedObjects;
	}

	@Override
	public List<T> saveOrUpdateAll(List<T> newOrDetachedObjects) {
		List<T> mergedObjects = saveOrUpdateAll(newOrDetachedObjects, false);
		return mergedObjects;
	}

}

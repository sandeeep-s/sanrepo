package com.eshop.base.persistence.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.base.persistence.GenericDAO;

/**
 * Implementation class for GenericDAO
 * 
 * @author 501200C250
 * 
 */

@Transactional(propagation=Propagation.REQUIRED)
public abstract class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected Class<T> type;

	@PersistenceContext
	private EntityManager entityManager = null;

	public GenericDAOImpl() {

	}

	/**
	 * Class Constructor.
	 * 
	 * @param aType type of class this generic dao is used for
	 */
	public GenericDAOImpl(Class<T> aType) {
		this.type = aType;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T save(T o, boolean flush) {
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T save(T o) {
		entityManager.persist(o);

		if (logger.isDebugEnabled()) {
			logger.debug("Persisted entity " + o.toString() + " of class " + type);
		}
		return o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T saveOrUpdate(T o, boolean flush) {
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T saveOrUpdate(T o) {
		T ret = entityManager.merge(o);
		if (logger.isDebugEnabled()) {
			logger.debug("Persisted entity " + o.toString() + " of class " + type);
		}
		return ret;
	}

	@Override
	public List<T> saveOrUpdateAll(List<T> newOrDetachedObjects, boolean flush) {
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
		List<T> mergedObjects = new ArrayList<T>();
		for (T o : newOrDetachedObjects) {
			T ret = entityManager.merge(o);
			mergedObjects.add(ret);
			if (logger.isDebugEnabled()) {
				logger.debug("Merged entity " + o.toString() + " of class " + type);
			}
		}
		return mergedObjects;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T findById(PK id) {
		if (logger.isDebugEnabled()) {
			logger.debug("Getting entity with\"" + id + "\" of class " + type);
		}
		T result = (T) this.entityManager.find(type, id);

		if (logger.isDebugEnabled()) {
			if (null == result) {
				logger.debug("Entity not found.");
			} else {
				logger.debug("Found entity with \"" + id + "\" of class " + type);
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("Getting all persistent entites of class " + type);
		}
		Criteria criteria = ((Session) entityManager.getDelegate()).createCriteria(type);

		List<T> result = (List<T>) criteria.list();
		if (logger.isDebugEnabled() && (null == result || result.isEmpty())) {
			logger.debug("No persistent entities of class " + type + " found.");
		}
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Set<T> findAllUnique() {
		if (logger.isDebugEnabled()) {
			logger.debug("Getting all unique persistent entites of class " + type);
		}
		Criteria criteria = ((Session) entityManager.getDelegate()).createCriteria(type);

		List<T> result = (List<T>) criteria.list();
		if (logger.isDebugEnabled() && (null == result || result.isEmpty())) {
			logger.debug("No persistent entities of class " + type + " found.");
		}
		Set<T> entitySet = null;
		if (null != result && !result.isEmpty()) {
			entitySet = new HashSet<T>();
			entitySet.addAll(result);
		}
		return entitySet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(T o, boolean flush) {
		((Session) entityManager.getDelegate()).update(o);
		if (flush) {
			// to get a StaleObjectException immediately
			entityManager.flush();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Persisted entity " + o.toString() + " of class " + type);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(T o) {
		((Session) entityManager.getDelegate()).update(o);

		if (logger.isDebugEnabled()) {
			logger.debug("Persisted entity " + o.toString() + " of class " + type);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(T o) {
		entityManager.remove(o);
		// to get a StaleObjectException immediately
		entityManager.flush();

		if (logger.isDebugEnabled()) {
			logger.debug("Removed entity " + o.toString() + " of class " + type);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAll() {
		String classname = type.getCanonicalName();
		entityManager.createQuery("delete from " + classname).executeUpdate();
		entityManager.flush();

		if (logger.isDebugEnabled()) {
			logger.debug("Removed all entities  of class " + type);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T getReference(PK id) {
		return entityManager.getReference(type, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T makePersistent(T o, boolean flush) {
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T makePersistent(T o) {
		entityManager.persist(o);

		if (logger.isDebugEnabled()) {
			logger.debug("Persisted entity " + o.toString() + " of class " + type);
		}
		return o;
	}

}

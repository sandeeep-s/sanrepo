
package com.etyre.base.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Interface for GenericDAO
 * 
 * @author 501200C250
 * 
 */
public interface GenericDAO<T, PK extends Serializable> {

	/**
	 * Make a new (transient) instance persistent. Possibility to flush persistent context immediately is provided  
	 * 
	 * @param newInstance - object to save
	 * @param flush - whether the persistent context should be flushed immediately
	 * @return the id of the saved object
	 */
	public T save(T newInstance, boolean flush);

	/**
	 * Make a new (transient) instance persistent. The changes are not flushed immediately  
	 * 
	 * @param newInstance - object to save
	 * @return the id of the saved object
	 */
	public T save(T newInstance);

	/**
	 * Merge the transient or detached object passed as first argument. Following things happen with this method call.
	 * Transient object passed is inserted into the database.
	 * If detached object is passed a check is made in persistent context for a persistent instance with the id of the detached object.
	 * If an instance is found in the persistent context the state of the detached object is copied on to the persistent instance.
	 * If no persistent instance is found in persistent context a database call is made for the id of detached object.
	 * If the persistent instance is retrieved from the database, the state of the detached object is copied to this instance.
	 * If the instance is not retrieved from the database, the state of detached object is copied to a new persistent instance.
	 * Detached object passed remains detached. 
	 * 
	 * @param newOrDetachedObject object to merge
	 * @param flush - whether the persistent context should be flushed immediately
	 * @return the merged object
	 */
	public T saveOrUpdate(T newOrDetachedObject, boolean flush);

	/**
	 * Merge the transient or detached object passed as first argument. Following things happen with this method call.
	 * Transient object passed is inserted into the database.
	 * If detached object is passed a check is made in persistent context for a persistent instance with the id of the detached object.
	 * If an instance is found in the persistent context the state of the detached object is copied on to the persistent instance.
	 * If no persistent instance is found in persistent context a database call is made for the id of detached object.
	 * If the persistent instance is retrieved from the database, the state of the detached object is copied to this instance.
	 * If the instance is not retrieved from the database, the state of detached object is copied to a new persistent instance.
	 * Detached object passed remains detached. 
	 * 
	 * @param newOrDetachedObject object to merge
	 * @return the merged object
	 */
	public T saveOrUpdate(T newOrDetachedObject);

	/**
	 * Convenience method to merge a list of the transient or detached objects.
	 * 
	 * @param newOrDetachedObjects object to merge
	 * @param flush - whether the persistent context should be flushed immediately
	 * @return list of the merged object
	 */
	public List<T> saveOrUpdateAll(List<T> newOrDetachedObjects, boolean flush);

	/**
	 * Convenience method to merge a list of the transient or detached objects.
	 * 
	 * @param newOrDetachedObjects object to merge
	 * @return list of the merged object
	 */
	public List<T> saveOrUpdateAll(List<T> newOrDetachedObjects);

	/**
	 * Retrieve an object that was previously persisted to the database using the indicated id as primary key.
	 * The entity instance returned is always initialized .
	 * This method will first hit the persistent cache to find a persistent instance with the given id.
	 * If the instance is not found in cache it will hit the database.
	 * If the instance is not found in the database it will return null. 
	 * 
	 * @param id - id of object to load
	 * @return the found object
	 */
	public T findById(PK id);

	/**
	 * Finds all persistent objects of the given type in the database.
	 * 
	 * @return all persistent objects of the given type
	 */
	public List<T> findAll();

	/**
	 * Finds all unique persistent objects of the given type in the database.
	 * 
	 * @return all unique persistent objects  of the given type
	 */
	public Set<T> findAllUnique();

	/**
	 * Make changes made to a detached object persistent.
	 * This method makes a detached object persistent
	 * 
	 * @param detachedObject object to update
	 * @param flush - whether the persistent context should be flushed immediately
	 */
	public void update(T detachedObject, boolean flush);

	/**
	 * Make changes made to a detached object persistent.
	 * This method makes a detached object persistent
	 * 
	 * @param detachedObject object to update
	 */
	public void update(T detachedObject);

	/**
	 * Remove an object from persistent storage in the database.
	 * Makes persistent object removed. The persistent context is flushed immediately so that further access to the object is prevented.
	 * 
	 * @param persistentObject object to delete
	 */
	public void delete(T persistentObject);

	/**
	 * Remove all the objects of given type from persistent storage in the database.
	 * Makes persistent object removed. The persistent context is flushed immediately so that further access to the object is prevented.
	 * 
	 */
	public void deleteAll();

	/**
	 * This method returns an initialized object or a proxy for the given id
	 * It never hits the database. 
	 * First it hits the persistent cache to find a persistent instance with this id. If found the persistence instance is returned.
	 * If the instance is not found in the persistent cache it returns a proxy instance with the given id.
	 * 
	 * @param id - id of object to load
	 * @return the found object or proxy
	 */
	public T getReference(PK id);

	/**
	 * Make a new (transient) instance persistent. Possibility to flush persistent context immediately is provided  
	 * 
	 * @param newInstance - object to save
	 * @param flush - whether the persistent context should be flushed immediately
	 * @return the id of the saved object
	 */
	public T makePersistent(T newInstance, boolean flush);

	/**
	 * Make a new (transient) instance persistent. The changes are not flushed immediately  
	 * 
	 * @param newInstance - object to save
	 * @return the id of the saved object
	 */
	public T makePersistent(T newInstance);

	
}

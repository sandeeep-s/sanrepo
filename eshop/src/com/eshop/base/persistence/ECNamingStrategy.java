/**
 * 
 */
package com.eshop.base.persistence;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.internal.util.StringHelper;

/**
 * @author ssd1kor
 *
 */
public class ECNamingStrategy extends ImprovedNamingStrategy {

	@Override
	public String classToTableName(String className) {
		return StringHelper.unqualify(className);
	}

	@Override
	public String propertyToColumnName(String propertyName) {
		return propertyName;
	}

	@Override
	public String tableName(String tableName) {
		return "EC_"+tableName;
	}

	@Override
	public String columnName(String columnName) {
		return columnName;
	}

}

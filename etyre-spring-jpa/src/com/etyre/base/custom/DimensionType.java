/**
 * 
 */
package com.etyre.base.custom;

import java.io.Serializable;

/**
 * @author ssd1kor
 *
 */
public class DimensionType implements Serializable{

	public String value;
	
	public String unit;
	
	public DimensionType(){
		
	}
	
	public DimensionType(String value, String unit){
		this.value = value;
		this.unit = unit;
	}
}

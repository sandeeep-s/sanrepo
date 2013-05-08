/**
 * 
 */
package com.etyre.vehicle.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.etyre.vehicle.model.Vehicle;

/**
 * @author ssd1kor
 *
 */
public class VehicleValidator implements Validator {

	@Override
	public boolean supports(Class<?> claaz) {
		return Vehicle.class.equals(claaz);
	}

	@Override
	public void validate(Object vehicle, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "make", "vehicle.make.empty");
		ValidationUtils.rejectIfEmpty(e, "model", "vehicle.model.empty");
		ValidationUtils.rejectIfEmpty(e, "manufacturingYear", "vehicle.year.empty");
	}

}

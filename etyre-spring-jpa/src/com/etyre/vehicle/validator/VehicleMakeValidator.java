/**
 * 
 */
package com.etyre.vehicle.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.etyre.vehicle.model.VehicleMake;


/**
 * @author ssd1kor
 *
 */
public class VehicleMakeValidator implements Validator {

	@Override
	public boolean supports(Class<?> claaz) {
		return VehicleMake.class.equals(claaz);
	}

	@Override
	public void validate(Object vehicleMake, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "name", "vehicle.make.name.empty");
	}

}

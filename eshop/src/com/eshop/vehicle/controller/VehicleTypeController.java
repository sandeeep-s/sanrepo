/**
 * 
 */
package com.eshop.vehicle.controller;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eshop.base.form.modelmapper.FormModelMapper;
import com.eshop.common.service.MediaService;
import com.eshop.vehicle.form.VehicleTypeForm;
import com.eshop.vehicle.model.VehicleType;
import com.eshop.vehicle.service.VehicleTypeService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/vehicletype")
public class VehicleTypeController {

	public static final String VIEW_LIST_VEHICLE_TYPE = "vehicleTypeList";
	
	public static final String VIEW_ADD_VEHICLE_TYPE = "addVehicleType";

	public static final String VIEW_ADD_SUCCESS_VEHICLE_TYPE = "redirect:vehicletype/{vehicleTypeId}";

	public static final String VIEW_ADD_SUCCESS_VEHICLE_TYPE_ACTUAL = "addVehicleTypeSuccess";

	public static final String VIEW_EDIT_VEHICLE_TYPE = "editVehicleType";
	
	public static final String VIEW_EDITED_VEHICLE_TYPE = "editVehicleTypeSuccess";

	public static final String VIEW_DELETED_VEHICLE_TYPE = "deleteVehicleTypeSuccess";
	
	public static final String VIEW_VIEW_VEHICLE_TYPE = "viewVehicleType";
	
	public static final String VIEW_NOT_FOUND_VEHICLE_TYPE = "vehicleTypeNotFound";

	public static final String COMMAND_NAME_VEHICLE_TYPE = "vehicleType";

	public static final String COMMAND_NAME_VEHICLE_TYPE_LIST = "vehicleTypes";

	public static final String VEHICLE_TYPE_ID = "vehicleTypeId";

	@Inject
	private VehicleTypeService vehicleTypeService;

	@Inject
	private MediaService mediaService;

	@Inject
	@Named("vehicleTypeFormMapper")
	private FormModelMapper<VehicleTypeForm, VehicleType> formModelMapper;

	public VehicleTypeService getVehicleTypeService() {
		return vehicleTypeService;
	}

	public void setVehicleTypeService(VehicleTypeService vehicleTypeService) {
		this.vehicleTypeService = vehicleTypeService;
	}

	public MediaService getMediaService() {
		return mediaService;
	}

	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listVehicleTypes(Model model) {
		Set<VehicleType> vehicleTypes = vehicleTypeService.getAllVehicleTypes();
		model.addAttribute(COMMAND_NAME_VEHICLE_TYPE_LIST, vehicleTypes);
		return VIEW_LIST_VEHICLE_TYPE;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddVehicleTypeForm(Model model) {
		model.addAttribute(COMMAND_NAME_VEHICLE_TYPE, new VehicleTypeForm());
		return VIEW_ADD_VEHICLE_TYPE;
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditVehicleTypeForm(@PathVariable Long id, Model model, HttpServletRequest request) {
		VehicleType vehicleType = vehicleTypeService.getVehicleTypeById(id);
		if (null == vehicleType){
			model.addAttribute(VEHICLE_TYPE_ID, id);
			return VIEW_NOT_FOUND_VEHICLE_TYPE;
		}
		VehicleTypeForm vehicleTypeForm = formModelMapper.mapModelToForm(vehicleType);
		model.addAttribute(COMMAND_NAME_VEHICLE_TYPE, vehicleTypeForm);
		return VIEW_EDIT_VEHICLE_TYPE;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addVehicleType(@Valid @ModelAttribute(COMMAND_NAME_VEHICLE_TYPE) VehicleTypeForm vehicleTypeForm, BindingResult result, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return VIEW_ADD_VEHICLE_TYPE;
		}

		VehicleType vehicleType = formModelMapper.mapFormToNewModel(vehicleTypeForm);
		vehicleType = vehicleTypeService.addVehicleType(vehicleType);
		model.addAttribute(COMMAND_NAME_VEHICLE_TYPE, vehicleType);
		redirectAttributes.addAttribute(VEHICLE_TYPE_ID, vehicleType.getId());
		return VIEW_ADD_SUCCESS_VEHICLE_TYPE;
	}

	@RequestMapping(value="/added", method=RequestMethod.GET)
	public String displayVehicleAdditonSuccess(){
		return VIEW_ADD_SUCCESS_VEHICLE_TYPE_ACTUAL;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getVehicleType(@PathVariable Long id, Model model) {
		VehicleType vehicleType = vehicleTypeService.getVehicleTypeById(id);
		if (null == vehicleType){
			model.addAttribute(VEHICLE_TYPE_ID, id);
			return VIEW_NOT_FOUND_VEHICLE_TYPE;
		}
		model.addAttribute(COMMAND_NAME_VEHICLE_TYPE, vehicleType);
		return VIEW_VIEW_VEHICLE_TYPE;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateVehicleType(@Valid @ModelAttribute(COMMAND_NAME_VEHICLE_TYPE) VehicleTypeForm vehicleTypeForm, BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return VIEW_EDIT_VEHICLE_TYPE;
		}

		VehicleType vehicleType = formModelMapper.mapFormToExistingModel(vehicleTypeForm);
		vehicleType = vehicleTypeService.updateVehicleType(vehicleType);
		model.addAttribute(COMMAND_NAME_VEHICLE_TYPE, vehicleType);
		return VIEW_EDITED_VEHICLE_TYPE;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteVehicleType(@PathVariable Long id, Model model) {
		VehicleType vehicleType = vehicleTypeService.deleteVehicleType(id);
		model.addAttribute(COMMAND_NAME_VEHICLE_TYPE, vehicleType);
		return VIEW_DELETED_VEHICLE_TYPE;
	}

}

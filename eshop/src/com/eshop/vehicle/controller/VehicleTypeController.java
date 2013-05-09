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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.common.service.MediaService;
import com.eshop.vehicle.model.VehicleType;
import com.eshop.vehicle.service.VehicleTypeService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/vehicletype")
public class VehicleTypeController {

	@Inject
	@Named("vehicleTypeService")
	private VehicleTypeService vehicleTypeService;

	@Inject
	@Named("mediaService")
	private MediaService mediaService;

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
		model.addAttribute("vehicleTypes", vehicleTypes);
		return "vehicleTypeList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddVehicleTypeForm(Model model) {
		model.addAttribute("vehicleType", new VehicleType());
		return "addVehicleType";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditVehicleTypeForm(@PathVariable Long id, Model model, HttpServletRequest request) {
		VehicleType vehicleType = vehicleTypeService.getVehicleTypeById(id);
		model.addAttribute("vehicleType", vehicleType);

		return "editVehicleType";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addVehicleType(@Valid VehicleType vehicleType, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addVehicleType";
		}

		vehicleType = vehicleTypeService.addVehicleType(vehicleType);
		model.addAttribute("vehicleType", vehicleType);
		return "addVehicleTypeSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getVehicleType(@PathVariable Long id, Model model) {
		VehicleType vehicleType = vehicleTypeService.getVehicleTypeById(id);
		model.addAttribute("vehicleType", vehicleType);
		return "viewVehicleType";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateVehicleType(@Valid VehicleType vehicleType, BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editVehicleType";
		}

		vehicleType = vehicleTypeService.updateVehicleType(vehicleType);
		model.addAttribute("vehicleType", vehicleType);
		return "editVehicleTypeSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteVehicleType(@PathVariable Long id) {
		vehicleTypeService.deleteVehicleType(id);
		return "deleteVehicleTypeSuccess";
	}

}
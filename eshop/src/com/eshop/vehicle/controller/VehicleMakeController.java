/**
 * 
 */
package com.eshop.vehicle.controller;

import java.util.List;
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

import com.eshop.base.form.modelmapper.FormModelMapper;
import com.eshop.common.service.MediaService;
import com.eshop.vehicle.form.VehicleMakeForm;
import com.eshop.vehicle.model.VehicleMake;
import com.eshop.vehicle.service.VehicleMakeService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/vehiclemake")
public class VehicleMakeController {

	@Inject
	private VehicleMakeService vehicleMakeService;

	@Inject
	private MediaService mediaService;
	
	@Inject
	@Named("vehicleMakeFormMapper")
	private FormModelMapper<VehicleMakeForm, VehicleMake> formModelMapper;

	public VehicleMakeService getVehicleMakeService() {
		return vehicleMakeService;
	}

	public void setVehicleMakeService(VehicleMakeService vehicleMakeService) {
		this.vehicleMakeService = vehicleMakeService;
	}

	public MediaService getMediaService() {
		return mediaService;
	}

	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listVehicleMakes(Model model) {
		Set<VehicleMake> vehicleMakes = vehicleMakeService.getAllVehicleMakes();
		model.addAttribute("vehicleMakes", vehicleMakes);
		return "vehicleMakeList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddVehicleMakeForm(Model model) {
		model.addAttribute("vehicleMake", new VehicleMakeForm());
		return "addVehicleMake";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditVehicleMakeForm(@PathVariable Long id, Model model, HttpServletRequest request) {
		VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(id);
		if (null == vehicleMake){
			model.addAttribute("vehicleMakeId", id);
			return "vehicleMakeNotFound";
		}
		
		VehicleMakeForm vehicleMakeForm = formModelMapper.mapModelToForm(vehicleMake);
		model.addAttribute("vehicleMake", vehicleMakeForm);

		return "editVehicleMake";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addVehicleMake(@Valid @ModelAttribute("vehicleMake") VehicleMakeForm vehicleMakeForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("vehicleMake", vehicleMakeForm);
			return "addVehicleMake";
		}

		VehicleMake vehicleMake = formModelMapper.mapFormToNewModel(vehicleMakeForm);
		
		vehicleMake = vehicleMakeService.addVehicleMake(vehicleMake);
		
		model.addAttribute("vehicleMake", vehicleMake);
		return "addVehicleMakeSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getVehicleMake(@PathVariable Long id, Model model) {
		VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(id);
		if (null == vehicleMake){
			model.addAttribute("vehicleMakeId", id);
			return "vehicleMakeNotFound";
		}

		model.addAttribute("vehicleMake", vehicleMake);
		return "viewVehicleMake";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateVehicleMake(@Valid @ModelAttribute("vehicleMake") VehicleMakeForm vehicleMakeForm, BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editVehicleMake";
		}

		VehicleMake vehicleMake = formModelMapper.mapFormToExistingModel(vehicleMakeForm);
		vehicleMake = vehicleMakeService.updateVehicleMake(vehicleMake);
		model.addAttribute("vehicleMake", vehicleMake);
		return "editVehicleMakeSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteVehicleMake(@PathVariable Long id, Model model) {
		VehicleMake vehicleMake = vehicleMakeService.deleteVehicleMake(id);
		model.addAttribute("vehicleMake", vehicleMake);
		return "deleteVehicleMakeSuccess";
	}

	@RequestMapping(value = "/{id}/modelyears", method = RequestMethod.GET)
	public String getModelYearsForMake(Model model, @PathVariable("id") Long vehicleMakeId, HttpServletRequest request) {
		List<Integer> modelYears = vehicleMakeService.getModelYearsForMake(vehicleMakeId);
		model.addAttribute("modelYears", modelYears);
		return "modelYearsFragment";
	}
}

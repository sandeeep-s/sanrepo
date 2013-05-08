/**
 * 
 */
package com.eshop.vehicle.controller;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.eshop.common.service.MediaService;
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
	@Named("vehicleMakeService")
	private VehicleMakeService vehicleMakeService;

	@Inject
	@Named("mediaService")
	private MediaService mediaService;

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
		Set<VehicleMake> vehicleMakeSet = vehicleMakeService.getAllVehicleMakes();
		model.addAttribute("vehicleMakeSet", vehicleMakeSet);
		return "vehicleMakeList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddVehicleMakeForm(Model model) {
		model.addAttribute("vehicleMake", new VehicleMake());
		return "addVehicleMake";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditVehicleMakeForm(@PathVariable Long id, Model model, HttpServletRequest request) {
		VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(id);
		model.addAttribute("vehicleMake", vehicleMake);

		return "editVehicleMake";
	}

	@RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
	public String displayVehicleMake(@PathVariable Long id, Model model) {
		VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(id);
		model.addAttribute("vehicleMake", vehicleMake);
		return "viewVehicleMake";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getVehicleMake(@PathVariable Long id, Model model) {
		VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(id);
		model.addAttribute("vehicleMake", vehicleMake);
		return "viewVehicleMake";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addVehicleMake(@Valid VehicleMake vehicleMake, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addVehicleMake";
		}

		vehicleMake = vehicleMakeService.addVehicleMake(vehicleMake);
		model.addAttribute("vehicleMake", vehicleMake);
		return "addVehicleMakeSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateVehicleMake(@Valid VehicleMake vehicleMake, BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editVehicleMake";
		}

		vehicleMake = vehicleMakeService.updateVehicleMake(vehicleMake);
		model.addAttribute("vehicleMake", vehicleMake);
		return "editVehicleMakeSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteVehicleMake(@PathVariable Long id) {
		vehicleMakeService.deleteVehicleMake(id);
		return "deleteVehicleMakeSuccess";
	}

}

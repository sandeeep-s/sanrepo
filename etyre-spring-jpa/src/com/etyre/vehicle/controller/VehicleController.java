/**
 * 
 */
package com.etyre.vehicle.controller;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.etyre.base.service.MediaService;
import com.etyre.vehicle.form.VehicleForm;
import com.etyre.vehicle.model.Vehicle;
import com.etyre.vehicle.model.VehicleMake;
import com.etyre.vehicle.service.VehicleMakeService;
import com.etyre.vehicle.service.VehicleService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/vehicle")
@SessionAttributes("vehicle")
public class VehicleController {

	@Inject
	@Named("vehicleService")
	private VehicleService vehicleService;

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

	public VehicleService getVehicleService() {
		return vehicleService;
	}

	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	public MediaService getMediaService() {
		return mediaService;
	}

	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getVehicle(@PathVariable Long id, Model model) {
		Vehicle vehicle = vehicleService.getVehicleById(id);
		model.addAttribute("vehicle", vehicle);
		return "viewVehicle";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addVehicle(Model model, HttpServletRequest request, @Valid VehicleForm vehicleForm, BindingResult result) {
		if (result.hasErrors()) {
			return "addVehicle";
		}
		String webRootPath = request.getServletContext().getRealPath("/");
		MultipartFile image = vehicleForm.getImage();
		String fileName = image.getOriginalFilename();
		mediaService.saveImage(webRootPath, fileName, image);
		Vehicle vehicle = new Vehicle();
		vehicle = vehicleService.addVehicle(vehicle);
		model.addAttribute("vehicle", vehicle);
		return "addVehicleSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateVehicle(Model model, HttpServletRequest request, @Valid VehicleForm vehicleForm, BindingResult result) {
		if (result.hasErrors()) {
			return "editVehicle";
		}
		String webRootPath = request.getServletContext().getRealPath("/");
		MultipartFile image = vehicleForm.getImage();
		String fileName = image.getOriginalFilename();
		mediaService.saveImage(webRootPath, fileName, image);
		HttpSession session = request.getSession();
		Vehicle vehicle = (Vehicle) session.getAttribute("vehicleToBeUpdated");
		vehicle = vehicleService.updateVehicle(vehicle);
		model.addAttribute("vehicle", vehicle);
		return "editVehicleSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteVehicle(@PathVariable Long id) {
		vehicleService.deleteVehicle(id);
		return "deleteVehicleSuccess";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listVehicles(Model model) {
		Set<Vehicle> vehicleSet = vehicleService.getAllVehicles();
		model.addAttribute("vehicleSet", vehicleSet);
		return "vehicleList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddVehicleForm(Model model) {
		Set<VehicleMake> vehicleMakeSet = vehicleMakeService.getAllVehicleMakes();
		model.addAttribute("vehicleMakeSet", vehicleMakeSet);
		model.addAttribute("vehicle", new VehicleForm());
		return "addVehicle";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditVehicleForm(@PathVariable Long id, Model model, HttpServletRequest request) {
		Set<VehicleMake> vehicleMakeSet = vehicleMakeService.getAllVehicleMakes();
		model.addAttribute("vehicleMakeSet", vehicleMakeSet);
		Vehicle vehicle = vehicleService.getVehicleById(id);

/*		VehicleForm vehicleForm = new VehicleForm();
		vehicleForm.setId(vehicle.getId());
		vehicleForm.setMake(vehicle.getVehicleModel().getVehicleMake());
		vehicleForm.setModel(vehicle.getVehicleModel());
		vehicleForm.setSubModel(vehicle.getModel());
		vehicleForm.setManufacturingYear(vehicle.getManufacturingYear());
		vehicleForm.setImageURL(vehicle.getImageURL());
		model.addAttribute("vehicle", vehicleForm);
*/
		HttpSession session = request.getSession();
		session.setAttribute("vehicleToBeUpdated", vehicle);

		return "editVehicle";
	}

	@RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
	public String displayVehicle(@PathVariable Long id, Model model) {
		Vehicle vehicle = vehicleService.getVehicleById(id);
		model.addAttribute("vehicle", vehicle);
		return "viewVehicle";
	}

}

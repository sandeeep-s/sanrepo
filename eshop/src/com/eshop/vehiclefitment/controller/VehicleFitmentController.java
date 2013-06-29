/**
 * 
 */
package com.eshop.vehiclefitment.controller;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.base.form.modelmapper.FormModelMapper;
import com.eshop.catalog.admin.service.ProductService;
import com.eshop.catalog.model.Product;
import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.service.VehicleModelService;
import com.eshop.vehiclefitment.form.VehicleFitmentForm;
import com.eshop.vehiclefitment.model.VehicleFitment;
import com.eshop.vehiclefitment.service.VehicleFitmentService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/vehiclefitment")
public class VehicleFitmentController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	@Named("vehicleFitmentService")
	private VehicleFitmentService vehicleFitmentService;

	@Inject
	@Named("vehicleModelService")
	private VehicleModelService vehicleModelService;

	@Inject
	@Named("productService")
	private ProductService productService;

	@Inject
	@Named("vehicleFitmentFormMapper")
	private FormModelMapper<VehicleFitmentForm, VehicleFitment> formModelMapper;

	public VehicleFitmentService getVehicleFitmentService() {
		return vehicleFitmentService;
	}

	public void setVehicleFitmentService(VehicleFitmentService vehicleFitmentService) {
		this.vehicleFitmentService = vehicleFitmentService;
	}

	public VehicleModelService getVehicleModelService() {
		return vehicleModelService;
	}

	public void setVehicleModelService(VehicleModelService vehicleModelService) {
		this.vehicleModelService = vehicleModelService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listVehicleFitments(Model model) {
		Set<VehicleModel> vehicleModels = vehicleModelService.getAllVehicleModels();
		model.addAttribute("vehicleModels", vehicleModels);

		return "vehicleFitmentList";
	}

	@RequestMapping(value = "/vehiclemodel/{id}", method = RequestMethod.GET)
	public String listVehicleFitmentsForVehicleModel(@PathVariable("id") Long vehicleModelId, Model model) {
		List<VehicleFitment> vehicleFitments = vehicleFitmentService.getVehicleFitmentsForVehicleModel(vehicleModelId);
		model.addAttribute("vehicleFitments", vehicleFitments);

		Set<VehicleModel> vehicleModels = vehicleModelService.getAllVehicleModels();
		model.addAttribute("vehicleModels", vehicleModels);

		return "vehicleFitmentList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddVehicleFitmentForm(Model model) {
		VehicleFitment vehicleFitment = vehicleFitmentService.createVehicleFitment();
		VehicleFitmentForm vehicleFitmentForm = formModelMapper.mapModelToForm(vehicleFitment);
		model.addAttribute("vehicleFitment", vehicleFitmentForm);

		Set<VehicleModel> vehicleModels = vehicleModelService.getAllVehicleModels();
		model.addAttribute("vehicleModels", vehicleModels);

		Set<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);

		return "addVehicleFitment";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditVehicleFitmentForm(@PathVariable Long id, Model model, HttpServletRequest request) {
		VehicleFitment vehicleFitment = vehicleFitmentService.getVehicleFitmentById(id);
		VehicleFitmentForm vehicleFitmentForm = formModelMapper.mapModelToForm(vehicleFitment);
		model.addAttribute("vehicleFitment", vehicleFitmentForm);

		Set<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);

		return "editVehicleFitment";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addVehicleFitment(@Valid VehicleFitmentForm vehicleFitmentForm, BindingResult result, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			System.out.println("addVehicleFitment errors=" + result.getAllErrors());
			return "addVehicleFitment";
		}

		VehicleFitment vehicleFitment = formModelMapper.mapFormToNewModel(vehicleFitmentForm);
		vehicleFitment = vehicleFitmentService.addVehicleFitment(vehicleFitment);
		model.addAttribute("vehicleFitment", vehicleFitment);
		return "addVehicleFitmentSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getVehicleFitment(@PathVariable Long id, Model model) {
		VehicleFitment vehicleFitment = vehicleFitmentService.getVehicleFitmentById(id);
		model.addAttribute("vehicleFitment", vehicleFitment);
		return "viewVehicleFitment";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateVehicleFitment(@Valid VehicleFitmentForm vehicleFitmentForm, BindingResult result, Model model,
			HttpServletRequest request) {

		logger.debug("Inside updateVehicleFitment");
		if (result.hasErrors()) {
			logger.error("Binding error=" + result.getAllErrors());
			return "editVehicleFitment";
		}

		VehicleFitment vehicleFitment = formModelMapper.mapFormToExistingModel(vehicleFitmentForm);
		vehicleFitment = vehicleFitmentService.updateVehicleFitment(vehicleFitment);
		model.addAttribute("vehicleFitment", vehicleFitment);
		return "editVehicleFitmentSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteVehicleFitment(@PathVariable Long id) {
		vehicleFitmentService.deleteVehicleFitment(id);
		return "deleteVehicleFitmentSuccess";
	}

}

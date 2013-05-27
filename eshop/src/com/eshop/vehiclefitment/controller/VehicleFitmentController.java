/**
 * 
 */
package com.eshop.vehiclefitment.controller;

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

import com.eshop.catalog.admin.service.ProductService;
import com.eshop.catalog.model.Product;
import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.service.VehicleModelService;
import com.eshop.vehiclefitment.model.Fitment;
import com.eshop.vehiclefitment.model.FitmentComponent;
import com.eshop.vehiclefitment.model.VehicleFitment;
import com.eshop.vehiclefitment.service.VehicleFitmentService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/vehiclefitment")
public class VehicleFitmentController {

	@Inject
	@Named("vehicleFitmentService")
	private VehicleFitmentService vehicleFitmentService;

	@Inject
	@Named("vehicleModelService")
	private VehicleModelService vehicleModelService;

	@Inject
	@Named("productService")
	private ProductService productService;

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
		Set<VehicleFitment> vehicleFitments = vehicleFitmentService.getAllVehicleFitments();
		model.addAttribute("vehicleFitments", vehicleFitments);
		return "vehicleFitmentList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddVehicleFitmentForm(Model model) {
		FitmentComponent fitmentComponent = new FitmentComponent();
		Fitment fitment = new Fitment();
		fitment.getFitmentComponents().add(fitmentComponent);
		VehicleFitment vehicleFitment = new VehicleFitment();
		vehicleFitment.getFitments().add(fitment);
		model.addAttribute("vehicleFitment", vehicleFitment);

		Set<VehicleModel> vehicleModels = vehicleModelService.getAllVehicleModels();
		model.addAttribute("vehicleModels", vehicleModels);

		Set<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		
		return "addVehicleFitment";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditVehicleFitmentForm(@PathVariable Long id, Model model, HttpServletRequest request) {
		VehicleFitment vehicleFitment = vehicleFitmentService.getVehicleFitmentById(id);
		model.addAttribute("vehicleFitment", vehicleFitment);

		return "editVehicleFitment";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addVehicleFitment(@Valid VehicleFitment vehicleFitment, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			System.out.println("addVehicleFitment errors="+result.getAllErrors());
			return "addVehicleFitment";
		}

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
	public String updateVehicleFitment(@Valid VehicleFitment vehicleFitment, BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editVehicleFitment";
		}

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
package com.eshop.vehicle.controller;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.vehicle.model.VehicleMake;
import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.model.VehicleType;
import com.eshop.vehicle.service.VehicleMakeService;
import com.eshop.vehicle.service.VehicleModelService;
import com.eshop.vehicle.service.VehicleReferenceDataService;
import com.eshop.vehicle.service.VehicleTypeService;

@Controller
@RequestMapping("/vehiclemodel")
public class VehicleModelController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	private VehicleModelService vehicleModelService;

	@Inject
	private VehicleMakeService vehicleMakeService;

	@Inject
	private VehicleTypeService vehicleTypeService;

	@Inject
	private VehicleReferenceDataService vehicleReferenceDataService;

	public VehicleModelService getVehicleModelService() {
		return vehicleModelService;
	}

	public void setVehicleModelService(VehicleModelService vehicleModelService) {
		this.vehicleModelService = vehicleModelService;
	}

	public VehicleMakeService getVehicleMakeService() {
		return vehicleMakeService;
	}

	public void setVehicleMakeService(VehicleMakeService vehicleMakeService) {
		this.vehicleMakeService = vehicleMakeService;
	}

	public VehicleTypeService getVehicleTypeService() {
		return vehicleTypeService;
	}

	public void setVehicleTypeService(VehicleTypeService vehicleTypeService) {
		this.vehicleTypeService = vehicleTypeService;
	}

	public VehicleReferenceDataService getVehicleReferenceDataService() {
		return vehicleReferenceDataService;
	}

	public void setVehicleReferenceDataService(VehicleReferenceDataService vehicleReferenceDataService) {
		this.vehicleReferenceDataService = vehicleReferenceDataService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllVehicleModels(Model model) {
		Set<VehicleModel> vehicleModels = vehicleModelService.getAllVehicleModels();
		model.addAttribute("vehicleModels", vehicleModels);
		return "vehicleModelList";
	}

	private void addRefDataRequestAttributes(Model model) {
		Set<VehicleMake> vehicleMakes = vehicleMakeService.getAllVehicleMakes();
		model.addAttribute("vehicleMakes", vehicleMakes);
		Set<VehicleType> vehicleTypes = vehicleTypeService.getAllVehicleTypes();
		model.addAttribute("vehicleTypes", vehicleTypes);
		List<Integer> modelYearsRefList = vehicleReferenceDataService.getModelYearsReferenceList();
		model.addAttribute("modelYearsRefList", modelYearsRefList);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddVehicleModelForm(Model model) {

		VehicleModel vehicleModel = vehicleModelService.createVehicleModelCommandObject();

		model.addAttribute("vehicleModel", vehicleModel);

		addRefDataRequestAttributes(model);

		return "addVehicleModel";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditVehicleModelForm(@PathVariable Long id, Model model) {

		try {
			VehicleModel vehicleModel = vehicleModelService.getVehicleModelById(id);

			model.addAttribute("vehicleModel", vehicleModel);

			addRefDataRequestAttributes(model);

			return "editVehicleModel";
		} catch (ObjectRetrievalFailureException e) {
			logger.error("VehicleModel with id " + id + " not found.", e);
			model.addAttribute("vehicleModelId", id);
			return "vehicleModelNotFound";
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addVehicleModel(@Valid VehicleModel vehicleModel, BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return "addVehicleModel";
		}

		vehicleModelService.addVehicleModel(vehicleModel);

		model.addAttribute("vehicleModel", vehicleModel);
		return "addVehicleModelSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewVehicleModel(@PathVariable Long id, Model model) {

		try {
			VehicleModel vehicleModel = vehicleModelService.getVehicleModelById(id);
			model.addAttribute("vehicleModel", vehicleModel);
			return "viewVehicleModel";
		} catch (ObjectRetrievalFailureException e) {
			logger.error("VehicleModel with id " + id + " not found.", e);
			model.addAttribute("vehicleModelId", id);
			return "vehicleModelNotFound";
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateVehicleModel(@Valid VehicleModel vehicleModel, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "editVehicleModel";
		}
		
		VehicleModel updatedVehicleModel = null;
		try {
			updatedVehicleModel = vehicleModelService.updateVehicleModel(vehicleModel);
		} catch (OptimisticLockingFailureException e) {
			bindingResult.addError(new ObjectError("vehicleModel", "vehicle.model.edited.by.other.user"));
		}
		model.addAttribute("vehicleModel", updatedVehicleModel);
		return "editVehicleModelSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteVehicleModel(@PathVariable Long id, Model model) {
		VehicleModel vehicleModel = vehicleModelService.deleteVehicleModel(id);
		model.addAttribute("vehicleModel", vehicleModel);
		return "deleteVehicleModelSuccess";
	}

	@RequestMapping(value = "/vehiclemake/{vehicleMakeId}/modelyear/{modelYear}")
	public String getVehicleModelsForModelYear(@PathVariable Long vehicleMakeId, @PathVariable Integer modelYear, Model model) {
		List<VehicleModel> vehicleModels = vehicleModelService.getVehicleModelForMakeAndYear(vehicleMakeId, modelYear);
		model.addAttribute("vehicleModels", vehicleModels);
		return "vehicleModelsFragment";
	}
}

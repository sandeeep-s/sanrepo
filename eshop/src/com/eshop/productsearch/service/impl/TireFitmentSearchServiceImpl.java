package com.eshop.productsearch.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.eshop.catalog.admin.service.DimensionPropertyService;
import com.eshop.catalog.model.Dimension;
import com.eshop.catalog.model.DimensionProperty;
import com.eshop.catalog.model.Product;
import com.eshop.productsearch.form.TireFitmentComponentForm;
import com.eshop.productsearch.form.TireFitmentForm;
import com.eshop.productsearch.service.ProductSearchService;
import com.eshop.productsearch.service.TireFitmentSearchService;
import com.eshop.productsearch.service.VehicleFitmentSearchService;
import com.eshop.vehiclefitment.model.FitmentComponent;
import com.eshop.vehiclefitment.model.VehicleFitment;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TireFitmentSearchServiceImpl implements TireFitmentSearchService {

	@Inject
	private VehicleFitmentSearchService vehicleFitmentSearchService;

	@Inject
	private ProductSearchService productSearchService;

	@Inject
	private DimensionPropertyService dimensionPropertyService;

	@Override
	public List<TireFitmentForm> searchFitmentByCategoryAndVehicleModel(Long categoryId, Long vehicleModelId, Boolean isOriginalEquipment) {

		//find original vehicle fitment objects for the vehicle model
		List<VehicleFitment> vehicleFitments = vehicleFitmentSearchService.searchFitmentByCategoryAndVehicleModel(categoryId,
				vehicleModelId, isOriginalEquipment);

		//Convert vehicle fitments into displayable fitment info.
		List<TireFitmentForm> tireFitmentForms = createTireFitmentFormsFromVehicleFitment(vehicleFitments);

		//Remove duplicate fitment infos.
		tireFitmentForms = new ArrayList<TireFitmentForm>(new LinkedHashSet<TireFitmentForm>(tireFitmentForms));

		return tireFitmentForms;
	}

	public List<TireFitmentForm> createTireFitmentFormsFromVehicleFitment(List<VehicleFitment> vehicleFitments) {
		List<TireFitmentForm> tireFitmentForms = new ArrayList<TireFitmentForm>();
		for (VehicleFitment vehicleFitment : vehicleFitments) {
			TireFitmentForm tireFitmentForm = createTireFitmentFormsFromVehicleFitment(vehicleFitment);
			tireFitmentForms.add(tireFitmentForm);
		}

		return tireFitmentForms;
	}

	public TireFitmentForm createTireFitmentFormsFromVehicleFitment(VehicleFitment vehicleFitment) {
		TireFitmentForm tireFitmentForm = new TireFitmentForm();
		List<TireFitmentComponentForm> fitmentComponentForms = new ArrayList<TireFitmentComponentForm>();
		for (FitmentComponent fitmentComponent : vehicleFitment.getFitmentComponents()) {

			TireFitmentComponentForm tfForm = createTireFitmentComponentFormsFromVehicleFitmentComponent(fitmentComponent);
			fitmentComponentForms.add(tfForm);
		}
		tireFitmentForm.setFitmentComponentForms(fitmentComponentForms);
		return tireFitmentForm;
	}

	public TireFitmentComponentForm createTireFitmentComponentFormsFromVehicleFitmentComponent(FitmentComponent fitmentComponent) {
		TireFitmentComponentForm tfForm = new TireFitmentComponentForm();
		tfForm.setPosition(fitmentComponent.getPosition());
		List<Dimension> dimensions = fitmentComponent.getProduct().getProductSpec().getDimensions();
		for (Dimension dimension : dimensions) {
			if ("Section".equalsIgnoreCase(dimension.getDimensionProperty().getName())) {
				tfForm.setSection(dimension.getDimensionValue());
			}
			if ("AspectRatio".equalsIgnoreCase(dimension.getDimensionProperty().getName())) {
				tfForm.setAspectRatio(dimension.getDimensionValue());
			}
			if ("Diameter".equalsIgnoreCase(dimension.getDimensionProperty().getName())) {
				tfForm.setDiameter(dimension.getDimensionValue());
			}
		}
		return tfForm;
	}

	@Override
	public List<VehicleFitment> searchFitmentByCategoryAndVehicleSubModel(Long categoryId, Long vehicleSubModelId,
			Boolean isOriginalEquipment) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Dimension> createDimensionList(String section, String aspectRatio, String diameter){
		List<Dimension> dimensions = new ArrayList<Dimension>();

		Dimension dimension = new Dimension();
		DimensionProperty dimensionProperty = dimensionPropertyService.getDimensionPropertyByName("Section");
		dimension.setDimensionProperty(dimensionProperty);
		dimension.setDimensionValue(section);
		dimensions.add(dimension);

		Dimension dimension1 = new Dimension();
		DimensionProperty dimensionProperty1 = dimensionPropertyService.getDimensionPropertyByName("AspectRatio");
		dimension1.setDimensionProperty(dimensionProperty1);
		dimension1.setDimensionValue(aspectRatio);
		dimensions.add(dimension1);

		Dimension dimension2 = new Dimension();
		DimensionProperty dimensionProperty2 = dimensionPropertyService.getDimensionPropertyByName("Diameter");
		dimension2.setDimensionProperty(dimensionProperty2);
		dimension2.setDimensionValue(diameter);
		dimensions.add(dimension2);
		
		return dimensions;
	}
	
	@Override
	public List<Product> searchTiresByDimensions(String section, String aspectRatio, String diameter) {

		List<Dimension> dimensions = createDimensionList(section, aspectRatio, diameter);
		List<Product> products = productSearchService.searchProductsByCategoryAndDimensions(new Long(1), dimensions);
		return products;
	}

	@Override
	public List<Product> searchOriginalTiresByDimensions(String section, String aspectRatio, String diameter, Long vehicleModelId) {
		List<Dimension> dimensions = createDimensionList(section, aspectRatio, diameter);
		//find original vehicle fitment objects for the vehicle model
		List<VehicleFitment> vehicleFitments = vehicleFitmentSearchService.searchFitmentByCategoryAndVehicleModel(1L, vehicleModelId, true);
		List<Product> products = extractProductsFromFitments(vehicleFitments);
		return null;
	}

	private List<Product> extractProductsFromFitments(List<VehicleFitment> vehicleFitments){
		return null;
	}
	
}

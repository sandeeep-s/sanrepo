package com.etyre.vehicle.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;

import com.etyre.vehicle.model.TireFitment;
import com.etyre.vehicle.model.TireFitmentSize;
import com.etyre.vehicle.model.Vehicle;
import com.etyre.vehicle.model.VehicleFitment;
import com.etyre.vehicle.model.VehicleMake;
import com.etyre.vehicle.model.VehicleModel;
import com.etyre.vehicle.model.VehicleType;
import com.etyre.vehicle.model.factory.VehicleFactory;
import com.etyre.vehicle.service.VehicleMakeService;
import com.etyre.vehicle.service.VehicleModelService;
import com.etyre.vehicle.service.VehicleService;
import com.etyre.vehicle.service.VehicleTypeService;

public class VehicleServiceTest {

	public ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

	static {
		PropertyConfigurator.configure("log4j.properties");
	}

	private VehicleMakeService vehicleMakeService = (VehicleMakeService) context.getBean("vehicleMakeService");
	private VehicleTypeService vehicleTypeService = (VehicleTypeService) context.getBean("vehicleTypeService");
	private VehicleModelService vehicleModelService = (VehicleModelService) context.getBean("vehicleModelService");
	private VehicleService vehicleService = (VehicleService) context.getBean("vehicleService");

	@Test
	public void addVehicleTest() throws Exception {
		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";

		String vehicleMakeName = "TestMakeAdd";
		String logoImage = "testmakeadd.png";

		String vehicleModelName = "TestModelName";
		Integer manufacturingYear = 2050;
		String vehicleModelImage = "testmodelimage.png";

		String vehicleName = "TestVehicle";
		String vehicleImage = "testvehicleimage.png";

		VehicleType vehicleType = null;
		VehicleMake vehicleMake = null;
		VehicleModel vehicleModel = null;
		Vehicle vehicle = null;
		try {

			vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeService.addVehicleType(vehicleType);
			vehicleMake = new VehicleMake(vehicleMakeName, logoImage);
			vehicleMakeService.addVehicleMake(vehicleMake);
			vehicleModel = new VehicleModel(vehicleModelName, manufacturingYear, vehicleModelImage, vehicleType, vehicleMake);
			vehicleModelService.addVehicleModel(vehicleModel);

			vehicle = VehicleFactory.createVehicle(vehicleName, vehicleImage, vehicleModel, null);
			vehicleService.addVehicle(vehicle);
			
			Vehicle vehicleFound = vehicleService.getVehicleById(vehicle.getId());
			assertNotNull(vehicleFound);
		} finally {
			if (null != vehicle){
				vehicleService.deleteVehicle(vehicle.getId());
			}
			if (null != vehicleModel) {
				vehicleModelService.deleteVehicleModel(vehicleModel.getId());
			}
			if (null != vehicleMake) {
				vehicleMakeService.deleteVehicleMake(vehicleMake.getId());
			}
			if (null != vehicleType) {
				vehicleTypeService.deleteVehicleType(vehicleType.getId());
			}
		}
	}

	@Test
	public void updateVehicleTest() throws Exception {
		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";

		String vehicleMakeName = "TestMakeAdd";
		String logoImage = "testmakeadd.png";

		String vehicleModelName = "TestModelName";
		Integer manufacturingYear = 2050;
		String vehicleModelImage = "testmodelimage.png";

		String vehicleName = "TestVehicle";
		String vehicleImage = "testvehicleimage.png";
		String vehicleImageUpdated = "testvehicleimage1.png";
		
		VehicleType vehicleType = null;
		VehicleMake vehicleMake = null;
		VehicleModel vehicleModel = null;
		Vehicle vehicle = null;
		try {

			vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeService.addVehicleType(vehicleType);
			vehicleMake = new VehicleMake(vehicleMakeName, logoImage);
			vehicleMakeService.addVehicleMake(vehicleMake);
			vehicleModel = new VehicleModel(vehicleModelName, manufacturingYear, vehicleModelImage, vehicleType, vehicleMake);
			vehicleModelService.addVehicleModel(vehicleModel);

			vehicle = VehicleFactory.createVehicle(vehicleName, vehicleImage, vehicleModel, null);
			vehicleService.addVehicle(vehicle);
			
			Vehicle vehicleFound = vehicleService.getVehicleById(vehicle.getId());
			assertNotNull(vehicleFound);
			vehicleFound.setImage(vehicleImageUpdated);
			
			vehicleService.updateVehicle(vehicleFound);
			vehicleFound = null;
			
			vehicleFound = vehicleService.getVehicleById(vehicle.getId());
			assertNotNull(vehicleFound);
			
			assertEquals(vehicleImageUpdated, vehicleFound.getImage());
			
		} finally {
			if (null != vehicle){
				vehicleService.deleteVehicle(vehicle.getId());
			}
			if (null != vehicleModel) {
				vehicleModelService.deleteVehicleModel(vehicleModel.getId());
			}
			if (null != vehicleMake) {
				vehicleMakeService.deleteVehicleMake(vehicleMake.getId());
			}
			if (null != vehicleType) {
				vehicleTypeService.deleteVehicleType(vehicleType.getId());
			}
		}
	}

	@Test
	public void deleteVehicleTest() throws Exception {
		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";

		String vehicleMakeName = "TestMakeAdd";
		String logoImage = "testmakeadd.png";

		String vehicleModelName = "TestModelName";
		Integer manufacturingYear = 2050;
		String vehicleModelImage = "testmodelimage.png";

		String vehicleName = "TestVehicle";
		String vehicleImage = "testvehicleimage.png";

		VehicleType vehicleType = null;
		VehicleMake vehicleMake = null;
		VehicleModel vehicleModel = null;
		Vehicle vehicle = null;
		try {

			vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeService.addVehicleType(vehicleType);
			vehicleMake = new VehicleMake(vehicleMakeName, logoImage);
			vehicleMakeService.addVehicleMake(vehicleMake);
			vehicleModel = new VehicleModel(vehicleModelName, manufacturingYear, vehicleModelImage, vehicleType, vehicleMake);
			vehicleModelService.addVehicleModel(vehicleModel);

			vehicle = VehicleFactory.createVehicle(vehicleName, vehicleImage, vehicleModel, null);
			vehicleService.addVehicle(vehicle);
			Long vehicleId = vehicle.getId();
			
			Vehicle vehicleFound = vehicleService.getVehicleById(vehicle.getId());
			assertNotNull(vehicleFound);
			
			vehicleService.deleteVehicle(vehicle.getId());
			vehicle = null;
			vehicleFound = null;
			
			vehicleFound = vehicleService.getVehicleById(vehicleId);
			assertNull(vehicleFound);
			
		} finally {
			if (null != vehicle){
				vehicleService.deleteVehicle(vehicle.getId());
			}
			if (null != vehicleModel) {
				vehicleModelService.deleteVehicleModel(vehicleModel.getId());
			}
			if (null != vehicleMake) {
				vehicleMakeService.deleteVehicleMake(vehicleMake.getId());
			}
			if (null != vehicleType) {
				vehicleTypeService.deleteVehicleType(vehicleType.getId());
			}
		}
	}

	@Test(expected=DataIntegrityViolationException.class)
	public void addVehicleDuplicateTest() throws Exception {
		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";

		String vehicleMakeName = "TestMakeAdd";
		String logoImage = "testmakeadd.png";

		String vehicleModelName = "TestModelName";
		Integer manufacturingYear = 2050;
		String vehicleModelImage = "testmodelimage.png";

		String vehicleName = "TestVehicle";
		String vehicleImage = "testvehicleimage.png";

		VehicleType vehicleType = null;
		VehicleMake vehicleMake = null;
		VehicleModel vehicleModel = null;
		Vehicle vehicleAdded = null;
		Vehicle vehicleDuplicate = null;
		try {

			vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeService.addVehicleType(vehicleType);
			vehicleMake = new VehicleMake(vehicleMakeName, logoImage);
			vehicleMakeService.addVehicleMake(vehicleMake);
			vehicleModel = new VehicleModel(vehicleModelName, manufacturingYear, vehicleModelImage, vehicleType, vehicleMake);
			vehicleModelService.addVehicleModel(vehicleModel);

			Vehicle vehicle1 = VehicleFactory.createVehicle(vehicleName, vehicleImage, vehicleModel, null);
			Vehicle vehicle2 = VehicleFactory.createVehicle(vehicleName, vehicleImage, vehicleModel, null);
			vehicleAdded = vehicleService.addVehicle(vehicle1);
			vehicleDuplicate = vehicleService.addVehicle(vehicle2);
			
		} finally {
			if (null != vehicleAdded){
				vehicleService.deleteVehicle(vehicleAdded.getId());
			}
			if (null != vehicleDuplicate){
				vehicleService.deleteVehicle(vehicleDuplicate.getId());
			}
			if (null != vehicleModel) {
				vehicleModelService.deleteVehicleModel(vehicleModel.getId());
			}
			if (null != vehicleMake) {
				vehicleMakeService.deleteVehicleMake(vehicleMake.getId());
			}
			if (null != vehicleType) {
				vehicleTypeService.deleteVehicleType(vehicleType.getId());
			}
		}
	}

	@Test(expected=HibernateOptimisticLockingFailureException.class)
	public void addVehicleFirstCommitWinsTest() throws Exception {
		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";

		String vehicleMakeName = "TestMakeAdd";
		String logoImage = "testmakeadd.png";

		String vehicleModelName = "TestModelName";
		Integer manufacturingYear = 2050;
		String vehicleModelImage = "testmodelimage.png";

		String vehicleName = "TestVehicle";
		String vehicleImage = "testvehicleimage.png";

		VehicleType vehicleType = null;
		VehicleMake vehicleMake = null;
		VehicleModel vehicleModel = null;
		Vehicle vehicle = null;
		try {

			vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeService.addVehicleType(vehicleType);
			vehicleMake = new VehicleMake(vehicleMakeName, logoImage);
			vehicleMakeService.addVehicleMake(vehicleMake);
			vehicleModel = new VehicleModel(vehicleModelName, manufacturingYear, vehicleModelImage, vehicleType, vehicleMake);
			vehicleModelService.addVehicleModel(vehicleModel);

			vehicle = VehicleFactory.createVehicle(vehicleName, vehicleImage, vehicleModel, null);
			vehicleService.addVehicle(vehicle);
			
			Vehicle vehicle1 = vehicleService.getVehicleById(vehicle.getId());
			Vehicle vehicle2 = vehicleService.getVehicleById(vehicle.getId());
			
			vehicle1.setImage("testvehicleimage1.png");
			vehicle2.setImage("testvehicleimage2.png");
			
			vehicleService.updateVehicle(vehicle1);
			vehicleService.updateVehicle(vehicle2);
			
		} finally {
			if (null != vehicle){
				vehicleService.deleteVehicle(vehicle.getId());
			}
			if (null != vehicleModel) {
				vehicleModelService.deleteVehicleModel(vehicleModel.getId());
			}
			if (null != vehicleMake) {
				vehicleMakeService.deleteVehicleMake(vehicleMake.getId());
			}
			if (null != vehicleType) {
				System.out.println("vehicleType.getId()="+vehicleType.getId());
				vehicleTypeService.deleteVehicleType(vehicleType.getId());
			}
		}
	}

	@Test
	public void addVehicleWithFitmentCascadeTest() throws Exception {
		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";

		String vehicleMakeName = "TestMakeAdd";
		String logoImage = "testmakeadd.png";

		String vehicleModelName = "TestModelName";
		Integer manufacturingYear = 2050;
		String vehicleModelImage = "testmodelimage.png";

		String vehicleName = "TestVehicle";
		String vehicleImage = "testvehicleimage.png";

		VehicleType vehicleType = null;
		VehicleMake vehicleMake = null;
		VehicleModel vehicleModel = null;
		Vehicle vehicle = null;
		try {

			vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeService.addVehicleType(vehicleType);
			vehicleMake = new VehicleMake(vehicleMakeName, logoImage);
			vehicleMakeService.addVehicleMake(vehicleMake);
			vehicleModel = new VehicleModel(vehicleModelName, manufacturingYear, vehicleModelImage, vehicleType, vehicleMake);
			vehicleModelService.addVehicleModel(vehicleModel);

			TireFitmentSize tireFitmentSizeFront = new TireFitmentSize("225", "65", "18"); 
			TireFitmentSize tireFitmentSizeRear = new TireFitmentSize("235", "75", "20"); 
			TireFitment tireFitment = new TireFitment(tireFitmentSizeFront, tireFitmentSizeRear); 
			VehicleFitment vehicleFitment = new VehicleFitment(tireFitment);
			Set<VehicleFitment> fitments = new HashSet<VehicleFitment>();
			fitments.add(vehicleFitment);
			vehicle = VehicleFactory.createVehicle(vehicleName, vehicleImage, vehicleModel, fitments);
			vehicleService.addVehicle(vehicle);
			assertNotNull(vehicle.getId());
			
			Vehicle vehicleFound = vehicleService.getVehicleById(vehicle.getId());
			assertNotNull(vehicleFound);
		} finally {
			if (null != vehicle){
				vehicleService.deleteVehicle(vehicle.getId());
			}
			if (null != vehicleModel) {
				vehicleModelService.deleteVehicleModel(vehicleModel.getId());
			}
			if (null != vehicleMake) {
				vehicleMakeService.deleteVehicleMake(vehicleMake.getId());
			}
			if (null != vehicleType) {
				vehicleTypeService.deleteVehicleType(vehicleType.getId());
			}
		}
	}

	@Test
	public void getVehiclesByMakeTest() throws Exception {
		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";

		String vehicleMakeName = "TestMakeAdd";
		String logoImage = "testmakeadd.png";

		String vehicleModelName = "TestModelName";
		Integer manufacturingYear = 2050;
		String vehicleModelImage = "testmodelimage.png";

		String vehicleName = "TestVehicle";
		String vehicleImage = "testvehicleimage.png";
		String vehicleName1 = "TestVehicle1";
		String vehicleImage1 = "testvehicleimage1.png";

		VehicleType vehicleType = null;
		VehicleMake vehicleMake = null;
		VehicleModel vehicleModel = null;
		Vehicle vehicle = null;
		Vehicle vehicle1 = null;
		try {

			vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeService.addVehicleType(vehicleType);
			vehicleMake = new VehicleMake(vehicleMakeName, logoImage);
			vehicleMakeService.addVehicleMake(vehicleMake);
			vehicleModel = new VehicleModel(vehicleModelName, manufacturingYear, vehicleModelImage, vehicleType, vehicleMake);
			vehicleModelService.addVehicleModel(vehicleModel);

			vehicle = VehicleFactory.createVehicle(vehicleName, vehicleImage, vehicleModel, null);
			vehicleService.addVehicle(vehicle);
			vehicle1 = VehicleFactory.createVehicle(vehicleName1, vehicleImage1, vehicleModel, null);
			vehicleService.addVehicle(vehicle1);
			
			Set<Vehicle> vehiclesFound = vehicleService.getAllVehiclesForMake(vehicleMake.getId());
			assertNotNull(vehiclesFound);
			assertEquals(2, vehiclesFound.size());
		} finally {
			if (null != vehicle){
				vehicleService.deleteVehicle(vehicle.getId());
			}
			if (null != vehicle1){
				vehicleService.deleteVehicle(vehicle1.getId());
			}
			if (null != vehicleModel) {
				vehicleModelService.deleteVehicleModel(vehicleModel.getId());
			}
			if (null != vehicleMake) {
				vehicleMakeService.deleteVehicleMake(vehicleMake.getId());
			}
			if (null != vehicleType) {
				vehicleTypeService.deleteVehicleType(vehicleType.getId());
			}
		}
	}


/*		@Test
		public void testGetVehiclesByMake() {
			String vehicleMakeName = "Bentley";
			String logoURL = "bentley.png";

			VehicleMake vehicleMake = new VehicleMake(vehicleMakeName, logoURL);
			VehicleMake savedVehicleMake = vehicleMakeService.add(vehicleMake);
			assertNotNull(savedVehicleMake.getId());

			String model = "Mulsanne";
			String subModel = "";
			Integer manufacturingYear = 2010;
			String imageURL = "mulsanne.jpg";

			Vehicle savedVehicle1 = vehicleService.add(savedVehicleMake.getId(), model, subModel, manufacturingYear, imageURL);
			assertNotNull(savedVehicle1.getId());

			model = "Continental";
			subModel = "";
			manufacturingYear = 2010;
			imageURL = "continental.jpg";

			Vehicle savedVehicle2 = vehicleService.add(savedVehicleMake.getId(), model, subModel, manufacturingYear, imageURL);
			assertNotNull(savedVehicle2.getId());

			Set<Vehicle> vehicleSet = vehicleService.getAllForMake(savedVehicleMake.getId());
			assertNotNull(vehicleSet);
			assertEquals(2, vehicleSet.size());

		}
	*/
}

package com.etyre.vehicle.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;

import com.etyre.vehicle.model.VehicleMake;
import com.etyre.vehicle.model.VehicleModel;
import com.etyre.vehicle.model.VehicleType;
import com.etyre.vehicle.service.VehicleMakeService;
import com.etyre.vehicle.service.VehicleModelService;
import com.etyre.vehicle.service.VehicleTypeService;

public class VehicleModelServiceTest {

	public ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

	static {
		PropertyConfigurator.configure("log4j.properties");
	}

	private VehicleModelService vehicleModelService = (VehicleModelService) context.getBean("vehicleModelService");
	private VehicleMakeService vehicleMakeService = (VehicleMakeService) context.getBean("vehicleMakeService");
	private VehicleTypeService vehicleTypeService = (VehicleTypeService) context.getBean("vehicleTypeService");

	@Test
	public void addVehicleModelTest() throws Exception {
		String vehicleModelName = "TestModelName";
		Integer manufacturingYear = 2050;
		String vehicleModelImage = "testmodelimage.png";

		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";

		String vehicleMakeName = "TestMakeAdd";
		String logoImage = "testmakeadd.png";

		VehicleType vehicleType = null;
		VehicleMake vehicleMake = null;
		VehicleModel vehicleModel = null;
		try {

			vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeService.addVehicleType(vehicleType);
			vehicleMake = new VehicleMake(vehicleMakeName, logoImage);
			vehicleMakeService.addVehicleMake(vehicleMake);

			vehicleModel = new VehicleModel(vehicleModelName, manufacturingYear, vehicleModelImage, vehicleType, vehicleMake);
			vehicleModelService.addVehicleModel(vehicleModel);

			VehicleModel vehicleModelFound = vehicleModelService.getVehicleModelById(vehicleModel.getId());
			assertNotNull(vehicleModelFound);
		} finally {
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
	public void updateVehicleModelTest() throws Exception {
		String vehicleModelName = "TestModelName";
		Integer manufacturingYear = 2050;
		String vehicleModelImage = "testmodelimage.png";
		String vehicleModelImageUpdated = "testmodelimage1.png";

		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";

		String vehicleMakeName = "TestMakeAdd";
		String logoImage = "testmakeadd.png";

		VehicleType vehicleType = null;
		VehicleMake vehicleMake = null;
		VehicleModel vehicleModel = null;
		try {

			vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeService.addVehicleType(vehicleType);
			vehicleMake = new VehicleMake(vehicleMakeName, logoImage);
			vehicleMakeService.addVehicleMake(vehicleMake);

			vehicleModel = new VehicleModel(vehicleModelName, manufacturingYear, vehicleModelImage, vehicleType, vehicleMake);
			vehicleModelService.addVehicleModel(vehicleModel);

			VehicleModel vehicleModelFound = vehicleModelService.getVehicleModelById(vehicleModel.getId());
			vehicleModelFound.setImage(vehicleModelImageUpdated);
			assertNotNull(vehicleModelFound);
			vehicleModelService.updateVehicleModel(vehicleModelFound);

			vehicleModelFound = vehicleModelService.getVehicleModelById(vehicleModel.getId());
			assertNotNull(vehicleModelFound);
			assertEquals(vehicleModelImageUpdated, vehicleModelFound.getImage());
		} finally {
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
	public void deleteVehicleModelTest() throws Exception {
		String vehicleModelName = "TestModelName";
		Integer manufacturingYear = 2050;
		String vehicleModelImage = "testmodelimage.png";

		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";

		String vehicleMakeName = "TestMakeAdd";
		String logoImage = "testmakeadd.png";

		VehicleType vehicleType = null;
		VehicleMake vehicleMake = null;
		VehicleModel vehicleModel = null;
		try {

			vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeService.addVehicleType(vehicleType);
			vehicleMake = new VehicleMake(vehicleMakeName, logoImage);
			vehicleMakeService.addVehicleMake(vehicleMake);

			vehicleModel = new VehicleModel(vehicleModelName, manufacturingYear, vehicleModelImage, vehicleType, vehicleMake);
			vehicleModelService.addVehicleModel(vehicleModel);
			Long vehicleModelId = vehicleModel.getId();
			VehicleModel vehicleModelFound = vehicleModelService.getVehicleModelById(vehicleModel.getId());
			assertNotNull(vehicleModelFound);

			vehicleModelService.deleteVehicleModel(vehicleModel.getId());
			vehicleModel = null;
			vehicleModelFound = null;

			vehicleModelFound = vehicleModelService.getVehicleModelById(vehicleModelId);
			assertNull(vehicleModelFound);

		} finally {
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

	@Test(expected = DataIntegrityViolationException.class)
	public void addVehicleModelDuplicateTest() throws Exception {
		String vehicleModelName = "TestModelName";
		Integer manufacturingYear = 2050;
		String vehicleModelImage = "testmodelimage.png";

		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";

		String vehicleMakeName = "TestMakeAdd";
		String logoImage = "testmakeadd.png";

		VehicleType vehicleType = null;
		VehicleMake vehicleMake = null;
		VehicleModel vehicleModelAdded = null;
		VehicleModel vehicleModelAddedDup = null;
		try {

			vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeService.addVehicleType(vehicleType);
			vehicleMake = new VehicleMake(vehicleMakeName, logoImage);
			vehicleMakeService.addVehicleMake(vehicleMake);

			VehicleModel vehicleModel1 = new VehicleModel(vehicleModelName, manufacturingYear, vehicleModelImage, vehicleType, vehicleMake);
			vehicleModelAdded = vehicleModelService.addVehicleModel(vehicleModel1);

			VehicleModel vehicleModel2 = new VehicleModel(vehicleModelName, manufacturingYear, vehicleModelImage, vehicleType, vehicleMake);
			vehicleModelAddedDup = vehicleModelService.addVehicleModel(vehicleModel2);

		} finally {
			if (null != vehicleModelAdded) {
				vehicleModelService.deleteVehicleModel(vehicleModelAdded.getId());
			}
			if (null != vehicleModelAddedDup && null != vehicleModelAddedDup.getId()) {
				vehicleModelService.deleteVehicleModel(vehicleModelAddedDup.getId());
			}
			if (null != vehicleMake) {
				vehicleMakeService.deleteVehicleMake(vehicleMake.getId());
			}
			if (null != vehicleType) {
				vehicleTypeService.deleteVehicleType(vehicleType.getId());
			}
		}
	}

	@Test(expected = HibernateOptimisticLockingFailureException.class)
	public void vehicleModelFirstCommitWinsTest() throws Exception {
		String vehicleModelName = "TestModelName";
		Integer manufacturingYear = 2050;
		String vehicleModelImage = "testmodelimage.png";

		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";

		String vehicleMakeName = "TestMakeAdd";
		String logoImage = "testmakeadd.png";

		VehicleType vehicleType = null;
		VehicleMake vehicleMake = null;
		VehicleModel vehicleModel = null;
		try {

			vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeService.addVehicleType(vehicleType);
			vehicleMake = new VehicleMake(vehicleMakeName, logoImage);
			vehicleMakeService.addVehicleMake(vehicleMake);

			vehicleModel = new VehicleModel(vehicleModelName, manufacturingYear, vehicleModelImage, vehicleType, vehicleMake);
			vehicleModelService.addVehicleModel(vehicleModel);

			VehicleModel vehicleModel1 = vehicleModelService.getVehicleModelById(vehicleModel.getId());
			VehicleModel vehicleModel2 = vehicleModelService.getVehicleModelById(vehicleModel.getId());
			
			vehicleModel1.setImage("testmodelimage1.png");
			vehicleModel2.setImage("testmodelimage2.png");
			
			vehicleModelService.updateVehicleModel(vehicleModel1);
			vehicleModelService.updateVehicleModel(vehicleModel2);
		} finally {
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

}

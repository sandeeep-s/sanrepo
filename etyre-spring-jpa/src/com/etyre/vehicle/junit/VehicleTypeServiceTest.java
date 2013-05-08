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

import com.etyre.vehicle.model.VehicleType;
import com.etyre.vehicle.service.VehicleTypeService;

public class VehicleTypeServiceTest {

	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

	static {
		PropertyConfigurator.configure("log4j.properties");
	}

	private VehicleTypeService vehicleTypeService = (VehicleTypeService) context.getBean("vehicleTypeService");

	@Test
	public void addVehicleTypeTest() throws Exception {
		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";
		VehicleType vehicleTypeAdded = null;
		try {
			VehicleType vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeAdded = vehicleTypeService.addVehicleType(vehicleType);

			VehicleType vehicleTypeFound = vehicleTypeService.getVehicleTypeById(vehicleTypeAdded.getId());

			assertEquals(vehicleTypeName, vehicleTypeFound.getName());
			assertEquals(vehicleTypeImage, vehicleTypeFound.getImage());
		} finally {
			if (null != vehicleTypeAdded) {
				vehicleTypeService.deleteVehicleType(vehicleTypeAdded.getId());
			}
		}
	}

	@Test
	public void updateVehicleTypeTest() throws Exception {
		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";
		String vehicleTypeImageUpdated = "testvehicletype1.png";
		VehicleType vehicleTypeAdded = null;
		try {
			VehicleType vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeAdded = vehicleTypeService.addVehicleType(vehicleType);

			VehicleType vehicleTypeFound = vehicleTypeService.getVehicleTypeById(vehicleTypeAdded.getId());
			vehicleTypeFound.setImage(vehicleTypeImageUpdated);

			vehicleTypeService.updateVehicleType(vehicleTypeFound);

			vehicleTypeFound = vehicleTypeService.getVehicleTypeById(vehicleTypeAdded.getId());

			assertEquals(vehicleTypeImageUpdated, vehicleTypeFound.getImage());
		} finally {
			if (null != vehicleTypeAdded) {
				vehicleTypeService.deleteVehicleType(vehicleTypeAdded.getId());
			}
		}
	}

	@Test
	public void deleteVehicleTypeTest() throws Exception {
		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";
		VehicleType vehicleTypeAdded = null;
		try {
			VehicleType vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeAdded = vehicleTypeService.addVehicleType(vehicleType);
			Long vehicleTypeId = vehicleTypeAdded.getId();
					
			VehicleType vehicleTypeFound = vehicleTypeService.getVehicleTypeById(vehicleTypeAdded.getId());

			assertNotNull(vehicleTypeFound);

			vehicleTypeService.deleteVehicleType(vehicleTypeAdded.getId());
			vehicleTypeAdded = null;
			vehicleType = null;
			
			vehicleTypeFound = vehicleTypeService.getVehicleTypeById(vehicleTypeId);
			
			assertNull(vehicleTypeFound);

		} finally {
			if (null != vehicleTypeAdded) {
				vehicleTypeService.deleteVehicleType(vehicleTypeAdded.getId());
			}
		}
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void addVehicleTypeDuplicateTest() throws Exception {
		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";
		VehicleType vehicleTypeAdded = null;
		VehicleType vehicleTypeAddedDup = null;
		try {
			VehicleType vehicleType1 = new VehicleType(vehicleTypeName, vehicleTypeImage);
			VehicleType vehicleType2 = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeAdded = vehicleTypeService.addVehicleType(vehicleType1);
			vehicleTypeAddedDup = vehicleTypeService.addVehicleType(vehicleType2);
		} finally {
			if (null != vehicleTypeAdded) {
				vehicleTypeService.deleteVehicleType(vehicleTypeAdded.getId());
			}
			if (null != vehicleTypeAddedDup) {
				vehicleTypeService.deleteVehicleType(vehicleTypeAddedDup.getId());
			}
		}
	}

	@Test(expected = HibernateOptimisticLockingFailureException.class)
	public void updateVehicleTypeFirstCommitWinTest() throws Exception {
		String vehicleTypeName = "TestVehicleType";
		String vehicleTypeImage = "testvehicletype.png";
		VehicleType vehicleTypeAdded = null;
		try {
			VehicleType vehicleType = new VehicleType(vehicleTypeName, vehicleTypeImage);
			vehicleTypeAdded = vehicleTypeService.addVehicleType(vehicleType);

			VehicleType vehicleType1 = vehicleTypeService.getVehicleTypeById(vehicleTypeAdded.getId());
			VehicleType vehicleType2 = vehicleTypeService.getVehicleTypeById(vehicleTypeAdded.getId());

			vehicleType1.setImage("testvehicletype1.png");
			vehicleType2.setImage("testvehicletype2.png");
			
			vehicleTypeService.updateVehicleType(vehicleType1);
			vehicleTypeService.updateVehicleType(vehicleType2);
		} finally {
			if (null != vehicleTypeAdded) {
				vehicleTypeService.deleteVehicleType(vehicleTypeAdded.getId());
			}
		}
	}

}

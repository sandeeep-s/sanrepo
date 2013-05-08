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
import com.etyre.vehicle.service.VehicleMakeService;

public class VehicleMakeServiceTest {

	public ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

	static {
		PropertyConfigurator.configure("log4j.properties");
	}

	private VehicleMakeService vehicleMakeService = (VehicleMakeService) context.getBean("vehicleMakeService");

	@Test
	public void testAddVehicleMake() throws Exception {
		String vehicleMakeName = "TestMakeAdd";
		String logoURL = "testmakeadd.png";
		VehicleMake vehicleMakeAdded = null;
		try {
			VehicleMake vehicleMake = new VehicleMake(vehicleMakeName, logoURL);
			vehicleMakeAdded = vehicleMakeService.addVehicleMake(vehicleMake);

			VehicleMake vehicleMakeFound = vehicleMakeService.getVehicleMakeById(vehicleMakeAdded.getId());

			assertEquals(vehicleMakeName, vehicleMakeFound.getName());
			assertEquals(logoURL, vehicleMakeFound.getLogoImage());
		} finally {
			if (null != vehicleMakeAdded) {
				vehicleMakeService.deleteVehicleMake(vehicleMakeAdded.getId());
			}
		}
	}

	@Test
	public void testUpdateVehicleMake() {
		VehicleMake vehicleMakeAdded = null;
		try {
			String vehicleMakeName = "TestMakeUpdate";
			String logoURL = "testmakeupdate.png";

			VehicleMake vehicleMake = new VehicleMake(vehicleMakeName, logoURL);
			vehicleMakeAdded = vehicleMakeService.addVehicleMake(vehicleMake);

			VehicleMake vehicleMakeFound = vehicleMakeService.getVehicleMakeById(vehicleMakeAdded.getId());
			vehicleMakeFound.setLogoImage("testmakeupdate1.png");
			VehicleMake vehicleMakeUpdated = vehicleMakeService.updateVehicleMake(vehicleMakeFound);

			vehicleMakeFound = vehicleMakeService.getVehicleMakeById(vehicleMakeAdded.getId());

			assertEquals("testmakeupdate1.png", vehicleMakeFound.getLogoImage());

		} finally {
			if (null != vehicleMakeAdded){
				vehicleMakeService.deleteVehicleMake(vehicleMakeAdded.getId());
			}
		}
	}

	@Test(expected = HibernateOptimisticLockingFailureException.class)
	public void testAddVehicleMakeFirstCommitWin() {
		VehicleMake vehicleMakeAdded = null;
		try {
			String vehicleMakeName = "TestMakeOpt";
			String logoURL = "testmakeopt.png";

			VehicleMake vehicleMake = new VehicleMake(vehicleMakeName, logoURL);
			vehicleMakeAdded = vehicleMakeService.addVehicleMake(vehicleMake);

			VehicleMake vehicleMake1 = vehicleMakeService.getVehicleMakeById(vehicleMakeAdded.getId());
			VehicleMake vehicleMake2 = vehicleMakeService.getVehicleMakeById(vehicleMakeAdded.getId());

			vehicleMake1.setLogoImage("testmakeopt1.png");
			vehicleMake2.setLogoImage("testmakeopt2.png");

			vehicleMakeService.updateVehicleMake(vehicleMake1);
			vehicleMakeService.updateVehicleMake(vehicleMake2);

		} finally {
			if (null != vehicleMakeAdded){
				vehicleMakeService.deleteVehicleMake(vehicleMakeAdded.getId());
			}
		}
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testAddVehicleMakeDuplicate() {
		VehicleMake vehicleMakeAdded = null;
		VehicleMake vehicleMakeDupAdded = null;
		try {
			String vehicleMakeName = "TestMakeDup";
			String logoURL = "testmakedup.png";

			VehicleMake vehicleMake = new VehicleMake(vehicleMakeName, logoURL);
			VehicleMake vehicleMakeDuplicate = new VehicleMake(vehicleMakeName, logoURL);

			vehicleMakeAdded = vehicleMakeService.addVehicleMake(vehicleMake);
			vehicleMakeDupAdded = vehicleMakeService.addVehicleMake(vehicleMakeDuplicate);
		} finally {
			if (null != vehicleMakeAdded){
				vehicleMakeService.deleteVehicleMake(vehicleMakeAdded.getId());
			}
			if (null != vehicleMakeDupAdded) {
				vehicleMakeService.deleteVehicleMake(vehicleMakeDupAdded.getId());
			}
		}

	}

	@Test
	public void testDeleteVehicleMake() {

		String vehicleMakeName = "TestMakeDelete";
		String logoURL = "testmakedelete.png";

		VehicleMake vehicleMake = new VehicleMake(vehicleMakeName, logoURL);
		VehicleMake vehicleMakeAdded = vehicleMakeService.addVehicleMake(vehicleMake);
		assertNotNull(vehicleMakeAdded.getId());

		VehicleMake vehicleMakeFound = vehicleMakeService.getVehicleMakeById(vehicleMakeAdded.getId());
		vehicleMakeService.deleteVehicleMake(vehicleMakeFound.getId());
		vehicleMakeFound = null;

		vehicleMake = vehicleMakeService.getVehicleMakeById(vehicleMakeAdded.getId());
		assertNull(vehicleMake);
	}

	/*	@Test
		public void testDeleteVehicleMakeCascade() {
			String vehicleMakeName = "Renault";
			String logoURL = "renault.png";

			VehicleMake vehicleMake = new VehicleMake(vehicleMakeName, logoURL);
			VehicleMake savedVehicleMake = vehicleMakeService.add(vehicleMake);

			String model = "Pulse";
			String subModel = "";
			Integer manufacturingYear = 2010;
			String imageURL = "pulse.jpg";

			Vehicle savedVehicle = vehicleService.add(savedVehicleMake.getId(), model, subModel, manufacturingYear, imageURL);
			assertNotNull(savedVehicle.getId());

			vehicleMake = vehicleMakeService.get(savedVehicleMake.getId());
			vehicleMakeService.delete(vehicleMake.getId());
			vehicleMake = vehicleMakeService.get(savedVehicleMake.getId());
			assertNull(vehicleMake);

			Vehicle vehicle = vehicleService.get(savedVehicle.getId());
			assertNull(vehicle);
		}

	*/
}

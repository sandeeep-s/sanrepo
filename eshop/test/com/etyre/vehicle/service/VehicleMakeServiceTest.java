package com.etyre.vehicle.service;

import javax.inject.Inject;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.etyre.common.model.Media;
import com.etyre.common.model.MediaType;
import com.etyre.common.service.MediaService;
import com.etyre.vehicle.model.VehicleMake;

@ContextConfiguration(locations={"classpath:spring-context-test.xml"})
@TransactionConfiguration(defaultRollback=true)
public class VehicleMakeServiceTest extends AbstractTestNGSpringContextTests{

	@Inject
	private VehicleMakeService vehicleMakeService;
	
	@Inject
	private MediaService mediaService;

	@DataProvider(name="createVehicleMakeDataProvider")
	public Object[][] createVehicleMakeData(){
		Object[][] data = new Object[1][];

		String fileLocation = "bmw-normal.jpg";
		String mediaName = "BMW";
		String thumbnailLocation = "bmw-thumbnail.jpg";
		String thumbnailName = "BMW";
		MediaType mediaType = MediaType.IMAGE;
		Media logoImage = mediaService.createMedia(mediaType, fileLocation, mediaName, thumbnailLocation, thumbnailName);

		Object[] vehicleMakeARR = {"BMW", logoImage};
		data[0] = vehicleMakeARR;
		return data;
	}

	@DataProvider(name="getVehicleMakeDataProvider")
	public Object[][] getVehicleMakeData(){
		Object[][] data = new Object[1][];

		String fileLocation = "audi-normal.jpg";
		String mediaName = "AUDI";
		String thumbnailLocation = "audi-thumbnail.jpg";
		String thumbnailName = "AUDI";
		MediaType mediaType = MediaType.IMAGE;
		Media logoImage = mediaService.createMedia(mediaType, fileLocation, mediaName, thumbnailLocation, thumbnailName);

		Object[] vehicleMakeARR = {"AUDI", logoImage};
		data[0] = vehicleMakeARR;
		return data;
	}

	@DataProvider(name="updateVehicleMakeDataProvider")
	public Object[][] updateVehicleMakeData(){
		Object[][] data = new Object[1][];

		String fileLocation = "porsche-normal.jpg";
		String mediaName = "PORSCHE";
		String thumbnailLocation = "porsche-thumbnail.jpg";
		String thumbnailName = "PORSCHE";
		MediaType mediaType = MediaType.IMAGE;
		Media logoImage = mediaService.createMedia(mediaType, fileLocation, mediaName, thumbnailLocation, thumbnailName);

		Object[] vehicleMakeARR = {"PORSCHE", logoImage};
		data[0] = vehicleMakeARR;
		return data;
	}

	@Test(dataProvider="createVehicleMakeDataProvider")
	public void testCreateVehicleMake(String vehicleMakeName, Media logoImage) {

		VehicleMake vehicleMake = vehicleMakeService.createVehicleMake(vehicleMakeName, logoImage);

		AssertJUnit.assertEquals(vehicleMakeName, vehicleMake.getName());
		AssertJUnit.assertEquals(logoImage.getMediaFileName(), vehicleMake.getLogoImage().getMediaFileName());
	}

	@Test(dataProvider="createVehicleMakeDataProvider")
	public void testAddVehicleMake(String vehicleMakeName, Media logoImage) {

		VehicleMake vehicleMake = vehicleMakeService.createVehicleMake(vehicleMakeName, logoImage);

		vehicleMake = vehicleMakeService.addVehicleMake(vehicleMake);

		AssertJUnit.assertNotNull(vehicleMake.getId());

	}
	
	@Test(dataProvider="getVehicleMakeDataProvider")
	public void testgetVehicleMake(String vehicleMakeName, Media logoImage) {

		VehicleMake vehicleMake = vehicleMakeService.createVehicleMake(vehicleMakeName, logoImage);

		vehicleMake = vehicleMakeService.addVehicleMake(vehicleMake);

		VehicleMake retrievedVehicleMake = vehicleMakeService.getVehicleMakeById(vehicleMake.getId());
		AssertJUnit.assertEquals(vehicleMakeName, retrievedVehicleMake.getName());

	}

	@Test(dataProvider="updateVehicleMakeDataProvider")
	public void testUpdateVehicleMake(String vehicleMakeName, Media logoImage) {

		VehicleMake vehicleMake = vehicleMakeService.createVehicleMake(vehicleMakeName, logoImage);

		vehicleMake = vehicleMakeService.addVehicleMake(vehicleMake);

		String fileLocation = "porsche-normal-updated.jpg";
		String mediaName = "PORSCHE-updated";
		String thumbnailLocation = "porsche-thumbnail-updated.jpg";
		String thumbnailName = "PORSCHE-updated";
		MediaType mediaType = MediaType.IMAGE;
		Media updatedLogoImage = mediaService.createMedia(mediaType, fileLocation, mediaName, thumbnailLocation, thumbnailName);

		vehicleMake.setLogoImage(updatedLogoImage);
		vehicleMakeService.updateVehicleMake(vehicleMake);
		
		VehicleMake vehicleMakeUpdated = vehicleMakeService.getVehicleMakeById(vehicleMake.getId());
		AssertJUnit.assertEquals(fileLocation, vehicleMakeUpdated.getLogoImage().getMediaFileName());

	}
	
	public void testDeleteVehicleMake(String vehicleMakeName, Media logoImage){
		
	}

}

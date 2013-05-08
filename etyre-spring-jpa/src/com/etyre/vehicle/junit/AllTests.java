package com.etyre.vehicle.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ VehicleMakeServiceTest.class, VehicleTypeServiceTest.class, VehicleModelServiceTest.class, VehicleServiceTest.class})
public class AllTests {

}

import java.lang.reflect.Method;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.eshop.base.model.EntityBase;
import com.eshop.vehicle.model.VehicleMake;


public class AnnotationTest {

	@Test
	public void testAnnotationInheritence(){
		
		try {
			Method getIdmethodMake =  VehicleMake.class.getMethod("getId");
			Method getIdmethodBase =  EntityBase.class.getMethod("getId");
			AssertJUnit.assertTrue(getIdmethodMake.isAnnotationPresent(Id.class));
			AssertJUnit.assertTrue(getIdmethodBase.isAnnotationPresent(Id.class));
			AssertJUnit.assertTrue(EntityBase.class.isAnnotationPresent(MappedSuperclass.class));
			AssertJUnit.assertFalse(VehicleMake.class.isAnnotationPresent(MappedSuperclass.class));
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

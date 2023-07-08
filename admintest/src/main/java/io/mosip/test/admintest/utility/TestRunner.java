package io.mosip.test.admintest.utility;

import java.io.File;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import io.mosip.admin.fw.util.AdminTestUtil;
import io.mosip.service.BaseTestCase;
import io.mosip.test.admintest.testcase.*;


public class TestRunner {
	static TestListenerAdapter tla = new TestListenerAdapter();
	
	public static String jarUrl = TestRunner.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	public static String uin="";
	public static String perpetualVid="";
	public static String onetimeuseVid="";
	public static String temporaryVid="";
	
	static TestNG testNg;
	
	public static void main(String[] args) throws Exception {
//admin user = AdminTestUtil.generateUIN();
//    	
//    	if (uin != null) {
//    		perpetualVid = AdminTestUtil.generateVID(uin, "perpetual");
//    		onetimeuseVid = AdminTestUtil.generateVID(uin, "onetimeuse");
//    		temporaryVid= AdminTestUtil.generateVID(uin, "temporary");
//    	}
		AdminTestUtil.initialize();
		
		
		testNg=new TestNG();
		
		String listExcludedGroups=JsonUtil.JsonObjParsing(Commons.getTestData(),"setExcludedGroups");
		testNg.setExcludedGroups(listExcludedGroups);
		testNg.setTestClasses(new Class[] {
				
	CenterTest.class,HolidaysTest.class,TemplateTest.class
				
				,
				
				DeviceTest.class,MachineTest.class
				,BlockListTest.class,CenterTypeTest.class,
				DeviceSpecificationTest.class,DeviceTypesTest.class,
				MachineSpecificationTest.class,MachineTypesTest.class,
				DynamicFieldTest.class,DocumentCategoriesTest.class,DocumentTypes.class,
				
			BulkUploadTest.class
		
		});
	//	testNg.addListener(tla);
		testNg.run();
		
	}
	public static String getGlobalResourcePath() {
		if (checkRunType().equalsIgnoreCase("JAR")) {
			return new File(jarUrl).getParentFile().getAbsolutePath()+"/MosipTestResource".toString();
		} else if (checkRunType().equalsIgnoreCase("IDE")) {
			String path = new File(TestRunner.class.getClassLoader().getResource("").getPath()).getAbsolutePath()
					.toString();
			if (path.contains("test-classes"))
				path = path.replace("test-classes", "classes");
			return path;
		}
		return "Global Resource File Path Not Found";
	}
    
	public static String getResourcePath() {
		if (checkRunType().equalsIgnoreCase("JAR")) {
			return new File(jarUrl).getParentFile().getAbsolutePath();
		} else if (checkRunType().equalsIgnoreCase("IDE")) {
			String path = new File(TestRunner.class.getClassLoader().getResource("").getPath()).getAbsolutePath()
					.toString();
			if (path.contains("test-classes"))
				path = path.replace("test-classes", "classes");
			return path;
		}
		return "Global Resource File Path Not Found";
	}
	
	public static String checkRunType() {
		if (TestRunner.class.getResource("TestRunner.class").getPath().toString().contains(".jar"))
			return "JAR";
		else
			return "IDE";
	}
	

}

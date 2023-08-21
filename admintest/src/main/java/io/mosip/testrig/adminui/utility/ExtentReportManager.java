package io.mosip.testrig.adminui.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager extends BaseClass {
	public static ExtentSparkReporter html;
	public static	ExtentReports extent;
	public static String Filepath;
	//public static WebDriver driver;
	public static	ExtentTest test;
	public static ExtentReports getReports() {
		if(extent==null) {
			extent=new ExtentReports();
			Filepath=System.getProperty("user.dir")+"/Reports/"+"mosip-admin-ui-test-report-"+Commons.appendDate+".html";
			html=new ExtentSparkReporter(Filepath);
			  extent.attachReporter(html);
		}
		
		return extent;
		
	}
}

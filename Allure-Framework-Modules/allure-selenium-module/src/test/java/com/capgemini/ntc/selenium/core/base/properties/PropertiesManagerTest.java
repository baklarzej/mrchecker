package com.capgemini.ntc.selenium.core.base.properties;

import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class PropertiesManagerTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	private PropertiesSelenium propertiesSelenium;
	
	@Before
	public void setUp() throws Exception {
		String path = System.getProperty("user.dir") + Paths.get("/src/test/resources/selenium.properties");
		Injector i = Guice.createInjector(PropertiesModule.init(path));
		this.propertiesSelenium = i.getInstance(PropertiesSelenium.class);
	}
	
	@After
	public void tearDown() throws Exception {
		PropertiesModule.delInstance();
	}
	
	@Test
	public void testParamterGetChrome() {
		assertEquals("", "chromedriver.exe", propertiesSelenium.getSeleniumChrome());
	}
	
	@Test
	public void testParamterGetFirefox() {
		assertEquals("", "geckodriver.exe", propertiesSelenium.getSeleniumFirefox());
	}
	
	@Test
	public void testParamterGetPahantomJS() {
		assertEquals("", "phantomjs.exe", propertiesSelenium.getSeleniumPhantomjs());
	}
	
	@Test
	public void testParamterGetIE() {
		assertEquals("", "IEDriverServer.exe", propertiesSelenium.getSeleniumIE());
	}
	
	// @Ignore
	@Test
	public void testDefaultParamters() {
		PropertiesModule.delInstance();
		
		Injector i = Guice.createInjector(PropertiesModule.init());
		PropertiesSelenium propertiesSelenium = i.getInstance(PropertiesSelenium.class);
		
		assertEquals("", "./lib/webdrivers/chrome/chromedriver.exe", propertiesSelenium.getSeleniumChrome());
	}
	
}
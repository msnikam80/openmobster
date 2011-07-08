package org.openmobster.perf.framework;

import java.util.List;
import org.apache.log4j.Logger;

import junit.framework.TestCase;
import org.openmobster.device.agent.frameworks.mobileObject.MobileObject;

public class PerfBootupChannel extends TestCase
{
	private static Logger log = Logger.getLogger(PerfBootupChannel.class);
	
	private SimulatedDeviceStack deviceStack;
	
	public void setUp() throws Exception
	{
		log.info("Starting BootupChannel....................................................");
		this.deviceStack = PerfSuite.getDevice();
		this.deviceStack.getRunner().activateDevice();
	}
	
	public void tearDown() throws Exception
	{
	}
	
	public void testBootupChannel() throws Exception
	{
		DeviceStackRunner runner = null;
		
		this.assertNotNull("Device Not Found for this test case", this.deviceStack);
		
		runner = this.deviceStack.getRunner();
	    runner.bootService();
		
		List<MobileObject> bootupBeans = runner.readAll();
		
		log.info("----------------------------------");
		log.info("Channel: "+runner.getService());
		log.info("BootupBeans: "+bootupBeans.size());
		log.info("--------------------------------");
		
		this.assertTrue("Channel was not properly booted",(bootupBeans != null && !bootupBeans.isEmpty() && bootupBeans.size()==10));
	}
}
package com.euro;

import java.io.File;

/*------------------------------------------------------------------------------------------------------

                                                NEWGEN SOFTWARE TECHNOLOGIES LIMITED

Group                                                       : CTS

Project/Product                                             : ManipalCigna Health Insurance

Application                                                 : PolicyKit

Module                                                      : PolicyKit

File Name                                                   : Utilities.java

Author                                                      : Shobhit TYAGI

Date (DD/MM/YYYY)                                           : 13/01/2020

Description                                                 : Class for logger initialization

-------------------------------------------------------------------------------------------------------

CHANGE HISTORY

-------------------------------------------------------------------------------------------------------

Problem No/CR No   Change Date   Changed By    Change Description

------------------------------------------------------------------------------------------------------*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;


public class Utilities {

	private static Properties p;
	// private static final Logger LOGGER = Logger.getLogger(Utilities.class);
	private static int trackingId = 1;

	static {
		try {
			p = new Properties();
			// String propertiesFilePath = System.getProperty("user.dir") + File.separator +
			// "OnDemand.properties";
			String propertiesFilePath = "E:\\euro.properties";
			p.load(new FileInputStream(propertiesFilePath));
		} catch (IOException e) {
			// LOGGER.info(Encode.forJava(e.getMessage()));
		}
	}

	// **********************************************************************************//

	public static String getProperty(String property) {
		return p.getProperty(property);
	}

}

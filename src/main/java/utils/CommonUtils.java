package utils;

import java.util.Date;

public class CommonUtils 
{
	public static final int IMPLICIT_WAIT_TIME = 10;
	
	private static String getEmailWithTimeStamp()
	{
		Date date = new Date();
		return "wadie"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}

}

package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.IOUtils.*;
public class HelperClass {

	
	public static String getJson(String path) throws IOException {
		
		
		FileInputStream fileInput = new FileInputStream(new File(path));
		
		return IOUtils.toString(fileInput , "UTF-8");	
	}
	
	
	
}

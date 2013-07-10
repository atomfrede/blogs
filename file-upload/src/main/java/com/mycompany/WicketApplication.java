package com.mycompany;

import java.io.File;
import java.io.IOException;

import com.mycompany.fileupload.FileManageResourceReference;
import com.mycompany.fileupload.FileUploadResourceReference;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 */
public class WicketApplication extends WebApplication
{
   public static String BASE_FOLDER = "/tmp/fileUploader";

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		try{
			BASE_FOLDER = File.createTempFile("dummy", "e").getParentFile().getAbsolutePath();
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		
        mountResource("fileManager", new FileManageResourceReference(BASE_FOLDER));
		mountResource("fileUpload", new FileUploadResourceReference(BASE_FOLDER));
	}
}

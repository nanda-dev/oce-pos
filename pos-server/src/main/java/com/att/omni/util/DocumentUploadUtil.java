package com.att.omni.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class DocumentUploadUtil {
	
	public static File convertMultipartFiletoFile(MultipartFile multipartFile) throws IllegalStateException, IOException
	{

	CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile) multipartFile;
	FileItem fileItem = commonsMultipartFile.getFileItem();
	DiskFileItem diskFileItem = (DiskFileItem) fileItem;
	String absPath = diskFileItem.getStoreLocation().getAbsolutePath();
	File file = new File(absPath);


	if (!file.exists()) {
	    file.createNewFile();
	    multipartFile.transferTo(file);
	}

	return file;
	}

}

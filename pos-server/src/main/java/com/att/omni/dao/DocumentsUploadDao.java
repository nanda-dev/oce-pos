package com.att.omni.dao;

import java.io.File;

public interface DocumentsUploadDao {

	void writeFile(File file, String fileName, String FileType);
}

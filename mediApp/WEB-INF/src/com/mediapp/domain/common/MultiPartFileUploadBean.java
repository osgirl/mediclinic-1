package com.mediapp.domain.common;

import org.springframework.web.multipart.MultipartFile;

public class MultiPartFileUploadBean extends MediAppBaseDomain{

	private static final long serialVersionUID = 13322321L;
	
	private MultipartFile file;
    
    private String fileName;
    
    private String filePath;
    
    private String comments;
    
	private int idPatient;

    public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}

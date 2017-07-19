/**
 * 
 */
package com.restfulFileUpload.model;

/**
 * @author Akshay
 *
 */
import java.io.Serializable;
import java.util.Date;

public class FileMetadata implements Serializable{
	
	private String fileName;
	private String path;
	private Date date;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}

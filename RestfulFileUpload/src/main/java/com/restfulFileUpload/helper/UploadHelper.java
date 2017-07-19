/**
 * 
 */
package com.restfulFileUpload.helper;

/**
 * @author Akshay
 *
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.restfulFileUpload.model.FileMetadata;

@Service
public class UploadHelper {

	public boolean singleFileUpload(String uploadFolder, MultipartFile file, String metadata) {

		try {

			byte[] bytes = file.getBytes();
			Path path = Paths.get(uploadFolder + file.getOriginalFilename());
			Files.write(path, bytes);
			saveMetadata(metadata,file.getOriginalFilename(), uploadFolder);

			return true;

		} catch (IOException e) {
			throw new MultipartException("File upload failed");
		}

	}

	private void saveMetadata(String metadata,String fileName, String path) throws IOException {

		FileMetadata f = new FileMetadata();
		f.setFileName(fileName);
		f.setPath(path);
		f.setDate(new Date());
		FileOutputStream fos = new FileOutputStream(metadata, true);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(f);
	}

}

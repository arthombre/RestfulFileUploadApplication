package com.restfulFileUpload.controller;

/**
 * @author Akshay
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.restfulFileUpload.helper.UploadHelper;
import com.restfulFileUpload.model.FileMetadata;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {
	@Autowired
	private UploadHelper uploadHelper;

    //Save the uploaded file and metadata to this folder
    private static String UPLOADED_FOLDER = "D://upload//";
    private static String METADATA = "D://upload//metadata.txt";

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        if(uploadHelper.singleFileUpload(UPLOADED_FOLDER, file, METADATA)) {
        	 redirectAttributes.addFlashAttribute("message",
                     "You successfully uploaded '" + file.getOriginalFilename() + "'");
         	return "redirect:/uploadStatus";
        }
        
        throw new MultipartException("File upload failed");
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}
# RestfulFileUploadApplication
Restful API in spring-boot application to upload file and persist meta-data on a file system

The Restful File Upload application provides the file upload functionality and stores the file into a fixed location on the file system. The meta-data of the file in maintained in a text document called 'metadata.txt' which is stored and constantly updated in the upload folder.

This application is developed using Spring-boot, Spring Restful webservices, Thymeleaf and Maven. No Database is used, the uploaded files and their meta-data is directly stored and maintained on the file system.


# Assumptions and Specifics

- A folder called upload is present on local disk drive D, as D:\upload\
- If folder or drive not present, the Path for file upload has been set in the controller package of the project in the file: UploadController.java 
- The server-port for the application has been set to 8282, thus the project will run on http://localhost:8282/
- Metadata for every file uploaded is maintained in D:\upload\metadata.txt
- For every new file added, the metadata text file is updated and the persistent data is appended.

# Building the Project

- Import the RestfulFileUpload project as Maven into an IDE such as Eclipse
- Create folder structure D:\upload\ for uploaded files and metadata.txt
- If creating such a structure is not possible, change path in UploadController.java to any path as per your convinience
- Run project as a Spring Boot Application
- Access the project on http://localhost:8282/

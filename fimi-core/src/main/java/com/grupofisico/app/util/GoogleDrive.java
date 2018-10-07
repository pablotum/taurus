package com.grupofisico.app.util;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;

public class GoogleDrive {

	private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = new ArrayList<>(); 
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    private static Drive service;

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    
    public GoogleDrive() {
    	try {
	    	NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	        service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
	                .setApplicationName(APPLICATION_NAME)
	                .build();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
    	Collections.addAll(SCOPES, DriveScopes.DRIVE_METADATA_READONLY, DriveScopes.DRIVE_FILE, DriveScopes.DRIVE);
        InputStream in = GoogleDrive.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }
/*
    public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        
        java.io.File f = new java.io.File("ciam.pdf");
        upload(f);
        download();
    }
  */  
    
    
    public String upload(java.io.File filePath) throws IOException, GeneralSecurityException {
    	File fileMetadata = new File();
    	MimetypesFileTypeMap mime = new MimetypesFileTypeMap();
    	String name = filePath.getName();
    	String type = mime.getContentType(filePath);
    
    	fileMetadata.setName(name);
    	//java.io.File filePath = new java.io.File("files/photo.jpg");
    	FileContent mediaContent = new FileContent(type, filePath);
    	File file = service.files().create(fileMetadata, mediaContent)
    	    .setFields("id")
    	    .execute();
    	System.out.println("File ID: " + file.getId());
    	return file.getId();
    }
    
    public OutputStream download(String fileId) throws IOException {
    	//String fileId = "1Y74u1WcsOwakhoOFWw-f-NhsFY2fOkIU";
    	OutputStream outputStream = new ByteArrayOutputStream();
    	service.files().get(fileId)
    	    .executeMediaAndDownloadTo(outputStream);
    	return outputStream;
    }
}

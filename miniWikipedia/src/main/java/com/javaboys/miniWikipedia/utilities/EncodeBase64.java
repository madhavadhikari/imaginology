package com.javaboys.miniWikipedia.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import com.javaboys.miniWikipedia.exception.UserCreateException;


public class EncodeBase64 {

	public static String decoder(String encodedImage) {
		DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("dd-mm-yyyy-hh-mm-ss");
		LocalDateTime currenttime= LocalDateTime.now();
		String dateTime = datetimeformat.format(currenttime);
		String directory="F:\\miniWikipedia\\upload\\"+dateTime+".png";
		File file = new File(directory);
		FileOutputStream imageOutFile;
		try {
			imageOutFile = new FileOutputStream(file);
			byte[] imageData = Base64.getDecoder().decode(encodedImage);
			imageOutFile.write(imageData);
			imageOutFile.close();
		} catch (FileNotFoundException e) {
			throw new UserCreateException(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return directory;
	}
}


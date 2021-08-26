package com.padma;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MovingDeletingAndListingFiles {

	public static void main(String[] args) throws IOException {
		Path utfFile = Files.createTempFile("some", ".txt");
		try {
			/*
			 * There is a Files.move method, but it does not move a file to a designated
			 * directory (which you might expect).
			 * 
			 * test.jpg c:\temp does not work.
			 * test.jpg c:\temp\test.jpg works.
			 */
			
			Files.move(utfFile, Path.of("c:\\dev")); // this is wrong!
		} catch (FileAlreadyExistsException e) {
		}
		
		
		try {
			Files.move(utfFile, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()));
			
			Path utfFile2 = Files.createTempFile("some", ".txt");
			Files.move(utfFile2, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);

			Path utfFile3 = Files.createTempFile("some", ".txt");
			Files.move(utfFile3, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()), StandardCopyOption.ATOMIC_MOVE);
			
		} catch (FileAlreadyExistsException e) {
		}

	}

}

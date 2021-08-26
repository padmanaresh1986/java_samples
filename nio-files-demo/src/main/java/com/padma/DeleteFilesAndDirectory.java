package com.padma;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class DeleteFilesAndDirectory {

	public static void main(String[] args) throws IOException {
		Path tmpDir = Files.createTempDirectory("prefix");
		try {
		    Files.delete(tmpDir);
		} catch (DirectoryNotEmptyException e) {
		    e.printStackTrace();
		}
		
		//How to delete non-empty directories
		
		/*
		 * Files.walk will walk a file tree depth-first, starting with the directory you
		 * specify. The reverseOrder comparator will make sure that you delete all
		 * children, before deleting the actual directory.
		 */
		try (Stream<Path> walk = Files.walk(tmpDir)) {
		    walk.sorted(Comparator.reverseOrder()).forEach(path -> {
		        try {
		            Files.delete(path);
		        } catch (IOException e) {
		            // something could not be deleted..
		            e.printStackTrace();
		        }
		    });
		}

	}

}

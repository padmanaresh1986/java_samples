package com.padma;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ListFIlesInADirectory {
	
	public static void main(String[] args) throws IOException {
		Path tmpDirectory = Files.createTempDirectory("prefix");
		try (var files = Files.list(tmpDirectory)) {
		    files.forEach(System.out::println);
		}

		try (var files = Files.newDirectoryStream(tmpDirectory, "*.txt")) {
		    files.forEach(System.out::println);
		}
		
		//How to list files recursively
		try (var files = Files.walk(tmpDirectory)) {
		    files.forEach(System.out::println);
		}
	}
	
	

}

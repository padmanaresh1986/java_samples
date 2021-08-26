package com.padma;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateFilesAndDirectories {
	
	public static void main(String[] args) throws IOException {
		
		Path path = Path.of("c:\\dev\\licenses\\windows\\readme1.txt");
		
		Path newDirectory = Files.createDirectories(path.getParent().resolve("some/new/dir"));
		System.out.println("newDirectory = " + newDirectory);

		Path newFile = Files.createFile(newDirectory.resolve("emptyFile.txt"));
		System.out.println("newFile = " + newFile);
		
	}

}

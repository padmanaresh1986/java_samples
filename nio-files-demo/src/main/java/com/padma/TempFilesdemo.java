package com.padma;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempFilesdemo {

	public static void main(String[] args) throws IOException {
		
		Path path = Path.of("c:\\dev\\licenses\\windows\\readme.txt");
		
		Path tempFile1 = Files.createTempFile("somePrefixOrNull", ".jpg");
		System.out.println("tempFile1 = " + tempFile1);

		Path tempFile2 = Files.createTempFile(path.getParent(), "somePrefixOrNull", ".jpg");
		System.out.println("tempFile2 = " + tempFile2);

		Path tmpDirectory = Files.createTempDirectory("prefix");
		System.out.println("tmpDirectory = " + tmpDirectory);
	}

}

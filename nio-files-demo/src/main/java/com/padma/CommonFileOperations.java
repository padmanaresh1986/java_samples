package com.padma;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class CommonFileOperations {
	public static void main(String[] args) throws IOException {
		
		//How to check if a file exists
		Path path = Path.of("c:\\dev\\licenses\\windows\\readme.txt");
		boolean exists = Files.exists(path);
		System.out.println("exists = " + exists);
		
		//How to get the last modified date of a file
		FileTime lastModifiedTime = Files.getLastModifiedTime(path);
		System.out.println("lastModifiedTime = " + lastModifiedTime);
		
		//How to get the owner of a file
		UserPrincipal owner = Files.getOwner(path);
		System.out.println("owner = " + owner);
		
		//How to compare files (Java12+)
		/*
		 * Path path = Path.of("c:\\dev\\licenses\\windows\\readme.txt"); long
		 * mismatchIndex = Files.mismatch(path, Paths.get("c:\\dev\\whatever.txt"));
		 * System.out.println("mismatch = " + mismatchIndex);
		 */

	}
}

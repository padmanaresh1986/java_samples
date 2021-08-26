package com.padma;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class PosixPermissionsOfFile {
	
	public static void main(String[] args) throws IOException {
		Path path = Path.of("c:\\dev\\licenses\\windows\\readme.txt");
		try {
		    Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);
		    System.out.println("permissions = " + permissions);
		} catch (UnsupportedOperationException e) {
		    System.err.println("Looks like you're not running on a posix file system");
		}
	}

}

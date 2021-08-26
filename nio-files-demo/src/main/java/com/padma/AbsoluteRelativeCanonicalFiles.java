package com.padma;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AbsoluteRelativeCanonicalFiles {

	public static void main(String[] args) {
		//Relative Paths
		Path p = Paths.get("./src/main/java/../resources/some.properties");
		System.out.println("p.isAbsolute() = " + p.isAbsolute());

		//Absolute Paths
		Path p2 = p.toAbsolutePath();
		System.out.println("p2 = " + p2);
		System.out.println("p2.isAbsolute() = " + p2.isAbsolute());
		
		//Normalized Paths
		Path p3 = p.normalize().toAbsolutePath();
		System.out.println("p3 = " + p3);
		System.out.println("p3.isAbsolute() = " + p3.isAbsolute());
		/*
		 * p3 = C:\dev\java-file-article\src\main\resources\some.properties
		   p3.isAbsolute() = true
		 */
		
		//Relativizing Paths
		Path relativizedPath = Paths.get("C:\\dev\\java-file-article\\").relativize(p3);
		System.out.println("relativizedPath = " + relativizedPath);
		//relativizedPath = src\main\resources\some.properties
	}

}

package com.padma;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;

import com.github.marschall.memoryfilesystem.MemoryFileSystemBuilder;

public class InMemoryFileSystems {

	public static void main(String[] args) throws IOException {
		 try (FileSystem fileSystem = MemoryFileSystemBuilder.newMacOs().build()) {

	            Path inMemoryFile = fileSystem.getPath("/somefile.txt");
	            Files.writeString(inMemoryFile, "Hello World");

	            System.out.println(Files.readString(inMemoryFile));
	        }
	}

}

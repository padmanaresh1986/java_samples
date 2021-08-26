package com.padma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class UsingReadersAndInputStreams {

	public static void main(String[] args) throws IOException {
		
		Path utfFile = Files.createTempFile("some", ".txt");
		try (BufferedReader bufferedReader = Files.newBufferedReader(utfFile)) {
		    // handle reader
		}

		try (InputStream is = Files.newInputStream(utfFile)) {
		    // handle inputstream
		}

	}

}

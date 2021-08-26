package com.padma;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class UsingWritersAndOutputStreams {

	public static void main(String[] args) throws IOException {
		Path utfFile = Files.createTempFile("some", ".txt");
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(utfFile)) {
		    // handle reader
		}

		try (OutputStream os = Files.newOutputStream(utfFile)) {
		    // handle outputstream
		}

	}

}

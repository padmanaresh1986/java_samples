package com.padma;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WritingAndReadingFiles {

	public static void main(String[] args) throws IOException {
		Path utfFile = Files.createTempFile("some", ".txt");
		Files.writeString(utfFile, "this is my string הה צצ üü"); // UTF 8
		System.out.println("utfFile = " + utfFile);

		Path iso88591File = Files.createTempFile("some", ".txt");
		Files.writeString(iso88591File, "this is my string הה צצ üü", StandardCharsets.ISO_8859_1); // otherwise == utf8
		System.out.println("iso88591File = " + iso88591File);
		
		
		//How to write bytes to files
		Path anotherIso88591File = Files.createTempFile("some", ".txt");
		Files.write(anotherIso88591File, "this is my string הה צצ üü".getBytes(StandardCharsets.ISO_8859_1));
		System.out.println("anotherIso88591File = " + anotherIso88591File);
		
		//Options when writing files
		Path anotherUtf8File = Files.createTempFile("some", ".txt");
		Files.writeString(anotherUtf8File, "this is my string הה צצ üü", StandardCharsets.UTF_8,
		        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
		System.out.println("anotherUtf8File = " + anotherUtf8File);

		Path oneMoreUtf8File = Files.createTempFile("some", ".txt");
		Files.write(oneMoreUtf8File, "this is my string הה צצ üü".getBytes(StandardCharsets.UTF_8),
		        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
		System.out.println("oneMoreUtf8File = " + oneMoreUtf8File);
		
		//How to read strings from files
		String s = Files.readString(utfFile);// UTF 8
		System.out.println("s = " + s);

		s = Files.readString(utfFile, StandardCharsets.ISO_8859_1); // otherwise == utf8
		System.out.println("s = " + s);
		
		//How to read bytes from files
		s = new String(Files.readAllBytes(utfFile), StandardCharsets.UTF_8);
		System.out.println("s = " + s);
	}

}

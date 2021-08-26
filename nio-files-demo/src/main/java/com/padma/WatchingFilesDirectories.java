package com.padma;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;


//https://docs.oracle.com/javase/tutorial/essential/io/notification.html
public class WatchingFilesDirectories {
	
	public static void main(String[] args) throws IOException {

	    WatchService watcher = FileSystems.getDefault().newWatchService();

	    Path dir = Path.of("c:\\someDir\\");

	    dir.register(watcher,
	    		StandardWatchEventKinds.ENTRY_CREATE,
	    		StandardWatchEventKinds.ENTRY_DELETE,
	    		StandardWatchEventKinds.ENTRY_MODIFY);

	    for (;;) {

	        WatchKey key;
	        try {
	            key = watcher.take();
	        } catch (InterruptedException x) {
	            return;
	        }

	        for (WatchEvent<?> event: key.pollEvents()) {
	            WatchEvent.Kind<?> kind = event.kind();

	            if (kind ==StandardWatchEventKinds.OVERFLOW) {
	                continue;
	            }

	            WatchEvent<Path> ev = (WatchEvent<Path>)event;
	            Path filename = ev.context();

	            Path changedFile = dir.resolve(filename);

	            // do something with the file
	        }

	        boolean valid = key.reset();
	        if (!valid) {
	            break;
	        }
	    }
	}

}

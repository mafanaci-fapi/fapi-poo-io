package br.edu.fapi.poo.io;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import org.junit.Test;

public class ExemploWatcher {

	@Test
	public void files_createDirectory() throws Exception {
		WatchService watcher = FileSystems.getDefault().newWatchService();

		Path diretorio = Paths.get(System.getProperty("user.dir")).resolve("entrada");

		WatchKey key = diretorio.register(watcher, StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

		for (;;) {
			try {
				key = watcher.take();
			} catch (InterruptedException x) {
				return;
			}
			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent.Kind<?> kind = event.kind();
				Path arquivo = (Path) event.context();
				if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
					System.out.println("Arquivo criado: " + arquivo.getFileName());
				} else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
					System.out.println("Arquivo deletado: " + arquivo.getFileName());
				}
				if ("encerrar.txt".equals(arquivo.getFileName().toString())) {
					watcher.close();
				}
			}
			boolean valid = key.reset();
			if (!valid) {
				System.out.println("Chave invalida");
				break;
			}
		}
	}

}

package br.edu.fapi.poo.io;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.junit.Assert;
import org.junit.Test;

public class ExemploFiles {

	@Test
	public void files_exists() throws Exception {
		Path path = Paths.get(System.getProperty("user.dir"));
		System.out.println(path.toString());
		System.out.println(Files.exists(path, LinkOption.NOFOLLOW_LINKS));

		Path path2 = path.resolve("origem/para-copiar.txt");
		System.out.println(path2.toString());
		System.out.println(Files.exists(path2, LinkOption.NOFOLLOW_LINKS));

		Assert.assertTrue(true);
	}
	
	@Test
	public void files_isDirectory() throws Exception {
		Path path = Paths.get(System.getProperty("user.dir"));
		System.out.println(path.toString());
		System.out.println(Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS));

		
		Path path2 = path.resolve("teste.txt");
		System.out.println(path2.toString());
		System.out.println(Files.exists(path2, LinkOption.NOFOLLOW_LINKS));

		Assert.assertTrue(true);
	}
	
	@Test
	public void files_is_readable_writable_hidden() throws Exception {
		Path path = Paths.get(System.getProperty("user.dir")).resolve("nomes.txt");
		System.out.println(path.toString());
		System.out.println("Is readable: " + Files.isReadable(path));
		System.out.println("Is writable: " + Files.isWritable(path));
		System.out.println("Is executable: " + Files.isExecutable(path));
		System.out.println("Is hidden: " + Files.isHidden(path));
		
		Assert.assertTrue(true);
	}
	
	
	@Test
	public void files_createDirectory() throws Exception {		
		Path path = Paths.get(System.getProperty("user.dir")).resolve("NewDir");
		//Verifica se o path representa um diretorio, o retorno é false pois o diretório ainda não foi criado.
		System.out.println(Files.isDirectory(path));

		try {
			Files.createDirectory(path);
		}catch(FileAlreadyExistsException e) {
			System.out.println("Diretório já criado.");
		}
		
		//Nesse momento o retorno é verdadeiro pois o diretório foi criado.
		System.out.println(Files.isDirectory(path));
		
		Assert.assertTrue(true);
	}

	@Test
	public void files_createFile() throws Exception {		
		Path path = Paths.get(System.getProperty("user.dir")).resolve("test.txt");
		//Verifica se o path representa um arquivo, o retorno é false pois o arquivo ainda não foi criado.
		System.out.println(Files.exists(path));

		try {
			Files.createFile(path);
		}catch(FileAlreadyExistsException e) {
			System.out.println("Arquivo já criado.");
		}
		
		//Nesse momento o retorno é verdadeiro pois o arquivo foi criado.
		System.out.println(Files.exists(path));
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void files_copyFile() throws Exception {		
		Path origem = Paths.get(System.getProperty("user.dir")).resolve("origem").resolve("para-copiar.txt");
		Path destino = Paths.get(System.getProperty("user.dir")).resolve("destino").resolve("arquivo-copiado.txt");
		
		Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void files_moveFile() throws Exception {		
		Path origem = Paths.get(System.getProperty("user.dir")).resolve("origem").resolve("para-mover.txt");
		try {
			Files.createFile(origem);
		}catch(FileAlreadyExistsException e) {
			System.out.println("Arquivo já criado. Movendo arquivo.");
		}
		
		Path destino = Paths.get(System.getProperty("user.dir")).resolve("destino").resolve("arquivo-movido.txt");
		Files.move(origem, destino, StandardCopyOption.REPLACE_EXISTING);
		
		Assert.assertTrue(true);
	}
	
	
}

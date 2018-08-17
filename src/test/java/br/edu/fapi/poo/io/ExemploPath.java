package br.edu.fapi.poo.io;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class ExemploPath {

	@Test
	public void metodosPath() throws Exception {
		Path path = 
				Paths.get(
				System.getProperty("user.dir"));

		System.out.format("toString: %s%n", path.toString());
		System.out.format("getFileName: %s%n", path.getFileName());
		System.out.format("getName(0): %s%n", path.getName(0));
		System.out.format("getNameCount: %d%n", path.getNameCount());
		System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
		System.out.format("getParent: %s%n", path.getParent());
		System.out.format("getRoot: %s%n", path.getRoot());
		
	}
	
}

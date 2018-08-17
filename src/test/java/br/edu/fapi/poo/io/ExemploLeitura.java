package br.edu.fapi.poo.io;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class ExemploLeitura {

	private static String arquivoLeitura = "nomes.txt";

	@Test
	public void lerArquivo_bufferedReader() throws Exception {
		File file = new File(arquivoLeitura);
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = null;
			while ((linha = bufferedReader.readLine()) != null) {
				System.out.println(linha);
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		assertTrue(true);
	}

	@Test
	public void lerArquivo_bufferedReader_ApiFilesPaths() throws Exception {
		try {
			List<String> linhas = Files.readAllLines(Paths.get(arquivoLeitura), StandardCharsets.ISO_8859_1);
			for (String linha : linhas) {
				System.out.println(linha);
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		assertTrue(true);
	}

}

package br.edu.fapi.poo.io;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.edu.fapi.poo.io.domain.Livro;
import br.edu.fapi.poo.io.util.Util;

public class ExemploEscrita {

	private static String arquivoEscrita = "horarios.txt";

	@Test
	public void test() throws Exception {
		
	}
	
	@Test
	public void escreverArquivo_FileOutputStream_Append() throws Exception {
		try {
			FileOutputStream fileOutputStrea = new FileOutputStream(arquivoEscrita, true);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.sss");
			byte[] byteStream = simpleDateFormat.format(new Date()).getBytes();
			fileOutputStrea.write(byteStream);

			fileOutputStrea.close();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		assertTrue(true);
	}

	@Test
	public void escreverArquivo_bufferedWriter_noAppend() throws Exception {
		try {
			FileWriter fileWriter = new FileWriter(arquivoEscrita);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.sss");
			bufferedWriter.write(simpleDateFormat.format(new Date()));

			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		assertTrue(true);
	}

	@Test
	public void escreverArquivo_bufferedWriter_Append() throws Exception {
		try {
			FileWriter fileWriter = new FileWriter(arquivoEscrita, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.sss");
			bufferedWriter.write("\n" + simpleDateFormat.format(new Date()));

			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		assertTrue(true);
	}

	@Test
	public void escreverArquivo_printdWriter_Append() throws Exception {
		try {
			FileWriter fileWriter = new FileWriter(arquivoEscrita, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			Calendar calendar = Calendar.getInstance();
			printWriter.printf("\n" + "%s - %02d/%02d/%04d %02d:%02d:%02d.%03d", "Arquivo gerado em: ",
					calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR),
					calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND),
					calendar.get(Calendar.MILLISECOND));

			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@Test
	public void escreverArquivoLivros_ObjectOutputStream() throws Exception {
		List<Livro> livros = Util.criarListaLivros();
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("livros.txt"));
			for (Livro livro : livros) {
				objectOutputStream.writeObject(livro);
			}
			objectOutputStream.close();

			ObjectInputStream ObjectInputStream = new ObjectInputStream(new FileInputStream("livros.txt"));
			Object object;
			try {
				do {
					object = ObjectInputStream.readObject();
					System.out.println(((Livro) object).toString());
				} while (true);
			} catch (EOFException e) {
				System.out.println("Leitura finalizada.");
			}
			ObjectInputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

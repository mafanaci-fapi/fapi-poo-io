package br.edu.fapi.poo.io.util;

import java.util.ArrayList;
import java.util.List;

import br.edu.fapi.poo.io.domain.Livro;

public class Util {

	public static List<Livro> criarListaLivros() {
		List<Livro> listaDeLivros = new ArrayList<Livro>();

		Livro bancoDeDados = new Livro();
		bancoDeDados.setTitulo("Banco de Dados - Projeto e Implementa��o");
		bancoDeDados.setAutor("Felipe Nery Rodrigues Machado");
		bancoDeDados.setEditora("�rica");
		bancoDeDados.setNumeroPaginas(400);

		Livro historiaDaEducacao = new Livro();
		historiaDaEducacao.setTitulo("Historia da Educacao");
		historiaDaEducacao.setAutor("Alicia Mariani Lucio");
		historiaDaEducacao.setEditora("Fael");
		historiaDaEducacao.setNumeroPaginas(154);

		Livro linguagemSQL = new Livro();
		linguagemSQL.setTitulo("Linguagem SQL - Guia Pr�tico de Aprendizagem");
		linguagemSQL.setAutor("Luciana Ferreira Baptista");
		linguagemSQL.setEditora("�rica");
		linguagemSQL.setNumeroPaginas(156);

		//Adicionando livros na lista
		listaDeLivros.add(bancoDeDados);
		listaDeLivros.add(historiaDaEducacao);
		listaDeLivros.add(linguagemSQL);

		return listaDeLivros;
	}

}

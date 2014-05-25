package br.com.jogo.controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import br.com.jogo.model.bdPerguntas;
public class GeradorDePerguntas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		retiraIndiceUsado();
	}
	
	public static ArrayList<Integer> embaralhaListaDePerguntas() {
		bdPerguntas Perguntas = new bdPerguntas();
		Perguntas.retornaIndiceDePerguntas();
		
		ArrayList<Integer> indice_perguntas = Perguntas.retornaIndiceDePerguntas();
		//Função que embaralha as perguntas
		Collections.shuffle(indice_perguntas);
		
		return indice_perguntas;
	}
	
	public static void retiraIndiceUsado() {
		ArrayList<Integer> indice_perguntas = embaralhaListaDePerguntas();
		System.out.println(indice_perguntas);
	}

}

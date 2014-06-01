package br.com.jogo.controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import javax.swing.JRadioButton;

import br.com.jogo.model.Perguntas;


public class Embaralhador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		retiraIndiceUsado();
	}
	
	/**
	 * Função que embaralha as perguntas
	 * @return
	 */
	public static ArrayList<Integer> embaralhaListaDePerguntas() {
		ArrayList<Integer> indicePerguntas = Perguntas.retornaIndiceDePerguntas();
		Collections.shuffle(indicePerguntas);
		return indicePerguntas;
	}
	
	
	/**
	 * Função que embaralha as respsostas passando como parametro uma pergunta com respostas
	 * @return
	 */
	public static ArrayList<JRadioButton> montaListaRespostasEmbaralhadas(Map<String, String> pergunta) {
		
		JRadioButton rdResposta1 = new JRadioButton(pergunta.get("respostaCorreta"));
		JRadioButton rdResposta2 = new JRadioButton(pergunta.get("opcao1"));
		JRadioButton rdResposta3 = new JRadioButton(pergunta.get("opcao2"));
		JRadioButton rdResposta4 = new JRadioButton(pergunta.get("opcao3"));
		
		ArrayList<JRadioButton> respostas = new ArrayList<JRadioButton>();
		respostas.add(rdResposta1);
		respostas.add(rdResposta2);
		respostas.add(rdResposta3);
		respostas.add(rdResposta4);		
		Collections.shuffle(respostas);
		
		return respostas;
	}
	
	public static ArrayList<JRadioButton> montaListaRespostasEmbaralhadas(ArrayList<JRadioButton> respostas) {
		
		Collections.shuffle(respostas);
		
		return respostas;
	}
	
	public static void retiraIndiceUsado() {
		ArrayList<Integer> indicePerguntas = embaralhaListaDePerguntas();
		System.out.println(indicePerguntas);
	}

}

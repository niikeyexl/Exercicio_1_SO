package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoa;

public class Pessoa {

	public static void main(String[] args) {
		int qtdThread = 4;
		Semaphore farol = new Semaphore(1);
		for (int i = 0; i < qtdThread; i++) new ThreadPessoa(farol).start();
		
		
	}

}

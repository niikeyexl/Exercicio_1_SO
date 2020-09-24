package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {
	private Semaphore semaforo;
	public ThreadPessoa(Semaphore s) {
		this.semaforo = s;
		
	}
	
	@Override
	public void run() {
		pessoaAndando();
		pessoaCruza();
	}

	private void pessoaCruza() {
		try {
			this.semaforo.acquire();
			System.out.println("A pessoa " + getId() + " está passando.");
			sleep((long)((1 + Math.random()) * 1000)); //Tempo de passagem em ms.
			System.out.println("A pessoa " + getId() + " passou.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.semaforo.release();
		}
	}

	private void pessoaAndando() {
		double distPerc = 0;
		double deslocTot = 200;
		while (distPerc < deslocTot) {
			try {
				sleep(1000);
				distPerc += ((Math.random() * 2) + 4);
				System.out.println("A pessoa "+ getId() + " percorreu a distancia de "+ (int)distPerc + " metros.");
			} catch (Exception e) {
			}
		}
		//(Max - Min + 1) * Rnd + Min
	}

}

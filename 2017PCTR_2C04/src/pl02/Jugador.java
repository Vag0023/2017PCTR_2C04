package pl02;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Jugador extends Thread implements Runnable {
	private int id;
	private int numVueltas;
	private boolean experto;
	private Club elClub;
	private int palos;
	private int pelotas;

	public Jugador(int id, boolean experto, int numVueltas, Club elClub) {
		this.id = id;
		this.experto = experto;
		this.numVueltas = numVueltas;
		this.elClub = elClub;
	}

	public void run() {

		for (int i = 0; i < numVueltas; i++) {
			if (experto) {
				palos = ThreadLocalRandom.current().nextInt(2, 5 + 1);
				pelotas = 1;
			} else {
				palos = 2;
				pelotas = ThreadLocalRandom.current().nextInt(1, 5 + 1);
			}

			System.out.println(id + "[" + palos + "," + pelotas + "] reserva ");
			elClub.reservar(pelotas, palos);

			System.out.println(id + "[" + palos + "," + pelotas + "] jugar ");
			try {
				TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(500, 1000 + 1));
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println(id + "[" + palos + "," + pelotas + "] devolver ");
			elClub.devolver(pelotas, palos);

			System.out.println(id + "[" + palos + "," + pelotas + "] descansar ");

			try {
				TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(500, 1000 + 1));
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			// Prueba asserts Club
			// elClub.reservar(250, 250);
			// elClub.devolver(500, 500);
		}

	}
}
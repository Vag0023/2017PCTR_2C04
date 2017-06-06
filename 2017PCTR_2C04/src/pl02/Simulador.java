package pl02;

public class Simulador {
	public static int NUM_EXPERTOS=7;
	public static int NUM_NOVATOS=7;
	public static int NUM_PELOTAS=20;
	public static int NUM_PALOS=20;
	public static int NUM_VUELTAS=5;
	public static void main(String[] args) {
		
		int limite=NUM_EXPERTOS+NUM_NOVATOS;
		boolean bool=true;
		Club clubA=new Club(NUM_PELOTAS,NUM_PALOS);
		///ExecutorService exec=Executors.newSingleThreadExecutor();
		for (int i = 1; i <= limite; i++) {
			if(i>NUM_EXPERTOS)
				bool=false;
			new Jugador(i,bool,NUM_VUELTAS,clubA).start();
		}
	}
}

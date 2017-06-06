package pl02;

public class Simulador {
	public static int NUM_EXPERTOS=7;
	public static int NUM_NOVATOS=7;
	public static int NUM_PELOTAS=20;
	public static int NUM_PALOS=20;
	public static int NUM_VUELTAS=5;
	public static void main(String[] args) {
		
		
		Club clubA=new Club(NUM_PELOTAS,NUM_PALOS);
		///ExecutorService exec=Executors.newSingleThreadExecutor();
		for (int i = 0; i < 14; i++) {
			Thread jugador= new Thread(new Jugador(i,true,NUM_VUELTAS,clubA));
			//exec.execute(new  Jugador(i,true,NUM_VUELTAS,clubA));
			jugador.start();
		}
	}
}

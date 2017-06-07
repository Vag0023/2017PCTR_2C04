package pl02;

public class Club {
	private int numPelotasIniciales, numPalosIniciales, numPelotasMax, numPalosMax,pa,pe;

	public Club(int numPelotasIniciales, int numPalosIniciales) {
		this.numPelotasIniciales = numPelotasIniciales;
		this.numPalosIniciales = numPalosIniciales;
		this.numPelotasMax = numPelotasIniciales;
		this.numPalosMax = numPalosIniciales;
	}

	public synchronized void reservar(int pelotas, int palos) {
		pa=palos;
		pe=pelotas;
		checkPostCondicion();
		int a = 1;
		while (a != 0) {
			
			if (numPelotasIniciales < pelotas || numPalosIniciales < palos) {
				try {
					
					wait();
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			} else {

				numPelotasIniciales -= pelotas;
				numPalosIniciales -= palos;
				checkPostCondicion();
				a = 0;
			}
		}
	}

	public synchronized void devolver(int pelotas, int palos) {
		numPelotasIniciales += pelotas;
		numPalosIniciales += palos;
		checkPostCondicion();
		notify();
	}

	private void checkPostCondicion() {
		assert numPelotasIniciales <= numPelotasMax : "Hay en total más pelotas de las que había inicialmente";
		assert numPelotasIniciales >= 0 : "Se solicitan más pelotas de las que había inicialmente";
		assert numPalosIniciales >= 0 : "Se solicitan más palos de las que había inicialmente";
		assert numPalosIniciales <= numPalosMax : "Hay en total más palos de las que había inicialmente";
		assert pa <= numPalosMax : "Se piden más palos de los que realementa hay";
		assert pe <= numPalosMax : "Se piden más pelotas de los que realementa hay";
	}
}
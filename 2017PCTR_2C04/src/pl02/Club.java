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
		assert numPelotasIniciales <= numPelotasMax : "Hay en total m�s pelotas de las que hab�a inicialmente";
		assert numPelotasIniciales >= 0 : "Se solicitan m�s pelotas de las que hab�a inicialmente";
		assert numPalosIniciales >= 0 : "Se solicitan m�s palos de las que hab�a inicialmente";
		assert numPalosIniciales <= numPalosMax : "Hay en total m�s palos de las que hab�a inicialmente";
		assert pa <= numPalosMax : "Se piden m�s palos de los que realementa hay";
		assert pe <= numPalosMax : "Se piden m�s pelotas de los que realementa hay";
	}
}
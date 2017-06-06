package pl02;

public class Club {
	private int numPelotasIniciales, numPalosIniciales,numPelotasMax, numPalosMax;
	public Club(int numPelotasIniciales,int numPalosIniciales){
		this.numPelotasIniciales=numPelotasIniciales;
		this.numPalosIniciales=numPalosIniciales;
		this.numPelotasMax=numPelotasIniciales;
		this.numPalosMax=numPalosIniciales;
	}

	public void reservar(int pelotas, int palos) {
		numPelotasIniciales-=pelotas;
		numPalosIniciales-=palos;
		checkPostCondicion();
	}

	public void devolver(int pelotas, int palos) {
		numPelotasIniciales+=pelotas;
		numPalosIniciales+=palos;
		checkPostCondicion();
	}
	private void checkPostCondicion(){
		assert  numPelotasIniciales <= numPelotasMax : "Supera la capacidad pelotas";
		assert  numPelotasIniciales >= 0 : "capacidad pelotas";
		assert numPalosIniciales >= 0 : " capacidad palos";
		assert numPalosIniciales <= numPalosMax : "Supera la capacidad palos";
	}
}

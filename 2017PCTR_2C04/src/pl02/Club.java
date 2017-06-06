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
		int a=1;
		while(a!=0){
			if(numPelotasIniciales < pelotas || numPalosIniciales < palos){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else{
				
				numPelotasIniciales-=pelotas;
				numPalosIniciales-=palos;
				checkPostCondicion();
				a=0;
				}
			}
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

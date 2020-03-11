package ejerciciosOODos;

import java.util.Timer;
import java.util.TimerTask;

public class Cruce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Timer timer = new Timer();

		Semaforo semaforo1 = new Semaforo("Rojo"), semaforo2 = new Semaforo("Rojo"), semaforo3 = new Semaforo("Verde"),
				semaforo4 = new Semaforo("Verde");

		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {

				
				if(semaforo3.estaVerde(semaforo3)) {
					semaforo3.cambiarAmarillo();
					semaforo4.cambiarAmarillo();
				} 
				
				if(semaforo3.estaAmarillo(semaforo3)) {
					semaforo3.cambiarVerde();
					semaforo4.cambiarVerde();
					semaforo1.cambiarAmarillo();
					semaforo2.cambiarAmarillo();
				} 
				
				if(semaforo1.estaAmarillo(semaforo1)){
					semaforo1.cambiarVerde();
					semaforo2.cambiarVerde();
					semaforo3.cambiarAmarillo();
					semaforo4.cambiarAmarillo();
				}
				
				if(semaforo1.estaVerde(semaforo1)) {
					semaforo3.cambiarRojo();
					semaforo4.cambiarRojo();
				}
				
				System.out.println("Semaforo 1: " + semaforo1.getColor() + "\nSemaforo 2: " + semaforo2.getColor()
						+ "\nSemaforo 3: " + semaforo3.getColor() + "\nSemaforo 4: " + semaforo4.getColor()+ "\n\n");
			}
		};
		timer.schedule(task, 0, 10000);
	}
}

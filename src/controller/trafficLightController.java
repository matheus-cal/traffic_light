package controller;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class trafficLightController extends Thread {
	private int idThread;
	private Semaphore trafficLight;
	private static int carCross;
	private String inicialDirection[] = {"Norte","Sul","Leste","Oeste"};
	private Random random = new Random();
		
	public trafficLightController(int idThread, Semaphore trafficLight) {
		this.idThread = idThread;
		this.trafficLight = trafficLight;
		start();
	}
		
		
	public void run() {
		try {
			trafficLight.acquire();
			cross();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			trafficLight.release();
			releaseNext();
		}
	}
	
	public void cross() {
		try {
			sleep(300);
			int finalDestination = 30;
			int distance = random.nextInt(4) + 1;
			int ranDistance = 0;
			while(ranDistance < finalDestination) {
				ranDistance = ranDistance + distance;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			switch(carCross) {
			case 0: System.out.println("O carro n°" +  idThread + " começou na posição " + inicialDirection[0]  + " e atravessou no sentido sul.");
			break;
			case 1: System.out.println("\nO carro n°" + idThread + " começou na posição " + inicialDirection[1]  + " e atravessou no sentido norte.");
			break;
			case 2: System.out.println("\nO carro n°" + idThread + " começou na posição " + inicialDirection[2]  + " e atravessou no sentido oeste.");
			break;
			case 3: System.out.println("\nO carro n°" + idThread + " começou na posição " + inicialDirection[3]  + " e atravessou no sentido leste.");
			break;
			}
			carCross++;
	}
		
		
	public void releaseNext() {
		System.out.println("Próximo carro está liberado para atravessar!");
	}
}

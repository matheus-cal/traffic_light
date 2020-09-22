package view;
import java.util.concurrent.Semaphore;
import controller.trafficLightController;

public class Principal {
	public static void main(String[] args) {
		
		Semaphore trafficLight = new Semaphore(1);
		
		for(int idThread = 1;idThread <= 4;idThread++) {
			trafficLightController thread = new trafficLightController(idThread, trafficLight);
		}
		
	}
}

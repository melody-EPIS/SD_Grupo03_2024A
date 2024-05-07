
public class ProductorConsumidorModificado {
	public static void main(String [] args) {
		CubbyHole cubbyhole = new CubbyHole();
		Consumer consumidor = new Consumer(cubbyhole, 1);
		Producer productor = new Producer(cubbyhole, 1);
		
		productor.start();
		consumidor.start();
		
	}

}


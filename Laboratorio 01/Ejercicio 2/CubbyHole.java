
class CubbyHole {
	private int contents;
	private boolean available = false;
	
	public synchronized int get() {
		// El consumidor adquier el monitor 
		while (available == false) {
			try {
				wait(); // espera que el Productor invoque a
				notify ();
			}
			catch (InterruptedException e) {
			}
		}
		available = false;
		notify(); 
		return contents;
		// el Consumidor libera el monitor
	}
	
	public synchronized void put(int value) {
		//El productor adquiere el monitor
		while(available == true) {
			try {
				wait();
			}
			catch (InterruptedException e) {
			}
		}
		contents = value; 
		available = true; 
		notify(); //notifica al Productor
		//el productor libera el monitor
	}
}

class Producer extends Thread {
	private final CubbyHole cubbyhole;
	private int numero;
	
	public Producer(CubbyHole c, int numero) {
		cubbyhole = c;
		this.numero = numero;
	}
	@Override
	public void run() {
		for(int i=0; i < 10; i ++) {
			cubbyhole.put(i);
			System.out.println("Productor #" + this.numero + " pone :" + i);
			try {
				sleep((int) (Math.random() * 100));
			}
			catch(InterruptedException e) {
			}
		}
	}
}

class Consumer extends Thread{
	private final CubbyHole cubbyhole;
	private int numero;
	
	public Consumer(CubbyHole c, int numero) {
		cubbyhole = c;
		this.numero = numero;
	}
	 @Override
	 public void run() {
		 for(int i=0; i < 10; i++) {
			 int value = cubbyhole.get();
			 System.out.println("Consumidor #" + this.numero + " obtiene " + value);
		 }
	 }
	 
}


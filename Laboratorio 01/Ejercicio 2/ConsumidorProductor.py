import threading
import random
import time

class CubbyHole:
    def __init__(self):
        self.contents = 0
        self.available = False
        self.lock = threading.Condition()

    def get(self):
        with self.lock:
            while not self.available:
                self.lock.wait()
            self.available = False
            self.lock.notify()
            return self.contents

    def put(self, value):
        with self.lock:
            while self.available:
                self.lock.wait()
            self.contents = value
            self.available = True
            self.lock.notify()

class Producer(threading.Thread):
    def __init__(self, cubbyhole, numero):
        threading.Thread.__init__(self)
        self.cubbyhole = cubbyhole
        self.numero = numero

    def run(self):
        for i in range(10):
            self.cubbyhole.put(i)
            print("Productor #" + str(self.numero) + " pone: " + str(i))
            time.sleep(random.random() * 0.1)

class Consumer(threading.Thread):
    def __init__(self, cubbyhole, numero):
        threading.Thread.__init__(self)
        self.cubbyhole = cubbyhole
        self.numero = numero

    def run(self):
        for i in range(10):
            value = self.cubbyhole.get()
            print("Consumidor #" + str(self.numero) + " obtiene " + str(value))

def main():
    cubbyhole = CubbyHole()
    consumidor = Consumer(cubbyhole, 1)
    productor = Producer(cubbyhole, 1)

    productor.start()
    consumidor.start()

if __name__ == "__main__":
    main()

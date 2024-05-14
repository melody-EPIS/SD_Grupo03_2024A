import threading
import time
import random

class LamportClock:
    def __init__(self):
        self.clock = 0
        self.lock = threading.Lock()

    def tick(self):
        with self.lock:
            self.clock += 1
            return self.clock

    def update(self, received_time):
        with self.lock:
            self.clock = max(self.clock, received_time) + 1

    def get_time(self):
        with self.lock:
            return self.clock

def thread_function(clock):
    time_stamp = clock.tick()
    print(f"Thread {threading.get_ident()} created event with Lamport time {time_stamp}")
    
    time.sleep(random.random())
    
    received_time = clock.tick()
    print(f"Thread {threading.get_ident()} received event with Lamport time {received_time}")
    clock.update(received_time)

if __name__ == "__main__":
    threads = []
    clock = LamportClock()

    for i in range(5):
        thread = threading.Thread(target=thread_function, args=(clock,))
        threads.append(thread)
        thread.start()

    for thread in threads:
        thread.join()

    print(f"Final Lamport time: {clock.get_time()}")

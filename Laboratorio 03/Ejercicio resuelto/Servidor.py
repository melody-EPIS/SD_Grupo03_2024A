import socket

class Servidor:
    PUERTO = 5000

    def __init__(self):
        try:
            skServidor = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            skServidor.bind(('localhost', self.PUERTO))
            skServidor.listen(3)
            print("Escuchando en el puerto", self.PUERTO)
            for numCli in range(3):
                skCliente, addr = skServidor.accept()
                print("Sirviendo al cliente", numCli)
                mensaje = "Hola cliente " + str(numCli)
                skCliente.send(mensaje.encode())
                skCliente.close()
            print("Demasiados clientes por hoy")
        except Exception as e:
            print(str(e))

if __name__ == "__main__":
    servidor = Servidor()

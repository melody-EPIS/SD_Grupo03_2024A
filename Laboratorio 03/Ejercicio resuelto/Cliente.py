import socket

class Cliente:
    HOST = 'localhost'
    PUERTO = 5000

    def __init__(self):
        try:
            skCliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            skCliente.connect((self.HOST, self.PUERTO))
            mensaje = skCliente.recv(1024).decode()
            print(mensaje)
            skCliente.close()
        except Exception as e:
            print(str(e))

if __name__ == "__main__":
    cliente = Cliente()

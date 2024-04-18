import socket
print("INICIANDO SERVIDOR TCP")
HOST = 'localhost'
PORT = 50000
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM) 
s.bind((HOST, PORT))
s.listen()
print('Aguardando conexão de um cliente')
conn, ender = s.accept()

print('Conectado em', ender)
while True:
    data = conn.recv(1021)
    if not data:
        print('Fechando a conexão')
        conn.close()
        break
    print("Reply: ", data)
    conn.sendall(data)
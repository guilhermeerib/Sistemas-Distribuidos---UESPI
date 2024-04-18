import socket

HOST = '127.0.0.1'
PORT = 50000
mesg = "Estudando conexao socket udp"
print("Request:", mesg)

with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as s:
    s.sendto(str.encode(mesg), (HOST, PORT))
    data, addr = s.recvfrom(1024)
    print('Mensagem ecoada:', data.decode())

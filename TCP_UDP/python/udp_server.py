import socket

print("INICIANDO SERVIDOR UDP")
HOST = 'localhost'
PORT = 50000

with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as s:
    s.bind((HOST, PORT))
    print('Aguardando mensagem...')
    data, addr = s.recvfrom(1024)
    print('Conectado em', addr)
    print('Mensagem recebida:', data.decode())
    s.sendto(data, addr)
print("Fechando Conexão") 
#!/usr/bin/env python3
import socket
print("INICIANDO CONEXÃO CLIENT TCP")
HOST = '127.0.0.1'
PORT = 50000
mesg= "Estudando conexao socket tcp"
print("Request: ", mesg)
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM) 
s.connect((HOST, PORT))

s.sendall(str.encode(mesg))
data = s.recv(1024)
print('Mensagem ecoada:', data.decode())
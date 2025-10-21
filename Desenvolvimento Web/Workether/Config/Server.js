import {WebSocketServer} from 'ws';

const wss = new WebSocketServer({port: 8080});

wss.on('connection', (ws) => {
    console.log('Novo cliente conectado');

    ws.on('message', (message) => {
        console.log('Messagem recebida: ', message);

        wss.clients.forEach(client => {
            if (cliente.readyState === ws.OPEN) {
                client.send(message);
            }
        })
    });

    was.on('close', () => {
        console.log('Cliente desconectado');
    })
});

console.log('Servidor WebSocket rodando em ws://localhost:8080');
import WebSocket, {WebSocketServer} from 'ws';

const wss = new WebSocketServer({port: 8080});

wss.on('connection', (ws) => {
    console.log('Novo cliente conectado');

    ws.on('message', (message) => {
        try {
            message = JSON.parse(message.toString());
            console.log('Messagem recebida: ', message);

            wss.clients.forEach(client => {
                if (client !== ws && client.readyState === WebSocket.OPEN) {
                    client.send(JSON.stringify(message));
                }
            });
        } catch (error) {
            console.error(error);
        }
    });

    ws.on('close', () => {
        console.log('Cliente desconectado');
    })

});


console.log('Servidor WebSocket rodando em ws://localhost:8080');
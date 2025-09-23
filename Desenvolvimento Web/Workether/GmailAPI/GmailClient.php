<?php

namespace GmailAPI;

use Google_Client;
use Google_Service_Gmail;
use Google_Service_Gmail_Message;

require __DIR__ . '/../vendor/autoload.php';
class GmailClient
{
    private $client;
    private $service;
    private $tokenPath;

    public function __construct()
    {
        $this->tokenPath = __DIR__ . '/../token.json';

        $this->client = new Google_Client();
        $this->client->setApplicationName('Workether Gmail API');
        $this->client->setScopes(Google_Service_Gmail::GMAIL_SEND);
        $this->client->setAuthConfig(__DIR__ . '/../credentials.json');
        $this->client->setAccessType('offline');
        $this->client->setPrompt('select_account consent');
        $this->client->setRedirectUri('http://localhost:8000/GmailAPI/GmailClient.php');

        $this->authenticate();
        $this->service = new Google_Service_Gmail($this->client);
    }

    private function authenticate()
    {
        if (file_exists($this->tokenPath)) {
            $this->client->setAccessToken(json_decode(file_get_contents($this->tokenPath), true));
        }

        if ($this->client->isAccessTokenExpired()) {
            if ($this->client->getRefreshToken()) {
                $this->client->fetchAccessTokenWithRefreshToken($this->client->getRefreshToken());
            } else {
                if (!isset($_GET['code'])) {
                    $authUrl = $this->client->createAuthUrl();
                    header('Location: ' . $authUrl);
                    exit();
                } else {
                    $token = $this->client->fetchAccessTokenWithAuthCode($_GET['code']);
                    $this->client->setAccessToken($token);
                    file_put_contents($this->tokenPath, json_encode($this->client->getAccessToken()));
                    echo "Autenticação concluída. Recarregue a página.";
                    exit();
                }
            }
        }
    }

    public function sendEmail($to, $subject, $messageText)
    {
        $rawMessage = "To: $to\r\n";
        $rawMessage .= "Subject: $subject\r\n";
        $rawMessage .= "MIME-Version: 1.0\r\n";
        $rawMessage .= "Content-Type: text/plain; charset=utf-8\r\n\r\n";
        $rawMessage .= $messageText;

        $rawMessage = base64_encode($rawMessage);
        $rawMessage = str_replace(['+', '/', '='], ['-', '_', ''], $rawMessage);

        $msg = new Google_Service_Gmail_Message();
        $msg->setRaw($rawMessage);

        return $this->service->users_messages->send('me', $msg);
    }
}
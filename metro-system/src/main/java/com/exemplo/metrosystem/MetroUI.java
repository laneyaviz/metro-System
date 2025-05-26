package com.exemplo.metrosystem;
// anbre a interface grafica
// faz a janela 
/*A requisição é configurada para enviar o JSON como corpo da mensagem (Content-Type: application/json).
Ele verifica a resposta do servidor:
Se o código de resposta for 200 OK (HTTP_OK), ele mostra uma mensagem de sucesso: "Estação cadastrada com sucesso!".*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class MetroUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Metrô");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nomeLabel = new JLabel("Nome da Estação:");
        JTextField nomeField = new JTextField(20);

        JLabel linhaLabel = new JLabel("Linha:");
        JTextField linhaField = new JTextField(20);

        JButton enviarBtn = new JButton("Cadastrar");

        enviarBtn.addActionListener(e -> {
            try {
                String json = String.format("{\"nome\":\"%s\",\"linha\":\"%s\"}",
                        nomeField.getText(), linhaField.getText());

                URL url = new URL("http://localhost:8080/api/estacoes");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");

                OutputStream os = conn.getOutputStream();
                os.write(json.getBytes());
                os.flush();

                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    JOptionPane.showMessageDialog(frame, "Estação cadastrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Erro ao cadastrar estação.");
                }

                conn.disconnect();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Erro: " + ex.getMessage());
            }
        });

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(linhaLabel);
        panel.add(linhaField);
        panel.add(enviarBtn);

        frame.add(panel);
        frame.setVisible(true);
    }
}
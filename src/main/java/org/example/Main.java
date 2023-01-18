package org.example;


import application.Application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("Choose and process file");
        JLabel result = new JLabel();
        button.addActionListener(e -> {
            JFileChooser fileChooser=new JFileChooser();
            int i=fileChooser.showOpenDialog(button);
            if(i==JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                Application app = new Application(selectedFile.getAbsolutePath());
                int code = app.execute();
                if (code == 0){
                    result.setText("Expression successfully calculated");
                }
                else if (code == 1){
                    result.setText("Empty source file");
                }else{
                    result.setText("Unknown exit code");
                }
            }
        });
        button.setBounds(50,200,200,30);
        result.setBounds(150, 200, 400, 30);
        frame.add(button);
        frame.add(result);
        frame.setSize(640, 480);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
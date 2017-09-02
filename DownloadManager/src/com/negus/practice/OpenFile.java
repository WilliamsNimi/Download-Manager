package com.negus.practice;
import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class OpenFile extends JFrame{
    JButton openFile, openFolder;
    OpenFileHandler openFileHandler;
    OpenFolderHandler openFolderHandler;
    JLabel fileDownloaded;
    
    File fileDownloading;
    String fileName, downloadPath;
    
    public OpenFile(File fileDownloading, String fileName, String downloadPath){
        this.fileDownloading = fileDownloading;
        this.fileName = fileName;
        this.downloadPath = downloadPath;
        
        
        Container container = getContentPane();
        GridBagConstraints object = new GridBagConstraints();
        container = getContentPane();
        object = new GridBagConstraints();
        container.setBackground(Color.LIGHT_GRAY);
        container.setLayout(new GridBagLayout());
        object.insets = new Insets(5,5,0,0);
        
        
        fileDownloaded = new JLabel(fileName+". Download complete.");
        object.gridx = 0;
        object.gridy = 0;
        container.add(fileDownloaded, object);
        
        openFile = new JButton("Open File");
        openFileHandler = new OpenFileHandler();
        openFile.addActionListener(openFileHandler);
        object.gridx = 0;
        object.gridy = 1;
        container.add(openFile, object);
        
        openFolder = new JButton("Open Folder");
        openFolderHandler = new OpenFolderHandler();
        openFolder.addActionListener(openFolderHandler);
        object.gridx = 1;
        object.gridy = 1;
        container.add(openFolder, object);
        
        setSize(400,100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Download Complete");
        setResizable(false);
    }
    
    public class OpenFileHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
         try {
            Desktop.getDesktop().open(fileDownloading);//used to open file after download
            } catch (IOException e1) {
                e1.printStackTrace();
            } 
        }
        
    }
    
    public class OpenFolderHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Desktop.getDesktop().open(new File(downloadPath));//used to open folder after download
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
        }
        
    }
}

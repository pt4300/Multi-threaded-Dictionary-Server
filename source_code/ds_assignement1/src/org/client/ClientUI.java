/*
 * Created by JFormDesigner on Thu Mar 30 10:27:24 AEDT 2023
 */

package org.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.google.gson.*;
import org.client.Client;
/**
 * @author Yuting Yu 1291624
 */
public class ClientUI extends JFrame {
    private String action = "";
    private Client client;
    private Gson gson;

    public ClientUI(String hostname, int port) {
        gson = new Gson();
        client = new Client(hostname,port);
        client.connect();
        initComponents();
    }


    private void search(ActionEvent e) {
        // TODO add your code here
        action = "search";
    }

    private void add(ActionEvent e) {
        // TODO add your code here
        action = "add";
    }

    private void delete(ActionEvent e) {
        // TODO add your code here
        action = "delete";
    }

    private void update(ActionEvent e) {
        // TODO add your code here
        action = "update";
    }

    private void send(ActionEvent e) {
        // TODO add your code here
        // do not pass 0 length value to server. Server will handle null values with a message
        String response = client.send(action,word.getText(),definition.getText().length()!=0?definition.getText():null);
        JsonObject responseObject = gson.fromJson(response, JsonObject.class);

        String status = responseObject.get("status").getAsString();
        String message = responseObject.get("message")!=null?responseObject.get("message").getAsString():"";
        String definitionString = responseObject.get("definition")!=null?responseObject.get("definition").getAsString():"";

//        definition.setText("");
//        word.setText("");
        if (status.equals("success")){
            if(action=="search"){
                responseField.setText("Status: "+status + "\n" +"Definition: " + definitionString);
            }else{
                responseField.setText("Status: "+status + "\n");
            }
        }
        else{
            responseField.setText("Status: "+status + "\n" +"Message: " + message);
        }

    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        searchRadioButton = new JRadioButton();
        addRadioButton = new JRadioButton();
        deleteRadioButton = new JRadioButton();
        updateRadioButton = new JRadioButton();
        word = new JTextField();
        scrollPane2 = new JScrollPane();
        responseField = new JTextPane();
        sendButton = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane3 = new JScrollPane();
        definition = new JTextArea();
        label4 = new JLabel();

        //======== this ========
        setResizable(false);
        setTitle("DictionaryClient");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        var contentPane = getContentPane();

        //---- searchRadioButton ----
        searchRadioButton.setText("search");
        searchRadioButton.addActionListener(e -> search(e));

        //---- addRadioButton ----
        addRadioButton.setText("add");
        addRadioButton.addActionListener(e -> add(e));

        //---- deleteRadioButton ----
        deleteRadioButton.setText("delete");
        deleteRadioButton.addActionListener(e -> delete(e));

        //---- updateRadioButton ----
        updateRadioButton.setText("update");
        updateRadioButton.addActionListener(e -> update(e));

        //======== scrollPane2 ========
        {

            //---- responseField ----
            responseField.setEditable(false);
            scrollPane2.setViewportView(responseField);
        }

        //---- sendButton ----
        sendButton.setText("send");
        sendButton.addActionListener(e -> send(e));

        //---- label1 ----
        label1.setText("Welcome User, Please input word and definition");
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label2 ----
        label2.setText("Word");

        //---- label3 ----
        label3.setText("Definition");

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(definition);
        }

        //---- label4 ----
        label4.setText("Response");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(searchRadioButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(addRadioButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(deleteRadioButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(updateRadioButton)
                                    .addGap(415, 415, 415))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label4)
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE))))
                            .addGap(0, 29, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(35, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 261, Short.MAX_VALUE)
                            .addComponent(word, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                            .addGap(292, 292, 292))))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 423, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addGap(405, 405, 405))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addGap(407, 407, 407))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(word, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(label3)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(searchRadioButton)
                                .addComponent(addRadioButton)
                                .addComponent(deleteRadioButton)
                                .addComponent(updateRadioButton)
                                .addComponent(sendButton))
                            .addGap(18, 18, 18))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label4)
                            .addGap(2, 2, 2)))
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(11, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- actionSelect ----
        var actionSelect = new ButtonGroup();
        actionSelect.add(searchRadioButton);
        actionSelect.add(addRadioButton);
        actionSelect.add(deleteRadioButton);
        actionSelect.add(updateRadioButton);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JRadioButton searchRadioButton;
    private JRadioButton addRadioButton;
    private JRadioButton deleteRadioButton;
    private JRadioButton updateRadioButton;
    private JTextField word;
    private JScrollPane scrollPane2;
    private JTextPane responseField;
    private JButton sendButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane3;
    private JTextArea definition;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

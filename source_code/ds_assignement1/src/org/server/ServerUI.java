/*
 * Created by JFormDesigner on Thu Mar 30 18:31:35 AEDT 2023
 */

package org.server;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Yuting Yu 1291624
 */
public class ServerUI extends JFrame {
    public ServerUI() {
        initComponents();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label2 = new JLabel();
        label3 = new JLabel();
        portText = new JTextField();
        scrollPane1 = new JScrollPane();
        consoleTextArea = new JTextArea();

        //======== this ========
        setTitle("DictionaryServer");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //---- label2 ----
        label2.setText("Port");

        //---- label3 ----
        label3.setText("Console Log:");

        //---- portText ----
        portText.setEditable(false);

        //======== scrollPane1 ========
        {

            //---- consoleTextArea ----
            consoleTextArea.setEditable(false);
            scrollPane1.setViewportView(consoleTextArea);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                            .addGap(105, 105, 105)
                            .addComponent(portText, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(19, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(portText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addComponent(label3)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(42, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    public void updateConsoleField(String text) {
        consoleTextArea.append(text);
        consoleTextArea.repaint();
    }
    public void updatePortField(String text) {
        portText.setText(text);
        portText.repaint();
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label2;
    private JLabel label3;
    private JTextField portText;
    private JScrollPane scrollPane1;
    private JTextArea consoleTextArea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

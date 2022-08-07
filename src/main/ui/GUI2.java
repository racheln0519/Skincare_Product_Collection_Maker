package ui;

import model.Product;
import model.ProductCollection;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GUI2 extends JFrame {

    private static final String JSON_STORE = "./data/product-collection.json";
    private JButton addButton = new JButton("Add Product");
    private JButton removeButton = new JButton("Remove Product");
    private JButton savingPreferenceButton = new JButton("Set Saving Preference");
    private JButton saveButton = new JButton("Save Collection");
    private JButton loadButton = new JButton("Load Collection");
    private JTextField textField = new JTextField(30);

    private ProductCollection myProductCollection;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    String[] products = {"product1","product2","product3","product4","product5",
            "product6","product7","product8","product9","product10"};

    @SuppressWarnings("methodlength")
    public GUI2() {
//        JFrame frame = new JFrame("Skincare Product Collection Maker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Skincare Product Collection Maker");
        getContentPane().setBackground(new java.awt.Color(147, 201, 147));

        // Sets the location and size of the frame and makes it visible
        setSize(400, 400);
        setLocationRelativeTo(null);
//        ImageIcon image = new ImageIcon()

        setLayout(new GridLayout(3,1));

        JList list = new JList(products);
        list.setVisibleRowCount(10);

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(list));
        add(panel);
        getContentPane().add(BorderLayout.NORTH, panel);
        revalidate();

        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("Cleanser");
        listModel.addElement("Toner");
        listModel.addElement("Serum");
        list.setModel(listModel);
        revalidate();

        JPanel panel2 = new JPanel();
        add(panel2);
        panel2.add(textField);
        panel2.add(addButton);
        panel2.add(removeButton);
        panel2.add(savingPreferenceButton);
        getContentPane().add(BorderLayout.CENTER, panel2);
        JPanel panel3 = new JPanel();
        add(panel3);
        panel3.add(saveButton);
        panel3.add(loadButton);
        getContentPane().add(BorderLayout.SOUTH, panel3);
        revalidate();

        pack();
        setVisible(true);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().toString().isEmpty()) {
                    String product = textField.getText().toString();
                    listModel.addElement(product);
                    textField.setText(null);
//                    JOptionPane.showMessageDialog(frame, "Success!" + product + " was added to your collection.");
                }
//                JOptionPane.showMessageDialog(frame, "Sorry, product was added to the collection.");

            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.remove(list.getSelectedIndex());
            }
        });

        savingPreferenceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText() == "save money") {
                    myProductCollection.savingMoney();
                }
                if (textField.getText() == "not saving money") {
                    myProductCollection.notSavingMoney();
                }
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    myProductCollection = jsonReader.read();
                    System.out.println("Success! Loaded " + myProductCollection.getName() + " from " + JSON_STORE);
                } catch (IOException exception) {
                    System.out.println("Unable to read from file: " + JSON_STORE);
                }
            }
        });


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(myProductCollection);
                    jsonWriter.close();
                    System.out.println("Success! Saved " + myProductCollection.getName() + " to " + JSON_STORE);
                } catch (FileNotFoundException exception) {
                    System.out.println("Unable to write to file: " + JSON_STORE);
                }
            }
        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = list.getSelectedIndex();
                    String item = (String)list.getSelectedValue();

                }
            }
        });
    }

    public static void main(String[] args) {
        new GUI2();
    }
}

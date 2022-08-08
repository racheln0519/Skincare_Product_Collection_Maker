package ui;

import model.ProductCollection;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;


public class GUI extends JFrame {

    private static final String JSON_STORE = "./data/product-collection.json";
    private JButton addButton = new JButton("Add Product");
    private JButton removeButton = new JButton("Remove Product");
    private JButton savingPreferenceButton = new JButton("Set Saving Preference");
    private JButton saveButton = new JButton("Save Collection");
    private JButton loadButton = new JButton("Load Collection");
    private JTextField textField = new JTextField(30);

    private static ProductCollection myProductCollection;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    String[] products = {"product1", "product2", "product3", "product4", "product5",
            "product6", "product7", "product8", "product9", "product10"};

    @SuppressWarnings("methodlength")
    public GUI() {
//        JFrame frame = new JFrame("Skincare Product Collection Maker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Skincare Product Collection Maker");
        getContentPane().setBackground(new java.awt.Color(147, 201, 147));

        // Sets the location and size of the frame and makes it visible
        setSize(400, 400);
        setLocationRelativeTo(null);
//        ImageIcon image = new ImageIcon()

        setLayout(new GridLayout(3, 1));

        JList list = new JList(products);
        list.setVisibleRowCount(10);

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(list));
        add(panel);
        getContentPane().add(BorderLayout.NORTH, panel);
        revalidate();

        DefaultListModel<String> listModel = new DefaultListModel();
        listModel.addElement("Cleanser");
        listModel.addElement("Toner");
        listModel.addElement("Serum");
        list.setModel(listModel);
        revalidate();

        JLabel success = new JLabel("");
        JLabel pictureDisplay = new JLabel();

        JPanel panel2 = new JPanel();
        add(panel2);
        panel2.add(textField);
        panel2.add(addButton);
        panel2.add(removeButton);
        panel2.add(savingPreferenceButton);
        panel2.add(success);
        getContentPane().add(BorderLayout.CENTER, panel2);
        JPanel panel3 = new JPanel();
        add(panel3);
        panel3.add(pictureDisplay);
        panel3.add(saveButton);
        panel3.add(loadButton);
        getContentPane().add(BorderLayout.SOUTH, panel3);
        revalidate();

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        pack();
        setVisible(true);


        addButton.addActionListener(e -> {
            String product = textField.getText();
            if (myProductCollection.savemoney() == false) {
                if (!textField.getText().isEmpty()) {
                    listModel.addElement(product);
                    list.setModel(listModel);
                    textField.setText(null);
                    pictureDisplay.setIcon(new ImageIcon("./data/AddProduct.png"));
                    success.setText("Success! " + product + " was added to the collection.");
                }
            }
//            success.setText("Sorry, you cant add products because you set your saving preference to 'save money'.");
        });

        removeButton.addActionListener(e -> {
            listModel.remove(list.getSelectedIndex());
            list.setModel(listModel);
            pictureDisplay.setIcon(new ImageIcon("./data/RemoveProduct.png"));
            success.setText("Success! The selected product has been removed from the collection.");

        });

        savingPreferenceButton.addActionListener(e -> {
            if (textField.getText().equals("save money")) {
                myProductCollection.savingMoney();
                textField.setText(null);
                success.setText("Money saving preference has been set to 'save money'.");

            }
            if (textField.getText().equals("not saving money")) {
                myProductCollection.notSavingMoney();
                textField.setText(null);
                success.setText("Money saving preference has been set to 'not saving money.");

            }
        });

        loadButton.addActionListener(e -> {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader("List.txt"));
                int val = Integer.parseInt(br.readLine());

                listModel.removeAllElements();
                for (int i = 0; i < val; i++) {
                    String s = br.readLine();
                    listModel.addElement(s);
                }

                success.setText("Success! Loaded collection from " + JSON_STORE + ".");
                list.setModel(listModel);
            } catch (Exception exception) {
                success.setText("Unable to read from file: " + JSON_STORE);
            } finally {
                try {
                    br.close();
                } catch (Exception exception) {
                    success.setText("Unable to read from file: " + JSON_STORE);
                }
            }
        });

        saveButton.addActionListener(e -> {
            int val = list.getModel().getSize();
            PrintWriter writer = null;

            try {
                writer = new PrintWriter("List.txt");
                writer.println(val);

                for (int i = 0; i < val; i++) {
                    writer.println(list.getModel().getElementAt(i));
                }

                success.setText("Success! Saved collection to " + JSON_STORE + ".");
            } catch (Exception exception) {
                success.setText("Unable to write to file: " + JSON_STORE);
            } finally {
                writer.close();
            }
        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = list.getSelectedIndex();
                    String item = (String) list.getSelectedValue();
                }
            }
        });
    }

    // getters
    public ProductCollection getProductCollection() {
        return myProductCollection;
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        myProductCollection = new ProductCollection("User's Collection");

        InputProduct inputProduct = new InputProduct(gui.getProductCollection());
    }
}

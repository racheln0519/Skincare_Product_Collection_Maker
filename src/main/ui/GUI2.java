package ui;

import javafx.event.ActionEvent;
import model.Product;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI2 extends JPanel implements ListSelectionListener {

    private JList list;
    private DefaultListModel listModel;

    private static final boolean shouldFill = true;
    private static final boolean shouldWeightX = true;
    private static final boolean RIGHT_TO_LEFT = false;
    private static final String addString = "add product";
    private static final String removeString = "remove product";
    private static final String savingPreferenceString = "money saving preference";
    private static final String viewCollectionString = "view collection";
    private static final String saveCollectionString = "save collection";
    private static final String loadCollectionString = "load collection";
    private JTextField typeHere;

    private JButton addButton;
    private JButton removeButton;
    private JButton savingPreferenceButton;
    private JButton viewCollectionButton;
    private JButton saveButton;
    private JButton loadButton;


    public GUI2() {
        super(new BorderLayout());

        @SuppressWarnings("methodlength")
        public static void addComponentsToPane(Container pane) {
            if (RIGHT_TO_LEFT) {
                pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            }
            pane.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            if (shouldFill) {
                c.fill = GridBagConstraints.HORIZONTAL;
            }

            addButton = new JButton("addButton");
            AddListener addListener = new AddListener(addButton);
            addListener.setActionCommand(addString);
            addListener.addActionListener(addListener);
            addListener.setEnabled(false);
            if (shouldWeightX) {
                c.weightx = 0.5;
            }
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 0;
            pane.add(button, c);

            removeButton = new JButton("removeButton");
            RemoveListener removeListener = new RemoveListener(removeButton);
            removeListener.setActionCommand(removeString);
            removeListener.addActionListener(removeListener);
            removeListener.setEnabled(false);
            if (shouldWeightX) {
                c.weightx = 0.5;
            }
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 1;
            c.gridy = 0;
            pane.add(button, c);

            savingPreferenceButton = new JButton("savingPreferenceButton");
            SavingPreferenceListener savingPreferenceListener = new SavingPreferenceListener(savingPreferenceButton);
            savingPreferenceListener.setActionCommand(savingPreferenceString);
            savingPreferenceListener.addActionListener(savingPreferenceListener);
            savingPreferenceListener.setEnabled(false);
            if (shouldWeightX) {
                c.weightx = 0.5;
            }
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 2;
            c.gridy = 0;
            pane.add(button, c);

            viewCollectionButton = new JButton("viewCollectionButton");
            ViewCollectionListener viewCollectionListener = new ViewCollectionListener(viewCollectionButton);
            viewCollectionListener.setActionCommand(viewCollectionString);
            viewCollectionListener.addActionListener(viewCollectionListener);
            viewCollectionListener.setEnabled(false);
            if (shouldWeightX) {
                c.weightx = 0.5;
            }
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 3;
            c.gridy = 0;
            pane.add(button, c);

            saveButton = new JButton("saveButton");
            SaveListener saveListener = new SaveListener(saveButton);
            saveListener.setActionCommand(saveCollectionString);
            saveListener.addActionListener(saveListener);
            saveListener.setEnabled(false);
            if (shouldWeightX) {
                c.weightx = 0.5;
            }
            c.anchor = GridBagConstraints.PAGE_END;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 4;
            c.gridy = 2;
            pane.add(button, c);

            loadButton = new JButton("loadButton");
            LoadListener loadListener = new LoadListener(loadButton);
            loadListener.setActionCommand(loadCollectionString);
            loadListener.addActionListener(loadListener);
            loadListener.setEnabled(false);
            if (shouldWeightX) {
                c.weightx = 0.5;
            }
            c.anchor = GridBagConstraints.PAGE_END;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 5;
            c.gridy = 2;
            pane.add(button, c);

        }

        private static void createAndShowGUI() {
            JFrame frame = new JFrame("Skincare Product Collection Maker");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500,600);

            // Create and set up the content pane
            JComponent newContentPane = new GUI2();
            newContentPane.setOpaque(true);
            frame.setContentPane(newContentPane);
            addComponentsToPane((frame.getContentPane()));

            // Displays the window
            frame.pack();
            frame.setVisible(true);
        }

        listModel = new DefaultListModel();
        listModel.addElement(new Product("Cleanser"));
        listModel.addElement(new Product("Toner"));
        listModel.addElement(new Product("Serum"));

        // Create the list and put it in a scroll pane
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(10);
        JScrollPane listScrollPane = new JScrollPane(list);

        typeHere = new JTextField(10);
        typeHere.addActionListener(addListener);
        typeHere.getDocument().addDocumentListener(addListener);
        String name = listModel.getElementAt(list.getSelectedIndex()).toString());

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(addButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(removeButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(savingPreferenceButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(viewCollectionButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(saveButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(loadButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(typeHere);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
    }

    private class RemoveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int index = list.getSelectedIndex();
            listModel.remove(index);

            int size = listModel.getSize();

            if (size == 0) {
                removeButton.setEnabled(false);
            } else {
                if (index == listModel.getSize()) {
                    index--;
                }
                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }
        }
    }

    private class AddListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private JButton button;

        public AddListener(JButton button) {
            this.button = button;
        }

        public void actionPerformed(ActionEvent e) {
            String productName = typeHere.getText();

            if (productName.equals("") || alreadyInList(productName)) {
                Toolkit.getDefaultToolkit().beep();
                typeHere.requestFocusInWindow();
                typeHere.selectAll();
                return;
            }

            int index = list.getSelectedIndex();
            if (index == 1) {
                index = 0;
            } else {
                index++;
            }

            listModel.addElement(typeHere.getText());

            // Reset the text field
            typeHere.requestFocusInWindow();
            typeHere.setText("");

            // Select the new item and make it visible
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }

        protected boolean alreadyInList(String productName) {
            return listModel.contains(productName);
        }

        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }

        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }

        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }

        private void enableButton() {
            if (!alreadyEnabled) {
                button.setEnabled(true);
            }
        }

        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }

    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (list.getSleectedIndex() == -1) {
                removeButton.setEnabled(false);
            } else {
                removeButton.setEnabled(true);
            }
        }
    }



    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });





    }

}

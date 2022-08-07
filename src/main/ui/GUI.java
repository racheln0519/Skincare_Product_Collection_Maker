//package ui;
//
//import model.Product;
//
//import javax.swing.*;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class GUI extends JPanel implements ListSelectionListener {
//
//    private JList<Product> list;
//    private DefaultListModel<Product> listModel;
//
//    private static final String addProductString = "add product";
//    private static final String removeProductString = "remove product";
//    private static final String savingPreferenceString = "money saving preference";
//    private static final String viewCollectionString = "view collection";
//
//    private JButton removeProductButton;
//    private JButton savingPreferenceButton;
//    private JButton viewCollectionButton;
//    private JTextField productName;
//
//
//    public GUI() {
//        super(new BorderLayout());
//        listModel.addElement(new Product("Cleanser"));
//        listModel.addElement(new Product("Toner"));
//        listModel.addElement(new Product("Serum"));
//
//        // Create a list and put it in a scroll pane
//        list = new JList(listModel);
//        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        list.setSelectedIndex(0);
//        list.addListSelectionListener(this);
//        list.setVisibleRowCount(15);
//        JScrollPane listScrollPane = new JScrollPane((list));
//
//        JButton addProductButton = new JButton(addProductString);
//        AddListener addListener = new AddListener(addProductButton);
//        addProductButton.setActionCommand(addProductString);
//        addProductButton.addActionListener(addListener);
//        addProductButton.setEnabled(false);
//
//        removeProductButton = new JButton(removeProductString);
//        removeProductButton.setActionCommand(removeProductString);
//        removeProductButton.addActionListener(new RemoveListener());
//
//        productName = new JTextField(25);
//        productName.addActionListener(addListener);
//        productName.getDocument().addDocumentListener(addListener);
//        String name = listModel.getElementAt(list.getSelectedIndex()).toString();
//
//        // Create a panel that uses BoxLayout
//        JPanel buttonPane = new JPanel();
//        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
//        buttonPane.add(removeProductButton);
//        buttonPane.add(Box.createHorizontalStrut(5));
//        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
//        buttonPane.add(Box.createHorizontalStrut(5));
//        buttonPane.add(productName);
//        buttonPane.add(addProductButton);
//        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
//
//        add(listScrollPane, BorderLayout.CENTER);
//        add(buttonPane, BorderLayout.PAGE_END);
//    }
//
//    public class RemoveListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            int index = list.getSelectedIndex();
//            listModel.remove(index);
//
//            int size = listModel.getSize();
//
//            if (size == 0) {
//                removeProductButton.setEnabled(false);
//            } else {
//                if (index == listModel.getSize()) {
//                    index--;
//                }
//                list.setSelectedIndex(index);
//                list.ensureIndexIsVisible(index);
//            }
//        }
//    }
//
//    public class AddListener implements ActionListener, DocumentListener {
//        private boolean alreadyEnabled = false;
//        private JButton button;
//
//        public AddListener(JButton button) {
//            this.button = button;
//        }
//
//        public void actionPerformed(ActionEvent e) {
//            String name = productName.getText();
//
//            // User did not input a unique product name
//            if (name.equals("") || containedInList(name)) {
//                Toolkit.getDefaultToolkit().beep();
//                productName.requestFocusInWindow();
//                productName.selectAll();
//                return;
//            }
//
//            int index = list.getSelectedIndex();
//            if (index == -1) {
//                index = 0;
//            } else {
//                index++;
//            }
//
//            listModel.insertElementAt(new Product(productName.getText()), index);
//
//            // Reset the text field
//            productName.requestFocusInWindow();
//            productName.setText("");
//
//            // Select the new item and make it visible
//            list.setSelectedIndex(index);
//            list.ensureIndexIsVisible(index);
//        }
//
//        protected boolean containedInList(String name) {
//            return listModel.contains(name);
//        }
//
//        public void insertUpdate(DocumentEvent e) {
//            enableButton();
//        }
//
//        public void removeUpdate(DocumentEvent e) {
//            handleEmptyTextField(e);
//        }
//
//        public void changedUpdate(DocumentEvent e) {
//            if (!handleEmptyTextField(e)) {
//                enableButton();
//            }
//        }
//
//        private void enableButton() {
//            if (!alreadyEnabled) {
//                button.setEnabled(true);
//            }
//        }
//
//        private boolean handleEmptyTextField(DocumentEvent e) {
//            if (e.getDocument().getLength() <= 0) {
//                button.setEnabled(false);
//                alreadyEnabled = false;
//                return true;
//            }
//            return false;
//        }
//
//        public void valueChanged(ListSelectionEvent e) {
//            if (!e.getValueIsAdjusting()) {
//                if (list.getSelectedIndex() == -1) {
//                    removeProductButton.setEnabled(false);
//                } else {
//                    removeProductButton.setEnabled(true);
//                }
//            }
//        }
//
//        public void showGUI() {
//            JFrame gui = new JFrame();
//            gui.setTitle("Skincare Product Collection Creator");
//            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            gui.setSize(700, 800);
//            gui.setResizable(false);
//            gui.setVisible(true);
//
//
//            Container pane = gui.getContentPane();
//
//
//            JComponent newContentPane = new GUI();
//            newContentPane.setOpaque(true);
//            gui.setContentPane(newContentPane);
//
//            gui.pack();
//        }
//
//        public static void main(String[] args) {
//            javax.swing.SwingUtilities.invokeLater(new Runnable() {
//                public void run() { showGUI(); }
//            });
//        }
//    }

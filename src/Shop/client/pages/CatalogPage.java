package Shop.client.pages;

import Shop.client.application.ApplicationButton;
import Shop.client.application.ApplicationField;
import Shop.client.application.ApplicationLabel;
import Shop.client.application.ApplicationPanel;
import Shop.data.Bought;
import Shop.data.Clothe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CatalogPage extends ApplicationPanel {
    public ClientFrame boss;
    private JLabel idLabel, modelLabel, priceLabel, countLabel, sizeLabel, typeLabel;
    private ApplicationButton buyButton,refreshButton, backButton;
    private ApplicationField idField, priceField, countField;
    private String[] size={"Size","XS", "S", "M", "L", "XL"};
    private String[] model={"Brand", "Dior", "Prada", "Versace", "Polo", "Imperial", "Hermes", "Burberry", "Channel", "Gucci","Kenzo"};
    private String[] type={"Categories", "Blouses", "Tops", "T-shirt", "Trousers", "Skirt", "Jeans", "Shoes", "Bags", "Belts","Hats"};
    private Object[] columns={"ID", "MODEL", "TYPE","SIZE","PRICE", "COUNT"};
    private JComboBox sizeBox, modelBox,  typeBox;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane pane;
    private ArrayList<Clothe> clothes;

    public CatalogPage(ClientFrame boss) {
        this.boss = boss;
        table=new JTable();
        tableModel=new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);;
        table.setModel(tableModel);
        table.setBackground(new Color(0xFFD9EB));
        table.setForeground(new Color(0xFDF8FF));
        table.setFont(new Font("Arial", 1, 16));
        table.setRowHeight(30);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                idField.setText(tableModel.getValueAt(i, 0).toString());
                modelBox.setSelectedItem(tableModel.getValueAt(i, 1).toString());
                typeBox.setSelectedItem(tableModel.getValueAt(i, 2).toString());
                sizeBox.setSelectedItem(tableModel.getValueAt(i, 3).toString());
                priceField.setText(tableModel.getValueAt(i, 4).toString());
                countField.setText(tableModel.getValueAt(i, 5).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        pane=new JScrollPane(table);
        pane.setBounds(0,0, 450, 600);
        pane.setBackground(new Color(0x9FC5D5));
        pane.setForeground(new Color(0x7F2E4D));
        add(pane);

        idLabel=new JLabel("ID");
        idLabel.setBounds(470, 40, 80, 25);
        idLabel.setForeground(Color.white);
        add(idLabel);
        idField=new ApplicationField();
        idField.setBounds(530, 40, 120, 25);
        add(idField);

        modelLabel=new JLabel("Brand:");
        modelLabel.setBounds(470, 80, 80, 25);
        modelLabel.setForeground(Color.white);
        add(modelLabel);
        modelBox=new JComboBox(model);
        modelBox.setBounds(530, 80, 120, 25);
        modelBox.setBackground(new Color(0xFDF8FF));
        modelBox.setForeground(new Color(0x000000));
        add(modelBox);

        typeLabel=new JLabel("Type:");
        typeLabel.setBounds(470, 120, 120, 25);
        typeLabel.setForeground(Color.white);
        add(typeLabel);
        typeBox=new JComboBox(type);
        typeBox.setBounds(530, 120, 120, 25);
        typeBox.setBackground(new Color(0xFDF8FF));
        typeBox.setForeground(new Color(0x000000));
        add(typeBox);

        sizeLabel=new JLabel("Size");
        sizeLabel.setBounds(470, 160, 80, 25);
        sizeLabel.setForeground(Color.white);
        add(sizeLabel);
        sizeBox=new JComboBox(size);
        sizeBox.setBounds(530, 160, 120, 25);
        sizeBox.setBackground(new Color(0xFFFFFF));
        sizeBox.setForeground(new Color(0x000000));
        add(sizeBox);

        priceLabel=new JLabel("Price:");
        priceLabel.setBounds(470, 200, 80, 25);
        priceLabel.setForeground(Color.white);
        add(priceLabel);
        priceField=new ApplicationField();
        priceField.setBounds(530, 200, 120, 25);
        add(priceField);

        countLabel=new JLabel("Count:");
        countLabel.setBounds(470, 240, 80, 25);
        countLabel.setForeground(Color.white);
        add(countLabel);
        countField=new ApplicationField();
        countField.setBounds(530, 240, 120, 25);
        add(countField);

        buyButton=new ApplicationButton("BUY");
        buyButton.setBounds(680, 30, 150, 30);
        add(buyButton);
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String model=modelBox.getSelectedItem().toString();
                int price=Integer.parseInt(priceField.getText());
                int count=Integer.parseInt(countField.getText());
                String size=sizeBox.getSelectedItem().toString();
                String type=typeBox.getSelectedItem().toString();
                if(model.isEmpty() || size.isEmpty() || type.isEmpty() || price==0 || count==0){
                    JOptionPane.showMessageDialog(boss, "Please, fill all fields!");
                }
                else{
                    Bought bought=new Bought(null, ClientMainFrame.currentUser.getId(), type, count, price*count);
                    boss.clientSocket.addBought(bought);
                    Clothe clothe=new Clothe(null, model, price, count, size, type);
  //                  boss.clientSocket.
                }
            }
        });

        refreshButton=new ApplicationButton("REFRESH");
        refreshButton.setBounds(680, 30, 150, 30);
        add(refreshButton);
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        backButton=new ApplicationButton("BACK");
        backButton.setBounds(680, 30, 150, 30);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boss.catalogPage.setVisible(false);
                boss.clientPage.setVisible(true);
            }
        });
    }

}

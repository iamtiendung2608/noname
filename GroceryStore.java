import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class Item{
    public int takeItem(String Item){
        HashMap<String,Integer>Store=new HashMap<>();
        Store.put("milo", 19000);
        Store.put("monster", 25000);
        Store.put("ovaltine", 22000);
        Store.put("redbull",30000);
        Store.put("sting",10000);
        return Store.get(Item);
    }
}
class Sold{
    static int total=0;
    static String name="hi";
    static int count=0;
    JFrame frame;
    JLabel label;
    Item a=new Item();
    public static void main(String[] args) {
        Sold gui=new Sold();
        gui.go();
    }
    void go(){
        frame=new JFrame("TienDung's Store");
        frame.setSize(800,800);
        JButton BuyButton=new JButton("Buy");
        BuyButton.addActionListener(new BuyingListener());
        BuyButton.setSize(100,100);
        JButton DBuyButton=new JButton("Don't Buy");
        DBuyButton.addActionListener(new NBuyingListener());
        DBuyButton.setSize(100,100);
        label=new JLabel("The total price is: 0");
        MyDrawPanel drawPanel=new MyDrawPanel();
        frame.getContentPane().add(BorderLayout.SOUTH,label);
        frame.getContentPane().add(BorderLayout.EAST, BuyButton);
        frame.getContentPane().add(BorderLayout.WEST,DBuyButton);
        frame.getContentPane().add(drawPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    class BuyingListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(count==0){
                name="milo";
                total+=a.takeItem(name);
                String k=Integer.toString(total);
                label.setText(k);
            }
            if(count==1){
                name="monster";
                total+=a.takeItem(name);
                String k=Integer.toString(total);
                label.setText(k);
            }
            if(count==2){
                name="ovaltine";
                total+=a.takeItem(name);
                String k=Integer.toString(total);
                label.setText(k);
            }
            if(count==3){
                name="redbull";
                total+=a.takeItem(name);
                String k=Integer.toString(total);
                label.setText(k);
            }
            if(count==4){
                name="sting";
                total+=a.takeItem(name);
                String k=Integer.toString(total);
                label.setText(k);
            }
            else{
                String k=Integer.toString(total);
                label.setText(k);
            }
            count++;
            frame.repaint();
        }
    }
   class NBuyingListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            count++;
            frame.repaint();
        }
    }
}
class MyDrawPanel extends JPanel{
    static int count=0;
    public void paintComponent(Graphics g){
        Image img;
        if(count==0)
            {
                img=new ImageIcon("milo.jpg").getImage();
                g.drawImage(img,3,4,this);
            }
        if(count==1)
        {
            img=new ImageIcon("monster.jpg").getImage();
            g.drawImage(img,3,4,this);
        }
        if(count==2)
        {
            img=new ImageIcon("ovaltine.jpg").getImage();
            g.drawImage(img,3,4,this);
        }
        if(count==3)
        {
            img=new ImageIcon("redbull.jpg").getImage();
            g.drawImage(img,3,4,this);
        }
        if(count==4)
        {
            img=new ImageIcon("sting.jpg").getImage();
            g.drawImage(img,3,4,this);
        }
        count++;
    }
}
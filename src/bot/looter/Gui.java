package bot.looter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui {

JCheckBox nameG;
JCheckBox appearG;
JCheckBox ironman;
JFrame frame;
int x;
Looter looter= new Looter();
    public int getX(){
        return x;
        }

    public void gui(){

        initComponents();
    }
    private void initComponents(){
        frame = new JFrame();
        frame.setTitle("SLooter");
        frame.setAlwaysOnTop(true);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("Amount of arrows");
        label.setBounds(17, 0, 200, 25);
        nameG.setBounds(185,-13,50,50);

        JTextField label2 = new JTextField("Arrows amount");
        label2.setBounds(17, 0, 200, 25);
        appearG.setBounds(225,12,50,50);


        JButton button = new JButton();
        button.setText("Start");
        button.setBounds(10, 82, 75, 25);

        panel.add(label);
        panel.add(label2);
        panel.add(nameG);
        panel.add(appearG);
        panel.add(ironman);
        panel.add(button);

        frame.add(panel);
        frame.setSize(290, 140);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(button.isEnabled()){
                    String amountL=label2.getText();
                    looter.adamantArrow=Integer.parseInt(amountL);
                }
            }
        });
    }
    }



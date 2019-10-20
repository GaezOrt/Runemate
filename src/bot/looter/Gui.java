package bot.looter;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class Gui {

JCheckBox nameG;
JCheckBox appearG;
JCheckBox ironman;
JFrame frame;
    public void gui(){

        initComponents();
    }
    private void initComponents(){
        nameG = new JCheckBox();
        appearG = new JCheckBox();
        ironman = new JCheckBox();
        frame = new JFrame();
        frame.setTitle("Tutorial Island");
        frame.setAlwaysOnTop(true);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("Random Name Generator?");
        label.setBounds(17, 0, 200, 25);
        nameG.setBounds(185,-13,50,50);

        JLabel label2 = new JLabel("Random Appearance Generator?");
        label2.setBounds(17, 25, 200, 25);
        appearG.setBounds(225,12,50,50);

        JLabel label3 = new JLabel("Ironman?");
        label3.setBounds(17, 50, 200, 25);
        ironman.setBounds(80,37,50,50);



        JButton button = new JButton();
        button.setText("Start");
        button.setBounds(10, 82, 75, 25);

        panel.add(label);
        panel.add(label2);
        panel.add(nameG);
        panel.add(appearG);
        panel.add(label3);
        panel.add(ironman);
        panel.add(button);

        frame.add(panel);
        frame.setSize(290, 140);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    }



package bot.looter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


 class Gui {



    Looter looter;
    Gui(Looter looter) {
        this.looter = looter;
    }

    public void gui(){

        initComponents();
    }
    private void initComponents(){
        JFrame frame;
        frame = new JFrame();
        frame.setTitle("SLooter");
        frame.setAlwaysOnTop(true);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("Amount of arrows");
        label.setBounds(17, 0, 200, 25);


        JTextField label2 = new JTextField("Arrows amount");
        label2.setBounds(17, 0, 200, 25);



        JButton button = new JButton();
        button.setText("Start");
        button.setBounds(10, 82, 75, 25);

        panel.add(label);
        panel.add(label2);
        panel.add(button);

        frame.add(panel);
        frame.setSize(290, 140);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(button.isEnabled()){

                    String amountL=label2.getText();
                    looter.setAdamantArrow(Integer.parseInt(amountL));
                }
            }
        });
    }
}



package bot.prayer;

import com.runemate.game.api.hybrid.entities.Item;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.script.framework.LoopingBot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prayer extends LoopingBot {

    Boolean bonesB = false;
    private enum State {
        NORMALBONES, NOTHING
    }

    @Override
    public void onStart(String... arguments) {
        JFrame frame= new JFrame();


        JCheckBox bones= new JCheckBox("Bones");

        JPanel npcs=new JPanel();
        JPanel panelAntiban= new JPanel();
        JSplitPane pane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT,npcs, panelAntiban );

        npcs.add(bones);
        frame.add(pane);
        frame.setVisible(true);

        bones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bones.isSelected()){
                   bonesB=true;
                }else{
                    bonesB=false;
                }
            }
        });
    }






    @Override
    public void onLoop() {
        switch (getCurrentState()) {

            case NORMALBONES:
            if(Inventory.isEmpty() && !Bank.open()){
                Npcs.newQuery().names("Banker").results().nearest().interact("Bank");
            }
            if(Bank.open() && Inventory.newQuery().names("Bones").results().size()==28){
                Bank.close();
            }
            if(Inventory.newQuery().names("Bones").results().size()>0){
             Item i=Inventory.newQuery().names("").results().random();

            }

                break;
        }

    }

    private State getCurrentState() {
        if (bonesB) {
            return State.NORMALBONES;
        } else {
            return State.NOTHING;

        }
    }
}

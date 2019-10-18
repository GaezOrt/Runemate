package bot.mining;

import bot.CustomPlayerSense;
import com.runemate.game.api.hybrid.input.Keyboard;
import com.runemate.game.api.hybrid.local.hud.interfaces.InterfaceWindows;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.hybrid.util.calculations.Random;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.LoopingBot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Mining extends LoopingBot {
    boolean copperOreB =false;
    boolean troutB=false;

    boolean switchAndSwitchKeyB=false;
    boolean switchToSkillsKeyB=false;
    boolean switchToSkillsB=false;
    boolean switchToSkillsAndComeB=false;
    boolean sleep4060B=false;
    boolean sleep2040B=false;
    boolean dropInventoryNormallyB=false;
    boolean clickNormalyB=false;
    boolean clickTwiceB=false;
    long initime;
    int minutes;
    int stopTime;

    private enum State
    {
        MINE,DROP,NOTHING
    }

    @Override
    public void onStart(String... arguments) {
        // GameEvents.Universal.LOGIN_HANDLER.disable();
        JFrame frame= new JFrame();
        frame.setSize(400,400);

        JCheckBox anchovies= new JCheckBox("CopperOre");
        JCheckBox trout = new JCheckBox("Trout");


        JCheckBox switchAndSwitchSkillsInv=new JCheckBox("Switch and switch back to inv f12");
        JCheckBox switchWithKeyToSkills= new JCheckBox("Switch with key To SKILLS");
        JCheckBox switchToSkills=new JCheckBox("Switch to skills Tab");
        JCheckBox switchToSkillsAndComeBack=new JCheckBox("Switch to skills and inventory");
        JCheckBox sleep4060=new JCheckBox("Sleep4060");
        JCheckBox sleepRandomTime2040= new JCheckBox("Sleep2040");
        JCheckBox dropInventoryNormally=new JCheckBox(" Drop inventory normally");
        JCheckBox clickNormally= new JCheckBox("Click normally");
        JCheckBox clickTwice= new JCheckBox("Click twice");

        JPanel npcs=new JPanel();
        JPanel panelAntiban= new JPanel();
        JSplitPane pane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT,npcs, panelAntiban );
        npcs.setLayout(new BoxLayout(npcs,BoxLayout.Y_AXIS));
        npcs.setSize(200,200);

        npcs.add(anchovies);
        npcs.add(trout);

        panelAntiban.add(switchAndSwitchSkillsInv);
        panelAntiban.add(switchWithKeyToSkills);

        panelAntiban.add(switchToSkills);
        panelAntiban.add(switchToSkillsAndComeBack);
        panelAntiban.add(sleep4060);
        panelAntiban.add(sleepRandomTime2040);
        panelAntiban.add(dropInventoryNormally);
        panelAntiban.add(clickNormally);
        panelAntiban.add(clickTwice);

        frame.add(pane);
        frame.setVisible(true);


        trout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(trout.isSelected()){
                    troutB=true;
                }else{
                    troutB=false;
                }
            }
        });
        switchWithKeyToSkills.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(switchWithKeyToSkills.isSelected()){
                    switchToSkillsKeyB=true;
                }else{
                    switchToSkillsKeyB=false;
                }
            }
        });
        switchAndSwitchSkillsInv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(switchAndSwitchSkillsInv.isSelected()){
                    switchAndSwitchKeyB=true;
                }else{
                    switchAndSwitchKeyB=false;
                }
            }
        });
        switchToSkills.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(switchToSkills.isSelected()){
                    switchToSkillsB=true;
                }else{
                    switchToSkillsB=false;
                }
            }
        });
        switchToSkillsAndComeBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(switchToSkillsAndComeBack.isSelected()){
                    switchToSkillsAndComeB=true;
                }else{
                    switchToSkillsAndComeB=false;
                }
            }
        });
        sleep4060.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sleep4060.isSelected()){
                    sleep4060B=true;
                }else{
                    sleep4060B=false;
                }
            }
        });
        sleepRandomTime2040.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sleepRandomTime2040.isSelected()){
                    sleep2040B=true;
                }else{
                    sleep2040B=false;
                }
            }
        });
        dropInventoryNormally.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dropInventoryNormally.isSelected()){
                    dropInventoryNormallyB=true;
                }else{
                    dropInventoryNormallyB=false;
                }
            }
        });
        clickNormally.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickNormally.isSelected()){
                    clickNormalyB=true;
                }else{
                    clickNormalyB=false;
                }
            }
        });

        clickTwice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickTwice.isSelected()){
                    clickTwiceB=true;
                }else{
                    clickTwiceB=false;
                }
            }
        });
        anchovies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(anchovies.isSelected()){
                    copperOreB =true;
                }else{
                    copperOreB =false;
                }
            }
        });
        initime = System.currentTimeMillis();
        stopTime= Random.nextInt(120,180);
        CustomPlayerSense.initializeKeys();
        System.out.println("Start until " + stopTime);
    }


    @Override
    public void onLoop() {
            MiningApi api = new MiningApi();
        switch (getCurrentState()){

            case MINE:

                if(switchAndSwitchKeyB) {
                    api.switchTabsSkillsInvKey();
                }
                if(switchToSkillsKeyB){
                    api.switchTabToSkillsKey();
                }
                if(clickNormalyB){
                    api.clickOnlyOne(10943,11161,"Mine");
                }
                if(clickTwiceB){
                    api.clickTwice(11161,10943,"Mine");
                }
                if(dropInventoryNormallyB){
                    api.dropInventory("Copper ore","Copper ore");
                }
                if(sleep2040B){
                    api.delay2540();
                }
                if(sleep4060B){
                    api.delay4060();
                }
                if(switchToSkillsAndComeB){
                    api.useSkillsTabComeBack();
                }
                if(switchToSkillsB){
                    api.useSkillTab();
                }

                break;

            case DROP:
                if(Inventory.isFull()) {
                    if (!InterfaceWindows.getInventory().isOpen()) {
                        InterfaceWindows.getInventory().open();
                    }
                    while (Inventory.contains("Copper ore") || Inventory.contains("")) {
                        for (SpriteItem i : Inventory.getItems("Copper ore")) {
                            Keyboard.pressKey(KeyEvent.VK_SHIFT);
                            i.interact("Drop");
                            Execution.delay(180,250);
                        }
                        Keyboard.releaseKey(KeyEvent.VK_SHIFT);
                    }

                }
                break;
        }

    }

    private State getCurrentState() {
        //Players.getLocal().getAnimationId() == -1 && !Players.getLocal().isMoving()
        if (!Inventory.isFull())
        {

            System.out.println("Pack");
            return State.MINE;
        } else if(Inventory.isFull())
        {
            return State.DROP;
        }else
        {
            return State.NOTHING;
        }
    }
}

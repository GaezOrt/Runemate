package bot.fisher;

import bot.CustomPlayerSense;
import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Interfaces;
import com.runemate.game.api.hybrid.util.calculations.Random;
import com.runemate.game.api.script.framework.LoopingBot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fisher extends LoopingBot {


    boolean shrimAnchoviesB=false;
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
    private enum State {
        FISHINGANCHOVIES, TROUT,NOTHING
    }

    @Override
    public void onStart(String... arguments) {
       // GameEvents.Universal.LOGIN_HANDLER.disable();
        JFrame frame= new JFrame();
        frame.setSize(400,400);

        JCheckBox anchovies= new JCheckBox("ShrimpsAnchovies");
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
                    shrimAnchoviesB=true;
                }else{
                    shrimAnchoviesB=false;
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
        FisherApi api=new FisherApi();
        switch(getCurrentState()){


            case FISHINGANCHOVIES:

                if(switchAndSwitchKeyB) {
                    api.switchTabsSkillsInvKey();
                }
                if(switchToSkillsKeyB){
                    api.switchTabToSkillsKey();
                }
                if(clickNormalyB){
                api.clickOnlyOne("Fishing spot","Net");
                }
                if(clickTwiceB){
                    api.clickTwice("Fishing spot","Net");
                }
                if(dropInventoryNormallyB){
                    api.dropInventory("Raw shrimps","Raw anchovies");
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
            case TROUT:
                if(Interfaces.getAt(629,14)!=null){
                    System.out.println("Logg player invisible");
                    Environment.getBot().stop("End script logged off");
                }
                if (minutes == stopTime) {
                    Environment.getBot().stop("End script");
                }
                minutes = (int) ((System.currentTimeMillis() - initime) / 60000);
                if(switchAndSwitchKeyB) {
                    api.switchTabsSkillsInvKey();
                }
                if(switchToSkillsKeyB){
                    api.switchTabToSkillsKey();
                }
                if(clickNormalyB){
                    api.clickOnlyOne("Rod Fishing spot","Lure");
                }
                if(clickTwiceB){
                    api.clickTwice("Rod Fishing spot","Lure");
                }
                if(dropInventoryNormallyB){
                    api.dropInventory("Raw trout","Raw salmon");
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
        }
    }


    private State getCurrentState() {
        if (shrimAnchoviesB) {
            return State.FISHINGANCHOVIES;
        } else if(troutB) {
            return State.TROUT;
        }else{
         return State.NOTHING;
            }
        }
}

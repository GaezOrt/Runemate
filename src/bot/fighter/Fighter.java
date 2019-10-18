package bot.fighter;

import bot.CustomPlayerSense;
import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.RuneScape;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.hybrid.util.calculations.Random;
import com.runemate.game.api.script.framework.LoopingBot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fighter extends LoopingBot
{



    Api api=new Api();


    boolean xpDropsB=false;

    boolean combatStylesB=false;

    boolean switchFromInvToSkillsAndBackKeysB=false;
    boolean switchFromInvToSkillsKeyB=false;

    boolean clickOnTile14B=false;
    boolean clickOnTile26B=false;
    boolean clicOnTile37B=false;



    boolean clickOnMinimap14B=false;
    boolean clickOnMinimap26B=false;
    boolean clickOnMinimap37B=false;


    boolean switchToSkillsTabAndComeBackToInvB=false;
    boolean switchToSkillsTabAndKeepThereB=false;



    boolean attackNormalB=false;
    boolean attackSlowerB=false;
    boolean attackSlowerSlowerB=false;


    boolean clickRunningB=false;
    boolean clickRunningBeforeAttB=false;

    boolean sleepRandomly3045B=false;
    boolean sleepRandomly4560B=false;
    boolean sleepRandomly6075B=false;


    boolean moveCameraAndAnguloBool=false;
    boolean moveCameraYawB=false;
    boolean moveCameraTowardsNpcB=false;
    boolean moveCameraRandomlyB=false;

    boolean isClickOnTiles800B=false;
    boolean isClickOnTiles1000B=false;
    boolean isClickOnTiles1200B=false;


    boolean buryOnAnyTimeB=false;
    boolean pickUpBones200B=false;
    boolean pickUpBones800B=false;
    boolean pickUpBones1200B=false;
    boolean pickUpBonesWhileAttackingB=false;

    boolean buryThem2or3TimesB=false;
    boolean buryAllOfThemB=false;
    boolean buryOneAtATimeB=false;

    boolean clickOnPlayer800B=false;
    boolean clickOnPlayer1000B=false;
    boolean clickOnPlayer1200B=false;

    boolean attack2TimesB=false;
    boolean attack34TimesB=false;
    boolean hoverNearNpcB=false;
    boolean clickOnCenterB=false;

    boolean goblinsandSpiderB=false;
    boolean goblinsBool=false;
    boolean giantFrogsB=false;


    boolean cowsB=false;
    boolean GiantFrogsB=false;
    long initime;
    int minutes;
    int stopTime;
    private enum State
    {
        COW,GIANTFROGS,NOTHING
    }
    @Override
    public void onStart(String... args)
    {
        JFrame frame= new JFrame();
        frame.setSize(800,800);

        JCheckBox cow= new JCheckBox("Cow");
        JCheckBox goblinsandspider=new JCheckBox("Cow");
        JCheckBox giantFrogs= new JCheckBox("Giant Frogs");
        JCheckBox buton3= new JCheckBox("3");
        JCheckBox buton4= new JCheckBox("4");

        JCheckBox xpDrops=new JCheckBox("XP Drops");

        JCheckBox clickOnCenterFrogs= new JCheckBox("Click on center");
        JCheckBox combatStyles= new JCheckBox("Combat styles");
        JCheckBox hoverNearNpc=new JCheckBox("Hover near npc");

        JCheckBox switchToSkillsAndBackKey= new JCheckBox("Switch to skills and back with f2");
        JCheckBox switchToSkillsKey= new JCheckBox("Switch to skills");

        JCheckBox clickFloor14= new JCheckBox("Click on near floor 14");
        JCheckBox clickFloor26= new JCheckBox("Click on near floor 26");
        JCheckBox clickFloor37= new JCheckBox(" Click on near floor 37");

        JCheckBox clickTile14= new JCheckBox("Click on near tile 14");
        JCheckBox clickTile26= new JCheckBox(" Click on near tile 26");
        JCheckBox clickTile37= new JCheckBox("Click on near tile 37");

        JCheckBox switchFromInvToSkillsAndThenBack = new JCheckBox("Switch inv to skills and then back");
        JCheckBox switchFromInvToSkillsAndKeepThere= new JCheckBox(" Switch inv to skills and keep there");


       // JCheckBox hoverOverNearNpc=new JCheckBox("Hover near npc");
        JCheckBox sleepRandomly3045= new JCheckBox("Sleep randomly between 30 and 45 secs");
        JCheckBox sleepRandomly4560= new JCheckBox("Sleep random 45 60");
        JCheckBox sleepRandomly6075= new JCheckBox(" Sleep random 60 75");


        JCheckBox clickOnPlayer800WhenNotAttacking= new JCheckBox("Click on players 800 when not attacking");
        JCheckBox clickOnPlayers1000= new JCheckBox("Click on players 1000");
        JCheckBox clickOnPlayer1200OnlyWhenAttacking= new JCheckBox("Click on players 1200 when attacking");


        JCheckBox pickUpBones200=new JCheckBox("Pickup bones 400");
        JCheckBox pickUpBones800=new JCheckBox("Pick up bones 800");
        JCheckBox pickUpBones1200=new JCheckBox("Pick up bones 1200");
        JCheckBox pickUpBonesWhileAttacking= new JCheckBox("Pick up bones while attacking");

        JCheckBox clickRunning=new JCheckBox("Click running button");
        JCheckBox clickRunningBeforeAttacking= new JCheckBox("Click Running before attacking");

        JCheckBox attackSlowerFirst= new JCheckBox("Attack normaly");
        JCheckBox attackSlower=new JCheckBox("Attack slower");
        JCheckBox attackSlowerSlower=new JCheckBox("Attack slower slower");



        JCheckBox buryOnAnyTime=new JCheckBox("Bury on any time");
        JCheckBox buryAllTogether= new JCheckBox("Bury all of them");
        JCheckBox burryThem2or3Times= new JCheckBox("Bury bones 2-3 times each all together");
        JCheckBox buryOneAtATime= new JCheckBox("Bury one at a time");

        JCheckBox clickNearFloor800= new JCheckBox("Click near tile 800");
        JCheckBox clickNearFloor1000= new JCheckBox("Click near tile 1000");
        JCheckBox clickNearFloor1200= new JCheckBox("Click near tile 1200");

        JCheckBox moveCameraToNpc= new JCheckBox("Move camera towards npc randomly");
        JCheckBox moveCameraYaw=new JCheckBox("Move camera yaw");
        JCheckBox moveCameraAndAnguloB=new JCheckBox("Move camera and angulo");
        JCheckBox moveCameraRandomly= new JCheckBox("Move camera randomly");

        JCheckBox attack2Times= new JCheckBox("Click 2 times");
        JCheckBox attack34Times=new JCheckBox("Click 3 times");


        JPanel npcs=new JPanel();
        JPanel panelAntiban= new JPanel();
        JSplitPane pane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT,npcs, panelAntiban );


        npcs.setLayout(new BoxLayout(npcs,BoxLayout.Y_AXIS));
        npcs.setSize(200,200);
        npcs.add(cow);
        npcs.add(goblinsandspider);
        npcs.add(giantFrogs);
        npcs.add(buton4);




        panelAntiban.add(xpDrops);
        panelAntiban.add(combatStyles);
        panelAntiban.add(clickFloor14);
        panelAntiban.add(clickFloor26);
        panelAntiban.add(clickFloor37);

        panelAntiban.add(clickOnCenterFrogs);
        panelAntiban.add(clickTile14);
        panelAntiban.add(clickTile26);
        panelAntiban.add(clickTile37);

        panelAntiban.add(switchToSkillsKey);
        panelAntiban.add(switchToSkillsAndBackKey);
        panelAntiban.add(switchFromInvToSkillsAndThenBack);
        panelAntiban.add(switchFromInvToSkillsAndKeepThere);

        panelAntiban.add(attackSlowerFirst);
        panelAntiban.add(attackSlowerSlower);
        panelAntiban.add(attackSlower);

        panelAntiban.add(sleepRandomly3045);
        panelAntiban.add(sleepRandomly4560);
        panelAntiban.add(sleepRandomly6075);

        panelAntiban.add(attack2Times);
        panelAntiban.add(attack34Times);

        panelAntiban.add(moveCameraAndAnguloB);
        panelAntiban.add(moveCameraYaw);
        panelAntiban.add(moveCameraToNpc);
        panelAntiban.add(moveCameraRandomly);

        //panelAntiban.add(clickRunning);
        //panelAntiban.add(clickRunningBeforeAttacking);

       // panelAntiban.add(clickOnPlayer800WhenNotAttacking);
        //panelAntiban.add(clickOnPlayers1000);
        //panelAntiban.add(clickOnPlayer1200OnlyWhenAttacking);

       // panelAntiban.add(clickRunning);
        //panelAntiban.add(clickRunningBeforeAttacking);

        panelAntiban.add(buryOnAnyTime);
        panelAntiban.add(buryAllTogether);
        panelAntiban.add(buryOneAtATime);
        panelAntiban.add(burryThem2or3Times);

        panelAntiban.add(hoverNearNpc);
        panelAntiban.add(pickUpBonesWhileAttacking);
        panelAntiban.add(pickUpBones200);
        panelAntiban.add(pickUpBones800);
        panelAntiban.add(pickUpBones1200);
       // panelAntiban.add(clickNearFloor800);
        //panelAntiban.add(clickNearFloor1000);
        //panelAntiban.add(clickNearFloor1200);


        frame.add(pane);
        frame.setVisible(true);


        clickOnCenterFrogs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickOnCenterFrogs.isSelected()){
                    clickOnCenterB=true;
                }else{
                    clickOnCenterB=false;
                }
            }
        });

        xpDrops.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(xpDrops.isSelected()){
                    xpDropsB=true;
                }else{
                    xpDropsB=false;
                }
            }
        });
        combatStyles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(combatStyles.isSelected()){
                    combatStylesB=true;
                }else{
                    combatStylesB=false;
                }
            }
        });
        attack34Times.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(attack34Times.isSelected()){
                    attack34TimesB=true;
                }else{
                    attack34TimesB=false;
                }
            }
        });
        hoverNearNpc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hoverNearNpc.isSelected()){
                    hoverNearNpcB=true;
                }else{
                    hoverNearNpcB=false;
                }
            }
        });
        moveCameraAndAnguloB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(moveCameraAndAnguloB.isSelected()){
                    moveCameraAndAnguloBool=true;
                }else{
                    moveCameraAndAnguloBool=false;
                }
            }
        });
        switchToSkillsAndBackKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(switchToSkillsAndBackKey.isSelected()){
                    switchFromInvToSkillsAndBackKeysB=true;
                }else{
                    switchFromInvToSkillsAndBackKeysB=false;
                }
            }
        });
        switchToSkillsKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(switchToSkillsKey.isSelected()){
                    switchFromInvToSkillsKeyB=true;
                }else{
                    switchFromInvToSkillsKeyB=false;
                }
            }
        });
        moveCameraYaw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(moveCameraYaw.isSelected()){
                    moveCameraYawB=true;
                }else{
                    moveCameraYawB=false;
                }
            }
        });
        clickFloor14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickFloor14.isSelected()){
                    clickOnTile14B=true;
                }else{
                    clickOnTile14B=false;
                }
            }
        });
        clickFloor26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickFloor26.isSelected()){
                    clickOnTile26B=true;
                }else{
                    clickOnTile26B=false;
                }
            }
        });

        clickFloor37.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickFloor37.isSelected()){
                    clicOnTile37B=true;
                }else{
                    clicOnTile37B=false;
                }
            }
        });
        clickTile14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickTile14.isSelected()){
                    clickOnMinimap14B=true;
                }else{
                    clickOnMinimap14B=false;
                }
            }
        });

        clickTile26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickTile26.isSelected()){
                    clickOnMinimap26B=true;
                }else{
                    clickOnMinimap26B=false;
                }
            }
        });
        clickTile37.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickTile37.isSelected()){
                    clickOnMinimap37B=true;
                }else{
                    clickOnMinimap37B=false;
                }
            }
        });
        switchFromInvToSkillsAndThenBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(switchFromInvToSkillsAndThenBack.isSelected()){
                    switchToSkillsTabAndComeBackToInvB=true;
                }else{
                    switchToSkillsTabAndComeBackToInvB=false;
                }
            }
        });

        switchFromInvToSkillsAndKeepThere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(switchFromInvToSkillsAndKeepThere.isSelected()){
                    switchToSkillsTabAndKeepThereB=true;

                }else{
                    switchToSkillsTabAndKeepThereB=false;
                }
            }
        });

        sleepRandomly3045.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sleepRandomly3045.isSelected()){
                    sleepRandomly3045B=true;
                }else{
                    sleepRandomly3045B=false;
                }
            }
        });
        sleepRandomly4560.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sleepRandomly4560.isSelected()){
                    sleepRandomly4560B=true;
                }else{
                    sleepRandomly4560B=false;
                }
            }
        });
        sleepRandomly6075.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sleepRandomly6075.isSelected()){
                    sleepRandomly6075B=true;
                }else{
                    sleepRandomly6075B=false;
                }
            }
        });
        attackSlowerFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(attackSlowerFirst.isSelected()){
                    attackNormalB=true;
                }else{
                    attackNormalB=false;
                }
            }
        });
        attackSlower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(attackSlower.isSelected()){
                    attackSlowerB=true;
                }else{
                    attackSlowerB=false;
                }
            }
        });
        attackSlowerSlower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(attackSlowerSlower.isSelected()){
                    attackSlowerSlowerB=true;
                }else{
                    attackSlowerSlowerB=true;
                }
            }
        });
        moveCameraRandomly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(moveCameraRandomly.isSelected()){
                    moveCameraRandomlyB=true;
                }else{
                    moveCameraRandomlyB=false;
                }
            }
        });
        /*hoverOverNearNpc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hoverOverNearNpc.isSelected()){
                    hoverNearNpcB=true;
                }else{
                    hoverNearNpcB=false;
                }
            }
        });

         */
        attack2Times.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(attack2Times.isSelected()){
                    attack2TimesB=true;
                }else{
                    attack2TimesB=false;

                }
            }
        });
        pickUpBonesWhileAttacking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pickUpBonesWhileAttacking.isSelected()){
                    pickUpBonesWhileAttackingB=true;
                }else{
                    pickUpBonesWhileAttackingB=false;
                }
            }
        });
        giantFrogs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(giantFrogs.isSelected()){
                    giantFrogsB=true;
                    GiantFrogsB=true;
                }else{
                    giantFrogsB=false;
                    GiantFrogsB=false;
                }
            }
        });
        burryThem2or3Times.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(burryThem2or3Times.isSelected()){
                    buryThem2or3TimesB=true;
                }else{
                    buryThem2or3TimesB=false;
                }
            }
        });
        moveCameraToNpc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(moveCameraToNpc.isSelected()){
                    moveCameraTowardsNpcB=true;
                }else{
                    moveCameraTowardsNpcB=false;
                }
            }
        });
        clickNearFloor800.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickNearFloor800.isSelected()){
                    isClickOnTiles800B=true;
                }else{
                    isClickOnTiles800B=false;
                }
            }
        });
        clickNearFloor1000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickNearFloor1000.isSelected()){
                    isClickOnTiles1000B=true;
                }else{
                    isClickOnTiles1000B=false;
                }
            }
        });
        clickNearFloor1200.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickNearFloor1200.isSelected()){
                    isClickOnTiles1200B=true;
                }else{
                    isClickOnTiles1200B=false;
                }
            }
        });


        goblinsandspider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(goblinsandspider.isSelected()){
                    goblinsandSpiderB=true;
                }else{
                    goblinsandSpiderB=false;
                }
            }
        });
        clickOnPlayer800WhenNotAttacking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickOnPlayer800WhenNotAttacking.isSelected()){
                    clickOnPlayer800B=true;
                }else{
                    clickOnPlayer800B=false;
                }
            }
        });
        clickOnPlayers1000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickOnPlayers1000.isSelected()){
                    clickOnPlayer1000B=true;
                }else{
                    clickOnPlayer1000B=false;
                }
            }
        });
        clickOnPlayer1200OnlyWhenAttacking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickOnPlayer1200OnlyWhenAttacking.isSelected()){
                    clickOnPlayer1200B=false;
                }else{
                    clickOnPlayer1200B=true;
                }
            }
        });
        buryOnAnyTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buryOnAnyTime.isSelected()){
                    buryOnAnyTimeB=true;
                }else{
                    buryOnAnyTimeB=false;
                }
            }
        });
        buryAllTogether.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buryAllTogether.isSelected()){
                    buryAllOfThemB=true;
                }else{
                    buryAllOfThemB=false;
                }
            }
        });

        buryOneAtATime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buryOneAtATime.isSelected()){
                    buryOneAtATimeB=true;
                }else{
                    buryOneAtATimeB=false;
                }
            }
        });
        pickUpBones1200.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pickUpBones1200.isSelected()){
                    pickUpBones1200B=true;
                }else{
                    pickUpBones1200B=false;
                }
            }
        });
        pickUpBones800.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pickUpBones800.isSelected()){
                    pickUpBones800B=true;
                }else{
                    pickUpBones800B=false;
                }
            }
        });

        pickUpBones200.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pickUpBones200.isSelected()){
                    pickUpBones200B=true;
                }else{
                    pickUpBones200B=false;
                }
            }
        });

        cow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cow.isSelected()){
                    cowsB=true;
                }else{

                    cowsB=false;
                }
            }
        });

        if(!Npcs.newQuery().names("Frog"," Giant frog","Big frog").results().isEmpty()){
            GiantFrogsB=true;
        }
        if(!Npcs.newQuery().names("Cow").results().isEmpty()){
            cowsB=true;
        }
        initime = System.currentTimeMillis();
        stopTime= Random.nextInt(160,180);
        CustomPlayerSense.initializeKeys();
        System.out.println("Start until " + stopTime);


    }




    @Override
    public void onLoop() {
        switch (getCurrentState()) {

            case COW:
                if (!RuneScape.isLoggedIn()) {
                    Environment.getBot().stop("End script logged off");
                }
                if (minutes == stopTime) {
                    Environment.getBot().stop("End script");
                }
                minutes = (int) ((System.currentTimeMillis() - initime) / 60000);
                Npc x = Npcs.newQuery().names("Cow", "Cow calf").results().nearest();


                if(xpDropsB){
                    api.closeXpShower();
                }
                if(combatStylesB){
                    api.changeCombatStyle();
                }
                if(attack34TimesB){
                    api.attack34Times("Cow", "Cow calf");
                }
                if(hoverNearNpcB){
                    api.hoverNpcNear("Cow");
                }
                if(moveCameraAndAnguloBool){
                    api.changeCameraAndAngular();
                }
                if (switchFromInvToSkillsAndBackKeysB) {
                    api.switchTabsSkillsInvKey();
                }
                if (switchFromInvToSkillsKeyB) {
                    api.switchTabToSkillsKey();
                }

                if (moveCameraYawB) {
                    api.angularCamera();
                }
                if (clicOnTile37B) {
                    api.clickOnNearFloor37();
                }
                if (clickOnTile26B) {
                    api.clickOnNearFloor26();
                }
                if (clickOnTile14B) {
                    api.clickOnNearTile14();
                }
                if (clickOnMinimap14B) {
                    api.clickNearTile14();
                }
                if (clickOnMinimap26B) {
                    api.clickNearTile26();
                }
                if (clickOnMinimap37B) {
                    api.clickNearTile37();
                }


                if (switchToSkillsTabAndComeBackToInvB) {
                    api.switchToSkillsTabAndThenToInventory();

                }
                if (switchToSkillsTabAndKeepThereB) {
                    api.switchToSkillsAndKeepItThere();
                }

                if (sleepRandomly3045B) {
                    api.sleepRandomly3045();
                }
                if (sleepRandomly4560B) {
                    api.sleepRandomly4560();
                }
                if (sleepRandomly6075B) {
                    api.sleepRandomly6075();
                }
                if (attackNormalB) {
                    System.out.println("NormalB");
                    api.attackSlowly("Cow", "Cow calf");

                }
                if (attackSlowerB) {
                    api.attackSlower("Cow", "Cow calf");
                    System.out.println("Slower");
                }
                if (attackSlowerSlowerB) {
                    System.out.println("SlowerSlowerB");
                    api.attackSlowerSlower("Cow", "Cow calf");
                }

/*
                if(clickOnPlayer800B){
                    api.clickOnPlayer800WhenNotAttacking();
                }
                if(clickOnPlayer1000B){
                    api.clickOnPlayer1000();
                }
                if(clickOnPlayer1200B){
                    api.clickOnPlayer1200OnlyWhenAttacking();
                }
  */
                if (buryAllOfThemB) {
                    api.buryBonesAllTogether("Bones","Big bones");
                }

                if (pickUpBones200B) {
                    api.pickUpBones200("Bones");
                }

                if (pickUpBones800B) {
                    api.pickUpBones800("Bones");
                }

                if (pickUpBones1200B) {
                    api.pickUpBones1200("Bones");
                }
                if (buryAllOfThemB) {
                    api.buryBonesAllTogether("Bones","Big bones");
                }
                if (buryOneAtATimeB) {
                    if (buryOnAnyTimeB) {
                        api.buryOneAnyTime("Bones","");
                    } else {
                        api.buryOneWhenNotAttacking("Bones","");
                    }

                }
                /*
                if(isClickOnTiles800B){
                    api.randomTilesCloseBasedOnRandom800();
                }
                if(isClickOnTiles1000B){
                    api.randomTilesCloseBasedOnRandom1200();
                }
                if(isClickOnTiles1200B){
                    api.randomTilesCloseBasedOnRandom1600();
                }
                */

                if (moveCameraTowardsNpcB) {
                    api.moveCameraToNpc(x);
                }
                if (buryThem2or3TimesB) {
                    api.buryBonesAllTogether2or3Times("Bones","Big bones");
                }
                if (pickUpBonesWhileAttackingB) {
                    api.pickUpBonesWhileAttacking("Bones");
                }
                if (attack2TimesB) {
                    api.attack23Times("Cow", "Cow calf");
                }
              /*  if(hoverNearNpcB){
                    api.hoverNearNpcs("Frog","Giant rat","");
                }
                */

                if (moveCameraRandomlyB) {
                    api.moveCameraRandomly();
                }


                GameObject door = GameObjects.newQuery().ids(1558).results().nearest();
                Api.eat();
                break;
            case GIANTFROGS:

                if (minutes == stopTime) {
                    Environment.getBot().stop("End script");
                }
                minutes = (int) ((System.currentTimeMillis() - initime) / 60000);

                Npc frog = Npcs.newQuery().names("Giant frog", "Big frog", "Frog").results().nearest();

                if(clickOnCenterB){
                    api.clickOnCenter();
                }

                if(xpDropsB){
                    api.closeXpShower();
                }
                if(combatStylesB){
                    api.changeCombatStyle();
                }
                if(attack34TimesB){
                    api.attack34Times("Giant frog","Big frog");
                }
                if(hoverNearNpcB){
                    api.hoverNpcNear("Giant frog");
                }
                if(moveCameraAndAnguloBool){
                    api.changeCameraAndAngular();
                }
                if(switchFromInvToSkillsAndBackKeysB){
                    api.switchTabsSkillsInvKey();
                }
                if(switchFromInvToSkillsKeyB){
                    api.switchTabToSkillsKey();
                }
                if(moveCameraYawB){
                    api.angularCamera();
                }
                if(clicOnTile37B){
                    api.clickOnNearFloor37();
                }
                if(clickOnTile26B){
                    api.clickOnNearFloor26();
                }
                if(clickOnTile14B){
                    api.clickOnNearTile14();
                }
                if(clickOnMinimap14B){
                    api.clickNearTile14();
                }
                if(clickOnMinimap26B){
                    api.clickNearTile26();
                }
                if(clickOnMinimap37B){
                    api.clickNearTile37();
                }

                if(switchToSkillsTabAndComeBackToInvB) {
                    api.switchToSkillsTabAndThenToInventory();

                }
                if(switchToSkillsTabAndKeepThereB){
                    api.switchToSkillsAndKeepItThere();
                }
                if(sleepRandomly3045B){
                    api.sleepRandomly3045();
                }
                if(sleepRandomly4560B){
                    api.sleepRandomly4560();
                }
                if(sleepRandomly6075B){
                    api.sleepRandomly6075();
                }

                if(attackNormalB) {
                    api.attackSlowly("Giant frog","Big frog");

                }
                if(attackSlowerB){
                    api.attackSlower("Giant frog","Big frog");
                }
                if(attackSlowerSlowerB){
                    api.attackSlowerSlower("Giant frog","Big frog");
                }

/*
                if(clickOnPlayer800B){
                    api.clickOnPlayer800WhenNotAttacking();
                }
                if(clickOnPlayer1000B){
                    api.clickOnPlayer1000();
                }
                if(clickOnPlayer1200B){
                    api.clickOnPlayer1200OnlyWhenAttacking();
                }
  */
                if(buryAllOfThemB) {
                    api.buryBonesAllTogether("Bones","Big bones");
                }

                if(pickUpBones200B){
                    api.pickUpBones200("Big bones");
                }

                if(pickUpBones800B){
                    api.pickUpBones800("Big bones");
                }

                if(pickUpBones1200B){
                    api.pickUpBones1200("Big bones");
                }
                if(buryAllOfThemB){
                    api.buryBonesAllTogether("Bones","Big bones");
                }
                if(buryOneAtATimeB){
                    if(buryOnAnyTimeB) {
                        api.buryOneAnyTime("Big bones","Bones");
                    }else{
                        api.buryOneWhenNotAttacking("Big bones","Bones");
                    }

                }
                /*
                if(isClickOnTiles800B){
                    api.randomTilesCloseBasedOnRandom800();
                }
                if(isClickOnTiles1000B){
                    api.randomTilesCloseBasedOnRandom1200();
                }
                if(isClickOnTiles1200B){
                    api.randomTilesCloseBasedOnRandom1600();
                }
                */

                if(moveCameraTowardsNpcB){
                    api.moveCameraToNpc(frog);
                }
                if(buryThem2or3TimesB){
                    api.buryBonesAllTogether2or3Times("Bones","Big bones");
                }
                if(pickUpBonesWhileAttackingB){
                    api.pickUpBonesWhileAttacking(" Big bones");
                }
                if(attack2TimesB){
                    api.attack23Times("Giant frog","Big frog");
                }
              /*  if(hoverNearNpcB){
                    api.hoverNearNpcs("Frog","Giant rat","");
                }
                */
                if(moveCameraRandomlyB){
                    api.moveCameraRandomly();
                }

        }
    }


    @Override
    public void onStop()
    {
    }

    private State getCurrentState() {

        //Players.getLocal().getAnimationId() == -1 && !Players.getLocal().isMoving()
      if(cowsB){
            return State.COW;
        } else if(GiantFrogsB)
        {
            return State.GIANTFROGS;
        }else
        {
            return State.NOTHING;
        }
    }


}


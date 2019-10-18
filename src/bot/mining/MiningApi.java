package bot.mining;

import com.runemate.game.api.hybrid.input.Keyboard;
import com.runemate.game.api.hybrid.local.hud.interfaces.InterfaceWindows;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Random;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.LoopingBot;

import java.awt.event.KeyEvent;

public class MiningApi extends LoopingBot {


    public void delay2540(){
        if(Random.nextInt(1,800)==2){
            Execution.delay(25000,40000);
        }
    }
    public void delay4060(){
        if(Random.nextInt(1,800)==2){
            Execution.delay(40000,60000);
        }
    }
    public void useSkillTab(){
        if(Random.nextInt(0,1000)==2){
            InterfaceWindows.getSkills().open();
        }
    }
    public void sleepInBetweenDropping(String name,String name1){
        if(Inventory.isFull()) {
            if (!InterfaceWindows.getInventory().isOpen()) {
                InterfaceWindows.getInventory().open();
            }
            while (Inventory.contains(name) || Inventory.contains(name1)) {
                for (SpriteItem i : Inventory.getItems(name,name1)) {
                    Keyboard.pressKey(KeyEvent.VK_SHIFT);
                    i.interact("Drop");
                    Execution.delay(180,250);
                    if(Random.nextInt(0,1000)==3){
                        Execution.delay(5000,30000);
                    }
                }
                Keyboard.releaseKey(KeyEvent.VK_SHIFT);
            }

        }
    }
    public void useSkillsTabComeBack(){
        if(Random.nextInt(0,1000)==2) {
            if (!InterfaceWindows.getSkills().isOpen()) {
                InterfaceWindows.getSkills().open();
            }
            Execution.delay(3000,6000);
            InterfaceWindows.getInventory().open();
        }
    }
    public void clickOnlyOne(int n1,int n2,String action){

        if(Players.getLocal().getAnimationId()==-1 && !Inventory.isFull()  && !Players.getLocal().isMoving()){
            GameObjects.newQuery().ids(n1,n2).results().nearest().interact(action);
            Execution.delay(1000,2000);
            Execution.delayUntil(()->Players.getLocal().getAnimationId()==-1,5000,12000);
        }
    }
    public void clickTwice(int id,int n2,String action){

        if(Players.getLocal().getAnimationId()==-1 && !Inventory.isFull() && Players.getLocal().getTarget()==null && !Players.getLocal().isMoving()){
            GameObjects.newQuery().ids(id,n2).results().nearest().interact(action);
            Execution.delay(800,1500);
        }
        if(Random.nextInt(0,800)==2){
            GameObjects.newQuery().ids(id,n2).results().nearest().interact(action);
            Execution.delay(800,1500);
        }

    }
    public void dropInventory(String name,String name1){

        if(Inventory.isFull()) {
            if (!InterfaceWindows.getInventory().isOpen()) {
                InterfaceWindows.getInventory().open();
            }
            while (Inventory.contains(name) || Inventory.contains(name1)) {
                for (SpriteItem i : Inventory.getItems(name,name1)) {
                    Keyboard.pressKey(KeyEvent.VK_SHIFT);
                    i.interact("Drop");
                    Execution.delay(180,250);
                }
                Keyboard.releaseKey(KeyEvent.VK_SHIFT);
            }

        }
    }

    public void switchTabsSkillsInvKey(){

        if(Random.nextInt(1,1000)==3) {
            if (!InterfaceWindows.getSkills().isOpen()) {
                Keyboard.pressKey(KeyEvent.VK_F2);
            }
            Execution.delay(Random.nextInt(2000,3000), 5000);
            Keyboard.pressKey(KeyEvent.VK_ESCAPE);

        }
    }
    public void switchTabToSkillsKey(){
        if(Random.nextInt(0,1000)==2){
            Keyboard.pressKey(KeyEvent.VK_F2);
        }

    }
    public void onLoop() {

    }
}

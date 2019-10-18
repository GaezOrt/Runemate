package bot.fighter;

import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.hybrid.input.Keyboard;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.hud.interfaces.*;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.location.navigation.basic.PredefinedPath;
import com.runemate.game.api.hybrid.location.navigation.basic.ViewportPath;
import com.runemate.game.api.hybrid.region.GroundItems;
import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Random;
import com.runemate.game.api.osrs.local.hud.interfaces.OSRSTab;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.LoopingBot;

import java.awt.event.KeyEvent;

import static com.runemate.game.api.hybrid.local.hud.interfaces.Inventory.newQuery;

public class Api extends LoopingBot {

    Area centro=new Area.Rectangular(new Coordinate(3193,3178,0),new Coordinate(3209,3170,0));
    public void clickOnCenter(){

        try {
            if(!centro.contains(Players.getLocal())&& Npcs.newQuery().names("Giant frog", "Big frog").results().nearest().distanceTo(Players.getLocal())>Random.nextInt(2,5) ) {
                Coordinate destination = centro.getRandomCoordinate();
                BresenhamPath pathToSafeZone = BresenhamPath.buildTo(destination);
                System.out.println("Going to safe zone, amount of arrows designed");
                pathToSafeZone.step(true);
            }
            }catch (NullPointerException e){


            }
        }

    public void attackSlower(String n1, String n2) {
        Npc goblin = Npcs.newQuery().names(n1, n2).results().nearest();
        try {
            if (Players.getLocal().getHealthGauge() == null && !Players.getLocal().isMoving()) {
                if (goblin.getHealthGauge() == null) {
                    goblin.interact("Attack");
                    Execution.delay(200, Random.nextInt(600, 800));
                }
            }
        }catch(NullPointerException e){

        }
    }

    public void attackSlowerSlower(String n1, String n2) {
        Npc goblin = Npcs.newQuery().names(n1, n2).results().nearest();
       try {
           if (Players.getLocal().getHealthGauge() == null && !Players.getLocal().isMoving()) {
               if (goblin != null) {
                   if (goblin.getHealthGauge() == null) {
                       goblin.interact("Attack");
                       Execution.delay(Random.nextInt(250, 400), Random.nextInt(401, 1000));

                   }
               }
           }
       }catch(NullPointerException e){

       }

        }
    public void clickOnNearFloor37(){
        if(Random.nextInt(1,1100)==4){
        PredefinedPath predefined = PredefinedPath.create(new Coordinate(Players.getLocal().getPosition().getX() + Random.nextInt(-4, 7), Players.getLocal().getPosition().getY() + Random.nextInt(-4,8), 0));

            if (predefined != null) {
                ViewportPath viewport = ViewportPath.convert(predefined);
                //viewport won't ever be null, so no need to null check it
                Coordinate nextStep = viewport.getNext();
                if (nextStep != null) {
                    if (nextStep.isVisible()) {
                        viewport.step();
                        System.out.println("Clicking on floor 37");
                    }
                }

                }
            }
        }

    public void clickOnNearFloor26(){
        if(Random.nextInt(1,900)==4){

        PredefinedPath predefined = PredefinedPath.create(new Coordinate(Players.getLocal().getPosition().getX() + Random.nextInt(-3, 6), Players.getLocal().getPosition().getY() + Random.nextInt(-3, 6), 0));

        if (predefined != null) {
            ViewportPath viewport = ViewportPath.convert(predefined);
            //viewport won't ever be null, so no need to null check it
            Coordinate nextStep = viewport.getNext();
            if (nextStep != null) {
                if (nextStep.isVisible()) {
                    viewport.step();
                    System.out.println("Clicking on floor 26");
                }

            }
        }
        }

    }

    public void clickOnNearTile14() {

        if(Random.nextInt(1,800)==4){
        PredefinedPath predefined = PredefinedPath.create(new Coordinate(Players.getLocal().getPosition().getX() + Random.nextInt(-4, 4), Players.getLocal().getPosition().getY() + Random.nextInt(-4, 4), 0));

        if (predefined != null) {
            ViewportPath viewport = ViewportPath.convert(predefined);
            //viewport won't ever be null, so no need to null check it
            Coordinate nextStep = viewport.getNext();
            if (nextStep != null) {
                if (nextStep.isVisible()) {
                    viewport.step();
                    System.out.println("Clicking on floor 14");
                }
            }

            }
        }
    }

   /* public void hoverNearNpcs(String n1, String n2, String n3) {
        if (Random.nextInt(0, 1200) == 2) {
            hoverOverNearNpc = true;
        }
        if (hoverOverNearNpc) {
            ctx.npcs.select().name(n1, n2, n3).nearest().poll().hover();
            log.info("Hovered over npc");
            hoverOverNearNpc = false;
        }
    }

    public void clickOnPlayer1200OnlyWhenAttacking() {
        int x = Random.nextInt(0, 1000);
        if (x == 3) {
            Player pla = ctx.players.select().select(p -> !p.equals(ctx.players.local())).nearest().limit(5).shuffle().poll();
            if (ctx.players.local().combatLevel() > pla.combatLevel() || ctx.players.local().combatLevel() < pla.combatLevel()) {

                int y = Random.nextInt(0, 3);
                switch (y) {
                    case 0:
                        if (ctx.players.local().interacting().valid())
                            pla.click(false);
                        clickedOnPlayer++;
                        log.info("clicking on player");
                        break;
                    case 1:
                        if (ctx.players.local().interacting().valid())
                            pla.hover();
                        clickedOnPlayer++;
                        log.info("Hover on player");
                        break;
                }

            }
        }
    }
*/
  /*  public void clickOnPlayer800WhenNotAttacking() {
        int x = Random.nextInt(0, 600);
        if (x == 3) {
            Player pla = ctx.players.select().select(p -> !p.equals(ctx.players.local())).nearest().limit(5).shuffle().poll();
            if (ctx.players.local().combatLevel() > pla.combatLevel() || ctx.players.local().combatLevel() < pla.combatLevel()) {

                int y = Random.nextInt(0, 3);
                switch (y) {
                    case 0:
                        if (ctx.players.local().animation() == -1 && !ctx.players.local().interacting().valid())
                            pla.click(false);
                        clickedOnPlayer++;
                        log.info("clicking on player");
                        break;
                    case 1:
                        if (ctx.players.local().animation() == -1 && !ctx.players.local().interacting().valid())
                            pla.hover();
                        clickedOnPlayer++;
                        log.info("Hover on player");
                        break;
                }

            }
        }
    }
*/
    public void clickOnPlayer1000() {
        int x = Random.nextInt(0, 800);
        if (x == 3) {

        }
    }
  /*  public void clickOnRunButton() {
        if ( > (Random.nextInt(1, 30) + 20) && !ctx.movement.running()) {
            ctx.widgets.component(160, 24).click();
            log.info("Clicking running");
        }
    }
*/

    public void attack23Times(String n1, String n2) {
        Npc goblin = Npcs.newQuery().names(n1, n2).results().nearest();
        if (Players.getLocal().getHealthGauge() == null && !Players.getLocal().isMoving()) {
            try {
                if (goblin.getHealthGauge() == null) {
                    if (goblin.isVisible()) {
                        goblin.interact("Attack");
                        Execution.delay(250, Random.nextInt(400, 900));

                        if (Random.nextInt(0, 50) == 3) {
                            goblin.interact("Attack");
                            System.out.println("Clicked for 2nd time");
                            Execution.delay(399, Random.nextInt(400, 700));
                        }
                    }
                }
            } catch (NullPointerException e) {

            }
        }
    }
    public void attack34Times(String n1, String n2){
        Npc goblin = Npcs.newQuery().names(n1, n2).results().nearest();
        if (Players.getLocal().getHealthGauge() == null && !Players.getLocal().isMoving()) {
            try {
                if (goblin.getHealthGauge() == null) {
                    if (goblin.isVisible()) {
                        goblin.interact("Attack");
                        Execution.delay(250, Random.nextInt(400, 900));

                        if (Random.nextInt(0, 50) == 3) {
                            goblin.interact("Attack");
                            goblin.click();
                            System.out.println("Clicked for 2nd time");
                            Execution.delay(399, Random.nextInt(400, 700));
                        }
                    }
                }
            } catch (NullPointerException e) {

            }
        }
    }
    public void buryOneWhenNotAttacking(String name,String name1) {
        int x = Random.nextInt(0, 150);
        if (x == 2) {
            try {
                if (Players.getLocal().getHealthGauge() != null && !Players.getLocal().isMoving()) {
                    SpriteItem item = Inventory.newQuery().names(name, name1).results().random();
                    if (item != null) {
                        item.click();
                    }
                }
            }catch (NullPointerException e){

            }
        }
    }

    public void buryOneAnyTime(String name,String name1) {
        int x = Random.nextInt(0, 150);

            if(x==2){
            try {
                SpriteItem item = Inventory.newQuery().names(name, name1).results().random();
                if (item != null) {
                    item.click();
                }
                System.out.println("Burying on any time");
            }catch (NullPointerException e) {

            }
        }
    }
    public void hoverNpcNear(String name){
            if(Random.nextInt(0,1000)==2) {
               try{
                   Npcs.newQuery().names(name).results().random().hover();
               }catch (NullPointerException e){

            }

            }
    }
    public void buryBonesAllTogether(String name,String name1) {
        if(Inventory.isFull()) {
            if (!InterfaceWindows.getInventory().isOpen()) {
                InterfaceWindows.getInventory().open();
            }
           try {
               while (Inventory.contains(name) || Inventory.contains(name1)) {
                   for (SpriteItem i : Inventory.getItems(name, name1)) {
                       i.click();
                       System.out.println("Burying all of them");
                       Execution.delay(800, 1000);
                   }
               }
           }catch (NullPointerException e){

           }
            }
        }

    public void clickNearTile14() {
        if (Random.nextInt(0, 1000) == 2) {
            Coordinate destination = new Coordinate(Players.getLocal().getPosition().getX() + Random.nextInt(-4, 4), Players.getLocal().getPosition().getY()+ Random.nextInt(-4, 4), 0);
            BresenhamPath bresPath = BresenhamPath.buildTo(destination);
                if(bresPath!=null){
                bresPath.step();
                    System.out.println("Walking to near tile 14");

                }
        }
    }
    public void clickNearTile26(){
        if (Random.nextInt(0, 1000) == 2) {
            Coordinate destination = new Coordinate(Players.getLocal().getPosition().getX() + Random.nextInt(-2,6), Players.getLocal().getPosition().getY()+ Random.nextInt(-2, 6), 0);
            BresenhamPath bresPath = BresenhamPath.buildTo(destination);
            if(bresPath != null){
                bresPath.step();
                System.out.println("Walking to near tile 26");
            }
        }
    }
    public void clickNearTile37(){
        if (Random.nextInt(0, 1000) == 2) {
            Coordinate destination = new Coordinate(Players.getLocal().getPosition().getX() + Random.nextInt(-4, 7), Players.getLocal().getPosition().getY() + Random.nextInt(-4, 7), 0);
            PredefinedPath bresPath = PredefinedPath.create(destination);
            System.out.println("Near tile 37");
            if (bresPath != null) {
                bresPath.step();
                System.out.println("Walking to near tile 14");
            }
        }
    }
    public void changeCombatStyle(){


            //Interfaces.newQuery().texts("Combat Options").results().first().click();
            try {
                if (Random.nextInt(0, 1400) == 4)
                {
                    if(!OSRSTab.COMBAT_OPTIONS.isOpen()) {
                        OSRSTab.COMBAT_OPTIONS.open();
                    }
                Interfaces.newQuery().texts("Slash").results().first().click();

                }
                if(Random.nextInt(1500)==6){
                   if(!OSRSTab.COMBAT_OPTIONS.isOpen()) {
                       OSRSTab.COMBAT_OPTIONS.open();
                   }
                    Interfaces.newQuery().texts("Chop").results().first().click();
                }
                if(Random.nextInt(1700)==8){
                    if(!OSRSTab.COMBAT_OPTIONS.isOpen()) {
                        OSRSTab.COMBAT_OPTIONS.open();
                    }
                    Interfaces.newQuery().texts("Lunge").results().first().click();
                }
                if(Random.nextInt(1900)==10){
                    if(!OSRSTab.COMBAT_OPTIONS.isOpen()) {
                        OSRSTab.COMBAT_OPTIONS.open();
                    }
                    Interfaces.newQuery().texts("Block").results().first().click();
                }

            }catch(NullPointerException e){

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

    public void buryBonesAllTogether2or3Times(String name,String name1) {

        if(Inventory.isFull()) {
            if (!InterfaceWindows.getInventory().isOpen()) {
                InterfaceWindows.getInventory().open();
            }
           try{
            while (Inventory.contains(name) || Inventory.contains(name1)) {
                for (SpriteItem i : Inventory.getItems(name,name1)) {
                    i.interact("Bury");
                    Execution.delay(800, 1000);
                    if (Random.nextInt(0, 1000) == 3) {
                        Execution.delay(5000, 30000);
                    }

                }
            }
            }catch(NullPointerException e){

           }

        }
    }

    public void pickUpBones200(String name) {
        int x = Random.nextInt(0, 50);

            if (x == 2) {
                try{
                if (Players.getLocal().getHealthGauge() == null && !Players.getLocal().isMoving() && !GroundItems.newQuery().names(name).results().isEmpty()) {
                    if (newQuery().results().size() < 28) {
                        GroundItems.newQuery().names(name).results().nearest().interact("Take", name);
                        Execution.delay(Random.nextInt(120, 170), Random.nextInt(300, 800));
                        System.out.println("Picking bones");
                    }
                }
                }catch(NullPointerException e){

                }
            }
        }

    public void pickUpBones800(String name) {
            int x = Random.nextInt(0, 230);
        if (x == 2) {
              try {
                  if (Players.getLocal().getHealthGauge() == null && !Players.getLocal().isMoving() && !GroundItems.newQuery().names(name).results().isEmpty()) {
                      if (newQuery().results().size() < 28) {
                          GroundItems.newQuery().names(name).results().nearest().interact("Take", name);
                          Execution.delay(Random.nextInt(120, 150), Random.nextInt(500, 700));
                          System.out.println("Picking bones");
                      }
                  }
              }catch(NullPointerException e){

              }
            }
    }

    public void pickUpBones1200(String name) {
        int x = Random.nextInt(0, 800);
        if (x == 2) {
try {
    if (Players.getLocal().getHealthGauge() == null && GroundItems.newQuery().names(name).results().isEmpty() && !Players.getLocal().isMoving()) {
        if (newQuery().results().size() < 28) {
            GroundItems.newQuery().names(name).results().nearest().interact("Take", name);
            Execution.delay(Random.nextInt(125, 200), Random.nextInt(300, 400));
            System.out.println("Picking bones");
        }
    }
}catch(NullPointerException e){

}
        }
    }

    public void pickUpBonesWhileAttacking(String name) {
        int x = Random.nextInt(0, 230);
        if (x == 2) {
           try {
               if (!GroundItems.newQuery().names(name).results().isEmpty() && !Players.getLocal().isMoving()) {
                   if (!Inventory.isFull()) {
                       GroundItems.newQuery().names(name).results().first().interact("Take", name);
                       Execution.delay(Random.nextInt(250, 600), Random.nextInt(650, 1000));
                       System.out.println("Picking bones while attacking");
                   }
               }
           }catch(NullPointerException e){

           }
        }
    }
    public void moveCameraToNpc(Npc npc) {
        int x = Random.nextInt(0, 1000);
        if (x == 3) {
            try {
                Camera.turnTo(npc);
                System.out.println("TURNING to NPC");
            }catch(NullPointerException e){

            }
        }
    }

    public void moveCameraRandomly() {
        int x = Random.nextInt(0, 600);
        if (x == 2) {
            Camera.turnTo(Random.nextInt(0, 399));
        }
    }

    public void attackSlowly(String n1, String n2) {
        Npc goblin = Npcs.newQuery().names(n1,n2).results().random();
        try {
            if (goblin.getHealthGauge() == null && Players.getLocal().getHealthGauge() == null && !Players.getLocal().isMoving()) {
                goblin.interact("Attack");
                Execution.delay(399, 800);

            }
        }catch(NullPointerException e){

        }
        }
    public void closeXpShower(){
        Interfaces.newQuery().texts("XP drops").results().first().click();
    }
     public void sleepRandomly3045() {
            if (Random.nextInt(0, 2000) == 3) {
                Execution.delay(Random.nextInt(27000, 32000), Random.nextInt(43000, 47000));
                System.out.println("Sleeping 30 45");
            }
        }
    public void sleepRandomly4560() {
        if (Random.nextInt(0, 2000)==3) {
            Execution.delay(Random.nextInt(43000, 47000), Random.nextInt(58000, 62000));
            System.out.println("Sleeping 45 60");
        }
    }
    public void sleepRandomly6075() {
        if (Random.nextInt(0, 2000) == 2) {
            Execution.delay(Random.nextInt(58000, 62000), Random.nextInt(73000, 77000));
            System.out.println("Sleeping 60 75");
        }
    }
    public void switchToSkillsTabAndThenToInventory(){

        if(Random.nextInt(1500)==4) {
            if(!InterfaceWindows.getSkills().isOpen()) {
                InterfaceWindows.getSkills().open();

                Execution.delay(Random.nextInt(2000, 4000), 6000);
            }
            System.out.println("Switching tabs from inv to skills and then back");
            InterfaceWindows.getInventory().open();
        }
    }
    public void switchToSkillsAndKeepItThere(){
        if(Random.nextInt(1800)==4){
            if(!InterfaceWindows.getSkills().isOpen())
            InterfaceWindows.getSkills().open();
        }
    }
    public void angularCamera(){
            if (Random.nextInt(0,1000)==2) {
                Camera.turnTo(Random.nextDouble(0, 1));
            }
    }
    public void changeCameraAndAngular(){
            if(Random.nextInt(0,1000)==2) {
                Camera.turnTo(Random.nextDouble(0, 1));
                Camera.turnTo(Random.nextInt(0, 399));
            }
    }

    public static int random(int min, int max)
    {
        int difference = max-min;
        int random = Random.nextInt(0, difference);
        return (int)((double)min + Math.sqrt((double)(difference * difference - random * random)));
    }
    public static boolean isHealthDangerouslyLow()
    {
        return Health.getCurrent()<random(2,4);
    }
    public static void eat()
    {
        final SpriteItem food = newQuery().names("Lobster").results().first();
            try {
                if (Health.getCurrentPercent() < Random.nextInt(5, 30)) {
                    int x = Random.nextInt(10);
                    switch (x) {
                        case 1:
                            if (Health.getCurrentPercent() < 10) {
                                food.interact("Eat");
                                food.interact("Eat");
                                food.interact("Eat");
                            }
                            break;
                        case 2:
                            if (Health.getCurrentPercent() < 20) {
                                food.interact("Eat");
                                food.interact("Eat");
                            }
                        default:
                            food.interact("Eat");
                            break;
                    }
                }
            }catch(NullPointerException e){

            }
    }


    @Override
    public void onLoop() {

    }
}

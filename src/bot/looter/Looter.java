package bot.looter;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.GroundItem;
import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.GroundItems;
import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.LoopingBot;

import java.util.Objects;

public class Looter extends LoopingBot {


    int adamantArrow;
    int x = 0;
    boolean gotoCenter = false;
    boolean clickOnDitch = false;
    boolean travelToZafeZone = false;
    int z;
    public void setAdamantArrow(int adamantArrow) {
        this.adamantArrow = adamantArrow;
    }
    LooterAreas areas = new LooterAreas();
    LooterApi api = new LooterApi();
    private enum State {
        LOOT, BANK
    }

    @Override
    public void onStart(String... arguments) {
        Gui gui= new Gui();
        gui.gui();
        adamantArrow= gui.getX();
    }

    @Override
    public void onLoop() {
        switch (getCurrentState()) {

            case LOOT:

                if ( !areas.getBesideTheDitch().contains(Players.getLocal())&&Inventory.isEmpty() && !areas.getArea().contains(Players.getLocal())) {
                    gotoCenter = true;
                }

                if (Inventory.isEmpty() && areas.getArea().contains(Players.getLocal())) {
                    api.pickUpArrows();
                }

                SpriteItem addy = Inventory.getItems("Adamant arrow").first();
                if (addy != null) {
                    if ((addy.getQuantity() <= adamantArrow) || Inventory.isEmpty()) {

                        if (Players.getLocal().getHealthGauge() == null && !Players.getLocal().isMoving()) {
                            api.pickUpArrows();
                            travelToZafeZone = true;
                            System.out.println("Grabbing arrows");
                        }

                    }
                }

                if (gotoCenter) {
                    gotoCenter = false;
                    api.travelTo(areas.getArea());
                }

                GroundItem adamantArrowsFloor = GroundItems.newQuery().names("Adamant arrow").results().nearest();
                SpriteItem addy1 = Inventory.getItems("Adamant arrow").first();
                if (addy1 != null && areas.getBesideTheDitch()!=null && adamantArrowsFloor!=null) {
                    if (areas.getArea().isReachable()&&!areas.getBesideTheDitch().contains(Players.getLocal())&&adamantArrowsFloor.distanceTo(Players.getLocal()) > 6 && Objects.requireNonNull(Players.getLocal()).getHealthGauge() == null && !areas.getArea().contains(Players.getLocal()) && addy1.getQuantity() < adamantArrow) {

                        api.travelTo(areas.getArea());
                    }
                }
                if (Players.getLocal().getHealthGauge() != null) {
                    try {
                        api.travelTo(areas.getSafeArea());
                    } catch (NullPointerException e) {
                        System.out.println("Excepcion on running");
                    }
                }

                if (Players.getLocal().getHealthGauge() != null) {
                    if (areas.getSafeArea().contains(Players.getLocal()) && Players.getLocal().getHealthGauge().getPercent() < 50) {
                        Execution.delay(40000, 60000);
                    }
                }

                if (Inventory.isEmpty() && !areas.getBesideTheDitch().contains(Players.getLocal()) && !areas.getArea().isReachable()) {
                    api.travelTo(areas.getBesideTheDitch());
                }

                if (Inventory.isEmpty() && areas.getBesideTheDitch().contains(Players.getLocal())) {
                    clickOnDitch = true;
                }

                GameObject wildernessDitch2 = GameObjects.newQuery().names("Wilderness Ditch").results().nearest();
                if (clickOnDitch && Inventory.isEmpty() && !areas.getSafeArea().contains(Players.getLocal())) {
                    if (wildernessDitch2 != null) {
                        wildernessDitch2.interact("Cross");
                        Execution.delay(2000, 3000);
                    }
                }
                if (Inventory.isEmpty() && areas.getSafeArea().contains(Players.getLocal())) {
                    clickOnDitch = false;
                    api.travelTo(areas.getArea());
                }
                break;
            case BANK:

                System.out.println("Bank + "+adamantArrow);
                if (Inventory.getItems("Adamant arrow").first() != null) {
                    if (travelToZafeZone && !areas.getSafeArea().contains(Players.getLocal()) && Inventory.getItems("Adamant arrow").first().getQuantity() >= adamantArrow) {
                        api.travelTo(areas.getSafeArea());
                        if (areas.getBesideTheDitch().contains(Players.getLocal())) {
                            travelToZafeZone = false;
                        }
                    }
                }

                if (areas.getBesideTheDitch().contains(Players.getLocal()) || areas.getBankArea().contains(Players.getLocal())) {
                    travelToZafeZone = false;
                }
                GameObject wildernessDitch = GameObjects.newQuery().names("Wilderness Ditch").results().nearest();
                if (wildernessDitch != null && areas.getSafeArea().contains(Players.getLocal()) && Inventory.getItems("Adamant arrow").first().getQuantity() >= adamantArrow) {
                    clickOnDitch = true;
                    travelToZafeZone = false;

                    if (Players.getLocal().getAnimationId() == -1 && !areas.getBankArea().isReachable() && clickOnDitch) {
                        wildernessDitch.interact("Cross");
                        Execution.delay(1000, 1500);
                        clickOnDitch = false;
                        System.out.println("clicking wilderness ditch");
                    }
                }

                if (Npcs.newQuery().names("Banker").results().isEmpty() && areas.getBankArea().isReachable() && Inventory.getItems("Adamant arrow").first().getQuantity() >= adamantArrow) {
                    api.travelTo(areas.getBankArea());
                }

                Npc bank = Npcs.newQuery().names("Banker").results().nearest();
                if (bank != null) {
                    if (!areas.getBankArea().contains(Players.getLocal()) && !Inventory.isEmpty() && !Npcs.newQuery().names("Banker").results().isEmpty() && !Players.getLocal().isMoving()) {
                        BresenhamPath pathtobank = BresenhamPath.buildTo(bank);
                        pathtobank.step(true);
                    }
                    if (!Inventory.isEmpty()) {
                        bank.interact("Bank");
                        Execution.delay(1000, 2000);
                        Bank.depositAllExcept(0);
                        clickOnDitch = true;
                    }
                }

                break;

        }
    }

    private State getCurrentState() {

        //Players.getLocal().getAnimationId() == -1 && !Players.getLocal().isMoving()
        try {
            z = Inventory.getItems("Adamant arrow").first().getQuantity();
        }catch (NullPointerException e){

        }

                if (Inventory.isEmpty() ||  z<= adamantArrow) {
                    return State.LOOT;

                }
            else {
                    return State.BANK;
                }

    }
}






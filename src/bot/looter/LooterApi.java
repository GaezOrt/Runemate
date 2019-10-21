package bot.looter;

import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.location.navigation.basic.PredefinedPath;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.region.GroundItems;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;

public class LooterApi {


    LooterAreas areas= new LooterAreas();
    private boolean travelFromLumbB=false;

    public void pickUpArrows(){
        try {
            GroundItems.newQuery().names("Adamant arrow").results().nearest().interact("Take");
            Execution.delay(500, 1000);
        }catch (NullPointerException e){

        }
    }
    public void travelTo(Area area) {
        try {
            Coordinate destination = area.getRandomCoordinate();
            BresenhamPath pathToSafeZone = BresenhamPath.buildTo(destination);
            System.out.println("Going to safe zone, amount of arrows designed");
            pathToSafeZone.step(true);
        }catch (NullPointerException e){

        }
    }

    public void walkBackFromLumb(){
        if(areas.getLumbArea().contains(Players.getLocal())){
            travelFromLumbB=true;
        }
        if(travelFromLumbB) {
            PredefinedPath.create(areas.getPathCoords()).step();
            }

        if(areas.getBesideTheDitch().contains(Players.getLocal())){
            travelFromLumbB=false;
        }

    }
}

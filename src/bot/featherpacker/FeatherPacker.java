package bot.featherpacker;

import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.hybrid.local.hud.interfaces.*;
import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.LoopingBot;

import java.util.Random;

/**
 * Created by Gaston on 30/12/2018.
 */
public class FeatherPacker extends LoopingBot
{

    private enum State
    {
        PACK,BUYER,NOTHING
    }
    @Override
    public void onStart(String... args)
    {
        System.out.println("Start");


    }

    @Override
    public void onLoop()
    {
        switch (getCurrentState())
        {
            case PACK:
                if(Shop.isOpen())
                {
                    Shop.close();
                }
                getLogger().warn("Packer!");
                Random random=new Random();
            int z = random.nextInt(5);
            switch (z)
            {

                case 1:
                    if (Inventory.getQuantity(11881) >= 1)
                    {
                        Inventory.getItems(11881).first().interact("Open");
                        Execution.delayUntil(()->Inventory.getQuantity(11881)==0,1000,13000);
                        System.out.println("Opening feathers");
                    }
                    break;
                case 3:
                    if (Inventory.getQuantity(11881) >= 1)
                    {
                        Inventory.getItems(11881).first().interact("Open");
                        Execution.delayUntil(() -> Inventory.getQuantity(11881) == 0, 1000, 20000);
                    }
                    break;

                case 4:
                    if (Inventory.getQuantity(11881) >= 1)
                    {
                        Inventory.getItems(11881).first().interact("Open");
                        Execution.delayUntil(() -> Inventory.getQuantity(11881) == 0, 0, 5000);
                    }
                    break;

            }


            case BUYER:

                getLogger().warn("Buyer");
                if(Inventory.getQuantity(11881)==0)
                {
                    Npc npc = Npcs.newQuery().names("Gerrant").results().nearest();
                    System.out.println("Buying feathers");
                    npc.interact("Trade");
                    if (Shop.isOpen())
                    {
                        Shop.buy(11881, 50);
                    }
                }
                if(Shop.isOpen() && Inventory.getQuantity()==28)
                {
                    System.out.println("Closing shop");
                    Shop.close();
                }


        }
    }

            @Override
    public void onStop()
            {
    }

    private State getCurrentState() {
        //Players.getLocal().getAnimationId() == -1 && !Players.getLocal().isMoving()
        if (Inventory.getQuantity(11881)>0)
        {

            System.out.println("Pack");
                return State.PACK;
        } else if(Inventory.getQuantity(11881)==0)
        {
            return State.BUYER;
        }else
            {
            return State.NOTHING;
        }
    }


}

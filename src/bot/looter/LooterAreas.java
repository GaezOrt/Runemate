package bot.looter;

import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import org.omg.CORBA.WCharSeqHelper;

public class LooterAreas {
    private Area lumbArea= new Area.Rectangular(new Coordinate(3218,3221),new Coordinate(3226,3213));
    private Area area= new Area.Rectangular(new Coordinate(3083,3538,0),new Coordinate(3096,3530,0));
    private Area safeArea= new Area.Rectangular(new Coordinate(3087,3525,0),new Coordinate(3097,3523,0));
    private Area bankArea= new Area.Rectangular(new Coordinate(3091,3498),new Coordinate(3099,3487));
    private Area BesideTheDitch= new Area.Rectangular(new Coordinate(3078,3521), new Coordinate(3115,3515));
    private final Coordinate[] pathCoords = {new Coordinate(3230,3219), new Coordinate(3235,3224), new Coordinate(3243,3225),new Coordinate(3251,3226), new Coordinate(3255,3236), new Coordinate(3253,3245), new Coordinate(3250,3255), new Coordinate(3248,3265), new Coordinate(3241,3275), new Coordinate(3239,3285), new Coordinate(3238,3294), new Coordinate(3235,3305), new Coordinate(3226,3310), new Coordinate(3224,3320), new Coordinate(3218,3327), new Coordinate(3210,3334), new Coordinate(3203,3344), new Coordinate(3203,3352) , new Coordinate(3202,3360), new Coordinate(3200,3369), new Coordinate(3190,3372), new Coordinate(3184,3376), new Coordinate(3177,3383), new Coordinate(3171,3390), new Coordinate(3164,3395), new Coordinate(3156,3399), new Coordinate(3147,3400), new Coordinate(3140,3406),new Coordinate(3132,3409), new Coordinate(3121,3412), new Coordinate(3114,3416),new Coordinate(3105,3420), new Coordinate(3102,3427), new Coordinate(3101,3438), new Coordinate(3099,3449), new Coordinate(3092,3454), new Coordinate(3087,3459), new Coordinate(3093,3463), new Coordinate(3099,3471), new Coordinate(3099,3479), new Coordinate(3096,3484), new Coordinate(3093,3491), new Coordinate(3093,3497), new Coordinate(3089,3504), new Coordinate(3087,3512), new Coordinate(3088,3519)};


    public Coordinate[] getPathCoords() {
        return pathCoords;
    }


    public Area getLumbArea() {
        return lumbArea;
    }



    public Area getArea() {
        return area;
    }

    public Area getSafeArea() {
        return safeArea;
    }

    public Area getBankArea() {
        return bankArea;
    }

    public Area getBesideTheDitch() {
        return BesideTheDitch;
    }
}

import java.awt.*;

public class Volvo240 extends Cars{

    private final static double trimFactor = 1.25;

    public Volvo240() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
        y = 0;
        x = 0;
        carLength = 4.8;
    }
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
    }





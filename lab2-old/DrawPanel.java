import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawPanel extends JPanel {
    private static DrawPanel instance;

    private DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
    }
    public static DrawPanel getInstance() {
        if (instance == null) {
            instance = new DrawPanel(800,800-240);
        }
        return instance;
    }


    // The controller member
    protected JPanel controlPanel = new JPanel();
    protected JPanel gasPanel = new JPanel();
    protected JSpinner gasSpinner = new JSpinner();
    protected int gasAmount = 0;
    protected JLabel gasLabel = new JLabel("Amount of gas");
    protected JButton gasButton = new JButton("Gas");
    protected JButton brakeButton = new JButton("Brake");
    protected JButton turboOnButton = new JButton("Saab Turbo on");
    protected JButton turboOffButton = new JButton("Saab Turbo off");
    protected JButton liftBedButton = new JButton("Scania Lift Bed");
    protected JButton lowerBedButton = new JButton("Lower Lift Bed");
    protected JButton startButton = new JButton("Start all cars");
    protected JButton stopButton = new JButton("Stop all cars");
    JButton addCarButton = new JButton("Add");
    JButton removeCarButton = new JButton("Remove");
    // Constructor

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work


        protected CarInWorld carWorld = CarInWorld.getInstance();
        BufferedImage carImage;

    public DrawPanel() {

    }


    @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            for (Cars car : carWorld.cars) {
                try {
                    carImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + car.modelName + ".jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                g.drawImage(carImage, (int) car.getX(), (int) car.getY(), null);
            }
        }
    }


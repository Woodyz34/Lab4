import javax.swing.*;
import java.awt.*;

public class InitComponents extends JFrame{
    DrawPanel drawPanel = DrawPanel.getInstance();
    private static final int X = 800;
    private static final int Y = 800;
    protected void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        drawPanel.gasSpinner = new JSpinner(spinnerModel);
        drawPanel.gasPanel.setLayout(new BorderLayout());
        drawPanel.gasPanel.add(drawPanel.gasLabel, BorderLayout.PAGE_START);
        drawPanel.gasPanel.add(drawPanel.gasSpinner, BorderLayout.PAGE_END);
        this.add(drawPanel.gasPanel);
        drawPanel.controlPanel.setLayout(new GridLayout(2, 4));
        drawPanel.controlPanel.add(drawPanel.gasButton, 0);
        drawPanel.controlPanel.add(drawPanel.turboOnButton, 1);
        drawPanel.controlPanel.add(drawPanel.liftBedButton, 2);
        drawPanel.controlPanel.add(drawPanel.brakeButton, 3);
        drawPanel.controlPanel.add(drawPanel.turboOffButton, 4);
        drawPanel.controlPanel.add(drawPanel.lowerBedButton, 5);
        drawPanel.controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(drawPanel.controlPanel);
        drawPanel.controlPanel.setBackground(Color.CYAN);
        drawPanel.startButton.setBackground(Color.blue);
        drawPanel.startButton.setForeground(Color.green);
        drawPanel.startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(drawPanel.startButton);
        drawPanel.stopButton.setBackground(Color.red);
        drawPanel.stopButton.setForeground(Color.black);
        drawPanel.stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(drawPanel.stopButton);
        drawPanel.controlPanel.add(drawPanel.addCarButton, 3);
        drawPanel.controlPanel.add(drawPanel.removeCarButton, 7);
        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary

        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

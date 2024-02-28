import javax.swing.*;
import java.awt.*;

public class DrawShape extends JPanel {
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int y = 50;
        for (int i = 0; i < 10; i++) {
            g2d.drawLine(50, y, 250, y);
            y += 20;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ten Lines");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.add(new DrawShape());
            frame.setVisible(true);
        });
    }
}

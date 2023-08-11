package hcl;
import javax.swing.*;
import java.awt.*;

public class 心脏3 extends JFrame {

    private 心脏3() {
        setTitle("送给陈晓璇");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        JumpingHeartPanel panel = new JumpingHeartPanel();
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(心脏3::new);
    }
}

class JumpingHeartPanel extends JPanel {
    private int size = 200;
    private int delay = 10;
    private int x = 200;
    private int y = 200;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.RED);

        Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);

        int[] xPoints = {x, x + size / 4, x - size / 4};
        int[] yPoints = {y + size / 4, y + size / 2, y + size / 2};
        g2d.drawPolygon(xPoints, yPoints, 3);
        g2d.fillArc(x - size / 2, y - size / 4, size / 2, size / 2, 0, 180);
        g2d.fillArc(x, y - size / 4, size / 2, size / 2, 0, 180);

        g2d.dispose();
    }

    public JumpingHeartPanel() {
        Thread animationThread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(delay);
                    x += 1;
                    y += Math.sin(Math.toRadians(x / 2));
                    repaint();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        animationThread.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}


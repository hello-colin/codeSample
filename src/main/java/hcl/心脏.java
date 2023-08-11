package hcl;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class 心脏 extends JPanel {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private double angle = 0;
    private double scale = 1.0;

    public 心脏() {
        Timer timer = new Timer(50, e -> {
            angle += 0.1;
            scale = 1.0 + 0.1 * Math.sin(angle);
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // 绘制心形曲线
        Path2D path = new Path2D.Double();
        path.moveTo(centerX, centerY - 5);
        path.curveTo(centerX + 70, centerY - 120, centerX + 160, centerY + 80, centerX, centerY + 180);
        path.curveTo(centerX - 160, centerY + 80, centerX - 70, centerY - 120, centerX, centerY - 5);

        // 缩放心形曲线
        g2d.scale(scale, scale);

        // 填充心形曲线
        g2d.setColor(Color.RED);
        g2d.fill(path);

        // 设置线宽，绘制边框
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.BLACK);
        g2d.draw(path);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Jumping Heart");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new 心脏());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

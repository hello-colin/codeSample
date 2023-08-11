import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class DynamicHeart extends JPanel {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final String MESSAGE = "送给陈晓璇";
    private static final int MESSAGE_Y_OFFSET = 60;

    private double scale = 1.0;
    private boolean expanding = true;

    public DynamicHeart() {
        Timer timer = new Timer(50, e -> {
            if (expanding) {
                scale += 0.02;
                if (scale >= 1.5) {
                    expanding = false;
                }
            } else {
                scale -= 0.02;
                if (scale <= 1.0) {
                    expanding = true;
                }
            }
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
        g2d.translate(centerX, centerY);
        g2d.scale(scale, scale);
        g2d.translate(-centerX, -centerY);

        // 填充心形曲线
        g2d.setColor(Color.RED);
        g2d.fill(path);

        // 设置线宽，绘制边框
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.BLACK);
        g2d.draw(path);

        // 画文字
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("微软雅黑", Font.BOLD, 24)); // 使用微软雅黑字体显示中文
        FontMetrics fontMetrics = g2d.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(MESSAGE);
        int textX = centerX - textWidth / 2;
        int textY = centerY - MESSAGE_Y_OFFSET;
        g2d.drawString(MESSAGE, textX, textY);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Dynamic Heart");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new DynamicHeart());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

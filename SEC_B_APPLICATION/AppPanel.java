import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class AppPanel extends JPanel {

    static BufferedImage bufferImage;
    Timer timer;
    int xAxis = 0;
    int yAxis = 0;
    int dx = 5, dy = 5;

    AppPanel() {
        setSize(500, 500);
        // setBackground(Color.CYAN);
        showBgImage();
        recallPaintComp();
    }

    static void showBgImage() {
        try {
            bufferImage = ImageIO.read(AppPanel.class.getResource("download.jpeg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("NO IMAGE FOUND");
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.drawImage(bufferImage, xAxis, yAxis, 50, 50, null);
    }

    void recallPaintComp() {
        timer = new Timer(30, (abcd) -> {

            xAxis += dx;
            yAxis += dy;

            if (xAxis <= 0 || xAxis >= getWidth() - 50) {
                dx = -dx;
            }
            if (yAxis <= 0 || yAxis >= getHeight() - 50) {
                dy = -dy;
            }

            repaint();
        });
        timer.start();
    }
}

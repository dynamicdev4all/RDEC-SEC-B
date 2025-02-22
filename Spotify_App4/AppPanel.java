import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AppPanel extends JPanel {
    Timer timer;

    BufferedImage songImage;

    JButton playPauseButton;
    JButton nextSongButton;
    JButton previousSongButton;

    ArrayList<SongModel> songList = ApiClient.getSongList();

    AppPanel() {
        setSize(500, 500);
        setBackground(Color.DARK_GRAY);
        playPauseButton = new JButton("Play/Pause");
        nextSongButton = new JButton("Next");
        previousSongButton = new JButton("Previous");
        add(playPauseButton);
        add(nextSongButton);
        add(previousSongButton);
        loadImage();
        appLoop();
        setFocusable(true);
    }

    void loadImage() {
        try {
            songImage = ImageIO.read(new URL(songList.get(0).songImageUrl));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void appLoop() {
        timer = new Timer(80, (abc) -> {
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        pen.setColor(Color.MAGENTA);
        pen.setFont(new Font("Arial", Font.ITALIC, 25));
        pen.drawString(songList.get(0).songName, 180, 320);
        pen.drawString(songList.get(0).singerName, 180, 340);
        pen.drawImage(songImage, 150, 100, 200, 200, null);
    }
}

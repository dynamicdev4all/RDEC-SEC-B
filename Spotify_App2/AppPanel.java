import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    int currentSongIndex = 0;
    JButton playPauseButton;
    JButton nextSongButton;
    JButton previousSongButton;

    BufferedImage songPhoto;

    ApiClient client = new ApiClient();

    ArrayList<SongModel> songList = ApiClient.getSongList();

    AppPanel() {
        setSize(500, 500);
        playPauseButton = new JButton("Play/Pause");
        nextSongButton = new JButton("Next");
        previousSongButton = new JButton("Previous");
        add(playPauseButton);
        add(nextSongButton);
        add(previousSongButton);
        loadPhoto();
        buttonControls();
        appLoop();
        setFocusable(true);
    }

    void buttonControls() {
        nextSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSongIndex++;
                loadPhoto();
            }
        });
        previousSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSongIndex--;
                loadPhoto();
            }
        });
    }

    void loadPhoto() {
        try {
            songPhoto = ImageIO.read(new URL(
                    songList.get(currentSongIndex).songImageUrl));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void appLoop() {
        timer = new Timer(80, (abc) -> {
            System.out.println("reapaint done");
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        pen.setColor(Color.RED);
        pen.setFont(new Font("Arial", Font.BOLD, 25));
        pen.drawString(songList.get(currentSongIndex).songName, 120, 330);
        pen.drawString(songList.get(currentSongIndex).singerName, 150, 380);
        pen.drawImage(songPhoto, 150, 100, 200, 200, null);
    }
}

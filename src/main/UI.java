package main;

import object.Chest;
import object.Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Font tnr_40, tnr_80B;
    BufferedImage keyImage, chestImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameOver = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;
        tnr_40 = new Font("Times New Roman", Font.PLAIN, 40);
        tnr_80B = new Font("Times New Roman", Font.BOLD, 80);
        Key key = new Key();
        keyImage = key.image;
        Chest chest = new Chest();
        chestImage = chest.image;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        if (gameOver == true) {
            g2.setFont(tnr_40);
            g2.setColor(Color.white);
            String text;
            int textLength;
            int x, y;
            text = "Jackpot! You found Gold and Diamonds!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            if(gp.player.chestCounter == 3) {
                x = gp.screenWidth / 2 - textLength/2;
                y = gp.screenHeight / 2 - (gp.tileSize*3);
                g2.drawString(text, x, y);

                text = "Your time is " + dFormat.format(playTime) + "!";
                x = gp.screenWidth / 2 - textLength/2;
                y = gp.screenHeight / 2 + (gp.tileSize*4);
                g2.drawString(text, x, y);

                g2.setFont(tnr_80B);
                g2.setColor(Color.yellow);
                text = "Congratulations!";
                x = gp.screenWidth / 2 - textLength/2;
                y = gp.screenHeight / 2 + (gp.tileSize*2);
                g2.drawString(text, x, y);

                gp.gameThread = null;

            }

        } else {
            g2.setFont(tnr_40);
            g2.setColor(Color.white);

            // KEY
            g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.hasKey, 72, 60);

            // CHEST
            g2.drawImage(chestImage, gp.tileSize / 2, gp.tileSize * 2, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.chestCounter, 80, 140);

            // TIME
            playTime += (double)1/60;
            g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize*12, gp.tileSize*11);

            // MESSAGE
            if (messageOn == true) {
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);
                messageCounter++;

                if (messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }

        }
    }
}

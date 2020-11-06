package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {

    Point lastp = new Point(0,0);

    public DrawPanel() {
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                lastp = mouseEvent.getPoint();
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        int dx = lastp.x - getWidth()/2;
        int dy = lastp.y - getHeight()/2;
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics gr = bi.createGraphics();
        gr.setColor(Color.WHITE);
        gr.fillRect(0, 0, getWidth(), getHeight());
        PixelDrawer pd = new PixelDrawer() {
            @Override
            public void drawPixel(int x, int y, Color c) {
                gr.setColor(c);
                gr.fillRect(x, y, 1, 1);
            }
        };//new BufferdImagePixelDrawer(bi);
        LineDrawer ld = new DDALineDrawer(pd);
        ScrinPoint a = new ScrinPoint(100, 100);
        ScrinPoint b = new ScrinPoint(200+dx, 200+dy);
        ld.drawLine(a,b);

        LineDrawer bd = new BresenhamLineDrawer(pd);
        ScrinPoint c = new ScrinPoint(300, 300);
        ScrinPoint d = new ScrinPoint(400+dx, 400+dy);
        bd.drawLine(c,d);

        LineDrawer vu = new VuLineDrawer(pd);
        ScrinPoint e = new ScrinPoint(450, 450);
        ScrinPoint f = new ScrinPoint(550+dx, 550+dy);
        vu.drawLine(e,f);
        g.drawImage(bi, 0,0, null);
        gr.dispose();
    }
}
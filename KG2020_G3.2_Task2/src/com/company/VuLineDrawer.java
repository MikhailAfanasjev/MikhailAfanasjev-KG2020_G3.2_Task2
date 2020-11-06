package com.company;
import java.awt.*;

public class VuLineDrawer implements LineDrawer {

    private PixelDrawer pd;
    public VuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }
    private float fractionalPart(float x) {
        int tmp = (int) x;
        return x - tmp;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {

    }

    @Override
    public void drawLine(ScrinPoint p1, ScrinPoint p2) {
        /*int x1, x2 ,y1, y2;
        x1 =p1.getX();
        x2 =p2.getX();
        y1 =p1.getY();
        y2 =p2.getY();

            if (x2 < x1) {
                x1 += x2;
                x2 = x1 - x2;
                x1 -= x2;
                y1 += y2;
                y2 = y1 - y2;
                y1 -= y2;
            }
            int dx = x2 - x1;
            int dy = y2 - y1;

            if (dx == 0 || dy == 0) {

                pd.drawPixel ( x1, y1, Color.BLUE);
                return;
            }
            float gradient;
            if (dx > dy) {
                gradient = (float) dy / dx;
                float intery = y1 + gradient;
                pd.drawPixel(x1, y1, Color.BLACK);
                for (int x = x1; x < x2; ++x) {
                    pd.drawPixel(x, (int)intery, Color.BLACK);
                    pd.drawPixel(x, (int)intery + 1, Color.BLACK);
                    intery += gradient;
                }

                pd.drawPixel(x2, y2, Color.BLACK);
            }
            else {
                gradient = (float) dx / dy;
                float interx = x1 + gradient;

                pd.drawPixel(x1, y1, Color.BLACK);
                for (int y = y1; y < y2; ++y) {
                    pd.drawPixel((int)interx, y, Color.BLACK);
                    pd.drawPixel((int)interx + 1, y, Color.BLACK);
                    interx += gradient;



                }*/
        Color color = Color.BLUE;
        int x1, x2 ,y1, y2;
        x1 =p1.getX();
        x2 =p2.getX();
        y1 =p1.getY();
        y2 =p2.getY();
        int dx = x2 - x1;
        int dy = y2 - y1;
        int absDx = Math.abs(dx);
        int absDy = Math.abs(dy);
        int red = color.getRed();
        int blue = color.getBlue();
        int green = color.getGreen();

        float gradient;
        if (absDx > absDy) {
            if (x1 > x2) {
                x1 = swap(x2, x2 = x1);
                y1 = swap(y2, y2 = y1);
            }
            gradient = (float) dy / dx;
            float interY = y1;
            pd.drawPixel(x1, y1, color);
            for (int x = x1; x < x2; x++) {
                int alpha = (int) Math.abs(255 - fractionalPart(interY) * 255);
                int invertedAlpha = (int) Math.abs(fractionalPart(interY) * 255);
                Color color1 = new Color(red, green, blue, alpha);
                Color color2 = new Color(red, green, blue, invertedAlpha);
                pd.drawPixel(x, (int)interY, color1);
                pd.drawPixel(x, (int)interY + 1, color2);
                interY += gradient;
            }
        }
        else {
            if (y1 > y2) {
                x1 = swap(x2, x2 = x1);
                y1 = swap(y2, y2 = y1);
            }
            gradient = (float) dx / dy;
            float interX = x1;
            pd.drawPixel(x1, y1, color);
            for (int y = y1; y < y2; y++) {
                int alpha = (int) (255 - fractionalPart(interX) * 255);
                int invertedAlpha = (int) (fractionalPart(interX) * 255);
                Color color1 = new Color(red, green, blue, alpha);
                Color color2 = new Color(red, green, blue, invertedAlpha);
                pd.drawPixel((int)interX, y, color1);
                pd.drawPixel((int)interX + 1, y, color2);
                interX += gradient;
            }
        }
        pd.drawPixel(x2, y2, color);

            }
    }


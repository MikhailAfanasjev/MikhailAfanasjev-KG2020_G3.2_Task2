package com.company;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {
    private PixelDrawer pd;
    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }
    private int sign (int x) {
        return (x > 0) ? 1 : (x < 0) ? -1 : 0;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {

    }

    @Override
    public void drawLine(ScrinPoint p1, ScrinPoint p2) {
       Graphics2D g = null;
        int x, y, dx, dy, incx, incy, pdx, pdy, es, el, err;
        dx = p2.getX() - p1.getX();//проекция на ось икс
        dy = p2.getY() - p1.getY();//проекция на ось игрек

        incx = sign(dx);

        incy = sign(dy);

        if (dx < 0) dx = -dx;
        if (dy < 0) dy = -dy;

        if (dx > dy)
        {
            pdx = incx;	pdy = 0;
            es = dy;	el = dx;
        }
        else
        {
            pdx = 0;	pdy = incy;
            es = dx;	el = dy;
        }
        x = p1.getX();
        y = p1.getX();
        err = el/2;
        pd.drawPixel (x, y, Color.DARK_GRAY);

        for (int t = 0; t < el; t++)
        {
            err -= es;
            if (err < 0)
            {
                err += el;
                x += incx;
                y += incy;
            }
            else
            {
                x += pdx;
                y += pdy;
            }

            pd.drawPixel (x, y, Color.BLUE);
    }
    }
}

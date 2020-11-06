package com.company;

import java.awt.*;

public interface LineDrawer {
    void drawLine(int x1, int y1, int x2, int y2, Color color);

    default int countStep(int delta) {
        return (delta > 0) ? 1 : -1;
    }

    void drawLine (ScrinPoint p1, ScrinPoint p2);
    default int swap(int first, int second) {
        return first;
    }
}

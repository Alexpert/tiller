package utils;

import javafx.scene.paint.Color;
import model.Tile;

import java.util.Random;

import static java.lang.Math.*;

public class WorldBuilder {
    public static Tile[][] generate(int width, int height) {
        Tile tiles[][] = new Tile[width][height];
        double heightMap[][] = new double[width][height];
        Random random = new Random();

        heightMap[0][0] = random.nextDouble();
        heightMap[width - 1][0] = random.nextDouble();
        heightMap[0][height - 1] = random.nextDouble();
        heightMap[width - 1][height - 1] = random.nextDouble();

        generateLine(heightMap, 0, 0, width - 1, 0);
        generateLine(heightMap, width - 1, 0, width - 1, height - 1);
        generateLine(heightMap, 0, height - 1, width - 1, height - 1);
        generateLine(heightMap, 0, 0, 0, height - 1);

        generateRectangle(heightMap, 0, 0, width - 1, height - 1);



        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (heightMap[x][y] < 0.3) {
                    tiles[x][y] = new Tile(Color.BLUE);
                } else if (heightMap[x][y] < 0.5) {
                    tiles[x][y] = new Tile(Color.YELLOW);
                } else if (heightMap[x][y] < 0.8) {
                    tiles[x][y] = new Tile(Color.GREEN);
                } else {
                    tiles[x][y] = new Tile(Color.GRAY);
                }
            }
        }

        return tiles;
    }

    private static void generateRectangle(double[][] heightMap, int x1, int y1, int x2, int y2) {
        if (x1 + 1 >= x2 && y1 + 1 >= y2)
            return;
        generateMiddlePoint(heightMap, x1, y1, x2, y1, x2, y2, x1, y2);

        generateLine(heightMap, x1, y1 + (y2 - y1) / 2, x1 + (x2 - x1) / 2, y1 + (y2 - y1) / 2);
        generateLine(heightMap,x1 + (x2 - x1) / 2, y1 + (y2 - y1) / 2, x2, y1 + (y2 - y1) / 2);
        generateLine(heightMap, x1 + (x2 - x1) / 2, y1, x1 + (x2 - x1) / 2, y1 + (y2 - y1) / 2);
        generateLine(heightMap,x1 + (x2 - x1) / 2, y1 + (y2 - y1) / 2, x1 + (x2 - x1) / 2, y2);

        generateRectangle(heightMap, x1, y1,x1 + (x2 - x1) / 2, y1 + (y2 - y1) / 2);
        generateRectangle(heightMap, x1 + (x2 - x1) / 2, y1, x2,y1 + (y2 - y1) / 2);
        generateRectangle(heightMap, x1, y1 + (y2 - y1) / 2,x1 + (x2 - x1) / 2, y2);
        generateRectangle(heightMap, x1 + (x2 - x1) / 2,y1 + (y2 - y1) / 2, x2, y2);
    }

    private static void generateLine(double[][] heightMap, int x1, int y1, int x2, int y2) {
        if (x1 + 1 >= x2 && y1 + 1 >= y2)
            return;

        generateMiddlePoint(heightMap, x1, y1, x2, y2);
        generateLine(heightMap, x1, y1, x1 + (x2 - x1) / 2, y1 + (y2 - y1) / 2);
        generateLine(heightMap, x1 + (x2 - x1) / 2, y1 + (y2 - y1) / 2, x2, y2);
    }

    private static void generateMiddlePoint(double[][] heightMap, int x1, int y1, int x2, int y2) {
        double dist = sqrt((x2 - x1)^2 + (y2 - y1)^2);
        heightMap[x1 + (x2 - x1) / 2][y1 + (y2 - y1) / 2] = (heightMap[x1][y1] + heightMap[x2][y2]) / 2
                + (new Random().nextDouble() - 0.5) * min(1, dist / 256);
    }

    private static void generateMiddlePoint(double[][] heightMap, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        double dist = (sqrt((x3 - x1)^2 + (y3 - y1)^2) + sqrt((x2 - x4)^2 + (y4 - y2)^2)) / 2;
        heightMap[x1 + (x3 - x1) / 2][y1 + (y3 - y1) / 2] =
                (heightMap[x1][y1] + heightMap[x2][y2] + heightMap[x3][y3] + heightMap[x4][y4]) / 4
                + (new Random().nextDouble() - 0.5) * min(1, dist / 75);
    }
}

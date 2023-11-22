package br.dev.brunoxkk0.pmt;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PixelMapperTool {

    public static void main(String[] args) throws IOException {

        // File file = new File("..."); A pixel art image with a density of 32 pixels per pixel
        // File file2 = new File("...");

        // new PixelMapperTool().process(32, 224, 1312, file, file2);
    }

    public void process(int bigPixel, int height, int width, File source, File target) throws IOException {

        int scaledWidth = width / bigPixel;
        int scaledHeight = height / bigPixel;

        BufferedImage bufferedImage = ImageIO.read(source);
        BufferedImage buffered = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);

        int[][] data = new int[scaledHeight][scaledWidth];

        for(int h = 0; h < height; h += bigPixel)
            for (int w = 0; w < width; w += bigPixel)
                data[h / bigPixel][w / bigPixel] = bufferedImage.getRGB(w, h);


        for(int h = 0; h < data.length; h++)
            for(int w = 0; w < data[h].length; w++)
                buffered.setRGB(w, h, data[h][w]);

        ImageIO.write(buffered, "png", target);
    }

}

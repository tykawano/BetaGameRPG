package Utils;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Tools {
    public BufferedImage flipHorizontally(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage flippedImage = new BufferedImage(width, height, image.getType());

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                flippedImage.setRGB(width - x - 1, y, image.getRGB(x, y));
            }
        }

        return flippedImage;
    }

    public BufferedImage rotateClockwise90Degrees(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        BufferedImage rotatedImage = new BufferedImage(height, width, originalImage.getType());
        Graphics2D g2d = rotatedImage.createGraphics();

        AffineTransform transform = new AffineTransform();
        transform.translate(height, 0);
        transform.rotate(Math.PI / 2);

        g2d.setTransform(transform);
        g2d.drawImage(originalImage, 0, 0, null);
        g2d.dispose();

        return rotatedImage;
    }
    public BufferedImage flipVertically(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        BufferedImage flippedImage = new BufferedImage(width, height, originalImage.getType());
        Graphics2D g2d = flippedImage.createGraphics();

        // Flip the image vertically
        g2d.drawImage(originalImage, 0, height, width, -height, null);
        g2d.dispose();

        return flippedImage;
    }

    public BufferedImage scaleImage(BufferedImage original, int width, int height){
        BufferedImage scaledImage = new BufferedImage(width, height, original.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original,0,0,width,height,null);
        g2.dispose();

        return scaledImage;
    }

    public BufferedImage changeImageOpacity(BufferedImage originalImage, float opacity) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resultImage.createGraphics();

        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
        g2d.setComposite(alphaComposite);

        g2d.drawImage(originalImage, 0, 0, null);

        g2d.dispose();

        return resultImage;
    }

    public BufferedImage setTextureSubImage(BufferedImage originalImage, int x,int y, int width, int height){
        BufferedImage scaledImage;
        originalImage = originalImage.getSubimage(x,y,width,height);
        scaledImage = scaleImage(originalImage,width*2,height*2);

        return scaledImage;
    }


}

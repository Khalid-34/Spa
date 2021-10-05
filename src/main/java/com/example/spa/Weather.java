package com.example.spa;



import java.util.logging.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.*;

public class Weather {

    private final static Logger LOGGER = Logger.getLogger(Weather.class.getName());

    public URL cats() throws IOException {
        URL url = new URL("https://purr.objects-us-east-1.dream.io/i/2mpW9.jpg");
        URL url2 = new URL("https://aws.random.cat/meow");
        LOGGER.info("prend l'url");
        BufferedImage image = ImageIO.read(url.openStream());
        //BufferedImage image = ImageIO.read(new URL("https://purr.objects-us-east-1.dream.io/i/2013-10-19%2016.06.51.jpg"));
        LOGGER.info("prend l'image de L'url");
//        Image scaledImage = image.getScaledInstance(300, 150, Image.SCALE_DEFAULT);
        LOGGER.info("prendre la dimension de l'image");
        ImageIO.write(
                //convertToBufferedImage(scaledImage),
                image,
                "png",
                new File("C:\\Users\\utilisateur\\Desktop\\image.png"));
        LOGGER.info("enregistrer l'image au bureaux");

        return url2;
        //return image;
    }

    public static BufferedImage convertToBufferedImage(Image img) {

        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bi = new BufferedImage(
                img.getWidth(null), img.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics2D = bi.createGraphics();
        graphics2D.drawImage(img, 0, 0, null);
        graphics2D.dispose();

        return bi;
    }

    public URL dog() throws MalformedURLException {
        URL urldog = new URL("https://random.dog/");
        return urldog;
    }

    public URL fox() throws MalformedURLException {
        URL urlfox = new URL("https://randomfox.ca/");
        return urlfox;
    }

}

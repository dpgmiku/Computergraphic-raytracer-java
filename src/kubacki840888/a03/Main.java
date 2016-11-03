/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a03;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author miku
 */
public class Main {

    static String name = "doc/a03.png";
    static final int WIDTH = 480;
    static final int HEIGHT = 270;
    static final double GAMMAWERT = 2.2;
    static Kamera kamera = new Kamera(WIDTH, HEIGHT, Math.PI / 2);
    static final Color SCHWARZ = new Color(0, 0, 0);
    static final Color WHITE = new Color(255, 255, 255);
    static final Color EINS = new Color((int) (cgtools.Random.random() * 255), (int) (cgtools.Random.random() * 255), (int) (cgtools.Random.random() * 255));
    static final Color ZWEI = new Color((int) (cgtools.Random.random() * 255), (int) (cgtools.Random.random() * 255), (int) (cgtools.Random.random() * 255));

    public static void main(String[] args) {

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x != WIDTH; x++) {
            for (int y = 0; y != HEIGHT; y++) {

                Ray ray = kamera.generateRay(x, y);
                // System.out.println(ray.normalisierteRichtung.x + "," + ray.normalisierteRichtung.y + "," +ray.normalisierteRichtung.z);

// System.out.println(10*ray.normalisierteRichtung.y);
// System.out.println(Math.round(10*ray.normalisierteRichtung.y));
// 
                Color entscheiden;
                if (Math.round(ray.normalisierteRichtung.y*10) % 2 == 0) {

                    entscheiden = EINS;

                } else {
                    entscheiden = ZWEI;

                }
            
                image.setRGB(x, y, gammakorrektur(entscheiden).getRGB());
            }
            }
        

// 
//    long temp = Math.abs(Math.round(ray.normalisierteRichtung.y*10));
//    if (temp%10==0 || temp%10==2 || temp%10==4 || temp%10==6 || temp%10==8)
//    {
//    image.setRGB(x, y, SCHWARZ.getRGB());
//        }  
//    else {
//        
//    image.setRGB(x,y,WHITE.getRGB());  }  
    



try {
            File outputfile = new File(name);
            ImageIO.write(image, "png", outputfile);
            System.out.println("Wrote image: " + name);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e);
        }
    }
    
    
     static Color gammakorrektur(Color kolors) {
        int red = kolors.getRed();
        int green = kolors.getGreen();
        int blue = kolors.getBlue();

        double redSkalierung = (double) (red) / 255;
        double greenSkalierung = (double) (green) / 255;
        double blueSkalierung = (double) (blue) / 255;

        double redHoch = Math.pow(redSkalierung, 1 / GAMMAWERT);
        double greenHoch = Math.pow(greenSkalierung, 1 / GAMMAWERT);
        double blueHoch = Math.pow(blueSkalierung, 1 / GAMMAWERT);

        Color gKolor = new Color(((int) (255 * redHoch)), ((int) (255 * greenHoch)), ((int) (255 * blueHoch)));

        return gKolor;
    }
}

package kubacki840888.a02;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    static String name = "doc/a02-3.png";
    static int width = 480;
    static int height = 270;
    static double gammawert = 2.2;
    static int abtastrate = 10;
    static int anzahlKreisen = 32;
    static Kreis[] kreisListe;

    private static void kreisListefuellen() {
        kreisListe = new Kreis[anzahlKreisen];

        double differenzRadien;
        double abstandMittelpunkte;
        double summeRadien;
        boolean schnittpunktExistiert;
        int anzahlKreisentemp;

        int i = 0;
        while (i < anzahlKreisen) {
            kreisListe[i] = new Kreis((int) (Math.max(cgtools.Random.random() * width - 5, 5)), (int) (Math.max(cgtools.Random.random() * height - 5, 5)), new Color((int) (cgtools.Random.random() * 255), (int) (cgtools.Random.random() * 255), (int) (cgtools.Random.random() * 255)), (int) (Math.max(cgtools.Random.random() * 50, 10)));

            System.out.println(kreisListe[i].getX() + "," + kreisListe[i].getY() + "," + kreisListe[i].getFarbe().getRGB() + "," + kreisListe[i].getRadius());

            if (i == 0) {
                i++;
            } else {
                anzahlKreisentemp = i;
                for (int k = 0; k < i; k++) {
                    abstandMittelpunkte = (Math.sqrt(Math.pow(kreisListe[i].getX() - kreisListe[k].getX(), 2) + Math.pow(kreisListe[i].getY() - kreisListe[k].getY(), 2)));
                    differenzRadien = Math.abs((kreisListe[i].getRadius()) - (kreisListe[k].getRadius()));
                    summeRadien = kreisListe[i].getRadius() + kreisListe[k].getRadius();
                    schnittpunktExistiert = ((differenzRadien < abstandMittelpunkte) && (abstandMittelpunkte < summeRadien));
                    if ((schnittpunktExistiert && (kreisListe[i].getRadius() > kreisListe[k].getRadius())) || ((schnittpunktExistiert == false) && ((abstandMittelpunkte > kreisListe[i].getRadius()) || (abstandMittelpunkte < kreisListe[i].getRadius() && kreisListe[k].getRadius() < kreisListe[i].getRadius())))) {
                        anzahlKreisentemp--;
                        System.out.println(anzahlKreisentemp);
                    }
                }

                if (anzahlKreisentemp == 0) {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        kreisListefuellen();
        for (int x = 0; x != width; x++) {
            for (int y = 0; y != height; y++) {

                int red = 0;
                int green = 0;
                int blue = 0;
                double xs;
                double ys;
                for (int xi = 0; xi < abtastrate; xi++) {
                    for (int yi = 0; yi < abtastrate; yi++) {

                        double rx = Math.random();
                        double ry = Math.random();

                        xs = x + ((xi + rx) / abtastrate);
                        ys = y + ((yi + ry) / abtastrate);
                       Color colortemp = antialiasingKreis(xs,ys);
                        red = red + colortemp.getRed();
                        green = green + colortemp.getGreen();
                        blue = blue + colortemp.getBlue();
                    }

                }
                int rederg = red / (abtastrate * abtastrate);
                int greenerg = green / (abtastrate * abtastrate);
                int blueerg = blue / (abtastrate * abtastrate);

                Color erg = new Color(rederg, greenerg, blueerg);

                image.setRGB(x, y, gammakorrektur(erg).getRGB());

            }
        }
        try {
            File outputfile = new File(name);
            ImageIO.write(image, "png", outputfile);
            System.out.println("Wrote image: " + name);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e);
        }

    }

    static Color antialiasingKreis(double xs, double ys) {
        //   kreisListe = new Kreis[1];
        //   kreisListe[0] = new Kreis(width/2,height/2, new Color(0,255,0), 50);
        int temp;
        for (int i = 0; i < anzahlKreisen; i++) {
            if (Math.pow(xs - kreisListe[i].getX(), 2) + Math.pow(ys - kreisListe[i].getY(), 2) <= Math.pow(kreisListe[i].getRadius(), 2)) {
                return kreisListe[i].getFarbe();
            }

        }
        temp = (int) (255 * ys / height);

        return new Color(temp, temp, 255);

    }

    static Color colorForGreenCircleOnBlueToWhite(int x, int y) {
        //if (Math.abs(width / 2 - x) < size/2 && Math.abs(height / 2 - y) < size/2 )
        int temp;
        for (int i = 0; i < anzahlKreisen; i++) {
            if (Math.pow(x - kreisListe[i].getX(), 2) + Math.pow(y - kreisListe[i].getY(), 2) <= Math.pow(kreisListe[i].getRadius(), 2)) {
                return kreisListe[i].getFarbe();

            }
        }

        temp = (int) (255 * y / height);

        return new Color(temp, temp, 255);

    }

    static Color gammakorrektur(Color kolors) {
        int red = kolors.getRed();
        int green = kolors.getGreen();
        int blue = kolors.getBlue();

        double redSkalierung = (double) (red) / 255;
        double greenSkalierung = (double) (green) / 255;
        double blueSkalierung = (double) (blue) / 255;

        double redHoch = Math.pow(redSkalierung, 1 / gammawert);
        double greenHoch = Math.pow(greenSkalierung, 1 / gammawert);
        double blueHoch = Math.pow(blueSkalierung, 1 / gammawert);

        Color gKolor = new Color(((int) (255 * redHoch)), ((int) (255 * greenHoch)), ((int) (255 * blueHoch)));

        return gKolor;
    }

    static int gammakorrektur(int intensivitaet) {
        double skalierung = (double) (intensivitaet) / 255;
        // System.out.println("Skalierung:" + skalierung);
        double hoch = Math.pow(skalierung, 1 / gammawert);
        // System.out.println("hoch:" + hoch);
        int neueIntensivitaet = (int) (255 * hoch);
        // System.out.println("neueIntensivitaet:"+neueIntensivitaet);
        return neueIntensivitaet;

    }

}

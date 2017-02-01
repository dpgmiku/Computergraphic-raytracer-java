/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.b03;

/**
 *
 * @author miku
 */
import cgtools.Vec3;
import cgtools.Image;
import cgtools.Mat4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Main {

    static String name = "doc/cone90dlugi_sun_wyzszy.png";

    static final Mat4 IDENTITY = Mat4.identity;
    static final Mat4 SCALE = Mat4.translate(1, 1, 1);
    static final Mat4 VORN = Mat4.translate(new Vec3(4, 4, 200));
    static final Mat4 RECHTS = Mat4.translate(6, 30, -10).mult(Mat4.rotate(0, 10, 0, -90));

    static final Mat4 m1 = Mat4.translate(new Vec3(0, 0, 10));
    static final Mat4 m2 = Mat4.rotate(1, 0, 0, -25);
    static final Mat4 m3 = Mat4.rotate(0, 1, 0, 90);
    static final Mat4 kombi = m3.mult(m2.mult(m1));
    static int scanrate = 7;
//die beste koordinaten um cylinder zu zeigen
//      static final  Mat4 m1 = Mat4.translate(new Vec3(0, 0, 10));
//	 static final	Mat4 m2 = Mat4.rotate(1, 0, 0, -25);
//	 static final	Mat4 m3 = Mat4.rotate(0, 1, 0, 90);
//	 static final	Mat4 kombi = m3.mult(m2.mult(m1));

    //rotate(x+widze blizej-widze dalej,y+przesuwa w prawo,-przesuwa w lewo,z+przekreca w prawo,-)
    //  static final Mat4 ROTATE = Mat4.rotate(new Vec3(0,7,0), -50);
    // static final Mat4 ROTATE2 = Mat4.rotate(new Vec3(2,0,0), 20);
    static final Mat4 OBEN = Mat4.translate(new Vec3(30, 170, -350)).mult(Mat4.rotate(10, 1, 0, 90));
    static final Mat4 HINTEN = Mat4.translate(new Vec3(14, 120, -260)).mult(Mat4.rotate(0, 10, 0, -180));
    static final Mat4 RECHTS2 = Mat4.rotate(0, 0, 1, 90);

    static Kamera kamera = new Kamera(Kamera.WIDTH, Kamera.HEIGHT, Math.PI / 2, kombi);
    static ArrayList<LightSource> lights = new ArrayList<>();
    static Scene SCENE = new Scene(lights);
    static Shape[] shapes;
    static Shape[] spiegel;
    static Shape[] cylindrerot;
    //static BackgroundMaterial backgroundMat = new BackgroundMaterial();
//    static LambertMaterial lam1 = new LambertMaterial(new Vec3(0.2, 0.7, 0.2));
//    static LambertMaterial lam2 = new LambertMaterial(new Vec3(1, 0, 0));
//
//    static LambertMaterial lam3 = new LambertMaterial(new Vec3(0.5, 0.5, 0.5));
//    static LambertMaterial skin = new LambertMaterial(new Vec3(0.98, 0.85, 0.52));
//    static LambertMaterial farbeFuesse = new LambertMaterial(new Vec3(212.0 / 255.0, 0, 79.0 / 255.0));
//    static LambertMaterial lam4 = new LambertMaterial(new Vec3(0, 1, 0));
//    static LambertMaterial farbeBody = new LambertMaterial(new Vec3(254.0 / 255.0, 125.0 / 255.0, 164.0 / 255.0));
//    static LambertMaterial policzki = new LambertMaterial(new Vec3(254.0 / 255.0, 87.0 / 255.0, 122.0 / 255.0));
//    static LambertMaterial mund = new LambertMaterial(new Vec3(126.0 / 255, 6.0 / 255, 76.0 / 255));
//    static LambertMaterial zunge = new LambertMaterial(new Vec3(253.0 / 255, 76.0 / 255, 99.0 / 255));
//    static LambertMaterial augenBlack = new LambertMaterial(new Vec3(0, 0, 0));
//    static LambertMaterial augenWhite = new LambertMaterial(new Vec3(1, 1, 1));
//    static LambertMaterial augenBlue = new LambertMaterial(new Vec3(21.0 / 255, 42.0 / 255, 91.0 / 255));

    private static void listeAusfuellen(int anzahlKirbies, double abstandx) {
        lights.add(new PointLight(new Vec3(0, 0, 0), new Vec3(0, 0, 0)));
        //spiegel = new Shape[1];
        //spiegel[0] = new Rectangle(500, 500, new LambertMaterial(new Constant(new Vec3(1, 1, 1))));

        //spiegel[1] = new Rectangle(100, 100, new LambertMaterial(new Texture(1, 1, 1), 0));
//                cylindrerot = new Shape[1];
        //      cylindrerot[0] = new Cylinder(new LambertMaterial(new PhotoTexture("doc/sun.jpg")),new Vec3(0,5,-12),3,10);
        shapes = new Shape[2];
        shapes[0] = new Background(new BackgroundMaterial(new Constant(new Vec3(0.5, 0.5, 0.5))));
        //shapes[1] = new Sphere(new Vec3(0, 5, -12), new LambertMaterial(new PhotoTexture("doc/sun.jpg")), 5);
        //shapes[2] = new Rectangle(500, 500, new LambertMaterial(new Constant(new Vec3(1, 0, 0))));
        // shapes[1] = new Group(cylindrerot, new Transform(Mat4.rotate(0,0,1,-90)));
        //      public Kegel(Material m, Vec3 top, double height, double bottomRadius) {

        shapes[1] = new Kegel(new LambertMaterial(new PhotoTexture("doc/sun.jpg")), new Vec3(-10, 0, -12), 20, 10);

// public Cone(Material material, Vec3 center, double tipz, double radius, double height) {
        //public Cylinder(Material material,Vec3 center, double radius, double height) {
        //shapes[2] = new Sphere(new Vec3(50, 60, -90), new GlassMaterial(new Constant(new Vec3(1, 1, 1))), 20);
        // shapes[3] = new Group(spiegel, new Transform(Mat4.rotate(1, 1, 1, 0)), lights);
//        for (int zaehler = 0; zaehler < anzahlKirbies; zaehler++) {
////        shapes[1] = new Sphere(new Vec3(20, 30, -90), lam2, 30);
//            //fuss links
//
//            int temp = 0;
//            if (zaehler % 2 == 0 && zaehler != 0) {
//                temp = zaehler - 1;
//            }
//            if (zaehler % 2 != 0 && zaehler != 0) {
//
//                temp = -zaehler;
//            }
//
//               //fuss rechts
//            shapes[3 + 15 * zaehler] = new Sphere(new Vec3(0 + abstandx * temp, 30, -90), farbeBody, 40);
//            //body
//            shapes[4 + 15 * zaehler] = new Sphere(new Vec3(-20 + abstandx * temp, 70, -90), farbeBody, 20);
//            //linkes hand oben
//            shapes[5 + 15 * zaehler] = new Sphere(new Vec3(40 + abstandx * temp, 32, -90), farbeBody, 20);
//            //rechtes hand unten
//            shapes[6 + 15 * zaehler] = new Sphere(new Vec3(-20 + abstandx * temp, 27, -62), policzki, 6);
//            //morda
//            shapes[7 + 15 * zaehler] = new Sphere(new Vec3(20 + abstandx * temp, 27, -62), policzki, 6);
//            shapes[8 + 15 * zaehler] = new Sphere(new Vec3(0 + abstandx * temp, 17, -62), mund, 14);
//            shapes[9 + 15 * zaehler] = new Sphere(new Vec3(0 + abstandx * temp, 14, -62), zunge, 13);
//            shapes[10 + 15 * zaehler] = new Sphere(new Vec3(-5 + abstandx * temp, 33, -62), augenWhite, 12.4);
//            shapes[11 + 15 * zaehler] = new Sphere(new Vec3(5 + abstandx * temp, 33, -62), augenWhite, 12.4);
//            shapes[12 + 15 * zaehler] = new Sphere(new Vec3(-5 + abstandx * temp, 31, -62), augenBlack, 12.5);
//            shapes[13 + 15 * zaehler] = new Sphere(new Vec3(5 + abstandx * temp, 31, -62), augenBlack, 12.5);
//            shapes[14 + 15 * zaehler] = new Sphere(new Vec3(5 + abstandx * temp, 30, -62), augenBlue, 12.4);
//            shapes[15 + 15 * zaehler] = new Sphere(new Vec3(-5 + abstandx * temp, 30, -62), augenBlue, 12.4);
//        }
//        //   shapes[2] = new Sphere(new Vec3(0, 0, -90), skin, 20);
//        //  shapes[15*anzahlKirbies+1]= new Sphere(new Vec3(0, -1518, -25), lam3,1500);
//        //erde
//        shapes[15 * anzahlKirbies + 1] = new Rectangle(200, 200, new LambertMaterial(new Vec3(1, 1, 1)));
//        //  shapes[3]= new Sphere(new Vec3(0,0,5),lam4 , 2.0 );
//        //shapes[2] = new Sphere(new Vec3(15, 15, 6), lam1, 3);
//        //shapes[3] = new Sphere(new Vec3(-5,-10,-100),lam1,10);
//
////Ray ray = new Ray(new Vec3(0.0,0.0,0.0), new Vec3(0.0,0.,-1.0));
////    Hit hit = shapes[0].getHit(ray);
////    System.out.println(hit.t);
//    }
//
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();;

        listeAusfuellen(5, 110.0);
        Group gruppe = new Group(shapes, new Transform(IDENTITY));
        //   Image image = SCENE.raytrace(kamera, gruppe, scanrate, 0, kamera.HEIGHT);

        MyThread thread1 = new MyThread(0, kamera.HEIGHT / 4, kamera, gruppe, scanrate, SCENE);
        MyThread thread2 = new MyThread(kamera.HEIGHT / 4, kamera.HEIGHT - kamera.HEIGHT / 2, kamera, gruppe, scanrate, SCENE);
        MyThread thread3 = new MyThread(kamera.HEIGHT - kamera.HEIGHT / 2, kamera.HEIGHT - kamera.HEIGHT / 4, kamera, gruppe, scanrate, SCENE);
        MyThread thread4 = new MyThread(kamera.HEIGHT - kamera.HEIGHT / 4, kamera.HEIGHT, kamera, gruppe, scanrate, SCENE);
        MyThread[] threads = {thread1, thread2, thread3, thread4};

        for (MyThread t : threads) {
            t.start();
        }

        for (MyThread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Image image = new Image(kamera.width, kamera.height);
        for (MyThread t : threads) {
            for (int x = 0; x != kamera.width; x++) {
                for (int y = t.start; y != t.finish; y++) {
                    image.setPixel(x, y, t.pixels[x][y]);
                }
            }
        }

        image.write("multithread.png");

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

    }
//    public static void main(String[] args) throws IOException {
//        Ray ray = new Ray(new Vec3(0, 0, 2), new Vec3(0, 0, -1), 0.0001, Double.POSITIVE_INFINITY);
//        Background background = new Background(new BackgroundMaterial(new Constant(new Vec3(0.5, 0.5, 0.5))));
//        Rectangle rectangle = new Rectangle(500, 500, new LambertMaterial(new Constant(new Vec3(1, 1, 1))));
//        System.out.println(background.getHit(ray) == null);
//    }
}

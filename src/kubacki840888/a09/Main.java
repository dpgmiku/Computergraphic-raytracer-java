/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a09;

/**
 *
 * @author miku
 */
import cgtools.Vec3;
import cgtools.Image;
import cgtools.Mat4;

import java.io.IOException;

public class Main {

    static String name = "doc/a09-3.png";
   
    static final Mat4 IDENTITY = Mat4.identity;
    static final Mat4 SCALE = Mat4.translate(10, 10, 10);
    static final Mat4 VORN = Mat4.translate(new Vec3(4, 4, 200));
    //rotate(x+widze blizej-widze dalej,y+przesuwa w prawo,-przesuwa w lewo,z+przekreca w prawo,-)
    //  static final Mat4 ROTATE = Mat4.rotate(new Vec3(0,7,0), -50);
    // static final Mat4 ROTATE2 = Mat4.rotate(new Vec3(2,0,0), 20);
    static final Mat4 OBEN = Mat4.translate(new Vec3(30, 170, -350)).mult(Mat4.rotate(10, 1, 0, 90));
    static final Mat4 HINTEN = Mat4.translate(new Vec3(14, 120, -260)).mult(Mat4.rotate(0, 10, 0, -180));
    static Kamera kamera = new Kamera(Kamera.WIDTH, Kamera.HEIGHT, Math.PI / 2, VORN);
    static final Scene SCENE = new Scene();
    static Shape[] shapes;
    static Shape[] spiegel;
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
        spiegel = new Shape[1];
       spiegel[0] = new Rectangle(220, 220, new LambertMaterial(new CheckerBoardTexture()));

        //spiegel[1] = new Rectangle(100, 100, new LambertMaterial(new Texture(1, 1, 1), 0));

        
        shapes = new Shape[4];
        shapes[0] = new Background(new BackgroundMaterial(new PhotoTexture("doc/sky2.png")));
        shapes[1] = new Sphere(new Vec3(-40, 85, -90), new LambertMaterial(new PhotoTexture("doc/mars.png")),20);

        shapes[2] = new Sphere(new Vec3(50, 60, -90), new LambertMaterial(new PhotoTexture("doc/globus.png")),40);
        

        shapes[3] =  new Group(spiegel, new Transform(Mat4.rotate(1,1,1,0)));
        
       
        

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

    private static void listeAusfuellen() {

    }

    public static void main(String[] args) throws IOException {
        listeAusfuellen(5, 110.0);
        Group gruppe = new Group(shapes, new Transform(IDENTITY));
        Image image = SCENE.raytrace(kamera, gruppe, 5);
        image.write(name);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a05;

/**
 *
 * @author miku
 */
import cgtools.Vec3;
import cgtools.Image;

import java.io.IOException;

public class Main {

    static String name = "doc/tescik12345678129101.png";
    static final int WIDTH = 480;
    static final int HEIGHT = 270;
    static Kamera kamera = new Kamera(WIDTH, HEIGHT, Math.PI / 2);
    static final Scene SCENE = new Scene();
    static Shape[] shapes;
    static BackgroundMaterial backgroundMat = new BackgroundMaterial();
    static LambertMaterial lam1 = new LambertMaterial(new Vec3(0.2, 0.7, 0.2));
    static LambertMaterial lam2 = new LambertMaterial(new Vec3(1, 0, 0));

    static LambertMaterial lam3 = new LambertMaterial(new Vec3(0.5, 0.5, 0.5));
    static LambertMaterial skin = new LambertMaterial(new Vec3(0.98, 0.85, 0.52));

    static LambertMaterial lam4 = new LambertMaterial(new Vec3(0, 1, 0));

    private static void listeAusfuellen() {
        shapes = new Shape[4];
        shapes[0] = new Background(backgroundMat);

        shapes[1] = new Sphere(new Vec3(20, 30, -90), lam2, 30);
        shapes[2] = new Sphere(new Vec3(0, 0, -90), skin, 20);
        shapes[3]= new Sphere(new Vec3(0, -1518, -25), lam3,1500);

        //  shapes[3]= new Sphere(new Vec3(0,0,5),lam4 , 2.0 );
        //shapes[2] = new Sphere(new Vec3(15, 15, 6), lam1, 3);
        //shapes[3] = new Sphere(new Vec3(-5,-10,-100),lam1,10);

//Ray ray = new Ray(new Vec3(0.0,0.0,0.0), new Vec3(0.0,0.,-1.0));
//    Hit hit = shapes[0].getHit(ray);
//    System.out.println(hit.t);
    }

    public static void main(String[] args) throws IOException {
        listeAusfuellen();
        Group gruppe = new Group(shapes);
        Image image = SCENE.raytrace(kamera, gruppe, 7);
        image.write(name);
    }

}

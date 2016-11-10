/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a04;

/**
 *
 * @author miku
 */

import cgtools.Image;

import java.io.IOException;



public class Main {
        static String name = "doc/a04.png";
    static final int WIDTH = 960;
    static final int HEIGHT = 540;
    static Kamera kamera = new Kamera(WIDTH, HEIGHT, Math.PI / 2);
    static final Scene SCENE = new Scene();
    static Shape[] shapes;
    
    private static void listeAusfuellen(){
    shapes=new Shape[5];
    shapes[0] = new Background();
    shapes[1]= new Sphere(new Vec3(10,10,10), new Vec3(0.2,0.7,0.2), 3);
       shapes[2]= new Sphere(new Vec3(10,10,16), new Vec3(0.7,0.1,0.7), 3);
       shapes[3]= new Sphere(new Vec3(0,1,-5), new Vec3(0.7,0.1,0.7), 1.5);
       shapes[4]= new Sphere(new Vec3(0,0,5), new Vec3(0,1,0), 2.0 );

//Ray ray = new Ray(new Vec3(0.0,0.0,0.0), new Vec3(0.0,0.,-1.0));
//    Hit hit = shapes[0].getHit(ray);
//    System.out.println(hit.t);

}
            
            
     public static void main(String[] args) throws IOException {
         listeAusfuellen();
       Group gruppe = new Group(shapes);
      Image image = SCENE.raytrace(kamera, gruppe, 10);
        image.write(name);
     }

}

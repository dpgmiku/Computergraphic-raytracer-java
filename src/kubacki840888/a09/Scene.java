/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a09;
import cgtools.Vec3;
import cgtools.Image;

/**
 *
 * @author miku
 */
public class Scene {

    public Scene() {

    }

    public Image raytrace(Kamera kamera, Group shapes, int abtastrate) {
        Image image = new Image(kamera.width, kamera.height);

        for (int x = 0; x != kamera.width; x++) {
            for (int y = 0; y != kamera.height; y++) {
                Vec3 vectemp = new Vec3(0.0, 0.0, 0.0);

                for (int xi = 0; xi < abtastrate; xi++) {
                    for (int yi = 0; yi < abtastrate; yi++) {
                        double rx = cgtools.Random.random();
                        double ry = cgtools.Random.random();
                        double xs = x + ((xi + rx) / abtastrate);
                        double ys = y + ((yi + ry) / abtastrate);

                        Ray ray = kamera.generateRay(xs, ys);
                        Hit hit = shapes.getHit(ray);

                        if (hit != null) {
                            vectemp = vectemp.add(calculateRadiance(shapes,ray,7));

                        }
                    }

                }
                //  System.out.println("x"+vectemp.x+"y"+vectemp.y+"z"+vectemp.z);
                vectemp = vectemp.skalar(1.0 / (abtastrate * abtastrate));
                // System.out.println("x"+vectemp.x+"y"+vectemp.y+"z"+vectemp.z);

                image.setPixel(x, y, gammakorrektur(vectemp, 2.2f));
            }
        }

        return image;
    }

    public static Vec3 gammakorrektur(Vec3 farbe, double gammawert) {

        return new Vec3(Math.pow(farbe.x, 1 / gammawert), Math.pow(farbe.y, 1 / gammawert), Math.pow(farbe.z, 1 / gammawert));
    }

    public Vec3 calculateRadiance(Group group, Ray ray, int depth) {
        if (depth==0){ return new Vec3(0,0,0);}
        Hit hit = group.getHit(ray);
     
        Vec3 emitted = hit.material.emitted(ray, hit);
        Scattered scattered = hit.material.scattered(ray, hit);
        if (scattered != null) {
            return emitted.add(scattered.albedo.sample(hit.texturekoordinaten).elementaryMultiply(calculateRadiance(group, scattered.scattered, depth-1)));
        } else {
            return emitted;
        }
        
        
    }
    
   
    
}

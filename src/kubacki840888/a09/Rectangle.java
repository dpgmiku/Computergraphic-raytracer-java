/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a09;

import cgtools.Vec3;

/**
 *
 * @author miku
 */
public class Rectangle implements Shape {

    double width;
    double height;
    Material material;

    public Rectangle(double x, double z, Material material) {
        this.width = x;
        this.height = z;
        this.material = material;

    }
    @Override
    public Hit getHit(Ray ray) {
        Hit hit = null;
        Vec3 n = new Vec3(0, 1, 0);
        double temp = (n.skalar(ray.normalisierteRichtung));
      //  if (temp==0){
      //      return null;
      //  }
        double t = n.skalar(ray.ursprung) * (-1) / temp;
        if (t >= ray.t0 && t <= ray.t1) {
            Vec3 pos = ray.pointAt(t);
            if (n.skalar(ray.normalisierteRichtung) > 0) {

                n.y = -1; 

            }

           if(pos.x>=-this.width/2 && pos.x<=this.width/2 && pos.z>=-this.height/2 && pos.z<=this.height/2){
		//hit = new Hit(t, pos    , material, n);
                hit = new Hit(t, pos, material, n, new Vec3(pos.x/this.width+0.5, pos.z/this.height+0.5,0));
			}
        }

        return hit;
    }

}

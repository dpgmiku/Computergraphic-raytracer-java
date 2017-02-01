/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.b01;

import cgtools.Vec3;
import java.util.Arrays;

/**
 *
 * @author miku
 */
public class Cylinder implements Shape {

    Material material;
    Vec3 center;
    double radius;
    double height;

    public Cylinder(Material material, Vec3 center, double radius, double height) {
        this.material = material;
        this.center = center;
        this.radius = radius;
        this.height = height;

    }

    @Override
    public Hit getHit(Ray ray) {
        Vec3 eminusc = ray.ursprung.minus(center);

        double a = Math.pow(ray.normalisierteRichtung.x, 2) + Math.pow(ray.normalisierteRichtung.y, 2);
        double b = 2 * (ray.normalisierteRichtung.x * eminusc.x + ray.normalisierteRichtung.y * eminusc.y);
        double c = Math.pow(eminusc.x, 2) + Math.pow(eminusc.y, 2) - Math.pow(radius, 2);
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return null;
        }

        double t1 = Math.min((-b + Math.sqrt(discriminant)) / (2 * a), (-b - Math.sqrt(discriminant)) / (2 * a));
        double t2 = (height / 2.0 - eminusc.z) / ray.normalisierteRichtung.z;
        double t3 = (-height / 2.0 - eminusc.z) / ray.normalisierteRichtung.z;

        // We'll iterate through the values in sorted order so we find closest intersection first
        double[] tarr = {t1, t2, t3};
        Arrays.sort(tarr);
        Vec3 normal = null;
        Double t = null;                 // The lowest intersection we find
        for (double x : tarr) {
            Vec3 location = ray.pointAt(x);

            if (x == t1) {
                if (Math.abs(location.z - center.z) < height / 2.0) {
                    normal = new Vec3(location.x - center.x, location.y - center.y, 0).normalisierung();
                    t = x;
                    break;
                }
            } else {
                if (Math.pow(location.x - center.x, 2)
                        + Math.pow(location.y - center.y, 2)
                        - Math.pow(radius, 2) <= 0) {
                    if (x == t2) {
                        normal = new Vec3(0, 0, 1);
                    } else if (x == t3) {
                        normal = new Vec3(0, 0, -1);
                    }

                    t = x;
                    break;
                }
            }
        }

        if (t == null || t > ray.t1 || t < ray.t0) {
            return null;
        }
        Vec3 location = ray.pointAt(t);
        // public Hit(double t, Vec3 intersection, Material material, Vec3 normalenvektor, Vec3 texturekoordinaten){
        double inclination = Math.acos(normal.y);
        double azimuth = Math.atan2(normal.x, normal.z);
        double u = (azimuth + Math.PI) / (2 * Math.PI);
        double v = inclination / Math.PI;
        return new Hit(t, location, material, normal, new Vec3(u, v, 0));
    }
}

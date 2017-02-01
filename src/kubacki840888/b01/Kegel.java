/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.b01;

import cgtools.Vec3;

/**
 *
 * @author miku
 */
public class Kegel implements Shape {

    Vec3 top;
    double height;
    double bottomRadius;
    Material material;

    public Kegel(Material m, Vec3 top, double height, double bottomRadius) {
        this.top = top;
        this.height = Math.abs(height);
        this.bottomRadius = Math.abs(bottomRadius);
        this.material = m;
    }

    //
    /**
     * Solves a quadratic equation a * x^2 + b * x + c
     *
     * @param a Scalar factor of the quadratic term.
     * @param b Scalar factor of the linear term.
     * @param c Constant of the equation.
     * @return Double vector of size 0, 1 or 2 according to the number of
     * solutions. Element 0 of the return vector is always the smallest possible
     * solution!
     */
    double[] SolveQuadrEq(double a, double b, double c) {
        double d = b * b - 4 * a * c;

        if (d < 0) {
            return new double[0];
        } else if (d == 0) {
            double ret[] = new double[1];
            ret[0] = -b / (2 * a);
            return ret;
        } else {
            double ret[] = new double[2];
            double sqrtD = Math.sqrt(d);
            if (a < 0) {
                ret[0] = (-b + sqrtD) / (2 * a);
                ret[1] = (-b - sqrtD) / (2 * a);
            } else {
                ret[1] = (-b + sqrtD) / (2 * a);
                ret[0] = (-b - sqrtD) / (2 * a);
            }
            return ret;
        }
    }

    public void getMinMaxXYZ(Vec3 min, Vec3 max) {
        min.x = top.x - bottomRadius;
        min.y = top.y - height;
        min.z = top.z - bottomRadius;
        max.x = top.x + bottomRadius;
        max.y = top.y;
        max.z = top.z + bottomRadius;
    }

    @Override
    public Hit getHit(Ray ray) {
// calculate r^2/h^2
        double rh = bottomRadius / height;
        rh *= rh;

        double a = ray.normalisierteRichtung.x * ray.normalisierteRichtung.x
                + ray.normalisierteRichtung.z * ray.normalisierteRichtung.z
                - ray.normalisierteRichtung.y * ray.normalisierteRichtung.y * rh;

        double b = 2 * ray.normalisierteRichtung.x * (ray.ursprung.x - top.x)
                + 2 * ray.normalisierteRichtung.z * (ray.normalisierteRichtung.z - top.z)
                - 2 * ray.normalisierteRichtung.y * (ray.normalisierteRichtung.y - top.y) * rh;

        Vec3 ot = ray.ursprung.minus(top);
        double cyh = (height + top.y);
        cyh *= cyh;

        double c = ot.x * ot.x + ot.z * ot.z - (ot.y * ot.y) * rh;

        double solutions[] = SolveQuadrEq(a, b, c);

        for (double s : solutions) {
            if (s > 0) {
                Vec3 intPos = ray.ursprung.add(ray.normalisierteRichtung.skalar(s));

                if (intPos.y > top.y || intPos.y < top.y - height) {
                    continue;
                }

                float normalY = (float) (bottomRadius / Math.sqrt(bottomRadius * bottomRadius + height * height));

                Vec3 normal = intPos.minus(top);
                normal.y = 0;
                normal.normalisierung();
                normal = normal.skalar(Math.sqrt(1 - normalY * normalY));
                normal.y = normalY;

                // negate normal if ray hits the cone from inside to outside
                if (normal.skalar(ray.normalisierteRichtung) > 0) {
                    normal = normal.skalar(-1);
                }
                double inclination = Math.acos(normal.y);
                double azimuth = Math.atan2(normal.x, normal.z);
                double u = (azimuth + Math.PI) / (2 * Math.PI);
                double v = inclination / Math.PI;

                return new Hit(s, intPos, material, normal, new Vec3(u, v, 0));
            }
        }

        return null;
    }
}

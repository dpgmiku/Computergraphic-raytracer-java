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
public class CheckerBoardTexture implements Texture {

    @Override
    public Vec3 sample(Vec3 uv) {
        double u = uv.x;
        double v = uv.y;
        int ui = ((int) Math.floor(u * 50));
        int vi = ((int) Math.floor(v * 50));

        if ((ui + vi) % 2 == 0) {
            return new Vec3(1, 1, 1);
        } else {
            return new Vec3(0, 0, 0);
        }
    }

}

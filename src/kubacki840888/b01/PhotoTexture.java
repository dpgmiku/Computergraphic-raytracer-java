/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.b01;

import cgtools.Vec3;
import cgtools.ImageTexture;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miku
 */
public class PhotoTexture implements Texture {

    ImageTexture texture;

    public PhotoTexture(String pfad) {
        try {
            texture = new ImageTexture(pfad);
        } catch (IOException ex) {
            Logger.getLogger(PhotoTexture.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public Vec3 sample(Vec3 uv) {
        
   // double xcut = uv.x-Math.floor(uv.x);
   // double ycut = uv.y-Math.floor(uv.y);

      return Scene.gammakorrektur(texture.samplePoint(uv.x, uv.y), 1/(2.2f));

    }




}

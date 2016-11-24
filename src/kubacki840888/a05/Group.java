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
public class Group implements Shape {
    
Shape[] shapes;

public Group(Shape[] shapes){
    this.shapes=shapes;
    
}

    @Override
     public Hit getHit(Ray ray) {
        Hit hit = null;
        double min = Double.POSITIVE_INFINITY;
    for(Shape shape:shapes){
        if (shape.getHit(ray)!=null){
        if (shape.getHit(ray).t<= min)
        {
        min=shape.getHit(ray).t;
        hit =shape.getHit(ray);
        }
        }  
    }    
    return hit;
    }


    

}

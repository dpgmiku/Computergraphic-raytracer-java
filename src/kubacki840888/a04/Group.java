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
public class Group implements Shape {
    
Shape[] shapes;

public Group(Shape[] shapes){
    this.shapes=shapes;
    
}

    @Override
    public Hit getHit(Ray ray) {
        double min = -1;
        Hit hit = null;
    for(Shape shape:shapes){
        if (shape.getHit(ray)!=null){
        if (shape.getHit(ray).t<min || min==-1)
        {
        hit =shape.getHit(ray);
        }
        }  
    }    
    return hit;
    }

    

}

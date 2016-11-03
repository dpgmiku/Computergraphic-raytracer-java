/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a03;

/**
 *
 * @author miku
 */
public class Vec3 {
    
    public final double x;
    public final double y;
    public final double z;
    
  public  Vec3 (double x, double y, double z){
    
        this.x=x;
        this.y=y;
        this.z=z;

    }
  
  Vec3 add(Vec3 v){
      
      return new Vec3(x+v.x,y+v.y,z+v.z);
      
  }
  
  Vec3 minus(Vec3 v){
      
        return new Vec3(x-v.x,y-v.y,z-v.z);
      
  }
  
Vec3 skalar(Vec3 skalar){
    
    
return  new Vec3(x*skalar.x,y*skalar.y,z*skalar.z);
}

Vec3 kreuzprodukt(Vec3 v){
    
    
return new Vec3((y*v.z)-(z*v.y), (z*v.x)-(x*v.z), (x*v.y)-(y*v.x));    
    
}    


Vec3 skalar(double skalar){

return new Vec3(x*skalar,y*skalar,z*skalar);


}

double laenge(){
    
    return Math.sqrt(Math.pow(x,2)+Math.pow(y, 2)+Math.pow(z,2));
    
    
}

Vec3 normalisierung(){
    
    
  return skalar(1/laenge());  
}





}

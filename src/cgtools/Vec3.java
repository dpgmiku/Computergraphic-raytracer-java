/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgtools;


/**
 *
 * @author miku
 */
public class Vec3 {
    
    public  double x;
    public double y;
    public  double z;
    
  public  Vec3 (double x, double y, double z){
    
        this.x=x;
        this.y=y;
        this.z=z;

    }
  
  public Vec3 add(Vec3 v){
      
      return new Vec3(x+v.x,y+v.y,z+v.z);
      
  }
  
  public Vec3 minus(Vec3 v){
      
        return new Vec3(x-v.x,y-v.y,z-v.z);
      
  }
  
public double skalar(Vec3 skalar){
    
    
return  this.x*skalar.x+this.y*skalar.y+this.z*skalar.z;
}


public Vec3 kreuzprodukt(Vec3 v){
    
    
return new Vec3((y*v.z)-(z*v.y), (z*v.x)-(x*v.z), (x*v.y)-(y*v.x));    
    
}    


public Vec3 skalar(double skalar){

return new Vec3(x*skalar,y*skalar,z*skalar);


}

public double laenge(){
    
    return Math.sqrt(Math.pow(x,2)+Math.pow(y, 2)+Math.pow(z,2));
    
    
}

public Vec3 normalisierung(){
    
    
  return skalar(1/laenge());  
}


public Vec3 elementaryMultiply(Vec3 multiply){
    
return new Vec3(this.x*multiply.x, this.y*multiply.y, this.z*multiply.z);    
}


}

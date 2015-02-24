package edu.ucsb.cs56.w15.drawings.vincenicoara.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes


// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D.Double; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Vince Nicoara
   @version for CS56, Winter 15, UCSB
   
*/
public class FaceWithFancyMustache extends Face implements Shape
{
	private int x;
	private int y;
	private int radius;
  private double leftPoint;
  private double rightPoint;
    /**
       Constructor
       @param xCoordinate the left-most x-coordinate of the head
       @param yCoordinate the highest y-coordinate of the head
       @param r The radius of the head.
     */   
         
    public FaceWithFancyMustache(int xCoordinate, int yCoordinate, int r){
      super(xCoordinate ,yCoordinate, r);
      x = xCoordinate;
      y = yCoordinate;
      radius = r;

      double mouthYCoordinate = (y + radius/3);
      leftPoint = x-(radius/2) - x/20;
      rightPoint = x+(radius/2) + x/20;

      GeneralPath wholeFace = this.get();

      Double mustacheLine = new Double (leftPoint, mouthYCoordinate - radius/15
				       , rightPoint, mouthYCoordinate - radius/15);
      wholeFace.append(mustacheLine, false);
    }

    public FaceWithFancyMustache(int xCoordinate, int yCoordinate, int r, int eyeRadius ){
      super(xCoordinate, yCoordinate, r, eyeRadius);
      x = xCoordinate;
      y = yCoordinate;
      radius = r;

      double mouthYCoordinate = (y + radius/3);
      leftPoint = x-(radius/2) - x/20 ;
      rightPoint = x+(radius/2) + x/20 ;

      GeneralPath wholeFace = this.get();

      Double mustacheLine = new Double (leftPoint, mouthYCoordinate - radius/15
               , rightPoint, mouthYCoordinate - radius/15);
      wholeFace.append(mustacheLine, false);
    }

    public FaceWithFancyMustache(int xCoordinate, int yCoordinate, int r, int eyeRadius, int arcHeight){
      super(xCoordinate, yCoordinate, r, eyeRadius, arcHeight);
      x = xCoordinate;
      y = yCoordinate;
      radius = r;

      double mouthYCoordinate = (y + radius/3);
      leftPoint = x-(radius/2) - x/20 ;
      rightPoint = x+(radius/2) + x/20 ;

      GeneralPath wholeFace = this.get();

      Double mustacheLine = new Double (leftPoint, mouthYCoordinate - radius/15
               , rightPoint, mouthYCoordinate - radius/15);
      wholeFace.append(mustacheLine, false);
    }

    public FaceWithFancyMustache(int x, int y, int r, int eyeRadius, int arcHeight
        , int lMustache, int rMustache){
      super(x, y, r, eyeRadius, arcHeight);
      radius = r;

      double mouthYCoordinate = (y + radius/3);
      lMustache = x-(radius/2) - x/20 ;
      rMustache = x+(radius/2) + x/20 ;

      GeneralPath wholeFace = this.get();

      Double mustacheLine = new Double (lMustache, mouthYCoordinate - radius/15
               , rMustache, mouthYCoordinate - radius/15);
      wholeFace.append(mustacheLine, false);
    }

}

package sef.module6.activity;

/**
 * @author  John Doe
 * 
 * This class represents a point in 3D space.  The coordinates are represented by
 * a set of values x, y an z that represents the coordinates along each plane
 */
public class Point3DImpl extends Point2DImpl implements Point3D{
	
	@SuppressWarnings("unused")
	private double z;
	
	/**
	 * Creates a Point3D object with the default coordinate of 0,0,0 
	 *
	 */
	public Point3DImpl(){
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	/**
	 * Creates a Point3D object at the specified coordinates
	 * 
	 * @param x coordinate along the x axis
	 * @param y coordinate along the y axis
	 * @param z coordinate along the z axis
	 */
	public Point3DImpl(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#setZ(double)
	 */
	public final void setZ(double z){
		this.z = z;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getZ()
	 */
	public final double getZ(){
		return this.z;
	}
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#move(double, double, double)
	 */
	public void move(double x2, double y2, double z2){
		this.setX(x2);
		this.setY(y2);
		this.setZ(z2);
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#translate(double, double, double)
	 */
	public void translate(double x2, double y2, double z2){
		this.setX(this.getX() + x2);
		this.setY(this.getY() + y2);
		this.setZ(this.getZ() + z2);
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#equals(double, double, double)
	 */
	public boolean equals(double x2, double y2, double z2) {
		double eps = 0.000001;

		if (Math.abs(this.getX() - x2) <= eps && Math.abs(this.getY() - y2) <= eps && Math.abs(this.getZ() - z2) <= eps) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Compares if the coordinates are equal to the coordinates specified by the parameter
	 * 
	 * @param p the coordinates to compare
	 * 
	 * @return true if the parameter is an instance of Point3D and contain the same coordinates, false otherwise
	 */
	public boolean equals(Object p){

		if (p instanceof Point3D) {
			double eps = 0.000001;

			if (Math.abs(this.getX() - ((Point3D) p).getX()) <= eps && Math.abs(this.getY() - ((Point3D) p).getY() ) <= eps && Math.abs(this.getZ() - ((Point3D) p).getZ() ) <= eps) {
				return true;
			}
		}

		return false;
		
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getDistance(sef.module5.activity.Point3D)
	 */
	public double getDistance(Point3D p){
		double dx = this.getX() - p.getX();
		double dy = this.getY() - p.getY();
		double dz = this.getZ() - p.getZ();
		double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

		return distance;
	}
	

	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getDistance(double, double, double)
	 */
	public double getDistance(double x2, double y2, double z2){
		double dx = this.getX() - x2;
		double dy = this.getY() - y2;
		double dz = this.getZ() - z2;
		double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

		return distance;
	}
	

}

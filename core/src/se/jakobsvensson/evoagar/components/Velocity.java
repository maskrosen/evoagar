package se.jakobsvensson.evoagar.components;

import com.artemis.Component;

public class Velocity extends Component{
	
	private float xSpeed;
	private float ySpeed;
	/**
	 * Creates a velocity component with initial x- and yspeed 0
	 */
	public Velocity(){
		this(0,0);
	}
	/**
	 * Creates a velocity component with the specified x- and y speed
	 * 
	 * @param xSpeed the x speed 
	 * @param ySpeed the y speed
	 */
	public Velocity(float xSpeed, float ySpeed){
		setXSpeed(xSpeed);
		setYSpeed(ySpeed);
	}
	/**
	 * Sets the x speed
	 * @param speed the x speed
	 */
	public void setXSpeed(float speed){
		this.xSpeed=speed;
	}
	/**
	 * Sets the y speed
	 * @param speed the y speed
	 */
	public void setYSpeed(float speed){
		this.ySpeed=speed;
	}
	/**
	 * Returns the x speed	
	 * @return the x speed
	 */
	public float getXSpeed(){
		return this.xSpeed;
	}
	/**
	 * Returns the y speed	
	 * @return the y speed
	 */
	public float getYSpeed(){
		return this.ySpeed;
	}

}

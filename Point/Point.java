package com.company;

/**
 *
 * This program represents a point in the Cartesian system
 * @author Daniel Levin ID 315048587
 * @version 7.11.2020
 *
 *
 */

public class Point {

    private double _radius; //the value of the radius of the vector to the Cartesian system point
    private double _alpha;  //the value of the angle of the vector to the Cartesian system point

    public static void main(String[] args) {

    }

    /**
     * Creates the Point object
     * @param x x value of the Cartesian system point
     * @param y y value of the Cartesian system point
     */

    public Point(double x, double y){

        if ((x >= 0.0 && y >= 0.0)) {////checks that the x and y values are in the first quadrant

            if (x == 0.0) {//if x is 0 only the y axis exists

                _alpha = (Math.PI / 2);//90 degree angle to the y axis

                _radius = y;

            } else if (y == 0.0) {//if y is 0 only the x axis exists

                _alpha = 0.0;//0 degree angle to the x axis

                _radius = x;


            } else {//calculates the vector to the x,y point

                _alpha = Math.atan(y / x);

                _radius = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));

            }
        }
    }

    /**
     * Creates a duplicate object point with the same attributes
     * @param other the point object that its attributes are needed to be copied
     */

    public Point(Point other){

        _alpha = other._alpha;
        _radius = other._radius;

    }

    private double convertY(){//uses the radius and angle to return the current y value

        return (Math.sin(_alpha) * _radius);

    }

    private double convertX(){//uses the radius and angle to return the current x value

        return (Math.cos(_alpha) * _radius);

    }

    /**
     * Retrieves the x coordinate value of the object
     * @return coordinate x value
     */

    public double getX(){

        if (_alpha == (Math.PI / 2))//if the angle is 90 degree x is 0
            return 0.0;
        else
            return convertX();

    }

    /**
     * Retrieves the y coordinate value of the object
     * @return coordinate y value
     */

    public double getY(){

        if (_alpha == 0.0)//if the angle is 0 degree y is 0
            return 0.0;
        else
            return convertY();

    }

    /**
     * Sets the x value of the object to a different value
     * @param x new desired x value
     */

    public void setX(double x){

        double oldY = convertY();//gets the current y value of the object for future calculations

        if (x > 0.0) {

            _alpha = Math.atan(oldY / x);

            _radius = Math.sqrt((Math.pow(x, 2) + Math.pow(oldY, 2)));

        } else if (x == 0.0){//if x = 0 only y axis exists

            _alpha = (Math.PI / 2);

            _radius = oldY;

        }

    }

    /**
     * Sets the y value of the object to a different value
     * @param y new desired y value
     */

    public void setY(double y){

        double oldX = convertX();//gets the current x value of the object for future calculations

        if (y >= 0) {

            _alpha = Math.atan(y / oldX);

            _radius = Math.sqrt((Math.pow(oldX, 2) + Math.pow(y, 2)));

        }

    }

    /**
     * Strings the x and y values together like this (x,y)
     * @return values of the point (x,y)
     */

    public String toString(){
        //rounds the x and y values in case 3.999999 happens
        return ("(" + Math.round(getX()*10000)/(double)10000 + "," + Math.round(getY()*10000)/(double)10000 + ")");

    }

    /**
     * checks if 2 points have the same x, y values
     * @param other the point which is wished to be compared to
     * @return true or false if the points are the same
     */

    public boolean equals(Point other){

        return ((other.getY() == getY()) && (other.getX() == getX()));

    }

    /**
     * checks if one point is above the other
     * @param other - the point which is being compared to
     * @return if the point is above
     */

    public boolean isAbove(Point other){

        return (getY() > other.getY());

    }

    /**
     * checks if one point is under the other
     * @param other - the point which is being compared to
     * @return if the point is below
     */

    public boolean isUnder(Point other){

        return other.isAbove(this);//if the point is not above then its below

    }

    /**
     * checks if one point is to the left of the other
     * @param other - the point which is being compared to
     * @return if the point is to the left
     */

    public boolean isLeft(Point other){

        return (getX() < other.getX());

    }

    /**
     * checks if one point is to the right of the other
     * @param other - the point which is being compared to
     * @return if the point is to the right
     */

    public boolean isRight(Point other){

        return other.isLeft(this);//if the point is not to the left then its to the right

    }

    /**
     * gives the value of the distance between 2 points
     * @param p other point
     * @return the distance between the points
     */

    public double distance(Point p){

        return (Math.sqrt(Math.pow((getY() - p.getY()), 2) + Math.pow((getX() - p.getX()), 2)));

    }

    /**
     * moves the point with the dx and dy values that are provided
     * @param dx x value that moves the point
     * @param dy y value that moves the point
     */

    public void move(double dx, double dy){

        if ((getX() + dx) >= 0 && (getY() + dy) >= 0) {//checks if the dx and dy that were received don't move the point from the first quadrant

            setX(getX() + dx);
            setY(getY() + dy);

        }
    }

}

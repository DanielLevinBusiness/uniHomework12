package com.company;

/**
 * This program represents a segment in the first quarter
 *
 * @author Daniel Levin ID 315048587
 * @version 27.11.2020
 */

public class Segment2 {

    private Point _poCenter;
    private double _length;

    public static void main(String[] args) {

    }

    /**
     * Creates the segment object using x,y values
     *
     * @param leftX  x value of the left segment point
     * @param leftY  y value of the left segment point
     * @param rightX x value of the right segment point
     * @param rightY y value of the right segment point
     */

    public Segment2(double leftX, double leftY, double rightX, double rightY) {

        if (rightY != leftY)// checks if right point is above or below the left point, if yes sets y left point value to right point y value
            rightY = leftY;

        _poCenter = new Point(((rightX - leftX) / 2), leftY);//gets the center point
        _length = (rightX - leftX);

    }

    /**
     * Creates the segment object using a center point and length of the segment
     *
     * @param poCenter the center point of the segment
     * @param length length of the segment
     */

    public Segment2(Point poCenter, double length) {

        _poCenter = new Point(poCenter);//to avoid aliasing
        _length = length;

    }

    /**
     * Creates the segment object using 2 points on the segment endings
     *
     * @param left left point of the segment
     * @param right right point of the segment
     */

    public Segment2(Point left, Point right) {

        if (right.getY() != left.getY())// checks if right point is above or below the left point, if yes sets y left point value to right point y value
            right.setY(left.getY());

        _length = right.distance(left);//distance between the 2 points if the segment length
        _poCenter = new Point((right.distance(left) / 2), left.getY());//center point is the distance between the points divided by 2

    }

    /**
     * duplicates a segment
     *
     * @param other the segment you want to copy
     */

    public Segment2(Segment2 other) {

        _poCenter = new Point(other._poCenter);//avoid aliasing
        _length = other._length;

    }

    /**
     * returns the left segment point OBJECT
     *
     * @return returns the left segment point object
     */

    public Point getPoLeft() {

        Point poLeft = new Point(_poCenter);//to avoid aliasing and to get the center point
        poLeft.move(-(_length / 2), 0);//getting the left point values by moving the center point to it

        return (poLeft);

    }

    /**
     * returns the right segment point OBJECT
     *
     * @return returns the right segment point object
     */

    public Point getPoRight() {

        Point poRight = new Point(_poCenter);//to avoid aliasing and to get the center point
        poRight.move(_length / 2, 0);//getting the left point values by moving the center point to it

        return (poRight);

    }

    /**
     * returns the length of the segment between the 2 points
     *
     * @return segment length
     */

    public double getLength() {

        return (_length);

    }

    /**
     * strings the segment's most left and most right points values
     *
     * @return the left and right points values
     */

    public String toString() {

        return (getPoLeft().toString() + "---" + getPoRight().toString());

    }

    /**
     * checks if one segment is equal to the other segment provided
     *
     * @return true or false if the segments are the same
     */

    public boolean equals(Segment2 other) {

        return (_poCenter.equals(other._poCenter) && _length == other._length);
        /*
        checks if the center point is the same in both using the point equals method
        and checks that they are the same length
         */
    }

    /**
     * checks if one segment is above the other segment provided
     *
     * @param other the segment that you wish to compare to
     * @return true or false if the segment is above the other segment
     */

    public boolean isAbove(Segment2 other) {

        return (getPoLeft().isAbove(other.getPoLeft()));//using the point above method

    }

    /**
     * checks if one segment is under the other segment provided
     *
     * @param other the segment that you wish to compare to
     * @return true or false if the segment is under the other segment
     */

    public boolean isUnder(Segment2 other) {

        return (other.isAbove(this));// checks if one segment is below the other by checking if one is above the other

    }

    /**
     * checks if one segment is to the left of the other segment provided
     *
     * @param other the segment that you wish to compare to
     * @return true or false if the segment is to the left of the other segment
     */

    public boolean isLeft(Segment2 other) {

        return (getPoRight().isLeft(other.getPoLeft()));// using the point isleft method

    }

    /**
     * checks if one segment is to the right of the other segment provided
     *
     * @param other the segment that you wish to compare to
     * @return true or false if the segment is to the right of the other segment
     */

    public boolean isRight(Segment2 other) {

        return (other.isLeft(this));// checks if a point is to the left by checking if the other one is to the right

    }

    /**
     * moves the WHOLE segment with the delta provided on the horizontal plane
     *
     * @param delta the value you wish the segment to be moved with
     */

    public void moveHorizontal(double delta) {

        if (getPoLeft().getX() + delta >= 0) { // checks if the delta moves the segment out of the first quarter

            getPoLeft().setX(getPoLeft().getX() + delta); // using the getPoLeft method to avoid aliasing
            getPoRight().setX(getPoRight().getX() + delta); // using the getPoRight method to avoid aliasing

        }

    }

    /**
     * moves the WHOLE segment with the delta provided on the vertical plane
     *
     * @param delta the value you wish the segment to be moved with
     */

    public void moveVertical(double delta) {

        if (getPoLeft().getY() + delta >= 0) {// checks if the delta moves the segment out of the first quarter

            getPoLeft().setY(getPoLeft().getY() + delta); // using the getPoLeft method to avoid aliasing
            getPoRight().setY(getPoRight().getY() + delta); // using the getPoRight method to avoid aliasing

        }

    }

    /**
     * changes the size/length of the segment
     *
     * @param delta the value you wish the segment's size to be changed with
     */

    public void changeSize(double delta) {

        if (delta + getPoRight().getX() >= getPoLeft().getX())// checks that the delta doesn't flip the left and right points
            getPoRight().setX(delta + getPoLeft().getX());// using the getPoRight method to avoid aliasing

    }

    /**
     * checks if a point is on the segment provided
     *
     * @param p the point that you want to check
     * @return true or false if the point is on the segment
     */

    public boolean pointOnSegment(Point p) {

        return ((getPoLeft().getY() == p.getY()) && (getPoLeft().getX() <= p.getX()) && (p.getX() <= getPoRight().getX()));
        /*
        checks if the point is at the same height, Y value, then checks if the point's X value
        is between the two, left and right, segment points
         */

    }

    /**
     * checks if one segment is bigger then the other segment, in length
     *
     * @param other the segment you wish to compare with
     * @return true or false if the segment provided is bigger or smaller
     */

    public boolean isBigger(Segment2 other) {

        return (this.getLength() > other.getLength());

    }

    /**
     * checks if the 2 segments overlap and gives the overlapping x value
     *
     * @param other the segment you wish to check the overlap with
     * @return the overlapping x value length, and if they don't overlap then 0
     */

    public double overlap(Segment2 other) {

        if ((getPoLeft().getX() < other.getPoLeft().getX()) && (getPoRight().getX() > other.getPoRight().getX()))
            return (other.getLength());//overlapping when one segment overshadows the other one
        else if ((getPoLeft().getX() > other.getPoLeft().getX()) && (getPoRight().getX() < other.getPoRight().getX()))
            return (this.getLength());//overlapping when one segment overshadows the other one
        else if ((getPoLeft().getX() == other.getPoLeft().getX()) && (getPoRight().getX() == other.getPoRight().getX()))
            return (this.getLength());//checks if the segments are the same in length but maybe a different height
        else if (getPoLeft().getX() > other.getPoLeft().getX())// if only a part of a segment overlaps the other segment
            return (other.getPoRight().getX() - getPoLeft().getX());
        else if (getPoLeft().getX() < other.getPoLeft().getX())// if only a part of a segment overlaps the other segment
            return (getPoLeft().getX() - other.getPoRight().getX());
        else
            return (0.0);//they don't overlap

    }

    /**
     * calculates the trapeze perimeter that if formed between the 2 segments
     *
     * @param other the other segment that forms the second base of the trapeze
     * @return the perimeter value of the trapeze
     */

    public double trapezePerimeter(Segment2 other) {

        double lengthOfSegment1 = this.getLength();//length of the trapeze base
        double lengthOfSegment2 = other.getLength();//length of the second trapeze base
        double distanceOfLeftToLeft = this.getPoLeft().distance(other.getPoLeft());
        // uses the point distance method to get the distance between 2 left points
        double distanceOfRightToRight = this.getPoRight().distance(other.getPoRight());
        // uses the point distance method to get the distance between 2 right points

        return (lengthOfSegment1 + lengthOfSegment2 + distanceOfLeftToLeft + distanceOfRightToRight);

    }

}

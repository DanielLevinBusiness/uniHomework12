package com.company;

/**
 * This program represents a segment in the first quarter
 *
 * @author Daniel Levin ID 315048587
 * @version 14.11.2020
 */

public class Segment1 {

    private Point _poLeft;
    private Point _poRight;

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

    public Segment1(double leftX, double leftY, double rightX, double rightY) {

        if (rightY != leftY) // checks if right point is above or below the left point, if yes sets y left point value to right point y value
            rightY = leftY;

        _poLeft = new Point(leftX, leftY);
        _poRight = new Point(rightX, rightY);

    }

    /**
     * Creates the segment object using 2 point objects
     *
     * @param left  left point object of the segment
     * @param right right point object of the segment
     */

    public Segment1(Point left, Point right) {

        if (right.getY() != left.getY())// checks if right point is above or below the left point, if yes sets y left point value to right point y value
            right.setY(left.getY());

        _poLeft = new Point(left);
        _poRight = new Point(right);

    }

    /**
     * duplicates a segment
     *
     * @param other the segment you want to copy
     */

    public Segment1(Segment1 other) {

        _poRight = new Point(other._poRight);
        _poLeft = new Point(other._poLeft);

    }

    /**
     * returns the left segment point OBJECT
     *
     * @return returns the left segment point object
     */

    public Point getPoLeft() {

        return (new Point(_poLeft));// creates new left point object to avoid aliasing

    }

    /**
     * returns the right segment point OBJECT
     *
     * @return returns the right segment point object
     */

    public Point getPoRight() {

        return (new Point(_poRight));// creates new right point object to avoid aliasing

    }

    /**
     * returns the length of the segment between the 2 points
     *
     * @return segment length
     */

    public double getLength() {

        return (_poRight.getX() - _poLeft.getX());// same y plain to just distance between 2 points

    }

    /**
     * strings the point X,Y values as (x,y)
     *
     * @return string (x,y)
     */

    public String toString() {

        return (_poLeft.toString() + "---" + _poRight.toString());

    }

    /**
     * checks if one segment is equal to the other segment provided
     *
     * @return true or false if the segments are the same
     */

    public boolean equals(Segment1 other) {

        return (_poRight.equals(other._poRight) && _poLeft.equals(other._poLeft));
        /*
         checks if both right and left points
         are the same in the 2 segments
        */

    }

    /**
     * checks if one segment is above the other segment provided
     *
     * @param other the segment that you wish to compare to
     * @return true or false if the segment is above the other segment
     */

    public boolean isAbove(Segment1 other) {

        return (_poLeft.isAbove(other._poLeft));// uses the above Point method to check the points

    }

    /**
     * checks if one segment is under the other segment provided
     *
     * @param other the segment that you wish to compare to
     * @return true or false if the segment is under the other segment
     */

    public boolean isUnder(Segment1 other) {

        return (other.isAbove(this));// checks if one segment is below the other by checking if one is above the other

    }

    /**
     * checks if one segment is to the left of the other segment provided
     *
     * @param other the segment that you wish to compare to
     * @return true or false if the segment is to the left of the other segment
     */

    public boolean isLeft(Segment1 other) {

        return (_poRight.isLeft(other._poLeft));// using the point isleft method

    }

    /**
     * checks if one segment is to the right of the other segment provided
     *
     * @param other the segment that you wish to compare to
     * @return true or false if the segment is to the right of the other segment
     */

    public boolean isRight(Segment1 other) {

        return other.isLeft(this);// checks if a point is to the left by checking if the other one is to the right

    }

    /**
     * moves the WHOLE segment with the delta provided on the horizontal plane
     *
     * @param delta the value you wish the segment to be moved with
     */

    public void moveHorizontal(double delta) {

        if (_poLeft.getX() + delta >= 0) { // checks if the delta moves the segment out of the first quarter

            getPoLeft().setX(_poLeft.getX() + delta); // using the getPoLeft method to avoid aliasing
            getPoRight().setX(_poRight.getX() + delta); // using the getPoRight method to avoid aliasing

        }

    }

    /**
     * moves the WHOLE segment with the delta provided on the vertical plane
     *
     * @param delta the value you wish the segment to be moved with
     */

    public void moveVertical(double delta) {

        if (_poLeft.getY() + delta >= 0) {// checks if the delta moves the segment out of the first quarter

            getPoLeft().setY(_poLeft.getY() + delta); // using the getPoLeft method to avoid aliasing
            getPoRight().setY(_poRight.getY() + delta); // using the getPoRight method to avoid aliasing

        }

    }

    /**
     * changes the size/length of the segment
     *
     * @param delta the value you wish the segment's size to be changed with
     */

    public void changeSize(double delta) {

        if (delta + _poRight.getX() >= _poLeft.getX())// checks that the delta doesn't flip the left and right points
            getPoRight().setX(delta + _poLeft.getX());// using the getPoRight method to avoid aliasing

    }

    /**
     * checks if a point is on the segment provided
     *
     * @param p the point that you want to check
     * @return true or false if the point is on the segment
     */

    public boolean pointOnSegment(Point p) {

        return ((_poLeft.getY() == p.getY()) && (_poLeft.getX() <= p.getX()) && (p.getX() <= _poRight.getX()));
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

    public boolean isBigger(Segment1 other) {

        return (this.getLength() > other.getLength());

    }

    /**
     * checks if the 2 segments overlap and gives the overlapping x value
     *
     * @param other the segment you wish to check the overlap with
     * @return the overlapping x value length, and if they don't overlap then 0
     */

    public double overlap(Segment1 other) {

        if ((_poLeft.getX() < other._poLeft.getX()) && (_poRight.getX() > other._poRight.getX()))
            return (other.getLength());//overlapping when one segment overshadows the other one
        else if ((_poLeft.getX() > other._poLeft.getX()) && (_poRight.getX() < other._poRight.getX()))
            return (this.getLength());//overlapping when one segment overshadows the other one
        else if ((_poLeft.getX() == other._poLeft.getX()) && (_poRight.getX() == other._poRight.getX()))
            return (this.getLength());//checks if the segments are the same in length but maybe a different height
        else if (_poLeft.getX() > other._poLeft.getX())// if only a part of a segment overlaps the other segment
            return (other._poRight.getX() - _poLeft.getX());
        else if (_poLeft.getX() < other._poLeft.getX())// if only a part of a segment overlaps the other segment
            return (_poLeft.getX() - other._poRight.getX());
        else
            return (0.0);//they don't overlap

    }

    /**
     * calculates the trapeze perimeter that if formed between the 2 segments
     *
     * @param other the other segment that forms the second base of the trapeze
     * @return the perimeter value of the trapeze
     */

    public double trapezePerimeter(Segment1 other) {

        double lengthOfSegment1 = this.getLength();//length of the trapeze base
        double lengthOfSegment2 = other.getLength();//length of the second trapeze base
        double distanceOfLeftToLeft = this._poLeft.distance(other._poLeft);
        // uses the point distance method to get the distance between 2 left points
        double distanceOfRightToRight = this._poRight.distance(other._poRight);
        // uses the point distance method to get the distance between 2 right points

        return (lengthOfSegment1 + lengthOfSegment2 + distanceOfLeftToLeft + distanceOfRightToRight);

    }

}

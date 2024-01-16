package Homeworks.Homework06;

public class Shape implements Comparable<Shape>
{
    public static final Double pi = Math.PI;
    String type;
    double area;
    double length;
    double width;
    double base;
    double height;
    double radius;


    public Shape(String atype, double alength, double awidth, double abase, double aheight, double aradius)
    {
        this.type = atype;
        this.length = alength;
        this.width = awidth;
        this.base = abase;
        this.height = aheight;
        this.radius = aradius;
        this.area = setArea();
    }

    public Shape()
    {
        init();
    }
    public void init()
    {
        type = "none";
        area = length = width = base = height = radius = 0.0;
    }

    public double setArea()
    {
        if(this.type == "Circle") //radius2 x PI
        {
            area = (radius * radius) * pi;
        }
        else if(this.type == "Rectangle")//length x width
        {
            area = length * width;
        }
        else if(this.type == "Right Triangle") //½ base x height
        {
            area = (base * height) /2;
        }
        return area;
    }

    public String getType()
    {
        return this.type;
    }

    public double getArea()
    {
        return this.area;
    }

    public double getLength()
    {
        return this.length;
    }

    public double getWidth()
    {
        return this.width;
    }

    public double getRadius()
    {
        return radius;
    }

    public double getHeight()
    {
        return height;
    }

    public double getBase()
    {
        return base;
    }

    public int compareTo(Shape aShape) // returns the greater area. If they are the same, 
    //it returns 0 if they are the same type, 1 if the new entry is greater, and -1 if else
    {
        int compare = Double.compare(area, aShape.getArea());
        if( compare !=  0)
            return compare;
        else
        {
            if (type.equalsIgnoreCase("Circle")) {
                if (aShape.getType().equalsIgnoreCase("Circle")) {
                    return 0; // Same type
                } else {
                    return -1; // Circle comes before other shapes
                }
            } else if (type.equalsIgnoreCase("Rectangle")) {
                if (aShape.getType().equalsIgnoreCase("Circle")) {
                    return 1; // Rectangle comes after Circle
                } else if (aShape.getType().equalsIgnoreCase("Rectangle")) {
                    return 0; // Same type
                } else {
                    return -1; // Rectangle comes before Right Triangle
                }
            } else if (type.equalsIgnoreCase("Right Triangle")) {
                if (aShape.getType().equalsIgnoreCase("Right Triangle")) {
                    return 0; // Same type
                } else {
                    return 1; // Right Triangle comes after other shapes
                }
            }
    
            // Default case (shouldn't happen if all shapes are covered)
            return 0;
        }
    }


    public String toString()
    {
        if(type.equalsIgnoreCase("Right Triangle"))
            return type+" Base: "+base +"Height:"+height+" Area:"+area;
        else if(type.equalsIgnoreCase("Rectangle"))
            return type+" Length: "+length +" Width:"+width+" Area:"+area;
        else
            return type+" Radius: "+radius+" Area:"+area;
    }

}

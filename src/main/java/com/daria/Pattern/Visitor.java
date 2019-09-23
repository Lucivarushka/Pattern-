package main.java.com.daria.Pattern;

import java.util.ArrayList;

public class Visitor {
    public static void main(String[] args) {
        ArrayList<Shape> arr = new ArrayList();
        arr.add(new Circle("Circle"));
        arr.add(new Circle("Ring"));
        arr.add(new Triangle("Isosceles"));
        arr.add(new Triangle("Various"));

        VisitorForShape visitor = new ShapeVisitor();
        for (Shape a : arr) {
            a.accept(visitor);
        }
    }
}

abstract class Shape {
    private String typeOfShape;

    public Shape(String typeOfShape) {
        this.typeOfShape = typeOfShape;
    }

    public abstract void accept(VisitorForShape visitor);

    public String getTypeOfShape() {
        return typeOfShape;
    }

    public void setTypeOfShape(String modelTitle) {
        this.typeOfShape = modelTitle;
    }
}

class Circle extends Shape {
    public Circle(String typeOfShape) {
        super(typeOfShape);
    }

    @Override
    public void accept(VisitorForShape visitor) {
        visitor.visit(this);
    }
}

class Triangle extends Shape {
    public Triangle(String typeOfShape) {
        super(typeOfShape);
    }

    @Override
    public void accept(VisitorForShape visitor) {
        visitor.visit(this);
    }
}

interface VisitorForShape {
    void visit(Circle circle);

    void visit(Triangle triangle);
}

class ShapeVisitor implements VisitorForShape {
    @Override
    public void visit(Circle circle) {
        System.out.println("It's the " + circle.getTypeOfShape());
    }

    @Override
    public void visit(Triangle triangle) {
        System.out.println("It's the " + triangle.getTypeOfShape());
    }
}


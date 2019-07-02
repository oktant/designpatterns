package pattern;

/**
 * Created by oalizada on 12/7/2016.
 */
public class FactoryPattern {
}

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("draw Rectangle");
    }
}

class Circle implements Shape {
    public void draw() {
        System.out.println("draw Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("draw Square");
    }
}

class ShapeFactory {
    public Shape shapeFactory(String shape) {
        if (shape == null) {
            return null;
        }
        if (shape.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shape.equalsIgnoreCase("SQUARE")) {
            return new Square();
        } else if (shape.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}

class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory aa = new ShapeFactory();
        Shape c = aa.shapeFactory("CIRCLE");
        c.draw();
    }
}

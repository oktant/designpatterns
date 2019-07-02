package pattern;

import java.util.HashMap;

/**
 * Created by oalizada on 12/7/2016.
 */
public class PrototypePattern{

}

abstract class  ShapePrototype implements Cloneable{
    private String id;
    protected String type;
    abstract void draw();
    public String getType(){
        return type;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }


}
 class RectanglePrototype extends ShapePrototype {
    public RectanglePrototype(){
        type = "Rectangle";
    }
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}


class SquarePrototype extends ShapePrototype {
    public SquarePrototype(){
        type = "Square";
    }
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}


class CirclePrototype extends ShapePrototype {
    public CirclePrototype(){
        type = "Circle";
    }
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }


}
class ShapeCache{
    private static HashMap<String, ShapePrototype> shapeMap=new HashMap<String,ShapePrototype>();

    public static ShapePrototype getShape(String shapeId) {
        ShapePrototype cachedShape = shapeMap.get(shapeId);
        return (ShapePrototype) cachedShape.clone();
    }

    public static void loadCache() {
        CirclePrototype circle = new CirclePrototype();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);
        SquarePrototype square = new SquarePrototype();
        square.setId("2");
        shapeMap.put(square.getId(),square);
        RectanglePrototype rectangle = new RectanglePrototype();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }
}
 class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        ShapePrototype clonedShape = ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());
        ShapePrototype clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());
        ShapePrototype clonedShape3 = ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}


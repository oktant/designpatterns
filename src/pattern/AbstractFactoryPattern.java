package pattern;

/**
 * Created by oalizada on 12/7/2016.
 */
public class AbstractFactoryPattern {
}
interface ShapeAbstract{
    void draw();
}
class RectangleAbstract implements ShapeAbstract {
    public void draw() {
        System.out.println("draw Rectangle");
    }
}

class CircleAbstract implements ShapeAbstract {
    public void draw() {
        System.out.println("draw Circle");
    }
}

class SquareAbstract implements ShapeAbstract {
    public void draw() {
        System.out.println("draw Square");
    }
}


interface ColorAbstract{
    void fill();
}

class Red implements ColorAbstract{
    public void fill(){
        System.out.println("filling with red");
    }
}
class Green implements ColorAbstract{
    public void fill(){
        System.out.println("filling with green");
    }
}

class Blue implements ColorAbstract{
    public void fill(){
        System.out.println("filling with Blue");
    }
}
abstract class AbstractFactory {
    abstract ColorAbstract getColor(String color);
    abstract ShapeAbstract getShape(String shape) ;
}

class ShapeFactoryAbstract extends AbstractFactory{
    public ShapeAbstract getShape(String shape){
        if(shape==null){
            return null;
        }
        if(shape.equalsIgnoreCase("CIRCLE")){
            return new CircleAbstract();
        }else if(shape.equalsIgnoreCase("RECTANGLE")){
            System.out.println("---------rectangle");
            return new RectangleAbstract();
        }else if(shape.equalsIgnoreCase("SQUARE")){
            return new SquareAbstract();
        }
        return null;
    }

    public ColorAbstract getColor(String color){
        return null;
    }
}

class ColorFactoryAbstract extends AbstractFactory{
    public ShapeAbstract getShape(String shape){
        return null;
    }
    public ColorAbstract getColor(String color){
        if(color==null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        }
        if(color.equalsIgnoreCase("Blue")){
            return new Blue();

        }
        if(color.equalsIgnoreCase("Green")){
            return new Green();
        }
        return null;
    }
}
class FactoryProducer{
    public static AbstractFactory getFactoryAbstract(String chooseFactrory){
        if(chooseFactrory==null){
            return null;
        }
        if(chooseFactrory.equalsIgnoreCase("Shape")){
            System.out.println("q1111");
            return new ShapeFactoryAbstract();
        }
        else if(chooseFactrory.equalsIgnoreCase("COLOr")){
            return new ColorFactoryAbstract();
        }
        return null;
    }
}

class AbstractFactoryPatternDemo{

    public static void main(String[] args) {
        AbstractFactory te=FactoryProducer.getFactoryAbstract("SHAPE");
        ShapeAbstract shapeAbstract=te.getShape("Rectangle");
        shapeAbstract.draw();
        AbstractFactory ts=FactoryProducer.getFactoryAbstract("COLOR");
        ColorAbstract colorAbstract=ts.getColor("BLUE");

        colorAbstract.fill();
    }


}
package pattern;

/**
 * Created by oalizada on 12/8/2016.
 */
public class FacadePattern {
}

interface ShapeFacade {
    void draw();
}


class RectangleFacade implements ShapeFacade {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}


class SquareFacade implements ShapeFacade {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}


class CircleFacade implements ShapeFacade {
    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}

class ShapeMakerFacade {
    private ShapeFacade circle;
    private ShapeFacade rectangle;
    private ShapeFacade square;
    public ShapeMakerFacade(){
        circle = new CircleFacade();
        rectangle = new RectangleFacade();
        square = new SquareFacade();

    }
    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}

 class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMakerFacade shapeMaker = new ShapeMakerFacade();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}




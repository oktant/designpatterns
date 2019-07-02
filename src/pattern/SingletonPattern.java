package pattern;

/**
 * Created by oalizada on 12/7/2016.
 */
public class SingletonPattern {
    private static SingletonPattern a=new SingletonPattern();
    private SingletonPattern(){

    }
    public static SingletonPattern getInstance(){
        return a;
    }
    public void showMessage(){
        System.out.println("Hello");
    }
}
class Test{
    public static void main(String[] args) {
        SingletonPattern.getInstance().showMessage();
    }
}
import mayflower.*;

public class Pointer extends Actor{
    public Pointer() {
        MayflowerImage img = new MayflowerImage("img/arrow-removebg-preview.png");
        img.rotate(23);
        img.scale(.25);
        this.setImage(img);
    }
    
    public void act() {
        
    }
}
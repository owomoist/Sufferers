
import mayflower.*;

class RussianRoulette extends TimedWorld {
    Spinner spin = new Spinner();
    Pointer arrow = new Pointer();
    double rotation;
    Timer t;
    double n;
    MouseInfo mouse;
    int coins;
    int coinsNow;
    boolean b = false;
    public RussianRoulette(int num) {
        super(1);
        showText("Welcome to Roulette!", 300, 300, Color.BLACK);
        showText("Press Space to Start", 300, 400, Color.BLACK);
        addObject(spin, 50, 135);
        addObject(arrow, 500, 570);
        rotation = spin.getImage().getRotation();
        t = new Timer(50000);
        n = 10;
        coins = num;
        showText("Coins: " + coins, 50, 950, Color.MEGENTA);
        coinsNow = coins;
    }

    public void act() {
        if(Mayflower.isKeyPressed(Keyboard.KEY_SPACE))
            b = true;
        if(b) {
            if(coinsNow != coins) {
                removeText(50, 950);
                showText("Coins: " + coins, 50, 950, Color.MEGENTA);
            }
            super.act();
            if(t.isDone()) {
                if(n > 0)
                    n -= .02;
                if(n < 0)
                    n = 0;
                spin.image.rotate(n);
                spin.setImage(spin.image);
            }
            if(rotation == spin.image.getRotation()) {
                if(rotation >= 337.5 && rotation <= 22.5) {
                    if(coinsNow == coins)
                    coins += 3;
                    //System.out.println("gray");
                }
                if(rotation > 22.5 && rotation <= 67.5) {
                    if(coinsNow == coins)
                    coins += 3;
                    //System.out.println("green");
                }
                if(rotation > 67.5 && rotation <= 112.5) {
                    if(coinsNow == coins)
                    coins = 0;
                    //System.out.println("blue");
                }
                if(rotation > 112.5 && rotation < 157.5) {
                    if(coinsNow == coins)
                    coins += 3;
                    //System.out.println("purple");
                }
                if(rotation >= 157.5 && rotation <= 202.5) {
                    if(coinsNow == coins)
                    coins = 0;
                    //System.out.println("pink");
                }
                if(rotation > 202.5 && rotation <= 247.5) {
                    if(coinsNow == coins)
                    coins += 3;
                    //System.out.println("red");
                }
                if(rotation > 247.5 && rotation <= 292.5) {
                    if(coinsNow == coins)
                    coins *= 2;
                    //System.out.println("orange");
                }
                if(rotation > 292.5 && rotation < 337.5) {
                    if(coinsNow == coins)
                    coins = 0;
                    //System.out.println("yellow");
                }
                if(Mayflower.isKeyPressed(Keyboard.KEY_SPACE)) {
                    
                }
            } else {
                rotation = spin.image.getRotation();
                }
            if(timer.getSecondsLeft() < 0)
            {
                WorldTracker.setCurrentWorld(new MainMenu(coins));
            }
        }
    }
}

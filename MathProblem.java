import mayflower.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class MathProblem extends TimedWorld
{
    private ArrayList<String> hints, steps;
    private String answer;
    private int stepNum, lineNum;

    private Button nextButton, showAnswerButton, breakButton, refreshButton;

    private int numCoins;
    private double duration;
    private String topic;
    private int topicNum;

    private Scanner sc;

    private boolean started;
    private ArrayList<World> arr;
    public MathProblem(double duration, int coinTransfer, String topic, int topicNum) throws Exception
    {
        super(duration);
        arr = new ArrayList<World>();
        showText(topic, 50, 50, Color.MEGENTA);
        this.topic = topic;
        this.topicNum = topicNum;
        sc = new Scanner(new File("txt/" + topic + topicNum + ".txt"));

        if(topicNum == 0)
            numCoins = coinTransfer + (int)(Math.ceil(duration));
        else
            numCoins = coinTransfer;

        System.out.println(numCoins);

        hints = new ArrayList<String>(); steps = new ArrayList<String>();
        stepNum = lineNum = 0;

        arr.add(new RussianRoulette(numCoins));
        arr.add(new Darts(numCoins));
    }

    private void addObjects()
    {
        nextButton = new Button("img/mouse cursor.png", "Next", 50, 100);
        addObject(nextButton, nextButton.getX(), nextButton.getY());

        showAnswerButton = new Button("img/mouse cursor.png", "Show Answer", 400, 100);
        addObject(showAnswerButton, showAnswerButton.getX(), showAnswerButton.getY());

        refreshButton = new Button("img/mouse cursor.png", "New Example", 50, 150);
        addObject(refreshButton, refreshButton.getX(), refreshButton.getY());

        breakButton = new Button("img/mouse cursor.png", "Take a Break", 400, 150, Color.GRAY);
        addObject(breakButton, breakButton.getX(), breakButton.getY());
        breakButton.setActive(false);
    }

    public void scanDoc()
    {
        String elem;
        while(sc.hasNextLine())
        {
            elem = sc.nextLine();
            if(elem.contains("hint"))
            {
                if(elem.equals("hint"))
                    hints.add(sc.nextLine());
                else
                    steps.add(elem);
            }
            else if(elem.equals("question"))
                showText(sc.nextLine(), 50, 300, Color.BLACK);
            else if(elem.equals("step"))
                steps.add(sc.nextLine());
            else if(elem.equals("answer"))
                answer = sc.nextLine();
        }
    }

    public void manageSteps()
    {
        if(nextButton.clicked())
        {
            if(stepNum < steps.size() && steps.get(stepNum).contains("hint"))
            {
                int hintNum = Integer.parseInt(steps.get(stepNum).substring(5));
                if(hints.get(hintNum).length() < 50)
                    showText("hint: " + hints.get(hintNum), 50, 350 + lineNum * 50, Color.GRAY);
                else
                {
                    showText("hint: " + hints.get(hintNum).substring(0, 50), 50, 350 + lineNum * 50, Color.GRAY);
                    lineNum++;
                    showText(hints.get(hintNum).substring(50), 50, 350 + lineNum * 50, Color.GRAY);
                }
                stepNum++; lineNum++;
            }
            else if(stepNum < steps.size())
            {
                showText(steps.get(stepNum), 50, 350 + lineNum * 50, Color.BLACK);
                stepNum++; lineNum++;
            }
            else
            {
                nextButton.setActive(false);
                nextButton.changeColor(Color.GRAY);
                showText("answer: " + answer, 50, 900, Color.BLACK);
                showAnswerButton.setActive(false);
                showAnswerButton.changeColor(Color.GRAY);

            }
        }

        if(showAnswerButton.clicked())
        {
            showText("answer: " + answer, 50, 900, Color.BLACK);
            showAnswerButton.setActive(false);
            showAnswerButton.changeColor(Color.GRAY);
        }
    }

    public void act()
    {
        if(!started)
        {
            addObjects();
            scanDoc();
            started = true;
        }

        super.act();
        manageSteps();

        if(timer.getSecondsLeft() < 0)
        {
            showText("You got " + (int)(Math.ceil(duration)) + " coins!", 720, 150, Color.MEGENTA);
            breakButton.changeColor(Color.BLACK);
            breakButton.setActive(true);
        }
        
        if(breakButton.clicked())
        {
            int ranNum;
            ranNum = (int)(Math.random() * 2); // for array of 2 games
            WorldTracker.setCurrentWorld(arr.get(ranNum));
        }
        
        if(refreshButton.clicked())
        {
            try
            {
                WorldTracker.setCurrentWorld(new MathProblem(timer.getSecondsLeft() / 60.0, numCoins, topic, topicNum + 1));
            }
            catch(Exception e)
            {
                showText("you ran out! here's your break early :D", 50, 300, Color.BLACK);
                showText("You have " + numCoins + " coins", 670, 150, Color.MEGENTA);
                breakButton.changeColor(Color.BLACK);
                breakButton.setActive(true);
            }
        }
    }
}
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TheQueueVisualizer {
    final static int QUEUE_FRAME_WIDTH = 270;
    final static int QUEUE_FRAME_HEIGHT = 570;

    public static void main(String[] args)
    {
        Queue<Integer> theOnlyQueue = new LinkedList<Integer>();
        Canvas theVisualizer = new Canvas("Queue Visualizer", 600, 600);
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the Queue Visualizer!");
        theVisualizer.setVisible(true);

        boolean again = false;
        do
        {
            drawQueue(theVisualizer, theOnlyQueue);

            boolean ok;
            do {
                System.out.println("\nWould you like to (a)dd or (r)emove an item from the queue?");
                System.out.println("You can also (p)eek to see what's at the head of the queue.");
                System.out.println("You can also (e)xit the program if you are finished.");
                String input = in.next();

                again = true;
                ok = true;

                switch (Character.toLowerCase(input.charAt(0)))
                {
                    case 'a':
                    {

                        System.out.println("What is the number you'd like to add to the tail of the queue?");
                        int inNumber = in.nextInt();

                        theOnlyQueue.add(inNumber);
                        System.out.println(inNumber + " was added to the queue.");

                        break;
                    }
                    case 'r':
                    {
                        System.out.println("Removing the head of the queue...");
                        System.out.println("Removed " + theOnlyQueue.remove() + " from the head of the queue.");

                        break;
                    }
                    case 'p':
                    {
                        System.out.println(theOnlyQueue.peek() + " is at the head of the queue.");

                        break;
                    }
                    case 'e':
                    {
                        again = false;
                        break;
                    }
                    default:
                    {
                        System.out.println("That wasn't a command...please try again!!");
                        ok = false;
                    }
                }

            } while (ok == false);
        } while (again == true);

        System.out.println("\nThank you for using the Queue Visualizer!!");
        System.exit(0);
    }

    private static void drawQueue(Canvas whereToDraw, Queue<Integer> queueToDraw) {
        whereToDraw.erase();

        // Draw Frame
        whereToDraw.drawRectangle(10, 10,
                QUEUE_FRAME_WIDTH,
                QUEUE_FRAME_HEIGHT);

        // Draw Informative Text
        whereToDraw.setInkColor(Color.GRAY);
        whereToDraw.setFontSize(40);

        whereToDraw.drawString("Head", 350, 50);
        whereToDraw.drawString("Tail", 350, 570);
        whereToDraw.drawString("Visual Queue", 325, 310);

        // Draw Row Dividers
        if (queueToDraw.isEmpty()) {
            whereToDraw.drawString("Empty!", 60, 310);
            return;
        }

        int distanceApart = QUEUE_FRAME_HEIGHT / queueToDraw.size();

        int drawRowHeight = 10;
        for (int count = 0; count < queueToDraw.size(); count++) {
            drawRowHeight += distanceApart;

            whereToDraw.drawLine(10, drawRowHeight,
                    10 + QUEUE_FRAME_WIDTH, drawRowHeight);
        }

        // Draw Queue Values
        int numberSeparation = distanceApart;
        whereToDraw.setFontSize(20);

        LinkedList<Integer> listForm = (LinkedList<Integer>)queueToDraw;
        int drawNumberHeight = -10;
        for (int count = 0; count < queueToDraw.size(); count++)
        {
            drawNumberHeight += distanceApart;

            whereToDraw.drawString(Integer.toString(listForm.get(count)),
                    50, drawNumberHeight);
        }
    }
}

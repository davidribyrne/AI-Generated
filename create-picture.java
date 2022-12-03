// Write a Java program that takes user input and uses it to create a picture.
// https://beta.openai.com/playground/p/yICE8TZI15uWO6kckNlMkWyR

import java.awt.Rectangle; 
import java.awt.Graphics; 
import java.awt.Color; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
  
public class PictureCreator extends JPanel { 
  
    public void paint(Graphics g) 
    { 
        // Get user input
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter the x coordinate: ");
        int x = scanner.nextInt();
        System.out.print("Enter the y coordinate: ");
        int y = scanner.nextInt();
        System.out.print("Enter the width: ");
        int width = scanner.nextInt();
        System.out.print("Enter the height: ");
        int height = scanner.nextInt();
        System.out.print("Enter the color(red, blue, green, etc.): ");
        String color = scanner.next();
        
        // Set the color 
        Color c = Color.BLACK; 
        if (color.equals("red")) 
            c = Color.RED; 
        else if (color.equals("green")) 
            c = Color.GREEN; 
        else if (color.equals("blue")) 
            c = Color.BLUE; 
  
        // Create a rectangle with the user input 
        Rectangle rect = new Rectangle(x, y, width, height); 
  
        // Fill the rectangle with the specified color 
        g.setColor(c); 
        g.fillRect(rect.x, rect.y, rect.width, rect.height); 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        // Create a new frame 
        JFrame frame = new JFrame("Picture Creator"); 
  
        // Create a new instance of the picture creator class 
        PictureCreator pic = new PictureCreator();
  
        // Add the picture creator to the frame 
        frame.add(pic); 
  
        // Set the size of the frame 
        frame.setSize(400, 400); 
  
        // Make the frame visible 
        frame.setVisible(true); 
    } 
}

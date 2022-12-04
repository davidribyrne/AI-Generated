
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird extends JPanel implements ActionListener {

	//width and height of window
	public static final int WIDTH = 400;
	public static final int HEIGHT = 600;

	public static final int GAP = 100; //gap between the pipes

	//position of the bird
	public static int x, y;

	//speed of the bird
	public static double speed;

	public static boolean gameOver; //whether or not the game is over

	//list of pipes
	public static ArrayList<Rectangle> pipes;

	//timer
	public static Timer timer;

	public FlappyBird() {

		//set up window
		JFrame frame = new JFrame("Flappy Bird");
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		//initialize variables
		x = WIDTH/2;
		y = HEIGHT/2;
		speed = 0;
		gameOver = false;
		pipes = new ArrayList<Rectangle>();

		//add a pipe to the list
		Random rand = new Random();
		pipes.add(new Rectangle(WIDTH, rand.nextInt(HEIGHT-GAP), 20, HEIGHT));

		//set up timer
		timer = new Timer(20, this);
		timer.start();

		//add listeners
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					//add upward velocity when space is pressed
					speed = -5;
				}
			}
		});
	}

	public void paintComponent(Graphics g) {
		//draw background
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		//draw pipes
		g.setColor(Color.green);
		for(Rectangle r : pipes) {
			g.fillRect(r.x, 0, 20, r.y);
			g.fillRect(r.x, r.y+GAP, 20, HEIGHT-r.y-GAP);
		}

		//draw bird
		g.setColor(Color.red);
		g.fillRect(x, y, 20, 20);

		//draw game over message
		if(gameOver) {
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Game Over!", WIDTH/2-90, HEIGHT/2);
		}

		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		//update the position of the bird
		y += speed;
		speed += 0.2;

		//check for collisions
		for(Rectangle r : pipes) {
			//check if the bird has collided with any of the pipes
			if(r.intersects(x, y, 20, 20)) {
				gameOver = true;
			}

			//check if the bird has gone off the screen
			if(y > HEIGHT || y < 0) {
				gameOver = true;
			}

			//update the position of the pipes
			r.x -= 2;

			//add a new pipe when a pipe goes off the screen
			if(r.x + 20 < 0) {
				Random rand = new Random();
				pipes.add(new Rectangle(WIDTH, rand.nextInt(HEIGHT-GAP), 20, HEIGHT));
			}
		}
	}

	public static void main(String[] args) {
		new FlappyBird();
	}
}
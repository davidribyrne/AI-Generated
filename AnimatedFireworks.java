// Write a Java program that creates animated fireworks in random colors on the screen.
// https://beta.openai.com/playground/p/qmDNUuX4EzsjhF3QaSa3K3Z4

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnimatedFireworks extends JFrame {
	// Declare constants
	public static final int DELAY = 50;
	public static final int MAX_PARTICLES = 500;
	public static final int MAX_PARTICLE_AGE = 100;
	public static final int MAX_PARTICLE_SIZE = 10;
	public static final int MAX_PARTICLE_SPEED = 5;

	// Declare global variables
	private int width, height;
	private Color[] colors;
	private Particle[] particles;
	private Timer timer;

	public AnimatedFireworks() {
		// Initialize colors
		colors = new Color[4];
		colors[0] = Color.YELLOW;
		colors[1] = Color.RED;
		colors[2] = Color.BLUE;
		colors[3] = Color.ORANGE;

		// Initialize particles
		particles = new Particle[MAX_PARTICLES];

		// Set window size
		width = 640;
		height = 480;
		this.setSize(width, height);

		// Set window title
		this.setTitle("Animated Fireworks");

		// Set window visibility
		this.setVisible(true);

		// Set window close operation
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Initialize timer
		timer = new Timer(DELAY, new TimerHandler());
		timer.start();
	}

	// Inner class for handling timer events
	private class TimerHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<particles.length; i++) {
				if(particles[i] == null) {
					// Generate random color
					int colorIndex = (int)(Math.random() * colors.length);
					Color color = colors[colorIndex];

					// Generate random position
					int x = (int)(Math.random() * width);
					int y = (int)(Math.random() * height);

					// Generate random size
					int size = (int)(Math.random() * MAX_PARTICLE_SIZE);

					// Generate random speed
					int speedX = (int)(Math.random() * MAX_PARTICLE_SPEED - MAX_PARTICLE_SPEED/2);
					int speedY = (int)(Math.random() * MAX_PARTICLE_SPEED - MAX_PARTICLE_SPEED/2);

					// Create new particle
					particles[i] = new Particle(x, y, size, color, speedX, speedY);
				}
			}

			repaint();
		}
	}

	// Inner class for handling particle movement
	private class Particle {
		private int x, y, size;
		private Color color;
		private int age;
		private int speedX, speedY;

		public Particle(int x, int y, int size, Color color, int speedX, int speedY) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.color = color;
			this.speedX = speedX;
			this.speedY = speedY;
			age = 0;
		}

		// Update position
		public void update() {
			x += speedX;
			y += speedY;
			age++;
		}

		// Draw particle
		public void draw(Graphics g) {
			g.setColor(color);
			g.fillOval(x, y, size, size);
		}

		// Check if particle is dead
		public boolean isDead() {
			return age > MAX_PARTICLE_AGE;
		}
	}

	// Override paint method
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		// Draw particles
		for(int i=0; i<particles.length; i++) {
			if(particles[i] != null) {
				particles[i].draw(g);
				particles[i].update();

				if(particles[i].isDead())
					particles[i] = null;
			}
		}
	}

	public static void main(String[] args) {
		new AnimatedFireworks();
	}
}

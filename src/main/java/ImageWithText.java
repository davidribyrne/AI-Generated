// Write a Java program that opens a JPEG image and adds random text. Display the image.

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageWithText {
	public static void main(String args[]) throws IOException {
		int width = 500;
		int height = 500;

		//read image file
		File file = new File("image.jpg");
		BufferedImage image = ImageIO.read(file);

		//create a blank, RGB, same width and height, and a white background
		BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = newImage.createGraphics();
		graphics.setColor(new java.awt.Color(255, 255, 255));
		graphics.fillRect(0, 0, width, height);

		//resize the image
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics.drawImage(image, 0, 0, width, height, null);

		//generate random text
		String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz";
		int length = 10;
		StringBuilder sb = new StringBuilder();
		Random rnd = new Random();
		while (sb.length() < length) {
			int index = (int) (rnd.nextFloat() * alphaNumericString.length());
			sb.append(alphaNumericString.charAt(index));
		}
		String randomString = sb.toString();

		//add random text
		graphics.setFont(new Font("Arial", Font.BOLD, 20));
		graphics.drawString(randomString, 10, 20);

		//display image
		graphics.dispose();
		JFrame frame = new JFrame();
		frame.setSize(width, height);
		ImageIcon icon = new ImageIcon(newImage);
		JLabel label = new JLabel(icon);
		frame.add(label);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
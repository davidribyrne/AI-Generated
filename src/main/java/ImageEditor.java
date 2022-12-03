// Write a Java program that prompts the user to browse to a JPEG image. Add random text to the image and display it.
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class ImageEditor {
	public static void main(String[] args) {
		// Prompt user to browse to a jpeg image
		System.out.println("Please select a JPEG image:");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();
		BufferedImage image = null;

		try {
			// Read in the image
			image = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Create a Graphics2D object
		Graphics2D g2d = image.createGraphics();
		// Add random text to the image
		g2d.drawString("Hello World!", 25, 25);
		// Display the image
		g2d.drawImage(image, null, 0, 0);
	}
}
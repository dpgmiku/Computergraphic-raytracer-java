package cgtools;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageTexture {
	private BufferedImage	image;
	private int				width;
	private int				height;

	public ImageTexture(String filename) throws IOException {
		image = ImageIO.read(new File(filename));
		width = image.getWidth();
		height = image.getHeight();
	}

	public Vec3 samplePoint(double u, double v) {
		int x = (int) Math.floor(clamp(u) * (width - 1));
		int y = (int) Math.floor(clamp(v) * (height - 1));

		Color rgb = new Color(image.getRGB(x, y));
		return new Vec3(rgb.getRed() / 255.0, rgb.getGreen() / 255.0,
				rgb.getBlue() / 255.0);
	}

	private double clamp(double v) {
		return Math.abs(v % 1.0);
	}
}

package com.report.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class CheckCodeImage {
	public static final int NUM = 1;
	public static final int ABC = 2;
	public static final int NUM_ABC = 3;
	private int codeType = 3;

	private final String[] CODES = { "A", "B", "C", "D", "E", "F", "G", "H",
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
			"V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7",
			"8", "9" };

	private final String[] fontName = { "Arial", "Verdana", "Courier New",
			"Terminal" };

	private final int[] fontStyle = { 1, 3 };

	private Font font = null;

	private int fontSize = 15;

	private int codeNums = 5;

	private int lineWidth = 30;

	private int width = 65;

	private int height = 25;

	private int count = 3;

	private BufferedImage image = null;

	private StringBuffer randCode = new StringBuffer("");

	public CheckCodeImage() {
	}

	public CheckCodeImage(int codeType) {
		switch (codeType) {
		case 1:
			this.codeType = 1;
			break;
		case 2:
			this.codeType = 2;
			break;
		default:
			this.codeType = 3;
		}
	}

	public BufferedImage getImage() {
		this.image = new BufferedImage(this.width, this.height, 1);

		Graphics2D g = (Graphics2D) this.image.getGraphics();

		Random random = new Random();

		g.setColor(getRandColor(250, 255));
		g.fillRect(0, 0, this.width, this.height);

		g.setColor(getRandColor(0, 10));
		g.drawRect(0, 0, this.width - 1, this.height - 1);

		for (int i = 0; i < this.codeNums; ++i) {
			int randIndex = 0;
			switch (this.codeType) {
			case 1:
				randIndex = random.nextInt(10) + 26;
				break;
			case 2:
				randIndex = random.nextInt(26);
				break;
			default:
				randIndex = random.nextInt(36);
			}
			this.randCode.append(this.CODES[randIndex]);

			g.setColor(new Color(20 + random.nextInt(50), 20 + random
					.nextInt(50), 20 + random.nextInt(50)));
			int f = random.nextInt(4);
			int s = random.nextInt(2);
			this.font = new Font(this.fontName[f], this.fontStyle[s],
					this.fontSize);
			g.setFont(this.font);
			g.drawString(this.CODES[randIndex], 11 * i + 4, 15);
		}

		for (int i = 0; i < this.count; ++i) {
			g.setColor(new Color(random.nextInt(102), random.nextInt(102),
					random.nextInt(102)));

			int x = random.nextInt(this.width - this.lineWidth - 1) + 1;
			int y = random.nextInt(this.height - 7 - 1) + 1;
			int xl = random.nextInt(this.lineWidth);

			int yl = random.nextInt(7);
			g.drawLine(x, y, x + xl, y + yl);
		}

		g.dispose();

		return this.image;
	}

	public String getRandCode() {
		return this.randCode.toString();
	}

	private Color getRandColor(int fc, int bc) {
		Random random = new Random();

		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}

		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);

		return new Color(r, g, b);
	}

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("d:\\code.bmp");
		CheckCodeImage cci = new CheckCodeImage(1);
		ImageIO.write(cci.getImage(), "PNG", fos);
		System.out.println(cci.getRandCode());
	}
}
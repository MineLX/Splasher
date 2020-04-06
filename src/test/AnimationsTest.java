package test;

import main.AutoStage;
import main.D2DPaletteFactory;

public class AnimationsTest {
	public static void main(String[] args) {
		AutoStage.create(new D2DPaletteFactory(), 1000, 600);
	}
}

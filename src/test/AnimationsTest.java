package test;

import main.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AnimationsTest {

	private static BallRole ball;

	public static void main(String[] args) throws InterruptedException {
		D2DPaletteFactory paletteFactory = new D2DPaletteFactory();
		paletteFactory.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				ball.animate();
			}
		});
		AutoStage stage = new AutoStage(paletteFactory, 1000, 600);
		ClearRole container = new ClearRole(0x00C3FC);
		stage.addRole(container);

		ball = new BallRole(stage.getContext());
		container.addRole(ball);
		Thread.sleep(2000);
		ball.animate();
	}
}

package test;

import main.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestRoleTest {

	public static void main(String[] args) {
		d2d();
	}

	private static void d2d() {
		IPaletteFactory factory = new D2DPaletteFactory();
		factory.addKeyListener(new MyKeyListener());

		AutoStage stage = AutoStage.create(factory, 1000, 600);
		stage.addRole(new TestRole(stage.getContext()));
	}

	private static class MyKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}
}

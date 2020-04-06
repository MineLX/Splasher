package test;

import main.*;

public class GraphStageTest {
	public static void main(String[] args) {
		AutoStage stage = AutoStage.create(new AwtPaletteFactory(), 1000, 600);
		stage.addRole(new TestRole(stage.getContext()));
	}
}

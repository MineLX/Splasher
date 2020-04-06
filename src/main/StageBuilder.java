package main;

public abstract class StageBuilder {
	protected final Context context;
	protected final IPaletteFactory factory;

	public StageBuilder(int width, int height, IPaletteFactory factory) {
		context = new Context(width, height);
		this.factory = factory;

		factory.addCleanup(() -> context.getCleanups().forEach(Runnable::run));
	}

	public abstract AutoStage createStage();
}

package main;

import java.util.ArrayList;
import java.util.List;

public class Context {

	public final int width;

	public final int height;

	private final List<Runnable> cleanups;

	Context(IPaletteFactory paletteFactory, int width, int height) {
		this.width = width;
		this.height = height;

		cleanups = new ArrayList<>();
		paletteFactory.addCleanup(() -> cleanups.forEach(Runnable::run));
	}

	public void addCleanUp(Runnable cleanup) {
		cleanups.add(cleanup);
	}

	public List<Runnable> getCleanups() {
		return cleanups;
	}
}

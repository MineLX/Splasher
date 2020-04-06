package main;

public abstract class Role {
	public void paint(IPalette palette) {
		palette.beginPaint();
		onDraw(palette);
		palette.endPaint();
	}

	protected abstract void onDraw(IPalette palette);
}

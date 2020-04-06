package main;

import com.zyh.pro.animator.main.animators.valueanimator.evaluations.Evaluator;

public class Oval {

	private int centerX;

	private int centerY;

	private int radiusX;

	private int radiusY;

	public Oval() {
	}

	public Oval(int centerX, int centerY, int radiusX, int radiusY) {
		locate(centerX, centerY, radiusX, radiusY);
	}

	public void locate(int centerX, int centerY, int radiusX, int radiusY) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.radiusX = radiusX;
		this.radiusY = radiusY;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public int getRadiusX() {
		return radiusX;
	}

	public int getRadiusY() {
		return radiusY;
	}

	@Override
	public String toString() {
		return "Oval(" + centerX + ", " + centerY + ")";
	}

	public static class OvalEvaluator implements Evaluator<Oval> {
		private final Oval oval = new Oval(0, 0, 0, 0);

		@Override
		public Oval evaluate(float f, Oval start, Oval end) {
			oval.centerX = convert(start.centerX, end.centerX, f);
			oval.centerY = convert(start.centerY, end.centerY, f);
			oval.radiusX = convert(start.radiusX, end.radiusX, f);
			oval.radiusY = convert(start.radiusY, end.radiusY, f);
			return oval;
		}

		private int convert(int start, int end, float f) {
			return (int) (start + (end - start) * f);
		}
	}
}

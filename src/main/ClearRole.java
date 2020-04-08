package main;

public class ClearRole extends CompositeRole {

	private final int value;

	public ClearRole(int value) {
		this.value = value;
	}

	@Override
	protected void onBackground(IPalette palette) {
		palette.clear(value);
	}
}

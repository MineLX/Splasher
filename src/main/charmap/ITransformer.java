package main.charmap;

public interface ITransformer<T, R> {
	R forward(T target); // TODO INSPIRED by this: split method declaration

	T backward(R target);
}

package gen;
public class Dispatcher {
	public static void main(String[] args) {
		Strauss [] s = {new Strauss(40), new Strauss(45)};
		Penguin[] p = {new Penguin(10), new Penguin(11), new Penguin(12)};
		Controller<Strauss> c1 = new Controller(s);
		c1.display();
		Controller<Penguin> c2 = new Controller(p);
		Controller.weightCompare(c1, c2);
	}
}
class Bird{
	int weight;
	Bird(int weight){
		this.weight = weight;
	}
	void move() {
		
	}
}
class Strauss extends Bird{
	Strauss (int weight){
		super(weight);
	}
	void move() {
		System.out.println("Run");
	}
}
class Penguin extends Bird{
	Penguin(int weight){
		super(weight);
	}
	void move() {
		System.out.println("Swim");
	}
}
class Controller<T extends Bird>{
	T[] array;
	Controller(T[] array){
		this.array = array;
	}
	void display() {
		for(T temp : array) {
			temp.move();
		}
	}
	int weightDefine() {
		int sum = 0;
		for(T temp : array) {
			sum += temp.weight;
		}
		return sum;
	}
	static void weightCompare(Controller<?> c1, Controller<?> c2 ) {
		System.out.println(c1.weightDefine() - c2.weightDefine());
	}
}
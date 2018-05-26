package gomibako;

public class Work {

	public static void main(String[] args) {
		long diff = 620;
		System.out.println(diff);
		int min = ((int) ((diff % 60) / 30)) * 5;
		System.out.println(min);

	}
}

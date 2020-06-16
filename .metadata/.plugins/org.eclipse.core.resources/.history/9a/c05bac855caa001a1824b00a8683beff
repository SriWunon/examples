
public class Hiking {
	private static int down = 0;
	private static int steps = 0;
	private static boolean valley = false;

	public static void main(String[] args) {
		String[] walks = { "U", "D", "D", "D", "U", "D", "U", "U" };

		for (String walk : walks) {
			if (walk.contentEquals("D")) {
				steps--;
			} else if (walk.contentEquals("U")) {
				steps++;
			}

			if (steps < 0 && !valley) {
				valley = true;
				down++;
			} else if (steps == 0 && valley) {
				valley = false;
			}
		}

		System.out.println("valley[s]: " + down);
	}

}

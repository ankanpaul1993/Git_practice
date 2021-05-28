import java.util.*;

public class Collections_Example {

	public static void main(String[] args) {

		Collections_Example ce = new Collections_Example();

		ce.printUniqueNumbers();

	}

	/*
	 * public void hashMap() {
	 * 
	 * HashMap<Integer, String> hm = new HashMap<Integer, String>(); hm.put(0,
	 * "hello"); hm.put(1, "Gudbye"); hm.put(42, "morning"); hm.put(3,
	 * "evening"); System.out.println(hm.get(42)); hm.remove(42);
	 * System.out.println(hm.get(42)); Set sn = hm.entrySet(); Iterator it =
	 * sn.iterator(); // hashtable -pass table set collections
	 * while(it.hasNext()) System.out.println(it.next()); Map.Entry mp =
	 * (Map.Entry) it.next(); // System.out.println(mp.getKey());
	 * System.out.println(mp.getValue());
	 * 
	 * }
	 */
/*	public void ArrayList() {

		ArrayList<Integer> ar = new ArrayList<Integer>();

		ar.add(14);
		ar.add(6);
		ar.add(10);
		ar.add(13);
		Iterator<Integer> it = ar.iterator();

		int minNumber = ar.get(0);

		for (int i = 0; i < ar.size(); i++) {

			System.out.println(ar.get(i));

			if (minNumber > ar.get(i)) {

				minNumber = ar.get(i);

			}

		}

		System.out.println(minNumber);

	}*/

	public void printUniqueNumbers() {

		int a[] = { 4, 5, 6, 4, 5, 3, 3, 9, 0, 0 };

		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {

			int counter = 0;
			if (!al.contains(a[i])) {

				al.add(a[i]);

				counter++;
			}

			for (int j = i + 1; j < a.length; j++) {

				if (a[i] == a[j]) {

					counter++;
				}

			}

			if (counter == 1) {

				System.out.println(a[i] + "is the unique number");

			}
		}

	}
}

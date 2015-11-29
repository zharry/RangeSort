import java.util.Random;

public class Benchmarking {

	public static boolean printSorted = true;
	public static int tries = 10;
	public static int arraySize = Integer.MAX_VALUE / 5000;

	public static void main(String[] args) {

		long[][] rngResults = testRandom();
		
		System.out.println("Java Sort Times: " + rangeSort.averageArray(rngResults[0]));
		System.out.println("RangeSort Sort Times: " + rangeSort.averageArray(rngResults[1]));

	}

	//Return result as 2D array, 0 = Java Sort; 1 = Range Sort
	public static long[][] testRandom() {
		int[] unsortedArray = new int[arraySize];
		Random random = new Random();
		long[] javaTimes = new long[tries];
		long[] rangeSortTimes = new long[tries];

		for (int a = 0; a < tries; a++) {
			for (int i = 0; i < arraySize; i++)
				unsortedArray[i] = Math.abs(random.nextInt(Integer.MAX_VALUE / 50));

			// Benchmark Standard Sort Times
			final long startTimeJava = System.currentTimeMillis();
			int[] javaSorted = rangeSort.javaSortArray(unsortedArray);
			final long endTimeJava = System.currentTimeMillis();

			// Benchmark RangeSort Sort Times
			final long startTimeRange = System.currentTimeMillis();
			int[] rangeSorted = rangeSort.sortArray(unsortedArray);
			final long endTimeRange = System.currentTimeMillis();

			// Write to Results
			javaTimes[a] = endTimeJava - startTimeJava;
			rangeSortTimes[a] = endTimeRange - startTimeRange;
			
			if (printSorted) {
				for (int z = 0; z < unsortedArray.length; z++) {
					if (javaSorted[z] != rangeSorted[z]) {
						System.out.println("Range Sort Failed!");
						System.exit(0);
					} else {
						System.out.println(javaSorted[z]);
					}
				}
			}
		}
		
		return new long[][]{javaTimes, rangeSortTimes};
	}

	public static void testNearlySorted() {

	}

	public static void testReversed() {

	}

	public static void testUnique() {

	}

}

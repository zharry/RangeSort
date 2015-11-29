
import java.util.Arrays;

public class rangeSort {

	public static int[] sortArray(int[] a) {
		int rangeStart = Integer.MAX_VALUE;
		int rangeEnd = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < rangeStart)
				rangeStart = a[i];
			if (a[i] > rangeEnd)
				rangeEnd = a[i];
		}
		int[] occurances = new int[rangeEnd - rangeStart + 1];
		for (int i = 0; i < a.length; i++)
			occurances[a[i] - rangeStart] += 1;
		return a;
	}

	public static int[] javaSortArray(int[] a) {
		Arrays.sort(a);
		return a;
	}

	public static double averageArray(long[] a) {
		long total = 0L;
		for (int i = 0; i < a.length; i++)
			total += a[i];
		return (total / a.length);
	}

}

mport java.util.Arrays;


public class DesignReceipt {
	
	public static String[] intersperse(String s, String[] arr) {
		if (s == null || arr == null) {
			return null;
		}
		else {
			int length = arr.length;
			if (length < 2) {
			return arr;
			}
			else {
				String[] ret = new String[length * 2 - 1];
				ret[ret.length - 1] = arr[length - 1];
				for(int i = 0; i < length - 1; i++) {
					ret[i * 2] = arr[i];
					ret[i * 2 + 1] = s;
				}
			return ret;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				intersperse("bazil", new String[]{"a", null, "b"})));
		// output: [a, bazil, null, bazil, b]
		System.out.println(Arrays.toString(intersperse("bazil", new String[]{})));
		// output: []
		System.out.println(Arrays.toString(intersperse(null, null)));
		// output: null
		System.out.println(Arrays.toString(
				intersperse("bazil", new String[]{"o", "a", "n", "h"})));
		// output: [o, bazil, a, bazil, n, bazil, h]
	}
}

package ch11.inst;

public class Inst2 {
	public void arraySize() {
		int[] a = new int[10];
		System.out.println(a.length);
	}

	/**
	 * if_icmple
	 */
	public void cmp() {
		short f1 = 9;
		byte f2 = 10;
		System.out.println(f1 > f2);
	}

	/**
	 * fcmpl ifle
	 */
	public void cmp2() {
		float f1 = 9;
		float f2 = 10;
		System.out.println(f1 > f2);
	}

	/**
	 * if_acmpne if_acmpeq
	 */
	public void cmp3() {
		Object f1 = new Object();
		Object f2 = new Object();
		System.out.println(f1 == f2);
		System.out.println(f1 != f2);
	}

	/**
	 * tableswitch 连续
	 *
	 * @param i
	 */
	public void swtich1(int i) {
		switch (i) {
			case 1:break;
			case 2:break;
			case 3:break;
		}
	}

	/**
	 * lookupswitch 不连续
	 *
	 * @param i
	 */
	public void swtich2(int i) {
		switch (i) {
			case 100:break;
			case 200:break;
			case 300:break;
		}
	}

	/**
	 * 少数不连续 会编译为连续的tableswitch
	 *
	 * @param i
	 */
	public void swtich3(int i) {
		switch (i) {
			case 1:
				break;
			case 2:
				break;
			case 5:
				break;
			default:
		}
	}

	public void swtich4(String i) {
		switch (i) {
			case "geym":
				break;
			case "zbase":
				break;
			case "java":
				break;
			default:
		}
	}

	public void trycatch() {
		try {
			swtich3(1);
		} finally {
			swtich2(1);
		}
	}

}

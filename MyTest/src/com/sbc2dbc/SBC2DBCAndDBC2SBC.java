package com.sbc2dbc;

public class SBC2DBCAndDBC2SBC {

	public static final char SBC_SPACE = 12288; // 全角空格 12288

	public static final char DBC_SPACE = 32; // 半角空格 32

	// ASCII character 33-126 <-> unicode 65281-65374
	public static final char ASCII_START = 33;

	public static final char ASCII_END = 126;

	public static final char UNICODE_START = 65281;

	public static final char UNICODE_END = 65374;

	public static final char DBC_SBC_STEP = 65248; // 全角半角转换间隔

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
//			System.out.println("半角的空格ASCII码为："+(int)(' '));
//			System.out.println("全角的空格ASCII码为："+(int)('　'));
//			System.out.println((char)33);
//			System.out.println((char)126);
//			System.out.println((char)65281);
//			System.out.println((char)65374);
//			System.out.println(Character.MIN_VALUE);
//			System.out.println(Character.MAX_VALUE);
//			for(int  i = Character.MIN_VALUE;i<=Character.MAX_VALUE;i++){
//				System.out.println(i+"======"+(char)i);
//			}
		System.out.println("asdfghjkl"+">>>>>>>"+dbc2sbcCase("asdfghjkl"));
	}

	public static char sbc2dbc(char src) {
		if (src == SBC_SPACE) {
			return DBC_SPACE;
		}

		if (src >= UNICODE_START && src <= UNICODE_END) {
			return (char) (src - DBC_SBC_STEP);
		}

		return src;
	}

	/**
	 * Convert from SBC case to DBC case
	 * 
	 * @param src
	 * @return DBC case
	 */
	public static String sbc2dbcCase(String src) {
		if (src == null) {
			return null;
		}
		char[] c = src.toCharArray();
		for (int i = 0; i < c.length; i++) {
			c[i] = sbc2dbc(c[i]);
		}
		return new String(c);
	}

	public static char dbc2sbc(char src) {
		if (src == DBC_SPACE) {
			return SBC_SPACE;
		}
		if (src >= ASCII_START && src <= ASCII_END) {
			return (char) (src + DBC_SBC_STEP);
		}
		return src;
	}

	/**
	 * Convert from DBC case to SBC case.
	 * 
	 * @param src
	 * @return SBC case string
	 */
	public static String dbc2sbcCase(String src) {
		if (src == null) {
			return null;
		}

		char[] c = src.toCharArray();
		for (int i = 0; i < c.length; i++) {
			c[i] = dbc2sbc(c[i]);
		}

		return new String(c);
	}
}

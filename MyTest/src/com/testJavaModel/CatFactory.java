package com.testJavaModel;

public class CatFactory implements Factory {

	@Override
	public Animal createAnimal() {
		// TODO 自动生成的方法存根
		return new Cat();
	}

}

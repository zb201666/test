package com.testJavaModel;

public class CatFactory implements Factory {

	@Override
	public Animal createAnimal() {
		// TODO �Զ����ɵķ������
		return new Cat();
	}

}

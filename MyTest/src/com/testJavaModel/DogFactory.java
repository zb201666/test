package com.testJavaModel;

public class DogFactory implements Factory {

	@Override
	public Animal createAnimal() {
		// TODO �Զ����ɵķ������
		return new Dog();
	}

}

package com.testJavaModel;

public class TestAnimalFactory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Dog dog = (Dog) AnimalFactory.createAnimal("dog");
		dog.eat();
		Cat cat = (Cat) AnimalFactory.createAnimal("cat");
		cat.eat();
		
		
		//=================================================
		DogFactory df = new DogFactory();
		Dog dog1 = (Dog) df.createAnimal();
		dog1.eat();
		CatFactory cf = new CatFactory();
		Cat cat1 = (Cat) cf.createAnimal();
		cat1.eat();
	}

}

package com.testJavaModel;

public class AnimalFactory {
	public static Animal createAnimal(String animlName){
		if(animlName.equalsIgnoreCase("dog")){
			return new Dog();
		}else if (animlName.equalsIgnoreCase("cat")){
			return new Cat();
		}else{
			return null;
		}
	}
}

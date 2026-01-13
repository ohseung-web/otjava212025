package polymorphism;

import java.util.ArrayList;

public class AnimalTest {

	public static void main(String[] args) {
		AnimalTest  atest = new AnimalTest();
		
//        atest.moveAnimal(new Human());
//        atest.moveAnimal(new Tiger());
//        atest.moveAnimal(new Eagle());
        
        
		Animal[] animalList = new Animal[3];
		animalList[0]  = new Human();
		animalList[1]  = new Tiger();
		animalList[2]  = new Eagle();

		for(int i=0;i<animalList.length;i++) {
			animalList[i].move();
		}

//		ArrayList<Animal> animalList2 = new ArrayList<>();
//		animalList2.add(new Human());
//		
//		for(int i=0;i<animalList2.size();i++) {
//			animalList2.get(i).move();
//		}
  

	}

//	public void moveAnimal(Animal animal) {
//	     animal.move();
//	     
//	}

}

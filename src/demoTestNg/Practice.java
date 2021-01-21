package demoTestNg;

public class Practice {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		  // ClassNotFoundException Example
        // Provide any class name to Class.forName() which does not exist
        // Or compile Test.java and then manually delete Person.class file so Person class will become unavailable
        // Run the program using java Test

        Class clazz = Class.forName("Person"); //person class
        Person person = (Person) clazz.newInstance();
        person.saySomething();
	    
	}

}


class Person {
    void saySomething() {
        System.out.println("Hello");
    }
}
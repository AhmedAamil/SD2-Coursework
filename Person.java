/* I declare that my work contains no examples of misconduct, such as plagiarism, or collusion. Any code taken from other sources is referenced within my code solution.
Student ID / @author : 20211096 / W1953895 / Aamil Aliyar
Date: 20.03.2023
@version 2023-03-22 */

// Creating a new class file called Person (Person.java) with a constructor and the following attributes: name, surname, and email
public class Person {
    private String name;
    private String surName;
    private String email;

    public Person(String name, String surName, String email) {
        // Creating a constructor with the attributes: Name, Surname, E-mail
        this.name = name;
        this.surName = surName;
        this.email = email;
    }

    // Getters for the attributes
    public String getName() {
        return name;
    }
    public String getSurName() {
        return surName;
    }
    public String getEmail() {
        return email;
    }

    // Setters for the attributes
    public void setName(String name) {
        this.name = name;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
/* I declare that my work contains no examples of misconduct, such as plagiarism, or collusion. Any code taken from other sources is referenced within my code solution.
Student ID / @author : 20211096 / W1953895 / Aamil Aliyar
Date: 20.03.2023
@version 2023-03-22 */

// Creating a new class file called Ticket (Ticket.java) with a constructor and the following attributes: row, seat, price, and Person.
public class Ticket {
    private int row;
    private int seat;
    private double price;
    private Person person;

    // Creating a constructor with the attributes: Row, Seat, Price, Person
    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    // Getters for the Attributes
    public int getRow() {
        return row;
    }
    public int getSeat() {
        return seat;
    }
    public double getPrice() {
        return price;
    }
    public Person getPerson() {
        return person;
    }

    // Setters for the attributes
    public void setRow(int row) {
        this.row = row;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public String print(){
        // Creating a Method to print/ return Ticket information and the total price.
        return "Name: " + person.getName() + " " + person.getSurName() + "\nEmail: " + person.getEmail() + "\nRow Number: " + row + "\nSeat Number: " + seat + "\nPrice: " + "£" + price;
    }
}
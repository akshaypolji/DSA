package misc.classes;

public class Main {
    public static void main(String[] args){
        Cookie cookieOne = new Cookie("Blue");
        Cookie cookieTwo = new Cookie("Green");

        cookieOne.setColor("Yellow");

        System.out.println(cookieOne.getColor());
        System.out.println(cookieTwo.getColor());
    }
}

package datastructures.hashtable;

public class Main {
    public static void main(String[] args) {
        HashTable newHashTable = new HashTable();

        System.out.println("------ Before Adding Values ---- ");

        newHashTable.printTable();

        newHashTable.set("nails", 100);
        newHashTable.set("tile", 50);
        newHashTable.set("lumber", 80);
        newHashTable.set("bolts", 200);
        newHashTable.set("screws", 140);
        newHashTable.set("spanner", 25);


        System.out.println("------ After Adding Values ---- ");

        newHashTable.printTable();

        System.out.println("Lumber:");
        System.out.println( newHashTable.get("lumber") );

        System.out.println("\nBolts:");
        System.out.println( newHashTable.get("bolts") );

        System.out.println("\nSpanner:");
        System.out.println( newHashTable.get("spanner") );

        System.out.println(newHashTable.keys());


    }
}

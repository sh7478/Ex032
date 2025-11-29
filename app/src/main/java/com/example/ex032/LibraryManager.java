package com.example.ex032;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LibraryManager extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Map<UUID, LibraryItem> inventory = new HashMap<>();
        Book b1 = new Book(1997, "Harry Potter and the Philosopher's Stone", "J. K. Rowling", 223);
        Book b2 = new Book(1997, "Harry Potter and the Chamber of Secrets", "J. K. Rowling", 251);
        Book b3 = new Book(2005, "Percy Jackson and the Olympians The Lightning Thief", "Rick Riordan", 377);
        Magazine m1 = new Magazine(2023, "TIME", 13, "Adam");
        Magazine m2 = new Magazine(2025, "National Geographic", 20, "Jake");
        inventory.put(b1.getItemId(), b1);
        inventory.put(b2.getItemId(), b2);
        inventory.put(b3.getItemId(), b3);
        inventory.put(m1.getItemId(), m1);
        inventory.put(m2.getItemId(), m2);
        UUID id1 = b1.getItemId();
        UUID id2 = b2.getItemId();
        UUID id3 = b3.getItemId();
        UUID id4 = m1.getItemId();
        UUID id5 = m2.getItemId();
        System.out.println(inventory.get(id4));
        if(inventory.get(UUID.randomUUID()) == null)
        {
            System.out.println("There was no item with that ID");
        }

        b3.borrow();
        m2.borrow();

        for(LibraryItem item : inventory.values())
        {
            if(item.isBorrowed())
            {
                System.out.println(item.calculateLateFee(10));
            }
        }

        String query =  "Harry Potter";
        for(LibraryItem item : inventory.values())
        {
            if(item instanceof Searchable)
            {
                Searchable search =(Searchable)item;
                if(search.matches(query))
                {
                    System.out.println(item);
                }
            }
        }
    }
}

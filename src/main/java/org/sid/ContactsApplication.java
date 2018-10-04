package org.sid;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner {
    @Autowired
    private ContactRepository contactRepository;

    public static void main(String[] args) {
        SpringApplication.run(ContactsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        contactRepository.save(new Contact("Walter", "White", dateFormat.parse("12/12/1950"), "w.w@gmail.com", 0610234532L, "http://imgur.com/ZeEEd04"));
        contactRepository.save(new Contact("Daryl", "Dixon", dateFormat.parse("11/11/1960"), "d.d@gmail.com", 0323456543L, "http://imgur.com/2DFepO9"));
        contactRepository.save(new Contact("Daenerys", "Targaryen", dateFormat.parse("10/10/1980"), "d.t@gmail.com", 0423456543L, "http://imgur.com/dhO3Fa"));
        
        contactRepository.findAll().forEach(c -> {
            System.out.println(c.getFirstName());
        });
    }
}

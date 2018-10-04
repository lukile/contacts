package org.sid.web;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ContactRestService {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
    public Contact getContact(@PathVariable Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/searchContacts", method = RequestMethod.GET)
    public Page<Contact> search(@RequestParam(name = "mc", defaultValue = "") String mc,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "5") int size) {
        return contactRepository.search("%" + mc + "%", new PageRequest(page, size));
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public Contact save(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @RequestMapping(value = "contacts/{id}", method = RequestMethod.PUT)
    public Contact udpate(@PathVariable Long id, @RequestBody Contact contact) {
        contact.setId(id);
        return contactRepository.save(contact);
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Long id) {
        contactRepository.deleteById(id);
        return true;
    }
}
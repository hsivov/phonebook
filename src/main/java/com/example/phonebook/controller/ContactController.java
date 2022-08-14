package com.example.phonebook.controller;

import com.example.phonebook.entity.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {

    List<Contact> contacts;

    public ContactController() {
        this.contacts = new ArrayList<>();
    }

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject("contacts", contacts);
        return modelAndView;
    }

    @PostMapping
    public String add(Contact contactToAdd){
        boolean isNameExist = contacts.stream().anyMatch(contact -> contact.getName().equals(contactToAdd.getName()));

        if (!isNameExist && !contactToAdd.getName().isEmpty() && !contactToAdd.getNumber().isEmpty()){
            this.contacts.add(contactToAdd);
        }

        return "redirect:/";
    }

    @PutMapping
    public String update(Contact contactToChange) {
        for (Contact contact : contacts){
            if (contact.getName().equals(contactToChange.getName())){
                this.contacts.remove(contact);
                this.contacts.add(contactToChange);

                break;
            }
        }
        return "redirect:/";
    }

    @DeleteMapping
    public String delete(Contact contactToDelete) {
        contacts.removeIf(contact -> contact.getName().equals(contactToDelete.getName()));
        return "redirect:/";
    }
}

package se.lexicon.dao;

import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Email;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EmailDaoImpl implements EmailDao{
    //Instance -  Singleton pattern
    //1.create an object of EmailDaoImpl
    private static EmailDaoImpl instance;
    //2.make the constructor private so that this class cannot be
    //instantiated
    private EmailDaoImpl(){
        emailList = new ArrayList<>();
    }

    //3.Get the only object available
    public static EmailDaoImpl getInstance(){
        if (instance == null) {
            instance = new EmailDaoImpl();
        }
        return instance;
    }


    //declare a new empty list
    private List<Email> emailList;



    @Override
    public Email save(Email email) {
        /* Validate the parameters */
        if(email == null) throw new IllegalArgumentException("Email is null");
        //Create unique Id and save
        email.setId(UUID.randomUUID().toString());
        email.setCreateDateTime(LocalDateTime.now());
        //Create an email list that add email data into the storage
        emailList.add(email);
        // return email
        return email;
    }

    @Override
    public void update(Email email) {
        // Validation is not null
        if (email == null) throw new IllegalArgumentException("Email is null.");
        if (email.getId() == null) throw new IllegalArgumentException("Email id is null.");

        //Reuse the find method
        //find(email.getId());
        //when email exist we can update de person info -> existing email
        Email existingEmail = find(email.getId());
        //Set - get
        existingEmail.setSubject(email.getSubject());
        existingEmail.setRecipient(email.getRecipient());
        existingEmail.setContent(email.getContent());


    }

    @Override
    public Email find(String id) {
        //Check
        if(id == null) throw new IllegalArgumentException("Id is null.");
     return   emailList
             .stream()
             .filter(email -> email.getId().equals(id))
             .findFirst()
             .orElseThrow(() -> new DataNotFoundException("Email data with id:" + id + " not found"));

    }

    @Override
    public List<Email> findAll() {
        return new ArrayList<>(emailList);
    }

    @Override
    public List<Email> findBySubject(String subject) {

        if (subject == null) throw new IllegalArgumentException("Subject is null");

       return emailList.stream()
               .filter(email -> email.getSubject().equals(subject))
               .collect(Collectors.toList());

    }
}

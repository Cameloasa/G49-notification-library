package se.lexicon.dao;

import se.lexicon.model.Email;

import java.util.List;

public interface EmailDao extends NotificationDao<Email>{
    //Email save(Email email);
    //void update(Email email);
    //Email find(String id);
    //List<Email> findAll();

    List<Email> findBySubject(String subject);
}







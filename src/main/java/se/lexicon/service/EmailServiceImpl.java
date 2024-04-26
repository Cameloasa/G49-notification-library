package se.lexicon.service;

import se.lexicon.dao.EmailDao;
import se.lexicon.dao.EmailDaoImpl;
import se.lexicon.exception.EmailException;
import se.lexicon.model.Email;
import se.lexicon.util.EmailSender;

import java.util.List;

public class EmailServiceImpl implements EmailService {


    private EmailDao emailDAO;

    public EmailServiceImpl() {
        emailDAO = EmailDaoImpl.getInstance();
    }

    @Override
    public Email createAndSend(String recipient, String subject, String message) throws EmailException {
        //check if recipient is null
        if (recipient == null) {
            throw new IllegalArgumentException("Recipient is null");
        }
        //create and send email
        Email savadEmail = emailDAO.save(new Email(recipient, subject, message));
        //send email
        EmailSender.sendEmail(savadEmail.getRecipient(), savadEmail.getSubject(), savadEmail.getContent());
        //set status to true
        savadEmail.setStatus(true);
        //update email
        emailDAO.update(savadEmail);
        return savadEmail;
    }

    @Override
    public List<Email> findAll() {
        return emailDAO.findAll();
    }
}

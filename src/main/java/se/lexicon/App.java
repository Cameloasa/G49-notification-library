package se.lexicon;


import se.lexicon.dao.EmailDao;
import se.lexicon.dao.EmailDaoImpl;
import se.lexicon.exception.EmailException;
import se.lexicon.model.Email;
import se.lexicon.util.EmailSender;

public class App
{
    public static void main( String[] args )
    {   //Register inform into the database
        EmailDao emailDao = EmailDaoImpl.getInstance();
        try {

        //create object
        Email email = new Email("recipient.exaple@test","Subject test","Content test");
        //save to the storage
        Email savedEmail = emailDao.save(email);
        //Send email
        EmailSender.sendEmail(savedEmail.getRecipient(),savedEmail.getSubject(),savedEmail.getContent());
        //Update status
        savedEmail.setStatus(true);
        //update in the storage
        emailDao.update(savedEmail);
        //find in the storage

        Email foundEmail = emailDao.find(savedEmail.getId());
        //Print out the object
        emailDao.findAll().forEach(System.out::println);

        } catch (EmailException e) {
            System.out.println(e.getMessage());

        }
    }
}

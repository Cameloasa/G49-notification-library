package se.lexicon.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Email;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class EmailDaoTest {

    private EmailDaoImpl testObject;
    private Email savedEmail;

    @BeforeEach
    public void setup(){
        testObject = EmailDaoImpl.getInstance();
        //Create object
        Email email = new Email("recipient.exaple@test","Subject test","Content test");
        //Save to the storage
        savedEmail = testObject.save(email);
        //assertion
        assertNotNull(savedEmail);



    }
    @Test
    public void testSave(){
        //Create object
        Email email = new Email("recipient.exaple@test","Subject test","Content test");
        //Save to the storage
        Email savedEmail = testObject.save(email);
        //assertion
        assertNotNull(savedEmail);

        Email foundEmail = testObject.find(savedEmail.getId());
        assertEquals(savedEmail,foundEmail);
    }

    @Test
    public void testFindExistingId(){
        //save an email - it is in setup
        // find it
        Email foundEmail = testObject.find(savedEmail.getId());
        //found email should not be null
        assertNotNull(foundEmail);
        // compare it
        assertEquals(savedEmail,foundEmail);
    }

    @Test
    public void testFindNonExistingId(){
        assertThrows(DataNotFoundException.class,() ->testObject.find("Not existing id"));
    }



}

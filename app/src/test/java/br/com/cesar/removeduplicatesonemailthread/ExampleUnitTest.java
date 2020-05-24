package br.com.cesar.removeduplicatesonemailthread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.cesar.removeduplicatesonemailthread.util.Utils;

import static org.junit.Assert.*;

public class ExampleUnitTest {

    @Test
    public void checkRemoveDuplicates() {
        final List<String> emails = new ArrayList<>(Arrays.asList(
                "teste1@email.com", "teste1@email.com", "teste1@email.com",
                "teste2@email.com", "teste2@email.com", "teste2@email.com",
                "teste3@email.com", "teste3@email.com", "teste3@email.com",
                "teste4@email.com", "teste4@email.com", "teste4@email.com")
        );

        Utils.removeDuplicates(emails);

        assertEquals(emails.size(), 4);
        assertTrue(emails.contains("teste1@email.com"));
        assertTrue(emails.contains("teste2@email.com"));
        assertTrue(emails.contains("teste3@email.com"));
        assertTrue(emails.contains("teste4@email.com"));
    }

}
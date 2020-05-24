package br.com.cesar.removeduplicatesonemailthread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

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
    }

}
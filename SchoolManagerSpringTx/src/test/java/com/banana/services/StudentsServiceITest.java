package com.banana.services;

import com.banana.config.SpringConfig;
import com.banana.models.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
class StudentsServiceITest {

    @Autowired
    private IStudentService service;

    @Test
    void storeStudent() throws Exception {
        service.storeStudent(new Student("juan", "juare", 2));
    }

    @Test
    void getStudentByIndex() {
    }

    @Test
    void getStudentById() throws Exception {
        Student std = service.getStudentById(1L);
        System.out.println(std);
        assertNotNull(std);
    }

    /**
     * TESTS PARA TRANSACCIONES
     **/
    // One TX, everything works properly
    @Test
    public void testFind_WithRequiredTX_Positive() throws Exception {
        Student std = service.getStudentById(1L);
        assertNotNull(std);
        System.out.println("Found std" + std);
    }

    // Save a null item - should throw an exception when saving.
    @Test
    public void testSave_withNullStudent_negative() {
        String expectedExceptionEndString = "event with null entity";
        try {
            service.storeStudent(null);
            fail("Exception not thrown");
        } catch (Exception iae) {
            assertTrue(iae.getMessage().endsWith(expectedExceptionEndString));
        }
    }

    // Non-transactional method called - no TX
    @Test
    public void testSize_noTX_positive() {
        System.out.println(service.size());
    }

    // Batch persistence done with one null item that blows up when persisted
    // Exception thrown, complete TX rolled back with original TX settings.
    @Test
    public void testSaveBatch_withNullEntity_negative() {
        String expectedExceptionEndString = "event with null entity";
        try {
            service.saveCollection(grabBatch());
            fail("Exception not thrown");
        } catch (Exception iae) {
            assertTrue(iae.getMessage().endsWith(expectedExceptionEndString));
        }
    }

    @Test
    public void testSave_WithRequiredTX_positive() throws Exception {
        Student saveStdnt = new Student("Juan", "Juanez", 1);
        assertNull(saveStdnt.getId());
        service.storeStudent(saveStdnt);
        Long id = saveStdnt.getId();
        System.out.println("Save Test...id is: " + id);
        assertNotNull(id);
    }


    private Collection<Student> grabBatch() {
        Collection<Student> batch = new ArrayList<>();
        batch.add(new Student("Luisa", "Linares", 1));
        batch.add(new Student("José", "Juarez", 2));
        batch.add(new Student("Andre", "Andrade", 3));
        batch.add(null);
        return batch;
    }

}
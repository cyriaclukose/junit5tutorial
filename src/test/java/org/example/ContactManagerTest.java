package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContactManagerTest {


    ContactManager  contactManager;


    @BeforeAll
    public static void setupAll (){

        System.out.println("before ALl is executed before all the test. And executed only once");

    }

    @BeforeEach

    public void setUp(){

         contactManager=new ContactManager();

        System.out.println("Before Each is executed before each test");
    }


    @Test
    @DisplayName("test Contact Added")
    public void testIfContactAdded(){

        contactManager.addContact("james","joseph","1234567890");

        Assertions.assertFalse(contactManager.getContactList().isEmpty());
        Assertions.assertEquals(1,contactManager.getContactList().size());


    }

    @Test
    @DisplayName("Should not create contact when first name is null")
    public void  shouldThrowRunTimeExceptionWhenFirstNameIsNull(){

     Assertions.assertThrows(RuntimeException.class,()->{
         contactManager.addContact(null,"smith","2314567890");
     });
    }

    @Test
    @DisplayName("Should not create contact when last name is null")
    public void  shouldThrowRunTimeExceptionWhenLastNameIsNull(){

        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("john",null,"2314567890");
        });
    }

    @Test
    @DisplayName("Should not create contact when number is null")
    public void  shouldThrowRunTimeExceptionWhenNUmberIsNull(){

        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("john",null,"");
        });
    }


    @AfterEach
    public void tearDown(){

        System.out.println(" AfterEach is executed after each test");
    }

    @AfterAll
    public static void tearDownAll(){

        System.out.println(" AfterAll is executed after all the test is executed");
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ParameterizedNestedTest{
        @org.junit.jupiter.params.ParameterizedTest
        @ValueSource(strings ={"","1234","wer4","0123456789"})
        @DisplayName("test phone number invalid scenarios using ValueSource")
        public void  shouldThrowRuntimeExceptionwhenPhoneNumberIsInvalid(String phoneNumber){

            Assertions.assertThrows(RuntimeException.class,()->{
                contactManager.addContact("john",null,phoneNumber);
            });
        }

        @org.junit.jupiter.params.ParameterizedTest
        @MethodSource("phoneNumberList")
        @DisplayName("test phone number invalid scenarios using MethodSource")
        public void  shouldThrowRuntimeExceptionwhenPhoneNumberIsNotValid(String phoneNumber){

            Assertions.assertThrows(RuntimeException.class,()->{
                contactManager.addContact("john",null,phoneNumber);
            });
        }

        private     List<String> phoneNumberList(){

            return Arrays.asList("098778","","0123466778","0123456789");
        }



        @org.junit.jupiter.params.ParameterizedTest
        @CsvSource({"098778","0123466778","0123456789"})
        @DisplayName("test phone number invalid scenarios using CsvSource")
        public void  testUsingCsvSource(String phoneNumber){

            Assertions.assertThrows(RuntimeException.class,()->{
                contactManager.addContact("john",null,phoneNumber);
            });
        }


        @org.junit.jupiter.params.ParameterizedTest
        @CsvFileSource(resources = "/data.csv")
        @DisplayName("test phone number invalid scenarios using CsvFileSource")
        public void  testUsingCsvFileSource(String phoneNumber){

            Assertions.assertThrows(RuntimeException.class,()->{
                contactManager.addContact("john",null,phoneNumber);
            });
        }



    }




}

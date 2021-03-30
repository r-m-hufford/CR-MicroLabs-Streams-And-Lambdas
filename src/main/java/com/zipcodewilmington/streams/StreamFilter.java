package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;

    /**
     * No arg constructor
     */ //TODO - construct person stream of 100 person objects; startingCharacter is a random capital letter
    public StreamFilter() {
        this.personStream = Stream.generate(new PersonFactory()::createRandomPerson).limit(100);
        this.startingCharacter = RandomUtils.createCharacter('A','Z').toString();
    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        this.personStream = Stream.generate(new PersonFactory()::createRandomPerson).limit(people.length);
        this.startingCharacter = startingCharacter.toString();
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {
        this.personStream = Stream.generate(new PersonFactory()::createRandomPerson).limit(people.size());
        this.startingCharacter = startingCharacter.toString();
    }


    /**
     * @param people - Stream of person objects
     * @param startingCharacter - character to filter by
     */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = Stream.generate(new PersonFactory()::createRandomPerson).limit(people.count());
        this.startingCharacter = startingCharacter.toString();
    }


    /**
     * Using multi-line lambda syntax
     * @return a list of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListMultiLine() {
        return personStream.filter( person -> {return
        person.getName().startsWith(startingCharacter);
        }).filter(person -> {return
                person.getName().endsWith(startingCharacter);
        }) .collect(Collectors.toList());
    }
    //filter twice
    // once for starting character
    // once for ending character
    //then toString or array


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
        Predicate<Person>isPalindrome = person -> person.getName().charAt(0) == person.getName().charAt(2);
        return personStream.filter(isPalindrome).collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        Predicate<Person>isPalindrome = person -> person.getName().charAt(0) == person.getName().charAt(2);
        return personStream.filter(isPalindrome).toArray(Person[]::new);
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        return personStream.filter( person -> {return
                person.getName().startsWith(startingCharacter);
        }).filter(person -> {return
                person.getName().endsWith(startingCharacter);
        }) .toArray(Person[]::new);
    }

}

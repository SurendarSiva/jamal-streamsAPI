package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    int limit = 10;
    int counter = 0;
    // 1. Find people aged less or equal 18
    for(Person p : people){
      if(p.getAge()<=18){
        System.out.println(p);
        counter++;
      }
      if(counter == limit){
        break;
      }
    }



    // 2. Then change implementation to find first 10 people

  }

  @Test
  public void imperativeApproach1() throws IOException {
    List<Person> people = MockData.getPeople();
    List<Person> newPeople = new ArrayList<>();
    // 1. Find people aged less or equal 18
    for (Person p : people) {
      if (p.getAge() <= 18) {
        newPeople.add(p);
      }
    }

    for(Person result: newPeople){
      System.out.println(result);
    }

  }



    @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

    Predicate<Person> p = person -> person.getAge()<=18;


      //ctrl+W and ctrl+alt+V
      List<String> ageLessThan18 = people.stream()
              .filter(p)
              .limit(10)
              .map(Person::getFirstName)
              .collect(Collectors.toList());

      ageLessThan18.forEach(System.out::println);
      //System.out.println(ageLessThan18);

    }
}

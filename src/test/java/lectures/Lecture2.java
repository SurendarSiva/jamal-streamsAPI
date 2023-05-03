package lectures;

import beans.Person;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  @Test
  public void range() throws Exception {

    //leave 10
    IntStream.range(0,10).forEach(System.out::println);
    System.out.println();
    //include 10
    IntStream.rangeClosed(0,10).forEach(System.out::println);

  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();

    IntStream.range(0, people.size())
            .forEach(index->{
              Person person = people.get(index);
              System.out.println(person);
            });

  }

  @Test
  public void intStreamIterate() throws Exception {
      IntStream.iterate(0,value->5+value)
              .filter(i->i%2==0)
              .limit(10)
              .forEach(System.out::println);
  }
}

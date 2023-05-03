package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import beans.PersonDTOList;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.assertj.core.api.ListAssert;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    Predicate<Car> toyota = car -> car.getMake().equals("Toyota");
    Predicate<Car> carsYearPredicate = car -> car.getYear() > 2008;

    List<Car> carsFilter = cars.stream()
            .filter(toyota)
            .filter(carsYearPredicate)
            .collect(Collectors.toList());

    System.out.println(carsFilter);
    carsFilter.forEach(System.out::println);

  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

    List<PersonDTO> personDTOList = people.stream()
            .map(PersonDTO::map)
            .limit(1)
            .collect(Collectors.toList());

    //personDTOList.forEach(System.out::println);
    System.out.println(personDTOList.size());

    assertThat(personDTOList).hasSize(1);

  }

  @Test
  public void averageCarPrice() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    double average = cars.stream()
            .mapToDouble(Car::getPrice)
            .average()
            .orElse(0);

    System.out.println(average);

  }

  @Test
  public void test() throws Exception {

  }


}




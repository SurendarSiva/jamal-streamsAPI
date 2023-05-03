package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    List<Person> people = MockData.getPeople();
    long count = people.stream()
            .filter(person -> person.getGender().equalsIgnoreCase("Female"))
            .count();
    System.out.println(count);


  }

  @Test
  public void min() throws Exception {
    List<Car> cars = MockData.getCars();
    double min = cars.stream()
            .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(car -> car.getPrice())
            .min()
            //.getAsDouble();
            .orElseThrow(NoSuchElementException::new);

    System.out.println(min);


  }

  @Test
  public void max() throws Exception {
    List<Car> cars = MockData.getCars();
    double max = cars.stream()
            .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(car -> car.getPrice())
            .max()
            .getAsDouble();
            //.orElseThrow(NoSuchElementException::new);

    System.out.println(max);

  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();

    double avgCarPrice = cars.stream()
            .mapToDouble(Car::getPrice)
            .average()
            .getAsDouble();

    System.out.println(avgCarPrice);

  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
            .mapToDouble(Car::getPrice)
            .sum();
    System.out.println(sum);
    BigDecimal bigDecimal = BigDecimal.valueOf(sum);
    System.out.println(bigDecimal);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics stats = cars.stream()
            .mapToDouble(Car::getPrice)
            .summaryStatistics();
    System.out.println(stats);
    System.out.println(stats.getMax());
    System.out.println(stats.getMin());
    System.out.println(stats.getAverage());
    System.out.println(stats.getSum());
    System.out.println(stats.getCount());
  }

}
package lectures;


import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Test;

public class Lecture6 {

  final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;

  Predicate<Integer> pBy2 = i -> i % 2 == 0;
  @Test
  public void findAny() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Integer integer = Arrays.stream(numbers)
            .filter(pBy2)
            .parallel()
            .findAny()
            .get();

    System.out.println(integer);

  }

  @Test
  public void findFirst() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    Integer first = Arrays.stream(numbers)
            .filter(pBy2)
            .findFirst()
            .get();

    System.out.println(first);

  }
}


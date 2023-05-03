package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class Lecture3 {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

    Integer minValue = numbers.stream()
           .min((num1, num2) -> num1 < num2 ? -1 : 1)
            //.min(Comparator.naturalOrder())
            .get();

    //assertThat(minValue).isEqualTo(1);

    System.out.println(minValue);

  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

    Integer maxValue = numbers.stream()
            .max((num1, num2) -> num1 < num2 ? -1 : 1)
            //.max(Comparator.naturalOrder())
            .get();

    assertThat(maxValue).isEqualTo(100);

    System.out.println(maxValue);


  }
}

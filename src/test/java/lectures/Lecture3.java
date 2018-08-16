package lectures;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class Lecture3 {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

    Integer min = numbers.stream()
            .min(Comparator.naturalOrder())
            .get(); // retern Integer not stream

    assertEquals(min.intValue(), 1 );



  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

    Integer max = numbers.stream()
            .max(Comparator.naturalOrder())
            .get();

    assertEquals(max.intValue(), 100);

  }
}

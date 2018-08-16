package lectures;


import beans.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class Lecture8 {

  @Test
  public void simpleGrouping() throws Exception {
    List<Car> cars = MockData.getCars();

    Map<String, List<Car>> grouping = cars.stream()
            .collect(Collectors.groupingBy(Car::getMake));

    grouping.forEach((make, cars1) -> {
      System.out.println(make);
      cars1.forEach(System.out::println);

    });

  }

  @Test
  public void groupingAndCounting() throws Exception {
    ArrayList<String> names = Lists
        .newArrayList(
            "John",
            "John",
            "Mariam",
            "Alex",
            "Mohammado",
            "Mohammado",
            "Vincent",
            "Alex",
            "Alex"
        );

    Map<String, Long> nameCount = names.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    nameCount.forEach((a,b) -> {
      System.out.println("Name: " + a + " - " + b);
    });
  }

}
package lectures;

import beans.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture12 {
  @Test
  public void understandingCollect() throws Exception {
    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
//            How it works
//            .collect(
//              () -> new ArrayList<String>(), - constructor
//              (list, element) -> list.add(element), - accumulator
//              (list1, list2) -> list1.addAll(list2)
//            )
//            or
//            .collect(
//              ArrayList::new,
//              ArrayList::add,
//              ArrayList::addAll,
//            )
        .collect(Collectors.toList());

    emails.forEach(System.out::println);
  }
}

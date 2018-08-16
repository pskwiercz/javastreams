package lectures;


import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class Lecture10 {

  private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
      Lists.newArrayList("Mariam", "Alex", "Ismail"),
      Lists.newArrayList("John", "Alesha", "Andre"),
      Lists.newArrayList("Susy", "Ali")
  );

  @Before
  public void setUp() {
    System.out.println(arrayListOfNames);
  }

  @Test
  public void withoutFlatMap() throws Exception {
//    [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
    List<String> names = Lists.newArrayList();

    for(List<String> list: arrayListOfNames) {
      for(String name: list) {
        names.add(name);
      }
    }

    names.forEach(System.out::println);

  }

  @Test
  public void withFlatMap() throws Exception {
//   [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]

    List<String> listOLists = arrayListOfNames.stream()
//            .flatMap(list -> list.stream())
            .flatMap(List::stream)
            .collect(Collectors.toList());

    System.out.println(listOLists);

  }

}


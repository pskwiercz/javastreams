package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    String tmpString = "";

    for(String s : names) {
        tmpString  = tmpString + s + ":";
    }

    String joinedString = tmpString.substring(0, tmpString.length()-1);

    System.out.println(joinedString);

  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    String s = names.stream()
            .collect(Collectors.joining(":"));

    System.out.println(s);


    String s1 = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.joining("|"));

    System.out.println(s1);
  }
}

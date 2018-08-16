package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    final Predicate<Car> carPredicate = car -> car.getPrice() < 6000;

    List<Car> filterCars = cars.stream()
            .filter(carPredicate)
            .collect(Collectors.toList());

    filterCars.forEach(System.out::println);

    long carsNumber = cars.stream()
            .filter(car -> car.getPrice() < 10000)
            .count();

    System.out.println(carsNumber);
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

    Function<Person, PersonDTO> personPersonDTOFunction =
            person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge());


    List<PersonDTO> dtos = people.stream()
//            .map(person -> {
//              PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
//              return dto;
//            })
            // the same
//            .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge())
            // the same
            .map(personPersonDTOFunction)
            .collect(Collectors.toList());

    dtos.forEach(System.out::println);


  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices

    ImmutableList<Car> cars = MockData.getCars();

    Double averagePrice = cars.stream()
            .mapToDouble(Car::getPrice)
//            .mapToDouble(car -> car.getPrice())
            .average()
            .orElse(0);

    System.out.println(averagePrice);


  }

  @Test
  public void test() throws Exception {

  }
}




package org.wikipedia.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.wikipedia.learn.Job.JAVA_DEVELOPER;
import static org.wikipedia.learn.Job.QA_ENGINEER;

public class Main {
    public static void main(String[] args) {
        //intefejse funkcyjne
        //1.Supplier nic nie przyjmuje ale zwraca wartość
        Supplier<Double> supplier = ()->Math.random();//<>to jest to co parametr funkcyjny będzie zwracał (parametryzacja typu)
        System.out.println(supplier.get());//sout
        //2.Consumer ten interfejs funkcyjny przyjmuję zmienną ale nic nie zwraca
        Consumer<String> consumer = str-> System.out.println(str);
        consumer.accept("Super!");
        //3.Predicate przyjmuję dowlonego typu zmienną i zwraca booleana
        Predicate<String> predicate = str->str.isEmpty();
        System.out.println(predicate.test("o"));
        //4.Function coś przyjmuję i coś zwraca, pierwszy to co przyjmuję a drugi to co oddaje
        Function<String, Integer> function = str->str.length();
        System.out.println(function.apply("Jest fajnie!!!!"));


        //metoda referencyjna to krótsza lambda
        Supplier<Double> supplier1 = Math::random;//limit jedna metoda bez argumentów z tylko jedną funkcją
        System.out.println(supplier1.get());

        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("\nSuper!");

        Predicate<String> predicate1 = String::isEmpty;
        System.out.println(predicate1.test(""));

        Function<String, Integer> function1 = String::length;
        System.out.println(function1.apply("Jest fajnie!!!!"));

        System.out.println("\n###############################################");
        // The BiPredicate interface represents an operation that takes two arguments (T,U) and returns a boolean result.
        BiPredicate<String, String> bipredicate = (s1, s2) -> (s1.equals(s2));

        System.out.println(bipredicate.test("BORAJI", "BORAJI"));

//        The following example shows how to use the applyAsDouble() method of the DoubleBinaryOperator interface with lambda expression.

        DoubleBinaryOperator operator1 = (a, b) -> (a + b);
        DoubleBinaryOperator operator2 = (a, b) -> (a - b);
        DoubleBinaryOperator operator3 = (a, b) -> (a * b);
        DoubleBinaryOperator operator4 = (a, b) -> (a / b);

        System.out.println(operator1.applyAsDouble(5, 6));
        System.out.println(operator2.applyAsDouble(8, -10));
        System.out.println(operator3.applyAsDouble(8, 5));
        System.out.println(operator4.applyAsDouble(8, 4));

//        BiFunction Interface  is a functional interface whose functional method is R apply(T t, U u).
//        The BiFunction is interface represents an operation that takes two arguments (T and U) and returns a result R.

        System.out.println("BiFunction Interface - 'apply' example \n");
        BiFunction <Integer, Integer, Integer> biFunctionObj = (i1, i2) -> i1 + i2;

        System.out.println("Sum of 2 integer values 5 and 8 is: " + biFunctionObj.apply(5, 8));

        System.out.println("BiFunction Interface - 'andThen' example \n");

        BiFunction <Integer, Integer, Integer> biFunctionObj2 = (i1, i2) -> i1 * i2;

        Function <Integer, Integer> functionObj = (i) -> i / 2;

        System.out.println("The second result is: " + biFunctionObj2.andThen(functionObj).apply(10, 5));

//        java.util.function.UnaryOperator is a functional interface, which extends(rozszerza się) the java.util.function.Function interface.
//        The UnaryOperator interface represents an operation that takes a single argument and returns a result of same type as its input argument.

        UnaryOperator<Integer> operator = t -> t * 2;

        System.out.println(operator.apply(5));
        System.out.println(operator.apply(10));
        System.out.println(operator.apply(15));

        System.out.println("\n###############################################");
        Stream<String> namesStream = Stream.of("John", "Marry", "George", "Paul", "Alice", "Ann");

        namesStream
                .filter(e -> e.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);//chce wykonać wszystkie funkje poprzednie, terminalny operator

        System.out.println("\n##################Home Work#############################");
        System.out.println("\nad.1");
        //Pobrać długość każdego słowa którego liczba liter jest podzielna przez dwa, na wejściu będziemy mieli listę długość stringów
        List<String> strings = Arrays.asList("Żubr", "Koń", "Pingwin","Jeż","Orka");
        strings.stream()
                .map(String::length)
                .filter(s -> s%2==0)
                .forEach(System.out::println);
        System.out.println("\nad.2");
        //zsumować liczby nieparzyste
        List<Integer> intigers = Arrays.asList(5, 6, 88,39,18);
        int sum = intigers.stream()
                .filter(s -> s%2!=0)
                .mapToInt(i -> i)//zwraca mi int stream to jest potrzebne w wypadku .sum dla reduce nie.
//                .reduce(0, Integer::sum);
                .sum();
        System.out.println(sum);

        System.out.println("\nad.3");

        //Stwórz listę Person do której dodam kilka person
        List<Person> personList = Arrays.asList(
                new Person(12345, "Jan", "Malinowski", 19, JAVA_DEVELOPER),
                new Person(54321, "Janusz", "Kowalski", 22, QA_ENGINEER),
                new Person(34098, "Bartek", "Malinowksi", 23, QA_ENGINEER),
                new Person(67890, "Bartłomiej", "Nowak", 25, JAVA_DEVELOPER),
                new Person(19876, "Władysław", "Polak", 33, JAVA_DEVELOPER),
                new Person(13579, "Andrzej", "Prus", 29, JAVA_DEVELOPER),
                new Person(97531, "Stefan", "Sienkiewicz", 21, QA_ENGINEER),
                new Person(24680, "Maria", "Mickiewicz", 22, QA_ENGINEER),
                new Person(48642, "Basia", "Słowacka", 30, QA_ENGINEER),
                new Person(66666, "Michalina", "Bakalarczyk", 46, QA_ENGINEER)
        );

        //wynik to map gdzie kluczem jest job a wartością jest double, średnia wieku osób na danycm stanowisku
        personList.stream()
                .filter(s -> s.getJob()==QA_ENGINEER)
                .mapToDouble(i -> i.getAge())
                .average()
                .ifPresent(avg -> System.out.println("The average age for QA ENGINEER is " + avg));

        personList.stream()
                .filter(s -> s.getJob()==JAVA_DEVELOPER)
                .mapToDouble(i -> i.getAge())
                .average()
                .ifPresent(avg -> System.out.println("The average age for JAVA DEVELOPER is " + avg));
//                .forEach(System.out::println);

        Map<Job, Double> collect = personList.stream()
                .collect(Collectors.groupingBy(Person::getJob, Collectors.averagingInt(Person::getAge)));//tworzy struktury danych i stringi, collectors mówi nam do jakiego typu
        //danych ma być przekonwertowane w strumieniu
        System.out.println(collect);

        System.out.println("\n##################Home Work#############################");
        //Collect
        //1.Pogrupuj Person po Jobie, kluczem jest job a wartością lista person wynik: nazwa zawodu i przypisane osoby do niego
        System.out.println("ad1prim");
        Map<Job, List<String>> collect1 = personList.stream()
                .collect(Collectors.groupingBy(Person::getJob, Collectors.mapping(Person::getFirstName, Collectors.toList())));
        System.out.println(collect1);
        //2.Zlicz ile jest osób któe mają konkretny job wynik: nazwa zawodu i liczba osób pracujących w danym zawodzie
        System.out.println("ad2prim");
        Map<Job, Long> collect2 = personList.stream()
                .collect(Collectors.groupingBy(Person::getJob, Collectors.counting()));
        System.out.println(collect2);
        //3.Dla każdego z jobów przypsiać summary statistics(obiekt w javie) dla age. wynik: kluczem job a wartością summary statistics
        System.out.println("ad3prim");
        Map<Job, DoubleSummaryStatistics> collect3 = personList.stream()
                .collect(Collectors.groupingBy(Person::getJob, Collectors.summarizingDouble(Person::getAge)));
        System.out.println(collect3);
        //4.Pogrupuj joby tak żeby kluczem będzie job a wartością lista imion która ma ten job
        System.out.println("ad4prim powtorzenie ad1prim");
        Map<Job, List<String>> collect4 = personList.stream()
                .collect(Collectors.groupingBy(Person::getJob, Collectors.mapping(Person::getFirstName, Collectors.toList())));
        System.out.println(collect4);

    }
}

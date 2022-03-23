package org.example.goldman.roundthree;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    static  class Hosting {

        private int Id;
        private String name;
        private long websites;

        public Hosting(int id, String name, long websites) {
            Id = id;
            this.name = name;
            this.websites = websites;
        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getWebsites() {
            return websites;
        }

        public void setWebsites(long websites) {
            this.websites = websites;
        }

        //getters, setters and toString()
    }

    public static void main(String[] args) {
        Integer highest = Stream.of(1, 2, 3, 77, 6, 5)
                .max(Comparator.comparing(Integer::valueOf))
                .get();
        System.out.println("Highest :: " + highest);
        OptionalDouble average = Stream.of(1, 2, 3, 77, 6, 5).mapToInt(Integer::valueOf).average();

        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));

        // key = id, value - websites
        Map<Integer, Hosting> result1 = list.stream().collect(
                Collectors.toMap(Hosting::getId, Function.identity()));

    }
}

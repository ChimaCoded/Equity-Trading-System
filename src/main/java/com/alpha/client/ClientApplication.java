package com.alpha.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }



//
//
//    @Bean
//    ApplicationRunner init(ClientRepository repository) {
//
//        String[][] data = {
//                {"C01", "Andrew", "Paul", "pass", "An@paul.com", "300.12"},
//                {"C02", "Shanoon", "Paul", "pass", "An@paul.com", "300.12"},
//                {"C03", "Alision", "Paul", "pass", "An@paul.com", "300.12"}
//        };
//
//        return args -> {
//            for (String[] array : data) {
//                try {
//                    Client client = new Client(
//                            array[0],
//                            array[1],
//                            array[2],
//                            array[3],
//                            (Double) NumberFormat.getInstance().parse(array[5])
//                    );
//                    repository.save(client);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            }
//            repository.findAll().forEach(System.out::println);
//        };
//    }

}

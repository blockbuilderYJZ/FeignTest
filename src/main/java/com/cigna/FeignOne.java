package com.cigna;

import feign.Headers;
import feign.RequestLine;

import java.util.Random;

public interface FeignOne {

    @RequestLine("GET /hello")
    public String helloWorld(String word);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @RequestLine("POST /getUser")
    public User getUser(String name);

    class User{
        String name;
        String age;

        public User() {
        }

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}

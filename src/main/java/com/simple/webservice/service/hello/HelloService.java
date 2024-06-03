
package com.simple.webservice.service.hello;

import org.joda.time.LocalTime;

public class HelloService {
  public static void main() {
    LocalTime currentTime = new LocalTime();
    System.out.println("The current local time is: " + currentTime);

    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());
  }

  public static String getLocalTime() {
    LocalTime currentTime = new LocalTime();
    return "The current local time is: " + currentTime;
  }
}
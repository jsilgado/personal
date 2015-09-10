package jsilgado.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context =
             new ClassPathXmlApplicationContext("Beans.xml");

      PropertyInjection obj = (PropertyInjection) context.getBean("helloWorld");

      obj.getMessage();

      AutowiredBeanExample autowiredBeanExampleObj = (AutowiredBeanExample) context.getBean("autowiredBeanExample");

      autowiredBeanExampleObj.method();

   }
}
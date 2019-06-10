package oop;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: shiyunkai
 * @Date: 2019/05/30 09:19
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        //Employee john = new Employee("John", 10000);
        //Employee mary = new Employee("Mary", 20000);
        //Employee alis = new Employee("Alis");
        //alis.setSalary(1000);
        //
        //LinkedList<Employee> employees = new LinkedList<>();
        //employees.add(john);
        //employees.add(mary);
        //employees.add(alis);
        //
        //for (Employee emp : employees) {
        //    System.out.println(emp);
        //}

        // 自定义的linkedList
        LinkedList list = new LinkedList();
        for(int i = 0;i<20;i++){
            list.add(i);
        }
        for(Integer value:list){
            System.out.print(value+" ");
        }

    }
}

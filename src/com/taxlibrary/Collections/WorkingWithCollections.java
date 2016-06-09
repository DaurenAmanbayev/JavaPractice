package com.taxlibrary.Collections;

import com.taxlibrary.Exceptions.Customer;

import java.util.*;

/**
 * Created by ktoloc on 07.06.2016.
 */
public class WorkingWithCollections {

    //--------------------------------
    static void ArrayListMethods() {
        ArrayList customers = new ArrayList(3);
        Customer customer = new Customer("John", "Wrock");
        customers.add(customer);
        customers.add(5);
        customers.add("Yahoo");
        int totalItem = customers.size();

        for (int i = 0; i < totalItem; i++) {
            Object currentElement = customers.get(i);
            if (currentElement instanceof Customer) {
                Customer currentCustomer = (Customer) customers.get(i);
                currentCustomer.GetInfo();
            }
        }
        //перебор коллекции итератором
        Iterator ICust = customers.iterator();

        while (ICust.hasNext()) {
            System.out.println(ICust.next());
        }

        Enumeration enumCustomers = Collections.enumeration(customers);
        while (enumCustomers.hasMoreElements())
        {
            Customer currentCustomer=(Customer)enumCustomers.nextElement();

        }

        ArrayList<Customer> customersList=new ArrayList<>();

        customersList.add(customer);
        //customersList.add("1");!!!!ERROR
        for (Customer item: customersList) {
            customer.GetInfo();
        }
    }
    //связаннный список
    static void LinkedListMethods()
    {
        List passengerList = new LinkedList();

        passengerList.add("Alex Smith");
        passengerList.add("Mary Lou");
        passengerList.add("Sim Monk");

        ListIterator iterator = passengerList.listIterator();

        System.out.println(iterator.next());
        iterator.add("VIP Customer");
        iterator.previous();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());


    }

    //--------------------------
    static void SetMethods()
    {

    }
    static void Worker()
    {

    }
    //----------------------
    //key value pairs
    //Hashtable синхронизированный
    //HashMap несинхронизированный
    static void HashSet()
    {
        // TODO Auto-generated method stub

        HashSet sss = new HashSet();
        sss.add("Mary");
        sss.add("Mary");

        ArrayList aaa = new ArrayList();

        aaa.add("Mary");
        aaa.add("Mary");

        Vector bbb = new Vector();
        bbb.add("Marry");
        bbb.add("Marry");

        Map hm=new HashMap();
        hm.put("customer", new Customer("John", "Smith"));
      //  hm.put("order", new Order());


        Customer customer = new Customer("David", "Lee");
        Order order = new Order("Jack", 250);
        Portfolio portfolio = new Portfolio();
        Map data = new Hashtable();
        data.put("Customer", customer);
        data.put("Order",order);
        data.put("Portfolio", portfolio);
    }


}

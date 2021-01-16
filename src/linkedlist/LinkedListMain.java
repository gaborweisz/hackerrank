package linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gabor on 2019.07.01..
 */
public class LinkedListMain {
    public static void main(String[] args) {

        ListItem<Integer> head = new ListItem(1);

        for (int i = 0; i < 10; i++) {
            head = head.addToHead(i);
            head.addToTail(i);
        }


        List<ListItem> list = new LinkedList<>();

        while (head.nextItem != null){
            head = head.nextItem;
            list.add(head);
        }

        list.add(head);

        printList(list);


    }


    public static void printLst(List<? extends ListItem> items) {

        for (ListItem item : items) {
            System.out.println(item.item);
        }

    }

    public static void printList(List<? extends List> items) {

        for (List item : items) {
            System.out.println(item);
        }

    }
}

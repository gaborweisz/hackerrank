package linkedlist;

import java.awt.*;

/**
 * Created by gabor on 2019.07.01..
 */
public class ListItem<T extends Number> extends List{

    T item;
    ListItem<T> nextItem;

    public ListItem(T item) {
        this.item = item;
    }

    public ListItem<T> addToHead(T item) {
        ListItem newItem = new ListItem(item);
        newItem.nextItem = this;

        return newItem;
    }

    public void  addToTail(T item) {

        ListItem<T> lastItem = this;
        while (lastItem.nextItem != null) lastItem = lastItem.nextItem;

        ListItem newItem = new ListItem(item);
        lastItem.nextItem = newItem;
    }
}

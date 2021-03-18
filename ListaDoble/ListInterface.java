package ListaDoble;


import java.util.Iterator;

public interface ListInterface {

    /*
    essential operations
    */
    public boolean isEmpty();

    public int getSize();

    public void clear();

    public Object getHead();

    public Object getTail();

    public ListNodeDouble search(Object object);

    public boolean add(Object object);

    public boolean insert(ListNodeDouble node, Object object);

    public boolean insert(Object ob, Object object);

    public boolean insertHead(Object object);

    public boolean insertTail(Object object);

    public boolean remove(ListNodeDouble node);

    public boolean remove(Object object);

    /*
    expansion operations
     */
    public boolean contains(Object object);

    public Iterator<ListNodeDouble> iterator();

    public Object[] toArray();

    public Object[] toArray(Object[] object);

    public Object getBeforeTo();

    public ListNodeDouble getBeforeTo(ListNodeDouble node); 

    public Object getNextTo();

    public Object getNextTo(ListNodeDouble node);

    public DoubleList subList(ListNodeDouble from, ListNodeDouble to);

    public DoubleList sortList();

}


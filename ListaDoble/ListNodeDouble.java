package ListaDoble;


public class ListNodeDouble {
    private Object object;
    public ListNodeDouble next;
    public ListNodeDouble previous;


    public ListNodeDouble() {
        this.object = null;
        this.next = null;
        this.previous = null;
    }

    public ListNodeDouble(Object object, ListNodeDouble next, ListNodeDouble previous) {
        this.object = object;
        this.next = next;
        this.previous = previous;
    }
    public ListNodeDouble(Object object) {
        this.object = object;
        this.next = null;
        this.previous = null;
    }

    public Object getObject() { 
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public boolean isEquals(Object object) {
        if (this.getObject().toString().equals(object.toString())) {
            return true;
        }
        return false;
    }

    public boolean isEquals(ListNodeDouble node) {
        if (this.toString().equals(node.toString())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        try{
        return "ListNode{" +
                "object=" + object +
                ", next=" + next.getObject() +
                ", previous =" + previous.getObject() +
                '}';
        }catch(Exception e){
            if(next == null){
                return "ListNode{" +
                "object=" + object +
                ", next=" + "null" +
                ", previous =" + previous.getObject() +
                '}';
            }else{
                return "ListNode{" +
                "object=" + object +
                ", next=" + next.getObject() +
                ", previous =null" +
                '}';
            }
            
        }
        
    }
}

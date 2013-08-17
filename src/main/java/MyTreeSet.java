
public class MyTreeSet implements Comparable {
    private final String name;
    private final Integer price;

    public MyTreeSet(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
       MyTreeSet myTreeSet= (MyTreeSet)o;
        if(price.intValue()>myTreeSet.getPrice()){ return 1;}
       else if(price.intValue()==myTreeSet.getPrice()){ return 0; }
        else  return -1;
    }

    private int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

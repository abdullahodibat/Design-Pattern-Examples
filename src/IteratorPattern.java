
/**
 * Created by abdullahodibat.
 */
public class IteratorPattern {

    public static void main(String[] args){
        Cities cities = new Cities();
        Iterator cityIterator = cities.getIterator();
        System.out.println(cityIterator.next());
        System.out.println(cityIterator.next());
        System.out.println(cityIterator.next());
        System.out.println(cityIterator.next());
    }

    interface Iterator {
        boolean hasNext();

        Object next();
    }

    interface Container {
        Iterator getIterator();
    }

    static class Cities implements Container {

        String[] cities = {"berlin", "hamburg", "munich", "frankfurt"};

        @Override
        public Iterator getIterator() {
            return new CtitiesIterator();
        }

        private class CtitiesIterator implements Iterator {
            int index;

            @Override
            public boolean hasNext() {
                return index < cities.length;
            }

            @Override
            public Object next() {
                if(this.hasNext()){
                    return cities[index++];
                } else return null;
            }
        }
    }

}

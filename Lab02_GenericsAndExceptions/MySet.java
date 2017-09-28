
/* my array list: an array that behaves like a list 
 * E/14/158
 */

public class MySet<T extends Comparable> { 

    int nextItem; 
    int currentCapacity;
    T[] data; // DO NOT CHANGE

    private static int defaultSizeToCreate = 10; // how many elements to create 

    @SuppressWarnings("unchecked")
    public MySet(int elements) { 
      this.nextItem = 0; 
  		this.defaultSizeToCreate = elements; 
  		this.currentCapacity = elements;   
      this.data = (T[]) new Comparable[this.defaultSizeToCreate]; 
    }

    public MySet() { 
		  this(defaultSizeToCreate); 
    }

    public boolean isEmpty() { return this.nextItem == 0; } 
    public boolean isFull() { return false; /* never get filled */} 
    
    
    @SuppressWarnings("unchecked")
    public boolean add(T item) { 
  		try{
	      		data[nextItem] = null; // DO NOT CHANGE
		}
		catch(Exception e){
          		T[] ar=(T[]) new Comparable[(this.currentCapacity+=this.defaultSizeToCreate)];
  			for(int x=0;x<nextItem;x++)ar[x]=this.data[x];
  			this.data=ar;
		}
  		for(int x=0;x<nextItem;x++){
  			if(data[x].compareTo(item)==0){
  				return false;
  		  }
  		}
  		data[nextItem++]=item;
  		return true;
    }


    public T remove() {
  		if(isEmpty()) return null; 
  		T toReturn=this.data[0];
  		for(int x=0;x<this.nextItem;x++)this.data[x]=this.data[x+1];
  		this.nextItem--;
  		return toReturn;
    }
}



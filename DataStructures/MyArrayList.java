import java.util.Arrays;

public class MyArrayList {
  private int threshold = 16;
  private int noOfElements = 0;

  String[] sArr;
  Character[] cArr;
  Integer[] iArr;

  public MyArrayList(Object o){
    if(o instanceof String){
      sArr = new String[threshold];
    }
    else if(o instanceof Integer){
      iArr = new Integer[threshold];
    }
    else if (o instanceof Character) {
      cArr = new Character[threshold];
    }
  }
  public void add(Integer x){
    if (noOfElements > threshold-1) {
      Integer[] oldArr = iArr;
      iArr = new Integer[2*threshold];
      for(int i=0; i<oldArr.length; i++)
        iArr[i] = oldArr[i];
      threshold *= 2;
    }
    iArr[noOfElements] = x;
    noOfElements++;
  }
  public void add(String x){
    if (noOfElements > threshold-1) {
      String[] oldArr = sArr;
      sArr = new String[2*threshold];
      for(int i=0; i<oldArr.length; i++)
        sArr[i] = oldArr[i];
      threshold *= 2;
    }
    sArr[noOfElements] = x;
    noOfElements++;
  }
  public void add(Character x){
    if (noOfElements > threshold-1) {
      Character[] oldArr = cArr;
      cArr = new Character[2*threshold];
      for(int i=0; i<oldArr.length; i++)
        cArr[i] = oldArr[i];
      threshold *= 2;
    }
    cArr[noOfElements] = x;
    noOfElements++;
  }

  public void delete(Integer x){
    for (int i=0; i<iArr.length; i++) {
      if(x == iArr[i]){
        for(int j=i; j<iArr.length-1; j++){
          iArr[j] = iArr[j+1];
        }
      }
    }
    noOfElements--;
  }

  public void delete(String x){
    for (int i=0; i<sArr.length; i++) {
      if(x == sArr[i]){
        for(int j=i; j<sArr.length-1; j++){
          sArr[j] = sArr[j+1];
        }
      }
    }
    noOfElements--;
  }
  public void delete(Character x){
    for (int i=0; i<cArr.length; i++) {
      if(x == cArr[i]){
        for(int j=i; j<cArr.length-1; j++){
          cArr[j] = cArr[j+1];
        }
      }
    }
    noOfElements--;
  }

  public String get(int index, String o){
      return sArr[index];
  }
  public Integer get(int index, Integer o){
      return iArr[index];
  }
  public Character get(int index, Character o){
      return cArr[index];
  }

  public int indexOf(Integer x){
    for(int i=0; i<iArr.length; i++)
      if(x == iArr[i])
        return i;
    return -1;
  }
  public int indexOf(String x){
    for(int i=0; i<sArr.length; i++)
      if(x == sArr[i])
        return i;
    return -1;
  }
  public int indexOf(Character x){
    for(int i=0; i<cArr.length; i++)
      if(x == cArr[i])
        return i;
    return -1;
  }

  public int size(){
    return noOfElements;
  }

  public static void main(String[] args) {
    MyArrayList myList = new MyArrayList(new String());
    myList.add("Sourabh");
    myList.add("Meghana");

    String s = new String();
    for(int i=0; i<2; i++){
      System.out.println(myList.get(i, s));
    }
  }
}

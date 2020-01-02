import java.io.*;
import java.util.*;
import java.util.stream.*;

class Test
{
    public static void main(String[] args) {
        // List<Integer> list = Arrays.asList(1,2,3,4);
        // System.out.println(list);
        // System.out.println(list.stream().map(x->x+1).collect(Collectors.toList()));
        // Integer[] arr = {1,2,3,4};
        // System.out.println(Arrays.stream(arr).map(x->x+3).collect(Collectors.toList()).toArray());
        // Integer[] arr2 = list.stream().toArray(Integer[] :: new);
        // System.out.println(arr2[0]);
        // Arrays.stream(arr2).forEach(x -> System.out.println(x));
        // List<Integer> list = Arrays.asList(9,3,6,1,12,5);
        // System.out.println(list.stream().sorted().collect(Collectors.toList()));
        Integer[] arr = {9,3,6,1,12,5};
        // Arrays.stream(arr).sorted().forEach(x->System.out.print(x+" "));
        int sum = Arrays.stream(arr).reduce(0,(ans,i)->ans+i);
        System.out.println(sum);
    }
}
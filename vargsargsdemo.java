import java.util.Arrays;

class calc{


    public void add(int ... i){ //{reach as array}

        System.out.println(Arrays.toString(i));
    }


}


public class vargsargsdemo {
    public static void main(String[] args) {

        calc obj = new calc();

        

       obj.add(20, 50 , 20,304,20) ;

        

    }
    
}

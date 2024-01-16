package Week4.GenLL;

import Labs.lab06.GenLL;

public class GenLLTester {

    public static void main(String args[])
    {
        GenLL<Integer> iLL = new GenLL<Integer>();
        GenLL<Double> dLL = new GenLL<Double>();
        GenLL<String> strLL = new GenLL<String>();

        for (int i=4;i>=0;i--)
        {
            iLL.add(i);
            dLL.add((double)i);
            strLL.add("Str: "+i);
        }
        iLL.print();
        dLL.print();
        strLL.print();
    }

}

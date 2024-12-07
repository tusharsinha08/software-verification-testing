public class Q1 {
    

    public int add(int a, int b){
        return a + b;
    }

    public String reverse(String input){
        if(input == null){
            throw new IllegalArgumentException("Input cannot be null");
        }
        return new StringBuilder(input).reverse().toString();
    }
}
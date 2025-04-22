package Exceptii;

public class Exceptia1 {
    // clasa: error, exception, runtime exception, clase personalizate
    // le gestionam folosind cuvinte predefinite: try - catch si finally
    // 2 tipuri mari de exceptii: checked si unchecked
    // checked - exceptii de compilare (nu se poate face build sau nu se poate rula proiectul)
    // unchecked - exceptii la runtime

    public static void main(String[] args) throws ExceptiaCustom {
//
//        try{
//            System.out.println(12/0);
//        } catch (ArithmeticException e) {
//            System.out.println(e.getMessage());
//        }

        try {
            int[] numbers = new int[10];
            numbers[11] = 5;
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e){
//            System.out.println(e.getMessage());
            throw new ExceptiaCustom("Eroare personalizata");
        } finally {
            System.out.println("Aceasta linie se executa indiferent daca exceptia este prinsa sau nu");
        }
    }

}

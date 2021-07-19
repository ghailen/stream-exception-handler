package utils;

import com.ghailene.javastreamexceptionhandling.CheckedExceptionHandlerConsumer;

import java.lang.annotation.Target;
import java.util.function.Consumer;

public class StreamExceptionHandler {

    public static <Target, ExObj extends Exception> Consumer<Target> handleGenericException(Consumer<Target> targetConsumer, Class<ExObj> exObjClass) {
        return obj -> {
            try {
                targetConsumer.accept(obj);
            } catch (Exception ex) {
                try {
                    ExObj exObj = exObjClass.cast(ex);
                    System.out.println("exception : " + exObj.getMessage());
                } catch (ClassCastException ecx) {
                    throw ex;
                }
            }

        };
    }


    public static <Target> Consumer<Target> handleCheckedExceptionConsumer(CheckedExceptionHandlerConsumer<Target,Exception> handlerConsumer){
        return obj ->{
            try{
                handlerConsumer.accept(obj);}
            catch (Exception ex){
                throw new RuntimeException(ex);
            }
        };
    }

}

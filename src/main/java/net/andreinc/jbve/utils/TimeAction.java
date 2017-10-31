package net.andreinc.jbve.utils;

import java.util.function.Function;
import java.util.function.Supplier;

public class TimeAction {

    public static <Ret, Input> TimeActionResponse<Ret> recordTimeAndDo(Function<Input, Ret> function, Input val) {
        long t1 = System.currentTimeMillis();
        Ret result = function.apply(val);
        long t2 = System.currentTimeMillis() - t1;
        return new TimeActionResponse<>(result, t2);
    }

    public static <Ret> TimeActionResponse<Ret> recordTimeAndDo(Supplier<Ret> supplier) {
        long t1 =System.currentTimeMillis();
        Ret result = supplier.get();
        long t2 = System.currentTimeMillis() - t1;
        return new TimeActionResponse<>(result, t2);
    }

}

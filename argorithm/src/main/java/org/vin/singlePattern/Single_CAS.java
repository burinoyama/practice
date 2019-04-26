package org.vin.singlePattern;

import java.util.concurrent.atomic.AtomicReference;

public class Single_CAS {

    private static final AtomicReference<Single_CAS> INSTANCE = new AtomicReference<>();

    private Single_CAS(){}

    public static Single_CAS getInstance() {
        for (; ; ) {
            Single_CAS single = INSTANCE.get();
            if (single != null) {
                return single;
            }
            single = new Single_CAS();
            if (INSTANCE.compareAndSet(null, single)) {
                return single;
            }
        }
    }

}

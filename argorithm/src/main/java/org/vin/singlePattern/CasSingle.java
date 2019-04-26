package org.vin.singlePattern;

import java.util.concurrent.atomic.AtomicReference;

public class CasSingle {

    private static final AtomicReference<CasSingle> INSTANCE = new AtomicReference<>();

    private CasSingle(){}

    public static CasSingle getInstance() {
        for (; ; ) {
            CasSingle single = INSTANCE.get();
            if (single != null) {
                return single;
            }
            single = new CasSingle();
            if (INSTANCE.compareAndSet(null, single)) {
                return single;
            }
        }
    }

}

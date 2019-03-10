package pl.n2god.util;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

    private static AtomicLong lastId = new AtomicLong(0);

    public static Long next() {
        return lastId.incrementAndGet();
    }
}

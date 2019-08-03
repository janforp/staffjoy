package xyz.staffjoy.faraday.config;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 类说明：
 *
 * @author zhucj
 * @since 2019-08-03 - 19:29
 */
public class ThreadLocalRandomTest {

    @Test
    public void testRandom() {
        Map<Integer, Integer> numMap = Maps.newHashMapWithExpectedSize(5);
        ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int i = 0; i < 100; i++) {
            int nextInt = current.nextInt(0, 5);
            Integer value = numMap.get(nextInt);
            if (value == null) {
                numMap.put(nextInt, 1);
            } else {
                numMap.put(nextInt, ++value);
            }
        }
        System.out.println(numMap);
    }
}

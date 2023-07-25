package com.gubin.api.config.lock;


import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicMarkableReferenceTest {
    // 注意：如果引用类型是Long、Integer， Short、Byte、 Character 一定一定要注意值所爱存区问！
    // 比Long、Integer， Short、Byte 缓存区间是在-128~127，会直接存在常量池中，而不在这个区间内对象的值则会每,次都new一个对象，那么即使两个对象的值相同，CAS 方法都会返园False
    // 先声明初始值，修改后的值和临时的值是为了保证CAS方法不会因为对象不一样而返回false¬
    private static final Integer INIT_NUM = 1000;
    private static final Integer UPDATE_NUM = 100;
    private static final Integer TEM_NUM = 200;
    private static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(INIT_NUM, 1);

    public static void main(String[] args) {
        Integer value = (Integer) atomicStampedReference.getReference();
        int stamp = atomicStampedReference.getStamp();
        System.out.println(Thread.currentThread().getName() + "当前值为：" + value + " 版本号为：" + stamp);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (atomicStampedReference.compareAndSet(value, UPDATE_NUM, 1, stamp + 1)) {
            System.out.println(Thread.currentThread().getName() + "当前值为：" + value + " 版本号为：" + atomicStampedReference.getStamp());
        } else {
            System.out.println("版本号不同，更新失败");
        }
    }
}

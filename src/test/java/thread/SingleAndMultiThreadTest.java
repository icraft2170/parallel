package thread;

import org.junit.jupiter.api.Test;

public class SingleAndMultiThreadTest {

    @Test
    void singleThread(){
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 500; i++)
            System.out.print(new String("-"));

            System.out.println("소요시간 1 : " + (System.currentTimeMillis() - startTime));

        for (int i = 0; i < 500; i++)
            System.out.print(new String("|"));

            System.out.println("소요시간 2 : " + (System.currentTimeMillis() - startTime));
    }

    @Test
    void multiThread(){
        long startTime = System.currentTimeMillis();
        Thread1 thread1 = new Thread1();
        thread1.setStartTime(startTime);
        thread1.start();

        for (int i = 0; i < 500; i++)
            System.out.print(new String("|"));

        System.out.println("소요시간 2 : " + (System.currentTimeMillis() - startTime));
    }

    static class Thread1 extends Thread{
        long startTime;

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        @Override
        public void run() {
            for (int i = 0; i < 500; i++)
                System.out.print(new String("-"));

            System.out.println("소요시간 1 : " + (System.currentTimeMillis() - startTime));
        }
    }

}

/**
 * 싱글 쓰레드
 *  - 절차적으로 하나 씩 작업이 수행된다.
 *  - 두 작업의 종료시간의 차이가 크지만 전체 시간은 상대적으로 효율적일 수 있다.
 * 멀티 쓰레드
 *  - 하나의 코어에서는 하나의 작업만 진행되기 때문에 한번의 하나씩만 수행되지만 두 쓰레드가 짧은시간 동안 서로 컨텍스트 스위칭(context switching)하며
 *  실행되기 때문에 한 번에 실행되는 것처럼 보인다.
 *  - 두 작업의 종료시간의 차이가 작지만 전체 시간은 상대적으로 비효율적일 수 있다.
 *
 *  쓰레드의 우선순위(Priority)
 *
 *  - Thread 내부에는 priority 라는 인스턴스 변수가 존재하고 이 우선순위의 값에 따라 쓰레드가 얻는 실행시간이 달라진다..
 *  - 우선 순위 변경은 priority의 setter 를 통해 가능하다, 다만 변경은 쓰레드 실행 이전에만 가능하다.
 *  - 다만 이 우선순위는 권고사항이다. 결국 OS에서 해당 스케쥴링 해주기 때문에. 확실한 것은 없다.
 *  ```
 *  class Thread implements Runnable { ... private int priority; ... }
 *  // priority 는 1 ~ 10 까지 가능하며 main method의 priority는 ( NORM_PRIORITY = 5 ) 5이다.
 *  // priority 는 높을 수록 우선순위가 높다.
 *  ```
 */



/**
 * 쓰레드 그룹(Thread Group)
 * - 서로 관련된 쓰레드를 그룹으로 다르기 위한 것으로 모든 쓰레드는 반드시 쓰레드 그룹에 포함되어야 한다.
 * - 기본적으로 JVM읜 main과 system이라는 쓰레드 그룹을 만들고 JVM운영에 필요한 쓰레드들을 생성하여 이 그룹에 포함시킨다.
 *  - ex : 가비지 컬렉션을 수행하는 Finalizer 쓰레드는 system 쓰레드 그룹에 속한다.
 * - 모든 쓰레드 그룹은 main Thread group의 자식 쓰레드그룹이 된다.또한 쓰레드를 생성할 때 쓰레드 그룹을 지정해주지 않는다면 main Thread group
 * 에 소속된다.
 * ```
 * public void uncaughtException(Thread t, Throwable e)
 *  // 쓰레드 그룹의 쓰레드가 처리되지 않은 예외에 의해 실행이 종료되었을 때, JVM에 의해 이 메서드가 자동적으로 호출된다.
 * ```
 */

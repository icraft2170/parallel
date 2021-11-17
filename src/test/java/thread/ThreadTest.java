package thread;

import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    void threadTest(){
        // Thread 를 상속받은 클래스의 인스턴스 생성
        ThreadExtendsThread thread = new ThreadExtendsThread();

        // Runnable 구현한 클래스의 인스턴스 생성 방법 3가지
        Runnable runnable = new ThreadImplementRunnable();
        Thread runnableThread = new Thread(runnable);

        // 이름이 변경
        thread.setName(" Thread 를 상속받은 ThreadExtendsThread ");
        thread.start();
        /**
         * Thread.start() -> 실행 대기상태에 있다가 자신이 차례가 되면 실행한다. 실행순서는 (OS의 스케쥴러가 결정한다.)
         * 한 번 종료된 쓰레드는 다시 실행할 수 없다. 하나의 쓰레드의 start()는 단 한 번만 호출될 수 있다. 두 번 이상 실행시
         * IllegalThreadStateException 발생
         */

        runnableThread.setName(" Runnable 을 구현한 ThreadImplementRunnable ");
        runnableThread.start();
        // Todo: 별도의 Runnable 구현체라면 실행되지 않는다. 이유는 ?...
        //runnableThread.run();



        // 'Runnable'은 Functional Interface
        Thread runnableThreadWithLambda = new Thread(() -> {
            System.out.println(" 람다와 함께한 Thread ");
        });
        runnableThreadWithLambda.start();
        // Todo: 이게 또 람다로는 정상 실행이 된다?? 이유 알아보자... ( 순서문제는 아님. 바꿔도 실행됨 )
        runnableThreadWithLambda.run();


        /**
         * public Thread(Runnable target) {this(null, target, "Thread-" + nextThreadNum(), 0);}
         *
         *  ----- Thread Class 에서 발췌 ----
         *
         *     Runnable target;
         *
         *     @Override
         *     public void run() {
         *         if (target != null) {
         *             target.run();
         *         }
         *     }
         *
         *     - 정리 : Thread 클래스는 Runnable 을 확장하고 Runnable 의 run()을 실행하도록 한다. Decorator 패턴으로 구성
         *     - 데코레이터 패턴 : 인터페이스를 구현체로 다형성을 통해 계속 아래로 내려가면서 확장해나가는 방법.
         *     - Thread가 확장한 기능을 필요할 때 직접 뜯어보자.
         */
    }
}

/**
 * 프로세스와 쓰레드
 * 프로세스
 *  - OS로 부터 자원을 할당받아 실행중인 프로그램
 * 쓰레드
 *  - 프로세스 내부에서 실제로 작업을 수행하는 일꾼으로 하나의 쓰레드는 하나의 호출스택을 가진다.
 *
 * 멀티태스킹과 멀티쓰레딩
 *
 * 멀티태스킹
 *  - OS에서 여러개의 프로세스를 동시에 실행될 수 있으면 멀티태스킹이 지원되는 OS라고 할수 있다. 하지만 사실 하나의 core는 한 번에 단 하나의 작업만 수행
 *  한다.
 * 멀티쓰레딩
 *  - 두 개이상의 쓰레드가 작업을 번갈아 가면서 수행한다. ( 하나의 코어는 하나의 일만 )
 *
 *  > 멀티쓰레딩의 장점
 *  > 1. CPU의 사용률을 항상시킨다.
 *  > 2. 자원을 보다 효율적으로 사용 할 수 있다.
 *  > 3. 사용자에 대한 응답성이 향상된다.
 *  > 4. 작업이 분리되어 코드가 간결해진다.
 *
 *  > 멀티쓰레딩에 생길 수 있는 문제점
 *  > 여러 쓰레드가 같은 프로세스 내에서 자원을 공유하면서 작업을 하기 때문에 발생할 수 있는 동기화(synchronization), 교착상태(deadlock)와 같은
 *  > 문제들을 고려해서 신중히 프로그래밍 해야한다.
 */


/**
 *
 *  start() 와 run()
 *
 *  - run() 을 호출하게 되면 현재 콜 스택 위에 그대로 실행된다. Thread가 아니라 메소드를 호출하는 것.
 *  - start() 는 호출스택(Call Stack)을 생성한 다음에 run()을 호출해서. 생성된 호출스택에 run()이 첫 번째로 올라가게 한다.
 *      - 모든 쓰레드는 독립적인 작업을 위해 자신만의 호출스택을 필요로 하기 때문에 start()로 실행해야 한다.
 *
 *  - 프로세스는 실행 중인 사용자 쓰레드가 하나도 없을 때 종료된다.
 *  > 쓰레드의 종류
 *      1. 사용자 쓰레드(user thread)
 *      2. 데몬 쓰레드(daemon thread)
 *
 */
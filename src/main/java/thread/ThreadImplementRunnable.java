package thread;


/**
 * Runnable 인터페이스 구현  ( Functional Interface )
 *  쓰레드로 작업하고자 하는 내용을 'void run()'의 구현부에 채워주면 된다.
 */

public class ThreadImplementRunnable implements Runnable{
    @Override
    public void run() {
        // thread 작업하고자 하는 logic
        // 'Thread'를 상속받은 것과 달리 static method 를 통한 추가 경로가 필요..
        // 다만 Runnable을 구현해서 진행하면 Thread와 달리 추가 상속이 가능하다. ( 상속이 아니라 구현이기 때문 )

        System.out.println(Thread.currentThread().getName());

    }
}

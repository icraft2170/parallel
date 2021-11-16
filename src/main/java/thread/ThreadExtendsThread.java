package thread;


/**
 * Thread 는 'Runnable' 의 구현체
 * - Thread 는 그저 'Runnable'의 기능을 추가한 구현체
 */


public class ThreadExtendsThread extends Thread{
    @Override
    public void run() {
        // Thread 의 getName()출력
        System.out.println(getName());
    }
}

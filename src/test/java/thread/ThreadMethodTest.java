package thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.LockSupport;

public class ThreadMethodTest {

    @Test
    void a(){
        //given

        //when

        //then

    }
}

/**
 * static void sleep(...) - 지정된 시간 동안 쓰레드 정지 [ 호출한 쓰레드에 영향을 준다 ]
 * void join(...) - 지정된 시간 동안 쓰레드 실행, 시간 이후에는 종료하거나 본래 쓰레드로 돌아옴
 * void interrupt() - sleep(),join()등으로 일시정지상태인 쓰레드를 깨워서 실행 대기상태로 만듬.
 * static void yield() - 실행 중에 자신에게 주어진 실행시간을 다른 쓰레드에게 양보하고 자신을 실행대기가 된다.
 */

/**
 *  (Thread Status)
 *
 * public enum State {
 *     NEW,     <- 쓰레드가 생성되고 start()가 호출되지 않은 상태
 *     RUNNABLE, <- 실행 중 혹은 실행 가능 상태
 *     BLOCKED, <- 동기화블록에 의해 일시정지된 상태 (lock이 풀릴 때까지 기다리는 상태)
 *     WAITING, <- 쓰레드의 작업이 종료되지는 않았지만 실행가능하지 않은(unrrunnable) 일시정지상태
 *     TIMED_WAITING, <- TIMED_WAITING은 일시정지시간이 지정된 경우를 의미한다.
 *     TERMINATED; <- 쓰레드의 작업이 종료된 상태
 * }
 * Thread.getStatus()를 통해 호출
 *
 */


/**
 *  쓰레드의 생성에서 소멸까지
 *
 *  NEW -> start() 호출 -> RUNNABLE  -> TERMINATED
 *
 *  RUNNABLE -> sleep(),join(),wait() 호출 -> WAITING,BLOCKED -> notify(),interrupt() 호출 -> RUNNABLE
 *
 */


/**
 *  interrupt()와 interrupted()
 *
 *  run(){
 *      while(!interrupted){
 *          // interrupted()는 interrupt() 호출이전에는 false 반환
 *          //logic
 *      }
 *  }
 *
 *  WAITING 상태에서 interrupt() 호출시 InterruptedException 발생 RUNNABLE 상태로 변경
 */


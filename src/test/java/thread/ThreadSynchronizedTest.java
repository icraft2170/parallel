package thread;

public class ThreadSynchronizedTest {


    // 잠금 (lock)



}

/**
 *  공유하는 영역을 여러 쓰레드가 동시에 사용한다면, 원하지 않는 결과값이 나올 수 도있다. (동시성 문제?)
 *  이 때 공유 데이터를  임계 영역(critical section)으로 선언하고 공유 데이터가 가진 lock을 획득한 이후 단 하나의 쓰레드만
 *  해당 영역 내의 코드를 수행할 수 있도록 한다. 해당 임계영역을 벗어나서 lock을 반납해야 다른 쓰레드가 임계영역의 코드를 실행할 수 있게된다.
 *
 *  -> 이렇게 한 쓰레드가 접근한 임계영역에 다른 쓰레드가 접근하지 못하도록 막는것을 쓰레드의 동기화(synchronization)
 *
 *  - synchronized -> 임계영역 설정 키워드
 *      - public synchronized void method(){ 임계영역 } : 메서드를 임계영역 설정
 *      - synchronized(객체 참조변수){ 임계 영역 } : 일정 블록에 임계영역 설정
 *      - 임계영역을 멀티쓰레딩환경에서 성능문제를 발생시킬 수 있기 때문에 최소화 해야한다.
 *
 */
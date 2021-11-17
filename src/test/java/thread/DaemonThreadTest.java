package thread;

public class DaemonThreadTest {
}

/**
 * Daemon Thread
 * - 데몬 쓰레드는 다른 일반 쓰레드의 작업을 돕는 보조적인 역할을 수행하는 쓰레드
 *  - ex) GC, 워드프로세서의 자동저장, 화면 자동 갱신등.
 * - 데몬 쓰레드는 무한르프와 조건문을 이용해 실행후 대기하다가 특정 조건이 만족하면 작업을 수행하고 다시 대기하도록 작성한다.
 * - 데몬 쓰레드는 일반 쓰레드와 작성방법과 실행방법이 같으며 다만 쓰레드를 생성한 다음 실행하기 전에 setDaemon(true)를 호출하기만 하면된다
 * ================================================================
 *     // default : false ( 일반 쓰레드 )
 *     private boolean daemon = false;
 *
 *     // daemon 쓰레이인지 여부 확인 ( method에 final은 오버라이딩 불가 )
 *     public final boolean isDaemon() {return daemon;}
 *
 *     // daemon 여부 설정.
 *     public final void setDaemon(boolean on) {
 *         checkAccess();
 *         if (isAlive()) {
 *             throw new IllegalThreadStateException();
 *         }
 *         daemon = on;
 *     }
 * ==================================================================
 */

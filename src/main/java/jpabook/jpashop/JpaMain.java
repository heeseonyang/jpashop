package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();/*트렌젝션 생성 */
        //엔티티 매니저는 데이터 변경시 트랜젝션을 시작해야 한다.
        tx.begin(); /*트렌젝션 시작*/

        try {

            tx.commit(); /*완전 초기화 되기 때문에 커밋을 해도 아무일도 일어나지 않아*/
        }catch (Exception e) {

            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

}

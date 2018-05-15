
package pl.coderslab.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Tweet;

@Component
@Transactional
public class TweetDao {
    @PersistenceContext
    EntityManager em;

    public TweetDao() {
    }

    public void save(Tweet entity) {
        this.em.persist(entity);
    }
}

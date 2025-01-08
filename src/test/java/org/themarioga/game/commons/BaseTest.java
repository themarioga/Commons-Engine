package org.themarioga.game.commons;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import jakarta.persistence.EntityManager;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@SpringBootTest
@EnableAutoConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@Transactional
@Rollback
public class BaseTest {

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void beforeTests() {
        getCurrentSession().clear();

        getCurrentSession().createNativeQuery("CREATE TABLE t_configuration(conf_key TEXT NOT NULL, conf_value TEXT NOT NULL, PRIMARY KEY (conf_key))").executeUpdate();
        getCurrentSession().createNativeQuery("INSERT INTO t_configuration(conf_key, conf_value) VALUES ('default_language', 'es')").executeUpdate();
    }

    protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

}

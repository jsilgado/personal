package es.jsilgado.spring_aop_timer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.jsilgado.spring_aop_timer.ConfigBean;
import es.jsilgado.spring_aop_timer.Foo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ConfigBean.class)
public class TestAOP {
	@Autowired
    private Foo foo;
     
    @Test
    public void test()
    {
        foo.bar();
    }
}

package com.wiley.beginningspring.ch7.di;

import com.wiley.beginningspring.ch7.config.Ch7ConfigurationForDependencyInjection;
import com.wiley.beginningspring.ch7.model.Bar;
import com.wiley.beginningspring.ch7.model.Foo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.Inherited;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Ch7ConfigurationForDependencyInjection.class)
public class DependencyInjectionTests {
    @Autowired
    @Qualifier("foo1")
    private Foo foo1;

    @Autowired
    @Qualifier("foo2")
    private Foo foo2;

    @Autowired
    private Bar bar;

    @Test
    public void testInjections(){
        Assert.assertNotNull(foo1);
        Assert.assertNotNull(foo2);
        Assert.assertNotNull(bar);
    }

}

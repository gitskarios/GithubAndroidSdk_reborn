package com.alorma.github.sdk.core.bean;

import com.alorma.github.sdk.core.bean.generator.UserGenerator;
import com.sergiandreplace.testabean.Configuration;
import com.sergiandreplace.testabean.TestABean;
import com.sergiandreplace.testabean.exception.FieldException;
import com.sergiandreplace.testabean.generator.GeneratorFactory;
import org.junit.Test;

public class RepoTest {

  @Test
  public void shouldTestRepoBean() throws FieldException {
    GeneratorFactory factory = new GeneratorFactory();
    factory.add(new UserGenerator());
    Configuration config = new Configuration.Builder()
        .setGeneratorFactory(factory).build();
    new TestABean(Repo.class, config).test();
  }

}

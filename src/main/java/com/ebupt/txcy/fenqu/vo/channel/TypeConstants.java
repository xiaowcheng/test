package com.ebupt.txcy.fenqu.vo.channel;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties("fenqu.channel.type")
public class TypeConstants
{
  private List<Type> types = new ArrayList<>();
  
  public List<Type> getTypes() {
    return types;
  }
  
  public void setTypes(List<Type> types) {
    this.types = types;
  }
}

package com.ebupt.txcy.fenqu.vo.channel;

import com.ebupt.txcy.fenqu.vo.channel.QueryRespItem;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class QueryResp
{
  private List<QueryRespItem> items;
  private int name; //1:baidu 2:tx 3:sougou 4:360 5:dianhuabang 6:ali
  
  public void setName(int name)
  {
    this.name = name;
  }
  
  public int getName()
  {
    return this.name;
  }
  
  public QueryResp()
  {
    this.items = new LinkedList();
  }
  
  public List<QueryRespItem> getItems()
  {
    return this.items;
  }
  
  public void setItems(List<QueryRespItem> items)
  {
    this.items = items;
  }
  
  public void addItem(QueryRespItem item)
  {
    this.items.add(item);
  }
  
  public void setItems(Collection<QueryRespItem> items)
  {
    for (Iterator iterator = items.iterator(); iterator.hasNext();)
    {
      QueryRespItem queryRespItem = (QueryRespItem)iterator.next();
      this.items.add(queryRespItem);
    }
  }
}

/**
 * LiLu, 2014-11-11 AM10:47:29
 */
package com.ebupt.txcy.fenqu.vo.channel;

/**
 *
 */
public class QueryRespItem {
	
	private String number;	
	private Integer mold;	//0 yellow 1 mark  2 no mark  noyellow

	private String type;	//mark type
	private Integer count;	//mark count
	private Integer id = 1; //1 biaozhun 0 nobiaozhun
	
	private Integer isAuth;	//0 yellow auth   1 no yellow auth
	private String name;	//yellow description
	private String teldesc;
	
	
	public QueryRespItem(){}
	
	public QueryRespItem(String number){
		this.number=number;
		this.type="";
		this.count=0;
	}
	public QueryRespItem(String number,String type,Integer count){
		this.number=number;
		this.type=type;
		this.count=count;
	}
	//no mark no yellow
	public QueryRespItem(String number,Integer mold){
		this.number=number;
		this.mold=mold;
	}
	//mark
	public QueryRespItem(String number,String type,Integer count,Integer id,Integer mold){
		this.number=number;
		this.type=type;
		this.count=count;
		this.id=id;
		this.mold=mold;
	}
	//yellow
	public QueryRespItem(String number,String name,Integer isAuth,Integer mold,String teldesc){
		this.number=number;
		this.name=name;
		this.isAuth=isAuth;
		this.mold=mold;
		this.teldesc = teldesc;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getTeldesc() {
		return teldesc;
	}

	public void setTeldesc(String teldesc) {
		this.teldesc = teldesc;
	}

	public Integer getMold() {
		return mold;
	}

	public void setMold(Integer mold) {
		this.mold = mold;
	}

	public Integer getIsAuth() {
		return isAuth;
	}

	public void setIsAuth(Integer isAuth) {
		this.isAuth = isAuth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}
	public String getType() {
		return type;
	}
	public Integer getCount() {
		return count;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	

}

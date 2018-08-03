/**
 * 
 */
package com.webservice.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Administrator
 *
 */
@WebService
public class FisrtWebServiceImplement implements FisrtWebService {

	/* （非 Javadoc）
	 * @see com.webservice.server.FisrtWebService#getAddressByPhoneNo(java.lang.String)
	 */
	@Override
	@WebMethod(operationName="getAddressByPhoneNumber")
	public String getAddressByPhoneNo(String phoneNo) {
		// TODO 自动生成的方法存根
		return "输入的手机号码为-----"+phoneNo;
	}

}

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

	/* ���� Javadoc��
	 * @see com.webservice.server.FisrtWebService#getAddressByPhoneNo(java.lang.String)
	 */
	@Override
	@WebMethod(operationName="getAddressByPhoneNumber")
	public String getAddressByPhoneNo(String phoneNo) {
		// TODO �Զ����ɵķ������
		return "������ֻ�����Ϊ-----"+phoneNo;
	}

}

/**
 * 
 */
package com.webservice.server;

import javax.jws.WebService;

/**
 * @author Administrator
 *
 */
@WebService
public interface FisrtWebService {
	 String getAddressByPhoneNo(String phoneNo);
}

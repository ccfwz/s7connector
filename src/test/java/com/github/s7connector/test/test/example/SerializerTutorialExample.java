/*
Copyright 2016 S7connector members (github.com/s7connector)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.github.s7connector.test.test.example;

import com.github.s7connector.api.S7Connector;
import com.github.s7connector.impl.S7TCPConnection;
import com.github.s7connector.impl.serializer.S7SerializerImpl;

/**
 * @author Thomas Rudin (thomas@rudin-informatik.ch)
 *
 */
public class SerializerTutorialExample
{
	
	public static void main(String[] args) throws Exception
	{
		//Open TCP Connection
		S7Connector connector = new S7TCPConnection("10.0.0.240", 0, 2);
		
		//Create serializer
		S7SerializerImpl serializer = new S7SerializerImpl(connector);
		
		//dispense bean from DB100 and offset 0
		MyDataBean bean1 = serializer.dispense(MyDataBean.class, 100, 0);
		
		//Set some values
		bean1.bit1 = true;
		bean1.myNumber = 123;
		
		//Store bean to DB101 offset 0
		serializer.store(bean1, 101, 0);
		
		//Close connection
		connector.close();
	}

}

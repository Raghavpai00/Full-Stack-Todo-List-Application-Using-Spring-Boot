package com.Raghav.Project.myFristWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
//"say-hello"=>"hello!what are you learning today?"
	
	//say-hello
	//http://localhost:8080/say-hello
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "hello!what are you learning today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>my first HTML page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("my first html page with body changed");
		sb.append("</body>");
		sb.append("</html>");
		
		//return "hello!what are you learning today?";
	return sb.toString();
	}
	//
	//"say-hello-jsp"=>sayHello.jsp
	///myFristWebApp/src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
	    return "sayHello";  // Spring → /WEB-INF/jsp/sayHello.jsp
	}
}

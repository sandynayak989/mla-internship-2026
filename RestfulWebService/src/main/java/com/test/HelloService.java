package com.test;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/text")
	public String simplePlainTextResponse() {
		return "This is simple Restful webrservice";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/html/{debit}")
	public String htmlTextResponse(@PathParam("debit") String card) {
		return "<html><body><h1>Simple Html response card no: "+card+"</h1></body></html>";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String greetUserResponse(@QueryParam("msg") String msg) {
		return msg;
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDetails> listAllUserData(){
		UserDetails u1 = new UserDetails(1,"Rohit","sharma","rohit@gmail.com",23482368);
		UserDetails u2 = new UserDetails(1,"Virat","Kohli","virat@gmail.com",12344567);
		UserDetails u3 = new UserDetails(1,"Sandy","Nayak","sandy@gmail.com",7793378);
		return List.of(u1,u2,u3);
	}
}

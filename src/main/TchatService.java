package main;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import beans.MessageBean;
import beans.MessageSQLITE;

@Path("/TchatService")
public class TchatService {

	@Path("/sendMessage")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendMessage(String json) {
		Gson gson = new Gson();
		try {
			MessageBean m = gson.fromJson(json, MessageBean.class);
			MessageSQLITE.addMessage(m);
			return Response.status(200).build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(418).entity(gson.toJson("I'm a teapot !")).build();
		}

	}

	@Path("/getMessage")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getMessages() {
		Gson gson = new Gson();
		return Response.status(200).entity(gson.toJson(MessageSQLITE.getMessage())).build();
	}

}

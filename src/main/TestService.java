
package main;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import beans.Eleve;

@Path("/MonService")
public class TestService {

	@Path("/helloWorld")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		System.out.println("HellowWorld !!");
		return "HelloWorld";
	}

	@Path("/eleve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String eleve() {
		Eleve e = new Eleve();
		e.setNom("Bob");
		e.setPrenom("Bobob");
		e.setNote(1);

		Gson gson = new Gson();
		return gson.toJson(e);
	}

	@Path("/eleve2")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response eleve(@QueryParam("name") String name) {
		Eleve e = new Eleve();
		e.setNom(name);
		e.setPrenom("Bobob");
		e.setNote(1);

		Gson gson = new Gson();
		return Response.status(200).entity(gson.toJson(e)).build();
	}

	@Path("/elevePost")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String elevePost(String recu) {

		System.out.println(recu);

		Eleve e = new Eleve();
		e.setNom("Bob");
		e.setPrenom("Bobob");
		e.setNote(1);

		Gson gson = new Gson();

		e = gson.fromJson(recu, Eleve.class);
		return gson.toJson(e);
	}

}

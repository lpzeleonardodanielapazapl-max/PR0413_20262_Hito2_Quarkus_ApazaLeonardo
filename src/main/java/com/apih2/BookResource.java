package com.apih2;

import java.util.ArrayList;
import java.util.List;

import com.apih2.models.Book;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/book")
public class BookResource {

    private static final List<Book> books = new ArrayList<>();

    static {
        books.add(new Book(1, "cien annos de soledad", "Gabriel Garcia Marquez"));
        books.add(new Book(2, "El Principito", "Antoine de Saint-Exupéry"));
        books.add(new Book(3, "Don Quijote de la Mancha", "Miguel de Cervantes"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response ObtenerLibros() {
        return Response.ok(books).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ObtenerPorId(@PathParam("id") int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return Response.ok(b).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearLibro(Book nuevoLibro) {
        nuevoLibro.setId(books.size() + 1);
        books.add(nuevoLibro);
        return Response.status(Response.Status.CREATED).entity(nuevoLibro).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarLibro(@PathParam("id") int id, Book libroActualizado) {
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getId() == id) {
                libroActualizado.setId(id);
                books.set(i, libroActualizado);
                return Response.ok(libroActualizado).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
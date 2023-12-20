package velazquez.loteria_navidad.utils;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@WebServlet("/loteriaAPI")
public class loteriaAPI extends HttpServlet {
  static final Logger logger = LoggerFactory.getLogger(loteriaAPI.class);

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    logger.info("Request received");

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    List<URI> targets = null;
    try {
      targets =
              List.of(
                      new URI("https://api.elpais.com/ws/LoteriaNavidadPremiados?n=1405"));
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
    HttpClient client = HttpClient.newHttpClient();
    List<CompletableFuture<String>> futures =
        targets.stream()
            .map(
                target ->
                    client
                        .sendAsync(
                            HttpRequest.newBuilder(target).GET().build(),
                            HttpResponse.BodyHandlers.ofString())
                        .thenApply(HttpResponse::body))
            .collect(Collectors.toList());

    logger.info("Waiting for results...");
    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    logger.info("All results received.");
    List<String> results =
        futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    logger.info("Results: {}", results);

    // Convert the results to JSON and write it to the response
    String json = new Gson().toJson(results.get(0).replace("busqueda=", ""));
    logger.info("JSON: {}", json);
    response.getWriter().write(json);
  }
}

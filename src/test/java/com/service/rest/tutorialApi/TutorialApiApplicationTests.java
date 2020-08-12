/*
 * package com.service.rest.tutorialApi;
 * 
 * import static org.junit.jupiter.api.Assertions.assertNotNull;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.web.client.TestRestTemplate; import
 * org.springframework.boot.web.server.LocalServerPort; import
 * org.springframework.http.HttpEntity; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.test.context.junit.jupiter.SpringExtension;
 * 
 * @ExtendWith(SpringExtension.class)
 * 
 * @SpringBootTest class TutorialApiApplicationTests {
 * 
 * @Autowired private TestRestTemplate restTemplate;
 * 
 * @Test void contextLoads() { }
 * 
 * @LocalServerPort private int port;
 * 
 * private String getRootUrl() { return "http:/localhost:" + port; }
 * 
 * @Test public void getAllTutorials() { HttpHeaders headers = new
 * HttpHeaders(); HttpEntity<String> entity = new HttpEntity<>(null,headers);
 * 
 * ResponseEntity<String> responseEntity =
 * restTemplate.exchange(getRootUrl()+"/api/tutorials", HttpMethod.GET,entity,
 * String.class); assertNotNull(responseEntity.getBody()); }
 * 
 * 
 * }
 */
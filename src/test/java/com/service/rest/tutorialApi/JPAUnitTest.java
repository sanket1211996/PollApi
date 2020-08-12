/*
 * package com.service.rest.tutorialApi;
 * 
 * import static org.assertj.core.api.Assertions.assertThat;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; import
 * org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager; import
 * org.springframework.test.context.junit.jupiter.SpringExtension;
 * 
 * import com.service.rest.pollApi.model.Candidate; import
 * com.service.rest.pollApi.repository.CandidateRepository;
 * 
 * @ExtendWith(SpringExtension.class)
 * 
 * @DataJpaTest public class JPAUnitTest {
 * 
 * @Autowired TestEntityManager entityManager;
 * 
 * @Autowired CandidateRepository tutorialRepository;
 * 
 * @Test public void should_find_no_tutorials_if_repository_is_empty() {
 * Iterable<Candidate> tutorials = tutorialRepository.findAll();
 * assertThat(tutorials).isEmpty(); }
 * 
 * @Test public void should_store_a_tutorial() {
 * 
 * Candidate tutorial = tutorialRepository.save(new
 * Candidate("testTitle","testDescription",true));
 * assertThat(tutorial).hasFieldOrPropertyWithValue("title", "testTitle");
 * assertThat(tutorial).hasFieldOrPropertyWithValue("description",
 * "testDescription");
 * assertThat(tutorial).hasFieldOrPropertyWithValue("published", true); }
 * 
 * @Test public void should_find_all_tutorials() {
 * 
 * Candidate tutorial1 = new Candidate("testTitle1", "testDescription1", true);
 * entityManager.persist(tutorial1);
 * 
 * Candidate tutorial2 = new Candidate("testTitle2", "testDescription2", false);
 * entityManager.persist(tutorial2);
 * 
 * Candidate tutorial3 = new Candidate("testTitle3", "testDescription3", true);
 * entityManager.persist(tutorial3);
 * 
 * Iterable<Candidate> tutorials = tutorialRepository.findAll();
 * 
 * assertThat(tutorials).hasSize(3).contains(tutorial1, tutorial2, tutorial3); }
 * 
 * @Test public void find_tutorial_by_id() { Candidate tutorial1 = new
 * Candidate("testTitle1", "testDescription1", true);
 * entityManager.persist(tutorial1); Candidate tutorial2 = new
 * Candidate("testTitle2", "testDescription2", false);
 * entityManager.persist(tutorial2);
 * 
 * Candidate foundTutorial =
 * tutorialRepository.findById(tutorial2.getId()).get();
 * assertThat(foundTutorial).isEqualTo(tutorial2); }
 * 
 * @Test public void should_find_published_tutorials() { Candidate tutorial1 =
 * new Candidate("testTitle1", "testDescription1", true);
 * entityManager.persist(tutorial1);
 * 
 * Candidate tutorial2 = new Candidate("testTitle2", "testDescription2", false);
 * entityManager.persist(tutorial2);
 * 
 * Candidate tutorial3 = new Candidate("testTitle3", "testDescription3", true);
 * entityManager.persist(tutorial3);
 * 
 * Iterable<Candidate> tutorials = tutorialRepository.findByPublished(true);
 * 
 * assertThat(tutorials).hasSize(2).contains(tutorial1, tutorial3); }
 * 
 * @Test public void should_find_tutorialsby_title_with_string() {
 * 
 * Candidate tutorial1 = new Candidate("testTitle1", "testDescription1", true);
 * entityManager.persist(tutorial1);
 * 
 * Candidate tutorial2 = new Candidate("Java", "testDescription2", false);
 * entityManager.persist(tutorial2);
 * 
 * Candidate tutorial3 = new Candidate("Java Spring", "testDescription3", true);
 * entityManager.persist(tutorial3);
 * 
 * Iterable<Candidate> tutorials =
 * tutorialRepository.findByTitleContaining("Java");
 * assertThat(tutorials).hasSize(2).contains(tutorial2, tutorial3); }
 * 
 * @Test public void should_update_tutorial_by_id() { Candidate tutorial1 = new
 * Candidate("testTitle1", "testDescription1", true);
 * entityManager.persist(tutorial1);
 * 
 * Candidate tutorial2 = new Candidate("Java", "testDescription2", false);
 * entityManager.persist(tutorial2);
 * 
 * Candidate tutorialUpdated = new Candidate("Java Spring", "testDescription3",
 * true);
 * 
 * Candidate tutorial = tutorialRepository.findById(tutorial2.getId()).get();
 * tutorial.setTitle(tutorialUpdated.getTitle());
 * tutorial.setDescription(tutorialUpdated.getDescription()); Candidate checkTut
 * = tutorialRepository.save(tutorial);
 * 
 * assertThat(checkTut.getId()).isEqualTo(tutorial2.getId());
 * assertThat(checkTut.getTitle()).isEqualTo(tutorialUpdated.getTitle());
 * assertThat(checkTut.getDescription()).isEqualTo(tutorialUpdated.
 * getDescription()); }
 * 
 * @Test public void should_delete_tutorial_by_id() { Candidate tutorial1 = new
 * Candidate("testTitle1", "testDescription1", true);
 * entityManager.persist(tutorial1);
 * 
 * Candidate tutorial2 = new Candidate("testTitle2", "testDescription2", false);
 * entityManager.persist(tutorial2);
 * 
 * Candidate tutorial3 = new Candidate("testTitle3", "testDescription3", true);
 * entityManager.persist(tutorial3);
 * 
 * tutorialRepository.deleteById(tutorial2.getId());
 * 
 * assertThat(tutorialRepository.findAll()).hasSize(2).contains(tutorial1,
 * tutorial3); }
 * 
 * @Test public void should_delete_all_tutorials() { Candidate tutorial1 = new
 * Candidate("testTitle1", "testDescription1", true);
 * entityManager.persist(tutorial1);
 * 
 * Candidate tutorial2 = new Candidate("testTitle2", "testDescription2", false);
 * entityManager.persist(tutorial2);
 * 
 * Candidate tutorial3 = new Candidate("testTitle3", "testDescription3", true);
 * entityManager.persist(tutorial3);
 * 
 * tutorialRepository.deleteAll();
 * 
 * assertThat(tutorialRepository.findAll()).isEmpty(); } }
 */
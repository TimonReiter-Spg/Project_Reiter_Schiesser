package com.example.dbiproj2324;
import ch.qos.logback.core.spi.AbstractComponentTracker;
import com.example.dbiproj2324.Entities.Fach;
import com.example.dbiproj2324.Entities.Lehrer;
import com.example.dbiproj2324.service.LehrerService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;


import java.util.List;
import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class LehrerServiceTest {

    @Autowired
    private LehrerService lehrerService;

    private static final Logger logger = LoggerFactory.getLogger(LehrerServiceTest.class);
    @Qualifier("mongoTemplate")
    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    @Order(0)
    public void testInsert100Lehrer() {
        long startTime = System.currentTimeMillis();
        insertTest(100);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        logger.info("Zeit für das Einfügen von 100 Lehrern: " + totalTime + " Millisekunden");
    }
/*
    @Test
    @Order(1)
    public void testInsert1000Lehrer() {
        long startTime = System.currentTimeMillis();
        insertTest(1000);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        logger.info("Zeit für das Einfügen von 1.000 Lehrern: " + totalTime + " Millisekunden");
    }

    @Test
    @Order(2)
    public void testInsert100000Lehrer() {
        long startTime = System.currentTimeMillis();
        insertTest(100000);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        logger.info("Zeit für das Einfügen von 100.000 Lehrern: " + totalTime + " Millisekunden");
    }

     */

    @Test
    @Order(3)
    public void testFindNormal(){
        long startTime = System.currentTimeMillis();
        List<Lehrer> lehrer = lehrerService.allLehrer();
        long endTime = System.currentTimeMillis();

        logger.info("Lehrer: " + lehrer + " Zeit: " + (endTime - startTime) + " Millisekunden");
    }

    @Test
    @Order(4)
    public void testFindWithFilter(){
        long startTime = System.currentTimeMillis();
        Lehrer test = new Lehrer("Test", List.of(new Fach("Test", 5)));
        lehrerService.addLehrer(test);
        String id = test.get_id();
        Lehrer lehrer = lehrerService.getLehrerById(id);
        List<Fach> faecher = lehrerService.getFaecherByLehrer(id);

        long endTime = System.currentTimeMillis();
        logger.info("Fächer: " + faecher + " Zeit: " + (endTime - startTime) + " Millisekunden");
    }


    @Test
    @Order(5)
    public void testFindWithFilterProjection(){
long startTime = System.currentTimeMillis();

    Lehrer test = new Lehrer("Docker-Dimon", List.of(new Fach("POS", 23)));
    Lehrer test2 = new Lehrer("Patty", List.of(new Fach("PRE", 12)));
        lehrerService.addLehrer(test);
        lehrerService.addLehrer(test2);

    Criteria criteria = Criteria.where("faecher.FachName").is("POS");
    Query query = new Query(criteria);
        query.fields().include("name");
    List<Lehrer> lehrerList = mongoTemplate.find(query, Lehrer.class);

    long endTime = System.currentTimeMillis();

        logger.info("Lehrer: " + lehrerList + " Zeit: " + (endTime - startTime) + " Millisekunden");

    }

    @Test
    @Order(6)
    public void testFindWithFilterProjectionAndSort() {
        long startTime = System.currentTimeMillis();

        Lehrer test = new Lehrer("Josi", List.of(new Fach("POS", 20)));
        Lehrer test2 = new Lehrer("Domas", List.of(new Fach("DBI", 20)));
        lehrerService.addLehrer(test);
        lehrerService.addLehrer(test2);

        Criteria criteria = Criteria.where("faecher.unterrichtsstunden").is(20);
        Query query = new Query(criteria);
        query.fields().include("name", "faecher.FachName");
        query.with(Sort.by(Sort.Order.asc("name")));
        List<Lehrer> lehrerList = mongoTemplate.find(query, Lehrer.class);

        long endTime = System.currentTimeMillis();

        logger.info("Lehrer: " + lehrerList + " Zeit: " + (endTime - startTime) + " Millisekunden");

    }


    @Test
    @Order(6)
    public void testUpdate(){
        long startTime = System.currentTimeMillis();

        Lehrer test = new Lehrer("Irgendein-Lehrer", List.of(new Fach("AM", 5)));
        lehrerService.addLehrer(test);
        String id = test.get_id();
        Fach fach = new Fach("DBI", 10);
        lehrerService.addFach(id, fach);

        long endTime = System.currentTimeMillis();

        logger.info("Zeit: " + (endTime - startTime) + " Millisekunden");
    }


    @Test
    @Order(7)
    public void testDeleteAll(){
        long startTime = System.currentTimeMillis();
        lehrerService.deleteAllLehrer();
        long endTime = System.currentTimeMillis();

        logger.info("Zeit: " + (endTime - startTime) + " Millisekunden");
    }


    public void insertTest(long amount)
    {
        for (int i = 0; i < amount; i++) {
            List<Fach> faecher = List.of(new Fach("POS ", 5), new Fach("POS ", 5),
                    new Fach("POS ", 5));
            Lehrer lehrer = new Lehrer("Lehrer " + i, faecher);
            lehrerService.addLehrer(lehrer);
        }
    }

}

/**
 * 
 */
package biz.hahamo.dev.enterprise.example;

import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import biz.hahamo.dev.enterprise.example.joined.CircleJoined;
import biz.hahamo.dev.enterprise.example.joined.ShapeJoined;
import biz.hahamo.dev.enterprise.example.joined.TriangleJoined;
import biz.hahamo.dev.enterprise.example.singletable.CircleSingletable;
import biz.hahamo.dev.enterprise.example.singletable.ShapeSingletable;
import biz.hahamo.dev.enterprise.example.singletable.TriangleSingletable;
import biz.hahamo.dev.enterprise.example.tableperclass.CirclePerclass;
import biz.hahamo.dev.enterprise.example.tableperclass.ShapePerclass;
import biz.hahamo.dev.enterprise.example.tableperclass.TrianglePerclass;

/**
 * This is a simple test bean to make the connection between the GUI and the repository.
 * 
 * @author GHajba
 */
@SessionScoped
public class TestBean {

    @Inject
    private ShapeRepository repo;

    public TestBean() {
    }

    public void testJoined(ActionEvent event) {

        System.out.println("Test Joined inheritance");

        List<ShapeJoined> resultList = repo.findAllJoined();
        System.out.println(resultList.size());
        // here should come 2 times CircleJoined if you use only the built-in test data generation
        for (ShapeJoined s : resultList) {
            System.out.println(s.getClass());
            ShapeJoined entity = repo.find(s.getClass(), s.getIdString());
            System.out.println(entity);
        }
        System.out.println("--------------\n");
    }

    public void testSingletable(ActionEvent event) {

        List<ShapeSingletable> resultList = repo.findAllSingletable();
        System.out.println(resultList.size());
        for (ShapeSingletable s : resultList) {
            System.out.println(s.getClass());
            System.out.println(repo.find(s.getClass(), s.getIdString()));
        }
        System.out.println("--------------\n");

    }

    public void testPerclass(ActionEvent event) {

        List<ShapePerclass> resultList = repo.findAllPerclass();
        System.out.println(resultList.size());
        for (ShapePerclass s : resultList) {
            System.out.println(s.getClass());
            System.out.println(repo.find(s.getClass(), s.getIdString()));
        }
        System.out.println("--------------\n");

    }

    public void createEntities(ActionEvent event) {
        CircleJoined circleJoined = new CircleJoined();
        circleJoined.setIdString("joinedTest");
        circleJoined.setRadius(123);
        TriangleJoined notReallyACircle = new TriangleJoined();
        notReallyACircle.setEqualSites(false);
        notReallyACircle.setIdString("a triangle shaped circle?");

        CircleSingletable circleSingletable = new CircleSingletable();
        circleSingletable.setIdString("singletableTest");
        circleSingletable.setRadius(234);
        TriangleSingletable nowATriangle = new TriangleSingletable();
        nowATriangle.setIdString("a triangle shaped triangle");
        nowATriangle.setEqualSites(true);

        CirclePerclass circlePerclass = new CirclePerclass();
        circlePerclass.setIdString("perclassTest");
        circlePerclass.setRadius(456);
        TrianglePerclass trianglePerclass = new TrianglePerclass();
        trianglePerclass.setEqualSites(false);
        trianglePerclass.setIdString("a single triangle");

        repo.save(circleJoined);
        repo.save(notReallyACircle);
        repo.save(circlePerclass);
        repo.save(trianglePerclass);
        repo.save(circleSingletable);
        repo.save(nowATriangle);
    }
}

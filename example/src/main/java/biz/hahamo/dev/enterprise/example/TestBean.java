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
import biz.hahamo.dev.enterprise.example.singletable.CircleSingletable;
import biz.hahamo.dev.enterprise.example.singletable.ShapeSingletable;
import biz.hahamo.dev.enterprise.example.tableperclass.CirclePerclass;
import biz.hahamo.dev.enterprise.example.tableperclass.ShapePerclass;

/**
 * @author GHajba
 *
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
        ShapeJoined s = resultList.get(0);
        System.out.println(s.getClass());
        CircleJoined c = (CircleJoined) s;
        System.out.println(c.getRadius());
        // TriangleJoined t = (TriangleJoined) resultList.get(1);
        // System.out.println(t.getEqualSites());
        System.out.println("--------------\n");
    }

    public void testSingletable(ActionEvent event) {

        List<ShapeSingletable> resultList = repo.findAllSingletable();
        System.out.println(resultList.size());
        ShapeSingletable s = resultList.get(0);
        System.out.println(s.getClass());
        CircleSingletable c = (CircleSingletable) s;
        System.out.println(c.getRadius());
        // TriangleJoined t = (TriangleJoined) resultList.get(1);
        // System.out.println(t.getEqualSites());
        System.out.println("--------------\n");

    }

    public void testPerclass(ActionEvent event) {

        List<ShapePerclass> resultList = repo.findAllPerclass();
        System.out.println(resultList.size());
        ShapePerclass s = resultList.get(0);
        System.out.println(s.getClass());
        CirclePerclass c = (CirclePerclass) s;
        System.out.println(c.getRadius());
        // TriangleJoined t = (TriangleJoined) resultList.get(1);
        // System.out.println(t.getEqualSites());
        System.out.println("--------------\n");

    }

    public void createEntities(ActionEvent event) {
        CircleJoined circleJoined = new CircleJoined();
        circleJoined.setIdString("joinedTest");
        circleJoined.setRadius(123);
        CircleSingletable circleSingletable = new CircleSingletable();
        circleSingletable.setIdString("singletableTest");
        circleSingletable.setRadius(234);
        CirclePerclass circlePerclass = new CirclePerclass();
        circlePerclass.setIdString("perclassTest");
        circlePerclass.setRadius(456);

        repo.save(circleJoined);
        repo.save(circlePerclass);
        repo.save(circleSingletable);
    }
}

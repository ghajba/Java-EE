/**
 *
 */
package biz.hahamo.dev.attributeconverter;

import java.time.LocalDate;

import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

/**
 * @author GHajba
 *
 */
@SessionScoped
public class TestBean {

    @Inject
    private ExampleRepository repo;

    public TestBean() {
    }

    public void testIt(ActionEvent event) {
        final ExampleEntity ee = new ExampleEntity();
        ee.setCreated(LocalDate.now());
        this.repo.save(ee);
        System.out.println(this.repo.findAll());
    }
}

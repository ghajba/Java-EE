/**
 * 
 */
package biz.hahamo.dev.enterprise.example;

import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import biz.hahamo.dev.enterprise.example.joined.Circle;
import biz.hahamo.dev.enterprise.example.joined.Shape;
import biz.hahamo.dev.enterprise.example.joined.Triangle;

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
	
	public void testIt(ActionEvent event){
		 
		//Get submit button id
//		buttonId = event.getComponent().getClientId();
		System.out.println("TestIt");
		List<Shape> findAll = repo.findAll();
		System.out.println(findAll.size());
		Shape s = findAll.get(0);
		System.out.println(s.getClass());
		Circle c = (Circle) s;
		System.out.println(c.getRadius());
		Triangle t = (Triangle) findAll.get(1);
		System.out.println(t.getEqualSites());
 
	}
}

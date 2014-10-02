/**
 * 
 */
package biz.hahamo.dev.enterprise.example;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

/**
 * @author gaborh
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
		repo.findAll();
 
	}
}

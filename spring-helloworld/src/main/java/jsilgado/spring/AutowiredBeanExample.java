package jsilgado.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class AutowiredBeanExample {

	@Autowired
	private AutowiredBean autowiredBean;

	public void setAutowiredBean(AutowiredBean AutowiredBean) {
		this.autowiredBean = AutowiredBean;
	}

	public AutowiredBean getAutowiredBean() {
		return autowiredBean;
	}

	public void method() {
		autowiredBean.launch();
	}
}
package model;

import javax.servlet.http.HttpServlet;

public class HealthCheckLogic extends HttpServlet {
	public void execute(Health health) {

		double weight=health.getWeight();
		double height=health.getHeight();
		double bmi=Math.round(weight/(height/100.0*height/100.0));
		health.setBmi(bmi);

		String bodyType;
		if(bmi<18.5) {
			bodyType="やせ型";
		}else if(bmi <25) {
			bodyType="普通";
		}else {
			bodyType="肥満";
		}
		health.setBodyType(bodyType);
	}
}

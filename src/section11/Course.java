package section11;

import java.util.List;

public class Course {
	
	public List<WebAutomtion> getWebAutomation() {
		return WebAutomation;
	}
	public void setWebAutomation(List<WebAutomtion> webAutomation) {
		this.WebAutomation = webAutomation;
	}
	public List<Api> getApi() {
		return api;
	}
	public void setApi(List<Api> api) {
		this.api = api;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}
	private List<WebAutomtion> WebAutomation;
	private List<Api> api;
	private List<Mobile> mobile;

}

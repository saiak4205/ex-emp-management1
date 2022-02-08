package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InsertAdministratorForm {
	@NotBlank(message = "名前は必須です")
	private String name;
	@Email(message = "メールアドレスの型が不正です")
	@Size(min=4,max=160,message = "パスワードは4文字以上160文字以下です")
	private String mailAddress;
	@Size(min=4,max=16,message = "パスワードは4文字以上16文字以下です")
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}
	
	
	
}

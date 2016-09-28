package zw.co.afrosoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(
        name = "tableGenerator",
        strategy = "org.hibernate.id.enhanced.TableGenerator"
)
public class Authorities {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tableGenerator")
	private Integer authoritiesId;
	private String username;
	private String authority;
	
	public Integer getAuthoritiesId() {
		return authoritiesId;
	}
	public void setAuthoritiesId(Integer authoritiesId) {
		this.authoritiesId = authoritiesId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}

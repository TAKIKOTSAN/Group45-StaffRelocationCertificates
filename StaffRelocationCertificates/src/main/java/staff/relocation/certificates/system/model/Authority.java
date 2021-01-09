package staff.relocation.certificates.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
    @Enumerated(EnumType.STRING)
    @Column(unique=true)    
    private RoleName name;
    
    public Authority(RoleName name) {
		super();
		this.name = name;
	}

	public Authority() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@JsonIgnore
	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}

	@Override
    public String getAuthority() {
        return name.name();
    }

   
    
}


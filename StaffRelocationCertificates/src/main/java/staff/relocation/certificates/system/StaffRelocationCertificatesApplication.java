package staff.relocation.certificates.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

public class StaffRelocationCertificatesApplication implements CommandLineRunner{
	@Autowired
	private InitData initData;
	public static void main(String[] args) {
		SpringApplication.run(StaffRelocationCertificatesApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		initData.Init();
	}
}

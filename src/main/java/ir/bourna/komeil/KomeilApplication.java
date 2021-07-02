package ir.bourna.komeil;

import ir.bourna.komeil.DTO.Response.FileStoragePropertiesResponseDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
@EnableConfigurationProperties({FileStoragePropertiesResponseDTO.class})
public class KomeilApplication {

	public static void main(String[] args) {
		SpringApplication.run(KomeilApplication.class, args);
	}

}

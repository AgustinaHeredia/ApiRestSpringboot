package cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01.model.repository")
@EntityScan("cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01.model.domain")
@ComponentScan(basePackages = "cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01")
public class S04T02N01HerediaMarengoAgustinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N01HerediaMarengoAgustinaApplication.class, args);
	}

}

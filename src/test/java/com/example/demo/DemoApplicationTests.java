package com.example.demo;

import com.example.demo.domain.post.post.service.Post;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class DemoApplicationTests {

	@Test
	void t1() {
		Post p1 = new Post(1, "title");
		Post p2 = new Post(1, "title");

		assertThat(p1).isEqualTo(p2);
	}

	@Test
	void t2() {
		Post p1 = new Post(1, "title1");
		Post p2 = new Post(1, "title2");

		Set<Post> posts = new HashSet<>();

		posts.add(p1);
		posts.add(p2);

		assertThat(posts.size()).isEqualTo(1);
	}

}

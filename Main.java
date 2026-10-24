package assignment;
import java.time.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;



public class Main {

	public static void main(String[] args) {
		SchedularService service = new SchedularService();
		User alice = new User("Alice", "alice@example.com", Role.EDITOR);


		Channel twitter = new TwitterChannel();
		Channel linkedin = new LinkedInChannel();


		// Create and schedule posts
		Post p1 = service.createPost("Hello Twitter!", LocalDateTime.now().plusSeconds(2), twitter, alice);
		service.schedule(p1, LocalDateTime.now().plusSeconds(2));


		Post p2 = service.createPost("Sharing an update on LinkedIn.", LocalDateTime.now().plusSeconds(3), linkedin, alice);
		service.schedule(p2, LocalDateTime.now().plusSeconds(3));


		// Wait to allow scheduled posts to become due
		try { Thread.sleep(4000); } catch (InterruptedException e) { }


		// Publish and report
		service.publishDuePosts();
		service.report();


		System.out.println("Twitter Posts: " + service.listByChannel(twitter));
		System.out.println("LinkedIn Posts: " + service.listByChannel(linkedin));
		}

	}


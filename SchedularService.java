package assignment;
import java.time.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;



public class SchedularService {
	private final List<Post> posts = new ArrayList<>();


	public Post createPost(String content, LocalDateTime scheduledTime, Channel channel, User author) {
	Post post = new Post(content, scheduledTime, channel, author);
	posts.add(post);
	return post;
	}


	public void schedule(Post post, LocalDateTime when) {
	post.setScheduledTime(when);
	post.setStatus(PostStatus.SCHEDULED);
	}


	public void publishDuePosts() {
	LocalDateTime now = LocalDateTime.now();
	for (Post post : posts) {
	if (post.getStatus() == PostStatus.SCHEDULED && !post.getScheduledTime().isAfter(now)) {
	if (post.getChannel().publish(post)) {
	post.setStatus(PostStatus.PUBLISHED);
	} else {
	post.setStatus(PostStatus.FAILED);
	}
	}
	}
	}


	public List<Post> listByChannel(Channel channel) {
	List<Post> result = new ArrayList<>();
	for (Post p : posts) {
	if (p.getChannel().equals(channel)) {
	result.add(p);
	}
	}
	return result;
	}


	public void report() {
	int total = posts.size();
	int published = 0, failed = 0;
	for (Post p : posts) {
	if (p.getStatus() == PostStatus.PUBLISHED) published++;
	if (p.getStatus() == PostStatus.FAILED) failed++;
	}
	System.out.println("Report: Total=" + total + ", Published=" + published + ", Failed=" + failed);
	}
}

package assignment;
import java.time.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;



public class Post {
	private static final AtomicInteger ID_GEN = new AtomicInteger(1000);
	private final int postId;
	private String content;
	private LocalDateTime scheduledTime;
	private Channel channel;
	private PostStatus status;
	private final User author;


	public Post(String content, LocalDateTime scheduledTime, Channel channel, User author) {
	this.postId = ID_GEN.getAndIncrement();
	this.content = content;
	this.scheduledTime = scheduledTime;
	this.channel = channel;
	this.status = PostStatus.DRAFT;
	this.author = author;
	}


	public int getPostId() { return postId; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	public LocalDateTime getScheduledTime() { return scheduledTime; }
	public void setScheduledTime(LocalDateTime scheduledTime) { this.scheduledTime = scheduledTime; }
	public Channel getChannel() { return channel; }
	public void setChannel(Channel channel) { this.channel = channel; }
	public PostStatus getStatus() { return status; }
	public void setStatus(PostStatus status) { this.status = status; }


	@Override
	public String toString() {
	return postId + ": '" + content + "' -> " + channel.getName() + " (" + status + ")";
	}

}

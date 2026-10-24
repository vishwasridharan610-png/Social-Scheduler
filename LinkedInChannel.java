package assignment;
import java.time.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
public class LinkedInChannel extends Channel {
	public static final int MAX_LENGTH = 3000;
	public LinkedInChannel() { 
		super("LinkedIn"); 
	}
	@Override
	public boolean validate(Post post) {
		return super.validate(post) && post.getContent().length() <= MAX_LENGTH;
	}
}
package assignment;
import java.time.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class TwitterChannel extends Channel {
	public static final int MAX_LENGTH = 280;
	public TwitterChannel() { super("Twitter"); }


	@Override
	public boolean validate(Post post) {
	return super.validate(post) && post.getContent().length() <= MAX_LENGTH;
	}

}

package assignment;
import java.time.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

enum Role { ADMIN, EDITOR, VIEWER }
enum ChannelStatus { ACTIVE, PAUSED }
enum PostStatus { DRAFT, SCHEDULED, PUBLISHED, FAILED }

abstract class Channel {
protected static final AtomicInteger ID_GEN = new AtomicInteger(100);
protected final int channelId;
protected String name;
protected ChannelStatus status;


public Channel(String name) {
this.channelId = ID_GEN.getAndIncrement();
this.name = name;
this.status = ChannelStatus.ACTIVE;
}


public int getChannelId() { return channelId; }
public String getName() { return name; }
public ChannelStatus getStatus() { return status; }
public void setStatus(ChannelStatus status) { this.status = status; }


public boolean validate(Post post) {
return status == ChannelStatus.ACTIVE && post.getContent() != null && !post.getContent().isBlank();
}


public boolean publish(Post post) {
if (!validate(post)) return false;
System.out.println("[" + name + "] Published: " + post.getContent());
return true;
}


@Override
public String toString() {
return channelId + ": " + name + " (" + status + ")";
}
}
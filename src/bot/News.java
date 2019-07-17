package bot;
public class News {
	
	private int id;
	private String publishDate;
	private String topic;
	private String headline;
	private String story;
	private String source;
	
	public News() {
	
	}
	
	public News(int id, String publishDate, String topic, String headline, String story, String source) {
		this.id = id;
		this.publishDate = publishDate;
		this.topic = topic;
		this.headline = headline;
		this.story = story;
		this.source = source;
	}
	
	public int getId() {
		return id;
	}
	public String getDate() {
		return publishDate;
	}
	public String getTopic() {
		return topic;
	}
	public String getHeadline() {
		return headline;
	}
	public String getStory() {
		return story;
	}
	public String getSource() {
		return source;
	}
}
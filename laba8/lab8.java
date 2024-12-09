import java.util.*;

class Comment {
    String text;
    int likes;
    int dislikes;

    public Comment(String text, int likes, int dislikes) {
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    
    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    @Override
    public String toString() {
        return "Comment{" + "text='" + text + '\'' + ", likes=" + likes + ", dislikes=" + dislikes + '}';
    }
}

class Video {
    String title;
    String url;
    int views;
    int likes;
    int dislikes;
    Set<Comment> comments;

    public Video(String title, String url, int views, int likes, int dislikes) {
        this.title = title;
        this.url = url;
        this.views = views;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = new HashSet<>(); // Використовуємо HashSet для коментарів
    }

    public void addComment(Comment comment) {
        comments.add(comment); // Додаємо коментар (унікальність гарантована)
    }

    public int getViews() {
        return views;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getLikes() {
        return likes;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Video{" + "title='" + title + '\'' + ", views=" + views + ", likes=" + likes + ", dislikes=" + dislikes + '}';
    }
}

class VideoBlog {
    Set<Video> videos;
    Map<String, Set<Video>> categoryMap; // Map для зберігання відео за категоріями

    public VideoBlog() {
        this.videos = new HashSet<>();
        this.categoryMap = new HashMap<>();
    }

    public void addVideo(Video video) {
        videos.add(video);
    }

    public void addVideoToCategory(String category, Video video) {
        categoryMap.computeIfAbsent(category, k -> new HashSet<>()).add(video); // Додаємо відео до категорії
    }

    public Set<Video> getVideos() {
        return videos;
    }

    public int getTotalViews() {
        int totalViews = 0;
        for (Video video : videos) {
            totalViews += video.getViews();
        }
        return totalViews;
    }

    public boolean hasCommentMoreLikesThanVideo() {
        for (Video video : videos) {
            for (Comment comment : video.getComments()) {
                if (comment.getLikes() > video.getLikes()) {
                    return true; // Якщо коментар має більше лайків, ніж відео
                }
            }
        }
        return false;
    }

    public Set<Video> getVideosWithMostDislikes() {
        Set<Video> result = new HashSet<>();
        int maxDislikes = Integer.MIN_VALUE;

        for (Video video : videos) {
            if (video.getDislikes() > maxDislikes) {
                maxDislikes = video.getDislikes();
                result.clear();
                result.add(video);
            } else if (video.getDislikes() == maxDislikes) {
                result.add(video);
            }
        }
        return result;
    }

    public Set<Video> getVideosByCategory(String category) {
        return categoryMap.getOrDefault(category, Collections.emptySet()); // Повертаємо відео за категорією
    }
}

public class lab8 {
    public static void main(String[] args) {
        VideoBlog blog = new VideoBlog();

        // Створення відео та коментарів
        Video video1 = new Video("Video 1", "url1", 1000, 500, 50);
        video1.addComment(new Comment("Great video!", 300, 10));
        video1.addComment(new Comment("Nice!", 200, 20));

        Video video2 = new Video("Video 2", "url2", 1500, 700, 80);
        video2.addComment(new Comment("Awesome!", 800, 5));

        blog.addVideo(video1);
        blog.addVideo(video2);

        // Додаємо відео до категорій
        blog.addVideoToCategory("Education", video1);
        blog.addVideoToCategory("Entertainment", video2);

        // 1) Загальна кількість переглядів
        System.out.println("Total views: " + blog.getTotalViews());

        // 2) Чи є коментар, що набрав більше лайків, ніж відео?
        System.out.println("Has comment with more likes than video: " + blog.hasCommentMoreLikesThanVideo());

        // 3) Визначити відео з найбільшими дізлайками
        Set<Video> videosWithMostDislikes = blog.getVideosWithMostDislikes();
        System.out.println("Videos with most dislikes:");
        for (Video v : videosWithMostDislikes) {
            System.out.println(v.title + " with " + v.getDislikes() + " dislikes");
        }

        // 4) Відео в категорії "Education"
        System.out.println("Videos in category 'Education':");
        for (Video v : blog.getVideosByCategory("Education")) {
            System.out.println(v.title);
        }
    }
}

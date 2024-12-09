import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
}
    class Video {
        String title;
        String url;
        int views;
        int likes; 
        int dislikes;
        List<Comment> comments;
    
        public Video(String title, String url, int views, int likes, int dislikes) {
            this.title = title;
            this.url = url;
            this.views = views;
            this.likes = likes;
            this.dislikes = dislikes;
            this.comments = new ArrayList<>();
        }
    
        public void addComment(Comment comment) {
            comments.add(comment);
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
    
        public List<Comment> getComments() {
            return comments;
        }
    }
    

class VideoBlog {
    List<Video> videos;

    public VideoBlog() {
        this.videos = new ArrayList<>();
    }

    public void addVideo(Video video) {
        videos.add(video);
    }

    public List<Video> getVideos() {
        return videos;
    }
    public int getTotalViews() {
        int totalViews = 0;
        Iterator<Video> iterator = videos.iterator(); // Нетипізований ітератор
        while (iterator.hasNext()) {
            totalViews += iterator.next().getViews();
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
    
    public List<Video> getVideosWithMostDislikes() {
        List<Video> result = new ArrayList<>();
        int maxDislikes = Integer.MIN_VALUE;
    
        // Типізований ітератор
        for (Video video : videos) {
            if (video.getDislikes() > maxDislikes) {
                maxDislikes = video.getDislikes();
                result.clear(); // Очищаємо список, якщо знайдено новий лідер
                result.add(video);
            } else if (video.getDislikes() == maxDislikes) {
                result.add(video); // Додаємо відео, якщо воно має такий самий максимальний дізлайк
            }
        }
    
        return result; // Повертаємо список відео з найбільшими дізлайками
    }
}


public class lab7 {
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

        // 1) Загальна кількість переглядів
        System.out.println("Total views: " + blog.getTotalViews());

        // 2) Чи є коментар, що набрав більше лайків, ніж відео?
        System.out.println("Has comment with more likes than video: " + blog.hasCommentMoreLikesThanVideo());

        // 3) Визначити відео з найбільшими дізлайками
        List<Video> videosWithMostDislikes = blog.getVideosWithMostDislikes();
        System.out.println("Videos with most dislikes:");
        for (Video v : videosWithMostDislikes) {
            System.out.println(v.title + " with " + v.getDislikes() + " dislikes");
        }
    }
}

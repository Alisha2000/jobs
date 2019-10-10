package Pojo;

public class NewPosts {
    String title;
    String status;

    public NewPosts(String title,String status){
        this.title=title;
        this.status=status;
    }

    @Override
    public String toString() {
       return this.title+""+this.status;

    }
}


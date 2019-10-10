package Pojo;

import javafx.geometry.Pos;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



public@Data class Posts {
    String title;
    String content;
    String status;
    public Posts(String title, String content, String status){
        super();
        this.title=title;
        this.content=content;
        this.status=status;
    }

    @Override
    public String toString(){
        return "This is the title "+this.title+" this is the content " +this.content +"this is the status"+this.status;
    }

}

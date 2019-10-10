package Pojo;

import lombok.Data;

public @Data class projectPost {
    String name;
    String email;

    public projectPost(String name, String email){
        this.name=name;
        this.email=email;
    }
    @Override
    public String toString(){
        return this.name+""+this.email;
    }

}

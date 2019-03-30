package music.service.jamendo.util;

import java.lang.reflect.Field;

public class JamendoFinder {

    private JamendoFinder(){}

    private String client_id = "a93e103b";

    private Format format = Format.jsonpretty;

    private int offset;

    private String limit;

    private Order order;

    private boolean fullcount = true;

    private int[] id;

    private String name;

    private String namesearch;

    private Type type;

    private int[] album_id;

    private String album_name;

    private int[] artist_id;

    private String artist_name;

    private String datebetween;

    private Speed[] speed;

    public String toURL() throws IllegalAccessException {
        StringBuilder URL = new StringBuilder();

        for(Field field : this.getClass().getDeclaredFields()){
            if(field.get(this) != null){
                if(field.getName().equals("client_id")) URL.append("?"); else URL.append("&");
                URL.append(field.getName()).append("=");
                if(field.getType().isArray()){
                    appendArray((Object[]) field.get(this), URL);
                }
                else{
                    appendObj(field.get(this), URL);
                }
            }
        }

        return URL.toString();
    }

    private void appendObj(Object obj, StringBuilder builder){
        if(obj != null){
            builder.append(obj);
        }
    }

    private <T> void appendArray(T[] array, StringBuilder stringBuilder){
        if(array != null) {
            StringBuilder str = new StringBuilder();
            for (T obj : array) {
                str.append('+');
                str.append(obj);
            }
            str.deleteCharAt(0);
            stringBuilder.append(str);
        }
    }

    public static Builder newBuilder(){
        return new JamendoFinder().new Builder();
    }

    public enum Format{
        xml,
        json,
        jsonpretty

    }

    enum Speed{
        verylow,
        low,
        medium,
        high,
        veryhigh;

    }

    enum Order{
        relevance,
        buzzrate,
        downloads_week,
        downloads_month,
        downloads_total,
        listens_week,
        listens_month,
        listens_total,
        popularity_week,
        popularity_month,
        popularity_total,
        name,
        album_name,
        artist_name,
        releasedate,
        duration,
        id;
    }

    enum Type{
        single,
        albumtrack;
    }

    public class Builder{

        private Builder(){}

        public Builder client_id(String client_id){
            JamendoFinder.this.client_id = client_id;
            return this;
        }

        public Builder format(Format format){
            JamendoFinder.this.format = format;
            return this;
        }

        public Builder offset(int offset){
            JamendoFinder.this.offset = offset;
            return this;
        }

        public Builder limit(String limit){
            JamendoFinder.this.limit = limit;
            return this;
        }

        public Builder order(Order order){
            JamendoFinder.this.order = order;
            return this;
        }

        public Builder fullcount(boolean fullcount){
            JamendoFinder.this.fullcount = fullcount;
            return this;
        }

        public Builder id(int[] id){
            JamendoFinder.this.id = id;
            return this;
        }

        public Builder name(String name){
            JamendoFinder.this.name = name;
            return this;
        }

        public Builder namesearch(String namesearch){
            JamendoFinder.this.namesearch = namesearch;
            return this;
        }

        public Builder type(Type type){
            JamendoFinder.this.type = type;
            return this;
        }

        public Builder album_id(int[] album_id){
            JamendoFinder.this.album_id = album_id;
            return this;
        }

        public Builder album_name(String album_name){
            JamendoFinder.this.album_name = album_name;
            return this;
        }

        public Builder artist_id(int[] artist_id){
            JamendoFinder.this.artist_id = artist_id;
            return this;
        }

        public Builder artist_name(String artist_name){
            JamendoFinder.this.artist_name = artist_name;
            return this;
        }

        public Builder datebetween(String datebetween){
            JamendoFinder.this.datebetween = datebetween;
            return this;
        }

        public Builder speed(Speed[] speed){
            JamendoFinder.this.speed = speed;
            return this;
        }

        public JamendoFinder build() {
            return JamendoFinder.this;
        }

    }
}

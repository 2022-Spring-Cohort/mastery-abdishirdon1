package com.survivingcodingbootcamp.blog.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import javax.persistence.ManyToMany;
import java.util.ArrayList;

import java.util.Objects;
import java.util.Collection;

@Entity
public class Hashtag 
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> posts;
    public Hashtag(String inName )
    {
        this.name = inName;
        this.posts = new ArrayList<Post>();
    }
    protected Hashtag() {
    }
    public Long getId() 
    {
        return id;
    }
    public String getName() 
    {
        return name;
    }
    public Collection<Post> getPosts() 
    {
        return posts;
    }
    @Override
    public String toString() 
    {
        return "Hashtag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o)
     {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return Objects.equals(id, hashtag.id) && Objects.equals(name, hashtag.name);
    }
    @Override
    public int hashCode() 
    {
        return Objects.hash(id, name);
    }

    public void addPost(Post post)
    {
        posts.add(post);
    }

}




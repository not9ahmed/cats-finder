package com.notahmed.catsfinder.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table("Cat")
public record Cat (
        @Id
        Long id,

        String name,
        AggregateReference<Breed, Long> breedId,
        AggregateReference<User, Long> ownerId,
        Date birth_date,
        ArrayList<String> images,
        ArrayList<String> toys,

        @MappedCollection(keyColumn = "id", idColumn = "cat")
        Set<Comment> comments
){
                // adding the comment to the cat
        public void addComment(Comment comment){

                // adding comment to this class
                comments.add(comment);

                // adding reference from comment to this
                comment.cat = this;
        }
}

//@Table("Cat")
//public class Cat {
//        @Id
//        private Long id;
//        private String name;
//
//
//
//        private AggregateReference<Breed, Long> breedId;
//
////        Long owner_id,
//        private AggregateReference<User, Long> ownerId;
//
//        private Date birth_date;
//        private ArrayList<String> images;
//        private ArrayList<String> toys;
//
//
//        @MappedCollection(keyColumn = "id", idColumn = "cat")
//        private Set<Comment> comments;
//
//        public Cat(String name, AggregateReference<Breed,
//                Long> breedId, AggregateReference<User,
//                Long> ownerId, Date birth_date, ArrayList<String> images,
//                   ArrayList<String> toys) {
//                this.name = name;
//                this.breedId = breedId;
//                this.ownerId = ownerId;
//                this.birth_date = birth_date;
//                this.images = images;
//                this.toys = toys;
//        }
//
//        public Long getId() {
//                return id;
//        }
//
//        public void setId(Long id) {
//                this.id = id;
//        }
//
//        public String getName() {
//                return name;
//        }
//
//        public void setName(String name) {
//                this.name = name;
//        }
//
//        public AggregateReference<Breed, Long> getBreedId() {
//                return breedId;
//        }
//
//        public void setBreedId(AggregateReference<Breed, Long> breedId) {
//                this.breedId = breedId;
//        }
//
//        public AggregateReference<User, Long> getOwnerId() {
//                return ownerId;
//        }
//
//        public void setOwnerId(AggregateReference<User, Long> ownerId) {
//                this.ownerId = ownerId;
//        }
//
//        public Date getBirth_date() {
//                return birth_date;
//        }
//
//        public void setBirth_date(Date birth_date) {
//                this.birth_date = birth_date;
//        }
//
//        public ArrayList<String> getImages() {
//                return images;
//        }
//
//        public void setImages(ArrayList<String> images) {
//                this.images = images;
//        }
//
//        public ArrayList<String> getToys() {
//                return toys;
//        }
//
//        public void setToys(ArrayList<String> toys) {
//                this.toys = toys;
//        }
//
//        public Set<Comment> getComments() {
//                return comments;
//        }
//
//        public void setComments(Set<Comment> comments) {
//                this.comments = comments;
//        }
//
//        // adding the comment to the cat
//        public void addComment(Comment comment){
//
//                // adding comment to this class
//                comments.add(comment);
//
//                // adding reference from comment to this
//                comment.cat = this;
//        }
//
//}
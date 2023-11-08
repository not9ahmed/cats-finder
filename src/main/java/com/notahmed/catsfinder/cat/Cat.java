package com.notahmed.catsfinder.cat;


import com.notahmed.catsfinder.breed.Breed;
import com.notahmed.catsfinder.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.*;

// will be the same class
//@Table("Cat")
//public record Cat (
//        @Id
//        Long id,
//
//        String name,
//        AggregateReference<Breed, Long> breedId,
//        AggregateReference<User, Long> ownerId,
//        Date birth_date,
//        ArrayList<String> images,
//        ArrayList<String> toys
//        ,
//
//        // nested collection very weak entity
//        // which means if the parent destroyed it will be deleted
//        // can be added to the cat
//        @MappedCollection(keyColumn = "id", idColumn = "cat")
//        Set<Comment> comments
//){
//
//
//    // TODO improve this relations
//    // adding the comment to the cat
//    public void addComment(Comment comment){
//
//        // adding comment to this class
//        comments.add(comment);
//
//        // adding reference from comment to this
//        // does not work cuz comment is immutable
////        comment.cat = this;
//    }
//}



@Table("Cat")
public class Cat {
        @Id
        private Long id;

        String name;
        AggregateReference<Breed, Long> breedId;
        AggregateReference<User, Long> ownerId;
        Date birth_date;
        ArrayList<String> images;
        ArrayList<String> toys;

        // nested collection very weak entity
        // which means if the parent destroyed it will be deleted
        // can be added to the cat
        @MappedCollection(idColumn = "cat", keyColumn = "id")
        private List<Comment> comments;


        // TODO improve this relations
        // adding the comment to the cat
        public void addComment(Comment comment){

            // adding comment to this class
            comments.add(comment);

            // adding reference from comment to this
            // does not work cuz comment is immutable
            comment.cat = this;
        }


        public Cat(Long id, String name, AggregateReference<Breed, Long> breedId, AggregateReference<User, Long> ownerId, Date birth_date, ArrayList<String> images, ArrayList<String> toys, List<Comment> comments) {
                this.id = id;
                this.name = name;
                this.breedId = breedId;
                this.ownerId = ownerId;
                this.birth_date = birth_date;
                this.images = images;
                this.toys = toys;
                this.comments = comments;
        }


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public AggregateReference<Breed, Long> getBreedId() {
                return breedId;
        }

        public void setBreedId(AggregateReference<Breed, Long> breedId) {
                this.breedId = breedId;
        }

        public AggregateReference<User, Long> getOwnerId() {
                return ownerId;
        }

        public void setOwnerId(AggregateReference<User, Long> ownerId) {
                this.ownerId = ownerId;
        }

        public Date getBirth_date() {
                return birth_date;
        }

        public void setBirth_date(Date birth_date) {
                this.birth_date = birth_date;
        }

        public ArrayList<String> getImages() {
                return images;
        }

        public void setImages(ArrayList<String> images) {
                this.images = images;
        }

        public ArrayList<String> getToys() {
                return toys;
        }

        public void setToys(ArrayList<String> toys) {
                this.toys = toys;
        }

        public List<Comment> getComments() {
                return comments;
        }

        public void setComments(List<Comment> comments) {
                this.comments = comments;
        }


        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Cat cat = (Cat) o;
                return Objects.equals(id, cat.id) && Objects.equals(name, cat.name) && Objects.equals(breedId, cat.breedId) && Objects.equals(ownerId, cat.ownerId) && Objects.equals(birth_date, cat.birth_date) && Objects.equals(images, cat.images) && Objects.equals(toys, cat.toys) && Objects.equals(comments, cat.comments);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, name, breedId, ownerId, birth_date, images, toys, comments);
        }

        @Override
        public String toString() {
                return "Cat{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", breedId=" + breedId +
                        ", ownerId=" + ownerId +
                        ", birth_date=" + birth_date +
                        ", images=" + images +
                        ", toys=" + toys +
                        ", comments=" + comments +
                        '}';
        }
}
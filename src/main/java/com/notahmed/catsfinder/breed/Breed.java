package com.notahmed.catsfinder.breed;


import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Objects;

// same as before
// Using class for the models is better
// TODO I can find more details about breed such as
//  -- origin country
// -- history
// -- characteristics
// -- facts which is a list
// -- other names
@Table("Breed")
public record Breed (
        @Id
        Long id,
        @NotBlank
        String name,
        String description,
        ArrayList<String> images
){}


// Updated Breed
/*
@Table("Breed")
public record Breed (
        @Id
        Long id,
        @NotBlank
        String name,
        String description,
        ArrayList<String> images,
        String originCountry
        String history,

        // array list or mappedCollection
        ArrayList<String> characteristics,
        ArrayList<String> funFacts
){}
 */

/*
@Table("Breed")
public class Breed {
        @Id
        private Long id;
        @NotBlank
        private String name;
        private String description;
        private ArrayList<String> images;
        private String originCountry;
        private String history;

        // array list or mappedCollection
        private ArrayList<String> characteristics;
        private ArrayList<String> funFacts;


        public Breed(Long id, String name, String description, ArrayList<String> images, String originCountry, String history, ArrayList<String> characteristics, ArrayList<String> funFacts) {
                this.id = id;
                this.name = name;
                this.description = description;
                this.images = images;
                this.originCountry = originCountry;
                this.history = history;
                this.characteristics = characteristics;
                this.funFacts = funFacts;
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

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public ArrayList<String> getImages() {
                return images;
        }

        public void setImages(ArrayList<String> images) {
                this.images = images;
        }

        public String getOriginCountry() {
                return originCountry;
        }

        public void setOriginCountry(String originCountry) {
                this.originCountry = originCountry;
        }

        public String getHistory() {
                return history;
        }

        public void setHistory(String history) {
                this.history = history;
        }

        public ArrayList<String> getCharacteristics() {
                return characteristics;
        }

        public void setCharacteristics(ArrayList<String> characteristics) {
                this.characteristics = characteristics;
        }

        public ArrayList<String> getFunFacts() {
                return funFacts;
        }

        public void setFunFacts(ArrayList<String> funFacts) {
                this.funFacts = funFacts;
        }


        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Breed breed = (Breed) o;
                return Objects.equals(id, breed.id) && Objects.equals(name, breed.name) && Objects.equals(description, breed.description) && Objects.equals(images, breed.images) && Objects.equals(originCountry, breed.originCountry) && Objects.equals(history, breed.history) && Objects.equals(characteristics, breed.characteristics) && Objects.equals(funFacts, breed.funFacts);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, name, description, images, originCountry, history, characteristics, funFacts);
        }

        @Override
        public String toString() {
                return "Breed{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", description='" + description + '\'' +
                        ", images=" + images +
                        ", originCountry='" + originCountry + '\'' +
                        ", history='" + history + '\'' +
                        ", characteristics=" + characteristics +
                        ", funFacts=" + funFacts +
                        '}';
        }
}

 */
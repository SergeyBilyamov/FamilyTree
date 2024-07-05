package com.genealogy.model;

import java.util.List;

public interface FamilyTreeService<T extends Person> {
    void addMember(T person);
    List<T> getAllMembers();
    List<T> getChildren(String parentName);
    void sortByName();
    void sortByBirthDate();
    void saveFamilyTree(String fileName);
    void loadFamilyTree(String fileName);
}
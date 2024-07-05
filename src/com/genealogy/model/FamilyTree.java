package com.genealogy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Person> implements Iterable<T>, Serializable {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T person) {
        members.add(person);
    }

    public List<T> getAllMembers() {
        return Collections.unmodifiableList(members);
    }

    public List<T> getChildren(String parentName) {
        List<T> children = new ArrayList<>();
        for (T person : members) {
            if (parentName.equals(person.getParentName())) {
                children.add(person);
            }
        }
        return children;
    }

    public void sortByName() {
        members.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
    }

    public void sortByBirthDate() {
        members.sort((p1, p2) -> p1.getBirthDate().compareTo(p2.getBirthDate()));
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }
}
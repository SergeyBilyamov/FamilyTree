package com.genealogy.io;

import com.genealogy.model.FamilyTree;

public interface FileHandler {
    void save(FamilyTree<?> familyTree, String fileName);
    FamilyTree<?> load(String fileName);
}
package com.genealogy.io;

import com.genealogy.model.FamilyTree;

import java.io.*;

public class FileHandlerImpl implements FileHandler {
    @Override
    public void save(FamilyTree<?> familyTree, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FamilyTree<?> load(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree<?>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
package com.genealogy.view;

import com.genealogy.model.Person;
import com.genealogy.presenter.FamilyTreePresenter;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FamilyTreeConsoleView implements FamilyTreeView {
    private FamilyTreePresenter presenter;
    private Scanner scanner;
    private Map<String, Command> commands;

    public FamilyTreeConsoleView() {
        this.scanner = new Scanner(System.in);
        this.commands = new HashMap<>();
    }

    @Override
    public void showFamilyMembers(List<Person> members) {
        for (Person person : members) {
            System.out.println(person);
        }
    }

    @Override
    public void showChildren(List<Person> children) {
        for (Person child : children) {
            System.out.println(child);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void start() {
        commands.put("1", new AddMemberCommand(presenter));
        commands.put("2", new ShowAllMembersCommand(presenter));
        commands.put("3", new ShowChildrenCommand(presenter));
        commands.put("4", new SortByNameCommand(presenter));
        commands.put("5", new SortByBirthDateCommand(presenter));
        commands.put("6", new SaveFamilyTreeCommand(presenter));
        commands.put("7", new LoadFamilyTreeCommand(presenter));

        while (true) {
            System.out.println("1. Добавить члена семьи");
            System.out.println("2. Показать всех членов семьи");
            System.out.println("3. Показать детей члена семьи");
            System.out.println("4. Сортировать по имени");
            System.out.println("5. Сортировать по дате рождения");
            System.out.println("6. Сохранить семейное дерево");
            System.out.println("7. Загрузить семейное дерево");
            System.out.println("8. Выход");
            String choice = scanner.nextLine();

            if (choice.equals("8")) {
                System.out.println("до свидания. Спасибо за использование программы.");
                System.exit(0);
            }

            Command command = commands.get(choice);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    public void setPresenter(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }
}
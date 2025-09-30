package org.example;

import javax.swing.*;
import java.awt.*;

class TodoGUI extends JFrame {

    // --- Core Components ---
    private final DefaultListModel<String> listModel;
    private final JList<String> taskList;
    private final JTextField taskInputField;
    private final JButton addButton;
    private final JButton deleteButton;


    public TodoGUI() {
        setTitle("Simple To-Do List");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskInputField = new JTextField(20); // Set a preferred width
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Selected Task");


        JScrollPane scrollPane = new JScrollPane(taskList);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("New Task:"));
        inputPanel.add(taskInputField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(inputPanel, BorderLayout.SOUTH);


        setupActionListeners();
    }
    private void setupActionListeners() {
        //listeners for buttons
        addButton.addActionListener(e -> addTask());
        taskInputField.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());
    }


    //new task
    private void addTask() {
        String task = taskInputField.getText().trim();
        if (!task.isEmpty()) {
            listModel.addElement(task);
            taskInputField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Enter a Task.", "Input Error", JOptionPane.WARNING_MESSAGE);
        }
    }

   //delete task
    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Select a task to delete.", "Selection Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
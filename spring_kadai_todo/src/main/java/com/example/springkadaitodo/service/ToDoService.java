package com.example.springkadaitodo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.repository.ToDoRepository;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository todoRepository;

    // 全件取得
    public List<ToDo> findAll() {
        return todoRepository.findAll();
    }

    // IDで取得
    public ToDo findById(Integer id) {
        Optional<ToDo> todo = todoRepository.findById(id);

        if (todo.isPresent()) {
            return todo.get();
        } else {
            throw new RuntimeException("Todo not found with id: " + id);
        }
    }

    // 新規登録
    public ToDo save(ToDo todo) {
        return todoRepository.save(todo);
    }

    // 更新
    public ToDo update(Integer id, ToDo updatedTodo) {

        ToDo todo = findById(id);

        todo.setTask(updatedTodo.getTask());
        todo.setDone(updatedTodo.getDone());

        return todoRepository.save(todo);
    }

    // 削除
    public void delete(Integer id) {

        ToDo todo = findById(id);

        todoRepository.delete(todo);
    }
}

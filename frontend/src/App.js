import React, { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [todos, setTodos] = useState([]);
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  const fetchTodos = async () => {
    const res = await axios.get("http://localhost:8081/api/todos");
    setTodos(res.data);
  };

  useEffect(() => {
    fetchTodos();
  }, []);

  const addTodo = async () => {
    if (!title.trim()) return alert("Title is mandatory");

    await axios.post("http://localhost:8081/api/todos", {
      title,
      description,
      completed: false
    });

    setTitle("");
    setDescription("");
    fetchTodos();
  };

  const deleteTodo = async (id) => {
    await axios.delete(`http://localhost:8081/api/todos/${id}`);
    fetchTodos();
  };

  const toggleTodo = async (todo) => {
    await axios.put(`http://localhost:8081/api/todos/${todo.id}`, {
      ...todo,
      completed: !todo.completed
    });
    fetchTodos();
  };

  return (
    <div className="container">
      <h1> Todo Application</h1>

      <div className="form">
        <input
          placeholder="Enter title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />

        <input
          placeholder="Enter description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />

        <button onClick={addTodo}>Add Todo</button>
      </div>

      <div className="todo-list">
        {todos.map((todo) => (
          <div key={todo.id} className="todo-card">
            <div>
              <h3
                className={todo.completed ? "completed" : ""}
                onClick={() => toggleTodo(todo)}
              >
                {todo.title}
              </h3>
              <p>{todo.description}</p>
              <small>
                Created: {new Date(todo.createdAt).toLocaleString()}
              </small>
            </div>
            <button className="delete" onClick={() => deleteTodo(todo.id)}>
              Delete
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;

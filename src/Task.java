public class Task {
    private String description;
    private boolean completed;




    public Task(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }

    @Override
    public String toString() {
        String status = completed ? "✅ Completed" : "❌ Not completed";
        return description + " - " + status;
    }

    public boolean isCompleted() {
        return completed;
    }



    public String getDescription() {
        return description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

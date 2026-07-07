import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private List<T> entities = new ArrayList<>();

    public void add(T entity) { entities.add(entity); }
    public List<T> getAll() { return entities; }
}

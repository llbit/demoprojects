import graph.Vertex;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
  public static void main(String[] args) {
  }

  public void bfs(Vertex start) {
    Queue<Vertex> q = new LinkedList<>();
    q.add(start);
    start.visited = true;
    while (!q.isEmpty()) {
      Vertex v = q.remove();
      for (Vertex u : v.neighbours()) {
        if (!u.visited) {
          // TODO: gör något med noden.
          q.add(u);
        }
      }
    }
  }
}

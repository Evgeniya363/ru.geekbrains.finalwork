package service.saving;

import model.Human;

import java.io.IOException;

public interface Formatter {
    boolean save (Human human, String path) throws IOException;
}

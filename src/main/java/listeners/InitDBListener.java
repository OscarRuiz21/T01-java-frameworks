package listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Statement;
import modelo.Operaciones;

public class InitDBListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            // Obtiene la ruta física del archivo init.sql desde el classpath
            String path = sce.getServletContext().getRealPath("/WEB-INF/classes/init.sql");
            String sql = Files.readString(Path.of(path), StandardCharsets.UTF_8);

            Operaciones ops = new Operaciones();
            try (Connection cn = ops.getConnection();
                 Statement st = cn.createStatement()) {
                st.execute(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Aquí podrías cerrar conexiones o limpiar recursos si fuera necesario
    }
}


import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;

/**
 * @author chen.luigi
 */
public class Main {

    public static final String GIT_FOLDER = ".git";
    public static final String GIT_URL = "git://git.savannah.gnu.org/3dldf.git";
    private static final File GIT_CONNECTOR_TEST_DIR = new File(System.getProperty("java.io.tmpdir"));
    private static final File GIT_TMP_DIRECTORY = new File(GIT_CONNECTOR_TEST_DIR, "Git");
    public static final String PROJECT_NAME = "3dldf";

    public static void main(String[] args) throws IOException {

        gitConnectionTest();
    }

    public static void gitConnectionTest() {
        Git git = null;
        File dir = new File(GIT_TMP_DIRECTORY, PROJECT_NAME);

        try {
            // clone git repository
            //getLogger().info("Cloning git repository for {}", projectName);
            git = Git.cloneRepository()
                    .setURI(GIT_URL)
                    .setDirectory(dir)
                    .call();

            // get tags
            File gitDir = new File(dir, GIT_FOLDER);
            Repository repo = new FileRepository(gitDir);
        } catch (InvalidRemoteException e) {
            e.printStackTrace();
        } catch (TransportException e) {
            e.printStackTrace();
        } catch (GitAPIException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

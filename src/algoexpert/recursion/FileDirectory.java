package algoexpert.recursion;


import java.io.File;

/**
 * Given a main directory/folder, list all the files from it, and if this directory has other nested sub-directories,
 * list files from them. It is pretty easy to observe a simple recursion pattern in the above problem.
 * <p>
 * Approach: DFS
 */
public class FileDirectory {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\yacha\\IdeaProjects\\Gayle-Laakmann-McDowell";
        File root = new File(filePath);
        listFiles(root, 0);
    }

    static void listFiles(File root, int level) {
        if (!root.exists() && !root.isDirectory()) {
            return;
        }
        File[] files = root.listFiles();
        if (files == null)
            return;

        for (File file : files) {
            for (int i = 0; i < level; i++) // Number of tabs
                System.out.print("\t");

            if (file.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                System.out.println("[" + file.getName() + "]");

                // recursion for sub-directories
                listFiles(file, level + 1);
            }
        }
    }

    // With using stack
    /*static void listFilesWithStack(File root, int level) {
        if (!root.exists() && !root.isDirectory()) {
            return;
        }
        File[] files = root.listFiles();
        if (files == null)
            return;

        Stack<File> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            File file = stack.pop();
            if (file.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                System.out.println("[" + file.getName() + "]");
                Arrays.stream(file.listFiles()).forEach(stack::push);
            }
        }
    }*/
}

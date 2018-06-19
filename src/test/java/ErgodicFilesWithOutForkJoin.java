import java.io.File;
/**
 * 递归方式去遍历文件夹
 * */
public class ErgodicFilesWithOutForkJoin {

    public StringBuilder ergodicFiles(File file, StringBuilder result) throws Exception {

        if (!file.exists()) {
            throw new Exception("file not exists !! ");
        }
        // 如果是文件夹
        if (file.isDirectory()) {
            result.append(" |--- " + file.getName() );
            File[] childfiles = file.listFiles();
            if (childfiles == null || childfiles.length == 0) {
                result.append(" this is nothing in this directory \n");
            } else {
                for (File childfile : childfiles) {
                    ergodicFiles(childfile, result);
                }
                result.append("\n");
            }
        } else if (file.isFile()) {
            result.append(" \n { " + file.getName() + " } ");
        }
        return result;
    }

    public static void main(String[] args) {
        File file = new File("I://");
        StringBuilder result = new StringBuilder();
        try {
            result = new ErgodicFilesWithOutForkJoin().ergodicFiles(file, new StringBuilder());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}

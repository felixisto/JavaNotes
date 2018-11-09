import java.io.File;

public class Files
{
    public static void main(String[] args)
    {
    	System.out.println("* * * *\nJAVA File samples\n* * * *");
    	System.out.println("");
    	
        String str = "";
        
        // File path of the "current working directory"
        String workingDirectory = "";
        
        try {
        	workingDirectory = new File(".").getAbsolutePath().toString();
        }
        catch (Exception e) {System.out.println("Failed to get the path of the current working directory"); return;}
        
        // File system
        System.out.println("");
        System.out.println("File.separator (system default name-separator) = '" + File.separator + "'");
        
        // File creation
        String standartFilePath = workingDirectory + "Files.java";
        
        System.out.println("Attempting to create a file at \"" + standartFilePath + "\"...");
        
        File file = Files.createFileAt(standartFilePath);
        
        if (file != null) {System.out.println("Successfully created file at path " + standartFilePath);}
        else {System.out.println("Failed to create file at path " + standartFilePath); return;}
        
        // File init
        
        System.out.println("\nA file is an abstract representation of file and directory pathnames.");
        
        System.out.println("Attempting to open a file at \"" + standartFilePath + "\"...");
        
        file = Files.openFileFromStringPath(standartFilePath);
        
        if (file != null) {System.out.println("Successfully opened file from path " + standartFilePath);}
        else {System.out.println("Failed to open file from path " + standartFilePath); return;}
        
        // File conditions
        System.out.println("File can execute= " + String.valueOf(file.canExecute()));
        System.out.println("File can read= " + String.valueOf(file.canRead()));
        System.out.println("File can write= " + String.valueOf(file.canWrite()));
        System.out.println("File is directory= " + String.valueOf(file.isDirectory()));
        System.out.println("File is file= " + String.valueOf(file.isFile()));
        
        // File removal/moving/renaming
        
        // File attributes read/write
        System.out.println("File length= " + file.length());
        System.out.println("File name= " + file.getName());
        System.out.println("File path= " + file.getPath());
        System.out.println("File total space= " + file.getPath());
        System.out.println("File usable space= " + String.valueOf(file.getTotalSpace()) + " bytes");
        System.out.println("File path= " + String.valueOf(file.getUsableSpace()) + " bytes");
        System.out.println("File is hidden= " + file.isHidden());
        
        // File reading/writing
    }
    
    public static File createFileAt(String path)
    {
    	try {
    		File f = new File(path);
    		f.createNewFile();
    		return f;
    	}
    	catch (Exception e)
        {System.out.println("Failed to create file from path, error: " + path);}
        
        return null;
    }
    
    public static File openFileFromStringPath(String path)
    {
    	try {
    		File f = new File(path);
    		return f;
    	}
    	catch (Exception e)
        {System.out.println("Failed to open file from path, error: " + path);}
        
        return null;
    }
}

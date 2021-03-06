import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Files
{
    public static void main(String[] args)
    {
    	System.out.println("* * * *\nJAVA File samples\n* * * *");
        
        String tempFileName = "zxcxst.txt";
        String tempFileNameNEW = "temp.txt";
    	
        String str = "";
        
        // File path of the "current working directory"
        String workingDirectory = "";
        
        try {
        	workingDirectory = Files.getWorkingDirectory();
            System.out.println("Current working directory is " + workingDirectory);
        }
        catch (Exception e) {System.out.println("Failed to get the path of the current working directory"); return;}
        
        // File system
        System.out.println("\nFile.separator (system default name-separator) = '" + File.separator + "'");
        
        // File creation
        String standartFilePath = workingDirectory + File.separator + tempFileName;
        
        System.out.println("Attempting to create a file at \"" + standartFilePath + "\"...");
        
        File file = Files.createFileAt(standartFilePath);
        
        if (file != null) {System.out.println("Successfully created file at path " + standartFilePath);}
        else {System.out.println("Failed to create file at path " + standartFilePath); return;}
        
        System.out.println("Ordering JAVA VM to delete this created file as soon as app closes...");
        
        Files.deleteFileOnExit(file);
        
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
        System.out.println("File is hidden= " + file.isHidden());
        
        // File attributes
        System.out.println("File name= " + file.getName());
        System.out.println("File extension= " + Files.getFileExtension(file.getName()));
        System.out.println("File path (as string)= " + file.getPath());
        System.out.println("File path (as path)= " + file.toPath().toString());
        System.out.println("File base path= " + Files.getBasePath(file.toPath()));
        System.out.println("File size= " + String.valueOf(file.length()) + " bytes");
        System.out.println("File total space= " + String.valueOf(file.getTotalSpace()) + " bytes");
        System.out.println("File usable space= " + String.valueOf(file.getUsableSpace()) + " bytes");
        
        // File reading/writing
        String data = "Info to be written to this file.";
        String appendData = "\nNEW LINE WOOOO!";
        
        System.out.println("\nRead/write operations:");
        System.out.println("Writing '" + data + "' to the file...");
        Files.writeToFile(file, data);
        
        System.out.println("Appending '" + appendData + "' to the end of the file...");
        Files.appendToFile(file, appendData);
        
        String readData = Files.readFromFile(file);
        System.out.println("Reading file, data read: '" + readData + "'");
        
        // File removal/moving/renaming
        //String newPathAsString = getBasePath(file.toPath()).toString() + File.separator + tempFileNameNEW;
        //Path newPath = java.nio.file.Paths.get(newPathAsString);
        //Files.renameFile(file, newPath);
        //Files.deleteFile(file);
    }
    
    public static String getWorkingDirectory()
    {
        Path path = java.nio.file.Paths.get("");
        return path.toAbsolutePath().toString();
    }
    
    public static String getBasePath(Path path)
    {
        try {
            File f = new File(path.toString());
            
            return f.getParentFile().getPath().toString();
        }
        catch (Exception e)
        {
            
        }
        
        return "";
    }
    
    public static String getFileExtension(String fileName)
    {
        String extension = "";
        
        int i = fileName.lastIndexOf('.');
        
        if (i > 0) { return fileName.substring(i+1); }
        
        return "";
    }
    
    public static File createFileAt(String path)
    {
    	try {
    		File f = new File(path);
    		f.createNewFile();
    		return f;
    	}
    	catch (Exception e)
        {System.out.println("Failed to create file from path, error: " + e.toString());}
        
        return null;
    }
    
    public static File openFileFromStringPath(String path)
    {
    	try {
    		File f = new File(path);
    		return f;
    	}
    	catch (Exception e)
        {System.out.println("Failed to open file from path, error: " + e.toString());}
        
        return null;
    }
    
    public static void renameFile(File file, Path destination)
    {
        try {
            java.nio.file.Files.move(file.toPath(), destination, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            // AVOID file.renameTo(destination), apparently its buggy on windows. Use Files.move() instead!
        }
        catch (Exception e)
        {System.out.println("Failed to rename file, error: " + e.toString());}
    }
    
    public static void moveFile(File file, Path destination)
    {
        try {
            java.nio.file.Files.move(file.toPath(), destination, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Exception e)
        {System.out.println("Failed to move file, error: " + e.toString());}
    }
    
    public static void deleteFile(File file)
    {
        try {
            file.delete();
        }
        catch (Exception e)
        {
            
        }
    }
    
    public static void deleteFileOnExit(File file)
    {
        file.deleteOnExit();
    }
    
    public static void writeToFile(File file, String data)
    {
    	try {
            java.nio.file.Files.write(file.toPath(), data.getBytes(), java.nio.file.StandardOpenOption.WRITE);
    	}
    	catch (Exception e)
    	{
    		
    	} 
    }
    
    public static void appendToFile(File file, String data)
    {
    	try {
    		List<String> lines = Arrays.asList(data);
            java.nio.file.Files.write(file.toPath(), lines, java.nio.file.StandardOpenOption.APPEND);
    	}
    	catch (Exception e)
    	{
    		
    	} 
    }
    
    public static String readFromFile(File file)
    {
    	try {
    		byte[] bytes = java.nio.file.Files.readAllBytes(file.toPath());
    		
            return new String(bytes, java.nio.charset.StandardCharsets.UTF_8);
    	}
    	catch (Exception e)
    	{
    		
    	}
    	
    	return "";
    }
    
    public static byte[] readBytesFromFile(File file) {
        try {
            RandomAccessFile file = new RandomAccessFile(file.toPath().getURL().getPath());
            byte[] data = new byte[(int)file.length()];
            file.readFully(data);
            return data;
        }
        catch (Exception e)
    	{
    		
    	}
    	
    	return new byte[0];
    }
}

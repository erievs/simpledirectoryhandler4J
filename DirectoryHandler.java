//***
// Erie Valley Software 
// 2023-2023,  5th, December 2023
// 
// Simple Directory Handler Java (SimpleDirectoryHandler4J)
//
// A simple utility designed for handling directories for games and other programs!
//
// MIT License 
//
//***

package main;

import java.io.File;

public class DirectoryHandler {
	
    public static String getProgramDirectory() {
    	
        String os = System.getProperty("os.name").toLowerCase(); // The OS of the user!
        
        String userHome = System.getProperty("user.home"); // The home directory of the user.

        String ProgramType = "Launcher"; // This is whatever you want your error/success statements to be.
        
        String FolderName = "islandworld-launcher"; // This is what your folder that this will use.
        
        String pdirectory; // It is adirectory because  we already used directory! It stands for program directory.

        
        // It checks your OS and then puts it in a string called pdirectory.
        
        // Win is Windows
        // Nix, Nux - Should be Unix like operating systems such as BSD and Solaris or whatever else could run Java.
        
        if (os.contains("win")) {
        	pdirectory = System.getenv("APPDATA") + File.separator + FolderName;
        } else if (os.contains("nix") || os.contains("nux")) {
        	pdirectory = userHome + File.separator + ".local" + File.separator + FolderName;
        } else if (os.contains("mac")) {
        	pdirectory = userHome + File.separator + "Library" + File.separator + "Application Support" + File.separator + FolderName;
        } else {
        	pdirectory = userHome + File.separator + FolderName;
        }

        
        // This is for libraries your project, if you want you can always change it but I used bin!
        
        // We add pdirectory to whatever sub folder we want with  + File.separator + and then put it in a string!
        
        String lDirectoryPath = pdirectory + File.separator + "bin";
        
        File libDirectory = new File(lDirectoryPath);
        
        
       
        
        if (!libDirectory.exists()) { 
            if (libDirectory.mkdirs()) {
                System.out.println(ProgramType + "directory created: " + libDirectory);
            } else {
                System.err.println("Failed to create bin directory: " + libDirectory);
            }
        } else {
            System.out.println("Bin directory already exists: " + libDirectory);
        }

        return pdirectory;
    }

    public static void main(String[] args) {
    	
        String gameDirectory = getProgramDirectory(); // You can use (your class).DirectoryHandler if I remember to use this string!
        
        System.out.println("Game Directory: " + gameDirectory); // prints out the directory!
    }
}

package application;

import archive.RarFactory;
import archive.ZipFactory;
import crypto.Crypter;
import io.TextFactory;
import io.JsonFactory;
import io.XmlFactory;
import models.Expression;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private String filename;

    private List<Expression> expressions;
    private final ZipFactory zipFactory;
    private final RarFactory rarFactory;
    private final TextFactory textFactory;
    private final JsonFactory jsonFactory;
    private final XmlFactory xmlFactory;

    private boolean isArchive;

    private String archiveName;

    public Application(String filename) {
        this.filename = filename;
        this.expressions = new ArrayList<>();
        this.zipFactory = new ZipFactory();
        this.rarFactory = new RarFactory();
        this.textFactory = new TextFactory();
        this.jsonFactory = new JsonFactory();
        this.xmlFactory = new XmlFactory();
    }

    public int execute() {
        int archiveExitCode = processArchive();
        int fileExitCode = processFile();
        if (archiveExitCode != 0){
            return archiveExitCode;
        }
        return fileExitCode;
    }

    private int processFile() {
        if (filename.endsWith(".txt")) {
            if (filename.endsWith("enc.txt")) {
                Crypter.getInstance().decrypt(filename);
            }
            expressions = textFactory.createDataSource().readData(filename);
            if (expressions.isEmpty()){
                return 1;
            }
            for (Expression ex : expressions) {
                Calculator.calculate(ex);
            }
            textFactory.createDataSource().writeData(expressions, filename);
        }
        if (filename.endsWith(".json")) {
            if (filename.endsWith("enc.json")) {
                Crypter.getInstance().decrypt(filename);
            }
            expressions = jsonFactory.createDataSource().readData(filename);
            if (expressions.isEmpty()){
                return 1;
            }
            for (Expression ex : expressions) {
                Calculator.calculate(ex);
            }
            jsonFactory.createDataSource().writeData(expressions, filename);
        }
        if (filename.endsWith(".xml")) {
            if (filename.endsWith("enc.xml")) {
                Crypter.getInstance().decrypt(filename);
            }
            expressions = xmlFactory.createDataSource().readData(filename);
            if (expressions.isEmpty()){
                return 1;
            }
            for (Expression ex : expressions) {
                Calculator.calculate(ex);
            }
            xmlFactory.createDataSource().writeData(expressions, filename);
        }
        if (isArchive) {
            try {
                zipFactory.createArchiver().createArchive(filename, archiveName);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }
        return 0;
    }

    //TODO : implement exit codes?
    private int processArchive() {
        if (filename.endsWith(".rar")) {
            rarFactory.createArchiver().unArchive(filename, ".");
            //isArchive = true;
        }
        if (filename.endsWith(".zip")) {
            archiveName = filename;
            filename = zipFactory.createArchiver().unArchive(filename, ".");
            isArchive = true;
        }
        return 0;
    }

}

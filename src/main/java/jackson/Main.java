package jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import jackson.pojo.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<User> users = createUsers();
        Tuple2<CsvMapper,CsvSchema> container = createCsvMapper();
        write(container._1, container._2, users);
        List<User> read = read(new File("temp.csv"));
        System.out.println(read);
    }

    private static List<User> read(File csvFile) throws IOException {
        List<User> users = new ArrayList<>();
        MappingIterator<User> userFromFile = new CsvMapper().readerWithTypedSchemaFor(User.class).readValues(csvFile);
        while (userFromFile.hasNext()) {
            users.add(userFromFile.next());
        }
        return users;
    }

    private static void write(CsvMapper csvMapper, CsvSchema csvSchema, Object data) throws IOException {
        ObjectWriter objectWriter = csvMapper.writer(csvSchema);
        File fileTemp = new File("temp.csv");
        FileOutputStream fileOutputStream = new FileOutputStream(fileTemp);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 3245);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
        objectWriter.writeValue(outputStreamWriter, data);
    }

    private static Tuple2<CsvMapper,CsvSchema> createCsvMapper() {
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        CsvSchema csvSchema = csvMapper.schemaFor(User.class).withHeader();
        csvSchema = csvSchema.withColumnSeparator('\t');
        return Tuple.of(csvMapper,csvSchema);
    }

    private static List<User> createUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Vac9",26));
        users.add(new User("Petya",23));
        users.add(new User("Vova",29));
        users.add(new User("Ksuha",23));
        return users;
    }
}

package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private final static long DEFAULT_PERIOD = 10000000000000L;
    private String processorName;
    private long period;
    protected String processorVersion;
    private int valueOfCheap;
    private Scanner informationScanner;
    private List<String> strings;

    public LocalProcessor(String processorName, long period, String processorVersion, int valueOfCheap,
                          Scanner informationScanner, List<String> strings) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.strings = strings;
    }

    public LocalProcessor() {
        this.period = DEFAULT_PERIOD;
        this.strings = new LinkedList<>();
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> strings) {
        if(!Objects.isNull(strings)) {
            for (String s : new LinkedList<>(strings)) {
                if(s != null) {
                    System.out.println(s.hashCode());
                }
            }
        }
    }

//    @FullNameProcessorGeneratorAnnotation
//    public String fullnameProcessorgenerator(LinkedList<String> stringList) {
//        for (int i = 0; i < stringArrayList.size(); i++) {
//            processorName+=stringList.get(i)+' ';
//        }
//        return processorName;
//    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> strings) {
        Objects.nonNull(strings);

        StringBuilder builder = new StringBuilder();
        for(String s :  strings){
            if(s != null){
                builder.append(s)
                        .append(' ');
            }
        }
        this.processorName = builder.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
            Objects.nonNull(file);

            try(Scanner scanner = new Scanner(file)){
                StringBuilder builder = new StringBuilder();
                this.informationScanner = scanner;
                while (scanner.hasNext()) {
                    builder.append(scanner.nextLine());
                }
                this.processorVersion = builder.toString();
            } catch (FileNotFoundException e){
                throw new RuntimeException(e);
            }
    }

//    public static void main(String[] args) {
//        LocalProcessor p = new LocalProcessor();
//        System.out.println( p.fullNameProcessorGenerator(List.of("1", "2", "3")) );
//    }
}

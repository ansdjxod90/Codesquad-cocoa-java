package Day8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class FileWrite {

    public static void main(String[] args) {
        FileWrite fw = new FileWrite();
        try {
            //fw.fileWrite();
            fw.fileRead();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    //파일 작성하는 메소드
    public void fileWrite() throws IOException {

        String directory = "c:\\AccountBook\\test1.txt";  //파일 경로.
        String msg = "테스트용 메시지입니다.";                //작성할 메시지

        BufferedWriter bw = Files.newBufferedWriter(Paths.get(directory), Charset.forName("MS949"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        //입력할때마다 기존 내용이 지워지고 새로 작성하기 원한다면 오른쪽의 StandardOpenOption.CREATE, StandardOpenOption.APPEND을 모두 지워주면 된다.

        bw.write(msg); // 텍스트파일에 지정된 문자열을 작성해줌.

        bw.flush();    // bw객체 청소
        bw.close();    // bw객체 종료
    }

    //파일 읽어오는 메소드
    public void fileRead() throws IOException {


        String directory = "c:\\AccountBook\\test.csv";  //파일 경로
        BufferedReader br = Files.newBufferedReader(Paths.get(directory), Charset.forName("MS949"));
        List<String> arr = new ArrayList<>();

        while(true){
            String line = br.readLine();
            arr.add(line);
            if(line == null) break;
        }



        br.close();

    }

}

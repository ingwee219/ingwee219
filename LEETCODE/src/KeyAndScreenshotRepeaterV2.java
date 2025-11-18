import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

public class KeyAndScreenshotRepeaterV2 extends java.lang.Object {

private static final int KEY_CODE_RIGHT_ARROW = KeyEvent.VK_RIGHT;

// 바탕화면 경로를 동적으로 가져옵니다.
private static final String DESKTOP_PATH = System.getProperty("user.home") + "/Desktop";
private static final String SCREENSHOT_FOLDER_NAME = "pic";
private static final String SCREENSHOT_PATH = DESKTOP_PATH + "/" + SCREENSHOT_FOLDER_NAME + "/";

public static void main(String[] args) {
    // ### 설정: 원하는 반복 횟수를 여기에 입력하세요. ###
    int repeatCount = 10; 
    // ---------------------------------------------------

    System.out.println("프로그램을 시작합니다.");
    System.out.println("스크린샷은 " + SCREENSHOT_PATH + " 에 저장됩니다.");
    System.out.println("총 " + repeatCount + "회 반복됩니다.");

    try {
        Robot robot = new Robot();
        
        // 1. **5초 초기 딜레이 추가**
        System.out.println("\n*** 5초 후에 첫 번째 작업이 시작됩니다. 해당 화면을 활성화하세요. ***");
        robot.delay(5000); // 5000ms = 5초 대기
        
        // 2. 스크린샷 저장 폴더 생성 (바탕화면/pic)
        File screenshotDir = new File(SCREENSHOT_PATH);
        if (!screenshotDir.exists()) {
            System.out.println("저장 폴더가 없어 폴더를 생성합니다: " + SCREENSHOT_PATH);
            screenshotDir.mkdirs();
        } else {
            System.out.println("저장 폴더가 이미 존재합니다: " + SCREENSHOT_PATH);
        }
        
        String fileNam = captureScreenshot(robot, 0);
        System.out.println("2. 스크린샷이 저장되었습니다: " + fileNam);
        // 반복 실행
        for (int i = 1; i < repeatCount; i++) {
            System.out.println("\n--- [" + i + "회차] 작업 시작 ---");

            // 3. 오른쪽 화살표 키 누르기 시뮬레이션
            System.out.println("1. 오른쪽 화살표 키(VK_RIGHT)를 누릅니다.");
            
            robot.keyPress(KEY_CODE_RIGHT_ARROW);
            robot.delay(50); // 짧은 딜레이
            robot.keyRelease(KEY_CODE_RIGHT_ARROW);

            // 4. 화면 갱신 대기 (필요에 따라 조절)
            robot.delay(350); // 0.35초 대기

            // 5. 스크린샷 캡처
            String fileName = captureScreenshot(robot, i);
            System.out.println("2. 스크린샷이 저장되었습니다: " + fileName);
            
            // 다음 반복 전에 잠시 대기
            if (i < repeatCount) {
                robot.delay(100); // 0.1초 대기 후 다음 반복
            }
        }

        System.out.println("\n--- 모든 작업(" + repeatCount + "회) 완료 ---");

    } catch (AWTException e) {
        System.err.println("Robot 클래스 초기화 오류. 시스템 권한을 확인하세요: " + e.getMessage());
    } catch (IOException e) {
        System.err.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
    }
}

/**
 * 전체 화면 스크린샷을 캡처하여 파일로 저장합니다.
 */
private static String captureScreenshot(Robot robot, int index) throws IOException {
    // 전체 화면 영역 가져오기
    Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    
    // 스크린샷 캡처
    BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
    
    // 파일 이름 형식 지정 (순번 및 현재 시간 포함)
    String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
    // 파일 저장 경로: 바탕화면/pic/screenshot_001_시간.png
    String fileName = String.format("%sscreenshot_%03d_%s.png", SCREENSHOT_PATH, index, timestamp);
    File outputFile = new File(fileName);
    
    // PNG 형식으로 파일 저장
    ImageIO.write(screenFullImage, "PNG", outputFile);
    
    return outputFile.getName(); // 저장된 파일 이름만 반환
}
}
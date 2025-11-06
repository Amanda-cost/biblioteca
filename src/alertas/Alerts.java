package alertas;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
	
	public static void alerterro(String title, String header, String content) {
Alert erro = new Alert(AlertType.ERROR);
erro.setTitle(title);
erro.setHeaderText(header);
erro.setContentText(content);
erro.show();
	}
	
	public static void alertinfo(String title, String header, String content) {
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle(title);
		info.setHeaderText(header);
		info.setContentText(content);
		info.show();
			}

}

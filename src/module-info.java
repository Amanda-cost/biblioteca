module Biblioteca {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	 opens controller to javafx.fxml;

	    // Exporta se você precisar acessar classes do controller em outros módulos
	    exports controller;
	    
	    // abre o pacote model para o JavaFX poder acessar via reflexão
	    opens model to javafx.base;

	  
	    exports model;
	  

}

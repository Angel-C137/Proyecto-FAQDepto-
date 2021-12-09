module formularios.faqdepto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens formularios.faqdepto to javafx.fxml;
    exports formularios.faqdepto;
}
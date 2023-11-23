module br.graecus.neptunum {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires jakarta.persistence;
    requires javafx.base;


    opens br.graecus.neptunum to javafx.fxml, javafx.base;
    opens br.graecus.neptunum.controller to javafx.fxml;
    opens br.graecus.neptunum.modelos to org.hibernate.orm.core, javafx.base;
    exports br.graecus.neptunum;
    exports br.graecus.neptunum.controller;
}
module br.graecus.neptunum {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires jakarta.persistence;


    opens br.graecus.neptunum to javafx.fxml;
    opens br.graecus.neptunum.controller to javafx.fxml;
    opens br.graecus.neptunum.modelos to org.hibernate.orm.core;
    exports br.graecus.neptunum;
    exports br.graecus.neptunum.controller;
}
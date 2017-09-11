package no.rutebanken.baba.organisation.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.rutebanken.baba.organisation.model.user.eventfilter.EventFilter;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class NotificationConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long pk;

    @Enumerated(EnumType.STRING)
    @NotNull
    private NotificationType notificationType;


    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private EventFilter eventFilter;

    private boolean enabled;


    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public EventFilter getEventFilter() {
        return eventFilter;
    }

    public void setEventFilter(EventFilter eventFilter) {
        this.eventFilter = eventFilter;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
package akademikerne.domain.view;

import javax.persistence.*;

@Entity
public class Rollebrugersystemrettighedview {
    @Basic
    @Column(name = "rollenavn", nullable = false, length = 50)
    private String rollenavn;
    @Basic
    @Column(name = "systemnavn", nullable = false, length = 50)
    private String systemnavn;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic
    @Column(name = "rettighedstypesystemid", nullable = false)
    private Integer rettighedstypesystemid;
    @Basic
    @Column(name = "rettighedsnavn", nullable = false, length = 50)
    private String rettighedsnavn;
    @Basic
    @Column(name = "rolleindehaverid", nullable = false)
    private Integer rolleindehaverid;
    @Basic
    @Column(name = "revideringsfrekvens", nullable = false)
    private Integer revideringsfrekvens;

    public String getRollenavn() {
        return rollenavn;
    }

    public void setRollenavn(String rollenavn) {
        this.rollenavn = rollenavn;
    }

    public String getSystemnavn() {
        return systemnavn;
    }

    public void setSystemnavn(String systemnavn) {
        this.systemnavn = systemnavn;
    }

    public Integer getRettighedstypesystemid() {
        return rettighedstypesystemid;
    }

    public void setRettighedstypesystemid(Integer rettighedstypesystemid) {
        this.rettighedstypesystemid = rettighedstypesystemid;
    }

    public String getRettighedsnavn() {
        return rettighedsnavn;
    }

    public void setRettighedsnavn(String rettighedsnavn) {
        this.rettighedsnavn = rettighedsnavn;
    }

    public Integer getRolleindehaverid() {
        return rolleindehaverid;
    }

    public void setRolleindehaverid(Integer rolleindehaverid) {
        this.rolleindehaverid = rolleindehaverid;
    }

    public Integer getRevideringsfrekvens() {
        return revideringsfrekvens;
    }

    public void setRevideringsfrekvens(Integer revideringsfrekvens) {
        this.revideringsfrekvens = revideringsfrekvens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rollebrugersystemrettighedview that = (Rollebrugersystemrettighedview) o;

        if (rollenavn != null ? !rollenavn.equals(that.rollenavn) : that.rollenavn != null) return false;
        if (systemnavn != null ? !systemnavn.equals(that.systemnavn) : that.systemnavn != null) return false;
        if (rettighedstypesystemid != null ? !rettighedstypesystemid.equals(that.rettighedstypesystemid) : that.rettighedstypesystemid != null)
            return false;
        if (rettighedsnavn != null ? !rettighedsnavn.equals(that.rettighedsnavn) : that.rettighedsnavn != null)
            return false;
        if (rolleindehaverid != null ? !rolleindehaverid.equals(that.rolleindehaverid) : that.rolleindehaverid != null)
            return false;
        if (revideringsfrekvens != null ? !revideringsfrekvens.equals(that.revideringsfrekvens) : that.revideringsfrekvens != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rollenavn != null ? rollenavn.hashCode() : 0;
        result = 31 * result + (systemnavn != null ? systemnavn.hashCode() : 0);
        result = 31 * result + (rettighedstypesystemid != null ? rettighedstypesystemid.hashCode() : 0);
        result = 31 * result + (rettighedsnavn != null ? rettighedsnavn.hashCode() : 0);
        result = 31 * result + (rolleindehaverid != null ? rolleindehaverid.hashCode() : 0);
        result = 31 * result + (revideringsfrekvens != null ? revideringsfrekvens.hashCode() : 0);
        return result;
    }
}

package com.and1droid.ecohack;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BikeSupport {
    @Id
    @PrimaryKey
    private String inv_id;
    private String inv_no;
    private String anc_num;
    private String inv_catl_no;
    private String catl_modele;
    private String marq;
    private String ce_no;
    private String element;
    private String categorie;
    private String couleur;
    private String materiau;
    private String condition;
    private String intervention;
    private String empl_x;
    private String empl_y;
    private String empl_z;
    private String territoire;
    private String statut;
    private String base;
    private String ancrage;
    private String parc;
    private String aire;
    private String empl_id;
    private String ordre_affichage;
    private String lon;
    private String lat;

    public String getInv_id() {
        return inv_id;
    }

    public void setInv_id(String inv_id) {
        this.inv_id = inv_id;
    }

    public String getInv_no() {
        return inv_no;
    }

    public void setInv_no(String inv_no) {
        this.inv_no = inv_no;
    }

    public String getAnc_num() {
        return anc_num;
    }

    public void setAnc_num(String anc_num) {
        this.anc_num = anc_num;
    }

    public String getInv_catl_no() {
        return inv_catl_no;
    }

    public void setInv_catl_no(String inv_catl_no) {
        this.inv_catl_no = inv_catl_no;
    }

    public String getCatl_modele() {
        return catl_modele;
    }

    public void setCatl_modele(String catl_modele) {
        this.catl_modele = catl_modele;
    }

    public String getMarq() {
        return marq;
    }

    public void setMarq(String marq) {
        this.marq = marq;
    }

    public String getCe_no() {
        return ce_no;
    }

    public void setCe_no(String ce_no) {
        this.ce_no = ce_no;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getMateriau() {
        return materiau;
    }

    public void setMateriau(String materiau) {
        this.materiau = materiau;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getIntervention() {
        return intervention;
    }

    public void setIntervention(String intervention) {
        this.intervention = intervention;
    }

    public String getEmpl_x() {
        return empl_x;
    }

    public void setEmpl_x(String empl_x) {
        this.empl_x = empl_x;
    }

    public String getEmpl_y() {
        return empl_y;
    }

    public void setEmpl_y(String empl_y) {
        this.empl_y = empl_y;
    }

    public String getEmpl_z() {
        return empl_z;
    }

    public void setEmpl_z(String empl_z) {
        this.empl_z = empl_z;
    }

    public String getTerritoire() {
        return territoire;
    }

    public void setTerritoire(String territoire) {
        this.territoire = territoire;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getAncrage() {
        return ancrage;
    }

    public void setAncrage(String ancrage) {
        this.ancrage = ancrage;
    }

    public String getParc() {
        return parc;
    }

    public void setParc(String parc) {
        this.parc = parc;
    }

    public String getAire() {
        return aire;
    }

    public void setAire(String aire) {
        this.aire = aire;
    }

    public String getEmpl_id() {
        return empl_id;
    }

    public void setEmpl_id(String empl_id) {
        this.empl_id = empl_id;
    }

    public String getOrdre_affichage() {
        return ordre_affichage;
    }

    public void setOrdre_affichage(String ordre_affichage) {
        this.ordre_affichage = ordre_affichage;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

}

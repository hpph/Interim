<?php


require_once 'Adresse.php';
require_once 'Login.php';
require_once 'Rdv.php';
require_once 'Metier.php';
require_once 'Contact.php';
require_once 'User.php';
require_once 'Annonce.php';

class Demandeur extends User {

  public $rdvs = array();

  public $metiers = array();

  private $login = null;

  public $annonces = array();

  public $contacts = array();

  public $id_demandeur = null;

}
?>

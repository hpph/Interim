<?php


require_once 'Demandeur.php';
require_once 'User.php';

class Superviseur extends User {
  public $demandeurs = array();

  public $id_superviseur = null;

}
?>

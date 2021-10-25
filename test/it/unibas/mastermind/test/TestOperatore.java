package it.unibas.mastermind.test;

import it.unibas.mastermind.modello.Combinazione;
import it.unibas.mastermind.modello.Operatore;
import it.unibas.mastermind.modello.Risposta;
import org.junit.Assert;
import org.junit.Test;

public class TestOperatore {

    private Operatore operatore = new Operatore();

    @Test
    public void testCombinazioneCorretta() {
//    Combinazione combinazione = new Combinazione();
//    combinazione.setCifraInPosizione(1, 0);
//    combinazione.setCifraInPosizione(2, 1);
//    combinazione.setCifraInPosizione(3, 2);
//    combinazione.setCifraInPosizione(4, 3);
//    Operatore operatore = new Operatore();
//    Assert.assertEquals(1, operatore.contaOccorrenze(1, combinazione));
//    Assert.assertEquals(1, operatore.contaOccorrenze(2, combinazione));
//    Assert.assertEquals(1, operatore.contaOccorrenze(3, combinazione));
//    Assert.assertEquals(1, operatore.contaOccorrenze(4, combinazione));
        Combinazione combinazione = new Combinazione(1, 2, 3, 4);
        Assert.assertTrue(operatore.verificaCorrettezza(combinazione));
        Assert.assertTrue(operatore.verificaCorrettezza(new Combinazione(3, 4, 2, 1)));
        Assert.assertTrue(operatore.verificaCorrettezza(new Combinazione(5, 4, 6, 1)));
        Assert.assertTrue(operatore.verificaCorrettezza(new Combinazione(3, 4, 2, 5)));
    }

    @Test
    public void testCombinazioneErrata() {
        Assert.assertFalse(operatore.verificaCorrettezza(new Combinazione(5, 5, 2, 1)));
        Assert.assertFalse(operatore.verificaCorrettezza(new Combinazione(5, 2, 2, 1)));
        try {
            Combinazione combinazione = new Combinazione(3, 4, 2, 0);
            Assert.fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            Combinazione combinazione = new Combinazione(3, 4, 2, 7);
            Assert.fail();
        } catch (IllegalArgumentException i) {
        }

    }

    @Test
    public void testGeneraCombinazioneCorretta() {
        for (int i = 0; i < 1000; i++) {
            Combinazione combinazione = operatore.genera();
            Assert.assertTrue(operatore.verificaCorrettezza(combinazione));
        }

    }

    @Test
    public void testPalliniBianchi() {
        Combinazione combinazioneSegreta = new Combinazione(1, 2, 3, 4);
        Combinazione tentativo = new Combinazione(4, 3, 2, 1);
        Assert.assertEquals(4, operatore.calcolaPalliniBianchi(combinazioneSegreta, tentativo));
        Assert.assertEquals(2, operatore.calcolaPalliniBianchi(new Combinazione(3, 6, 5, 2), tentativo));
        Assert.assertEquals(3, operatore.calcolaPalliniBianchi(new Combinazione(2, 4, 3, 6), tentativo));
        Assert.assertEquals(0, operatore.calcolaPalliniBianchi(new Combinazione(4, 3, 2, 1), tentativo));
    }

    @Test
    public void testPalliniNeri() {
        Combinazione tentativo = new Combinazione(2, 3, 4, 5);
        Assert.assertEquals(0, operatore.calcolaPalliniNeri(new Combinazione(1, 2, 3, 4), tentativo));
        Assert.assertEquals(1, operatore.calcolaPalliniNeri(new Combinazione(2, 6, 3, 4), tentativo));
        Assert.assertEquals(2, operatore.calcolaPalliniNeri(new Combinazione(2, 3, 1, 4), tentativo));
        Assert.assertEquals(3, operatore.calcolaPalliniNeri(new Combinazione(2, 3, 1, 5), tentativo));
        Assert.assertEquals(4, operatore.calcolaPalliniNeri(new Combinazione(2, 3, 4, 5), tentativo));

    }

    @Test
    public void testValutaTentativo() {
        for (int i = 0; i < 10; i++) {
            Combinazione comb = operatore.genera();
            Combinazione tent = operatore.genera();
            Risposta risp = operatore.valutaTentativo(comb, tent);
        }

    }

}

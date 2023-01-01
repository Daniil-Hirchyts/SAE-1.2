package com.example.e3;

public class Graph {
    private Noeud[] nodes;
    private Etiquette[] etiquettes;
    private Relation[] relations;
    private Fleche[] fleches;
    private Cycle[] cycles;

    public Graph(Noeud[] nodes, Etiquette[] etiquettes, Relation[] relations, Fleche[] fleches, Cycle[] cycles) {
        this.nodes = nodes;
        this.etiquettes = etiquettes;
        this.relations = relations;
        this.fleches = fleches;
        this.cycles = cycles;
    }


}

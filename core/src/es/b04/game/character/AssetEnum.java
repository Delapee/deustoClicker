package es.b04.game.character;

public enum AssetEnum {
    PLAY1("B1.png"), PLAY2("B2.png"), GAMEBCK("backgroundOp.png"), SQUADBCK("BackgroundSquad.png"), CENEMY1("C1.png"),
    CENEMY2("C2.png"), CURSOR("cursor.png"), MAINTITTLE("mainTittle.png"), PIRATE("pirate.png");
    private String asset;

    AssetEnum(String asset) {
        this.asset = asset;
    }

    public String getAsset() {
        return asset;
    }
}

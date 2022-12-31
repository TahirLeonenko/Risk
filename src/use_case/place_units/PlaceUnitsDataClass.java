package use_case.place_units;

import game_entities.Board;
import game_entities.BoardGraph;
import game_entities.PlayerInterface;

public class PlaceUnitsDataClass {
    private final PlayerInterface player;
    private final BoardGraph board;

    public PlaceUnitsDataClass(PlayerInterface player, BoardGraph board) {
        this.player = player;
        this.board = board;
    }

    public PlayerInterface getPlayer() {
        return player;
    }

    public BoardGraph getBoard() {
        return board;
    }
}

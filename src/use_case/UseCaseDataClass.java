package use_case;

import game_entities.BoardGraph;
import game_entities.PlayerInterface;

public class UseCaseDataClass {
    private final PlayerInterface player;
    private final BoardGraph board;

    public UseCaseDataClass(PlayerInterface player, BoardGraph board) {
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

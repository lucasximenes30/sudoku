package ui.custom.screen;

import model.GameStatusEnum;
import model.Space;
import service.BoardService;
import service.EventEnum;
import service.NotifierService;
import ui.custom.button.CheckGameStatusButton;
import ui.custom.button.FinishGameButton;
import ui.custom.button.ResetButton;
import ui.custom.frame.MainFrame;
import ui.custom.input.NumberText;
import ui.custom.panel.MainPanel;
import ui.custom.panel.SudokuSector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainScreen {

    private final static Dimension dimension = new Dimension(600,600);

    private final BoardService boardService;
    private final NotifierService notifierService;

    private JButton finishGameButton;
    private JButton checkGameStatusButton;
    private JButton resetButton;

    public MainScreen(final Map<String, String> gameConfig) {
        this.boardService = new BoardService(gameConfig);
        this.notifierService = new NotifierService();
    }

    public void buildMainScreen() {
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);
        for (int r = 0; r < 9; r+=3) {
            int endRow = r + 2;
            for (int c = 0; c < 9; c+=3) {
                int endCol = c + 2;
                List<Space> spaces = getSpacesFromSector(boardService.getSpace(), c, endCol, r, endRow);
                JPanel sector = generateSection(spaces);
                mainPanel.add(generateSection(spaces));

            }
        }
        addResetButton(mainPanel);
        addCheckGameStatusButton(mainPanel);
        addFinishGameButton(mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private List<Space> getSpacesFromSector(List<List<Space>> spaces,
                                            final int initColl,final int endColl,
                                            final int initRow, final int endRow) {
        List<Space> spaceSector = new ArrayList<>();
        for (int r = initRow; r <= endRow; r++) {
            for (int c = initColl; c <= endColl; c++) {
                spaceSector.add(spaces.get(c).get(r));

            }
        }
        return spaceSector;
    }

    private JPanel generateSection(final List<Space> spaces){
        List<NumberText> fields = new ArrayList<>(spaces.stream()
                .map(NumberText::new)
                .toList());
        fields.forEach(t -> notifierService.subscriber(EventEnum.CLEAR_SPACE,t));
        return new SudokuSector(fields);
    }

    private void addFinishGameButton(JPanel mainPanel) {
       finishGameButton = new FinishGameButton(e ->{
            if(boardService.gameIsFinished()){
                JOptionPane.showMessageDialog(null,"Parabéns, você concluiu o jogo!");
                resetButton.setEnabled(true);
                checkGameStatusButton.setEnabled(false);
                finishGameButton.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null, "Seu jogo tem alguma inconsistência, ajuste e tente novamente.");
            }
       });
        mainPanel.add(finishGameButton);
    }

    private void addCheckGameStatusButton(JPanel mainPanel) {
        checkGameStatusButton = new CheckGameStatusButton(e -> {
            boolean hasErrors = boardService.hasErrors();
            GameStatusEnum gameStatus = boardService.getStatus();
            String message = switch (gameStatus) {
                case NON_STARTED -> "O jogo não foi iniciado";
                case INCOMPLETE -> "O jogo está incompleto.";
                case COMPLETE -> "O jogo está completo.";

            };
            message += hasErrors ? " e contém erros " : " e não contém erros.";
            JOptionPane.showMessageDialog(null, message);
        });
        mainPanel.add(MainScreen.this.checkGameStatusButton);
    }

    private void addResetButton(JPanel mainPanel) {
        resetButton = new ResetButton(e -> {
            int dialogResult = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja realmente reiniciar o jogo?",
                    "Limpar o jogo",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if(dialogResult == 0){
                boardService.reset();
                notifierService.notify(EventEnum.CLEAR_SPACE);
            }
        });
        mainPanel.add(resetButton);
    }
}

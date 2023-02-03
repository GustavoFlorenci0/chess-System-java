package boardgame;

public class Board {
  
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows< 1 || columns <1) {
			throw new BoardException("Erro criando um tabuleiro: tem que ter ´pelo menos 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];		
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Posição nao tem o tabuleiro");
		}
		return pieces[row][column];
	}
	
	public Piece piece( Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição nao tem o tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position ) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Já tem uma Peça nesta posição" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >=0 && column <columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição nao tem o tabuleiro");
		}
		return piece(position) != null;
	}
	
}

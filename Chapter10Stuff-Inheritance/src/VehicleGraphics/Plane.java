package VehicleGraphics;

import java.awt.Color;
import java.awt.Point;

public class Plane extends Vehicle {

	@Override
	public void draw(Point where) {
		Color old = whereToDraw.getInkColor();
		int[] bxs = { where.x, where.x + 50, where.x, where.x + 50 };
		int[] bys = { where.y + 50, where.y + 50, where.y, where.y };
		int[] txs = { where.x, where.x + 25, where.x + 50 };
		int[] tys = { where.y - 75, where.y - 125, where.y - 75 };
		int[] wlxs = {where.x, where.x - 50, where.x};
		int[] wlys = {where.y - 20, where.y - 35, where.y - 50};
		int[] wrxs = {where.x + 50, where.x + 100, where.x + 50};
		int[] wrys = {where.y - 20, where.y - 35, where.y - 50};

		// Fill
		whereToDraw.setInkColor(myColor);
		whereToDraw.drawFilledPolygon(bxs, bys, bxs.length);
		whereToDraw.drawFilledRectangle(where.x, where.y - 75, 50, 75);
		whereToDraw.drawFilledPolygon(txs, tys, txs.length);
		whereToDraw.drawFilledPolygon(wlxs, wlys, wlxs.length);
		whereToDraw.drawFilledPolygon(wrxs, wrys, wrxs.length);

		// Outline
		whereToDraw.setInkColor(Color.BLACK);
		whereToDraw.drawPolygon(bxs, bys, bxs.length);
		whereToDraw.drawRectangle(where.x, where.y - 75, 50, 75);
		whereToDraw.drawPolygon(txs, tys, txs.length);
		whereToDraw.drawPolygon(wlxs, wlys, wlxs.length);
		whereToDraw.drawPolygon(wrxs, wrys, wrxs.length);

		whereToDraw.setInkColor(old);
	}

	@Override
	public void erase(Point where) {
		// TODO Auto-generated method stub

	}

	public Plane(Point initial, Canvas surface, Color theColor) {
		super(initial, surface, theColor);
	}
}

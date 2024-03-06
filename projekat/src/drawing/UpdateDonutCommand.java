package drawing;

import geometry.Donut;

public class UpdateDonutCommand implements Command{

	Donut newDonut;
	Donut originalDonut;
	Donut oldDonut;
	
	public UpdateDonutCommand(Donut oldDonut, Donut newDonut) {
		this.newDonut = newDonut;
		this.oldDonut = oldDonut;
	}
	
	@Override
	public void Do() {
		originalDonut = oldDonut.clone();
		
		oldDonut.setCenter(newDonut.getCenter());
		//oldDonut.setRadius(newDonut.getRadius());
		oldDonut.setInnerColor(newDonut.getInnerColor());
		oldDonut.setInnerRadius(newDonut.getInnerRadius());
		oldDonut.setSelected(true);
		oldDonut.setColor(newDonut.getColor());
	}

	@Override
	public void Undo() {
		
		oldDonut.setCenter(originalDonut.getCenter());
		//oldDonut.setRadius(newDonut.getRadius());
		oldDonut.setInnerColor(originalDonut.getInnerColor());
		oldDonut.setInnerRadius(originalDonut.getInnerRadius());
		oldDonut.setSelected(true);
		oldDonut.setColor(originalDonut.getColor());
	}

	@Override
	public String toString() {
		return "Update,Donut,x:" + originalDonut.getCenter().getX() + ",y:" + originalDonut.getCenter().getY() + ",Radius:" + originalDonut.getRadius() + 
				",innerRadius:" + originalDonut.getInnerRadius() + ",Selected:" + originalDonut.isSelected() +	",Color:" + originalDonut.getColor().getRGB() + ",InnerColor:" + originalDonut.getInnerColor().getRGB()
				+ ",NewDonut x:" + newDonut.getCenter().getX() + ",y:" + newDonut.getCenter().getY() + ",Radius:" + newDonut.getRadius() + 
				",innerRadius:" + newDonut.getInnerRadius() + ",Selected:" + newDonut.isSelected() +	",Color:" + newDonut.getColor().getRGB() + ",InnerColor:" + newDonut.getInnerColor().getRGB();
	}
	
	
}

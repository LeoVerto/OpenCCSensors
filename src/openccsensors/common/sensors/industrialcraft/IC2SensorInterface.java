package openccsensors.common.sensors.industrialcraft;

import ic2.api.IEnergyStorage;
import ic2.api.IReactor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import openccsensors.common.core.ISensorInterface;
import openccsensors.common.core.ISensorTarget;
import openccsensors.common.helper.BlockTileHelper;
import openccsensors.common.sensors.GenericSensorInterface;

public class IC2SensorInterface extends GenericSensorInterface implements ISensorInterface 
{
	
	Class[] relevantClassTypes = {
			IEnergyStorage.class,
			IReactor.class
	};

	@Override
	public String getName() 
	{
		return "ic2sensor";
	}


	@Override
	public String[] getMethods() 
	{
		return null;
	}

	@Override
	public Object[] callMethod(int methodID, Object[] args) throws Exception 
	{
		return null;
	}
	
	@Override
	public HashMap<String, ISensorTarget> getAvailableTargets(World world, int x, int y, int z) {
		
		HashMap<String, ISensorTarget> targets = new HashMap<String, ISensorTarget>();

		HashMap<String, TileEntity> entities = BlockTileHelper.getAdjacentTile(world, x, y, z, relevantClassTypes);

		Iterator it = entities.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<String, TileEntity> pairs = (Entry<String, TileEntity>) it.next();
			targets.put(pairs.getKey(), getTargetForTileEntity(pairs.getValue()));
		}

		return targets;
	}
	
	private ISensorTarget getTargetForTileEntity(TileEntity entity)
	{
		if (entity instanceof IReactor)
		{
			return new ReactorTarget(entity);
		}
		else if (entity instanceof IEnergyStorage)
		{
			return new EnergyStorageTarget(entity);
		}
		
		return null;
	}

}

package tw.edu.ntu.csie.experimental

import org.apache.spark.util.Vector
import java.io.FileOutputStream
import java.io.FileInputStream
import java.io.ObjectOutputStream
import java.io.ObjectInputStream
import scala.Predef
import tw.edu.ntu.csie.experimental.SolverType._

/** 
 * A linear model stores weights and other information.
 *
 *@param param user-specified parameters
 *@param w the weights of features
 *@param nrClass the number of classes
 *@param bias the value of user-specified bias
 */
class Model(val param : Parameter, labelSet : Array[Double]) extends Serializable
{
	var label : Array[Double] = labelSet.sortWith(_ < _)
	val nrClass : Int = label.size
	var w : Array[Vector] = new Array(nrClass)
	var bias : Double = -1.0

	def setBias(b : Double) : this.type = 
	{
		this.bias = b
		this
	}

	/** 
	 * Save Model to the local file system.
	 *
	 * @param fileName path to the output file
	 */
	def saveModel(fileName : String) =
	{
		val fos = new FileOutputStream(fileName)
		val oos = new ObjectOutputStream(fos)
		oos.writeObject(this)
		oos.close
	}
}

object Model
{

	/** 
	 * load Model from the local file system.
	 *
	 * @param fileName path to the input file
	 */
	def loadModel(fileName : String) : Model =
	{
		val fis = new FileInputStream(fileName)
		val ois = new ObjectInputStream(fis)
		val model : Model = ois.readObject.asInstanceOf[Model]
		ois.close
		model
	}
}

	

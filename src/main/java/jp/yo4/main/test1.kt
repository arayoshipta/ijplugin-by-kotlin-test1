package jp.yo4.main

import ij.IJ
import ij.ImagePlus
import ij.plugin.filter.PlugInFilter
import ij.plugin.filter.PlugInFilter.*
import ij.process.ImageProcessor

/**
 * Created by Yoshiyuki on 1/22/2017.
 */
class test1 : PlugInFilter {
    var imp: ImagePlus? = null
    override fun setup(str: String?, imp: ImagePlus?): Int {
        this.imp = imp
        return DOES_ALL
    }

    override fun run(ip: ImageProcessor?) {
        if(ip != null) {
            IJ.log("if-check")
            ip.invert()
            imp?.updateAndDraw()
        }
        IJ.wait(1000)

        IJ.log("safe call")
        ip?.invert()
        imp?.updateAndDraw()

        IJ.wait(1000)
        IJ.log("!!")
        ip!!.invert()
        imp?.updateAndDraw()
    }
}
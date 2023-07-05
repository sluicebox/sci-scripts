;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64869)
(include sci.sh)
(use Plane)
(use Actor)
(use System)

(instance voTemp of View
	(properties)
)

(class TiledBitmap of Obj
	(properties
		bitmap 0
		bBorder 1
		nSizeMode 0
		nWidth 0
		nHeight 0
		nTilesX 0
		nTilesY 0
		nBaseTilesX 0
		nBaseTilesY 0
		nOffsetX 0
		nOffsetY 0
		nBaseWidth 0
		nBaseHeight 0
		nBorderHeight 0
		nBorderWidth 0
		nLeftBorderWidth 0
		nRightBorderWidth 0
		nTopBorderHeight 0
		nBottomBorderHeight 0
		vTiles -1
	)

	(method (init param1 param2 param3 param4 param5)
		(super init: &rest)
		(if (< argc 3)
			(PrintDebug {invalid init of TiledBitmap})
			(return)
		)
		(= vTiles param1)
		(if (> argc 3)
			(= nSizeMode param4)
		)
		(if (> argc 4)
			(= bBorder param5)
		)
		(self resize: param2 param3)
	)

	(method (resize param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(if (< argc 2)
			(PrintDebug {Invalid resize of TiledBitmap})
			(return)
		)
		(if (not (ResCheck rsVIEW vTiles))
			(PrintDebug {no view %hd for TiledBitmap} vTiles)
			(return)
		)
		(voTemp view: vTiles loop: 0 cel: 0)
		(if (or (< (= temp5 (NumLoops voTemp)) 1) (> temp5 2))
			(PrintDebug {wrong number of loops view %hd} vTiles)
			(return)
		)
		(if (== temp5 1)
			(= temp0 0)
			(= temp6 (NumCels voTemp))
		else
			(= temp0 bBorder)
			(= temp6 (NumCels voTemp))
			(voTemp loop: 1)
			(= temp7 (NumCels voTemp))
		)
		(if (or (!= temp6 1) (and temp0 (!= temp7 8)))
			(PrintDebug
				{Error: tiles view %hd should have 1 cel in loop 0, 8 cels in loop 1}
			)
			(return)
		)
		(= nBaseWidth (CelWide vTiles 0 0))
		(= nBaseHeight (CelHigh vTiles 0 0))
		(if temp0
			(= nBorderHeight (CelHigh vTiles 1 0))
			(= nBorderWidth (CelWide vTiles 1 2))
			(= nLeftBorderWidth (CelWide vTiles 1 0))
			(= nRightBorderWidth (CelWide vTiles 1 1))
			(= nTopBorderHeight (CelHigh vTiles 1 2))
			(= nBottomBorderHeight (CelHigh vTiles 1 3))
			(if (or (!= nBaseHeight nBorderHeight) (!= nBaseWidth nBorderWidth))
				(= temp11 0)
			else
				(= temp11 1)
			)
			(= temp8 0)
			(if (!= nBorderHeight (CelHigh vTiles 1 1))
				(PrintDebug {view %hd left/right borders don't match})
				(= temp8 1)
			)
			(if (!= nBorderWidth (CelWide vTiles 1 3))
				(PrintDebug {view %hd top/bottom borders don't match})
				(= temp8 1)
			)
			(if
				(or
					(!= nLeftBorderWidth (CelWide vTiles 1 4))
					(!= nTopBorderHeight (CelHigh vTiles 1 4))
				)
				(PrintDebug {view %hd TL corner wrong size})
				(= temp8 1)
			)
			(if
				(or
					(!= nRightBorderWidth (CelWide vTiles 1 5))
					(!= nTopBorderHeight (CelHigh vTiles 1 5))
				)
				(PrintDebug {view %hd TR corner wrong size})
				(= temp8 1)
			)
			(if
				(or
					(!= nLeftBorderWidth (CelWide vTiles 1 6))
					(!= nBottomBorderHeight (CelHigh vTiles 1 6))
				)
				(PrintDebug {view %hd BL corner wrong size})
				(= temp8 1)
			)
			(if
				(or
					(!= nRightBorderWidth (CelWide vTiles 1 7))
					(!= nBottomBorderHeight (CelHigh vTiles 1 7))
				)
				(PrintDebug {view %hd BR corner wrong size})
				(= temp8 1)
			)
			(if temp8
				(return)
			)
		else
			(= nBorderHeight nBaseHeight)
			(= nBorderWidth nBaseWidth)
			(= temp11 1)
			(= nBottomBorderHeight
				(= nTopBorderHeight
					(= nRightBorderWidth (= nLeftBorderWidth 0))
				)
			)
		)
		(switch nSizeMode
			(0
				(= nTilesX (/ param1 nBorderWidth))
				(if (!= param1 (* nTilesX nBorderWidth))
					(++ nTilesX)
				)
				(= nTilesY (/ param2 nBorderHeight))
				(if (!= param2 (* nTilesY nBorderHeight))
					(++ nTilesY)
				)
			)
			(1
				(= temp1 (- param1 (+ nLeftBorderWidth nRightBorderWidth)))
				(= temp2 (- param2 (+ nTopBorderHeight nBottomBorderHeight)))
				(if (or (< temp1 nBaseWidth) (< temp2 nBaseHeight))
					(PrintDebug {requested max size too small for tiles})
				)
				(= nTilesX (/ temp1 nBaseWidth))
				(= nTilesY (/ temp2 nBaseHeight))
			)
		)
		(if temp11
			(= nBaseTilesX nTilesX)
			(= nBaseTilesY nTilesY)
		else
			(= temp1 (* nTilesX nBorderWidth))
			(= temp2 (* nTilesY nBorderHeight))
			(= nBaseTilesX (/ temp1 nBaseWidth))
			(if (!= temp1 (* nBaseTilesX nBaseWidth))
				(++ nBaseTilesX)
			)
			(= nBaseTilesY (/ temp2 nBaseHeight))
			(if (!= temp2 (* nBaseTilesY nBaseHeight))
				(++ nBaseTilesY)
			)
		)
		(if temp0
			(= nWidth
				(+ nLeftBorderWidth (* nBorderWidth nTilesX) nRightBorderWidth)
			)
			(= nHeight
				(+
					nTopBorderHeight
					(* nBorderHeight nTilesY)
					nBottomBorderHeight
				)
			)
			(= nOffsetX
				(+ nLeftBorderWidth (/ (- (* nBorderWidth nTilesX) param1) 2))
			)
			(= nOffsetY
				(+ nTopBorderHeight (/ (- (* nBorderHeight nTilesY) param2) 2))
			)
		else
			(= nWidth param1)
			(= nHeight param2)
			(= nOffsetY (= nOffsetX 0))
		)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
			(= bitmap 0)
		)
		(= bitmap (Bitmap 0 nWidth nHeight 255 255)) ; Create
		(= temp9 nLeftBorderWidth)
		(= temp10 nTopBorderHeight)
		(for ((= temp3 0)) (< temp3 nBaseTilesY) ((++ temp3))
			(for ((= temp4 0)) (< temp4 nBaseTilesX) ((++ temp4))
				(Bitmap 3 bitmap vTiles 0 0 temp9 temp10) ; AddCel
				(+= temp9 nBaseWidth)
			)
			(= temp9 nLeftBorderWidth)
			(+= temp10 nBaseHeight)
		)
		(if temp0
			(= temp9 0)
			(= temp10 0)
			(Bitmap 3 bitmap vTiles 1 4 temp9 0) ; AddCel
			(+= temp9 nLeftBorderWidth)
			(for ((= temp3 0)) (< temp3 nTilesX) ((++ temp3))
				(Bitmap 3 bitmap vTiles 1 2 temp9 temp10) ; AddCel
				(+= temp9 nBorderWidth)
			)
			(Bitmap 3 bitmap vTiles 1 5 temp9 temp10) ; AddCel
			(= temp9 0)
			(= temp10 nTopBorderHeight)
			(for ((= temp3 0)) (< temp3 nTilesY) ((++ temp3))
				(Bitmap 3 bitmap vTiles 1 0 temp9 temp10) ; AddCel
				(+= temp10 nBorderHeight)
			)
			(= temp9 (+ nLeftBorderWidth (* nTilesX nBorderWidth)))
			(= temp10 nTopBorderHeight)
			(Bitmap
				5 ; AddRect
				bitmap
				temp9
				temp10
				(- (+ temp9 nRightBorderWidth) 1)
				(- (+ temp10 (* nBorderHeight nTilesY)) 1)
				255
			)
			(for ((= temp3 0)) (< temp3 nTilesY) ((++ temp3))
				(Bitmap 3 bitmap vTiles 1 1 temp9 temp10) ; AddCel
				(+= temp10 nBorderHeight)
			)
			(= temp9 0)
			(= temp10 (+ nTopBorderHeight (* nBorderHeight nTilesY)))
			(Bitmap
				5 ; AddRect
				bitmap
				temp9
				temp10
				(- nWidth 1)
				(- (+ temp10 nBottomBorderHeight) 1)
				255
			)
			(Bitmap 3 bitmap vTiles 1 6 temp9 temp10) ; AddCel
			(+= temp9 nLeftBorderWidth)
			(for ((= temp3 0)) (< temp3 nTilesX) ((++ temp3))
				(Bitmap 3 bitmap vTiles 1 3 temp9 temp10) ; AddCel
				(+= temp9 nBorderWidth)
			)
			(Bitmap 3 bitmap vTiles 1 7 temp9 temp10) ; AddCel
		)
	)

	(method (getBitmap param1 &tmp temp0)
		(= temp0 bitmap)
		(if (and argc param1)
			(= bitmap 0)
		)
		(return temp0)
	)

	(method (dispose)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
			(= bitmap 0)
		)
		(super dispose: &rest)
	)
)

(class TiledView of View
	(properties
		nWidth 0
		nHeight 0
		nOffsetX 0
		nOffsetY 0
	)

	(method (init param1 param2 param3 param4)
		(cond
			((< argc 2)
				(PrintDebug {Invalid init of TiledView -- not enough params})
			)
			((== argc 2)
				(TiledBitmap init: view param1 param2)
			)
			((== argc 3)
				(TiledBitmap init: view param1 param2 param3)
			)
			((> argc 3)
				(TiledBitmap init: view param1 param2 param3 param4)
			)
		)
		(= bitmap (TiledBitmap getBitmap: 1))
		(= nWidth (TiledBitmap nWidth:))
		(= nHeight (TiledBitmap nHeight:))
		(= nOffsetX (TiledBitmap nOffsetX:))
		(= nOffsetY (TiledBitmap nOffsetY:))
		(super init: &rest)
	)

	(method (dispose &tmp temp0)
		(= temp0 0)
		(if bitmap
			(= temp0 bitmap)
			(= bitmap 0)
		)
		(super dispose:)
		(if temp0
			(Bitmap 1 temp0) ; Dispose
		)
	)
)

(class TiledPlane of Plane
	(properties
		bBorder 1
		nSizeMode 0
		nOffsetX 0
		nOffsetY 0
		vTiles -1
		voBG 0
	)

	(method (init param1 param2 param3 param4 param5 param6 param7 &tmp [temp0 2])
		(if (< argc 5)
			(PrintDebug {Not enough params to init of TiledPlane})
			(return)
		)
		(super init: param1 param2 param3 param4 &rest)
		(= vTiles param5)
		(if (> argc 5)
			(= nSizeMode param6)
		)
		(if (> argc 6)
			(= bBorder param7)
		)
		(self setRect: param1 param2 param3 param4)
	)

	(method (dispose)
		(if voBG
			(voBG dispose:)
			(= voBG 0)
		)
		(super dispose: &rest)
	)

	(method (setRect param1 param2 param3 param4 &tmp temp0 temp1)
		(= temp0 (+ (- param3 param1) 1))
		(= temp1 (+ (- param4 param2) 1))
		(if
			(or
				(!= temp0 (self getWidth:))
				(!= temp1 (self getHeight:))
				(not voBG)
			)
			(if voBG
				(voBG dispose:)
			)
			(= voBG (TiledView new:))
			(voBG name: {voBG} setPri: 0 view: vTiles)
			(voBG init: temp0 temp1 nSizeMode bBorder self)
			(= nOffsetX (voBG nOffsetX:))
			(= nOffsetY (voBG nOffsetY:))
			(= temp0 (voBG nWidth:))
			(= temp1 (voBG nHeight:))
		)
		(super setRect: left top (- (+ left temp0) 1) (- (+ top temp1) 1))
	)
)


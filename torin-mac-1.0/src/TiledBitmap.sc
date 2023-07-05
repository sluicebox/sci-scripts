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
		bitmap 0
		vTiles -1
	)

	(method (init vTilesParm nX nY nSizeParm bBorderParm)
		(super init: &rest)
		(if (< argc 3)
			(PrintDebug {invalid init of TiledBitmap})
			(return)
		)
		(= vTiles vTilesParm)
		(if (> argc 3)
			(= nSizeMode nSizeParm)
		)
		(if (> argc 4)
			(= bBorder bBorderParm)
		)
		(self resize: nX nY)
	)

	(method (resize nX nY &tmp bMakeBorder nXTemp nYTemp i j nLoops nCels0 nCels1 bProb nCurX nCurY bBaseBorderMatch)
		(if (< argc 2)
			(PrintDebug {Invalid resize of TiledBitmap})
			(return)
		)
		(if (not (ResCheck rsVIEW vTiles))
			(PrintDebug {no view %hd for TiledBitmap} vTiles)
			(return)
		)
		(voTemp view: vTiles loop: 0 cel: 0)
		(if (or (< (= nLoops (NumLoops voTemp)) 1) (> nLoops 2))
			(PrintDebug {wrong number of loops view %hd} vTiles)
			(return)
		)
		(if (== nLoops 1)
			(= bMakeBorder 0)
			(= nCels0 (NumCels voTemp))
		else
			(= bMakeBorder bBorder)
			(= nCels0 (NumCels voTemp))
			(voTemp loop: 1)
			(= nCels1 (NumCels voTemp))
		)
		(if (or (!= nCels0 1) (and bMakeBorder (!= nCels1 8)))
			(PrintDebug
				{Error: tiles view %hd should have 1 cel in loop 0, 8 cels in loop 1}
			)
			(return)
		)
		(= nBaseWidth (CelWide vTiles 0 0))
		(= nBaseHeight (CelHigh vTiles 0 0))
		(if bMakeBorder
			(= nBorderHeight (CelHigh vTiles 1 0))
			(= nBorderWidth (CelWide vTiles 1 2))
			(= nLeftBorderWidth (CelWide vTiles 1 0))
			(= nRightBorderWidth (CelWide vTiles 1 1))
			(= nTopBorderHeight (CelHigh vTiles 1 2))
			(= nBottomBorderHeight (CelHigh vTiles 1 3))
			(if (or (!= nBaseHeight nBorderHeight) (!= nBaseWidth nBorderWidth))
				(= bBaseBorderMatch 0)
			else
				(= bBaseBorderMatch 1)
			)
			(= bProb 0)
			(if (!= nBorderHeight (CelHigh vTiles 1 1))
				(PrintDebug {view %hd left/right borders don't match})
				(= bProb 1)
			)
			(if (!= nBorderWidth (CelWide vTiles 1 3))
				(PrintDebug {view %hd top/bottom borders don't match})
				(= bProb 1)
			)
			(if
				(or
					(!= nLeftBorderWidth (CelWide vTiles 1 4))
					(!= nTopBorderHeight (CelHigh vTiles 1 4))
				)
				(PrintDebug {view %hd TL corner wrong size})
				(= bProb 1)
			)
			(if
				(or
					(!= nRightBorderWidth (CelWide vTiles 1 5))
					(!= nTopBorderHeight (CelHigh vTiles 1 5))
				)
				(PrintDebug {view %hd TR corner wrong size})
				(= bProb 1)
			)
			(if
				(or
					(!= nLeftBorderWidth (CelWide vTiles 1 6))
					(!= nBottomBorderHeight (CelHigh vTiles 1 6))
				)
				(PrintDebug {view %hd BL corner wrong size})
				(= bProb 1)
			)
			(if
				(or
					(!= nRightBorderWidth (CelWide vTiles 1 7))
					(!= nBottomBorderHeight (CelHigh vTiles 1 7))
				)
				(PrintDebug {view %hd BR corner wrong size})
				(= bProb 1)
			)
			(if bProb
				(return)
			)
		else
			(= nBorderHeight nBaseHeight)
			(= nBorderWidth nBaseWidth)
			(= bBaseBorderMatch 1)
			(= nBottomBorderHeight
				(= nTopBorderHeight
					(= nRightBorderWidth (= nLeftBorderWidth 0))
				)
			)
		)
		(switch nSizeMode
			(0
				(= nTilesX (/ nX nBorderWidth))
				(if (!= nX (* nTilesX nBorderWidth))
					(++ nTilesX)
				)
				(= nTilesY (/ nY nBorderHeight))
				(if (!= nY (* nTilesY nBorderHeight))
					(++ nTilesY)
				)
			)
			(1
				(= nXTemp (- nX (+ nLeftBorderWidth nRightBorderWidth)))
				(= nYTemp (- nY (+ nTopBorderHeight nBottomBorderHeight)))
				(if (or (< nXTemp nBaseWidth) (< nYTemp nBaseHeight))
					(PrintDebug {requested max size too small for tiles})
				)
				(= nTilesX (/ nXTemp nBaseWidth))
				(= nTilesY (/ nYTemp nBaseHeight))
			)
		)
		(if bBaseBorderMatch
			(= nBaseTilesX nTilesX)
			(= nBaseTilesY nTilesY)
		else
			(= nXTemp (* nTilesX nBorderWidth))
			(= nYTemp (* nTilesY nBorderHeight))
			(= nBaseTilesX (/ nXTemp nBaseWidth))
			(if (!= nXTemp (* nBaseTilesX nBaseWidth))
				(++ nBaseTilesX)
			)
			(= nBaseTilesY (/ nYTemp nBaseHeight))
			(if (!= nYTemp (* nBaseTilesY nBaseHeight))
				(++ nBaseTilesY)
			)
		)
		(if bMakeBorder
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
				(+ nLeftBorderWidth (/ (- (* nBorderWidth nTilesX) nX) 2))
			)
			(= nOffsetY
				(+ nTopBorderHeight (/ (- (* nBorderHeight nTilesY) nY) 2))
			)
		else
			(= nWidth nX)
			(= nHeight nY)
			(= nOffsetY (= nOffsetX 0))
		)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
			(= bitmap 0)
		)
		(= bitmap (Bitmap 0 nWidth nHeight 255 255)) ; Create
		(= nCurX nLeftBorderWidth)
		(= nCurY nTopBorderHeight)
		(for ((= i 0)) (< i nBaseTilesY) ((++ i))
			(for ((= j 0)) (< j nBaseTilesX) ((++ j))
				(Bitmap 3 bitmap vTiles 0 0 nCurX nCurY) ; AddCel
				(+= nCurX nBaseWidth)
			)
			(= nCurX nLeftBorderWidth)
			(+= nCurY nBaseHeight)
		)
		(if bMakeBorder
			(= nCurX 0)
			(= nCurY 0)
			(Bitmap 3 bitmap vTiles 1 4 nCurX 0) ; AddCel
			(+= nCurX nLeftBorderWidth)
			(for ((= i 0)) (< i nTilesX) ((++ i))
				(Bitmap 3 bitmap vTiles 1 2 nCurX nCurY) ; AddCel
				(+= nCurX nBorderWidth)
			)
			(Bitmap 3 bitmap vTiles 1 5 nCurX nCurY) ; AddCel
			(= nCurX 0)
			(= nCurY nTopBorderHeight)
			(for ((= i 0)) (< i nTilesY) ((++ i))
				(Bitmap 3 bitmap vTiles 1 0 nCurX nCurY) ; AddCel
				(+= nCurY nBorderHeight)
			)
			(= nCurX (+ nLeftBorderWidth (* nTilesX nBorderWidth)))
			(= nCurY nTopBorderHeight)
			(Bitmap
				5 ; AddRect
				bitmap
				nCurX
				nCurY
				(- (+ nCurX nRightBorderWidth) 1)
				(- (+ nCurY (* nBorderHeight nTilesY)) 1)
				255
			)
			(for ((= i 0)) (< i nTilesY) ((++ i))
				(Bitmap 3 bitmap vTiles 1 1 nCurX nCurY) ; AddCel
				(+= nCurY nBorderHeight)
			)
			(= nCurX 0)
			(= nCurY (+ nTopBorderHeight (* nBorderHeight nTilesY)))
			(Bitmap
				5 ; AddRect
				bitmap
				nCurX
				nCurY
				(- nWidth 1)
				(- (+ nCurY nBottomBorderHeight) 1)
				255
			)
			(Bitmap 3 bitmap vTiles 1 6 nCurX nCurY) ; AddCel
			(+= nCurX nLeftBorderWidth)
			(for ((= i 0)) (< i nTilesX) ((++ i))
				(Bitmap 3 bitmap vTiles 1 3 nCurX nCurY) ; AddCel
				(+= nCurX nBorderWidth)
			)
			(Bitmap 3 bitmap vTiles 1 7 nCurX nCurY) ; AddCel
		)
	)

	(method (getBitmap bRelease &tmp tmpBitmap)
		(= tmpBitmap bitmap)
		(if (and argc bRelease)
			(= bitmap 0)
		)
		(return tmpBitmap)
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

	(method (init nX nY nSizeParm bBorderParm)
		(cond
			((< argc 2)
				(PrintDebug {Invalid init of TiledView -- not enough params})
			)
			((== argc 2)
				(TiledBitmap init: view nX nY)
			)
			((== argc 3)
				(TiledBitmap init: view nX nY nSizeParm)
			)
			((> argc 3)
				(TiledBitmap init: view nX nY nSizeParm bBorderParm)
			)
		)
		(= bitmap (TiledBitmap getBitmap: 1))
		(= nWidth (TiledBitmap nWidth:))
		(= nHeight (TiledBitmap nHeight:))
		(= nOffsetX (TiledBitmap nOffsetX:))
		(= nOffsetY (TiledBitmap nOffsetY:))
		(super init: &rest)
	)

	(method (dispose &tmp bm)
		(= bm 0)
		(if bitmap
			(= bm bitmap)
			(= bitmap 0)
		)
		(super dispose:)
		(if bm
			(Bitmap 1 bm) ; Dispose
		)
	)
)

(class TiledPlane of Plane
	(properties
		nOffsetX 0
		nOffsetY 0
		voBG 0
		vTiles -1
		nSizeMode 0
		bBorder 1
	)

	(method (init nLeft nTop nRight nBottom vTilesParm nSizeParm bBorderParm &tmp [temp0 2])
		(if (< argc 5)
			(PrintDebug {Not enough params to init of TiledPlane})
			(return)
		)
		(super init: nLeft nTop nRight nBottom &rest)
		(= vTiles vTilesParm)
		(if (> argc 5)
			(= nSizeMode nSizeParm)
		)
		(if (> argc 6)
			(= bBorder bBorderParm)
		)
		(self setRect: nLeft nTop nRight nBottom)
	)

	(method (dispose)
		(if voBG
			(voBG dispose:)
			(= voBG 0)
		)
		(super dispose: &rest)
	)

	(method (setRect nLeft nTop nRight nBottom &tmp nWide nHigh)
		(= nWide (+ (- nRight nLeft) 1))
		(= nHigh (+ (- nBottom nTop) 1))
		(if
			(or
				(!= nWide (self getWidth:))
				(!= nHigh (self getHeight:))
				(not voBG)
			)
			(if voBG
				(voBG dispose:)
			)
			(= voBG (TiledView new:))
			(voBG name: {voBG} setPri: 0 view: vTiles)
			(voBG init: nWide nHigh nSizeMode bBorder self)
			(= nOffsetX (voBG nOffsetX:))
			(= nOffsetY (voBG nOffsetY:))
			(= nWide (voBG nWidth:))
			(= nHigh (voBG nHeight:))
		)
		(super setRect: left top (- (+ left nWide) 1) (- (+ top nHigh) 1))
	)
)


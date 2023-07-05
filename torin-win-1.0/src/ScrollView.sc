;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64891)
(include sci.sh)
(use Main)
(use Plane)
(use Actor)
(use System)

(class ScrollView of View
	(properties
		nScrollSpeedX 0
		nScrollSpeedY 0
		nScrollDenomX 0
		nScrollDenomY 0
		nOriginX 0
		nOriginY 0
		oMyPlane 0
	)

	(method (setScreenSpeed nArgX nArgY &tmp nSpeedX nSpeedY nPlaneMaxX nPlaneMaxY)
		(if oMyPlane
			(if argc
				(= nSpeedX nArgX)
			else
				(= nSpeedX 0)
			)
			(if (> argc 1)
				(= nSpeedY nArgY)
			else
				(= nSpeedY 0)
			)
			(= nPlaneMaxX (oMyPlane nScrollMaxX:))
			(= nPlaneMaxY (oMyPlane nScrollMaxY:))
			(= nScrollSpeedX (- nPlaneMaxX nSpeedX))
			(= nScrollSpeedY (- nPlaneMaxY nSpeedY))
			(if (== nSpeedX 0)
				(= nScrollDenomX (= nScrollSpeedX 1))
			)
			(if (== nSpeedY 0)
				(= nScrollDenomY (= nScrollSpeedY 1))
			)
		)
		(= nOriginX x)
		(= nOriginY y)
	)

	(method (setSpeedFraction axis nNum nDenom &tmp nPlaneMaxX nPlaneMaxY)
		(if (and oMyPlane (> argc 2))
			(cond
				((== axis 0)
					(= nScrollSpeedX
						(-
							(= nPlaneMaxX (oMyPlane nScrollMaxX:))
							(/ (* nPlaneMaxX nNum) nDenom)
						)
					)
				)
				((== axis 1)
					(= nScrollSpeedY
						(-
							(= nPlaneMaxY (oMyPlane nScrollMaxY:))
							(/ (* nPlaneMaxY nNum) nDenom)
						)
					)
				)
			)
		)
		(= nOriginX x)
		(= nOriginY y)
	)

	(method (setTotalWidth axis nWidth &tmp nPlaneMaxX nPlaneMaxY nPlaneSizeX nPlaneSizeY)
		(if (and oMyPlane (> argc 1))
			(cond
				((== axis 0)
					(= nPlaneMaxX (oMyPlane nScrollMaxX:))
					(= nPlaneSizeX (oMyPlane nScreenSizeX:))
					(= nScrollSpeedX (- nPlaneMaxX (- nWidth nPlaneSizeX)))
				)
				((== axis 1)
					(= nPlaneMaxY (oMyPlane nScrollMaxY:))
					(= nPlaneSizeY (oMyPlane nScreenSizeY:))
					(= nScrollSpeedY (- nPlaneMaxY (- nWidth nPlaneSizeY)))
				)
			)
		)
		(= nOriginX x)
		(= nOriginY y)
	)

	(method (setVisibleRange axis nBound1 nBound2 &tmp nTmp nPlaneMaxX nPlaneMaxY nPlaneSizeX nPlaneSizeY nMyX nMyY nBounds nPlaneTravelled)
		(if (> nBound1 nBound2)
			(= nTmp nBound1)
			(= nBound1 nBound2)
			(= nBound2 nTmp)
		)
		(if (and oMyPlane (> argc 1))
			(cond
				((== axis 0)
					(= nMyX (CelWide view loop cel))
					(= nPlaneMaxX (oMyPlane nScrollMaxX:))
					(= nPlaneSizeX (oMyPlane nScreenSizeX:))
					(= nBounds (- nBound2 nBound1))
					(= nPlaneTravelled (- (- nBound2 nMyX) (+ nBound1 nPlaneSizeX)))
					(= nScrollSpeedX (/ (* nPlaneMaxX nPlaneTravelled) nBounds))
					(>>= nScrollSpeedX $0004)
					(= nScrollDenomX (>> nPlaneMaxX $0004))
					(= x (- nBound2 (/ (* nScrollSpeedX nBound2) nScrollDenomX)))
					(UpdateScreenItem self)
					(SetNowSeen self)
				)
				((== axis 1)
					(= nMyY (CelHigh view loop cel))
					(= nPlaneMaxY (oMyPlane nScrollMaxY:))
					(= nPlaneSizeY (oMyPlane nScreenSizeY:))
					(= nBounds (- nBound2 nBound1))
					(= nPlaneTravelled (- (- nBound2 nMyY) (+ nBound1 nPlaneSizeY)))
					(= nScrollSpeedY (- 0 (/ (* nPlaneMaxY nPlaneTravelled) nBounds)))
					(>>= nScrollSpeedY $0004)
					(= nScrollDenomY (>> nPlaneMaxY $0004))
					(= y (- nBound2 (/ (* nScrollSpeedY nBound2) nScrollDenomY)))
					(UpdateScreenItem self)
					(SetNowSeen self)
				)
			)
		)
		(= nOriginX x)
		(= nOriginY y)
	)

	(method (setSpeedDirect nSpeedX nSpeedY)
		(= nScrollSpeedX nSpeedX)
		(= nScrollSpeedY nSpeedY)
		(= nOriginX x)
		(= nOriginY y)
	)

	(method (reposition &tmp nPos nPlaneMaxY nPlaneMaxX)
		(if oMyPlane
			(if nScrollSpeedX
				(= nPos (oMyPlane nCurPosX:))
				(= nPlaneMaxX (oMyPlane nScrollMaxX:))
				(if (not nScrollDenomX)
					(= nScrollDenomX nPlaneMaxX)
				)
				(= x (+ nOriginX (MulDiv nScrollSpeedX nPos nScrollDenomX)))
				(UpdateScreenItem self)
				(SetNowSeen self)
			)
			(if nScrollSpeedY
				(= nPos (oMyPlane nCurPosY:))
				(= nPlaneMaxY (oMyPlane nScrollMaxY:))
				(if (not nScrollDenomY)
					(= nScrollDenomY nPlaneMaxY)
				)
				(= y (+ nOriginY (MulDiv nScrollSpeedY nPos nScrollDenomY)))
				(UpdateScreenItem self)
				(SetNowSeen self)
			)
		)
	)
)

(class Panner of Code
	(properties
		nSpeed 0
		nStepX 0
		nStepY 0
		nXTarget 0
		nYTarget 0
		oPlane 0
		nSaveTime 0
		oCuee 0
	)

	(method (init nX nY oCueeParm nSpeedParm nStepXParm nStepYParm oPlaneParm)
		(if (or (< argc 4) (not nSpeedParm))
			(= nSpeed (gEgo moveSpeed:))
		else
			(= nSpeed nSpeedParm)
		)
		(if (or (< argc 5) (not nStepXParm))
			(= nStepX (gEgo xStep:))
		else
			(= nStepX nStepXParm)
		)
		(if (or (< argc 6) (not nStepYParm))
			(= nStepY (gEgo yStep:))
		else
			(= nStepY nStepYParm)
		)
		(if (or (< argc 7) (not oPlaneParm))
			(= oPlane (gCurRoom plane:))
		else
			(= oPlane oPlaneParm)
		)
		(if (< argc 3)
			(= oCuee 0)
		else
			(= oCuee oCueeParm)
		)
		(= nXTarget nX)
		(= nYTarget nY)
		(if (== nXTarget 33536)
			(= nXTarget (oPlane nCurPosX:))
		)
		(if (< nXTarget 0)
			(= nXTarget 0)
		)
		(if (> nXTarget (oPlane nScrollMaxX:))
			(= nXTarget (oPlane nScrollMaxX:))
		)
		(if (== nYTarget 33536)
			(= nYTarget (oPlane nCurPosY:))
		)
		(if (< nYTarget 0)
			(= nYTarget 0)
		)
		(if (> nYTarget (oPlane nScrollMaxY:))
			(= nYTarget (oPlane nScrollMaxY:))
		)
		(= nSaveTime gGameTime)
		(gTheDoits add: self)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 2] temp9 temp10 temp11)
		(if (== nSpeed 0)
			(= nSpeed 1)
		)
		(if (>= (= temp6 (- gGameTime nSaveTime)) nSpeed)
			(= temp9 (/ (* nStepX temp6) nSpeed))
			(= temp10 (/ (* nStepY temp6) nSpeed))
			(= temp0 (oPlane nCurPosX:))
			(= temp1 (oPlane nCurPosY:))
			(if (and (== temp0 nXTarget) (== temp1 nYTarget))
				(= temp11 oCuee)
				(oPlane oPanner: 0)
				(self dispose:)
				(if temp11
					(temp11 cue:)
				)
				(return)
			)
			(= temp2 (- nXTarget temp0))
			(if (< (= temp3 (- nYTarget temp1)) 0)
				(= temp5 -1)
			else
				(= temp5 1)
			)
			(if (< temp2 0)
				(= temp4 -1)
			else
				(= temp4 1)
			)
			(= temp2 (Abs temp2))
			(= temp3 (Abs temp3))
			(if (< temp2 temp9)
				(+= temp0 (* temp2 temp4))
			else
				(+= temp0 (* temp9 temp4))
			)
			(if (< temp3 temp10)
				(+= temp1 (* temp3 temp5))
			else
				(+= temp1 (* temp10 temp5))
			)
			(oPlane scrollTo: temp0 temp1)
			(= nSaveTime gGameTime)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose: &rest)
	)
)

(class ScrollPlane of Plane
	(properties
		nScreenSizeX 0
		nScreenSizeY 0
		nScreenOrgX 0
		nScreenOrgY 0
		nCurPosX 0
		nCurPosY 0
		nScrollMaxX 0
		nScrollMaxY 0
		oMyScrollViews 0
		oMyNotifyObjs 0
		oMyNotifySelectors 0
		oPanner 0
	)

	(method (init nSizeX nSizeY &tmp oCast)
		(super init: &rest)
		(if (not nScreenSizeX)
			(= nScreenSizeX (gThePlane getWidth:))
			(= nScreenSizeY (gThePlane getHeight:))
			(= nScreenOrgX (gThePlane left:))
			(= nScreenOrgY (gThePlane top:))
		)
		(self
			setRect:
				nScreenOrgX
				nScreenOrgY
				(- (+ nScreenOrgX nSizeX) 1)
				(- (+ nScreenOrgY nSizeY) 1)
		)
		(= nScrollMaxX (- nSizeX nScreenSizeX))
		(= nScrollMaxY (- nSizeY nScreenSizeY))
		(self addPics: addViews:)
		(if oMyScrollViews
			(oMyScrollViews eachElementDo: #init (self getMainCast:))
		)
		(= nCurPosX -1)
		(self scrollTo: 0 0)
		(= gScrollPlane self)
	)

	(method (addPics))

	(method (addViews))

	(method (replay)
		(self addPics:)
	)

	(method (dispose)
		(= gScrollPlane 0)
		(if oMyScrollViews
			(oMyScrollViews release:)
			(oMyScrollViews dispose:)
			(= oMyScrollViews 0)
		)
		(if oMyNotifyObjs
			(oMyNotifyObjs release:)
			(oMyNotifyObjs dispose:)
			(= oMyNotifyObjs 0)
		)
		(if oMyNotifySelectors
			(oMyNotifySelectors release:)
			(oMyNotifySelectors dispose:)
			(= oMyNotifySelectors 0)
		)
		(self killPan:)
		(super dispose: &rest)
	)

	(method (canScrollUp)
		(if (> nCurPosY 0)
			(return 1)
		else
			(return 0)
		)
	)

	(method (canScrollDown)
		(if (< nCurPosY nScrollMaxY)
			(return 1)
		else
			(return 0)
		)
	)

	(method (canScrollLeft)
		(if (> nCurPosX 0)
			(return 1)
		else
			(return 0)
		)
	)

	(method (canScrollRight)
		(if (< nCurPosX nScrollMaxX)
			(return 1)
		else
			(return 0)
		)
	)

	(method (getLocalX foThis)
		(return (- (foThis x:) nCurPosX))
	)

	(method (getLocalY foThis)
		(return (- (foThis y:) nCurPosY))
	)

	(method (addScrollView voThis)
		(if (not oMyScrollViews)
			(= oMyScrollViews (Set new:))
		)
		(oMyScrollViews add: (voThis oMyPlane: self yourself:))
	)

	(method (addToNotifyList oThis selThis)
		(if (not oMyNotifyObjs)
			(= oMyNotifyObjs (List new:))
			(= oMyNotifySelectors (List new:))
		)
		(oMyNotifyObjs add: oThis)
		(oMyNotifySelectors add: selThis)
	)

	(method (panTo nArgX nArgY oCueeParm nSpeedParm nStepXParm nStepYParm &tmp nSpeed nStepX nStepY oCuee)
		(if (or (< argc 4) (not nSpeedParm))
			(= nSpeed (gEgo moveSpeed:))
		else
			(= nSpeed nSpeedParm)
		)
		(if (or (< argc 5) (not nStepXParm))
			(= nStepX (gEgo xStep:))
		else
			(= nStepX nStepXParm)
		)
		(if (or (< argc 6) (not nStepYParm))
			(= nStepY (gEgo yStep:))
		else
			(= nStepY nStepYParm)
		)
		(if (< argc 3)
			(= oCuee 0)
		else
			(= oCuee oCueeParm)
		)
		(self killPan:)
		(= oPanner
			((Panner new:)
				init: nArgX nArgY oCuee nSpeed nStepX nStepY self
				yourself:
			)
		)
	)

	(method (killPan)
		(if oPanner
			(oPanner dispose:)
			(= oPanner 0)
		)
	)

	(method (scroll nArgX nArgY &tmp nX nY)
		(if argc
			(= nX nArgX)
		else
			(= nX 0)
		)
		(if (> argc 1)
			(= nY nArgY)
		else
			(= nY 0)
		)
		(self scrollTo: (+ nX nCurPosX) (+ nY nCurPosY))
	)

	(method (scrollTo nArgX nArgY &tmp nX nY objNode selNode oTmp selTmp nWidth nHeight)
		(if argc
			(= nX nArgX)
		else
			(= nX 0)
		)
		(if (> argc 1)
			(= nY nArgY)
		else
			(= nY 0)
		)
		(if (> nX nScrollMaxX)
			(= nX nScrollMaxX)
		)
		(if (< nX 0)
			(= nX 0)
		)
		(if (> nY nScrollMaxY)
			(= nY nScrollMaxY)
		)
		(if (< nY 0)
			(= nY 0)
		)
		(if (and (== nCurPosX nX) (== nCurPosY nY))
			(return)
		)
		(= nCurPosX nX)
		(= nCurPosY nY)
		(= nWidth (self getWidth:))
		(= nHeight (self getHeight:))
		(= top (- nScreenOrgY nCurPosY))
		(= left (- nScreenOrgX nCurPosX))
		(self setRect: left top (- (+ left nWidth) 1) (- (+ top nHeight) 1))
		(if oMyScrollViews
			(oMyScrollViews eachElementDo: #reposition)
		)
		(UpdatePlane self)
		(if (or (not oMyNotifyObjs) (not oMyNotifySelectors))
			(return)
		)
		(= objNode (oMyNotifyObjs first:))
		(for
			((= selNode (oMyNotifySelectors first:)))
			(and objNode selNode)
			((= selNode (oMyNotifyObjs next: selNode)))
			
			(= oTmp (KList 8 objNode)) ; NodeValue
			(= selTmp (KList 8 selNode)) ; NodeValue
			(if (and oTmp selTmp)
				(Eval oTmp selTmp)
			)
			(= objNode (oMyNotifyObjs next: objNode))
		)
	)

	(method (scrollToObj foWhat bCenterParam &tmp bCenter centerX centerY objCenterX objCenterY scrollX scrollY)
		(if (< argc 2)
			(= bCenter 0)
		else
			(= bCenter bCenterParam)
		)
		(if (and (self isObjVisible: foWhat) (not bCenter))
			(return)
		)
		(= centerX (/ nScreenSizeX 2))
		(= centerY (/ nScreenSizeY 2))
		(foWhat normalizeRect:)
		(= objCenterX
			(+ (foWhat nsLeft:) (/ (- (foWhat nsRight:) (foWhat nsLeft:)) 2))
		)
		(= objCenterY
			(+ (foWhat nsTop:) (/ (- (foWhat nsBottom:) (foWhat nsTop:)) 2))
		)
		(-= objCenterX nCurPosX)
		(-= objCenterY nCurPosY)
		(= scrollX (- objCenterX centerX))
		(= scrollY (- objCenterY centerY))
		(self scroll: scrollX scrollY)
	)

	(method (scrollToLoc nX nY bCenterParam &tmp bCenter centerX centerY scrollX scrollY)
		(if (< argc 2)
			(= bCenter 0)
		else
			(= bCenter bCenterParam)
		)
		(if (and (self isLocVisible: nX nY) (not bCenter))
			(return)
		)
		(= centerX (/ nScreenSizeX 2))
		(= centerY (/ nScreenSizeY 2))
		(-= nX nCurPosX)
		(-= nY nCurPosY)
		(= scrollX (- nX centerX))
		(= scrollY (- nY centerY))
		(self scroll: scrollX scrollY)
	)

	(method (isObjVisible foWhat)
		(if (< (- (foWhat nsLeft:) nCurPosX) 0)
			(return 0)
		)
		(if (< (- (foWhat nsTop:) nCurPosY) 0)
			(return 0)
		)
		(if (> (- (foWhat nsRight:) nCurPosX) nScreenSizeX)
			(return 0)
		)
		(if (> (- (foWhat nsBottom:) nCurPosY) nScreenSizeY)
			(return 0)
		)
		(return 1)
	)

	(method (isLocVisible nX nY)
		(if (< (- nX nCurPosX) 0)
			(return 0)
		)
		(if (< (- nY nCurPosY) 0)
			(return 0)
		)
		(if (> (- nX nCurPosX) nScreenSizeX)
			(return 0)
		)
		(if (> (- nY nCurPosY) nScreenSizeY)
			(return 0)
		)
		(return 1)
	)
)


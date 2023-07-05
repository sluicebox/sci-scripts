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

	(method (setScreenSpeed param1 param2 &tmp temp0 temp1 temp2 temp3)
		(if oMyPlane
			(if argc
				(= temp0 param1)
			else
				(= temp0 0)
			)
			(if (> argc 1)
				(= temp1 param2)
			else
				(= temp1 0)
			)
			(= temp2 (oMyPlane nScrollMaxX:))
			(= temp3 (oMyPlane nScrollMaxY:))
			(= nScrollSpeedX (- temp2 temp0))
			(= nScrollSpeedY (- temp3 temp1))
			(if (== temp0 0)
				(= nScrollDenomX (= nScrollSpeedX 1))
			)
			(if (== temp1 0)
				(= nScrollDenomY (= nScrollSpeedY 1))
			)
		)
		(= nOriginX x)
		(= nOriginY y)
	)

	(method (setSpeedFraction param1 param2 param3 &tmp temp0 temp1)
		(if (and oMyPlane (> argc 2))
			(cond
				((== param1 0)
					(= nScrollSpeedX
						(-
							(= temp0 (oMyPlane nScrollMaxX:))
							(/ (* temp0 param2) param3)
						)
					)
				)
				((== param1 1)
					(= nScrollSpeedY
						(-
							(= temp1 (oMyPlane nScrollMaxY:))
							(/ (* temp1 param2) param3)
						)
					)
				)
			)
		)
		(= nOriginX x)
		(= nOriginY y)
	)

	(method (setTotalWidth param1 param2 &tmp temp0 temp1 temp2 temp3)
		(if (and oMyPlane (> argc 1))
			(cond
				((== param1 0)
					(= temp0 (oMyPlane nScrollMaxX:))
					(= temp2 (oMyPlane nScreenSizeX:))
					(= nScrollSpeedX (- temp0 (- param2 temp2)))
				)
				((== param1 1)
					(= temp1 (oMyPlane nScrollMaxY:))
					(= temp3 (oMyPlane nScreenSizeY:))
					(= nScrollSpeedY (- temp1 (- param2 temp3)))
				)
			)
		)
		(= nOriginX x)
		(= nOriginY y)
	)

	(method (setVisibleRange param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if (> param2 param3)
			(= temp0 param2)
			(= param2 param3)
			(= param3 temp0)
		)
		(if (and oMyPlane (> argc 1))
			(cond
				((== param1 0)
					(= temp5 (CelWide view loop cel))
					(= temp1 (oMyPlane nScrollMaxX:))
					(= temp3 (oMyPlane nScreenSizeX:))
					(= temp7 (- param3 param2))
					(= temp8 (- (- param3 temp5) (+ param2 temp3)))
					(= nScrollSpeedX (/ (* temp1 temp8) temp7))
					(>>= nScrollSpeedX $0004)
					(= nScrollDenomX (>> temp1 $0004))
					(= x (- param3 (/ (* nScrollSpeedX param3) nScrollDenomX)))
					(UpdateScreenItem self)
					(SetNowSeen self)
				)
				((== param1 1)
					(= temp6 (CelHigh view loop cel))
					(= temp2 (oMyPlane nScrollMaxY:))
					(= temp4 (oMyPlane nScreenSizeY:))
					(= temp7 (- param3 param2))
					(= temp8 (- (- param3 temp6) (+ param2 temp4)))
					(= nScrollSpeedY (- 0 (/ (* temp2 temp8) temp7)))
					(>>= nScrollSpeedY $0004)
					(= nScrollDenomY (>> temp2 $0004))
					(= y (- param3 (/ (* nScrollSpeedY param3) nScrollDenomY)))
					(UpdateScreenItem self)
					(SetNowSeen self)
				)
			)
		)
		(= nOriginX x)
		(= nOriginY y)
	)

	(method (setSpeedDirect param1 param2)
		(= nScrollSpeedX param1)
		(= nScrollSpeedY param2)
		(= nOriginX x)
		(= nOriginY y)
	)

	(method (reposition &tmp temp0 temp1 temp2)
		(if oMyPlane
			(if nScrollSpeedX
				(= temp0 (oMyPlane nCurPosX:))
				(= temp2 (oMyPlane nScrollMaxX:))
				(if (not nScrollDenomX)
					(= nScrollDenomX temp2)
				)
				(= x (+ nOriginX (MulDiv nScrollSpeedX temp0 nScrollDenomX)))
				(UpdateScreenItem self)
				(SetNowSeen self)
			)
			(if nScrollSpeedY
				(= temp0 (oMyPlane nCurPosY:))
				(= temp1 (oMyPlane nScrollMaxY:))
				(if (not nScrollDenomY)
					(= nScrollDenomY temp1)
				)
				(= y (+ nOriginY (MulDiv nScrollSpeedY temp0 nScrollDenomY)))
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

	(method (init param1 param2 param3 param4 param5 param6 param7)
		(if (or (< argc 4) (not param4))
			(= nSpeed (gEgo moveSpeed:))
		else
			(= nSpeed param4)
		)
		(if (or (< argc 5) (not param5))
			(= nStepX (gEgo xStep:))
		else
			(= nStepX param5)
		)
		(if (or (< argc 6) (not param6))
			(= nStepY (gEgo yStep:))
		else
			(= nStepY param6)
		)
		(if (or (< argc 7) (not param7))
			(= oPlane (gCurRoom plane:))
		else
			(= oPlane param7)
		)
		(if (< argc 3)
			(= oCuee 0)
		else
			(= oCuee param3)
		)
		(= nXTarget param1)
		(= nYTarget param2)
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

	(method (init param1 param2 &tmp temp0)
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
				(- (+ nScreenOrgX param1) 1)
				(- (+ nScreenOrgY param2) 1)
		)
		(= nScrollMaxX (- param1 nScreenSizeX))
		(= nScrollMaxY (- param2 nScreenSizeY))
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

	(method (getLocalX param1)
		(return (- (param1 x:) nCurPosX))
	)

	(method (getLocalY param1)
		(return (- (param1 y:) nCurPosY))
	)

	(method (addScrollView param1)
		(if (not oMyScrollViews)
			(= oMyScrollViews (Set new:))
		)
		(oMyScrollViews add: (param1 oMyPlane: self yourself:))
	)

	(method (addToNotifyList param1 param2)
		(if (not oMyNotifyObjs)
			(= oMyNotifyObjs (List new:))
			(= oMyNotifySelectors (List new:))
		)
		(oMyNotifyObjs add: param1)
		(oMyNotifySelectors add: param2)
	)

	(method (panTo param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3)
		(if (or (< argc 4) (not param4))
			(= temp0 (gEgo moveSpeed:))
		else
			(= temp0 param4)
		)
		(if (or (< argc 5) (not param5))
			(= temp1 (gEgo xStep:))
		else
			(= temp1 param5)
		)
		(if (or (< argc 6) (not param6))
			(= temp2 (gEgo yStep:))
		else
			(= temp2 param6)
		)
		(if (< argc 3)
			(= temp3 0)
		else
			(= temp3 param3)
		)
		(self killPan:)
		(= oPanner
			((Panner new:)
				init: param1 param2 temp3 temp0 temp1 temp2 self
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

	(method (scroll param1 param2 &tmp temp0 temp1)
		(if argc
			(= temp0 param1)
		else
			(= temp0 0)
		)
		(if (> argc 1)
			(= temp1 param2)
		else
			(= temp1 0)
		)
		(self scrollTo: (+ temp0 nCurPosX) (+ temp1 nCurPosY))
	)

	(method (scrollTo param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if argc
			(= temp0 param1)
		else
			(= temp0 0)
		)
		(if (> argc 1)
			(= temp1 param2)
		else
			(= temp1 0)
		)
		(if (> temp0 nScrollMaxX)
			(= temp0 nScrollMaxX)
		)
		(if (< temp0 0)
			(= temp0 0)
		)
		(if (> temp1 nScrollMaxY)
			(= temp1 nScrollMaxY)
		)
		(if (< temp1 0)
			(= temp1 0)
		)
		(if (and (== nCurPosX temp0) (== nCurPosY temp1))
			(return)
		)
		(= nCurPosX temp0)
		(= nCurPosY temp1)
		(= temp6 (self getWidth:))
		(= temp7 (self getHeight:))
		(= top (- nScreenOrgY nCurPosY))
		(= left (- nScreenOrgX nCurPosX))
		(self setRect: left top (- (+ left temp6) 1) (- (+ top temp7) 1))
		(if oMyScrollViews
			(oMyScrollViews eachElementDo: #reposition)
		)
		(UpdatePlane self)
		(if (or (not oMyNotifyObjs) (not oMyNotifySelectors))
			(return)
		)
		(= temp2 (oMyNotifyObjs first:))
		(for
			((= temp3 (oMyNotifySelectors first:)))
			(and temp2 temp3)
			((= temp3 (oMyNotifyObjs next: temp3)))
			
			(= temp4 (KList 8 temp2)) ; NodeValue
			(= temp5 (KList 8 temp3)) ; NodeValue
			(if (and temp4 temp5)
				(Eval temp4 temp5)
			)
			(= temp2 (oMyNotifyObjs next: temp2))
		)
	)

	(method (scrollToObj param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (< argc 2)
			(= temp0 0)
		else
			(= temp0 param2)
		)
		(if (and (self isObjVisible: param1) (not temp0))
			(return)
		)
		(= temp1 (/ nScreenSizeX 2))
		(= temp2 (/ nScreenSizeY 2))
		(param1 normalizeRect:)
		(= temp3
			(+ (param1 nsLeft:) (/ (- (param1 nsRight:) (param1 nsLeft:)) 2))
		)
		(= temp4
			(+ (param1 nsTop:) (/ (- (param1 nsBottom:) (param1 nsTop:)) 2))
		)
		(-= temp3 nCurPosX)
		(-= temp4 nCurPosY)
		(= temp5 (- temp3 temp1))
		(= temp6 (- temp4 temp2))
		(self scroll: temp5 temp6)
	)

	(method (scrollToLoc param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (< argc 2)
			(= temp0 0)
		else
			(= temp0 param3)
		)
		(if (and (self isLocVisible: param1 param2) (not temp0))
			(return)
		)
		(= temp1 (/ nScreenSizeX 2))
		(= temp2 (/ nScreenSizeY 2))
		(-= param1 nCurPosX)
		(-= param2 nCurPosY)
		(= temp3 (- param1 temp1))
		(= temp4 (- param2 temp2))
		(self scroll: temp3 temp4)
	)

	(method (isObjVisible param1)
		(if (< (- (param1 nsLeft:) nCurPosX) 0)
			(return 0)
		)
		(if (< (- (param1 nsTop:) nCurPosY) 0)
			(return 0)
		)
		(if (> (- (param1 nsRight:) nCurPosX) nScreenSizeX)
			(return 0)
		)
		(if (> (- (param1 nsBottom:) nCurPosY) nScreenSizeY)
			(return 0)
		)
		(return 1)
	)

	(method (isLocVisible param1 param2)
		(if (< (- param1 nCurPosX) 0)
			(return 0)
		)
		(if (< (- param2 nCurPosY) 0)
			(return 0)
		)
		(if (> (- param1 nCurPosX) nScreenSizeX)
			(return 0)
		)
		(if (> (- param2 nCurPosY) nScreenSizeY)
			(return 0)
		)
		(return 1)
	)
)


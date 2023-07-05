;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64009)
(include sci.sh)
(use Main)
(use ScrollView)
(use Plane)
(use PolyPath)
(use Feature)
(use Actor)

(class ScrollExit of Feature
	(properties
		nScrollDir 1
		nExitDist 30
		nBorderDist 40
		oScrollPlane 0
		oCursor 0
		nOffX 0
		nOffY 0
	)

	(method (init)
		(super init: &rest)
		(= oScrollPlane gScrollPlane)
		(switch nScrollDir
			(3
				(= oCursor (ScriptID 64006 2)) ; oSouthCursor
				(= nsTop (- (plane bottom:) nExitDist))
				(= nsBottom (plane bottom:))
				(= nsRight (plane right:))
				(= nsLeft 0)
				(= nOffX (oScrollPlane left:))
				(= nOffY (- (oScrollPlane getHeight:) nBorderDist))
			)
			(2
				(= oCursor (ScriptID 64006 3)) ; oEastCursor
				(= nsTop 0)
				(= nsBottom (plane bottom:))
				(= nsRight (plane right:))
				(= nsLeft (- (plane right:) nExitDist))
				(= nOffX (- (oScrollPlane getWidth:) nBorderDist))
				(= nOffY (oScrollPlane top:))
			)
			(4
				(= oCursor (ScriptID 64006 4)) ; oWestCursor
				(= nsTop 0)
				(= nsBottom (plane bottom:))
				(= nsRight nExitDist)
				(= nsLeft 0)
				(= nOffX nBorderDist)
				(= nOffY (oScrollPlane top:))
			)
			(else
				(= oCursor (ScriptID 64006 1)) ; oNorthCursor
				(= nsTop 0)
				(= nsBottom nExitDist)
				(= nsRight (plane right:))
				(= nsLeft 0)
				(= nOffX (oScrollPlane left:))
				(= nOffY nBorderDist)
			)
		)
		(self forceCursor: oCursor)
	)

	(method (handleEvent event)
		(if
			(or
				(not gEgo)
				(not (gEgo scratch:))
				(not (gEgo isNotHidden:))
				(and (== nScrollDir 1) (not (oScrollPlane canScrollUp:)))
				(and (== nScrollDir 3) (not (oScrollPlane canScrollDown:)))
				(and (== nScrollDir 4) (not (oScrollPlane canScrollLeft:)))
				(and (== nScrollDir 2) (not (oScrollPlane canScrollRight:)))
			)
			(return 0)
		else
			(super handleEvent: event &rest)
			(return)
		)
	)

	(method (hide)
		(self forceCursor: 0)
	)

	(method (show)
		(self forceCursor: oCursor)
	)

	(method (doVerb &tmp temp0 temp1)
		(if
			(or
				(not gEgo)
				(not (gEgo scratch:))
				(not (gEgo isNotHidden:))
			)
			(return)
		)
		(switch nScrollDir
			(3
				(= temp0 (- gMouseX nOffX))
				(= temp1 nOffY)
			)
			(2
				(= temp0 nOffX)
				(= temp1 (- gMouseY nOffY))
			)
			(4
				(= temp0 nOffX)
				(= temp1 (- gMouseY nOffY))
			)
			(else
				(= temp0 (- gMouseX nOffX))
				(= temp1 nOffY)
			)
		)
		(if (gEgo oWalkHandler:)
			((gEgo oWalkHandler:) doit: temp0 temp1)
		else
			(gEgo setMotion: PolyPath temp0 temp1)
		)
	)
)

(instance foNScroll of ScrollExit
	(properties)
)

(instance foSScroll of ScrollExit
	(properties
		nScrollDir 3
	)
)

(instance foWScroll of ScrollExit
	(properties
		nScrollDir 4
	)
)

(instance foEScroll of ScrollExit
	(properties
		nScrollDir 2
	)
)

(class TorScrollPlane of ScrollPlane
	(properties
		oNScrollExit -1
		oSScrollExit -1
		oEScrollExit -1
		oWScrollExit -1
		oHorizHandle -1
		oVertHandle -1
	)

	(method (init)
		(super init: &rest)
		(if nScrollMaxX
			(if (== -1 oEScrollExit)
				(= oEScrollExit (foEScroll init: (ScriptID 0 1) yourself:)) ; oBackgroundPlane
			)
			(if (== -1 oWScrollExit)
				(= oWScrollExit (foWScroll init: (ScriptID 0 1) yourself:)) ; oBackgroundPlane
			)
			(if (== -1 oHorizHandle)
				(= oHorizHandle (oHHandle oMyScrollPlane: self init: yourself:))
			)
		)
		(if nScrollMaxY
			(if (== -1 oNScrollExit)
				(= oNScrollExit (foNScroll init: (ScriptID 0 1) yourself:)) ; oBackgroundPlane
			)
			(if (== -1 oSScrollExit)
				(= oSScrollExit (foSScroll init: (ScriptID 0 1) yourself:)) ; oBackgroundPlane
			)
			(if (== -1 oVertHandle)
				(= oVertHandle (oVHandle oMyScrollPlane: self init: yourself:))
			)
		)
	)

	(method (disable)
		(if (and oHorizHandle (!= -1 oHorizHandle))
			(oHorizHandle hide:)
		)
		(if (and oVertHandle (!= -1 oVertHandle))
			(oVertHandle hide:)
		)
		(if (and oNScrollExit (!= -1 oNScrollExit))
			(oNScrollExit hide:)
		)
		(if (and oSScrollExit (!= -1 oSScrollExit))
			(oSScrollExit hide:)
		)
		(if (and oEScrollExit (!= -1 oEScrollExit))
			(oEScrollExit hide:)
		)
		(if (and oWScrollExit (!= -1 oWScrollExit))
			(oWScrollExit hide:)
		)
		(super disable: &rest)
	)

	(method (enable)
		(super enable: &rest)
		(if (and oHorizHandle (!= -1 oHorizHandle))
			(oHorizHandle show:)
		)
		(if (and oVertHandle (!= -1 oVertHandle))
			(oVertHandle show:)
		)
		(if (and oNScrollExit (!= -1 oNScrollExit))
			(oNScrollExit show:)
		)
		(if (and oSScrollExit (!= -1 oSScrollExit))
			(oSScrollExit show:)
		)
		(if (and oEScrollExit (!= -1 oEScrollExit))
			(oEScrollExit show:)
		)
		(if (and oWScrollExit (!= -1 oWScrollExit))
			(oWScrollExit show:)
		)
	)

	(method (dispose)
		(if (and oHorizHandle (!= -1 oHorizHandle))
			(oHorizHandle dispose:)
		)
		(if (and oVertHandle (!= -1 oVertHandle))
			(oVertHandle dispose:)
		)
		(if (and oNScrollExit (!= -1 oNScrollExit))
			(oNScrollExit dispose:)
		)
		(if (and oSScrollExit (!= -1 oSScrollExit))
			(oSScrollExit dispose:)
		)
		(if (and oEScrollExit (!= -1 oEScrollExit))
			(oEScrollExit dispose:)
		)
		(if (and oWScrollExit (!= -1 oWScrollExit))
			(oWScrollExit dispose:)
		)
		(= oHorizHandle
			(= oVertHandle
				(= oNScrollExit
					(= oSScrollExit (= oEScrollExit (= oWScrollExit -1)))
				)
			)
		)
		(super dispose: &rest)
	)

	(method (panTo)
		(gEgo bAutoScroll: 0)
		(super panTo: &rest)
	)
)

(class TorScrollHandle of View
	(properties
		oMyScrollPlane 0
		nLowBound 0
		nHighBound 0
		bXAxis 1
		bImAHog 0
		nMouseStartX 0
		nMouseStartY 0
		nHandleStartX 0
		nHandleStartY 0
	)

	(method (init &tmp oPlane)
		(= oPlane (Plane new:))
		(oPlane picture: -2 priority: 420 init:)
		(super init: (oPlane getMainCast:) &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
		(oPlane setSize:)
		(oPlane moveTo: (- (gThePlane right:) 6) (- (gThePlane bottom:) 6))
		(oMyScrollPlane addToNotifyList: self 1066)
		(self reSynch:)
	)

	(method (dispose &tmp oPlaneTemp)
		(= oPlaneTemp plane)
		(super dispose: &rest)
		(oPlaneTemp dispose:)
		(= oMyScrollPlane (= plane 0))
	)

	(method (reSynch &tmp nPos nMax nRange)
		(if (not oMyScrollPlane)
			(return)
		)
		(= nRange (- nHighBound nLowBound))
		(if bXAxis
			(= nPos (oMyScrollPlane nCurPosX:))
			(= nMax (oMyScrollPlane nScrollMaxX:))
			(plane
				moveTo: (+ (MulDiv nPos nRange nMax) nLowBound) (plane top:)
			)
			(UpdatePlane plane)
		else
			(= nPos (oMyScrollPlane nCurPosY:))
			(= nMax (oMyScrollPlane nScrollMaxY:))
			(plane
				moveTo: (plane left:) (+ (MulDiv nPos nRange nMax) nLowBound)
			)
			(UpdatePlane plane)
		)
	)

	(method (stopHogging)
		(= bImAHog 0)
		(gOEventHandler unregisterEventHog: self)
	)

	(method (handleEvent event &tmp nPos nMax nRange nScroll)
		(if (not oMyScrollPlane)
			(return)
		)
		(if (and (self onMe: event) (== (event type:) evMOUSEBUTTON))
			(= bImAHog 1)
			(gOEventHandler registerEventHog: self)
			(event globalize:)
			(gEgo bAutoScroll: 0)
			(= nMouseStartX (event x:))
			(= nMouseStartY (event y:))
			(= nHandleStartX (plane left:))
			(= nHandleStartY (plane top:))
		)
		(if bImAHog
			(if (== (event type:) evMOUSERELEASE)
				(self stopHogging:)
			)
			(event globalize:)
			(if bXAxis
				(if
					(<
						(= nPos (+ (- (event x:) nMouseStartX) nHandleStartX))
						nLowBound
					)
					(= nPos nLowBound)
				)
				(if (> nPos nHighBound)
					(= nPos nHighBound)
				)
				(plane moveTo: nPos nHandleStartY)
				(UpdatePlane plane)
				(= nRange (- nHighBound nLowBound))
				(-= nPos nLowBound)
				(= nMax (oMyScrollPlane nScrollMaxX:))
				(= nScroll (MulDiv nPos nMax nRange))
				(oMyScrollPlane
					scrollTo:
						(MulDiv nPos nMax nRange)
						(oMyScrollPlane nCurPosY:)
				)
			else
				(if
					(<
						(= nPos (+ (- (event y:) nMouseStartY) nHandleStartY))
						nLowBound
					)
					(= nPos nLowBound)
				)
				(if (> nPos nHighBound)
					(= nPos nHighBound)
				)
				(plane moveTo: nHandleStartX nPos)
				(UpdatePlane plane)
				(= nRange (- nHighBound nLowBound))
				(-= nPos nLowBound)
				(= nMax (oMyScrollPlane nScrollMaxY:))
				(oMyScrollPlane
					scrollTo:
						(oMyScrollPlane nCurPosX:)
						(MulDiv nPos nMax nRange)
				)
			)
			(event claimed: 1)
			(return 1)
		)
		(super handleEvent: event &rest)
	)
)

(instance oHHandle of TorScrollHandle
	(properties
		view 60004
		loop 18
		nLowBound 20
		nHighBound 620
	)

	(method (init)
		(super init: &rest)
		(= nLowBound (+ (gThePlane left:) 10))
		(= nHighBound (- (gThePlane right:) (+ 10 (CelWide view loop cel))))
	)
)

(instance oVHandle of TorScrollHandle
	(properties
		view 60004
		loop 19
		nLowBound 24
		nHighBound 297
		bXAxis 0
	)

	(method (init)
		(super init: &rest)
		(= nLowBound (+ (gThePlane top:) 12))
		(= nHighBound (- (gThePlane bottom:) (+ 12 (CelHigh view loop cel))))
	)
)


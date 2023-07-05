;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64009)
(include sci.sh)
(use Main)
(use ScrollView)
(use Plane)
(use Print)
(use PolyPath)
(use Feature)
(use Actor)

(class ScrollExit of Feature
	(properties
		nOffX 0
		nOffY 0
		nScrollDir 1
		nExitDist 30
		nBorderDist 40
		oScrollPlane 0
		oCursor 0
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
		bImAHog 0
		oMyScrollPlane 0
		nLowBound 0
		nHighBound 0
		bXAxis 1
		nMouseStartX 0
		nMouseStartY 0
		nHandleStartX 0
		nHandleStartY 0
	)

	(method (init &tmp temp0)
		(= temp0 (Plane new:))
		(temp0 picture: -2 priority: 420 init:)
		(super init: (temp0 getMainCast:) &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
		(temp0 setSize:)
		(temp0 moveTo: (- (gThePlane right:) 6) (- (gThePlane bottom:) 6))
		(oMyScrollPlane addToNotifyList: self 1158)
		(self reSynch:)
	)

	(method (dispose &tmp temp0)
		(= temp0 plane)
		(super dispose: &rest)
		(temp0 dispose:)
		(= oMyScrollPlane (= plane 0))
	)

	(method (reSynch &tmp temp0 temp1 temp2)
		(if (not oMyScrollPlane)
			(Prints
				{Attempt to resynch scroll handle with no scroll plane. DJM torscrol.sc}
			)
			(return)
		)
		(= temp2 (- nHighBound nLowBound))
		(if bXAxis
			(= temp0 (oMyScrollPlane nCurPosX:))
			(= temp1 (oMyScrollPlane nScrollMaxX:))
			(plane
				moveTo: (+ (MulDiv temp0 temp2 temp1) nLowBound) (plane top:)
			)
			(UpdatePlane plane)
		else
			(= temp0 (oMyScrollPlane nCurPosY:))
			(= temp1 (oMyScrollPlane nScrollMaxY:))
			(plane
				moveTo: (plane left:) (+ (MulDiv temp0 temp2 temp1) nLowBound)
			)
			(UpdatePlane plane)
		)
	)

	(method (stopHogging)
		(= bImAHog 0)
		(gOEventHandler unregisterEventHog: self)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(if (not oMyScrollPlane)
			(Prints
				{Attempt to handleEvent scroll handle with no scroll plane. DJM torscrol.sc}
			)
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
						(= temp0 (+ (- (event x:) nMouseStartX) nHandleStartX))
						nLowBound
					)
					(= temp0 nLowBound)
				)
				(if (> temp0 nHighBound)
					(= temp0 nHighBound)
				)
				(plane moveTo: temp0 nHandleStartY)
				(UpdatePlane plane)
				(= temp2 (- nHighBound nLowBound))
				(-= temp0 nLowBound)
				(= temp1 (oMyScrollPlane nScrollMaxX:))
				(= temp3 (MulDiv temp0 temp1 temp2))
				(oMyScrollPlane
					scrollTo:
						(MulDiv temp0 temp1 temp2)
						(oMyScrollPlane nCurPosY:)
				)
			else
				(if
					(<
						(= temp0 (+ (- (event y:) nMouseStartY) nHandleStartY))
						nLowBound
					)
					(= temp0 nLowBound)
				)
				(if (> temp0 nHighBound)
					(= temp0 nHighBound)
				)
				(plane moveTo: nHandleStartX temp0)
				(UpdatePlane plane)
				(= temp2 (- nHighBound nLowBound))
				(-= temp0 nLowBound)
				(= temp1 (oMyScrollPlane nScrollMaxY:))
				(oMyScrollPlane
					scrollTo:
						(oMyScrollPlane nCurPosX:)
						(MulDiv temp0 temp1 temp2)
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
		loop 18
		view 60004
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
		loop 19
		view 60004
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


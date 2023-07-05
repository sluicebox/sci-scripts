;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64005)
(include sci.sh)
(use Main)
(use PushButton)
(use Actor)
(use System)

(class ScrollBar of View
	(properties
		height 0
		object 0
		selector 0
		left 0
		top 0
		width 0
		type 0
		minPosn 0
		maxPosn 0
		curPosn 0
		incSize 1
		pageSize 3
		vThumbView -1
		lThumbLoop 0
		cThumbCel 0
		vDownArrowView -1
		lDownArrowLoop 0
		cDownArrowCel 0
		vUpArrowView -1
		lUpArrowLoop 0
		cUpArrowCel 0
		oThumb 0
		oDownArrow 0
		oUpArrow 0
		nScrollTime 0
		nThumbOffset 0
		nPhysRange 0
		nUserRange 0
	)

	(method (init param1 &tmp temp0 temp1 temp2)
		(= temp2 (if (and argc param1) param1 else gCast))
		(super init: temp2)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
		(= left x)
		(= top y)
		(= x (= y 0))
		(if (!= vDownArrowView -1)
			((= oDownArrow (PushButton new:))
				view: vDownArrowView
				loop: lDownArrowLoop
				cel: cDownArrowCel
				priority: (self priority:)
				fixPriority: 1
				oClickNotify: self
				nClickMethod: 1115
				oHeldNotify: self
				nHeldMethod: 1122
				init: temp2
			)
		)
		(if (!= vUpArrowView -1)
			((= oUpArrow (PushButton new:))
				view: vUpArrowView
				loop: lUpArrowLoop
				cel: cUpArrowCel
				priority: (self priority:)
				fixPriority: 1
				oClickNotify: self
				nClickMethod: 1114
				oHeldNotify: self
				nHeldMethod: 1123
				init: temp2
			)
		)
		((= oThumb (DragButton new:))
			view: vThumbView
			loop: lThumbLoop
			cel: cThumbCel
			priority: (+ 1 (self priority:))
			fixPriority: 1
			oClickNotify: self
			nClickMethod: 1116
			oDragNotify: self
			nDragMethod: 1117
			oStopNotify: self
			nStopMethod: 1118
			init: temp2
		)
		(cond
			((== type 0)
				(= nPhysRange
					(-
						(CelHigh view loop cel)
						(CelHigh vThumbView lThumbLoop cThumbCel)
					)
				)
			)
			((== type 1)
				(= nPhysRange
					(-
						(CelWide view loop cel)
						(CelWide vThumbView lThumbLoop cThumbCel)
					)
				)
			)
		)
		(if (== 0 minPosn maxPosn)
			(= maxPosn nPhysRange)
		)
		(= nUserRange (- maxPosn minPosn))
		(cond
			((== type 0)
				(= width (CelWide view loop cel))
				(= height 0)
				(if oUpArrow
					(oUpArrow x: 0 y: 0)
					(= temp1
						(CelHigh
							(oUpArrow view:)
							(oUpArrow loop:)
							(oUpArrow cel:)
						)
					)
					(+= height temp1)
				)
				(self x: 0 y: height)
				(oThumb x: 0 y: (+ height (self userToPhys: curPosn)))
				(= temp1 (CelHigh view loop cel))
				(+= height temp1)
				(if oDownArrow
					(oDownArrow x: 0 y: height)
					(= temp1
						(CelHigh
							(oDownArrow view:)
							(oDownArrow loop:)
							(oDownArrow cel:)
						)
					)
					(+= height temp1)
				)
			)
			((== type 1)
				(= width 0)
				(= height (CelHigh view loop cel))
				(if oUpArrow
					(oUpArrow x: 0 y: 0)
					(= temp1
						(CelWide
							(oUpArrow view:)
							(oUpArrow loop:)
							(oUpArrow cel:)
						)
					)
					(+= width temp1)
				)
				(self x: width y: 0)
				(oThumb x: (+ width (self userToPhys: curPosn)) y: 0)
				(= temp1 (CelHigh view loop cel))
				(+= width temp1)
				(if oDownArrow
					(oDownArrow x: width y: 0)
					(= temp1
						(CelWide
							(oDownArrow view:)
							(oDownArrow loop:)
							(oDownArrow cel:)
						)
					)
					(+= width temp1)
				)
			)
		)
		(self posn: left top)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (physToUser param1 &tmp temp0)
		(if (not nPhysRange)
			(PrintDebug {physical range not inited. DJM. scrllbar.sc})
			(return 0)
		)
		(= param1 (Max 0 (Min nPhysRange param1)))
		(= temp0 (+ (MulDiv param1 nUserRange nPhysRange) minPosn))
		(return (= temp0 (Max minPosn (Min maxPosn temp0))))
	)

	(method (userToPhys param1)
		(if (not nUserRange)
			(return 0)
		)
		(return (MulDiv (- param1 minPosn) nPhysRange nUserRange))
	)

	(method (getPos)
		(return curPosn)
	)

	(method (setPos param1)
		(= curPosn param1)
		(self userMovedSlider: curPosn)
	)

	(method (setMinMax param1 param2)
		(= minPosn param1)
		(= nUserRange (- (= maxPosn param2) param1))
		(self userMovedSlider: curPosn)
	)

	(method (setIncrement param1 param2)
		(= incSize param1)
		(= pageSize param2)
	)

	(method (handleEvent event &tmp temp0)
		(if (self onMe: event)
			(event claimed: 1)
			(if (& (event type:) evMOUSEBUTTON)
				(= temp0 (self movementDirection:))
				(if (> (Eval event temp0) (Eval oThumb temp0))
					(self pageDown:)
				else
					(self pageUp:)
				)
			)
		)
		(event claimed:)
	)

	(method (initThumb &tmp temp0 temp1)
		(= temp0 (self movementDirection:))
		(= temp1 (gUser curEvent:))
		(= nThumbOffset
			(- (Eval temp1 temp0) (self userToPhys: curPosn))
		)
	)

	(method (scrollThumb &tmp temp0 temp1 temp2 temp3)
		(= temp0 (self movementDirection:))
		(= temp1 (gUser curEvent:))
		(if
			(!=
				(= temp2
					(self
						physToUser: (- (Eval temp1 temp0) nThumbOffset)
					)
				)
				curPosn
			)
			(= temp3 (- temp2 curPosn))
			(self move: temp3)
		)
	)

	(method (stopThumb))

	(method (move param1 param2 &tmp temp0 temp1 temp2)
		(= temp0 (self movementDirection:))
		(= temp1 (Eval self temp0))
		(cond
			((> (= temp2 (+ curPosn param1)) maxPosn)
				(= temp2 maxPosn)
			)
			((< temp2 minPosn)
				(= temp2 minPosn)
			)
		)
		(if (== temp2 curPosn)
			(return 0)
		)
		(= curPosn temp2)
		(Eval oThumb temp0 (+ temp1 (self userToPhys: curPosn)))
		(if (and (> argc 1) param2)
			(UpdateScreenItem oThumb)
		)
		(self scrolled:)
		(return 1)
	)

	(method (movementDirection)
		(return
			(cond
				((== type 0) 31)
				((== type 1) 30)
			)
		)
	)

	(method (userMovedSlider param1 param2 &tmp temp0 temp1)
		(= temp0 (self movementDirection:))
		(= curPosn param1)
		(if (< curPosn minPosn)
			(= curPosn minPosn)
		)
		(if (> curPosn maxPosn)
			(= curPosn maxPosn)
		)
		(= temp1 (Eval self temp0))
		(Eval oThumb temp0 (+ temp1 (self userToPhys: curPosn)))
		(if (and (> argc 1) param2)
			(UpdateScreenItem oThumb)
		)
	)

	(method (posn param1 param2 &tmp temp0 temp1)
		(= temp0 (- param1 x))
		(= temp1 (- param2 y))
		(if (!= param1 0)
			(if oUpArrow
				(oUpArrow x: (+ (oUpArrow x:) temp0))
			)
			(self x: (+ x temp0))
			(if oDownArrow
				(oDownArrow x: (+ (oDownArrow x:) temp0))
			)
			(if oThumb
				(oThumb x: (+ (oThumb x:) temp0))
			)
		)
		(if (!= param2 0)
			(if oUpArrow
				(oUpArrow y: (+ (oUpArrow y:) temp1))
			)
			(self y: (+ y temp1))
			(if oDownArrow
				(oDownArrow y: (+ (oDownArrow y:) temp1))
			)
			(if oThumb
				(oThumb y: (+ (oThumb y:) temp1))
			)
		)
		(= left param1)
		(= top param2)
	)

	(method (scrolled)
		(if object
			(Eval object selector)
		)
	)

	(method (pageUp)
		(= nScrollTime (+ gGameTime 20))
		(self move: (- pageSize) 1)
	)

	(method (pageDown)
		(= nScrollTime (+ gGameTime 20))
		(self move: pageSize 1)
	)

	(method (arrowUp)
		(= nScrollTime (+ gGameTime 20))
		(self move: (- incSize) 1)
	)

	(method (arrowDown)
		(= nScrollTime (+ gGameTime 20))
		(self move: incSize 1)
	)

	(method (heldArrowDown)
		(if (> gGameTime nScrollTime)
			(= nScrollTime (+ gGameTime 5))
			(self move: incSize 1)
		)
	)

	(method (heldArrowUp)
		(if (> gGameTime nScrollTime)
			(= nScrollTime (+ gGameTime 5))
			(self move: (- incSize) 1)
		)
	)
)

(class DragButton of View
	(properties
		bImAHog 0
		oClickNotify 0
		nClickMethod 0
		oDragNotify 0
		nDragMethod 0
		oStopNotify 0
		nStopMethod 0
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (stopHogging)
		(gOEventHandler unregisterEventHog: self)
		(= bImAHog 0)
	)

	(method (handleEvent event)
		(cond
			(bImAHog
				(event claimed: 1)
				(if (== (event type:) evMOUSERELEASE)
					(Eval oStopNotify nStopMethod)
					(self stopHogging:)
				)
				(if oDragNotify
					(Eval oDragNotify nDragMethod)
				)
				(return 1)
			)
			((and (== (event type:) evMOUSEBUTTON) (self onMe: event))
				(event claimed: 1)
				(gOEventHandler registerEventHog: self)
				(= bImAHog 1)
				(if oClickNotify
					(Eval oClickNotify nClickMethod)
				)
				(return 1)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)
)


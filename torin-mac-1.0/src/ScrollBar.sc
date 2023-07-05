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
		type 0
		object 0
		selector 0
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
		top 0
		left 0
		width 0
		height 0
		oThumb 0
		oDownArrow 0
		oUpArrow 0
		nScrollTime 0
		nThumbOffset 0
		nPhysRange 0
		nUserRange 0
	)

	(method (init theCast &tmp newLoc celSize ourCast)
		(= ourCast (if (and argc theCast) theCast else gCast))
		(super init: ourCast)
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
				nClickMethod: 1029
				oHeldNotify: self
				nHeldMethod: 1034
				init: ourCast
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
				nClickMethod: 1028
				oHeldNotify: self
				nHeldMethod: 1035
				init: ourCast
			)
		)
		((= oThumb (DragButton new:))
			view: vThumbView
			loop: lThumbLoop
			cel: cThumbCel
			priority: (+ 1 (self priority:))
			fixPriority: 1
			oClickNotify: self
			nClickMethod: 1030
			oDragNotify: self
			nDragMethod: 1031
			oStopNotify: self
			nStopMethod: 1032
			init: ourCast
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
					(= celSize
						(CelHigh
							(oUpArrow view:)
							(oUpArrow loop:)
							(oUpArrow cel:)
						)
					)
					(+= height celSize)
				)
				(self x: 0 y: height)
				(oThumb x: 0 y: (+ height (self userToPhys: curPosn)))
				(= celSize (CelHigh view loop cel))
				(+= height celSize)
				(if oDownArrow
					(oDownArrow x: 0 y: height)
					(= celSize
						(CelHigh
							(oDownArrow view:)
							(oDownArrow loop:)
							(oDownArrow cel:)
						)
					)
					(+= height celSize)
				)
			)
			((== type 1)
				(= width 0)
				(= height (CelHigh view loop cel))
				(if oUpArrow
					(oUpArrow x: 0 y: 0)
					(= celSize
						(CelWide
							(oUpArrow view:)
							(oUpArrow loop:)
							(oUpArrow cel:)
						)
					)
					(+= width celSize)
				)
				(self x: width y: 0)
				(oThumb x: (+ width (self userToPhys: curPosn)) y: 0)
				(= celSize (CelHigh view loop cel))
				(+= width celSize)
				(if oDownArrow
					(oDownArrow x: width y: 0)
					(= celSize
						(CelWide
							(oDownArrow view:)
							(oDownArrow loop:)
							(oDownArrow cel:)
						)
					)
					(+= width celSize)
				)
			)
		)
		(self posn: left top)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (physToUser nPos &tmp nRet)
		(if (not nPhysRange)
			(PrintDebug {physical range not inited. DJM. scrllbar.sc})
			(return 0)
		)
		(= nPos (Max 0 (Min nPhysRange nPos)))
		(= nRet (+ (MulDiv nPos nUserRange nPhysRange) minPosn))
		(return (= nRet (Max minPosn (Min maxPosn nRet))))
	)

	(method (userToPhys nPos)
		(if (not nUserRange)
			(return 0)
		)
		(return (MulDiv (- nPos minPosn) nPhysRange nUserRange))
	)

	(method (getPos)
		(return curPosn)
	)

	(method (setPos nPos)
		(= curPosn nPos)
		(self userMovedSlider: curPosn)
	)

	(method (setMinMax nMin nMax)
		(= minPosn nMin)
		(= nUserRange (- (= maxPosn nMax) nMin))
		(self userMovedSlider: curPosn)
	)

	(method (setIncrement nLine nPage)
		(= incSize nLine)
		(= pageSize nPage)
	)

	(method (handleEvent event &tmp theDirection)
		(if (self onMe: event)
			(event claimed: 1)
			(if (& (event type:) evMOUSEBUTTON)
				(= theDirection (self movementDirection:))
				(if (> (Eval event theDirection) (Eval oThumb theDirection))
					(self pageDown:)
				else
					(self pageUp:)
				)
			)
		)
		(event claimed:)
	)

	(method (initThumb &tmp theDirection event)
		(= theDirection (self movementDirection:))
		(= event (gUser curEvent:))
		(= nThumbOffset
			(- (Eval event theDirection) (self userToPhys: curPosn))
		)
	)

	(method (scrollThumb &tmp theDirection event newCurPosn delta)
		(= theDirection (self movementDirection:))
		(= event (gUser curEvent:))
		(if
			(!=
				(= newCurPosn
					(self
						physToUser: (- (Eval event theDirection) nThumbOffset)
					)
				)
				curPosn
			)
			(= delta (- newCurPosn curPosn))
			(self move: delta)
		)
	)

	(method (stopThumb))

	(method (move amount upd &tmp theDirection scrollOffset newPosn)
		(= theDirection (self movementDirection:))
		(= scrollOffset (Eval self theDirection))
		(cond
			((> (= newPosn (+ curPosn amount)) maxPosn)
				(= newPosn maxPosn)
			)
			((< newPosn minPosn)
				(= newPosn minPosn)
			)
		)
		(if (== newPosn curPosn)
			(return 0)
		)
		(= curPosn newPosn)
		(Eval oThumb theDirection (+ scrollOffset (self userToPhys: curPosn)))
		(if (and (> argc 1) upd)
			(UpdateScreenItem oThumb)
		)
		(self scrolled:)
		(return 1)
	)

	(method (movementDirection)
		(return
			(cond
				((== type 0) 2)
				((== type 1) 1)
			)
		)
	)

	(method (userMovedSlider newPosn upd &tmp theDirection baseLocation)
		(= theDirection (self movementDirection:))
		(= curPosn newPosn)
		(if (< curPosn minPosn)
			(= curPosn minPosn)
		)
		(if (> curPosn maxPosn)
			(= curPosn maxPosn)
		)
		(= baseLocation (Eval self theDirection))
		(Eval oThumb theDirection (+ baseLocation (self userToPhys: curPosn)))
		(if (and (> argc 1) upd)
			(UpdateScreenItem oThumb)
		)
	)

	(method (posn newx newy &tmp offx offy)
		(= offx (- newx x))
		(= offy (- newy y))
		(if (!= newx 0)
			(if oUpArrow
				(oUpArrow x: (+ (oUpArrow x:) offx))
			)
			(self x: (+ x offx))
			(if oDownArrow
				(oDownArrow x: (+ (oDownArrow x:) offx))
			)
			(if oThumb
				(oThumb x: (+ (oThumb x:) offx))
			)
		)
		(if (!= newy 0)
			(if oUpArrow
				(oUpArrow y: (+ (oUpArrow y:) offy))
			)
			(self y: (+ y offy))
			(if oDownArrow
				(oDownArrow y: (+ (oDownArrow y:) offy))
			)
			(if oThumb
				(oThumb y: (+ (oThumb y:) offy))
			)
		)
		(= left newx)
		(= top newy)
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
		oClickNotify 0
		nClickMethod 0
		oDragNotify 0
		nDragMethod 0
		oStopNotify 0
		nStopMethod 0
		bImAHog 0
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


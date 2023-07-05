;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64905)
(include sci.sh)
(use Main)
(use User)
(use Actor)
(use System)

(class ScrollBar of View
	(properties
		type 0
		thumbView -1
		thumbLoop 0
		thumbCel 0
		thumb 0
		object 0
		selector 0
		minPosn 0
		maxPosn 0
		curPosn 0
		ourCast 0
		pageSize 0
		lowIcon 0
		highIcon 0
		relVer 1
		freeTrack 0
	)

	(method (init param1 param2 param3)
		(= ourCast (if (and argc param1) param1 else gCast))
		(super init: ourCast)
		(if (> argc 1)
			((= lowIcon param2) init: ourCast)
			(if (> argc 2)
				((= highIcon param3) init: ourCast)
			)
		)
		((= thumb (View new:))
			view: thumbView
			loop: thumbLoop
			cel: thumbCel
			priority: 255
			fixPriority: 1
			init: ourCast
		)
		(cond
			((== type 0)
				(if (not curPosn)
					(= curPosn y)
				)
				(thumb posn: x curPosn)
			)
			((== type 1)
				(if (not curPosn)
					(= curPosn x)
				)
				(thumb posn: curPosn y)
			)
		)
		(UpdateScreenItem thumb)
	)

	(method (dispose)
		(thumb dispose:)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (not (event modifiers:)))
			(event localize: (ourCast plane:))
			(cond
				((thumb onMe: event)
					(self select: 1)
					(event claimed: 1)
				)
				((and lowIcon (lowIcon onMe: event))
					(if (lowIcon select: relVer)
						(self arrowUp:)
					)
					(event claimed: 1)
				)
				((and highIcon (highIcon onMe: event))
					(if (highIcon select: relVer)
						(self arrowDown:)
					)
					(event claimed: 1)
				)
				((self onMe: event)
					(self select: 0)
					(event claimed: 1)
				)
			)
			(event localize: (gCast plane:))
		)
		(event claimed:)
	)

	(method (select param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (self movementSelector:))
		((User curEvent:) localize: (ourCast plane:) claimed: 1)
		(cond
			((and argc param1)
				(= temp3
					(-
						(Eval (User curEvent:) temp1)
						(Eval thumb temp1)
					)
				)
				(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
					(= temp4 0)
					(temp0 localize: (ourCast plane:))
					(cond
						(
							(<
								(- (= temp2 (Eval temp0 temp1)) temp3)
								curPosn
							)
							(= temp4
								(if freeTrack
									(- (- temp2 temp3) curPosn)
								else
									-1
								)
							)
						)
						((> (- temp2 temp3) curPosn)
							(= temp4
								(if freeTrack
									(- (- temp2 temp3) curPosn)
								else
									1
								)
							)
						)
					)
					(if temp4
						(self move: temp4 1)
						(if (not (& signal $0200))
							(self scrolled:)
						)
					)
					(temp0 dispose:)
				)
				(temp0 dispose:)
			)
			(
				(<
					(= temp2 (Eval (User curEvent:) temp1))
					(Eval thumb temp1)
				)
				(self pageUp:)
			)
			((> temp2 (Eval thumb temp1))
				(self pageDown:)
			)
		)
	)

	(method (move param1 param2 &tmp temp0)
		(= temp0 (self movementSelector:))
		(= curPosn (+ param1 (Eval thumb temp0)))
		(cond
			((> curPosn maxPosn)
				(= curPosn maxPosn)
			)
			((< curPosn minPosn)
				(= curPosn minPosn)
			)
		)
		(Eval thumb temp0 curPosn)
		(if (and (> argc 1) param2)
			(UpdateScreenItem thumb)
			(FrameOut)
		)
	)

	(method (movementSelector)
		(return
			(cond
				((== type 0) 2)
				((== type 1) 1)
			)
		)
	)

	(method (rePosn param1 param2 &tmp temp0)
		(= temp0 (self movementSelector:))
		(= curPosn param1)
		(Eval thumb temp0 curPosn)
		(if (and (> argc 1) param2)
			(UpdateScreenItem thumb)
			(FrameOut)
		)
	)

	(method (scrolled)
		(if object
			(Eval object selector)
		)
	)

	(method (pageUp)
		(self move: (- pageSize) 1 scrolled:)
	)

	(method (pageDown)
		(self move: pageSize 1 scrolled:)
	)

	(method (arrowUp)
		(self move: -1 1 scrolled:)
	)

	(method (arrowDown)
		(self move: 1 1 scrolled:)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64988)
(include sci.sh)
(use Main)
(use ScrollView)
(use Motion)
(use Actor)

(public
	proc64988_0 0
)

(procedure (proc64988_0 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (param1 plane:))
	(if (temp0 isKindOf: ScrollPlane)
		(= temp1 (temp0 getLocalX: param1))
		(= temp2 (temp0 getLocalY: param1))
		(= temp3 (MulDiv (CelHigh (param1 view:) 0 0) (param1 scaleY:) 128))
		(if global108
			(= global205 240)
			(= global206 60)
		else
			(= global205 50)
			(= global206 12)
			(= global109 (- (- (temp0 nScreenSizeX:) 5) (* global205 2)))
			(= global110
				(- (- (temp0 nScreenSizeY:) 5) (+ (* 2 global206) temp3))
			)
		)
		(cond
			((and (temp0 canScrollLeft:) (< temp1 global205))
				(if global108
					(temp0 scroll: (- temp1 global205) 0)
				else
					(temp0 scroll: (- 0 global109) 0)
				)
			)
			(
				(and
					(temp0 canScrollRight:)
					(> temp1 (- (temp0 nScreenSizeX:) global205))
				)
				(if global108
					(temp0
						scroll: (- temp1 (- (temp0 nScreenSizeX:) global205)) 0
					)
				else
					(temp0 scroll: global109 0)
				)
			)
		)
		(cond
			((and (temp0 canScrollUp:) (< (- temp2 temp3) global206))
				(if global108
					(temp0 scroll: 0 (- (- temp2 temp3) global206))
				else
					(temp0 scroll: 0 (- 0 global110))
				)
			)
			(
				(and
					(temp0 canScrollDown:)
					(> temp2 (- (temp0 nScreenSizeY:) global206))
				)
				(if global108
					(temp0
						scroll: 0 (- temp2 (- (temp0 nScreenSizeY:) global206))
					)
				else
					(temp0 scroll: 0 global110)
				)
			)
		)
	)
)

(class Ego of Actor
	(properties
		edgeHit 0
		bAutoScroll 1
		bIsInitialized 0
		oWalkHandler 0
	)

	(method (walkTo))

	(method (init)
		(super init: &rest)
		(|= signal $2000)
		(if (not cycler)
			(self setCycle: Walk)
		)
		(= bIsInitialized (= bAutoScroll 1))
	)

	(method (dispose)
		(= bIsInitialized 0)
		(if oWalkHandler
			(oWalkHandler dispose:)
			(= oWalkHandler 0)
		)
		(super dispose: &rest)
	)

	(method (setWalkHandler param1)
		(if oWalkHandler
			(oWalkHandler dispose:)
			(= oWalkHandler 0)
		)
		(= oWalkHandler param1)
	)

	(method (facingMe)
		(return 1)
	)

	(method (setMotion param1)
		(if param1
			(= bAutoScroll 1)
			(if (and gCurRoom ((gCurRoom plane:) isKindOf: ScrollPlane))
				((gCurRoom plane:) killPan:)
			)
		)
		(super setMotion: param1 &rest)
	)

	(method (doit)
		(super doit:)
		(if bAutoScroll
			(proc64988_0 self)
		)
	)

	(method (get what &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= temp1 [what temp0])
			(temp1 moveTo: -3)
		)
	)

	(method (put what recipient)
		(if (self has: what)
			(what moveTo: (if (== argc 1) -1 else recipient))
		)
	)

	(method (has what)
		(return
			(or (what ownedBy: -3) (what ownedBy: -2) (what ownedBy: -4))
		)
	)

	(method (handleEvent event &tmp dir eType eMsg)
		(if (not bIsInitialized)
			(return 0)
		)
		(= eType (event type:))
		(= eMsg (event message:))
		(cond
			((and script (script handleEvent: event)) 1)
			((not (gUser canControl:)))
			((& eType $0010) ; direction
				(if (and (== (= dir eMsg) JOY_NULL) (& eType evKEYBOARD))
					(event claimed:)
					(return)
				)
				(if (and (& eType evKEYBOARD) (== dir (gUser prevDir:)) mover)
					(= dir JOY_NULL)
				)
				(gUser prevDir: dir)
				(self setDirection: dir)
				(event claimed: 1)
			)
			((& eType evVERB)
				(if (& eType evMOVE)
					(if oWalkHandler
						(oWalkHandler doit: (event x:) (+ (event y:) z))
						(event claimed: 1)
						(return 1)
					)
					(switch gUseObstacles
						(0
							(self
								setMotion: MoveTo (event x:) (+ (event y:) z)
							)
						)
						(1
							(self walkTo: (event x:) (+ (event y:) z))
						)
						(2
							(self walkTo: (event x:) (+ (event y:) z))
						)
					)
					(gUser prevDir: 0)
					(event claimed: 1)
				else
					(super handleEvent: event)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)
)


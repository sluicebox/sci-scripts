;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64988)
(include sci.sh)
(use Main)
(use ScrollView)
(use oRotInvPlane)
(use PolyPath)
(use Motion)
(use Actor)

(public
	PerformAutoScroll 0
)

(procedure (PerformAutoScroll who &tmp oPlane nX nY nHeight)
	(= oPlane (who plane:))
	(if (oPlane isKindOf: ScrollPlane)
		(= nX (oPlane getLocalX: who))
		(= nY (oPlane getLocalY: who))
		(= nHeight (MulDiv (CelHigh (who view:) 0 0) (who scaleY:) 128))
		(if global108
			(= gnEgoScrollBorderX 240)
			(= gnEgoScrollBorderY 60)
		else
			(= gnEgoScrollBorderX 50)
			(= gnEgoScrollBorderY 12)
			(= global109 (- (- (oPlane nScreenSizeX:) 5) (* gnEgoScrollBorderX 2)))
			(= global110
				(- (- (oPlane nScreenSizeY:) 5) (+ (* 2 gnEgoScrollBorderY) nHeight))
			)
		)
		(cond
			((and (oPlane canScrollLeft:) (< nX gnEgoScrollBorderX))
				(if global108
					(oPlane scroll: (- nX gnEgoScrollBorderX) 0)
				else
					(oPlane scroll: (- 0 global109) 0)
				)
			)
			(
				(and
					(oPlane canScrollRight:)
					(> nX (- (oPlane nScreenSizeX:) gnEgoScrollBorderX))
				)
				(if global108
					(oPlane
						scroll: (- nX (- (oPlane nScreenSizeX:) gnEgoScrollBorderX)) 0
					)
				else
					(oPlane scroll: global109 0)
				)
			)
		)
		(cond
			((and (oPlane canScrollUp:) (< (- nY nHeight) gnEgoScrollBorderY))
				(if global108
					(oPlane scroll: 0 (- (- nY nHeight) gnEgoScrollBorderY))
				else
					(oPlane scroll: 0 (- 0 global110))
				)
			)
			(
				(and
					(oPlane canScrollDown:)
					(> nY (- (oPlane nScreenSizeY:) gnEgoScrollBorderY))
				)
				(if global108
					(oPlane
						scroll: 0 (- nY (- (oPlane nScreenSizeY:) gnEgoScrollBorderY))
					)
				else
					(oPlane scroll: 0 global110)
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

	(method (setWalkHandler oHandler)
		(if oWalkHandler
			(oWalkHandler dispose:)
			(= oWalkHandler 0)
		)
		(= oWalkHandler oHandler)
	)

	(method (facingMe)
		(return 1)
	)

	(method (setMotion param)
		(if param
			(= bAutoScroll 1)
			(if (and gCurRoom ((gCurRoom plane:) isKindOf: ScrollPlane))
				((gCurRoom plane:) killPan:)
			)
		)
		(super setMotion: param &rest)
	)

	(method (doit)
		(super doit:)
		(if bAutoScroll
			(PerformAutoScroll self)
		)
	)

	(method (get what &tmp i ioTemp)
		(for ((= i 0)) (< i argc) ((++ i))
			(= ioTemp [what i])
			(ioTemp moveTo: -3)
		)
	)

	(method (put what recipient)
		(if (self has: what)
			(if (what ownedBy: -4)
				(PutAwayEyeItem)
			)
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
							(self
								setMotion:
									PolyPath
									(event x:)
									(+ (event y:) z)
							)
						)
						(2
							(self
								setMotion:
									PolyPath
									(event x:)
									(+ (event y:) z)
									0
									0
							)
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


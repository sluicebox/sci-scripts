;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 580)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	scoreCribbage 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(= temp0 0)
	(if param1
		(= temp0 (/ (* param1 10) param2))
	)
	(return temp0)
)

(procedure (localproc_1 param1 param2 param3)
	(if (and (!= argc 4) (not param1))
		(return)
	)
	(if (>= param1 10)
		(proc0_10
			580
			3
			(mod (/ param1 10) 10)
			param2
			param3
			15
			cribbageScoreWindow
		)
	)
	(if (>= param1 0)
		(proc0_10
			580
			3
			(mod param1 10)
			(+ param2 9)
			param3
			15
			cribbageScoreWindow
		)
	)
)

(procedure (localproc_2)
	(= local0 gGameControls)
	(EnableCursor)
	((= gGameControls cribbageScore)
		plane: cribbageScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor x: (+ 90 (iconOK nsLeft:)) y: (+ 61 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreCribbage of Code
	(properties)

	(method (init)
		(localproc_2)
	)
)

(instance cribbageScoreWindow of InvisibleWindow
	(properties
		left 70
		top 48
		right 288
		bottom 152
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(= priority 14)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 580 0 0 0 0 15 self)
		(= temp1 (((gTheHands at: 1) owner:) view:))
		(proc0_10
			580
			(if (>= temp1 9) 2 else 1)
			(mod temp1 9)
			102
			7
			15
			cribbageScoreWindow
			{score}
		)
		(if global252
			(proc0_10 580 5 0 22 64 15 self)
		)
		(if global402
			(= temp2 (/ ((gTheHands at: 1) pointsInHand:) global402))
			(= temp4
				(localproc_0
					(mod ((gTheHands at: 1) pointsInHand:) global402)
					global402
				)
			)
			(localproc_1 temp2 120 25)
			(proc0_10 580 6 temp4 138 25 15 cribbageScoreWindow)
			(if ((gTheHands at: 1) cribsPlayed:)
				(= temp2
					(/
						((gTheHands at: 1) pointsInCrib:)
						((gTheHands at: 1) cribsPlayed:)
					)
				)
				(= temp4
					(localproc_0
						(mod
							((gTheHands at: 1) pointsInCrib:)
							((gTheHands at: 1) cribsPlayed:)
						)
						global402
					)
				)
				(localproc_1 temp2 120 38)
				(proc0_10 580 6 temp4 138 38 15 cribbageScoreWindow)
			)
			(= temp2 (/ ((gTheHands at: 1) pointsPegged:) global402))
			(= temp4
				(localproc_0
					(mod ((gTheHands at: 1) pointsPegged:) global402)
					global402
				)
			)
			(localproc_1 temp2 120 51)
			(proc0_10 580 6 temp4 138 51 15 cribbageScoreWindow)
			(= temp2 (/ ((gTheHands at: 0) pointsInHand:) global402))
			(= temp4
				(localproc_0
					(mod ((gTheHands at: 0) pointsInHand:) global402)
					global402
				)
			)
			(localproc_1 temp2 170 25)
			(proc0_10 580 6 temp4 188 25 15 cribbageScoreWindow)
			(if ((gTheHands at: 0) cribsPlayed:)
				(= temp2
					(/
						((gTheHands at: 0) pointsInCrib:)
						((gTheHands at: 0) cribsPlayed:)
					)
				)
				(= temp4
					(localproc_0
						(mod
							((gTheHands at: 0) pointsInCrib:)
							((gTheHands at: 0) cribsPlayed:)
						)
						global402
					)
				)
				(localproc_1 temp2 170 38)
				(proc0_10 580 6 temp4 188 38 15 cribbageScoreWindow)
			)
			(= temp2 (/ ((gTheHands at: 0) pointsPegged:) global402))
			(= temp4
				(localproc_0
					(mod ((gTheHands at: 0) pointsPegged:) global402)
					global402
				)
			)
			(localproc_1 temp2 170 51)
			(proc0_10 580 6 temp4 188 51 15 cribbageScoreWindow)
			(if global252
				(= temp2 (/ ((gTheHands at: 0) mugginsPointsLost:) global402))
				(= temp4
					(localproc_0
						(mod ((gTheHands at: 0) mugginsPointsLost:) global402)
						global402
					)
				)
				(localproc_1 temp2 170 64)
				(proc0_10 580 6 temp4 188 64 15 cribbageScoreWindow)
			)
		)
		(if (> global402 100)
			(proc0_10 580 3 (/ global402 100) 44 88 15)
		)
		(localproc_1 (mod global402 100) 53 88 1)
		(if (!= global402 1)
			(proc0_10 580 7 0 111 86 15 cribbageScoreWindow)
		)
	)
)

(instance cribbageScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 129
		nsTop 81
		x 129
		y 81
		signal 387
		mainView 580
		mainLoop 4
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)


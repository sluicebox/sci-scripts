;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 580)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use h5Messager)
(use GameControls)
(use User)
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
			(+ param2 11)
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
		(gMouseCursor x: (+ 182 (iconOK nsLeft:)) y: (+ 165 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreCribbage of Code
	(properties)

	(method (init)
		(proc17_2)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 60 global878))
		else
			(PlaySong play: 61)
		)
		(localproc_2)
		(PlaySong play: 0)
		(proc64996_0)
	)
)

(instance cribbageScoreWindow of InvisibleWindow
	(properties
		left 142
		top 134
		right 578
		bottom 419
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= priority 14)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 580 0 0 0 0 15 self)
		(= temp1 (((global117 at: 1) owner:) view:))
		(if global916
			(-= temp1 1400)
		)
		(proc0_10
			580
			(if global916 2 else 1)
			temp1
			280
			47
			15
			cribbageScoreWindow
			{score}
		)
		(if global252
			(proc0_10 580 5 0 34 126 15 self)
		)
		(if global402
			(= temp2 (/ ((global117 at: 1) pointsInHand:) global402))
			(= temp4
				(localproc_0
					(mod ((global117 at: 1) pointsInHand:) global402)
					global402
				)
			)
			(localproc_1 temp2 264 56)
			(proc0_10 580 6 temp4 286 56 15 cribbageScoreWindow)
			(if ((global117 at: 1) cribsPlayed:)
				(= temp2
					(/
						((global117 at: 1) pointsInCrib:)
						((global117 at: 1) cribsPlayed:)
					)
				)
				(= temp4
					(localproc_0
						(mod
							((global117 at: 1) pointsInCrib:)
							((global117 at: 1) cribsPlayed:)
						)
						global402
					)
				)
				(localproc_1 temp2 264 78)
				(proc0_10 580 6 temp4 286 78 15 cribbageScoreWindow)
			)
			(= temp2 (/ ((global117 at: 1) pointsPegged:) global402))
			(= temp4
				(localproc_0
					(mod ((global117 at: 1) pointsPegged:) global402)
					global402
				)
			)
			(localproc_1 temp2 264 100)
			(proc0_10 580 6 temp4 286 100 15 cribbageScoreWindow)
			(= temp2 (/ ((global117 at: 0) pointsInHand:) global402))
			(= temp4
				(localproc_0
					(mod ((global117 at: 0) pointsInHand:) global402)
					global402
				)
			)
			(localproc_1 temp2 192 56)
			(proc0_10 580 6 temp4 214 56 15 cribbageScoreWindow)
			(if ((global117 at: 0) cribsPlayed:)
				(= temp2
					(/
						((global117 at: 0) pointsInCrib:)
						((global117 at: 0) cribsPlayed:)
					)
				)
				(= temp4
					(localproc_0
						(mod
							((global117 at: 0) pointsInCrib:)
							((global117 at: 0) cribsPlayed:)
						)
						global402
					)
				)
				(localproc_1 temp2 192 78)
				(proc0_10 580 6 temp4 214 78 15 cribbageScoreWindow)
			)
			(= temp2 (/ ((global117 at: 0) pointsPegged:) global402))
			(= temp4
				(localproc_0
					(mod ((global117 at: 0) pointsPegged:) global402)
					global402
				)
			)
			(localproc_1 temp2 192 100)
			(proc0_10 580 6 temp4 214 100 15 cribbageScoreWindow)
			(if global252
				(= temp2 (/ ((global117 at: 0) mugginsPointsLost:) global402))
				(= temp4
					(localproc_0
						(mod ((global117 at: 0) mugginsPointsLost:) global402)
						global402
					)
				)
				(localproc_1 temp2 192 122)
				(proc0_10 580 6 temp4 214 122 15 cribbageScoreWindow)
			)
		)
		(if (> global402 100)
			(proc0_10 580 8 (/ global402 100) 66 152 15)
		)
		(if (>= (= temp5 (mod global402 100)) 10)
			(proc0_10 580 8 (mod (/ temp5 10) 10) 77 152 15 cribbageScoreWindow)
		)
		(if (>= temp5 0)
			(proc0_10 580 8 (mod temp5 10) 88 152 15 cribbageScoreWindow)
		)
		(if (!= global402 1)
			(proc0_10 580 7 0 148 153 15 cribbageScoreWindow)
		)
	)
)

(instance cribbageScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 167
		nsTop 141
		x 167
		y 141
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


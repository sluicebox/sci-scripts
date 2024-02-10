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
		(DrawCel 580 3 (mod (/ param1 10) 10) param2 param3 15)
	)
	(if (>= param1 0)
		(DrawCel 580 3 (mod param1 10) (+ param2 9) param3 15)
	)
)

(procedure (localproc_2)
	(= local0 gGameControls)
	(HandsOn)
	((= gGameControls cribbageScore)
		window: cribbageScoreWindow
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
		top 48
		left 70
		bottom 152
		right 288
	)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4)
		(super open:)
		(DrawCel 580 0 0 0 0 15)
		(= temp1 (((global117 at: 1) owner:) view:))
		(DrawCel 580 (if (>= temp1 9) 2 else 1) (mod temp1 9) 102 7 15)
		(if global252
			(DrawCel 580 5 0 22 64 15)
		)
		(if global402
			(= temp2 (/ ((global117 at: 1) pointsInHand:) global402))
			(= temp4
				(localproc_0
					(mod ((global117 at: 1) pointsInHand:) global402)
					global402
				)
			)
			(localproc_1 temp2 120 25)
			(DrawCel 580 6 temp4 138 25 15)
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
				(localproc_1 temp2 120 38)
				(DrawCel 580 6 temp4 138 38 15)
			)
			(= temp2 (/ ((global117 at: 1) pointsPegged:) global402))
			(= temp4
				(localproc_0
					(mod ((global117 at: 1) pointsPegged:) global402)
					global402
				)
			)
			(localproc_1 temp2 120 51)
			(DrawCel 580 6 temp4 138 51 15)
			(= temp2 (/ ((global117 at: 0) pointsInHand:) global402))
			(= temp4
				(localproc_0
					(mod ((global117 at: 0) pointsInHand:) global402)
					global402
				)
			)
			(localproc_1 temp2 170 25)
			(DrawCel 580 6 temp4 188 25 15)
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
				(localproc_1 temp2 170 38)
				(DrawCel 580 6 temp4 188 38 15)
			)
			(= temp2 (/ ((global117 at: 0) pointsPegged:) global402))
			(= temp4
				(localproc_0
					(mod ((global117 at: 0) pointsPegged:) global402)
					global402
				)
			)
			(localproc_1 temp2 170 51)
			(DrawCel 580 6 temp4 188 51 15)
			(if global252
				(= temp2 (/ ((global117 at: 0) mugginsPointsLost:) global402))
				(= temp4
					(localproc_0
						(mod ((global117 at: 0) mugginsPointsLost:) global402)
						global402
					)
				)
				(localproc_1 temp2 170 64)
				(DrawCel 580 6 temp4 188 64 15)
			)
		)
		(if (> global402 100)
			(DrawCel 580 3 (/ global402 100) 44 88 15)
		)
		(localproc_1 (mod global402 100) 53 88 1)
		(if (!= global402 1)
			(DrawCel 580 7 0 111 86 15)
		)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance cribbageScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		view 580
		loop 4
		cel 0
		nsLeft 129
		nsTop 81
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(RedrawCast)
		(= gGameControls local0)
	)
)


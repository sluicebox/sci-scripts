;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use Location)
(use Actor)
(use System)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(if (== argc 2)
		(= temp0 param2)
	else
		(= temp0 0)
	)
	(switch param1
		(0
			(arrow_0 init: temp0)
		)
		(1
			(arrow_45 init: temp0)
		)
		(2
			(arrow_90 init: temp0)
		)
		(3
			(arrow_135 init: temp0)
		)
		(4
			(arrow_180 init: temp0)
		)
		(5
			(arrow_225 init: temp0)
		)
		(6
			(arrow_270 init: temp0)
		)
		(7
			(arrow_315 init: temp0)
		)
	)
)

(class Compass of Obj
	(properties
		closed 0
	)

	(method (open)
		(if closed
			(== closed 0)
			(self update:)
		)
	)

	(method (close)
		(return (and (not closed) (== closed 1)))
	)

	(method (clear)
		(arrow_0 dispose:)
		(arrow_45 dispose:)
		(arrow_90 dispose:)
		(arrow_135 dispose:)
		(arrow_180 dispose:)
		(arrow_225 dispose:)
		(arrow_270 dispose:)
		(arrow_315 dispose:)
		(arrow_Up dispose:)
		(arrow_Down dispose:)
		(north_Indicator dispose:)
	)

	(method (update &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (not closed)
			(self clear:)
			(= temp5 0)
			(= temp6 0)
			(= temp0 (gCurRoom picObj:))
			(cond
				((or (temp0 left:) (temp0 right:))
					(localproc_0 0 1)
				)
				((temp0 down:)
					(= temp5 1)
					(arrow_0 init:)
					(= temp0 (temp0 down:))
				)
				((temp0 up:)
					(= temp6 1)
					(arrow_0 init:)
					(= temp0 (temp0 up:))
				)
				(else
					(arrow_0 init: 1)
					(if (temp0 heading:)
						(= temp2 (/ (- 360 (temp0 heading:)) 45))
					else
						(= temp2 0)
					)
					(north_Indicator init: temp2)
				)
			)
			(if (temp0 up:)
				(arrow_Up init: temp5)
			)
			(if (temp0 down:)
				(arrow_Down init: temp6)
			)
			(if
				(or
					(<= 6001 gNewRoomNum 6911) ; avianLeftShaft1, mirmicatPoolCloseUp
					(<= 5001 gNewRoomNum 5030) ; NYAvian1, NYAvianTetraCU
					(== gNewRoomNum 6000) ; avianShaft
					(<= 7000 gNewRoomNum 7924) ; octoAtriumRamp, ocMorphGateSW
					(<= 5301 gNewRoomNum 5331) ; NY_Octospider_Plaza_1, NY_Octospider_Plaza_31
					(<= 8000 gNewRoomNum 8130) ; HumanRamp, HumanBeds
					(<= 5202 gNewRoomNum 5215) ; humanPlazaRm2, NY_Human_Plaza_15
					(<= 5401 gNewRoomNum 5419) ; NY_Subway_1, puzzleIconCU
					(<= 5700 gNewRoomNum 5701) ; NYPort, NYPort2
					(<= 5500 gNewRoomNum 5524) ; NYMazeA, NYMazeZ
				)
				(cond
					((<= 7000 gNewRoomNum 7924) ; octoAtriumRamp, ocMorphGateSW
						(= temp4 (/ (mod (+ (temp0 heading:) 135) 360) 45))
					)
					((<= 6001 gNewRoomNum 6911) ; avianLeftShaft1, mirmicatPoolCloseUp
						(= temp4 (/ (temp0 heading:) 45))
					)
					(else
						(= temp4 (/ (mod (+ (temp0 heading:) 180) 360) 45))
					)
				)
			else
				(= temp4 (/ (temp0 heading:) 45))
			)
			(north_Indicator init: (mod (- 8 temp4) 8))
			(for
				((= temp1 (temp0 right:)))
				(and temp1 (!= temp1 temp0))
				((= temp1 (temp1 right:)))
				
				(= temp2 (/ (proc21_1 temp0 temp1) 45))
				(localproc_0 temp2)
			)
		)
	)
)

(instance north_Indicator of View
	(properties
		x 273
		y 389
		view 206
	)

	(method (init param1)
		(self cel: param1)
		(super init: global123)
	)
)

(instance arrow_0 of View
	(properties
		x 273
		y 389
		view 206
		loop 3
	)

	(method (init param1)
		(if (and argc param1)
			(= cel 1)
		else
			(= cel 0)
		)
		(super init: global123)
	)
)

(instance arrow_45 of View
	(properties
		x 273
		y 389
		view 206
		loop 4
	)

	(method (init)
		(super init: global123)
	)
)

(instance arrow_90 of View
	(properties
		x 273
		y 389
		view 206
		loop 5
	)

	(method (init)
		(super init: global123)
	)
)

(instance arrow_135 of View
	(properties
		x 273
		y 389
		view 206
		loop 6
	)

	(method (init)
		(super init: global123)
	)
)

(instance arrow_180 of View
	(properties
		x 273
		y 389
		view 206
		loop 7
	)

	(method (init)
		(super init: global123)
	)
)

(instance arrow_225 of View
	(properties
		x 273
		y 389
		view 206
		loop 8
	)

	(method (init)
		(super init: global123)
	)
)

(instance arrow_270 of View
	(properties
		x 273
		y 389
		view 206
		loop 9
	)

	(method (init)
		(super init: global123)
	)
)

(instance arrow_315 of View
	(properties
		x 273
		y 389
		view 206
		loop 10
	)

	(method (init)
		(super init: global123)
	)
)

(instance arrow_Up of View
	(properties
		x 273
		y 389
		view 206
		loop 1
	)

	(method (init param1)
		(if (and argc param1)
			(= cel 1)
		else
			(= cel 0)
		)
		(super init: global123)
	)
)

(instance arrow_Down of View
	(properties
		x 273
		y 389
		view 206
		loop 2
	)

	(method (init param1)
		(if (and argc param1)
			(= cel 1)
		else
			(= cel 0)
		)
		(super init: global123)
	)
)


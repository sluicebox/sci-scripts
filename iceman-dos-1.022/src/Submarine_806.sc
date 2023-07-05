;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 806)
(include sci.sh)
(use Main)
(use TimedControler)
(use n821)
(use n827)
(use System)

(public
	accelerator 1
)

(class Submarine of Obj
	(properties
		_depth 35
		_absHeading 0
		pitch 0
		roll 0
		rudder 0
		_vSpeed 0
		hSpeed 0
		bowBallast 60
		emergencyBallast 480
		throttle 0
		rpms 0
		longitude 0
		latitude 0
		misslesLeft 4
		torpedosLeft 10
		decoysLeft 4
		flags 8
		waterTemp 12
		lastH 0
		lastM 0
		floor 10000
		ceiling 0
		wayPoint1X 0
		wayPoint1Y 0
		wayPoint2X 0
		wayPoint2Y 0
		wayPoint3X 0
		wayPoint3Y 0
		wayPoint4X 0
		wayPoint4Y 0
		wayPoint5X 0
		wayPoint5Y 0
		wheelX 158
		diveLeverY 144
		throttleY 179
	)

	(method (init)
		(= lastH global135)
		(= lastM global134)
		(headingController init: self 392)
		(accelerator init: self 358)
	)

	(method (accel param1 param2)
		(if argc
			(accelerator incPerTime: param1)
			(if (>= argc 2)
				(accelerator cycles: param2)
			)
		)
	)

	(method (absHeading param1)
		(return
			(if argc
				(= _absHeading (umod param1 360))
			else
				_absHeading
			)
		)
	)

	(method (doit)
		(if (and (!= global137 (GetTime 1)) _vSpeed) ; SysTime12
			(self depth: (+ _vSpeed _depth))
		)
		(headingController doit:)
		(accelerator doit:)
	)

	(method (dive param1 &tmp temp0)
		(if 1
			(= temp0 (* param1 20))
			(self bowBallast: temp0)
		)
		(self pitch: (* (- param1 3) 10) vSpeed:)
	)

	(method (vSpeed)
		(= _vSpeed
			(-
				(/
					(+
						(*
							2
							(- (sign (self pitch:)))
							(CosMult (self pitch:) (self hSpeed:))
						)
						(/
							(+ (- 480 emergencyBallast) (* 4 (- 60 bowBallast)))
							4
						)
					)
					30
				)
			)
		)
	)

	(method (turn param1)
		(self rudder: (/ param1 9) roll: (/ (* param1 2) 3))
	)

	(method (depth param1)
		(if (not argc)
			(return _depth)
		)
		(cond
			((< param1 35)
				(return (= _depth 35))
			)
			((> param1 5000)
				(EgoDead 926 2 0 806 0) ; "You have exceeded the maximum depth for this craft."
			)
			((> param1 floor)
				(if hSpeed
					(EgoDead 926 3 0 806 1) ; "You ran the sub aground."
				else
					(return (= _depth floor))
				)
			)
			((< param1 ceiling)
				(EgoDead 926 4 0 806 2) ; "You were running too shallow under the ice."
			)
		)
		(return (= _depth param1))
	)
)

(instance accelerator of TimedControler
	(properties
		incPerTime 1
	)

	(method (drive &tmp temp0 temp1)
		(= incPerTime
			(sign
				(= temp0
					(-
						(if
							(or
								(== (Abs (= temp1 (Submarine throttle:))) 1)
								(not temp1)
							)
							(* temp1 5)
						else
							(* (- temp1 1) 20)
						)
						(Submarine hSpeed:)
					)
				)
			)
		)
		(= temp0 (Abs temp0))
		(= cycles (+ (* global132 (/ (- 60 temp0) 8)) 1))
		(super drive:)
		(Submarine rpms: (* (Sqrt (* (Submarine hSpeed:) 300)) 10))
		(theObj vSpeed:)
	)
)

(instance headingController of TimedControler
	(properties
		cyclCnt 5
		incPerTime 1
	)

	(method (drive &tmp temp0)
		(= temp0 (/ (* (proc827_0 theObj 356) (proc827_0 theObj 358)) 5))
		(= incPerTime (sign temp0))
		(cond
			((not (= temp0 (Abs temp0))))
			((> temp0 20)
				(*= incPerTime 6)
				(= cycles (+ (* global132 2) 1))
			)
			((> temp0 10)
				(*= incPerTime 3)
				(= cycles (+ (* global132 4) 1))
			)
			(else
				(*= incPerTime 2)
				(= cycles (+ (* global132 8) 1))
			)
		)
		(super drive:)
	)
)


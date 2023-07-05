;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Print)
(use Feature)
(use System)

(public
	ExitFeature 0
)

(class ExitFeature of Feature
	(properties
		nsLeft -999
		nsTop -999
		nsRight -999
		nsBottom -999
		state 8
		x -999
		y -999
		exitDir 0
		nextRoom 0
		interRoom 0
		appXOffset 0
		appYOffset 0
	)

	(method (init param1)
		(self exitDir: param1 approachVerbs: 21 setHotspot: 21 3) ; Exit, Exit, Move
		(cond
			((OneOf param1 1 10 13)
				(if (== nsLeft -999)
					(= nsLeft 0)
				)
				(if (== nsTop -999)
					(= nsTop -20)
				)
				(if (== nsRight -999)
					(= nsRight 293)
				)
				(if (== nsBottom -999)
					(= nsBottom 0)
				)
				(if (== y -999)
					(= y 0)
				)
				(if (== x -999)
					(= x (+ nsLeft (/ (- nsRight nsLeft) 2)))
				)
			)
			((OneOf param1 3 11 12)
				(if (== nsLeft -999)
					(= nsLeft 0)
				)
				(if (== nsTop -999)
					(= nsTop 123)
				)
				(if (== nsRight -999)
					(= nsRight 293)
				)
				(if (or (== nsBottom -999) (> nsBottom 129))
					(= nsBottom 137)
				)
				(if (== x -999)
					(= x (+ nsLeft (/ (- nsRight nsLeft) 2)))
				)
				(if (== y -999)
					(= y (+ nsTop (/ (- nsBottom nsTop) 2)))
				)
			)
			((== param1 2)
				(if (== nsLeft -999)
					(= nsLeft 285)
				)
				(if (== nsTop -999)
					(= nsTop 0)
				)
				(if (or (== nsRight -999) (> nsRight 292))
					(= nsRight 310)
				)
				(if (== nsBottom -999)
					(= nsBottom 130)
				)
				(if (== x -999)
					(= x (+ nsLeft (/ (- nsRight nsLeft) 2)))
				)
				(if (== y -999)
					(= y (- nsBottom 10))
				)
			)
			((== param1 4)
				(if (or (== nsLeft -999) (< nsLeft 0))
					(= nsLeft -20)
				)
				(if (== nsTop -999)
					(= nsTop 0)
				)
				(if (== nsRight -999)
					(= nsRight 5)
				)
				(if (== nsBottom -999)
					(= nsBottom 130)
				)
				(if (== x -999)
					(= x (+ nsLeft (/ (- nsRight nsLeft) 2)))
				)
				(if (== y -999)
					(= y (- nsBottom 10))
				)
			)
			(else
				(Printf {Invalid cursor: %d passed to ExitFeature!} param1)
			)
		)
		(super init:)
		(self sightAngle: 26505)
	)

	(method (doVerb theVerb)
		(if (and nextRoom (== theVerb 21)) ; Exit
			(gGame handsOff:)
			(CueObj client: 0)
			(if interRoom
				(= global125 interRoom)
			)
			(gCurRoom newRoom: nextRoom)
		else
			(super doVerb: theVerb)
		)
	)
)


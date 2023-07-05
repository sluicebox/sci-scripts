;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 48)
(include sci.sh)
(use Main)
(use Motion)

(class Spin of Fwd
	(properties
		cel 0
		slowSpin 1
		currentSpeed 0
		startCel 0
	)

	(method (init param1 param2 param3 param4)
		(super init: param1)
		(= cel clientLastCel)
		(if (> argc 1)
			(= caller param2)
			(if (> argc 2)
				(= cel param3)
				(if (> argc 3)
					(= slowSpin param4)
				)
			)
		)
		(if slowSpin
			(= currentSpeed 0)
		else
			(= currentSpeed (client cycleSpeed:))
		)
	)

	(method (doit &tmp temp0)
		(if (!= (client cel:) (= temp0 (self nextCel:)))
			(if (> temp0 clientLastCel)
				(self cycleDone:)
			else
				(client cel: temp0)
			)
			(if (and (== cel (client cel:)) slowSpin)
				(if (< currentSpeed (client cycleSpeed:))
					(<<= currentSpeed $0001)
					(if (not currentSpeed)
						(= currentSpeed 1)
					)
				else
					(= completed 1)
					(self motionCue:)
				)
			)
		)
	)

	(method (nextCel)
		(return
			(if (< (Abs (- gGameTime cycleCnt)) currentSpeed)
				(client cel:)
			else
				(= cycleCnt gGameTime)
				(+ (client cel:) cycleDir)
			)
		)
	)
)


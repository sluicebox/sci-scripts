;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 891)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class FuzzyStop of Fwd
	(properties
		theStopCelArray 0
	)

	(method (init param1 param2 param3)
		(= theStopCelArray param2)
		(if (>= argc 3)
			(= caller param3)
		)
		(super init: param1 &rest)
	)

	(method (motionCue &tmp temp0)
		(= temp0 (client mover:))
		(if (and caller (or (not temp0) (temp0 completed:)))
			(caller cue:)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((not (client isStopped:))
				(super doit: &rest)
			)
			((and (client isStopped:) (client mover:))
				(if (and (= temp0 (client mover:)) (not (temp0 completed:)))
					(client setMotion: 0)
				)
			)
			(
				(and
					(!=
						(client cel:)
						(WordAt theStopCelArray (client loop:))
					)
					(>= (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
				)
				(= cycleCnt gGameTime)
				(client setCel: (WordAt theStopCelArray (client loop:)))
				(self motionCue:)
			)
		)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 103)
(include sci.sh)
(use Main)
(use Grooper)

(public
	EgoGroop 0
)

(class EgoGroop of Grooper
	(properties
		dontHead 0
		speedState 0
	)

	(method (doit)
		(if
			(and
				(== (gEgo loop:) (- (NumLoops gEgo) 1))
				(not (& (gEgo signal:) $0800))
			)
			(gEgo loop: (gEgo cel:))
		)
		(super doit: &rest)
	)

	(method (cue &tmp [temp0 10])
		(super cue:)
		(= dontHead 1)
		(if (and (== (gEgo view:) 900) (gGame isHandsOn:))
			(if (< 3 (gEgo loop:) 8)
				(gEgo setStep: 3 2)
				(if speedState
					(gEgo currentSpeed: (- (gEgo currentSpeed:) 2))
					(gEgo setSpeed: (gEgo currentSpeed:))
					(= speedState 0)
				)
			else
				(gEgo setStep: 6 2)
				(if (not speedState)
					(gEgo currentSpeed: (+ (gEgo currentSpeed:) 2))
					(gEgo setSpeed: (gEgo currentSpeed:))
					(= speedState 2)
				)
			)
		)
		(= dontHead 0)
	)
)


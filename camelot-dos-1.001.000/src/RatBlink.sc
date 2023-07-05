;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 174)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	RatBlink 0
)

(class RatBlink of Rgn
	(properties
		eyeList 0
		curEye 0
		numEyes 0
	)

	(method (init)
		(super init:)
		(= eyeList (List new:))
		(self setScript: doDaBlinka)
	)

	(method (dispose &tmp temp0)
		(super dispose:)
		(eyeList dispose: delete:)
	)

	(method (addEyes param1 param2 param3 &tmp temp0 temp1)
		(= temp1 (if (== argc 3) param3 else -1))
		((= temp0 (Prop new:))
			view: 267
			x: param1
			y: param2
			setPri: temp1
			init:
			hide:
		)
		(eyeList add: temp0)
		(++ numEyes)
	)
)

(instance ratEyesForward of Fwd
	(properties)
)

(instance doDaBlinka of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 3])
		(switch (= state newState)
			(0
				(if (or (gEgo script:) (IsFlag 181))
					(-- state)
				)
				(= seconds (Random 3 15))
			)
			(1
				(= temp0 (Random 0 (- (client numEyes:) 1)))
				(client curEye: ((client eyeList:) at: temp0))
				((client curEye:)
					setLoop: 4
					cycleSpeed: 2
					show:
					setCycle: ratEyesForward
				)
				(= cycles (Random 6 18))
			)
			(2
				(if (Random 0 1)
					((client curEye:) setLoop: 3)
					(= cycles (Random 4 18))
				else
					(self cue:)
				)
			)
			(3
				((client curEye:) hide:)
				(self changeState: 0)
			)
		)
	)
)


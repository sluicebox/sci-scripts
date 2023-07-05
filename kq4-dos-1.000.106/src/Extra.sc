;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 988)
(include sci.sh)
(use Motion)
(use Actor)

(class Extra of Prop
	(properties
		cycleSpeed 1
		pauseCel 0
		minPause 10
		maxPause 30
		minCycles 8
		maxCycles 20
		state -1
		cycles 0
	)

	(method (init)
		(self isExtra: 1)
		(= cel (InitialCel))
		(self changeState: 0)
		(super init:)
	)

	(method (doit)
		(if (not (-- cycles))
			(self cue:)
		)
		(super doit:)
	)

	(method (stopExtra)
		(self setCel: (InitialCel) stopUpd:)
	)

	(method (startExtra)
		(self changeState: 1)
	)

	(method (cue)
		(self changeState: (+ state 1))
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random minPause maxPause))
			)
			(1
				(self setCycle: Fwd)
				(= cycles (Random minCycles maxCycles))
			)
			(2
				(self setCel: (InitialCel))
				(self changeState: 0)
			)
		)
	)

	(procedure (InitialCel)
		(return
			(switch pauseCel
				(-1
					(Random 0 (self lastCel:))
				)
				(-2
					(self lastCel:)
				)
				(else pauseCel)
			)
		)
	)
)


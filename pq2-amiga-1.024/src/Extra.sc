;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 988)
(include sci.sh)
(use Motion)
(use Actor)

(class Extra of Prop
	(properties
		cycleSpeed 1
		cycleType 0
		hesitation 0
		pauseCel 0
		minPause 10
		maxPause 30
		minCycles 8
		maxCycles 20
		counter 0
		state -1
		cycles 0
	)

	(method (init)
		(= cel (InitialCel))
		(self changeState: 0)
		(super init:)
	)

	(method (doit)
		(if (and (== cycleType 1) (== cel pauseCel))
			(and (!= pauseCel 0) (== cycles (+ hesitation 1)))
		)
		(if (and cycles (not (-- cycles)))
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
		(return (or (& signal $0005) (self changeState: (+ state 1))))
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== counter 0)
					(= cycles (Random minPause maxPause))
					(if (!= cycleType 0)
						(= counter (- (Random minCycles maxCycles) 1))
					)
				else
					(-- counter)
					(self cue:)
				)
			)
			(1
				(if (== cycleType 0)
					(self setCycle: Fwd)
					(= cycles (Random minCycles maxCycles))
				else
					(self setCycle: End self)
				)
			)
			(2
				(if (== cycleType 2)
					(= cycles hesitation)
				else
					(self cue:)
				)
			)
			(3
				(if (== cycleType 2)
					(self setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(4
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
				((== cycleType 0) pauseCel)
			)
		)
	)
)


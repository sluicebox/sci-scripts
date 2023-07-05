;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 920)
(include sci.sh)
(use Motion)
(use Actor)

(class Extra of Prop
	(properties
		state -1
		cycleSpeed 1
		cycleType 0
		hesitation 0
		pauseCel 0
		minPause 10
		maxPause 30
		minCycles 8
		maxCycles 20
		counter 0
		cycles 0
	)

	(method (init)
		(= cel (localproc_0))
		(self changeState: 0)
		(super init:)
	)

	(method (doit)
		(if (and (== cycleType 1) (== cel pauseCel) (!= pauseCel 0))
			(= cycles (+ hesitation 1))
		)
		(if (and cycles (not (-- cycles)))
			(self cue:)
		)
		(super doit:)
	)

	(method (stopExtra)
		(self setCel: (localproc_0) stopUpd:)
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
				(if (<= counter 0)
					(if (!= cycleType 0)
						(= counter (- (Random minCycles maxCycles) 1))
					)
					(if (not (= cycles (Random minPause maxPause)))
						(self cue:)
					)
				else
					(-- counter)
					(self cue:)
				)
			)
			(1
				(cond
					((== cycleType 0)
						(self setCycle: Fwd)
						(= cycles (Random minCycles maxCycles))
					)
					((and (== cycleType 2) (== pauseCel -2))
						(self setCycle: Beg self)
					)
					(else
						(self setCycle: End self)
					)
				)
			)
			(2
				(if (and hesitation (== cycleType 2))
					(= cycles hesitation)
				else
					(self cue:)
				)
			)
			(3
				(if (== cycleType 2)
					(if (!= pauseCel -2)
						(self setCycle: Beg self)
					else
						(self setCycle: End self)
					)
				else
					(self cue:)
				)
			)
			(4
				(self setCel: (localproc_0))
				(self changeState: 0)
			)
		)
	)

	(procedure (localproc_0)
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


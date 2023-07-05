;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use n001)
(use Motion)
(use System)

(public
	getRock 0
)

(local
	savSignal
	savPriority
	savIllegalBits
)

(instance getRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= savSignal (gEgo signal:))
				(= savPriority (gEgo priority:))
				(= savIllegalBits (gEgo illegalBits:))
				(HandsOff)
				(gEgo
					view: 47
					setLoop: (if (== (gEgo loop:) 0) 0 else 1)
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(TimePrint 4 60 0) ; "You pick up a few small rocks."
				(gEgo get: 9 5 setCycle: Beg self) ; Rock
			)
			(2
				(NormalEgo)
				(HandsOn)
				(gEgo priority: savPriority illegalBits: savIllegalBits signal: savSignal)
				(client setScript: 0)
			)
		)
	)
)


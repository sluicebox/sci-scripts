;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 103)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	getRock 0
)

(local
	local0
	local1
	local2
)

(instance getRock of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 103)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (gEgo signal:))
				(= local1 (gEgo priority:))
				(= local2 (gEgo illegalBits:))
				(HandsOff)
				(gEgo
					view: 510
					setLoop: (if (== (gEgo loop:) 0) 0 else 1)
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(TimePrint 4 103 0) ; "You pick up a few small rocks."
				(gEgo get: 21 10 setCycle: Beg self) ; boulder
			)
			(2
				(NormalEgo)
				(HandsOn)
				(gEgo priority: local1 illegalBits: local2 signal: local0)
				(client setScript: 0)
			)
		)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 103)
(include sci.sh)
(use Main)
(use n814)
(use Print)
(use Motion)
(use System)

(public
	getRock 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 40]
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
				(= local0 (gEgo cycleSpeed:))
				(= local1 (gEgo signal:))
				(= local2 (gEgo priority:))
				(= local3 (gEgo illegalBits:))
				(= local4 (not global102))
				(HandsOff)
				(gEgo
					view: 510
					setLoop: (if (OneOf (gEgo loop:) 2 4 0 6) 0 else 1)
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(1
				(= ticks 18)
			)
			(2
				(gEgo cel: (- (gEgo cel:) 1))
				(= ticks 30)
			)
			(3
				(gEgo cel: (+ (gEgo cel:) 1))
				(= ticks 18)
			)
			(4
				(gEgo cel: (- (gEgo cel:) 1))
				(= ticks 30)
			)
			(5
				(gEgo cel: (+ (gEgo cel:) 1))
				(= ticks 18)
			)
			(6
				(gEgo cel: (- (gEgo cel:) 1))
				(= ticks 30)
			)
			(7
				(Message msgGET 103 1 0 0 1 @local5) ; "You pick up a few small rocks."
				(Print addText: @local5 init:)
				(gEgo setCycle: Beg self)
			)
			(8
				(NormalEgo)
				(if local4
					(HandsOn)
				)
				(gEgo
					get: 10 10 ; rock
					cycleSpeed: local0
					priority: local2
					illegalBits: local3
					signal: local1
				)
				(client setScript: 0)
			)
		)
	)
)


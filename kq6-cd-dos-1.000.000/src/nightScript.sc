;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use LoadMany)
(use Sound)
(use Motion)
(use System)

(public
	nightScript 0
)

(local
	local0
	local1
)

(instance nightScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: killSound: 1)
				(localMusic4 number: 930 loop: 1 play:)
				(= local1 (gEgo cel:))
				(gEgo
					normal: 0
					view: 883
					ignoreActors: 1
					illegalBits: 0
					ignoreHorizon: 1
					cycleSpeed: 10
				)
				(if (OneOf (gEgo cel:) 0 2 4 6)
					(= local0 1)
					(gEgo setLoop: 1)
				else
					(gEgo setLoop: 0)
				)
				(gEgo setCycle: End self)
			)
			(1
				(gMessager say: 1 37 0 0 self 0) ; "Alexander winds the mechanical nightingale and listens to its sweet, sunny tune."
			)
			(2
				(localMusic4 number: 931 loop: 1 play: self)
				(if local0
					(gEgo setLoop: 7 setCycle: Fwd)
				else
					(gEgo setLoop: 6 setCycle: Fwd)
				)
			)
			(3
				(gGame killSound: 0)
				(= cycles 2)
			)
			(4
				(gGame handsOn:)
				(localMusic4 stop: dispose:)
				(gEgo reset: local1)
				(= cycles 1)
			)
			(5
				(self dispose:)
				(LoadMany 0 93)
			)
		)
	)
)

(instance localMusic4 of Sound
	(properties)
)


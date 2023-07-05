;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Sync)
(use Actor)
(use System)

(public
	rm091 0
)

(instance rm091 of KQ5Room
	(properties
		picture 91
	)

	(method (init)
		(super init:)
		(HandsOff)
		(hOneEyes init: setScript: eye1Script)
		(hTwoEyes init: setScript: eye2Script)
		(h1Mouth init:)
		(h2Mouth init:)
		(self setScript: crtn5Script)
	)

	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance crtn5Script of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(h1Mouth setCycle: MouthSync 5057)
				(Say 5057 self)
			)
			(2
				(h1Mouth setCycle: 0)
				(h2Mouth setCycle: MouthSync 5058)
				(Say 5058 self)
			)
			(3
				(h2Mouth setCycle: 0)
				(h1Mouth setCycle: MouthSync 5059)
				(Say 5059 self)
			)
			(4
				(h1Mouth setCycle: 0)
				(gCurRoom newRoom: 90)
			)
		)
	)
)

(instance eye1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(client cel: 1)
				(= cycles 2)
			)
			(2
				(client cel: 0)
				(self init:)
			)
		)
	)
)

(instance eye2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(client cel: 1)
				(= cycles 2)
			)
			(2
				(client cel: 0)
				(self init:)
			)
		)
	)
)

(instance h1Mouth of Prop
	(properties
		x 110
		y 72
		view 1035
		loop 1
		cel 4
		priority 4
		cycleSpeed 2
	)
)

(instance hOneEyes of Prop
	(properties
		x 110
		y 60
		view 844
		priority 5
	)
)

(instance h2Mouth of Prop
	(properties
		x 218
		y 74
		view 1035
		cel 4
		priority 4
		cycleSpeed 2
	)
)

(instance hTwoEyes of Prop
	(properties
		x 217
		y 61
		view 844
		loop 2
		priority 5
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 122)
(include sci.sh)
(use Main)
(use DLetter)
(use KQ5Room)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(public
	ending3 0
)

(instance ending3 of KQ5Room
	(properties
		picture 218
	)

	(method (init)
		(super init:)
		(HandsOff)
		(gGame setCursor: 5 1)
		(Load rsSCRIPT 941)
		(egoMouth init: setCycle: RandCycle)
		(arm init:)
		(casEyes init:)
		(alBlinking init:)
		(valBlinking init:)
		(rosEyes init:)
		(self setScript: cartoon)
	)

	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance cartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(arm setScript: armScript)
				(egoMouth setCycle: Fwd)
				(PrintDC 122 0 #at 9 119 #width 285 #dispose) ; "Let me introduce you to my family. This is my wife, Queen Valanice; my daughter, Princess Rosella; and my son, Prince Alexander...who started this whole mess! All of you, this is Princess Cassima from the Land of the Green Isles. Without her, none of us would be standing here now. She bravely saved my life!"
				(= seconds 24)
			)
			(1
				(cls)
				(egoMouth dispose:)
				(alTalking init: setCycle: RandCycle)
				(PrintDC 122 1 #at 8 146 #width 285 #dispose) ; "My Lady. I am deeply in your debt and I will make it up to you. With your permission, I'd like to travel to the Land of the Green Isles to see you."
				(= seconds 12)
			)
			(2
				(cls)
				(casEyes hide:)
				(alBlinking hide:)
				(valBlinking hide:)
				(rosEyes hide:)
				(gCurRoom newRoom: 120) ; ending
			)
		)
	)
)

(instance egoMouth of Prop
	(properties
		x 116
		y 34
		view 936
		priority 1
		cycleSpeed 2
	)
)

(instance arm of Prop
	(properties
		x 90
		y 40
		view 936
		loop 1
		priority 1
		cycleSpeed 2
	)
)

(instance casEyes of Prop
	(properties
		x 64
		y 28
		view 936
		loop 2
		priority 1
		cycleSpeed 2
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 40)
			(1
				(if (not script)
					(self setScript: (bodyScript new:))
				)
			)
		)
	)
)

(instance alTalking of Prop
	(properties
		x 270
		y 32
		view 936
		loop 3
		priority 1
		cycleSpeed 2
	)
)

(instance alBlinking of Prop
	(properties
		x 260
		y 18
		view 936
		loop 4
		priority 1
		cycleSpeed 2
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 40)
			(1
				(if (not script)
					(self setScript: (bodyScript new:))
				)
			)
		)
	)
)

(instance valBlinking of Prop
	(properties
		x 144
		y 32
		view 936
		loop 5
		priority 1
		cycleSpeed 2
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 40)
			(1
				(if (not script)
					(self setScript: (bodyScript new:))
				)
			)
		)
	)
)

(instance rosEyes of Prop
	(properties
		x 202
		y 37
		view 936
		loop 6
		priority 1
		cycleSpeed 2
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 40)
			(1
				(if (not script)
					(self setScript: (bodyScript new:))
				)
			)
		)
	)
)

(instance armScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= seconds 6)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

(instance bodyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client setCycle: Beg self)
			)
			(2
				(client setScript: 0)
			)
		)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 122)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Sync)
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
				(egoMouth setCycle: MouthSync 5210)
				(Say 5210 self)
			)
			(1
				(cls)
				(egoMouth setCycle: 0 dispose:)
				(alTalking init: setCycle: MouthSync 5211)
				(Say 5211 self)
			)
			(2
				(cls)
				(alTalking setCycle: 0)
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


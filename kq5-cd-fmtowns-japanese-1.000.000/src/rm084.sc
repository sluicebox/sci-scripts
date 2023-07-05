;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 84)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Sync)
(use Motion)
(use Actor)
(use System)

(public
	rm084 0
)

(instance rm084 of KQ5Room
	(properties
		picture 84
	)

	(method (init)
		(super init:)
		(Load rsVIEW 796)
		(Load rsSCRIPT 941)
		(theMouth init:)
		(arms init:)
		(theEyes init:)
		(self setScript: cartoon setRegions: 763) ; cartoonRegion
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
			)
		)
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
				(= seconds 3)
			)
			(1
				(theMouth setCycle: MouthSync 5099)
				(Say 5099 self)
			)
			(2
				(cls)
				(theMouth setCycle: 0)
				(= seconds 2)
			)
			(3
				(arms cycleSpeed: 1 setCycle: End)
				(= seconds 2)
			)
			(4
				(gCurRoom newRoom: 83)
			)
		)
	)
)

(instance theMouth of Prop
	(properties
		x 119
		y 71
		view 780
		priority 10
		signal 2064
		cycleSpeed 2
	)
)

(instance theEyes of Prop
	(properties
		x 119
		y 60
		view 780
		loop 1
		priority 10
		signal 2064
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 30)
			(1
				(if (not cycler)
					(self setCycle: End)
				)
			)
		)
	)
)

(instance arms of Prop
	(properties
		x 128
		y 93
		view 780
		loop 2
		priority 10
		signal 2064
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 84)
(include sci.sh)
(use Main)
(use Interface)
(use RandCycle)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm084 0
)

(instance rm084 of Rm
	(properties
		picture 84
	)

	(method (init)
		(super init:)
		(Load rsVIEW 796)
		(Load rsSCRIPT 751)
		(mouth init:)
		(arms init:)
		(eyes init:)
		(self setScript: cartoon)
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
		(DisposeScript 751)
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
				(mouth setCycle: RandCycle)
				(PrintDC 84 0 #at 111 127 #dispose) ; "I never take anything without giving in return. For your generosity in giving me those exquisite emeralds I give you my finest pair of shoes. May they help you in your quest."
				(= seconds 12)
			)
			(2
				(cls)
				(mouth setCycle: 0)
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

(instance mouth of Prop
	(properties
		y 71
		x 119
		view 780
		priority 10
		signal 2064
		cycleSpeed 2
	)
)

(instance eyes of Prop
	(properties
		y 60
		x 119
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
		y 93
		x 128
		view 780
		loop 2
		priority 10
		signal 2064
	)
)


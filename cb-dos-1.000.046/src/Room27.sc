;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room27 0
)

(instance Room27 of Rm
	(properties
		picture 27
	)

	(method (init)
		(= horizon 120)
		(= east 28)
		(= west 26)
		(= north 21)
		(super init:)
		(if gDetailLevel
			(star1 cycleSpeed: 2 setCycle: Fwd init:)
			(star2 init: setScript: twinkle)
		)
		(self setRegions: 207 405 setFeatures: House) ; fenceReg, Gator
		(if (and (>= gAct 2) (< gAct 4))
			(self setRegions: 202) ; EthelDrunk
		)
		(if
			(or
				(and (== gAct 3) (!= global114 10))
				(and (== gAct 6) (not (& gMustDos $0002)))
			)
			(self setRegions: 281) ; rudywand
		)
		(switch gPrevRoomNum
			(21
				(gEgo posn: 162 122)
			)
		)
		(gEgo view: 0 init:)
		(HandsOn)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 27 0) ; "You are at the south edge of the bayou island. An old road runs alongside the old plantation's front wrought iron fence. From here you can see the west edge of the main circular driveway."
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((Said '[<around,at][/room]')
					(Print 27 0) ; "You are at the south edge of the bayou island. An old road runs alongside the old plantation's front wrought iron fence. From here you can see the west edge of the main circular driveway."
				)
				((Said '/cabin,mansion')
					(Print 27 1) ; "A once-grand plantation house sits in the center of this lonely bayou island. You can imagine the family that once lived here: the parties, the farming, the hustle and the bustle of a thriving plantation; but now, no more. Now the estate has been reduced to a mere fragment of itself while the big house and outbuildings have been allowed to deteriorate."
				)
			)
		)
	)
)

(instance twinkle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(star2 setCycle: End self)
			)
			(1
				(if (< (Random 1 100) 35)
					(= state -1)
				else
					(= state 0)
				)
				(= seconds (Random 7 15))
			)
		)
	)
)

(instance star1 of Prop
	(properties
		y 3
		x 116
		view 107
		loop 1
	)
)

(instance star2 of Prop
	(properties
		y 43
		x 228
		view 107
		loop 2
	)
)

(instance House of RFeature
	(properties
		nsTop 69
		nsLeft 74
		nsBottom 82
		nsRight 90
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/playhouse'))
			(event claimed: 1)
			(Print 27 2) ; "You see a playhouse in the distance to the north."
		)
	)
)


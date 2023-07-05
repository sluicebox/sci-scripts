;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room29 0
)

(local
	local0
)

(instance Room29 of Rm
	(properties
		picture 29
	)

	(method (init)
		(= horizon 84)
		(= east 30)
		(= west 28)
		(= north 23)
		(super init:)
		(if gDetailLevel
			(owlHead setScript: owl init:)
			(owlBody init: stopUpd:)
			(star1 cycleSpeed: 2 setCycle: Fwd init:)
			(star2 init: setScript: twinkle)
		else
			(owlBody init: stopUpd:)
			(owlHead loop: 4 cel: 2 addToPic:)
		)
		(self setRegions: 207 405 setFeatures: owlBody) ; fenceReg, Gator
		(if (and (== gAct 3) (< gJeevesChoresState 6))
			(self setRegions: 203) ; clarwand
		)
		(switch gPrevRoomNum
			(23
				(gEgo posn: 151 118)
			)
			(24
				(gEgo posn: 255 125)
			)
		)
		(gEgo view: 0 illegalBits: -32768 init:)
		(HandsOn)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 29 0) ; "You are walking along the south edge of the bayou island. An old road runs alongside the old plantation's front wrought iron fence. From here you can see the east edge of the main circular driveway."
		)
		(if (& (gEgo onControl: 0) $0002)
			(gCurRoom newRoom: 23)
		)
		(if (& (gEgo onControl: 0) $0004)
			(gCurRoom newRoom: 24)
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
					(Print 29 0) ; "You are walking along the south edge of the bayou island. An old road runs alongside the old plantation's front wrought iron fence. From here you can see the east edge of the main circular driveway."
				)
				((Said '/cabin,mansion')
					(Print 29 1) ; "A once-grand plantation house sits in the center of this lonely bayou island. You can imagine the family that once lived here: the parties, the farming, the hustle and the bustle of a thriving plantation; but now, no more. Now the estate has been reduced to a mere fragment of itself while the big house and outbuildings have been allowed to deteriorate."
				)
				((Said '/path')
					(Print 29 2) ; "A dirt path leads toward an old gazebo."
				)
				((Said '/gazebo')
					(Print 29 3) ; "You see a gazebo in the distance to the north."
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

(instance owl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 7))
			)
			(1
				(if (== (owlHead cel:) 0)
					(owlHead setCycle: End self)
					(= local0 (Random 0 3))
				else
					(owlHead setCycle: Beg self)
					(= state -1)
				)
			)
			(2
				(if local0
					(= cycles 1)
				else
					(= seconds (Random 2 5))
				)
			)
			(3
				(if local0
					(owlHead loop: 4)
					(= seconds (Random 2 5))
				else
					(= state 0)
					(= cycles 1)
				)
			)
			(4
				(owlHead loop: 3)
				(= cycles 5)
			)
			(5
				(if (-- local0)
					(= state 2)
				else
					(= state 0)
				)
				(= cycles 1)
			)
		)
	)
)

(instance star1 of Prop
	(properties
		y 34
		x 294
		view 107
		loop 1
	)
)

(instance star2 of Prop
	(properties
		y 13
		x 117
		view 107
		loop 2
	)
)

(instance owlHead of Prop
	(properties
		y 58
		x 130
		view 125
		loop 3
		priority 14
		signal 16
		cycleSpeed 2
	)

	(method (handleEvent event)
		(cond
			((Said 'give,feed,show>')
				(if (or (Said '/*<owl') (Said '/owl') (Said '/*/owl'))
					(if global219
						(if global224
							(Print 29 4) ; "The owl prefers small varmints that scurry around in the darkness."
						else
							(DontHave) ; "You don't have it."
						)
					else
						(Print 29 4) ; "The owl prefers small varmints that scurry around in the darkness."
					)
				)
			)
			((Said 'talk/owl')
				(Print 29 5) ; "Hoo, hoo."
			)
			((Said 'capture,get/owl')
				(Print 29 6) ; "You couldn't get close enough to the owl to catch it."
			)
			((or (MousedOn self event 3) (Said 'look/owl'))
				(Print 29 7) ; "The owl is on his nightly rodent patrol. He pays little attention to you."
				(event claimed: 1)
			)
		)
	)
)

(instance owlBody of Prop
	(properties
		y 82
		x 122
		view 125
		loop 4
		cel 1
		priority 15
		signal 16
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(Print 29 7) ; "The owl is on his nightly rodent patrol. He pays little attention to you."
			(event claimed: 1)
		)
	)
)


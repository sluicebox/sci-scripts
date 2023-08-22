;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room13 0
)

(synonyms
	(fence corral)
	(room barn)
)

(local
	local0
	local1
)

(instance Room13 of Rm
	(properties
		picture 13
	)

	(method (init)
		(= north 9)
		(= horizon 100)
		(super init:)
		(LoadMany rsSOUND 107 108)
		(if (== gAct 1)
			(self setRegions: 381) ; walkabout
		)
		(Door
			cel: (if (== gPrevRoomNum 69) 3 else 0)
			ignoreActors: 1
			init:
			stopUpd:
		)
		(= global373 Door)
		(mySound init:)
		(= global374 mySound)
		(if gDetailLevel
			(Splash1 ignoreActors: 1 init: hide:)
			(Splash2 ignoreActors: 1 init: hide:)
		)
		(self setFeatures: Window1 Window2 Window3 Hay1 Hay2)
		(gEgo illegalBits: -32766)
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
			(9
				(gEgo posn: 276 101)
			)
			(14
				(gEgo posn: 295 125)
			)
			(20
				(gEgo loop: 3 posn: 297 187)
			)
			(21
				(gEgo posn: 310 159)
			)
			(25
				(gEgo posn: 178 188)
			)
			(69
				(gEgo posn: 147 142)
				(HandsOff)
				(self setScript: exit)
			)
		)
		(gEgo view: 0 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 13 0) ; "On the west corner of the island, you see an old dilapidated stable surrounded by an empty corral."
		)
		(if
			(and
				(& (gEgo onControl: 0) $0010)
				(or (== (gEgo loop:) 3) (== (gEgo loop:) 1))
				(not local0)
				(== (Door cel:) 0)
			)
			(= local0 1)
			(= global131 0)
			(self setScript: myDoor)
		)
		(if (and (== gPrevRoomNum 69) (not local1) (== (Door cel:) 0))
			(= local1 1)
			(Door stopUpd:)
		)
		(if (& (gEgo onControl: 1) $0002)
			(gCurRoom newRoom: 69)
		)
		(if
			(and
				(& (gEgo onControl: 1) $4000)
				(!= (gEgo mover:) 0)
				gDetailLevel
			)
			(switch (gEgo loop:)
				(2
					(if (== (gEgo cel:) 2)
						(Splash1
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel:) 5)
						(Splash2
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
				(3
					(if (== (gEgo cel:) 2)
						(Splash1
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel:) 5)
						(Splash2
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
				(else
					(if (== (gEgo cel:) 0)
						(Splash1
							posn: (- (gEgo x:) 2) (+ (gEgo y:) 1)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel:) 4)
						(Splash2
							posn: (- (gEgo x:) 2) (+ (gEgo y:) 1)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
			)
		)
		(switch (gEgo edgeHit:)
			(EDGE_RIGHT
				(if (< (gEgo y:) 135)
					(gCurRoom newRoom: 14)
				else
					(gCurRoom newRoom: 21)
				)
			)
			(EDGE_BOTTOM
				(if (> (gEgo x:) 188)
					(gCurRoom newRoom: 20)
				else
					(gCurRoom newRoom: 25)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(cond
			((== newRoomNumber 69)
				(gConMusic stop:)
			)
			((== global198 200)
				(++ global198)
				(|= gCorpseFlags $0002) ; Wilbur
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 13 0) ; "On the west corner of the island, you see an old dilapidated stable surrounded by an empty corral."
						)
						((Said '<in/room')
							(Print 13 1) ; "You can't. The door is closed"
						)
						((Said '/chapel')
							(Print 13 2) ; "You see the little chapel in the distance to the north."
						)
						((Said '<(in,above)/fence')
							(Print 13 3) ; "There is nothing but weeds in the corral."
						)
						((Said '/fence')
							(Print 13 4) ; "An empty corral surrounds the old stable."
						)
					)
				)
				((Said '/archway')
					(Print 13 5) ; "You don't see a gate here."
				)
				(
					(or
						(Said 'climb,hop/fence')
						(Said 'enter,((go,get)<in)/fence')
					)
					(Print 13 6) ; "There is nothing of interest in the corral."
				)
			)
		)
	)
)

(instance myDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(mySound number: 107 loop: 1 play:)
				(Door cycleSpeed: 3 setCycle: End self)
				(if (not global131)
					(gEgo ignoreControl: 2)
				)
			)
			(1
				(Door stopUpd:)
				(if (not global131)
					(gEgo setMotion: MoveTo 145 133)
				else
					(= global131 2)
					(= cycles 1)
				)
			)
			(2
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance exit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Door setCycle: Beg self)
				(mySound number: 108 loop: 1 play:)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance Door of Prop
	(properties
		y 71
		x 163
		view 113
		priority 3
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/door'))
			(event claimed: 1)
			(Print 13 7) ; "It's a wide, sliding door."
		)
	)
)

(instance Splash1 of Prop
	(properties
		view 1
		loop 6
	)
)

(instance Splash2 of Prop
	(properties
		view 1
		loop 6
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 69
		nsLeft 16
		nsBottom 92
		nsRight 44
	)

	(method (handleEvent event)
		(cond
			((Said 'open,look<(in,through)/window,room')
				(Print 13 8) ; "You can't get close enough."
			)
			((Said 'break/window')
				(Print 13 9) ; "There's no need for that!"
			)
			((or (MousedOn self event 3) (Said 'look/window'))
				(event claimed: 1)
				(Print 13 10) ; "The stable seems to have plenty of windows."
			)
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 76
		nsLeft 60
		nsBottom 98
		nsRight 90
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 13 10) ; "The stable seems to have plenty of windows."
		)
	)
)

(instance Window3 of RFeature
	(properties
		nsTop 11
		nsLeft 115
		nsBottom 36
		nsRight 175
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 13 10) ; "The stable seems to have plenty of windows."
		)
	)
)

(instance Hay1 of RFeature
	(properties
		nsTop 122
		nsLeft 103
		nsBottom 149
		nsRight 130
	)

	(method (handleEvent event)
		(cond
			((Said 'move,press/bale')
				(Print 13 11) ; "The soggy bales of hay are too heavy to move."
			)
			((Said 'get/bale')
				(Print 13 12) ; "You don't want to carry around soggy hay!"
			)
			((or (MousedOn self event 3) (Said 'look/bale'))
				(event claimed: 1)
				(Print 13 13) ; "Soggy bales of hay lie outside the stable door."
			)
		)
	)
)

(instance Hay2 of RFeature
	(properties
		nsTop 111
		nsLeft 212
		nsBottom 123
		nsRight 239
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 13 13) ; "Soggy bales of hay lie outside the stable door."
		)
	)
)

(instance mySound of Sound
	(properties
		number 107
	)
)


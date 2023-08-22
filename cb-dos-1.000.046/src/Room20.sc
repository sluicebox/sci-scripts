;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
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
	Room20 0
)

(local
	local0
	local1
	local2
)

(instance Room20 of Rm
	(properties
		picture 20
	)

	(method (init)
		(= west 13)
		(= east 21)
		(= north 14)
		(= horizon 96)
		(super init:)
		(LoadMany rsSOUND 43 44)
		(if gDetailLevel
			(Squirel init: setScript: runAway)
		)
		(Door cel: (if (== gPrevRoomNum 61) 3 else 0) init: stopUpd:)
		(self setFeatures: Window1 Window2 Window3 Window4 Box)
		(if (and (>= gAct 2) (== global113 gCurRoomNum))
			(self setRegions: 202) ; EthelDrunk
		)
		(if
			(and
				(== global114 gCurRoomNum)
				(or
					(== gAct 3)
					(and (== gAct 6) (not (& gMustDos $0002)))
				)
			)
			(self setRegions: 281) ; rudywand
		)
		(switch gPrevRoomNum
			(25
				(gEgo posn: 84 188)
			)
			(26
				(gEgo posn: 297 188)
			)
			(14
				(gEgo posn: 305 100)
			)
			(61
				(= local1 1)
				(gEgo loop: 2 posn: 82 166)
				(self setScript: enterFrom61)
			)
			(13
				(gEgo posn: 3 177)
			)
		)
		(gEgo view: 0 illegalBits: -32768 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 20 0) ; "You have come upon a run-down carriage house. Old crates have been piled before one of the doors. For obvious reasons, it has not been used as a carriage house for some time."
		)
		(if
			(and
				(& (gEgo onControl: 1) $0008)
				(== (gEgo loop:) 3)
				(not local0)
			)
			(= local0 1)
			(self setScript: myDoor)
		)
		(if (& (gEgo onControl: 1) $0002)
			(gCurRoom newRoom: 61)
		)
		(if (== (gEgo edgeHit:) EDGE_BOTTOM)
			(if (< (gEgo x:) 188)
				(gCurRoom newRoom: 25)
			else
				(gCurRoom newRoom: 26)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (and (& gCorpseFlags $0008) (!= newRoomNumber 61)) ; Ethel
			(= gEthelState 101)
		)
		(if (== newRoomNumber 61)
			(gConMusic stop:)
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
						(
							(or
								(Said '[<around,at][/room]')
								(Said '/cabin[<buggy]')
							)
							(Print 20 0) ; "You have come upon a run-down carriage house. Old crates have been piled before one of the doors. For obvious reasons, it has not been used as a carriage house for some time."
						)
						((Said '/drive,path')
							(Print 20 1) ; "A small, dirt driveway leads to the old carriage house."
						)
					)
				)
				((Said 'open/box,box')
					(Print 20 2) ; "They're just old crates. There's nothing of interest inside them."
				)
				((Said 'move,press,get/box,box')
					(Print 20 3) ; "The crates are much too heavy for you to move."
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
				(gEgo illegalBits: 0)
				(myMusic number: 43 loop: 1 play:)
				(Door cycleSpeed: 3 setCycle: End self)
			)
			(1
				(Door ignoreActors: 1 stopUpd:)
				(if (gEgo inRect: 80 0 84 200)
					(= cycles 1)
				else
					(gEgo setMotion: MoveTo 82 (gEgo y:) self)
				)
			)
			(2
				(gEgo setMotion: MoveTo 82 158 self)
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

(instance enterFrom61 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 82 175 self)
			)
			(1
				(Door cycleSpeed: 1 setCycle: Beg self)
				(myMusic number: 44 loop: 1 play:)
			)
			(2
				(Door stopUpd:)
				(HandsOn)
				(= local1 0)
				(client setScript: 0)
			)
		)
	)
)

(instance runAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 8))
			)
			(1
				(Squirel setCycle: End self)
			)
			(2
				(Squirel posn: 309 (Squirel y:) setCycle: End self)
			)
			(3
				(Squirel dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance Squirel of Prop
	(properties
		y 133
		x 286
		view 206
	)

	(method (handleEvent event)
		(cond
			((Said 'get,capture/squirrel')
				(Print 20 4) ; "They are very difficult to catch."
			)
			((or (MousedOn self event 3) (Said 'look/squirrel'))
				(event claimed: 1)
				(Print 20 5) ; "You have frightened off a little squirrel."
			)
		)
	)
)

(instance Door of Prop
	(properties
		y 166
		x 73
		view 120
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/door'))
			(event claimed: 1)
			(Print 20 6) ; "It's a large, carriage house door."
		)
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 99
		nsBottom 131
		nsRight 31
	)

	(method (handleEvent event)
		(cond
			((Said 'open/window')
				(Print 20 7) ; "The windows do not open."
			)
			((Said 'break/window')
				(Print 20 8) ; "Why do that? Just use the door!"
			)
			((Said 'look<(in,through)/window,(cabin<buggy)')
				(if (& (gEgo onControl: 0) $0040)
					(Print 20 9) ; "You peek through the window, but can't make out any details."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'look/window'))
				(event claimed: 1)
				(Print 20 10) ; "You see some large windows in the carriage house."
			)
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 90
		nsLeft 143
		nsBottom 116
		nsRight 209
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 20 10) ; "You see some large windows in the carriage house."
		)
	)
)

(instance Window3 of RFeature
	(properties
		nsTop 51
		nsLeft 73
		nsBottom 72
		nsRight 114
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 20 10) ; "You see some large windows in the carriage house."
		)
	)
)

(instance Window4 of RFeature
	(properties
		nsTop 30
		nsLeft 238
		nsBottom 50
		nsRight 273
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 20 10) ; "You see some large windows in the carriage house."
		)
	)
)

(instance Box of RFeature
	(properties
		nsTop 93
		nsLeft 252
		nsBottom 143
		nsRight 289
	)

	(method (handleEvent event)
		(cond
			((Said 'look<in/box')
				(Print 20 2) ; "They're just old crates. There's nothing of interest inside them."
			)
			((or (MousedOn self event 3) (Said 'look/box'))
				(event claimed: 1)
				(Print 20 11) ; "A couple of old crates are piled in front of the carriage house."
			)
		)
	)
)

(instance myMusic of Sound
	(properties)
)


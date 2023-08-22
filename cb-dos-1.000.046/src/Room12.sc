;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
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
	Room12 0
)

(synonyms
	(ignite lamp)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance Room12 of Rm
	(properties
		picture 12
	)

	(method (init)
		(= south 23)
		(= west 17)
		(= north 6)
		(= local0 0)
		(= local2 0)
		(super init:)
		(= local6 (IsFirstTimeInRoom))
		(if gDetailLevel
			(Lamp setPri: 14 setCycle: Fwd init:)
			(Splash1 ignoreActors: 1 init: hide:)
			(Splash2 ignoreActors: 1 init: hide:)
		else
			(Lamp setPri: 14 init: stopUpd:)
		)
		(gAddToPics add: dHouse eachElementDo: #init doit:)
		(Load rsSCRIPT 985)
		(LoadMany rsSOUND 43 44 48)
		(Load rsVIEW 56)
		(self setRegions: 206 setFeatures: dHouse Window1) ; houseOReg
		(Door
			cel: (if (== gPrevRoomNum 35) 3 else 0)
			setPri: 6
			ignoreActors: 1
			init:
			stopUpd:
		)
		(= global376 Door)
		(Cellar
			cel: (if (== gPrevRoomNum 53) 3 else 0)
			ignoreActors: 1
			init:
			stopUpd:
		)
		(= gCellar Cellar)
		(if (== [gCycleTimers 2] 1)
			(= global155 17)
		)
		(if (or (and (>= gAct 1) (< gAct 5)) (== gAct 6))
			(= local1 1)
			(self setRegions: 239) ; jfeed
		else
			(= global162 0)
		)
		(if (or (== gAct 5) (> gAct 6))
			(Dish init: stopUpd:)
		)
		(myMusic number: 44 loop: 1 init:)
		(dHouse2 ignoreActors: 1 setPri: 10 init:)
		(switch gPrevRoomNum
			(6
				(gEgo posn: 318 60)
			)
			(4
				(gEgo posn: 235 55)
			)
			(17
				(gEgo posn: 1 178)
			)
			(35
				(HandsOff)
				(gEgo posn: 164 122)
				(if (not local6)
					(gEgo setMotion: MoveTo 196 145)
					(Door setCycle: Beg)
					(myMusic number: 44 loop: 1 priority: 5 play:)
				)
			)
			(53
				(gEgo posn: 272 123)
				(Cellar setCycle: Beg)
				(myMusic number: 44 loop: 1 priority: 5 play:)
			)
			(23
				(gEgo posn: 295 180)
			)
		)
		(gEgo view: 0 illegalBits: -32750 init:)
		(= global131 myMusic)
	)

	(method (doit)
		(if local6
			(= local6 0)
			(Print 12 0) ; "You are standing at the northeast corner of the house right outside the kitchen. Beside the kitchen door you see a doghouse and a cellar door."
			(if (== gPrevRoomNum 35)
				(gEgo setMotion: MoveTo 193 145)
				(Door setCycle: Beg)
				(myMusic number: 44 loop: 1 priority: 5 play:)
			)
		)
		(if (and (not local3) (== gPrevRoomNum 35) (== (Door cel:) 0))
			(= local3 1)
			(Door stopUpd:)
		)
		(if (and (& (gEgo onControl: 1) $0001) (not local5))
			(= local5 1)
			(HandsOn)
		)
		(if (& (gEgo onControl: 0) $0008)
			(gCurRoom newRoom: 4)
		)
		(if
			(and
				(& (gEgo onControl: 0) $0020)
				(not local4)
				(or (== (gEgo loop:) 1) (== (gEgo loop:) 3))
			)
			(HandsOff)
			(= local4 1)
			(gEgo setScript: myDoor2)
		)
		(if (& (gEgo onControl: 0) $0002)
			(gCurRoom newRoom: 35)
		)
		(if (== (gEgo edgeHit:) EDGE_RIGHT)
			(if (< (gEgo y:) 80)
				(gCurRoom newRoom: 6)
			else
				(gCurRoom newRoom: 18)
			)
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
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (or (== newRoomNumber 35) (== newRoomNumber 53))
			(gConMusic stop:)
			(gEgo setLoop: -1)
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
							(Print 12 0) ; "You are standing at the northeast corner of the house right outside the kitchen. Beside the kitchen door you see a doghouse and a cellar door."
						)
						((Said '/fence')
							(Print 12 1) ; "There is a small fence at the back of the house."
						)
						((Said '/path')
							(Print 12 2) ; "You notice a path behind the house."
						)
						((Said '/stair')
							(Print 12 3) ; "Stone steps lead up to the kitchen door."
						)
						((Said '/up')
							(Print 12 4) ; "You look upwards at the second-story windows of Ethel's guest room."
						)
					)
				)
				((Said 'climb/fence')
					(Print 12 5) ; "You don't need to do that. There's nothing there."
				)
				((Said 'bang/door<basement')
					(if (& (gEgo onControl: 0) $0080)
						(gEgo setScript: knockDoor)
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((or (Said 'bang/[<door,!*,*]') (Said 'bang'))
					(if (& (gEgo onControl: 0) $0080)
						(gEgo setScript: knockDoor)
					else
						(Print 12 6) ; "There's no need to knock. Just go into the house!"
					)
				)
			)
		)
	)
)

(instance LookDog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo ignoreActors: 1 setMotion: MoveTo 186 158 self)
			)
			(1
				(gEgo view: 22 loop: 0 setCycle: End self)
			)
			(2
				(gEgo loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(if global162
					(Print 12 7) ; "Well, well, look who's home! Beauregard!"
				else
					(if
						(and
							local1
							(not (gEgo has: 0)) ; necklace
							(== ((gInventory at: 0) owner:) 99) ; necklace
						)
						(Print 12 8) ; "You peer into the dark interior of the doghouse and look around. What's this?! Why, it looks like a necklace of small amethyst and quartz stones! Beauregard must have found it someplace and brought it here. You quickly grab it and take it with you."
						(= global182 1)
						(gEgo get: 0) ; necklace
					else
						(Print 12 9) ; "You peer into the dark interior of the doghouse and look around. Currently, it's empty."
					)
					(= local1 0)
				)
				(= cycles 1)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo
					loop: 0
					cel: (- (NumCels gEgo) 1)
					setCycle: Beg self
				)
			)
			(6
				(gEgo view: 0 loop: 1 ignoreActors: 0 setCycle: Walk)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance myDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(Cellar setCycle: End self)
				(myMusic number: 43 loop: 1 priority: 5 play:)
			)
			(2
				(gEgo
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 251 120 self
				)
			)
			(3
				(gEgo setMotion: MoveTo 227 125 self)
			)
			(4
				(gCurRoom newRoom: 53)
			)
		)
	)
)

(instance myDoor2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo illegalBits: 0 setMotion: MoveTo 175 136 self)
			)
			(2
				(gEgo setLoop: 1 setMotion: MoveTo 165 122 self)
			)
			(3
				(gEgo setMotion: 0 illegalBits: -32768)
				(Door cycleSpeed: 1 ignoreActors: 1 setCycle: End self)
				(myMusic number: 43 loop: 1 priority: 5 play:)
			)
			(4
				(gEgo setMotion: MoveTo (- (gEgo x:) 50) (gEgo y:))
			)
		)
	)
)

(instance knockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 267 125 self)
			)
			(1
				(gEgo view: 56 loop: 4 setMotion: 0 setCycle: End self)
			)
			(2
				(myMusic number: 48 loop: 1 play:)
				(gEgo loop: 5 setCycle: Fwd)
				(= cycles 6)
			)
			(3
				(gEgo loop: 4 cel: 3 setCycle: Beg self)
			)
			(4
				(HandsOn)
				(gEgo view: 0 loop: 1 illegalBits: -32752 setCycle: Walk)
				(if
					(or
						(and (== gAct 1) (< global155 17))
						(== gAct 3)
						(== gAct 0)
						(> gAct 4)
					)
					(Print 12 10) ; "You knock loudly on the cellar door but get no answer."
				else
					(Print 12 11) ; "Is that you, Fifi?!"
				)
				(client setScript: 0)
			)
		)
	)
)

(instance Door of Prop
	(properties
		y 122
		x 150
		view 117
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {door})
		)
	)
)

(instance Cellar of Prop
	(properties
		y 117
		x 264
		view 112
		priority 8
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(if
			(or
				(and (== gAct 1) (< global155 17))
				(== gAct 3)
				(== gAct 0)
				(> gAct 4)
			)
			(= temp0 1)
		)
		(cond
			(
				(or
					(MousedOn self event 3)
					(Said 'look/(door<basement),basement')
				)
				(event claimed: 1)
				(Print 12 12) ; "There appears to be a cellar door here."
			)
			(
				(or
					(Said '/(door<basement),basement>')
					(and (& (gEgo onControl: 0) $0080) (Said '/door>'))
				)
				(cond
					((Said '(look<in),unbar')
						(if temp0
							(Print 12 13) ; "You don't have the key."
						else
							(Print 12 14) ; "It is not locked."
						)
					)
					((Said 'open')
						(if (& (gEgo onControl: 0) $0080)
							(cond
								((not temp0)
									(HandsOff)
									(gEgo setScript: myDoor)
								)
								((!= (Cellar cel:) (Cellar lastCel:))
									(Print 12 15) ; "You try opening the cellar door but, alas, it is locked!"
								)
								(else
									(AlreadyOpen) ; "It is already open."
								)
							)
						else
							(NotClose) ; "You're not close enough."
						)
					)
				)
			)
		)
	)
)

(instance Lamp of Prop
	(properties
		y 83
		x 130
		view 112
		loop 1
		cel 1
	)

	(method (handleEvent event)
		(cond
			((Said 'get/ignite')
				(Print 12 16) ; "The porch light is firmly attached to the wall."
			)
			((or (MousedOn self event 3) (Said 'look/ignite'))
				(event claimed: 1)
				(Print 12 17) ; "A porch light shines outside the kitchen door."
			)
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

(instance dHouse2 of Prop
	(properties
		y 159
		x 168
		view 112
		loop 2
		cel 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 12 18) ; "There is a large doghouse outside the kitchen door. You see the name BEAUREGARD written over the doghouse door."
		)
	)
)

(instance dHouse of RPicView
	(properties
		y 159
		x 151
		view 112
		loop 2
		priority 12
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((Said 'look<(below,behind)/doghouse')
				(Print 12 19) ; "You see nothing there."
			)
			(
				(or
					(Said 'search,(look<in)/doghouse')
					(Said 'search,(look<in)/cabin<beauregard')
				)
				(if (gEgo inRect: 163 149 187 163)
					(HandsOff)
					(gEgo setScript: LookDog)
				else
					(NotClose) ; "You're not close enough."
				)
				(event claimed: 1)
			)
			(
				(or
					(Said 'enter,(get,go<in)/doghouse')
					(Said 'enter,(get,go<in)/cabin<beauregard')
				)
				(Print 12 20) ; "You don't want to go in the doghouse. It's dirty and smelly in there!"
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/doghouse')
					(Said 'look/cabin<beauregard')
				)
				(Print 12 18) ; "There is a large doghouse outside the kitchen door. You see the name BEAUREGARD written over the doghouse door."
				(event claimed: 1)
			)
		)
	)
)

(instance myMusic of Sound
	(properties)
)

(instance Window1 of RFeature
	(properties
		nsTop 59
		nsLeft 19
		nsBottom 141
		nsRight 46
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {window})
		)
	)
)

(instance Dish of Prop
	(properties
		y 159
		x 206
		view 112
		loop 2
		cel 2
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/dish'))
				(event claimed: 1)
				(Print 12 21) ; "The dog dish is empty."
			)
			((Said 'get/dish')
				(Print 12 22) ; "You don't want to carry a dirty, old dog dish!"
			)
		)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
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
	Room14 0
)

(local
	[local0 2]
	local2
	[local3 11]
	local14
	local15
)

(instance Room14 of Rm
	(properties
		picture 14
	)

	(method (init)
		(= west 13)
		(= east 10)
		(super init:)
		(LoadMany rsVIEW 1 25 56)
		(LoadMany rsSOUND 41 43 44 47 48 97)
		(if (not global206)
			(Load rsVIEW 47)
		)
		(Chair
			setPri: 10
			ignoreActors: 1
			cel: (if global206 2 else 0)
			init:
			stopUpd:
		)
		(Door cel: (if (== gPrevRoomNum 63) 2 else 0) init: stopUpd:)
		(Rope setPri: 14 init: stopUpd:)
		(if gDetailLevel
			(Squirel init: setScript: runAway)
			(Splash1 ignoreActors: 1 init: hide:)
			(Splash2 ignoreActors: 1 init: hide:)
		)
		(self setFeatures: Window1 Window2 Window3 Window4 Tower Chapel House)
		(if (and (>= gAct 2) (< gAct 4))
			(self setRegions: 202) ; EthelDrunk
		)
		(if (and (== gAct 6) (not (& gMustDos $0002)))
			(self setRegions: 281) ; rudywand
		)
		(switch gPrevRoomNum
			(21
				(gEgo posn: 276 188)
			)
			(20
				(gEgo posn: 48 188)
			)
			(3
				(gEgo posn: 276 100)
			)
			(9
				(gEgo posn: 76 113)
			)
			(63
				(gEgo posn: 227 132 loop: 2)
				(self setScript: myDoor)
			)
			(10
				(gEgo posn: 310 138)
			)
		)
		(gEgo view: 0 illegalBits: -32768 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 14 0) ; "You have come upon a ramshackle little playhouse. Hanging from a nearby tree you see an old rope swing. Seeing these long-ago playthings makes you wonder about the children who used to live here."
		)
		(if (& (gEgo onControl: 0) $0010)
			(gCurRoom newRoom: 3)
		)
		(if (& (gEgo onControl: 0) $0008)
			(gCurRoom newRoom: 9)
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
							posn: (- (gEgo x:) 2) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel:) 4)
						(Splash2
							posn: (- (gEgo x:) 2) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
			)
		)
		(if (== (gEgo edgeHit:) EDGE_BOTTOM)
			(if (< (gEgo x:) 192)
				(gCurRoom newRoom: 20)
			else
				(gCurRoom newRoom: 21)
			)
		)
		(if local15
			(switch (Rope cel:)
				(2
					(Chair posn: 56 126 forceUpd:)
				)
				(1
					(Chair posn: 56 128 forceUpd:)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 63)
			(gConMusic stop:)
			(gEgo illegalBits: -32768 setPri: -1 setLoop: -1)
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
							(Print 14 0) ; "You have come upon a ramshackle little playhouse. Hanging from a nearby tree you see an old rope swing. Seeing these long-ago playthings makes you wonder about the children who used to live here."
						)
						((Said '/path,(boulder<stepping)')
							(Print 14 1) ; "A little, stone path leads to the door of the playhouse."
						)
					)
				)
				((Said 'get,get,cut,untie,look/hemp')
					(Print 14 2) ; "The rope belongs to the swing."
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
				(if local2
					(gEgo illegalBits: 0 setMotion: MoveTo 236 130 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if local2
					(gEgo setPri: 8 loop: 3)
					(Door cycleSpeed: 3 setCycle: End self)
					(soundFX number: 43 loop: 1 play:)
				else
					(Door cycleSpeed: 3 setCycle: Beg self)
					(soundFX number: 44 loop: 1 play:)
				)
			)
			(2
				(Door stopUpd:)
				(if local2
					(gEgo
						view: 25
						cel: 0
						setLoop: 0
						setMotion: MoveTo 210 130
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if local2
					(if
						(and
							(== gAct 6)
							(== gPrevRoomNum 63)
							(& gMustDos $0002)
						)
						(&= gMustDos $00fb)
					)
					(gCurRoom newRoom: 63)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance comeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 56 loop: 0 setCycle: End self)
			)
			(1
				(Print 14 3 #at 40 140 #draw #dispose) ; "You rap lightly on the playhouse door."
				(soundFX number: 48 loop: 1 play:)
				(gEgo loop: 2 setCycle: Fwd)
				(= cycles 14)
			)
			(2
				(cls)
				(gEgo view: 56 loop: 0 cel: 3 setCycle: Beg self)
			)
			(3
				(if (== gAct 6)
					(Print 14 4) ; "You hear a muffled reply."
				else
					(Print 14 5) ; "Is that you, Laura? Come in and join me."
				)
				(= cycles 1)
			)
			(4
				(= local2 1)
				(gEgo view: 0 setCycle: Walk setScript: myDoor)
				(client setScript: 0)
			)
		)
	)
)

(instance swinging of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global206 1)
				(gEgo setMotion: MoveTo 52 144 self)
			)
			(1
				(Print 14 6 #at 90 10 #dispose) ; "Gingerly, you sit in the swing."
				(gEgo
					view: 47
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 0 setMotion: MoveTo 52 147)
				(Chair setCel: 0 setMotion: MoveTo 56 128)
				(Rope setCycle: End self)
			)
			(3
				(soundFX number: 41 loop: 1 play:)
				(gEgo loop: 1 cel: 0 cycleSpeed: 0 setCycle: End self)
				(Chair setCycle: End)
			)
			(4
				(cls)
				(soundFX number: 47 loop: 1 play:)
				(= local15 1)
				(Rope setCycle: Fwd)
				(ShakeScreen 5 5) ; ssUPDOWN | $0004
				(= cycles 14)
			)
			(5
				(= local15 0)
				(Rope setCycle: Beg)
				(gEgo loop: 2 cel: 0 setCycle: Fwd)
				(soundFX number: 97 loop: 1 play:)
				(= seconds 5)
			)
			(6
				(cls)
				(Chair stopUpd:)
				(Rope stopUpd:)
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(7
				(gEgo view: 0 loop: 2 setLoop: -1 setCycle: Walk)
				(= cycles 2)
			)
			(8
				(Print 14 7) ; "How embarrassing!"
				(HandsOn)
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
				(Squirel posn: (+ (Squirel x:) 23) (Squirel y:))
				(if (< (++ local14) 3)
					(= state 0)
				)
				(= cycles 1)
			)
			(3
				(Squirel loop: 2 cycleSpeed: 2 setCycle: Fwd)
				(= cycles 7)
			)
			(4
				(Squirel loop: 0 cycleSpeed: 0 setCycle: End self)
			)
			(5
				(Squirel posn: (+ (Squirel x:) 23) (Squirel y:))
				(if (< (++ local14) 5)
					(= state 3)
				)
				(= cycles 1)
			)
			(6
				(Squirel dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance noOneHome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 56 loop: 0 setCycle: End self)
			)
			(1
				(gEgo loop: 2 setCycle: Fwd)
				(= cycles 12)
				(soundFX number: 48 loop: 1 play:)
			)
			(2
				(cls)
				(Print 14 8) ; "You rap lightly on the playhouse door. There is no reply."
				(gEgo view: 56 loop: 0 cel: 3 setCycle: Beg self)
			)
			(3
				(HandsOn)
				(gEgo view: 0 setCycle: Walk loop: 3)
				(client setScript: 0)
			)
		)
	)
)

(instance Squirel of Prop
	(properties
		y 111
		x 12
		view 206
	)

	(method (handleEvent event)
		(cond
			((Said 'get,capture/squirrel')
				(Print 14 9) ; "They are very difficult to catch."
			)
			((or (MousedOn self event 3) (Said 'look/squirrel'))
				(event claimed: 1)
				(Print 14 10) ; "You have frightened off a little squirrel."
			)
		)
	)
)

(instance Rope of Prop
	(properties
		y 62
		x 100
		view 114
		loop 2
	)
)

(instance Chair of Act
	(properties
		y 126
		x 56
		view 114
	)

	(method (handleEvent event)
		(cond
			((Said 'press/swing')
				(Print 14 11) ; "It would be silly to push the swing with nobody in it."
			)
			(
				(or
					(Said 'swing')
					(Said 'go,climb,(get<(in,on))/swing')
					(Said 'sit[/swing]')
				)
				(cond
					(global206
						(Print 14 12) ; "You broke it!"
					)
					((gEgo inRect: 27 140 77 167)
						(gEgo setScript: swinging)
					)
					(else
						(NotClose) ; "You're not close enough."
					)
				)
			)
			((Said 'get/swing')
				(Print 14 13) ; "It would be silly to carry around an old swing."
			)
			((or (MousedOn self event 3) (Said 'look/swing'))
				(event claimed: 1)
				(if global206
					(Print 14 14) ; "The broken swing hangs from a nearby oak."
				else
					(Print 14 15) ; "A charming, old swing hangs from a nearby oak."
				)
			)
		)
	)
)

(instance Door of Prop
	(properties
		y 125
		x 232
		view 114
		loop 1
		priority 5
	)

	(method (handleEvent event)
		(cond
			((Said 'break/door')
				(Print 14 16) ; "Force will not work on this strong little door."
			)
			((Said 'unbar/door')
				(if (>= gAct 7)
					(Print 14 17) ; "It's already unlocked."
				else
					(Print 14 18) ; "You can't. You don't have the key."
				)
			)
			((Said 'bang[/door]')
				(if (& (gEgo onControl: 1) $0002)
					(if
						(or
							(== gAct 2)
							(and (== gAct 6) (not (& gMustDos $0002)))
						)
						(HandsOff)
						(gEgo setScript: comeIn)
					else
						(HandsOff)
						(gEgo setScript: noOneHome)
					)
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((Said 'open/door')
				(if (& (gEgo onControl: 1) $0002)
					(if (>= gAct 2)
						(= local2 1)
						(gEgo setScript: myDoor)
					else
						(Print 14 19) ; "You attempt to open the playhouse door but discover it's locked."
					)
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'look/door'))
				(event claimed: 1)
				(Print 14 20) ; "You'll have to stoop to get through that door!"
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

(instance Window1 of RFeature
	(properties
		nsTop 83
		nsLeft 133
		nsBottom 95
		nsRight 144
	)

	(method (handleEvent event)
		(cond
			((Said 'look<(in,through)/window,playhouse')
				(if (& (gEgo onControl: 0) $0040)
					(Print 14 21) ; "You peek through the window, but can't make out any details."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((Said 'break/window')
				(Print 14 22) ; "It would do you no good as the windows are very small."
			)
			((Said 'open/window')
				(Print 14 23) ; "The windows do not open."
			)
			((or (MousedOn self event 3) (Said 'look/window'))
				(event claimed: 1)
				(Print 14 24) ; "Little, round windows adorn the playhouse."
			)
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 93
		nsLeft 164
		nsBottom 108
		nsRight 176
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 14 24) ; "Little, round windows adorn the playhouse."
		)
	)
)

(instance Window3 of RFeature
	(properties
		nsTop 95
		nsLeft 195
		nsBottom 106
		nsRight 207
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 14 24) ; "Little, round windows adorn the playhouse."
		)
	)
)

(instance Window4 of RFeature
	(properties
		nsTop 87
		nsLeft 240
		nsBottom 99
		nsRight 251
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 14 24) ; "Little, round windows adorn the playhouse."
		)
	)
)

(instance Tower of RFeature
	(properties
		nsTop 21
		nsLeft 242
		nsBottom 45
		nsRight 252
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/tower'))
			(event claimed: 1)
			(Print 14 25) ; "You see the bell tower in the distance to the north."
		)
	)
)

(instance Chapel of RFeature
	(properties
		nsTop 29
		nsLeft 106
		nsBottom 46
		nsRight 130
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/chapel'))
			(event claimed: 1)
			(Print 14 26) ; "You see the little chapel in the distance to the north."
		)
	)
)

(instance House of RFeature
	(properties
		nsTop 47
		nsLeft 131
		nsBottom 121
		nsRight 255
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/playhouse,cabin'))
			(event claimed: 1)
			(Print 14 27) ; "This is an old playhouse that some long-ago children played in."
		)
	)
)

(instance soundFX of Sound
	(properties
		number 48
		priority 3
	)
)


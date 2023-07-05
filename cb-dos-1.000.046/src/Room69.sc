;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 69)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room69 0
)

(synonyms
	(butler man person)
	(room barn)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance Room69 of Rm
	(properties
		picture 69
	)

	(method (init)
		(super init:)
		(gAddToPics add: saddle trough bridle eachElementDo: #init doit:)
		(self
			setFeatures: saddle trough bridle hay1 hay2 window1 window2 window3
		)
		(LoadMany rsSOUND 40 85 118)
		(LoadMany rsVIEW 269 63)
		(if (gEgo has: 17) ; carrot
			(Load rsVIEW 8)
		)
		(myMusic number: 40 loop: 1)
		(if (and (not gWilburCorpseRoomNum) (>= gAct 2))
			(if (or (== gAct 6) (== (Random 1 2) 1))
				(= gWilburCorpseRoomNum 69)
			else
				(= gWilburCorpseRoomNum 58)
			)
		)
		(if
			(and
				(== gWilburCorpseRoomNum 69)
				(not (& gCorpseFlags $0002)) ; Wilbur
				(not (& gCorpseFlags $0040)) ; Lillian
			)
			(self setRegions: 256) ; Dwilb
		)
		(Door init: ignoreActors: 1 stopUpd:)
		(if (== ((gInventory at: 2) owner:) 69) ; lantern
			(Lamp init: stopUpd:)
		)
		(if (and (== gAct 1) (or (== global155 6) (== global155 7)))
			(Jeeves init:)
			(HandsOff)
			(self setScript: feedNag)
		else
			(HandsOn)
		)
		(Horse setPri: 9 init: stopUpd:)
		(Ears setPri: 9 init:)
		(Leg setPri: 9 init: stopUpd:)
		(Tail setPri: 9 init: stopUpd:)
		(Head setPri: 9 init: stopUpd:)
		(gEgo view: 0 posn: 211 170 illegalBits: -32752 init:)
		(if (== gAct 1)
			(Load rsVIEW 440)
			(Load rsVIEW 445)
			(Load rsVIEW 452)
			(Hay init:)
		)
	)

	(method (newRoom newRoomNumber)
		(if (gCast contains: Jeeves)
			(= [gCycleTimers 2] 1050)
			(= global155 7)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit &tmp temp0)
		(if (IsFirstTimeInRoom)
			(Print 69 0) ; "There is only one stall in this old stable. As there is an old, broken-down nag in the stall, you deduce this must be Blaze."
		)
		(if (and local0 (& (gEgo onControl: 1) $0001) (not script))
			(Room69 setScript: myDoor)
		)
		(if (and (== [gCycleTimers 2] 1100) (== gAct 1))
			(if (not script)
				(= local4 1)
				(HandsOff)
				(self setScript: feedNag)
			else
				(= [gCycleTimers 2] 1110)
			)
		)
		(if (not local1)
			(cond
				((== (= temp0 (Random 1 25)) 1)
					(cond
						((== (Ears cel:) 0)
							(Ears setCycle: End)
						)
						((== (Ears cel:) (- (NumCels Ears) 1))
							(Ears setCycle: Beg)
						)
					)
				)
				((and gDetailLevel (> temp0 2) (< temp0 6))
					(cond
						((== (Tail cel:) 0)
							(Tail setCycle: End)
						)
						((== (Tail cel:) (- (NumCels Tail) 1))
							(Tail setCycle: Beg)
						)
					)
				)
				((and gDetailLevel (> temp0 5) (< temp0 8))
					(cond
						((== (Leg cel:) 0)
							(Leg setCycle: End)
						)
						((== (Leg cel:) (- (NumCels Leg) 1))
							(Leg setCycle: Beg)
						)
					)
				)
			)
		)
		(if (and (not local1) (not local3))
			(= local3 (Random 30 80))
			(myMusic number: 40 loop: 1 play:)
		)
		(-- local3)
		(if (& (gEgo onControl: 0) $0002)
			(HandsOff)
			(gCurRoom newRoom: 13)
		)
		(if
			(and
				(< (gEgo distanceTo: Horse) 65)
				(> (gEgo y:) 140)
				(!= ((gInventory at: 17) owner:) 69) ; carrot
				(== local0 1)
				(== local1 0)
			)
			(= local1 1)
			(self setScript: kicked)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 69 0) ; "There is only one stall in this old stable. As there is an old, broken-down nag in the stall, you deduce this must be Blaze."
						)
						((Said '/door')
							(Print 69 1) ; "The door leads out front."
						)
						((Said '/room')
							(if (== ((gInventory at: 2) owner:) 69) ; lantern
								(Print 69 2) ; "You see an old, sway-backed horse in the stall. Behind the horse, hanging on the wall, is a lantern."
							else
								(Print 69 3) ; "You see an old, sway-backed horse in the stall."
							)
						)
						((or (Said '/dirt,dirt') (Said '<down'))
							(Print 69 4) ; "The stable floor is littered with hay."
						)
						((Said '/wall')
							(if (== ((gInventory at: 2) owner:) 69) ; lantern
								(Print 69 5) ; "A lantern hangs from the wall inside the stall."
							else
								(Print 69 6) ; "You look carefully at the walls around you, but see nothing special about them."
							)
						)
						((or (Said '/ceiling') (Said '<up'))
							(Print 69 7) ; "You look up at the ceiling but see nothing of interest."
						)
					)
				)
				((Said 'feel,get/lantern/cane')
					(if (gEgo has: 21) ; cane
						(Print 69 8) ; "The cane is not quite long enough."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'climb/wall,room')
					(Print 69 9) ; "The horse might bite you if you tried that!"
				)
				((Said 'open/window')
					(Print 69 10) ; "The windows do not open."
				)
				((Said 'break/window')
					(Print 69 11) ; "There is no reason to do that."
				)
			)
		)
	)
)

(instance feedHorse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 150 138 self
				)
			)
			(1
				(LookAt gEgo Horse)
				(gEgo
					view: 8
					cel: 0
					loop: 0
					setAvoider: 0
					setCycle: End self
				)
			)
			(2
				(Print 69 12) ; "You hold the carrot in front of Blaze's nose who begins to cautiously sniff at it. He then gently takes it into his mouth and eats it. He looks at you and whinnies softly as if in friendship."
				(gEgo cel: 0 loop: 1 setCycle: End self)
			)
			(3
				(gEgo cel: 0 loop: 2 setCycle: End self)
				(Mouth setPri: 9 cycleSpeed: 3 setCycle: Fwd init:)
			)
			(4
				(gEgo put: 17 69) ; carrot
				(gEgo view: 0 loop: 1 setCycle: Walk)
				(HandsOn)
				(= seconds 5)
			)
			(5
				(Mouth dispose:)
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
				(HandsOff)
				(gEgo
					ignoreActors: 0
					setAvoider: (Avoid new:)
					setMotion: MoveTo 140 142 self
				)
			)
			(1
				(LookAt gEgo Horse)
				(if (== local0 0)
					(= local0 1)
					(Door setPri: 13 cycleSpeed: 3 setCycle: End self)
					(gEgo ignoreControl: 16 observeControl: 32)
				else
					(= local0 0)
					(Door setPri: 10 cycleSpeed: 3 setCycle: Beg self)
					(gEgo ignoreControl: 32 observeControl: 16)
				)
			)
			(2
				(gEgo setAvoider: 0)
				(Door stopUpd:)
				(if (!= ((gInventory at: 17) owner:) 69) ; carrot
					(Room69 setScript: kicked)
				else
					(HandsOn)
					(client setScript: 0)
				)
			)
		)
	)
)

(instance kicked of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 1) (== local2 0) (== (Horse cel:) 4))
			(= local2 1)
			(gEgo
				view: 269
				setLoop: 1
				cel: 0
				illegalBits: 0
				cycleSpeed: 1
				setCycle: End
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 130 142 self)
			)
			(1
				(HandsOff)
				(Tail hide:)
				(Leg hide:)
				(Head hide:)
				(Ears hide:)
				(Horse
					view: 269
					loop: 0
					cel: 0
					cycleSpeed: 1
					setPri: 12
					startUpd:
					setCycle: End self
				)
				(myMusic number: 85 loop: 1 play:)
			)
			(2
				(Horse setPri: 9 stopUpd:)
				(= cycles 21)
			)
			(3
				(= global128 269)
				(= global129 2)
				(= global130 2)
				(= global127 1)
				(EgoDead 69 13) ; "You're a DEAD ringer, Laura!"
				(client setScript: 0)
			)
		)
	)
)

(instance feedNag of Script
	(properties)

	(method (doit)
		(if (and (== state 3) (== (Jeeves cel:) 3))
			(Hay posn: 104 145 setPri: 9 setCycle: End show:)
		)
		(if (and (== state 1) (== (Jeeves cel:) 4))
			(Hay hide:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo inRect: 109 138 200 150)
					(gEgo setMotion: MoveTo 160 135)
				)
				(if (gEgo inRect: 200 139 259 150)
					(gEgo setMotion: MoveTo 259 143)
				)
				(if (gEgo inRect: 204 151 263 200)
					(gEgo setMotion: MoveTo 189 153)
				)
				(if local4
					(Jeeves
						view: 440
						posn: 220 170
						setCycle: Walk
						setMotion: MoveTo 238 145 self
						init:
					)
				else
					(= cycles 1)
				)
			)
			(1
				(Jeeves view: 445 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(Jeeves
					view: 452
					setCycle: Walk
					setLoop: 0
					setMotion: MoveTo 124 145 self
				)
			)
			(3
				(Jeeves view: 445 setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(Jeeves
					view: 440
					setLoop: -1
					setCycle: Walk
					setAvoider: (Avoid new:)
					setMotion: MoveTo 193 145 self
				)
				(if (gEgo inRect: 200 162 227 176)
					(gEgo setMotion: MoveTo 186 170)
				)
			)
			(5
				(Jeeves setMotion: MoveTo 220 170 self)
			)
			(6
				(HandsOn)
				(= global155 8)
				(= [gCycleTimers 2] (- 1700 (* 8 100)))
				(Jeeves dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance petHorse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 145 138 self
				)
			)
			(1
				(LookAt gEgo Horse)
				(gEgo
					view: 63
					cel: 0
					loop: 0
					setAvoider: 0
					setCycle: End self
				)
			)
			(2
				(gEgo cel: 0 loop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(if (== ((gInventory at: 17) owner:) 69) ; carrot
					(Print 69 14) ; "You gently stroke Blaze's soft nose. He seems to like that."
				else
					(Print 69 15) ; "As you stroke Blaze's velvety-soft nose, his eyes open wide and his ears twitch uncontrollably."
					(Ears setCycle: End)
				)
				(gEgo cel: 0 loop: 2 setCycle: End self)
			)
			(4
				(gEgo view: 0 loop: 1 setCycle: Walk)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance saddle of RPicView
	(properties
		y 109
		x 268
		view 169
		loop 1
		cel 2
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(Said 'detach,use,get/saddle')
					(Said 'attach/saddle')
					(Said 'saddle/blaze')
				)
				(Print 69 16) ; "The saddle is very heavy. Besides, you've never been fond of horseback riding."
			)
			((or (MousedOn self event 3) (Said 'look/saddle'))
				(event claimed: 1)
				(Print 69 17) ; "You see an old saddle hanging on the wall."
			)
		)
	)
)

(instance trough of RPicView
	(properties
		y 153
		x 73
		view 169
		loop 1
		cel 1
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/trough,water'))
			(event claimed: 1)
			(Print 69 18) ; "Why, that's Blaze's drinking water!"
		)
	)
)

(instance bridle of RPicView
	(properties
		y 96
		x 142
		view 169
		loop 1
		cel 3
	)

	(method (handleEvent event)
		(cond
			((Said 'detach,use,get/bit')
				(Print 69 19) ; "The bridle doesn't belong to you. Besides, you've never been fond of horseback riding."
			)
			((or (MousedOn self event 3) (Said 'look/bit'))
				(event claimed: 1)
				(Print 69 20) ; "That must be Blaze's old bridle."
			)
		)
	)
)

(instance Door of Prop
	(properties
		y 147
		x 100
		view 169
		priority 9
	)

	(method (handleEvent event)
		(cond
			((Said 'enter,(go<in)/room,archway')
				(Print 69 21) ; "Go ahead! Just open the stall!"
			)
			((Said 'open,enter,(go<in)/room,archway')
				(if (& (gEgo onControl: 0) $0004)
					(if (== local0 0)
						(Room69 setScript: myDoor)
					else
						(AlreadyOpen) ; "It is already open."
					)
				else
					(Print 69 22) ; "You can't from here."
				)
			)
			((Said 'close/archway,room')
				(if (== local0 1)
					(Room69 setScript: myDoor)
				else
					(AlreadyClosed) ; "It is already closed."
				)
			)
			((or (MousedOn self event 3) (Said 'look/archway,room'))
				(event claimed: 1)
				(Print 69 23) ; "A gate leads into the stall."
			)
		)
	)
)

(instance Lamp of Prop
	(properties
		y 110
		x 42
		view 169
		loop 1
		priority 7
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/lantern,lamp,ignite'))
				(event claimed: 1)
				(Print 69 5) ; "A lantern hangs from the wall inside the stall."
			)
			((Said 'get/lantern,ignite')
				(if (< (gEgo distanceTo: Lamp) 45)
					(Lamp dispose:)
					(= global182 1)
					(gEgo get: 2) ; lantern
				else
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance Hay of Prop
	(properties
		y 141
		x 228
		view 445
		loop 3
		cel 4
	)
)

(instance Leg of Prop
	(properties
		y 141
		x 104
		view 169
		loop 4
		signal 16384
		cycleSpeed 2
	)
)

(instance Tail of Prop
	(properties
		y 104
		x 62
		view 169
		loop 3
		signal 16384
		cycleSpeed 2
	)
)

(instance Ears of Prop
	(properties
		y 94
		x 119
		view 169
		loop 5
		signal 16384
	)
)

(instance Mouth of Prop
	(properties
		y 105
		x 105
		view 8
		loop 3
	)
)

(instance Head of Prop
	(properties
		y 108
		x 99
		view 169
		loop 2
		cel 1
	)
)

(instance Horse of Prop
	(properties
		y 140
		x 51
		view 169
		loop 2
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/blaze'))
				(event claimed: 1)
				(Print 69 24) ; "Blaze must have once been a beautiful stallion, but now, with many passing years, he has been reduced to an old broken-down nag. You guess that he must be the Colonel's horse."
			)
			((or (Said 'bit/blaze') (Said 'attach,attach/bit/blaze'))
				(Print 69 25) ; "This isn't King's Quest IV!"
			)
			((Said '(feed,give,show)>')
				(cond
					((Said '/carrot')
						(cond
							((== ((gInventory at: 17) owner:) 69) ; carrot
								(Print 69 26) ; "You already fed him."
							)
							((gEgo has: 17) ; carrot
								(if (& (gEgo onControl: 0) $0004)
									(Room69 setScript: feedHorse)
								else
									(NotClose) ; "You're not close enough."
								)
							)
							(else
								(DontHave) ; "You don't have it."
							)
						)
					)
					((Said '/(bale[<blaze]),blaze')
						(Print 69 27) ; "Blaze is tired of hay. He's not interested."
					)
					((Said '/food')
						(Print 69 28) ; "You don't have anything to feed to Blaze."
					)
					((Said '/*')
						(event claimed: 1)
						(if (and global219 global224)
							(Print 69 29) ; "Blaze isn't interested."
						else
							(DontHave) ; "You don't have it."
						)
					)
				)
			)
			((Said 'ask[/blaze]/c<about')
				(myEd number: 118 loop: 1 play:)
				(Print 69 30) ; "A horse is a horse of course. But Wilbur is just imaginary."
			)
			((Said 'ask,tell[/blaze]/*<about')
				(Print 69 31) ; "The horse doesn't understand you!"
			)
			((Said '/blaze>')
				(cond
					((Said 'talk')
						(Print 69 32) ; "You gently speak to Blaze. He just looks at you with his big, brown eyes."
					)
					((Said '(get<on),mount,mount,climb')
						(Print 69 33) ; "You don't like to ride horses, remember?"
					)
					((Said 'guide,move,press,get,get')
						(if (== ((gInventory at: 17) owner:) 69) ; carrot
							(Print 69 34) ; "Blaze seems happy right where he is."
						else
							(Print 69 21) ; "Go ahead! Just open the stall!"
						)
					)
					((Said 'feed,give/carrot')
						(cond
							((== ((gInventory at: 17) owner:) 69) ; carrot
								(Print 69 26) ; "You already fed him."
							)
							((gEgo has: 17) ; carrot
								(if (& (gEgo onControl: 0) $0004)
									(Room69 setScript: feedHorse)
								else
									(NotClose) ; "You're not close enough."
								)
							)
							(else
								(Print 69 28) ; "You don't have anything to feed to Blaze."
							)
						)
					)
					((Said 'yell')
						(Print 69 35) ; "You yell at the horse and he twitches his ears."
					)
					((Said 'kiss')
						(if (== ((gInventory at: 17) owner:) 69) ; carrot
							(Print 69 36) ; "You plant a big kiss on Blaze's nose. He looks at you curiously."
						else
							(Print 69 37) ; "That's not a nice thought, Laura!"
						)
					)
					((Said 'kill')
						(Print 69 38) ; "You have to move closer to do that."
					)
					((Said 'pat,pat')
						(if (< (gEgo distanceTo: Horse) 105)
							(Room69 setScript: petHorse)
						else
							(NotClose) ; "You're not close enough."
						)
					)
				)
			)
		)
	)
)

(instance Jeeves of Act
	(properties
		y 145
		x 238
		view 440
	)

	(method (handleEvent)
		(cond
			((Said 'look/butler')
				(Print 69 39) ; "Jeeves seems to be busy doing his chores."
			)
			((Said '*/butler')
				(Print 69 40) ; "You attempt to talk to Jeeves but he ignores you as he goes about his business."
			)
		)
	)
)

(instance myMusic of Sound
	(properties)
)

(instance myEd of Sound
	(properties)
)

(instance hay1 of RFeature
	(properties
		nsTop 145
		nsLeft 137
		nsBottom 163
		nsRight 169
	)

	(method (handleEvent event)
		(cond
			((or (Said 'drink[/water]') (Said 'get/drink'))
				(Print 69 41) ; "Not that water!"
			)
			((Said 'get/water')
				(Print 69 42) ; "You have no need to carry water."
			)
			((Said 'look<in/water,trough')
				(Print 69 43) ; "There is only water in the trough."
			)
			((Said 'get/bale')
				(Print 69 44) ; "You don't want to carry hay around!"
			)
			((Said 'search,(look<in)/bale')
				(if (gEgo inRect: 193 128 241 142)
					(Print 69 45) ; "It's just hay, nothing more."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'look/bale'))
				(event claimed: 1)
				(Print 69 46) ; "Bales of hay have been haphazardly piled around."
			)
		)
	)
)

(instance hay2 of RFeature
	(properties
		nsTop 118
		nsLeft 207
		nsBottom 135
		nsRight 238
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 69 46) ; "Bales of hay have been haphazardly piled around."
		)
	)
)

(instance window1 of RFeature
	(properties
		nsTop 62
		nsLeft 171
		nsBottom 81
		nsRight 198
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said '/window'))
			(event claimed: 1)
			(Print 69 47) ; "You can see the dark night out the stable windows."
		)
	)
)

(instance window2 of RFeature
	(properties
		nsTop 69
		nsLeft 213
		nsBottom 87
		nsRight 241
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 69 47) ; "You can see the dark night out the stable windows."
		)
	)
)

(instance window3 of RFeature
	(properties
		nsTop 8
		nsLeft 69
		nsBottom 26
		nsRight 95
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 69 47) ; "You can see the dark night out the stable windows."
		)
	)
)


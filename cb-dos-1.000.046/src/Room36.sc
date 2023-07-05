;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room36 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(instance Room36 of Rm
	(properties
		picture 36
	)

	(method (init)
		(super init:)
		(= east 37)
		(= local6 (IsFirstTimeInRoom))
		(Load rsVIEW 16)
		(LoadMany rsSOUND 43 44 74 75)
		(= global120 0)
		(if
			(or
				(and (== gAct 0) (== global199 2))
				(and (!= gClarenceWilburState 4) (== gAct 1))
				(== gAct 2)
			)
			(LoadMany rsSOUND 200 201 202 203 204)
		)
		(self
			setFeatures:
				phono
				harp
				tromb
				trump
				item
				Piano
				bookcase
				mandolin
				cues
				ship
				billiard
				wingback
				sofa1
				sofa2
				table1
				table2
				portrait
		)
		(if gDetailLevel
			(lamp1 setCycle: Fwd init:)
			(lamp2 setCycle: Fwd init:)
		else
			(lamp1 init: stopUpd:)
			(lamp2 init: stopUpd:)
		)
		(Fdoor cel: (if (== gPrevRoomNum 15) 2 else 0) init: stopUpd:)
		(= global373 Fdoor)
		(Bdoor cel: (if (== gPrevRoomNum 15) 2 else 0) init: stopUpd:)
		(= global374 Bdoor)
		(panel x: (if (== gPrevRoomNum 49) 146 else 141) init: stopUpd:)
		(crank_ init: stopUpd:)
		(keys init: hide:)
		(roll init: stopUpd:)
		(switch gAct
			(0
				(if (and (not (& gSpyFlags $0001)) (== [gCycleTimers 0] 1))
					(= [gCycleTimers 0] 0)
					(= [gCycleTimers 2] 1800)
					(|= gSpyFlags $0001)
					(= global199 1)
				)
				(if (and (== global199 1) (== [gCycleTimers 2] 1))
					(= [gCycleTimers 2] 0)
					(= global199 2)
				)
				(switch global199
					(0
						(= local3 1)
						(self setRegions: 232) ; grargue
					)
					(2
						(= local3 1)
						(= local0 1)
						(self setRegions: 233) ; glorplay
					)
				)
			)
			(1
				(= local3 1)
				(if (or (== gClarenceWilburState 4) (== [gCycleTimers 0] 1))
					(= gClarenceWilburState 4)
					(= [gCycleTimers 0] 0)
					(self setRegions: 245) ; billiard
					(balls priority: 7)
				else
					(= local0 1)
					(= global199 2)
					(self setRegions: 233) ; glorplay
				)
			)
			(2
				(= local3 1)
				(= local0 1)
				(self setRegions: 233) ; glorplay
			)
			(3
				(if (not (& global141 $0004))
					(self setRegions: 382) ; sweeping
				)
			)
			(else
				(= local3 0)
			)
		)
		(gAddToPics
			add:
				balls
				phono
				sofa1
				sofa2
				table1
				table2
				portrait
				wingback
				harp
				tromb
				trump
				mandolin
				cues
				bookcase
				ship
				rim
				billiard
				item
			eachElementDo: #init
			doit:
		)
		(if (!= gPrevRoomNum 49)
			(if (== gPrevRoomNum 37)
				(gEgo posn: 305 98)
			else
				(gEgo posn: 60 119)
				(if (not local6)
					(gEgo setMotion: MoveTo 68 119)
					(= global202 2)
				)
			)
			(gEgo view: 0 illegalBits: -32764 setPri: -1 init:)
		else
			(gEgo
				view: 0
				illegalBits: -32764
				setPri: 2
				loop: 2
				posn: 126 79
				init:
			)
			(gEgo posn: 138 79)
			(self setScript: enterPanel)
		)
	)

	(method (doit)
		(if (and (== gAct 3) (== global217 0))
			(Print 36 0) ; "Things look suspicious here! You can see pieces of a broken record on the floor by the Victrola and a small pile of pink feathers near it."
			(= global217 1)
		)
		(if (and (== gAct 3) (== global374 1))
			(= local3 1)
		)
		(if (and (== gAct 3) (== global374 0))
			(= local3 0)
		)
		(if local6
			(Print 36 1) ; "You have found the Colonel's billiard room. Funny, he doesn't seem to be the kind of guy who would enjoy playing billiards, listening to records on the Victrola, or the player piano."
			(if (== gPrevRoomNum 15)
				(gEgo setMotion: MoveTo 68 119)
				(= global202 2)
			)
			(= local6 0)
		)
		(if (and (or (== global202 1) (== global202 2)) (not (Fdoor script:)))
			(Fdoor setScript: DoorFunc)
		)
		(if (not script)
			(cond
				((& (gEgo onControl: 0) $0008)
					(if (== (gEgo loop:) 1)
						(gEgo setPri: 8)
						(HandsOff)
						(self setScript: myDoor)
					)
				)
				((gEgo inRect: 46 120 55 131)
					(gEgo setPri: 10)
				)
				((not local5)
					(gEgo setPri: -1)
				)
			)
		)
		(if (& (gEgo onControl: 1) $0004)
			(gEgo illegalBits: -32768 ignoreActors: 0)
			(gCurRoom newRoom: 15)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0020)
				(== local3 0)
				(== global204 0)
			)
			(gCurRoom newRoom: 49)
		)
		(if (< (gEgo x:) 190)
			(= vertAngle 44)
		else
			(= vertAngle 10)
		)
		(super doit:)
	)

	(method (dispose)
		(if (< global160 4)
			(++ global160)
		else
			(= global160 0)
		)
		(DisposeScript 204)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(cls)
		(= global190 0)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(DisposeScript 990)
			(if
				(or
					(Said 'play/game,billiard')
					(Said 'ask/*/(game,billiard)<play<to')
				)
				(Print 36 2) ; "Although your father is an excellent billiards player, you never learned the game."
			)
			(= local8
				(if
					(or
						(!= global208 260)
						(and
							(not (Said 'ask[/rudolph]/actress<about>'))
							(not (Said 'ask[/actress]/rudolph<about>'))
						)
					)
					(or
						(not (& global208 $0044))
						(not (Said 'tell[/actress,attorney]/gertie<about>'))
						(not (& gCorpseFlags $0001)) ; Gertie
						(& global145 $0002)
					)
				)
			)
			(if
				(and
					global208
					local8
					(Said
						'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>'
					)
				)
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
				(if (event claimed:)
					(return)
				)
			)
			(cond
				((Said '/panel,(door<hidden)>')
					(cond
						((and (& global175 $0004) (Said 'open,move'))
							(if (not local3)
								(if (& (gEgo onControl: 0) $0010)
									(HandsOff)
									(self setScript: exiting)
								else
									(NotClose) ; "You're not close enough."
								)
							else
								(Print 36 3) ; "You better not while others are in the room."
							)
						)
						((Said 'look')
							(if (& global175 $0004)
								(Print 36 4) ; "Even though you know where it is, you can't see it."
							else
								(Print 36 5) ; "You don't see one."
							)
						)
					)
				)
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(if (== gAct 3)
								(if (not (& global141 $0004))
									(if (gEgo has: 9) ; broken_record
										(Print 36 6) ; "There is small pile of pink feathers on the floor along with some mud spots."
									else
										(Print 36 0) ; "Things look suspicious here! You can see pieces of a broken record on the floor by the Victrola and a small pile of pink feathers near it."
									)
								else
									(Print 36 1) ; "You have found the Colonel's billiard room. Funny, he doesn't seem to be the kind of guy who would enjoy playing billiards, listening to records on the Victrola, or the player piano."
								)
							else
								(Print 36 1) ; "You have found the Colonel's billiard room. Funny, he doesn't seem to be the kind of guy who would enjoy playing billiards, listening to records on the Victrola, or the player piano."
							)
						)
						((Said '/ball[<billiard]')
							(Print 36 7) ; "You see three balls on the billiard table; two red and one white."
						)
						((Said '/bench[<piano]')
							(Print 36 8) ; "It's just a common piano bench."
						)
						((or (Said '/dirt') (Said '<down'))
							(if (== gAct 3)
								(cond
									((gEgo has: 9) ; broken_record
										(if (not (& global141 $0004))
											(Print 36 6) ; "There is small pile of pink feathers on the floor along with some mud spots."
										else
											(event claimed: 0)
										)
									)
									((not (& global141 $0004))
										(Print 36 9) ; "There are pieces of a broken record, a small pile of pink feathers, and some mud spots on the floor."
									)
									(else
										(event claimed: 0)
									)
								)
							else
								(event claimed: 0)
							)
						)
						((Said '/door')
							(Print 36 10) ; "The French doors lead outside."
						)
						((Said '/record')
							(cond
								((gEgo has: 9) ; broken_record
									(event claimed: 0)
								)
								((< (gEgo distanceTo: phono) 20)
									(Print 36 11) ; "Oh! One of your favorites!"
								)
								(else
									(NotClose) ; "You're not close enough."
								)
							)
						)
					)
				)
				((Said 'get/ball')
					(Print 36 12) ; "You don't need any billiard balls."
				)
			)
		)
	)
)

(instance exiting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local5 1)
				(= global204 1)
				(panel setMotion: MoveTo 170 83 self)
				(gEgo illegalBits: -32768)
				(soundFX number: 74 loop: 1 play:)
			)
			(1
				(if (gEgo inRect: 137 87 139 89)
					(= cycles 1)
				else
					(gEgo illegalBits: -32768 setMotion: MoveTo 138 88 self)
				)
			)
			(2
				(gEgo setMotion: MoveTo 138 79 self)
			)
			(3
				(gEgo setPri: 2)
				(panel setMotion: MoveTo 141 83 self)
				(soundFX number: 75 loop: 1 play:)
			)
			(4
				(HandsOn)
				(= global204 0)
				(client setScript: 0)
			)
		)
	)
)

(instance playPiano of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(HandsOff)
				(gEgo ignoreControl: -32768)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 137 89 self)
			)
			(2
				(gEgo view: 16 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(crank_ hide:)
				(if (== global120 0)
					(= global120 1)
				)
				(windMusic loop: -1 play:)
				(gEgo loop: 0 cel: 0 setCycle: Fwd)
				(= cycles 14)
			)
			(4
				(windMusic stop:)
				(crank_ show:)
				(gEgo view: 16 loop: 1 cel: 0 setCycle: Beg self)
			)
			(5
				(gEgo view: 0 loop: 0 setCycle: Walk observeControl: -32768)
				(HandsOn)
				(if gDetailLevel
					(keys show: setCycle: Fwd)
				)
				(roll setCycle: Fwd)
				(myMusic number: (+ 200 global160) loop: 1 play: self)
			)
			(6
				(if (< global160 4)
					(++ global160)
				else
					(= global160 0)
				)
				(keys hide:)
				(roll stopUpd:)
				(= local1 0)
				(client setScript: 0)
			)
		)
	)
)

(instance enterPanel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local5 1)
				(= global204 1)
				(panel setMotion: MoveTo 170 83 self)
				(soundFX number: 74 loop: 1 play:)
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 15) self
				)
			)
			(2
				(gEgo setPri: -1 illegalBits: -32768)
				(panel setMotion: MoveTo 141 83 self)
				(soundFX number: 75 loop: 1 play:)
			)
			(3
				(HandsOn)
				(Print 36 13) ; "The secret panel closes behind you and leaves no trace!"
				(= global204 0)
				(= local5 0)
				(client setScript: 0)
			)
		)
	)
)

(instance DoorFunc of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7 (User canControl:))
				(User canControl: 0)
				(Bdoor setCycle: (if (== global202 1) End else Beg))
				(Fdoor setCycle: (if (== global202 1) End else Beg) self)
				(if (not local0)
					(doorMusic number: (if (== global202 1) 43 else 44) play:)
				)
			)
			(1
				(User canControl: local7)
				(Bdoor stopUpd:)
				(Fdoor stopUpd:)
				(= global202 3)
				(client setScript: 0)
			)
		)
	)
)

(instance myDoor of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== global202 3)
			(= global202 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
				(gEgo setMotion: 0 ignoreActors: 1 illegalBits: 0)
			)
			(1
				(if (< (gEgo x:) 68)
					(gEgo setMotion: MoveTo 80 119 self)
				else
					(= cycles 1)
				)
			)
			(2
				(= global202 1)
			)
			(3
				(gEgo setMotion: MoveTo (- (gEgo x:) 50) (gEgo y:))
			)
		)
	)
)

(instance balls of RPicView
	(properties
		y 102
		x 157
		view 136
		loop 9
		cel 5
		priority 9
		signal 16384
	)
)

(instance phono of RPicView
	(properties
		y 93
		x 96
		view 136
		loop 1
		cel 6
		priority 5
	)

	(method (handleEvent event)
		(cond
			((Said 'get/record')
				(Print 36 14) ; "The records don't belong to you."
			)
			(
				(or
					(Said
						'play,attach,control,rotate/handle,gramophone,music,record[/(gramophone,(player<record))<on]'
					)
					(Said '(rotate<on),(wind[<up])/gramophone,(player<record)')
				)
				(if (not local0)
					(if (gEgo has: 9) ; broken_record
						(Print 36 15) ; "You don't have a record that will work."
					else
						(Print 36 16) ; "You don't have a record."
					)
				else
					(Print 36 17) ; "There is already a record playing. Oh! One of your favorites."
				)
			)
			((Said 'open,(look<in)/gramophone,armoire,(player<record)')
				(if (< (gEgo distanceTo: record) 30)
					(Print 36 18) ; "You look inside the Victrola cabinet and see several records. But since they don't belong to you, you decide to leave them alone."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/gramophone,armoire,(player<record)')
				)
				(if (== gAct 3)
					(Print 36 19) ; "You see an old-fashioned Victrola and cabinet in the corner of the room. However, the record that is playing on the phonograph is current."
				else
					(Print 36 20) ; "You see an old-fashioned Victrola and cabinet in the corner of the room."
				)
				(event claimed: 1)
			)
		)
	)
)

(instance sofa1 of RPicView
	(properties
		y 167
		x 54
		view 136
		loop 3
		priority 12
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {couch})
		)
	)
)

(instance sofa2 of RPicView
	(properties
		y 167
		x 203
		view 136
		loop 3
		priority 12
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {couch})
		)
	)
)

(instance table1 of RPicView
	(properties
		y 167
		x 126
		view 136
		loop 2
		cel 4
		priority 12
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance wingback of RPicView
	(properties
		y 94
		x 295
		view 136
		loop 2
		cel 2
		priority 5
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance harp of RPicView
	(properties
		y 48
		x 295
		view 136
		loop 1
		cel 4
		priority 1
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/guitar'))
				(event claimed: 1)
				(Print 36 21) ; "You see several musical instruments hanging on the wall."
			)
			((Said 'get/guitar')
				(Print 36 22) ; "You were never musically inclined."
			)
			((Said 'play/guitar')
				(Print 36 22) ; "You were never musically inclined."
			)
		)
	)
)

(instance tromb of RPicView
	(properties
		y 45
		x 268
		view 136
		loop 1
		cel 5
		priority 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 36 21) ; "You see several musical instruments hanging on the wall."
		)
	)
)

(instance trump of RPicView
	(properties
		y 42
		x 233
		view 136
		loop 1
		cel 3
		priority 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 36 21) ; "You see several musical instruments hanging on the wall."
		)
	)
)

(instance mandolin of RPicView
	(properties
		y 56
		x 104
		view 136
		loop 1
		priority 4
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 36 21) ; "You see several musical instruments hanging on the wall."
		)
	)
)

(instance cues of RPicView
	(properties
		y 122
		x 30
		view 136
		loop 1
		cel 8
		priority 9
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/rack,cue'))
				(event claimed: 1)
				(Print 36 23) ; "There are billiard cues in the rack on the wall."
			)
			((Said 'get/cue[<billiard]')
				(Print 36 24) ; "Since you don't play billiards, you don't need a billiard cue."
			)
		)
	)
)

(instance bookcase of RPicView
	(properties
		y 112
		x 65
		view 136
		loop 2
		cel 3
		priority 7
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/bookcase'))
			(event claimed: 1)
			(Print 36 25) ; "The bookcases are crammed full of books."
		)
	)
)

(instance ship of RPicView
	(properties
		y 148
		x 127
		view 136
		loop 1
		cel 1
		priority 12
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/boat'))
				(event claimed: 1)
				(Print 36 26) ; "You notice a model of an old ship on the table."
			)
			((Said 'get/boat')
				(Print 36 27) ; "It's not yours. There's nothing special about it."
			)
		)
	)
)

(instance item of RPicView
	(properties
		y 91
		x 226
		view 136
		loop 3
		cel 2
		priority 5
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance table2 of RPicView
	(properties
		y 90
		x 250
		view 136
		loop 2
		priority 5
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance rim of PV
	(properties
		y 111
		x 155
		view 136
		loop 8
		priority 9
		signal 16384
	)
)

(instance billiard of RPicView
	(properties
		y 126
		x 155
		view 136
		loop 3
		cel 1
		priority 8
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(MousedOn self event 3)
				(Said 'look/(nightstand<billiard),billiard')
			)
			(event claimed: 1)
			(if (and (== gAct 1) (== gClarenceWilburState 4))
				(Print 36 28) ; "Currently, Gloria and Clarence are playing a game of billiards."
			else
				(Print 36 29) ; "This is an old billiard table. As it's quite dirty and dusty, it doesn't appear as if billiards has been played much. Upon it, you see three balls; two red and one white."
			)
		)
	)
)

(instance portrait of RPicView
	(properties
		y 50
		x 182
		view 136
		loop 1
		cel 7
		priority 5
	)

	(method (handleEvent event)
		(cond
			((Said 'look<behind,below/painting')
				(Print 36 30) ; "You can't see anything behind the picture."
			)
			((Said 'get/painting')
				(Print 36 31) ; "The picture is firmly attached to the wall."
			)
			((Said 'open/painting')
				(Print 36 32) ; "It doesn't open."
			)
			(
				(or
					(and (Said 'look/eye>') (Said 'look/actress,woman'))
					(Said 'look/eye[<actress,woman,painting]')
					(Said 'look/eye/actress,woman')
				)
				(Print 36 33) ; "The eyes of the picture have a haunted, hollow look to them."
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/painting')
					(Said 'look/actress,woman/painting')
				)
				(event claimed: 1)
				(Print 36 34) ; "You see a picture of a lovely dark-haired girl above the player piano. Strange...her eyes have a haunted, hollow look to them."
			)
		)
	)
)

(instance Fdoor of Prop
	(properties
		y 116
		x 53
		view 201
		signal 16384
		cycleSpeed 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {door})
		)
	)
)

(instance Bdoor of Prop
	(properties
		y 126
		x 43
		view 201
		loop 2
		priority 9
		signal 16400
		cycleSpeed 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {door})
		)
	)
)

(instance keys of Prop
	(properties
		y 75
		x 179
		view 136
		loop 7
		priority 5
		signal 16
	)
)

(instance roll of Prop
	(properties
		y 70
		x 180
		view 136
		loop 6
		priority 5
		signal 16
	)
)

(instance record of Prop
	(properties
		y 67
		x 98
		view 136
		loop 5
		priority 6
		signal 16
	)
)

(instance crank_ of Prop
	(properties
		y 69
		x 146
		view 136
		loop 2
		cel 5
		priority 5
		signal 16
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(MousedOn self event 3)
					(Said 'look/control,handle,mechanism[<winding][/piano]')
				)
				(event claimed: 1)
				(Print 36 35) ; "You can turn the winding mechanism to "wind up" the player piano."
			)
			(
				(Said
					'(wind[<up]),control,rotate/piano,control,handle,mechanism[<winding][/piano]'
				)
				(if (& (gEgo onControl: 1) $0010)
					(if (== local0 0)
						(if (== local1 0)
							(keys setScript: playPiano)
						else
							(Print 36 36) ; "It is already playing ."
						)
					else
						(Print 36 37) ; "Not now. There is already music playing from a record on the Victrola."
					)
				else
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance lamp1 of Prop
	(properties
		y 45
		x 119
		view 136
		cel 1
		priority 4
		signal 16
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance lamp2 of Prop
	(properties
		y 45
		x 249
		view 136
		priority 1
		signal 16
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance Piano of RFeature
	(properties
		nsTop 52
		nsLeft 152
		nsBottom 78
		nsRight 209
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)>')
				(cond
					((Said '/piano')
						(Print 36 38) ; "There is nothing that would interest you in the player piano."
					)
					((Said '/bench')
						(Print 36 39) ; "The piano bench doesn't open."
					)
				)
			)
			((or (MousedOn self event 3) (Said 'look/piano'))
				(event claimed: 1)
				(Print 36 40) ; "A lovely old player piano sits against the back wall."
			)
			((Said 'play/piano')
				(Print 36 41) ; "You never learned to play the piano. But, there is a winding mechanism on the side of the player piano."
			)
		)
	)
)

(instance panel of Act
	(properties
		y 83
		view 136
		loop 2
		cel 6
		priority 3
		signal 6160
		illegalBits 0
	)
)

(instance myMusic of Sound
	(properties)
)

(instance soundFX of Sound
	(properties)
)

(instance pianoMusic of Sound ; UNUSED
	(properties)
)

(instance doorMusic of Sound
	(properties)
)

(instance windMusic of Sound
	(properties
		number 39
	)
)


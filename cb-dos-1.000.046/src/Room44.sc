;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use Interface)
(use DCIcon)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room44 0
)

(synonyms
	(drawer chest dresser)
	(luggage case bag)
	(chute archway laundry)
	(room bedroom)
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
)

(instance Room44 of Rm
	(properties
		picture 44
	)

	(method (init)
		(= west 43)
		(= global190 0)
		(super init:)
		(SetCursor 997 1 300 0)
		(gConMusic stop:)
		(Load rsFONT 4)
		(LoadMany rsVIEW 22 653 38)
		(LoadMany rsSOUND 74 75)
		(gAddToPics
			add:
				chest1
				chest2
				item3
				item4
				bed1
				bed2
				mirror
				sofa
				needle
				table2
				wingback
			eachElementDo: #init
			doit:
		)
		(lamp1 setPri: 13 init: stopUpd:)
		(lamp2 setPri: 13 init: stopUpd:)
		(if gDetailLevel
			(lamp1 startUpd: setCycle: Fwd)
			(lamp2 startUpd: setCycle: Fwd)
		)
		(self
			setRegions: 213 ; fireReg
			setFeatures:
				mirror
				table2
				wingback
				sofa
				item4
				item3
				bed2
				bed1
				chest1
				chest2
				Fireplace
		)
		(suit1 setPri: 7 init: stopUpd:)
		(cond
			((== gAct 5)
				(= local6 1)
				(self setRegions: 274) ; trunk
			)
			((== gAct 0)
				(suit2 setPri: 11 ignoreActors: 1 init:)
			)
			(else
				(suit2 setPri: 11 ignoreActors: 1 init: stopUpd:)
			)
		)
		(if (and (== gAct 3) (& gMustDos $0002))
			(= local6 1)
			(self setRegions: 265) ; lillbed
		)
		(if (and (== gAct 6) (& gMustDos $0002) (not (IsFlag 36)))
			(= local6 1)
			(self setRegions: 385) ; RudySearch
		)
		(chute
			setLoop: 0
			setCel: 9
			yStep: 5
			illegalBits: 0
			setPri: 2
			ignoreActors: 1
			init:
			stopUpd:
			setScript: chuteActions
		)
		(if (== gAct 0)
			(if (> global203 1)
				(= local6 1)
			)
			(self setRegions: 230) ; leargue
			(if (== global203 0)
				(self setRegions: 411) ; Startup
				(= local5 1)
			)
		)
		(switch gPrevRoomNum
			(43
				(gEgo posn: 1 152)
			)
			(45
				(gEgo posn: 259 121)
			)
			(50
				(gEgo posn: 68 167)
				(= local7 1)
			)
		)
		(gEgo view: 0 ignoreActors: 0 illegalBits: -32768 init:)
	)

	(method (doit)
		(if local7
			(= local7 0)
			(Print 44 0) ; "The secret panel closes behind you and leaves no trace!"
		)
		(if (IsFirstTimeInRoom)
			(gEgo yStep: 2)
		)
		(if (and (== global203 1) local5)
			((ScriptID 411) dispose:) ; Startup
			(= local5 0)
		)
		(if (& (gEgo onControl: 1) $0004)
			(gCurRoom newRoom: 45)
		)
		(if (not local3)
			(if (and (< (gEgo x:) 51) (> (gEgo y:) 127))
				(gEgo setPri: 10)
			else
				(gEgo setPri: -1)
			)
		)
		(cond
			((< (gEgo x:) 30)
				(= vertAngle 0)
			)
			((< (gEgo x:) 140)
				(= vertAngle 163)
			)
			(else
				(= vertAngle 137)
			)
		)
		(if (> global203 1)
			(= local6 1)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(cls)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(DisposeScript 990)
			(if
				(and
					global208
					(Said
						'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>'
					)
				)
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
			)
			(cond
				((event claimed:))
				((Said '/panel,(door<hidden)>')
					(cond
						((Said 'look')
							(if (& global175 $0020)
								(Print 44 1) ; "Even though you know where it is, you can't see it."
							else
								(Print 44 2) ; "You don't see one."
							)
						)
						((and (& global175 $0020) (Said 'open,move'))
							(if (not local6)
								(if (& (gEgo onControl: 1) $0008)
									(gCurRoom newRoom: 50)
								else
									(NotClose) ; "You're not close enough."
								)
							else
								(Print 44 3) ; "Better not while someone is in the room."
							)
						)
					)
				)
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 44 4) ; "This is the guest room you share with Lillian. Though a bit tired-looking, it seems comfortable enough."
						)
						((Said '/mantel')
							(Print 44 5) ; "There is only dust on the mantel."
						)
						((Said '/wall')
							(Print 44 6) ; "Beneath a set of three, small pictures, you notice a small door in the wall."
						)
						((Said '<in/vanity,(nightstand<dressing)')
							(Print 44 7) ; "The vanity is empty."
						)
						((Said '/vanity,(nightstand<dressing)')
							(Print 44 8) ; "You see a nice little vanity by one bed."
						)
					)
				)
				((Said 'open/vanity,(nightstand<dressing)')
					(Print 44 7) ; "The vanity is empty."
				)
				((Said 'get/diary')
					(cond
						((gEgo has: 19) ; diary
							(AlreadyTook) ; "You already took it."
						)
						((< (gEgo distanceTo: suit2) 15)
							(if (>= gAct 6)
								(HandsOff)
								(= local4 1)
								(= global182 1)
								(gEgo get: 19) ; diary
								(= local2 1)
								(suit2 setScript: OpenSuit)
							else
								(Print 44 9) ; "Lillian's suitcase is locked."
							)
						)
						(else
							(NotClose) ; "You're not close enough."
						)
					)
				)
			)
		)
	)
)

(instance chuteActions of Script
	(properties)

	(method (handleEvent event)
		(if (== (event type:) evSAID)
			(cond
				((event claimed:))
				((Said 'look<(down,up)')
					(if local0
						(Print 44 10) ; "Cautiously, you poke your head into the dark opening of the little door and look around. All you can see is a narrow chute going down into complete darkness."
					else
						(event claimed: 0)
					)
				)
				((Said 'look/chute')
					(if local0
						(Print 44 10) ; "Cautiously, you poke your head into the dark opening of the little door and look around. All you can see is a narrow chute going down into complete darkness."
					else
						(Print 44 11) ; "What chute? All you see is a little door."
					)
				)
				((Said 'open/door,chute')
					(cond
						(local0
							(Print 44 12) ; "It is already open."
						)
						((gEgo inRect: 10 127 40 135)
							(= state 0)
							(= cycles 1)
						)
						(else
							(NotClose) ; "You're not close enough."
						)
					)
				)
				((Said 'hop,crawl,go,enter,climb/chute')
					(if local0
						(HandsOff)
						(= state 5)
						(= cycles 1)
					else
						(Print 44 13) ; "It's not open."
					)
				)
				((or (Said 'stand') (Said 'close/door,chute'))
					(if local0
						(= cycles 1)
					else
						(Print 44 14) ; "Are you sure you are keeping track of what you are doing?"
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
			)
			(1
				(User canControl: 0)
				(gEgo illegalBits: 0 setMotion: MoveTo 32 128 self)
			)
			(2
				(gEgo view: 22 loop: 0 cel: 0 setCycle: End)
				(myMusic number: 74 loop: 1 play:)
				(chute setMotion: MoveTo 19 167 self)
			)
			(3
				(Print 44 15) ; "It appears to be a chute of some kind. You wonder where it goes to."
				(= local0 1)
			)
			(4
				(chute setMotion: MoveTo 19 127)
				(= local0 0)
				(myMusic number: 75 loop: 1 play:)
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo view: 0 loop: 1 setCycle: Walk illegalBits: -32768)
				(User canControl: 1)
			)
			(6
				(myMusic number: 9 loop: 1 play:)
				(gEgo
					setLoop: 2
					cel: 0
					setMotion: MoveTo 26 128
					setCycle: End self
				)
				(Print 44 16 #at 160 152 #font 4 #width 125 #mode 1 #draw #dispose) ; "AAAIIIEEEEEEE!!!"
			)
			(7
				(= seconds 4)
			)
			(8
				(if (> global203 1)
					(cls)
					(= global172 99)
				)
				(ShakeScreen 10 5) ; ssUPDOWN | $0004
				(myMusic number: 47 loop: 1 play:)
				(= cycles 21)
			)
			(9
				(= global172 110)
				(= local3 1)
				(myMusic number: 57 loop: 1 play: self)
				(gEgo
					view: 38
					setLoop: 1
					posn: 20 200
					setCycle: Walk
					setPri: 9
					setMotion: MoveTo 25 -1 self
				)
			)
			(10
				(= global128 myIcon)
				(= global129 0)
				(= global132 1)
			)
			(11
				(EgoDead 44 17) ; "Oh, chute!"
			)
		)
	)
)

(instance OpenSuit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(cond
					(local4
						(Ok) ; "Okay."
						(= local4 0)
					)
					(local2
						(if (gEgo has: 19) ; diary
							(Print 44 18) ; "You see Lillian's clothes."
						else
							(Print 44 19) ; "You notice a diary lying atop Lillian's clothes."
						)
					)
					(else
						(Print 44 20) ; "You see the clothes you packed for the weekend."
					)
				)
				(= cycles 1)
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(HandsOn)
				(client stopUpd: setScript: 0)
			)
		)
	)
)

(instance chest1 of RPicView
	(properties
		y 91
		x 43
		view 144
		cel 4
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look[<at]/drawer'))
			(event claimed: 1)
			(Print 44 21) ; "In two corners of the room, you see two dressers."
		)
	)
)

(instance chest2 of RPicView
	(properties
		y 91
		x 205
		view 144
		cel 4
	)

	(method (handleEvent event)
		(if (and (MousedOn self event 3) (event claimed: 0))
			(event claimed: 1)
			(Print 44 21) ; "In two corners of the room, you see two dressers."
		)
	)
)

(instance bed1 of RPicView
	(properties
		y 106
		x 211
		view 144
		cel 7
		priority 7
		signal 16384
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look[<at]/bed'))
			(event claimed: 1)
			(Print 44 22) ; "There is a suitcase lying on each bed."
		)
	)
)

(instance bed2 of RPicView
	(properties
		y 153
		x 269
		view 144
		cel 8
		priority 11
		signal 16384
	)

	(method (handleEvent event)
		(if (and (MousedOn self event 3) (event claimed: 0))
			(event claimed: 1)
			(Print 44 22) ; "There is a suitcase lying on each bed."
		)
	)
)

(instance mirror of RPicView
	(properties
		y 147
		x 280
		view 144
		priority 10
	)

	(method (handleEvent event)
		(cond
			((or (Said 'look<in/mirror') (Said 'look<at/reflection'))
				(if (< (gEgo distanceTo: mirror) 80)
					(= global213 12)
					(Say 0 44 23) ; "You gaze into the mirror and appraise your appearance. A bit disheveled, perhaps, but not bad...considering the circumstances."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((Said 'look<(behind,below)/mirror')
				(Print 44 24) ; "There is nothing of interest behind the mirror."
			)
			((Said 'get/mirror')
				(Print 44 25) ; "The mirror is firmly attached to the vanity."
			)
			((or (MousedOn self event 3) (Said 'look/mirror'))
				(Print 44 26) ; "The oval-framed mirror is attached to the vanity."
				(event claimed: 1)
			)
		)
	)
)

(instance sofa of RPicView
	(properties
		y 169
		x 172
		view 144
		cel 1
		priority 13
		signal 16384
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {couch})
		)
	)
)

(instance wingback of RPicView
	(properties
		y 148
		x 113
		view 144
		cel 2
		priority 10
		signal 16384
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance item3 of RPicView
	(properties
		y 116
		x 251
		view 144
		cel 3
		priority 8
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance item4 of RPicView
	(properties
		y 42
		x 129
		view 144
		cel 5
		priority 1
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(and (Said 'look/eye>') (Said 'look/colonel'))
					(Said 'look/eye<colonel')
					(Said 'look/eye/colonel')
				)
				(Print 44 27) ; "The Colonel's eyes look fine."
			)
			(
				(or
					(and (Said 'look/eye>') (Said 'look/woman'))
					(Said 'look/eye[<woman,painting]')
					(Said 'look/eye/woman')
				)
				(Print 44 28) ; "The eyes of the little girl have a strange, hollow look to them."
			)
			((Said 'move,get/painting')
				(Print 44 29) ; "The portraits are firmly attached to the wall."
			)
			((Said 'look<(behind,below)/painting')
				(Print 44 30) ; "You can see nothing behind the pictures."
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/painting,colonel')
					(Said 'look/woman,man,colonel/painting')
				)
				(event claimed: 1)
				(Print 44 31) ; "Above the fireplace, you notice a picture of Colonel Dijon in his younger, more vital, days. On the opposite wall, you also see a picture of a little girl. Funny, the girl's eyes have a strange, hollow look to them."
			)
		)
	)
)

(instance needle of PV
	(properties
		y 78
		x 26
		view 144
		cel 6
		priority 9
	)
)

(instance table2 of RPicView
	(properties
		y 169
		x 127
		view 144
		cel 3
		priority 13
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance lamp1 of Prop
	(properties
		y 30
		x 240
		view 144
		loop 3
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
		y 53
		x 301
		view 144
		loop 3
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance suit1 of Prop
	(properties
		y 88
		x 208
		view 144
		loop 1
	)

	(method (handleEvent event)
		(cond
			((Said 'get/cloth')
				(if (gEgo inRect: 245 131 290 160)
					(Print 44 32) ; "They're not your clothes."
				else
					(Print 44 33) ; "The clothes you're wearing are fine."
				)
			)
			((Said 'change,wear,(attach<on)/cloth')
				(if (gEgo inRect: 245 131 290 160)
					(Print 44 34) ; "They're not your style."
				else
					(Print 44 33) ; "The clothes you're wearing are fine."
				)
			)
			((Said '(look<through),search/cloth')
				(if (gEgo inRect: 245 131 290 160)
					(Print 44 35) ; "There is nothing special about Lillian's clothes."
				else
					(Print 44 36) ; "The clothes are the same ones you packed."
				)
			)
			((Said '/(luggage,cloth)>')
				(cond
					((Said 'open,(look<in)')
						(cond
							((gEgo inRect: 245 131 290 140)
								(cond
									((< gAct 5)
										(Print 44 9) ; "Lillian's suitcase is locked."
									)
									((== gAct 5)
										(Print 44 37) ; "Lillian isn't going to let you look in her suitcase!"
									)
									(else
										(HandsOff)
										(= local2 1)
										(= local1 0)
										(suit2 setScript: OpenSuit)
									)
								)
							)
							(
								(or
									(gEgo inRect: 241 154 320 200)
									(gEgo inRect: 178 0 320 98)
								)
								(Print 44 38) ; "You're on the wrong side of the bed to do that."
							)
							((< (gEgo distanceTo: suit1) 25)
								(= local1 1)
								(= local2 0)
								(HandsOff)
								(suit1 setScript: OpenSuit)
							)
							(else
								(NotClose) ; "You're not close enough."
							)
						)
					)
					((Said 'look')
						(Print 44 39) ; "Your suitcase lies on the bed to the left of the doorway while Lillian's lies on the bed to the right."
					)
					((Said 'close')
						(AlreadyClosed) ; "It is already closed."
					)
					((Said 'get')
						(if
							(or
								(gEgo inRect: 245 131 290 160)
								(< (gEgo distanceTo: suit1) 25)
							)
							(Print 44 40) ; "You'd look silly carrying a suitcase around with you!"
						else
							(NotClose) ; "You're not close enough."
						)
					)
				)
			)
			((MousedOn self event 3)
				(event claimed: 1)
				(DoLook {suitcase})
			)
		)
	)
)

(instance suit2 of Prop
	(properties
		y 133
		x 265
		view 144
		loop 2
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {suitcase})
		)
	)
)

(instance chute of Act
	(properties
		y 127
		x 19
		view 144
		cel 9
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (MousedOn self event 3) (Said 'look/door'))
			(event claimed: 1)
			(Print 44 6) ; "Beneath a set of three, small pictures, you notice a small door in the wall."
		)
	)
)

(instance Fireplace of RFeature
	(properties
		nsTop 47
		nsLeft 108
		nsBottom 88
		nsRight 154
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {fireplace})
		)
	)
)

(instance myMusic of Sound
	(properties)
)

(instance myIcon of DCIcon
	(properties
		view 653
	)
)


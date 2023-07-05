;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
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
	Room34 0
)

(local
	local0
	local1
	local2
	local3
)

(instance Room34 of Rm
	(properties
		picture 34
	)

	(method (init)
		(super init:)
		(= west 33)
		(Load rsVIEW 22)
		(LoadMany rsSOUND 9 47 74 75)
		(gAddToPics
			add:
				chair1
				chair2
				chair3
				chair4
				chair5
				chair6
				chair7
				chair8
				chair9
				chair10
				chair11
				chair12
				coffee
				chandelier
				flowers
			eachElementDo: #init
			doit:
		)
		(self
			setRegions: 213 ; fireReg
			setFeatures:
				Table
				chair7
				chair8
				chair9
				chair10
				chair11
				chair12
				BigTable
				chair1
				chair2
				chair3
				chair4
				chair5
				chair6
				coffee
				chandelier
				Hutch
				Mirror
		)
		(if gDetailLevel
			(gas setPri: 9 ignoreActors: 1 setCycle: Fwd init:)
			(fire loop: (/ gAct 2) setCycle: Fwd init:)
		else
			(gas setPri: 9 ignoreActors: 1 init: stopUpd:)
			(fire loop: (/ gAct 2) init: stopUpd:)
		)
		(chute
			setLoop: 2
			yStep: 5
			illegalBits: 0
			setPri: 2
			ignoreActors: 1
			init:
			stopUpd:
			setScript: chuteActions
		)
		(if (and (<= (Random 1 100) 35) (> gAct 0) (< gAct 7))
			(Shadow illegalBits: 0 posn: 13 82 setPri: 2 init:)
			(Shadow setScript: shadowWalk)
		)
		(switch gAct
			(1
				(if (== gClarenceWilburState 3)
					(if (== [gCycleTimers 0] 1)
						(= gClarenceWilburState 4)
					else
						(if (== gClarenceWilburState 3)
							(User canInput: 0)
						)
						(= local2 1)
						(self setRegions: 237) ; wcargue
					)
				)
			)
			(4
				(= local2 1)
				(self setRegions: 403) ; rudyeat
			)
			(3
				(if (and (== gMinute 3) (== [gCycleTimers 2] 0))
					(= [gCycleTimers 2] 1800)
				)
				(if (> [gCycleTimers 2] 1)
					(= local2 1)
					(self setRegions: 383) ; kissact3
				)
			)
		)
		(if (!= gPrevRoomNum 50)
			(if (== gPrevRoomNum 33)
				(gEgo posn: 14 150)
			else
				(gEgo posn: 265 120)
			)
			(gEgo illegalBits: -32768 view: 0 init:)
		else
			(gEgo view: 0 illegalBits: -32768 setPri: -1 posn: 68 167 init:)
			(= local3 1)
		)
	)

	(method (doit)
		(if local3
			(= local3 0)
			(Print 34 0) ; "The secret panel closes behind you and leaves no trace!"
		)
		(if (IsFirstTimeInRoom)
			(Print 34 1) ; "This is a very elegant dining room. It looks like the Colonel has some class after all!"
		)
		(if (& (gEgo onControl: 1) $0004)
			(gCurRoom newRoom: 35)
		)
		(if (not local1)
			(if (and (< (gEgo x:) 51) (> (gEgo y:) 126))
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
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(= temp0
				(or
					(!= gAct 1)
					(!= gClarenceWilburState 3)
					(and
						(not (Said 'ask[/c]/attorney<about>'))
						(not (Said 'ask[/attorney]/c<about>'))
					)
				)
			)
			(if
				(and
					global208
					temp0
					(Said
						'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>'
					)
				)
				(DisposeScript 990)
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
				(if (event claimed:)
					(return 1)
				)
			)
			(cond
				((Said '/panel,(door<hidden)>')
					(cond
						((Said 'look')
							(if (& global175 $0002)
								(Print 34 2) ; "Even though you know where it is, you can't see it."
							else
								(Print 34 3) ; "You don't see one."
							)
						)
						((and (& global175 $0002) (Said 'open,move'))
							(if (not local2)
								(if (& (gEgo onControl: 1) $0008)
									(gCurRoom newRoom: 50)
								else
									(NotClose) ; "You're not close enough."
								)
							else
								(Print 34 4) ; "Better not while someone is in the room."
							)
						)
					)
				)
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 34 1) ; "This is a very elegant dining room. It looks like the Colonel has some class after all!"
						)
						((Said 'look/panel[<hidden]')
							(if (& global175 $0002)
								(Print 34 2) ; "Even though you know where it is, you can't see it."
							else
								(Print 34 3) ; "You don't see one."
							)
						)
						((Said '/wall,door')
							(Print 34 5) ; "You notice a small door below the wall light."
						)
						((Said '<below/nightstand')
							(Print 34 6) ; "There is nothing special under the table."
						)
						((Said '/nightstand')
							(Print 34 7) ; "Which table do you mean...the small table or the dining table?"
						)
						(
							(or
								(and (Said 'look/eye>') (Said 'look/man'))
								(Said 'look/eye[<man,painting]')
								(Said 'look/eye/man')
							)
							(Print 34 8) ; "The eyes of the man appear oddly vacant."
						)
						((Said '<behind,below/painting')
							(Print 34 9) ; "You can see nothing behind the picture."
						)
						((or (Said '/painting') (Said '/man/painting'))
							(Print 34 10) ; "Upon the wall opposite the fireplace hangs a picture of an aristocratic-looking, older man. That's strange...the eyes of the man appear oddly vacant."
						)
					)
				)
				((Said 'move,get/painting')
					(Print 34 11) ; "The portrait is firmly attached to the wall."
				)
				((Said 'get>')
					(cond
						((Said '/mirror')
							(Print 34 12) ; "The mirror is firmly attached to the wall."
						)
						((Said '/coffee')
							(Print 34 13) ; "The coffee urn is empty."
						)
						((Said '/fire,log')
							(Print 34 14) ; "Don't play with fire!"
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
						(Print 34 15) ; "Cautiously, you poke your head into the dark opening of the little door and look around. All you can see is a narrow chute going down into complete darkness."
					else
						(event claimed: 0)
					)
				)
				((Said 'look/chute')
					(if local0
						(Print 34 15) ; "Cautiously, you poke your head into the dark opening of the little door and look around. All you can see is a narrow chute going down into complete darkness."
					else
						(Print 34 16) ; "What chute? All you see is a little door."
					)
				)
				((Said 'open/door[<chute]')
					(cond
						(local0
							(Print 34 17) ; "It is already open."
						)
						((gEgo inRect: 5 126 40 135)
							(= state 0)
							(= cycles 1)
						)
						(else
							(NotClose) ; "You're not close enough."
						)
					)
				)
				((Said 'hop,crawl,go,enter/chute')
					(if local0
						(HandsOff)
						(= state 5)
						(= cycles 1)
					else
						(Print 34 18) ; "It's not open."
					)
				)
				((or (Said 'stand') (Said 'close/door,chute'))
					(if local0
						(= cycles 1)
					else
						(Print 34 19) ; "Are you sure you are keeping track are what you are doing?"
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
				(gEgo illegalBits: 0 setMotion: MoveTo 33 127 self)
			)
			(2
				(gEgo view: 22 loop: 0 cel: 0 setCycle: End)
				(chute setMotion: MoveTo 19 167 self)
				(myMusic number: 74 loop: 1 play:)
			)
			(3
				(= local0 1)
				(Print 34 20) ; "It appears to be a chute of some kind. You wonder where it goes to."
			)
			(4
				(chute setMotion: MoveTo 23 121)
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
					setMotion: MoveTo 27 128
					setCycle: End self
				)
			)
			(7
				(Print 34 21 #dispose) ; "AAAIIIIEEEEEEE!"
				(= seconds 4)
			)
			(8
				(cls)
				(= global172 100)
				(ShakeScreen 10 5) ; ssUPDOWN | $0004
				(myMusic number: 47 loop: 1 play:)
				(= cycles 21)
			)
			(9
				(= local1 1)
				(myMusic number: 57 loop: 1 play: self)
				(gEgo
					view: 38
					posn: 20 200
					setCycle: Walk
					setPri: 9
					illegalBits: 0
					setMotion: MoveTo 25 -1 self
				)
			)
			(10
				(= global128 myIcon)
				(= global129 0)
			)
			(11
				(= global132 1)
				(EgoDead 34 22) ; "Oh, chute!"
			)
		)
	)
)

(instance shadowWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(Shadow setMotion: MoveTo 295 82 self)
			)
			(2
				(Shadow dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance chair1 of RPicView
	(properties
		y 113
		x 106
		view 134
		loop 5
		cel 4
		priority 7
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair2 of RPicView
	(properties
		y 113
		x 136
		view 134
		loop 5
		cel 4
		priority 7
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair3 of RPicView
	(properties
		y 113
		x 164
		view 134
		loop 5
		cel 4
		priority 7
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair4 of RPicView
	(properties
		y 90
		x 205
		view 134
		loop 6
		cel 1
		priority 5
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair5 of RPicView
	(properties
		y 90
		x 50
		view 134
		loop 6
		priority 5
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair6 of RPicView
	(properties
		y 112
		x 188
		view 134
		loop 5
		cel 2
		priority 7
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair7 of RPicView
	(properties
		y 125
		x 220
		view 134
		loop 5
		priority 8
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair8 of RPicView
	(properties
		y 131
		x 87
		view 134
		loop 5
		cel 7
		priority 8
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair9 of RPicView
	(properties
		y 130
		x 121
		view 134
		loop 5
		cel 9
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair10 of RPicView
	(properties
		y 130
		x 153
		view 134
		loop 5
		cel 11
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair11 of RPicView
	(properties
		y 130
		x 181
		view 134
		loop 5
		cel 11
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair12 of RPicView
	(properties
		y 130
		x 212
		view 134
		loop 5
		cel 12
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance coffee of RPicView
	(properties
		y 138
		x 301
		view 134
		priority 12
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(Said 'open/coffee,urn[<urn]')
					(Said 'look<in/coffee,urn')
					(Said 'pour,get,drink/cup,coffee')
				)
				(cond
					((== gAct 4)
						(Print 34 23) ; "You're not fond of coffee."
					)
					((gEgo inRect: 259 139 320 200)
						(Print 34 13) ; "The coffee urn is empty."
					)
					(else
						(NotClose) ; "You're not close enough."
					)
				)
			)
			((Said 'get/urn')
				(Print 34 24) ; "The coffee urn is much too big and heavy to carry around."
			)
			((or (MousedOn self event 3) (Said 'look/urn'))
				(event claimed: 1)
				(Print 34 25) ; "It's a lovely piece, isn't it?"
			)
		)
	)
)

(instance chandelier of RPicView
	(properties
		y 42
		x 144
		view 134
		cel 3
		priority 9
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/chandelier'))
			(event claimed: 1)
			(Print 34 26) ; "A beautiful crystal chandelier hangs above the dining table."
		)
	)
)

(instance flowers of PV
	(properties
		y 55
		x 129
		view 134
		cel 2
		priority 5
	)
)

(instance fire of Prop
	(properties
		y 85
		x 131
		view 232
		cel 1
		priority 5
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/log'))
			(event claimed: 1)
			(DoLook {fire})
		)
	)
)

(instance gas of Prop
	(properties
		y 82
		x 24
		view 134
		loop 3
		cel 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance chute of Act
	(properties
		y 121
		x 23
		view 134
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (MousedOn self event 3) (Said 'look/door'))
			(Print 34 5) ; "You notice a small door below the wall light."
			(event claimed: 1)
		)
	)
)

(instance Shadow of Act
	(properties
		view 110
	)
)

(instance Hutch of RFeature
	(properties
		nsTop 46
		nsLeft 222
		nsBottom 106
		nsRight 247
	)

	(method (handleEvent event)
		(cond
			((or (Said 'look<in/armoire') (Said 'open/armoire'))
				(Print 34 27) ; "There is nothing of interest in the hutch."
			)
			((or (MousedOn self event 3) (Said 'look/armoire'))
				(Print 34 28) ; "You notice a lovely, leaded glass hutch in the corner."
				(event claimed: 1)
			)
		)
	)
)

(instance BigTable of RFeature
	(properties
		nsTop 95
		nsLeft 99
		nsBottom 107
		nsRight 199
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/nightstand<dining'))
			(Print 34 29) ; "There is plenty of seating around the large dining table."
			(event claimed: 1)
		)
	)
)

(instance Table of RFeature
	(properties
		nsTop 133
		nsLeft 284
		nsBottom 168
		nsRight 319
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said '/nightstand<little'))
			(Print 34 30) ; "A large, silver coffee urn sits on the small table."
			(event claimed: 1)
		)
	)
)

(instance Mirror of RFeature
	(properties
		nsTop 16
		nsLeft 107
		nsBottom 48
		nsRight 141
	)

	(method (handleEvent event)
		(cond
			((Said 'look<behind,below/mirror')
				(Print 34 31) ; "There is nothing of interest behind the mirror."
			)
			((or (Said 'look<in/mirror') (Said 'look[<at]/reflection'))
				(if (< (gEgo distanceTo: fire) 80)
					(= global213 12)
					(Say 0 34 32) ; "You gaze into the mirror and appraise your appearance. A bit disheveled, perhaps, but not bad...considering the circumstances."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'look/mirror'))
				(Print 34 33) ; "You see a dusty, old mirror hanging on the wall."
				(event claimed: 1)
			)
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


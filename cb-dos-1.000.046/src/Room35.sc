;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
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
	Room35 0
)

(synonyms
	(room kitchen)
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(gAddToPics dispose:)
	(gCast eachElementDo: #hide)
	(DrawPic 992 6 1 0)
)

(procedure (localproc_1)
	(cls)
	(DrawPic 35 7 1 0)
	(gAddToPics
		add: sink butterchurn stool rack icebox shelves shelf
		eachElementDo: #init
		doit:
	)
	(gCast eachElementDo: #show)
)

(instance Room35 of Rm
	(properties
		picture 35
	)

	(method (init)
		(= west 34)
		(super init:)
		(= global202 0)
		(= local2 (IsFirstTimeInRoom))
		(LoadMany rsSOUND 43 44)
		(gAddToPics
			add: sink butterchurn stool rack icebox shelves shelf
			eachElementDo: #init
			doit:
		)
		(self
			setFeatures:
				sink
				butterchurn
				stool
				icebox
				shelves
				Stove
				Window1
				Window2
				rack
				Cabinet
				Table
		)
		(kettle setPri: 5 init:)
		(if gDetailLevel
			(lamp1 setCycle: Fwd init:)
			(lamp2 setCycle: Fwd init:)
			(if (< gAct 2)
				(kettle loop: 0 setCycle: Fwd)
			)
		else
			(lamp1 init: stopUpd:)
			(lamp2 init: stopUpd:)
		)
		(iceDoor setPri: 5 init: stopUpd:)
		(if (== ((gInventory at: 12) owner:) 35) ; soup_bone
			(Bone setPri: 4 init: stopUpd:)
		)
		(if (and (<= (Random 1 100) 35) (> gAct 1) (< gAct 7))
			(Shadow illegalBits: 0 posn: 13 82 setPri: 2 init:)
			(Shadow setScript: shadowWalk)
		)
		(switch gAct
			(0
				(self setRegions: 229) ; celiWash
			)
			(1
				(self setRegions: 236) ; celiBrea
			)
		)
		(Fdoor
			cel: (if (== gPrevRoomNum 12) 2 else 0)
			ignoreActors: 1
			init:
			stopUpd:
		)
		(= global373 Fdoor)
		(Bdoor
			cel: (if (== gPrevRoomNum 12) 2 else 0)
			setPri: 9
			ignoreActors: 1
			init:
			stopUpd:
		)
		(= global374 Bdoor)
		(if (== gPrevRoomNum 34)
			(gEgo posn: 1 123)
		else
			(HandsOff)
			(gEgo posn: 235 120)
			(if (not local2)
				(self setScript: closeDoor)
			)
		)
		(gEgo view: 0 illegalBits: -32732 init:)
	)

	(method (doit)
		(if local2
			(= local2 0)
			(Print 35 0) ; "This old house has a nice big kitchen."
			(if (== gAct 0)
				(Print 35 1) ; "Right now you see Celie washing the dinner dishes while Beauregard has found a warm spot by the stove."
			)
			(if (== gPrevRoomNum 12)
				(self setScript: closeDoor)
			)
		)
		(if
			(and
				(& (gEgo onControl: 0) $0010)
				(not local0)
				(== (gEgo loop:) 0)
			)
			(HandsOff)
			(= local0 1)
			(gEgo setScript: myDoor)
		)
		(if (& (gEgo onControl: 1) $0004)
			(gCurRoom newRoom: 12)
		)
		(cond
			((< (gEgo x:) 100)
				(= vertAngle 0)
			)
			((< (gEgo x:) 160)
				(= vertAngle 167)
			)
			(else
				(= vertAngle 137)
			)
		)
		(switch global202
			(1
				(localproc_0)
			)
			(2
				(localproc_1)
			)
		)
		(= global202 0)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(cls)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(DisposeScript 990)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(= temp0
				(or
					(!= gAct 1)
					(and
						(not (Said 'ask[/celie]/lil<about>'))
						(not (Said 'ask[/lil]/celie<about>'))
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
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
			)
			(if (event claimed:)
				(return 1)
			)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 35 0) ; "This old house has a nice big kitchen."
							(if (== gAct 0)
								(Print 35 1) ; "Right now you see Celie washing the dinner dishes while Beauregard has found a warm spot by the stove."
							)
						)
						((Said '/dish')
							(if (== gAct 0)
								(Print 35 2) ; "Right now the sink's full of dirty dishes."
							else
								(Print 35 3) ; "You don't see any dishes."
							)
						)
						((Said '/door')
							(Print 35 4) ; "The French doors lead outside."
						)
						((Said '/carpet')
							(Print 35 5) ; "You see a tiny rug by the kitchen sink."
						)
						((Said '<(in,below)/nightstand')
							(Print 35 6) ; "Various kitchen implements are stored under the table. There's nothing you need there."
						)
					)
				)
				((Said 'scrub/give')
					(Print 35 7) ; "You should do that in the bathroom."
				)
				((Said 'get/dish')
					(if (== gAct 0)
						(Print 35 8) ; "Why would you want dirty old dishes?"
					else
						(Print 35 3) ; "You don't see any dishes."
					)
				)
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

(instance myDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo illegalBits: 0)
				(if (> (gEgo x:) 229)
					(gEgo setMotion: MoveTo 229 (gEgo y:) self)
				else
					(= cycles 1)
				)
			)
			(2
				(Bdoor cycleSpeed: 1 ignoreActors: 1 setCycle: End)
				(Fdoor cycleSpeed: 1 ignoreActors: 1 setCycle: End self)
				(mySound number: 43 play:)
			)
			(3
				(gEgo setMotion: MoveTo (+ (gEgo x:) 50) 122)
			)
		)
	)
)

(instance frigDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(iceDoor setCycle: End self)
			)
			(1
				(if (== ((gInventory at: 12) owner:) 35) ; soup_bone
					(Print 35 9) ; "Aha! A leftover soup bone! As it might come in handy, you grab it and take it with you."
					(= global182 1)
					(gEgo get: 12) ; soup_bone
					(Bone dispose:)
				else
					(Print 35 10) ; "Nope. Nothing interesting in there!"
				)
				(= cycles 1)
			)
			(2
				(iceDoor setCycle: Beg self)
			)
			(3
				(HandsOn)
				(iceDoor stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance closeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 3)
			)
			(1
				(gEgo ignoreActors: 0 setMotion: MoveTo 226 122 self)
				(Fdoor setCycle: Beg)
				(Bdoor setCycle: Beg)
				(mySound number: 44 play:)
			)
			(2
				(HandsOn)
				(Bdoor stopUpd:)
				(Fdoor stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance sink of RPicView
	(properties
		y 81
		x 217
		view 135
		cel 1
		priority 4
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/sink'))
			(event claimed: 1)
			(if (== gAct 0)
				(Print 35 11) ; "The sink is full of dirty dinner dishes."
			else
				(Print 35 12) ; "It's just an empty sink."
			)
		)
	)
)

(instance butterchurn of RPicView
	(properties
		y 166
		x 21
		view 135
		cel 3
		priority 12
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/butterchurn')
				(Print 35 13) ; "It's empty."
			)
			((or (MousedOn self event 3) (Said 'look/butterchurn'))
				(event claimed: 1)
				(Print 35 14) ; "The old butter churn is empty."
			)
		)
	)
)

(instance stool of RPicView
	(properties
		y 152
		x 198
		view 135
		cel 2
		priority 10
		signal 16384
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/chair,barstool'))
			(event claimed: 1)
			(Print 35 15) ; "That's a pretty basic three-legged stool."
		)
	)
)

(instance rack of RPicView
	(properties
		y 66
		x 220
		view 135
		loop 1
		cel 2
		priority 3
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/pan'))
			(event claimed: 1)
			(Print 35 16) ; "Cooking pans hang on the wall above the sink."
		)
	)
)

(instance icebox of RPicView
	(properties
		y 91
		x 27
		view 135
		priority 3
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(Said 'open,(look<in)/freezer')
					(and (== ((gInventory at: 12) owner:) 35) (Said 'get/bone')) ; soup_bone
				)
				(if (gEgo inRect: 9 84 43 100)
					(gEgo setScript: frigDoor)
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((and global208 (Said 'ask,tell'))
				(event claimed: 0)
			)
			(
				(and
					(!= gAct 0)
					(or (Said '/beauregard') (Said '//beauregard'))
				)
				(Print 35 17) ; "Beauregard isn't here right now."
			)
			(
				(and
					(== gAct 0)
					(== ((gInventory at: 12) owner:) 0) ; soup_bone
					(or
						(Said 'get/back<bone[<from]')
						(Said 'get/*/beauregard')
						(Said 'get/bone')
					)
				)
				(Print 35 18) ; "It doesn't look like Beauregard is going to stop chewing on the bone long enough for you to retrieve it."
			)
			((Said 'get/bone')
				(cond
					((gEgo has: 12) ; soup_bone
						(AlreadyTook) ; "You already took it."
					)
					((== ((gInventory at: 12) owner:) 35) ; soup_bone
						(DontHave) ; "You don't have it."
					)
					(else
						(Print 35 19) ; "You already took the bone and gave it to Beauregard."
					)
				)
			)
			((or (MousedOn self event 3) (Said 'look/freezer'))
				(event claimed: 1)
				(Print 35 20) ; "This is your average, run-of-the-mill icebox."
			)
		)
	)
)

(instance shelves of RPicView
	(properties
		y 144
		x 279
		view 135
		loop 1
		priority 10
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/armoire')
				(Print 35 21) ; "There's nothing you need in the cupboards."
			)
			((or (MousedOn self event 3) (Said 'look/armoire'))
				(event claimed: 1)
				(Print 35 22) ; "This kitchen could use more cupboard space!"
			)
		)
	)
)

(instance shelf of PV
	(properties
		y 133
		x 150
		view 135
		loop 1
		cel 1
		priority 10
		signal 16384
	)
)

(instance lamp1 of Prop
	(properties
		y 56
		x 231
		view 135
		loop 4
		cel 1
		priority 6
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
		y 66
		x 255
		view 135
		loop 4
		priority 11
		signal 16
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance Fdoor of Prop
	(properties
		y 113
		x 242
		view 201
		loop 1
		priority 7
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
		y 125
		x 253
		view 201
		loop 3
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {door})
		)
	)
)

(instance kettle of Prop
	(properties
		y 63
		x 118
		view 235
		loop 1
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/caldron')
				(cond
					((< gAct 2)
						(Print 35 23) ; "There's hot coffee in there!"
					)
					((<= gAct 4)
						(Print 35 24) ; "A small amount of lukewarm coffee is still in the pot."
					)
					(else
						(Print 35 25) ; "The coffee pot's empty."
					)
				)
			)
			((Said 'get/caldron')
				(if (< gAct 2)
					(Print 35 26) ; "No! It's hot!"
				else
					(Print 35 27) ; "You don't need a coffee pot."
				)
			)
			((Said 'pour,get,drink/cup,coffee')
				(Print 35 28) ; "You've never been fond of coffee."
			)
			((or (MousedOn self event 3) (Said 'look[<at]/caldron[<coffee]'))
				(if (< gAct 2)
					(Print 35 29) ; "The smell of coffee permeates the room from the bubbling pot."
				else
					(Print 35 30) ; "A big coffee pot sits on top of the stove."
				)
				(event claimed: 1)
			)
		)
	)
)

(instance Shadow of Act
	(properties
		view 110
	)
)

(instance Stove of RFeature
	(properties
		nsTop 32
		nsLeft 90
		nsBottom 88
		nsRight 133
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/oven')
				(Print 35 31) ; "There is nothing in the stove or oven."
			)
			((or (MousedOn self event 3) (Said 'look/oven'))
				(if (< gAct 2)
					(Print 35 32) ; "A pot of coffee bubbles on the stove."
				else
					(Print 35 30) ; "A big coffee pot sits on top of the stove."
				)
				(event claimed: 1)
			)
		)
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 20
		nsLeft 46
		nsBottom 85
		nsRight 72
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {window})
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 20
		nsLeft 145
		nsBottom 85
		nsRight 172
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {window})
		)
	)
)

(instance iceDoor of Prop
	(properties
		y 84
		x 18
		view 135
		loop 3
	)
)

(instance Bone of Prop
	(properties
		y 82
		x 27
		view 135
		loop 2
		cel 1
	)

	(method (handleEvent)
		(cond
			((and (< gAct 2) (Said 'ask/celie/bone<for'))
				(= global213 2)
				(++ local3)
				(Say 1 35 33) ; "You kin have it. It' been in that there icebox for a long time."
			)
			((and (== gAct 1) (Said 'ask/lil/bone<for'))
				(= global213 6)
				(Say 1 35 33) ; "You kin have it. It' been in that there icebox for a long time."
			)
		)
	)
)

(instance mySound of Sound
	(properties
		number 43
	)
)

(instance Table of RFeature
	(properties
		nsTop 106
		nsLeft 110
		nsBottom 12
		nsRight 175
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/nightstand'))
			(if (== gAct 1)
				(Print 35 34) ; "Celie rolls out tomorrow's bread on the kitchen table."
			else
				(Print 35 35) ; "A large kitchen table dominates the center on the room."
			)
			(event claimed: 1)
		)
	)
)

(instance Cabinet of RFeature
	(properties
		nsTop 33
		nsLeft 176
		nsBottom 52
		nsRight 210
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(Print 35 22) ; "This kitchen could use more cupboard space!"
			(event claimed: 1)
		)
	)
)


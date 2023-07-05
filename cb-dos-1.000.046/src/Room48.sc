;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 48)
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
	Room48 0
)

(synonyms
	(luggage case bag)
	(drawer dresser)
	(notebook book)
	(room bedroom)
)

(local
	local0
)

(instance mySound of Sound
	(properties)
)

(instance Room48 of Rm
	(properties
		picture 48
	)

	(method (init)
		(= west 47)
		(super init:)
		(LoadMany rsSOUND 74 75)
		(if (== gAct 6)
			(if (not (& gMustDos $0001))
				(Load rsFONT 41)
				(LoadMany rsSOUND 29 94 95 96)
				(Load rsSCRIPT 406)
				(Load rsVIEW 642)
			)
			(chair cel: 4)
			(stain setPri: 4 ignoreActors: 1 init:)
		)
		(gAddToPics
			add: lady bed1 bed2 chest desk table1 table2 suit1 suit2 sofa chair
			eachElementDo: #init
			doit:
		)
		(self
			setFeatures:
				suit1
				suit2
				lady
				bed1
				chest
				bed2
				table1
				chair
				sofa
				table2
				desk
		)
		(if gDetailLevel
			(lamp1 setPri: 1 setCycle: Fwd init:)
			(lamp2 setPri: 5 setCycle: Fwd init:)
		else
			(lamp1 setPri: 1 init: stopUpd:)
			(lamp2 setPri: 5 init: stopUpd:)
		)
		(panel
			setLoop: 2
			setCel: 6
			x: (if (== gPrevRoomNum 50) 165 else 169)
			setPri: 4
			init:
			stopUpd:
		)
		(switch gAct
			(0
				(if (> global199 0)
					(= local0 1)
					(self setRegions: 379) ; rudyDrin
				)
			)
			(1
				(= local0 1)
				(self setRegions: 241) ; rudyslap
			)
			(2
				(if (and (& gMustDos $0004) (< [gCycleTimers 2] 2))
					(|= gSpyFlags $0008)
					(= local0 1)
					(self setRegions: 260) ; csleep
				else
					(HandsOff)
					(= local0 1)
					(self setRegions: 259) ; crArgue
				)
			)
			(5
				(= local0 1)
				(self setRegions: 276) ; desk
			)
			(6
				(notebook setPri: 9 init: stopUpd:)
			)
		)
		(if (!= gPrevRoomNum 50)
			(gEgo view: 0 posn: 8 96 illegalBits: -32760 init:)
		else
			(gEgo
				view: 0
				illegalBits: -32768
				setPri: 2
				loop: 2
				posn: 175 79
				init:
			)
			(if (== local0 0)
				(gEgo posn: 169 79)
				(self setScript: enterPanel)
			)
		)
	)

	(method (doit)
		(if (and (not (& gSpyFlags $0008)) (== gAct 6))
			(|= gSpyFlags $0008)
			(Print 48 0) ; "Uh, oh! A bad feeling comes over you as you look around this room. The small desk chair has been knocked over and you see a fresh bloodstain on the rug!"
		)
		(if (IsFirstTimeInRoom)
			(Print 48 1) ; "This appears to be another guest room that Rudy and Clarence are sharing."
		)
		(if (gEgo inRect: 110 84 143 107)
			(gEgo setPri: 5)
		else
			(gEgo setPri: -1)
		)
		(if (and (& (gEgo onControl: 0) $0008) (== global204 0))
			(gCurRoom newRoom: 50)
		)
		(if (< (gEgo x:) 140)
			(= vertAngle 163)
		else
			(= vertAngle 137)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 204)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(if
				(and
					global208
					(Said
						'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>'
					)
				)
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
				(if (event claimed:)
					(return 1)
				)
			)
			(cond
				((Said '/panel,(door<hidden)>')
					(cond
						((and (& global175 $0080) (Said 'open,move'))
							(if (not local0)
								(if (& (gEgo onControl: 0) $0004)
									(HandsOff)
									(self setScript: exiting)
								else
									(NotClose) ; "You're not close enough."
								)
							else
								(Print 48 2) ; "You better not while others are in the room."
							)
						)
						((Said 'look')
							(if (& global175 $0080)
								(Print 48 3) ; "Even though you know where it is, you can't see it."
							else
								(Print 48 4) ; "You don't see one."
							)
						)
					)
				)
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(if (>= gAct 6)
								(Print 48 0) ; "Uh, oh! A bad feeling comes over you as you look around this room. The small desk chair has been knocked over and you see a fresh bloodstain on the rug!"
							else
								(Print 48 1) ; "This appears to be another guest room that Rudy and Clarence are sharing."
							)
						)
						((or (Said '/carpet,dirt,blood,stain') (Said '<down'))
							(if (== gAct 6)
								(Print 48 5) ; "You see a fresh bloodstain on the rug near the overturned chair."
							else
								(event claimed: 0)
							)
						)
					)
				)
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
				(= global204 1)
				(panel setMotion: MoveTo 140 84 self)
				(mySound number: 74 loop: 1 play:)
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 15) self
				)
			)
			(2
				(gEgo setPri: -1 illegalBits: -32760)
				(panel setMotion: MoveTo 169 84 self)
				(mySound number: 75 loop: 1 play:)
			)
			(3
				(HandsOn)
				(Print 48 6) ; "The secret panel closes behind you and leaves no trace!"
				(= global204 0)
				(client setScript: 0)
			)
		)
	)
)

(instance exiting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global204 1)
				(panel setMotion: MoveTo 140 84 self)
				(mySound number: 74 loop: 1 play:)
			)
			(1
				(if (gEgo inRect: 168 87 169 89)
					(= cycles 1)
				else
					(gEgo illegalBits: -32768 setMotion: MoveTo 169 88 self)
				)
			)
			(2
				(gEgo illegalBits: -32768 setMotion: MoveTo 169 79 self)
			)
			(3
				(gEgo setPri: 2)
				(panel setMotion: MoveTo 169 84 self)
				(mySound number: 75 loop: 1 play:)
			)
			(4
				(HandsOn)
				(= global204 0)
				(client setScript: 0)
			)
		)
	)
)

(instance LookNote of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not (& gMustDos $0001))
						(|= gMustDos $0001)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(Print 48 7) ; "You notice that just one page has been written on, and today's date, May 27th, 1925, heads it. Curiously, you read the rest. It says..."
				(Print 48 8) ; "...I'm terribly apprehensive about what's going on here. I can't say why...just call it a bad sensation...but as the evening wears on I'm feeling more and more alone. Where's Wilbur? Where's Gertie? Where's Gloria? Could they have left without me? Is there a way to leave the island that I'm not aware of? Still, the spine-tingling feeling won't leave, and frankly, I'm scared."
				(= cycles 1)
			)
			(2
				(client setScript: 0)
			)
		)
	)
)

(instance lady of RPicView
	(properties
		y 47
		x 138
		view 148
		loop 1
		priority 5
	)

	(method (handleEvent event)
		(cond
			((Said 'look<behind,below/painting')
				(Print 48 9) ; "You can't see behind the picture."
			)
			((Said 'get/painting')
				(Print 48 10) ; "The picture is firmly attached to the wall."
			)
			((Said 'open/painting')
				(Print 48 11) ; "It doesn't open."
			)
			(
				(or
					(and (Said 'look/eye>') (Said 'look/woman'))
					(Said 'look/eye[<woman,painting]')
					(Said 'look/eye/woman')
				)
				(Print 48 12) ; "The eyes of the woman have a strange, faraway look to them."
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/painting')
					(Said 'look/woman/painting')
				)
				(event claimed: 1)
				(Print 48 13) ; "You notice an interesting picture of a woman and child. Oddly, the woman's eyes have a strange, faraway look in them."
			)
		)
	)
)

(instance bed1 of RPicView
	(properties
		y 105
		x 208
		view 148
		loop 2
		priority 6
		signal 16384
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {bed})
		)
	)
)

(instance chest of RPicView
	(properties
		y 89
		x 136
		view 148
		loop 1
		cel 1
		priority 5
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/luggage')
				(Print 48 14) ; "They're locked."
			)
			((Said 'look[<at]/luggage')
				(Print 48 15) ; "You notice three suitcases next to the beds. They must belong to Rudy and Clarence."
			)
			((Said 'get/luggage')
				(Print 48 16) ; "You'd look silly carrying a suitcase around with you."
			)
			((or (MousedOn self event 3) (Said 'look[<at]/drawer'))
				(event claimed: 1)
				(Print 48 17) ; "It's a plain old dresser."
			)
		)
	)
)

(instance bed2 of RPicView
	(properties
		y 107
		x 104
		view 148
		loop 2
		cel 1
		priority 6
		signal 16384
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {bed})
		)
	)
)

(instance desk of RPicView
	(properties
		y 135
		x 283
		view 148
		loop 1
		cel 8
		priority 9
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/(drawer<desk),desk,(top[<desk])')
				(Print 48 18) ; "There is nothing of interest in the small desk."
			)
			((or (MousedOn self event 3) (Said 'look/desk'))
				(event claimed: 1)
				(if (== gAct 5)
					(Print 48 19) ; "Clarence is writing in his notebook at the small desk."
				else
					(Print 48 20) ; "You see a small writing desk against the right wall."
				)
			)
		)
	)
)

(instance table1 of RPicView
	(properties
		y 90
		x 63
		view 148
		loop 1
		cel 2
		priority 5
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 48 17) ; "It's a plain old dresser."
		)
	)
)

(instance chair of RPicView
	(properties
		y 137
		x 254
		view 148
		loop 2
		cel 3
		priority 9
	)

	(method (handleEvent event)
		(if (== gAct 6)
			(cond
				((Said 'get,straighten/chair')
					(Print 48 21) ; "Don't worry about the chair. You have other things to worry about."
				)
				((or (Said 'look/chair') (MousedOn self event 3))
					(event claimed: 1)
					(Print 48 22) ; "During some sort of struggle, the desk chair has been over-turned."
				)
			)
		)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance sofa of RPicView
	(properties
		y 157
		x 194
		view 148
		loop 1
		cel 7
		priority 11
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {couch})
		)
	)
)

(instance table2 of RPicView
	(properties
		y 157
		x 133
		view 148
		loop 1
		cel 6
		priority 11
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/nightstand>'))
			(cond
				((and (== gAct 2) (> [gCycleTimers 2] 2))
					(Print 48 23) ; "Upon the table you notice Clarence's cigar and drink."
					(event claimed: 1)
				)
				((MousedOn self event 3)
					(DoLook {table})
					(event claimed: 1)
				)
			)
		)
	)
)

(instance suit1 of RPicView
	(properties
		y 113
		x 214
		view 148
		loop 1
		cel 3
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 48 15) ; "You notice three suitcases next to the beds. They must belong to Rudy and Clarence."
		)
	)
)

(instance suit2 of RPicView
	(properties
		y 100
		x 72
		view 148
		loop 1
		cel 4
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 48 15) ; "You notice three suitcases next to the beds. They must belong to Rudy and Clarence."
		)
	)
)

(instance notebook of Prop
	(properties
		y 111
		x 282
		view 148
		loop 1
		cel 9
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(MousedOn self event 3)
					(Said 'look/desk')
					(Said 'look/top[<desk]')
				)
				(event claimed: 1)
				(Print 48 24) ; "Clarence has left his notebook on the small writing desk."
			)
			((Said 'rotate/page')
				(Print 48 25) ; "Only one page has been written on."
			)
			((Said 'open/notebook')
				(Print 48 26) ; "The notebook is already open."
			)
			((Said 'close/notebook')
				(Print 48 27) ; "You don't need to close it."
			)
			((Said 'get/notebook')
				(Print 48 28) ; "You don't need to carry around Clarence's notebook."
			)
			((Said 'look,read/notebook')
				(if (gEgo inRect: 249 118 306 144)
					(Room48 setScript: LookNote)
				else
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance lamp1 of Prop
	(properties
		y 44
		x 72
		view 148
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance lamp2 of Prop
	(properties
		y 43
		x 202
		view 148
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance panel of Act
	(properties
		y 84
		view 148
		illegalBits 0
	)
)

(instance stain of Prop
	(properties
		y 140
		x 244
		view 148
		loop 2
		cel 5
	)
)


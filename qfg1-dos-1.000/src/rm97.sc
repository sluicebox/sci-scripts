;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 97)
(include sci.sh)
(use Main)
(use n100)
(use n101)
(use n102)
(use n104)
(use n105)
(use n106)
(use Interface)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm97 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0 param1 &tmp [temp0 4] [temp4 400])
	(clr)
	(Format @temp4 &rest)
	(TextSize @[temp0 0] @temp4 gUserFont 0)
	(Print
		@temp4
		#at
		-1
		12
		#width
		(if (> [temp0 2] 24) 300 else 0)
		#mode
		1
		#title
		param1
	)
)

(instance rm97 of Rm
	(properties
		picture 97
		style 2
	)

	(method (dispose)
		(SetFlag 87)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 97 465 503)
		(LoadMany rsSOUND 88 66)
		(if (gEgo knows: 23) ; flameDartSpell
			(Load rsVIEW 522)
			(Load rsSCRIPT 100)
		)
		(if (gEgo knows: 20) ; dazzleSpell
			(Load rsVIEW 521)
			(Load rsSCRIPT 106)
		)
		(if (gEgo knows: 22) ; calmSpell
			(Load rsVIEW 521)
			(Load rsSCRIPT 104)
		)
		(if (gEgo knows: 17) ; openSpell
			(Load rsVIEW 521)
			(Load rsSCRIPT 105)
		)
		(gContMusic fade:)
		(super init:)
		(SolvePuzzle 711 12)
		(SL enable:)
		(NormalEgo)
		(dragon init: setPri: 0 addToPic:)
		(mula init: setPri: 11 addToPic:)
		(carpet init: addToPic:)
		(falcon init: setPri: 8 addToPic:)
		(vase init: addToPic:)
		(oscar init: setPri: 8 addToPic:)
		(book init: setPri: 9 addToPic:)
		(mirror setPri: 9 init: stopUpd:)
		(door init: stopUpd:)
		(eyes init: setPri: 1)
		(torchL init: setCycle: Fwd)
		(torchR init: setCycle: Fwd)
		(eyes init: setScript: blink)
		(switch gPrevRoomNum
			(172 ; rmBrig
				(HandsOff)
				(if (IsFlag 273)
					(= local3 1)
					(leader
						init:
						setLoop: 5
						setCel: 0
						setPri: 11
						posn: 129 142
						setScript: elsaIsBack
					)
					(gEgo init: loop: 1 posn: 237 159)
					(yorick init: illegalBits: 0 posn: 316 142)
				else
					(= local2 1)
					(leader
						setLoop: 3
						setCel: 0
						init:
						setPri: 9
						posn: 129 142
						setScript: elsaKillsEgo
					)
					(gEgo init: loop: 1 setPri: 10 posn: 178 141)
					(yorick init: posn: 316 142)
				)
			)
			(else
				(= local2 1)
				(leader init: setPri: 11 illegalBits: 0 setScript: leaderVaults)
				(gEgo init: setScript: egoEnters)
				(elsaSong init:)
			)
		)
	)

	(method (doit)
		(if (== (gEgo edgeHit:) EDGE_RIGHT)
			(if (gEgo has: 40) ; mirror
				(gCurRoom newRoom: 84)
			else
				(gCurRoom newRoom: 600) ; EndGame
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((super handleEvent: event))
					((MouseClaimed gEgo event 3)
						(HighPrint 97 0) ; "You finally made it through Yorick's room."
					)
				)
			)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'rest,nap')
						(EgoDead 97 1 80 {Z-Z-Z-Z-Z-Z-Z-Z-Z-Z} 82 800 0 0) ; "The Brigands oblige you by making your pleasant rest permanent!"
					)
					((Said 'look>')
						(cond
							((Said '[<at,around][/place,area]')
								(HighPrint 97 2) ; "The Leader's room is filled with treasures."
							)
							((Said '/falcon,statue')
								(HighPrint 97 3) ; "Used to belong to Bogey."
							)
							((Said '/west,east,south')
								(HighPrint 97 4) ; "You see loot from brigand raids stacked against the walls."
							)
							((Said '/north,desk')
								(HighPrint 97 5) ; "You see a desk. On the desk is a book and a mirror."
							)
							((Said '/yorick')
								(if local4
									(HighPrint 97 6) ; "What a funny guy!"
								else
									(HighPrint 97 7) ; "He's not here."
								)
							)
							((Said '/carpet')
								(HighPrint 97 8) ; "This looks like a Persian carpet. It has a license plate that says " Abdulla Doo 222"."
							)
							((Said '/woman,man')
								(cond
									(local2
										(HighPrint 97 9) ; "The brigand leader wears a sword, and it looks well used."
									)
									(local3
										(HighPrint 97 10) ; "Elsa looks much better in a dress."
										(HighPrint 97 11) ; "It depends on your taste, though, I suppose."
									)
									(else
										(HighPrint 97 12) ; "Everybody else is gone."
									)
								)
							)
							(else
								(HighPrint 97 2) ; "The Leader's room is filled with treasures."
								(event claimed: 1)
							)
						)
					)
					(
						(or
							(Said
								'cast,use,throw,splash/disenchant,potion[<disenchant]'
							)
							(Said 'disenchant')
						)
						(if (gEgo has: 38) ; disenchant potion
							(SetFlag 273)
							(gEgo use: 38) ; disenchant potion
							(HighPrint 97 13) ; "You throw the Dispel Potion on the brigand leader."
						else
							(HighPrint 97 14) ; "Good idea, but you don't have that potion."
						)
					)
					((Said 'cast>')
						(= temp0 (SaidSpell event))
						(if (CastSpell temp0)
							(switch temp0
								(18
									(if local2
										(HighPrint 97 15) ; "You sense a strong magical aura on the brigand leader."
									)
									(if (not (gEgo has: 40)) ; mirror
										(HighPrint 97 16) ; "The hand mirror on the desk radiates a powerful magical aura."
									)
									(HighPrint 97 17) ; "You sense magical auras from the large carpet and several other objects in the room, but you don't have time to investigate."
								)
								(20
									(CastDazzle)
								)
								(23
									(CastDart 0)
								)
								(22
									(CastCalm)
								)
								(17
									(CastOpen)
								)
								(else
									(HighPrint 97 18) ; "That spell is useless here."
								)
							)
						)
					)
					((Said 'throw/dagger')
						(ThrowKnife 0)
					)
					((Said 'throw/boulder')
						(ThrowRock 0)
					)
					((Said 'get/boulder')
						(HighPrint 97 19) ; "There are no rocks here."
					)
					((Said 'open[/gate,door]')
						(HighPrint 97 20) ; "That would be foolhardy. You would let the brigands in."
					)
					((Said 'get,get/mirror')
						(cond
							(
								(and
									(gEgo inRect: 100 108 233 135)
									(not (gEgo has: 40)) ; mirror
								)
								(HighPrint 97 21) ; "You pick up the mirror and store it away."
								(SolvePuzzle 715 10)
								(gEgo get: 40) ; mirror
								(mirror dispose:)
							)
							((gEgo has: 40) ; mirror
								(HighPrint 97 22) ; "You already have the mirror."
							)
							(else
								(HighPrint 97 23) ; "You're not near the mirror."
							)
						)
					)
					((Said 'get,get/potion')
						(cond
							(
								(and
									(gEgo inRect: 100 108 233 135)
									(not local1)
								)
								(HighPrint 97 24) ; "You place the two Healing Potions into your pack."
								(gEgo get: 34) ; healing
								(gEgo get: 34) ; healing
								(= local1 1)
							)
							((gEgo inRect: 100 108 233 135)
								(HighPrint 97 25) ; "There are no more potions here."
							)
							(else
								(NotClose)
							)
						)
					)
					((Said 'search/desk')
						(if (gEgo inRect: 100 108 233 135)
							(cond
								((and (gEgo has: 40) local1) ; mirror
									(HighPrint 97 26) ; "You find nothing more."
								)
								(local1
									(HighPrint 97 27) ; "You see a mirror."
								)
								((gEgo has: 40) ; mirror
									(HighPrint 97 28) ; "You find two Healing Potions."
								)
								(else
									(HighPrint 97 29) ; "A quick but thorough search of the desk discloses two Healing Potions and a mirror."
								)
							)
						else
							(NotClose)
						)
					)
					((Said 'get')
						(= local0 1)
						(if (and (gEgo has: 34) (gEgo has: 40)) ; healing, mirror
							(HighPrint 97 30) ; "You don't have time to take anything else."
						else
							(HighPrint 97 31) ; "Take only those things that will serve your quest. Your time is limited."
						)
					)
				)
			)
		)
	)
)

(instance dragon of View
	(properties
		y 92
		x 159
		view 97
	)
)

(instance mula of View
	(properties
		y 144
		x 285
		view 97
		cel 1
		priority 11
	)
)

(instance carpet of View
	(properties
		y 164
		x 273
		view 97
		cel 2
		priority 12
	)
)

(instance falcon of View
	(properties
		y 92
		x 256
		view 97
		cel 3
		priority 8
	)
)

(instance vase of View
	(properties
		y 151
		x 298
		view 97
		cel 4
		priority 11
	)
)

(instance oscar of View
	(properties
		y 81
		x 65
		view 97
		cel 5
		priority 10
	)
)

(instance book of View
	(properties
		y 108
		x 160
		view 97
		cel 6
		priority 9
	)
)

(instance mirror of View
	(properties
		y 109
		x 125
		view 97
		cel 7
		priority 9
	)
)

(instance eyes of Prop
	(properties
		y 75
		x 159
		view 97
		loop 1
		cel 1
		priority 1
	)
)

(instance torchL of Prop
	(properties
		y 76
		x 91
		view 97
		loop 2
		cel 4
	)
)

(instance door of Prop
	(properties
		y 190
		x 232
		view 97
		loop 8
	)
)

(instance torchR of Prop
	(properties
		y 76
		x 225
		view 97
		loop 2
		cel 2
	)
)

(instance leader of Act
	(properties
		y 123
		x 164
		view 97
		loop 4
	)
)

(instance yorick of Act
	(properties
		y 142
		x 316
		view 97
		loop 6
	)
)

(instance brig1 of Act
	(properties
		view 465
	)
)

(instance brig2 of Act
	(properties
		view 465
	)
)

(instance brig3 of Act
	(properties
		view 465
	)
)

(instance elsaSong of Sound
	(properties
		number 88
		priority 1
	)
)

(instance tromp of Sound
	(properties
		number 66
		priority 3
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					posn: 230 195
					illegalBits: 0
					setMotion: MoveTo 197 141 self
				)
			)
			(1
				(NormalEgo)
				(gEgo loop: 1 illegalBits: $8004)
				(self dispose:)
			)
		)
	)
)

(instance blink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(eyes setCycle: Fwd)
				(= cycles (Random 2 9))
			)
			(2
				(eyes setCycle: Beg)
				(self changeState: 0)
			)
		)
	)
)

(instance leaderVaults of Script
	(properties)

	(method (doit)
		(if (and (== state 1) (== (elsaSong prevSignal:) 10))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leader setLoop: 4 setCel: 1 posn: 164 122)
				(= seconds 5)
			)
			(1
				(elsaSong play:)
			)
			(2
				(User canInput: 1)
				(leader setCel: 2 posn: 164 120)
				(= cycles 2)
			)
			(3
				(leader setCel: 3 posn: 158 123)
				(= cycles 2)
			)
			(4
				(leader setCel: 4 posn: 152 126)
				(= cycles 2)
			)
			(5
				(leader setCel: 5 posn: 146 129)
				(= cycles 2)
			)
			(6
				(leader setCel: 6 posn: 140 132)
				(= cycles 2)
			)
			(7
				(leader setCel: 7 posn: 134 135)
				(= cycles 2)
			)
			(8
				(leader setCel: 8 illegalBits: $8000 posn: 128 138)
				(= cycles 2)
			)
			(9
				(leader setCel: 9 setPri: -1 posn: 122 141)
				(= seconds 5)
			)
			(10
				(gCurRoom newRoom: 172) ; rmBrig
				(self dispose:)
			)
		)
	)
)

(instance elsaIsBack of Script
	(properties)

	(method (doit)
		(if (and (<= 8 state 9) local0)
			(self changeState: 10)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(localproc_0 {Elsa} 97 32)
				(localproc_0 {Elsa} 97 33)
				(localproc_0 {Elsa} 97 34)
				(localproc_0 {Elsa} 97 35)
				(localproc_0 {Elsa} 97 36)
				(= cycles 1)
			)
			(2
				(yorick
					setLoop: 6
					setCel: 0
					setCycle: Walk
					cycleSpeed: 2
					setMotion: MoveTo 258 142 self
				)
				(= local4 1)
			)
			(3
				(localproc_0 {Yorick} 97 37)
				(localproc_0 {Yorick} 97 38)
				(localproc_0 {Yorick} 97 39)
				(= cycles 2)
			)
			(4
				(localproc_0 {Elsa} 97 40)
				(localproc_0 {Elsa} 97 41)
				(localproc_0 {Elsa} 97 42)
				(localproc_0 {Elsa} 97 43)
				(= cycles 2)
			)
			(5
				(tromp number: (SoundFX 66) init: loop: 4 play:)
				(localproc_0 {Yorick} 97 44)
				(= cycles 2)
			)
			(6
				(leader setCycle: End self)
				(= local3 0)
			)
			(7
				(leader ignoreActors:)
				(yorick setLoop: 7 setCel: 0 setCycle: End self)
				(HandsOn)
				(tromp loop: 4 play:)
				(= local4 0)
			)
			(8
				(HighPrint 97 45) ; "The brigands are trying to break into the room."
				(yorick dispose:)
				(tromp loop: 6 play:)
				(= seconds 20)
			)
			(9
				(tromp loop: 6 play:)
				(= seconds 15)
			)
			(10
				(HandsOff)
				(door setCel: 1)
				(brig1
					init:
					setCycle: Walk
					posn: 259 230
					setMotion: MoveTo 259 202
				)
				(brig2
					init:
					setCycle: Walk
					posn: 242 247
					setMotion: MoveTo 242 214
				)
				(brig3
					init:
					setCycle: Walk
					posn: 278 250
					setMotion: MoveTo 278 214 self
				)
			)
			(11
				(EgoDead 97 46 82 516 0 9 80 {Wearing out your welcome.}) ; "Thinking about all that treasure cost you time and more. Some folks just don't know when to leave."
			)
		)
	)
)

(instance elsaKillsEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leader cycleSpeed: 1 setCycle: End self)
			)
			(1
				(= cycles 6)
			)
			(2
				(leader cycleSpeed: 1 setCycle: Beg)
				(= cycles 16)
			)
			(3
				(gEgo
					view: 503
					setLoop: 0
					setCel: 0
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(4
				(yorick
					setLoop: 6
					setCel: 0
					setCycle: Walk
					cycleSpeed: 2
					setMotion: MoveTo 258 142
				)
				(= cycles 32)
			)
			(5
				(localproc_0 {Yorick} 97 47)
				(= cycles 1)
			)
			(6
				(EgoDead 97 48 82 503 0 7 80 {One thrust...and that's it???}) ; "The brigand leader is deadly with a sword. The magic spell that possesses her makes her an invincible warrior."
			)
		)
	)
)


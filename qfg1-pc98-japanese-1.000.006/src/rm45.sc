;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm45 0
)

(local
	local0
	[local1 36] = [32 0 0 0 32 83 114 101 140 59 221 69 248 59 300 67 173 71 251 81 239 85 300 99 256 141 300 151 203 153 292 165 64 136 157 143]
	[local37 2]
	[local39 3]
	local42
	local43
	[local44 4]
	local48
	local49
	local50
	local51
	local52
	local53
	[local54 10]
	local64
	local65 = 10
	[local66 30] = [100 150 200 225 400 625 750 850 950 1050 2 2 2 2 2 2 2 2 2 2 0 0 0 0 0 0 0 0 0 0]
	local96
	local97
	local98
	local99
	local100
	local101
	local102
	local103
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1)
	(= temp0 (- (param1 x:) (param2 x:)))
	(= temp1 (* 2 (- (param1 y:) (param2 y:))))
	(if (or (not (< -110 temp0 110)) (not (< -110 temp1 110)))
		(return 0)
	)
	(if (u< param3 (+ (* temp0 temp0) (* temp1 temp1)))
		(return 0)
	else
		(return 1)
	)
)

(procedure (localproc_1 param1 param2 &tmp temp0)
	(= [local37 0] param1)
	(= [local37 1] param2)
	(= [local39 0] (gEgo x:))
	(= [local39 1] (gEgo y:))
	(= local0 [local1 0])
	(= temp0 1)
	(while (and local0 temp0)
		(= temp0
			(localproc_2
				[local1 local0]
				[local1 (+ local0 1)]
				[local1 (+ local0 2)]
				[local1 (+ local0 3)]
			)
		)
		(-= local0 4)
	)
	(return temp0)
)

(procedure (localproc_2 param1 param2 param3 param4)
	(cond
		((localproc_3 param1 param2 param3 param4)
			(return 1)
		)
		((localproc_6 param1 param2 param3 param4)
			(return 1)
		)
		((localproc_4 param1 param2 param3 param4)
			(return 1)
		)
		(else
			(return 0)
		)
	)
)

(procedure (localproc_3 param1 param2 param3 param4)
	(cond
		(
			(and
				(localproc_5
					param1
					param2
					[local37 0]
					[local37 1]
					[local39 0]
					[local39 1]
				)
				(localproc_5
					param3
					param2
					[local37 0]
					[local37 1]
					[local39 0]
					[local39 1]
				)
				(localproc_5
					param1
					param4
					[local37 0]
					[local37 1]
					[local39 0]
					[local39 1]
				)
				(localproc_5
					param3
					param4
					[local37 0]
					[local37 1]
					[local39 0]
					[local39 1]
				)
			)
			(return 1)
		)
		(
			(or
				(localproc_5
					param1
					param2
					[local37 0]
					[local37 1]
					[local39 0]
					[local39 1]
				)
				(localproc_5
					param3
					param2
					[local37 0]
					[local37 1]
					[local39 0]
					[local39 1]
				)
				(localproc_5
					param1
					param4
					[local37 0]
					[local37 1]
					[local39 0]
					[local39 1]
				)
				(localproc_5
					param3
					param4
					[local37 0]
					[local37 1]
					[local39 0]
					[local39 1]
				)
			)
			(return 0)
		)
		(else
			(return 1)
		)
	)
)

(procedure (localproc_4 param1 param2 param3 param4 &tmp temp0)
	(= temp0 0)
	(if
		(!=
			(localproc_5 [local37 0] [local37 1] param1 param2 param1 param4)
			(localproc_5 [local39 0] [local39 1] param1 param2 param1 param4)
		)
		(++ temp0)
	)
	(if
		(!=
			(localproc_5 [local37 0] [local37 1] param1 param2 param3 param2)
			(localproc_5 [local39 0] [local39 1] param1 param2 param3 param2)
		)
		(++ temp0)
	)
	(if (< temp0 2)
		(return 1)
	else
		(return 0)
	)
	(if
		(!=
			(localproc_5 [local37 0] [local37 1] param3 param4 param1 param4)
			(localproc_5 [local39 0] [local39 1] param3 param4 param1 param4)
		)
		(++ temp0)
	)
	(if (< temp0 2)
		(return 1)
	else
		(return 0)
	)
	(if
		(!=
			(localproc_5 [local37 0] [local37 1] param3 param4 param3 param2)
			(localproc_5 [local39 0] [local39 1] param3 param4 param3 param2)
		)
		(++ temp0)
	)
	(if (< temp0 2)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_5 param1 param2 param3 param4 param5 param6)
	(if
		(>
			(+
				(* param6 param3)
				(- (* param5 param4))
				(* param1 (- param4 param6))
				(* param2 (- param5 param3))
			)
			0
		)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_6 param1 param2 param3 param4)
	(cond
		(
			(and
				(localproc_7 param1 param2)
				(localproc_7 param3 param2)
				(localproc_7 param1 param4)
				(localproc_7 param3 param4)
			)
			(return 1)
		)
		(
			(or
				(localproc_7 param1 param2)
				(localproc_7 param3 param2)
				(localproc_7 param1 param4)
				(localproc_7 param3 param4)
			)
			(return 0)
		)
		(else
			(return 1)
		)
	)
)

(procedure (localproc_7 param1 param2)
	(if
		(>
			(+
				(* [local37 0] [local37 0])
				(* [local37 1] [local37 1])
				(- (+ (* [local39 0] [local37 0]) (* [local39 1] [local37 1])))
				(* param2 (- [local39 1] [local37 1]))
				(* param1 (- [local39 0] [local37 0]))
			)
			0
		)
		(return 1)
	else
		(return 0)
	)
)

(instance rm45 of Rm
	(properties
		picture 45
		style 8
		horizon 48
		north 33
		east 51
		south 62
		west 44
	)

	(method (dispose)
		(SetFlag 35)
		(if (== gPrevRoomNum 445) ; goblinArena
			(= global332 0)
		)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(SL enable:)
		(self setLocales: 804)
		(LoadMany rsVIEW 446 445)
		(NormalEgo)
		(gEgo init:)
		(gContMusic stop:)
		(goblinS play:)
		(if (not global331)
			(Load rsVIEW 448)
			(movingBush init: setScript: bushAttacks)
		)
		(goblin1 x: (+ 35 (Random 0 25)) init: setScript: goblin1Leaves)
		(goblin2 x: (+ 195 (Random 0 35)) init: setScript: goblin2Leaves)
		(goblin5 init: hide: setScript: goblin5Leaves)
		(if (> gHowFast 0)
			(goblin6 init: hide: setScript: goblin6Leaves)
			(if (> gHowFast 1)
				(goblin3
					x: (- 310 (Random 0 20))
					init:
					setScript: goblin3Leaves
				)
				(goblin4 init: hide: setScript: goblin4Leaves)
			)
		)
		(switch gPrevRoomNum
			(33
				(gEgo posn: 130 50 setMotion: MoveTo 130 60)
			)
			(51
				(gEgo posn: 318 108 setMotion: MoveTo 305 108)
			)
			(44
				(gEgo posn: 1 120 setMotion: MoveTo 15 120)
			)
			(445 ; goblinArena
				(if global333
					(EgoGait 1 0) ; running
					(gEgo posn: 318 108 setMotion: MoveTo 255 108)
				else
					(Load rsVIEW 519)
					(gEgo posn: 185 125 setScript: egoVictorious)
					(switch global331
						(0)
						(1
							(deadGoblin1 setPri: 6 init:)
							(self setScript: firstDeadGoblin)
						)
						(2
							(deadGoblin2 init:)
							(deadGoblin3 init:)
						)
						(3
							(deadGoblin1 setPri: 6 init:)
							(deadGoblin5 init:)
							(deadGoblin6 init:)
						)
						(4
							(deadGoblin1 setPri: 6 init:)
							(deadGoblin2 init:)
							(deadGoblin3 init:)
							(deadGoblin4 init:)
						)
						(5
							(deadGoblin1 setPri: 6 init:)
							(deadGoblin2 init:)
							(deadGoblin3 init:)
							(deadGoblin4 init:)
							(deadGoblin5 init:)
						)
						(6
							(deadGoblin1 setPri: 6 init:)
							(deadGoblin2 init:)
							(deadGoblin3 init:)
							(deadGoblin4 init:)
							(deadGoblin5 init:)
							(deadGoblin6 init:)
						)
						(7
							(deadGoblin1 setPri: 6 init:)
							(deadGoblin2 init:)
							(deadGoblin3 init:)
							(deadGoblin4 init:)
							(deadGoblin5 init:)
							(deadGoblin6 init:)
							(deadGoblin7 setPri: 6 init:)
						)
						(else
							(deadGoblin1 setPri: 6 init:)
							(deadGoblin2 init:)
							(deadGoblin3 init:)
							(deadGoblin4 init:)
							(deadGoblin5 init:)
							(deadGoblin6 init:)
							(deadGoblin7 setPri: 6 init:)
							(deadGoblin8 init:)
						)
					)
				)
			)
			(else
				(gEgo posn: 160 189 setMotion: MoveTo 160 165)
			)
		)
		(if (or (!= gPrevRoomNum 445) global333) ; goblinArena
			(switch global331
				(0
					(if (IsFlag 232)
						(= local51 1)
					)
				)
				(1
					(= local51 1)
					(= local49 1)
				)
				(2
					(= local51 1)
					(= local49 1)
					(= local43 1)
				)
				(3
					(= local51 1)
					(= local49 1)
					(= local43 1)
				)
				(else
					(= local51 1)
					(= local49 1)
					(= local43 1)
					(= local53 1)
				)
			)
		)
	)

	(method (doit)
		(if (gEgo edgeHit:)
			(SetFlag 232)
			(goblinS stop:)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look,look>')
						(cond
							((Said '/bush')
								(HighPrint 45 0) ; "You seem to see movement, but you are not certain what is over there."
							)
							((Said '/boulder')
								(HighPrint 45 1) ; "The rocks look as if they were deliberately piled."
							)
							((Said '/north,south,east,west')
								(HighPrint 45 2) ; "You see forest."
							)
							((Said '/man,creature,monster,goblin')
								(HighPrint 45 3) ; "You see a Goblin, a small but dangerous humanoid."
							)
							((Said '/cave')
								(if (gEgo inRect: 0 0 106 86)
									(HighPrint 45 4) ; "You see a small cave concealed in the rocks. The cave is not big enough for you to enter. This is where the Goblins hide."
								else
									(HighPrint 45 5) ; "You can not see a cave."
								)
							)
							((Said '[/!*]')
								(HighPrint 45 6) ; "Something about the bushes here gives you a very bad feeling."
							)
						)
					)
					((Said 'search/goblin,body,man,creature')
						(HighPrint 45 7) ; "You're not close to anything matching that description."
					)
					((Said 'search[/room]')
						(cond
							((gEgo inRect: 0 0 106 86)
								(HighPrint 45 8) ; "You find a small cave concealed in the rocks, just big enough for the Goblins to come through."
							)
							((gEgo inRect: 106 0 187 86)
								(HighPrint 45 9) ; "Nothing here, but you'r e HOT!"
							)
							((gEgo inRect: 187 0 320 86)
								(HighPrint 45 10) ; "Nothing here, but you're warm."
							)
							((gEgo inRect: 0 86 106 134)
								(HighPrint 45 11) ; "Nothing here, you're warm."
							)
							((gEgo inRect: 106 86 187 134)
								(HighPrint 45 10) ; "Nothing here, but you're warm."
							)
							((gEgo inRect: 187 86 320 134)
								(HighPrint 45 12) ; "Nothing here, you're cold."
							)
							(else
								(HighPrint 45 13) ; "Nothing here, you're frigid."
							)
						)
					)
					(
						(Said
							'japaneseclimbdown,climb,climb,enter,go/cave,chasm,boulder'
						)
						(HighPrint 45 14) ; "The cave opening is too small and the rocks are too hard for you to be able to enter."
					)
					(
						(Said
							'close,close,close,close,block,block/cave,chasm,boulder'
						)
						(HighPrint 45 15) ; "The rocks are too large and heavy to move."
					)
					((Said 'enlarge,break,hit,enlarge/cave,cave,chasm')
						(HighPrint 45 16) ; "You can't do that. Maybe in the next game. We're getting behind schedule."
					)
					((Said 'attack[/goblin,creature,man]')
						(HighPrint 45 17) ; "Looks like no one has the stomach to fight you."
					)
					((Said 'move,move,force/boulder')
						(HighPrint 45 18) ; "The rock are too large and heavy to move."
					)
				)
			)
		)
	)
)

(instance goblin1 of Act
	(properties
		y 81
		x 59
		view 445
		loop 2
		illegalBits 0
	)

	(method (doit)
		(if (and local42 local43)
			(= local42 0)
			(self setMotion: MoveTo 146 (self y:))
			(= [local54 local64] (Clone goblinAttacks))
			(self setScript: [local54 local64] 0 local64)
			(++ local64)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) evMOUSEBUTTON) (MouseClaimed goblin1 event 3))
				(HighPrint 45 19) ; "It's R2D4!"
			)
		)
	)
)

(instance goblin2 of Act
	(properties
		y 70
		x 200
		view 445
		loop 2
		illegalBits 0
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) evMOUSEBUTTON) (MouseClaimed goblin2 event 3))
				(HighPrint 45 20) ; "It's Hollywood, a virtual Goblin!"
			)
		)
	)
)

(instance goblin3 of Act
	(properties
		y 58
		x 296
		view 445
		loop 2
		illegalBits 0
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) evMOUSEBUTTON) (MouseClaimed goblin3 event 3))
				(HighPrint 45 21) ; "It's Droopy!"
			)
		)
	)
)

(instance goblin4 of Act
	(properties
		y 69
		x 207
		view 445
		loop 2
		illegalBits 0
	)

	(method (doit)
		(if (and local48 local49)
			(= local48 0)
			(self setMotion: MoveTo 156 69)
			(= [local54 local64] (Clone goblinAttacks))
			(self setScript: [local54 local64] 0 local64)
			(++ local64)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) evMOUSEBUTTON) (MouseClaimed goblin4 event 3))
				(HighPrint 45 22) ; "It's Sneaky!"
			)
		)
	)
)

(instance goblin5 of Act
	(properties
		y 173
		x 42
		view 445
		loop 3
		illegalBits 0
	)

	(method (doit)
		(if (and local50 local51)
			(= local50 0)
			(self setMotion: MoveTo 42 125)
			(= [local54 local64] (Clone goblinAttacks))
			(self setScript: [local54 local64] 0 local64)
			(++ local64)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) evMOUSEBUTTON) (MouseClaimed goblin5 event 3))
				(HighPrint 45 23) ; "It's Nickaroo, a real Goblin!"
			)
		)
	)
)

(instance goblin6 of Act
	(properties
		y 84
		x 298
		view 445
		loop 3
		illegalBits 0
	)

	(method (doit)
		(if (and local52 local53)
			(= local52 0)
			(self setMotion: MoveTo 200 84)
			(= [local54 local64] (Clone goblinAttacks))
			(self setScript: [local54 local64] 0 local64)
			(++ local64)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) evMOUSEBUTTON) (MouseClaimed goblin6 event 3))
				(HighPrint 45 24) ; "It's JohnnyFive!"
			)
		)
	)
)

(instance movingBush of Act
	(properties
		y 94
		x 235
		view 448
		loop 4
	)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (MouseClaimed movingBush event 3))
			(HighPrint 45 25) ; "One strange bush!"
		)
		(if (Said 'kill,attack/bush,tree')
			(HighPrint 45 26) ; "A Goblin steps out of the bush."
			(goblinS stop:)
			(= global332 445)
			(gCurRoom newRoom: 445) ; goblinArena
		)
	)
)

(instance deadGoblin1 of View
	(properties
		y 88
		x 79
		view 446
		cel 1
		priority 6
	)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (MouseClaimed self event 3))
			(HighPrint 45 27) ; "The only good Goblin is a dead Goblin!"
		)
		(if (Said 'search/enemy,goblin,body,man,creature')
			(cond
				((and (not local96) (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 28) ; "You find 5 silvers concealed in a pouch. You take the silvers."
					(= local96 1)
					(Purchase -5)
				)
				((and local96 (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 29) ; "You've already taken his money."
				)
				(else
					(event claimed: 0)
				)
			)
		)
		(if (Said 'look,look/goblin')
			(HighPrint 45 30) ; "You've seen one dead Goblin, you've seen 'em all."
		)
	)
)

(instance deadGoblin2 of View
	(properties
		y 118
		x 235
		view 446
		cel 3
	)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (MouseClaimed self event 3))
			(HighPrint 45 31) ; "What's he staring at?"
		)
		(if (Said 'search/enemy,goblin,body,man,creature')
			(cond
				((and (not local97) (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 32) ; "You find 4 silvers tucked in his tunic. He has no use for the silvers. Into your pocket they go."
					(= local97 1)
					(Purchase -4)
				)
				((and local97 (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 29) ; "You've already taken his money."
				)
				(else
					(event claimed: 0)
				)
			)
		)
		(if (Said 'look,look/goblin')
			(HighPrint 45 30) ; "You've seen one dead Goblin, you've seen 'em all."
		)
	)
)

(instance deadGoblin3 of View
	(properties
		y 66
		x 130
		view 446
	)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (MouseClaimed self event 3))
			(HighPrint 45 33) ; "Strange place to take a nap."
		)
		(if (Said 'search/enemy,goblin,body,man,creature')
			(cond
				((and (not local98) (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 34) ; "The poor slob was the big loser at the poker game. He didn't even have lunch money."
					(= local98 1)
				)
				((and local98 (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 35) ; "He didn't have anything."
				)
				(else
					(event claimed: 0)
				)
			)
		)
		(if (Said 'look,look/goblin')
			(HighPrint 45 30) ; "You've seen one dead Goblin, you've seen 'em all."
		)
	)
)

(instance deadGoblin4 of View
	(properties
		y 128
		x 160
		view 446
		loop 1
		cel 3
	)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (MouseClaimed self event 3))
			(HighPrint 45 36) ; "He's getting a sun tan?"
		)
		(if (Said 'search/enemy,goblin,body,man,creature')
			(cond
				((and (not local99) (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 37) ; "It's your lucky day, this was the big winner at last night's poker game. You take his 35 silvers."
					(= local99 1)
					(Purchase -35)
				)
				((and local99 (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 29) ; "You've already taken his money."
				)
				(else
					(event claimed: 0)
				)
			)
		)
		(if (Said 'look,look/goblin')
			(HighPrint 45 30) ; "You've seen one dead Goblin, you've seen 'em all."
		)
	)
)

(instance deadGoblin5 of View
	(properties
		y 168
		x 292
		view 446
		cel 2
	)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (MouseClaimed self event 3))
			(HighPrint 45 38) ; "A good Goblin!"
		)
		(if (Said 'search/enemy,goblin,body,man,creature')
			(cond
				((and (not local100) (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 39) ; "In this Goblin's left shoe you find 8 silvers. You look around and slip the silvers into your pocket."
					(= local100 1)
					(Purchase -8)
				)
				((and local100 (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 29) ; "You've already taken his money."
				)
				(else
					(event claimed: 0)
				)
			)
		)
		(if (Said 'look,look/goblin')
			(HighPrint 45 30) ; "You've seen one dead Goblin, you've seen 'em all."
		)
	)
)

(instance deadGoblin6 of View
	(properties
		y 162
		x 82
		view 446
		loop 1
		cel 2
	)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (MouseClaimed self event 3))
			(HighPrint 45 40) ; "Does anyone know CPR?"
		)
		(if (Said 'search/enemy,goblin,body,man,creature')
			(cond
				((and (not local101) (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 41) ; "Clutched in his hand are 4 silvers. You take the money."
					(= local101 1)
					(Purchase -4)
				)
				((and local101 (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 29) ; "You've already taken his money."
				)
				(else
					(event claimed: 0)
				)
			)
		)
		(if (Said 'look,look/goblin')
			(HighPrint 45 30) ; "You've seen one dead Goblin, you've seen 'em all."
		)
	)
)

(instance deadGoblin7 of View
	(properties
		y 75
		x 13
		view 446
		loop 1
		cel 1
	)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (MouseClaimed self event 3))
			(HighPrint 45 42) ; "Limp as a dishrag."
		)
		(if (Said 'search/enemy,goblin,body,man,creature')
			(cond
				((and (not local102) (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 43) ; "This guy lost all his dough to a loan shark."
					(= local102 1)
				)
				((and local102 (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 44) ; "You've know he's broke."
				)
				(else
					(event claimed: 0)
				)
			)
		)
		(if (Said 'look,look/goblin')
			(HighPrint 45 30) ; "You've seen one dead Goblin, you've seen 'em all."
		)
	)
)

(instance deadGoblin8 of View
	(properties
		y 135
		x 30
		view 446
		loop 1
	)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (MouseClaimed self event 3))
			(HighPrint 45 45) ; "He lost."
		)
		(if (Said 'search/enemy,goblin,body,man,creature')
			(cond
				((and (not local103) (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 46) ; "The Goblin government lost his paycheck."
					(= local103 1)
				)
				((and local103 (<= (gEgo distanceTo: self) 30))
					(HighPrint 45 47) ; "He never had any money."
				)
				(else
					(event claimed: 0)
				)
			)
		)
		(if (Said 'look,look/goblin')
			(HighPrint 45 30) ; "You've seen one dead Goblin, you've seen 'em all."
		)
	)
)

(instance goblin1Leaves of Script
	(properties)

	(method (doit)
		(if (and (< state 6) (< (gEgo y:) 100))
			(self changeState: 6)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(6
				(= local42 1)
				(client setCycle: Walk setMotion: MoveTo -400 (client y:) self)
			)
			(7
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance goblin2Leaves of Script
	(properties)

	(method (doit)
		(if (and (< state 6) (< (gEgo y:) 155) (> (gEgo x:) 135))
			(self changeState: 6)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(6
				(client setCycle: Walk setMotion: MoveTo 262 70 self)
			)
			(7
				(client setMotion: MoveTo 262 80 self)
			)
			(8
				(client setMotion: MoveTo 410 80 self)
			)
			(9
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance goblin3Leaves of Script
	(properties)

	(method (doit)
		(if (and (< state 6) (< (gEgo y:) 155) (> (gEgo x:) 135))
			(self changeState: 6)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(6
				(= cycles 8)
			)
			(7
				(client setCycle: Walk setMotion: MoveTo 247 58 self)
			)
			(8
				(client setMotion: MoveTo 247 72 self)
			)
			(9
				(client setMotion: MoveTo 410 72 self)
			)
			(10
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance goblin4Leaves of Script
	(properties)

	(method (doit)
		(if
			(and
				(< state 6)
				(or (> (gEgo y:) 120) (< (gEgo x:) 100))
				(not (gCast contains: goblin2))
			)
			(self changeState: 6)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(6
				(client show: setCycle: Walk setMotion: MoveTo 237 69 self)
				(= local48 1)
			)
			(7
				(client setMotion: MoveTo 237 53 self)
			)
			(8
				(client setMotion: MoveTo 310 53 self)
			)
			(9
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance goblin5Leaves of Script
	(properties)

	(method (doit)
		(if
			(and
				(< state 6)
				(or (< (gEgo y:) 95) (> (gEgo x:) 220))
				(not (gCast contains: goblin3))
			)
			(self changeState: 6)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(6
				(= local50 1)
				(client show: setCycle: Walk setMotion: MoveTo 42 125 self)
			)
			(7
				(client setMotion: MoveTo -10 125 self)
			)
			(8
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance goblin6Leaves of Script
	(properties)

	(method (doit)
		(if
			(and
				(< state 6)
				(> (gEgo y:) 100)
				(< (gEgo x:) 150)
				(not (gCast contains: goblin3))
			)
			(self changeState: 6)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(6
				(client show: setCycle: Walk setMotion: MoveTo 265 84 self)
			)
			(7
				(= local52 1)
				(= seconds 2)
			)
			(8
				(client setMotion: MoveTo 265 66 self)
			)
			(9
				(client setMotion: MoveTo 235 66 self)
			)
			(10
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance goblinAttacks of Script
	(properties)

	(method (doit)
		(if
			(and
				[local66 (+ register local65 local65)]
				(localproc_0 client gEgo (+ [local66 register] 5))
			)
			(goblinS stop:)
			(= global332 445)
			(gCurRoom newRoom: 445) ; goblinArena
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'attack[/goblin,creature,man]')
						(HighPrint 45 48) ; "You'll fight all right."
						(goblinS stop:)
						(= global332 445)
						(gCurRoom newRoom: 445) ; goblinArena
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client illegalBits: -32768)
				(= seconds (Random 2 5))
			)
			(1
				(if
					(and
						(not (localproc_0 client gEgo [local66 register]))
						(localproc_1 (client x:) (client y:))
					)
					(self changeState: 5)
				else
					(self changeState: 2)
				)
			)
			(2
				(= cycles 10)
			)
			(3
				(self changeState: 1)
			)
			(5
				(client setMotion: MoveTo (gEgo x:) (gEgo y:))
				(if [local66 (+ register local65)]
					(-- [local66 (+ register local65)])
				else
					(= [local66 (+ register local65 local65)] 1)
				)
				(= cycles 12)
			)
			(6
				(client setMotion: 0)
				(self changeState: 1)
			)
		)
	)
)

(instance bushAttacks of Script
	(properties)

	(method (doit)
		(if
			(and
				(!= state 8)
				(!= state 0)
				(localproc_0 movingBush gEgo 5625)
			)
			(self changeState: 8)
		)
		(if (and (== state 8) (not (localproc_0 movingBush gEgo 7225)))
			(self changeState: 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(if (localproc_1 (client x:) (client y:))
					(self changeState: 5)
				else
					(self changeState: 2)
				)
			)
			(2
				(client setLoop: 4 setMotion: 0)
				(= cycles 15)
			)
			(3
				(self changeState: 1)
			)
			(5
				(client
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo (gEgo x:) (gEgo y:)
				)
				(= cycles 20)
			)
			(6
				(client setMotion: 0)
				(self changeState: 1)
			)
			(8
				(client setLoop: 4 setMotion: 0)
			)
		)
	)
)

(instance egoVictorious of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 519
					setLoop: 2
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(NormalEgo)
				(gEgo loop: 2)
				(HandsOn)
			)
		)
	)
)

(instance firstDeadGoblin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(= cycles 5)
			)
			(1
				(HighPrint 45 49) ; "Wow! You threw that dead goblin a long way!"
				(client setScript: 0)
			)
		)
	)
)

(instance goblinS of Sound
	(properties
		number 76
		priority 3
		loop -1
	)
)


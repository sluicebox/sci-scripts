;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use eRS)
(use PAvoider)
(use Scaler)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Door)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm250 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	local5 = 1
)

(instance rm250 of FPRoom
	(properties
		noun 19
		picture 250
		style 100
		east 260
		west 240
	)

	(method (init)
		(if (IsFlag 1)
			(= east 265)
		else
			(= east 260)
		)
		(if (IsFlag 59)
			(self setRegions: 90) ; streetRgn
		)
		(if (== gCurPuzzle 22)
			(self setRegions: 91) ; rowdyRgn
		)
		(gEgo init: setScale: Scaler 100 50 175 95 normalize:)
		(switch gPrevRoomNum
			(west
				(= style 12)
				(gGame handsOn:)
			)
			(east
				(= style 11)
				(if (< (gEgo y:) 103)
					(gEgo y: 103)
				)
				(gGame handsOn:)
			)
			(680
				(gGame handsOn:)
			)
			(600
				(gEgo edgeHit: EDGE_NONE)
			)
			(710
				(gEgo edgeHit: EDGE_NONE)
			)
			(235
				(if (== gCurPuzzle 10)
					(gEgo x: 260 y: 106 setHeading: 180 stopUpd:)
					(gCurRoom setScript: sReveireScreams)
				else
					(gGame handsOn:)
				)
			)
			(220
				(if (== gCurPuzzle 10)
					(gEgo x: 260 y: 106 setHeading: 180 stopUpd:)
					(gCurRoom setScript: sReveireScreams)
				else
					(gGame handsOn:)
				)
			)
			(26 ; actBreak
				(if (IsFlag 80)
					(ClearFlag 80)
					(gGame handsOn:)
				else
					(LoadMany rsSCRIPT 1814)
					(ClearFlag 84)
					(gCurRoom setScript: sSepiaStart)
				)
			)
			(else
				(gEgo x: 150 y: 150)
				(gGame handsOn:)
			)
		)
		(gCurRoom
			addObstacle:
				(cond
					((== gAct 1)
						((Polygon new:)
							type: PBarredAccess
							init: 0 103 0 0 319 0 319 103 298 103 286 110 262 103 262 79 257 79 257 103 203 103 104 101 43 105 34 105 33 76 27 76 26 105 14 105
							yourself:
						)
					)
					(
						(and
							(IsFlag 69)
							(not (IsFlag 64))
							(>= gCurPuzzle 13)
							(<= gCurPuzzle 14)
							(not (gEgo has: 0)) ; Baking_Soda
						)
						(= local1
							((Polygon new:)
								type: PBarredAccess
								init: 0 103 0 0 319 0 319 103 262 103 262 79 257 79 257 103 249 117 193 117 193 103 199 103 199 101 173 101 104 101 56 105 34 105 33 76 27 76 26 105 13 105
								yourself:
							)
						)
					)
					(else
						((Polygon new:)
							type: PBarredAccess
							init: 0 103 0 0 319 0 319 103 262 103 262 79 257 79 257 103 203 103 104 101 56 105 34 105 33 76 27 76 26 105 13 105
							yourself:
						)
					)
				)
				(if (and (>= gCurPuzzle 8) (<= gCurPuzzle 9))
					(= local3
						((Polygon new:)
							type: PBarredAccess
							init: 152 121 150 145 87 145 85 121 85 112 152 112
							yourself:
						)
					)
				else
					(= local3
						((Polygon new:)
							type: PBarredAccess
							init: 152 121 85 121 85 112 152 112
							yourself:
						)
					)
				)
				((Polygon new:)
					type: PBarredAccess
					init: 198 105 233 105 233 115 198 115
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 173 319 189 0 189 0 172
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 292 116 298 105 319 105 319 116
					yourself:
				)
		)
		(super init:)
		(if (IsFlag 1)
			(sheriffDoor init: locked: 1)
		else
			(sheriffDoor init:)
		)
		(pharmacyDoor init:)
		(sheriffOffice init: setOnMeCheck: 1 128)
		(thinTall init: approachVerbs: 4 setOnMeCheck: 1 256) ; Do
		(playhouse init: setOnMeCheck: 1 512)
		(pharmacy init: setOnMeCheck: 1 1024)
		(pharmacyPoles init: setOnMeCheck: 1 2048)
		(clutter init: setOnMeCheck: 1 4096)
		(rail init: setOnMeCheck: 1 8192)
		(sheriffSign init: setOnMeCheck: 26505)
		(tallThinSign init: setOnMeCheck: 26505)
		(playhouseSign init: setOnMeCheck: 26505)
		(pharmacySign init: setOnMeCheck: 26505)
		(playhouseDoor init: approachVerbs: 4 setOnMeCheck: 26505) ; Do
		(sheriffWindow init: setOnMeCheck: 26505)
		(pharmacyRight init: setOnMeCheck: 26505)
		(pharmacyLeft init: setOnMeCheck: 26505)
		(trough init: setOnMeCheck: 26505)
		(if (and (>= gCurPuzzle 8) (<= gCurPuzzle 9))
			(horse1
				init:
				cycleSpeed: 10
				setCycle: Fwd
				setScript: sHorseStuff
				approachVerbs: 65 ; Paper_Sack
			)
			(horse2
				init:
				cycleSpeed: 12
				setCycle: Fwd
				setScript: (sHorseStuff new:)
				approachVerbs: 65 ; Paper_Sack
			)
			(LoadMany rsSOUND 2116)
		)
		(if
			(and
				(IsFlag 69)
				(not (IsFlag 64))
				(>= gCurPuzzle 13)
				(<= gCurPuzzle 14)
				(not (gEgo has: 0)) ; Baking_Soda
			)
			(bakingSoda init: approachVerbs: 4) ; Do
		)
		(cond
			((<= gCurPuzzle 3)
				(indian1 init: approachVerbs: 4 2 9) ; Do, Talk, Door_Key
			)
			((<= gCurPuzzle 4)
				(indian2 init: approachVerbs: 4 2 9) ; Do, Talk, Door_Key
			)
			((and (<= gCurPuzzle 5) (not (IsFlag 37)) (== gPrevRoomNum 240))
				(indian2 setCycle: StopWalk -1 approachVerbs: 4 2 9 init:) ; Do, Talk, Door_Key
				(indian3
					x: 330
					y: 130
					setAvoider: PAvoider
					setCycle: StopWalk -1
					setScript: sEnterIndian
					approachVerbs: 4 2 9 ; Do, Talk, Door_Key
					init:
				)
			)
			(
				(and
					(<= gCurPuzzle 5)
					(not (IsFlag 37))
					(== gAct 1)
					(== gPrevRoomNum 260)
				)
				(indian2 setCycle: StopWalk -1 init:)
				(indian3
					x: -10
					setAvoider: PAvoider
					setCycle: StopWalk -1
					setScript: sEnterIndian
					init:
				)
			)
			((and (IsFlag 37) (< gCurPuzzle 7))
				(indian3 init: approachVerbs: 4 2 9) ; Do, Talk, Door_Key
			)
			((>= gCurPuzzle 7)
				(closedSign init: addToPic:)
			)
		)
		(cond
			((and (>= gCurPuzzle 2) (<= gCurPuzzle 6))
				(gGameMusic2 number: 600 flags: 1 loop: -1 play: setVol: 80)
				(gGameMusic1 number: 710 flags: 1 loop: -1 play: setVol: 0)
			)
			((== gCurPuzzle 14) 0)
			((OneOf gPrevRoomNum 600 26) ; actBreak
				(gGameMusic1 number: 710 flags: 1 loop: -1 play: setVol: 0)
			)
			((== gPrevRoomNum 710)
				(gGameMusic2 number: 600 flags: 1 loop: -1 play: setVol: 0)
			)
			(else
				(gGameMusic1
					number: 710
					flags: 1
					loop: -1
					play:
					setVol: (if (OneOf gPrevRoomNum 240 710) 80 else 0)
				)
				(gGameMusic2
					number: 600
					flags: 1
					loop: -1
					play:
					setVol: (if (OneOf gPrevRoomNum 260 600) 80 else 0)
				)
			)
		)
		(if (and (== gAct 3) (== global141 gCurRoomNum) (not (IsFlag 53)))
			(horsePlop init: approachVerbs: 4) ; Do
			(gCurRoom
				addObstacle:
					(= local2
						((Polygon new:)
							type: PBarredAccess
							init: 126 123 126 132 96 132 96 123
							yourself:
						)
					)
			)
		)
		(if (and (== gAct 3) (not (IsFlag 99)))
			(SetFlag 99)
			(whoopeeHorse init:)
			(whoopeeMan init: setLoop: 0 setScript: sWhoopee)
		)
		(if (IsFlag 18)
			(pharmacyDoor locked: 1)
		else
			(pharmacyDoor locked: 0)
		)
		(if (IsFlag 52)
			(dummyCredits init: setScript: (ScriptID 32 0)) ; sOpeningCredits
		)
	)

	(method (doit &tmp temp0 temp1 [temp2 2])
		(super doit:)
		(cond
			((and local0 (== (PalVary pvGET_CURRENT_STEP) 0))
				(sSepiaStart cue:)
				(= local0 0)
			)
			((== gCurPuzzle 14) 0)
			((<= (gEgo x:) 159)
				(if (> (gGameMusic2 vol:) 0)
					(gGameMusic2 setVol: 0)
				)
				(cond
					(
						(<
							(= temp0
								(GetDistance
									(gEgo x:)
									(gEgo y:)
									159
									(gEgo y:)
								)
							)
							20
						)
						(= temp0 20)
					)
					((> temp0 80)
						(= temp0 80)
					)
				)
				(gGameMusic1 setVol: temp0)
			)
			((>= (gEgo x:) 160)
				(if (> (gGameMusic1 vol:) 0)
					(gGameMusic1 setVol: 0)
				)
				(cond
					(
						(<
							(= temp1
								(GetDistance
									(gEgo x:)
									(gEgo y:)
									160
									(gEgo y:)
								)
							)
							20
						)
						(= temp1 20)
					)
					((> temp1 80)
						(= temp1 80)
					)
				)
				(gGameMusic2 setVol: temp1)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 32)
		(if (and (not (IsFlag 69)) (== gAct 2) (== gCurPuzzle 13))
			(not (SetFlag 69))
		)
		(cond
			((== gCurPuzzle 14) 0)
			((== gNewRoomNum 710)
				(gGameMusic1 fade: 127 10 16 0)
			)
			((== gNewRoomNum 600)
				(gGameMusic2 fade: 127 10 16 0)
			)
			(else
				(gGameMusic1 fade:)
				(gGameMusic2 fade:)
			)
		)
	)
)

(instance sSepiaStart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(gTheIconBar disable:)
				(gGame setCursor: 996)
				(PalVary pvINIT 250 0)
				(gEgo x: 260 y: 106 setHeading: 180 stopUpd:)
				(= seconds 3)
				((ScriptID 1814 57) disposeWhenDone: 0) ; Willy
			)
			(1
				(PalVary pvREVERSE 8 0 1)
			)
			(2
				(gMessager say: 25 0 0) ; "So Freddy wuz forced to shut down the ol' Pharmacy agin his will. But he vowed to keep the place up, knowin' that someday he'd be openin' it up again."
				(= cycles 1)
			)
			(3
				((ScriptID 1814 57) disposeWhenDone: 1) ; Willy
				(gTheIconBar enable:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterIndian of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 37)
				(= cycles 1)
			)
			(1
				(indian3 setMotion: PolyPath 269 107 self)
			)
			(2
				(gGame handsOff:)
				(indian3 setLoop: 2 setCel: 0 stopUpd:)
				(indian2 setLoop: 2 setCel: 1 signal: 16384 stopUpd:)
				(gEgo stopUpd:)
				(= cycles 5)
			)
			(3
				(if (< (gEgo x:) 160)
					((ScriptID 1840 10) x: 200 y: 60 textX: -180) ; Indian2
					((ScriptID 1841 11) x: 200 y: 70 textX: -180) ; Indian3
				)
				(gMessager say: 24 0 0) ; "How!"
				(= cycles 1)
			)
			(4
				(gGame handsOn:)
				(indian2 setLoop: 0 setCel: 1 setMotion: MoveTo 330 105)
				(= cycles 30)
			)
			(5
				(indian3 setMotion: MoveTo 284 105 self)
			)
			(6
				(indian3 setLoop: 2 setCel: 2 approachVerbs: 4 2 9) ; Do, Talk, Door_Key
				(= cycles 1)
			)
			(7
				(indian3 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sHorseStuff of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local4 (== (horse1 loop:) 3) (== (horse1 cel:) 4))
			(= local4 0)
			(horseSound number: 2116 play: horse1)
		)
		(if (and local5 (== (horse2 loop:) 3) (== (horse2 cel:) 4))
			(= local5 0)
			(horseSound2 number: 2939 play: horse2)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 0 3)
					(0
						(client setLoop: 0)
					)
					(1
						(client setLoop: 1)
					)
					(2
						(client setLoop: 3)
					)
					(3
						(client setLoop: 2)
					)
				)
				(client setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(if (and (== (Random 5 10) 8) (!= (client loop:) 3))
					(switch client
						(horse1
							(horseSound number: 2114 play: horse1)
						)
						(horse2
							(horseSound2 number: 2115 play: horse2)
						)
					)
				)
				(= seconds (Random 3 10))
			)
			(2
				(client setCycle: End self)
				(self changeState: 0)
			)
		)
	)
)

(instance sEndPuz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gTimers delete: (ScriptID 0 13) (ScriptID 0 14)) ; deathTimer, gasMaskTimer
				(= global138 0)
				(gEgo put: 13) ; Deflatulizer
				(gEgo put: 21) ; Gas_Mask
				(gEgo put: 20) ; Filled_Sack
				(= cycles 1)
			)
			(1
				(horse1 dispose:)
				(horse2 dispose:)
				(gCast eachElementDo: #hide)
				(gCurRoom style: 6 drawPic: 780)
				(= cycles 10)
			)
			(2
				(gMessager say: 1 29 0 0 self 18) ; "You carefully pour the Deflatulizer into the horse's water trough."
				(gGame points: 20 152)
			)
			(3
				(gEgo x: 260 y: 106 loop: 2 stopUpd:)
				((gCurRoom obstacles:) delete: local3)
				(local3 dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 152 121 85 121 85 112 152 112
							yourself:
						)
				)
				(= cycles 1)
			)
			(4
				(gCast eachElementDo: #show)
				(gCurRoom style: 7 drawPic: 250)
				(= cycles 1)
			)
			(5
				(= gCurPuzzle 10)
				(= next sReveireScreams)
				(self dispose:)
			)
		)
	)
)

(instance sReveireScreams of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 84)
				(kidRunning init: setCycle: Walk setMotion: MoveTo 168 145 self)
			)
			(1
				(kidRunning setMotion: MoveTo 265 122 self)
			)
			(2
				(kidRunning setLoop: 2 setCel: 0 setCycle: CT 5 1 self)
			)
			(3
				(kidRunning loop: 2 cel: 0 setCycle: ROsc 4 5 6 self)
			)
			(4
				(gMessager say: 26 0 0 0 self) ; "Board up yer winders 'n' doors! Lock up the wimmen and children! Run fer the border, Louise!"
			)
			(5
				(kidRunning setCycle: Beg self)
			)
			(6
				(kidRunning
					loop: 0
					setCycle: Walk
					setMotion: MoveTo 340 122 self
				)
			)
			(7
				((ScriptID 0 13) setReal: (ScriptID 0 13) 0 15) ; deathTimer, deathTimer
				(kidRunning dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWhoopee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 4)
			)
			(1
				(client setCycle: Walk setMotion: PolyPath 304 147 self)
			)
			(2
				(if (gEgo inRect: 289 116 319 149)
					(gEgo
						setMotion: MoveTo (- (gEgo x:) 40) (gEgo y:) self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(gGame handsOff:)
				(whoopeeHorse dispose:)
				(client setLoop: 2 posn: 304 121 cel: 0 setCycle: CT 8 1 self)
			)
			(4
				(whoopeeSound play: self)
				(client setCycle: End self)
			)
			(5)
			(6
				(client setLoop: 3 setCycle: End self)
				(whoopeeSound number: 2116 play: self)
			)
			(7 0)
			(8
				(client setCycle: Beg self)
				(whoopeeSound number: 2113 play: self)
			)
			(9
				(client setLoop: 4 cel: 0 setCycle: End self)
			)
			(10
				(client
					setLoop: 5
					setCel: 0
					posn: 321 123
					setCycle: Walk
					setMotion: MoveTo 335 (client y:) self
				)
			)
			(11
				(client dispose:)
				(UnLoad 128 113)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sheriffDoor of Door
	(properties
		x 42
		y 99
		noun 3
		approachX 30
		approachY 107
		view 250
		entranceTo 710
		lockedCase 1
		openSnd 2146
		closeSnd 2147
		openVerb 4
		moveToX 30
		moveToY 92
		enterType 0
		exitType 0
	)
)

(instance pharmacyDoor of Door
	(properties
		x 259
		y 95
		noun 1
		approachX 260
		approachY 106
		view 250
		loop 1
		entranceTo 600
		locked 1
		lockedCase 1
		openSnd 2146
		closeSnd 2147
		openVerb 4
		moveToX 260
		moveToY 93
		enterType 0
		exitType 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; Door_Key
				(if (not locked)
					(= locked 1)
					(SetFlag 18)
					(gMessager say: noun 9 2) ; "You cleverly lock the door."
				else
					(= locked 0)
					(ClearFlag 18)
					(if (IsFlag 130)
						(gMessager say: noun 9 3) ; "You unlock the door."
					else
						(gMessager say: noun 9 1) ; "You unlock the door. Ta-daa! You're halfway through the game."
						(gGame points: 500 130)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance whoopeeMan of Actor
	(properties
		x 33
		y 121
		noun 29
		view 113
	)
)

(instance indian1 of Actor
	(properties
		x 284
		y 105
		noun 21
		approachX 272
		approachY 115
		view 839
		loop 2
		cel 2
		signal 16385
		scaleSignal 1
		scaleX 80
		scaleY 80
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 2 9) ; Do, Talk, Door_Key
	)
)

(instance indian2 of Actor
	(properties
		x 284
		y 105
		noun 22
		approachX 272
		approachY 115
		view 840
		loop 2
		cel 2
		signal 16385
		scaleSignal 1
		scaleX 87
		scaleY 87
		cycleSpeed 2
		moveSpeed 2
	)

	(method (doVerb theVerb)
		(return
			(if (== (indian3 script:) sEnterIndian)
				0
			else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance indian3 of Actor
	(properties
		x 284
		y 105
		noun 23
		approachX 272
		approachY 115
		view 841
		loop 2
		cel 2
		signal 16385
		scaleSignal 1
		scaleX 87
		scaleY 87
		cycleSpeed 4
		moveSpeed 4
	)

	(method (doVerb theVerb)
		(return
			(if (== (indian3 script:) sEnterIndian)
				0
			else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance kidRunning of Actor
	(properties
		x -10
		y 145
		view 105
		loop 1
		cycleSpeed 4
		moveSpeed 4
	)
)

(instance horsePlop of Prop
	(properties
		x 111
		y 127
		noun 27
		approachX 105
		approachY 134
		view 129
		loop 2
		signal 16384
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo get: 23 horsePlop) ; Horse_Plop
				(SetFlag 53)
				(gGame points: 1 128)
				((gCurRoom obstacles:) delete: local2)
				(local2 dispose:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance horse1 of Prop
	(properties
		x 126
		y 125
		noun 1
		approachX 131
		approachY 137
		view 114
		loop 2
		priority 8
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; Paper_Sack
				(cond
					((== gCurPuzzle 8)
						(gMessager say: noun 0 4 0 0 18) ; "The aroma is simply too overpowering. You daren't touch the horse until you have some way to protect yourself from the stench."
					)
					((and (== (self loop:) 3) (not (gEgo has: 20))) ; Filled_Sack
						(gEgo put: 41) ; Paper_Sack
						(gEgo get: -1 20) ; Filled_Sack
						(gGame points: 6 151)
						(gMessager say: noun 65 0 0 0 18) ; "Yes, it's very possibly the most revolting thing you've ever done, but hey, a pharmacist's gotta do what a pharmacist's gotta do."
					)
					(else
						(gMessager say: noun 65 2 0 0 18) ; "A really terrifically disgusting idea! Unfortunately, the horse's tail is momentarily blocked."
					)
				)
			)
			(64 ; Filled_Sack
				(gMessager say: noun 64 0 0 0 18) ; "She can't take any more, Captain! Any more and she'll BLOW!"
			)
			(1 ; Look
				(if (== (self loop:) 3)
					(gMessager say: noun 1 1 0 0 18) ; "The horse's tail is fluttering in the breeze! (And what a breeze!)"
				else
					(gMessager say: noun 1 0 0 0 18) ; "It's somebody's poor horse."
				)
			)
			(4 ; Do
				(gMessager say: noun 4 0 0 0 18) ; "Nice horsey!"
			)
			(29 ; Deflatulizer
				(gCurRoom setScript: sEndPuz)
			)
			(else
				(gMessager say: noun theVerb 0 0 0 18)
			)
		)
	)

	(method (cue)
		(super cue:)
		(= local4 1)
	)
)

(instance horse2 of Prop
	(properties
		x 101
		y 125
		noun 1
		approachX 107
		approachY 137
		view 115
		loop 3
		priority 8
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; Paper_Sack
				(cond
					((== gCurPuzzle 8)
						(gMessager say: noun 0 4 0 0 18) ; "The aroma is simply too overpowering. You daren't touch the horse until you have some way to protect yourself from the stench."
					)
					((and (== (self loop:) 3) (not (gEgo has: 20))) ; Filled_Sack
						(gEgo put: 41) ; Paper_Sack
						(gEgo get: -1 20) ; Filled_Sack
						(gGame points: 6 151)
						(gMessager say: noun 65 0 0 0 18) ; "Yes, it's very possibly the most revolting thing you've ever done, but hey, a pharmacist's gotta do what a pharmacist's gotta do."
					)
					(else
						(gMessager say: noun 65 2 0 0 18) ; "A really terrifically disgusting idea! Unfortunately, the horse's tail is momentarily blocked."
					)
				)
			)
			(64 ; Filled_Sack
				(gMessager say: noun 64 0 0 0 18) ; "She can't take any more, Captain! Any more and she'll BLOW!"
			)
			(1 ; Look
				(if (== (self loop:) 3)
					(gMessager say: noun 1 1 0 0 18) ; "The horse's tail is fluttering in the breeze! (And what a breeze!)"
				else
					(gMessager say: noun 1 0 0 0 18) ; "It's somebody's poor horse."
				)
			)
			(4 ; Do
				(gMessager say: noun 4 0 0 0 18) ; "Nice horsey!"
			)
			(29 ; Deflatulizer
				(gCurRoom setScript: sEndPuz)
			)
			(else
				(gMessager say: noun theVerb 0 0 0 18)
			)
		)
	)

	(method (cue)
		(super cue:)
		(= local5 1)
	)
)

(instance dummyCredits of Prop
	(properties
		x -10
		y -10
		view 996
	)
)

(instance whoopeeHorse of View
	(properties
		x 304
		y 121
		view 113
		loop 1
	)
)

(instance closedSign of View
	(properties
		x 297
		y 70
		noun 28
		view 252
		loop 2
		priority 5
		signal 16
	)
)

(instance bakingSoda of View
	(properties
		x 224
		y 98
		noun 20
		approachX 235
		approachY 114
		view 251
		priority 6
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo get: 0 bakingSoda) ; Baking_Soda
				((gCurRoom obstacles:) delete: local1)
				(local1 dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 103 0 0 319 0 319 103 262 103 262 79 257 79 257 103 203 103 104 101 56 105 34 105 33 76 27 76 26 105 13 105
							yourself:
						)
				)
				(gGame points: 1)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sheriffOffice of Feature
	(properties
		x 44
		y 40
		noun 10
	)
)

(instance thinTall of Feature
	(properties
		x 99
		y 29
		noun 7
		approachX 99
		approachY 102
	)
)

(instance playhouse of Feature
	(properties
		x 159
		y 39
		noun 5
	)
)

(instance pharmacy of Feature
	(properties
		x 268
		y 32
		noun 9
	)
)

(instance pharmacyPoles of Feature
	(properties
		x 268
		y 32
		noun 11
	)
)

(instance clutter of Feature
	(properties
		x 169
		y 167
		noun 12
	)
)

(instance rail of Feature
	(properties
		x 309
		y 104
		noun 2
	)
)

(instance sheriffSign of Feature
	(properties
		x 44
		y 40
		noun 14
		nsTop 32
		nsLeft 20
		nsBottom 49
		nsRight 69
	)
)

(instance tallThinSign of Feature
	(properties
		x 99
		y 29
		noun 6
		nsTop 6
		nsLeft 83
		nsBottom 53
		nsRight 115
	)
)

(instance playhouseSign of Feature
	(properties
		x 159
		y 39
		noun 8
		nsTop 24
		nsLeft 119
		nsBottom 54
		nsRight 199
	)
)

(instance pharmacySign of Feature
	(properties
		x 268
		y 32
		noun 13
		nsTop 24
		nsLeft 217
		nsBottom 40
		nsRight 319
	)
)

(instance playhouseDoor of Feature
	(properties
		x 158
		y 82
		noun 15
		nsTop 63
		nsLeft 142
		nsBottom 101
		nsRight 175
		approachX 156
		approachY 103
	)
)

(instance sheriffWindow of Feature
	(properties
		x 61
		y 76
		noun 4
		nsTop 70
		nsLeft 54
		nsBottom 82
		nsRight 69
	)
)

(instance pharmacyRight of Feature
	(properties
		x 295
		y 71
		noun 17
		nsTop 49
		nsLeft 285
		nsBottom 94
		nsRight 306
	)
)

(instance pharmacyLeft of Feature
	(properties
		x 228
		y 69
		noun 16
		nsTop 50
		nsLeft 222
		nsBottom 89
		nsRight 235
	)
)

(instance trough of Feature
	(properties
		x 118
		y 94
		noun 18
		nsTop 110
		nsLeft 91
		nsBottom 119
		nsRight 146
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29 ; Deflatulizer
				(gCurRoom setScript: sEndPuz)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance horseSound of FPSound
	(properties
		flags 1
	)
)

(instance horseSound2 of FPSound
	(properties
		flags 1
	)
)

(instance whoopeeSound of FPSound
	(properties
		flags 1
		number 2112
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 670)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Feature)
(use Door)
(use ForwardCounter)
(use Window)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm670 0
)

(local
	[local0 2]
	local2
	[local3 2]
	local5
	local6 = 1
)

(instance rm670 of FPRoom
	(properties
		noun 29
		picture 670
		style 100
		north 500
		south 230
	)

	(method (init &tmp temp0)
		(gEgo init: setScale: Scaler 120 63 189 97 normalize:)
		(switch gPrevRoomNum
			(south
				(gEgo x: 47)
				(gGame handsOn:)
			)
			(235
				(self south: 235)
				(gEgo x: 47)
				(gGame handsOn:)
			)
			(500
				(switch (Random 2 9)
					(2
						(= global135 673)
					)
					(3
						(= global135 673)
					)
					(4
						(= global135 665)
					)
					(5
						(= global135 665)
					)
					(6
						(= global135 666)
					)
					(7
						(= global135 666)
					)
					(8
						(= global135 670)
					)
					(9
						(= global135 670)
					)
				)
				(gEgo loop: 2)
			)
			(675
				(gGame handsOn:)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(gEgo x: 47 y: 181 setHeading: 0)
				(if (== gPrevRoomNum 671)
					(gGame handsOn: setCursor: 0 1)
				else
					(gGame handsOn:)
				)
			)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 8 189 0 189 0 0 319 0 319 189 82 189 82 185 95 180 108 177 216 177 228 185 244 185 251 179 291 179 291 151 305 151 292 128 269 128 257 123 257 112 250 104 231 100 231 76 221 76 221 99 183 99 152 99 150 115 130 115 120 121 82 121 72 113 52 113 52 119 72 121 79 127 73 137 8 165
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 154 104 235 104 238 129 152 129
					yourself:
				)
				(if (== gCurPuzzle 20)
					((Polygon new:)
						type: PBarredAccess
						init: 77 173 68 155 79 133 280 133 287 149 277 170 263 173 239 173
						yourself:
					)
				else
					((Polygon new:)
						type: PBarredAccess
						init: 177 173 177 133 277 133 281 151 277 170 263 173 239 173
						yourself:
					)
				)
		)
		(if (!= gCurPuzzle 20)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 174 133 174 173 80 173 70 151 80 133
						yourself:
					)
			)
		)
		(cond
			((< gCurPuzzle 20)
				(chandelier2 ignoreActors: addToPic: init:)
				(pokerTable ignoreActors: addToPic: init: approachVerbs: 1) ; Look
				(sittingCowboy1
					ignoreActors:
					addToPic:
					init:
					approachVerbs: 4 2 ; Do, Talk
				)
				(sittingCowboy2
					ignoreActors:
					addToPic:
					init:
					approachVerbs: 4 2 ; Do, Talk
				)
				(sittingCowboy3
					ignoreActors:
					addToPic:
					init:
					approachVerbs: 4 2 ; Do, Talk
				)
				(sam
					init:
					stopUpd:
					approachVerbs: 4 2 31 ; Do, Talk, Money
					setScript:
						(if (>= (gGame detailLevel:) 2) sSamMotions else 0)
				)
				(if (IsFlag 34)
					(doc init: setLoop: 1 setCel: 0 approachVerbs: 10 4 2) ; Penelope_s_Rx, Do, Talk
				else
					(doc
						init:
						approachVerbs: 10 4 2 ; Penelope_s_Rx, Do, Talk
						setScript:
							(if (>= (gGame detailLevel:) 2)
								sDrinkWhiskey
							else
								0
							)
					)
					(whiskey init: approachVerbs: 4) ; Do
				)
				(if (!= gCurPuzzle 14)
					(pianoPlayer approachVerbs: 2 setCycle: RandCycle init:) ; Talk
				)
			)
			((== gCurPuzzle 20)
				(aces ignoreActors: addToPic: init: approachVerbs: 1 4 2) ; Look, Do, Talk
				(pokerTable ignoreActors: addToPic: init: approachVerbs: 1) ; Look
				(chips ignoreActors: addToPic: init:)
				(chandelier2 ignoreActors: addToPic: init:)
				(pianoPlayer approachVerbs: 2 setCycle: RandCycle init:) ; Talk
				(sam
					init:
					stopUpd:
					approachVerbs: 4 2 31 ; Do, Talk, Money
					setScript:
						(if (>= (gGame detailLevel:) 2) sSamMotions else 0)
				)
				(laffer
					init:
					stopUpd:
					approachVerbs: 2 4 9 ; Talk, Do, Door_Key
					setScript: sLafferDrinks
				)
				(doc
					view: 682
					setPri: 6
					x: 74
					y: 93
					z: 0
					ignoreActors:
					addToPic:
					init:
				)
			)
			(else
				(pokerTable ignoreActors: addToPic: approachVerbs: 1 init:) ; Look
				(pianoPlayer approachVerbs: 2 setCycle: RandCycle init:) ; Talk
				(sam
					init:
					stopUpd:
					approachVerbs: 4 2 31 ; Do, Talk, Money
					setScript:
						(if (>= (gGame detailLevel:) 2) sSamMotions else 0)
				)
				(doc
					view: 682
					setPri: 6
					x: 74
					y: 93
					z: 0
					ignoreActors:
					addToPic:
					init:
				)
				(laffer stopUpd: approachVerbs: 2 4 9 init:) ; Talk, Do, Door_Key
			)
		)
		(if (and (== global135 670) (!= gCurPuzzle 20))
			(solo init: setCycle: ForwardCounter 5 solo)
			(chorus
				init:
				setLoop: 0
				setCycle: Walk
				setMotion: MoveTo 208 69 chorus
			)
		else
			(= global135 673)
		)
		(shieldTable ignoreActors: addToPic: init:)
		(bottles init:)
		(spinner init:)
		(stage init:)
		(backDoor init:)
		(poolTable init: setOnMeCheck: 1 2)
		(roulette init: setOnMeCheck: 1 4)
		(diceGame init: setOnMeCheck: 1 8)
		(moose init: setOnMeCheck: 1 16)
		(hatRack init: setOnMeCheck: 1 32)
		(table1 init: setOnMeCheck: 1 256)
		(table2 init: setOnMeCheck: 1 128)
		(blackJack init: setOnMeCheck: 1 512)
		(piano init: setOnMeCheck: 1 1024)
		(chandelier init: setOnMeCheck: 1 2048)
		(painting2 init: setOnMeCheck: 1 4096)
		(littlePic init: setOnMeCheck: 1 -32768)
		(bar init: setOnMeCheck: 1 8192)
		(rail init: setOnMeCheck: 1 16384)
		(painting1 init: approachVerbs: 2 4 setOnMeCheck: 1 64) ; Talk, Do
	)

	(method (doit)
		(cond
			(script)
			((and (IsFlag 85) (== ((User alterEgo:) edgeHit:) 3))
				(gCurRoom setScript: sRowdyWarning)
			)
			((== (gEgo edgeHit:) 3)
				(gCurRoom setScript: sExitSouth)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 230) (OneOf gCurPuzzle 8 9 20 22))
			(= newRoomNumber 235)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(if (and (!= gNewRoomNum 230) (!= gCurPuzzle 14))
			(gGameMusic1 fade:)
		)
		(super dispose:)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setLoop: 2 setMotion: MoveTo (gEgo x:) 290 self)
			)
			(1
				(gCurRoom newRoom: 230)
			)
		)
	)
)

(instance sSamMotions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sam setCycle: End self)
			)
			(1
				(= seconds (Random 1 4))
			)
			(2
				(sam setCycle: Beg self)
			)
			(3
				(= seconds (Random 1 4))
			)
			(4
				(if (Random 0 1)
					(sam setLoop: 1 setCel: 0 setCycle: CT 5 1 self)
				else
					(= cycles 1)
				)
			)
			(5
				(if (== (sam cel:) 5)
					(sam setLoop: 0 setCel: 0 setCycle: Fwd)
					(= seconds (Random 4 7))
				else
					(= cycles 1)
				)
			)
			(6
				(if (== (sam loop:) 0)
					(sam setLoop: 1 setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(7
				(self changeState: 0)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance sDrinkWhiskey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 1)
				(= seconds (Random 7 15))
			)
			(1
				(= local6 0)
				(whiskey hide:)
				(doc setCycle: End self)
			)
			(2
				(whiskey show: stopUpd:)
				(doc setCel: 0 stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance sRowdyWarning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(rowdySound number: 2944 play:)
				(= ticks 20)
			)
			(2
				(rowdySound number: 2944 play:)
				(= ticks 20)
			)
			(3
				(rowdySound number: 2944 play:)
				(= ticks 50)
			)
			(4
				(rowdySound number: 2944 play: self)
			)
			(5
				(rowdySound number: 2954 play: self)
			)
			(6
				(gMessager say: 45 0 0 0 self) ; "Without warning, you hear gunshots out in front of the Saloon."
			)
			(7
				(gEgo setMotion: MoveTo 47 181 self)
			)
			(8
				(ClearFlag 85)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPickATune of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gNormalCursor ((gTheIconBar curIcon:) cursor:))
				(gGame handsOff:)
				(if (== local5 0)
					(= local5 1)
					(gMessager say: 38 2 0 0 self) ; "Play it, Neville."
				else
					(= cycles 1)
				)
			)
			(1
				(gGame setCursor: 999 1)
				(= local2 global135)
				(if
					(==
						(= global135
							(Print
								posn: 65 20
								font: 1207
								window: SysWindow
								addTitle: 58 0 0 1 670
								addButton: 150 47 0 0 1 0 0 670 ; "The Ballad of the Frontier Pharmacist"
								addButton: 235 48 0 0 1 0 15 670 ; "Revolucion Numero 9"
								addButton: 675 49 0 0 1 0 30 670 ; "I've Grown Accustomed to Your Ace"
								addButton: 540 50 0 0 1 0 45 670 ; "Hot Lead in the Old Town Tonight"
								addButton: 201 51 0 0 1 0 60 670 ; "The Varmint of Baghdad"
								addButton: 185 52 0 0 1 0 75 670 ; "Gunrise, Gunset"
								addButton: 548 53 0 0 1 0 90 670 ; "When You Say Blood"
								addButton: 323 54 0 0 1 0 105 670 ; "Zircon Jim's Theme"
								addButton: 501 55 0 0 1 0 120 670 ; "Singh Sungh Blue"
								addButton: 660 56 0 0 1 0 135 670 ; "My Sweet Cranky Ol' Mom"
								init:
							)
						)
						0
					)
					(= global135 local2)
				else
					(gGameMusic1 number: global135 flags: 1 loop: -1 play:)
				)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(gGame setCursor: gNormalCursor)
				(self dispose:)
			)
		)
	)
)

(instance sLafferDrinks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 20 50))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client setCel: 0 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sDocReadsRX of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo stopUpd:)
				(whiskey init:)
				(gEgo put: 58) ; Under_Glass
				(gEgo get: -1 12) ; Correct_Rx
				(gGameMusic1 fade: 0 10 16 0)
				(gGameMusic2 number: 674 flags: 1 loop: -1 play: setVol: 0)
				(= cycles 3)
			)
			(1
				(gGameMusic2 fade: 127 10 16 0)
				(gMessager say: 7 0 6 1 2 self) ; "You thrust the prescription and the whisky glass under Doc's nose."
			)
			(2
				(doc view: 235 loop: 0 setCycle: CT 4 1 self)
			)
			(3
				(whiskey dispose:)
				(doc setCycle: End self)
			)
			(4
				(doc stopUpd:)
				(= cycles 3)
			)
			(5
				(gMessager say: 7 0 6 3 6 self) ; "Teshtosterate...hmmm...no, I spoze that would be uneffi... <hic>"
				(= gCurPuzzle 5)
			)
			(6
				(doc loop: 1 setCycle: End self)
			)
			(7
				(doc loop: 2 cel: 4 setCycle: CT 2 -1 self)
			)
			(8
				(paper init:)
				(doc setCycle: Beg self)
			)
			(9
				(doc stopUpd:)
				(= cycles 3)
			)
			(10
				(gGame points: 7)
				(gMessager say: 7 0 6 7 10 self) ; "Doc scribbles a correction on the prescription and hands it back to you."
				(= gCurPuzzle 5)
			)
			(11
				(paper dispose:)
				(gGameMusic2 fade: 0 10 16 1)
				(gGameMusic1 fade: 127 10 16 0)
				(UnLoad 128 235)
				(doc view: 671 loop: 1 cel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance chorus of Actor
	(properties
		x 1
		y 69
		noun 37
		view 686
		signal 20480
		cycleSpeed 10
		moveSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gGameMusic2 number: 2952 flags: 1 loop: 1 play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(self setLoop: (if (> x 200) 1 else 0))
		(self setMotion: MoveTo (if (> x 200) 1 else 208) y self)
	)
)

(instance solo of Actor
	(properties
		x 124
		y 74
		noun 37
		view 686
		loop 2
		signal 20480
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gGameMusic2 number: 2952 flags: 1 loop: 1 play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(self setLoop: (if (== loop 2) 3 else 2))
		(self setCycle: ForwardCounter 5 self)
	)
)

(instance chandelier2 of Actor
	(properties
		x 221
		y 135
		z 137
		noun 36
		view 670
		loop 2
		priority 13
		signal 4096
	)
)

(instance laffer of Prop
	(properties
		x 58
		y 134
		noun 10
		approachX 70
		approachY 149
		view 688
		signal 20480
		detailLevel 2
	)

	(method (init)
		(super init:)
		(if (> (gGame detailLevel:) 2)
			(self setScript: sLafferDrinks)
		)
	)
)

(instance pianoPlayer of Prop
	(properties
		x 57
		y 85
		noun 38
		approachX 74
		approachY 113
		view 673
		loop 2
		priority 6
		signal 20496
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(self setScript: sPickATune)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(if (or (== gPrevRoomNum 230) (== gPrevRoomNum 235))
			(gGameMusic1 fade: 127 10 16 0)
		else
			(gGameMusic1 number: global135 flags: 1 loop: -1 play:)
		)
	)
)

(instance sam of Prop
	(properties
		x 14
		y 98
		noun 11
		approachX 45
		approachY 150
		view 673
		loop 1
		priority 9
		signal 20496
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(31 ; Money
				(gMessager say: noun 31) ; "Hey, Sam! Gimme a case of the beer you just got in from St. Louis!"
				(gEgo put: 37) ; Money
				(gEgo get: -1 1 2) ; Beer
				(gGame points: 5)
			)
			(2 ; Talk
				(cond
					((<= gAct 1)
						(switch global139
							(0
								(gMessager say: noun theVerb 9) ; "Well, if it ain't Sam Andreas, the bartender's bartender!"
								(++ global139)
							)
							(1
								(gMessager say: noun theVerb 10) ; "Say, Sam, I think I'll take an Ovaltine."
								(++ global139)
							)
							(2
								(gMessager say: noun theVerb 11) ; "Got any Ovaltine in stock yet?"
							)
						)
					)
					((== gCurPuzzle 12)
						(gMessager say: 11 2 14) ; "Sam, have you noticed what's going on in this town?"
					)
					((== gCurPuzzle 13)
						(gMessager say: 11 2 15) ; "Sam, anything unusual going on?"
					)
					((== gCurPuzzle 14)
						(gMessager say: 11 2 16) ; "Sam, come quick! The assay office is on fire!"
					)
					((== gCurPuzzle 15)
						(gMessager say: 11 2 17) ; "The fire's out at the Assay Office, Sam. You can stop panicking."
					)
					((or (== gCurPuzzle 8) (== gCurPuzzle 9))
						(gMessager say: 11 2 12) ; "Sam, Sam! Don't let anyone go out on the street 'till I give you the say-so."
					)
					((== gCurPuzzle 10)
						(gMessager say: 11 2 13) ; "Sam!"
					)
					((== gAct 3)
						(switch global139
							(0
								(gMessager say: noun theVerb 18) ; "Sam, I'm gonna be going away for a while."
								(++ global139)
							)
							(1
								(gMessager say: noun theVerb 19) ; "Howdy, Sam."
								(++ global139)
							)
							(2
								(gMessager say: noun theVerb 20) ; "Okay, Sam, you beat it out of me."
							)
						)
					)
					((== gCurPuzzle 20)
						(gMessager say: 11 2 21) ; "Sam! What the devil is going on here?"
					)
					((== gCurPuzzle 22)
						(gMessager say: 11 2 22) ; "Sam, what's going on outside? You got any idea?"
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doc of Prop
	(properties
		x 193
		y 140
		z 13
		noun 7
		approachX 224
		approachY 143
		view 671
		priority 11
		signal 20496
		cycleSpeed 10
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (>= gCurPuzzle 20)
			(gMessager say: noun 0 4) ; "Don't bother him. He's sleeping it off."
		else
			(switch theVerb
				(2 ; Talk
					(cond
						((<= gAct 1)
							(switch global137
								(0
									(gMessager say: noun theVerb 9) ; "Doc! Hey, Doc!"
									(++ global137)
								)
								(1
									(gMessager say: noun theVerb 10) ; "Doc, you're not writing prescriptions while you're drunk, are you?"
									(++ global137)
								)
								(2
									(gMessager say: noun theVerb 11) ; "Doc?"
								)
							)
						)
						((or (== gCurPuzzle 8) (== gCurPuzzle 9))
							(gMessager say: noun theVerb 23) ; "Doc! What do you recommend for extreme flatulence?"
						)
						((== gCurPuzzle 10)
							(gMessager say: noun theVerb 13) ; "Doc, what do you know about snails?"
						)
						((== gCurPuzzle 12)
							(gMessager say: noun theVerb 14) ; "Doc, what can you tell me about ants?"
						)
						((== gCurPuzzle 13)
							(gMessager say: noun theVerb 24) ; "Hey, Doc...don't you think you ought to sober up? There's a lot of sick people in this town, and they need your attention."
						)
						((== gCurPuzzle 14)
							(gMessager say: noun theVerb 16) ; "Doc! You've got to come and help! The Assay Office is on fire!"
						)
						((== gCurPuzzle 15)
							(gMessager say: noun theVerb 25) ; "Doc, what do you do when you're awake and you can't get back to sleep?"
						)
						((== gCurPuzzle 16)
							(gMessager say: noun theVerb 26) ; "Doc!"
						)
						((== gCurPuzzle 19)
							(gMessager say: noun theVerb 27) ; "OK, Doc, I'm makin' my goodbyes. I'm about to cut outta town."
						)
					)
				)
				(10 ; Penelope_s_Rx
					(gMessager say: 7 0 5) ; "You thrust the prescription under Doc's nose and demand an explanation."
				)
				(12 ; Helen_s_Rx
					(gMessager say: 7 0 5) ; "You thrust the prescription under Doc's nose and demand an explanation."
				)
				(14 ; Madame_s_Rx
					(gMessager say: 7 0 7) ; "I cain't read this so good. Mus' be sumptin wrong with ma eyes."
				)
				(16 ; Under_Glass
					(self setScript: sDocReadsRX)
				)
				(17 ; Correct_Rx
					(gMessager say: 7 0 5) ; "You thrust the prescription under Doc's nose and demand an explanation."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)
)

(instance aces of Prop
	(properties
		x 224
		y 122
		noun 31
		approachX 232
		approachY 174
		view 672
		loop 4
		priority 10
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gGame handsOff:)
				(gCurRoom newRoom: 675)
			)
			(2 ; Talk
				(switch global146
					(0
						(gMessager say: noun theVerb 28) ; "How's the game going, slick?"
						(++ global146)
					)
					(1
						(gMessager say: noun theVerb 29) ; "Doesn't it bother you that you're bilking these people out of their homes and businesses?"
						(++ global146)
					)
					(2
						(gMessager say: noun theVerb 30) ; "I'm making a citizen's arrest. You're cheating, I know it."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pokerGuy1 of Prop
	(properties
		x 180
		y 149
		noun 39
		view 672
		signal 20480
	)
)

(instance pokerGuy2 of Prop
	(properties
		x 267
		y 147
		noun 41
		view 672
		loop 1
		signal 20480
	)
)

(instance pokerGuy3 of Prop
	(properties
		x 255
		y 167
		noun 42
		view 672
		loop 2
		signal 20480
	)
)

(instance pokerGuy4 of Prop
	(properties
		x 191
		y 164
		noun 43
		view 672
		loop 3
		priority 11
		signal 20496
	)
)

(instance backDoor of Door
	(properties
		x 213
		y 89
		noun 30
		approachX 221
		approachY 101
		view 670
		entranceTo 500
		openSnd 2146
		closeSnd 2147
		openVerb 4
		moveToX 221
		moveToY 92
		enterType 0
		exitType 0
	)
)

(instance sittingCowboy1 of Prop
	(properties
		x 180
		y 103
		noun 44
		approachX 246
		approachY 119
		view 684
		priority 8
		signal 20496
	)
)

(instance sittingCowboy2 of Prop
	(properties
		x 207
		y 95
		noun 44
		approachX 246
		approachY 119
		view 684
		loop 1
		priority 8
		signal 20496
	)
)

(instance sittingCowboy3 of Prop
	(properties
		x 169
		y 93
		noun 44
		approachX 246
		approachY 119
		view 684
		loop 2
		priority 8
		signal 20496
	)
)

(instance shieldTable of Prop
	(properties
		x 120
		y 129
		noun 33
		view 678
		loop 5
		priority 11
		signal 20496
	)

	(method (init)
		(super init:)
		(chair1 ignoreActors: addToPic: init:)
		(chair2 ignoreActors: addToPic: init:)
		(chair3 ignoreActors: addToPic: init:)
		(chair4 ignoreActors: addToPic: init:)
	)
)

(instance pokerTable of View
	(properties
		x 228
		y 129
		noun 34
		approachX 232
		approachY 174
		view 678
		loop 5
		priority 11
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== gCurPuzzle 20)
					(gCurRoom newRoom: 675)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(cond
					((< gCurPuzzle 20)
						(gMessager say: noun 4 1) ; "You're not the type to gamble."
					)
					((== gCurPuzzle 20)
						(gMessager say: noun 4 2) ; "You don't want to start playing Poker with this guy. He's known far and wide as a cheat."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(if (== gCurPuzzle 20)
			(pokerGuy1 ignoreActors: addToPic: approachVerbs: 4 2 init:) ; Do, Talk
			(pokerGuy2 ignoreActors: addToPic: approachVerbs: 4 2 init:) ; Do, Talk
			(pokerGuy3 ignoreActors: addToPic: approachVerbs: 4 2 init:) ; Do, Talk
			(pokerGuy4 ignoreActors: addToPic: approachVerbs: 4 2 init:) ; Do, Talk
		else
			(pChair1 ignoreActors: addToPic: init:)
			(pChair2 ignoreActors: addToPic: init:)
			(pChair3 ignoreActors: addToPic: init:)
			(pChair4 ignoreActors: addToPic: init:)
		)
	)
)

(instance pChair1 of View
	(properties
		x 200
		y 127
		noun 40
		view 678
		priority 10
		signal 20496
	)
)

(instance pChair2 of View
	(properties
		x 249
		y 127
		noun 40
		view 678
		loop 1
		priority 10
		signal 20496
	)
)

(instance pChair3 of View
	(properties
		x 256
		y 148
		noun 40
		view 678
		loop 2
		priority 12
		signal 20496
	)
)

(instance pChair4 of View
	(properties
		x 205
		y 148
		noun 40
		view 678
		loop 3
		priority 12
		signal 20496
	)
)

(instance whiskey of View
	(properties
		x 224
		y 143
		z 22
		noun 32
		view 670
		loop 1
		priority 12
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local6
					(SetFlag 34)
					(gGame points: 1)
					(doc setLoop: 1 setCel: 0 setScript: 0 stopUpd:)
					(gEgo get: 50 self) ; Shot_Glass
					(self dispose:)
				else
					(gMessager say: 7 4 35) ; "Well, for goodness' sake, don't rip the glass right OUT OF HIS HAND!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chair1 of View
	(properties
		x 101
		y 127
		noun 40
		view 678
		priority 10
		signal 20496
	)
)

(instance chair2 of View
	(properties
		x 147
		y 127
		noun 40
		view 678
		loop 1
		priority 10
		signal 20496
	)
)

(instance chair3 of View
	(properties
		x 147
		y 150
		noun 40
		view 678
		loop 2
		priority 12
		signal 20496
	)
)

(instance chair4 of View
	(properties
		x 98
		y 151
		noun 40
		view 678
		loop 3
		priority 12
		signal 20496
	)
)

(instance chips of View
	(properties
		x 229
		y 126
		view 672
		loop 5
		priority 12
		signal 20496
	)
)

(instance paper of View
	(properties
		x 230
		y 128
		view 235
		loop 3
		priority 11
		signal 16400
	)
)

(instance bottles of Feature
	(properties
		x 12
		y 86
		noun 26
		nsTop 72
		nsBottom 100
		nsRight 24
	)
)

(instance spinner of Feature
	(properties
		x 309
		y 71
		noun 27
		nsTop 49
		nsLeft 299
		nsBottom 94
		nsRight 319
	)
)

(instance stage of Feature
	(properties
		x 127
		y 45
		noun 28
		nsTop 6
		nsLeft 50
		nsBottom 85
		nsRight 205
	)
)

(instance poolTable of Feature
	(properties
		x 155
		y 175
		noun 12
	)
)

(instance roulette of Feature
	(properties
		x 285
		y 179
		noun 13
	)
)

(instance diceGame of Feature
	(properties
		x 310
		y 150
		noun 14
	)
)

(instance moose of Feature
	(properties
		x 289
		y 200
		noun 15
	)
)

(instance hatRack of Feature
	(properties
		x 245
		y 72
		noun 16
	)
)

(instance painting1 of Feature
	(properties
		x 223
		y 31
		noun 17
		approachX 221
		approachY 101
	)
)

(instance table1 of Feature
	(properties
		x 107
		y 89
		noun 19
	)
)

(instance table2 of Feature
	(properties
		x 198
		y 98
		noun 18
	)
)

(instance blackJack of Feature
	(properties
		x 281
		y 103
		noun 20
	)
)

(instance piano of Feature
	(properties
		x 47
		y 81
		noun 21
	)
)

(instance chandelier of Feature
	(properties
		x 105
		y 100
		noun 22
	)
)

(instance painting2 of Feature
	(properties
		x 7
		y 39
		noun 23
	)
)

(instance littlePic of Feature
	(properties
		x 32
		y 38
		noun 24
	)
)

(instance bar of Feature
	(properties
		x 26
		y 120
		noun 25
	)
)

(instance rail of Feature
	(properties
		x 26
		y 120
		noun 63
	)
)

(instance rowdySound of FPSound
	(properties
		flags 1
	)
)


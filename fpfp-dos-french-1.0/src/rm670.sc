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

(procedure (localproc_0 param1 param2 param3 &tmp temp0 [temp1 4])
	(TextSize @[temp1 0] param2 param3 0 0)
	(if (< (= temp0 (- param1 (/ (- [temp1 3] [temp1 1]) 2))) 0)
		(= temp0 0)
	)
	(return temp0)
)

(instance rm670 of FPRoom
	(properties
		noun 31
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
				(gMessager say: 33 0 0 0 self) ; MISSING MESSAGE
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

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 [temp10 40] [temp50 40] [temp90 40] [temp130 40] [temp170 40] [temp210 40] [temp250 40] [temp290 40] [temp330 40] [temp370 40])
		(switch (= state newState)
			(0
				(if (== local5 0)
					(= local5 1)
					(gMessager say: 22 2 0 0 self) ; MISSING MESSAGE
				else
					(= cycles 1)
				)
			)
			(1
				(= gNormalCursor ((gTheIconBar curIcon:) cursor:))
				(gGame setCursor: 999 1)
				(Message msgGET 670 36 0 0 1 @temp10)
				(Message msgGET 670 38 0 0 1 @temp50)
				(Message msgGET 670 39 0 0 1 @temp90)
				(Message msgGET 670 40 0 0 1 @temp130)
				(Message msgGET 670 41 0 0 1 @temp170)
				(Message msgGET 670 42 0 0 1 @temp210)
				(Message msgGET 670 43 0 0 1 @temp250)
				(Message msgGET 670 44 0 0 1 @temp290)
				(Message msgGET 670 45 0 0 1 @temp330) ; "Without warning, you hear gunshots out in front of the Saloon."
				(Message msgGET 670 37 0 0 1 @temp370)
				(= temp0
					(localproc_0 (proc0_16 110 110 92 110 110) @temp10 1207)
				)
				(= temp1
					(localproc_0 (proc0_16 110 110 92 110 110) @temp50 1207)
				)
				(= temp2
					(localproc_0 (proc0_16 110 110 92 110 110) @temp90 1207)
				)
				(= temp3
					(localproc_0 (proc0_16 110 110 92 110 110) @temp130 1207)
				)
				(= temp4
					(localproc_0 (proc0_16 110 110 92 110 110) @temp170 1207)
				)
				(= temp5
					(localproc_0 (proc0_16 110 110 92 110 110) @temp210 1207)
				)
				(= temp6
					(localproc_0 (proc0_16 110 110 92 110 110) @temp250 1207)
				)
				(= temp7
					(localproc_0 (proc0_16 110 110 92 110 110) @temp290 1207)
				)
				(= temp8
					(localproc_0 (proc0_16 110 110 92 110 110) @temp330 1207)
				)
				(= temp9
					(localproc_0 (proc0_16 110 110 92 110 110) @temp370 1207)
				)
				(= local2 global135)
				(if
					(==
						(= global135
							(Print
								posn: 65 20
								font: 1207
								window: SysWindow
								addTitle: 46 0 0 1 670
								addButton: 150 @temp10 temp0 0
								addButton: 235 @temp50 temp1 15
								addButton: 675 @temp90 temp2 30
								addButton: 540 @temp130 temp3 45
								addButton:
									201
									@temp170
									temp4
									(proc0_16 60 60 70 60 60)
								addButton:
									185
									@temp210
									temp5
									(proc0_16 75 75 85 75 75)
								addButton:
									548
									@temp250
									temp6
									(proc0_16 90 90 100 90 90)
								addButton:
									323
									@temp290
									temp7
									(proc0_16 105 105 115 105 105)
								addButton:
									501
									@temp330
									temp8
									(proc0_16 120 120 130 120 120)
								addButton:
									660
									@temp370
									temp9
									(proc0_16 135 135 145 135 135)
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
				(gMessager say: 12 0 4 1 2 self) ; MISSING MESSAGE
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
				(gMessager say: 12 0 4 3 6 self) ; MISSING MESSAGE
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
				(gMessager say: 12 0 4 7 10 self) ; MISSING MESSAGE
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
		noun 10
		view 686
		signal 20480
		cycleSpeed 10
		moveSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gGameMusic2 number: 2952 flags: 1 loop: 1 play:)
				else
					(gMessager say: noun theVerb) ; "Howdy, stranger. New in town?"
				)
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
		noun 10
		view 686
		loop 2
		signal 20480
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gGameMusic2 number: 2952 flags: 1 loop: 1 play:)
				else
					(gMessager say: noun theVerb) ; "Howdy, stranger. New in town?"
				)
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
		noun 9
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
		noun 16
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
		noun 22
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
		noun 34
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
				(gMessager say: noun 31) ; MISSING MESSAGE
				(gEgo put: 37) ; Money
				(gEgo get: -1 1 2) ; Beer
				(gGame points: 5)
			)
			(2 ; Talk
				(cond
					((<= gAct 1)
						(switch global139
							(0
								(gMessager say: noun theVerb 9) ; MISSING MESSAGE
								(++ global139)
							)
							(1
								(gMessager say: noun theVerb 10) ; MISSING MESSAGE
								(++ global139)
							)
							(2
								(gMessager say: noun theVerb 11) ; MISSING MESSAGE
							)
						)
					)
					((== gCurPuzzle 12)
						(gMessager say: 34 2 17) ; MISSING MESSAGE
					)
					((== gCurPuzzle 13)
						(gMessager say: 34 2 28) ; MISSING MESSAGE
					)
					((== gCurPuzzle 14)
						(gMessager say: 34 2 12) ; MISSING MESSAGE
					)
					((== gCurPuzzle 15)
						(gMessager say: 34 2 31) ; MISSING MESSAGE
					)
					((or (== gCurPuzzle 8) (== gCurPuzzle 9))
						(gMessager say: 34 2 29) ; MISSING MESSAGE
					)
					((== gCurPuzzle 10)
						(gMessager say: 34 2 18) ; MISSING MESSAGE
					)
					((== gAct 3)
						(switch global139
							(0
								(gMessager say: noun theVerb 24) ; MISSING MESSAGE
								(++ global139)
							)
							(1
								(gMessager say: noun theVerb 25) ; MISSING MESSAGE
								(++ global139)
							)
							(2
								(gMessager say: noun theVerb 26) ; MISSING MESSAGE
							)
						)
					)
					((== gCurPuzzle 20)
						(gMessager say: 34 2 27) ; MISSING MESSAGE
					)
					((== gCurPuzzle 22)
						(gMessager say: 34 2 30) ; MISSING MESSAGE
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
		noun 12
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
			(gMessager say: noun 0 6) ; MISSING MESSAGE
		else
			(switch theVerb
				(2 ; Talk
					(cond
						((<= gAct 1)
							(switch global137
								(0
									(gMessager say: noun theVerb 9) ; MISSING MESSAGE
									(++ global137)
								)
								(1
									(gMessager say: noun theVerb 10) ; MISSING MESSAGE
									(++ global137)
								)
								(2
									(gMessager say: noun theVerb 11) ; MISSING MESSAGE
								)
							)
						)
						((or (== gCurPuzzle 8) (== gCurPuzzle 9))
							(gMessager say: noun theVerb 15) ; MISSING MESSAGE
						)
						((== gCurPuzzle 10)
							(gMessager say: noun theVerb 18) ; MISSING MESSAGE
						)
						((== gCurPuzzle 12)
							(gMessager say: noun theVerb 17) ; MISSING MESSAGE
						)
						((== gCurPuzzle 13)
							(gMessager say: noun theVerb 13) ; MISSING MESSAGE
						)
						((== gCurPuzzle 14)
							(gMessager say: noun theVerb 12) ; MISSING MESSAGE
						)
						((== gCurPuzzle 15)
							(gMessager say: noun theVerb 16) ; MISSING MESSAGE
						)
						((== gCurPuzzle 16)
							(gMessager say: noun theVerb 19) ; MISSING MESSAGE
						)
						((== gCurPuzzle 19)
							(gMessager say: noun theVerb 14) ; MISSING MESSAGE
						)
					)
				)
				(10 ; Penelope_s_Rx
					(gMessager say: 12 0 5) ; MISSING MESSAGE
				)
				(12 ; Helen_s_Rx
					(gMessager say: 12 0 5) ; MISSING MESSAGE
				)
				(14 ; Madame_s_Rx
					(gMessager say: 12 0 7) ; MISSING MESSAGE
				)
				(16 ; Under_Glass
					(self setScript: sDocReadsRX)
				)
				(17 ; Correct_Rx
					(gMessager say: 12 0 5) ; MISSING MESSAGE
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
		noun 1
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
				(gCurRoom newRoom: 675)
			)
			(2 ; Talk
				(switch global146
					(0
						(gMessager say: noun theVerb 1) ; MISSING MESSAGE
						(++ global146)
					)
					(1
						(gMessager say: noun theVerb 2) ; MISSING MESSAGE
						(++ global146)
					)
					(2
						(gMessager say: noun theVerb 3) ; MISSING MESSAGE
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
		noun 23
		view 672
		signal 20480
	)
)

(instance pokerGuy2 of Prop
	(properties
		x 267
		y 147
		noun 24
		view 672
		loop 1
		signal 20480
	)
)

(instance pokerGuy3 of Prop
	(properties
		x 255
		y 167
		noun 25
		view 672
		loop 2
		signal 20480
	)
)

(instance pokerGuy4 of Prop
	(properties
		x 191
		y 164
		noun 26
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
		noun 3
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
		noun 4
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
		noun 4
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
		noun 4
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
		noun 35
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
		noun 27
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
						(gMessager say: noun 4 22) ; MISSING MESSAGE
					)
					((== gCurPuzzle 20)
						(gMessager say: noun 4 23) ; MISSING MESSAGE
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
		noun 7
		view 678
		priority 10
		signal 20496
	)
)

(instance pChair2 of View
	(properties
		x 249
		y 127
		noun 7
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
		noun 7
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
		noun 7
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
		noun 50
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
					(gMessager say: 12 4 8) ; MISSING MESSAGE
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
		noun 7
		view 678
		priority 10
		signal 20496
	)
)

(instance chair2 of View
	(properties
		x 147
		y 127
		noun 7
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
		noun 7
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
		noun 7
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
		noun 6
		nsTop 72
		nsBottom 100
		nsRight 24
	)
)

(instance spinner of Feature
	(properties
		x 309
		y 71
		noun 14
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
		noun 47
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
		noun 28
	)
)

(instance roulette of Feature
	(properties
		x 285
		y 179
		noun 32
	)
)

(instance diceGame of Feature
	(properties
		x 310
		y 150
		noun 11
	)
)

(instance moose of Feature
	(properties
		x 289
		y 200
		noun 18
	)
)

(instance hatRack of Feature
	(properties
		x 245
		y 72
		noun 15
	)
)

(instance painting1 of Feature
	(properties
		x 223
		y 31
		noun 19
		approachX 221
		approachY 101
	)
)

(instance table1 of Feature
	(properties
		x 107
		y 89
		noun 48
	)
)

(instance table2 of Feature
	(properties
		x 198
		y 98
		noun 49
	)
)

(instance blackJack of Feature
	(properties
		x 281
		y 103
		noun 13
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
		noun 8
	)
)

(instance painting2 of Feature
	(properties
		x 7
		y 39
		noun 20
	)
)

(instance littlePic of Feature
	(properties
		x 32
		y 38
		noun 17
	)
)

(instance bar of Feature
	(properties
		x 26
		y 120
		noun 5
	)
)

(instance rail of Feature
	(properties
		x 26
		y 120
		noun 29
	)
)

(instance rowdySound of FPSound
	(properties
		flags 1
	)
)


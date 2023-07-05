;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 94)
(include sci.sh)
(use Main)
(use rm100)
(use KQ6Print)
(use KQ6Room)
(use User)
(use Actor)
(use System)

(public
	creditRoom 0
)

(local
	[local0 50]
	[local50 200]
	[local250 26] = [1 1 1 2 3 4 1 2 3 4 4 1 3 4 1 3 3 4 1 2 3 4 1 2 1 -1]
	[local276 26] = [98 100 380 240 150 480 650 520 450 580 160 490 730 690 790 770 260 750 220 470 410 510 210 290 660 -1]
	local302
	local303 = 1
	local304
	local305
	local306 = 1
)

(instance creditRoom of KQ6Room
	(properties
		picture 98
		horizon 0
	)

	(method (init &tmp temp0)
		(super init:)
		(gGlobalSound number: 10 loop: -1 play: buttonScript)
		(gTheIconBar disable:)
		(gCurRoom setScript: creditsScript)
	)

	(method (doVerb)
		(gMessager say: 2 0 0 0) ; "Thank you for playing King's Quest VI."
		(return 1)
	)
)

(instance creditsScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(DrawPic [local276 local302] 9)
				(if (== [local276 local302] 98)
					(= cycles 2)
				else
					(setUpRoom doit: self)
				)
			)
			(1
				(if (and (== [local276 local302] 98) local306)
					(= local306 0)
					(self setScript: showScore self)
				else
					(= cycles 2)
				)
			)
			(2
				(if (== [local276 local302] 98)
					(= state 3)
				)
				(= cycles 1)
			)
			(3
				(if local304
					(Message msgGET 94 1 0 0 local303 @local0)
					(Message msgGET 94 1 0 0 (++ local303) @local50)
				else
					(Message msgGET 94 0 0 0 local303 @local0)
					(Message msgGET 94 0 0 0 (++ local303) @local50)
				)
				(if (>= (++ local303) 32)
					(= local304 1)
					(= local303 1)
				)
				(switch [local250 local302]
					(1
						(Display @local0 dsCOLOR 0 dsCOORD 64 11 dsWIDTH 200 dsFONT 3110 dsALIGN alCENTER)
						(Display @local50 dsCOLOR 0 dsCOORD 64 31 dsWIDTH 200 dsFONT 2207 dsALIGN alCENTER)
						(Display @local0 dsCOLOR 7 dsCOORD 63 10 dsWIDTH 200 dsFONT 3110 dsALIGN alCENTER)
						(Display @local50 dsCOLOR 7 dsCOORD 63 30 dsWIDTH 200 dsFONT 2207 dsALIGN alCENTER)
					)
					(2
						(Display @local0 dsCOLOR 0 dsCOORD 194 11 dsWIDTH 200 dsFONT 3110 dsALIGN alCENTER)
						(Display
							@local50
							dsCOLOR
							0
							dsCOORD
							194
							31
							dsWIDTH
							200
							dsFONT
							2207
							dsALIGN
							alCENTER
						)
						(Display @local0 dsCOLOR 7 dsCOORD 194 10 dsWIDTH 200 dsFONT 3110 dsALIGN alCENTER)
						(Display
							@local50
							dsCOLOR
							7
							dsCOORD
							194
							30
							dsWIDTH
							200
							dsFONT
							2207
							dsALIGN
							alCENTER
						)
					)
					(3
						(Display @local0 dsCOLOR 0 dsCOORD 136 88 dsWIDTH 200 dsFONT 3110 dsALIGN alCENTER)
						(Display
							@local50
							dsCOLOR
							0
							dsCOORD
							136
							118
							dsWIDTH
							200
							dsFONT
							2207
							dsALIGN
							alCENTER
						)
						(Display @local0 dsCOLOR 7 dsCOORD 135 87 dsWIDTH 200 dsFONT 3110 dsALIGN alCENTER)
						(Display
							@local50
							dsCOLOR
							7
							dsCOORD
							135
							117
							dsWIDTH
							200
							dsFONT
							2207
							dsALIGN
							alCENTER
						)
					)
					(4
						(Display @local0 dsCOLOR 0 dsCOORD 11 98 dsWIDTH 200 dsFONT 3110 dsALIGN alCENTER)
						(Display
							@local50
							dsCOLOR
							0
							dsCOORD
							11
							128
							dsWIDTH
							200
							dsFONT
							2207
							dsALIGN
							alCENTER
						)
						(Display @local0 dsCOLOR 7 dsCOORD 10 97 dsWIDTH 200 dsFONT 3110 dsALIGN alCENTER)
						(Display
							@local50
							dsCOLOR
							7
							dsCOORD
							10
							127
							dsWIDTH
							200
							dsFONT
							2207
							dsALIGN
							alCENTER
						)
					)
				)
				(if (not local305)
					(= seconds 8)
				else
					(client setScript: buttonScript)
				)
			)
			(4
				(if (== [local276 (++ local302)] -1)
					(= local302 0)
					(= local303 1)
					(= local304 0)
					(= local305 1)
				)
				(self init:)
			)
		)
	)
)

(instance buttonScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 200])
		(switch (= state newState)
			(0
				(gTheIconBar
					enable:
					disable: 0 1 2 3 4 5 6
					activateHeight: -100
					height: -100
				)
				(User canInput: 1)
				(gGame setCursor: gNormalCursor)
				(quitBut init:)
				(replayBut init:)
				(restartBut init:)
				(= cycles 10)
			)
			(1)
		)
	)
)

(instance showScore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(KQ6Print
					font: gUserFont
					addTextF:
						{You received %d out of %d points. You've completed approximately %d percent of the main-path puzzles in King's Quest VI.}
						gScore
						gPossibleScore
						(/ (* gScore 100) gPossibleScore)
					init:
				)
				(= cycles 1)
			)
			(1
				(if (<= gScore 230)
					(gMessager say: 0 0 1 2 self) ; "We hope you'll play again!"
				else
					(gMessager say: 0 0 1 3 self) ; "Congratulations on your excellent performance! If you want to go "beyond" the ultimate score, we recommend that you try the other, "easier" entrance to the castle. You can do so easily by restoring back to a point just before the Druid's rain storm. DON'T GO BACK TO SEE THE DRUIDS--instead, head for the castle. New puzzle challenges await you!"
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance quitBut of ButtonActor
	(properties
		x 191
		y 173
		view 94
		loop 2
	)

	(method (cue)
		(super cue: &rest)
		(= gQuit 1)
	)
)

(instance replayBut of ButtonActor
	(properties
		x 77
		y 173
		view 94
	)

	(method (cue)
		(super cue: &rest)
		(gGame setCursor: gWaitCursor)
		(= local302 0)
		(= local303 1)
		(= local304 0)
		(= local305 0)
		(quitBut dispose:)
		(restartBut dispose:)
		(gCurRoom init:)
		(self dispose:)
	)
)

(instance restartBut of ButtonActor
	(properties
		x 134
		y 173
		view 94
		loop 1
	)

	(method (cue)
		(super cue: &rest)
		(gGame restart: 1)
	)
)

(instance setUpRoom of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0 param1)
		(= param1 0)
		(switch [local276 local302]
			(100
				((= temp1 (Prop new:))
					view: 101
					loop: 0
					cel: 11
					x: 113
					y: 74
					init:
					addToPic:
					dispose:
				)
			)
			(380
				((= temp1 (Prop new:))
					view: 383
					loop: 0
					cel: 0
					x: 94
					y: 87
					init:
					addToPic:
					dispose:
				)
				((= temp2 (Prop new:))
					view: 382
					loop: 1
					cel: 0
					x: 158
					y: 49
					init:
					addToPic:
					dispose:
				)
			)
			(240
				((= temp1 (Prop new:))
					view: 240
					loop: 0
					cel: 0
					x: 254
					y: 99
					init:
					addToPic:
					dispose:
				)
				((= temp2 (Prop new:))
					view: 240
					loop: 1
					cel: 0
					x: 186
					y: 86
					init:
					addToPic:
					dispose:
				)
			)
			(150
				((= temp1 (Prop new:))
					view: 150
					loop: 7
					cel: 0
					x: 291
					y: 120
					init:
					addToPic:
					dispose:
				)
			)
			(480
				((= temp1 (Prop new:))
					view: 4801
					loop: 0
					cel: 0
					x: 142
					y: 76
					init:
					addToPic:
					dispose:
				)
				((= temp2 (Prop new:))
					view: 4801
					loop: 1
					x: 277
					y: 129
					init:
					addToPic:
					dispose:
				)
				((= temp3 (Prop new:))
					view: 4851
					loop: 0
					x: 215
					y: 91
					init:
					addToPic:
					dispose:
				)
				((= temp4 (Prop new:))
					view: 4851
					loop: 1
					x: 229
					y: 93
					init:
					addToPic:
					dispose:
				)
				((= temp5 (Prop new:))
					view: 4851
					loop: 2
					x: 252
					y: 84
					init:
					addToPic:
					dispose:
				)
				((= temp6 (Prop new:))
					view: 4851
					loop: 3
					x: 253
					y: 85
					init:
					addToPic:
					dispose:
				)
			)
			(650
				((= temp1 (Prop new:))
					view: 650
					loop: 0
					cel: 0
					x: 159
					y: 51
					init:
					addToPic:
					dispose:
				)
				((= temp2 (Prop new:))
					view: 650
					loop: 1
					cel: 0
					x: 299
					y: 61
					init:
					addToPic:
					dispose:
				)
				((= temp3 (Prop new:))
					view: 650
					loop: 2
					cel: 0
					x: 65
					y: 89
					init:
					addToPic:
					dispose:
				)
			)
			(160
				((= temp1 (Prop new:))
					view: 160
					loop: 7
					cel: 0
					x: 5
					y: 79
					init:
					addToPic:
					dispose:
				)
			)
			(690
				((= temp1 (Prop new:))
					view: 690
					loop: 1
					cel: 0
					x: 22
					y: 82
					init:
					addToPic:
					dispose:
				)
				((= temp2 (Prop new:))
					view: 691
					loop: 6
					cel: 0
					x: 111
					y: 119
					init:
					addToPic:
					dispose:
				)
				((= temp3 (Prop new:))
					view: 692
					loop: 0
					cel: 0
					x: 224
					y: 107
					init:
					addToPic:
					dispose:
				)
			)
			(730
				((= temp1 (Prop new:))
					view: 730
					loop: 0
					cel: 0
					x: 160
					y: 100
					init:
					addToPic:
					dispose:
				)
				((= temp2 (Prop new:))
					view: 730
					loop: 1
					cel: 0
					x: 70
					y: 143
					z: 28
					init:
					addToPic:
					dispose:
				)
				((= temp3 (Prop new:))
					view: 730
					loop: 2
					cel: 0
					x: 250
					y: 119
					init:
					addToPic:
					dispose:
				)
			)
			(260
				((= temp1 (Prop new:))
					view: 260
					loop: 0
					cel: 0
					x: 22
					y: 80
					init:
					addToPic:
					dispose:
				)
			)
			(220
				((= temp1 (Prop new:))
					view: 220
					loop: 0
					cel: 0
					x: 107
					y: 94
					init:
					addToPic:
					dispose:
				)
			)
			(510
				((= temp1 (Prop new:))
					view: 510
					loop: 1
					cel: 0
					x: 236
					y: 58
					init:
					addToPic:
					dispose:
				)
			)
			(290
				((= temp1 (Prop new:))
					view: 290
					loop: 3
					cel: 0
					x: 136
					y: 80
					init:
					addToPic:
					dispose:
				)
			)
			(750
				((= temp1 (Prop new:))
					view: 7500
					loop: 0
					cel: 0
					x: 210
					y: 115
					init:
					addToPic:
					dispose:
				)
			)
			(470
				((= temp1 (Prop new:))
					view: 475
					loop: 2
					cel: 2
					x: 273
					y: 119
					init:
					addToPic:
					dispose:
				)
			)
			(else 1)
		)
		(temp0 cue:)
	)
)


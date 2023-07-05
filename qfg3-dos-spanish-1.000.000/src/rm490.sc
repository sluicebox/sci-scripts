;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 490)
(include sci.sh)
(use Main)
(use GloryWindow)
(use Teller)
(use Print)
(use Talker)
(use IconBar)
(use GameControls)
(use Game)
(use Actor)
(use System)

(public
	rm490 0
	yesuTalker 1
)

(local
	[local0 8] = [0 16 17 -18 24 25 26 999]
	[local8 6] = [0 -19 21 22 23 999]
	[local14 3] = [0 20 999]
	[local17 9] = [0 16 27 28 29 30 31 32 999]
	[local26 9] = [0 16 33 40 34 35 39 42 999]
	[local35 5]
	[local40 4] = [0 -18 -19 999]
	[local44 4] = [0 44 45 999]
	[local48 5] = [0 44 46 34 999]
	[local53 4] = [0 44 -47 999]
	[local57 4]
	local61
	[local62 14]
	local76
	local77
	local78
	local79
	local80
	local81
	local82
	[local83 14] = [209 181 154 130 104 77 56 86 113 141 167 194 221 238]
	[local97 14] = [62 69 75 82 89 95 115 121 115 108 100 93 87 68]
	[local111 90] = [3 3 3 3 3 3 0 3 3 3 3 3 3 0 143 129 103 94 68 57 36 65 77 101 115 141 156 178 13 15 20 17 24 26 45 50 49 42 47 38 37 20 220 209 190 168 159 132 110 142 166 173 195 211 222 238 152 162 163 171 173 179 197 205 199 196 193 183 177 157 5 22 34 36 55 55 48 49 -27 -15 -3 -5 20 47 57 59 58 61 51 42]
	[local201 14]
	local215
	local216
	local217
	local218
)

(procedure (localproc_0 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 [temp4 6] [temp10 14] temp24 temp25 temp26 temp27 temp28)
	(= temp24 1)
	(= temp25 -50)
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		(if [param5 temp0]
			(for ((= temp1 0)) (< temp1 14) ((++ temp1))
				(= [temp10 temp1] [param5 temp1])
			)
			(= temp3 0)
			(= temp28 [temp10 temp0])
			(= [temp10 temp0] 0)
			(= temp1 temp28)
			(= temp2 temp0)
			(while (> temp1 0)
				(if (> (++ temp2) 13)
					(= temp2 0)
				)
				(switch temp2
					(6
						(++ temp3)
					)
					(13
						(-- temp3)
					)
				)
				(++ [temp10 temp2])
				(-- temp1)
			)
			(if (and (== temp2 6) (not param4))
				(+=
					temp3
					(localproc_0
						param1
						param2
						0
						1
						[temp10 0]
						[temp10 1]
						[temp10 2]
						[temp10 3]
						[temp10 4]
						[temp10 5]
						[temp10 6]
						[temp10 7]
						[temp10 8]
						[temp10 9]
						[temp10 10]
						[temp10 11]
						[temp10 12]
						[temp10 13]
					)
				)
			else
				(if
					(and
						(!= temp2 6)
						(!= temp2 13)
						(== [temp10 temp2] 1)
						(> [temp10 (- 12 temp2)] 0)
					)
					(= temp3 (+ [temp10 (- 12 temp2)] 1))
					(= [temp10 temp2] 0)
					(= [temp10 (- 12 temp2)] 0)
				)
				(if (> param2 1)
					(if
						(==
							(= temp27
								(localproc_0
									(- 1 param1)
									(- param2 1)
									0
									0
									[temp10 7]
									[temp10 8]
									[temp10 9]
									[temp10 10]
									[temp10 11]
									[temp10 12]
									[temp10 13]
									[temp10 0]
									[temp10 1]
									[temp10 2]
									[temp10 3]
									[temp10 4]
									[temp10 5]
									[temp10 6]
								)
							)
							-50
						)
						(= temp27 0)
					)
					(-= temp3 temp27)
				)
			)
			(cond
				(
					(or
						(and param1 (> temp3 temp25))
						(and (not param1) (< temp3 temp25))
					)
					(= temp25 temp3)
					(= temp24 1)
					(= [temp4 0] temp0)
				)
				((== temp3 temp25)
					(++ temp24)
					(= [temp4 (- temp24 1)] temp0)
				)
			)
		)
	)
	(if (== param2 local79)
		(= local61 [temp4 (Random 0 (- temp24 1))])
	)
	(return temp25)
)

(procedure (localproc_1)
	(return
		(not
			(and
				(+
					[local62 0]
					[local62 1]
					[local62 2]
					[local62 3]
					[local62 4]
					[local62 5]
				)
				(+
					[local62 7]
					[local62 8]
					[local62 9]
					[local62 10]
					[local62 11]
					[local62 12]
				)
			)
		)
	)
)

(procedure (localproc_2 param1 param2)
	(if local82
		(local82 stopUpd:)
	)
	(= [local62 param1] param2)
	([local201 param1] startUpd: cel: (if (> param2 14) 14 else param2))
	(= local82 [local201 param1])
)

(procedure (localproc_3)
	(HandsOn)
	(gTheIconBar disable: 5 6 7 8)
	(gTheIconBar enable: 9)
	(tray setScript: moveScript)
)

(instance rm490 of Rm
	(properties
		picture 490
		style 9
	)

	(method (init)
		(HandsOff)
		(gTheIconBar disable: 9)
		(gEgo noun: 3)
		(= local81 gSpeed)
		(= gSpeed 1)
		(for ((= local76 0)) (< local76 14) ((++ local76))
			(= [local62 local76] [local111 local76])
			(= [local201 local76]
				((tray new:)
					cel: [local111 local76]
					x: (+ [local83 local76] 48)
					y: (+ [local97 local76] 37)
					heading: local76
					init:
					stopUpd:
					yourself:
				)
			)
		)
		(= local79 global209)
		(= local80 0)
		(super init:)
		(gLongSong setLoop: -1 changeTo: 490)
		(yesufuHead init:)
		(self setScript: startGame)
		(gWalkHandler add: self)
		(gEgo solvePuzzle: 285 3)
	)

	(method (doit)
		(super doit:)
		(if (tray script:)
			((tray script:) doit:)
		)
		(if (GameIsRestarting)
			(yesufuHead init:)
		)
	)

	(method (dispose)
		(= gSpeed local81)
		(gWalkHandler delete: self)
		((gEgo actions:) dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gEgo addHonor: -20)
				(gCurRoom newRoom: 480)
			)
			(2 ; Talk
				((gEgo actions:) doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tray of Prop
	(properties
		view 490
		signal 16640
	)

	(method (doVerb theVerb &tmp [temp0 40])
		(cond
			((== theVerb 2) ; Talk
				((gEgo actions:) doVerb: theVerb)
			)
			((== theVerb 1) ; Look
				(Message msgGET 490 4 1 52 1 @temp0) ; "There are %d stones in this tray."
				(Print addTextF: @temp0 [local62 heading] init:)
			)
			((== theVerb 3) ; Walk
				(gCurRoom doVerb: 3)
			)
			((!= theVerb 4) ; Do
				(super doVerb: theVerb &rest)
			)
			((< heading 6)
				(gMessager say: 4 4 53) ; "This is Yesufu's side. You cannot remove stones from here unless you win them."
			)
			((== heading 6)
				(gMessager say: 4 4 54) ; "This is your opponent's home tray."
			)
			((== heading 13)
				(gMessager say: 4 4 55) ; "This is your home tray."
			)
			([local62 heading]
				(tray setScript: 0)
				(= local77 heading)
				(gCurRoom setScript: playersMove)
			)
			(else
				(gMessager say: 4 4 56) ; "You have no stones there."
			)
		)
	)
)

(instance startGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== global454 0)
						(= [local57 0] @local44)
						(= [local35 0] @local0)
						(= [local35 1] @local8)
						(= [local35 2] @local14)
						(egoTeller init: gEgo @local44 @local57)
						(yesuTeller init: yesufuHead @local0 @local35 @local40)
						(= seconds 2)
					)
					((== global454 1)
						(= [local57 0] @local48)
						(= [local35 0] @local17)
						(egoTeller init: gEgo @local48 @local57)
						(yesuTeller init: yesufuHead @local17 @local35 @local40)
						(= seconds 2)
					)
					((== global454 2)
						(= [local57 0] @local53)
						(= [local35 0] @local26)
						(egoTeller init: gEgo @local53 @local57)
						(yesuTeller init: yesufuHead @local26 @local35 @local40)
						(= seconds 2)
					)
					(else
						(++ global454)
						(= [local57 0] @local53)
						(= [local35 0] @local26)
						(egoTeller init: gEgo @local53 @local57)
						(yesuTeller init: yesufuHead @local26 @local35 @local40)
						(localproc_3)
						(self dispose:)
					)
				)
			)
			(1
				(cond
					((== global454 0)
						(gMessager say: 2 6 15 0 self) ; "The side near me be my side. The hole on the end at your left be my home. The hole on the end at your right be your home."
					)
					((== global454 1)
						(gMessager say: 2 6 36 0 self) ; "I would be happy if you will tell me some stories of how you became a hero while we play."
					)
					((== global454 2)
						(gMessager say: 2 6 34 0 self) ; "I be thinking that maybe the words you speak of peace be real. Maybe I will try to help you to bring peace to my people."
					)
				)
				(++ global454)
			)
			(2
				(localproc_3)
				(self dispose:)
			)
		)
	)
)

(instance playersMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local216 0)
				(HandsOff)
				(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
			)
			(1
				(= local78 [local62 local77])
				(gLongSong2 number: 491 setLoop: 1 play: 127)
				(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
				(localproc_2 local77 0)
			)
			(2
				(if (> (++ local77) 13)
					(= local77 0)
				)
				(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
			)
			(3
				(gLongSong2 number: 491 setLoop: 1 play: 127)
				(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
				(localproc_2 local77 (++ [local62 local77]))
			)
			(4
				(= register 0)
				(cond
					((-- local78)
						(-= state 3)
						(= cycles 1)
					)
					((not (or (== local77 6) (== local77 13)))
						(= cycles 1)
					)
					((localproc_1)
						(gCurRoom setScript: gameDoneSequence)
					)
					((and (== local77 13) (not local215))
						(++ local215)
						(= register 1)
						(gMessager say: 2 6 13 0 self) ; "You now go again."
					)
					((localproc_1)
						(gCurRoom setScript: gameDoneSequence)
					)
					(else
						(= register 2)
						(gMessager say: 2 6 2 0 self) ; "It be my move."
					)
				)
			)
			(5
				(cond
					((== register 1)
						(localproc_3)
						(self dispose:)
					)
					((== register 2)
						(gCurRoom setScript: computersMove)
					)
					((and (== [local62 local77] 1) [local62 (- 12 local77)])
						(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
						(+= local78 [local62 local77])
						(localproc_2 local77 0)
					)
					((localproc_1)
						(gCurRoom setScript: gameDoneSequence)
					)
					(else
						(= register 2)
						(gMessager say: 2 6 2 0 self) ; "It be my move."
					)
				)
			)
			(6
				(if (== register 2)
					(gCurRoom setScript: computersMove)
				else
					(= local77 (- 12 local77))
					(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
				)
			)
			(7
				(+= local78 [local62 local77])
				(localproc_2 local77 0)
				(if (< local77 6)
					(gMessager say: 2 6 6 0 self) ; "Very good move. You got my stones."
				else
					(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
				)
			)
			(8
				(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
			)
			(9
				(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
				(localproc_2 13 (+ [local62 13] local78))
			)
			(10
				(if (localproc_1)
					(gCurRoom setScript: gameDoneSequence)
				else
					(gMessager say: 2 6 2 0 self) ; "It be my move."
				)
			)
			(11
				(gCurRoom setScript: computersMove)
			)
		)
	)
)

(instance computersMove of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local215 0)
				(= cycles 1)
			)
			(1
				(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
			)
			(2
				(HandsOff)
				(if local80
					(localproc_0
						1
						local79
						1
						0
						[local62 0]
						[local62 1]
						[local62 2]
						[local62 3]
						[local62 4]
						[local62 5]
						[local62 6]
						[local62 7]
						[local62 8]
						[local62 9]
						[local62 10]
						[local62 11]
						[local62 12]
						[local62 13]
					)
				else
					(= local80 1)
					(if (< (Random 0 9) 7)
						(= local61 (Random 3 5))
					else
						(= local61 (Random 0 1))
					)
					(Wait 0)
					(Wait 6)
				)
				(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
			)
			(3
				(= local78 [local62 local61])
				(localproc_2 local61 0)
				(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
			)
			(4
				(if (> (++ local61) 13)
					(= local61 0)
				)
				(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
			)
			(5
				(gLongSong2 number: 491 setLoop: 1 play: 127)
				(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
				(localproc_2 local61 (++ [local62 local61]))
			)
			(6
				(= register 0)
				(cond
					((-- local78)
						(-= state 3)
						(= cycles 1)
					)
					((not (or (== local61 6) (== local61 13)))
						(= cycles 1)
					)
					((localproc_1)
						(gCurRoom setScript: gameDoneSequence)
					)
					((and (== local61 6) (not local216))
						(= local216 1)
						(gCurRoom setScript: self)
					)
					(else
						(= register 3)
						(gMessager say: 2 6 4 0 self) ; "It be your turn to move your stones now."
					)
				)
			)
			(7
				(cond
					((== register 3)
						(localproc_3)
						(self dispose:)
					)
					((and (== [local62 local61] 1) [local62 (- 12 local61)])
						(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
						(+= local78 [local62 local61])
						(localproc_2 local61 0)
					)
					((localproc_1)
						(gCurRoom setScript: gameDoneSequence)
					)
					(else
						(= register 3)
						(gMessager say: 2 6 4 0 self) ; "It be your turn to move your stones now."
					)
				)
			)
			(8
				(if (== register 3)
					(localproc_3)
					(self dispose:)
				else
					(= local61 (- 12 local61))
					(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
				)
			)
			(9
				(if (< 6 local61 13)
					(gMessager say: 2 6 3 1 self) ; "I be capturing some of your stones now."
				else
					(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
				)
				(+= local78 [local62 local61])
				(localproc_2 local61 0)
			)
			(10
				(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
			)
			(11
				(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
				(localproc_2 6 (+ [local62 6] local78))
			)
			(12
				(if (localproc_1)
					(gCurRoom setScript: gameDoneSequence)
				else
					(gMessager say: 2 6 4 0 self) ; "It be your turn to move your stones now."
				)
			)
			(13
				(localproc_3)
				(self dispose:)
			)
		)
	)
)

(instance gameDoneSequence of Script
	(properties)

	(method (changeState newState &tmp [temp0 70] temp70 temp71)
		(switch (= state newState)
			(0
				(gEgo useSkill: 1 20) ; intelligence
				(HandsOff)
				(gMessager say: 2 6 7 0 self) ; "Now this game is over."
			)
			(1
				(cond
					((< [local62 6] [local62 13])
						(gMessager say: 2 6 9 0 self) ; "You have more stones in your home than I have in mine. You be the winner."
					)
					((> [local62 6] [local62 13])
						(gMessager say: 2 6 8 0 self) ; "I have more stones in my home then you have in your home. I be the winner."
					)
					(else
						(gMessager say: 2 6 50 0 self) ; "We both have the same number of stones in our home. It be a tie!"
					)
				)
			)
			(2
				(= cycles 8)
			)
			(3
				(if (== local217 5)
					(= register 1)
					(gMessager say: 2 6 43 0 self) ; "I can play no more today. I must be watching the cattle soon. It be fun playing with you."
				else
					(gMessager say: 2 6 10 0 self) ; "You play a good game. Maybe we play again?"
				)
			)
			(4
				(if register
					(gCurRoom newRoom: 480)
				else
					(= temp71 (gGame setCursor: 999))
					((= global469 (GameControls new:))
						window:
							((GloryWindow new:)
								top: 51
								left: 64
								bottom: 143
								right: 257
								priority: 15
								yourself:
							)
					)
					(= temp70 ((ScriptID 0 17) new: 1 0 51 1 490)) ; textIcon
					(temp70
						view: 935
						loop: 1
						cel: 0
						nsTop: 2
						nsLeft: 2
						modifiers: 1
						signal: 132
					)
					(global469 add: temp70)
					(= temp70 ((ScriptID 0 17) new: 1 0 0 1 490)) ; textIcon
					(temp70 nsTop: 70 nsLeft: 29 cursor: 1)
					(global469 add: temp70)
					(= temp70 ((ScriptID 0 17) new: 1 0 0 2 490)) ; textIcon
					(temp70 nsTop: 70 nsLeft: 129 cursor: 0)
					(global469 add: temp70)
					(= temp70 (IconI new:))
					(temp70
						nsTop: 25
						nsLeft: 29
						view: 490
						loop: 0
						cel: [local62 6]
						maskView: 490
						maskLoop: 0
						maskCel: [local62 6]
						signal: 132
					)
					(global469 add: temp70)
					(= temp70 (IconI new:))
					(temp70
						nsTop: 25
						nsLeft: 129
						view: 490
						loop: 0
						cel: [local62 13]
						maskView: 490
						maskLoop: 0
						maskCel: [local62 13]
						signal: 132
					)
					(global469 add: temp70)
					(= temp70 (textI new: 1 0 49 1 490 [local62 6]))
					(temp70 nsTop: 50 nsLeft: 19 signal: 132)
					(global469 add: temp70)
					(= temp70 (textI new: 1 0 48 1 490 [local62 13]))
					(temp70 nsTop: 50 nsLeft: 125 signal: 132)
					(global469 add: temp70)
					(global469 show: dispose:)
					(gGame setCursor: temp71)
					(if global460
						(++ local217)
						(gMessager say: 2 6 11 0 self) ; "Mzuri. We will see how well you do this time."
						(for ((= local76 0)) (< local76 14) ((++ local76))
							(= [local62 local76] [local111 local76])
							([local201 local76]
								cel: [local111 local76]
								startUpd:
							)
						)
						(= local80 0)
					else
						(= register 1)
						(gMessager say: 2 6 12 0 self) ; "Maybe then we play another time."
					)
				)
			)
			(5
				(if register
					(gCurRoom newRoom: 480)
				else
					(for ((= local76 0)) (< local76 14) ((++ local76))
						([local201 local76] stopUpd:)
					)
					(if (== local217 1)
						(cond
							((== global454 0)
								(gMessager say: 2 6 37 0 self) ; "You learn fast and play very well."
							)
							((== global454 1)
								(gMessager say: 2 6 38 0 self) ; "My people have a saying, Haba na haba hujaza kibaba - little and little fill the kibaba measure. This means doing things a little at a time will get things done. I think about this while playing Awari."
							)
							((== global454 2)
								(gMessager say: 2 6 41 0 self) ; "The Warriors sound very brave when they talk about war. Only Uhura talks about peace. The other Warriors get mad at her. They be saying words like coward. Still she talks of peace."
							)
							(else
								(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
							)
						)
					else
						(= ticks (+ (* (gEgo moveSpeed:) 3) 1))
					)
				)
			)
			(6
				(if local218
					(= local218 0)
					(self dispose:)
				else
					(= local218 1)
					(gCurRoom setScript: computersMove)
				)
			)
		)
	)

	(method (dispose)
		(localproc_3)
		(super dispose: &rest)
	)
)

(instance textI of IconI
	(properties
		view 935
		loop 2
		cel 0
	)

	(method (new param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 [temp3 30])
		(= temp0 (Clone self))
		(if argc
			(= temp1 (Message msgSIZE param5 param1 param2 param3 param4))
			(temp0 message: (Memory memALLOC_NONCRIT temp1))
			(Message msgGET param5 param1 param2 param3 param4 @temp3)
			(Format (temp0 message:) @temp3 param6)
		)
		(return temp0)
	)

	(method (show)
		(= nsRight nsLeft)
		(= nsBottom nsTop)
		(Display message dsCOORD nsLeft nsBottom dsFONT 0 dsCOLOR 17 dsALIGN modifiers dsWIDTH 189)
	)

	(method (highlight))

	(method (select))

	(method (mask))

	(method (dispose)
		(Memory memFREE message)
		(super dispose:)
	)
)

(instance yesufuHead of View
	(properties
		x 5
		y 8
		noun 2
		view 981
		loop 1
		priority 1
		signal 16
	)

	(method (init)
		(Graph grFILL_BOX 10 10 98 126 1 12 -1)
		(Graph grUPDATE_BOX 10 10 98 126 1)
		(super init:)
		(DrawCel 934 2 0 10 10 2)
	)
)

(instance yesuTeller of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				25 ; "Uhura"
				local217
				26 ; "Laibon"
				local217
				31 ; "Winning"
				local217
				32 ; "Losing"
				local217
				39 ; "Help"
				local217
				42 ; "Bravery"
				local217
		)
	)
)

(instance egoTeller of Teller
	(properties)

	(method (cue)
		(gMessager caller: 0)
		(gCurRoom newRoom: 480)
	)

	(method (respond)
		(super respond: &rest)
		(if (== query 44)
			(HandsOff)
			(gMessager caller: self)
		)
		(return 1)
	)

	(method (doChild)
		(if (not (IsFlag 286))
			(gEgo addHonor: 20)
		)
		(gEgo solvePuzzle: 286 3)
		(return 1)
	)
)

(instance yesuTalker of Talker
	(properties
		x 5
		y 8
		view 981
		loop 1
		talkWidth 260
		back 57
		textX 20
		textY 100
	)

	(method (init)
		(super init: yesuBust yesuEyes yesuMouth &rest)
	)
)

(instance yesuMouth of Prop
	(properties
		nsTop 54
		nsLeft 39
		view 981
	)
)

(instance yesuEyes of Prop
	(properties
		nsTop 38
		nsLeft 34
		view 981
		loop 2
	)
)

(instance yesuBust of View
	(properties
		nsTop 21
		nsLeft 31
		view 981
		loop 3
	)
)

(instance moveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(gMessager say: 2 6 5 1 self) ; "It be your turn to move."
			)
			(2
				(self init:)
			)
		)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 377)
(include sci.sh)
(use Main)
(use dummyClient)
(use PuzzleIcon)
(use Interface)
(use LoadMany)
(use Window)
(use Sound)
(use System)

(public
	pWord 0
	theWord 1
)

(local
	local0
	local1
	[local2 20]
	local22
	[local23 11] = [22 13 9 4 18 6 0 24 10 7 8]
	local34 = -1
	[local35 44] = [37 24 103 35 26 35 92 46 37 46 125 57 37 57 136 68 37 68 92 79 37 79 103 90 4 101 114 112 4 112 103 123 26 123 103 134 26 134 114 145 15 145 70 156]
	local79 = -1
	[local80 11] = [{P} {A} {R} {L} {O} {R} {G} {A} {M} {E} {S}]
	local91
	local92
	local93
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1)
	(= temp0 0)
	(++ param1)
	(while (!= (= temp1 (StrAt param1 temp0)) 32)
		(StrAt param2 temp0 temp1)
		(++ temp0)
	)
	(StrAt param2 temp0 0)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 [temp3 20] temp23 temp24 temp25)
	(= temp24 (sWordSet size:))
	(for ((= temp0 0)) (< temp0 11) ((++ temp0))
		(= temp23 (sWordSet at: temp0))
		(localproc_0 (pWord at: [local23 temp0]) @temp3)
		(if temp24
			(if (temp23 filled:)
				(localproc_0 (pWord at: (temp23 curGuest:)) @temp3)
				(temp23 upDate: 0 222)
				(temp23 showWord: @temp3)
				(if (temp23 correct:)
					(= temp25 1)
				else
					(= temp25 0)
				)
				(temp23 placeWord: @temp3 temp25 (temp23 curGuest:))
			)
		else
			(= temp2 (SWord new:))
			(= temp1 (* temp0 4))
			(temp2
				nsLeft: [local35 temp1]
				nsTop: [local35 (+ temp1 1)]
				nsRight: [local35 (+ temp1 2)]
				nsBottom: [local35 (+ temp1 3)]
				value: temp0
				length: (StrLen @temp3)
				init:
			)
			(sWordSet add: temp2)
		)
	)
)

(procedure (localproc_2 &tmp temp0 [temp1 100])
	(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
		(localproc_0 (pWord at: ((sWordSet at: temp0) curGuest:)) @temp1)
		(if (not (StrCmp @temp1 @local2))
			(return temp0)
		)
	)
	(return -1)
)

(procedure (localproc_3 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (param1 x:))
	(= temp1 (param1 y:))
	(switch (param1 message:)
		(1
			(= temp3 (- temp1 11))
		)
		(5
			(if (>= temp1 151)
				(= temp2 60)
				(= temp3 30)
			else
				(= temp3 (+ temp1 11))
			)
		)
		(else
			(return)
		)
	)
	(if (mod (- temp3 30) 11)
		(gGame setCursor: gTheCursor 1 60 30)
	else
		(gGame setCursor: gTheCursor 1 60 temp3)
	)
)

(instance rewardSound of Sound
	(properties
		flags 1
		number 51
	)
)

(instance wordSound of Sound
	(properties
		flags 1
		number 59
	)
)

(class SWord of Obj
	(properties
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
		value 0
		length 0
		filled 0
		correct 0
		curGuest -1
		underBits 0
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 [temp5 20] temp25 temp26)
		(= temp1 (event x:))
		(= temp2 (event y:))
		(= temp25 0)
		(= temp3 (event type:))
		(= temp0 (event message:))
		(if (self onMe: event)
			(if (or (and (& temp3 evKEYBOARD) (== temp0 KEY_RETURN)) (== temp3 evJOYDOWN))
				(= temp3 evMOUSEBUTTON)
			)
			(switch temp3
				(evNULL
					(if (!= value local79)
						(= temp4 (sWordSet at: local79))
						(if (and (>= local79 0) (temp4 underBits:))
							(temp4 upDate: 1 0)
						)
						(self upDate: 0 199)
						(if filled
							(localproc_0 (pWord at: curGuest) @temp5)
							(self showWord: @temp5)
						)
						(= local79 value)
					)
				)
				(evMOUSEBUTTON
					(if
						(or
							(= temp25 (== local34 [local23 value]))
							(== length (StrLen @local2))
						)
						(if (!= (= temp26 (localproc_2)) -1)
							((sWordSet at: temp26)
								curGuest: -1
								filled: 0
								correct: 0
								upDate: 1 0
								upDate: 2 0
							)
						)
						(self placeWord: @local2 temp25 0)
					else
						(proc5_9 377 0) ; "The selected word doesn't fit properly on this line."
					)
				)
			)
			(return 1)
		)
	)

	(method (placeWord param1 param2 param3)
		(self upDate: 1 0)
		(wordSound play:)
		(self upDate: 0 222)
		(self showWord: param1)
		(= filled 1)
		(++ local91)
		(if underBits
			(UnLoad 133 underBits)
		)
		(= underBits (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1))
		(= curGuest (if param3 param3 else local34))
		(= correct param2)
		(if (self checkForDone:)
			(self flashSecretWord: 36)
			(self flashSecretWord: 199)
			(self flashSecretWord: 36)
			(Wait 0)
			(Wait 60)
			(rewardSound play:)
			(proc5_9 377 1) ; "Congratulations! You've solved both the word search and acrostic puzzles, proving yourself to be an expert at word games. You are awarded the Word Game Achievement plaque and a set of tangram pieces that you can use to open the door at the end of the hallway."
			(gEgo get: 9)
			(gEgo get: 26)
			(theWord solvePuzzle: 2 goAway:)
		)
	)

	(method (onMe param1 &tmp temp0 temp1)
		(= temp0 (param1 x:))
		(= temp1 (param1 y:))
		(return (and (<= nsLeft temp0 nsRight) (<= nsTop temp1 nsBottom)))
	)

	(method (showWord param1 &tmp temp0 temp1 temp2)
		(= temp1 0)
		(for ((= temp0 nsLeft)) (< temp0 nsRight) ((+= temp0 11))
			(= temp2 (StrAt param1 temp1))
			(Display @temp2 dsCOORD (+ temp0 2) (+ nsTop 2) dsFONT 999 dsCOLOR 99)
			(++ temp1)
		)
	)

	(method (upDate param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(switch param1
			(0
				(++ local91)
				(if underBits
					(UnLoad 133 underBits)
				)
				(= underBits (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1))
				(for ((= temp0 nsLeft)) (< temp0 nsRight) ((+= temp0 11))
					(Graph
						grFILL_BOX
						(= temp1 (+ nsTop 1))
						(= temp3 (+ temp0 1))
						(= temp2 nsBottom)
						(= temp4 (+ temp0 11))
						1
						(if (== temp0 48) 53 else param2)
						-1
						-1
					)
					(Graph grUPDATE_BOX temp1 temp3 temp2 temp4 1)
				)
			)
			(1
				(-- local91)
				(Graph grRESTORE_BOX underBits)
				(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
			)
			(2
				(for ((= temp0 nsLeft)) (< temp0 nsRight) ((+= temp0 11))
					(Graph
						grFILL_BOX
						(= temp1 (+ nsTop 1))
						(= temp3 (+ temp0 1))
						(= temp2 nsBottom)
						(= temp4 (+ temp0 11))
						1
						(if (== temp0 48) 53 else 5)
						-1
						-1
					)
					(Graph grUPDATE_BOX temp1 temp3 temp2 temp4 1)
				)
			)
		)
	)

	(method (checkForDone &tmp temp0)
		(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
			(if (!= ((sWordSet at: temp0) correct:) 1)
				(return 0)
			)
		)
		(return 1)
	)

	(method (flashSecretWord param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 20])
		(Wait 0)
		(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
			(= temp5 (sWordSet at: temp0))
			(Graph
				grFILL_BOX
				(= temp1 (+ (temp5 nsTop:) 1))
				(= temp3 49)
				(= temp2 (temp5 nsBottom:))
				(= temp4 59)
				1
				param1
				-1
				-1
			)
			(Graph grUPDATE_BOX temp1 temp3 temp2 temp4 1)
			(Display [local80 temp0] dsCOORD 50 (+ (temp5 nsTop:) 2) dsFONT 999 dsCOLOR 99)
			(Wait 10)
		)
	)
)

(instance puzWindow of SysWindow
	(properties
		top 12
		left 62
		bottom 175
		right 277
		back 43
	)

	(method (open)
		(super open:)
		(DrawCel 350 0 0 2 22 15)
		(= local0 (+ 68 (CelWide 350 0 0)))
		(= local1 36)
		(pWord nsLeft: (- local0 62) nsTop: (- local1 12) init:)
		(localproc_1)
		(localproc_0 (pWord at: 0) @local2)
		(= local34 0)
	)
)

(instance theWord of PuzzleBar
	(properties
		puzzleHeight 169
		bottomHeight 0
		solvedFlag 15
	)

	(method (init)
		(= window puzWindow)
		(LoadMany rsSOUND 51 59)
		(super init: &rest)
		(self show:)
	)

	(method (dispose)
		(sWordSet eachElementDo: #dispose release: dispose:)
		(pWord dispose:)
		(super dispose: &rest)
	)

	(method (show &tmp temp0 temp1)
		(super show: &rest)
		(for ((= temp1 0)) (<= temp1 10) ((++ temp1))
			(= temp0 (sWordSet at: temp1))
			(if (temp0 underBits:)
				(UnLoad 133 (temp0 underBits:))
			)
		)
		(= local79 -1)
	)

	(method (buyClue &tmp temp0 temp1 [temp2 20])
		(if (super buyClue:)
			(for
				((= temp1 0))
				(!= ((sWordSet at: temp1) correct:) 0)
				((++ temp1))
			)
			(= temp0 (sWordSet at: temp1))
			(localproc_0 (pWord at: [local23 temp1]) @temp2)
			(temp0 placeWord: @temp2 1 [local23 temp1])
		)
	)

	(method (showHelp)
		(proc5_9 377 2) ; "The words which were hidden in the word search puzzle are in a list on the right side of the display. Highlight one of the words, then click on a line with the same number of letter spaces."
		(proc5_9 377 3) ; "When all of the lines are correctly filled, the vertical line will spell a phrase describing the words you used. You can use a hint coin to put in the next word that you are missing or have wrong."
	)

	(method (animateOnce)
		(Animate (gCast elements:) 1)
		(return 1)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 6] temp12 temp13 temp14)
		(= temp0 (event type:))
		(= temp4 (event x:))
		(= temp5 (event y:))
		(= temp1 (event message:))
		(if (and local92 (& temp0 $0040)) ; direction
			(localproc_3 event)
		)
		(if (not local92)
			(= temp3 (self firstTrue: #onMe event))
		)
		(if (& temp0 $0040) ; direction
			(switch temp1
				(JOY_DOWN
					(if (not local92)
						(= local92 1)
						(gGame setCursor: gTheCursor 1 60 30)
						(= temp5 30)
					)
				)
				(JOY_RIGHT
					(if local92
						(gGame setCursor: gTheCursor 1 175 28)
					)
				)
			)
		)
		(if (and local92 (<= temp5 20))
			(= local92 0)
		)
		(if (not (sWordSet firstTrue: #handleEvent event))
			(= temp14 (sWordSet at: local79))
			(if (IsObject temp14)
				(temp14 upDate: 1 0)
				(= local79 -1)
			)
		)
		(if (and (> temp4 (- local0 62)) (> temp5 (- local1 12)) (not local93))
			(= local93 1)
		)
		(if local93
			(while (> (= temp13 ((= temp12 (Event new:)) x:)) local0)
				(if (> (temp12 y:) local1)
					(MapKeyToDir temp12)
					(temp12 localize:)
					(pWord handleEvent: temp12)
					(if (== (temp12 message:) JOY_LEFT)
						(break)
					)
				else
					(break)
				)
				(temp12 dispose:)
			)
			(= local93 0)
			(temp12 dispose:)
			(gGame setCursor: gTheCursor 1 60 30)
		)
		(event claimed: 0)
		(if (not local92)
			(if (super dispatchEvent: event)
				(return 1)
			else
				(return 0)
			)
		else
			(event dispose:)
			(return 0)
		)
	)
)

(instance sWordSet of Set
	(properties)
)

(instance pWord of DSelector
	(properties
		state 1
		font 999
		x 15
		y 8
		text { Backgammon_____Baseball_______Basketball_____Billiards______Blackjack______Bowling________Bridge_________Checkers_______Chess__________Cribbage_______Dominos________Football_______Golf___________Hearts_________Hockey_________Horseshoes_____Jacks__________Jigsaw_________Poker__________Pool___________Puzzle_________Soccer_________Spades_________Tennis_________TicTacToe_____}
	)

	(method (init)
		(super init: &rest)
		(self setSize: enable: draw:)
	)

	(method (handleEvent event)
		(if (& (event type:) $0040) ; direction
			(event type: evKEYBOARD)
			(switch (event message:)
				(JOY_DOWN
					(event message: KEY_DOWN)
				)
				(JOY_UP
					(event message: KEY_UP)
				)
				(else
					(event type: $0040) ; direction
				)
			)
		)
		(super handleEvent: event)
		(if (!= (= local22 (self indexOf: cursor)) local34)
			(localproc_0 (self at: local22) @local2)
			(= local34 local22)
		)
	)
)


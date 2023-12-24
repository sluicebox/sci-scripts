;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Print)
(use Window)
(use Sound)
(use System)

(public
	music 0
)

(local
	[local0 15] = [0 2 4 5 7 9 11 12 14 16 17 19 21 23 24]
	[local15 10] = [1 3 6 8 10 13 15 18 20 22]
	[local25 15] = [3 4 0 3 4 4 0 3 4 0 3 4 4 0 2]
	[local40 10] = [0 1 3 4 5 7 8 10 11 12]
	local50 = {ZSXDCVGBHNJM,2W3ER5T6Y7UI}
	[local51 25] = [0 -1 1 -1 2 3 -1 4 -1 5 -1 6 7 -1 8 -1 9 10 -1 11 -1 12 -1 13 14]
	[local76 15] = [22 21 19 16 14 11 16 13 11 8 6 3 2 1 0]
	[local91 60]
	[local151 60]
	local211
	local212
	local213
	local214
	local215
	local216 = 1
	local217 = -1
	local218 = -1
	local219 = 4
	[local220 47]
	local267
	local268
	local269
	local270
	local271
	local272
	local273
	local274
	[local275 20]
	local295
	local296
	local297
	local298
	local299
	local300
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3)
	(cond
		((< (= temp1 (if (> argc 5) param3 else [local51 param3])) 0)
			(if local216
				(= temp1 [local51 (-- param3)])
				(if (& (<< $0001 temp1) local217)
					(DrawCel
						354
						param4
						4
						param1
						(+ param2 (if (>= temp1 6) -2 else 5) [local76 temp1])
						-1
					)
				)
				(= local271 1)
			else
				(= temp1 [local51 (++ param3)])
				(if (& (<< $0001 temp1) local218)
					(DrawCel
						354
						param4
						5
						param1
						(+ param2 (if (>= temp1 6) -4 else 3) [local76 temp1])
						-1
					)
				)
				(= local271 -1)
			)
		)
		((and (> argc 5) param6)
			(if (& (<< $0001 temp1) (if (> param6 0) local217 else local218))
				(DrawCel
					354
					param4
					(if (> param6 0) 4 else 5)
					param1
					(+
						param2
						(if (>= temp1 6) -2 else 5)
						[local76 temp1]
						(if (> param6 0) 0 else -2)
					)
					-1
				)
			)
			(= local271 param6)
		)
		(else
			(if (& (<< $0001 temp1) (~ (& local217 local218)))
				(DrawCel
					354
					param4
					6
					param1
					(+ param2 (if (>= temp1 6) -2 else 5) [local76 temp1])
					-1
				)
			)
			(= local271 0)
		)
	)
	(= temp0
		(+
			param2
			(switch temp1
				(0 30)
				(12 4)
				(13 5)
				(14 5)
				(else 7)
			)
		)
	)
	(Graph grFILL_BOX temp0 (+ param1 4) (+ temp0 1) (+ param1 13) 1 4)
	(if (== temp1 14)
		(Graph grFILL_BOX (+ param2 2) (+ param1 4) (+ param2 3) (+ param1 13) 1 4)
	)
	(= temp2 6)
	(if (>= temp1 6)
		(+= param4 2)
		(if (== param5 3)
			(= temp2 2)
		)
	)
	(DrawCel 354 param4 param5 (+ param1 temp2) (+ param2 [local76 temp1]) -1)
	(Graph grUPDATE_BOX (- param2 1) param1 (+ param2 44) (+ param1 15) 1)
	(= local270 temp1)
	(StrAt @temp3 0 (+ 65 (mod (+ temp1 2) 7)))
	(StrAt @temp3 1 0)
	(Graph grUPDATE_BOX (- param2 5) param1 (+ param2 44) (+ param1 15) 1)
	(if local273
		(Display @temp3 dsCOORD (+ param1 4) (+ param2 35) dsFONT 999 dsCOLOR 2)
		(if local271
			(DrawCel
				354
				10
				(if (> local271 0) 4 else 5)
				(+ param1 9)
				(+ param2 35 (if (> local271 0) -1 else -2))
				-1
			)
		)
	)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(= temp3 15)
	(if (and (>= argc 3) param3)
		(= temp3 param3)
	)
	(= temp1 (+ param2 44))
	(Graph grFILL_BOX (- param2 5) param1 temp1 (= temp0 (+ param1 temp3)) 1 45)
	(for ((= temp2 0)) (< temp2 5) ((++ temp2))
		(Graph
			grFILL_BOX
			(+ param2 7 (* temp2 5))
			param1
			(+ param2 8 (* temp2 5))
			temp0
			1
			4
		)
		(if (< temp2 4)
			(Graph
				grFILL_BOX
				(+ param2 8 (* temp2 5))
				param1
				(+ param2 9 (* temp2 5))
				temp0
				1
				44
			)
		)
	)
	(if (or (< argc 3) param3)
		(Graph grUPDATE_BOX (- param2 5) param1 temp1 temp0 1)
	)
)

(procedure (localproc_2 param1 param2 param3 &tmp temp0)
	(= local217 -1)
	(= local218 -1)
	(= temp0 0)
	(while (StrAt param3 temp0)
		(localproc_0
			param1
			param2
			(- (StrAt param3 (+ temp0 1)) 99)
			10
			(- (StrAt param3 temp0) 48)
			(- (StrAt param3 (+ temp0 2)) 61)
		)
		(localproc_5 local270 local271)
		(+= temp0 3)
		(+= param1 15)
	)
)

(procedure (localproc_3 param1)
	(return
		(if (and (>= param1 97) (<= param1 122))
			(- param1 32)
		else
			param1
		)
	)
)

(procedure (localproc_4 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(if (not (IsObject param1))
		(return)
	)
	(= temp0 (- (param1 nsTop:) 1))
	(= temp1 (- (param1 nsLeft:) 1))
	(= temp2 (param1 nsBottom:))
	(= temp3 (param1 nsRight:))
	(Graph grDRAW_LINE temp0 temp1 temp0 temp3 param2 -1 -1)
	(Graph grDRAW_LINE temp0 temp3 temp2 temp3 param2 -1 -1)
	(Graph grDRAW_LINE temp2 temp3 temp2 temp1 param2 -1 -1)
	(Graph grDRAW_LINE temp2 temp1 temp0 temp1 param2 -1 -1)
	(Graph grUPDATE_BOX temp0 temp1 (+ temp2 1) (+ temp3 1) 1)
)

(procedure (localproc_5 param1 param2 &tmp temp0 temp1)
	(if argc
		(= temp0 (<< $0001 param1))
		(= temp1 param2)
	else
		(+= local211 3)
		(+= local212 15)
		(place nsLeft: (+ 44 (* 5 local211)) nsRight: (+ 56 (* 5 local211)))
		(= temp0 (<< $0001 local270))
		(= temp1 local271)
	)
	(|= local217 temp0)
	(|= local218 temp0)
	(switch temp1
		(1
			(&= local217 (~ temp0))
		)
		(-1
			(&= local218 (~ temp0))
		)
	)
)

(procedure (localproc_6 param1 param2 &tmp temp0)
	(= local217 -1)
	(= local218 -1)
	(for ((= temp0 1)) (< temp0 param2) ((+= temp0 3))
		(localproc_5
			(- (StrAt param1 temp0) 99)
			(- (StrAt param1 (+ temp0 1)) 61)
		)
	)
)

(procedure (localproc_7)
	(= local217 -1)
	(= local218 -1)
	(localproc_1 44 38 230)
	(place nsLeft: 44 nsRight: 56)
	(= local212 44)
	(= local211 0)
)

(procedure (localproc_8 param1 param2 &tmp temp0)
	(for
		((= temp0 0))
		(or (StrAt param1 temp0) (StrAt param2 temp0))
		((++ temp0))
		
		(if (!= (StrAt param1 temp0) (StrAt param2 temp0))
			(return temp0)
		)
	)
)

(procedure (localproc_9 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp3 0)
	(= temp6 [local295 param1])
	(= temp1 ((music at: (mod temp6 (music size:))) nsTop:))
	(= temp2 temp6)
	(= temp4 32767)
	(while
		(or
			(== ((= temp0 (music at: (mod temp2 (music size:)))) nsTop:) temp1)
			(== (temp0 name:) {replayBut})
		)
		(if (not (& (temp0 signal:) $0004))
			(if
				(<
					(= temp5
						(Abs
							(-
								(param2 x:)
								(/ (+ (temp0 nsLeft:) (temp0 nsRight:)) 2)
							)
						)
					)
					temp4
				)
				(= temp4 temp5)
				(= temp3 temp0)
			else
				(break)
			)
		)
		(++ temp2)
	)
	(if temp3
		(if (== (temp3 name:) {place})
			(if
				(and
					(!= (music script:) partTwo)
					(< (temp3 modifiers:) local211)
				)
				(temp3 value: (- (StrAt @local151 (+ (temp3 modifiers:) 1)) 99))
			)
			(SetCursor
				(/ (+ (temp3 nsLeft:) (temp3 nsRight:)) 2)
				(+ (temp3 nsTop:) (* 3 (- 14 (temp3 value:))))
			)
		else
			(proc5_9 temp3)
		)
	)
	(return temp3)
)

(procedure (localproc_10 param1 &tmp temp0 temp1)
	(Message
		msgGET
		354
		1
		0
		(switch gDifficulty
			(0 1) ; Novice
			(1 2) ; Standard
			(2 3) ; Expert
		)
		(= temp1 (Random 1 35))
		param1
	)
	(for ((= temp0 0)) (< temp0 45) ((+= temp0 3))
		(breakif (not (StrAt param1 temp0)))
		(if (or (< (StrAt param1 temp0) 48) (> (StrAt param1 temp0) 51))
			(Printf {note value out of range in seq %d} temp1)
		)
		(if
			(or
				(< (StrAt param1 (+ temp0 1)) 99)
				(> (StrAt param1 (+ temp0 1)) 113)
				(and
					(== (StrAt param1 (+ temp0 1)) 99)
					(== (StrAt param1 (+ temp0 2)) 60)
				)
				(and
					(== (StrAt param1 (+ temp0 1)) 113)
					(== (StrAt param1 (+ temp0 2)) 62)
				)
			)
			(Printf {note out of range in seq %d} temp1)
		)
		(if
			(or
				(< (StrAt param1 (+ temp0 2)) 60)
				(> (StrAt param1 (+ temp0 2)) 62)
			)
			(Printf {improper accidental in seq %d} temp1)
		)
	)
	(if (StrAt param1 temp0)
		(Printf {seq %d too long} temp1)
	)
)

(instance music of PuzzleBar
	(properties
		state 8
		solvedFlag 25
		noun 2
		msgModule 340
		personalID 11
	)

	(method (init param1 &tmp temp0)
		(= local300 param1)
		(= window musWin)
		(super init:)
		(= local296 size)
		(for ((= temp0 0)) (< temp0 10) ((++ temp0))
			(self
				add:
					((= [local220 (- (StrAt local50 [local15 temp0]) 44)]
							(aKey new:)
						)
						nsTop: 104
						nsBottom: 131
						nsLeft: (+ 75 (* 11 [local40 temp0]))
						nsRight: (+ 84 (* 11 [local40 temp0]))
						value: [local15 temp0]
						yourself:
					)
			)
		)
		(= local295 size)
		(for ((= temp0 0)) (< temp0 15) ((++ temp0))
			(self
				add:
					((= [local220 (- (StrAt local50 [local0 temp0]) 44)]
							(aKey new:)
						)
						nsLeft: (+ 68 (* 11 temp0))
						nsRight: (+ 79 (* 11 temp0))
						cel: [local25 temp0]
						value: [local0 temp0]
						yourself:
					)
			)
		)
		(= [local220 37] [local220 0])
		(self add: replayBut)
		(= local297 size)
		(for ((= temp0 1)) (< temp0 8) ((++ temp0))
			(self
				add:
					((things new:)
						loop: temp0
						nsLeft: (+ -2 (* temp0 28))
						init:
						yourself:
					)
			)
		)
		(self add: playBut fineBut)
		(fineBut signal: (| (fineBut signal:) $0004))
		(replayBut signal: (| (replayBut signal:) $0004))
		(playBut signal: (| (playBut signal:) $0004))
		(self eachElementDo: #perform noEditNotes 8)
		(= local298 size)
		(note init:)
		(self
			setScript:
				(switch (WordAt local300 0)
					(0 partOne)
					(1 partTwo)
					(2 partThree)
				)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1)
		(return
			(if
				(and
					(& (event type:) evKEYBOARD)
					(u<= (= temp0 (- (localproc_3 (event message:)) 44)) 46)
					[local220 temp0]
					(not (& ([local220 temp0] signal:) $0004))
				)
				(self highlight: [local220 temp0] 1)
				([local220 temp0] select:)
				0
			else
				(if (& (event type:) $0040) ; direction
					(switch (event message:)
						(JOY_RIGHT
							(self advance:)
							(if (== (highlightedIcon name:) {place})
								(if
									(and
										(!= (music script:) partTwo)
										(<
											(highlightedIcon modifiers:)
											local211
										)
									)
									(highlightedIcon
										value:
											(-
												(StrAt
													@local151
													(+
														(highlightedIcon
															modifiers:
														)
														1
													)
												)
												99
											)
									)
								)
								(SetCursor
									(/
										(+
											(highlightedIcon nsLeft:)
											(highlightedIcon nsRight:)
										)
										2
									)
									(+
										(highlightedIcon nsTop:)
										(* 3 (- 14 (highlightedIcon value:)))
									)
								)
							)
						)
						(JOY_LEFT
							(self retreat:)
							(if (== (highlightedIcon name:) {place})
								(if
									(and
										(!= (music script:) partTwo)
										(<
											(highlightedIcon modifiers:)
											local211
										)
									)
									(highlightedIcon
										value:
											(-
												(StrAt
													@local151
													(+
														(highlightedIcon
															modifiers:
														)
														1
													)
												)
												99
											)
									)
								)
								(SetCursor
									(/
										(+
											(highlightedIcon nsLeft:)
											(highlightedIcon nsRight:)
										)
										2
									)
									(+
										(highlightedIcon nsTop:)
										(* 3 (- 14 (highlightedIcon value:)))
									)
								)
							)
						)
						(JOY_DOWN
							(if (& (event modifiers:) emSHIFT)
								(gGame
									setCursor:
										gTheCursor
										1
										(event x:)
										(+ (event y:) 3)
								)
							else
								(for
									((= temp1
										(if (IsObject highlightedIcon)
											(switch (highlightedIcon nsTop:)
												(106 4)
												(115 4)
												(104 0)
												(83 1)
												(2
													(if (== size local298)
														2
													else
														3
													)
												)
												(else 2)
											)
										)
									))
									(not (localproc_9 (mod temp1 5) event))
									((-- temp1))
								)
							)
						)
						(JOY_UP
							(if (& (event modifiers:) emSHIFT)
								(gGame
									setCursor:
										gTheCursor
										1
										(event x:)
										(+ (event y:) -3)
								)
							else
								(for
									((= temp1
										(if (IsObject highlightedIcon)
											(switch (highlightedIcon nsTop:)
												(106 1)
												(115 1)
												(104 2)
												(83 3)
												(2 0)
												(else 4)
											)
										)
									))
									(not (localproc_9 (mod temp1 5) event))
									((++ temp1))
								)
							)
						)
					)
					(event type: evNULL)
				)
				(super dispatchEvent: event)
			)
		)
	)

	(method (hide)
		(gGame setCursor: gTheCursor)
		(note dispose:)
		(super hide: &rest)
	)

	(method (showHelp param1)
		(super showHelp: param1 &rest)
		(if (and (not (& state $2000)) param1 shown)
			(Say
				self
				noun
				0
				(switch script
					(partOne 8)
					(partTwo 9)
					(partThree 10)
					(else 13)
				)
			)
		)
	)

	(method (buyClue &tmp temp0 temp1)
		(if (and (super buyClue:) (!= script buildSong))
			(if local273
				(localproc_1 44 38 230)
				(localproc_2 44 38 @local91)
				(music pHandsOff: 1)
				(switch script
					(partOne
						(partOne dispose:)
					)
					(partTwo
						(music highlightedIcon: 0)
						(= local215 0)
						(gGame setCursor: 996)
						(partTwo dispose:)
						(Graph grRESTORE_BOX local269)
						(Graph
							grUPDATE_BOX
							(local213 nsTop:)
							(local213 nsLeft:)
							(local213 nsBottom:)
							(local213 nsRight:)
							1
						)
						(= local272 0)
						(music delete: place)
					)
					(partThree
						(= local272 0)
						(StrCpy @local151 @local91)
						(buildSong dispose:)
					)
				)
			else
				(if (== script partTwo)
					(Graph grRESTORE_BOX local269)
				)
				(StrAt @temp1 1 0)
				(for ((= temp0 2)) (< temp0 17) ((++ temp0))
					(StrAt @temp1 0 (+ 65 (mod temp0 7)))
					(Display @temp1 dsCOORD (+ 49 (* 11 temp0)) 140 dsFONT 999 dsCOLOR 2)
				)
				(= local273 1)
				(if (== script partTwo)
					(= local269
						(Graph
							grSAVE_BOX
							(local213 nsTop:)
							(local213 nsLeft:)
							(local213 nsBottom:)
							(local213 nsRight:)
							1
						)
					)
				)
			)
		)
	)
)

(instance musWin of SysWindow
	(properties
		top 2
		left 8
		bottom 167
		right 311
		back 53
		priority -1
	)

	(method (open &tmp [temp0 2])
		(super open: &rest)
		(DrawCel 354 0 0 0 21 -1)
		(DrawCel 354 0 1 151 21 -1)
		(DrawCel 354 0 2 0 91 -1)
		(DrawCel 354 0 3 151 91 -1)
	)
)

(instance partOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local215 self)
				(= next partTwo)
				(music eachElementDo: #perform kbSwitch 1)
				(localproc_10 @local91)
				(= local212 44)
				(= cycles 1)
			)
			(1
				(Say music 2 0 8 0) ; "|c2|Lesson 1 - Sight Reading:|c| Listen and read each note as it is displayed on the staff then click the corresponding key on the keyboard. If you need help, just use your Hint Watch."
				(localproc_2 44 38 @local91)
				(= local211 0)
				(= local217 -1)
				(= local218 -1)
				(= cycles 1)
			)
			(2
				(= register (- (StrAt @local91 (+ local211 1)) 99))
				(= local216 (- (StrAt @local91 (+ local211 2)) 61))
				(localproc_0
					local212
					38
					register
					11
					(- (StrAt @local91 local211) 48)
					local216
				)
				(= register (+ [local0 register] local216))
				(= cycles 1)
				(= local216 (> local216 0))
			)
			(3
				(music eachElementDo: #perform kbSwitch 0)
			)
			(4
				(if (!= local214 register)
					(localproc_1 local212 38)
					(localproc_0
						local212
						38
						local214
						11
						(- (StrAt @local91 local211) 48)
					)
				)
			)
			(5
				(music eachElementDo: #perform kbSwitch 1)
				(if (== local214 register)
					(localproc_0
						local212
						38
						local214
						10
						(- (StrAt @local91 local211) 48)
					)
					(localproc_5)
					(if (StrAt @local91 (+ local211 1))
						(self changeState: (- state 3))
					else
						(= local215 0)
						(gCSoundFX number: 106 loop: 1 play: self)
					)
				else
					(localproc_1 local212 38)
					(self changeState: (- state 3))
				)
			)
			(6
				(self setScript: playSong self @local91)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance partTwo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Memory memPOKE local300 1)
				(= next partThree)
				(= cycles 1)
			)
			(1
				(Say music 2 0 9 0) ; "|c2|Lesson 2 - Placing Notes:|c| Listen and watch each key on the keyboard as it is played. Place the corresponding note onto the music staff. If you get stuck, just use your Hint Watch."
				(music eachElementDo: #perform kbSwitch 1)
				(localproc_7)
				(localproc_10 @local91)
				(if gDifficulty
					(music eachElementDo: #perform noEditNotes 6 1)
				)
				(replayBut signal: (& (replayBut signal:) $fffb) show:)
				(= cycles 1)
			)
			(2
				(self setScript: playNote self @local91)
			)
			(3
				(= local269
					(Graph
						grSAVE_BOX
						(local213 nsTop:)
						(local213 nsLeft:)
						(local213 nsBottom:)
						(local213 nsRight:)
						1
					)
				)
				(DrawCel
					354
					(local213 loop:)
					(local213 cel:)
					(local213 nsLeft:)
					(local213 nsTop:)
					-1
				)
				(music add: place)
				(place highlight: 0)
				(= local215 self)
				(localproc_4 local267 45)
				(= local219 (- (StrAt @local91 local211) 46))
				(music pHandsOff: 0)
				(= local272 1)
			)
			(4
				(Graph grRESTORE_BOX local269)
				(Graph
					grUPDATE_BOX
					(local213 nsTop:)
					(local213 nsLeft:)
					(local213 nsBottom:)
					(local213 nsRight:)
					1
				)
				(= local272 0)
				(music delete: place)
				(if
					(and
						(== (+ local214 99) (StrAt @local91 (+ local211 1)))
						(==
							(+
								(if local268
									(+ (* -2 (local268 loop:)) 13)
								else
									0
								)
								61
							)
							(StrAt @local91 (+ local211 2))
						)
						(== local219 (- (StrAt @local91 local211) 46))
					)
					(localproc_5)
					(= cycles 2)
					(if (StrAt @local91 local211)
						(-= state 3)
					else
						(music highlightedIcon: 0)
						(= local215 0)
						(gGame setCursor: 996)
						(++ state)
					)
				else
					(gCSoundFX
						number:
							(+
								601
								(* 100 (- local219 2))
								[local0 local214]
								(if local268
									(+ (* -2 (local268 loop:)) 13)
								else
									0
								)
							)
						loop: 1
						play: self
					)
					(localproc_0
						(place nsLeft:)
						38
						local214
						11
						(- local219 2)
						(if local268
							(+ (* -2 (local268 loop:)) 13)
						else
							0
						)
					)
					(music highlightedIcon: 0)
				)
			)
			(5
				(localproc_1 (place nsLeft:) 38)
				(-= state 4)
				(= ticks 20)
			)
			(6
				(gCSoundFX number: 106 loop: 1 play: self)
			)
			(7
				(self setScript: playSong self @local91)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance partThree of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Memory memPOKE local300 2)
				(= next buildSong)
				(= cycles 1)
			)
			(1
				(Say music 2 0 10 0) ; "|c2|Lesson 3 - Memorize The Tune:|c| Listen to the song and observe each note as it is displayed on the music staff. Your goal is to memorize the tune. After the musical staff clears, reconstruct the tune from memory by placing notes on the staff. You may press the |c1|repeat button|c| to hear the song again. If you get stuck, use your Hint Watch."
				(replayBut signal: (& (replayBut signal:) $fffb) show:)
				(localproc_10 @local91)
				(for ((= register 0)) (< register 15) ((++ register))
					(music
						add:
							((place new:)
								nsLeft: (+ 44 (* 15 register))
								nsRight: (+ 56 (* 15 register))
								modifiers: (* 3 register)
								signal: (| (place signal:) $0004)
								yourself:
							)
					)
				)
				(if gDifficulty
					(music eachElementDo: #perform noEditNotes 1 1)
				else
					(StrCpy @local151 @local91)
					(= register (StrLen @local91))
					(for ((= temp0 1)) (< temp0 register) ((+= temp0 3))
						(StrAt @local151 temp0 99)
						(StrAt @local151 (+ temp0 1) 61)
					)
					(= local274 1)
				)
				(= cycles 1)
			)
			(2
				(localproc_7)
				(self setScript: playSong self @local91)
			)
			(3
				(Message msgGET (music msgModule:) 2 0 11 1 @local275)
				(Prints @local275)
				(= local272 1)
				(fineBut signal: (& (fineBut signal:) $fffb) show:)
				(playBut signal: (& (playBut signal:) $fffb) show:)
				(self setScript: buildSong self)
			)
			(4
				(if (StrCmp @local91 @local151)
					(= local274
						(+ 1 (* (/ (localproc_8 @local91 @local151) 3) 3))
					)
					(-= state 3)
					(Say music 2 0 12) ; "Oops! That's not quite it. Listen again."
				else
					(fineBut signal: (| (fineBut signal:) $0004) mask: 0)
					(replayBut signal: (| (playBut signal:) $0004) mask: 0)
					(= local274 0)
					(music eachElementDo: #perform kbSwitch 0 solvePuzzle:)
				)
				(= cycles 1)
			)
			(5
				(Say music 2 0 13) ; "|c2|Free Play:|c| You have mastered all three lessons! Just click on 'EXIT' at anytime when you're through. If you'd like to play Dr. Brain's keyboard some more, you may play anything you wish."
				(music eachElementDo: #perform noEditNotes 1 1)
				(self dispose:)
			)
		)
	)
)

(instance buildSong of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local274
					(= local211 (StrLen @local151))
					(music eachElementDo: #perform placeSwitch 0)
					(localproc_1 44 38 230)
					(localproc_2 44 38 @local151)
					(DrawCel 354 9 3 (+ 42 (* 5 local274)) 70 -1)
				else
					(localproc_7)
					(music eachElementDo: #perform placeSwitch 0)
					(StrAt @local151 0 0)
				)
				(music pHandsOff: 0)
			)
			(1
				(= local272 0)
				(music pHandsOff: 1)
				(StrAt @local151 local211 0)
				(self setScript: playSong self @local151)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance playNote of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 [local0 (- (StrAt register (+ 1 local211)) 99)])
				(= local213
					[local220
						(-
							(StrAt
								local50
								(+ temp0 (- (StrAt register (+ 2 local211)) 61))
							)
							44
						)
					]
				)
				(= local269
					(Graph
						grSAVE_BOX
						(local213 nsTop:)
						(local213 nsLeft:)
						(local213 nsBottom:)
						(local213 nsRight:)
						1
					)
				)
				(DrawCel
					354
					(local213 loop:)
					(local213 cel:)
					(local213 nsLeft:)
					(local213 nsTop:)
					-1
				)
				(note
					number:
						(+
							601
							(* 100 (- (StrAt register local211) 48))
							(local213 value:)
						)
					play: self
				)
			)
			(1
				(Graph grRESTORE_BOX local269)
				(Graph
					grUPDATE_BOX
					(local213 nsTop:)
					(local213 nsLeft:)
					(local213 nsBottom:)
					(local213 nsRight:)
					1
				)
				(self dispose:)
			)
		)
	)
)

(instance playSong of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (not (StrAt register 0))
					(self dispose:)
					(return)
				)
				(music pHandsOff: 1)
				(= local217 -1)
				(= local218 -1)
				(= local211 0)
				(= local212 44)
				(= cycles 1)
			)
			(1
				(localproc_0
					local212
					38
					(- (StrAt register (+ local211 1)) 99)
					11
					(- (StrAt register local211) 48)
					(- (StrAt register (+ local211 2)) 61)
				)
				(self setScript: playNote self register)
			)
			(2
				(localproc_0
					local212
					38
					(- (StrAt register (+ local211 1)) 99)
					10
					(- (StrAt register local211) 48)
					(- (StrAt register (+ local211 2)) 61)
				)
				(localproc_5)
				(if (StrAt register local211)
					(-= state 2)
				)
				(= ticks 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance replaySong of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(music pHandsOff: 1)
				(= register local211)
				(localproc_7)
				(self setScript: playSong self @local91)
			)
			(1
				(Prints {Ready?})
				(localproc_7)
				(= local211 register)
				(localproc_2 44 38 @local151)
				(music pHandsOff: 0)
				(self dispose:)
			)
		)
	)
)

(instance things of CodeIcon
	(properties
		view 354
		nsTop 83
		maskView 354
		maskLoop 9
		maskCel 4
	)

	(method (select)
		(if (super select: &rest)
			(if (< loop 6)
				(localproc_4 local267 45)
				(= local267 self)
				(= local219 loop)
			else
				(localproc_4 local268 45)
				(if (== local268 self)
					(= local268 0)
					(return)
				else
					(= local268 self)
				)
			)
			(localproc_4 self 0)
		)
	)
)

(instance place of CodeIcon
	(properties
		nsTop 30
		nsBottom 78
		signal 161
	)

	(method (onMe param1 &tmp temp0 temp1)
		(= upClick 207)
		(if
			(and
				(= temp1
					(if (super onMe: param1)
						(not (music pHandsOff:))
					)
				)
				(not (& signal $0004))
				(!= local219 1)
				cursor
			)
			(= temp0
				(if local268
					(+ (* -2 (local268 loop:)) 13)
				else
					0
				)
			)
			(= value (- 14 (/ (- (param1 y:) nsTop) 3)))
			(if (< value 0)
				(= value 0)
			)
			(if (> value 14)
				(= value 14)
			)
			(if (and (not value) (< temp0 0))
				(++ value)
			)
			(if (and (== value 14) (> temp0 0))
				(-- value)
			)
			(localproc_1 nsLeft (+ nsTop 8) 0)
			(localproc_0 nsLeft (+ nsTop 8) value 11 (- local219 2) temp0)
			(if (not local215)
				(= upClick (+ 901 [local0 value] temp0))
			)
		)
		(return temp1)
	)

	(method (highlight param1)
		(super highlight: param1 &rest)
		(cond
			((!= local219 1)
				(gGame setCursor: (if param1 996 else 900))
				(if param1
					(if (not local215)
						(localproc_6 @local151 modifiers)
						(if (and (== (music script:) partThree) (not gDifficulty))
							(= local219 (- (StrAt @local151 modifiers) 46))
						)
					)
				else
					(= cursor 1)
					(if (or (== modifiers local211) local215)
						(localproc_1 nsLeft (+ nsTop 8))
						(DrawCel 354 9 3 (+ 3 nsLeft) (+ 40 nsTop) -1)
					else
						(localproc_1 nsLeft (+ nsTop 8) 0)
						(localproc_0
							nsLeft
							(+ nsTop 8)
							(- (StrAt @local151 (+ modifiers 1)) 99)
							10
							(- (StrAt @local151 modifiers) 48)
							(- (StrAt @local151 (+ modifiers 2)) 61)
						)
					)
				)
			)
			((and (!= modifiers local211) (not local215))
				(localproc_6 @local151 modifiers)
				(localproc_0
					nsLeft
					(+ nsTop 8)
					(- (StrAt @local151 (+ modifiers 1)) 99)
					(if param1 11 else 10)
					(- (StrAt @local151 modifiers) 48)
					(- (StrAt @local151 (+ modifiers 2)) 61)
				)
			)
		)
	)

	(method (show))

	(method (select)
		(if (super select: &rest)
			(if (or local215 (!= local219 1))
				(localproc_0
					nsLeft
					(+ nsTop 8)
					value
					10
					(- local219 2)
					(if local268
						(+ (* -2 (local268 loop:)) 13)
					else
						0
					)
				)
			)
			(if local215
				(= local214 value)
				(local215 cue:)
			else
				(if (== local219 1)
					(StrAt @local151 local211 0)
					(if (< modifiers local211)
						(StrCpy (+ @local151 modifiers) (+ @local151 modifiers 3))
						(localproc_1
							(+ (* 5 modifiers) 44)
							38
							(- 230 (* 5 modifiers))
						)
						(localproc_2 44 38 @local151)
						(music
							eachElementDo: #perform placeSwitch (-= local211 3)
						)
					)
				else
					(StrAt @local151 modifiers (+ local219 46))
					(StrAt @local151 (+ modifiers 1) (+ value 99))
					(StrAt
						@local151
						(+ modifiers 2)
						(+
							(if local268
								(+ (* -2 (local268 loop:)) 13)
							else
								0
							)
							61
						)
					)
					(= cursor 0)
					(gGame setCursor: 900)
					(if (== modifiers local211)
						(music
							eachElementDo: #perform placeSwitch (+= local211 3)
						)
						(StrAt @local151 local211 0)
					else
						(localproc_1
							(+ (* 5 modifiers) 44)
							38
							(- 230 (* 5 modifiers))
						)
						(localproc_2 44 38 @local151)
					)
				)
				(localproc_6 @local151 modifiers)
			)
		)
	)
)

(instance replayBut of CodeIcon
	(properties
		view 354
		loop 9
		nsLeft 250
		nsTop 115
		maskView 354
		maskLoop 9
		maskCel 6
		upClick 0
		upClickOff 0
	)

	(method (select &tmp temp0)
		(= downClick (if local272 0 else 145))
		(if (and (super select: &rest) local272)
			(switch (music script:)
				(partTwo
					(Graph grRESTORE_BOX local269)
					(music delete: place)
					(= local272 0)
					(partTwo state: (- (partTwo state:) 2) cue:)
				)
				(partThree
					(buildSong setScript: replaySong)
				)
			)
		)
	)
)

(instance playBut of CodeIcon
	(properties
		view 354
		loop 14
		nsLeft 222
		nsTop 83
		maskView 354
		maskLoop 9
		maskCel 5
	)

	(method (select &tmp temp0)
		(if (and (super select: &rest) (buildSong client:))
			(switch (buildSong script:)
				(0
					(buildSong setScript: playSong backOn @local151)
				)
			)
		)
	)
)

(instance backOn of Script
	(properties)

	(method (cue)
		(music pHandsOff: 0)
	)
)

(instance fineBut of CodeIcon
	(properties
		view 354
		loop 15
		nsLeft 254
		nsTop 83
		maskView 354
		maskLoop 9
		maskCel 5
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(localproc_1 44 38 230)
			(localproc_2 44 38 @local151)
			(buildSong cue:)
		)
	)
)

(instance aKey of CodeIcon
	(properties
		view 354
		loop 8
		cel 1
		nsTop 106
		nsBottom 151
		signal 161
		downClick 0
		upClick 0
		upClickOff 0
	)

	(method (show))

	(method (select &tmp temp0 temp1)
		(if (& signal $0004)
			(return)
		)
		(= local214 value)
		(= temp1 (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1))
		(DrawCel view loop cel nsLeft nsTop -1)
		(if (and local215 (== (music script:) partOne))
			(local215 cue:)
		)
		(note number: (+ 601 value) play:)
		(super select: &rest)
		(if (not argc)
			(Wait 0)
			(Wait 15)
		)
		(Graph grRESTORE_BOX temp1)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(if argc
			(note stop:)
		)
		(if (and local215 (== (music script:) partOne))
			(local215 cue:)
		)
	)
)

(instance note of Sound
	(properties)
)

(instance kbSwitch of Code
	(properties)

	(method (doit param1 param2)
		(if (== (param1 name:) {aKey})
			(param1
				signal:
					(if param2
						(| (param1 signal:) $0004)
					else
						(& (param1 signal:) $fffb)
					)
			)
		)
	)
)

(instance placeSwitch of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(if (== (param1 name:) {place})
			(= temp1
				(if (or (!= (music script:) partThree) gDifficulty)
					local211
				else
					(- local211 3)
				)
			)
			(= temp0 (param1 modifiers:))
			(param1
				signal:
					(if (> temp0 temp1)
						(| (param1 signal:) $0004)
					else
						(& (param1 signal:) $fffb)
					)
			)
			(if (== temp0 local211)
				(param1 highlight: 0)
			)
		)
	)
)

(instance noEditNotes of Code
	(properties)

	(method (doit param1 param2)
		(if (== (param1 name:) {things})
			(param1
				signal:
					(if (< (param1 loop:) param2)
						(| (param1 signal:) $0004)
					else
						(& (param1 signal:) $fffb)
					)
			)
			(if (> argc 2)
				(param1 show:)
			)
		)
	)
)


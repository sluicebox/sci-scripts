;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use LoadMany)
(use Window)

(public
	cipher 0
)

(local
	[local0 76]
	[local76 76]
	[local152 76]
	local228
	local229
	local230
	local231
	[local232 4] = [{0                                 } {1                                 } {2                                 } {3                                 }]
	local236 = {4                                 }
	[local237 4]
	[local241 4]
	[local245 4] = [11 144 120 30]
	[local249 4] = [96 96 113 113]
	local253 = {                                  }
	local254
	local255
	local256
	local257
	local258
	local259
	[local260 3]
	local263
)

(procedure (localproc_0 param1)
	(return
		(or (== param1 39) (<= 65 param1 90) (<= 97 param1 122) (== param1 46))
	)
)

(procedure (localproc_1 param1)
	(return
		(or
			(== param1 39)
			(<= 65 param1 90)
			(<= 97 param1 122)
			(<= 48 param1 57)
			(== param1 46)
		)
	)
)

(procedure (localproc_2 param1 &tmp temp0 temp1) ; UNUSED
	(= temp0 (localproc_0 param1))
	(for ((= temp1 1)) (and (== temp0 0) (< temp1 argc)) ((++ temp1))
		(= temp0 (or temp0 (== param1 [param1 temp1])))
	)
	(return temp0)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp4 (StrLen local230))
	(= temp0 (= temp1 0))
	(= temp5 1)
	(while (and temp5 (< temp0 4))
		(if (> temp4 (+ temp1 30))
			(= temp3 30)
		else
			(= temp3 (- temp4 temp1))
			(= temp5 0)
		)
		(while (and (>= temp3 0) (localproc_0 (StrAt local230 (+ temp1 temp3))))
			(-- temp3)
		)
		(if (not (++ temp3))
			(= temp3 30)
		)
		(= [local237 temp0] temp3)
		(StrCpy [local232 temp0] local253)
		(= temp2 0)
		(while (< temp2 temp3)
			(StrAt [local232 temp0] temp2 (StrAt local230 temp1))
			(++ temp2)
			(++ temp1)
		)
		(++ temp0)
	)
	(= local231 temp0)
	0
	(while (< temp0 4)
		(StrCpy [local232 temp0] local253)
		(= [local237 temp0] 0)
		(++ temp0)
	)
)

(procedure (localproc_4 param1)
	(return (/ (- param1 38) 9))
)

(procedure (localproc_5 param1 param2 param3 &tmp temp0 temp1)
	(letter highlight: 0)
	(letter
		nsLeft: (+ 12 (* param2 7))
		nsRight: (+ 19 (* param2 7))
		nsTop: (+ 38 (* param1 9))
		nsBottom: (+ 46 (* param1 9))
		value: (+ (* param1 30) param2)
		highlight: 1
	)
	(if param3
		(= temp0 (+ 15 (* param2 7)))
		(= temp1 (+ 45 (* param1 9)))
		(gGame setCursor: gTheCursor 1 temp0 temp1)
	)
)

(procedure (localproc_6 param1 param2 param3 &tmp temp0 temp1 temp2 [temp3 2])
	(= temp0 (+ 12 (* param2 7)))
	(= temp1 (+ 38 (* param1 9)))
	(= temp2 (StrAt [local232 param1] param2))
	(localproc_21 (Format @temp3 {%c} temp2) param3 149 temp0 temp1)
	(Graph grUPDATE_BOX temp1 temp0 (+ temp1 9) (+ temp0 7) 1)
)

(procedure (localproc_7 param1 param2 param3)
	(while (localproc_0 (StrAt [local232 param1] param2))
		(localproc_6 param1 param2 param3)
		(++ param2)
	)
)

(procedure (localproc_8 &tmp temp0 temp1 temp2)
	(DrawCel 202 0 0 2 22 -1)
	(DrawCel 202 0 1 114 22 -1)
	(for ((= temp0 0)) (< temp0 local231) ((++ temp0))
		([local241 temp0] show:)
	)
	(= temp1 (+ 12 (* (- 30 (StrLen local236)) 7)))
	(= temp2 74)
	(localproc_21 local236 0 149 temp1 74)
)

(procedure (localproc_9 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 76])
	(= temp6 @temp7)
	(= temp3 (StrLen local230))
	(if (> param1 param2)
		(= temp4 param2)
		(= temp5 param1)
	else
		(= temp4 param1)
		(= temp5 param2)
	)
	(for ((= temp0 0)) (< temp0 temp4) ((++ temp0))
		(StrAt temp6 temp0 (StrAt local230 temp0))
	)
	(= temp1 temp0)
	(for ((= temp2 temp5)) (localproc_0 (StrAt local230 temp2)) ((++ temp2))
		(StrAt temp6 temp1 (StrAt local230 temp2))
		(++ temp1)
	)
	(while (localproc_0 (StrAt local230 temp0))
		(++ temp0)
	)
	(while (< temp0 temp5)
		(StrAt temp6 temp1 (StrAt local230 temp0))
		(++ temp0)
		(++ temp1)
	)
	(for ((= temp2 temp4)) (localproc_0 (StrAt local230 temp2)) ((++ temp2))
		(StrAt temp6 temp1 (StrAt local230 temp2))
		(++ temp1)
	)
	(while (localproc_0 (StrAt local230 temp0))
		(++ temp0)
	)
	(while (< temp0 temp3)
		(StrAt temp6 temp1 (StrAt local230 temp0))
		(++ temp0)
		(++ temp1)
	)
	(StrAt temp6 temp1 0)
	(StrCpy local230 temp6)
)

(procedure (localproc_10 param1 param2 &tmp temp0)
	(= temp0 (StrAt local230 param1))
	(StrAt local230 param1 (StrAt local230 param2))
	(StrAt local230 param2 temp0)
)

(procedure (localproc_11)
	(StrCpy local230 local228)
	(switch gDifficulty
		(0 ; Novice
			(if (< (Random 0 99) 50)
				(localproc_15)
			else
				(localproc_16)
			)
		)
		(1 ; Standard
			(if (< (Random 0 99) 50)
				(localproc_14)
			else
				(localproc_15)
				(localproc_16)
			)
		)
		(2 ; Expert
			(if (< (Random 0 99) 50)
				(localproc_15)
				(localproc_14)
			else
				(localproc_14)
				(localproc_16)
			)
		)
	)
	(StrCpy local229 local230)
)

(procedure (localproc_12 param1 param2)
	(cond
		((!= local255 -1)
			(if (and (== param1 local257) (== param2 local258))
				(return 51)
			)
			(return 0)
		)
		((!= local256 -1)
			(if (== param1 local257)
				(while (localproc_0 (StrAt [local232 param1] param2))
					(-- param2)
				)
				(if (== (++ param2) local258)
					(return 51)
				)
			)
			(return 0)
		)
		(else
			(return 0)
		)
	)
)

(procedure (localproc_13 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp2 0)
	(= temp0 param1)
	(while (localproc_0 (StrAt local230 temp0))
		0
		(++ temp0)
		(++ temp2)
	)
	(for ((= temp3 0)) (< temp3 temp2) ((++ temp3))
		(= temp0 (+ param1 (Random 0 (- temp2 1))))
		(= temp1 (+ param1 (Random 0 (- temp2 1))))
		(if (!= temp0 temp1)
			(localproc_10 temp0 temp1)
		)
	)
)

(procedure (localproc_14 &tmp temp0 temp1 temp2)
	(= temp0 0)
	(= temp1 0)
	(= temp2 (StrLen local230))
	(while (not temp0)
		(while (and (< temp1 temp2) (not (localproc_0 (StrAt local230 temp1))))
			(++ temp1)
		)
		(if (== temp1 temp2)
			(= temp0 1)
		else
			(localproc_13 temp1)
		)
		(while
			(and
				(not temp0)
				(< temp1 temp2)
				(localproc_0 (StrAt local230 temp1))
			)
			(++ temp1)
		)
		(if (== temp1 temp2)
			(= temp0 1)
		)
	)
)

(procedure (localproc_15 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp5 0)
	(= temp0 0)
	(= temp4 0)
	(= temp6 (StrLen local230))
	(while (not temp5)
		(while (and (< temp0 temp6) (not (localproc_0 (StrAt local230 temp0))))
			(++ temp0)
		)
		(if (== temp0 temp6)
			(= temp5 1)
		else
			(++ temp4)
		)
		(while
			(and
				(not temp5)
				(< temp0 temp6)
				(localproc_0 (StrAt local230 temp0))
			)
			(++ temp0)
		)
		(if (== temp0 temp6)
			(= temp5 1)
		)
	)
	(for ((= temp1 0)) (< temp1 temp4) ((++ temp1))
		(= temp2 (Random 0 (- temp4 1)))
		(= temp3 (Random 0 (- temp4 1)))
		(if (!= temp2 temp3)
			(localproc_9 (localproc_19 temp2) (localproc_19 temp3))
		)
	)
)

(procedure (localproc_16 &tmp temp0 temp1)
	(= temp1 0)
	(= temp0 (StrLen local230))
	(while (< temp1 temp0)
		(if (== (StrAt local230 temp1) 32)
			(cond
				((< temp1 2)
					(localproc_17 temp1 (Random 0 2))
					(+= temp1 2)
				)
				((> temp1 (- temp0 2))
					(localproc_17 temp1 (- (Random 0 2)))
				)
				((< (Random 0 99) 50)
					(localproc_17 temp1 (Random 0 2))
					(+= temp1 2)
				)
				(else
					(localproc_17 temp1 (- (Random 0 2)))
				)
			)
		)
		(++ temp1)
	)
)

(procedure (localproc_17 param1 param2 &tmp temp0)
	(cond
		((> param2 0)
			(for ((= temp0 0)) (< temp0 param2) ((++ temp0))
				(StrAt
					local230
					(+ param1 temp0)
					(StrAt local230 (+ param1 temp0 1))
				)
			)
			(StrAt local230 (+ param1 temp0) 32)
		)
		((< param2 0)
			(for ((= temp0 0)) (> temp0 param2) ((-- temp0))
				(StrAt
					local230
					(+ param1 temp0)
					(StrAt local230 (+ param1 temp0 -1))
				)
			)
			(StrAt local230 (+ param1 temp0) 32)
		)
	)
)

(procedure (localproc_18 &tmp temp0 temp1 temp2 [temp3 80] [temp83 80])
	(= temp1 (= temp0 0))
	(= temp2 1)
	(while (and temp2 (!= (= temp0 (localproc_20 local228 temp0 @temp3)) -1))
		(= temp1 (localproc_20 local230 temp1 @temp83))
		(if (StrCmp @temp3 @temp83)
			(= temp2 0)
		)
	)
	(return temp2)
)

(procedure (localproc_19 param1 &tmp temp0 temp1 temp2)
	(= temp1 0)
	(= temp2 (StrLen local230))
	(while (and (< temp1 temp2) (not (localproc_0 (StrAt local230 temp1))))
		(++ temp1)
	)
	(for ((= temp0 0)) (< temp0 param1) ((++ temp0))
		(while (and (< temp1 temp2) (localproc_0 (StrAt local230 temp1)))
			(++ temp1)
		)
		(while (and (< temp1 temp2) (not (localproc_0 (StrAt local230 temp1))))
			(++ temp1)
		)
	)
	(return temp1)
)

(procedure (localproc_20 param1 param2 param3 &tmp temp0 temp1)
	(= temp1 (StrLen param1))
	(= temp0 0)
	(while (and (not (localproc_0 (StrAt param1 param2))) (< param2 temp1))
		(++ param2)
	)
	(if (>= param2 temp1)
		(return -1)
	)
	(while (and (localproc_0 (StrAt param1 param2)) (< param2 temp1))
		(StrAt param3 temp0 (StrAt param1 param2))
		(++ temp0)
		(++ param2)
	)
	(StrAt param3 temp0 0)
	(return param2)
)

(procedure (localproc_21 param1 param2 param3 param4 param5 param6 param7 &tmp [temp0 4] temp4)
	(if (>= argc 7)
		(= temp4 param7)
	else
		(= temp4 gUserFont)
	)
	(Display param1 dsCOORD (+ param4 1) param5 dsCOLOR param3 dsALIGN alLEFT dsFONT temp4 &rest)
	(Display param1 dsCOORD param4 param5 dsCOLOR param2 dsALIGN alLEFT dsFONT temp4 &rest)
)

(instance cipher of PuzzleBar
	(properties
		hintFlag 49
		solvedFlag 16
		noun 17
		msgModule 200
		personalID 22
	)

	(method (init &tmp temp0)
		(= local263 (gGame setCursor: gWaitCursor 1))
		(LoadMany rsSOUND 106 145)
		(LoadMany rsVIEW 206 202)
		(= window ciphWindow)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(= [local260 temp0] 0)
		)
		(self add: letter)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(self
				add:
					((= [local241 temp0] (row new:))
						nsLeft: 12
						nsTop: (+ 38 (* temp0 9))
						nsBottom: (+ 46 (* temp0 9))
						nsRight: 222
						value: temp0
						yourself:
					)
			)
		)
		(self add: resetButton)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(self
				add:
					((buttonIcon new:)
						nsLeft: [local245 temp0]
						nsTop: [local249 temp0]
						value: (+ temp0 1)
						loop: (+ 3 (* temp0 2))
						yourself:
					)
			)
		)
		(self resetPuzzle:)
		(super init: &rest)
	)

	(method (show)
		(gGame setCursor: local263 1)
		(super show: &rest)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(cond
			((& (event type:) $0040) ; direction
				(if (IsObject highlightedIcon)
					(= temp4 (self indexOf: highlightedIcon))
					(switch (event message:)
						(JOY_DOWN
							(cond
								((== ((self highlightedIcon:) name:) {letter})
									(= temp2 (/ (highlightedIcon value:) 30))
									(= temp3 (mod (highlightedIcon value:) 30))
									(if (>= (++ temp2) local231)
										(= temp4 5)
									else
										(= temp4 0)
										(localproc_5 temp2 temp3 1)
									)
								)
								((<= temp4 5)
									(++ temp4)
								)
								((== temp4 6)
									(= temp4 9)
								)
								((== temp4 7)
									(= temp4 8)
								)
								((< temp4 (- size 3))
									(= temp4 (- size 2))
								)
								(else
									(= temp4 0)
									(localproc_5 0 0 1)
								)
							)
						)
						(JOY_UP
							(cond
								((== ((self highlightedIcon:) name:) {letter})
									(= temp2 (/ (highlightedIcon value:) 30))
									(= temp3 (mod (highlightedIcon value:) 30))
									(if (< (-- temp2) 0)
										(= temp4 (- size 2))
									else
										(= temp4 0)
										(localproc_5 temp2 temp3 1)
									)
								)
								((<= temp4 6)
									(-- temp4)
								)
								((== temp4 7)
									(= temp4 5)
								)
								((== temp4 8)
									(= temp4 7)
								)
								((== temp4 9)
									(= temp4 6)
								)
								(else
									(= temp4 8)
								)
							)
						)
						(JOY_RIGHT
							(cond
								((== ((self highlightedIcon:) name:) {letter})
									(= temp2 (/ (highlightedIcon value:) 30))
									(= temp3 (mod (highlightedIcon value:) 30))
									(if (>= (++ temp3) 30)
										(= temp3 0)
										(++ temp2)
									)
									(if (>= temp2 local231)
										(= temp4 5)
									else
										(= temp4 0)
										(localproc_5 temp2 temp3 1)
									)
								)
								((<= temp4 6)
									(= temp4 7)
								)
								((== temp4 7)
									(= temp4 9)
								)
								((== temp4 8)
									(= temp4 (- size 2))
								)
								((== temp4 9)
									(= temp4 8)
								)
								((>= (++ temp4) size)
									(= temp4 (- size 3))
								)
							)
						)
						(JOY_LEFT
							(cond
								((== ((self highlightedIcon:) name:) {letter})
									(= temp2 (/ (highlightedIcon value:) 30))
									(= temp3 (mod (highlightedIcon value:) 30))
									(if (< (-- temp3) 0)
										(= temp3 29)
										(-- temp2)
									)
									(if (< temp2 0)
										(= temp4 (- size 2))
									else
										(= temp4 0)
										(localproc_5 temp2 temp3 1)
									)
								)
								((<= temp4 5)
									(= temp4 6)
								)
								((== temp4 6)
									(= temp4 5)
								)
								((== temp4 7)
									(= temp4 6)
								)
								((== temp4 8)
									(= temp4 9)
								)
								((== temp4 9)
									(= temp4 7)
								)
								((< (-- temp4) (- size 3))
									(= temp4 (- size 1))
								)
							)
						)
					)
				else
					(= temp4 0)
					(localproc_5 0 0 1)
				)
				(if temp4
					(= temp0 (self at: temp4))
					(proc5_9 temp0)
					(self highlight: temp0)
				)
				(event type: evNULL)
			)
			((& (event type:) evKEYBOARD)
				(cond
					((or (== (event message:) KEY_r) (== (event message:) KEY_R))
						(resetButton highlight: 1 select:)
						(Wait 0)
						(Wait 10)
						(resetButton highlight: 0)
					)
					((or (== (event message:) KEY_w) (== (event message:) KEY_W))
						((self at: 6) select:)
					)
					((or (== (event message:) KEY_l) (== (event message:) KEY_L))
						((self at: 7) select:)
					)
					((or (== (event message:) KEY_d) (== (event message:) KEY_D))
						((self at: 9) select:)
					)
					((or (== (event message:) KEY_i) (== (event message:) KEY_I))
						((self at: 8) select:)
					)
					((== (event message:) KEY_INSERT)
						((self at: 8) select:)
					)
					((== (event message:) KEY_DELETE)
						((self at: 9) select:)
					)
				)
			)
		)
		(if (and puzzleStatus (& (event type:) $0105)) ; evJOYDOWN | evMOUSEKEYBOARD
			(event dispose:)
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)

	(method (buyClue &tmp temp0 temp1)
		(if (super buyClue: &rest)
			(= temp0 (Message msgSIZE msgModule noun 4 6 1))
			(= temp1 (Memory memALLOC_CRIT temp0))
			(Message msgGET msgModule noun 4 6 1 temp1)
			(proc15_4 self 99 temp1 local228)
			(if temp1
				(Memory memFREE temp1)
			)
		)
	)

	(method (solvePuzzle)
		(gCSoundFX number: 106 setLoop: 0 play: 127)
		(Wait 0)
		(Wait 60)
		(super solvePuzzle: &rest)
	)

	(method (resetPuzzle &tmp temp0)
		(ClearFlag hintFlag)
		(= local255 -1)
		(= local256 -1)
		(= local259 -1)
		(= local228 @local0)
		(= local230 @local76)
		(= local229 @local152)
		(= local254 0)
		(repeat
			(if
				(not
					(&
						[local260 (/ (= temp0 (Random 0 35)) 16)]
						(<< $0001 (mod temp0 16))
					)
				)
				(|= [local260 (/ temp0 16)] (<< $0001 (mod temp0 16)))
				(break)
			)
		)
		(++ temp0)
		(Message
			msgGET
			205
			1
			(switch gDifficulty
				(0 13) ; Novice
				(1 14) ; Standard
				(2 15) ; Expert
			)
			1
			temp0
			local228
		)
		(Message
			msgGET
			205
			1
			(switch gDifficulty
				(0 13) ; Novice
				(1 14) ; Standard
				(2 15) ; Expert
			)
			2
			temp0
			local236
		)
		(localproc_11)
		(localproc_3)
	)
)

(instance ciphWindow of SysWindow
	(properties
		top 4
		left 36
		bottom 163
		right 266
		back 185
		priority -1
	)

	(method (open)
		(super open:)
		(DrawCel 206 0 0 0 21 -1)
		(DrawCel 206 1 0 0 90 -1)
		(localproc_8)
		(DrawCel 202 1 0 2 88 -1)
		(DrawCel 202 1 1 114 88 -1)
		(DrawCel 202 11 0 94 135 -1)
	)
)

(instance row of CodeIcon
	(properties
		view 202
		loop 12
		cel 0
		signal 385
	)

	(method (show &tmp temp0 temp1)
		(= temp0 (localproc_4 nsTop))
		(for ((= temp1 0)) (< temp1 [local237 temp0]) ((++ temp1))
			(localproc_6 temp0 temp1 (localproc_12 temp0 temp1))
		)
	)

	(method (highlight &tmp temp0 temp1)
		(= temp0 value)
		(if (>= (= temp1 (/ (- (cipher eventX:) 12) 7)) 30)
			(= temp1 29)
		)
		(localproc_5 temp0 temp1 0)
	)
)

(instance letter of CodeIcon
	(properties
		view 202
		loop 12
		cel 0
		nsLeft 12
		nsTop 38
		nsRight 19
		nsBottom 47
	)

	(method (select &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(gCSoundFX number: 145 setLoop: 0 play: 127)
		(= temp0 (/ value 30))
		(= temp1 (mod value 30))
		(if local254
			(if (< temp1 [local237 temp0])
				(= temp2 temp1)
				(for ((= temp3 0)) (< temp3 temp0) ((++ temp3))
					(+= temp2 [local237 temp3])
				)
				(switch (local254 value:)
					(1
						(if (localproc_0 (StrAt local230 temp2))
							(while
								(and
									(>= temp2 0)
									(localproc_0 (StrAt local230 temp2))
								)
								(-- temp2)
								(-- temp1)
							)
							(++ temp2)
							(++ temp1)
							(cond
								((== local256 -1)
									(= local256 temp2)
									(= local257 temp0)
									(= local258 temp1)
									(localproc_7 temp0 temp1 51)
								)
								((!= local256 temp2)
									(localproc_9 local256 temp2)
									(localproc_3)
									(= local256 -1)
									(localproc_8)
								)
							)
						)
					)
					(2
						(if (localproc_0 (StrAt local230 temp2))
							(cond
								((== local255 -1)
									(= local257 temp0)
									(= local258 temp1)
									(= local255 temp2)
									(localproc_6 temp0 temp1 51)
								)
								((!= local255 temp2)
									(localproc_10 local255 temp2)
									(= temp4 (StrAt [local232 temp0] temp1))
									(StrAt
										[local232 temp0]
										temp1
										(StrAt [local232 local257] local258)
									)
									(StrAt [local232 local257] local258 temp4)
									(= local255 -1)
									(localproc_8)
								)
							)
						)
					)
					(3
						(if (localproc_1 (StrAt local230 temp2))
							(if (< (= temp5 (StrLen local230)) 150)
								(for
									((= temp3 temp5))
									(>= temp3 temp2)
									((-- temp3))
									
									(StrAt
										local230
										(+ temp3 1)
										(StrAt local230 temp3)
									)
								)
								(StrAt local230 temp2 32)
								(localproc_3)
								(localproc_8)
							else
								(gMessager say: 17 41 7 1) ; "This phrase is too long to fit on the sign. Try removing some spaces to get it to fit better."
							)
						)
					)
					(4
						(if (== (StrAt local230 temp2) 32)
							(= temp5 (StrLen local230))
							(for ((= temp3 temp2)) (< temp3 temp5) ((++ temp3))
								(StrAt
									local230
									temp3
									(StrAt local230 (+ temp3 1))
								)
							)
							(localproc_3)
							(localproc_8)
						)
					)
				)
			)
			(if (localproc_18)
				(cond
					((< global171 3)
						(if (== (++ global171) 3)
							(cipher solvePuzzle:)
						else
							(Say cipher 1 27 0 global171 0 205)
							(if local254
								(local254 loop: (- (local254 loop:) 1) show:)
							)
							(cipher resetPuzzle:)
							(localproc_8)
						)
					)
					((== global171 3)
						(cipher solvePuzzle:)
					)
				)
			)
		else
			(gMessager say: 17 41 8 1) ; "Sorry, but you need to select an |c2|Operation|c| first."
		)
	)

	(method (highlight param1 &tmp temp0 temp1 [temp2 4] temp6 temp7)
		(= temp0 (/ value 30))
		(= temp1 (mod value 30))
		(cipher highlightedIcon: self)
		(if (and local254 (== (local254 value:) 1))
			(if (< temp1 [local237 temp0])
				(= temp6 temp1)
				(for ((= temp7 0)) (< temp7 temp0) ((++ temp7))
					(+= temp6 [local237 temp7])
				)
				(if (localproc_0 (StrAt local230 temp6))
					(while
						(and (>= temp6 0) (localproc_0 (StrAt local230 temp6)))
						(-- temp6)
						(-- temp1)
					)
					(++ temp6)
					(++ temp1)
					(localproc_7
						temp0
						temp1
						(if param1
							30
						else
							(localproc_12 temp0 temp1)
						)
					)
					(= local259 temp6)
				)
			)
		else
			(localproc_6
				temp0
				temp1
				(if param1
					30
				else
					(localproc_12 temp0 temp1)
				)
			)
		)
	)
)

(instance resetButton of CodeIcon
	(properties
		view 202
		loop 2
		nsLeft 88
		nsTop 92
	)

	(method (select)
		(if (super select: &rest)
			(= local255 -1)
			(= local256 -1)
			(StrCpy local230 local229)
			(localproc_3)
			(localproc_8)
		)
	)
)

(instance buttonIcon of CodeIcon
	(properties
		view 202
	)

	(method (select)
		(if (super select: &rest)
			(cond
				((!= local255 -1)
					(localproc_6 local257 local258 0)
					(= local255 -1)
				)
				((!= local256 -1)
					(localproc_7 local257 local258 0)
					(= local256 -1)
				)
			)
			(if local254
				(if (== self local254)
					(= local254 0)
					(-- loop)
					(self show:)
				else
					(local254 loop: (- (local254 loop:) 1) show:)
					(= local254 self)
					(++ loop)
					(self show:)
				)
			else
				(= local254 self)
				(++ loop)
				(self show:)
			)
		)
	)
)


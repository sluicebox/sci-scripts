;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 195)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Print)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	jigsaw 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	[local18 8]
	[local26 8]
	[local34 3] = [13 16 15]
	[local37 6] = [27 73 109 3 7 11]
	local43
	local44
	[local45 4] = [160 350 160 -30]
	[local49 4] = [-30 95 220 95]
	[local53 14] = [28 27 21 117 114 115 116 79 90 91 102 104 103 92]
	[local67 3] = [0 7 3]
	[local70 3] = [2 13 13]
	local73
	[local74 8] = [8191 384 -32744 6145 384 -32744 -2047 255]
	[local82 40] = [0 16 42 67 94 124 149 172 207 230 258 282 0 293 0 293 0 284 0 284 0 285 0 290 0 283 0 288 0 17 46 69 99 123 151 178 202 230 248 285]
	[local122 40] = [0 0 0 0 0 0 0 0 0 0 0 0 12 7 30 26 50 54 65 69 85 77 114 106 124 127 147 146 162 164 168 167 167 165 162 170 166 168 166 165]
	[local162 3] = [2 6 6]
	[local165 3] = [3 7 7]
	[local168 3] = [3 7 7]
	[local171 3] = [2 5 5]
	[local174 3] = [3 7 7]
	[local177 3] = [4 9 9]
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(for ((= temp1 0)) (< temp1 12) ((++ temp1))
		(DrawCel local3 0 temp1 [local82 temp1] 0 -1)
	)
	(= temp0 12)
	(= temp1 12)
	(while (< temp0 28)
		(= temp2 (mod temp1 (* local6 5)))
		(DrawCel
			(+ local3 (/ temp1 60))
			(/ temp2 12)
			(mod temp2 12)
			[local82 temp0]
			[local122 temp0]
			-1
		)
		(++ temp0)
		(if (mod temp1 2)
			(++ temp1)
		else
			(+= temp1 11)
		)
	)
	(= temp0 28)
	(= temp1 0)
	(while (< temp1 12)
		(DrawCel (+ local3 1) 4 temp1 [local82 temp0] [local122 temp0] -1)
		(++ temp1)
		(++ temp0)
	)
)

(procedure (localproc_1 &tmp [temp0 5] temp5)
	(if (> (Abs local17) (Abs gGameTime))
		(= temp5 (- gGameTime local17))
	else
		(= temp5 (- (Abs gGameTime) (Abs local17)))
	)
	(if (>= temp5 60)
		(if (> (++ local16) 59)
			(if (> (++ local15) 59)
				(if (> (++ local14) 99)
					(-- local14)
				)
				(= local15 0)
			)
			(= local16 0)
		)
		(= local17 gGameTime)
		(localproc_2 local14 local15 local16 @temp0)
		(DrawCel 180 5 0 170 135 -1)
		(Display @temp0 dsCOORD 172 137 dsCOLOR 32 dsFONT gUserFont)
		(= global117 gGameTime)
	else
		(= global116 gGameTime)
	)
)

(procedure (localproc_2 param1 param2 param3 param4)
	(Format
		param4
		{%d%d:%d%d:%d%d}
		(/ param1 10)
		(mod param1 10)
		(/ param2 10)
		(mod param2 10)
		(/ param3 10)
		(mod param3 10)
	)
)

(procedure (localproc_3 param1 param2 &tmp temp0 temp1)
	(= temp0 (+ (* param2 local9) (/ local9 2) local11))
	(= temp1 (- (+ (* param1 local10) (/ local10 2) local12) 1))
	(gGame setCursor: gTheCursor 1 temp0 temp1)
)

(procedure (localproc_4)
	(gGame setCursor: gTheCursor 1 207 162)
)

(instance jigsaw of PuzzleBar
	(properties
		hintFlag 53
		solvedFlag 52
		noun 23
		personalID 16
	)

	(method (init &tmp temp0)
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(= [local18 temp0] 0)
			(= [local26 temp0] 0)
		)
		(= local4 (= local5 (= local14 (= local15 (= local16 0)))))
		(= local44 0)
		(= local13 -1)
		(= local43 1)
		(if (== gDifficulty 1) ; Standard
			(for ((= temp0 0)) (< temp0 8) ((++ temp0))
				(= [local18 temp0] [local74 temp0])
				(= [local26 temp0] [local74 temp0])
			)
		)
		(if gDifficulty
			(= local0 183)
			(= local6 12)
			(= local7 10)
			(= local9 26)
			(= local10 19)
			(= local3 184)
			(|= [local18 4] $8000)
			(|= [local18 5] $1c00)
			(|= [local18 6] $01c0)
			(|= [local18 7] $003c)
			(|= [local26 4] $8000)
			(|= [local26 5] $1c00)
			(|= [local26 6] $01c0)
			(|= [local26 7] $003c)
			(= local2 120)
			(= local11 0)
			(= local12 1)
			(theChest nsTop: 106 nsLeft: 151)
			(LoadMany rsVIEW local0 local3 (+ local3 1))
		else
			(= local0 180)
			(= local6 6)
			(= local7 5)
			(= local9 53)
			(= local10 38)
			(= local3 181)
			(= [local18 1] 6176)
			(= local2 30)
			(= local11 1)
			(= local12 0)
			(theChest nsTop: 113 nsLeft: 133)
			(LoadMany rsVIEW local0 local3)
		)
		(= local8 [local37 gDifficulty])
		(= local1 8)
		(= showCast 1)
		(= puzzleCast
			((Set new:)
				add: (moveProp view: local3 setPri: 16 hide: yourself:)
				yourself:
			)
		)
		(if (not local43)
			(self add: theExitButton theChest)
			(= local44 1)
		)
		(self add: theBackground)
		(if (not inited)
			(= inited 1)
			(= puzzleStatus 0)
			(= msgModule gCurRoomNum)
		)
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4)
		(LoadMany rsSOUND 125 144 145 241 242 246)
		(= puzzleStatus 0)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(|= state $0020)
		(DrawPic 195 9 1)
		(Animate (puzzleCast elements:) 0)
		(= temp0 30)
		(= temp1 30)
		(for ((= temp2 (FirstNode elements))) temp2 ((= temp2 temp3))
			(= temp3 (NextNode temp2))
			(if (not (IsObject (= temp4 (NodeValue temp2))))
				(return)
			)
			(if (and (not (& (temp4 signal:) $0080)) (<= (temp4 nsRight:) 0))
				(temp4 show: temp0 temp1)
				(= temp0 (+ 20 (temp4 nsRight:)))
			else
				(temp4 show:)
			)
		)
		(if (== gDifficulty 1) ; Standard
			(localproc_0)
		)
		(if (pieceSet size:)
			(pieceSet eachElementDo: #show)
		)
		(if (!= local13 -1)
			(moveProp show:)
			(gGame setCursor: 996)
		)
		(if local43
			(self setScript: buildChest)
		)
		(= local17 (+ gTickOffset (GetTime)))
		(self doit: hide:)
		(ScriptID 15 7)
		(return puzzleStatus)
	)

	(method (animateOnce)
		(if local44
			(localproc_1)
		)
		(Palette palANIMATE 221 228 -9)
		(super animateOnce: &rest)
	)

	(method (dispatchEvent event &tmp temp0 temp1 [temp2 2] temp4 temp5)
		(cond
			((& (event type:) $0040) ; direction
				(cond
					((== highlightedIcon theBackground)
						(= temp1 (/ eventX local9))
						(= temp0 (/ eventY local10))
						(= temp4 0)
						(= temp5 99)
					)
					(highlightedIcon
						(= temp5 (self indexOf: highlightedIcon))
					)
					(else
						(= temp5 0)
					)
				)
				(switch (event message:)
					(JOY_UP
						(cond
							((< temp5 1)
								(localproc_4)
							)
							((< temp5 2)
								(localproc_3
									[local162 gDifficulty]
									[local165 gDifficulty]
								)
							)
							(temp0
								(localproc_3 (-- temp0) temp1)
							)
							((< [local171 gDifficulty] temp1 [local177 gDifficulty])
								(localproc_4)
							)
							(else
								(localproc_3 (- local7 1) temp1)
							)
						)
					)
					(JOY_DOWN
						(cond
							((< temp5 1)
								(localproc_3 0 (/ local6 2))
							)
							((< temp5 2)
								(proc5_9 (self at: 0))
							)
							((< temp0 [local162 gDifficulty])
								(localproc_3 (++ temp0) temp1)
							)
							((== temp0 (- local7 1))
								(localproc_3 0 temp1)
							)
							((and (not gDifficulty) (== temp0 3) (== temp1 4))
								(localproc_3 (++ temp0) temp1)
							)
							((< [local171 gDifficulty] temp1 [local177 gDifficulty])
								(localproc_4)
							)
							(else
								(localproc_3 (++ temp0) temp1)
							)
						)
					)
					(JOY_RIGHT
						(cond
							((< temp5 2)
								(localproc_3
									[local174 gDifficulty]
									[local177 gDifficulty]
								)
							)
							(
								(and
									(== temp1 [local171 gDifficulty])
									(> temp0 [local162 gDifficulty])
								)
								(localproc_4)
							)
							(else
								(if (>= (++ temp1) local6)
									(= temp1 0)
								)
								(localproc_3 temp0 temp1)
							)
						)
					)
					(JOY_LEFT
						(cond
							((< temp5 2)
								(localproc_3
									[local168 gDifficulty]
									[local171 gDifficulty]
								)
							)
							(
								(and
									(not gDifficulty)
									(or
										(and (== temp0 3) (== temp1 4))
										(and (== temp0 4) (== temp1 5))
									)
								)
								(localproc_4)
							)
							(
								(and
									gDifficulty
									(> temp0 [local162 gDifficulty])
									(== temp1 [local177 gDifficulty])
								)
								(localproc_4)
							)
							(else
								(if (< (-- temp1) 0)
									(= temp1 (- local6 1))
								)
								(localproc_3 temp0 temp1)
							)
						)
					)
				)
				(event type: evNULL)
			)
			(
				(or
					(and (& (event type:) evMOUSEBUTTON) (& (event modifiers:) emSHIFT))
					(and
						(& (event type:) evKEYBOARD)
						(or
							(== (event message:) KEY_p)
							(== (event message:) KEY_P)
							(and
								(== (event message:) KEY_RETURN)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				((Print new:) addIcon: 180 4 0 0 0 init:)
			)
		)
		(if (and puzzleStatus (& (event type:) $0105)) ; evJOYDOWN | evMOUSEKEYBOARD
			(event dispose:)
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)

	(method (dispose)
		(pieceSet
			eachElementDo: #dispose
			eachElementDo: #delete
			release:
			dispose:
		)
		(super dispose: &rest)
	)

	(method (solvePuzzle &tmp temp0 [temp1 5] [temp6 5] [temp11 70])
		(= temp0 (* gDifficulty 3))
		(if
			(or
				(< local14 [global175 temp0])
				(< local15 [global175 (+ temp0 1)])
				(and
					(== local15 [global175 (+ temp0 1)])
					(< local16 [global175 (+ temp0 2)])
				)
			)
			(localproc_2 local14 local15 local16 @temp1)
			(localproc_2
				[global175 temp0]
				[global175 (+ temp0 1)]
				[global175 (+ temp0 2)]
				@temp6
			)
			(Message msgGET msgModule noun [local34 gDifficulty] 16 1 @temp11)
			(proc15_4 self 99 @temp11 @temp6 @temp1)
			(= [global175 temp0] local14)
			(= [global175 (+ temp0 1)] local15)
			(= [global175 (+ temp0 2)] local16)
			(super solvePuzzle: &rest)
		)
		(= puzzleStatus 1)
		(gCurRoom picture: 180)
		(= local44 0)
	)
)

(instance theChest of CodeIcon
	(properties
		view 183
		loop 1
		cel 1
		nsLeft 151
		nsTop 106
	)

	(method (onMe param1 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		)
		(return
			(if (!= local13 -1)
				2
				(& $0006 (OnControl CONTROL temp0 temp1))
			else
				(& $0004 (OnControl CONTROL temp0 temp1))
			)
		)
	)

	(method (show)
		(if (== 0 local16 local15 local14)
			(= local17 (+ gTickOffset (GetTime)))
		)
		(super show: &rest)
		(localproc_1)
	)

	(method (select &tmp temp0 temp1)
		(cond
			((!= local13 -1)
				(gCSoundFX number: 244 setLoop: 1 play:)
				(= [local18 (/ local13 16)]
					(& [local18 (/ local13 16)] (~ (<< $0001 (mod local13 16))))
				)
				(= local13 -1)
				(moveProp hide:)
				(gGame setCursor: 900)
				(-- local4)
			)
			((>= local4 local8) 0)
			(else
				(= temp0 (- local2 1))
				(while
					(&
						[local18 (/ (= local13 (Random 0 temp0)) 16)]
						(<< $0001 (mod local13 16))
					)
				)
				(= [local18 (/ local13 16)]
					(| [local18 (/ local13 16)] (<< $0001 (mod local13 16)))
				)
				(= temp1 (mod local13 (* local6 5)))
				(gCSoundFX number: 145 setLoop: 1 play:)
				(moveProp
					view: (+ local3 (/ local13 60))
					loop: (/ temp1 local6)
					cel: (mod temp1 local6)
					x: (jigsaw eventX:)
					y: (jigsaw eventY:)
					show:
				)
				(gGame setCursor: 996)
				(++ local4)
			)
		)
	)

	(method (highlight))
)

(instance theBackground of CodeIcon
	(properties
		nsTop 0
		nsRight 320
		nsBottom 190
	)

	(method (select &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(cond
			((!= local13 -1)
				(= temp1 (/ (moveProp x:) local9))
				(= temp4
					(+ (* (= temp0 (/ (moveProp y:) local10)) local6) temp1)
				)
				(= temp8 0)
				(if (== temp4 local13)
					(= temp2 (+ (* temp1 local9) (/ local9 2) local11))
					(= temp3 (- (+ (* temp0 local10) (/ local10 2) local12) 1))
					(if
						(and
							(< (- temp2 local1) (moveProp x:) (+ temp2 local1))
							(< (- temp3 local1) (moveProp y:) (+ temp3 local1))
						)
						(moveProp x: temp2 y: temp3)
						(SetNowSeen moveProp (moveProp nsTop:))
						(++ local5)
						(= [local26 (/ temp4 16)]
							(| [local26 (/ temp4 16)] (<< $0001 (mod temp4 16)))
						)
						(= temp8 1)
						(gCSoundFX number: 242 setLoop: 1 play:)
					else
						(gCSoundFX number: 144 setLoop: 1 play:)
					)
				else
					(gCSoundFX number: 144 setLoop: 1 play:)
				)
				(= temp9
					((puzPiece new:)
						nsLeft: (moveProp nsLeft:)
						nsTop: (moveProp nsTop:)
						nsBottom: (moveProp nsBottom:)
						nsRight: (moveProp nsRight:)
						x: (moveProp x:)
						y: (moveProp y:)
						value: local13
						show:
						yourself:
					)
				)
				(if temp8
					(pieceSet addToFront: temp9)
				else
					(pieceSet add: temp9)
				)
				(moveProp hide:)
				(gGame setCursor: 900)
				(= local13 -1)
				(if (>= local5 local8)
					(jigsaw solvePuzzle:)
				)
			)
			(
				(= temp6
					(pieceSet
						firstTrue: #onMe (jigsaw eventX:) (jigsaw eventY:)
					)
				)
				(= temp7 (mod (temp6 value:) (* local6 5)))
				(moveProp
					view: (+ local3 (/ (temp6 value:) 60))
					loop: (/ temp7 local6)
					cel: (mod temp7 local6)
					x: (temp6 x:)
					y: (temp6 y:)
					show:
				)
				(gGame setCursor: 996 1 (temp6 x:) (temp6 y:))
				(= local13 (temp6 value:))
				(if
					(&
						[local26 (/ (temp6 value:) 16)]
						(<< $0001 (mod (temp6 value:) 16))
					)
					(= [local26 (/ (temp6 value:) 16)]
						(&
							[local26 (/ (temp6 value:) 16)]
							(~ (<< $0001 (mod (temp6 value:) 16)))
						)
					)
					(-- local5)
				)
				(pieceSet delete: temp6)
				(temp6 dispose:)
				(PicNotValid 1)
				(Graph grFILL_BOX 0 0 190 320 1 5 -1 -1)
				(theChest show:)
				(if (== gDifficulty 1) ; Standard
					(localproc_0)
				)
				(if (pieceSet size:)
					(pieceSet eachElementDo: #show)
				)
				(PicNotValid 0)
				(gCSoundFX number: 246 setLoop: 1 play:)
				(Graph grUPDATE_BOX 0 0 190 320 1)
			)
		)
	)

	(method (highlight))

	(method (show))
)

(instance pieceSet of Set
	(properties)
)

(class puzPiece of Obj
	(properties
		x 0
		y 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		signal 0
		value 0
	)

	(method (onMe param1 param2)
		(return
			(and
				(< nsLeft param1 nsRight)
				(< nsTop param2 nsBottom)
				(or
					(not (HaveMouse))
					(not
						(IsItSkip
							(+ local3 (/ value 60))
							(/ value local6)
							(mod value local6)
							(- param2 nsTop)
							(- param1 nsLeft)
						)
					)
				)
			)
		)
	)

	(method (show &tmp temp0)
		(= temp0 (mod value (* local6 5)))
		(DrawCel
			(+ local3 (/ value 60))
			(/ temp0 local6)
			(mod temp0 local6)
			nsLeft
			nsTop
			-1
		)
	)
)

(instance theExitButton of CodeIcon
	(properties
		view 180
		loop 6
		nsLeft 202
		nsTop 180
	)

	(method (select)
		(if (super select: &rest)
			(jigsaw goAway:)
		)
	)

	(method (onMe)
		(if (!= local13 -1)
			(return 0)
		else
			(return (super onMe: &rest))
		)
	)
)

(instance moveProp of Actor
	(properties)

	(method (doit)
		(= x (jigsaw eventX:))
		(= y (jigsaw eventY:))
		(super doit: &rest)
	)
)

(instance buildChest of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 5] [temp11 50])
		(switch (= state newState)
			(0
				(= register [local67 gDifficulty])
				(= ticks 3)
				((jigsaw puzzleCast:)
					add:
						((= local73 (Actor new:))
							view: (if gDifficulty 183 else 180)
							loop: 0
							x: 500
							moveSpeed: 1
							signal: 26627
							setPri: 15
							illegalBits: 0
							cel: (if (== gDifficulty 1) 3 else -1) ; Standard
							yourself:
						)
				)
				(jigsaw pHandsOff: 1)
			)
			(1
				(= temp2 (Random 0 3))
				(= temp4 (mod [local53 register] local6))
				(= temp3 (/ [local53 register] local6))
				(= temp0 (+ (* temp4 local9) (/ local9 2) local11))
				(= temp1 (- (+ (* temp3 local10) (/ local10 2) local12) 1))
				(local73
					cel: (+ (local73 cel:) 1)
					x: [local45 temp2]
					y: [local49 temp2]
				)
				(local73 setMotion: MoveTo temp0 temp1 self)
			)
			(2
				(gCSoundFX number: 242 setLoop: 1 play:)
				(DrawCel
					(local73 view:)
					(local73 loop:)
					(local73 cel:)
					(local73 nsLeft:)
					(local73 nsTop:)
					-1
				)
				(if (<= (++ register) [local70 gDifficulty])
					(-= state 2)
					(= ticks 1)
				else
					(= ticks 1)
				)
			)
			(3
				(jigsaw
					addToFront: theChest
					addToFront: theExitButton
					pHandsOff: 0
				)
				((jigsaw puzzleCast:) delete: local73)
				(local73 dispose: delete:)
				(if (== gDifficulty 1) ; Standard
					(localproc_0)
				)
				(gCSoundFX number: 125 setLoop: 1 play:)
				(theChest view: local0 show:)
				(theExitButton show:)
				(= temp5 (* gDifficulty 3))
				(if (not (jigsaw shown:))
					(Say jigsaw 23 9 0 0 0 180) ; "This is the animated jigsaw puzzle. You'll find all the pieces to it in the chest. If you wish to quit this puzzle before solving it, just click on the Exit button (on the front of the chest). To see what the jigsaw puzzle looks like, just click anywhere on the gray screen."
					(jigsaw shown: 1)
				)
				(if (< [global175 temp5] 99)
					(localproc_2
						[global175 temp5]
						[global175 (+ temp5 1)]
						[global175 (+ temp5 2)]
						@temp6
					)
					(Message msgGET 180 23 [local34 gDifficulty] 15 1 @temp11)
					(proc15_4 jigsaw 99 @temp11 @temp6)
				)
				(= local17 (+ gTickOffset (GetTime)))
				(= local43 0)
				(= local44 1)
				(self dispose:)
			)
		)
	)
)


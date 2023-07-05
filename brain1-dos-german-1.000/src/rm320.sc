;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Interface)
(use Feature)
(use LoadMany)
(use Window)
(use Sound)
(use Game)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	[local0 8] = [12 155 161 163 104 162 70 155]
	[local8 8] = [128 16 72 45 128 103 130 125]
	[local16 7] = [111 58 93 59 111 146 148]
	[local23 7] = [62 80 94 136 123 138 94]
	[local30 8] = [0 6 4 5 2 3 1 7]
	[local38 7] = [0 4 6 5 1 3 2]
	[local45 7]
	local52 = -1
	local53
	local54
	[local55 14]
	[local69 7]
	[local76 8]
	local84
)

(procedure (localproc_0 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 7) ((++ temp0))
		(= temp1 [local45 temp0])
		(if
			(not
				(and
					(== (temp1 cel:) 0)
					(== [local16 [local38 temp0]] (temp1 x:))
					(== [local23 [local38 temp0]] (temp1 y:))
				)
			)
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_1 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (< temp0 7) ((++ temp0))
		(if (!= local52 ([local45 temp0] value:))
			([local45 temp0] setPri: 15)
		)
	)
	(Animate (gCast elements:) 0)
	(for ((= temp0 0)) (< temp0 7) ((++ temp0))
		(if (!= local52 ([local45 temp0] value:))
			([local45 temp0] stopUpd:)
		)
	)
)

(procedure (localproc_2 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (< temp0 7) ((++ temp0))
		([local45 temp0] startUpd:)
		(Animate (gCast elements:) 0)
		(Animate (gCast elements:) 0)
	)
)

(procedure (localproc_3 param1) ; UNUSED
	(if (and (& (param1 type:) $0004) (== (param1 message:) 13))
		(param1 type: 1 message: 0)
	)
)

(procedure (localproc_4 &tmp temp0)
	(= temp0 4)
	(proc5_16 8 28 150 142 4)
	(proc5_16 45 112 150 28 temp0)
	(proc5_16 9 83 81 142 temp0)
	(proc5_16 45 58 45 112 temp0)
	(proc5_16 81 142 114 114 temp0)
)

(procedure (localproc_5)
	(if (localproc_0)
		(doorSound play:)
		(backDoor cel: 1)
		(Animate (gCast elements:) 0)
		(Wait 0)
		(Wait 60)
		(rewardSound play:)
		(proc5_9 320 15)
		(tan solvePuzzle: goAway:)
		(Animate (gCast elements:) 0)
		(gCurRoom newRoom: 360)
	)
)

(instance rm320 of Rm
	(properties
		lookStr {This is the third floor hallway, the language hall.}
		picture 320
		style 7
		south 200
	)

	(method (init)
		(Load rsSCRIPT 377)
		(LoadMany rsSOUND 51 58 265 912 968)
		(super init: &rest)
		(gCMusic number: 320 setLoop: -1 flags: 1 play:)
		(SetFlag 49)
		(leftDoor init: stopUpd:)
		(leftFeat init:)
		(backFeat init:)
		(backDoor init: stopUpd:)
		(drBrainBust init:)
		(tree init:)
	)

	(method (dispose)
		(if (IsObject tan)
			(tan dispose:)
		)
		(if (IsObject (ScriptID 377 1)) ; theWord
			((ScriptID 377 1) dispose:) ; theWord
		)
		(if (IsObject (ScriptID 325 0)) ; word
			((ScriptID 325 0) dispose:) ; word
		)
		(gCMusic fade: 0 15 12 1)
		(super dispose: &rest)
	)
)

(class TanPiece of Prop
	(properties
		onMeCheck 4096
		value 0
	)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(super doit: &rest)
		(if (== value local52)
			(if argc
				(param1 localize:)
				(gPMouse handleEvent: param1)
				(gTheDoits doit:)
				(param1 dispose:)
			else
				(= temp0 (Event new: -1))
				(= temp1 (temp0 x:))
				(= temp2 (temp0 y:))
				(temp0 localize:)
				(gTheDoits doit:)
				(temp0 dispose:)
				(self posn: temp1 temp2)
			)
		)
	)

	(method (rotate &tmp temp0)
		(if (== cel (- (NumCels self) 1))
			(= temp0 0)
		else
			(= temp0 (+ cel 1))
		)
		(= cel temp0)
		(turnPieceSound play:)
		(Animate (gCast elements:) 0)
		(= [local69 value] cel)
		(localproc_5)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (== (event type:) evMOUSEBUTTON) (== local52 -1) (self onMe: event))
				(switch gTheCursor
					(8
						(event claimed: 1)
						(= local52 value)
						(self setPri: 15)
					)
					(27
						(self rotate:)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance doorSound of Sound
	(properties
		flags 1
		number 912
	)
)

(instance rewardSound of Sound
	(properties
		flags 1
		number 51
	)
)

(instance placePieceSound of Sound
	(properties
		flags 1
		number 58
	)
)

(instance turnPieceSound of Sound
	(properties
		flags 1
		number 265
	)
)

(instance tan of PuzzleBar
	(properties
		puzzleHeight 169
		bottomHeight 0
		hintFlag 44
		solvedFlag 9
	)

	(method (init)
		(= window puzWindow)
		(super init: &rest)
		(self show:)
	)

	(method (dispose &tmp temp0)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(if (IsObject [local45 temp0])
				([local45 temp0] dispose:)
				(= [local45 temp0] 0)
			)
		)
		(Animate (gCast elements:) 0)
		(super dispose: &rest)
	)

	(method (goAway &tmp temp0)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(if (IsObject [local45 temp0])
				([local45 temp0] hide:)
			)
		)
		(Animate (gCast elements:) 0)
		(super goAway: &rest)
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (gEgo has: 9)
			(if (not shown)
				(for ((= temp0 0)) (< temp0 8) ((++ temp0))
					((= temp1 (pieceIcon new:))
						value:
							(cond
								((== temp0 4) 6)
								((== temp0 6) 4)
								(else temp0)
							)
						loop: (+ [local30 temp0] 1)
						nsLeft: (- [local0 [local30 temp0]] 32)
						nsTop: (- [local8 [local30 temp0]] 9)
						nsLeft: [local0 [local30 temp0]]
						nsTop: (+ 20 [local8 [local30 temp0]])
						cel: 0
					)
					(if (< temp0 7)
						((= [local45 temp0] (TanPiece new:))
							value: temp0
							view: 375
							loop: [local38 temp0]
							x:
								(if [local55 (* 2 temp0)]
									[local55 (* 2 temp0)]
								else
									-100
								)
							y:
								(if [local55 (+ 1 (* 2 temp0))]
									[local55 (+ 1 (* 2 temp0))]
								else
									-100
								)
							setPri: 15
							init:
							signal: 4096
						)
						([local45 temp0]
							cel:
								(if [local55 (* 2 temp0)]
									[local69 temp0]
								else
									(Random 0 (- (NumCels [local45 temp0]) 1))
								)
						)
						(if (= [local76 temp0] (!= ([local45 temp0] x:) -100))
							(temp1 cel: 3)
						else
							(temp1 cel: 0)
						)
					)
					(self add: temp1)
				)
				(= temp3 (self at: 0))
				(= temp4 (self at: 1))
				(= temp5 (self at: 2))
				(= temp6 (self at: 3))
				(self
					delete: temp3
					addToEnd: temp3
					delete: temp4
					addToEnd: temp4
					delete: temp5
					addToEnd: temp5
					delete: temp6
					addToEnd: temp6
				)
				(= shown 1)
			else
				(for ((= temp0 0)) (< temp0 7) ((++ temp0))
					([local45 temp0] show:)
				)
			)
		else
			(SetFlag 48)
		)
		(super show: &rest)
		(if (not (IsFlag 48))
			(if (== gTheCursor 27)
				(gGame setCursor: 8)
			)
			(= local52 -1)
		)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(if (IsObject [local45 temp0])
				([local45 temp0] hide:)
			)
		)
		(backDoor show:)
		(leftDoor show:)
		(Animate (gCast elements:) 0)
	)

	(method (buyClue)
		(if (super buyClue: &rest)
			(proc5_9 320 0)
			(proc5_9 320 1)
			(proc5_9 320 2)
		)
	)

	(method (showHelp)
		(proc5_9 320 3)
		(proc5_9 320 4)
		(proc5_9 320 5)
	)

	(method (animateOnce)
		(Animate (gCast elements:) 1)
		(return 1)
	)

	(method (dispatchEvent event &tmp temp0 [temp1 2] temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12)
		(= temp0 (event type:))
		(= temp4 (event x:))
		(= temp5 (event y:))
		(= temp3 (self firstTrue: #onMe event))
		(if (IsFlag 48)
			(proc5_9 320 6)
			(self goAway:)
		)
		(event globalize:)
		(= gLastEvent event)
		(gCast handleEvent: event)
		(if (and (& temp0 $0040) (!= local52 -1)) ; direction
			([local45 local52] doit: event)
			(return 0)
		)
		(if (& (event type:) evKEYBOARD)
			(= temp0 evMOUSEBUTTON)
		)
		(event localize:)
		(if (and (not (event claimed:)) (== temp0 evMOUSEBUTTON) (!= local52 -1))
			(= temp11 [local45 local52])
			(= temp7 ([local45 local52] x:))
			(= temp8 ([local45 local52] y:))
			(= temp9 [local16 [local38 local52]])
			(= temp10 [local23 [local38 local52]])
			(if (not (and (<= 8 temp4 150) (<= 29 temp5 142)))
				([local45 local52] posn: -100 -100)
				(if (or (== (= temp12 local52) 4) (== temp12 6))
					(= temp12 (- 10 temp12))
				)
				((tan at: temp12) cel: 0 show:)
				(= [local76 local52] 0)
				(gCast delete: [local45 local52] addToEnd: [local45 local52])
				(Animate (gCast elements:) 0)
			else
				(placePieceSound play:)
				(if (<= (= temp6 (GetDistance temp7 temp8 temp9 temp10)) 8)
					([local45 local52] posn: temp9 temp10)
					(localproc_5)
				)
				(= [local55 (* 2 (temp11 value:))] (temp11 x:))
				(= [local55 (+ 1 (* 2 (temp11 value:)))] (temp11 y:))
				([local45 local52] setPri: 1)
				(gCast
					delete: [local45 local52]
					addToFront: [local45 local52]
				)
			)
			(= local52 -1)
		)
		(event claimed: 0)
		(if (super dispatchEvent: event)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance puzWindow of SysWindow
	(properties
		top 9
		left 32
		bottom 189
		right 227
		back 43
		priority -1
	)

	(method (open)
		(super open:)
		(DrawCel 376 0 0 0 20 -1)
		(if (== global114 0)
			(localproc_4)
		)
		(backDoor hide:)
		(leftDoor hide:)
		(Animate (gCast elements:) 0)
		(if (not local54)
			(= local54 1)
			(tan showHelp:)
		)
	)
)

(instance pieceIcon of CodeIcon
	(properties
		view 376
		cursor 999
		helpStr {This icon lets you select a piece of the puzzle.}
		highlightColor 0
		lowlightColor 255
	)

	(method (select &tmp temp0)
		(if (and (== local52 -1) (super select: &rest))
			(cond
				((!= value 7)
					(if (== gTheCursor 27)
						(if (>= ([local45 value] x:) 0)
							(= [local76 value] 1)
							([local45 value] rotate:)
						)
					else
						(= [local76 value] 1)
						(= cel 3)
						(self show:)
						(= temp0 [local45 (= local52 value)])
						(temp0 setPri: 15)
						(Animate (gCast elements:) 0)
						(= [local55 (* 2 (temp0 value:))] 0)
						(= [local55 (+ 1 (* 2 (temp0 value:)))] 0)
						(if (!= (temp0 x:) -100)
							(gGame
								setCursor:
									gTheCursor
									1
									([local45 local52] x:)
									([local45 local52] y:)
							)
						)
					)
				)
				(local84
					(gGame setCursor: 8)
					(= local84 0)
				)
				(else
					(gGame setCursor: 27)
					(= local84 1)
				)
			)
		)
	)

	(method (highlight param1)
		(if (== local52 -1)
			(= cel
				(cond
					((== param1 1) 2)
					([local76 value] 3)
					(else 0)
				)
			)
			(self show:)
		)
	)
)

(instance leftDoor of Prop
	(properties
		x 94
		y 124
		description {left-hand door}
		sightAngle 180
		view 320
		loop 1
		cel 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance leftFeat of Feature
	(properties
		description {left-hand door}
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 320 7) ; "A sign on the door reads "Word Games"."
			)
			(3
				(cond
					((and (IsFlag 10) (IsFlag 15))
						(proc5_9 320 8)
					)
					((IsFlag 10)
						(if (leftDoor cel:)
							(doorSound play:)
						)
						(leftDoor cel: 0)
						(Animate (gCast elements:) 0)
						((ScriptID 377 1) init:) ; theWord
					)
					((IsFlag 49)
						(if (leftDoor cel:)
							(doorSound play:)
						)
						(leftDoor cel: 0 forceUpd:)
						(Animate (gCast elements:) 0)
						(ClearFlag 49)
						((ScriptID 325 0) init:) ; word
					)
					(else
						(if (leftDoor cel:)
							(doorSound play:)
						)
						(leftDoor cel: 0)
						(Animate (gCast elements:) 0)
						((ScriptID 325 0) init:) ; word
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance backDoor of Prop
	(properties
		x 175
		y 86
		view 320
		loop 2
	)

	(method (onMe)
		(return 0)
	)
)

(instance backFeat of Feature
	(properties
		description {back door}
		onMeCheck 8
	)

	(method (doVerb theVerb invItem)
		(cond
			((== theVerb 2)
				(Print 320 9) ; "The sign over this door reads "Puzzle Room". The door has a curious square-shaped lock mechanism."
			)
			((or (== theVerb 3) (and (== theVerb 4) (== invItem 9)))
				(gGame setCursor: 8)
				(cond
					((IsFlag 9)
						(doorSound play:)
						(backDoor cel: 1)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: 360)
					)
					((gEgo has: 9)
						(Animate (gCast elements:) 0)
						(tan init:)
					)
					(else
						(proc5_9 320 10)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tree of Feature
	(properties
		nsTop 20
		nsLeft 114
		nsBottom 123
		nsRight 163
		description {rubber tree}
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 320 11) ; "It's a rubber tree. These can be very useful should you fall off a high cliff. They are much less useful inside a castle."
			)
			(3
				(gCMusic2 number: 968 flags: 1 setLoop: 1 setVol: 127 play:)
				(proc5_9 320 12)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drBrainBust of Feature
	(properties
		nsTop 83
		nsLeft 256
		nsBottom 154
		nsRight 279
		description {bust}
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 320 13) ; "This is a bust of Dr. Brain on a classic Ionic column, as used by the ancient Greeks. (You had no idea he was so old! Or so vain.)"
			)
			(3
				(proc5_9 320 14)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 428)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Interface)
(use listArray)
(use Window)
(use Sound)
(use Actor)
(use System)

(public
	solar 0
	proc428_1 1
)

(local
	[local0 18] = [10 4 81 4 152 4 10 19 81 19 152 19 10 34 81 34 152 34]
	[local18 45] = [103 105 104 101 107 109 106 108 102 119 77 92 88 65 58 107 70 103 41 120 106 132 54 202 61 44 74 119 59 91 72 64 40 106 52 102 24 119 88 132 38 202 44 44 56]
	[local63 9] = [2 4 3 0 7 8 5 6 1]
	[local72 9] = [3 11 3 3 4 3 10 4 3]
	[local81 9] = [50 79 62 30 180 220 99 138 38]
	[local90 9] = [10 15 13 6 30 36 19 24 8]
	[local99 9] = [3 6 4 1 17 22 8 13 2]
	local108 = -1
	local109 = -1
	local110
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 9) ((++ temp0))
		(if (== ((planetSet at: temp0) located:) 0)
			(return 0)
		)
	)
	(return 1)
)

(procedure (proc428_1)
	(if (IsObject solar)
		(solar dispose:)
	)
	(if (IsObject planetSet)
		(planetSet dispose:)
	)
	(if (IsObject foundSound)
		(foundSound dispose:)
	)
	(if (IsObject rewardSound)
		(rewardSound dispose:)
	)
)

(instance solar of PuzzleBar
	(properties
		puzzleHeight 169
		bottomHeight 0
		solvedFlag 35
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(gCMusic number: 420 setLoop: -1 flags: 1 play:)
		(= window solWindow)
		(if (== (planetSet size:) 0)
			(= temp4 1)
		else
			(= temp4 0)
		)
		((ScriptID 420 4) stopUpd:) ; Globespinning
		((ScriptID 420 6) stopUpd:) ; monolith
		(for ((= temp0 0)) (< temp0 9) ((++ temp0))
			(if temp4
				(= temp1 (planetIcon new:))
				(temp1
					nsLeft: (+ [local0 (* 2 temp0)] 1)
					nsTop: (+ [local0 (+ (* 2 temp0) 1)] 124)
					value: temp0
					loop: (+ 2 temp0)
					cel: 0
				)
				(self add: temp1)
				(= temp2 (planet new:))
				(temp2 view: 428 init:)
				(planetSet add: temp2)
			else
				(= temp2 (planetSet at: temp0))
				(if (temp2 selected:)
					(temp2 view: 427)
				else
					(temp2 view: 428)
				)
				(temp2 show:)
			)
			(if (< (= temp5 [local99 temp0]) 10)
				(switch global114
					(0
						(*= temp5 4)
					)
					(1
						(*= temp5 2)
					)
				)
			)
			(temp2
				ignoreActors: 1
				radius: [local72 temp0]
				setPri: 15
				setLoop: [local63 temp0]
				setCel: 0
				value: temp0
				x: (+ 124 [local81 temp0])
				y: 79
				cursor: [local18 temp0]
				moveSpeed: temp5
				xStep: 3
				yStep: 2
				setMotion: DoEllipse [local81 temp0] [local90 temp0] 124 79 36
			)
		)
		(super init: &rest)
		(self show:)
	)

	(method (show &tmp temp0)
		(= highlightedIcon (self at: 0))
		(super show: &rest)
		(gGame setCursor: 8)
		((ScriptID 420 4) startUpd:) ; Globespinning
		(for ((= temp0 0)) (< temp0 9) ((++ temp0))
			((planetSet at: temp0) hide: setMotion: 0)
		)
		(Animate (gCast elements:) 0)
	)

	(method (buyClue &tmp temp0 temp1 temp2 temp3 temp4)
		(if (super buyClue:)
			(if (!= local108 -1)
				((planetSet at: local108) locate:)
				(return)
			)
			(= temp3 100)
			(for ((= temp0 0)) (< temp0 9) ((++ temp0))
				(= temp4 (planetSet at: temp0))
				(if
					(and
						(not (temp4 selected:))
						(< (= temp1 (temp4 loop:)) temp3)
					)
					(= temp3 temp1)
					(= temp2 temp0)
				)
			)
			((planetSet at: temp2) locate:)
		)
	)

	(method (showHelp)
		(proc5_9 428 0) ; "This is an opportunity for you to show your knowledge of the solar system. Choose the name of a planet, then click the cross-hair cursor on the correct planet. You may have picked up a clue to the correct order somewhere else in the castle."
		(proc5_9 428 1) ; "If you can't catch one of the planets, click on its name, then put a hint coin in the slot. (Or spend a hint coin without choosing a name, and we'll help you with the innermost planet you haven't yet named.)"
	)

	(method (animateOnce)
		(Animate (gCast elements:) 1)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2] temp7 temp8 temp9)
		(= temp0 (event type:))
		(= temp2 (event x:))
		(= temp3 (event y:))
		(= temp1 (event message:))
		(= gLastEvent event)
		(= temp4 (self firstTrue: #onMe event))
		(if local110
			(if (or (< temp3 20) (< temp2 0) (> temp2 227) (> temp3 119))
				(= local110 0)
			else
				(= gGameTime (+ gTickOffset (GetTime)))
				(self animateOnce:)
				(gTheDoits doit:)
				(gPMouse handleEvent: event)
			)
		)
		(if
			(and
				(& temp0 $0040) ; direction
				(not local110)
				(IsObject highlightedIcon)
				(or
					(highlightedIcon isKindOf: CodeIcon)
					(highlightedIcon isKindOf: PuzzleIcon)
				)
			)
			(if (highlightedIcon isKindOf: CodeIcon)
				(= temp9 (highlightedIcon value:))
			else
				(= temp9 -1)
			)
			(switch temp1
				(JOY_DOWN
					(cond
						((== temp9 -1)
							(if (not local110)
								(= local110 1)
								(gGame setCursor: gTheCursor 1 124 79)
							)
						)
						((<= temp9 5)
							(for ((= temp8 0)) (< temp8 3) ((++ temp8))
								(self advance:)
							)
						)
					)
				)
				(JOY_UP
					(cond
						((>= temp9 3)
							(for ((= temp8 0)) (< temp8 3) ((++ temp8))
								(self retreat:)
							)
						)
						((not local110)
							(= local110 1)
							(gGame setCursor: gTheCursor 1 124 79)
						)
					)
				)
			)
		)
		(= temp7 (GetPort))
		(SetPort 0)
		(event localize:)
		(planetSet firstTrue: #handleEvent event)
		(SetPort temp7)
		(event localize:)
		(event claimed: 0)
		(if (not local110)
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

(instance solWindow of SysWindow
	(properties
		top 8
		left 45
		bottom 186
		right 272
		back 43
	)

	(method (open)
		(super open:)
		(DrawCel 426 0 0 1 20 -1)
		(DrawCel 426 0 1 1 124 -1)
	)
)

(instance planetIcon of CodeIcon
	(properties
		view 426
		cursor 999
		helpStr {This icon selects a planet cursor.}
		highlightColor 0
		lowlightColor 5
	)

	(method (select &tmp temp0)
		(if (and (not ((planetSet at: value) selected:)) (super select: &rest))
			(if (>= local109 0)
				((solar at: local109) cel: 0 show:)
			)
			(self cel: 1 show:)
			(= local109 value)
			(= local108 value)
			(gGame setCursor: 202)
		)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (not ((planetSet at: value) selected:))
			(= temp5 (if argc param1))
			(if (not (& signal $0020))
				(return)
			)
			(= temp0 (if temp5 highlightColor else lowlightColor))
			(= temp1 (+ nsTop 1))
			(= temp2 (+ nsLeft 2))
			(= temp3 (- nsBottom 2))
			(= temp4 (- nsRight 2))
			(Graph grDRAW_LINE temp1 temp2 temp1 temp4 temp0 -1 -1)
			(Graph grDRAW_LINE temp1 temp4 temp3 temp4 temp0 -1 -1)
			(Graph grDRAW_LINE temp3 temp4 temp3 temp2 temp0 -1 -1)
			(Graph grDRAW_LINE temp3 temp2 temp1 temp2 temp0 -1 -1)
			(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		)
	)
)

(instance foundSound of Sound
	(properties
		flags 1
		number 950
	)
)

(instance rewardSound of Sound
	(properties
		flags 1
		number 52
	)
)

(class planet of Actor
	(properties
		illegalBits 0
		value 0
		cursor 0
		selected 0
		located 0
		radius 0
	)

	(method (locate)
		(= selected 1)
		(= view 427)
		(foundSound play:)
		(Print 428 2) ; "You have found a planet."
		(= located 1)
		((solar at: value) cel: 2 show:)
		(= local108 -1)
		(= local109 -1)
		(if (localproc_0)
			(proc5_15 planetsDone)
			(solar solvePuzzle: goAway:)
			(gCurRoom setScript: (ScriptID 420 7)) ; outWhite
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 (event type:))
		(= temp1 (event message:))
		(if (and (& temp0 evKEYBOARD) (== temp1 KEY_RETURN))
			(= temp0 evMOUSEBUTTON)
		)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (== temp0 evMOUSEBUTTON) (self onMe: event))
				(if (== value local108)
					(self locate:)
				)
				(event claimed: 1)
				(return 1)
			)
		)
	)

	(method (doit &tmp temp0)
		(if mover
			(= cel
				(cond
					((<= (= temp0 (- (mover curAngle:) (mover step:))) 60) 5)
					((<= temp0 120) 4)
					((<= temp0 180) 3)
					((<= temp0 240) 2)
					((<= temp0 300) 1)
					((<= temp0 360) 0)
				)
			)
		)
		(cond
			((not (solar isActive:)) 0)
			((or (< (- x radius) 57) (> (+ x radius) 260))
				(if (not (& signal $0080))
					(self hide:)
				)
			)
			((& signal $0080)
				(self show:)
			)
		)
		(super doit: &rest)
	)
)

(instance planetSet of Set
	(properties)
)

(instance planetsDone of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 180)
			)
			(1
				(rewardSound play:)
				(proc5_11 428 3) ; "Now that you have found all the planets, and saved the Solar System from almost-certain destruction, maybe you'll finally be able to remember where you parked your bike."
				(= ticks 300)
			)
			(2
				(= client 0)
				(self dispose:)
			)
		)
	)
)


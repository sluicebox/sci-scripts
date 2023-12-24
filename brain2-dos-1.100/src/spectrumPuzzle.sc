;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 244)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use IconBar)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	spectrumPuzzle 0
)

(local
	local0
	local1
	local2
	[local3 4] = [101 129 155 181]
	[local7 2] = [73 97]
	[local9 8] = [{000} {001} {002} {003} {004} {005} {006} {007}]
	[local17 6]
	[local23 8]
	[local31 8]
	[local39 18] = [0 22 44 48 52 55 59 65 73 80 80 84 88 93 100 105 109 112]
	[local57 64]
	local121
	local122
	local123
	local124
	local125
	local126
	local127
	local128
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(switch param1
		(1
			(for ((= temp0 0)) (< temp0 local121) ((++ temp0))
				(= temp1 0)
				(repeat
					(if
						(==
							[local57 (= temp6 (+ (* [local17 temp0] 8) temp1))]
							0
						)
						(break)
					)
					(if (> (= temp3 (/ (* (- [local57 temp6] 380) 2) 7)) 112)
						(= temp3 112)
					)
					(= temp2 0)
					(= temp5 0)
					(while (not temp5)
						(if
							(and
								(>= (- 112 temp3) [local39 temp2])
								(<= (- 112 temp3) [local39 (+ temp2 1)])
							)
							(= temp4 (+ 219 temp2))
							(= temp5 1)
						)
						(++ temp2)
					)
					(Graph grDRAW_LINE 45 (- 207 temp3) 50 (- 207 temp3) temp4 -1 -1)
					(++ temp1)
				)
			)
			(Graph grUPDATE_BOX 45 95 51 208 1)
		)
		(0
			(for ((= temp0 0)) (< temp0 local122) ((++ temp0))
				(= temp1 0)
				(repeat
					(if
						(==
							[local57 (= temp6 (+ (* [local23 temp0] 8) temp1))]
							0
						)
						(break)
					)
					(if (> (= temp3 (/ (* (- [local57 temp6] 380) 2) 7)) 112)
						(= temp3 112)
					)
					(= temp2 0)
					(= temp5 0)
					(while (not temp5)
						(if
							(and
								(>= (- 112 temp3) [local39 temp2])
								(<= (- 112 temp3) [local39 (+ temp2 1)])
							)
							(= temp4 (+ 219 temp2))
							(= temp5 1)
						)
						(++ temp2)
					)
					(Graph grDRAW_LINE 56 (- 207 temp3) 61 (- 207 temp3) temp4 -1 -1)
					(++ temp1)
				)
			)
			(Graph grUPDATE_BOX 56 95 62 208 1)
		)
		(2
			(= temp1 0)
			(repeat
				(if
					(==
						[local57 (= temp6 (+ (* [local17 local127] 8) temp1))]
						0
					)
					(break)
				)
				(if (> (= temp3 (/ (* (- [local57 temp6] 380) 2) 7)) 112)
					(= temp3 112)
				)
				(= temp2 0)
				(= temp5 0)
				(while (not temp5)
					(if
						(and
							(>= (- 112 temp3) [local39 temp2])
							(<= (- 112 temp3) [local39 (+ temp2 1)])
						)
						(= temp4 (+ 219 temp2))
						(= temp5 1)
					)
					(++ temp2)
				)
				(Graph grDRAW_LINE 56 (- 207 temp3) 61 (- 207 temp3) temp4 -1 -1)
				(++ temp1)
			)
			(Graph grUPDATE_BOX 56 95 62 208 1)
		)
	)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
	(if (and argc (IsObject param1))
		(= temp0 (/ (+ (param1 nsLeft:) (param1 nsRight:)) 2))
		(= temp1 (+ (param1 nsTop:) 3))
		(gGame setCursor: gTheCursor 1 temp0 temp1)
	else
		(= temp0 46)
		(= temp1 89)
		(gGame setCursor: gTheCursor 1 temp0 89)
	)
)

(class Flame of Prop
	(properties
		signal 18
		flameState 0
	)

	(method (cue)
		(= cel 0)
		(self flameState: (& (self flameState:) $fffe))
		(self flameState: (| (self flameState:) $0002))
	)
)

(instance spectrumPuzzle of PuzzleBar
	(properties
		hintFlag 50
		solvedFlag 3
		noun 15
		msgModule 240
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 4] temp11 [temp12 10])
		(LoadMany rsVIEW 244 246 247)
		(LoadMany rsSOUND 104 106 144 152 154 207 236)
		(= local1 gDifficulty)
		(= local0 iconHeight)
		(= window spectrumWindow)
		(= local122 0)
		(= local123 246)
		(= local127 0)
		(= local128 0)
		(click owner: element init:)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(= [local17 temp0] -1)
		)
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(= [local31 temp0] 0)
			(= [local23 temp0] -1)
		)
		(for ((= temp0 0)) (< temp0 64) ((++ temp0))
			(= [local57 temp0] 0)
		)
		(switch local1
			(0
				(= local121 3)
			)
			(1
				(= local121 5)
			)
			(2
				(= local121 6)
			)
		)
		(= temp0 1)
		(repeat
			(if (== (= temp11 (Message msgGET 244 1 1 temp0 1 @temp12)) 0)
				(break)
			)
			(++ temp0)
		)
		(= local126 (- temp0 1))
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(= [local31 temp0] (Random 0 (- local126 1)))
			(= temp1 0)
			(while (< temp1 temp0)
				(if (== [local31 temp1] [local31 temp0])
					(= temp1 0)
					(= [local31 temp0] (Random 0 (- local126 1)))
				else
					(++ temp1)
				)
			)
		)
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(Message msgGET 244 1 1 (+ [local31 temp0] 1) 1 [local9 temp0])
			(for
				((= temp1 0))
				(= temp11
					(Message msgGET 244 1 1 (+ [local31 temp0] 1) (+ temp1 2) @temp7)
				)
				((++ temp1))
				
				(= [local57 (+ (* temp0 8) temp1)] (ReadNumber @temp7))
			)
		)
		(for ((= temp0 0)) (< temp0 local121) ((++ temp0))
			(= [local17 temp0] (Random 0 7))
			(= temp1 0)
			(while (< temp1 temp0)
				(if (== [local17 temp1] [local17 temp0])
					(= temp1 0)
					(= [local17 temp0] (Random 0 7))
				else
					(++ temp1)
				)
			)
		)
		(for ((= temp0 0)) (< temp0 local121) ((++ temp0))
			(for ((= temp1 (+ temp0 1))) (< temp1 local121) ((++ temp1))
				(if (< [local17 temp1] [local17 temp0])
					(= temp11 [local17 temp0])
					(= [local17 temp0] [local17 temp1])
					(= [local17 temp1] temp11)
				)
			)
		)
		(= temp5 4)
		(= temp4 2)
		(for ((= temp2 0)) (< temp2 temp4) ((++ temp2))
			(for ((= temp3 0)) (< temp3 temp5) ((++ temp3))
				(self
					add:
						((= temp6 (element new:))
							view: 244
							loop: 1
							cel: 2
							nsLeft: [local3 temp3]
							nsTop: [local7 temp2]
							value: (+ (* temp2 temp5) temp3)
							text: [local9 (+ (* temp2 temp5) temp3)]
							yourself:
						)
				)
				(bowlCast add: temp6)
			)
		)
		(selectedBowls add:)
		(self add: fakeburnerIcon)
		(super init: &rest)
	)

	(method (show)
		(= eventY (= eventX 0))
		(flameCast
			add:
				(burnLoop view: 244 flameState: 0)
				(burner view: 244 flameState: 0 nsLeft: 92 nsTop: 93)
		)
		(super show: &rest)
		(flameCast release:)
		(return puzzleStatus)
	)

	(method (hide)
		(Animate (gCast elements:) 0)
		(gGame setCursor: local2 1)
		(super hide: &rest)
	)

	(method (animateOnce)
		(if (& local124 $0010)
			(if (== (burner flameState:) 0)
				(gCSoundFX number: 152 setLoop: 0 play: 127)
				(burnLoop
					show:
					setCycle: End burnLoop
					flameState: (| (burnLoop flameState:) $0001)
				)
				(burner
					setCycle: End burner
					flameState: (| (burner flameState:) $0001)
				)
				(Graph grFILL_BOX 56 95 62 208 1 7 -1 -1)
				(Graph grUPDATE_BOX 56 95 62 208 1)
			)
		else
			(if (& (burner flameState:) $0002)
				(burner flameState: 0)
			)
			(if (and (& local124 $0020) (& (burnLoop flameState:) $0001))
				(burnLoop hide:)
				(Animate (flameCast elements:) 1)
				(burnLoop flameState: 0)
			)
		)
		(if (or (& (burner flameState:) $0001) (& (burnLoop flameState:) $0001))
			(Animate (flameCast elements:) 1)
			(if gDoMotionCue
				(= gDoMotionCue 0)
				(flameCast eachElementDo: #motionCue)
			)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 [temp3 2])
		(if (not local2)
			(= local2 gTheCursor)
		)
		(cond
			((and (<= 0 eventX 219) (<= local0 eventY 126))
				(if (not (& local124 $0001))
					(|= local124 $0003)
				)
			)
			((& local124 $0001)
				(= local124 (& (|= local124 $0002) $fffe))
			)
		)
		(if (& local124 $0002)
			(if (& local124 $0004)
				(gGame setCursor: local2)
				(&= local124 $fff9)
			else
				(gGame setCursor: local123)
				(= local124 (| (&= local124 $fffd) $0004))
			)
		)
		(if (and (& local124 $0008) (& local124 $0001))
			(gGame setCursor: local123)
			(= local124 (| (&= local124 $fff7) $0004))
		)
		(cond
			((and (<= 22 eventX 70) (<= 75 eventY 97))
				(if (not (& local124 $0010))
					(|= local124 $0030)
				)
			)
			((& local124 $0010)
				(= local124 (& (|= local124 $0020) $ffef))
			)
		)
		(cond
			((& (event type:) $0040) ; direction
				(if (or (IsObject highlightedIcon) (& local124 $0010))
					(if (& local124 $0010)
						(= temp1 8)
					else
						(= temp1 (self indexOf: highlightedIcon))
					)
					(= temp2 4)
					(switch (event message:)
						(JOY_DOWN
							(cond
								((<= temp1 (- temp2 1))
									(+= temp1 temp2)
								)
								((<= temp1 7)
									(= temp1 (- size 2))
								)
								((== temp1 8)
									(= temp1 (- size 2))
								)
								(else
									(= temp1 0)
								)
							)
						)
						(JOY_UP
							(cond
								((<= temp1 (- temp2 1))
									(= temp1 (- size 2))
								)
								((<= temp1 7)
									(-= temp1 temp2)
								)
								((== temp1 8)
									(= temp1 (- size 2))
								)
								(else
									(= temp1 temp2)
								)
							)
						)
						(JOY_RIGHT
							(cond
								((< temp1 7)
									(++ temp1)
								)
								((< temp1 8)
									(= temp1 8)
								)
								((== temp1 8)
									(= temp1 0)
								)
								((>= (++ temp1) size)
									(= temp1 (- size 3))
								)
							)
						)
						(JOY_LEFT
							(cond
								((not temp1)
									(= temp1 8)
								)
								((<= temp1 7)
									(-- temp1)
								)
								((== temp1 8)
									(= temp1 7)
								)
								((< (-- temp1) (- size 3))
									(= temp1 (- size 1))
								)
							)
						)
					)
				else
					(= temp1 0)
				)
				(if (!= temp1 8)
					(= temp0 (self at: temp1))
					(localproc_1 temp0)
				else
					(localproc_1)
				)
				(event type: evNULL)
			)
			(
				(and
					(& (event type:) evKEYBOARD)
					(or (== (event message:) KEY_b) (== (event message:) KEY_B))
				)
				(localproc_1)
			)
		)
		(super dispatchEvent: event &rest)
	)

	(method (solvePuzzle &tmp temp0)
		(Wait 0)
		(Wait 20)
		(gCSoundFX number: 106 setLoop: 0 play: 127)
		(Wait 20)
		(selectedBowls eachElementDo: #textColor 52)
		(for ((= temp0 0)) (< temp0 local122) ((++ temp0))
			(Wait 30)
			(gCSoundFX number: 144 setLoop: 0 play: 127)
			((selectedBowls at: temp0) show:)
		)
		(Wait 45)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(gCSoundFX number: 207 setLoop: 0 play: 127)
			(selectedBowls eachElementDo: #textColor 24 eachElementDo: #show)
			(Wait 15)
			(gCSoundFX number: 144 setLoop: 0 play: 127)
			(selectedBowls eachElementDo: #textColor 52 eachElementDo: #show)
			(Wait 15)
		)
		(Wait 60)
		(spectrumPuzzle goAway:)
		(gGame setCursor: local2)
		(super solvePuzzle: &rest)
	)

	(method (buyClue &tmp temp0)
		(Graph grFILL_BOX 56 95 62 208 1 7 -1 -1)
		(Graph grUPDATE_BOX 56 95 62 208 1)
		(if (IsFlag hintFlag)
			(if (== local127 (- local121 1))
				(= local127 0)
				(= local128 1)
			else
				(++ local127)
			)
			(if (not local128)
				(ClearFlag hintFlag)
			)
		)
		(if (super buyClue: &rest)
			(= temp0 (bowlCast at: [local17 local127]))
			(gCSoundFX number: 144 setLoop: 0 play: 127)
			(Wait 0)
			(temp0 textColor: 52 show:)
			(localproc_0 2)
			(Wait 120)
			(gCSoundFX number: 207 setLoop: 0 play: 127)
			(temp0 textColor: 24 show:)
		)
	)

	(method (dispose)
		(flameCast
			eachElementDo: #dispose
			eachElementDo: #delete
			release:
			dispose:
		)
		(bowlCast release: dispose:)
		(selectedBowls release: dispose:)
		(click dispose:)
		(super dispose: &rest)
	)
)

(instance spectrumWindow of SysWindow
	(properties
		top 10
		left 50
		bottom 136
		right 269
		priority 13
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 244 0 0 0 local0 -1)
		(localproc_0 1)
	)
)

(instance element of TextIcon
	(properties
		loop 1
		textColor 24
	)

	(method (select param1 &tmp temp0 temp1 [temp2 2])
		(= local123 247)
		(|= local124 $0008)
		(if (< local122 8)
			(= [local23 local122] (self value:))
			(++ local122)
		else
			(= [local23 7] (self value:))
		)
		(selectedBowls add: self)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(if downClick
						(click number: downClick play:)
					)
					(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(self showText: (- textColor 2))
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 localize:)
						(cond
							((self onMe: temp0)
								(if (not temp1)
									(DrawCel
										view
										loop
										(= temp1 1)
										nsLeft
										nsTop
										-1
									)
									(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
									(self showText: (- textColor 2))
								)
							)
							(temp1
								(DrawCel view loop (= temp1 0) nsLeft nsTop -1)
								(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
								(self showText: textColor)
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(cond
						((== temp1 1)
							(if upClick
								(click number: upClick play:)
							)
							(if (!= (self loop:) 2)
								(self loop: 2 show:)
							)
							(DrawCel view loop 0 nsLeft nsTop -1)
							(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
							(self showText: textColor)
						)
						(upClickOff
							(click number: upClickOff play:)
						)
					)
					temp1
				)
				(else
					(if (!= (self loop:) 2)
						(self loop: 2 show:)
					)
					(DrawCel view loop 0 nsLeft nsTop -1)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(self showText: textColor)
					1
				)
			)
		)
	)

	(method (showText param1)
		(switch (StrLen text)
			(1
				(proc5_8 text param1 (+ nsLeft 7) (+ nsTop 10) -1 999)
			)
			(2
				(proc5_8 text param1 (+ nsLeft 5) (+ nsTop 10) -1 999)
			)
		)
	)
)

(instance fakeburnerIcon of IconI
	(properties
		view 244
		loop 3
		cel 0
		nsLeft 22
		nsTop 75
		nsRight 70
		nsBottom 97
	)

	(method (onMe)
		(return 0)
	)
)

(instance burner of Flame
	(properties
		x 99
		y 105
		loop 3
		priority 15
	)

	(method (cue &tmp temp0 temp1 temp2 temp3)
		(super cue: &rest)
		(= local123 246)
		(|= local124 $0008)
		(localproc_0 0)
		(if (!= [local23 0] -1)
			(gCSoundFX stop: number: 154 setLoop: 0 play: 127)
		)
		(for ((= temp1 0)) (< temp1 local122) ((++ temp1))
			(for ((= temp2 (+ temp1 1))) (< temp2 local122) ((++ temp2))
				(if (< [local23 temp2] [local23 temp1])
					(= temp0 [local23 temp1])
					(= [local23 temp1] [local23 temp2])
					(= [local23 temp2] temp0)
				)
			)
		)
		(= temp3 1)
		(if (!= local122 local121)
			(= temp3 0)
		else
			(for ((= temp1 0)) (< temp1 local121) ((++ temp1))
				(if (!= [local23 temp1] [local17 temp1])
					(= temp3 0)
					(break)
				)
			)
		)
		(if (== temp3 1)
			(spectrumPuzzle solvePuzzle:)
		else
			(= local122 0)
			(for ((= temp1 0)) (< temp1 8) ((++ temp1))
				(= [local23 temp1] -1)
			)
			(bowlCast eachElementDo: #loop 1)
			(selectedBowls eachElementDo: #show)
			(selectedBowls release:)
		)
	)
)

(instance burnLoop of Flame
	(properties
		z 50
		loop 4
		priority 15
	)

	(method (doit)
		(self
			x: (+ 50 (spectrumPuzzle eventX:))
			y: (+ 10 (spectrumPuzzle eventY:) (self z:))
		)
		(super doit: &rest)
	)
)

(instance click of Sound
	(properties
		flags 1
	)
)

(instance flameCast of Set
	(properties)
)

(instance bowlCast of Set
	(properties)
)

(instance selectedBowls of Set
	(properties)
)


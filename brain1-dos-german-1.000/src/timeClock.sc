;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Interface)
(use Language)
(use Window)

(public
	timeClock 0
)

(local
	[local0 7] = [45 50 4 4 3 3 43]
	[local7 7] = [11 1 7 7 8 8 11]
	local14
	local15
	local16
	local17
	local18 = 1
	local19
	local20
	local21 = 15
	local22 = 48
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	local34
	local35
	local36
	[local37 3] = [17 66 85]
	[local40 3] = [60 60 60]
	[local43 4] = [0 0 0 45]
	local47
	local48
	local49
)

(procedure (localproc_0)
	(cond
		((== local18 1)
			(if (== local16 288)
				(++ local18)
				(return 1)
			else
				(return 0)
			)
		)
		((== local18 2)
			(if (== local16 660)
				(++ local18)
				(return 1)
			else
				(return 0)
			)
		)
		((== local18 3)
			(if (== local16 105)
				(gEgo put: 7)
				(= local24 1)
				(timeClock solvePuzzle: 2)
				(++ local18)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(procedure (localproc_1)
	(cond
		((== local18 1)
			(= local16 288)
			(gEgo put: 5)
			(return 1)
		)
		((== local18 2)
			(= local16 660)
			(gEgo put: 6)
			(return 1)
		)
		((== local18 3)
			(= local16 105)
			(gEgo put: 7)
			(return 1)
		)
	)
)

(procedure (localproc_2)
	(localproc_4)
	(if (and (== (mod local26 10) 0) (!= local27 local26))
		(= local27 local26)
		(++ local16)
		(= local28 0)
		(return 1)
	)
)

(procedure (localproc_3 &tmp temp0)
	(if (!= (= temp0 (GetPort)) local29)
		(SetPort local29)
	)
	(cond
		((> (= local30 (/ local16 60)) 12)
			(-= local30 12)
			(-= local16 720)
		)
		((not local30)
			(+= local30 12)
			(+= local16 720)
		)
	)
	(= local33 (/ local30 10))
	(= local34 (mod local30 10))
	(= local31 (/ (= local17 (mod local16 60)) 10))
	(= local32 (mod local17 10))
	(Graph grFILL_BOX 38 30 52 90 1 [local0 0] -1 -1)
	(Graph grUPDATE_BOX 38 30 52 90 1)
	(if (> local30 9)
		(Format @local35 {%1d} local33)
		(proc5_8 @local35 [local0 1] 35 40 -1 201)
	)
	(Format @local35 {%1d} local34)
	(proc5_8 @local35 [local0 1] 43 40 -1 201)
	(proc5_8 {:} [local0 1] 56 40 -1 201)
	(Format @local35 {%1d} local31)
	(proc5_8 @local35 [local0 1] 65 40 -1 201)
	(Format @local35 {%1d} local32)
	(proc5_8 @local35 [local0 1] 77 40 -1 201)
	(SetPort temp0)
)

(procedure (localproc_4 &tmp temp0 temp1)
	(= local26 (& (= temp0 (GetTime 1)) $003f)) ; SysTime12
	(= temp1 (& (>> temp0 $0006) $003f))
	(return (+ (* (= local25 (>> temp0 $000c)) 360) (* temp1 6) (/ local26 10)))
)

(procedure (localproc_5 &tmp temp0)
	(if local20
		(DrawCel 125 0 1 (- 48 local22) 20 15)
		(localproc_6)
	else
		(DrawCel 125 0 0 (- 48 local22) 20 15)
	)
	(localproc_3)
)

(procedure (localproc_6 &tmp temp0)
	(= temp0 (GetPort))
	(SetPort 0)
	(if (not (IsFlag 0))
		(= local19 (Graph grSAVE_BOX 0 0 180 46 1))
	else
		(= local19 (Graph grSAVE_BOX 0 0 180 47 1))
	)
	(DrawCel 125 0 2 2 20 15)
	(SetPort temp0)
)

(procedure (localproc_7 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (CelWide (param1 view:) (param1 loop:) (param1 cel:)))
	(= temp2 (CelHigh (param1 view:) (param1 loop:) (param1 cel:)))
	(= temp1 (+ (param1 nsLeft:) (/ temp0 2)))
	(= temp3 (+ (param1 nsTop:) (/ temp2 2)))
	(gGame setCursor: gTheCursor 1 temp1 temp3)
)

(instance timeClock of PuzzleBar
	(properties
		puzzleHeight 200
		bottomHeight 0
		solvedFlag 1
	)

	(method (init &tmp temp0 temp1)
		(if (not (IsFlag 0))
			(for ((= temp0 0)) (< temp0 7) ((++ temp0))
				(= [local0 temp0] [local7 temp0])
			)
		)
		(= local14 (localproc_4))
		(= window (timeWindow back: [local0 6] yourself:))
		(= local21 iconHeight)
		(= local23 (+ iconHeight puzzleHeight 3))
		(gEgo get: 4)
		(if (gEgo has: 4)
			(clockKeyIcon signal: (& (clockKeyIcon signal:) $fffb))
		else
			(clockKeyIcon signal: (| (clockKeyIcon signal:) $0004))
		)
		(if (gEgo has: 7)
			(clockCardIcon signal: (& (clockCardIcon signal:) $fffb))
		else
			(clockCardIcon signal: (| (clockCardIcon signal:) $0004))
		)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			((= temp1 (timeButtonIcon new:))
				loop: 2
				maskLoop: 2
				value: temp0
				highlightColor: [local0 4]
				lowlightColor: [local0 5]
				nsLeft: [local37 temp0]
				nsTop: [local40 temp0]
			)
			(self add: temp1 disable: temp1)
			(= [local43 temp0] temp1)
		)
		(self
			add:
				(cardSlotIcon
					loop: 3
					maskLoop: 3
					value: 0
					nsLeft: 28
					nsTop: 92
					highlightColor: [local0 2]
					lowlightColor: [local0 3]
					yourself:
				)
				(clockKeyIcon
					loop: 6
					value: 0
					nsLeft: 15
					nsTop: 109
					highlightColor: [local0 2]
					lowlightColor: [local0 3]
					yourself:
				)
				(clockCardIcon
					loop: 5
					maskLoop: 5
					value: 0
					nsLeft: 64
					nsTop: 111
					highlightColor: [local0 2]
					lowlightColor: [local0 3]
					yourself:
				)
		)
		(if (not local20)
			(self
				add:
					(keyholeIcon
						loop: 1
						maskLoop: 1
						value: 0
						nsLeft: 79
						nsTop: 63
						highlightColor: [local0 2]
						lowlightColor: [local0 3]
						yourself:
					)
			)
		)
		(super init: &rest)
	)

	(method (animateOnce)
		(if local49
			(= local49 0)
			(proc5_9 190 0) ; "Visitors to the castle need to punch in on this time clock. Dr. Brain is very big on punctuality, and expects you to punch in at exactly the right time."
			(proc5_9 190 1) ; "You will need to punch each of your time cards in at the correct time according to the time sequence on the card."
		)
		(if ((ScriptID 180 1) script:) ; clock
			(((ScriptID 180 1) script:) doit:) ; clock
		)
		(timeButtonScript doit:)
		(if (localproc_2)
			(localproc_3)
		)
		(return 1)
	)

	(method (dispatchEvent event &tmp temp0 temp1)
		(= temp0 (self indexOf: highlightedIcon))
		(if (& (event type:) $0040) ; direction
			(switch (event message:)
				(JOY_DOWN
					(cond
						((< temp0 (- size 4))
							(cond
								((< temp0 3)
									(= temp1 (self at: 3))
								)
								((== temp0 3)
									(= temp1 (self at: 5))
								)
								((== temp0 4)
									(= temp1 (self at: (- size 3)))
								)
								((== temp0 5)
									(= temp1 (self at: (- size 3)))
								)
								((== temp0 6)
									(= temp1 (self at: 3))
								)
							)
						)
						(local20
							(= temp1 (self at: 1))
						)
						(else
							(= temp1 (self at: 6))
						)
					)
					(localproc_7 temp1)
					(self highlight: temp1)
				)
				(JOY_UP
					(if (< temp0 (- size 4))
						(cond
							((< temp0 3)
								(= temp1 (self at: (- size 3)))
							)
							((== temp0 3)
								(if local20
									(= temp1 (self at: 1))
								else
									(= temp1 (self at: 6))
								)
							)
							((== temp0 4)
								(= temp1 (self at: 3))
							)
							((== temp0 5)
								(= temp1 (self at: 3))
							)
							((== temp0 6)
								(= temp1 (self at: (- size 3)))
							)
						)
					else
						(= temp1 (self at: 5))
					)
					(localproc_7 temp1)
					(self highlight: temp1)
				)
			)
		)
		(super dispatchEvent: event)
	)

	(method (show &tmp temp0)
		(if (GameIsRestarting)
			(= local14 (localproc_4))
		)
		(= highlightedIcon (self at: 5))
		(super show: &rest)
		(= local14 (localproc_4))
		(gTheIconBar select: (gTheIconBar at: 1) curIcon: (gTheIconBar at: 1))
		(gGame setCursor: 8)
		(if local20
			(= temp0 (GetPort))
			(SetPort 0)
			(Graph grRESTORE_BOX local19)
			(Graph grUPDATE_BOX 0 0 180 47 1)
			(SetPort temp0)
		)
		(if local24
			(proc5_9 190 2) ; "Good going! You're now punched in and ready for work. The back door opens to reveal... an elevator car."
		)
		(return local24)
	)

	(method (buyClue)
		(cond
			((not (gEgo has: 7))
				(proc5_9 190 3) ; "You need to find a time card before you can punch in."
			)
			((super buyClue: &rest)
				(= local48 1)
				(if local20
					(gCMusic2 number: 50 setLoop: 1 play:)
					(localproc_1)
					(localproc_3)
					(clockCardIcon select:)
					(DrawCel 125 5 1 64 111 15)
					(cardSlotIcon select:)
				else
					(proc5_9 190 4) ; "Of course, Dr. Brain values cleverness even more than punctuality. Try using the key you got from the Math Marvel to open the Time Clock and reset the time."
					(gCMusic2 number: 51 setLoop: 1 play:)
					(localproc_1)
					(localproc_3)
					(clockCardIcon select:)
					(DrawCel 125 5 1 64 111 15)
					(cardSlotIcon select:)
				)
				(= local48 0)
			)
		)
	)

	(method (showHelp)
		(proc5_9 190 0) ; "Visitors to the castle need to punch in on this time clock. Dr. Brain is very big on punctuality, and expects you to punch in at exactly the right time."
		(proc5_9 190 1) ; "You will need to punch each of your time cards in at the correct time according to the time sequence on the card."
	)

	(method (hide)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(super hide: &rest)
	)
)

(instance cardSlotIcon of CodeIcon
	(properties
		view 125
		loop 3
		cel 0
		maskView 125
		maskLoop 3
		maskCel 1
	)

	(method (highlight param1)
		(cond
			(local20
				(if param1
					(DrawCel view loop 4 nsLeft nsTop 15)
				else
					(DrawCel view loop 2 nsLeft nsTop 15)
				)
			)
			(param1
				(DrawCel view loop 5 nsLeft nsTop 15)
			)
			(else
				(DrawCel view loop 0 nsLeft nsTop 15)
			)
		)
	)

	(method (select)
		(if (and (== gTheCursor 111) (super select: &rest))
			(gCMusic number: 936 setLoop: 1 play:)
			(if local20
				(DrawCel 125 3 3 28 92 15)
			else
				(DrawCel 125 3 1 28 92 15)
			)
			(if (localproc_0)
				(Wait 0)
				(Wait 45)
				(gCMusic2 number: 52 setLoop: 1 play:)
				(Print 190 5) ; "You got it!"
				(if (> local18 3)
					(timeClock goAway:)
					(self dispose:)
				)
			else
				(gCMusic2 number: 57 setLoop: 1 play:)
				(proc5_11 190 6) ; "It's not the right time to clock in yet."
			)
			(DrawCel view loop cel 28 92 15)
			(DrawCel 125 5 0 64 111 15)
			(gGame setCursor: 80 1)
		)
	)
)

(instance clockKeyIcon of CodeIcon
	(properties
		view 125
		loop 6
		cel 0
		signal 128
		maskView 125
		maskLoop 6
		maskCel 2
	)

	(method (highlight param1)
		(if (not (or local20 (== gTheCursor 69)))
			(if param1
				(DrawCel view loop 3 nsLeft nsTop 15)
			else
				(DrawCel view loop 0 nsLeft nsTop 15)
			)
		)
	)

	(method (select &tmp [temp0 3])
		(if (super select: &rest)
			(gCMusic2 number: 58 setLoop: 1 play:)
			(DrawCel 125 6 2 nsLeft nsTop 15)
			(gGame setCursor: 69 1)
			(= local36 1)
		)
	)
)

(instance clockCardIcon of CodeIcon
	(properties
		view 125
		cel 0
		signal 128
		maskView 125
		maskCel 2
	)

	(method (highlight param1 &tmp temp0 temp1 [temp2 250])
		(if param1
			(DrawCel view loop 3 nsLeft nsTop 15)
			(if (not local48)
				(cond
					((== local18 1)
						(= temp0 {1:12\n2:24\n3:36\n})
						(= temp1 {first})
					)
					((== local18 2)
						(= temp0 {4:15\n6:30\n8:45\n})
						(= temp1 {second})
					)
					((== local18 3)
						(= temp0 {10:18\n8:27\n5:36\n})
						(= temp1 {third})
					)
				)
				(if (IsObject gModelessDialog)
					(gModelessDialog dispose:)
				)
				(if 1
					(= global408 (Memory memALLOC_CRIT (StrLen temp1)))
					(= global409 (Memory memALLOC_CRIT (StrLen temp1)))
					(StrSplitInTwo global408 global409 temp1)
					(Format @temp2 190 7 global408 temp0 global409 temp0) ; "The %s card has previously been used at: %s"
					(Memory memFREE global408)
					(Memory memFREE global409)
				)
				(Print @temp2 #at 166 130 #time 3 #dispose)
			)
		else
			(if (IsObject gModelessDialog)
				(gModelessDialog dispose:)
			)
			(DrawCel view loop 1 nsLeft nsTop 15)
		)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gCMusic2 number: 58 setLoop: 1 play:)
			(DrawCel 125 5 1 nsLeft nsTop 15)
			(if (not local20)
				(DrawCel 125 6 0 15 109 15)
			)
			(gGame setCursor: 111 1)
		)
	)
)

(instance keyholeIcon of CodeIcon
	(properties
		view 125
		cel 0
		maskView 125
	)

	(method (highlight param1)
		(if (not local20)
			(if param1
				(DrawCel view loop 2 nsLeft nsTop 15)
			else
				(DrawCel view loop 0 nsLeft nsTop 15)
			)
		)
	)

	(method (select &tmp temp0)
		(if (and (== gTheCursor 69) (not local20))
			((ScriptID 180 1) setCel: 1 setScript: clockScript) ; clock
			(gEgo put: 4)
		)
	)
)

(instance timeButtonIcon of CodeIcon
	(properties
		view 125
		cel 0
		maskView 125
	)

	(method (select &tmp [temp0 2])
		(gCMusic2 number: 61 setLoop: 1 play:)
		(if local20
			((ScriptID 180 1) setScript: timeButtonScript 0 value) ; clock
		)
	)

	(method (highlight param1)
		(if param1
			(gTheIconBar select: (gTheIconBar at: 1) curIcon: (gTheIconBar at: 1))
			(gGame setCursor: 8)
			(DrawCel view loop 3 nsLeft nsTop 15)
		else
			(DrawCel view loop 1 nsLeft nsTop 15)
		)
	)

	(method (onMe)
		(if local20
			(return (super onMe: &rest))
		else
			(return 0)
		)
	)
)

(instance timeWindow of SysWindow
	(properties
		top 15
		left 48
		bottom 146
		right 166
		back 43
	)

	(method (open)
		(super open:)
		(if (gEgo has: 7)
			(clockCardIcon signal: (& (clockCardIcon signal:) $fffb))
		else
			(clockCardIcon signal: (| (clockCardIcon signal:) $0004))
		)
		(= local29 (GetPort))
		(if (or local20 local47)
			(= local15 (localproc_4))
			(+= local16 (- local15 local14))
			(localproc_5)
		else
			(= local47 1)
			(DrawCel 125 0 0 (- 48 local22) 20 15)
			(= local15 (localproc_4))
			(= local16 (+ 540 (- local15 local14)))
			(localproc_5)
			(Wait 30)
			(if (== gTheCursor 69)
				(keyholeIcon select:)
			)
		)
	)
)

(instance clockScript of HandsOffScript
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= local36 0)
				(= local20 1)
				(DrawCel 125 6 2 15 109 15)
				(timeClock disable: clockKeyIcon)
				(DrawCel 125 4 0 79 63 15)
				(= cycles 10)
			)
			(1
				(gCMusic number: 939 setLoop: 1 play:)
				(localproc_6)
				(timeClock delete: keyholeIcon)
				(DrawCel 125 0 1 0 20 15)
				(DrawCel 125 3 2 28 92 15)
				(cardSlotIcon cel: 2 maskCel: 3)
				([local43 0] signal: (& ([local43 0] signal:) $fffb))
				([local43 1] signal: (& ([local43 1] signal:) $fffb))
				([local43 2] signal: (& ([local43 2] signal:) $fffb))
				(localproc_3)
				(if (gEgo has: 7)
					(DrawCel 125 5 0 64 111 15)
				)
				(= cycles 10)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance timeButtonScript of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame setCursor: 80 1)
				(DrawCel 125 2 2 [local37 register] [local40 register] 15)
				(switch register
					(0
						(= temp0 (/ local16 60))
						(+= local16 60)
						(if (> temp0 12)
							(-= local16 720)
						)
					)
					(1
						(= temp0 (/ (mod local16 60) 10))
						(+= local16 10)
						(if (>= temp0 5)
							(-= local16 60)
						)
					)
					(2
						(= temp0 (mod local16 10))
						(++ local16)
						(if (>= temp0 9)
							(-= local16 10)
						)
					)
				)
				(localproc_3)
				(= cycles 20)
			)
			(1
				(if (== (timeClock highlightedIcon:) (timeClock at: register))
					((timeClock highlightedIcon:) highlight: 1)
				else
					((timeClock at: register) highlight: 0)
				)
				(self dispose:)
			)
		)
	)
)


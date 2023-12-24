;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 185)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Print)
(use Window)

(public
	flamingos 0
)

(local
	[local0 27] = [0 0 0 0 0 0 0 0 0 14 64 4 41 117 73 114 33 89 28 74 78 40 95 24 49 97 101]
	local27 = {abcdefghi}
	[local28 9]
	[local37 9]
	[local46 9]
	[local55 9] = [7 16 7 56 130 40 448 4 448]
	[local64 27] = [2 0 0 2 2 0 2 2 0 4 4 0 0 4 2 4 4 0 4 2 6 0 6 6 0 6 0]
	[local91 9] = [4 4 11 14 23 17 17 17 17]
	[local100 9] = [12 12 -2 12 1 9 9 9 9]
	[local109 9] = [7 7 8 5 1 -13 -13 -13 -13]
	[local118 9] = [17 22 8 22 16 4 24 62 0]
	local127 = 99
	local128 = 98
	local129 = 104
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2)
	(for ((= temp0 (StrLen param1))) temp0 ((-- temp0))
		(= temp2 (- (Random 1 temp0) 1))
		(= temp1 (StrAt param1 temp2))
		(StrCpy (+ param1 temp2) (+ param1 temp2 1))
		(StrAt param1 8 temp1)
		(StrAt param1 9 0)
	)
)

(procedure (localproc_1 param1)
	(Wait 0)
	(Wait param1)
)

(procedure (localproc_2 param1 &tmp temp0 temp1)
	(= temp1 1)
	(= temp0 0)
	(while (< temp0 9)
		(if (& [local55 param1] temp1)
			(= [local28 temp0] [local64 (+ (* 9 [local46 param1]) param1)])
			([local0 temp0]
				loop: (+ (& ([local0 temp0] loop:) $0001) [local28 temp0])
			)
			(if (== argc 1)
				([local0 temp0] show:)
			)
		)
		(++ temp0)
		(<<= temp1 $0001)
	)
	(if (== param1 [local46 param1] 2)
		(= [local28 6] 6)
		([local0 6] loop: (+ (& ([local0 6] loop:) $0001) 6))
		(if (== argc 1)
			([local0 6] show:)
		)
	)
	(if (> (++ [local46 param1]) gDifficulty)
		(= [local46 param1] 0)
	)
)

(procedure (localproc_3 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 9) ((++ temp0))
		([local0 temp0]
			loop: (+ [local28 temp0] (& ([local0 temp0] loop:) $0001))
			show:
		)
	)
)

(procedure (localproc_4 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 9) ((++ temp0))
		([local0 temp0]
			loop: (+ [local37 temp0] (& ([local0 temp0] loop:) $0001))
			show:
		)
	)
	(gCSoundFX number: 131 loop: 1 play:)
)

(instance flamingos of PuzzleBar
	(properties
		puzzleHeight 169
		solvedFlag 2
		noun 1
		msgModule 180
		personalID 17
	)

	(method (init &tmp temp0 temp1 temp2)
		(= window flamWin)
		(localproc_0 local27)
		(for ((= temp0 0)) (< temp0 9) ((++ temp0))
			(= temp1 (mod temp0 3))
			(= temp2 (/ temp0 3))
			(self
				add:
					((= [local0 (- (StrAt local27 temp0) 97)] (bird new:))
						nsLeft: (+ 12 (* temp1 47) (* temp2 4))
						nsTop: (+ 25 (* temp2 45))
						loop: (Random 0 1)
						value: temp0
						modifiers: (- (StrAt local27 temp0) 97)
						yourself:
					)
			)
		)
		(switch gDifficulty
			(0 ; Novice
				(= temp0
					(switch (Random 1 3)
						(1 1)
						(2 4)
						(3 7)
					)
				)
				(= [local37 temp0] 2)
				(switch temp0
					(1
						(= local127 101)
						(= local128 105)
					)
					(4
						(= local127 100)
						(= local128 102)
					)
					(7
						(= local127 101)
						(= local128 99)
					)
				)
			)
			(1 ; Standard
				(= [local37 2] 4)
				(= [local37 4] 2)
				(= local127 100)
				(= local128 102)
				(= local129 104)
			)
			(2 ; Expert
				(= [local37 2] 4)
				(= [local37 4] 2)
				(= [local37 6] 6)
			)
		)
		(for ((= temp0 1)) (<= temp0 9) ((++ temp0))
			(switch (StrAt local27 (- temp0 1))
				(local127
					(= local127 temp0)
				)
				(local128
					(= local128 temp0)
				)
				(local129
					(= local129 temp0)
				)
			)
		)
		(super init: &rest)
	)

	(method (showHelp &tmp temp0 [temp1 9])
		(super showHelp: &rest)
		(for ((= temp0 0)) (< temp0 9) ((++ temp0))
			(= [temp1 temp0] [local28 temp0])
			(= [local28 temp0] 0)
		)
		(localproc_3)
		(localproc_1 20)
		(for ((= temp0 0)) (< temp0 (+ 4 gDifficulty)) ((++ temp0))
			(localproc_3)
			(localproc_1 10)
			(localproc_4)
			(localproc_1 10)
		)
		(for ((= temp0 0)) (< temp0 9) ((++ temp0))
			(= [local28 temp0] [temp1 temp0])
		)
		(localproc_3)
	)

	(method (buyClue &tmp temp0 temp1 [temp2 300])
		(if (super buyClue: &rest)
			(for ((= temp0 (= temp1 0))) (< temp0 9) ((++ temp0))
				(if (or (!= [local46 temp0] 0) (!= [local28 temp0] 0))
					(= temp1 1)
				)
				(= [local28 temp0] (= [local46 temp0] 0))
			)
			(if temp1
				(Prints {Resetting})
			)
			(localproc_3)
			(Message
				msgGET
				msgModule
				1
				(switch gDifficulty
					(0 21) ; Novice
					(1 22) ; Standard
					(2 23) ; Expert
				)
				0
				1
				@temp2
			)
			(proc15_4 self 99 @temp2 local127 local128 local129)
		)
	)

	(method (solvePuzzle &tmp temp0 temp1)
		(gCSoundFX number: 134 loop: -1 play:)
		(Wait 0)
		(for ((= temp1 0)) (< temp1 8) ((++ temp1))
			(for ((= temp0 0)) (< temp0 9) ((++ temp0))
				([local0 temp0]
					loop: (& (+ ([local0 temp0] loop:) 2) $0007)
					show:
				)
				(Wait 2)
			)
		)
		(gCSoundFX stop:)
		(localproc_1 20)
		(super solvePuzzle:)
	)

	(method (dispatchEvent event &tmp temp0 temp1)
		(if (& (event type:) $0040) ; direction
			(= temp1
				(if highlightedIcon
					(self indexOf: highlightedIcon)
				else
					0
				)
			)
			(switch (event message:)
				(JOY_UP
					(if (< (-= temp1 3) 0)
						(+= temp1 size)
					)
				)
				(JOY_DOWN
					(if (>= (+= temp1 3) size)
						(-= temp1 size)
					)
				)
				(JOY_RIGHT
					(if (not (mod (++ temp1) 3))
						(-= temp1 3)
					)
				)
				(JOY_LEFT
					(if (not (mod temp1 3))
						(+= temp1 3)
					)
					(-- temp1)
				)
			)
			(= temp0 (self at: temp1))
			(proc5_9 temp0)
			(event type: evNULL)
		)
		(if (and puzzleStatus (& (event type:) $030f)) ; evJOYUP | evJOYDOWN | evKEYUP | evMOUSEKEYBOARD | evMOUSERELEASE
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)
)

(instance flamWin of SysWindow
	(properties
		top 13
		left 92
		bottom 176
		right 254
		back 53
		priority -1
	)
)

(instance bird of CodeIcon
	(properties
		view 186
		loop 0
		signal 385
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(localproc_2 modifiers)
			(for
				((= temp0 0))
				(and (< temp0 9) (== [local28 temp0] [local37 temp0]))
				((++ temp0))
			)
			(if (== temp0 9)
				(flamingos solvePuzzle: goAway:)
			)
		)
	)

	(method (show &tmp temp0 temp1)
		(PicNotValid 1)
		(super show: &rest)
		(= temp1 1)
		(= temp0 0)
		(while (< temp0 6)
			(if (& [local118 value] temp1)
				(if (== temp0 5)
					(+= temp0 (/ loop 2))
				)
				(DrawCel
					view
					(| (& loop $0001) $0008)
					temp0
					(+
						nsLeft
						(if (& loop $0001)
							[local109 temp0]
						else
							[local91 temp0]
						)
					)
					(+ nsTop [local100 temp0])
					-1
				)
			)
			(++ temp0)
			(<<= temp1 $0001)
		)
		(PicNotValid 0)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 13) nsBottom (+ nsRight 13) 1)
	)
)


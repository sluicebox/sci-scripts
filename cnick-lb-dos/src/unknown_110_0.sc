;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use n010)
(use unknown_100_4)
(use Interface)
(use GameControls)
(use System)

(public
	unknown_110_0 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 45]
	[local52 140]
	[local192 70]
	[local262 85]
	[local347 85]
	[local432 55]
	[local487 75]
	[local562 70]
	[local632 70]
)

(procedure (localproc_0)
	(= local0 global130)
	(= local1 global132)
	(= local2 (Class_100_2 sel_643:))
	(= local3 (Class_100_2 sel_642:))
	(= local4 (Class_100_2 sel_40:))
	(= local5 global148)
	(= global136 (Class_100_2 sel_40:))
	(= local6 gGameControls)
	(unknown_110_3 sel_192: (Format @local7 199 19)) ; "DEFAULT BUTTON - Set all buttons back to their original settings."
	(unknown_110_4 sel_192: (Format @local52 199 20)) ; "HELP BUTTON - This is the button that you pressed to get help on other things. By placing this cursor on an item on the Control Panel and pressing the button, you will get a brief explanation of what each button is for."
	(unknown_110_5 sel_192: (Format @local192 199 21)) ; "OK BUTTON - Pressing this button will put away this Control Panel and return you to whatever you were doing."
	(unknown_110_6 sel_192: (Format @local262 199 23)) ; "MUST PLAY - If ON, a play must be made if there is one. If OFF, dominoes may be taken from the Boneyard at any time. (Originally ON)"
	(unknown_110_7 sel_192: (Format @local347 199 24)) ; "HIGHEST DOUBLET - If ON, the player with the highest doublet plays first. If OFF, players take turns playing the first domino and may play any domino. (Originally ON)"
	(unknown_110_8 sel_192: (Format @local432 199 25)) ; "SHOW BONEYARD - If ON, all dominoes in the Boneyard are displayed at the end of each hand. (Originally OFF)"
	(unknown_110_9 sel_192: (Format @local487 199 26)) ; "BONEYARD MINIMUM - The minimum number of dominoes that must remain in the Boneyard. This may be set to 0 or 2. (Originally 0)"
	(unknown_110_10 sel_192: (Format @local562 199 27)) ; "DOMINOES PER HAND - The number of dominoes which are taken at the beginning of each hand. This may be set to 5 or 7. (Originally 7)"
	(unknown_110_11 sel_192: (Format @local632 199 29)) ; "Game Score Limit - Set this switch to the number of points a game consists of. (Default 100)"
	((= gGameControls unknown_110_1)
		sel_32: unknown_110_2
		sel_118:
			(unknown_110_3 sel_325: unknown_110_3 sel_404: 57 sel_117:)
			unknown_110_4
			(unknown_110_5 sel_325: unknown_110_5 sel_404: 57 sel_117:)
			(unknown_110_6
				sel_3: (if global130 5 else 6)
				sel_325: unknown_110_6
				sel_404: 57
				sel_117:
			)
			(unknown_110_7
				sel_3: (if global132 7 else 8)
				sel_325: unknown_110_7
				sel_404: 57
				sel_117:
			)
			(unknown_110_8
				sel_3: (if (Class_100_2 sel_643:) 9 else 10)
				sel_325: unknown_110_8
				sel_404: 57
				sel_117:
			)
			(unknown_110_9
				sel_3: (if (== (Class_100_2 sel_642:) 0) 11 else 12)
				sel_325: unknown_110_9
				sel_404: 57
				sel_117:
			)
			(unknown_110_10
				sel_3:
					(if (or global135 (== (Class_100_2 sel_40:) 5)) 13 else 14)
				sel_325: unknown_110_10
				sel_404: 57
				sel_117:
			)
			(unknown_110_11
				sel_3: 0
				sel_4: (+ (/ global148 100) 1)
				sel_325: unknown_110_11
				sel_404: 57
				sel_117:
			)
		sel_215: unknown_110_4
		sel_210: (if (not (HaveMouse)) unknown_110_5 else 0)
	)
	(gGameControls sel_198:)
)

(instance unknown_110_0 of Code
	(properties
		sel_20 -1
	)

	(method (sel_57)
		(localproc_0)
	)
)

(instance unknown_110_1 of GameControls
	(properties
		sel_20 -1
	)

	(method (sel_204 param1)
		(if (and (== (param1 sel_31:) 4) (== (param1 sel_37:) 27))
			(Print 110 0) ; "Clear this dialog box by pressing the "OK" button."
			(param1 sel_37: 0)
		)
		(super sel_204: param1 &rest)
	)

	(method (sel_111)
		(unknown_110_0 sel_111:)
		(super sel_111:)
	)
)

(instance unknown_110_2 of Class_10_0
	(properties
		sel_187 30
		sel_188 53
		sel_189 158
		sel_190 267
	)

	(method (sel_183 &tmp temp0)
		(super sel_183:)
		(DrawCel 110 0 0 0 0 15)
		(Graph grUPDATE_BOX sel_187 sel_188 (+ sel_189 1) (+ sel_190 1) 1)
	)
)

(instance unknown_110_3 of ControlIcon
	(properties
		sel_20 -1
		sel_2 110
		sel_3 1
		sel_4 0
		sel_7 7
		sel_6 19
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(= global130 0)
		(unknown_110_6 sel_57:)
		(Class_100_2 sel_643: 1)
		(unknown_110_8 sel_57:)
		(Class_100_2 sel_642: 2)
		(unknown_110_9 sel_57:)
		(Class_100_2 sel_40: 5)
		(unknown_110_10 sel_57:)
		(unknown_110_11 sel_4: 2 sel_198: sel_57:)
		(= global148 100)
		(= global132 0)
		(unknown_110_7 sel_57:)
	)
)

(instance unknown_110_4 of ControlIcon
	(properties
		sel_20 -1
		sel_2 110
		sel_3 3
		sel_4 0
		sel_7 7
		sel_6 71
		sel_33 980
		sel_37 6
		sel_14 387
		sel_196 -1
	)
)

(instance unknown_110_5 of ControlIcon
	(properties
		sel_20 -1
		sel_2 110
		sel_3 4
		sel_4 0
		sel_7 7
		sel_6 98
		sel_14 451
		sel_196 -1
	)

	(method (sel_57 &tmp temp0)
		(gDominoes_opt sel_57: 3)
		(gGameControls sel_102: sel_111:)
		(Animate (gCast sel_24:) 0)
		(if global135
			(Class_100_2 sel_40: global136)
		)
		(if (!= global136 (Class_100_2 sel_40:))
			(if (== (Class_100_2 sel_27:) 0)
				(if gModelessDialog
					(gModelessDialog sel_111:)
				)
				(= temp0 (gSystemWindow sel_26:))
				(gSystemWindow sel_26: 21)
				(Print
					(Format @global550 199 22 (Class_100_2 sel_40:)) ; "Select %d Dominoes each"
					27
					1
					64
					-1
					17
					111
				)
			)
			(gSystemWindow sel_26: temp0)
		)
		(if (== ((gCurRoom sel_141:) sel_29:) 3)
			(if (> (Class_100_2 sel_86:) (Class_100_2 sel_642:))
				((Class_100_2 sel_641:) sel_165: 2)
				(((Class_100_2 sel_641:) sel_450:)
					sel_4: (Class_100_2 sel_86:)
					sel_198:
				)
			else
				((Class_100_2 sel_641:) sel_165: 5)
				(((Class_100_2 sel_641:) sel_450:) sel_102:)
			)
		)
		(= gGameControls local6)
		(if
			(and
				(!= local1 global132)
				global132
				(== ((gCurRoom sel_141:) sel_29:) 2)
			)
			(proc100_1)
		)
	)
)

(instance unknown_110_6 of ControlIcon
	(properties
		sel_20 -1
		sel_2 110
		sel_4 0
		sel_7 65
		sel_6 19
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(= sel_3 (if (= global130 (- 1 global130)) 5 else 6))
		(self sel_198:)
	)
)

(instance unknown_110_7 of ControlIcon
	(properties
		sel_20 -1
		sel_2 110
		sel_4 0
		sel_7 65
		sel_6 36
		sel_14 387
		sel_193 110
		sel_194 7
		sel_195 2
		sel_196 -1
	)

	(method (sel_57 &tmp temp0)
		(= sel_3 (if (= global132 (- 1 global132)) 7 else 8))
		(self sel_198:)
	)
)

(instance unknown_110_8 of ControlIcon
	(properties
		sel_20 -1
		sel_2 110
		sel_4 0
		sel_7 65
		sel_6 55
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(if (Class_100_2 sel_643:)
			(Class_100_2 sel_643: 0)
		else
			(Class_100_2 sel_643: 1)
		)
		(= sel_3 (if (Class_100_2 sel_643:) 9 else 10))
		(self sel_198:)
		(if (and global129 (<= 4 ((gCurRoom sel_141:) sel_29:) 6))
			(if (Class_100_2 sel_643:)
				(gUnknown_100_11 sel_110: global137)
			else
				(gUnknown_100_11 sel_102:)
			)
		)
	)
)

(instance unknown_110_9 of ControlIcon
	(properties
		sel_20 -1
		sel_2 110
		sel_4 0
		sel_7 65
		sel_6 71
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(if (== (Class_100_2 sel_642:) 0)
			(Class_100_2 sel_642: 2)
		else
			(Class_100_2 sel_642: 0)
		)
		(= sel_3 (if (== (Class_100_2 sel_642:) 0) 11 else 12))
		(self sel_198:)
	)
)

(instance unknown_110_10 of ControlIcon
	(properties
		sel_20 -1
		sel_2 110
		sel_4 0
		sel_7 65
		sel_6 88
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(if (== (Class_100_2 sel_40:) 5)
			(Class_100_2 sel_40: 7)
		else
			(Class_100_2 sel_40: 5)
		)
		(= sel_3 (if (== (Class_100_2 sel_40:) 5) 13 else 14))
		(self sel_198:)
		(= global135 0)
		(if
			(and
				(== ((gCurRoom sel_141:) sel_29:) 1)
				(<= (Class_100_2 sel_86:) (- 28 (* (Class_100_2 sel_40:) 2)))
			)
			(Print 199 28 64 -1 150) ; "The change to 5 Dominoes per hand will take effect at the beginning of the next hand."
			(= global135 5)
		)
	)
)

(instance unknown_110_11 of ControlIcon
	(properties
		sel_20 -1
		sel_2 110
		sel_4 3
		sel_7 65
		sel_6 105
		sel_14 387
		sel_196 -1
	)

	(method (sel_171 param1 &tmp temp0 temp1 temp2 temp3)
		(= temp3 sel_4)
		(if (> (= temp2 (+ sel_4 1)) 6)
			(= temp2 2)
		)
		(if (and argc param1 (& sel_14 $0001))
			(DrawCel sel_2 sel_3 (= temp1 1) sel_7 sel_6 -1)
			(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
			(while (!= ((= temp0 (Event sel_109:)) sel_31:) 2)
				(temp0 sel_147:)
				(cond
					((self sel_200: temp0)
						(if (!= temp1 1)
							(DrawCel sel_2 sel_3 (= temp1 1) sel_7 sel_6 -1)
							(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
						)
					)
					((== temp1 1)
						(DrawCel sel_2 sel_3 (= temp1 temp3) sel_7 sel_6 -1)
						(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
					)
				)
				(temp0 sel_111:)
			)
			(temp0 sel_111:)
			(if (== temp1 1)
				(DrawCel sel_2 sel_3 (= sel_4 temp2) sel_7 sel_6 -1)
				(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
				(= global148 (* (- sel_4 1) 100))
			)
			(return temp1)
		else
			(return 1)
		)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Wat)
(use Interface)
(use MList)
(use Sound)
(use Motion)
(use System)

(public
	monkFight 0
	overlayDisposer 1
)

(local
	local0
	local1
	local2
	local3
	[local4 64] = [40 27 8 8 0 0 0 0 30 16 7 47 0 0 0 0 18 23 33 8 0 0 0 0 16 29 20 4 0 0 0 0 100 100 100 100 42 32 20 21 100 100 100 100 30 19 26 31 100 100 100 100 10 10 35 23 100 100 100 100 10 50 10 5]
)

(procedure (localproc_0 &tmp [temp0 200])
	(if local0
		(Format @temp0 &rest)
		(proc13_1 @temp0)
	)
)

(procedure (localproc_1 param1 param2)
	(Max
		24
		(Min
			(+
				(* 36 gHowFast)
				(switch global125
					(1 1)
					(2 0)
					(3 6)
					(4 12)
				)
			)
			(*
				param1
				6
				(if (== param2 rob)
					30
				else
					(-
						32
						(switch global125
							(1 0)
							(2 25)
							(3 25)
							(4 32)
						)
					)
				)
			)
		)
	)
)

(instance defenseOddsCode of Code
	(properties
		sel_20 {defenseOddsCode}
	)

	(method (sel_57 param1 param2)
		(return (- (((param1 sel_42:) sel_612:) sel_631: param2 param1)))
	)
)

(instance attackOddsCode of Code
	(properties
		sel_20 {attackOddsCode}
	)

	(method (sel_57 param1 param2)
		(if (!= ((param1 sel_630:) sel_42:) (param1 sel_42:))
			(((param1 sel_42:) sel_612:) sel_631: param1 param2)
		)
	)
)

(instance attackStrengthCode of Code
	(properties
		sel_20 {attackStrengthCode}
	)

	(method (sel_57 param1)
		(param1 sel_620:)
	)
)

(instance RandForward of Fwd
	(properties
		sel_20 {RandForward}
	)

	(method (sel_233 &tmp temp0 temp1)
		(= temp0 (sel_42 sel_4:))
		(if
			(and
				(!= (= temp1 (super sel_233: &rest)) temp0)
				(<= (Random 1 100) 60)
			)
			(= temp1 temp0)
		)
		(return temp1)
	)
)

(instance qsp of Script
	(properties
		sel_20 {qsp}
	)

	(method (sel_110)
		(if (or argc (not (sel_42 sel_142:)))
			(super sel_110: &rest)
		)
	)

	(method (sel_57)
		(if (== sel_137 sel_136 sel_139 (sel_42 sel_629:) 0)
			(= sel_139 1)
		)
		(super sel_57: &rest)
	)

	(method (sel_144 param1 &tmp temp0 temp1 temp2 temp3)
		(switch (= sel_29 param1)
			(0
				(= sel_136 (= sel_139 0))
				(= temp3 (sel_42 sel_619:))
				(= temp2
					(if
						(= temp1
							(if (= temp0 (sel_42 sel_613:))
								(temp0 sel_619:)
							)
						)
						(temp1 sel_630:)
					)
				)
				(cond
					((sel_42 sel_619:))
					((or (not temp2) (<= (temp1 sel_29:) 0))
						(cond
							(
								(and
									(== global125 4)
									(or (temp0 sel_615:) (temp0 sel_139:))
								)
								(= temp3
									((sel_42 sel_622:)
										sel_611: attackStrengthCode
									)
								)
								(sel_42 sel_629: temp3 self)
							)
							(
								(or
									(temp0 sel_615:)
									(<= (Random 0 100) (/ (* 100 global125) 4))
								)
								(while 1
									(= temp3
										((sel_42 sel_622:)
											sel_64:
												(Random
													0
													(-
														((sel_42 sel_622:)
															sel_86:
														)
														1
													)
												)
										)
									)
									(localproc_0 11 0 (temp3 sel_20:))
									(breakif
										(!= sel_42 ((temp3 sel_630:) sel_42:))
									)
								)
								(localproc_0 11 1 (temp3 sel_20:))
								(sel_42 sel_629: temp3 self)
							)
						)
					)
					(temp2
						(if (== sel_42 (temp2 sel_42:))
							(= temp3
								((sel_42 sel_622:)
									sel_611: defenseOddsCode temp1
								)
							)
							(sel_42 sel_629: temp3 self)
						else
							(= temp3
								((sel_42 sel_622:)
									sel_611: attackOddsCode temp1
								)
							)
							(sel_42 sel_629: temp3 self)
						)
					)
				)
				(if (not temp3)
					(= sel_139 1)
				)
			)
			(1
				(= sel_139 (* 6 (sel_42 sel_53:)))
			)
			(2
				(self sel_110:)
			)
		)
	)
)

(class qsPart of Part
	(properties
		sel_20 {qsPart}
	)

	(method (sel_209 &tmp temp0 temp1 temp2)
		(= temp1 (sel_42 sel_1:))
		(= temp2 ((sel_42 sel_613:) sel_1:))
		(= temp0 (/ (+ temp1 temp2) 2))
		(if (<= temp1 temp2)
			(= sel_7 (- (sel_42 sel_7:) 10))
			(= sel_9 temp0)
		else
			(= sel_7 temp0)
			(= sel_9 (+ (sel_42 sel_9:) 10))
		)
		(super sel_209: &rest)
	)

	(method (sel_632 &tmp temp0)
		(return
			(/
				(*
					(= temp0
						(if (and (not argc) (== sel_42 monk))
							(switch global125
								(1 0)
								(2 25)
								(3 25)
								(4 32)
							)
						else
							32
						)
					)
					(super sel_632: &rest)
				)
				32
			)
		)
	)
)

(class QSFighter of Fighter
	(properties
		sel_20 {QSFighter}
		sel_236 9
		sel_53 9
	)

	(method (sel_110)
		(self sel_155: 0 sel_307: sel_15: 0)
		(super sel_110: &rest)
	)

	(method (sel_162 param1 &tmp temp0)
		(= temp0 (if argc param1))
		(if (and sel_237 (sel_237 sel_143:))
			((sel_237 sel_143:) sel_145:)
		)
		(super sel_162: temp0 &rest)
	)

	(method (sel_625 param1 param2)
		(if sel_619
			(self sel_629: 0)
		)
		(cond
			((or (<= sel_620 0) (<= (param2 sel_632:) 0))
				(self sel_146: (Clone getKilled))
			)
			((not sel_142)
				(self sel_146: (Clone getHit))
			)
		)
		(= sel_139
			(Max sel_615 sel_139 (localproc_1 (param1 sel_632:) self))
		)
		(*= sel_139 3)
		(= sel_615 0)
	)

	(method (sel_627 param1 &tmp temp0 temp1)
		(= temp0 (or (sel_613 sel_142:) (super sel_627: param1 &rest)))
		(if sel_615
			(= sel_615 (localproc_1 sel_615 self))
		)
		(if local3
			(local3 sel_111:)
		)
		(= temp1 (sel_613 sel_3:))
		(cond
			((== self ((param1 sel_630:) sel_42:))
				(= local3 0)
			)
			(temp0
				((= local3 thudAndGroanSound) sel_39:)
			)
			(
				(or
					(and (== sel_3 2) (== temp1 6))
					(and (== sel_3 4) (== temp1 8))
				)
				((= local3 swishSound) sel_39:)
			)
			((not (sel_613 sel_629:))
				((= local3 thudSound) sel_39:)
			)
			(else
				((= local3 woodHitsWoodSound) sel_39:)
			)
		)
	)
)

(instance thudAndGroanSound of Sound
	(properties
		sel_20 {thudAndGroanSound}
		sel_99 1
		sel_40 935
	)
)

(instance thudSound of Sound
	(properties
		sel_20 {thudSound}
		sel_99 1
		sel_40 588
	)
)

(instance swishSound of Sound
	(properties
		sel_20 {swishSound}
		sel_99 1
		sel_40 934
	)
)

(instance woodHitsWoodSound of Sound
	(properties
		sel_20 {woodHitsWoodSound}
		sel_99 1
		sel_40 122
	)
)

(instance overlayDisposer of Script
	(properties
		sel_20 {overlayDisposer}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(thudAndGroanSound sel_111:)
				(thudSound sel_111:)
				(swishSound sel_111:)
				(woodHitsWoodSound sel_111:)
				(sel_143 sel_145:)
				(= sel_143 0)
				(rob sel_111:)
				(monk sel_111:)
				(= sel_139 1)
			)
			(1
				(proc958_0 0 858 893)
				(self sel_111:)
			)
		)
	)
)

(instance monkFight of Fight
	(properties
		sel_20 {monkFight}
	)

	(method (sel_57)
		(if
			(and
				(!= global125 local1)
				(!= (rob sel_3:) 10)
				(!= (monk sel_3:) 10)
			)
			(self sel_110:)
		)
		(= local1 global125)
		(super sel_57: &rest)
	)

	(method (sel_111)
		(= gPMouse local2)
		(gMouseDownHandler sel_81: rob)
		(gDirectionHandler sel_81: rob)
		(gKeyDownHandler sel_81: rob)
		(super sel_111:)
	)

	(method (sel_144 param1 &tmp temp0)
		(switch (= sel_29 param1)
			(0)
			(1
				(= sel_139 1)
			)
			(2
				(= temp0 sel_143)
				(= sel_143 0)
				(sel_42 sel_146: overlayDisposer temp0)
			)
		)
	)

	(method (sel_110 param1 &tmp temp0)
		(if argc
			(= local2 gPMouse)
			(= gPMouse 0)
			(gMouseDownHandler sel_129: rob)
			(gDirectionHandler sel_129: rob)
			(gKeyDownHandler sel_129: rob)
		)
		(= local1 global125)
		(robMidHit sel_631: 36 sel_243: monkBody)
		(robHighHit sel_631: 23 sel_243: monkHead)
		(robLowHit sel_631: 52 sel_243: monkLegs)
		(robOverHit sel_631: 11 sel_243: monkOverHead)
		(robMidBlk sel_243: robBody)
		(robHighBlk sel_243: robOverHead)
		(robDuck sel_243: robHead)
		(robJump sel_243: robLegs)
		(rob sel_1: 145 sel_0: 100)
		(monkMidHit sel_631: 36 sel_243: robBody)
		(monkHighHit sel_631: 23 sel_243: robHead)
		(monkLowHit sel_631: 52 sel_243: robLegs)
		(monkOverHit sel_631: 11 sel_243: robOverHead)
		(monkMidBlk sel_243: monkBody)
		(monkHighBlk sel_243: monkOverHead)
		(monkDuck sel_243: monkHead)
		(monkJump sel_243: monkLegs)
		(monk sel_1: 162 sel_0: 97)
		(if argc
			(super sel_110: param1 rob monk @local4 &rest)
		else
			(super sel_110:)
		)
		((rob sel_621:) sel_119: 632 30)
		((monk sel_621:)
			sel_119:
				632
				(switch global125
					(1 0)
					(2 25)
					(3 25)
					(4 32)
				)
		)
		(rob sel_620: (/ (* 67 (robBody sel_620:)) 100))
		(monk
			sel_620:
				(/
					(*
						(switch global125
							(1 100)
							(2 45)
							(3 61)
							(4 88)
						)
						(monkBody sel_620:)
					)
					100
				)
		)
		(if (== global125 1)
			(rob sel_146: cheatWin)
		else
			(monk sel_628: qsp)
		)
		(gGame sel_198: 10 1 (monk sel_1:) (- (monk sel_0:) 53))
	)
)

(instance cheatWin of Script
	(properties
		sel_20 {cheatWin}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(rob sel_629: robOverHit self)
			)
			(1)
			(2
				(self sel_111:)
			)
		)
	)
)

(instance rob of QSFighter
	(properties
		sel_20 {rob}
		sel_2 122
	)

	(method (sel_627 &tmp temp0)
		(= temp0 (super sel_627: &rest))
		(if (and sel_142 (== global125 1) (not (sel_613 sel_142:)))
			(sel_613 sel_146: getKilled sel_142)
		)
		(return temp0)
	)

	(method (sel_133 param1 &tmp temp0)
		(cond
			((and (== (param1 sel_31:) 4) (== (param1 sel_37:) 2))
				(= local0 (not local0))
			)
			(
				(and
					(not (or sel_139 sel_615))
					(or
						(and (== (param1 sel_31:) 64) (== (param1 sel_37:) 0))
						(and (== (param1 sel_31:) 4) (== (param1 sel_37:) 53))
						(and
							(== global125 2)
							(== (param1 sel_31:) 1)
							(self sel_209: param1)
						)
					)
					(= temp0 (sel_613 sel_629:))
					(== self ((temp0 sel_630:) sel_42:))
				)
				(= temp0 (sel_617 sel_611: defenseOddsCode temp0))
				(param1 sel_73: 1)
				(self sel_629: temp0)
			)
			(else
				(super sel_133: param1 &rest)
			)
		)
	)

	(method (sel_57 &tmp temp0 temp1)
		(if (not (or sel_619 sel_237 (<= sel_620 0)))
			(self sel_3: 0 sel_162: (Clone RandForward))
		)
		(super sel_57: &rest)
		(cond
			(
				(and
					(not
						(= temp0
							(or
								sel_139
								sel_615
								(and sel_619 (sel_619 sel_139:))
							)
						)
					)
					(== gTheCursor gWaitCursor)
				)
				(gGame sel_198: 10)
			)
			((and sel_615 (!= gTheCursor gWaitCursor))
				(gGame sel_198: gWaitCursor)
			)
		)
	)

	(method (sel_110 &tmp temp0)
		(if (= temp0 (== sel_616 0))
			(self
				sel_307:
				sel_621: robOverHead robHead robBody robLegs
				sel_622:
					robMidBlk
					robHighBlk
					robDuck
					robJump
					robMidHit
					robLowHit
					robHighHit
					robOverHit
			)
		)
		(self sel_3: 0 sel_162: (Clone RandForward))
		(sel_617 sel_20: {robTechs})
		(sel_616 sel_20: {robParts} sel_119: 632 30)
		(super sel_110: &rest)
	)
)

(instance getKilled of Script
	(properties
		sel_20 {getKilled}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= global199 0)
				(proc0_3)
				(gMouseDownHandler sel_81: rob)
				(gDirectionHandler sel_81: rob)
				(gKeyDownHandler sel_81: rob)
				(rob sel_620: 0)
				(monk sel_620: 0)
				(= sel_139 1)
			)
			(1
				(monk sel_628: 0)
				(sel_42 sel_629: 0 sel_155: 10 sel_156: 0 sel_162: End self)
			)
			(2
				((sel_42 sel_613:) sel_629: 0 sel_155: 0 sel_156: 0)
				(= sel_139 60)
			)
			(3
				(Wat sel_644: (if (== sel_42 rob) 1 else 2))
				(if (== sel_42 rob)
					(proc0_6 222)
				else
					(proc0_6 223)
				)
				(monkFight sel_145:)
				(= global199 1)
				(self sel_111:)
			)
		)
	)
)

(instance getHit of Script
	(properties
		sel_20 {getHit}
	)

	(method (sel_111)
		(sel_42 sel_139: sel_141)
		(super sel_111: &rest)
	)

	(method (sel_144 param1 &tmp temp0)
		(switch (= sel_29 param1)
			(0
				(= global199 0)
				(proc0_3)
				(= sel_141 (sel_42 sel_139:))
				(sel_42 sel_155: 0 sel_156: 0)
				(= sel_139 (sel_42 sel_53:))
			)
			(1
				(sel_42 sel_155: 9 sel_156: 0 sel_162: End self)
			)
			(2
				(= sel_139 (sel_42 sel_53:))
			)
			(3
				(sel_42 sel_155: 0 sel_156: 0 sel_162: (Clone RandForward))
				(gGame sel_198: 10)
				(= global199 1)
				(self sel_111:)
			)
			(4
				(Printf 11 2 sel_20 sel_29) ; "%s state %d"
				(Printf 11 2 sel_20 sel_29) ; "%s state %d"
				(Printf 11 2 sel_20 sel_29) ; "%s state %d"
				(Printf 11 2 sel_20 sel_29) ; "%s state %d"
				(Printf 11 2 sel_20 sel_29) ; "%s state %d"
				(Printf 11 2 sel_20 sel_29) ; "%s state %d"
				(Printf 11 2 sel_20 sel_29) ; "%s state %d"
				(Printf 11 2 sel_20 sel_29) ; "%s state %d"
				(Printf 11 2 sel_20 sel_29) ; "%s state %d"
				(Printf 11 2 sel_20 sel_29) ; "%s state %d"
			)
		)
	)
)

(instance attackElsewhere of Code ; UNUSED
	(properties
		sel_20 {attackElsewhere}
	)

	(method (sel_57 param1 param2)
		(if (not (param1 sel_209: param2))
			(((param2 sel_42:) sel_621:) sel_120: 209 param1)
		)
	)
)

(instance robOverHead of qsPart
	(properties
		sel_20 {robOverHead}
	)

	(method (sel_209)
		(= sel_6 (- 30 (sel_42 sel_6:)))
		(= sel_8 (sel_42 sel_6:))
		(super sel_209: &rest)
	)
)

(instance robHead of qsPart
	(properties
		sel_20 {robHead}
	)

	(method (sel_209)
		(= sel_6 (sel_42 sel_6:))
		(= sel_8 (+ (sel_42 sel_6:) (/ (- (sel_42 sel_8:) (sel_42 sel_6:)) 3)))
		(super sel_209: &rest)
	)
)

(instance robBody of qsPart
	(properties
		sel_20 {robBody}
	)

	(method (sel_209)
		(= sel_6 (+ (sel_42 sel_6:) (/ (- (sel_42 sel_8:) (sel_42 sel_6:)) 3)))
		(= sel_8
			(+ (sel_42 sel_6:) (/ (* (- (sel_42 sel_8:) (sel_42 sel_6:)) 2) 3))
		)
		(super sel_209: &rest)
	)
)

(instance robLegs of qsPart
	(properties
		sel_20 {robLegs}
	)

	(method (sel_209)
		(= sel_6
			(+ (sel_42 sel_6:) (/ (* (- (sel_42 sel_8:) (sel_42 sel_6:)) 2) 3))
		)
		(= sel_8 (+ 30 (sel_42 sel_8:)))
		(super sel_209: &rest)
	)
)

(class QSTechnique of Technique
	(properties
		sel_20 {QSTechnique}
	)

	(method (sel_631)
		(Min
			100
			(/
				(*
					(super sel_631: &rest)
					(+
						100
						(if (not (or argc (== sel_42 rob)))
							(switch global125
								(2 -2)
								(3 3)
								(4 10)
							)
						)
					)
				)
				100
			)
		)
	)

	(method (sel_111)
		(if (not (sel_42 sel_237:))
			(sel_42 sel_3: 0 sel_4: 0 sel_162: (Clone RandForward))
		)
		(super sel_111: &rest)
	)

	(method (sel_636)
		(return
			(cond
				(argc
					(super sel_636: &rest)
				)
				((== sel_42 (sel_630 sel_42:)) 0)
				((< (sel_42 sel_614:) sel_634) sel_634)
				(else
					(/ sel_634 2)
				)
			)
		)
	)

	(method (sel_632)
		(return
			(if (and (not argc) (== global125 1) (sel_42 sel_628:))
				0
			else
				(super sel_632: &rest)
			)
		)
	)

	(method (sel_145)
		(if (and (sel_42 sel_139:) (!= (sel_630 sel_42:) sel_42))
			(self sel_111:)
		else
			(super sel_145: &rest)
		)
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_139
					(*
						1
						(if (!= (sel_630 sel_42:) sel_42)
							(+
								(self sel_636:)
								(Max (sel_42 sel_139:) (sel_42 sel_615:))
							)
						else
							(sel_42 sel_615:)
						)
					)
				)
				(if (not sel_139)
					(self sel_145:)
				)
			)
			(1
				(sel_42 sel_4: 0 sel_3: sel_3 sel_626: self sel_162: End self)
			)
			(2
				(= sel_232 1)
				(sel_42 sel_627: self)
				(= sel_141 (sel_42 sel_3:))
				(= sel_139 (* (sel_42 sel_53:) (- 3 (sel_42 sel_238:))))
			)
			(3
				(if (== (sel_42 sel_3:) sel_141)
					(sel_42 sel_162: Beg self)
				else
					(self sel_111:)
				)
			)
			(4
				(= sel_139 (sel_42 sel_53:))
			)
			(5
				(self sel_111:)
			)
		)
		(localproc_0
			11
			3
			sel_20
			param1
			sel_3
			(sel_42 sel_20:)
			(sel_42 sel_3:)
			(sel_42 sel_4:)
			(if (sel_42 sel_237:)
				((sel_42 sel_237:) sel_20:)
			else
				{none}
			)
		)
	)
)

(instance robOverHit of QSTechnique
	(properties
		sel_20 {robOverHit}
		sel_21 56
		sel_633 1
		sel_3 1
		sel_620 6
		sel_634 24
		sel_635 11
	)
)

(instance robHighHit of QSTechnique
	(properties
		sel_20 {robHighHit}
		sel_21 57
		sel_633 2
		sel_3 2
		sel_620 4
		sel_634 18
		sel_635 23
	)
)

(instance robMidHit of QSTechnique
	(properties
		sel_20 {robMidHit}
		sel_21 54
		sel_633 3
		sel_3 3
		sel_620 3
		sel_634 12
		sel_635 36
	)
)

(instance robLowHit of QSTechnique
	(properties
		sel_20 {robLowHit}
		sel_21 51
		sel_633 4
		sel_3 4
		sel_620 2
		sel_634 6
		sel_635 52
	)
)

(instance robHighBlk of QSTechnique
	(properties
		sel_20 {robHighBlk}
		sel_21 50
		sel_633 5
		sel_3 5
	)
)

(instance robDuck of QSTechnique
	(properties
		sel_20 {robDuck}
		sel_21 55
		sel_633 8
		sel_3 6
	)
)

(instance robMidBlk of QSTechnique
	(properties
		sel_20 {robMidBlk}
		sel_21 52
		sel_633 7
		sel_3 7
	)
)

(instance robJump of QSTechnique
	(properties
		sel_20 {robJump}
		sel_21 49
		sel_633 6
		sel_3 8
	)
)

(instance monk of QSFighter
	(properties
		sel_20 {monk}
		sel_2 124
	)

	(method (sel_627)
		(if (!= global125 1)
			(super sel_627: &rest)
		)
	)

	(method (sel_110 &tmp temp0)
		(if (= temp0 (== sel_616 0))
			(self
				sel_307:
				sel_621: monkOverHead monkHead monkBody monkLegs
				sel_622:
					monkMidHit
					monkLowHit
					monkHighHit
					monkOverHit
					monkMidBlk
					monkHighBlk
					monkDuck
					monkJump
			)
		)
		(self sel_3: 0 sel_162: (Clone RandForward))
		(sel_616 sel_20: {monkParts})
		(sel_617 sel_20: {monkTechs})
		(if temp0
			(super sel_110: &rest)
		)
	)

	(method (sel_624 param1)
		(if (and (== sel_3 6) (== (sel_613 sel_3:) 2))
			(sel_613 sel_3: 3)
		)
		(super sel_624: param1 &rest)
	)
)

(instance monkOverHead of qsPart
	(properties
		sel_20 {monkOverHead}
	)

	(method (sel_209)
		(= sel_6 (- 30 (sel_42 sel_6:)))
		(= sel_8 (sel_42 sel_6:))
		(super sel_209: &rest)
	)
)

(instance monkHead of qsPart
	(properties
		sel_20 {monkHead}
	)

	(method (sel_209)
		(= sel_6 (sel_42 sel_6:))
		(= sel_8 (+ (sel_42 sel_6:) (/ (- (sel_42 sel_8:) (sel_42 sel_6:)) 3)))
		(super sel_209: &rest)
	)
)

(instance monkBody of qsPart
	(properties
		sel_20 {monkBody}
	)

	(method (sel_209)
		(= sel_6 (+ (sel_42 sel_6:) (/ (- (sel_42 sel_8:) (sel_42 sel_6:)) 3)))
		(= sel_8
			(+ (sel_42 sel_6:) (/ (* (- (sel_42 sel_8:) (sel_42 sel_6:)) 2) 3))
		)
		(super sel_209: &rest)
	)
)

(instance monkLegs of qsPart
	(properties
		sel_20 {monkLegs}
	)

	(method (sel_209)
		(= sel_6
			(+ (sel_42 sel_6:) (/ (* (- (sel_42 sel_8:) (sel_42 sel_6:)) 2) 3))
		)
		(= sel_8 (+ 30 (sel_42 sel_8:)))
		(super sel_209: &rest)
	)
)

(instance monkOverHit of QSTechnique
	(properties
		sel_20 {monkOverHit}
		sel_3 1
		sel_620 6
		sel_634 24
		sel_635 11
	)
)

(instance monkHighHit of QSTechnique
	(properties
		sel_20 {monkHighHit}
		sel_3 2
		sel_620 4
		sel_634 18
		sel_635 23
	)
)

(instance monkMidHit of QSTechnique
	(properties
		sel_20 {monkMidHit}
		sel_3 3
		sel_620 3
		sel_634 12
		sel_635 36
	)
)

(instance monkLowHit of QSTechnique
	(properties
		sel_20 {monkLowHit}
		sel_3 4
		sel_620 2
		sel_634 6
		sel_635 52
	)
)

(instance monkHighBlk of QSTechnique
	(properties
		sel_20 {monkHighBlk}
		sel_3 5
	)
)

(instance monkDuck of QSTechnique
	(properties
		sel_20 {monkDuck}
		sel_3 6
	)
)

(instance monkMidBlk of QSTechnique
	(properties
		sel_20 {monkMidBlk}
		sel_3 7
	)
)

(instance monkJump of QSTechnique
	(properties
		sel_20 {monkJump}
		sel_3 8
	)
)


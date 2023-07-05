;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 303)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Interface)
(use LeapTo)
(use RandCycle)
(use Path)
(use Motion)
(use Actor)
(use System)

(public
	dummyPublic0 0
	proc303_1 1
	proc303_2 2
	proc303_3 3
	point1 4
	point2 5
	point3 6
	point4 7
	point5 8
	point6 9
	point7 10
	point8 11
	point9 12
	point10 13
	point11 14
	point12 15
	point13 16
	point14 17
	point15 18
	point16 19
	point17 20
	point18 21
	point19 22
	point20 23
	point21 24
	point22 25
	point23 26
	point24 27
)

(local
	[local0 19] = [39 -2 38 -2 35 -2 33 -2 27 -2 22 -2 18 -2 14 -2 10 -2 -32768]
	[local19 15] = [7 -2 6 -2 5 -2 4 -2 3 -2 2 -2 2 0 -32768]
	local34
)

(procedure (proc303_2 &tmp [temp0 50] temp50 temp51)
	(= temp50 (gSystemWindow sel_25:))
	(= temp51 (gSystemWindow sel_26:))
	(gSystemWindow sel_25: 16 sel_26: 21)
	(proc0_1)
	(if (and (== (global178 sel_31:) 1) (!= global179 2))
		(gSong sel_39: 802 sel_165: -1)
	)
	(Format @global550 399 2 (global303 sel_510:) 303 4) ; "SCORECARD  %10s  %10s"
	(StrCat @global550 (Format @temp0 399 3)) ; "------------------------------------"
	(StrCat
		@global550
		(Format @temp0 399 4 (global303 sel_511:) (global304 sel_511:)) ; "Total Points %10d  %10d"
	)
	(StrCat
		@global550
		(Format @temp0 399 5 (global303 sel_512:) (global304 sel_512:)) ; "Games Won  %10d  %10d"
	)
	(StrCat
		@global550
		(Format @temp0 399 6 (global303 sel_513:) (global304 sel_513:)) ; "Gammons   %10d  %10d"
	)
	(StrCat
		@global550
		(Format @temp0 399 7 (global303 sel_514:) (global304 sel_514:)) ; "Backgammons %10d  %10d"
	)
	(StrCat
		@global550
		(Format @temp0 399 8 (global303 sel_391:) (global304 sel_391:)) ; "Pip Count  %10d  %10d"
	)
	(Print @global550 30 500 67 216 182 gDoAbsCode)
	(gSystemWindow sel_25: temp50 sel_26: temp51)
	(gSong sel_162:)
)

(procedure (proc303_3 &tmp [temp0 2])
	(if global323
		(gTheDiceList sel_119: 461 sel_119: 494 0)
	)
	(= global323 0)
	(= global336 global315)
	(gTheDoubleCube sel_497:)
	(global303 sel_515:)
	(global304 sel_515:)
	(global303 sel_516:)
	(global304 sel_516:)
	(proc0_1)
	(= global305 0)
	(= global325 1)
)

(procedure (proc303_1)
	(switch (Print 303 5 78 { Play Game } 1 78 { Setup Board } 2) ; "Backgammon"
		(1
			(if global338
				(switch (Print 303 6 78 { No } 1 78 { Yes } 2) ; "Show generated moves?"
					(1
						(= global340 0)
					)
					(2
						(= global340 1)
					)
				)
			)
		)
		(2
			(= global337 1)
			(return)
		)
	)
)

(instance dummyPublic0 of Code
	(properties
		sel_20 {dummyPublic0}
	)
)

(class Point of List
	(properties
		sel_20 {Point}
		sel_467 0
		sel_468 0
		sel_469 2
		sel_40 0
		sel_470 0
		sel_471 0
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_472 0
		sel_473 0
		sel_474 0
		sel_475 0
		sel_476 0
		sel_477 0
	)

	(method (sel_110)
		(super sel_110: &rest)
		(= sel_473 sel_86)
		(self sel_437:)
	)

	(method (sel_144 &tmp temp0)
		(if (== (gCurRoom sel_368:) 350)
			(if (Random 0 1)
				(gSound sel_39: 300)
			else
				(gSound sel_39: 301)
			)
		else
			(gSound sel_39: 302)
		)
		(if (>= (= temp0 (self sel_131: global181)) 0)
			(global181
				sel_14: (| (global181 sel_14:) $0810)
				sel_3:
					(+
						(global181 sel_25:)
						(if
							(and
								(!= self (ScriptID 300 1)) ; off1
								(!= self (ScriptID 300 2)) ; off2
							)
							0
						else
							3
						)
					)
				sel_60: (+ 12 (/ temp0 5))
			)
		)
		(global181 sel_53: 3 sel_51: 9 sel_52: 6 sel_283:)
		(= global181 0)
		(if (or (== (global178 sel_31:) 1) global337)
			(proc0_3)
		)
		(gGamePlayScript sel_135: 1)
	)

	(method (sel_480 param1 param2 &tmp temp0 temp1 temp2)
		(gAssocPoint sel_125:)
		(for ((= temp2 0)) (< temp2 sel_86) ((++ temp2))
			(if (!= param2 (= temp0 (self sel_64: temp2)))
				(gAssocPoint sel_118: temp0)
			)
		)
	)

	(method (sel_479 &tmp temp0)
		((= global181 (NodeValue (self sel_126:))) sel_481: self (- sel_86 1))
		(global181 sel_63: 15)
		(if (!= global305 1)
			(= temp0 (* global326 384))
			(if global326
				(global181 sel_296: LeapTo global306 global307 0 self temp0)
			else
				(global181
					sel_51: (* (global181 sel_51:) 2)
					sel_52: (* (global181 sel_52:) 2)
					sel_296: MoveTo global306 global307 self
				)
			)
		else
			(global181
				sel_51: (* (global181 sel_51:) 2)
				sel_52: (* (global181 sel_52:) 2)
				sel_296: MoveTo global306 global307 self
			)
		)
		(if global305
			(-- global305)
		)
	)

	(method (sel_478 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 sel_86) ((++ temp0))
			((= temp1 (self sel_64: temp0)) sel_481: self temp0)
			(temp1 sel_1: global306 sel_0: global307 sel_283:)
			(gACast sel_118: temp1)
		)
	)

	(method (sel_437)
		((KeyMouse sel_414:) sel_118: self)
	)

	(method (sel_132 param1 &tmp temp0)
		(cond
			((== argc 2)
				(= temp0 [param1 1])
				(if
					(and
						(<=
							sel_7
							(>> (+ (temp0 sel_7:) (temp0 sel_9:)) $0001)
							sel_9
						)
						(<=
							sel_6
							(>> (+ (temp0 sel_6:) (temp0 sel_8:)) $0001)
							sel_8
						)
					)
					(param1 sel_73: 1)
					(return self)
				)
			)
			(
				(and
					(<= sel_7 (param1 sel_1:) sel_9)
					(<= sel_6 (param1 sel_0:) sel_8)
				)
				(param1 sel_73: 1)
				(return self)
			)
		)
		(return 0)
	)
)

(class Dies of Actor
	(properties
		sel_20 {Dies}
		sel_223 2
		sel_53 2
		sel_482 0
		sel_483 0
		sel_484 0
		sel_485 0
		sel_486 0
		sel_487 0
		sel_488 0
		sel_489 0
		sel_490 0
		sel_491 0
	)

	(method (sel_497)
		(self
			sel_461:
			sel_494: 1
			sel_63: 12
			sel_53: 2
			sel_223: 2
			sel_153: RandCycle
		)
	)

	(method (sel_498 &tmp temp0)
		(= temp0 (Random 0 1))
		(self
			sel_2: 301
			sel_285:
			sel_63: 15
			sel_165: temp0
			sel_4: 0
			sel_489: -1
			sel_282:
				(-
					(+
						(Random sel_486 sel_488)
						(if (== global178 global303) 112 else 0)
					)
				)
				(Random sel_485 sel_487)
			sel_300:
			sel_296: Roll1 self
		)
	)

	(method (sel_144)
		(switch (++ sel_489)
			(0
				(self sel_296: Roll2 self)
			)
			(1
				(if (== self gTheDice2)
					(gTheDice1 sel_495:)
					(gTheDice2 sel_495:)
					(if (== (global178 sel_31:) 1)
						(proc0_3)
					)
					(gSound sel_99: 1)
					(local34 sel_144:)
				)
			)
		)
	)

	(method (sel_110)
		(self sel_2: 302 sel_287: sel_298: sel_300: sel_306: 50 50 sel_285:)
		(= sel_490 sel_1)
		(= sel_491 sel_0)
		(super sel_110: &rest)
	)

	(method (sel_492)
		(= sel_482 (Random 1 6))
	)

	(method (sel_493)
		(= sel_483 (= sel_484 0))
	)

	(method (sel_496 param1)
		(if param1
			(= sel_3 (+ (* (- sel_482 1) 2) (Random 0 1)))
		else
			(= sel_3 (+ (* (- sel_482 1) 2) (mod sel_3 2)))
		)
		(= sel_4 (- (NumCels self) 1))
	)

	(method (sel_461)
		(self sel_2: 302 sel_165: (+ 12 (mod sel_3 2)) sel_4: (- sel_482 1))
	)

	(method (sel_494 param1)
		(self sel_499:)
		(if param1
			(proc0_1)
		)
		(self sel_283:)
	)

	(method (sel_495)
		(self sel_63: 12 sel_153: 0 sel_283:)
	)

	(method (sel_499)
		(if (or (== self gTheDice1) (== self gTheDice2))
			(if (== global332 global178)
				(self
					sel_282:
						sel_490
						(if (== self gTheDice2)
							(gTheDice1 sel_491:)
						else
							(gTheDice2 sel_491:)
						)
				)
			else
				(self sel_282: sel_490 sel_491)
			)
		)
	)
)

(class DieList of List
	(properties
		sel_20 {DieList}
		sel_500 1
		sel_501 0
	)

	(method (sel_508 param1 param2 &tmp temp0)
		(if (not sel_500)
			((self sel_64: param1) sel_461: sel_494: param2)
		else
			((= temp0 (self sel_64: (>> param1 $0001))) sel_461:)
			(if (mod sel_501 2)
				(temp0 sel_494: param2)
			)
		)
		(++ sel_501)
	)

	(method (sel_509)
		(self sel_501: sel_86 sel_119: 461 sel_119: 494 1)
	)

	(method (sel_507 &tmp temp0)
		(for ((= temp0 0)) (< temp0 sel_86) ((++ temp0))
			((self sel_64: temp0) sel_493:)
		)
	)

	(method (sel_504 param1 &tmp [temp0 3])
		(= sel_501 0)
		(if sel_500
			(self sel_81: gTheDice3 gTheDice4)
		)
		(if (and (== (NodeValue (self sel_124:)) gTheDice2) (not global339))
			(self sel_81: gTheDice2 sel_118: gTheDice2)
		)
		(if (not global339)
			(self sel_119: 493)
			(if (not argc)
				(self sel_119: 492)
			else
				(gTheDice1 sel_482: [param1 0])
				(gTheDice2 sel_482: [param1 0])
			)
		)
		(if global338
			(Format @temp0 303 0 (gTheDice1 sel_482:)) ; "%d"
			(Print 303 1 38 @temp0 2) ; "Die 1"
			(gTheDice1 sel_482: (ReadNumber @temp0))
			(Format @temp0 303 0 (gTheDice2 sel_482:)) ; "%d"
			(Print 303 2 38 @temp0 2) ; "Die 2"
			(gTheDice2 sel_482: (ReadNumber @temp0))
		)
		(= sel_500 (== (gTheDice1 sel_482:) (gTheDice2 sel_482:)))
	)

	(method (sel_505 &tmp temp0)
		(if (< (gTheDice1 sel_482:) (gTheDice2 sel_482:))
			(= temp0 (gTheDice1 sel_482:))
			(gTheDice1 sel_482: (gTheDice2 sel_482:))
			(gTheDice2 sel_482: temp0)
		)
	)

	(method (sel_502 param1 &tmp temp0 temp1)
		(proc0_4)
		(if (not global339)
			(if (> argc 1)
				(self sel_504: &rest)
			else
				(self sel_504:)
			)
		)
		(if sel_500
			(self sel_118: gTheDice3 gTheDice4)
			(gTheDice3 sel_493: sel_482: (= temp0 (gTheDice1 sel_482:)))
			(gTheDice4 sel_493: sel_482: temp0)
		else
			(self sel_505:)
		)
		(= local34 param1)
		(gSound sel_39: 504 sel_165: 1 sel_99: 0)
		(for ((= temp1 0)) (< temp1 2) ((++ temp1))
			((gTheDiceList sel_64: temp1) sel_498:)
		)
		(= temp0 (Random 2 6))
		(while (-- temp0)
			(gTheDice1 sel_57:)
			(proc0_1)
		)
	)

	(method (sel_503 param1 &tmp temp0 temp1 temp2)
		(= temp1 (>> argc $0001))
		(for ((= temp2 (= temp0 0))) (< temp2 temp1) ((++ temp2))
			(+=
				temp0
				(- ([param1 temp2] sel_40:) ([param1 (+ temp1 temp2)] sel_40:))
			)
		)
		(return temp0)
	)

	(method (sel_506 &tmp temp0)
		(self sel_119: 110)
		(proc0_1)
		(proc0_4)
		(repeat
			(self sel_504:)
			(if (or (not sel_500) global338)
				(break)
			)
		)
		(self sel_119: 497)
		(if (and sel_500 global338)
			(self sel_118: gTheDice3 gTheDice4)
			(gTheDice3 sel_493: sel_482: (gTheDice1 sel_482:))
			(gTheDice4 sel_493: sel_482: (gTheDice1 sel_482:))
			(switch (Print 303 3 78 {Player 1} 1 78 {Player 2} 2) ; "Current Player :"
				(1
					(= global178 global303)
				)
				(2
					(= global178 global304)
				)
			)
		)
		(if (not sel_500)
			(= global178
				(if (> (gTheDice1 sel_482:) (gTheDice2 sel_482:))
					global303
				else
					global304
				)
			)
		)
		(if (not global337)
			(= temp0 90)
			(gSound sel_39: 303 sel_165: -1)
			(while (-- temp0)
				(= gGameTime (+ gTickOffset (GetTime)))
				(Wait 1)
				(Animate (self sel_24:) 1)
				(Random 1 6)
			)
			(gSound sel_165: 1 sel_159:)
		)
		(self sel_505:)
		(gTheDice1 sel_499:)
		(gTheDice2 sel_499:)
		(self sel_119: 496 1 sel_119: 495)
		(proc0_1)
		(proc0_3)
		(gTheArrow sel_110:)
		(if (!= global179 2)
			(if (== (global178 sel_31:) 2)
				(gChar1 sel_446: (Random 0 2) 0 443 1)
			else
				(gChar1 sel_446: (Random 3 5) 0 445 1)
			)
		else
			(Print (Format @global550 399 1 (global178 sel_510:))) ; "%s wins the dice roll."
		)
		(if (and (not global337) (== (global178 sel_31:) 2))
			(proc0_4 981)
		)
	)
)

(class Roll1 of RelPath
	(properties
		sel_20 {Roll1}
	)

	(method (sel_64 param1)
		(return [local0 param1])
	)

	(method (sel_57)
		(if (super sel_57:)
			(sel_42 sel_4: (+ (sel_42 sel_4:) 1))
		)
	)
)

(class Roll2 of RelPath
	(properties
		sel_20 {Roll2}
	)

	(method (sel_64 param1)
		(return [local19 param1])
	)

	(method (sel_57)
		(if (super sel_57:)
			(if (!= (sel_42 sel_2:) 302)
				(sel_42
					sel_2: 302
					sel_4: -1
					sel_3: (- (* (sel_42 sel_482:) 2) (+ (sel_42 sel_3:) 1))
				)
			)
			(sel_42 sel_4: (+ (sel_42 sel_4:) 1))
			(if (> (sel_42 sel_4:) (sel_42 sel_225:))
				(sel_42 sel_4: (sel_42 sel_225:))
			)
		)
	)
)

(class DiceCup of TrackingView
	(properties
		sel_20 {DiceCup}
		sel_1 20
		sel_0 111
		sel_2 300
		sel_3 5
	)

	(method (sel_110)
		(self sel_283: sel_287: sel_63: 11)
		(super sel_110: &rest)
		(self sel_437:)
		(= sel_450 gTheDiceList)
	)

	(method (sel_132 param1)
		(if (super sel_132: param1)
			(self sel_283:)
			(if (== (global178 sel_31:) 2)
				(return 0)
			)
			(if (!= (gTheDiceList sel_501:) (gTheDiceList sel_86:))
				(gSound sel_39: 905)
				(gChar1 sel_446: (Random 6 8) -32768)
				(return 0)
			)
			(param1 sel_73: 1)
			(proc0_4)
			(gTheDiceList sel_502: gGamePlayScript)
		)
		(return (param1 sel_73:))
	)

	(method (sel_437)
		((KeyMouse sel_414:) sel_118: self)
	)
)

(class DoubleCube of TrackingView
	(properties
		sel_20 {DoubleCube}
		sel_2 300
		sel_469 0
		sel_74 1
		sel_517 1
		sel_518 0
	)

	(method (sel_523)
		(if sel_517
			(= sel_517 0)
			(self sel_102: sel_438:)
		else
			(= sel_517 1)
			(self sel_198: sel_437:)
		)
		(proc0_1)
	)

	(method (sel_497)
		(self
			sel_3: 6
			sel_282: 300 109
			sel_469: 0
			sel_518: 0
			sel_74: 1
			sel_283:
			sel_287:
			sel_63: 11
		)
	)

	(method (sel_110)
		(super sel_110: &rest)
		(self sel_497:)
		(= sel_517 global324)
		(if (not sel_517)
			(self sel_102:)
		)
		(self sel_437:)
	)

	(method (sel_520 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= global327
			(/
				(*
					(= temp0
						(-
							((= temp1 (global178 sel_524:)) sel_391:)
							(global178 sel_391:)
						)
					)
					100
				)
				(temp1 sel_391:)
			)
		)
		(if (or (== sel_3 12) (not sel_517) (== sel_469 global178))
			(return)
		)
		(= temp2 (>> (+ global329 1) $0001))
		(= temp3 (>> (+ (- 15 ((global178 sel_525:) sel_86:)) 1) $0001))
		(for ((= temp7 1)) (< temp7 6) ((++ temp7))
			(if
				(and
					((= temp6 (global178 sel_64: temp7)) sel_468:)
					(== (temp6 sel_469:) (global178 sel_526:))
				)
				(++ temp5) ; UNINIT
			)
		)
		(= temp4
			(cond
				((not sel_518)
					(if (<= global327 25)
						(or
							(and
								(< (global178 sel_391:) 100)
								(== sel_469 0)
								(or (>= temp0 30) (>= global327 8))
								(== sel_469 temp1)
								(or (>= temp0 37) (>= global327 10))
							)
							(and (!= sel_469 global178) (>= temp0 15))
						)
					)
				)
				((and (<= global327 25) (== sel_469 temp1))
					(or (>= temp0 37) (>= global327 20))
				)
			)
		)
		(if
			(and
				(or
					(and (or global331 global330) temp4)
					(and
						(== (global178 sel_527:) 2)
						(not global322)
						(or
							global331
							(>= temp3 (>> (+ (- 15 global334) 1) $0001))
						)
						(or (< temp3 temp2) (and temp4 (== temp3 temp2)))
					)
				)
				(or
					(!= (global178 sel_527:) 2)
					(and
						global322
						(not
							(or
								(and
									(>= (temp1 sel_528:) 6)
									(or
										(< (global178 sel_528:) 6)
										(>=
											(- 25 (temp1 sel_529:))
											(global178 sel_529:)
										)
									)
								)
								(and
									((global178 sel_530:) sel_86:)
									(>= global334 3)
								)
							)
						)
						(or
							(< (global178 sel_391:) 110)
							(>= (global178 sel_528:) 3)
						)
					)
				)
				(or
					global331
					global330
					(not
						(and
							(== (global178 sel_527:) 2)
							(not global322)
							(>=
								((global178 sel_531:) sel_86:)
								(- ((temp1 sel_531:) sel_86:) 1)
							)
							(== temp3 temp2)
						)
					)
				)
			)
			(self sel_436:)
			(self sel_519:)
		)
	)

	(method (sel_522)
		(self
			sel_518: sel_469
			sel_282: 21 (if (== (= sel_469 global178) global303) 84 else 160)
			sel_3: (+ sel_3 1)
			sel_74: (* sel_74 2)
		)
		(proc0_1)
	)

	(method (sel_521)
		(proc0_4)
		(gTheDiceList sel_501: (gTheDiceList sel_86:))
		(global178 sel_391: 0)
		(= global323 1)
		(gGamePlayScript sel_29: 2 sel_135: 1)
	)

	(method (sel_519 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 [temp10 10] [temp20 10] temp30)
		(if (!= ((= temp2 (global178 sel_524:)) sel_31:) 2)
			(gChar1 sel_446: (Random 12 14) 0 443 2)
			(switch
				(Print
					(Format @global550 399 9 (temp2 sel_510:)) ; "%s, do you accept the double?"
					78
					(Format @temp10 399 26) ; "Yes"
					1
					78
					(Format @temp20 399 27) ; "No"
					2
					182
					gDoAbsCode
				)
				(1
					(self sel_522:)
					(return 1)
				)
				(2
					(self sel_521:)
					(return 0)
				)
			)
		else
			(= temp0
				(/
					(* (= temp1 (- (global178 sel_391:) (temp2 sel_391:))) 100)
					(temp2 sel_391:)
				)
			)
			(= temp3 (>> (+ global329 1) $0001))
			(= temp4 (>> (+ (- 15 ((global178 sel_525:) sel_86:)) 1) $0001))
			(= temp6 (= temp7 0))
			(for ((= temp30 1)) (< temp30 6) ((++ temp30))
				(cond
					((not (global178 sel_532: temp30))
						(++ temp6)
					)
					(((global178 sel_64: temp30) sel_468:)
						(++ temp7)
					)
				)
			)
			(for ((= temp30 1)) (< temp30 25) ((++ temp30))
				(if
					(and
						(==
							((= temp8 (temp2 sel_64: temp30)) sel_469:)
							(global178 sel_526:)
						)
						(temp8 sel_467:)
						(> (temp8 sel_476:) 6)
					)
					(++ temp9) ; UNINIT
				)
			)
			(if
				(and
					(= temp5
						(or
							(and (not global322) (>= temp1 -56) (>= temp0 -15))
							(and global322 (>= temp1 -94) (>= temp0 -25))
						)
					)
					(or
						global322
						(and
							(<= (- temp3 (/ temp3 6)) temp4)
							(or (> temp3 1) (> (temp2 sel_391:) 6))
						)
					)
					(not
						(and
							((global178 sel_533:) sel_86:)
							(>= temp7 3)
							(not temp6)
							temp9 ; UNINIT
						)
					)
				)
				(gChar1 sel_446: (Random 15 17) 0 443 1)
				(self sel_522:)
				(return 1)
			else
				(gChar1 sel_446: (Random 18 20) 0 445 -32768)
				(self sel_521:)
				(return 0)
			)
		)
	)

	(method (sel_132 param1 &tmp [temp0 10] [temp10 10])
		(if (and (== (global178 sel_31:) 1) (super sel_132: param1))
			(if (not sel_517)
				(return 0)
			)
			(self sel_283:)
			(if (!= sel_469 global178)
				(if (!= (gTheDiceList sel_501:) (gTheDiceList sel_86:))
					(gSound sel_39: 905)
					(gChar1 sel_446: (Random 24 26) -32768)
					(return 0)
				)
			else
				(gSound sel_39: 905)
				(gChar1 sel_446: (Random 21 23) -32768)
				(return 0)
			)
			(if (== sel_3 12)
				(gSound sel_39: 905)
				(gChar1 sel_446: (Random 27 29) -32768)
				(return 0)
			)
			(param1 sel_73: 1)
			(switch
				(Print
					(Format @global550 399 10 (global178 sel_510:)) ; "%s, do you want to Double?"
					78
					(Format @temp0 399 26) ; "Yes"
					1
					78
					(Format @temp10 399 27) ; "No"
					2
					64
					-1
					(if (== global179 2)
						(if (== global178 global303) 160 else 10)
					else
						160
					)
					182
					gDoAbsCode
				)
				(1
					(self sel_519:)
				)
			)
		)
		(return (param1 sel_73:))
	)

	(method (sel_437)
		((KeyMouse sel_414:) sel_118: self)
	)

	(method (sel_438)
		((KeyMouse sel_414:) sel_81: self)
	)
)

(instance point1 of Point
	(properties
		sel_20 {point1}
		sel_6 104
		sel_7 256
		sel_8 188
		sel_9 271
		sel_472 -1
	)
)

(instance point2 of Point
	(properties
		sel_20 {point2}
		sel_6 104
		sel_7 240
		sel_8 188
		sel_9 255
		sel_472 -1
	)
)

(instance point3 of Point
	(properties
		sel_20 {point3}
		sel_6 104
		sel_7 224
		sel_8 188
		sel_9 239
		sel_472 -1
	)
)

(instance point4 of Point
	(properties
		sel_20 {point4}
		sel_6 104
		sel_7 208
		sel_8 188
		sel_9 223
		sel_472 -1
	)
)

(instance point5 of Point
	(properties
		sel_20 {point5}
		sel_6 104
		sel_7 192
		sel_8 188
		sel_9 207
		sel_472 -1
	)
)

(instance point6 of Point
	(properties
		sel_20 {point6}
		sel_6 104
		sel_7 176
		sel_8 188
		sel_9 191
		sel_472 -1
	)
)

(instance point7 of Point
	(properties
		sel_20 {point7}
		sel_6 104
		sel_7 143
		sel_8 188
		sel_9 157
		sel_472 -1
	)
)

(instance point8 of Point
	(properties
		sel_20 {point8}
		sel_6 104
		sel_7 127
		sel_8 188
		sel_9 142
		sel_472 -1
	)
)

(instance point9 of Point
	(properties
		sel_20 {point9}
		sel_6 104
		sel_7 111
		sel_8 188
		sel_9 126
		sel_472 -1
	)
)

(instance point10 of Point
	(properties
		sel_20 {point10}
		sel_6 104
		sel_7 95
		sel_8 188
		sel_9 110
		sel_472 -1
	)
)

(instance point11 of Point
	(properties
		sel_20 {point11}
		sel_6 104
		sel_7 79
		sel_8 188
		sel_9 94
		sel_472 -1
	)
)

(instance point12 of Point
	(properties
		sel_20 {point12}
		sel_6 104
		sel_7 63
		sel_8 188
		sel_9 78
		sel_472 -1
	)
)

(instance point13 of Point
	(properties
		sel_20 {point13}
		sel_6 5
		sel_7 63
		sel_8 89
		sel_9 78
		sel_472 1
	)
)

(instance point14 of Point
	(properties
		sel_20 {point14}
		sel_6 5
		sel_7 79
		sel_8 89
		sel_9 94
		sel_472 1
	)
)

(instance point15 of Point
	(properties
		sel_20 {point15}
		sel_6 5
		sel_7 95
		sel_8 89
		sel_9 110
		sel_472 1
	)
)

(instance point16 of Point
	(properties
		sel_20 {point16}
		sel_6 5
		sel_7 111
		sel_8 89
		sel_9 126
		sel_472 1
	)
)

(instance point17 of Point
	(properties
		sel_20 {point17}
		sel_6 5
		sel_7 127
		sel_8 89
		sel_9 142
		sel_472 1
	)
)

(instance point18 of Point
	(properties
		sel_20 {point18}
		sel_6 5
		sel_7 143
		sel_8 89
		sel_9 157
		sel_472 1
	)
)

(instance point19 of Point
	(properties
		sel_20 {point19}
		sel_6 5
		sel_7 176
		sel_8 89
		sel_9 191
		sel_472 1
	)
)

(instance point20 of Point
	(properties
		sel_20 {point20}
		sel_6 5
		sel_7 192
		sel_8 89
		sel_9 207
		sel_472 1
	)
)

(instance point21 of Point
	(properties
		sel_20 {point21}
		sel_6 5
		sel_7 208
		sel_8 89
		sel_9 223
		sel_472 1
	)
)

(instance point22 of Point
	(properties
		sel_20 {point22}
		sel_6 5
		sel_7 224
		sel_8 89
		sel_9 239
		sel_472 1
	)
)

(instance point23 of Point
	(properties
		sel_20 {point23}
		sel_6 5
		sel_7 240
		sel_8 89
		sel_9 255
		sel_472 1
	)
)

(instance point24 of Point
	(properties
		sel_20 {point24}
		sel_6 5
		sel_7 256
		sel_8 89
		sel_9 271
		sel_472 1
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Interface)
(use BGPlayer)
(use LeapTo)
(use dummyPublic0)
(use RandCycle)
(use Path)
(use File)
(use Game)
(use Actor)
(use System)

(public
	backgam 0
	off1 1
	off2 2
)

(instance backgam of Rm
	(properties
		sel_20 {backgam}
		sel_28 10
	)

	(method (sel_110 &tmp temp0)
		((= gBackgam_opt backgam_opt) sel_57:)
		(= sel_368 global317)
		(if (gChar1 sel_441:)
			(gChar1 sel_282: 29 36 sel_198: sel_110:)
			(Load rsTEXT (+ (* (+ (gChar1 sel_2:) 1) 1000) global187))
		else
			(Load rsTEXT 19300)
		)
		(Characters sel_110:)
		(super sel_110: &rest)
		(gSong sel_162:)
		(Load rsVIEW 300)
		(Load rsVIEW 310)
		(Load rsSOUND 906)
		(Load rsSOUND 504)
		(Load rsSOUND 303)
		(Load rsSOUND 300)
		(Load rsSOUND 301)
		(Load rsSOUND 302)
		(Load rsSOUND 905)
		(Load rsSOUND 909)
		(Load rsSOUND 914)
		(Load rsSOUND 915)
		(Load rsSOUND 904)
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(Load rsVIEW (+ 983 temp0))
		)
		(ScriptID 310) ; thebgCode
		LeapTo
		RandCycle
		Path
		(= gACast aCast)
		((= gTheBar1 theBar1)
			sel_118:
				stone1
				stone2
				stone3
				stone4
				stone5
				stone6
				stone7
				stone8
				stone9
				stone10
				stone11
				stone12
				stone13
				stone14
				stone15
		)
		((= gTheBar2 theBar2)
			sel_118:
				stone16
				stone17
				stone18
				stone19
				stone20
				stone21
				stone22
				stone23
				stone24
				stone25
				stone26
				stone27
				stone28
				stone29
				stone30
		)
		(= global303 theBGPlayer1)
		(= global304 theBGPlayer2)
		(if (and (== (global303 sel_31:) 2) (== global179 1))
			(= global303 theBGPlayer2)
			(= global304 theBGPlayer1)
		)
		(global303 sel_527: global190 sel_31: global194 sel_510: @global150)
		(global304 sel_527: global191 sel_31: global195 sel_510: @global157)
		(= global332 (if (== (global303 sel_31:) 1) global303 else global304))
		(= gGamePlayScript gamePlayScript)
		(= gTheArrow theArrow)
		(if (!= global179 2)
			(= global315 0)
		)
		(= gAllStonesObj allStonesObj)
		((= gAssocPoint assocPoint))
		(= global319 0)
		((= gTheDice3 theDice3) sel_102:)
		((= gTheDice4 theDice4) sel_102:)
		(global303
			sel_118:
				off1
				(ScriptID 303 4) ; point1
				(ScriptID 303 5) ; point2
				(ScriptID 303 6) ; point3
				(ScriptID 303 7) ; point4
				(ScriptID 303 8) ; point5
				(ScriptID 303 9) ; point6
				(ScriptID 303 10) ; point7
				(ScriptID 303 11) ; point8
				(ScriptID 303 12) ; point9
				(ScriptID 303 13) ; point10
				(ScriptID 303 14) ; point11
				(ScriptID 303 15) ; point12
				(ScriptID 303 16) ; point13
				(ScriptID 303 17) ; point14
				(ScriptID 303 18) ; point15
				(ScriptID 303 19) ; point16
				(ScriptID 303 20) ; point17
				(ScriptID 303 21) ; point18
				(ScriptID 303 22) ; point19
				(ScriptID 303 23) ; point20
				(ScriptID 303 24) ; point21
				(ScriptID 303 25) ; point22
				(ScriptID 303 26) ; point23
				(ScriptID 303 27) ; point24
				gTheBar1
			sel_110:
		)
		(global304
			sel_118:
				off2
				(ScriptID 303 27) ; point24
				(ScriptID 303 26) ; point23
				(ScriptID 303 25) ; point22
				(ScriptID 303 24) ; point21
				(ScriptID 303 23) ; point20
				(ScriptID 303 22) ; point19
				(ScriptID 303 21) ; point18
				(ScriptID 303 20) ; point17
				(ScriptID 303 19) ; point16
				(ScriptID 303 18) ; point15
				(ScriptID 303 17) ; point14
				(ScriptID 303 16) ; point13
				(ScriptID 303 15) ; point12
				(ScriptID 303 14) ; point11
				(ScriptID 303 13) ; point10
				(ScriptID 303 12) ; point9
				(ScriptID 303 11) ; point8
				(ScriptID 303 10) ; point7
				(ScriptID 303 9) ; point6
				(ScriptID 303 8) ; point5
				(ScriptID 303 7) ; point4
				(ScriptID 303 6) ; point3
				(ScriptID 303 5) ; point2
				(ScriptID 303 4) ; point1
				gTheBar2
			sel_110:
		)
		((= gThePoints thePoints)
			sel_118:
				off1
				off2
				(ScriptID 303 4) ; point1
				(ScriptID 303 5) ; point2
				(ScriptID 303 6) ; point3
				(ScriptID 303 7) ; point4
				(ScriptID 303 8) ; point5
				(ScriptID 303 9) ; point6
				(ScriptID 303 10) ; point7
				(ScriptID 303 11) ; point8
				(ScriptID 303 12) ; point9
				(ScriptID 303 13) ; point10
				(ScriptID 303 14) ; point11
				(ScriptID 303 15) ; point12
				(ScriptID 303 16) ; point13
				(ScriptID 303 17) ; point14
				(ScriptID 303 18) ; point15
				(ScriptID 303 19) ; point16
				(ScriptID 303 20) ; point17
				(ScriptID 303 21) ; point18
				(ScriptID 303 22) ; point19
				(ScriptID 303 23) ; point20
				(ScriptID 303 24) ; point21
				(ScriptID 303 25) ; point22
				(ScriptID 303 26) ; point23
				(ScriptID 303 27) ; point24
				gTheBar1
				gTheBar2
		)
		((= gTheDiceList theDiceList) sel_110:)
		((= gTheDoubleCube theDoubleCube) sel_110:)
		((= gTheDiceCup theDiceCup) sel_110:)
		(proc303_3)
		(gTheDiceList
			sel_118:
				(= gTheDice1 theDice1)
				(= gTheDice2 theDice2)
				gTheDice3
				gTheDice4
			sel_506:
		)
		(if (not global337)
			(self sel_145: gGamePlayScript)
		)
	)

	(method (sel_132 param1)
		(if
			(or
				(& (param1 sel_31:) $0002)
				(and (& (param1 sel_31:) $0004) (== (param1 sel_37:) 27))
			)
			(return)
		)
		(if (not (param1 sel_73:))
			(global178 sel_132: param1)
			(gTheDiceCup sel_132: param1)
			(gTheDoubleCube sel_132: param1)
		)
	)

	(method (sel_57 &tmp temp0)
		(super sel_57: &rest)
		(Random 0 99)
		(if (!= global317 sel_368)
			(Print 300 0) ; "This option is only available in the original Hoyles III Game. To pick up a copy of Hoyles III, call Sierra On-Line at (209) 683-4468."
			(= sel_368 global317)
		)
		(if (!= (gTheDoubleCube sel_517:) global324)
			(gTheDoubleCube sel_523:)
		)
	)

	(method (sel_111)
		(= global181 0)
		((global303 sel_531:) sel_119: 125 sel_111:)
		(global303 sel_119: 125 sel_111:)
		((global304 sel_531:) sel_119: 125 sel_111:)
		(global304 sel_119: 125 sel_111:)
		(gAllStonesObj sel_111:)
		(gThePoints sel_111:)
		(gAssocPoint sel_111:)
		(gTheDiceList sel_119: 111 sel_119: 81 sel_111:)
		(KeyMouse sel_125:)
		(gTheDice3 sel_111:)
		(gTheDice4 sel_111:)
		(gTheDiceCup sel_111:)
		(gSound sel_165: 1 sel_99: 1)
		(aCast sel_125: sel_111:)
		(DisposeScript 301)
		(DisposeScript 303)
		(DisposeScript 302)
		(DisposeScript 310)
		(DisposeScript 941)
		(DisposeScript 983)
		(DisposeScript 9)
		(super sel_111:)
	)
)

(class Stone of DragableActor
	(properties
		sel_20 {Stone}
		sel_52 6
		sel_2 300
		sel_15 0
		sel_51 9
		sel_452 300
		sel_453 0
		sel_454 1
		sel_25 2
	)

	(method (sel_110)
		(super sel_110: &rest)
		(= sel_453 sel_25)
		(= sel_458 associatedCode)
		(self sel_165: sel_25 sel_283: sel_286: sel_298: sel_287:)
	)

	(method (sel_481 param1 param2 &tmp temp0)
		(if (and (!= param1 off1) (!= param1 off2))
			(self
				sel_14: (| sel_14 $0010)
				sel_60: (+ 12 (= temp0 (/ param2 5)))
				sel_3: sel_25
			)
			(= global306 (+ (param1 sel_7:) 7))
			(= global307
				(if (< (param1 sel_472:) 0)
					(-
						(- (- (param1 sel_8:) 15) (* (mod param2 5) 13))
						(* temp0 3)
					)
				else
					(- (+ (param1 sel_6:) (* (mod param2 5) 13) 16) (* temp0 3))
				)
			)
		else
			(= global306 (- (param1 sel_9:) 13))
			(= global307 (+ (param1 sel_6:) (* param2 4) 10))
			(self sel_63: 12)
		)
	)
)

(instance gamePlayScript of Script
	(properties
		sel_20 {gamePlayScript}
	)

	(method (sel_143 param1 &tmp [temp0 4])
		(switch (= sel_29 param1)
			(0
				(if (and (not (HaveMouse)) (== (global178 sel_31:) 1))
					(KeyMouse sel_191: gTheDiceCup)
				)
				(global178 sel_537:)
				(if (global178 sel_536: 0)
					(proc0_1)
					(if (== global179 1)
						(proc0_4)
					)
					(gSound sel_39: 909)
					(cond
						((== (global178 sel_31:) 2)
							(gChar1
								sel_446: (Format @global550 399 21) 0 445 -32768 ; "I have no possible moves and must pass."
							)
						)
						((== global179 2)
							(gChar1
								sel_446:
									(Format ; "%s has no possible moves and must pass."
										@global550
										399
										24
										(global178 sel_510:)
									)
									-32768
							)
						)
						(else
							(gChar1
								sel_446:
									(Format ; "%s, you have no possible moves and must pass."
										@global550
										399
										25
										(global178 sel_510:)
									)
									0
									444
									2
							)
						)
					)
					(global178 sel_551:)
					(= sel_29 -1)
				else
					(proc0_6)
					(if (== (global178 sel_31:) 2)
						(gTheDoubleCube sel_520:)
					)
					(global178 sel_549:)
				)
				(= sel_135 1)
			)
			(1
				(if
					(or
						global337
						sel_140
						(and global319 (== (global178 sel_31:) 2))
					)
					(gTheDiceCup sel_436:)
					(if sel_140
						(gTheDiceList sel_502: self sel_140)
					else
						(gTheDiceList sel_502: self)
					)
				else
					(= global319 1)
					(= sel_135 1)
				)
			)
			(2
				(cond
					((== (global178 sel_31:) 2)
						(proc0_4 981)
						(if (and (not global336) global325)
							(global178 sel_555:)
						else
							(global178 sel_543:)
						)
						(= sel_135 1)
					)
					(global325
						(= global325 0)
					)
				)
			)
			(3
				(cond
					(global305
						(-- sel_29)
						(proc0_4)
						(if (== (global178 sel_31:) 1)
							(gSound sel_39: 914)
							(if (Random 0 5)
								(gChar1 sel_445:)
							else
								(gChar1 sel_446: (Random 51 53))
							)
						else
							(gSound sel_39: 915)
							(if (Random 0 5)
								(gChar1 sel_443:)
							else
								(gChar1 sel_446: (Random 54 56))
							)
						)
						((global178 sel_533:) sel_479:)
					)
					((== (gTheDiceList sel_501:) (gTheDiceList sel_86:))
						(if (global178 sel_391:)
							(if (not sel_140)
								(if
									(or
										(not global336)
										(!= (gTheDice1 sel_482:) 2)
										(!= (gTheDice2 sel_482:) 1)
									)
									(global178 sel_551:)
								else
									(repeat
										(StrCpy @temp0 {})
										(Print 399 0 38 @temp0 2) ; "Which doubles do you want?"
										(= sel_140 (ReadNumber @temp0))
										(if (<= 1 sel_140 6)
											(break)
										)
									)
								)
							else
								(if (> sel_140 0)
									(gChar1 sel_446: (Random 60 62) -32768)
								else
									(global178 sel_551:)
								)
								(= sel_140 0)
							)
							(= sel_29 -1)
							(= sel_135 1)
						else
							(global178 sel_557:)
						)
					)
					(else
						(-- sel_29)
						(cond
							((== (global178 sel_31:) 2)
								(global178 sel_562:)
							)
							((global178 sel_391:)
								(if (not (global178 sel_553:))
									(if (not (gTheDiceList sel_501:))
										(Wait 50)
									)
									(proc0_1)
									(gSound sel_39: 909)
									(gChar1
										sel_446: (Random 48 50) -32768 444 1
									)
									(gTheDiceList sel_509:)
									(if global336
										(= sel_140 -1)
									)
									(= sel_135 1)
								)
							)
							(else
								(gTheDiceList sel_501: (gTheDiceList sel_86:))
								(= sel_135 1)
							)
						)
					)
				)
			)
			(4
				(Animate (gCast sel_24:) 1)
				(= sel_135 1)
			)
			(5
				(proc303_2)
				(= global323 1)
				(proc303_3)
				(global178 sel_551:)
				(gSong sel_162:)
				(= sel_29 -1)
				(= sel_135 1)
			)
		)
	)
)

(instance theDice1 of Dies
	(properties
		sel_20 {theDice1}
		sel_1 19
		sel_0 110
		sel_485 128
		sel_486 33
		sel_487 136
		sel_488 45
	)
)

(instance theDice2 of Dies
	(properties
		sel_20 {theDice2}
		sel_1 19
		sel_0 128
		sel_485 133
		sel_486 63
		sel_487 141
		sel_488 75
	)
)

(instance theDice3 of Dies
	(properties
		sel_20 {theDice3}
	)
)

(instance theDice4 of Dies
	(properties
		sel_20 {theDice4}
	)
)

(instance theDiceList of DieList
	(properties
		sel_20 {theDiceList}
	)
)

(instance off1 of Point
	(properties
		sel_20 {off1}
		sel_6 118
		sel_7 286
		sel_8 194
		sel_9 315
		sel_472 1
	)
)

(instance off2 of Point
	(properties
		sel_20 {off2}
		sel_6 7
		sel_7 285
		sel_8 83
		sel_9 314
		sel_472 1
	)
)

(instance theBar1 of Point
	(properties
		sel_20 {theBar1}
		sel_6 105
		sel_7 158
		sel_8 188
		sel_9 175
		sel_472 1
	)
)

(instance theBar2 of Point
	(properties
		sel_20 {theBar2}
		sel_6 5
		sel_7 158
		sel_8 88
		sel_9 175
		sel_472 -1
	)
)

(instance allStonesObj of Point
	(properties
		sel_20 {allStonesObj}
	)
)

(instance assocPoint of Point
	(properties
		sel_20 {assocPoint}
	)
)

(instance stone1 of Stone
	(properties
		sel_20 {stone1}
	)
)

(instance stone2 of Stone
	(properties
		sel_20 {stone2}
	)
)

(instance stone3 of Stone
	(properties
		sel_20 {stone3}
	)
)

(instance stone4 of Stone
	(properties
		sel_20 {stone4}
	)
)

(instance stone5 of Stone
	(properties
		sel_20 {stone5}
	)
)

(instance stone6 of Stone
	(properties
		sel_20 {stone6}
	)
)

(instance stone7 of Stone
	(properties
		sel_20 {stone7}
	)
)

(instance stone8 of Stone
	(properties
		sel_20 {stone8}
	)
)

(instance stone9 of Stone
	(properties
		sel_20 {stone9}
	)
)

(instance stone10 of Stone
	(properties
		sel_20 {stone10}
	)
)

(instance stone11 of Stone
	(properties
		sel_20 {stone11}
	)
)

(instance stone12 of Stone
	(properties
		sel_20 {stone12}
	)
)

(instance stone13 of Stone
	(properties
		sel_20 {stone13}
	)
)

(instance stone14 of Stone
	(properties
		sel_20 {stone14}
	)
)

(instance stone15 of Stone
	(properties
		sel_20 {stone15}
	)
)

(instance stone16 of Stone
	(properties
		sel_20 {stone16}
	)
)

(instance stone17 of Stone
	(properties
		sel_20 {stone17}
	)
)

(instance stone18 of Stone
	(properties
		sel_20 {stone18}
	)
)

(instance stone19 of Stone
	(properties
		sel_20 {stone19}
	)
)

(instance stone20 of Stone
	(properties
		sel_20 {stone20}
	)
)

(instance stone21 of Stone
	(properties
		sel_20 {stone21}
	)
)

(instance stone22 of Stone
	(properties
		sel_20 {stone22}
	)
)

(instance stone23 of Stone
	(properties
		sel_20 {stone23}
	)
)

(instance stone24 of Stone
	(properties
		sel_20 {stone24}
	)
)

(instance stone25 of Stone
	(properties
		sel_20 {stone25}
	)
)

(instance stone26 of Stone
	(properties
		sel_20 {stone26}
	)
)

(instance stone27 of Stone
	(properties
		sel_20 {stone27}
	)
)

(instance stone28 of Stone
	(properties
		sel_20 {stone28}
	)
)

(instance stone29 of Stone
	(properties
		sel_20 {stone29}
	)
)

(instance stone30 of Stone
	(properties
		sel_20 {stone30}
	)
)

(instance theBGPlayer1 of BGPlayer
	(properties
		sel_20 {theBGPlayer1}
		sel_526 0
	)
)

(instance theBGPlayer2 of BGPlayer
	(properties
		sel_20 {theBGPlayer2}
	)
)

(instance thePoints of BGPlayer
	(properties
		sel_20 {thePoints}
	)
)

(instance associatedCode of Code
	(properties
		sel_20 {associatedCode}
	)

	(method (sel_110)
		(global181 sel_450: gAssocPoint)
	)
)

(instance theDoubleCube of DoubleCube
	(properties
		sel_20 {theDoubleCube}
	)
)

(instance theDiceCup of DiceCup
	(properties
		sel_20 {theDiceCup}
	)
)

(instance theArrow of Actor
	(properties
		sel_20 {theArrow}
		sel_1 20
		sel_0 182
		sel_2 850
		sel_4 1
	)

	(method (sel_110)
		(self sel_287: sel_283: sel_144:)
		(super sel_110: &rest)
	)

	(method (sel_144)
		(self sel_165: (if (== global178 global332) 2 else 3))
	)
)

(instance aCast of Set
	(properties
		sel_20 {aCast}
	)
)

(instance backgam_opt of File
	(properties
		sel_20 {backgam.opt}
	)

	(method (sel_57 param1 &tmp [temp0 20] [temp20 8])
		(cond
			((and argc (== param1 3))
				(if (self sel_183: 2)
					(self
						sel_328:
							(Format @temp0 300 1 global317 global315 global324) ; "%3d%d%d"
						sel_332:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self sel_183: 1)
				(if
					(or
						(!=
							(= global317 (ReadNumber (self sel_327: @temp20 4)))
							300
						)
						(!= global317 350)
					)
					(= global317 300)
				)
				(= global315 (ReadNumber (self sel_327: @temp20 2)))
				(= global324 (ReadNumber (self sel_327: @temp20 2)))
				(self sel_332:)
				(return 0)
			)
			(else
				(= global317 300)
				(= global315 0)
				(= global324 0)
				(return 0)
			)
		)
	)
)


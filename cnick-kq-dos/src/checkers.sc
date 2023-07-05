;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use KeyMouse)
(use MoveToEndLoop)
(use Interface)
(use LeapTo)
(use IconBar)
(use RandCycle)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	checkers 0
	pieces 1
	proc200_2 2
	R29 3
	R25 4
	R22 5
	player1 6
	player2 7
	squares 8
)

(local
	local0
	local1
	[local2 24] = [249 193 137 82 277 222 166 109 249 193 137 81 277 221 165 109 249 193 137 81 277 221 165 109]
	[local26 24] = [179 179 179 179 156 156 156 156 133 133 133 133 64 64 64 64 41 41 41 41 18 18 18 18]
	local50
	local51
	local52
	local53
	local54
)

(procedure (localproc_0 &tmp [temp0 500]) ; UNUSED
	(Format @temp0 &rest)
	(Print @temp0 64 10 180)
)

(procedure (localproc_1)
	(= global181 0)
	(pieces sel_119: 567)
)

(procedure (localproc_2 param1 param2)
	(return
		(or
			(and (== param1 1) (== param2 2))
			(and (== param1 0) (== param2 3))
			(and (== param1 3) (== param2 0))
			(and (== param1 2) (== param2 1))
		)
	)
)

(procedure (proc200_2 &tmp [temp0 80] [temp80 80] temp160 temp161)
	(if (or (!= (gSong sel_40:) 803) (== (gSong sel_157:) -1))
		(gSong sel_39: 803 sel_165: -1)
	)
	(= temp160 (gSystemWindow sel_25:))
	(= temp161 (gSystemWindow sel_26:))
	(gSystemWindow sel_25: 16 sel_26: 21)
	(Format @global550 299 7 (player2 sel_510:) 200 0) ; "SCORECARD  %=10s %=9s --------------------------------"
	(StrCat
		@global550
		(Format @temp80 299 8 (player2 sel_563:) (player1 sel_563:)) ; "Wins      %=3d    %=3d"
	)
	(StrCat
		@global550
		(Format @temp80 299 9 (player2 sel_564:) (player1 sel_564:)) ; "Losses     %=3d    %=3d"
	)
	(StrCat
		@global550
		(Format @temp80 299 10 (player2 sel_565:) (player1 sel_565:)) ; "Draws      %=3d    %=3d"
	)
	(Print @global550 30 500 182 gDoAbsCode)
	(gSystemWindow sel_25: temp160 sel_26: temp161)
	(gSong sel_162:)
)

(instance checkers of Rm
	(properties
		sel_20 {checkers}
		sel_28 10
	)

	(method (sel_110)
		(Load rsVIEW 200)
		(Load rsVIEW 210)
		(Load rsVIEW 250)
		(Load rsVIEW 251)
		(Load rsVIEW 252)
		(Load rsVIEW 253)
		(Load rsVIEW 210)
		(Load rsVIEW 275)
		(Load rsVIEW 981)
		(Load rsVIEW 983)
		(Load rsVIEW 984)
		(Load rsVIEW 985)
		(Load rsVIEW 986)
		(Load rsVIEW 987)
		(Load rsVIEW 988)
		(Load rsVIEW 989)
		(Load rsVIEW 990)
		(Load rsVIEW 980)
		(Load rsSOUND 200)
		(Load rsSOUND 201)
		(Load rsSOUND 202)
		(Load rsSOUND 203)
		(Load rsSOUND 204)
		(Load rsSOUND 205)
		(Load rsSOUND 206)
		(Load rsSOUND 207)
		(Load rsSOUND 208)
		(Load rsSOUND 904)
		(Load rsSOUND 903)
		(Load rsSOUND 906)
		(Load rsSOUND 907)
		(ScriptID 210) ; thechCode
		(ScriptID 202) ; root
		(ScriptID 201) ; book
		(ScriptID 203) ; endGame1
		(ScriptID 204) ; sqr0
		MoveToEndLoop
		LeapTo
		RandCycle
		((= gCheckers_opt (ScriptID 201 2)) sel_57:) ; checkers_opt
		(= sel_368 global266)
		(player1 sel_527: global190 sel_31: global194 sel_510: @global150)
		(player2 sel_527: global191 sel_31: global195 sel_510: @global157)
		(if (== global188 0)
			(player2 sel_31: 1)
			(= global188 1)
		)
		(= gTheArrow theArrow)
		(= global235 0)
		(if (gChar1 sel_441:)
			(gChar1 sel_282: 33 40 sel_198: sel_110:)
			(Load rsTEXT (+ (* (+ (gChar1 sel_2:) 1) 1000) global187))
		else
			(Load rsTEXT 19200)
		)
		(Characters sel_110:)
		(super sel_110:)
		(gSong sel_162:)
		(cond
			((not global198)
				(gGame sel_191: 982 1)
				(if (and (== (player1 sel_31:) 1) (== global188 1))
					(= global271 player2)
				else
					(= global271 player1)
				)
				(= global178 player1)
				(= global259 1)
				(gTheArrow sel_165: 3)
				(cond
					((and (== global188 1) (== (player1 sel_31:) 1))
						(= local52 1)
					)
					((== global188 2)
						(= local52 3)
					)
				)
			)
			((== global271 player2)
				(= global178 player2)
				(gTheArrow sel_165: 2)
				(if (== global188 1)
					(= local52 1)
				else
					(= local52 2)
				)
			)
			(else
				(= global178 player1)
				(gTheArrow sel_165: 3)
				(if (== global188 2)
					(= local52 3)
				)
			)
		)
		(if (== global188 1)
			(= global244 1)
			(if (== (player1 sel_31:) 1)
				(= global271 player2)
				(= global178 player2)
				(gTheArrow sel_165: 2)
				(= global259 -1)
				(player1 sel_527: global191 sel_31: 2 sel_510: @global157)
				(player2 sel_527: global190 sel_31: 1 sel_510: @global150)
			)
		)
		((ScriptID 202 0) sel_118:) ; root
		((ScriptID 202 1) sel_118:) ; lev1Lst
		((ScriptID 202 2) sel_118:) ; lev2Lst
		((ScriptID 202 3) sel_118:) ; lev3Lst
		((ScriptID 202 4) sel_118:) ; lev4Lst
		((ScriptID 202 6) sel_118:) ; lev44Lst
		((ScriptID 202 7) sel_118:) ; lev5Lst
		(pieces sel_118:)
		(squares sel_118:)
		(dumSqrs sel_118:)
		(player1 sel_118:)
		(player2 sel_118:)
		(gTheArrow sel_110: sel_283:)
		(= gGameScript (ScriptID 201 1)) ; gameScript
		(B1 sel_110:)
		(B2 sel_110:)
		(B3 sel_110:)
		(B4 sel_110:)
		(B5 sel_110:)
		(B6 sel_110:)
		(B7 sel_110:)
		(B8 sel_110:)
		(B9 sel_110:)
		(B10 sel_110:)
		(B11 sel_110:)
		(B12 sel_110:)
		(R21 sel_110:)
		(R22 sel_110:)
		(R23 sel_110:)
		(R24 sel_110:)
		(R25 sel_110:)
		(R26 sel_110:)
		(R27 sel_110:)
		(R28 sel_110:)
		(R29 sel_110:)
		(R30 sel_110:)
		(R31 sel_110:)
		(R32 sel_110:)
		((ScriptID 204 0) sel_110:) ; sqr0
		((ScriptID 204 1) sel_110:) ; sqr1
		((ScriptID 204 2) sel_110:) ; sqr2
		((ScriptID 204 3) sel_110:) ; sqr3
		((ScriptID 204 4) sel_110:) ; sqr4
		((ScriptID 204 5) sel_110:) ; sqr5
		((ScriptID 204 6) sel_110:) ; sqr6
		((ScriptID 204 7) sel_110:) ; sqr7
		((ScriptID 204 8) sel_110:) ; sqr8
		((ScriptID 204 9) sel_110:) ; sqr9
		((ScriptID 204 10) sel_110:) ; sqr10
		((ScriptID 204 11) sel_110:) ; sqr11
		((ScriptID 204 12) sel_110:) ; sqr12
		((ScriptID 204 13) sel_110:) ; sqr13
		((ScriptID 204 14) sel_110:) ; sqr14
		((ScriptID 204 15) sel_110:) ; sqr15
		((ScriptID 204 16) sel_110:) ; sqr16
		((ScriptID 204 17) sel_110:) ; sqr17
		((ScriptID 204 18) sel_110:) ; sqr18
		((ScriptID 204 19) sel_110:) ; sqr19
		((ScriptID 204 20) sel_110:) ; sqr20
		((ScriptID 204 21) sel_110:) ; sqr21
		((ScriptID 204 22) sel_110:) ; sqr22
		((ScriptID 204 23) sel_110:) ; sqr23
		((ScriptID 204 24) sel_110:) ; sqr24
		((ScriptID 204 25) sel_110:) ; sqr25
		((ScriptID 204 26) sel_110:) ; sqr26
		((ScriptID 204 27) sel_110:) ; sqr27
		((ScriptID 204 28) sel_110:) ; sqr28
		((ScriptID 204 29) sel_110:) ; sqr29
		((ScriptID 204 30) sel_110:) ; sqr30
		((ScriptID 204 31) sel_110:) ; sqr31
		((ScriptID 204 32) sel_110:) ; sqr32
		((ScriptID 204 33) sel_110:) ; dumSqr1
		((ScriptID 204 34) sel_110:) ; dumSqr2
		((ScriptID 204 35) sel_110:) ; dumSqr3
		((ScriptID 204 36) sel_110:) ; dumSqr4
		((ScriptID 204 37) sel_110:) ; dumSqr5
		((ScriptID 204 38) sel_110:) ; dumSqr6
		((ScriptID 204 39) sel_110:) ; dumSqr7
		((ScriptID 204 40) sel_110:) ; dumSqr8
		((ScriptID 204 41) sel_110:) ; dumSqr9
		((ScriptID 204 42) sel_110:) ; dumSqr10
		((ScriptID 204 43) sel_110:) ; dumSqr11
		((ScriptID 204 44) sel_110:) ; dumSqr12
		((ScriptID 204 45) sel_110:) ; dumSqr13
		((ScriptID 204 46) sel_110:) ; dumSqr14
		((ScriptID 204 47) sel_110:) ; dumSqr15
		((ScriptID 204 48) sel_110:) ; dumSqr16
		((ScriptID 204 49) sel_110:) ; dumSqr17
		((ScriptID 204 50) sel_110:) ; dumSqr18
		((ScriptID 204 51) sel_110:) ; dumSqr19
		((ScriptID 204 52) sel_110:) ; dumSqr20
		((ScriptID 204 53) sel_110:) ; dumSqr21
		((ScriptID 204 54) sel_110:) ; dumSqr22
		((ScriptID 204 55) sel_110:) ; dumSqr23
		((ScriptID 204 56) sel_110:) ; dumSqr24
		((ScriptID 204 57) sel_110:) ; dumSqr25
		((ScriptID 204 58) sel_110:) ; dumSqr26
		((ScriptID 204 59) sel_110:) ; dumSqr27
		((ScriptID 204 60) sel_110:) ; dumSqr28
		((ScriptID 204 61) sel_110:) ; dumSqr29
		((ScriptID 204 62) sel_110:) ; dumSqr30
		((ScriptID 204 63) sel_110:) ; dumSqr31
		((ScriptID 204 64) sel_110:) ; dumSqr32
		(proc0_1)
		(if (== sel_368 250)
			(gSound2 sel_39: 207 sel_165: 1)
		)
		(switch local52
			(1
				(gChar1 sel_446: (Random 18 20))
			)
			(2
				(Print (Format @global550 299 0 (player2 sel_510:))) ; "%s moves first"
			)
			(3
				(Print (Format @global550 299 0 (player1 sel_510:))) ; "%s moves first"
			)
		)
		(self sel_145: gGameScript)
	)

	(method (sel_57 &tmp temp0)
		(super sel_57: &rest)
		(if (!= global266 sel_368)
			(IconBar sel_205:)
			(= sel_368 global266)
			(gGame sel_191: 20 1)
			(for ((= temp0 0)) (< temp0 (gCast sel_86:)) ((++ temp0))
				(UnLoad 133 ((gCast sel_64: temp0) sel_5:))
			)
			(DrawPic sel_368 10)
			(localproc_1)
			(gGame sel_191: 982 1)
			(proc0_1)
			(if (== sel_368 250)
				(gSound2 sel_39: 207 sel_165: 1)
			)
			(IconBar sel_170:)
		)
		(if global262
			(if (and (== global188 2) (== global178 player1))
				(player2 sel_563: (+ (player2 sel_563:) 1))
				(player1 sel_564: (+ (player1 sel_564:) 1))
			else
				(player1 sel_563: (+ (player1 sel_563:) 1))
				(player2 sel_564: (+ (player2 sel_564:) 1))
			)
			(proc200_2)
			(squares sel_119: 497)
			(pieces sel_119: 497)
			(gCurRoom sel_145: gGameScript)
		)
		(if (and global260 (== global188 1))
			(if (checkDraw sel_57:)
				(gChar1 sel_446: (Random 0 2))
				(player1 sel_565: (+ (player1 sel_565:) 1))
				(player2 sel_565: (+ (player2 sel_565:) 1))
				(proc200_2)
				(squares sel_119: 497)
				(pieces sel_119: 497)
				(gCurRoom sel_145: gGameScript)
			else
				(gChar1 sel_446: (Random 3 5))
			)
		)
		(= global260 0)
	)

	(method (sel_111 &tmp temp0)
		((ScriptID 202 1) sel_111:) ; lev1Lst
		((ScriptID 202 2) sel_111:) ; lev2Lst
		((ScriptID 202 3) sel_111:) ; lev3Lst
		((ScriptID 202 4) sel_111:) ; lev4Lst
		((ScriptID 202 6) sel_111:) ; lev44Lst
		((ScriptID 202 7) sel_111:) ; lev5Lst
		((ScriptID 202 0) sel_111:) ; root
		(pieces sel_125: sel_111:)
		(squares sel_125: sel_111:)
		(dumSqrs sel_125: sel_111:)
		(KeyMouse sel_125: sel_111:)
		(player1 sel_125: sel_111:)
		(player2 sel_125: sel_111:)
		(super sel_111:)
		(DisposeScript 202)
		(DisposeScript 201)
		(DisposeScript 203)
		(DisposeScript 204)
		(DisposeScript 210)
		(DisposeScript 11)
		(DisposeScript 302)
		(DisposeScript 9)
		(DisposeScript 941)
	)

	(method (sel_132 param1 &tmp [temp0 2])
		(if (and (== (param1 sel_31:) 4) (== (param1 sel_37:) 27))
			(return 0)
		else
			(global178 sel_132: param1)
		)
	)
)

(class Piece of DragableActor
	(properties
		sel_20 {Piece}
		sel_52 3
		sel_4 1
		sel_60 10
		sel_51 6
		sel_452 200
		sel_454 0
		sel_31 -1
		sel_566 0
	)

	(method (sel_567)
		(if (== global266 250)
			((ScriptID 201 3) sel_153: 0 sel_102: sel_4: 0 sel_284:) ; splash
			(cond
				((or (== (self sel_31:) -1) (== (self sel_31:) 1))
					(if (== (self sel_3:) 2)
						(self sel_2: 250 sel_452: 250)
					else
						(self sel_2: 252 sel_452: 252)
					)
				)
				((or (== (self sel_31:) -2) (== (self sel_31:) 2))
					(if (== (self sel_3:) 2)
						(self sel_2: 251 sel_452: 251)
					else
						(self sel_2: 253 sel_452: 253)
					)
				)
			)
			(if (< (pieces sel_131: self) 12)
				(self sel_3: 3 sel_453: 3 sel_284:)
			else
				(self sel_3: 2 sel_453: 2 sel_284:)
			)
			(self sel_59: gLooperDir8 sel_4: 0 sel_454: 7 sel_458: dragSpider)
		else
			(cond
				((or (== (self sel_31:) -1) (== (self sel_31:) 1))
					(if (== (self sel_2:) 250)
						(self sel_165: 2 sel_453: 2 sel_4: 1 sel_454: 0)
					else
						(self sel_165: 0 sel_453: 0 sel_4: 1 sel_454: 0)
					)
				)
				((or (== (self sel_31:) -2) (== (self sel_31:) 2))
					(if (== (self sel_2:) 251)
						(self sel_165: 2 sel_453: 2 sel_4: 3 sel_454: 2)
					else
						(self sel_165: 0 sel_453: 0 sel_4: 3 sel_454: 2)
					)
				)
			)
			(self
				sel_2: 200
				sel_452: 200
				sel_53: 3
				sel_59: 0
				sel_458: 0
				sel_153: 0
				sel_284:
			)
		)
	)

	(method (sel_568 param1)
		(if (== sel_566 param1)
			(return 1)
		)
		(return 0)
	)

	(method (sel_144)
		(if (and (== sel_2 sel_455) (== global266 (gCurRoom sel_368:)))
			(self sel_461:)
		)
		(self sel_63: 10 sel_153: 0)
		(if (== global266 250)
			(gSound2 sel_159:)
			(gSound sel_39: 208 sel_165: 1)
			(if (== (global178 sel_526:) -1)
				(self sel_3: 3)
			else
				(self sel_3: 2)
			)
			(self sel_4: 0)
		else
			(gSound2 sel_159:)
			(gSound sel_39: 200 sel_165: 1)
			(self sel_306: 2 3)
		)
		(self sel_283:)
		(proc0_3)
	)

	(method (sel_573 &tmp temp0 temp1 temp2 temp3)
		(for ((= temp0 1)) (< temp0 33) ((++ temp0))
			(cond
				((== (global178 sel_526:) -1)
					(if (< ([global200 temp0] sel_574:) 0)
						(for
							((= temp1 3))
							(>=
								temp1
								(if (== ([global200 temp0] sel_574:) -1)
									2
								else
									0
								)
							)
							((-- temp1))
							
							(= temp2 ([global200 temp0] sel_575: temp1))
							(= temp3 ([global200 temp2] sel_575: temp1))
							(if
								(and
									(> ([global200 temp2] sel_574:) 0)
									(== ([global200 temp3] sel_574:) 0)
								)
								(return 1)
							)
						)
					)
				)
				((> ([global200 temp0] sel_574:) 0)
					(for
						((= temp1 0))
						(<=
							temp1
							(if (== ([global200 temp0] sel_574:) 1) 1 else 3)
						)
						((++ temp1))
						
						(= temp2 ([global200 temp0] sel_575: temp1))
						(= temp3 ([global200 temp2] sel_575: temp1))
						(if
							(and
								(< ([global200 temp2] sel_574:) 0)
								(== ([global200 temp3] sel_574:) 0)
							)
							(return 1)
						)
					)
				)
			)
		)
		(return 0)
	)

	(method (sel_532 param1 &tmp temp0 temp1)
		(= global246 0)
		(= temp1 0)
		(if (== global244 1)
			(= temp1 (self sel_573:))
		)
		(if (> param1 0)
			(cond
				(([global200 param1] sel_574:)
					(if (!= (self sel_566:) param1)
						(gSound sel_39: 907 sel_165: 1)
						(gChar1 sel_446: (Random 12 14) -32768 445)
					)
					(return 0)
				)
				(
					(and
						(> param1 sel_566)
						(or (== (global178 sel_526:) -1) (== (self sel_31:) 2))
					)
					(switch param1
						(([global200 sel_566] sel_575: 3)
							(if global245
								(return 0)
							)
							(if (not temp1)
								(self sel_569: param1)
								(return 1)
							else
								(gSound sel_39: 907 sel_165: 1)
								(gChar1 sel_446: (Random 21 23) -32768 443)
								(return 0)
							)
						)
						(([global200 sel_566] sel_575: 2)
							(if global245
								(return 0)
							)
							(if (not temp1)
								(self sel_569: param1)
								(return 1)
							else
								(gSound sel_39: 907 sel_165: 1)
								(gChar1 sel_446: (Random 21 23) -32768 443)
								(return 0)
							)
						)
						(
							([global200 ([global200 sel_566] sel_575: 3)]
								sel_575: 3
							)
							(return (self sel_570: param1 3))
						)
						(
							([global200 ([global200 sel_566] sel_575: 2)]
								sel_575: 2
							)
							(return (self sel_570: param1 2))
						)
					)
				)
				(
					(and
						(< param1 sel_566)
						(or (== (global178 sel_526:) 1) (== (self sel_31:) -2))
					)
					(switch param1
						(([global200 sel_566] sel_575: 1)
							(if global245
								(return 0)
							)
							(if (not temp1)
								(self sel_569: param1)
								(return 1)
							else
								(gSound sel_39: 907 sel_165: 1)
								(gChar1 sel_446: (Random 21 23) -32768 443)
								(return 0)
							)
						)
						(([global200 sel_566] sel_575: 0)
							(if global245
								(return 0)
							)
							(if (not temp1)
								(self sel_569: param1)
								(return 1)
							else
								(gSound sel_39: 907 sel_165: 1)
								(gChar1 sel_446: (Random 21 23) -32768 443)
								(return 0)
							)
						)
						(
							([global200 ([global200 sel_566] sel_575: 0)]
								sel_575: 0
							)
							(return (self sel_570: param1 0))
						)
						(
							([global200 ([global200 sel_566] sel_575: 1)]
								sel_575: 1
							)
							(return (self sel_570: param1 1))
						)
					)
				)
				(
					(<
						([global200 param1] sel_576:)
						([global200 sel_566] sel_576:)
					)
					(gSound sel_39: 907 sel_165: 1)
					(gChar1 sel_446: (Random 6 8) -32768 445)
					(return 0)
				)
			)
		)
		(if (== param1 0)
			(return 0)
		)
		(if (== param1 -1)
			(gSound sel_39: 907 sel_165: 1)
			(gChar1 sel_446: (Random 9 11) -32768 445)
			(return 0)
		)
		(if (self sel_572: param1 10)
			(gChar1 sel_446: 299 3 -32768)
		else
			(gSound sel_39: 907 sel_165: 1)
			(gChar1 sel_446: (Random 12 14) -32768 445)
		)
		(return 0)
	)

	(method (sel_572 param1 param2 &tmp temp0 temp1 temp2 [temp3 2])
		(if (== (global178 sel_526:) -1)
			(for
				((= temp0 0))
				(<= temp0 (if (== (self sel_31:) -1) 1 else 3))
				((++ temp0))
				
				(if (not (localproc_2 temp0 param2))
					(= temp1 ([global200 param1] sel_575: temp0))
					(= temp2 ([global200 temp1] sel_575: temp0))
					(if
						(and
							(> ([global200 temp1] sel_574:) 0)
							(or
								(== ([global200 temp2] sel_574:) 0)
								(== temp2 sel_566)
							)
						)
						(cond
							((== temp2 sel_566)
								(return 1)
							)
							((self sel_572: temp2 temp0)
								(return 1)
							)
						)
					)
				)
			)
		else
			(for
				((= temp0 3))
				(>= temp0 (if (== (self sel_31:) 1) 2 else 0))
				((-- temp0))
				
				(if (not (localproc_2 temp0 param2))
					(= temp1 ([global200 param1] sel_575: temp0))
					(= temp2 ([global200 temp1] sel_575: temp0))
					(if
						(and
							(< ([global200 temp1] sel_574:) 0)
							(or
								(== ([global200 temp2] sel_574:) 0)
								(== temp2 sel_566)
							)
						)
						(cond
							((== temp2 sel_566)
								(return 1)
							)
							((self sel_572: temp2 temp0)
								(return 1)
							)
						)
					)
				)
			)
		)
		(if (== param2 10)
			(return 0)
		)
	)

	(method (sel_569 param1)
		([global200 sel_566] sel_574: 0)
		(self sel_566: param1)
		(cond
			((and (== (global178 sel_526:) -1) (> param1 28))
				(if (!= (self sel_31:) -2)
					(= global273 1)
				)
				(if (== global270 1)
					(= global270 2)
				)
				([global200 param1] sel_574: -2)
				(self sel_31: -2)
				(if (== global266 200)
					(self sel_4: 3 sel_454: 2)
				)
			)
			((and (== (global178 sel_526:) 1) (< param1 5))
				(if (!= (self sel_31:) 2)
					(= global273 1)
				)
				([global200 param1] sel_574: 2)
				(self sel_31: 2)
				(if (== global266 200)
					(self sel_4: 3 sel_454: 2)
				)
			)
			(else
				([global200 param1] sel_574: sel_31)
			)
		)
	)

	(method (sel_570 param1 param2)
		(cond
			((== (global178 sel_526:) -1)
				(if
					(>
						([global200 ([global200 sel_566] sel_575: param2)]
							sel_574:
						)
						0
					)
					(= global250
						(pieces
							sel_120: 568 ([global200 sel_566] sel_575: param2)
						)
					)
					(= global246 1)
					([global200 ([global200 sel_566] sel_575: param2)]
						sel_574: 0
					)
					([global200 sel_566] sel_574: 0)
					(self sel_566: param1)
					(if (and (> param1 28) (!= (self sel_31:) -2))
						([global200 param1] sel_574: -2)
						(self sel_31: -2)
						(if (== global266 200)
							(self sel_4: 3 sel_454: 2)
						)
						(= global245 0)
					else
						([global200 param1] sel_574: sel_31)
						(= global245 (self sel_571:))
					)
					(if (== global266 200)
						((gCurRoom sel_141:) sel_144:)
					)
					(return 1)
				else
					(gChar1 sel_446: (Random 12 14) -32768 445)
					(return 0)
				)
			)
			((< ([global200 ([global200 sel_566] sel_575: param2)] sel_574:) 0)
				(= global250
					(pieces sel_120: 568 ([global200 sel_566] sel_575: param2))
				)
				(= global246 1)
				([global200 ([global200 sel_566] sel_575: param2)] sel_574: 0)
				([global200 sel_566] sel_574: 0)
				(self sel_566: param1)
				(if (and (< param1 5) (!= (self sel_31:) 2))
					([global200 param1] sel_574: 2)
					(self sel_31: 2)
					(if (== global266 200)
						(self sel_4: 3 sel_454: 2)
					)
					(= global245 0)
				else
					([global200 param1] sel_574: sel_31)
					(= global245 (self sel_571:))
				)
				(if (== global266 200)
					((gCurRoom sel_141:) sel_144:)
				)
				(return 1)
			)
			(else
				(gChar1 sel_446: (Random 12 14) -32768 445)
				(return 0)
			)
		)
	)

	(method (sel_571 &tmp temp0 temp1 temp2)
		(if (== (global178 sel_526:) -1)
			(for
				((= temp0 3))
				(>= temp0 (if (== sel_31 -1) 2 else 0))
				((-- temp0))
				
				(= temp1 ([global200 sel_566] sel_575: temp0))
				(= temp2 ([global200 temp1] sel_575: temp0))
				(if
					(and
						(> ([global200 temp1] sel_574:) 0)
						(== ([global200 temp2] sel_574:) 0)
					)
					(return 1)
				)
			)
		else
			(for
				((= temp0 0))
				(<= temp0 (if (== sel_31 1) 1 else 3))
				((++ temp0))
				
				(= temp1 ([global200 sel_566] sel_575: temp0))
				(= temp2 ([global200 temp1] sel_575: temp0))
				(if
					(and
						(< ([global200 temp1] sel_574:) 0)
						(== ([global200 temp2] sel_574:) 0)
					)
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (sel_110)
		(if (== global266 250)
			(cond
				((== global259 -1)
					(if (< (pieces sel_86:) 12)
						(self sel_2: 250 sel_452: 250 sel_3: 3 sel_453: 3)
					else
						(self sel_2: 252 sel_452: 252 sel_3: 2 sel_453: 2)
					)
				)
				((< (pieces sel_86:) 12)
					(self sel_2: 252 sel_452: 252 sel_3: 3 sel_453: 3)
				)
				(else
					(self sel_2: 250 sel_452: 250 sel_3: 2 sel_453: 2)
				)
			)
			(self
				sel_59: gLooperDir8
				sel_454: 7
				sel_4: 0
				sel_458: dragSpider
				sel_63: 10
			)
		else
			(self sel_2: 200 sel_63: 10)
			(cond
				((== global259 -1)
					(if (< (pieces sel_86:) 12)
						(self sel_165: 2 sel_453: 2)
					else
						(self sel_165: 0 sel_453: 0)
					)
				)
				((< (pieces sel_86:) 12)
					(self sel_165: 0 sel_453: 0)
				)
				(else
					(self sel_165: 2 sel_453: 2)
				)
			)
		)
		(self sel_1: [local2 (pieces sel_86:)])
		(self sel_0: [local26 (pieces sel_86:)])
		(super sel_110: &rest)
		(pieces sel_118: self)
		(self sel_287:)
		(self sel_283:)
	)

	(method (sel_497 &tmp temp0)
		(if (!= ((ScriptID 202 0) sel_86:) 0) ; root
			((ScriptID 202 0) sel_577: (ScriptID 202 0)) ; root, root
			((ScriptID 202 0) sel_125:) ; root
		)
		((ScriptID 201 3) sel_153: 0 sel_102: sel_4: 0 sel_284:) ; splash
		(if (== (= temp0 (pieces sel_131: self)) 0)
			(if (== global259 -1)
				(= global259 1)
				(= global178 player1)
				(if (== (player1 sel_31:) 2)
					(proc0_4)
				)
				(gTheArrow sel_165: 3)
			else
				(proc0_3)
				(= global259 -1)
				(= global178 player2)
				(gTheArrow sel_165: 2)
			)
		)
		(self sel_296: 0)
		(self sel_1: [local2 temp0] sel_0: [local26 temp0] sel_60: 10)
		(if (< temp0 12)
			(self sel_31: -1 sel_566: (+ temp0 1))
		else
			(self sel_31: 1 sel_566: (+ temp0 9))
		)
		(cond
			((== global266 200)
				(if (== (self sel_3:) 2)
					(self sel_165: 0 sel_453: 0)
				else
					(self sel_165: 2 sel_453: 2)
				)
				(self sel_454: 0 sel_4: 1 sel_306: 2 3 sel_53: 3)
			)
			((or (== (self sel_2:) 250) (== (self sel_2:) 251))
				(self sel_2: 252 sel_452: 252 sel_4: 0)
			)
			((or (== (self sel_2:) 252) (== (self sel_2:) 253))
				(self sel_2: 250 sel_452: 250 sel_4: 0)
			)
		)
		(if (== global266 250)
			(if (< temp0 12)
				(self sel_3: 3 sel_453: 3)
			else
				(self sel_3: 2 sel_453: 2)
			)
			(self sel_4: 0 sel_454: 7 sel_153: 0 sel_284:)
		)
		(self sel_283:)
		(if (== temp0 23)
			(proc0_1)
			(cond
				((and (== global188 1) (== global259 -1))
					(gChar1 sel_446: (Random 18 20))
				)
				((== global188 2)
					(if (== global259 -1)
						(Print (Format @global550 299 0 (player2 sel_510:))) ; "%s moves first"
					else
						(Print (Format @global550 299 0 (player1 sel_510:))) ; "%s moves first"
					)
				)
			)
		)
	)
)

(class Sqr of KMRect
	(properties
		sel_20 {Sqr}
		sel_578 0
		sel_579 0
		sel_580 0
		sel_581 0
		sel_574 0
		sel_40 0
		sel_576 0
		sel_582 0
	)

	(method (sel_110)
		(= [global200 global235] self)
		(++ global235)
		(squares sel_118: self)
		(self sel_437:)
	)

	(method (sel_575 param1)
		(return
			(switch param1
				(0 sel_578)
				(1 sel_579)
				(2 sel_580)
				(3 sel_581)
			)
		)
	)

	(method (sel_132 param1)
		(if
			(and
				(<= sel_7 (param1 sel_1:) sel_9)
				(<= sel_6 (param1 sel_0:) sel_8)
			)
			(param1 sel_73: 1)
			(return sel_40)
		)
		(return 0)
	)

	(method (sel_497 &tmp temp0)
		(cond
			((== (= temp0 (squares sel_131: self)) 0)
				([global200 temp0] sel_574: 99)
			)
			((< temp0 13)
				([global200 temp0] sel_574: -1)
			)
			((< temp0 21)
				([global200 temp0] sel_574: 0)
			)
			(else
				([global200 temp0] sel_574: 1)
			)
		)
	)
)

(class CheckPlayer of List
	(properties
		sel_20 {CheckPlayer}
		sel_31 0
		sel_526 0
		sel_510 0
		sel_527 0
		sel_563 0
		sel_564 0
		sel_565 0
	)

	(method (sel_144)
		(cond
			((== global266 200)
				(cond
					((== (global272 sel_31:) 2)
						(global272 sel_4: 3)
					)
					((== (global272 sel_31:) -2)
						(global272 sel_4: 3)
					)
					(
						(and
							(== (global272 sel_455:) (global272 sel_2:))
							(== global266 (gCurRoom sel_368:))
						)
						(global272 sel_461:)
					)
				)
				(if
					(and
						(== (global272 sel_455:) (global272 sel_2:))
						(== global266 (gCurRoom sel_368:))
					)
					(if (== global178 player1)
						(gSound sel_39: 200 sel_165: 1)
					else
						(gSound sel_39: 201 sel_165: 1)
					)
					(if (global272 sel_532: global236)
						(global272 sel_63: 10 sel_283:)
						(if (not global246)
							((gCurRoom sel_141:) sel_144:)
						)
					else
						(proc0_4)
						(gSound2 sel_39: 904 sel_165: 1)
						(global272
							sel_63: 15
							sel_306: 20 20
							sel_296:
								MoveTo
								(global272 sel_418:)
								(global272 sel_419:)
								global272
						)
					)
				else
					((gCurRoom sel_141:) sel_144:)
				)
			)
			(
				(and
					(== (global272 sel_455:) (global272 sel_2:))
					(== global266 (gCurRoom sel_368:))
				)
				(gSound sel_39: 208 sel_165: 1)
				(if (or (== (global272 sel_31:) -2) (== (global272 sel_31:) 2))
					(cond
						((== (global272 sel_2:) 250)
							(global272 sel_2: 251 sel_452: 251)
						)
						((== (global272 sel_2:) 252)
							(global272 sel_2: 253 sel_452: 253)
						)
					)
				)
				(global272 sel_153: 0)
				(global272 sel_4: 0)
				(if (== (global178 sel_526:) -1)
					(global272 sel_3: 3)
				else
					(global272 sel_3: 2)
				)
				(proc0_1)
				(global272 sel_63: 10 sel_283:)
				(proc0_3)
				((gCurRoom sel_141:) sel_144:)
			)
			((global272 sel_532: global236)
				(global272 sel_63: 10 sel_283:)
				(cond
					((== (global272 sel_31:) 2)
						(global272 sel_4: 3)
					)
					((== (global272 sel_31:) -2)
						(global272 sel_4: 3)
					)
				)
				(proc0_3)
				((gCurRoom sel_141:) sel_144:)
			)
			(else
				(proc0_4)
				(global272
					sel_63: 15
					sel_306: 20 20
					sel_296:
						MoveToEndLoop
						(global272 sel_418:)
						(global272 sel_419:)
						global272
				)
			)
		)
	)

	(method (sel_132 param1 &tmp temp0 temp1 temp2 temp3)
		(if (== (global178 sel_31:) 2)
			(return 0)
		)
		(return
			(cond
				((= temp1 (pieces sel_120: 132 param1))
					(if (and global245 (!= temp1 global272))
						(return 0)
					)
					(if (== (temp1 sel_566:) 99)
						(return 0)
					)
					(if (not (self sel_583: temp1))
						(return 0)
					)
					(if (and (== (temp1 sel_460: param1) 1) global181)
						(= global272 global181)
						(= global235 (global181 sel_566:))
						(= temp3 (Event sel_109:))
						(cond
							((= temp0 (squares sel_120: 132 temp3))
								(= temp0 (temp0 sel_40:))
							)
							((dumSqrs sel_120: 132 temp3)
								(= temp0 -1)
							)
						)
						(temp3 sel_111:)
						(if (global181 sel_532: temp0)
							(proc0_4)
							(proc0_1)
							(= global236 temp0)
							(if (== global266 200)
								(global181 sel_63: 10 sel_283:)
								(global181
									sel_282:
										(+ ([global200 global236] sel_7:) 14)
										(+ ([global200 global236] sel_6:) 12)
								)
								(if (== global178 player1)
									(gSound sel_39: 200 sel_165: 1)
								else
									(gSound sel_39: 201 sel_165: 1)
								)
								(if (not global246)
									((gCurRoom sel_141:) sel_144:)
								)
							else
								(proc0_4)
								(if
									(global272
										sel_304:
											([global200 global236] sel_7:)
											([global200 global236] sel_6:)
											([global200 global236] sel_9:)
											([global200 global236] sel_8:)
									)
									(global272
										sel_153: 0
										sel_4: 0
										sel_296: 0
										sel_284:
									)
									(global272
										sel_282:
											(+
												([global200 global236] sel_7:)
												14
											)
											(+
												([global200 global236] sel_6:)
												12
											)
									)
									(self sel_144:)
								else
									(global272
										sel_63: 15
										sel_296:
											MoveToEndLoop
											(+
												([global200 global236] sel_7:)
												14
											)
											(+
												([global200 global236] sel_6:)
												12
											)
											self
									)
								)
							)
						else
							(proc0_4)
							(if
								(and
									(!= (global181 sel_418:) (global181 sel_1:))
									(!= (global181 sel_419:) (global181 sel_0:))
								)
								(gSound2 sel_39: 904 sel_165: 1)
							)
							(if (== global266 250)
								((ScriptID 203 6) sel_57:) ; findLoop
								(global181
									sel_63: 15
									sel_296:
										MoveToEndLoop
										(global181 sel_418:)
										(global181 sel_419:)
										global181
								)
							else
								(global181
									sel_63: 15
									sel_306: 20 20
									sel_296:
										MoveTo
										(global181 sel_418:)
										(global181 sel_419:)
										global181
								)
							)
						)
						(= global181 0)
					)
				)
				(global181
					(= global272 global181)
					(= global235 (global181 sel_566:))
					(= temp3 (Event sel_109:))
					(cond
						((= temp0 (squares sel_120: 132 temp3))
							(= temp0 (temp0 sel_40:))
						)
						((dumSqrs sel_120: 132 temp3)
							(= temp0 -1)
						)
					)
					(temp3 sel_111:)
					(= global236 temp0)
					(proc0_4)
					(if (< 0 global236 33)
						(cond
							((== global266 200)
								(global181
									sel_63: 15
									sel_296:
										MoveTo
										(+ ([global200 temp0] sel_7:) 14)
										(+ ([global200 temp0] sel_6:) 12)
										self
								)
							)
							((global181 sel_532: global236)
								(global181
									sel_63: 15
									sel_296:
										MoveToEndLoop
										(+ ([global200 temp0] sel_7:) 14)
										(+ ([global200 temp0] sel_6:) 12)
										self
								)
							)
							(else
								(proc0_3)
								(global181 sel_461:)
							)
						)
					else
						(proc0_3)
						(global181 sel_461:)
					)
					(= global181 0)
				)
			)
		)
	)

	(method (sel_583 param1)
		(if (and (== sel_526 -1) (> (param1 sel_31:) 0))
			(gSound2 sel_39: 907 sel_165: 1)
			(gChar1 sel_446: (Random 15 17) -32768 445)
			(return 0)
		)
		(if (and (== sel_526 1) (< (param1 sel_31:) 0))
			(gSound2 sel_39: 907 sel_165: 1)
			(gChar1 sel_446: (Random 15 17) -32768 445)
			(return 0)
		)
		(return 1)
	)
)

(class DumSqr of KMRect
	(properties
		sel_20 {DumSqr}
	)

	(method (sel_110)
		(super sel_110:)
		(dumSqrs sel_118: self)
		(self sel_437:)
	)

	(method (sel_132 param1)
		(if
			(and
				(<= sel_7 (param1 sel_1:) sel_9)
				(<= sel_6 (param1 sel_0:) sel_8)
			)
			(param1 sel_73: 1)
			(return (param1 sel_73:))
		)
		(return 0)
	)
)

(instance player1 of CheckPlayer
	(properties
		sel_20 {player1}
		sel_31 2
		sel_526 1
	)
)

(instance player2 of CheckPlayer
	(properties
		sel_20 {player2}
		sel_31 1
		sel_526 -1
	)
)

(instance B1 of Piece
	(properties
		sel_20 {B1}
		sel_566 1
	)
)

(instance B2 of Piece
	(properties
		sel_20 {B2}
		sel_566 2
	)
)

(instance B3 of Piece
	(properties
		sel_20 {B3}
		sel_566 3
	)
)

(instance B4 of Piece
	(properties
		sel_20 {B4}
		sel_566 4
	)
)

(instance B5 of Piece
	(properties
		sel_20 {B5}
		sel_566 5
	)
)

(instance B6 of Piece
	(properties
		sel_20 {B6}
		sel_566 6
	)
)

(instance B7 of Piece
	(properties
		sel_20 {B7}
		sel_566 7
	)
)

(instance B8 of Piece
	(properties
		sel_20 {B8}
		sel_566 8
	)
)

(instance B9 of Piece
	(properties
		sel_20 {B9}
		sel_566 9
	)
)

(instance B10 of Piece
	(properties
		sel_20 {B10}
		sel_566 10
	)
)

(instance B11 of Piece
	(properties
		sel_20 {B11}
		sel_566 11
	)
)

(instance B12 of Piece
	(properties
		sel_20 {B12}
		sel_566 12
	)
)

(instance R21 of Piece
	(properties
		sel_20 {R21}
		sel_31 1
		sel_566 21
	)
)

(instance R22 of Piece
	(properties
		sel_20 {R22}
		sel_31 1
		sel_566 22
	)
)

(instance R23 of Piece
	(properties
		sel_20 {R23}
		sel_31 1
		sel_566 23
	)
)

(instance R24 of Piece
	(properties
		sel_20 {R24}
		sel_31 1
		sel_566 24
	)
)

(instance R25 of Piece
	(properties
		sel_20 {R25}
		sel_31 1
		sel_566 25
	)
)

(instance R26 of Piece
	(properties
		sel_20 {R26}
		sel_31 1
		sel_566 26
	)
)

(instance R27 of Piece
	(properties
		sel_20 {R27}
		sel_31 1
		sel_566 27
	)
)

(instance R28 of Piece
	(properties
		sel_20 {R28}
		sel_31 1
		sel_566 28
	)
)

(instance R29 of Piece
	(properties
		sel_20 {R29}
		sel_31 1
		sel_566 29
	)
)

(instance R30 of Piece
	(properties
		sel_20 {R30}
		sel_31 1
		sel_566 30
	)
)

(instance R31 of Piece
	(properties
		sel_20 {R31}
		sel_31 1
		sel_566 31
	)
)

(instance R32 of Piece
	(properties
		sel_20 {R32}
		sel_31 1
		sel_566 32
	)
)

(instance pieces of List
	(properties
		sel_20 {pieces}
	)
)

(instance squares of List
	(properties
		sel_20 {squares}
	)
)

(instance dumSqrs of List
	(properties
		sel_20 {dumSqrs}
	)
)

(instance dragSpider of Code
	(properties
		sel_20 {dragSpider}
	)

	(method (sel_110 param1)
		(= local0 (param1 sel_1:))
		(= local1 (param1 sel_0:))
		(= local50 0)
		(param1 sel_53: 6 sel_223: 6 sel_4: (param1 sel_225:) sel_284:)
	)

	(method (sel_57 param1)
		(param1 sel_1: local0)
		(param1 sel_0: local1)
		(if (param1 sel_224:)
			((param1 sel_224:) sel_57:)
		)
		(if (param1 sel_56:)
			((param1 sel_56:) sel_57:)
		)
		(if
			(and
				(== local50 0)
				(not (param1 sel_56:))
				(not (param1 sel_224:))
				(== (param1 sel_4:) (param1 sel_225:))
				(or
					(< gMouseX (- local0 10))
					(> gMouseX (+ local0 10))
					(< gMouseY (- local1 10))
					(> gMouseY (+ local1 10))
				)
				(u< (= local50 (GetTime)) 15)
			)
			(= local50 15)
		)
		(if (and local50 (u> (GetTime) (+ local50 15)))
			(gLooperDir8 sel_57: param1 (param1 sel_55:))
			(gSound2 sel_39: 206 sel_165: 1)
			(param1 sel_4: 0 sel_296: MoveToEndLoop gMouseX gMouseY)
			(= local50 0)
		)
		(= local0 (param1 sel_1:))
		(= local1 (param1 sel_0:))
	)
)

(instance theArrow of Actor
	(properties
		sel_20 {theArrow}
		sel_1 32
		sel_0 166
		sel_2 850
		sel_4 1
	)
)

(instance checkDraw of Code
	(properties
		sel_20 {checkDraw}
	)

	(method (sel_57 &tmp temp0 temp1 temp2)
		(= temp1 0)
		(= temp2 0)
		(for ((= temp0 1)) (< temp0 33) ((++ temp0))
			(switch ([global200 temp0] sel_574:)
				(1
					(++ temp2)
					(+= temp1 2)
				)
				(2
					(++ temp2)
					(+= temp1 3)
				)
				(-1
					(++ temp2)
					(-= temp1 2)
				)
				(-2
					(++ temp2)
					(-= temp1 3)
				)
			)
		)
		(if global274
			(if (>= global249 (+ local54 20))
				(if (== temp2 local53)
					(return 1)
				else
					(= global274 0)
				)
			)
		else
			(= global274 1)
			(= local53 temp2)
			(= local54 global249)
		)
		(cond
			((< temp1 0)
				(return 1)
			)
			((> temp1 0)
				(return 0)
			)
			((== temp1 0)
				(return 1)
			)
		)
	)
)


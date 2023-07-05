;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 201)
(include sci.sh)
(use Main)
(use MoveToEndLoop)
(use checkers)
(use Interface)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	book 0
	gameScript 1
	checkers_opt 2
	splash 3
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 5]
	[local12 5]
)

(instance book of Code
	(properties
		sel_20 {book}
	)

	(method (sel_57 &tmp temp0)
		(global243 sel_586: 0)
		(cond
			((== global249 0)
				(global243 sel_584: 22)
				(global243 sel_585: 18)
			)
			((== global249 1)
				(cond
					((== global235 9)
						(if (== global236 13)
							(global243 sel_584: 22)
							(global243 sel_585: 18)
							(= global237 1)
						else
							(== global236 14)
							(global243 sel_584: 22)
							(global243 sel_585: 18)
							(= global237 2)
						)
					)
					((== global235 10)
						(if (== global236 14)
							(global243 sel_584: 22)
							(global243 sel_585: 17)
							(= global237 3)
						else
							(global243 sel_584: 21)
							(global243 sel_585: 17)
							(= global237 4)
						)
					)
					((== global235 11)
						(if (== global236 15)
							(global243 sel_584: 23)
							(global243 sel_585: 18)
							(= global237 5)
						else
							(global243 sel_584: 24)
							(global243 sel_585: 19)
							(= global237 6)
						)
					)
					((== global235 12)
						(global243 sel_584: 24)
						(global243 sel_585: 20)
						(= global237 7)
					)
					(else
						(global243 sel_584: 22)
						(global243 sel_585: 18)
					)
				)
			)
			((== global249 2)
				(if (== global236 16)
					(if (== global235 11)
						(global243 sel_584: 18)
						(global243 sel_585: 14)
					else
						(global243 sel_584: 24)
						(global243 sel_585: 20)
						(= global237 35)
					)
				else
					(global243 sel_584: 25)
					(global243 sel_585: 22)
				)
			)
			((== global249 3)
				(cond
					((== global237 1)
						(cond
							((== global235 12)
								(global243 sel_584: 24)
								(global243 sel_585: 20)
								(= global237 10)
							)
							((== global235 10)
								(global243 sel_584: 25)
								(global243 sel_585: 22)
								(= global237 11)
							)
							((== global235 11)
								(global243 sel_584: 25)
								(global243 sel_585: 22)
								(= global237 12)
							)
							(else
								(global243 sel_584: 26)
								(global243 sel_585: 22)
								(= global237 13)
							)
						)
					)
					((== global237 2)
						(global243 sel_584: 24)
						(global243 sel_585: 19)
						(= global237 14)
					)
					((== global237 3)
						(global243 sel_584: 17)
						(global243 sel_585: 13)
						(= global237 15)
					)
					((== global237 4)
						(cond
							((== global235 12)
								(global243 sel_584: 24)
								(global243 sel_585: 19)
							)
							((== global235 11)
								(global243 sel_584: 22)
								(global243 sel_585: 18)
							)
							((== global235 9)
								(global243 sel_584: 24)
								(global243 sel_585: 20)
								(= global237 16)
							)
							(else
								(global243 sel_584: 17)
								(global243 sel_585: 14)
							)
						)
					)
					((== global237 5)
						(global243 sel_584: 27)
						(global243 sel_585: 23)
						(= global237 17)
					)
					((== global237 6)
						(cond
							((and (== global235 9) (== global236 13))
								(global243 sel_584: 27)
								(global243 sel_585: 24)
								(= global237 18)
							)
							((or (== global235 9) (== global235 16))
								(global243 sel_584: 22)
								(global243 sel_585: 17)
							)
							(else
								(global243 sel_584: 22)
								(global243 sel_585: 18)
							)
						)
					)
					((== global237 7)
						(cond
							((and (== global235 10) (== global236 15))
								(global243 sel_584: 23)
								(global243 sel_585: 18)
							)
							((== global235 8)
								(global243 sel_584: 22)
								(global243 sel_585: 18)
							)
							(else
								(global243 sel_584: 28)
								(global243 sel_585: 24)
							)
						)
					)
				)
			)
			((== global249 4)
				(if (== global237 35)
					(global243 sel_584: 25)
					(global243 sel_585: 22)
				else
					(global243 sel_584: 29)
					(global243 sel_585: 25)
				)
			)
			((== global249 5)
				(cond
					((== global237 10)
						(cond
							((== global235 8)
								(global243 sel_584: 27)
								(global243 sel_585: 24)
							)
							((== global235 10)
								(global243 sel_584: 25)
								(global243 sel_585: 22)
							)
							(else
								(global243 sel_584: 26)
								(global243 sel_585: 22)
							)
						)
					)
					((== global237 11)
						(global243 sel_584: 24)
						(global243 sel_585: 20)
					)
					((== global237 12)
						(if (== global236 9)
							(global243 sel_584: 29)
							(global243 sel_585: 25)
						else
							(global243 sel_584: 18)
							(global243 sel_585: 14)
						)
					)
					((== global237 13)
						(if (== global235 11)
							(global243 sel_584: 31)
							(global243 sel_585: 26)
						else
							(global243 sel_584: 24)
							(global243 sel_585: 20)
						)
					)
					((== global237 14)
						(global243 sel_584: 25)
						(global243 sel_585: 22)
					)
					((== global237 15)
						(if
							(or
								(and (== global235 11) (== global236 15))
								(== global235 10)
							)
							(global243 sel_584: 25)
							(global243 sel_585: 22)
						else
							(global243 sel_584: 24)
							(global243 sel_585: 20)
						)
					)
					((== global237 16)
						(if (and (== global235 6) (== global236 9))
							(global243 sel_584: 17)
							(global243 sel_585: 14)
						)
					)
					((== global237 17)
						(cond
							((== global235 9)
								(global243 sel_584: 18)
								(global243 sel_585: 14)
							)
							((== global235 12)
								(global243 sel_584: 24)
								(global243 sel_585: 19)
							)
							((== global236 8)
								(global243 sel_584: 23)
								(global243 sel_585: 19)
							)
							((== global235 10)
								(global243 sel_584: 22)
								(global243 sel_585: 17)
							)
						)
					)
					((== global237 18)
						(if (== global235 16)
							(global243 sel_584: 31)
							(global243 sel_585: 27)
						else
							(global243 sel_584: 22)
							(global243 sel_585: 18)
						)
					)
				)
			)
		)
	)
)

(instance gameScript of Script
	(properties
		sel_20 {gameScript}
	)

	(method (sel_143 param1 &tmp temp0)
		(switch (= sel_29 param1)
			(0
				(= global252 0)
				(= global181 0)
				(= global253 0)
				(= global250 0)
				(= global249 0)
				(= global235 0)
				(= global240 0)
				(= global241 0)
				(= global255 0)
				(= global243 (ScriptID 202 0)) ; root
				(= global242 0)
				(= global245 0)
				(= global246 0)
				(= global268 0)
				(= global267 0)
				(= local2 0)
				(= local3 0)
				(= global262 0)
				(= global260 0)
				(= local5 0)
				(= local6 0)
				(= global269 1)
				(= global270 1)
				(= global274 0)
				(Format @local7 299 18) ; "Y"
				(Format @local12 299 19) ; "N"
				(= sel_135 1)
			)
			(1
				(cond
					((and (== (global178 sel_31:) 1) ((ScriptID 203 5) sel_57:)) ; lostGame
						(if (== global178 (ScriptID 200 7)) ; player2
							(gSong sel_39: 803 sel_165: -1)
							(if (== global188 2)
								(Print
									(Format ; "Congratulations %s. You win!"
										@global550
										299
										1
										((ScriptID 200 6) sel_510:) ; player1
									)
								)
							else
								(gChar1 sel_446: (Random 36 38) 0 444)
							)
							((ScriptID 200 6) ; player1
								sel_563: (+ ((ScriptID 200 6) sel_563:) 1) ; player1
							)
							((ScriptID 200 7) ; player2
								sel_564: (+ ((ScriptID 200 7) sel_564:) 1) ; player2
							)
							(proc200_2)
						else
							(if (== global188 2)
								(Print
									(Format ; "Congratulations %s. You win!"
										@global550
										299
										1
										((ScriptID 200 7) sel_510:) ; player2
									)
								)
							else
								(gSong sel_39: 906 sel_165: 1)
								(gChar1 sel_446: (Random 33 35) 0 445)
							)
							(Wait 1)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 100)
							((ScriptID 200 7) ; player2
								sel_563: (+ ((ScriptID 200 7) sel_563:) 1) ; player2
							)
							((ScriptID 200 6) ; player1
								sel_564: (+ ((ScriptID 200 6) sel_564:) 1) ; player1
							)
							(proc200_2)
						)
						((ScriptID 200 8) sel_119: 497) ; squares
						((ScriptID 200 1) sel_119: 497) ; pieces
						(= sel_29 4)
						(self sel_144:)
					)
					((== (global178 sel_31:) 2)
						(proc0_4)
						(if local5
							(= local5 0)
							(gChar1 sel_446: (Random 30 32) 0 444)
							(if (== global270 2)
								(= global270 3)
							)
						else
							(if global273
								(= global273 0)
								(gSong sel_39: 202 sel_165: 1)
							)
							(if (== global270 2)
								(= global270 3)
								(gChar1 sel_446: (Random 24 26) 0 445 3)
							)
						)
						(gGame sel_191: 981)
						(= global247 (GetTime))
						(if (not ((ScriptID 202 0) sel_589:)) ; root
							((ScriptID 202 0) sel_577: (ScriptID 202 0)) ; root, root
							((ScriptID 202 0) sel_125:) ; root
							(gSong sel_39: 906 sel_165: 1)
							(gChar1 sel_446: (Random 33 35) 0 445)
							(Wait 1)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 100)
							((ScriptID 200 7) ; player2
								sel_563: (+ ((ScriptID 200 7) sel_563:) 1) ; player2
							)
							((ScriptID 200 6) ; player1
								sel_564: (+ ((ScriptID 200 6) sel_564:) 1) ; player1
							)
							(proc200_2)
							((ScriptID 200 8) sel_119: 497) ; squares
							((ScriptID 200 1) sel_119: 497) ; pieces
							(= sel_29 4)
							(= sel_138 1)
						)
					)
					(else
						(if global273
							(= global273 0)
							(gSong sel_39: 202 sel_165: 1)
						)
						(cond
							((== global269 2)
								(= global269 3)
								(gChar1 sel_446: (Random 27 29) 0 443 3)
							)
							(local6
								(= local6 0)
								(gChar1 sel_443:)
							)
						)
						(proc0_3)
						(if (== (global178 sel_526:) -1)
							(gTheArrow sel_165: 2)
						else
							(gTheArrow sel_165: 3)
						)
					)
				)
			)
			(2
				(if global250
					(proc0_4)
					(global250 sel_63: 15 sel_566: 99 sel_51: 14 sel_52: 10)
					(if (== global266 200)
						(= local4 0)
						(gSound2 sel_39: 904 sel_165: 1)
						(global250 sel_296: MoveTo 350 100 self)
					else
						(= local1 (Random 80 140))
						(= local0 (Random 15 50))
						(= local4 1)
						(gSound2 sel_39: 204 sel_165: 1)
						(global250 sel_296: MoveToEndLoop local0 local1 self)
					)
				else
					(= sel_135 1)
				)
			)
			(3
				(if global253
					(global253 sel_283: sel_63: 10)
				)
				(= local3 0)
				(if global250
					(if (== global266 200)
						(gSound sel_39: 203)
					)
					(= temp0 (Random 1 3))
					(if (and (== (global178 sel_31:) 1) (== temp0 3))
						(gChar1 sel_445:)
					)
					(= local3 global250)
					(if (and (== global266 250) local4)
						(splash sel_110: self global250)
					)
					(global250 sel_282: 400 100 sel_283: sel_63: 10)
				)
				(= global250 0)
				(if global245
					(if (== (global178 sel_31:) 2)
						(= local6 1)
						(= sel_29 1)
						((ScriptID 202 0) sel_596:) ; root
					else
						(cond
							((and (== global188 2) (not global244))
								(proc0_3)
								(if
									(Print ; "Jump Again?"
										299
										2
										78
										@local7
										0
										78
										@local12
										1
										64
										5
										80
									)
									(= sel_135 1)
									(return)
								)
							)
							((not gModelessDialog)
								(Print 299 4 64 10 100 111) ; "Jump Again"
							)
						)
						(= local5 1)
						(if (== global266 200)
							(= sel_29 1)
							(proc0_3)
						else
							(= sel_29 0)
						)
					)
				else
					(= sel_135 1)
				)
			)
			(4
				(= global250 0)
				(= global245 0)
				(= sel_29 0)
				(++ global249)
				(if gModelessDialog
					(gModelessDialog sel_111:)
				)
				(switch (global178 sel_31:)
					(1
						(cond
							((== global188 1)
								(gTheArrow sel_165: 3)
								(= global178 (ScriptID 200 6)) ; player1
								(if
									(or
										(== global266 200)
										(== local4 0)
										(not local3)
									)
									(= sel_135 1)
								)
							)
							((== global178 (ScriptID 200 6)) ; player1
								(= global178 (ScriptID 200 7)) ; player2
								(if
									(or
										(== global266 200)
										(== local4 0)
										(not local3)
									)
									(gTheArrow sel_165: 2)
									(= sel_135 1)
								)
							)
							(else
								(= global178 (ScriptID 200 6)) ; player1
								(if
									(or
										(== global266 200)
										(== local4 0)
										(not local3)
									)
									(gTheArrow sel_165: 3)
									(= sel_135 1)
								)
							)
						)
					)
					(2
						((ScriptID 202 0) sel_577: (ScriptID 202 0)) ; root, root
						((ScriptID 202 0) sel_125:) ; root
						(= global178 (ScriptID 200 7)) ; player2
						(if (or (== global266 200) (== local4 0) (not local3))
							(gTheArrow sel_165: 2)
							(= sel_135 1)
						)
					)
				)
			)
			(5
				(= sel_29 -1)
				(= sel_138 1)
			)
		)
	)
)

(instance tmp_out of File ; UNUSED
	(properties
		sel_20 {tmp.out}
	)

	(method (sel_57 &tmp [temp0 80])
		(Format ; "%3d%3d%3d%3d"
			@temp0
			201
			0
			global235
			global236
			(global243 sel_584:)
			(global243 sel_585:)
		)
		(self sel_183: 0 sel_328: @temp0 sel_332:)
	)
)

(instance checkers_opt of File
	(properties
		sel_20 {checkers.opt}
	)

	(method (sel_57 param1 &tmp [temp0 20] [temp20 8])
		(cond
			((and argc (== param1 3))
				(if (self sel_183: 2)
					(self
						sel_328: (Format @temp0 201 1 global244 global266) ; "%d%3d"
						sel_332:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self sel_183: 1)
				(= global244 (ReadNumber (self sel_327: @temp20 2)))
				(if (!= global188 2)
					(= global244 1)
				)
				(if
					(and
						(!=
							(= global266 (ReadNumber (self sel_327: @temp20 4)))
							200
						)
						(!= global266 250)
					)
					(= global266 200)
				)
				(self sel_332:)
				(return 0)
			)
			(else
				(= global244 1)
				(= global266 200)
				(return 0)
			)
		)
	)
)

(instance splash of Prop
	(properties
		sel_20 {splash}
	)

	(method (sel_110 param1 param2)
		(gSound2 sel_159:)
		(gSound2 sel_39: 903 sel_165: 1)
		(= local2 param2)
		(local2 sel_282: 400 100)
		(if (== (global178 sel_526:) -1)
			(local2 sel_3: 2 sel_4: 0)
		else
			(local2 sel_3: 3 sel_4: 0)
		)
		(self
			sel_2: 275 sel_276 14
			sel_282: local0 local1
			sel_165: 0
			sel_287:
			sel_198:
			sel_223: 5
			sel_153: End self
		)
		(proc0_1)
		(super sel_110: &rest)
	)

	(method (sel_144)
		(self sel_102: sel_4: 0 sel_284:)
		(proc0_1)
		(local2 sel_296: 0)
		(gameScript sel_144:)
	)
)


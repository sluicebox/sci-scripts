;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
(include sci.sh)
(use Main)
(use Interface)
(use dummyPublic0)
(use Feature)
(use Motion)
(use System)

(local
	[local0 15] = [6 6 6 6 6 8 8 8 13 13 13 13 13 24 24]
	[local15 25] = [0 11 12 14 15 15 17 6 6 5 3 2 3 0 0 1 1 0 1 0 1 0 0 0 1]
	[local40 162] = [8 24 8 6 13 9 13 24 13 7 13 10 8 6 13 8 24 24 13 9 8 6 24 24 13 24 8 6 24 18 24 24 6 6 13 13 6 6 13 13 6 6 13 13 6 6 13 13 8 8 24 24 13 13 13 24 8 6 13 24 13 24 13 8 24 13 8 6 13 13 24 18 13 24 8 6 24 18 13 13 24 18 24 18 8 8 6 6 13 13 6 6 8 8 6 6 13 13 24 24 13 13 8 8 24 24 13 13 13 11 8 6 13 6 13 6 13 8 13 13 8 6 13 13 24 13 13 13 13 13 24 13 13 13 24 18 24 18 8 8 6 6 13 13 6 6 24 24 8 8 13 13 24 24 13 13 8 8 24 24 13 13]
	[local202 6] = [0 31 56 75 88 97]
	[local208 6] = [0 3 11 25 44 69]
	local214
	local215
	local216
	local217
	local218
	local219
	local220
	local221
	local222
	local223
	local224
	local225
	local226
	local227
	local228
	local229
	local230
	local231
	local232
	local233
	local234
	local235
	local236
	local237
	local238
	local239
	local240
	local241
	local242
	local243
	local244
	local245
	local246
	local247
	local248
	local249
)

(class BGPlayer of List
	(properties
		sel_20 {BGPlayer}
		sel_31 1
		sel_526 1
		sel_530 0
		sel_525 0
		sel_531 0
		sel_534 2
		sel_533 0
		sel_524 0
		sel_535 0
		sel_512 0
		sel_527 0
		sel_391 0
		sel_513 0
		sel_514 0
		sel_510 0
		sel_511 0
		sel_528 0
		sel_529 0
	)

	(method (sel_560 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(= temp1 (Event sel_109:))
		(= temp5 (self sel_554: 1 0))
		(= temp6
			(or
				(self sel_554: 2 0)
				(self
					sel_554: -1 (+ (gTheDice1 sel_482:) (gTheDice2 sel_482:)) 2
				)
			)
		)
		(if (not (or param2 (= param2 (self sel_120: 132 temp1 global181))))
			(temp1 sel_111:)
			(self sel_552: param1 0 0)
			(return 0)
		)
		(temp1 sel_111:)
		(= temp9 (gTheDice1 sel_1:))
		(= temp11 (gTheDice1 sel_0:))
		(= temp10 (gTheDice2 sel_1:))
		(= temp12 (gTheDice2 sel_0:))
		(if
			(and
				(> (= temp0 (- (param1 sel_40:) (param2 sel_40:))) 0)
				(self sel_532: (param2 sel_40:))
				(self sel_556: param2 param1)
			)
			(global181 sel_283: sel_461:)
			(if (!= (param1 sel_131: local214) (- (param1 sel_86:) 1))
				(param1 sel_81: local214 sel_118: local214)
			)
			(self sel_540: param1 param2)
			(if (not (gTheDice1 sel_483:))
				(= temp7 gTheDice1)
				(= temp8 gTheDice2)
				(= temp3 temp10)
				(= temp4 temp12)
			else
				(= temp7 gTheDice2)
				(= temp8 gTheDice1)
				(= temp3 temp9)
				(= temp4 temp11)
			)
			(if sel_391
				(self sel_536: 1)
				(if
					(and
						(sel_531 sel_86:)
						(== (gTheDiceList sel_501:) 1)
						(not
							(or
								(and temp5 temp6)
								(gTheDiceList sel_500:)
								(sel_530 sel_86:)
								(temp7 sel_483:)
								(self sel_553:)
							)
						)
					)
					(self sel_541: param2 param1)
					(gSound sel_39: 905)
					(if (not temp6)
						(gChar1 sel_446: 399 22 -32768)
					else
						(gChar1 sel_446: (Random 30 32) -32768)
					)
					(gTheDiceList sel_501: (- (gTheDiceList sel_501:) 1) sel_507:)
					(temp8 sel_282: temp3 temp4 sel_496: 0)
					(self sel_552: param1 0 0 sel_536: 1)
					(return 0)
				)
			)
			(gACast sel_125:)
			(if (param2 sel_471:)
				(gACast sel_118: (NodeValue (param2 sel_124:)))
			)
			(self sel_541: param2 param1)
			(self sel_536: 1)
			(self sel_542: param1 param2)
			(self sel_536: 0)
			(if (& param3 $0004)
				(proc0_4)
				(if global305
					(++ global305)
				)
				(param2 sel_479:)
			else
				(param1 sel_478:)
				(param2 sel_478: sel_144:)
				(Animate (gACast sel_24:) 0)
			)
			(return 1)
		else
			(self sel_552: param1 temp0 (== param2 sel_525))
			(return 0)
		)
	)

	(method (sel_559 param1 param2)
		(if
			(and
				(== param1 sel_525)
				(sel_525 sel_86:)
				(sel_525 sel_122: local214)
			)
			(gSound sel_39: 905)
			(gChar1 sel_446: (Random 33 35) -32768)
			(return 0)
		)
		(if (and (sel_530 sel_86:) (!= param1 sel_530))
			(cond
				((not global336)
					(gSound sel_39: 905)
					(gChar1 sel_446: (Random 36 38) -32768)
					(return 0)
				)
				(sel_535
					(gSound sel_39: 905)
					(gChar1
						sel_446: (Format @global550 399 23 sel_535) -32768 ; "You have %d stones on the bar which must be removed first."
					)
					(return 0)
				)
			)
		)
		(local214 sel_63: 15)
		(return
			(and
				(== (local214 sel_460: param2) 1)
				global181
				(self sel_560: param1 0 (param2 sel_31:))
			)
		)
	)

	(method (sel_561)
		(if (== (gTheDiceList sel_501:) (gTheDiceList sel_86:))
			(gSound sel_39: 905)
			(gChar1 sel_446: (Random 39 41) -32768)
			(return 1)
		)
	)

	(method (sel_132 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (setupButton sel_132: param1)
			(return 0)
		)
		(cond
			((not global337)
				(if (== sel_31 2)
					(return 0)
				)
				(cond
					(
						(and
							(= local214 (gAllStonesObj sel_120: 132 param1))
							(== (param1 sel_31:) 1)
						)
						(if (self sel_561:)
							(return 0)
						)
						(if (!= (local214 sel_25:) sel_526)
							(gSound sel_39: 905)
							(gChar1 sel_446: (Random 42 44) -32768)
							(return 0)
						)
						(for ((= temp6 0)) (< temp6 local216) ((++ temp6))
							(if
								((= temp2 (sel_531 sel_64: temp6))
									sel_122: local214
								)
								(break)
							)
						)
						(= temp5 (temp2 sel_86:))
						(for ((= temp6 0)) (< temp6 temp5) ((++ temp6))
							(if (== local214 (temp2 sel_64: temp6))
								(break)
							)
						)
						(if (== temp6 temp5)
							(return 0)
						)
						(temp2 sel_480: (mod temp6 5) local214)
						(self sel_559: temp2 param1)
					)
					(
						(and
							(!= (param1 sel_31:) 1)
							(= temp2 (gThePoints sel_120: 132 param1))
						)
						(if (self sel_561:)
							(return 0)
						)
						(if global181
							(= local214 global181)
							(= temp1 temp2)
							(= temp5 (gThePoints sel_86:))
							(for ((= temp6 0)) (< temp6 temp5) ((++ temp6))
								(if
									((= temp2 (gThePoints sel_64: temp6))
										sel_122: local214
									)
									(break)
								)
							)
							(self sel_560: temp2 temp1 (param1 sel_31:))
						else
							(if (not (= temp5 (temp2 sel_86:)))
								(return 0)
							)
							(if (== (temp2 sel_469:) sel_534)
								(gSound sel_39: 905)
								(gChar1 sel_446: (Random 42 44) -32768)
								(return 0)
							)
							(= local214 (NodeValue (temp2 sel_126:)))
							(= temp6 (mod (- temp5 1) 5))
							(temp2 sel_480: temp6 local214)
							(self sel_559: temp2 param1)
						)
					)
				)
			)
			((= local214 (gAllStonesObj sel_120: 132 param1))
				(= temp2 0)
				(for ((= temp6 0)) (< temp6 (gThePoints sel_86:)) ((++ temp6))
					(if
						(and
							((gThePoints sel_64: temp6) sel_86:)
							((gThePoints sel_64: temp6) sel_122: local214)
						)
						(= temp2 (gThePoints sel_64: temp6))
						(if (== (temp2 sel_469:) (global178 sel_534:))
							(= global178 (global178 sel_524:))
						)
						(break)
					)
				)
				(global178 sel_537: sel_536: 1)
				(if (and (== (local214 sel_460: param1) 1) global181)
					(= temp0 (Event sel_109:))
					(if (not (= temp1 (global178 sel_120: 132 temp0 global181)))
						(temp0 sel_111:)
						(global178 sel_552: temp2 1 (== temp1 sel_525))
						(return 0)
					)
					(temp0 sel_111:)
					(if (!= (global178 sel_534:) (temp1 sel_469:))
						(proc0_1)
						(global181 sel_283:)
						(if (!= local214 (NodeValue (temp2 sel_126:)))
							(temp2 sel_81: local214 sel_118: local214)
						)
						(= global325 0)
						(global178 sel_542: temp2 temp1 sel_538: temp1 temp2 -1)
						(gACast sel_125:)
						(temp2 sel_478:)
						(temp1 sel_478: sel_144:)
						(proc0_1)
						(gGamePlayScript sel_135: 1)
						(return 1)
					else
						(global178 sel_552: temp2 temp3 (== temp1 sel_525)) ; UNINIT
						(return 0)
					)
				)
			)
		)
	)

	(method (sel_556 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (gTheDiceList sel_86:))
		(= temp1 (gTheDiceList sel_503: param2 param1))
		(for ((= temp5 0)) (< temp5 temp0) ((++ temp5))
			(if
				(and
					(not ((= temp2 (gTheDiceList sel_64: temp5)) sel_483:))
					(== temp1 (temp2 sel_482:))
				)
				(temp2 sel_483: param2 sel_484: param1)
				(gTheDiceList sel_508: temp5 0)
				(return 1)
			)
		)
		(for ((= temp5 0)) (< temp5 temp0) ((++ temp5))
			(if (not ((= temp2 (gTheDiceList sel_64: temp5)) sel_483:))
				(if (> temp1 (temp2 sel_482:))
					(return 0)
				else
					(break)
				)
			)
		)
		(if
			(and
				(>= ((= temp3 (NodeValue (sel_531 sel_124:))) sel_40:) temp1)
				(== temp3 param2)
				(== param1 sel_525)
			)
			(temp2 sel_483: param2 sel_484: param1)
			(gTheDiceList sel_508: temp5 0)
			(return 1)
		)
		(return 0)
	)

	(method (sel_552 param1 param2 param3)
		(proc0_4)
		(global181
			sel_53: 0
			sel_51: (* (global181 sel_51:) 3)
			sel_52: (* (global181 sel_52:) 3)
			sel_461:
		)
		(local214 sel_481: param1 (param1 sel_131: local214))
		(local214 sel_63: 15)
		(proc0_1)
		(local214 sel_296: MoveTo global306 global307 param1)
		(if param2
			(gSound sel_39: 905)
			(if (and param3 (> ((NodeValue (sel_531 sel_124:)) sel_40:) 6))
				(gChar1 sel_446: (Random 57 59) -32768)
			else
				(gChar1 sel_446: (Random 9 11) -32768)
			)
		else
			(gSound sel_39: 904)
		)
	)

	(method (sel_542 param1 param2 &tmp temp0)
		(self sel_540: param1 param2)
		(= global326
			(if (== (param1 sel_472:) (param2 sel_472:))
				(- (param1 sel_472:))
			else
				0
			)
		)
		(if (param2 sel_471:)
			(= temp0 (NodeValue (param2 sel_126:)))
			(temp0 sel_60: 11 sel_14: (| (temp0 sel_14:) $0010))
			(param2 sel_81: temp0 sel_471: 0)
			(sel_533 sel_118: temp0)
			(sel_524 sel_391: (+ (sel_524 sel_391:) (param2 sel_40:)))
			(= global305 (if (== sel_31 1) 1 else 2))
			(if global336
				(sel_524 sel_535: (+ (sel_524 sel_535:) 1))
			)
		)
		(if (and global336 (== param1 sel_530) sel_535)
			(-- sel_535)
		)
		(param1 sel_81: (= temp0 (NodeValue (param1 sel_126:))))
		(param2 sel_118: temp0)
		(-= sel_391 (- (param1 sel_40:) (param2 sel_40:)))
	)

	(method (sel_558 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 (= temp4 0))
		(= temp6 13)
		(= temp7 param1)
		(while (and (<= (++ temp4) 6) (<= (++ temp7) 25))
			(if (== ((= temp1 (sel_524 sel_64: temp7)) sel_469:) sel_534)
				(+= temp0 (-= temp6 2))
			else
				(= temp5 0)
				(= temp3 (+ temp4 param1))
				(while (and (< (++ temp5) temp4) (<= (++ temp3) 25))
					(if (== ((sel_524 sel_64: temp3) sel_469:) sel_534)
						(cond
							((not (temp1 sel_468:))
								(+= temp0 2)
							)
							(
								(or
									(!=
										((= temp2
												(sel_524
													sel_64: (+ temp5 param1)
												)
											)
											sel_469:
										)
										sel_526
									)
									(temp2 sel_467:)
								)
								(+= temp0 2)
								(if (== (temp2 sel_469:) sel_534)
									(-= temp6 2)
								)
							)
						)
					)
					1
				)
				(cond
					((temp1 sel_468:))
					(
						(and
							(<= (= temp5 (+ temp4 temp7)) 25)
							(==
								((= temp1 (sel_524 sel_64: temp5)) sel_469:)
								sel_534
							)
						)
						(++ temp0)
					)
					((temp1 sel_468:))
					(
						(and
							(<= (+= temp5 temp4) 25)
							(==
								((= temp1 (sel_524 sel_64: temp5)) sel_469:)
								sel_534
							)
						)
						(++ temp0)
					)
					((temp1 sel_468:))
					(
						(and
							(<= (+= temp5 temp4) 25)
							(==
								((= temp1 (sel_524 sel_64: temp5)) sel_469:)
								sel_534
							)
						)
						(++ temp0)
					)
				)
			)
			1
		)
		(if (<= param1 6)
			(return temp0)
		)
		(cond
			((sel_533 sel_467:)
				(return (/ (* temp0 [local202 local243]) 100))
			)
			((sel_533 sel_468:)
				(return (/ (* temp0 [local208 local243]) 100))
			)
			(else
				(return temp0)
			)
		)
	)

	(method (sel_539 param1 param2 &tmp temp0 temp1)
		(param2
			sel_473: (= temp1 (+ (param2 sel_473:) 1))
			sel_467: (== temp1 1)
			sel_468: (>= temp1 2)
			sel_469: (param1 sel_469:)
		)
		(if (not (= temp0 (- (param1 sel_473:) 1)))
			(param1 sel_469: 2 sel_473: 0 sel_467: 0)
		else
			(param1 sel_473: temp0 sel_467: (== temp0 1) sel_468: (>= temp0 2))
		)
	)

	(method (sel_540 param1 param2)
		(cond
			((== (param2 sel_469:) sel_534)
				(self sel_539: param2 sel_533)
				(param2 sel_471: 1)
			)
			((param2 sel_471:)
				(param2 sel_471: (+ (param2 sel_471:) 1))
			)
		)
		(self sel_539: param1 param2)
	)

	(method (sel_541 param1 param2)
		(self sel_539: param1 param2)
		(if (param1 sel_471:)
			(param1 sel_471: (- (param1 sel_471:) 1))
			(if (not (or (param1 sel_473:) (param1 sel_471:)))
				(self sel_539: sel_533 param1)
			)
		)
	)

	(method (sel_532 param1 &tmp temp0)
		(cond
			((> param1 0)
				(if
					(or
						(!= ((= temp0 (self sel_64: param1)) sel_469:) sel_534)
						(temp0 sel_467:)
					)
					(return temp0)
				)
			)
			((not global331)
				(return sel_525)
			)
		)
		(return 0)
	)

	(method (sel_538 param1 param2 param3)
		(if (and (param1 sel_467:) (param1 sel_40:))
			(cond
				((< param3 0)
					(sel_531 sel_130: param2 param1)
				)
				(param3
					(sel_531 sel_130: (sel_531 sel_64: (- param3 1)) param1)
				)
				(else
					(sel_531 sel_128: param1)
				)
			)
			(++ local216)
			(if (> (param1 sel_40:) 6)
				(++ global331)
			)
		)
		(if (and (!= (param2 sel_469:) sel_526) (param2 sel_40:))
			(sel_531 sel_81: param2)
			(-- local216)
			(if (> (param2 sel_40:) 6)
				(-- global331)
			)
		)
	)

	(method (sel_554 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0 (gTheDiceList sel_86:))
		(= temp2 ((NodeValue (sel_531 sel_124:)) sel_40:))
		(for ((= temp5 0)) (< temp5 local216) ((++ temp5))
			(cond
				((>= param1 0)
					(for ((= temp6 0)) (< temp6 temp0) ((++ temp6))
						(if
							(and
								(or (not param1) (== (+ temp6 1) param1))
								(or
									(not
										((= temp1 (gTheDiceList sel_64: temp6))
											sel_483:
										)
									)
									[param1 1]
								)
								(self
									sel_532:
										(-
											(= temp3
												((sel_531 sel_64: temp5)
													sel_40:
												)
											)
											(= temp4 (temp1 sel_482:))
										)
								)
								(or (>= temp3 temp4) (== temp2 temp3))
							)
							(return 0)
						)
					)
				)
				(
					(and
						(self
							sel_532:
								(-
									(= temp3 ((sel_531 sel_64: temp5) sel_40:))
									[param1 1]
								)
						)
						(self
							sel_532:
								(-
									temp3
									((gTheDiceList sel_64: (- [param1 2] 1))
										sel_482:
									)
								)
						)
					)
					(return 0)
				)
			)
		)
		(return 1)
	)

	(method (sel_553 &tmp temp0 temp1 temp2 temp3)
		(if (self sel_554: 0 0)
			(return 0)
		else
			(= temp2 (= temp0 (gTheDiceList sel_86:)))
			(if (and (sel_530 sel_86:) (or (not global336) sel_535))
				(for ((= temp3 0)) (< temp3 temp2) ((++ temp3))
					(if
						(or
							(not
								(self
									sel_532:
										(-
											25
											((= temp1 (gTheDiceList sel_64: temp3))
												sel_482:
											)
										)
								)
							)
							(temp1 sel_483:)
						)
						(-- temp0)
					)
				)
				(if (<= (sel_530 sel_473:) temp0)
					(= temp0 temp2)
				)
			)
			(return temp0)
		)
	)

	(method (sel_543 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 [temp19 40])
		(proc0_1)
		(= local244 (GetTime))
		(= local218 (= temp12 (= local245 (= local246 0))))
		(= local217 -32767)
		(= local215 (self sel_553:))
		(while local215
			(-- local215)
			(if (gTheDiceList sel_500:)
				(= temp15 global331)
				(= temp13 (gTheDice1 sel_482:))
				(for ((= temp0 0)) (< temp0 local216) ((++ temp0))
					(if
						(= temp8
							(self
								sel_532:
									(-
										((= temp4 (sel_531 sel_64: temp0))
											sel_40:
										)
										temp13
									)
							)
						)
						(self sel_540: temp4 temp8)
						(cond
							(local215
								(self sel_538: temp8 temp4 -1)
								(= temp16 global331)
								(for
									((= temp1
										(if (and (not global331) temp15)
											0
										else
											temp0
										)
									))
									(< temp1 local216)
									((++ temp1))
									
									(if
										(= temp9
											(self
												sel_532:
													(-
														((= temp5
																(sel_531
																	sel_64:
																		temp1
																)
															)
															sel_40:
														)
														temp13
													)
											)
										)
										(self sel_540: temp5 temp9)
										(cond
											((>= local215 2)
												(self sel_538: temp9 temp5 -1)
												(= temp17 global331)
												(for
													((= temp2
														(if
															(and
																(not global331)
																temp16
															)
															0
														else
															temp1
														)
													))
													(< temp2 local216)
													((++ temp2))
													
													(if
														(= temp10
															(self
																sel_532:
																	(-
																		((=
																				temp6
																				(sel_531
																					sel_64:
																						temp2
																				)
																			)
																			sel_40:
																		)
																		temp13
																	)
															)
														)
														(self
															sel_540:
																temp6
																temp10
														)
														(cond
															((>= local215 3)
																(self
																	sel_538:
																		temp10
																		temp6
																		-1
																)
																(for
																	((= temp3
																		(if
																			(and
																				(not
																					global331
																				)
																				temp17
																			)
																			0
																		else
																			temp2
																		)
																	))
																	(<
																		temp3
																		local216
																	)
																	((++ temp3))
																	
																	(if
																		(=
																			temp11
																			(self
																				sel_532:
																					(-
																						((=
																								temp7
																								(sel_531
																									sel_64:
																										temp3
																								)
																							)
																							sel_40:
																						)
																						temp13
																					)
																			)
																		)
																		(self
																			sel_540:
																				temp7
																				temp11
																		)
																		(if
																			(=
																				temp14
																				(self
																					sel_544:
																						temp4
																						temp5
																						temp6
																						temp7
																						temp8
																						temp9
																						temp10
																						temp11
																				)
																			)
																			(++
																				temp12
																			)
																			(self
																				sel_550:
																					temp14
																					temp8
																					temp4
																					temp9
																					temp5
																					temp10
																					temp6
																					temp11
																					temp7
																			)
																		)
																		(self
																			sel_541:
																				temp11
																				temp7
																		)
																	)
																)
															)
															(
																(= temp14
																	(self
																		sel_544:
																			temp4
																			temp5
																			temp6
																			temp8
																			temp9
																			temp10
																	)
																)
																(++ temp12)
																(self
																	sel_550:
																		temp14
																		temp8
																		temp4
																		temp9
																		temp5
																		temp10
																		temp6
																)
															)
														)
														(self
															sel_541:
																temp10
																temp6
														)
														(if (>= local215 3)
															(self
																sel_538:
																	temp6
																	temp10
																	temp2
															)
														)
													)
												)
											)
											(
												(= temp14
													(self
														sel_544:
															temp4
															temp5
															temp8
															temp9
													)
												)
												(++ temp12)
												(self
													sel_550:
														temp14
														temp8
														temp4
														temp9
														temp5
												)
											)
										)
										(self sel_541: temp9 temp5)
										(if (>= local215 2)
											(self sel_538: temp5 temp9 temp1)
										)
									)
								)
							)
							((= temp14 (self sel_544: temp4 temp8))
								(++ temp12)
								(self sel_550: temp14 temp8 temp4)
							)
						)
						(self sel_541: temp8 temp4)
						(if local215
							(self sel_538: temp4 temp8 temp0)
						)
					)
				)
			else
				(for ((= temp0 0)) (< temp0 local216) ((++ temp0))
					(if
						(= temp8
							(self
								sel_532:
									(-
										((= temp4 (sel_531 sel_64: temp0))
											sel_40:
										)
										(gTheDice1 sel_482:)
									)
							)
						)
						(self sel_540: temp4 temp8)
						(cond
							(local215
								(self sel_538: temp8 temp4 -1)
								(for
									((= temp1 0))
									(< temp1 local216)
									((++ temp1))
									
									(if
										(= temp9
											(self
												sel_532:
													(-
														((= temp5
																(sel_531
																	sel_64:
																		temp1
																)
															)
															sel_40:
														)
														(gTheDice2 sel_482:)
													)
											)
										)
										(self sel_540: temp5 temp9)
										(if
											(= temp14
												(self
													sel_544:
														temp4
														temp5
														temp8
														temp9
												)
											)
											(++ temp12)
											(self
												sel_550:
													temp14
													temp8
													temp4
													temp9
													temp5
											)
										)
										(self sel_541: temp9 temp5)
									)
								)
							)
							((= temp14 (self sel_544: temp4 temp8))
								(++ temp12)
								(self sel_550: temp14 temp8 temp4)
							)
						)
						(self sel_541: temp8 temp4)
						(if local215
							(self sel_538: temp4 temp8 temp0)
						)
					)
				)
				(if
					(= temp8
						(self
							sel_532:
								(-
									((= temp4 (NodeValue (sel_531 sel_124:)))
										sel_40:
									)
									(gTheDice2 sel_482:)
								)
						)
					)
					(= temp10 global331)
					(self sel_540: temp4 temp8)
					(if local215
						(self sel_538: temp8 temp4 -1)
						(if
							(and
								local216
								(not global331)
								temp10
								(not (self sel_554: 1 1))
							)
							(for ((= temp1 0)) (< temp1 local216) ((++ temp1))
								(if
									(= temp9
										(self
											sel_532:
												(-
													((= temp5
															(sel_531
																sel_64: temp1
															)
														)
														sel_40:
													)
													(gTheDice1 sel_482:)
												)
										)
									)
									(self sel_540: temp5 temp9)
									(if
										(= temp14
											(self
												sel_544: temp5 temp4 temp9 temp8
											)
										)
										(++ temp12)
										(self
											sel_550:
												temp14
												temp8
												temp4
												temp9
												temp5
										)
									)
									(self sel_541: temp9 temp5)
								)
							)
						)
					)
					(self sel_541: temp8 temp4)
					(if local215
						(self sel_538: temp4 temp8 0)
					)
				)
				(for ((= temp0 0)) (< temp0 local216) ((++ temp0))
					(if
						(= temp8
							(self
								sel_532:
									(-
										((= temp4 (sel_531 sel_64: temp0))
											sel_40:
										)
										(gTheDice2 sel_482:)
									)
							)
						)
						(self sel_540: temp4 temp8)
						(cond
							(local215
								(if
									(and
										(temp8 sel_467:)
										(= temp9
											(self
												sel_532:
													(-
														(temp8 sel_40:)
														(gTheDice1 sel_482:)
													)
											)
										)
										(!= temp8 sel_525)
									)
									(self sel_540: temp8 temp9)
									(if
										(= temp14
											(self
												sel_544: temp8 temp4 temp9 temp8
											)
										)
										(++ temp12)
										(if (!= temp9 sel_525)
											(gTheDiceList
												sel_81: gTheDice2
												sel_128: gTheDice2
											)
										)
										(self
											sel_550:
												temp14
												temp8
												temp4
												temp9
												temp8
										)
									)
									(self sel_541: temp9 temp8)
								)
							)
							((= temp14 (self sel_544: temp4 temp8))
								(++ temp12)
								(self sel_550: temp14 temp8 temp4)
							)
						)
						(self sel_541: temp8 temp4)
					)
				)
			)
			(if temp12
				(break)
			)
		)
		(= temp0 1)
		(= temp1 (gTheDiceList sel_86:))
		(while (< temp0 temp1)
			(if (== sel_530 ((= temp4 (gTheDiceList sel_64: temp0)) sel_483:))
				(gTheDiceList sel_81: temp4 sel_128: temp4)
			)
			(++ temp0)
		)
		(if
			(or
				(==
					((= temp4 (gTheDiceList sel_64: 1)) sel_484:)
					((= temp5 (gTheDiceList sel_64: 0)) sel_483:)
				)
				(and
					(temp4 sel_483:)
					(> ((temp4 sel_483:) sel_40:) 6)
					(== (temp5 sel_484:) sel_525)
				)
			)
			(gTheDiceList sel_81: temp4 sel_128: temp4)
		)
		(if (and global338 (>= sel_527 1))
			(Format @global550 301 0 (- (GetTime) local244) temp12) ; "Time = %d %d"
			(for ((= temp18 0)) (< temp18 (gTheDiceList sel_86:)) ((++ temp18))
				(if ((gTheDiceList sel_64: temp18) sel_483:)
					(StrCat
						@global550
						(Format ; "%d %d"
							@temp19
							301
							1
							(((gTheDiceList sel_64: temp18) sel_483:) sel_40:)
							(((gTheDiceList sel_64: temp18) sel_484:) sel_40:)
						)
					)
				)
			)
			(Print @global550)
		)
	)

	(method (sel_562 &tmp temp0 temp1 temp2 temp3 temp4)
		(if
			((= temp0 (gTheDiceList sel_64: (= temp1 (gTheDiceList sel_501:))))
				sel_483:
			)
			(self
				sel_542: (temp0 sel_483:) (temp0 sel_484:)
				sel_538: (temp0 sel_484:) (temp0 sel_483:)
			)
			((temp0 sel_484:) sel_479:)
			(if (not (or temp1 global325))
				(= temp2 (NodeValue (gTheDiceList sel_124:)))
				(= temp3 (NodeValue (gTheDiceList sel_126:)))
				(if
					(and
						(not (temp3 sel_483:))
						(==
							(-
								((temp2 sel_483:) sel_40:)
								((temp2 sel_484:) sel_40:)
							)
							(temp3 sel_482:)
						)
					)
					(= temp1 1)
				)
			)
			(Wait 1)
			(Wait 20)
			(gTheDiceList sel_508: temp1 1)
		else
			(if (and (== sel_31 2) sel_391)
				(proc0_3)
				(proc0_1)
				(gSound sel_39: 909)
				(gChar1 sel_446: (Random 45 47) 0 445 2)
			)
			(gTheDiceList sel_509:)
			(gGamePlayScript sel_135: 1)
		)
	)

	(method (sel_545 param1 &tmp temp0)
		(if (== sel_527 0)
			(if (param1 sel_467:)
				(-= local229 (param1 sel_474:))
			)
			(if (and (param1 sel_468:) (< (param1 sel_86:) 2))
				(++ local232)
			)
			(if (or (not (param1 sel_86:)) (== (param1 sel_469:) sel_534))
				(++ local233)
			)
		)
		(if (param1 sel_471:)
			(+= local228 (param1 sel_475:))
			(++ local247)
		)
		(if (== sel_527 0)
			(return)
		)
		(if (and (param1 sel_468:) (< (param1 sel_86:) 2))
			(+=
				local232
				(Max
					(- 6 (Max 1 (Abs (- (= temp0 (param1 sel_40:)) 6))))
					1
				)
			)
			(if (and (== sel_527 2) (<= 2 temp0 3))
				(-= local232 (- temp0 1))
			)
		)
		(if (== sel_527 1)
			(return)
		)
		(if (and (== (param1 sel_40:) 20) (param1 sel_468:))
			(+= local238 (if (> sel_391 80) 750 else 100))
		)
	)

	(method (sel_546 param1)
		(if (and (== sel_527 0) (param1 sel_467:))
			(-= local229 (param1 sel_474:))
		)
		(if
			(and
				(== (param1 sel_40:) 20)
				(>= (param1 sel_86:) 2)
				(not (param1 sel_468:))
				local239
			)
			(-= local238 300)
		)
	)

	(method (sel_548 param1 param2 &tmp temp0 temp1)
		(if (and (== sel_527 0) (>= (param1 sel_40:) 6))
			(++ local234)
		)
		(if (>= sel_527 1)
			(if
				(and
					(!=
						(/ (- (= temp1 (param1 sel_40:)) 1) 6)
						(/ (= temp0 (- (param2 sel_40:) 1)) 6)
					)
					(> temp1 6)
				)
				(+= local234 (+ (mod temp0 6) (* (/ temp1 6) 3)))
			)
			(if
				(and
					(== sel_527 1)
					(>= (param1 sel_86:) 2)
					(not (param1 sel_468:))
					global331
					(<= temp1 10)
				)
				(-=
					local232
					(Max (- 6 (Max 1 (Abs (- temp1 6)))) 0)
				)
			)
		)
		(if
			(and
				(== (param1 sel_86:) 1)
				(not (param1 sel_473:))
				(param2 sel_468:)
				(>= (param2 sel_86:) 2)
			)
			(++ local230)
		)
		(if (== param2 sel_525)
			(+= local231 (+ 25 (param1 sel_40:)))
		)
	)

	(method (sel_547 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14)
		(if (== sel_527 0)
			(return)
		)
		(= temp3 [param1 (- argc 1)])
		(= temp4 (>> argc $0001))
		(= temp1
			(= temp5
				(= temp6
					(= temp8
						(= sel_528
							(= temp11 (= local242 (= temp12 (= temp10 0))))
						)
					)
				)
			)
		)
		(if global322
			(if (== sel_527 2)
				(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
					(if
						(<
							([param1 temp14] sel_40:)
							global333
							([param1 (- temp14 temp4)] sel_40:)
						)
						(++ sel_528)
					)
				)
				(if
					(and
						(= temp13
							(if (== sel_528 local240)
								(not local228)
							)
						)
						(> global327 0)
					)
					(+= local238 1000)
				)
				(= sel_528 0)
				(= local241 25)
				(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
					(if
						(or
							(and
								((= temp0 [param1 temp14]) sel_468:)
								(< (temp0 sel_86:) 2)
								(< (= temp9 (temp0 sel_40:)) local241)
							)
							(and
								(not
									((= temp0 [param1 (- temp14 temp4)])
										sel_468:
									)
								)
								(>= (temp0 sel_86:) 2)
								(< (= temp9 (temp0 sel_40:)) local241)
							)
						)
						(= local241 temp9)
					)
				)
				(if (or global331 local249)
					(for ((= temp14 6)) (<= temp14 10) ((++ temp14))
						(if (sel_524 sel_532: (- 25 temp14))
							(break)
						)
						(++ sel_528)
						(= sel_529 temp14)
					)
					(if sel_529
						(= temp12 6)
						(for ((= temp14 5)) temp14 ((-- temp14))
							(if (sel_524 sel_532: (- 25 temp14))
								(break)
							)
							(= temp12 temp14)
							(++ sel_528)
						)
					)
				)
				(if (< sel_528 3)
					(= sel_528 0)
				)
			else
				(= temp13 0)
			)
			(for ((= temp14 0)) (< temp14 local216) ((++ temp14))
				(cond
					(
						(>=
							(= temp9
								((= temp0 (sel_531 sel_64: temp14)) sel_40:)
							)
							19
						)
						(++ temp5)
					)
					((<= 1 temp9 6)
						(++ temp6)
						(if (temp0 sel_468:)
							(++ local242)
						)
					)
				)
			)
			(if (temp3 sel_467:)
				(cond
					((>= (= temp9 (temp3 sel_40:)) 19)
						(++ temp5)
					)
					((<= 1 temp9 6)
						(++ temp6)
					)
				)
			)
			(= local243 (- 6 local242))
			(for ((= temp14 0)) (< temp14 local216) ((++ temp14))
				(if ((= temp0 (sel_531 sel_64: temp14)) sel_467:)
					(= temp2
						(if
							(or
								(== sel_527 1)
								(and
									(not local228)
									(<= (temp0 sel_40:) local241)
								)
							)
							(temp0 sel_477:)
						else
							(self sel_558: (temp0 sel_470:))
						)
					)
					(temp0 sel_476: temp2)
					(if (< (= temp9 (temp0 sel_40:)) 19)
						(+= temp8 temp2)
						(if temp2
							(++ temp1)
						)
					)
					(if (and temp2 (<= temp9 6))
						(++ temp11)
					)
					(if temp2
						(-= local229 (*= temp2 (temp0 sel_474:)))
						(-= temp10 temp2)
					)
					(if (sel_533 sel_473:)
						(if (== sel_527 1)
							(-= local229 (* [local15 temp9] (temp0 sel_474:)))
						else
							(-= local229 local237)
						)
					)
				)
			)
			(if (temp3 sel_467:)
				(= temp2
					(if
						(or
							(== sel_527 1)
							(and (not local228) (<= (temp3 sel_40:) local241))
						)
						(temp3 sel_477:)
					else
						(self sel_558: (temp3 sel_470:))
					)
				)
				(temp3 sel_476: temp2)
				(if (< (= temp9 (temp3 sel_40:)) 19)
					(+= temp8 temp2)
					(if temp2
						(++ temp1)
					)
				)
				(if (and temp2 (<= temp9 6))
					(++ temp11)
				)
				(if temp2
					(-= local229 (*= temp2 (temp3 sel_474:)))
					(-= temp10 temp2)
				)
				(if (sel_533 sel_473:)
					(if (== sel_527 1)
						(-= local229 (* [local15 temp9] (temp3 sel_474:)))
					else
						(-= local229 local237)
					)
				)
			)
			(if (not global331)
				(*= local229 local226)
				(if (and (== sel_527 2) (> ([param1 0] sel_40:) 6))
					(*= local229 2)
				)
			)
			(if (== sel_527 2)
				(if
					(and
						(or
							(>= global334 4)
							(and (== global334 3) (>= global327 15))
						)
						(< local242 temp6)
					)
					(if
						(<=
							local229
							(= temp0 (/ -32767 (= temp9 (* (- global334 2) 2))))
						)
						(= local229 temp0)
					)
					(*= local229 temp9)
				)
				(if (and temp11 local239 (> global327 -20))
					(if
						(<=
							local229
							(= temp0 (/ -32767 (= temp9 (* temp11 3))))
						)
						(= local229 temp0)
					)
					(*= local229 temp9)
				)
			)
		else
			(= temp13 1)
		)
		(= temp7 (Max 0 (+ local236 (* (- temp5 local239) 3))))
		(if (or (not temp1) (<= (/ temp8 temp1) temp7))
			(for ((= temp14 (= temp2 0))) (< temp14 temp4) ((++ temp14))
				(if
					(and
						(not ((= temp0 [param1 temp14]) sel_467:))
						(or
							(== (= temp9 ([param1 temp14] sel_86:)) 2)
							(> temp9 3)
							(and
								(>= sel_528 5)
								(< (sel_524 sel_528:) 6)
								(<=
									1
									(-
										temp12
										([param1 (+ temp14 temp4)] sel_40:)
									)
									2
								)
							)
						)
						(!=
							temp1
							(= temp9
								((= temp0 [param1 (+ temp14 temp4)]) sel_40:)
							)
						)
						(temp0 sel_473:)
						(or
							(and
								(temp0 sel_467:)
								(<= (temp0 sel_476:) temp7)
								(or (temp0 sel_471:) (> (temp0 sel_40:) 7))
								(or (> temp9 2) (<= 1 (- temp12 temp9) 2))
							)
							(and
								(== (temp0 sel_473:) 3)
								(< 0 (temp0 sel_86:) 3)
								(!= ([param1 temp14] sel_86:) 3)
								(or
									(> temp9 7)
									(!= ([param1 temp14] sel_86:) 2)
								)
								(or (> temp9 3) (<= 1 (- temp12 temp9) 2))
							)
						)
					)
					(+=
						local235
						(*
							(+ (* 2 (not (temp0 sel_476:))) 1)
							(Max (- 8 (Max 1 (Abs (- temp9 7)))) 5)
						)
					)
				)
			)
		)
		(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
			(if
				(and
					((= temp0 [param1 temp14]) sel_467:)
					(not (temp0 sel_86:))
					([param1 (- temp14 temp4)] sel_473:)
				)
				(++ local233)
			)
			(if
				(and
					(not ([param1 (- temp14 temp4)] sel_473:))
					(!= (= temp0 [param1 temp14]) sel_525)
					(temp0 sel_86:)
				)
				(-- local233)
			)
			(if
				(and
					(!= [param1 (- temp14 temp4)] sel_530)
					(== (= temp9 (temp0 sel_40:)) 23)
					(not (temp0 sel_468:))
					(not (temp0 sel_471:))
					(not (<= 1 (- temp9 (sel_524 sel_529:)) 2))
				)
				(-= local238 500)
			)
			(if
				(and
					(== (temp0 sel_40:) 6)
					(> (temp0 sel_473:) 5)
					global322
					(< ([param1 (- temp14 temp4)] sel_476:) 11)
				)
				(-= local238 (* 250 (- (temp0 sel_473:) 5)))
			)
		)
		(if (== sel_527 2)
			(if (and (not temp1) local242 (<= temp11 1))
				(= temp9 (+ local242 2))
				(if (> local242 2)
					(+= temp9 (Random 0 1))
				)
				(*= local228 (>> temp9 $0001))
			)
			(if (and (>= local247 2) (or (<= temp11 1) (<= global327 -20)))
				(*= local228 (+ (* (- local247 1) 2) 1))
			)
			(if (and (>= global327 10) global322 (sel_525 sel_86:))
				(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
					(if ((= temp0 [param1 temp14]) sel_471:)
						(-= local238 500)
					)
				)
			)
			(if
				(and
					(> global329 temp5)
					(or
						(= temp1
							(if (== [param1 0] sel_530)
								(and
									(<
										((= temp0 [param1 temp4]) sel_40:)
										global333
									)
									(== temp0 [param1 (- temp4 1)])
								)
							)
						)
						(and (< global327 -20) global322)
					)
				)
				(for ((= temp14 0)) (< temp14 temp4) ((++ temp14))
					(if
						(and
							(>= ((= temp0 [param1 temp14]) sel_40:) 19)
							(<= (temp0 sel_86:) 2)
							(not (temp0 sel_468:))
						)
						(if
							(or
								((= temp0 [param1 (+ temp14 temp4)]) sel_471:)
								(not temp1)
							)
							(if
								(or
									(<= (= temp9 (temp0 sel_40:)) 19)
									(< temp9 global333)
								)
								(-= local238 1500)
							)
						else
							(+= local238 1500)
						)
					)
				)
			)
			(if
				(and
					(<= sel_528 3)
					(> ((NodeValue (sel_531 sel_124:)) sel_40:) 13)
					(< local242 3)
				)
				(= temp14 temp4)
				(= temp1 0)
				(while (< temp14 argc)
					(if
						(and
							(!=
								temp1
								(= temp9 ((= temp0 [param1 temp14]) sel_40:))
							)
							(temp0 sel_468:)
							(!= (- temp12 1) temp9)
							(or
								(== temp9 1)
								(and (== temp9 2) (not (temp0 sel_473:)))
							)
							(not (sel_533 sel_473:))
						)
						(= temp1 temp9)
						(-= local238 (* 300 (- 3 temp9)))
					)
					(++ temp14)
				)
			)
			(if (not global322)
				(if (<= global329 (- 15 temp6))
					(for ((= temp14 0)) (< temp14 temp4) ((++ temp14))
						(if (> ([param1 temp14] sel_40:) 6)
							(+=
								local238
								(if (<= ([param1 (+ temp14 temp4)] sel_40:) 6)
									750
								else
									250
								)
							)
						)
					)
				)
				(for ((= temp14 0)) (< temp14 temp4) ((++ temp14))
					(cond
						((>= ([param1 temp14] sel_40:) 19)
							(+= local238 2000)
						)
						((> ([param1 temp14] sel_40:) 6)
							(+= local238 500)
						)
					)
				)
			)
			(if (not local238)
				(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
					(if
						(<=
							((= temp0 [param1 temp14]) sel_40:)
							19
							([param1 (- temp14 temp4)] sel_40:)
						)
						(cond
							((<= global329 temp5)
								(+= local238 1250)
							)
							((>= temp5 local239)
								(+= local238 125)
							)
						)
					)
				)
			)
			(if (and global331 global322 (not temp13))
				(for ((= temp14 (= temp1 0))) (< temp14 temp4) ((++ temp14))
					(if
						(and
							(!=
								temp1
								(= temp9 ((= temp0 [param1 temp14]) sel_40:))
							)
							(>= (temp0 sel_86:) 2)
							(not (temp0 sel_468:))
							(<= temp9 10)
							(or
								(!= temp9 (+ sel_529 1))
								(<= temp9 7)
								(and (>= (temp0 sel_476:) 11) (>= sel_528 3))
								(== (+ sel_529 1) 6)
							)
							(or
								(and (not (temp0 sel_86:)) (<= temp9 7))
								(temp0 sel_467:)
								(> ([param1 (+ temp14 temp4)] sel_40:) 6)
								temp11
							)
							(not
								(and
									(gTheDiceList sel_500:)
									(== temp9 (+ sel_529 1))
									(==
										((= temp0 (self sel_64: (+ temp9 1)))
											sel_86:
										)
										2
									)
									(not (temp0 sel_473:))
								)
							)
						)
						(= temp1 temp9)
						(-=
							local232
							(*
								(+ 1 ([param1 (+ temp14 temp4)] sel_468:))
								(Max
									(- 6 (Max 1 (Abs (- temp9 6))))
									0
								)
							)
						)
						(if (<= temp9 7)
							(-= local232 2)
						)
					)
				)
				(if sel_528
					(= temp1 0)
					(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
						(if
							(and
								(!=
									temp1
									(= temp9
										((= temp0 [param1 temp14]) sel_40:)
									)
								)
								(temp0 sel_468:)
								(< (temp0 sel_86:) 2)
								(or
									(not
										((= temp0 [param1 (- temp14 temp4)])
											sel_467:
										)
									)
									(> temp9 6)
									(not temp11)
								)
								(== (temp0 sel_40:) sel_529)
								(!= sel_529 6)
								(<= (temp0 sel_40:) 10)
								(not (temp0 sel_468:))
								(>= (temp0 sel_86:) 2)
								(or (not local248) sel_528)
							)
							(= temp1 temp9)
							(+=
								local232
								(Max
									(- 6 (Max 1 (Abs (- temp9 6))))
									1
								)
							)
						)
					)
				)
			)
			(if (not temp11)
				(if (and (sel_533 sel_473:) (>= local242 3))
					(= temp1 0)
					(for ((= temp14 (= temp1 0))) (< temp14 temp4) ((++ temp14))
						(if
							(and
								(!= temp1 (= temp9 ([param1 temp14] sel_40:)))
								(<=
									((= temp0 [param1 (+ temp14 temp4)])
										sel_40:
									)
									6
								)
								(< (temp0 sel_86:) 2)
								(temp0 sel_468:)
								(or (not local248) sel_528)
							)
							(= temp1 temp9)
							(+=
								local232
								(*
									(+ (temp0 sel_471:) 1)
									(Max
										(- 6 (Max 1 (Abs (- temp9 6))))
										0
									)
								)
							)
						)
					)
				)
				(cond
					((>= sel_528 6)
						(+= local238 1000)
					)
					((and (== sel_528 5) (< local248 5))
						(+= local238 500)
					)
				)
			)
			(if (>= (sel_524 sel_528:) 4)
				(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
					(if
						(<=
							1
							(= temp9
								(-
									((= temp0 [param1 temp14]) sel_40:)
									(sel_524 sel_529:)
								)
							)
							2
						)
						(+=
							local238
							(if (and (== temp9 1) (temp0 sel_468:))
								900
							else
								500
							)
						)
					)
				)
			)
			(if (not local238)
				(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
					(if
						(==
							((= temp0 [param1 temp14]) sel_40:)
							(- (sel_524 sel_529:) (sel_524 sel_528:))
						)
						(+= local238 (if (temp0 sel_471:) 750 else 300))
					)
				)
				(for ((= temp14 0)) (< temp14 temp4) ((++ temp14))
					(if
						(and
							(== ((= temp0 [param1 temp14]) sel_40:) 13)
							(not (temp0 sel_468:))
							temp5
						)
						(-= local238 150)
					)
				)
				(for ((= temp14 0)) (< temp14 temp4) ((++ temp14))
					(if
						(and
							(>=
								([param1 temp14] sel_40:)
								(= temp9 ([param1 (+ temp14 temp4)] sel_40:))
								19
							)
							(temp0 sel_473:)
						)
						(+= local238 (* (- 24 temp9) 30))
					)
				)
			)
			(if (and temp13 local229 (not global331))
				(= local228
					(= local230
						(= local232 (= local235 (= local238 (= sel_528 0))))
					)
				)
			)
		)
	)

	(method (sel_544 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 30])
		(cond
			(local246
				(if (HaveMouse)
					(gGame sel_191: (+ 983 local245))
				else
					(gGame sel_191: (+ 983 local245) 1 305 185)
				)
				(= local245 (& (++ local245) $0007))
			)
			((>= (- (GetTime) local244) 180)
				(= local246 1)
			)
		)
		(if (>= (= temp0 (- (sel_530 sel_86:) (sel_530 sel_473:))) local218)
			(if (and (sel_530 sel_86:) (not temp0))
				(return 0)
			)
			(= temp2 (>> argc $0001))
			(if (- (sel_525 sel_473:) (sel_525 sel_86:))
				(= temp7 6)
				(= temp1 0)
				(while temp7
					(if (== ((self sel_64: temp7) sel_469:) sel_526)
						(= temp1 temp7)
						(break)
					)
					(-- temp7)
				)
				(for ((= temp7 0)) (< temp7 temp2) ((++ temp7))
					(if
						(and
							(!=
								(= temp3
									(gTheDiceList
										sel_503:
											(= temp6 [param1 temp7])
											(= temp5 [param1 (+ temp7 temp2)])
									)
								)
								((gTheDiceList sel_64: temp7) sel_482:)
							)
							(> temp1 temp3)
						)
						(return 0)
					)
				)
			)
			(if (> temp0 local218)
				(gTheDiceList sel_507:)
				(= local217 -32767)
				(= local218 temp0)
			)
			(if (!= sel_527 -1)
				(= local228
					(= local229
						(= local230
							(= local232
								(= local233
									(= local234
										(= local231
											(= local235
												(= temp3
													(= temp4
														(= local238
															(= sel_528
																(= local247 0)
															)
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
				(for ((= temp7 0)) (< temp7 temp2) ((++ temp7))
					(if
						(and
							(!= temp4 (= temp6 [param1 temp7]))
							(!= temp6 sel_530)
						)
						(self sel_546: (= temp4 temp6))
					)
					(if
						(and
							(!= temp3 (= temp5 [param1 (+ temp7 temp2)]))
							(!= temp5 sel_525)
						)
						(self sel_545: (= temp3 temp5))
					)
					(self sel_548: temp6 temp5)
				)
				(self sel_547: param1 &rest)
				(if (< local229 -14000)
					(= local229 -14000)
				)
				(= temp1
					(+
						15000
						local229
						(* local220 local230)
						(* local219 local228)
						(* local221 local231)
						(* local222 local232)
						(* local223 local234)
						(* local224 local233)
						(* local235 local225)
						(* local227 sel_528)
						local238
					)
				)
				(if (and global338 (>= sel_527 1))
					(Format @global550 301 2)
					(for ((= temp7 0)) (< temp7 argc) ((++ temp7))
						(StrCat
							@global550
							(Format ; "%d %d"
								@temp8
								301
								1
								([param1 temp7] sel_40:)
								([param1 (++ temp7)] sel_40:)
							)
						)
					)
					(StrCat
						@global550
						(Format ; "%d %d %d %d %d %d %d %d %d %d"
							@temp8
							301
							3
							local228
							local229
							local230
							local232
							local231
							local233
							local234
							local235
							local238
							sel_528
						)
					)
					(StrCat
						@global550
						(Format ; "%d %d %d %d %d %d %d %d %d %d = %d"
							@temp8
							301
							4
							(* local228 local219)
							local229
							(* local230 local220)
							(* local232 local222)
							(* local231 local221)
							(* local233 local224)
							(* local234 local223)
							(* local235 local225)
							local238
							(* local227 sel_528)
							temp1
						)
					)
					(if (>= temp1 local217)
						(StrCat @global550 {*})
					)
					(StrCat @global550 {\nBest = })
					(for
						((= temp7 0))
						(< temp7 (gTheDiceList sel_86:))
						((++ temp7))
						
						(if ((gTheDiceList sel_64: temp7) sel_483:)
							(StrCat
								@global550
								(Format ; "%d %d"
									@temp8
									301
									1
									(((gTheDiceList sel_64: temp7) sel_483:)
										sel_40:
									)
									(((gTheDiceList sel_64: temp7) sel_484:)
										sel_40:
									)
								)
							)
						)
					)
					(StrCat
						@global550
						(Format ; "= %d %d %d %d %d %d %d %d %d %d %d"
							@temp8
							301
							5
							local217
							[global341 0]
							[global341 1]
							[global341 2]
							[global341 3]
							[global341 4]
							[global341 5]
							[global341 6]
							[global341 7]
							[global341 8]
							[global341 9]
						)
					)
					(StrCat
						@global550
						(Format ; "%d %d %d %d %d %d %d %d %d %d"
							@temp8
							301
							3
							[global341 10]
							[global341 11]
							[global341 12]
							[global341 13]
							[global341 14]
							[global341 15]
							[global341 16]
							[global341 17]
							[global341 18]
							[global341 19]
						)
					)
					(if global340
						(Print @global550)
					)
					(if (>= temp1 local217)
						(= [global341 0] local228)
						(= [global341 1] local229)
						(= [global341 2] local230)
						(= [global341 3] local232)
						(= [global341 4] local231)
						(= [global341 5] local233)
						(= [global341 6] local234)
						(= [global341 7] local235)
						(= [global341 8] local238)
						(= [global341 9] sel_528)
						(= [global341 10] (* local228 local219))
						(= [global341 11] local229)
						(= [global341 12] (* local230 local220))
						(= [global341 13] (* local232 local222))
						(= [global341 14] (* local231 local221))
						(= [global341 15] (* local233 local224))
						(= [global341 16] (* local234 local223))
						(= [global341 17] (* local235 local225))
						(= [global341 18] local238)
						(= [global341 19] (* sel_528 local227))
					)
				)
				(return temp1)
			else
				(return (Random 1 99))
			)
		)
		(return 0)
	)

	(method (sel_550 param1 param2 &tmp temp0 temp1 temp2)
		(= temp2 (>> (- argc 1) $0001))
		(if (< local217 param1)
			(= temp0 (= temp1 0))
			(while (< temp0 temp2)
				((gTheDiceList sel_64: temp0)
					sel_484: [param2 temp1]
					sel_483: [param2 (++ temp1)]
				)
				(++ temp0)
				(++ temp1)
			)
			(= local217 param1)
		)
	)

	(method (sel_549)
		(switch sel_527
			(0
				(= local221 30)
				(= local225 0)
				(= local227 0)
				(= local226 1)
				(cond
					((not global331)
						(if global322
							(= local219 3)
							(= local220 15)
							(= local222 10)
							(= local223 3)
							(= local224 0)
						else
							(= local219 0)
							(= local220 0)
							(= local222 0)
							(= local223 10)
							(= local224 100)
						)
					)
					(global322
						(= local219 15)
						(= local220 15)
						(= local222 10)
						(= local223 5)
						(= local224 0)
					)
					(else
						(= local219 0)
						(= local220 0)
						(= local222 0)
						(= local223 10)
						(= local224 100)
					)
				)
			)
			(1
				(= local221 30)
				(= local236 6)
				(= local227 0)
				(= local226 10)
				(cond
					((not global331)
						(if global322
							(if (>= sel_391 (+ (sel_524 sel_391:) 20))
								(= local219 2)
							else
								(= local219 8)
							)
							(= local220 1000)
							(= local237 100)
							(= local222 60)
							(= local223 15)
							(= local224 0)
							(= local225 0)
						else
							(= local219 0)
							(= local220 0)
							(= local222 0)
							(= local223 10)
							(= local224 150)
							(= local225 0)
							(= local237 0)
						)
					)
					(global322
						(if (> global327 -20)
							(= local219 8)
							(= local220 75)
							(= local222 100)
							(= local223 5)
							(= local224 0)
							(= local225 50)
							(= local237 25)
						else
							(= local219 15)
							(= local220 0)
							(= local222 25)
							(= local223 0)
							(= local224 0)
							(= local225 0)
							(= local237 0)
						)
					)
					(else
						(= local219 0)
						(= local220 0)
						(= local222 0)
						(= local223 15)
						(= local224 150)
						(= local225 0)
						(= local237 0)
					)
				)
			)
			(2
				(= local236 6)
				(= local227 150)
				(if (not global331)
					(= local226 30)
					(if global322
						(if
							(or
								(<= global327 -20)
								(and (<= global327 0) (> global333 12))
							)
							(= local219 8)
						else
							(= local219 2)
						)
						(= local220 1000)
						(= local237 100)
						(= local222 120)
						(= local223 20)
						(= local224 5)
						(= local225 0)
						(= local221 30)
					else
						(= local219 0)
						(= local220 0)
						(= local222 0)
						(= local223 90)
						(= local224 150)
						(= local225 0)
						(= local237 0)
						(= local221 50)
					)
				else
					(= local226 15)
					(= local221 30)
					(if global322
						(if
							(or
								(<= global327 -20)
								(and (<= global327 0) (> global333 12))
							)
							(= local219 17)
							(= local220 75)
							(= local222 120)
							(= local223 5)
							(= local224 5)
							(= local225 75)
							(= local237 25)
						else
							(= local219 2)
							(= local220 25)
							(= local222 100)
							(= local223 5)
							(= local224 5)
							(= local225 20)
							(= local237 25)
						)
					else
						(= local219 0)
						(= local220 0)
						(= local222 0)
						(= local223 15)
						(= local224 150)
						(= local225 0)
						(= local237 0)
					)
				)
			)
		)
	)

	(method (sel_555 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (gTheDiceList sel_500:)
			(= temp0 (+ (* (- (gTheDice1 sel_482:) 1) 4) 30))
		else
			(= temp1 (- (gTheDice2 sel_482:) 1))
			(for ((= temp4 (= temp0 0))) (< temp4 temp1) ((++ temp4))
				(+= temp0 (- 5 temp4))
			)
			(= temp0 (* (+ temp0 (- (- (gTheDice1 sel_482:) temp1) 2)) 2))
		)
		(if (!= sel_527 -1)
			(+= temp0 (* sel_527 54))
		)
		(= temp4 0)
		(while (< temp4 (gTheDiceList sel_86:))
			((= temp2 (gTheDiceList sel_64: temp4))
				sel_483: (self sel_64: (= temp3 [local40 temp0]))
			)
			(temp2 sel_484: (self sel_64: (- temp3 (temp2 sel_482:))))
			(++ temp4)
			(++ temp0)
		)
		(= global325 0)
	)

	(method (sel_110 &tmp temp0 temp1)
		(if (and global337 (== self global303))
			(setupButton sel_110:)
		)
		((= sel_530 (NodeValue (self sel_126:))) sel_469: sel_526 sel_40: 25)
		((= sel_525 (NodeValue (self sel_124:))) sel_469: sel_526)
		(= sel_531 (BGPlayer sel_109:))
		(for ((= temp1 0)) (< temp1 15) ((++ temp1))
			((= temp0 (sel_530 sel_64: temp1)) sel_25: sel_526 sel_110:)
			(gAllStonesObj sel_118: temp0)
		)
		(for ((= temp1 0)) (<= temp1 25) ((++ temp1))
			((self sel_64: temp1) sel_110:)
		)
		(= sel_524 (if (== self global303) global304 else global303))
		(= sel_533 (if (== sel_530 gTheBar1) gTheBar2 else gTheBar1))
		(= sel_534 (sel_524 sel_526:))
	)

	(method (sel_515 &tmp temp0 temp1 temp2)
		(self sel_537:)
		(for ((= temp1 0)) (!= (sel_530 sel_86:) 15) ((++ temp1))
			(if (== ((= temp0 (self sel_64: temp1)) sel_469:) sel_526)
				(for ((= temp2 0)) (temp0 sel_86:) ((++ temp2))
					(self sel_542: temp0 sel_530)
				)
			)
		)
		(= sel_391 375)
	)

	(method (sel_516 &tmp temp0 temp1)
		(self sel_537:)
		(if (not global336)
			(for ((= temp0 0)) (< temp0 15) ((++ temp0))
				(self sel_542: sel_530 (self sel_64: [local0 temp0]))
			)
		)
		(gACast sel_125:)
		(for ((= temp0 0)) (<= temp0 25) ((++ temp0))
			(if (== ((= temp1 (self sel_64: temp0)) sel_469:) sel_526)
				(temp1 sel_478:)
			)
		)
		(self sel_536: 0)
		(= sel_535 0)
	)

	(method (sel_537 &tmp temp0)
		(for ((= temp0 1)) (< temp0 25) ((++ temp0))
			((self sel_64: temp0)
				sel_40: temp0
				sel_475: (* (- (* (/ (+ temp0 5) 6) 3) 2) 15)
				sel_470: (- 25 temp0)
				sel_474: (- (* (/ (- 25 (- temp0 5)) 6) 3) 2)
			)
		)
	)

	(method (sel_536 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (not param1)
			(= global330 global331)
			(= local239 (= local240 (= global334 (= sel_529 0))))
			(= temp2 (sel_524 sel_531:))
			(= temp3 (temp2 sel_86:))
			(if
				(and
					(temp2 sel_86:)
					(== (= global333 ((NodeValue (temp2 sel_124:)) sel_40:)) 25)
				)
				(= global333 -1)
			)
			(= global329 (- 15 ((sel_524 sel_525:) sel_86:)))
		)
		(sel_531 sel_125:)
		(= global331 0)
		(for ((= temp5 25)) temp5 ((-- temp5))
			(if (== ((= temp0 (self sel_64: temp5)) sel_469:) sel_526)
				(sel_531 sel_118: temp0)
				(if (> (= temp4 (temp0 sel_40:)) 6)
					(++ global331)
				)
				(if (and (not param1) (> temp4 global333))
					(+= local240 (temp0 sel_86:))
				)
			)
			(if (not param1)
				(if (== sel_527 2)
					(temp0 sel_476: (self sel_558: (temp0 sel_470:)))
				else
					(temp0 sel_476: 0)
					(for ((= temp6 0)) (< temp6 temp3) ((++ temp6))
						(if (< (= temp4 ((temp2 sel_64: temp6) sel_40:)) temp5)
							(temp0
								sel_476:
									(+
										(temp0 sel_476:)
										[local15 (- temp5 temp4)]
									)
							)
						)
					)
				)
				(temp0 sel_477: (temp0 sel_476:))
			)
		)
		(= local216 (sel_531 sel_86:))
		(if (not param1)
			(if (not local216)
				(= global322 0)
			else
				(= global322
					(< global333 ((NodeValue (sel_531 sel_124:)) sel_40:))
				)
			)
			(for ((= temp5 0)) (< temp5 temp3) ((++ temp5))
				(cond
					((<= (= temp4 ((= temp0 (temp2 sel_64: temp5)) sel_40:)) 6)
						(++ local239)
					)
					((and (>= 24 temp4 19) (temp0 sel_468:))
						(++ global334)
					)
				)
			)
			(if global322
				(= local249 global331)
				(= sel_528 0)
				(for ((= temp5 6)) (<= temp5 10) ((++ temp5))
					(if (self sel_532: (- 25 temp5))
						(break)
					)
					(++ sel_528)
				)
				(if sel_528
					(sel_524 sel_529: 19)
					(for ((= temp5 5)) temp5 ((-- temp5))
						(if (self sel_532: (= temp4 (- 25 temp5)))
							(break)
						)
						(++ sel_528)
						(sel_524 sel_529: temp4)
					)
				)
				(sel_524 sel_528: sel_528)
				(if (== sel_527 2)
					(= sel_528 0)
					(for ((= temp5 6)) (<= temp5 10) ((++ temp5))
						(if (sel_524 sel_532: (- 25 temp5))
							(break)
						)
						(++ sel_528)
						(= sel_529 temp5)
					)
					(if sel_528
						(for ((= temp5 5)) temp5 ((-- temp5))
							(if (self sel_532: (- 25 temp5))
								(break)
							)
							(++ sel_528)
						)
					)
					(if (< sel_528 3)
						(= sel_529 0)
					)
					(if (< (sel_524 sel_528:) 3)
						(sel_524 sel_528: 0)
						(sel_524 sel_529: 0)
					)
					(= local248 sel_528)
				)
				(return
					(and
						(>= (sel_524 sel_528:) 6)
						(or
							(and
								(== (sel_524 sel_529:) 24)
								(or
									(and (not global336) (sel_530 sel_86:))
									sel_535
								)
							)
							(and
								(==
									((= temp0
											(self
												sel_64: (+ (sel_524 sel_529:) 1)
											)
										)
										sel_469:
									)
									sel_526
								)
								(==
									(temp0 sel_86:)
									(-
										15
										(+
											((self sel_64: 1) sel_86:)
											(sel_525 sel_86:)
										)
									)
								)
							)
						)
					)
				)
			)
			(return 0)
		)
	)

	(method (sel_557 &tmp temp0 temp1 [temp2 31])
		(proc0_1)
		(proc0_3)
		(if (and (== sel_31 1) (!= global179 2))
			(gSong sel_39: 906 sel_165: 1)
		else
			(gSong sel_39: 802 sel_165: -1)
		)
		(cond
			((or global323 ((sel_524 sel_525:) sel_86:))
				(= temp0 1)
			)
			((or local239 (sel_533 sel_86:))
				(= temp0 3)
				(++ sel_514)
			)
			(else
				(= temp0 2)
				(++ sel_513)
			)
		)
		(++ sel_512)
		(= temp1 temp0)
		(*= temp0 (gTheDoubleCube sel_74:))
		(+= sel_511 temp0)
		(if (== global179 1)
			(if (== sel_31 2)
				(Format @global550 399 12) ; "I won the game"
			else
				(Format @global550 399 13) ; "You won the game"
			)
		else
			(Format @global550 399 11 sel_510) ; "%s won the game"
		)
		(if (>= temp1 2)
			(StrCat @global550 (Format @temp2 399 14)) ; "plus a"
			(if (== temp1 3)
				(StrCat @global550 (Format @temp2 399 15)) ; "backgammon"
			else
				(StrCat @global550 (Format @temp2 399 16)) ; "gammon"
			)
		)
		(StrCat @global550 (Format @temp2 399 17 temp0)) ; "for a total of %d"
		(if (> temp0 1)
			(StrCat @global550 (Format @temp2 399 19)) ; "points"
		else
			(StrCat @global550 (Format @temp2 399 18)) ; "point"
		)
		(StrCat @global550 (Format @temp2 399 20)) ; "."
		(gChar1 sel_446: @global550 -32768)
		(if (== sel_31 2)
			(if (or (== temp0 1) (not (= temp1 (Random 0 1))))
				(gChar1 sel_443: 0 gGamePlayScript)
			else
				(gChar1 sel_444: 0 gGamePlayScript)
			)
		else
			(gChar1 sel_445: 0 gGamePlayScript)
			(if (== global179 2)
				(gGamePlayScript sel_135: 1)
			)
		)
	)

	(method (sel_551)
		(= global178 sel_524)
		(gTheArrow sel_144:)
		(if (== (global178 sel_31:) 1)
			(proc0_3)
		)
		(proc0_1)
	)
)

(instance setupButton of Feature
	(properties
		sel_20 {setupButton}
	)

	(method (sel_132 param1)
		(if
			(and
				global337
				(<= 0 (param1 sel_1:) 41)
				(<= 178 (param1 sel_0:) 199)
			)
			(param1 sel_73: 1)
			(= global337 0)
			(= global338 1)
			(proc303_1)
			(if (not global337)
				(gTheDiceList sel_506:)
				(proc0_1)
				((global178 sel_524:) sel_536: 0)
				(gCurRoom sel_145: gGamePlayScript)
			)
			(return 1)
		)
		(return 0)
	)
)


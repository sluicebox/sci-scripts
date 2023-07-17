;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1301)
(include sci.sh)
(use Main)
(use dummyPublic0)
(use Str)
(use Print)
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
		type 0
		myColor 1
		bar 0
		off 0
		whichPoints 0
		otherColor 2
		otherBar 0
		otherPlayer 0
		aceyHits 0
		gamesWon 0
		skill 0
		count 0
		gammons 0
		backgammons 0
		playerName 0
		totalPts 0
		bigPrime 0
		endPrime 0
	)

	(method (moveToDest param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(= temp1 (Event new:))
		(= temp5 (self noLegalMoves: 1 0))
		(= temp6
			(or
				(self noLegalMoves: 2 0)
				(self
					noLegalMoves:
						-1
						(+ (gTheDice1 pipValue:) (gTheDice2 pipValue:))
						2
				)
			)
		)
		(if
			(not
				(or
					param2
					(= param2 (self firstTrue: #handleEvent temp1 global189))
				)
			)
			(temp1 dispose:)
			(self moveBack: param1 0 0)
			(return 0)
		)
		(temp1 dispose:)
		(= temp9 (gTheDice1 x:))
		(= temp11 (gTheDice1 y:))
		(= temp10 (gTheDice2 x:))
		(= temp12 (gTheDice2 y:))
		(if
			(and
				(> (= temp0 (- (param1 number:) (param2 number:))) 0)
				(self validMove: (param2 number:))
				(self dieMove: param2 param1)
			)
			(global189 dim:)
			(if (!= (param1 indexOf: local214) (- (param1 size:) 1))
				(param1 delete: local214 add: local214)
			)
			(self checkToProps: param1 param2)
			(if (not (gTheDice1 oldPoint:))
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
			(if count
				(self readPoints: 1)
				(if
					(and
						(whichPoints size:)
						(== (gTheDiceList numberUsed:) 1)
						(not
							(or
								(and temp5 temp6)
								(gTheDiceList doubles:)
								(bar size:)
								(temp7 oldPoint:)
								(self adjustLevel:)
							)
						)
					)
					(self checkFromProps: param2 param1)
					(proc0_12 905)
					(gChar1 sayReg: 1000 2 60 0 (Random 1 2) 0 0)
					(gTheDiceList
						numberUsed: (- (gTheDiceList numberUsed:) 1)
						clearAll:
					)
					(temp8 posn: temp3 temp4 setPip: 0)
					(self moveBack: param1 0 0 readPoints: 1)
					(return 0)
				)
			)
			(gACast release:)
			(if (param2 hit:)
				(gACast add: (KList 8 (param2 first:))) ; NodeValue
			)
			(self checkFromProps: param2 param1)
			(self readPoints: 1)
			(self moveStone: param1 param2)
			(self readPoints: 0)
			(if (& param3 $0004)
				(if global755
					(++ global755)
				)
				(param2 moveToPoint:)
			else
				(param1 adjustPoint:)
				(param2 adjustPoint: cue:)
				(proc0_9 (gACast elements:) 0)
			)
			(return 1)
		else
			(self moveBack: param1 temp0 (== param2 off))
			(return 0)
		)
	)

	(method (checkLegal param1 param2)
		(if (and (== param1 off) (off size:) (off contains: local214))
			(proc0_12 905)
			(return 0)
		)
		(if (and (bar size:) (!= param1 bar))
			(proc0_12 905)
			(return 0)
		)
		(local214 setPri: 15)
		(return
			(and
				(== (local214 processEvent: param2) 1)
				global189
				(self moveToDest: param1 0 (param2 type:))
			)
		)
	)

	(method (touchingPieces)
		(if (== (gTheDiceList numberUsed:) (gTheDiceList size:))
			(proc0_12 905)
			(if (== gAttitudeSetting 0)
				(= global920 1)
				(gChar1 say: 1300 15 162 0 2)
			else
				(= global920 1)
				(gChar1 sayReg: 1300 15 162 0 (Random 1 2))
			)
			(return 1)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (setupButton handleEvent: event)
			(return 0)
		)
		(cond
			((not global787)
				(if (== type 1)
					(return 0)
				)
				(cond
					(
						(and
							(= local214
								(gAllStonesObj firstTrue: #handleEvent event)
							)
							(== (event type:) evMOUSEBUTTON)
						)
						(if (self touchingPieces:)
							(return 0)
						)
						(if (!= (local214 color:) myColor)
							(proc0_12 905)
							(gChar1
								sayReg:
									1300
									(+ (gChar1 view:) 1)
									93
									0
									(Random 1 2)
									0
									0
							)
							(return 0)
						)
						(for ((= temp6 0)) (< temp6 local216) ((++ temp6))
							(if
								((= temp2 (whichPoints at: temp6))
									contains: local214
								)
								(break)
							)
						)
						(= temp5 (temp2 size:))
						(for ((= temp6 0)) (< temp6 temp5) ((++ temp6))
							(if (== local214 (temp2 at: temp6))
								(break)
							)
						)
						(if (== temp6 temp5)
							(return 0)
						)
						(temp2 getAssocPt: (mod temp6 5) local214)
						(self checkLegal: temp2 event)
					)
					(
						(and
							(!= (event type:) evMOUSEBUTTON)
							(= temp2 (gThePoints firstTrue: #handleEvent event))
						)
						(if (self touchingPieces:)
							(return 0)
						)
						(if global189
							(= local214 global189)
							(= temp1 temp2)
							(= temp5 (gThePoints size:))
							(for ((= temp6 0)) (< temp6 temp5) ((++ temp6))
								(if
									(and
										(not ((gThePoints at: temp6) isEmpty:))
										((= temp2 (gThePoints at: temp6))
											contains: local214
										)
									)
									(break)
								)
							)
							(self moveToDest: temp2 temp1 (event type:))
						else
							(if (not (= temp5 (temp2 size:)))
								(return 0)
							)
							(if (== (temp2 whose:) otherColor)
								(proc0_12 905)
								(gChar1
									sayReg:
										1300
										(+ (gChar1 view:) 1)
										93
										0
										(Random 1 2)
										0
										0
								)
								(return 0)
							)
							(if
								(==
									(= local214 (temp2 firstTrue: #onMe event))
									0
								)
								(= local214 (KList 8 (temp2 last:))) ; NodeValue
							)
							(= temp6 (mod (- temp5 1) 5))
							(temp2 getAssocPt: temp6 local214)
							(self checkLegal: temp2 event)
						)
					)
				)
			)
			((= local214 (gAllStonesObj firstTrue: #handleEvent event))
				(= temp2 0)
				(for ((= temp6 0)) (< temp6 (gThePoints size:)) ((++ temp6))
					(if
						(and
							((gThePoints at: temp6) size:)
							((gThePoints at: temp6) contains: local214)
						)
						(= temp2 (gThePoints at: temp6))
						(if (== (temp2 whose:) (global800 otherColor:))
							(= global800 (global800 otherPlayer:))
						)
						(break)
					)
				)
				(global800 numberPoints: readPoints: 1)
				(if (and (== (local214 processEvent: event) 1) global189)
					(= temp0 (Event new:))
					(if
						(not
							(= temp1
								(global800
									firstTrue: #handleEvent temp0 global189
								)
							)
						)
						(temp0 dispose:)
						(global800 moveBack: temp2 1 (== temp1 off))
						(return 0)
					)
					(temp0 dispose:)
					(if (!= (global800 otherColor:) (temp1 whose:))
						(RedrawCast)
						(global189 stopUpd:)
						(if (!= local214 (KList 8 (temp2 last:))) ; NodeValue
							(temp2 delete: local214 add: local214)
						)
						(= global775 0)
						(global800
							moveStone: temp2 temp1
							updatePoints: temp1 temp2 -1
						)
						(gACast release:)
						(temp2 adjustPoint:)
						(temp1 adjustPoint: cue:)
						(RedrawCast)
						(gGamePlayScript cycles: 1)
						(return 1)
					else
						(global800 moveBack: temp2 temp3 (== temp1 off)) ; UNINIT
						(return 0)
					)
				)
			)
		)
	)

	(method (dieMove param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (gTheDiceList size:))
		(= temp1 (gTheDiceList calcUsed: param2 param1))
		(for ((= temp5 0)) (< temp5 temp0) ((++ temp5))
			(if
				(and
					(not ((= temp2 (gTheDiceList at: temp5)) oldPoint:))
					(== temp1 (temp2 pipValue:))
				)
				(temp2 oldPoint: param2 newPoint: param1)
				(gTheDiceList movePick: temp5 0)
				(return 1)
			)
		)
		(for ((= temp5 0)) (< temp5 temp0) ((++ temp5))
			(if (not ((= temp2 (gTheDiceList at: temp5)) oldPoint:))
				(if (> temp1 (temp2 pipValue:))
					(return 0)
				else
					(break)
				)
			)
		)
		(if
			(and
				(>= ((= temp3 (KList 8 (whichPoints first:))) number:) temp1) ; NodeValue
				(== temp3 param2)
				(== param1 off)
			)
			(temp2 oldPoint: param2 newPoint: param1)
			(gTheDiceList movePick: temp5 0)
			(return 1)
		)
		(return 0)
	)

	(method (moveBack param1 param2 param3)
		(global189
			moveSpeed: global898
			xStep: (* (global189 xStep:) 3)
			yStep: (* (global189 yStep:) 3)
			dim:
		)
		(local214 movePos: param1 (param1 indexOf: local214))
		(local214 setPri: 15)
		(RedrawCast)
		(local214 setMotion: MoveTo global756 global757 param1)
		(if param2
			(proc0_12 905)
			(if (and param3 (> ((KList 8 (whichPoints first:)) number:) 6)) ; NodeValue
			)
		else
			(proc0_12 905)
		)
	)

	(method (moveStone param1 param2 &tmp temp0)
		(self checkToProps: param1 param2)
		(= global776
			(if (== (param1 dir:) (param2 dir:))
				(- (param1 dir:))
			else
				0
			)
		)
		(if (param2 hit:)
			(= temp0 (KList 8 (param2 last:))) ; NodeValue
			(temp0 setPri: 11)
			(param2 delete: temp0 hit: 0)
			(otherBar add: temp0)
			(otherPlayer count: (+ (otherPlayer count:) (param2 number:)))
			(= global755 (if (== type 0) 1 else 2))
		)
		(param1 delete: (= temp0 (KList 8 (param1 last:)))) ; NodeValue
		(param2 add: temp0)
		(-= count (- (param1 number:) (param2 number:)))
	)

	(method (numberOfRolls param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 (= temp4 0))
		(= temp6 13)
		(= temp7 param1)
		(while (and (<= (++ temp4) 6) (<= (++ temp7) 25))
			(if (== ((= temp1 (otherPlayer at: temp7)) whose:) otherColor)
				(+= temp0 (-= temp6 2))
			else
				(= temp5 0)
				(= temp3 (+ temp4 param1))
				(while (and (< (++ temp5) temp4) (<= (++ temp3) 25))
					(if (== ((otherPlayer at: temp3) whose:) otherColor)
						(cond
							((not (temp1 closed:))
								(+= temp0 2)
							)
							(
								(or
									(!=
										((= temp2
												(otherPlayer
													at: (+ temp5 param1)
												)
											)
											whose:
										)
										myColor
									)
									(temp2 blot:)
								)
								(+= temp0 2)
								(if (== (temp2 whose:) otherColor)
									(-= temp6 2)
								)
							)
						)
					)
					1
				)
				(cond
					((temp1 closed:))
					(
						(and
							(<= (= temp5 (+ temp4 temp7)) 25)
							(==
								((= temp1 (otherPlayer at: temp5)) whose:)
								otherColor
							)
						)
						(++ temp0)
					)
					((temp1 closed:))
					(
						(and
							(<= (+= temp5 temp4) 25)
							(==
								((= temp1 (otherPlayer at: temp5)) whose:)
								otherColor
							)
						)
						(++ temp0)
					)
					((temp1 closed:))
					(
						(and
							(<= (+= temp5 temp4) 25)
							(==
								((= temp1 (otherPlayer at: temp5)) whose:)
								otherColor
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
			((otherBar blot:)
				(return (/ (* temp0 [local202 local243]) 100))
			)
			((otherBar closed:)
				(return (/ (* temp0 [local208 local243]) 100))
			)
			(else
				(return temp0)
			)
		)
	)

	(method (updateProps param1 param2 &tmp temp0 temp1)
		(param2
			tempSize: (= temp1 (+ (param2 tempSize:) 1))
			blot: (== temp1 1)
			closed: (>= temp1 2)
			whose: (param1 whose:)
		)
		(if (not (= temp0 (- (param1 tempSize:) 1)))
			(param1 whose: 2 tempSize: 0 blot: 0)
		else
			(param1 tempSize: temp0 blot: (== temp0 1) closed: (>= temp0 2))
		)
	)

	(method (checkToProps param1 param2)
		(cond
			((== (param2 whose:) otherColor)
				(self updateProps: param2 otherBar)
				(param2 hit: 1)
			)
			((param2 hit:)
				(param2 hit: (+ (param2 hit:) 1))
			)
		)
		(self updateProps: param1 param2)
	)

	(method (checkFromProps param1 param2)
		(self updateProps: param1 param2)
		(if (param1 hit:)
			(param1 hit: (- (param1 hit:) 1))
			(if (not (or (param1 tempSize:) (param1 hit:)))
				(self updateProps: otherBar param1)
			)
		)
	)

	(method (validMove param1 &tmp temp0)
		(cond
			((> param1 0)
				(if
					(or
						(!= ((= temp0 (self at: param1)) whose:) otherColor)
						(temp0 blot:)
					)
					(return temp0)
				)
			)
			((not global781)
				(return off)
			)
		)
		(return 0)
	)

	(method (updatePoints param1 param2 param3)
		(if (and (param1 blot:) (param1 number:))
			(cond
				((< param3 0)
					(whichPoints addAfter: param2 param1)
				)
				(param3
					(whichPoints
						addAfter: (whichPoints at: (- param3 1)) param1
					)
				)
				(else
					(whichPoints addToFront: param1)
				)
			)
			(++ local216)
			(if (> (param1 number:) 6)
				(++ global781)
			)
		)
		(if (and (!= (param2 whose:) myColor) (param2 number:))
			(whichPoints delete: param2)
			(-- local216)
			(if (> (param2 number:) 6)
				(-- global781)
			)
		)
	)

	(method (noLegalMoves param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0 (gTheDiceList size:))
		(= temp2 ((KList 8 (whichPoints first:)) number:)) ; NodeValue
		(for ((= temp5 0)) (< temp5 local216) ((++ temp5))
			(cond
				((>= param1 0)
					(for ((= temp6 0)) (< temp6 temp0) ((++ temp6))
						(if
							(and
								(or (not param1) (== (+ temp6 1) param1))
								(or
									(not
										((= temp1 (gTheDiceList at: temp6))
											oldPoint:
										)
									)
									[param1 1]
								)
								(self
									validMove:
										(-
											(= temp3
												((whichPoints at: temp5)
													number:
												)
											)
											(= temp4 (temp1 pipValue:))
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
							validMove:
								(-
									(= temp3 ((whichPoints at: temp5) number:))
									[param1 1]
								)
						)
						(self
							validMove:
								(-
									temp3
									((gTheDiceList at: (- [param1 2] 1)) pipValue:)
								)
						)
					)
					(return 0)
				)
			)
		)
		(return 1)
	)

	(method (adjustLevel &tmp temp0 temp1 temp2 temp3)
		(if (self noLegalMoves: 0 0)
			(return 0)
		else
			(= temp2 (= temp0 (gTheDiceList size:)))
			(if (and (bar size:) (or (not global786) aceyHits))
				(for ((= temp3 0)) (< temp3 temp2) ((++ temp3))
					(if
						(or
							(not
								(self
									validMove:
										(-
											25
											((= temp1 (gTheDiceList at: temp3))
												pipValue:
											)
										)
								)
							)
							(temp1 oldPoint:)
						)
						(-- temp0)
					)
				)
				(if (<= (bar tempSize:) temp0)
					(= temp0 temp2)
				)
			)
			(return temp0)
		)
	)

	(method (generateBoards &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 [temp20 39])
		(RedrawCast)
		(= local244 (GetTime))
		(= local218 (= temp12 (= local245 (= local246 0))))
		(= local217 32769)
		(= local215 (self adjustLevel:))
		(while local215
			(-- local215)
			(if (gTheDiceList doubles:)
				(= temp15 global781)
				(= temp13 (gTheDice1 pipValue:))
				(for ((= temp0 0)) (< temp0 local216) ((++ temp0))
					(if
						(= temp8
							(self
								validMove:
									(-
										((= temp4 (whichPoints at: temp0))
											number:
										)
										temp13
									)
							)
						)
						(self checkToProps: temp4 temp8)
						(cond
							(local215
								(self updatePoints: temp8 temp4 -1)
								(= temp16 global781)
								(for
									((= temp1
										(if (and (not global781) temp15)
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
												validMove:
													(-
														((= temp5
																(whichPoints
																	at: temp1
																)
															)
															number:
														)
														temp13
													)
											)
										)
										(self checkToProps: temp5 temp9)
										(cond
											((>= local215 2)
												(self
													updatePoints: temp9 temp5 -1
												)
												(= temp17 global781)
												(for
													((= temp2
														(if
															(and
																(not global781)
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
																validMove:
																	(-
																		((=
																				temp6
																				(whichPoints
																					at:
																						temp2
																				)
																			)
																			number:
																		)
																		temp13
																	)
															)
														)
														(self
															checkToProps:
																temp6
																temp10
														)
														(cond
															((>= local215 3)
																(self
																	updatePoints:
																		temp10
																		temp6
																		-1
																)
																(for
																	((= temp3
																		(if
																			(and
																				(not
																					global781
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
																				validMove:
																					(-
																						((=
																								temp7
																								(whichPoints
																									at:
																										temp3
																								)
																							)
																							number:
																						)
																						temp13
																					)
																			)
																		)
																		(self
																			checkToProps:
																				temp7
																				temp11
																		)
																		(if
																			(=
																				temp14
																				(self
																					evaluateBoard:
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
																				compareBoard:
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
																			checkFromProps:
																				temp11
																				temp7
																		)
																	)
																)
															)
															(
																(= temp14
																	(self
																		evaluateBoard:
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
																	compareBoard:
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
															checkFromProps:
																temp10
																temp6
														)
														(if (>= local215 3)
															(self
																updatePoints:
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
														evaluateBoard:
															temp4
															temp5
															temp8
															temp9
													)
												)
												(++ temp12)
												(self
													compareBoard:
														temp14
														temp8
														temp4
														temp9
														temp5
												)
											)
										)
										(self checkFromProps: temp9 temp5)
										(if (>= local215 2)
											(self
												updatePoints: temp5 temp9 temp1
											)
										)
									)
								)
							)
							((= temp14 (self evaluateBoard: temp4 temp8))
								(++ temp12)
								(self compareBoard: temp14 temp8 temp4)
							)
						)
						(self checkFromProps: temp8 temp4)
						(if local215
							(self updatePoints: temp4 temp8 temp0)
						)
					)
				)
			else
				(for ((= temp0 0)) (< temp0 local216) ((++ temp0))
					(if
						(= temp8
							(self
								validMove:
									(-
										((= temp4 (whichPoints at: temp0))
											number:
										)
										(gTheDice1 pipValue:)
									)
							)
						)
						(self checkToProps: temp4 temp8)
						(cond
							(local215
								(self updatePoints: temp8 temp4 -1)
								(for
									((= temp1 0))
									(< temp1 local216)
									((++ temp1))
									
									(if
										(= temp9
											(self
												validMove:
													(-
														((= temp5
																(whichPoints
																	at: temp1
																)
															)
															number:
														)
														(gTheDice2 pipValue:)
													)
											)
										)
										(self checkToProps: temp5 temp9)
										(if
											(= temp14
												(self
													evaluateBoard:
														temp4
														temp5
														temp8
														temp9
												)
											)
											(++ temp12)
											(self
												compareBoard:
													temp14
													temp8
													temp4
													temp9
													temp5
											)
										)
										(self checkFromProps: temp9 temp5)
									)
								)
							)
							((= temp14 (self evaluateBoard: temp4 temp8))
								(++ temp12)
								(self compareBoard: temp14 temp8 temp4)
							)
						)
						(self checkFromProps: temp8 temp4)
						(if local215
							(self updatePoints: temp4 temp8 temp0)
						)
					)
				)
				(if
					(= temp8
						(self
							validMove:
								(-
									((= temp4 (KList 8 (whichPoints first:))) ; NodeValue
										number:
									)
									(gTheDice2 pipValue:)
								)
						)
					)
					(= temp10 global781)
					(self checkToProps: temp4 temp8)
					(if local215
						(self updatePoints: temp8 temp4 -1)
						(if
							(and
								local216
								(not global781)
								temp10
								(not (self noLegalMoves: 1 1))
							)
							(for ((= temp1 0)) (< temp1 local216) ((++ temp1))
								(if
									(= temp9
										(self
											validMove:
												(-
													((= temp5
															(whichPoints
																at: temp1
															)
														)
														number:
													)
													(gTheDice1 pipValue:)
												)
										)
									)
									(self checkToProps: temp5 temp9)
									(if
										(= temp14
											(self
												evaluateBoard:
													temp5
													temp4
													temp9
													temp8
											)
										)
										(++ temp12)
										(self
											compareBoard:
												temp14
												temp8
												temp4
												temp9
												temp5
										)
									)
									(self checkFromProps: temp9 temp5)
								)
							)
						)
					)
					(self checkFromProps: temp8 temp4)
					(if local215
						(self updatePoints: temp4 temp8 0)
					)
				)
				(for ((= temp0 0)) (< temp0 local216) ((++ temp0))
					(if
						(= temp8
							(self
								validMove:
									(-
										((= temp4 (whichPoints at: temp0))
											number:
										)
										(gTheDice2 pipValue:)
									)
							)
						)
						(self checkToProps: temp4 temp8)
						(cond
							(local215
								(if
									(and
										(temp8 blot:)
										(= temp9
											(self
												validMove:
													(-
														(temp8 number:)
														(gTheDice1 pipValue:)
													)
											)
										)
										(!= temp8 off)
									)
									(self checkToProps: temp8 temp9)
									(if
										(= temp14
											(self
												evaluateBoard:
													temp8
													temp4
													temp9
													temp8
											)
										)
										(++ temp12)
										(if (!= temp9 off)
											(gTheDiceList
												delete: gTheDice2
												addToFront: gTheDice2
											)
										)
										(self
											compareBoard:
												temp14
												temp8
												temp4
												temp9
												temp8
										)
									)
									(self checkFromProps: temp9 temp8)
								)
							)
							((= temp14 (self evaluateBoard: temp4 temp8))
								(++ temp12)
								(self compareBoard: temp14 temp8 temp4)
							)
						)
						(self checkFromProps: temp8 temp4)
					)
				)
			)
			(if temp12
				(break)
			)
		)
		(= temp0 1)
		(= temp1 (gTheDiceList size:))
		(while (< temp0 temp1)
			(if (== bar ((= temp4 (gTheDiceList at: temp0)) oldPoint:))
				(gTheDiceList delete: temp4 addToFront: temp4)
			)
			(++ temp0)
		)
		(if
			(or
				(==
					((= temp4 (gTheDiceList at: 1)) newPoint:)
					((= temp5 (gTheDiceList at: 0)) oldPoint:)
				)
				(and
					(temp4 oldPoint:)
					(> ((temp4 oldPoint:) number:) 6)
					(== (temp5 newPoint:) off)
				)
			)
			(gTheDiceList delete: temp4 addToFront: temp4)
		)
		(if (and global788 (>= skill 1))
			(for ((= temp18 0)) (< temp18 (gTheDiceList size:)) ((++ temp18))
				(if ((gTheDiceList at: temp18) oldPoint:)
					(gStr
						cat:
							(temp19 ; UNINIT
								format:
									{%d %d }
									(((gTheDiceList at: temp18) oldPoint:) number:)
									(((gTheDiceList at: temp18) newPoint:) number:)
							)
					)
				)
			)
			(Print global550:)
		)
	)

	(method (think &tmp temp0 temp1 temp2 temp3 temp4)
		(if
			((= temp0 (gTheDiceList at: (= temp1 (gTheDiceList numberUsed:))))
				oldPoint:
			)
			(self
				moveStone: (temp0 oldPoint:) (temp0 newPoint:)
				updatePoints: (temp0 newPoint:) (temp0 oldPoint:)
			)
			((temp0 newPoint:) moveToPoint:)
			(if (not (or temp1 global775))
				(= temp2 (KList 8 (gTheDiceList first:))) ; NodeValue
				(= temp3 (KList 8 (gTheDiceList last:))) ; NodeValue
				(if
					(and
						(not (temp3 oldPoint:))
						(==
							(-
								((temp2 oldPoint:) number:)
								((temp2 newPoint:) number:)
							)
							(temp3 pipValue:)
						)
					)
					(= temp1 1)
				)
			)
			(gTheDiceList movePick: temp1 1)
		else
			(if (and (== type 1) count)
				(EnableCursor)
				(RedrawCast)
				(proc0_12 905)
				(gChar1 say6: 1000 2 67 0 (Random 1 5) 0 0)
			)
			(gTheDiceList pickupAll:)
			(gGamePlayScript cycles: 1)
		)
	)

	(method (evaluateToMove param1 &tmp temp0)
		(if (== skill 0)
			(if (param1 blot:)
				(-= local229 (param1 blotNum:))
			)
			(if (and (param1 closed:) (< (param1 size:) 2))
				(++ local232)
			)
			(if (or (not (param1 size:)) (== (param1 whose:) otherColor))
				(++ local233)
			)
		)
		(if (param1 hit:)
			(+= local228 (param1 hitNum:))
			(++ local247)
		)
		(if (== skill 0)
			(return)
		)
		(if (and (param1 closed:) (< (param1 size:) 2))
			(+=
				local232
				(Max
					(- 6 (Max 1 (Abs (- (= temp0 (param1 number:)) 6))))
					1
				)
			)
			(if (and (== skill 2) (<= 2 temp0 3))
				(-= local232 (- temp0 1))
			)
		)
		(if (== skill 1)
			(return)
		)
		(if (and (== (param1 number:) 20) (param1 closed:))
			(+= local238 (if (> count 80) 750 else 100))
		)
	)

	(method (evaluateFromMove param1)
		(if (and (== skill 0) (param1 blot:))
			(-= local229 (param1 blotNum:))
		)
		(if
			(and
				(== (param1 number:) 20)
				(>= (param1 size:) 2)
				(not (param1 closed:))
				local239
			)
			(-= local238 300)
		)
	)

	(method (evaluateMove param1 param2 &tmp temp0 temp1)
		(if (and (== skill 0) (>= (param1 number:) 6))
			(++ local234)
		)
		(if (>= skill 1)
			(if
				(and
					(!=
						(/ (- (= temp1 (param1 number:)) 1) 6)
						(/ (= temp0 (- (param2 number:) 1)) 6)
					)
					(> temp1 6)
				)
				(+= local234 (+ (mod temp0 6) (* (/ temp1 6) 3)))
			)
			(if
				(and
					(== skill 1)
					(>= (param1 size:) 2)
					(not (param1 closed:))
					global781
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
				(== (param1 size:) 1)
				(not (param1 tempSize:))
				(param2 closed:)
				(>= (param2 size:) 2)
			)
			(++ local230)
		)
		(if (== param2 off)
			(+= local231 (+ 25 (param1 number:)))
		)
	)

	(method (evaluateOverall param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14)
		(if (== skill 0)
			(return)
		)
		(= temp3 [param1 (- argc 1)])
		(= temp4 (>> argc $0001))
		(= temp1
			(= temp5
				(= temp6
					(= temp8
						(= bigPrime
							(= temp11 (= local242 (= temp12 (= temp10 0))))
						)
					)
				)
			)
		)
		(if global772
			(if (== skill 2)
				(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
					(if
						(<
							([param1 temp14] number:)
							global783
							([param1 (- temp14 temp4)] number:)
						)
						(++ bigPrime)
					)
				)
				(if
					(and
						(= temp13
							(if (== bigPrime local240)
								(not local228)
							)
						)
						(> global777 0)
					)
					(+= local238 1000)
				)
				(= bigPrime 0)
				(= local241 25)
				(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
					(if
						(or
							(and
								((= temp0 [param1 temp14]) closed:)
								(< (temp0 size:) 2)
								(< (= temp9 (temp0 number:)) local241)
							)
							(and
								(not
									((= temp0 [param1 (- temp14 temp4)])
										closed:
									)
								)
								(>= (temp0 size:) 2)
								(< (= temp9 (temp0 number:)) local241)
							)
						)
						(= local241 temp9)
					)
				)
				(if (or global781 local249)
					(for ((= temp14 6)) (<= temp14 10) ((++ temp14))
						(if (otherPlayer validMove: (- 25 temp14))
							(break)
						)
						(++ bigPrime)
						(= endPrime temp14)
					)
					(if endPrime
						(= temp12 6)
						(for ((= temp14 5)) temp14 ((-- temp14))
							(if (otherPlayer validMove: (- 25 temp14))
								(break)
							)
							(= temp12 temp14)
							(++ bigPrime)
						)
					)
				)
				(if (< bigPrime 3)
					(= bigPrime 0)
				)
			else
				(= temp13 0)
			)
			(for ((= temp14 0)) (< temp14 local216) ((++ temp14))
				(cond
					(
						(>=
							(= temp9
								((= temp0 (whichPoints at: temp14)) number:)
							)
							19
						)
						(++ temp5)
					)
					((<= 1 temp9 6)
						(++ temp6)
						(if (temp0 closed:)
							(++ local242)
						)
					)
				)
			)
			(if (temp3 blot:)
				(cond
					((>= (= temp9 (temp3 number:)) 19)
						(++ temp5)
					)
					((<= 1 temp9 6)
						(++ temp6)
					)
				)
			)
			(= local243 (- 6 local242))
			(for ((= temp14 0)) (< temp14 local216) ((++ temp14))
				(if ((= temp0 (whichPoints at: temp14)) blot:)
					(= temp2
						(if
							(or
								(== skill 1)
								(and
									(not local228)
									(<= (temp0 number:) local241)
								)
							)
							(temp0 hitStore:)
						else
							(self numberOfRolls: (temp0 altNum:))
						)
					)
					(temp0 hitProb: temp2)
					(if (< (= temp9 (temp0 number:)) 19)
						(+= temp8 temp2)
						(if temp2
							(++ temp1)
						)
					)
					(if (and temp2 (<= temp9 6))
						(++ temp11)
					)
					(if temp2
						(-= local229 (*= temp2 (temp0 blotNum:)))
						(-= temp10 temp2)
					)
					(if (otherBar tempSize:)
						(if (== skill 1)
							(-= local229 (* [local15 temp9] (temp0 blotNum:)))
						else
							(-= local229 local237)
						)
					)
				)
			)
			(if (temp3 blot:)
				(= temp2
					(if
						(or
							(== skill 1)
							(and (not local228) (<= (temp3 number:) local241))
						)
						(temp3 hitStore:)
					else
						(self numberOfRolls: (temp3 altNum:))
					)
				)
				(temp3 hitProb: temp2)
				(if (< (= temp9 (temp3 number:)) 19)
					(+= temp8 temp2)
					(if temp2
						(++ temp1)
					)
				)
				(if (and temp2 (<= temp9 6))
					(++ temp11)
				)
				(if temp2
					(-= local229 (*= temp2 (temp3 blotNum:)))
					(-= temp10 temp2)
				)
				(if (otherBar tempSize:)
					(if (== skill 1)
						(-= local229 (* [local15 temp9] (temp3 blotNum:)))
					else
						(-= local229 local237)
					)
				)
			)
			(if (not global781)
				(*= local229 local226)
				(if (and (== skill 2) (> ([param1 0] number:) 6))
					(*= local229 2)
				)
			)
			(if (== skill 2)
				(if
					(and
						(or
							(>= global784 4)
							(and (== global784 3) (>= global777 15))
						)
						(< local242 temp6)
					)
					(if
						(<=
							local229
							(= temp0 (/ 32769 (= temp9 (* (- global784 2) 2))))
						)
						(= local229 temp0)
					)
					(*= local229 temp9)
				)
				(if (and temp11 local239 (> global777 -20))
					(if (<= local229 (= temp0 (/ 32769 (= temp9 (* temp11 3)))))
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
						(not ((= temp0 [param1 temp14]) blot:))
						(or
							(== (= temp9 ([param1 temp14] size:)) 2)
							(> temp9 3)
							(and
								(>= bigPrime 5)
								(< (otherPlayer bigPrime:) 6)
								(<=
									1
									(-
										temp12
										([param1 (+ temp14 temp4)] number:)
									)
									2
								)
							)
						)
						(!=
							temp1
							(= temp9
								((= temp0 [param1 (+ temp14 temp4)]) number:)
							)
						)
						(temp0 tempSize:)
						(or
							(and
								(temp0 blot:)
								(<= (temp0 hitProb:) temp7)
								(or (temp0 hit:) (> (temp0 number:) 7))
								(or (> temp9 2) (<= 1 (- temp12 temp9) 2))
							)
							(and
								(== (temp0 tempSize:) 3)
								(< 0 (temp0 size:) 3)
								(!= ([param1 temp14] size:) 3)
								(or (> temp9 7) (!= ([param1 temp14] size:) 2))
								(or (> temp9 3) (<= 1 (- temp12 temp9) 2))
							)
						)
					)
					(+=
						local235
						(*
							(+ (* 2 (not (temp0 hitProb:))) 1)
							(Max
								(- 8 (Max 1 (Abs (- temp9 7))))
								5
							)
						)
					)
				)
			)
		)
		(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
			(if
				(and
					((= temp0 [param1 temp14]) blot:)
					(not (temp0 size:))
					([param1 (- temp14 temp4)] tempSize:)
				)
				(++ local233)
			)
			(if
				(and
					(not ([param1 (- temp14 temp4)] tempSize:))
					(!= (= temp0 [param1 temp14]) off)
					(temp0 size:)
				)
				(-- local233)
			)
			(if
				(and
					(!= [param1 (- temp14 temp4)] bar)
					(== (= temp9 (temp0 number:)) 23)
					(not (temp0 closed:))
					(not (temp0 hit:))
					(not (<= 1 (- temp9 (otherPlayer endPrime:)) 2))
				)
				(-= local238 500)
			)
			(if
				(and
					(== (temp0 number:) 6)
					(> (temp0 tempSize:) 5)
					global772
					(< ([param1 (- temp14 temp4)] hitProb:) 11)
				)
				(-= local238 (* 250 (- (temp0 tempSize:) 5)))
			)
		)
		(if (== skill 2)
			(if (and (not temp1) local242 (<= temp11 1))
				(= temp9 (+ local242 2))
				(if (> local242 2)
					(+= temp9 (Random 0 1))
				)
				(*= local228 (>> temp9 $0001))
			)
			(if (and (>= local247 2) (or (<= temp11 1) (<= global777 -20)))
				(*= local228 (+ (* (- local247 1) 2) 1))
			)
			(if (and (>= global777 10) global772 (off size:))
				(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
					(if ((= temp0 [param1 temp14]) hit:)
						(-= local238 500)
					)
				)
			)
			(if
				(and
					(> global779 temp5)
					(or
						(= temp1
							(if (== [param1 0] bar)
								(and
									(<
										((= temp0 [param1 temp4]) number:)
										global783
									)
									(== temp0 [param1 (- temp4 1)])
								)
							)
						)
						(and (< global777 -20) global772)
					)
				)
				(for ((= temp14 0)) (< temp14 temp4) ((++ temp14))
					(if
						(and
							(>= ((= temp0 [param1 temp14]) number:) 19)
							(<= (temp0 size:) 2)
							(not (temp0 closed:))
						)
						(if
							(or
								((= temp0 [param1 (+ temp14 temp4)]) hit:)
								(not temp1)
							)
							(if
								(or
									(<= (= temp9 (temp0 number:)) 19)
									(< temp9 global783)
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
					(<= bigPrime 3)
					(> ((KList 8 (whichPoints first:)) number:) 13) ; NodeValue
					(< local242 3)
				)
				(= temp14 temp4)
				(= temp1 0)
				(while (< temp14 argc)
					(if
						(and
							(!=
								temp1
								(= temp9 ((= temp0 [param1 temp14]) number:))
							)
							(temp0 closed:)
							(!= (- temp12 1) temp9)
							(or
								(== temp9 1)
								(and (== temp9 2) (not (temp0 tempSize:)))
							)
							(not (otherBar tempSize:))
						)
						(= temp1 temp9)
						(-= local238 (* 300 (- 3 temp9)))
					)
					(++ temp14)
				)
			)
			(if (not global772)
				(if (<= global779 (- 15 temp6))
					(for ((= temp14 0)) (< temp14 temp4) ((++ temp14))
						(if (> ([param1 temp14] number:) 6)
							(+=
								local238
								(if (<= ([param1 (+ temp14 temp4)] number:) 6)
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
						((>= ([param1 temp14] number:) 19)
							(+= local238 2000)
						)
						((> ([param1 temp14] number:) 6)
							(+= local238 500)
						)
					)
				)
			)
			(if (not local238)
				(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
					(if
						(<=
							((= temp0 [param1 temp14]) number:)
							19
							([param1 (- temp14 temp4)] number:)
						)
						(cond
							((<= global779 temp5)
								(+= local238 1250)
							)
							((>= temp5 local239)
								(+= local238 125)
							)
						)
					)
				)
			)
			(if (and global781 global772 (not temp13))
				(for ((= temp14 (= temp1 0))) (< temp14 temp4) ((++ temp14))
					(if
						(and
							(!=
								temp1
								(= temp9 ((= temp0 [param1 temp14]) number:))
							)
							(>= (temp0 size:) 2)
							(not (temp0 closed:))
							(<= temp9 10)
							(or
								(!= temp9 (+ endPrime 1))
								(<= temp9 7)
								(and (>= (temp0 hitProb:) 11) (>= bigPrime 3))
								(== (+ endPrime 1) 6)
							)
							(or
								(and (not (temp0 size:)) (<= temp9 7))
								(temp0 blot:)
								(> ([param1 (+ temp14 temp4)] number:) 6)
								temp11
							)
							(not
								(and
									(gTheDiceList doubles:)
									(== temp9 (+ endPrime 1))
									(==
										((= temp0 (self at: (+ temp9 1))) size:)
										2
									)
									(not (temp0 tempSize:))
								)
							)
						)
						(= temp1 temp9)
						(-=
							local232
							(*
								(+ 1 ([param1 (+ temp14 temp4)] closed:))
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
				(if bigPrime
					(= temp1 0)
					(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
						(if
							(and
								(!=
									temp1
									(= temp9
										((= temp0 [param1 temp14]) number:)
									)
								)
								(temp0 closed:)
								(< (temp0 size:) 2)
								(or
									(not
										((= temp0 [param1 (- temp14 temp4)])
											blot:
										)
									)
									(> temp9 6)
									(not temp11)
								)
								(== (temp0 number:) endPrime)
								(!= endPrime 6)
								(<= (temp0 number:) 10)
								(not (temp0 closed:))
								(>= (temp0 size:) 2)
								(or (not local248) bigPrime)
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
				(if (and (otherBar tempSize:) (>= local242 3))
					(= temp1 0)
					(for ((= temp14 (= temp1 0))) (< temp14 temp4) ((++ temp14))
						(if
							(and
								(!= temp1 (= temp9 ([param1 temp14] number:)))
								(<=
									((= temp0 [param1 (+ temp14 temp4)])
										number:
									)
									6
								)
								(< (temp0 size:) 2)
								(temp0 closed:)
								(or (not local248) bigPrime)
							)
							(= temp1 temp9)
							(+=
								local232
								(*
									(+ (temp0 hit:) 1)
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
					((>= bigPrime 6)
						(+= local238 1000)
					)
					((and (== bigPrime 5) (< local248 5))
						(+= local238 500)
					)
				)
			)
			(if (>= (otherPlayer bigPrime:) 4)
				(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
					(if
						(<=
							1
							(= temp9
								(-
									((= temp0 [param1 temp14]) number:)
									(otherPlayer endPrime:)
								)
							)
							2
						)
						(+=
							local238
							(if (and (== temp9 1) (temp0 closed:)) 900 else 500)
						)
					)
				)
			)
			(if (not local238)
				(for ((= temp14 temp4)) (< temp14 argc) ((++ temp14))
					(if
						(==
							((= temp0 [param1 temp14]) number:)
							(- (otherPlayer endPrime:) (otherPlayer bigPrime:))
						)
						(+= local238 (if (temp0 hit:) 750 else 300))
					)
				)
				(for ((= temp14 0)) (< temp14 temp4) ((++ temp14))
					(if
						(and
							(== ((= temp0 [param1 temp14]) number:) 13)
							(not (temp0 closed:))
							temp5
						)
						(-= local238 150)
					)
				)
				(for ((= temp14 0)) (< temp14 temp4) ((++ temp14))
					(if
						(and
							(>=
								([param1 temp14] number:)
								(= temp9 ([param1 (+ temp14 temp4)] number:))
								19
							)
							(temp0 tempSize:)
						)
						(+= local238 (* (- 24 temp9) 30))
					)
				)
			)
			(if (and temp13 local229 (not global781))
				(= local228
					(= local230
						(= local232 (= local235 (= local238 (= bigPrime 0))))
					)
				)
			)
		)
	)

	(method (evaluateBoard param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(cond
			(local246
				(= local245 (& (++ local245) $0007))
			)
			((>= (- (GetTime) local244) 180)
				(= local246 1)
			)
		)
		(if (>= (= temp0 (- (bar size:) (bar tempSize:))) local218)
			(if (and (bar size:) (not temp0))
				(return 0)
			)
			(= temp2 (>> argc $0001))
			(if (- (off tempSize:) (off size:))
				(= temp7 6)
				(= temp1 0)
				(while temp7
					(if (== ((self at: temp7) whose:) myColor)
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
										calcUsed:
											(= temp6 [param1 temp7])
											(= temp5 [param1 (+ temp7 temp2)])
									)
								)
								((gTheDiceList at: temp7) pipValue:)
							)
							(> temp1 temp3)
						)
						(return 0)
					)
				)
			)
			(if (> temp0 local218)
				(gTheDiceList clearAll:)
				(= local217 32769)
				(= local218 temp0)
			)
			(if (!= skill -1)
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
															(= bigPrime
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
					(if (and (!= temp4 (= temp6 [param1 temp7])) (!= temp6 bar))
						(self evaluateFromMove: (= temp4 temp6))
					)
					(if
						(and
							(!= temp3 (= temp5 [param1 (+ temp7 temp2)]))
							(!= temp5 off)
						)
						(self evaluateToMove: (= temp3 temp5))
					)
					(self evaluateMove: temp6 temp5)
				)
				(self evaluateOverall: param1 &rest)
				(if (< local229 -14000)
					(= local229 51536)
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
						(* local227 bigPrime)
						local238
					)
				)
				(if (and global788 (>= skill 1))
					(temp9 format: {}) ; UNINIT
					(for ((= temp7 0)) (< temp7 argc) ((++ temp7))
						(gStr
							cat:
								(temp9 ; UNINIT
									format:
										{%d %d }
										([param1 temp7] number:)
										([param1 (++ temp7)] number:)
								)
						)
					)
					(gStr
						cat:
							(temp9 ; UNINIT
								format:
									{\n%d %d %d %d %d %d %d %d %d %d\n}
									local228
									local229
									local230
									local232
									local231
									local233
									local234
									local235
									local238
									bigPrime
							)
					)
					(gStr
						cat:
							(temp9 ; UNINIT
								format:
									{%d %d %d %d %d %d %d %d %d %d\n= %d}
									(* local228 local219)
									local229
									(* local230 local220)
									(* local232 local222)
									(* local231 local221)
									(* local233 local224)
									(* local234 local223)
									(* local235 local225)
									local238
									(* local227 bigPrime)
									temp1
							)
					)
					(>= temp1 local217)
					(for ((= temp7 0)) (< temp7 (gTheDiceList size:)) ((++ temp7))
						(if ((gTheDiceList at: temp7) oldPoint:)
							(gStr
								cat:
									(temp9 ; UNINIT
										format:
											{%d %d }
											(((gTheDiceList at: temp7) oldPoint:)
												number:
											)
											(((gTheDiceList at: temp7) newPoint:)
												number:
											)
									)
							)
						)
					)
					(gStr
						cat:
							(temp9 ; UNINIT
								format:
									{= %d\n%d %d %d %d %d %d %d %d %d %d}
									local217
									[global791 0]
									[global791 1]
									[global791 2]
									[global791 3]
									[global791 4]
									[global791 5]
									[global791 6]
									[global791 7]
									[global791 8]
									[global791 9]
							)
					)
					(gStr
						cat:
							(temp9 ; UNINIT
								format:
									{\n%d %d %d %d %d %d %d %d %d %d\n}
									[global791 10]
									[global791 11]
									[global791 12]
									[global791 13]
									[global791 14]
									[global791 15]
									[global791 16]
									[global791 17]
									[global791 18]
									[global791 19]
							)
					)
					global790
					(if (>= temp1 local217)
						(= [global791 0] local228)
						(= [global791 1] local229)
						(= [global791 2] local230)
						(= [global791 3] local232)
						(= [global791 4] local231)
						(= [global791 5] local233)
						(= [global791 6] local234)
						(= [global791 7] local235)
						(= [global791 8] local238)
						(= [global791 9] bigPrime)
						(= [global791 10] (* local228 local219))
						(= [global791 11] local229)
						(= [global791 12] (* local230 local220))
						(= [global791 13] (* local232 local222))
						(= [global791 14] (* local231 local221))
						(= [global791 15] (* local233 local224))
						(= [global791 16] (* local234 local223))
						(= [global791 17] (* local235 local225))
						(= [global791 18] local238)
						(= [global791 19] (* bigPrime local227))
					)
				)
				(return temp1)
			else
				(return (Random 1 99))
			)
		)
		(return 0)
	)

	(method (compareBoard param1 param2 &tmp temp0 temp1 temp2)
		(= temp2 (>> (- argc 1) $0001))
		(if (< local217 param1)
			(= temp0 (= temp1 0))
			(while (< temp0 temp2)
				((gTheDiceList at: temp0)
					newPoint: [param2 temp1]
					oldPoint: [param2 (++ temp1)]
				)
				(++ temp0)
				(++ temp1)
			)
			(= local217 param1)
		)
	)

	(method (adjustWeights)
		(switch skill
			(0
				(= local221 30)
				(= local225 0)
				(= local227 0)
				(= local226 1)
				(cond
					((not global781)
						(if global772
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
					(global772
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
					((not global781)
						(if global772
							(if (>= count (+ (otherPlayer count:) 20))
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
					(global772
						(if (> global777 -20)
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
				(if (not global781)
					(= local226 30)
					(if global772
						(if
							(or
								(<= global777 -20)
								(and (<= global777 0) (> global783 12))
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
					(if global772
						(if
							(or
								(<= global777 -20)
								(and (<= global777 0) (> global783 12))
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

	(method (makeFirstMove &tmp temp0 temp1 temp2 temp3 temp4)
		(if (gTheDiceList doubles:)
			(= temp0 (+ (* (- (gTheDice1 pipValue:) 1) 4) 30))
		else
			(= temp1 (- (gTheDice2 pipValue:) 1))
			(for ((= temp4 (= temp0 0))) (< temp4 temp1) ((++ temp4))
				(+= temp0 (- 5 temp4))
			)
			(= temp0 (* (+ temp0 (- (- (gTheDice1 pipValue:) temp1) 2)) 2))
		)
		(if (!= skill -1)
			(+= temp0 (* skill 54))
		)
		(= temp4 0)
		(while (< temp4 (gTheDiceList size:))
			((= temp2 (gTheDiceList at: temp4))
				oldPoint: (self at: (= temp3 [local40 temp0]))
			)
			(temp2 newPoint: (self at: (- temp3 (temp2 pipValue:))))
			(++ temp4)
			(++ temp0)
		)
		(= global775 0)
	)

	(method (init &tmp temp0 temp1)
		(if (and global787 (== self global753))
			(setupButton init:)
		)
		((= bar (KList 8 (self last:))) whose: myColor number: 25) ; NodeValue
		((= off (KList 8 (self first:))) whose: myColor) ; NodeValue
		(= whichPoints (BGPlayer new:))
		(for ((= temp1 0)) (< temp1 15) ((++ temp1))
			((= temp0 (bar at: temp1)) color: myColor init:)
			(gAllStonesObj add: temp0)
		)
		(for ((= temp1 0)) (<= temp1 25) ((++ temp1))
			((self at: temp1) init:)
		)
		(= otherPlayer (if (== self global753) global754 else global753))
		(= otherBar (if (== bar gTheBar1) gTheBar2 else gTheBar1))
		(= otherColor (otherPlayer myColor:))
	)

	(method (moveAllToBar &tmp temp0 temp1 temp2)
		(self numberPoints:)
		(for ((= temp1 0)) (!= (bar size:) 15) ((++ temp1))
			(if (== ((= temp0 (self at: temp1)) whose:) myColor)
				(for ((= temp2 0)) (temp0 size:) ((++ temp2))
					(self moveStone: temp0 bar)
				)
			)
		)
		(= count 375)
	)

	(method (setupPlayer &tmp temp0 temp1)
		(self numberPoints:)
		(if (not global786)
			(for ((= temp0 0)) (< temp0 15) ((++ temp0))
				(self moveStone: bar (self at: [local0 temp0]))
			)
		)
		(for ((= temp0 0)) (<= temp0 25) ((++ temp0))
			(if (== ((= temp1 (self at: temp0)) whose:) myColor)
				(temp1 adjustPoint:)
			)
		)
		(self readPoints: 0)
		(= aceyHits 0)
	)

	(method (numberPoints &tmp temp0)
		(for ((= temp0 1)) (< temp0 25) ((++ temp0))
			((self at: temp0)
				number: temp0
				hitNum: (* (- (* (/ (+ temp0 5) 6) 3) 2) 15)
				altNum: (- 25 temp0)
				blotNum: (- (* (/ (- 25 (- temp0 5)) 6) 3) 2)
			)
		)
	)

	(method (readPoints param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (not param1)
			(= global780 global781)
			(= local239 (= local240 (= global784 (= endPrime 0))))
			(= temp2 (otherPlayer whichPoints:))
			(= temp3 (temp2 size:))
			(if
				(and
					(temp2 size:)
					(== (= global783 ((KList 8 (temp2 first:)) number:)) 25) ; NodeValue
				)
				(= global783 -1)
			)
			(= global779 (- 15 ((otherPlayer off:) size:)))
		)
		(whichPoints release:)
		(= global781 0)
		(for ((= temp5 25)) temp5 ((-- temp5))
			(if (== ((= temp0 (self at: temp5)) whose:) myColor)
				(whichPoints add: temp0)
				(if (> (= temp4 (temp0 number:)) 6)
					(++ global781)
				)
				(if (and (not param1) (> temp4 global783))
					(+= local240 (temp0 size:))
				)
			)
			(if (not param1)
				(if (== skill 2)
					(temp0 hitProb: (self numberOfRolls: (temp0 altNum:)))
				else
					(temp0 hitProb: 0)
					(for ((= temp6 0)) (< temp6 temp3) ((++ temp6))
						(if (< (= temp4 ((temp2 at: temp6) number:)) temp5)
							(temp0
								hitProb:
									(+
										(temp0 hitProb:)
										[local15 (- temp5 temp4)]
									)
							)
						)
					)
				)
				(temp0 hitStore: (temp0 hitProb:))
			)
		)
		(= local216 (whichPoints size:))
		(if (not param1)
			(if (not local216)
				(= global772 0)
			else
				(= global772
					(< global783 ((KList 8 (whichPoints first:)) number:)) ; NodeValue
				)
			)
			(for ((= temp5 0)) (< temp5 temp3) ((++ temp5))
				(cond
					((<= (= temp4 ((= temp0 (temp2 at: temp5)) number:)) 6)
						(++ local239)
					)
					((and (>= 24 temp4 19) (temp0 closed:))
						(++ global784)
					)
				)
			)
			(if global772
				(= local249 global781)
				(= bigPrime 0)
				(for ((= temp5 6)) (<= temp5 10) ((++ temp5))
					(if (self validMove: (- 25 temp5))
						(break)
					)
					(++ bigPrime)
				)
				(if bigPrime
					(otherPlayer endPrime: 19)
					(for ((= temp5 5)) temp5 ((-- temp5))
						(if (self validMove: (= temp4 (- 25 temp5)))
							(break)
						)
						(++ bigPrime)
						(otherPlayer endPrime: temp4)
					)
				)
				(otherPlayer bigPrime: bigPrime)
				(if (== skill 2)
					(= bigPrime 0)
					(for ((= temp5 6)) (<= temp5 10) ((++ temp5))
						(if (otherPlayer validMove: (- 25 temp5))
							(break)
						)
						(++ bigPrime)
						(= endPrime temp5)
					)
					(if bigPrime
						(for ((= temp5 5)) temp5 ((-- temp5))
							(if (self validMove: (- 25 temp5))
								(break)
							)
							(++ bigPrime)
						)
					)
					(if (< bigPrime 3)
						(= endPrime 0)
					)
					(if (< (otherPlayer bigPrime:) 3)
						(otherPlayer bigPrime: 0)
						(otherPlayer endPrime: 0)
					)
					(= local248 bigPrime)
				)
				(return
					(and
						(>= (otherPlayer bigPrime:) 6)
						(or
							(and
								(== (otherPlayer endPrime:) 24)
								(or (and (not global786) (bar size:)) aceyHits)
							)
							(and
								(==
									((= temp0
											(self
												at:
													(+
														(otherPlayer endPrime:)
														1
													)
											)
										)
										whose:
									)
									myColor
								)
								(==
									(temp0 size:)
									(- 15 (+ ((self at: 1) size:) (off size:)))
								)
							)
						)
					)
				)
			)
			(return 0)
		)
	)

	(method (winGame &tmp temp0 temp1 temp2 [temp3 29] temp32 temp33)
		(= temp32 (Str new:))
		(= temp2 (Str new:))
		(RedrawCast)
		(EnableCursor)
		(cond
			((or global773 ((otherPlayer off:) size:))
				(= temp0 1)
			)
			((or local239 (otherBar size:))
				(= temp0 3)
				(++ backgammons)
			)
			(else
				(= temp0 2)
				(++ gammons)
			)
		)
		(++ gamesWon)
		(= temp1 temp0)
		(*= temp0 (gTheDoubleCube value:))
		(+= totalPts temp0)
		(if (or (== gAttitudeSetting 2) (== gAttitudeSetting 3))
			(if (== type 1)
				(gChar1 say: 1000 2 64 0 (Random 1 2))
			else
				(= global920 1)
				(gChar1 say: 15 15 179 0 (Random 1 7))
			)
		)
		(gGamePlayScript cycles: 1)
	)

	(method (changePlayer)
		(= global800 otherPlayer)
		(gTheArrow cue:)
		(if (== (global800 type:) 0)
			(EnableCursor)
		)
		(RedrawCast)
	)
)

(instance setupButton of Feature
	(properties)

	(method (handleEvent event)
		(if (and global787 (<= 0 (event x:) 41) (<= 178 (event y:) 199))
			(event claimed: 1)
			(= global787 0)
			(= global788 1)
			(proc1303_1)
			(if (not global787)
				(gTheDiceList whoFirst:)
				(RedrawCast)
				((global800 otherPlayer:) readPoints: 0)
				(gCurRoom setScript: gGamePlayScript)
			)
			(return 1)
		)
		(return 0)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use PuzzleIcon)
(use ForwardCounter)
(use Window)
(use Motion)
(use Actor)
(use System)

(public
	genetics 0
)

(local
	[local0 10] = [1 1 23 45 67 135 157 179 201 201]
	[local10 10] = [49 22 22 22 22 22 22 22 22 49]
	local20 = {bBaAeEmMlL}
	local21
	local22
	local23
	local24
	[local25 10]
	[local35 10]
	local45
	local46
	[local47 4]
	[local51 4]
	[local55 35]
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16)
	(if (not gDifficulty)
		(return (localproc_4))
	)
	(= temp0 0)
	(= temp1 0)
	(= temp2 0)
	(for
		((= temp3 0))
		(or (== temp0 temp2) (== temp1 temp3))
		((= temp3 (genetics at: (= temp16 (Random 5 9)))))
		
		(= temp0 (genetics at: (= temp13 (Random 0 4))))
		(= temp1 (genetics at: (= temp14 (Random 5 9))))
		(= temp2 (genetics at: (= temp15 (Random 0 4))))
	)
	(= [local47 0] temp13)
	(= [local47 1] temp14)
	(= [local47 2] temp15)
	(= [local47 3] temp16)
	(= temp7 (temp0 value:))
	(= temp8 (temp1 value:))
	(= temp9 (temp2 value:))
	(= temp10 (temp3 value:))
	(= temp5 (& (= temp4 (Random 0 31)) temp7))
	(= temp6 (& (~ temp4) temp8))
	(= temp11 (| temp5 temp6))
	(= temp5 (& (= temp4 (Random 0 31)) temp9))
	(= temp6 (& (~ temp4) temp10))
	(= temp12 (| temp5 temp6))
	(= local23 temp11)
	(= local24 temp12)
	(return 1)
)

(procedure (localproc_1 param1 param2 param3 param4 &tmp temp0 [temp1 6])
	(for ((= temp0 0)) (< temp0 10) ((+= temp0 2))
		(StrAt @temp1 temp0 (StrAt local20 (+ temp0 (& param1 $0001))))
		(StrAt @temp1 (+ temp0 1) (StrAt local20 (+ temp0 (& param2 $0001))))
		(>>= param1 $0001)
		(>>= param2 $0001)
	)
	(StrAt @temp1 10 0)
	(DrawCel 304 8 3 param3 param4 -1)
	(Display @temp1 dsCOORD (+ param3 3) (+ param4 3) dsCOLOR 12 dsALIGN alLEFT dsFONT 999 &rest)
)

(procedure (localproc_2 param1 param2 param3 param4 param5 &tmp temp0)
	(= temp0 (| param4 param5))
	(DrawCel 304 11 param3 param1 param2 -1)
	(DrawCel
		305
		0
		[global201 (+ 0 (& temp0 $0001))]
		(+ param1 13)
		(+ param2 7)
		-1
	)
	(DrawCel
		305
		1
		[global201 (+ 2 (& (>>= temp0 $0001) $0001))]
		(+ param1 1)
		(+ param2 10)
		-1
	)
	(DrawCel
		305
		2
		[global201 (+ 4 (& (>>= temp0 $0001) $0001))]
		(+ param1 8)
		(+ param2 0)
		-1
	)
	(DrawCel
		305
		3
		[global201 (+ 6 (& (>>= temp0 $0001) $0001))]
		(+ param1 15)
		(+ param2 11)
		-1
	)
	(DrawCel
		305
		4
		[global201 (+ 8 (& (>>= temp0 $0001) $0001))]
		(+ param1 8)
		(+ param2 33)
		-1
	)
	(if (and (== param2 117) (== param1 89))
		(localproc_6 param4 param5 (- param1 5) (+ param2 55))
	else
		(localproc_1 param4 param5 (- param1 5) (+ param2 55))
	)
)

(procedure (localproc_3 param1 param2 param3 param4 param5)
	(if (> param4 2)
		(DrawCel 304 param3 2 param1 param2 -1)
	else
		(DrawCel 304 param3 param4 param1 param2 -1)
	)
	(DrawCel
		305
		5
		[global201 (+ 0 (& param5 $0001))]
		(+ param1 6)
		(+ param2 4)
		-1
	)
	(DrawCel
		305
		6
		[global201 (+ 2 (& (>>= param5 $0001) $0001))]
		(+ param1 1)
		(+ param2 5)
		-1
	)
	(DrawCel
		305
		7
		[global201 (+ 4 (& (>>= param5 $0001) $0001))]
		(+ param1 6)
		(+ param2 2)
		-1
	)
	(DrawCel
		305
		8
		[global201 (+ 6 (& (>>= param5 $0001) $0001))]
		(+ param1 7)
		(+ param2 4)
		-1
	)
	(DrawCel
		305
		9
		[global201 (+ 8 (& (>>= param5 $0001) $0001))]
		(+ param1 3)
		(+ param2 11)
		-1
	)
	(if (> param4 2)
		(DrawCel 304 param3 param4 param1 param2 -1)
	)
)

(procedure (localproc_4 &tmp temp0 temp1 temp2 [temp3 32] [temp35 32] [temp67 32])
	(for ((= temp0 0)) (< temp0 32) ((++ temp0))
		(= [temp3 temp0] 0)
	)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(for ((= temp1 5)) (< temp1 10) ((++ temp1))
			(++
				[temp3
					(= temp2
						(|
							((genetics at: temp0) value:)
							((genetics at: temp1) value:)
						)
					)
				]
			)
			(= [temp35 temp2] temp0)
			(= [temp67 temp2] temp1)
		)
	)
	(= temp0 0)
	(while (!= [temp3 temp0] 1)
		(if (== (++ temp0) 32)
			(return 0)
		)
	)
	(= [local47 0] [temp35 temp0])
	(= [local47 1] [temp67 temp0])
	(= local23 ((genetics at: [temp35 temp0]) value:))
	(= local24 ((genetics at: [temp67 temp0]) value:))
	(return 1)
)

(procedure (localproc_5 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 [temp15 32] [temp47 32] [temp79 10])
	(= temp3 (leftParent value:))
	(= temp4 (leftParent cursor:))
	(= temp5 (rightParent value:))
	(= temp6 (rightParent cursor:))
	(= temp8 0)
	(= temp9 -1)
	(= temp10 -1)
	(= temp12 0)
	(for ((= temp0 0)) (< temp0 32) ((++ temp0))
		(= [temp15 temp0] 0)
		(= [temp47 temp0] 0)
		(if (< temp0 10)
			(= [temp79 temp0] -1)
		)
	)
	(for ((= temp0 0)) (< temp0 32) ((++ temp0))
		(= [temp15 (| (& (~ temp0) temp3) (& temp4 temp0))] 1)
		(= [temp47 (| (& (~ temp0) temp5) (& temp6 temp0))] 1)
	)
	(for ((= temp0 0)) (< temp0 32) ((++ temp0))
		(if [temp15 temp0]
			(for ((= temp1 0)) (< temp1 32) ((++ temp1))
				(if [temp47 temp1]
					(= temp13 (^ local23 temp0))
					(= temp14 (^ local24 temp1))
					(= temp7 0)
					(for ((= temp2 0)) (< temp2 5) ((++ temp2))
						(= temp7
							(+
								(+= temp7 (& (>> temp13 temp2) $0001))
								(& (>> temp14 temp2) $0001)
							)
						)
					)
					(cond
						((not temp8)
							(= [temp79 0] temp7)
							(= [local25 0] temp0)
							(= [local35 0] temp1)
							(= temp9 temp7)
							(= temp10 0)
							(++ temp8)
							(if (not temp7)
								(= temp12 1)
							)
						)
						(temp7
							(cond
								((< temp8 10)
									(= [temp79 temp8] temp7)
									(= [local25 temp8] temp0)
									(= [local35 temp8] temp1)
									(gCSoundFX number: 247 setLoop: 0 play:)
									(child modifiers: temp8 show:)
									(if (> temp7 temp9)
										(= temp9 temp7)
										(= temp10 temp8)
									)
									(++ temp8)
								)
								((< temp7 temp9)
									(= [temp79 temp10] temp7)
									(= [local25 temp10] temp0)
									(= [local35 temp10] temp1)
									(gCSoundFX number: 247 setLoop: 0 play:)
									(child modifiers: temp10 show:)
									(= temp9 temp7)
									(for
										((= temp2 0))
										(< temp2 temp8)
										((++ temp2))
										
										(if (> [temp79 temp2] temp9)
											(= temp9 [temp79 temp2])
											(= temp10 temp2)
										)
									)
								)
							)
						)
						((not temp12)
							(= [temp79 temp10] temp7)
							(= [local25 temp10] temp0)
							(= [local35 temp10] temp1)
							(= temp12 1)
							(= temp9 temp7)
							(for ((= temp2 0)) (< temp2 temp8) ((++ temp2))
								(if (> [temp79 temp2] temp9)
									(= temp9 [temp79 temp2])
									(= temp10 temp2)
								)
							)
						)
					)
				)
			)
		)
	)
	(child modifiers: (* temp8 16))
	(child show:)
)

(procedure (localproc_6 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 60])
	(for ((= temp2 0)) (< temp2 60) ((++ temp2))
		(= [temp5 temp2] 0)
	)
	(= temp3 -1)
	(= temp0 local23)
	(= temp1 local24)
	(= temp4 0)
	(for ((= temp2 0)) (< temp2 10) ((+= temp2 2))
		(cond
			((== (& param1 $0001) (& temp0 $0001))
				(if temp4
					(StrAt @temp5 (++ temp3) 124)
					(StrAt @temp5 (++ temp3) 99)
					(StrAt @temp5 (++ temp3) 124)
					(= temp4 0)
				)
			)
			((not temp4)
				(StrAt @temp5 (++ temp3) 124)
				(StrAt @temp5 (++ temp3) 99)
				(StrAt @temp5 (++ temp3) 50)
				(StrAt @temp5 (++ temp3) 124)
				(= temp4 1)
			)
		)
		(StrAt @temp5 (++ temp3) (StrAt local20 (+ temp2 (& param1 $0001))))
		(cond
			((== (& param2 $0001) (& temp1 $0001))
				(if temp4
					(StrAt @temp5 (++ temp3) 124)
					(StrAt @temp5 (++ temp3) 99)
					(StrAt @temp5 (++ temp3) 124)
					(= temp4 0)
				)
			)
			((not temp4)
				(StrAt @temp5 (++ temp3) 124)
				(StrAt @temp5 (++ temp3) 99)
				(StrAt @temp5 (++ temp3) 50)
				(StrAt @temp5 (++ temp3) 124)
				(= temp4 1)
			)
		)
		(StrAt @temp5 (++ temp3) (StrAt local20 (+ temp2 (& param2 $0001))))
		(>>= param1 $0001)
		(>>= param2 $0001)
		(>>= temp0 $0001)
		(>>= temp1 $0001)
	)
	(if temp4
		(StrAt @temp5 (++ temp3) 124)
		(StrAt @temp5 (++ temp3) 99)
		(StrAt @temp5 (++ temp3) 124)
		(= temp4 0)
	)
	(StrAt @temp5 (++ temp3) 0)
	(DrawCel 304 8 3 param3 param4 -1)
	(Display @temp5 dsCOORD (+ param3 3) (+ param4 3) dsCOLOR 12 dsALIGN alLEFT dsFONT 999 &rest)
)

(procedure (localproc_7 param1 param2 param3 &tmp [temp0 20] temp20 temp21)
	(= temp20 (StrLen param1))
	(for ((= temp21 0)) (< temp21 temp20) ((++ temp21))
		(StrAt @temp0 temp21 (StrAt temp21 param1))
		(StrAt @temp0 (+ temp21 1) 0)
		(Wait 0)
		(Wait 4)
		(DrawCel 304 8 3 param2 param3 -1)
		(Display
			@temp0
			dsCOORD
			param2
			(+ param3 3)
			dsCOLOR
			44
			dsALIGN
			alRIGHT
			dsFONT
			999
			dsWIDTH
			54
			&rest
		)
	)
)

(procedure (localproc_8 param1 &tmp temp0 temp1)
	(= temp0 (/ (+ (param1 nsLeft:) (param1 nsRight:)) 2))
	(= temp1 (/ (+ (param1 nsTop:) (* 3 (param1 nsBottom:))) 4))
	(gGame setCursor: gTheCursor 1 temp0 temp1)
)

(instance geneticWin of SysWindow
	(properties
		left 65
		bottom 186
		right 289
		back 33
		priority -1
	)

	(method (open)
		(super open: &rest)
		(DrawCel 304 1 3 89 22 -1)
		(DrawCel 304 11 2 89 33 -1)
		(DrawCel 304 8 3 84 88 -1)
		(DrawCel 304 1 4 89 106 -1)
		(DrawCel 304 8 3 84 172 -1)
		(DrawCel 304 15 0 (+ (- (blPipe x:) 65) 1) (- (blPipe y:) 1) -1)
		(DrawCel 304 14 0 (+ (- (brPipe x:) 65) 1) (- (brPipe y:) 1) -1)
		(if gDifficulty
			(DrawCel 304 1 6 68 131 -1)
		else
			(DrawCel 304 13 0 (+ (- (tlPipe x:) 65) 1) (- (tlPipe y:) 1) -1)
			(DrawCel 304 12 0 (+ (- (trPipe x:) 65) 1) (- (trPipe y:) 1) -1)
		)
		(DrawCel 304 1 5 172 106 -1)
		(if (== gDifficulty 2) ; Expert
			(DrawCel 304 11 3 172 117 -1)
			(localproc_1 local23 local24 167 172)
		else
			(localproc_2 172 117 2 local23 local24)
		)
	)
)

(instance genetics of PuzzleBar
	(properties
		solvedFlag 19
		noun 14
		personalID 2
	)

	(method (init &tmp temp0 temp1 temp2)
		(= window geneticWin)
		(self puzzleCast: (Set new:))
		(if (not gDifficulty)
			((genetics puzzleCast:) add: tlPipe trPipe)
		else
			(= local45 (scanLine new:))
			((genetics puzzleCast:) add: local45 scanLine explode)
		)
		((genetics puzzleCast:) add: blPipe brPipe)
		(genetics showCast: 1)
		(for ((= temp2 0)) (not temp2) ((= temp2 (localproc_0)))
			(= local21 0)
			(= local22 0)
			(= local23 0)
			(= local24 0)
			(for ((= temp0 0)) (< temp0 32) ((++ temp0))
				(= [local55 temp0] 0)
				(if (< temp0 10)
					(= [local25 temp0] 0)
					(= [local35 temp0] 0)
				)
				(if (< temp0 4)
					(= [local51 temp0] -1)
				)
			)
			(if size
				(self eachElementDo: #dispose release:)
			)
			(for ((= temp0 0)) (< temp0 10) ((++ temp0))
				(while [local55 (= temp1 (Random 0 31))]
				)
				(= [local55 temp1] 1)
				(self
					add:
						((grandParents new:)
							nsLeft: [local0 temp0]
							nsTop: [local10 temp0]
							nsRight: (+ [local0 temp0] 23)
							nsBottom: (+ [local10 temp0] 28)
							value: temp1
							cursor: temp1
							modifiers: 0
							yourself:
						)
				)
			)
		)
		(self
			add:
				(leftParent
					value: 255
					cursor: 255
					modifiers: 255
					cel: 2
					yourself:
				)
				(rightParent
					value: 255
					cursor: 255
					modifiers: 255
					cel: 2
					yourself:
				)
				breedIcon
				recDomButton
		)
		(if gDifficulty
			(self add: upArrow downArrow)
		)
		(self add: (child cel: 2 value: 255 cursor: 255 modifiers: 0))
		(if gDifficulty
			(self add: matchIcon)
		)
		(super init: &rest)
	)

	(method (doit)
		(if gDifficulty
			(local45 hide:)
			(scanLine hide:)
			(explode hide:)
		)
		(super doit: &rest)
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
					(cond
						((== temp1 0)
							(++ temp1)
						)
						((< temp1 3)
							(= temp1 (- size 3))
						)
						((< temp1 7)
							(= temp1 (- size 2))
						)
						((< temp1 9)
							(= temp1 (- size 1))
						)
						((== temp1 9)
							(-- temp1)
						)
						((== temp1 10)
							(= temp1 3)
						)
						((== temp1 11)
							(= temp1 6)
						)
						((== temp1 12)
							(= temp1 0)
						)
						((== temp1 13)
							(-- temp1)
						)
						((== temp1 14)
							(if gDifficulty
								(= temp1 10)
							)
						)
						((== temp1 15)
							(if gDifficulty
								(-- temp1)
							else
								(= temp1 13)
							)
						)
						((== temp1 16)
							(if gDifficulty
								(= temp1 5)
							else
								(= temp1 10)
							)
						)
						((== temp1 17)
							(= temp1 11)
						)
						((== temp1 18)
							(= temp1 13)
						)
						((== temp1 19)
							(= temp1 16)
						)
						(else
							(= temp1 17)
						)
					)
				)
				(JOY_DOWN
					(cond
						((== temp1 0)
							(= temp1 12)
						)
						((== temp1 1)
							(-- temp1)
						)
						((== temp1 2)
							(= temp1 12)
						)
						((< temp1 5)
							(= temp1 10)
						)
						((< temp1 8)
							(= temp1 11)
						)
						((== temp1 8)
							(++ temp1)
						)
						((< temp1 11)
							(+= temp1 2)
						)
						((== temp1 11)
							(if (== gDifficulty 0) ; Novice
								(= temp1 6)
							else
								(= temp1 17)
							)
						)
						((== temp1 12)
							(++ temp1)
						)
						((== temp1 13)
							(= temp1 (- size 3))
						)
						((== temp1 14)
							(if gDifficulty
								(++ temp1)
							)
						)
						((== temp1 15)
							(if gDifficulty
								(++ temp1)
							else
								(= temp1 1)
							)
						)
						((== temp1 16)
							(if gDifficulty
								(= temp1 19)
							else
								(= temp1 4)
							)
						)
						((== temp1 17)
							(if gDifficulty
								(= temp1 20)
							else
								(= temp1 8)
							)
						)
						((== temp1 18)
							(= temp1 1)
						)
						((== temp1 19)
							(= temp1 4)
						)
						(else
							(= temp1 8)
						)
					)
				)
				(JOY_RIGHT
					(cond
						((== temp1 0)
							(= temp1 9)
						)
						((< temp1 8)
							(++ temp1)
						)
						((== temp1 8)
							(= temp1 1)
						)
						((== temp1 9)
							(= temp1 0)
						)
						((< temp1 12)
							(++ temp1)
						)
						((== temp1 12)
							(= temp1 10)
						)
						((== temp1 13)
							(if gDifficulty
								(++ temp1)
							)
						)
						((== temp1 14)
							(if gDifficulty
								(= temp1 16)
							)
						)
						((< temp1 17)
							(++ temp1)
						)
						((== temp1 17)
							(if gDifficulty
								(= temp1 13)
							else
								(= temp1 15)
							)
						)
						((< temp1 20)
							(++ temp1)
						)
						(else
							(= temp1 18)
						)
					)
				)
				(JOY_LEFT
					(cond
						((== temp1 0)
							(= temp1 9)
						)
						((== temp1 1)
							(= temp1 8)
						)
						((< temp1 9)
							(-- temp1)
						)
						((== temp1 9)
							(= temp1 0)
						)
						((== temp1 10)
							(= temp1 12)
						)
						((< temp1 13)
							(-- temp1)
						)
						((== temp1 13)
							(if gDifficulty
								(= temp1 17)
							)
						)
						((< temp1 16)
							(if gDifficulty
								(= temp1 12)
							else
								(= temp1 17)
							)
						)
						((== temp1 16)
							(if gDifficulty
								(= temp1 14)
							else
								(= temp1 15)
							)
						)
						((== temp1 17)
							(-- temp1)
						)
						((== temp1 18)
							(= temp1 20)
						)
						((== temp1 19)
							(= temp1 18)
						)
						(else
							(-- temp1)
						)
					)
				)
			)
			(= temp0 (self at: temp1))
			(localproc_8 temp0)
			(event type: evNULL)
		)
		(if (and puzzleStatus (& (event type:) $0105)) ; evJOYDOWN | evMOUSEKEYBOARD
			(event dispose:)
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)

	(method (solvePuzzle &tmp temp0)
		(= global188 (| (leftParent value:) (leftParent cursor:)))
		(= global189 (| (rightParent value:) (rightParent cursor:)))
		(if gDifficulty
			(= global200
				(|
					[local25 (= temp0 (mod (child modifiers:) 16))]
					[local35 temp0]
				)
			)
		else
			(= global200 (| (child value:) (child cursor:)))
		)
		(super solvePuzzle: &rest)
	)

	(method (buyClue &tmp temp0)
		(= temp0 0)
		(while (== [local47 temp0] [local51 temp0])
			(++ temp0)
			(if
				(or
					(and (not gDifficulty) (== temp0 2))
					(and gDifficulty (== temp0 4))
				)
				(return)
			)
		)
		(if (super buyClue:)
			(if gDifficulty
				(if (< temp0 2)
					(leftParent select:)
				else
					(rightParent select:)
				)
			)
			((genetics at: [local47 temp0]) select:)
		)
	)
)

(instance leftParent of CodeIcon
	(properties
		view 304
		loop 5
		nsLeft 53
		nsTop 67
		cursor 255
		modifiers 255
		value 255
	)

	(method (show param1 &tmp temp0)
		(if (== argc 1)
			(= cel param1)
		)
		(if (!= value 255)
			(localproc_3 nsLeft nsTop loop cel (| value cursor))
		else
			(super show: &rest)
		)
	)

	(method (highlight param1)
		(cond
			(param1
				(if (!= value 255)
					(localproc_2 89 33 2 value cursor)
				)
			)
			((== (rightParent cel:) 1)
				(rightParent highlight:)
			)
		)
		(if (!= cel 1)
			(super highlight: param1 &rest)
		)
	)

	(method (select)
		(rightParent cel: 2 show:)
		(if (== (child cel:) 1)
			(child cel: 2 show:)
		)
		(self cel: 1 show:)
	)
)

(instance rightParent of CodeIcon
	(properties
		view 304
		loop 6
		nsLeft 149
		nsTop 67
		cursor 255
		modifiers 255
		value 255
	)

	(method (show param1 &tmp temp0)
		(if (== argc 1)
			(= cel param1)
		)
		(if (!= value 255)
			(localproc_3 nsLeft nsTop loop cel (| value cursor))
		else
			(super show: &rest)
		)
	)

	(method (highlight param1)
		(cond
			(param1
				(if (!= value 255)
					(localproc_2 89 33 2 value cursor)
				)
			)
			((== (leftParent cel:) 1)
				(leftParent highlight:)
			)
		)
		(if (!= cel 1)
			(super highlight: param1 &rest)
		)
	)

	(method (select)
		(leftParent cel: 2 show:)
		(if (== (child cel:) 1)
			(child cel: 2 show:)
		)
		(self cel: 1 show:)
	)
)

(instance child of CodeIcon
	(properties
		view 304
		loop 11
		nsLeft 89
		nsTop 117
		cursor 255
		value 255
	)

	(method (show &tmp temp0 temp1)
		(= temp0 (mod modifiers 16))
		(cond
			(gDifficulty
				(if modifiers
					(localproc_2
						nsLeft
						nsTop
						cel
						[local25 temp0]
						[local35 temp0]
					)
					(StrAt @temp1 0 (+ 48 temp0))
					(StrAt @temp1 1 0)
					(Display @temp1 dsCOORD 128 119 dsCOLOR 12 dsALIGN alLEFT dsFONT 999 &rest)
				else
					(super show: &rest)
				)
			)
			((!= value 255)
				(localproc_2 nsLeft nsTop 2 value cursor)
			)
			(else
				(super show: &rest)
			)
		)
	)

	(method (highlight))

	(method (select)
		(if gDifficulty
			(if (== (rightParent cel:) 1)
				(rightParent cel: 2 show:)
			else
				(leftParent cel: 2 show:)
			)
			(self cel: 1 show:)
		)
	)
)

(instance upArrow of CodeIcon
	(properties
		view 304
		loop 2
		nsLeft 70
		nsTop 133
	)

	(method (select &tmp temp0 temp1)
		(super select: &rest)
		(= temp0 (/ (child modifiers:) 16))
		(= temp1 (mod (child modifiers:) 16))
		(if (!= temp0 0)
			(if (== (++ temp1) temp0)
				(= temp1 0)
			)
			(child modifiers: (+ (* temp0 16) temp1) show:)
		)
	)
)

(instance downArrow of CodeIcon
	(properties
		view 304
		loop 3
		nsLeft 70
		nsTop 145
	)

	(method (select &tmp temp0 temp1)
		(super select: &rest)
		(= temp0 (/ (child modifiers:) 16))
		(= temp1 (mod (child modifiers:) 16))
		(if (!= temp0 0)
			(if (< (-- temp1) 0)
				(= temp1 (- temp0 1))
			)
			(child modifiers: (+ (* temp0 16) temp1) show:)
		)
	)
)

(instance grandParents of CodeIcon
	(properties
		view 304
		loop 4
		cursor 0
		signal 161
	)

	(method (show param1 &tmp temp0)
		(if (== argc 1)
			(= cel param1)
		)
		(localproc_3 nsLeft nsTop loop cel (| value cursor))
	)

	(method (highlight param1)
		(cond
			(param1
				(localproc_2 89 33 2 value cursor)
			)
			((== (leftParent cel:) 1)
				(leftParent highlight:)
			)
			(else
				(rightParent highlight:)
			)
		)
		(if (and (!= cel 1) (< cel 3))
			(super highlight: param1 &rest)
		)
	)

	(method (select &tmp temp0 temp1 temp2)
		(gCSoundFX number: 144 setLoop: 0 play:)
		(if (< (genetics indexOf: self) 5)
			(= temp0 local21)
			(= temp1 tlPipe)
			(= temp2 leftParent)
			(= local21 self)
			(cond
				((not gDifficulty)
					(= [local51 0] (genetics indexOf: self))
				)
				((== (leftParent cel:) 1)
					(= [local51 0] (genetics indexOf: self))
				)
				(else
					(= [local51 2] (genetics indexOf: self))
				)
			)
		else
			(= temp0 local22)
			(= temp1 trPipe)
			(= temp2 rightParent)
			(= local22 self)
			(cond
				((not gDifficulty)
					(= [local51 1] (genetics indexOf: self))
				)
				((== (leftParent cel:) 1)
					(= [local51 1] (genetics indexOf: self))
				)
				(else
					(= [local51 3] (genetics indexOf: self))
				)
			)
		)
		(if temp0
			(temp0 cel: (+ 2 (temp0 modifiers:)) show:)
		)
		(if (not gDifficulty)
			(gCSoundFX number: 150 loop: 1 play:)
			(temp1 show: cel: 0 setCycle: CT 0 1)
			(while (temp1 cycler:)
				(= gGameTime (GetTime))
				(genetics animateOnce:)
			)
			(temp2 value: value cursor: cursor show: select:)
		)
		(self cel: 1 show:)
		(if (and (!= (leftParent cel:) 1) (!= (rightParent cel:) 1))
			(child cel: 2 show:)
			(leftParent select:)
		)
	)
)

(instance matchIcon of CodeIcon
	(properties
		view 304
		loop 0
		nsLeft 144
		nsTop 131
		downClick 0
		upClick 0
		upClickOff 0
	)

	(method (select &tmp temp0)
		(super select: &rest)
		(if
			(and
				(== [local25 (= temp0 (mod (child modifiers:) 16))] local23)
				(== [local35 temp0] local24)
			)
			(genetics setScript: solveSound)
		else
			(gCSoundFX number: 136 setLoop: 0 play:)
		)
	)
)

(instance breedIcon of CodeIcon
	(properties
		view 304
		loop 1
		nsLeft 4
		nsTop 80
	)

	(method (select &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(super select: &rest)
		(if gDifficulty
			(if (!= (child cel:) 1)
				(if (or (== local21 0) (== local22 0))
					(gCSoundFX number: 135 setLoop: 0 play:)
					(gMessager say: 57 41 12 1) ; "ERROR: Nothing to breed."
					(return)
				)
				(= temp0 (local21 value:))
				(= temp1 (local22 value:))
				(if (== (rightParent cel:) 1)
					(= temp7 rightParent)
					(= temp6 1)
					(= temp4 (/ (leftParent modifiers:) 16))
					(= temp5 (mod (leftParent modifiers:) 16))
				else
					(= temp7 leftParent)
					(= temp6 0)
					(= temp4 (/ (rightParent modifiers:) 16))
					(= temp5 (mod (rightParent modifiers:) 16))
				)
				(= temp2 (genetics indexOf: local21))
				(= temp3 (genetics indexOf: local22))
				(if (or (== temp2 temp4) (== temp3 temp5))
					(if (== temp2 temp4)
						((genetics at: temp4)
							cel: (+ 2 ((genetics at: temp4) modifiers:))
							show:
						)
						(= local21 0)
					)
					(if (== temp3 temp5)
						((genetics at: temp5)
							cel: (+ 2 ((genetics at: temp4) modifiers:))
							show:
						)
						(= local22 0)
					)
					(gCSoundFX number: 135 setLoop: 0 play:)
					(gMessager say: 57 41 11 1) ; "ERROR: One of the cyborgs you have chosen is already in use by the other parent."
					(return)
				)
				(if (!= (temp7 modifiers:) 255)
					((genetics at: (/ (temp7 modifiers:) 16))
						cel: 2
						modifiers: 0
						show:
					)
					((genetics at: (mod (temp7 modifiers:) 16))
						cel: 2
						modifiers: 0
						show:
					)
				)
				(genetics setScript: fgBreed 0 temp6)
			else
				(if
					(or
						(== (leftParent value:) 255)
						(== (rightParent value:) 255)
					)
					(gCSoundFX number: 135 setLoop: 0 play:)
					(gMessager say: 57 41 11 1) ; "ERROR: One of the cyborgs you have chosen is already in use by the other parent."
					(return)
				)
				(genetics setScript: childBreed)
			)
		else
			(if (or (== local21 0) (== local22 0))
				(gCSoundFX number: 135 setLoop: 0 play:)
				(gMessager say: 57 41 12 1) ; "ERROR: Nothing to breed."
				(return)
			)
			(= temp0 (local21 value:))
			(= temp1 (local22 value:))
			(gCSoundFX number: 194 setLoop: 0 play:)
			(blPipe show: cel: 0 setCycle: CT 0 1)
			(brPipe show: cel: 0 setCycle: CT 0 1)
			(Wait 0)
			(Wait 1)
			(while (brPipe cycler:)
				(= gGameTime (GetTime))
				(genetics animateOnce:)
			)
			(child value: temp0 cursor: temp1 show:)
			(if (and (== temp0 local23) (== temp1 local24))
				(genetics setScript: solveSound)
			)
		)
	)
)

(instance scanLine of Prop
	(properties
		view 304
		loop 7
		priority 15
		signal 16
		cycleSpeed 2
	)
)

(instance explode of Prop
	(properties
		view 304
		loop 10
		priority 15
		signal 16
	)
)

(instance fgBreed of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(genetics pHandsOff: 1)
				(gCSoundFX number: 195 setLoop: 0 play:)
				(if register
					(= local46 rightParent)
				else
					(= local46 leftParent)
				)
				(local45
					show:
					x: (- (+ (local22 nsLeft:) 65) 1)
					y: (+ (local22 nsTop:) 1)
					cel: 0
					setCycle: ForwardCounter 4
				)
				(scanLine
					show:
					x: (- (+ (local21 nsLeft:) 65) 1)
					y: (+ (local21 nsTop:) 1)
					cel: 0
					setCycle: ForwardCounter 4 self
				)
			)
			(1
				(local45 hide:)
				(scanLine hide:)
				(explode
					show:
					x: (- (+ (local46 nsLeft:) 65) 1)
					y: (+ (local46 nsTop:) 1)
					cel: 0
					setCycle: End self
				)
			)
			(2
				(explode hide:)
				(= temp0 (local21 value:))
				(= temp1 (local22 value:))
				(= temp2 (genetics indexOf: local21))
				(= temp3 (genetics indexOf: local22))
				(local46
					value: temp0
					cursor: temp1
					modifiers: (+ (* temp2 16) temp3)
					cel: 2
					show:
					highlight:
				)
				(if register
					(child select:)
				else
					(rightParent select:)
				)
				(local21 cel: (+ 3 register) modifiers: (+ 1 register) show:)
				(= local21 0)
				(local22 cel: (+ 3 register) modifiers: (+ 1 register) show:)
				(= local22 0)
				(genetics pHandsOff: 0)
				(self dispose:)
			)
		)
	)
)

(instance childBreed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(genetics pHandsOff: 1)
				(gCSoundFX number: 194 setLoop: 0 play: self)
				(localproc_7 {GENERATING..} 84 172)
				(blPipe show: cel: 0 setCycle: CT 0 1)
				(brPipe show: cel: 0 setCycle: CT 0 1)
			)
			(1
				(localproc_5)
				(genetics pHandsOff: 0)
				(self dispose:)
			)
		)
	)
)

(instance recDomButton of CodeIcon
	(properties
		view 304
		loop 9
		nsLeft 1
		nsTop 102
		value 1
	)

	(method (show)
		(localproc_2 5 117 2 (* 31 value) (* 31 value))
		(super show: &rest)
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 0 nsLeft nsTop -1)
		else
			(DrawCel view loop 2 nsLeft nsTop -1)
		)
	)

	(method (select)
		(super select: &rest)
		(^= value $0001)
		(= loop (+ 8 value))
		(self show:)
	)
)

(instance tlPipe of Prop
	(properties
		x 125
		y 58
		view 304
		loop 13
		priority 15
		signal 16
	)
)

(instance trPipe of Prop
	(properties
		x 200
		y 58
		view 304
		loop 12
		priority 15
		signal 16
	)
)

(instance blPipe of Prop
	(properties
		x 125
		y 96
		view 304
		loop 15
		priority 15
		signal 16
	)
)

(instance brPipe of Prop
	(properties
		x 200
		y 96
		view 304
		loop 14
		priority 15
		signal 16
	)
)

(instance solveSound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(genetics pHandsOff: 1)
				(if (!= (gCSoundFX prevSignal:) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(1
				(gCSoundFX number: 106 setLoop: 1 play: 127 self)
			)
			(2
				(genetics pHandsOff: 0)
				(genetics solvePuzzle:)
				(self dispose:)
			)
		)
	)
)


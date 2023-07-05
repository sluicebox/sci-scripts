;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 501)
(include sci.sh)
(use Main)
(use yacht)

(public
	onesScore 0
	twosScore 1
	threesScore 2
	foursScore 3
	fivesScore 4
	sixesScore 5
	fourOfAKindScore 6
	fullHouseScore 7
	smStraightScore 8
	lgStraightScore 9
	yahtzeeScore 10
	chanceScore 11
)

(procedure (localproc_0 &tmp temp0)
	(= temp0 0)
	(= global506 0)
	(if
		(and
			((global178 at: 1) tempScore:)
			((global178 at: 2) tempScore:)
			((global178 at: 3) tempScore:)
		)
		(= global506 2)
		(= temp0 (DiceList diceTotal:))
	)
	(if
		(and
			((global178 at: 2) tempScore:)
			((global178 at: 3) tempScore:)
			((global178 at: 4) tempScore:)
		)
		(= global506 3)
		(= temp0 (DiceList diceTotal:))
	)
	(return temp0)
)

(procedure (localproc_1 &tmp temp0)
	(= temp0 0)
	(= global506 0)
	(if (and ((global178 at: 0) tempScore:) ((global178 at: 4) tempScore:))
		(if
			(and
				((global178 at: 1) tempScore:)
				((global178 at: 2) tempScore:)
				(not ((global178 at: 3) tempScore:))
			)
			(= global506 45)
		)
		(if
			(and
				((global178 at: 1) tempScore:)
				((global178 at: 3) tempScore:)
				(not ((global178 at: 2) tempScore:))
			)
			(= global506 35)
		)
		(if
			(and
				((global178 at: 2) tempScore:)
				((global178 at: 3) tempScore:)
				(not ((global178 at: 1) tempScore:))
			)
			(= global506 25)
		)
	)
	(if (and ((global178 at: 1) tempScore:) ((global178 at: 5) tempScore:))
		(if
			(and
				((global178 at: 3) tempScore:)
				((global178 at: 2) tempScore:)
				(not ((global178 at: 4) tempScore:))
			)
			(= global506 56)
		)
		(if
			(and
				((global178 at: 2) tempScore:)
				((global178 at: 4) tempScore:)
				(not ((global178 at: 3) tempScore:))
			)
			(= global506 46)
		)
		(if
			(and
				((global178 at: 4) tempScore:)
				((global178 at: 3) tempScore:)
				(not ((global178 at: 2) tempScore:))
			)
			(= global506 36)
		)
	)
	(if (> global506 0)
		(= temp0 (DiceList diceTotal:))
	)
	(return temp0)
)

(procedure (localproc_2 &tmp temp0)
	(= temp0 0)
	(if (== ((global178 at: 8) retValue:) 2)
		(= temp0 2)
	)
	(return temp0)
)

(procedure (localproc_3 &tmp temp0)
	(= temp0 0)
	(= global506 0)
	(if
		(and
			(== global501 global502 global503)
			(!= global503 global504)
			(!= global503 global505)
		)
		(= global506 1)
	)
	(if
		(and
			(== global502 global503 global504)
			(!= global501 global502)
			(!= global504 global505)
		)
		(= global506 2)
	)
	(if
		(and
			(== global503 global504 global505)
			(!= global501 global503)
			(!= global502 global503)
		)
		(= global506 3)
	)
	(if (> global506 0)
		(= temp0 global503)
		(-= global506 1)
	)
	(return temp0)
)

(procedure (localproc_4 &tmp temp0)
	(= temp0 0)
	(= global506 0)
	(if
		(or
			(and
				(== global501 global502)
				(== global503 global504)
				(!= global502 global503)
				(!= global504 global505)
			)
			(and
				(== global501 global502)
				(== global504 global505)
				(!= global502 global503)
				(!= global503 global504)
			)
			(and
				(== global502 global503)
				(== global504 global505)
				(!= global501 global502)
				(!= global503 global504)
			)
		)
		(= temp0 global504)
		(= global506 global502)
	)
	(return temp0)
)

(procedure (localproc_5 &tmp temp0 temp1)
	(= temp0 0)
	(= global506 0)
	(if
		(and
			(== global501 global502)
			(!= global502 global503)
			(!= global502 global504)
			(!= global502 global505)
		)
		(= temp0 global501)
		(= temp1 1)
	)
	(if
		(and
			(== global502 global503)
			(!= global501 global502)
			(!= global503 global504)
			(!= global503 global505)
		)
		(= temp0 global502)
		(= temp1 2)
	)
	(if
		(and
			(== global503 global504)
			(!= global501 global503)
			(!= global502 global503)
			(!= global504 global505)
		)
		(= temp0 global503)
		(= temp1 3)
	)
	(if
		(and
			(== global504 global505)
			(!= global501 global504)
			(!= global502 global504)
			(!= global503 global504)
		)
		(= temp0 global504)
		(= temp1 4)
	)
	(if (> temp0 0)
		(= global506 (- temp1 1))
	)
	(return temp0)
)

(procedure (localproc_6 param1 &tmp temp0 temp1)
	(= temp1 0)
	(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
		(if
			(and
				(== param1 (+ temp0 1))
				(== ((global178 at: temp0) finalScore:) -1)
			)
			(= temp1 1)
		)
	)
	(return temp1)
)

(procedure (localproc_7 &tmp temp0 temp1)
	(= temp1 0)
	(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
		(if
			(and
				(> ((global178 at: temp0) tempScore:) 0)
				(== ((global178 at: temp0) finalScore:) -1)
				(> ((global178 at: temp0) tempScore:) temp1)
			)
			(= temp1 ((global178 at: temp0) finalScore:))
		)
	)
	(return temp1)
)

(procedure (localproc_8 &tmp temp0 temp1)
	(= temp1 0)
	(for ((= temp0 6)) (<= temp0 10) ((++ temp0))
		(if
			(and
				(> ((global178 at: temp0) tempScore:) 0)
				(== ((global178 at: temp0) finalScore:) -1)
			)
			(++ temp1)
		)
	)
	(return temp1)
)

(instance onesScore of Score
	(properties
		y 36
		loop 1
		pipNumber 1
	)

	(method (calc)
		(= tempScore (= retValue 0))
		(= tempScore (DiceList scoreTheUpperNum: gOnesScore 1))
		(= retValue 1)
		(return retValue)
	)

	(method (eval)
		(if (== finalScore -1)
			(= wtfactor 0)
			(if (or (== (global178 skill:) 0) (== (global178 skill:) 1))
				(switch tempScore
					(0
						(= wtfactor 6)
					)
					(1
						(= wtfactor 10)
					)
					(2
						(= wtfactor 20)
					)
					(3
						(= wtfactor 30)
					)
					(4
						(= wtfactor 35)
					)
					(5
						(= wtfactor 40)
					)
				)
			)
			(if (== (global178 skill:) 2)
				(if (== (global178 rollsLeft:) 0)
					(switch tempScore
						(0
							(= wtfactor 12)
						)
						(1
							(= wtfactor 16)
						)
						(2
							(= wtfactor 26)
						)
						(3
							(= wtfactor 30)
						)
						(4
							(= wtfactor 35)
						)
						(5
							(= wtfactor 40)
						)
					)
				)
				(if (== (global178 rollsLeft:) 1)
					(switch tempScore
						(0
							(= wtfactor 12)
						)
						(1
							(= wtfactor 16)
						)
						(2
							(= wtfactor 26)
						)
						(3
							(= wtfactor 30)
						)
						(4
							(= wtfactor 35)
						)
						(5
							(= wtfactor 40)
						)
					)
				)
				(if (== (global178 rollsLeft:) 2)
					(switch tempScore
						(0
							(= wtfactor 12)
						)
						(1
							(= wtfactor 16)
						)
						(2
							(= wtfactor 21)
						)
						(3
							(= wtfactor 30)
						)
						(4
							(= wtfactor 35)
						)
						(5
							(= wtfactor 40)
						)
					)
				)
			)
			(return wtfactor)
		)
	)
)

(instance twosScore of Score
	(properties
		y 47
		loop 2
		pipNumber 2
	)

	(method (calc)
		(= tempScore (= retValue 0))
		(= tempScore (DiceList scoreTheUpperNum: gTwosScore 2))
		(= retValue 2)
		(return retValue)
	)

	(method (eval)
		(if (== finalScore -1)
			(= wtfactor 0)
			(if (or (== (global178 skill:) 0) (== (global178 skill:) 1))
				(switch tempScore
					(0
						(= wtfactor 5)
					)
					(2
						(= wtfactor 11)
					)
					(4
						(= wtfactor 21)
					)
					(6
						(= wtfactor 30)
					)
					(8
						(= wtfactor 35)
					)
					(10
						(= wtfactor 40)
					)
				)
			)
			(if (== (global178 skill:) 2)
				(if (== (global178 rollsLeft:) 0)
					(switch tempScore
						(0
							(= wtfactor 9)
						)
						(2
							(= wtfactor 15)
						)
						(4
							(= wtfactor 25)
						)
						(6
							(= wtfactor 30)
						)
						(8
							(= wtfactor 35)
						)
						(10
							(= wtfactor 40)
						)
					)
				)
				(if (== (global178 rollsLeft:) 1)
					(switch tempScore
						(0
							(= wtfactor 9)
						)
						(2
							(= wtfactor 15)
						)
						(4
							(= wtfactor 25)
						)
						(6
							(= wtfactor 30)
						)
						(8
							(= wtfactor 35)
						)
						(10
							(= wtfactor 40)
						)
					)
				)
				(if (== (global178 rollsLeft:) 2)
					(switch tempScore
						(0
							(= wtfactor 9)
						)
						(2
							(= wtfactor 15)
						)
						(4
							(= wtfactor 22)
						)
						(6
							(= wtfactor 30)
						)
						(8
							(= wtfactor 35)
						)
						(10
							(= wtfactor 40)
						)
					)
				)
			)
			(return wtfactor)
		)
	)
)

(instance threesScore of Score
	(properties
		y 58
		loop 3
		pipNumber 3
	)

	(method (calc)
		(= tempScore (= retValue 0))
		(= tempScore (DiceList scoreTheUpperNum: gThreesScore 3))
		(= retValue 3)
		(return retValue)
	)

	(method (eval)
		(if (== finalScore -1)
			(= wtfactor 0)
			(if (or (== (global178 skill:) 0) (== (global178 skill:) 1))
				(switch tempScore
					(0
						(= wtfactor 4)
					)
					(3
						(= wtfactor 12)
					)
					(6
						(= wtfactor 22)
					)
					(9
						(= wtfactor 30)
					)
					(12
						(= wtfactor 35)
					)
					(15
						(= wtfactor 40)
					)
				)
			)
			(if (== (global178 skill:) 2)
				(if (== (global178 rollsLeft:) 0)
					(switch tempScore
						(0
							(= wtfactor 8)
						)
						(3
							(= wtfactor 14)
						)
						(6
							(= wtfactor 24)
						)
						(9
							(= wtfactor 30)
						)
						(12
							(= wtfactor 35)
						)
						(15
							(= wtfactor 40)
						)
					)
				)
				(if (== (global178 rollsLeft:) 1)
					(switch tempScore
						(0
							(= wtfactor 8)
						)
						(3
							(= wtfactor 14)
						)
						(6
							(= wtfactor 24)
						)
						(9
							(= wtfactor 30)
						)
						(12
							(= wtfactor 35)
						)
						(15
							(= wtfactor 40)
						)
					)
				)
				(if (== (global178 rollsLeft:) 2)
					(switch tempScore
						(0
							(= wtfactor 8)
						)
						(3
							(= wtfactor 14)
						)
						(6
							(= wtfactor 23)
						)
						(9
							(= wtfactor 30)
						)
						(12
							(= wtfactor 35)
						)
						(15
							(= wtfactor 40)
						)
					)
				)
			)
			(return wtfactor)
		)
	)
)

(instance foursScore of Score
	(properties
		y 69
		loop 4
		pipNumber 4
	)

	(method (calc)
		(= tempScore (= retValue 0))
		(= tempScore (DiceList scoreTheUpperNum: gFoursScore 4))
		(= retValue 4)
		(return retValue)
	)

	(method (eval)
		(if (== finalScore -1)
			(= wtfactor 0)
			(if (or (== (global178 skill:) 0) (== (global178 skill:) 1))
				(switch tempScore
					(0
						(= wtfactor 3)
					)
					(4
						(= wtfactor 13)
					)
					(8
						(= wtfactor 23)
					)
					(12
						(= wtfactor 30)
					)
					(16
						(= wtfactor 35)
					)
					(20
						(= wtfactor 40)
					)
				)
			)
			(if (== (global178 skill:) 2)
				(if (== (global178 rollsLeft:) 0)
					(switch tempScore
						(0
							(= wtfactor 7)
						)
						(4
							(= wtfactor 13)
						)
						(8
							(= wtfactor 23)
						)
						(12
							(= wtfactor 30)
						)
						(16
							(= wtfactor 35)
						)
						(20
							(= wtfactor 40)
						)
					)
				)
				(if (== (global178 rollsLeft:) 1)
					(switch tempScore
						(0
							(= wtfactor 7)
						)
						(4
							(= wtfactor 13)
						)
						(8
							(= wtfactor 23)
						)
						(12
							(= wtfactor 30)
						)
						(16
							(= wtfactor 35)
						)
						(20
							(= wtfactor 40)
						)
					)
				)
				(if (== (global178 rollsLeft:) 2)
					(switch tempScore
						(0
							(= wtfactor 7)
						)
						(4
							(= wtfactor 13)
						)
						(8
							(= wtfactor 24)
						)
						(12
							(= wtfactor 30)
						)
						(16
							(= wtfactor 35)
						)
						(20
							(= wtfactor 40)
						)
					)
				)
			)
			(return wtfactor)
		)
	)
)

(instance fivesScore of Score
	(properties
		y 80
		loop 5
		pipNumber 5
	)

	(method (calc)
		(= tempScore (= retValue 0))
		(= tempScore (DiceList scoreTheUpperNum: gFivesScore 5))
		(= retValue 5)
		(return retValue)
	)

	(method (eval)
		(if (== finalScore -1)
			(= wtfactor 0)
			(if (or (== (global178 skill:) 0) (== (global178 skill:) 1))
				(switch tempScore
					(0
						(= wtfactor 2)
					)
					(5
						(= wtfactor 14)
					)
					(10
						(= wtfactor 24)
					)
					(15
						(= wtfactor 30)
					)
					(20
						(= wtfactor 35)
					)
					(25
						(= wtfactor 40)
					)
				)
			)
			(if (== (global178 skill:) 2)
				(if (== (global178 rollsLeft:) 0)
					(switch tempScore
						(0
							(= wtfactor 6)
						)
						(5
							(= wtfactor 12)
						)
						(10
							(= wtfactor 22)
						)
						(15
							(= wtfactor 30)
						)
						(20
							(= wtfactor 35)
						)
						(25
							(= wtfactor 40)
						)
					)
				)
				(if (== (global178 rollsLeft:) 1)
					(switch tempScore
						(0
							(= wtfactor 6)
						)
						(5
							(= wtfactor 12)
						)
						(10
							(= wtfactor 22)
						)
						(15
							(= wtfactor 30)
						)
						(20
							(= wtfactor 35)
						)
						(25
							(= wtfactor 40)
						)
					)
				)
				(if (== (global178 rollsLeft:) 2)
					(switch tempScore
						(0
							(= wtfactor 6)
						)
						(5
							(= wtfactor 12)
						)
						(10
							(= wtfactor 25)
						)
						(15
							(= wtfactor 30)
						)
						(20
							(= wtfactor 35)
						)
						(25
							(= wtfactor 40)
						)
					)
				)
			)
			(return wtfactor)
		)
	)
)

(instance sixesScore of Score
	(properties
		y 91
		loop 6
		pipNumber 6
	)

	(method (calc)
		(= tempScore (= retValue 0))
		(= tempScore (DiceList scoreTheUpperNum: gSixesScore 6))
		(= retValue 6)
		(return retValue)
	)

	(method (eval)
		(if (== finalScore -1)
			(= wtfactor 0)
			(if (or (== (global178 skill:) 0) (== (global178 skill:) 1))
				(switch tempScore
					(0
						(= wtfactor 1)
					)
					(6
						(= wtfactor 15)
					)
					(12
						(= wtfactor 25)
					)
					(18
						(= wtfactor 30)
					)
					(24
						(= wtfactor 35)
					)
					(30
						(= wtfactor 40)
					)
				)
			)
			(if (== (global178 skill:) 2)
				(if (== (global178 rollsLeft:) 0)
					(switch tempScore
						(0
							(= wtfactor 5)
						)
						(6
							(= wtfactor 11)
						)
						(12
							(= wtfactor 21)
						)
						(18
							(= wtfactor 30)
						)
						(24
							(= wtfactor 35)
						)
						(30
							(= wtfactor 40)
						)
					)
				)
				(if (== (global178 rollsLeft:) 1)
					(switch tempScore
						(0
							(= wtfactor 5)
						)
						(6
							(= wtfactor 11)
						)
						(12
							(= wtfactor 21)
						)
						(18
							(= wtfactor 30)
						)
						(24
							(= wtfactor 35)
						)
						(30
							(= wtfactor 40)
						)
					)
				)
				(if (== (global178 rollsLeft:) 2)
					(switch tempScore
						(0
							(= wtfactor 5)
						)
						(6
							(= wtfactor 11)
						)
						(12
							(= wtfactor 26)
						)
						(18
							(= wtfactor 30)
						)
						(24
							(= wtfactor 35)
						)
						(30
							(= wtfactor 40)
						)
					)
				)
			)
			(return wtfactor)
		)
	)
)

(instance fourOfAKindScore of Score
	(properties
		y 102
		loop 7
	)

	(method (calc)
		(= tempScore (= retValue 0))
		(if
			(or
				(== global501 global502 global503 global504)
				(== global502 global503 global504 global505)
			)
			(= retValue global502)
			(= tempScore (DiceList diceTotal:))
		)
		(return retValue)
	)

	(method (eval &tmp temp0 temp1 temp2)
		(if (== finalScore -1)
			(= wtfactor 0)
			(if (== (global178 skill:) 0)
				(if (== (global178 rollsLeft:) 0)
					(if tempScore
						(= wtfactor 50)
					else
						(= wtfactor 3)
					)
				)
				(if
					(or
						(== (global178 rollsLeft:) 1)
						(== (global178 rollsLeft:) 2)
					)
					(if (not (or (localproc_5) (localproc_4)))
						(= wtfactor 2)
						(= keepers 0)
					)
					(if (localproc_5)
						(= wtfactor 16)
						(self setKeepers: global506 (+ global506 1))
					)
					(if (localproc_4)
						(= wtfactor 16)
						(= temp0 (localproc_4))
						(= temp0 (DiceList whichHas: temp0))
						(self setKeepers: temp0 (+ temp0 1))
					)
					(if (localproc_3)
						(= wtfactor 32)
						(self
							setKeepers:
								global506
								(+ global506 1)
								(+ global506 2)
						)
					)
					(if tempScore
						(= wtfactor 50)
						(self setKeepers: 0 1 2 3 4)
					)
					(if ((global178 at: 10) retValue:)
						(= wtfactor 50)
						(self setKeepers: 0 1 2 3)
					)
				)
			)
			(if (== (global178 skill:) 1)
				(if (== (global178 rollsLeft:) 0)
					(if tempScore
						(= wtfactor 50)
					else
						(= wtfactor 3)
					)
				)
				(if
					(or
						(== (global178 rollsLeft:) 1)
						(== (global178 rollsLeft:) 2)
					)
					(if (not (or (localproc_5) (localproc_4)))
						(= wtfactor 2)
						(= keepers 0)
					)
					(if (localproc_5)
						(= wtfactor 16)
						(self setKeepers: global506 (+ global506 1))
					)
					(if (localproc_4)
						(= wtfactor 16)
						(= temp0 (localproc_4))
						(= temp0 (DiceList whichHas: temp0))
						(self setKeepers: temp0 (+ temp0 1))
					)
					(if (localproc_3)
						(= wtfactor 32)
						(self
							setKeepers:
								global506
								(+ global506 1)
								(+ global506 2)
						)
					)
					(if tempScore
						(= wtfactor 50)
						(self setKeepers: 0 1 2 3 4)
					)
					(if ((global178 at: 10) retValue:)
						(= temp0 ((global178 at: 10) retValue:))
						(if (== ((global178 at: 10) finalScore:) 50)
							(cond
								((>= temp0 4)
									(= wtfactor 50)
									(self setKeepers: 0 1 2 3 4)
								)
								(
									(and
										(localproc_6 temp0)
										(not (global178 lateInGame:))
									)
									(= wtfactor 30)
									(self setKeepers: 0 1 2 3 4)
								)
								(else
									(if
										(or
											(== (global178 rollsLeft:) 1)
											(== (global178 rollsLeft:) 2)
										)
										(self setKeepers: 0 1 2 3)
									else
										(self setKeepers: 0 1 2 3 4)
									)
									(= wtfactor 50)
								)
							)
						)
					)
				)
			)
			(if (== (global178 skill:) 2)
				(if (== (global178 rollsLeft:) 0)
					(if tempScore
						(cond
							((>= tempScore 14)
								(= wtfactor 50)
							)
							((global178 lateInGame:)
								(= wtfactor 50)
							)
							(else
								(= wtfactor 5)
							)
						)
						(= temp0 (DiceList whichHas: retValue))
					else
						(= wtfactor 8)
					)
				)
				(if
					(or
						(== (global178 rollsLeft:) 1)
						(== (global178 rollsLeft:) 2)
					)
					(if (not (or (localproc_5) (localproc_4)))
						(= wtfactor 1)
						(= keepers 0)
					)
					(if (localproc_5)
						(= temp0 (localproc_5))
						(if (and (localproc_6 temp0) (>= temp0 4))
							(= wtfactor 20)
						else
							(= wtfactor 5)
						)
						(self setKeepers: global506 (+ global506 1))
					)
					(if (localproc_4)
						(= temp1 (localproc_4))
						(= temp2 global506)
						(cond
							((>= temp1 4)
								(if (localproc_6 temp1)
									(= wtfactor 28)
								else
									(= wtfactor 5)
								)
								(= temp0 (DiceList whichHas: temp1))
								(self setKeepers: temp0 (+ temp0 1))
							)
							((localproc_6 temp2)
								(= wtfactor 20)
								(= temp0 (DiceList whichHas: temp2))
								(self setKeepers: temp0 (+ temp0 1))
							)
							(else
								(= wtfactor 5)
								(= temp0 (DiceList whichHas: temp1))
								(self setKeepers: temp0 (+ temp0 1))
							)
						)
					)
					(if (localproc_3)
						(= temp0 (localproc_3))
						(cond
							((and (localproc_6 temp0) (>= temp0 3))
								(= wtfactor 32)
							)
							((global178 lateInGame:)
								(= wtfactor 32)
							)
							(else
								(= wtfactor 10)
							)
						)
						(self
							setKeepers:
								global506
								(+ global506 1)
								(+ global506 2)
						)
					)
					(if tempScore
						(cond
							((>= tempScore 14)
								(= wtfactor 50)
							)
							((global178 lateInGame:)
								(= wtfactor 50)
							)
							(else
								(= wtfactor 5)
							)
						)
						(cond
							((== (= temp0 (DiceList whichHas: retValue)) 0)
								(cond
									(
										(and
											(> global505 4)
											(==
												((global178 at: 10) finalScore:)
												50
											)
										)
										(self setKeepers: 0 1 2 3 4)
									)
									((> global505 4)
										(self setKeepers: 0 1 2 3 4)
									)
									(else
										(self
											setKeepers:
												temp0
												(+ temp0 1)
												(+ temp0 2)
												(+ temp0 3)
										)
									)
								)
							)
							(
								(and
									(> global501 4)
									(== ((global178 at: 10) finalScore:) 50)
								)
								(self setKeepers: 0 1 2 3 4)
							)
							((> global501 4)
								(self setKeepers: 0 1 2 3 4)
							)
							(else
								(self
									setKeepers:
										temp0
										(+ temp0 1)
										(+ temp0 2)
										(+ temp0 3)
								)
							)
						)
					)
					(if ((global178 at: 10) retValue:)
						(= temp0 ((global178 at: 10) retValue:))
						(if (== ((global178 at: 10) finalScore:) 50)
							(cond
								((>= temp0 4)
									(= wtfactor 50)
									(self setKeepers: 0 1 2 3 4)
								)
								(
									(and
										(localproc_6 temp0)
										(not (global178 lateInGame:))
									)
									(= wtfactor 30)
									(self setKeepers: 0 1 2 3 4)
								)
								(else
									(if
										(or
											(== (global178 rollsLeft:) 1)
											(== (global178 rollsLeft:) 2)
										)
										(self setKeepers: 0 1 2 3)
									else
										(self setKeepers: 0 1 2 3 4)
									)
									(= wtfactor 50)
								)
							)
						)
					)
				)
			)
			(return wtfactor)
		)
	)
)

(instance fullHouseScore of Score
	(properties
		y 113
		loop 8
	)

	(method (calc)
		(= tempScore (= retValue 0))
		(if
			(or
				(and
					(== global501 global502)
					(== global503 global504 global505)
					(!= global501 global505)
				)
				(and
					(== global501 global502 global503)
					(== global504 global505)
					(!= global501 global505)
				)
			)
			(= retValue global503)
			(= tempScore (DiceList diceTotal:))
		)
		(return retValue)
	)

	(method (eval &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== finalScore -1)
			(= wtfactor 0)
			(if (or (== (global178 skill:) 0) (== (global178 skill:) 1))
				(if (== (global178 rollsLeft:) 0)
					(if tempScore
						(= wtfactor 35)
					else
						(= wtfactor 2)
					)
				)
				(if
					(or
						(== (global178 rollsLeft:) 1)
						(== (global178 rollsLeft:) 2)
					)
					(if (not (or (localproc_5) (localproc_4)))
						(= keepers 0)
						(= wtfactor 2)
					)
					(if (localproc_5)
						(if (== (global178 rollsLeft:) 1)
							(= wtfactor 2)
						)
						(if (== (global178 rollsLeft:) 2)
							(= wtfactor 2)
						)
						(self setKeepers: global506 (+ global506 1))
					)
					(if
						(or
							(> (localproc_3) 3)
							(> ((global178 at: 6) retValue:) 3)
							(> ((global178 at: 10) retValue:) 3)
						)
						(if (== (global178 rollsLeft:) 1)
							(= wtfactor 4)
						)
						(if (== (global178 rollsLeft:) 2)
							(= wtfactor 4)
						)
						(if (localproc_3)
							(self
								setKeepers:
									global506
									(+ global506 1)
									(+ global506 2)
							)
						)
						(if ((global178 at: 6) retValue:)
							(= temp4 (DiceList whichHas: retValue))
							(self setKeepers: temp4 (+ temp4 1) (+ temp4 2))
						)
						(if ((global178 at: 10) retValue:)
							(self setKeepers: 0 1 2)
						)
					)
					(if (localproc_4)
						(= temp0 (localproc_4))
						(= temp1 global506)
						(= temp3 (DiceList whichHas: temp1))
						(= temp2 (DiceList whichHas: temp0))
						(self setKeepers: temp3 (+ temp3 1) temp2 (+ temp2 1))
						(= wtfactor 19)
					)
					(if tempScore
						(= wtfactor 35)
						(self setKeepers: 0 1 2 3 4)
					)
				)
			)
			(if (== (global178 skill:) 2)
				(if (== (global178 rollsLeft:) 0)
					(if (> tempScore 0)
						(cond
							((>= tempScore 18)
								(= wtfactor 45)
							)
							((global178 lateInGame:)
								(= wtfactor 40)
							)
							(else
								(= wtfactor 20)
							)
						)
					else
						(= wtfactor 2)
					)
				)
				(if (not (or (localproc_5) (localproc_4)))
					(if (== (global178 rollsLeft:) 1)
						(= wtfactor 1)
					)
					(if (== (global178 rollsLeft:) 2)
						(= wtfactor 1)
					)
					(= keepers 0)
				)
				(if (localproc_5)
					(if (== (global178 rollsLeft:) 1)
						(= wtfactor 2)
					)
					(if (== (global178 rollsLeft:) 2)
						(= wtfactor 2)
					)
					(self setKeepers: global506 (+ global506 1))
				)
				(if
					(or
						(and (>= (localproc_3) 1) (<= (localproc_3) 3))
						(and
							(>= ((global178 at: 6) retValue:) 1)
							(<= ((global178 at: 6) retValue:) 3)
						)
						(and
							(>= ((global178 at: 10) retValue:) 1)
							(<= ((global178 at: 10) retValue:) 3)
						)
					)
					(if (== (global178 rollsLeft:) 1)
						(= wtfactor 3)
					)
					(if (== (global178 rollsLeft:) 2)
						(= wtfactor 3)
					)
					(if (localproc_3)
						(self
							setKeepers:
								global506
								(+ global506 1)
								(+ global506 2)
						)
					)
					(if ((global178 at: 6) retValue:)
						(= temp4 (DiceList whichHas: retValue))
						(self setKeepers: temp4 (+ temp4 1) (+ temp4 2))
					)
					(if ((global178 at: 10) retValue:)
						(self setKeepers: 0 1 2)
					)
				)
				(if
					(or
						(> (localproc_3) 3)
						(> ((global178 at: 6) retValue:) 3)
						(> ((global178 at: 10) retValue:) 3)
					)
					(if (== (global178 rollsLeft:) 1)
						(= wtfactor 4)
					)
					(if (== (global178 rollsLeft:) 2)
						(= wtfactor 4)
					)
					(if (localproc_3)
						(self
							setKeepers:
								global506
								(+ global506 1)
								(+ global506 2)
						)
					)
					(if ((global178 at: 6) retValue:)
						(= temp4 (DiceList whichHas: retValue))
						(self setKeepers: temp4 (+ temp4 1) (+ temp4 2))
					)
					(if ((global178 at: 10) retValue:)
						(self setKeepers: 0 1 2)
					)
				)
				(if (localproc_4)
					(= temp0 (localproc_4))
					(= temp1 global506)
					(= temp3 (DiceList whichHas: temp1))
					(= temp2 (DiceList whichHas: temp0))
					(if (<= (+ (* temp0 2) (* temp1 2)) 14)
						(if (global178 lateInGame:)
							(= wtfactor 20)
						else
							(if (== (global178 rollsLeft:) 1)
								(= wtfactor 5)
							)
							(if (== (global178 rollsLeft:) 2)
								(= wtfactor 5)
							)
						)
					else
						(if (== (global178 rollsLeft:) 1)
							(= wtfactor 20)
						)
						(if (== (global178 rollsLeft:) 2)
							(= wtfactor 23)
						)
					)
					(self setKeepers: temp3 (+ temp3 1) temp2 (+ temp2 1))
				)
				(if (> tempScore 0)
					(cond
						((<= tempScore 13)
							(if (== (global178 rollsLeft:) 1)
								(if (global178 lateInGame:)
									(= wtfactor 31)
								else
									(= wtfactor 5)
								)
							)
							(if (== (global178 rollsLeft:) 2)
								(if (global178 lateInGame:)
									(= wtfactor 20)
								else
									(= wtfactor 5)
								)
							)
						)
						((>= tempScore 18)
							(= wtfactor 45)
						)
						((global178 lateInGame:)
							(= wtfactor 40)
						)
						(else
							(= wtfactor 20)
						)
					)
					(self setKeepers: 0 1 2 3 4)
				)
			)
			(return wtfactor)
		)
	)
)

(instance smStraightScore of Score
	(properties
		y 124
		loop 9
	)

	(method (calc)
		(= tempScore (= retValue 0))
		(if
			(and
				((global178 at: 0) tempScore:)
				((global178 at: 1) tempScore:)
				((global178 at: 2) tempScore:)
				((global178 at: 3) tempScore:)
			)
			(= tempScore 25)
			(= retValue 1)
		)
		(if
			(and
				((global178 at: 2) tempScore:)
				((global178 at: 3) tempScore:)
				((global178 at: 4) tempScore:)
				((global178 at: 5) tempScore:)
			)
			(= tempScore 25)
			(= retValue 3)
		)
		(if
			(and
				((global178 at: 1) tempScore:)
				((global178 at: 2) tempScore:)
				((global178 at: 3) tempScore:)
				((global178 at: 4) tempScore:)
			)
			(= tempScore 25)
			(= retValue 2)
		)
		(return retValue)
	)

	(method (eval)
		(if (== finalScore -1)
			(= wtfactor 0)
			(if (or (== (global178 skill:) 0) (== (global178 skill:) 1))
				(if (== (global178 rollsLeft:) 0)
					(if tempScore
						(= wtfactor 50)
					else
						(= wtfactor 2)
					)
				)
				(if
					(or
						(== (global178 rollsLeft:) 1)
						(== (global178 rollsLeft:) 2)
					)
					(if (not tempScore)
						(= wtfactor 2)
						(= keepers 0)
					)
					(if (localproc_0)
						(= wtfactor 29)
						(if (== global506 2)
							(self setKeepers: global512 global513 global514)
						else
							(self setKeepers: global513 global514 global515)
						)
					)
					(if tempScore
						(= wtfactor 50)
						(self setKeepers: 0 1 2 3 4)
					)
					(if (not keepers)
						(self
							setKeepers: global512 global513 global514 global515
						)
					)
				)
			)
			(if (== (global178 skill:) 2)
				(if (== (global178 rollsLeft:) 0)
					(if tempScore
						(= wtfactor 85)
					else
						(= wtfactor 2)
					)
				)
				(if
					(or
						(== (global178 rollsLeft:) 1)
						(== (global178 rollsLeft:) 2)
					)
					(if (not tempScore)
						(= wtfactor 4)
						(= keepers 0)
					)
					(if (localproc_1)
						(= wtfactor 5)
						(if (== global506 45)
							(self setKeepers: global511 global512 global513)
						)
						(if (== global506 35)
							(self setKeepers: global511 global512 global514)
						)
						(if (== global506 46)
							(self setKeepers: global513 global515 global516)
						)
						(if (== global506 36)
							(self setKeepers: global514 global515 global516)
						)
					)
					(if (localproc_0)
						(= wtfactor 29)
						(if (== global506 2)
							(self setKeepers: global512 global513 global514)
						else
							(self setKeepers: global513 global514 global515)
						)
					)
					(if tempScore
						(= wtfactor 50)
						(switch retValue
							(1
								(self
									setKeepers:
										global511
										global512
										global513
										global514
								)
							)
							(2
								(self
									setKeepers:
										global512
										global513
										global514
										global515
								)
							)
							(3
								(self
									setKeepers:
										global513
										global514
										global515
										global516
								)
							)
						)
					)
					(if ((global178 at: 9) tempScore:)
						(= wtfactor 50)
						(self setKeepers: 0 1 2 3)
					)
					(if (and tempScore (== ((global178 at: 9) finalScore:) 30))
						(= wtfactor 50)
						(self setKeepers: 0 1 2 3 4)
					)
					(if (not keepers)
						(self
							setKeepers: global512 global513 global514 global515
						)
					)
				)
			)
			(return wtfactor)
		)
	)
)

(instance lgStraightScore of Score
	(properties
		y 135
		loop 10
	)

	(method (calc)
		(= tempScore (= retValue 0))
		(if
			(and
				(> global505 global504 global503 global502 global501)
				(or
					(==
						(+ global501 global502 global503 global504 global505)
						15
					)
					(==
						(+ global501 global502 global503 global504 global505)
						20
					)
				)
			)
			(= retValue global501)
			(= tempScore 30)
		)
		(return retValue)
	)

	(method (eval &tmp temp0)
		(if (== finalScore -1)
			(= wtfactor 0)
			(if (== (global178 skill:) 0)
				(if (== (global178 rollsLeft:) 0)
					(if tempScore
						(= wtfactor 60)
					else
						(= wtfactor 4)
					)
				)
				(if
					(or
						(== (global178 rollsLeft:) 1)
						(== (global178 rollsLeft:) 2)
					)
					(if (not tempScore)
						(= keepers 0)
						(= wtfactor 2)
					)
					(if ((global178 at: 8) tempScore:)
						(= wtfactor 55)
						(if (== ((global178 at: 8) retValue:) 1)
							(self
								setKeepers:
									global511
									global512
									global513
									global514
							)
						)
						(if (== ((global178 at: 8) retValue:) 3)
							(self
								setKeepers:
									global513
									global514
									global515
									global516
							)
						)
					)
					(if (localproc_2)
						(= wtfactor 55)
						(self
							setKeepers: global512 global513 global514 global515
						)
					)
					(if tempScore
						(= wtfactor 60)
						(self setKeepers: 0 1 2 3 4)
					)
				)
				(if (not keepers)
					(self setKeepers: global512 global513 global514 global515)
				)
			)
			(if (== (global178 skill:) 1)
				(if (== (global178 rollsLeft:) 0)
					(if tempScore
						(= wtfactor 60)
					else
						(= wtfactor 4)
					)
				)
				(if
					(or
						(== (global178 rollsLeft:) 1)
						(== (global178 rollsLeft:) 2)
					)
					(if (not tempScore)
						(= keepers 0)
						(= wtfactor 2)
					)
					(if ((global178 at: 8) tempScore:)
						(= wtfactor 55)
						(if (== ((global178 at: 8) retValue:) 1)
							(self
								setKeepers:
									global511
									global512
									global513
									global514
							)
						)
						(if (== ((global178 at: 8) retValue:) 3)
							(self
								setKeepers:
									global513
									global514
									global515
									global516
							)
						)
					)
					(if (localproc_2)
						(= wtfactor 55)
						(self
							setKeepers: global512 global513 global514 global515
						)
					)
					(if tempScore
						(= wtfactor 60)
						(self setKeepers: 0 1 2 3 4)
					)
				)
				(if (not keepers)
					(self setKeepers: global512 global513 global514 global515)
				)
			)
			(if (== (global178 skill:) 2)
				(if (== (global178 rollsLeft:) 0)
					(if tempScore
						(= wtfactor 95)
					else
						(= wtfactor 5)
					)
				)
				(if
					(or
						(== (global178 rollsLeft:) 1)
						(== (global178 rollsLeft:) 2)
					)
					(if (not tempScore)
						(= wtfactor 2)
						(= keepers 0)
					)
					(if (localproc_1)
						(= wtfactor 15)
						(switch global506
							(45
								(self
									setKeepers:
										global511
										global512
										global513
										global515
								)
							)
							(35
								(self
									setKeepers:
										global511
										global512
										global514
										global515
								)
							)
							(25
								(self
									setKeepers:
										global511
										global513
										global514
										global515
								)
							)
							(56
								(self
									setKeepers:
										global512
										global513
										global514
										global516
								)
							)
							(46
								(self
									setKeepers:
										global512
										global513
										global515
										global516
								)
							)
							(36
								(self
									setKeepers:
										global512
										global514
										global515
										global516
								)
							)
						)
					)
					(if (localproc_0)
						(= wtfactor 20)
						(switch global506
							(2
								(self setKeepers: global512 global513 global514)
							)
							(3
								(self setKeepers: global513 global514 global515)
							)
						)
					)
					(if ((global178 at: 8) tempScore:)
						(cond
							((== ((global178 at: 8) finalScore:) -1)
								(= wtfactor 60)
							)
							((== (global178 rollsLeft:) 2)
								(= wtfactor 60)
							)
							((and (== (global178 rollsLeft:) 1) (localproc_5))
								(= temp0 (localproc_5))
								(if (localproc_6 temp0)
									(= wtfactor 20)
								else
									(= wtfactor 60)
								)
							)
						)
						(if (== ((global178 at: 8) retValue:) 1)
							(self
								setKeepers:
									global511
									global512
									global513
									global514
							)
						)
						(if (== ((global178 at: 8) retValue:) 3)
							(self
								setKeepers:
									global513
									global514
									global515
									global516
							)
						)
					)
					(if (localproc_2)
						(if (== ((global178 at: 8) finalScore:) -1)
							(= wtfactor 85)
						else
							(= wtfactor 85)
						)
						(self
							setKeepers: global512 global513 global514 global515
						)
					)
					(if tempScore
						(= wtfactor 100)
						(self setKeepers: 0 1 2 3 4)
					)
				)
				(if (not keepers)
					(self setKeepers: global512 global513 global514 global515)
				)
			)
			(return wtfactor)
		)
	)
)

(instance yahtzeeScore of Score
	(properties
		y 146
		loop 11
	)

	(method (calc)
		(= tempScore (= retValue 0))
		(if (== global501 global502 global503 global504 global505)
			(= retValue global501)
			(= tempScore 50)
		)
		(return retValue)
	)

	(method (eval &tmp temp0)
		(if (== finalScore -1)
			(= wtfactor 0)
			(if (== (global178 skill:) 0)
				(if (== (global178 rollsLeft:) 0)
					(if tempScore
						(= wtfactor 100)
					else
						(= wtfactor 6)
					)
				)
				(if
					(or
						(== (global178 rollsLeft:) 1)
						(== (global178 rollsLeft:) 2)
					)
					(if
						(not
							(or
								(localproc_3)
								((global178 at: 6) tempScore:)
								tempScore
							)
						)
						(= wtfactor 2)
						(= keepers 0)
					)
					(if (global178 lateInGame:)
						(if (localproc_5)
							(= wtfactor 16)
							(self setKeepers: global506 (+ global506 1))
						)
						(if (localproc_4)
							(= wtfactor 16)
							(= temp0 (localproc_4))
							(= temp0 (DiceList whichHas: temp0))
							(self setKeepers: temp0 (+ temp0 1))
						)
					)
					(if (localproc_3)
						(= wtfactor 28)
						(self
							setKeepers:
								global506
								(+ global506 1)
								(+ global506 2)
						)
					)
					(if ((global178 at: 6) tempScore:)
						(= wtfactor 55)
						(= temp0
							(DiceList whichHas: ((global178 at: 6) retValue:))
						)
						(self
							setKeepers:
								temp0
								(+ temp0 1)
								(+ temp0 2)
								(+ temp0 3)
						)
					)
					(if tempScore
						(= wtfactor 100)
						(self setKeepers: 0 1 2 3 4)
					)
				)
			)
			(if (== (global178 skill:) 1)
				(if (== (global178 rollsLeft:) 0)
					(if tempScore
						(= wtfactor 100)
					else
						(= wtfactor 6)
					)
				)
				(if
					(or
						(== (global178 rollsLeft:) 1)
						(== (global178 rollsLeft:) 2)
					)
					(if (not (or (localproc_5) (localproc_4)))
						(= wtfactor 2)
						(= keepers 0)
					)
					(if (localproc_5)
						(= wtfactor 16)
						(self setKeepers: global506 (+ global506 1))
					)
					(if (localproc_4)
						(= wtfactor 16)
						(= temp0 (localproc_4))
						(= temp0 (DiceList whichHas: temp0))
						(self setKeepers: temp0 (+ temp0 1))
					)
					(if (localproc_3)
						(= wtfactor 28)
						(self
							setKeepers:
								global506
								(+ global506 1)
								(+ global506 2)
						)
					)
					(if ((global178 at: 6) tempScore:)
						(= wtfactor 55)
						(= temp0
							(DiceList whichHas: ((global178 at: 6) retValue:))
						)
						(self
							setKeepers:
								temp0
								(+ temp0 1)
								(+ temp0 2)
								(+ temp0 3)
						)
					)
					(if tempScore
						(= wtfactor 100)
						(self setKeepers: 0 1 2 3 4)
					)
				)
			)
			(if (== (global178 skill:) 2)
				(if (== (global178 rollsLeft:) 0)
					(cond
						(tempScore
							(= wtfactor 100)
						)
						((global178 lateInGame:)
							(= wtfactor 10)
						)
						(else
							(= wtfactor 4)
						)
					)
				)
				(if
					(or
						(== (global178 rollsLeft:) 1)
						(== (global178 rollsLeft:) 2)
					)
					(if (not (or (localproc_5) (localproc_4)))
						(= wtfactor 2)
						(= keepers 0)
					)
					(if (localproc_5)
						(= wtfactor 3)
						(self setKeepers: global506 (+ global506 1))
					)
					(if (localproc_4)
						(= wtfactor 3)
						(= temp0 (localproc_4))
						(= temp0 (DiceList whichHas: temp0))
						(self setKeepers: temp0 (+ temp0 1))
					)
					(if (localproc_3)
						(= temp0 (localproc_3))
						(if (localproc_6 temp0)
							(= wtfactor 32)
						else
							(= wtfactor 7)
						)
						(self
							setKeepers:
								global506
								(+ global506 1)
								(+ global506 2)
						)
					)
					(if ((global178 at: 6) tempScore:)
						(= wtfactor 55)
						(= temp0
							(DiceList whichHas: ((global178 at: 6) retValue:))
						)
						(self
							setKeepers:
								temp0
								(+ temp0 1)
								(+ temp0 2)
								(+ temp0 3)
						)
					)
					(if tempScore
						(= wtfactor 100)
						(self setKeepers: 0 1 2 3 4)
					)
				)
			)
			(return wtfactor)
		)
	)
)

(instance chanceScore of Score
	(properties
		y 157
		loop 12
	)

	(method (calc)
		(= tempScore (= retValue 0))
		(= tempScore (DiceList diceTotal:))
		(= retValue 5)
		(return retValue)
	)

	(method (eval &tmp temp0)
		(if (== finalScore -1)
			(= wtfactor 0)
			(if (== (global178 skill:) 0)
				(if (== (global178 rollsLeft:) 0)
					(= wtfactor tempScore)
				else
					(= wtfactor tempScore)
					(self setKeepers:)
				)
			)
			(if (== (global178 skill:) 1)
				(if (== (global178 rollsLeft:) 0)
					(= wtfactor tempScore)
				else
					(= wtfactor tempScore)
					(self setKeepers:)
				)
			)
			(if (== (global178 skill:) 2)
				(if (or (> (localproc_7) tempScore) (localproc_8))
					(= wtfactor 1)
				else
					(= wtfactor tempScore)
				)
				(self setKeepers:)
			)
			(return wtfactor)
		)
	)

	(method (setKeepers &tmp temp0)
		(for ((= temp0 (= keepers 0))) (< temp0 5) ((++ temp0))
			(if
				(>=
					((DiceList at: temp0) pipValue:)
					(if (== (global178 rollsLeft:) 0) 0 else 4)
				)
				(switch temp0
					(-1 0)
					(0
						(|= keepers $0001)
					)
					(1
						(|= keepers $0002)
					)
					(2
						(|= keepers $0004)
					)
					(3
						(|= keepers $0008)
					)
					(4
						(|= keepers $0010)
					)
				)
			)
		)
	)
)


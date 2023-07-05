;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 724)
(include sci.sh)
(use Main)
(use Piles)
(use SortArray)
(use System)

(public
	proc724_0 0
	proc724_1 1
	proc724_2 2
)

(local
	local0
	local1
)

(procedure (proc724_0 param1 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (< temp0 13) ((++ temp0))
		(= [global201 temp0]
			(switch param1
				(4 [global123 temp0])
				(1 [global162 temp0])
				(2 [global149 temp0])
				(3 [global136 temp0])
			)
		)
	)
)

(procedure (proc724_1 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(= local0 (Dealer curPlayer:))
	(= local1 (local0 partner:))
	(= temp0 0)
	(= temp1 0)
	(while (< temp0 13)
		(cond
			((== [global201 param2] 1)
				(if
					(and
						(==
							(= temp2
								(SortArray
									isCurrent: (= temp3 (local0 at: temp0))
								)
							)
							param2
						)
						(== param3 (temp3 suit:))
					)
					(= temp1 temp0)
					(= temp0 13)
				)
			)
			(
				(and
					(==
						(= temp2
							(SortArray isCurrent: (= temp3 (local1 at: temp0)))
						)
						param2
					)
					(== param3 (temp3 suit:))
				)
				(= temp1 temp0)
				(= temp0 13)
			)
		)
		(++ temp0)
	)
	(if (== [global201 param2] 1)
		(local0 at: temp1)
		(return)
	else
		(local1 at: temp1)
		(return)
	)
)

(procedure (proc724_2 param1 param2 param3 param4 param5 param6 &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10) ; UNUSED
	(= local0 (Dealer curPlayer:))
	(= local1 (local0 partner:))
	(= temp2 (= temp3 (= temp4 (= temp5 (= temp8 0)))))
	(= temp6 param2)
	(= temp7 param3)
	(= temp10 (gTrick leader:))
	(param1 finCard: 0)
	(cond
		([global201 0]
			(param1 finChance: 50)
			(param1 mustLose: 0)
			(cond
				([global201 1]
					(cond
						([global201 2]
							(return 0)
						)
						(
							(and
								[global201 3]
								[global201 4]
								(!= [global201 0] [global201 1])
							)
							(if
								(and
									[global201 5]
									(or (> temp6 3) (> temp7 3))
									(> temp6 2)
									(> temp7 2)
								)
								(param1 finTricks: 2)
							else
								(param1 finTricks: 1)
							)
							(return 12)
						)
						(
							(and
								[global201 3]
								(or
									[global201 4]
									(== [global201 0] [global201 3])
									(== [global201 1] [global201 3])
								)
							)
							(if [global201 4]
								(cond
									((!= [global201 3] [global201 4])
										(param1
											finCard: (proc724_1 param1 4 param4)
										)
										(if
											(and
												[global201 5]
												(or (> temp6 3) (> temp7 3))
												(> temp6 2)
												(> temp7 2)
											)
											(param1 finTricks: 2)
										else
											(param1 finTricks: 1)
										)
									)
									(
										(and
											(== [global201 4] [global201 0])
											(> temp6 1)
											(> temp7 1)
										)
										(param1 finTricks: 2)
									)
									(else
										(param1 finTricks: 1)
									)
								)
							else
								(param1 finTricks: 1)
							)
							(if (== [global201 3] 1)
								(return 1)
							else
								(return 16)
							)
						)
						(
							(and
								[global201 4]
								(or
									(==
										[global201 0]
										[global201 1]
										[global201 4]
									)
									(and
										[global201 5]
										(== [global201 0] [global201 1])
										(or
											(== [global201 0] [global201 5])
											[global201 6]
										)
										(or (> temp7 3) (> temp6 3))
										(> temp7 1)
										(> temp6 1)
									)
								)
							)
							(param1 finChance: 75)
							(param1 finTricks: 1)
							(param1 mustLose: 1)
							(param1 noFinLoserChance: 25)
							(param1 noFinLoserTricks: 2)
							(if [global201 6]
								(if
									(and
										(or (> temp7 3) (> temp6 3))
										(> temp7 2)
										(> temp6 2)
									)
									(param1 finTricks: 2)
									(param1 noFinLoserTricks: 3)
								else
									(param1 finTricks: 1)
									(param1 noFinLoserTricks: 2)
								)
								(cond
									((!= [global201 0] [global201 4])
										(param1
											finCard: (proc724_1 param1 4 param4)
										)
									)
									((!= [global201 0] [global201 5])
										(param1
											finCard: (proc724_1 param1 5 param4)
										)
									)
									((!= [global201 0] [global201 6])
										(param1
											finCard: (proc724_1 param1 6 param4)
										)
									)
								)
							)
							(if (== [global201 0] 1)
								(return 1)
							else
								(return 16)
							)
						)
					)
				)
				([global201 2]
					(cond
						((and [global201 3] [global201 4])
							(cond
								(
									(and
										(==
											[global201 0]
											[global201 2]
											[global201 3]
											[global201 4]
										)
										(> temp7 2)
										(> temp6 2)
									)
									(param1 finTricks: 3)
								)
								(
									(and
										(or (> temp6 2) (> temp7 2))
										(> temp6 1)
										(> temp7 1)
									)
									(param1 finTricks: 2)
								)
								(
									(or
										(and (> temp6 0) (> temp7 0))
										(and (> temp7 1) (== temp10 param5))
										(and (> temp6 1) (== temp10 param6))
									)
									(param1 finTricks: 1)
								)
								(else
									(param1 finTricks: 0)
									(return 0)
								)
							)
							(cond
								((!= [global201 2] [global201 0])
									(param1
										finCard: (proc724_1 param1 2 param4)
									)
									(if (== [global201 0] 1)
										(return 1)
									else
										(return 16)
									)
								)
								((!= [global201 3] [global201 0])
									(param1
										finCard: (proc724_1 param1 3 param4)
									)
									(if (== [global201 0] 1)
										(return 1)
									else
										(return 16)
									)
								)
								((!= [global201 4] [global201 0])
									(param1
										finCard: (proc724_1 param1 4 param4)
									)
									(if (== [global201 0] 1)
										(return 1)
									else
										(return 16)
									)
								)
								((== [global201 0] 1)
									(return 1)
								)
								(else
									(return 16)
								)
							)
						)
						([global201 3]
							(cond
								(
									(and
										(==
											[global201 2]
											[global201 3]
											[global201 0]
										)
										(> temp6 1)
										(> temp7 1)
									)
									(param1 finTricks: 2)
									(if (== [global201 0] 1)
										(return 1)
									else
										(return 16)
									)
								)
								(
									(or
										(and temp6 temp7)
										(and
											(== [global201 0] 1)
											(!= temp10 local0)
										)
										(and
											(== [global201 0] 2)
											(!= temp10 local1)
										)
									)
									(param1 finTricks: 1)
								)
								(else
									(param1 finTricks: 0)
									(return 0)
								)
							)
							(if (== [global201 0] 1)
								(return 1)
							else
								(return 16)
							)
						)
						([global201 4]
							(cond
								((== [global201 2] [global201 4] [global201 0])
									(cond
										((== [global201 0] 1)
											(cond
												((> temp7 1)
													(param1 finChance: 25)
													(param1 finTricks: 2)
												)
												(
													(or
														(== temp7 1)
														(!= temp10 local0)
													)
													(param1 finTricks: 1)
												)
												(else
													(param1 finTricks: 0)
													(return 0)
												)
											)
										)
										((> temp6 1)
											(param1 finChance: 25)
											(param1 finTricks: 2)
										)
										((or (== temp6 1) (!= temp10 local1))
											(param1 finTricks: 1)
										)
										(else
											(param1 finTricks: 0)
											(return 0)
										)
									)
									(if (== [global201 0] 1)
										(return 3)
									else
										(return 18)
									)
								)
								(
									(and
										[global201 5]
										[global201 6]
										(== [global201 0] [global201 2])
									)
									(cond
										((and (> temp7 2) (> temp6 2))
											(param1
												finTricks:
													(-
														1
														(Max temp7 temp6)
													)
											)
										)
										(
											(and
												(== [global201 0] 1)
												(> temp6 2)
												(> temp7 1)
											)
											(param1 finTricks: 2)
										)
										(
											(and
												(== [global201 0] 2)
												(> temp6 1)
												(> temp7 2)
											)
											(param1 finTricks: 2)
										)
										((and (== [global201 0] 1) (== temp6 2))
											(param1 finTricks: 1)
										)
										((and (== [global201 0] 2) (== temp7 2))
											(param1 finTricks: 1)
										)
										(
											(and
												(== [global201 0] 1)
												(== temp6 2)
												(!= temp10 local0)
											)
											(param1 finTricks: 1)
										)
										(
											(and
												(== [global201 0] 1)
												(== temp7 2)
												(!= temp10 local1)
											)
											(param1 finTricks: 1)
										)
										(else
											(param1 finTricks: 0)
											(return 0)
										)
									)
									(if (> (param1 finTricks:) 1)
										(param1 finChance: 25)
									else
										(param1 finChance: 50)
									)
									(cond
										((!= [global201 0] [global201 4])
											(param1
												finCard:
													(proc724_1 param1 4 param4)
											)
										)
										((!= [global201 0] [global201 5])
											(param1
												finCard:
													(proc724_1 param1 5 param4)
											)
										)
										((!= [global201 0] [global201 6])
											(param1
												finCard:
													(proc724_1 param1 6 param4)
											)
										)
									)
									(if (== [global201 0] 1)
										(return 3)
									else
										(return 18)
									)
								)
								(
									(and
										(== [global201 0] [global201 2])
										(== [global201 0] [global201 5])
									)
									(param1 finChance: 25)
									(param1
										finCard: (proc724_1 param1 4 param4)
									)
									(if (== [global201 0] 1)
										(return 3)
									else
										(return 18)
									)
								)
								(else
									(param1 finChance: 50)
									(cond
										((== [global201 0] [global201 2])
											(if (== [global201 0] 1)
												(return 1)
											else
												(return 16)
											)
										)
										((== [global201 0] 1)
											(return 17)
										)
										(else
											(return 2)
										)
									)
								)
							)
						)
						((== [global201 0] [global201 2])
							(param1 finChance: 50)
							(if (== [global201 0] 1)
								(return 1)
							else
								(return 16)
							)
						)
						(else
							(param1 finChance: 50)
							(param1 mustLose: 1)
							(if (== [global201 0] 1)
								(return 17)
							else
								(return 2)
							)
						)
					)
				)
				([global201 3]
					(cond
						((and [global201 4] [global201 5])
							(param1 finChance: 75)
							(param1 mustLose: 1)
							(cond
								((!= [global201 0] [global201 3])
									(param1
										finCard: (proc724_1 param1 3 param4)
									)
								)
								((!= [global201 0] [global201 4])
									(param1
										finCard: (proc724_1 param1 4 param4)
									)
								)
								((!= [global201 0] [global201 5])
									(param1
										finCard: (proc724_1 param1 5 param4)
									)
								)
							)
							(if (== [global201 0] 1)
								(return 3)
							else
								(return 18)
							)
						)
						(
							(and
								[global201 4]
								(== [global201 0] [global201 3])
								(== [global201 0] [global201 4])
							)
							(param1 finChance: 75)
							(param1 mustLose: 1)
							(if (== [global201 0] 1)
								(return 3)
							else
								(return 18)
							)
						)
						(
							(and
								[global201 5]
								(== [global201 0] [global201 3])
								(or
									(== [global201 0] [global201 5])
									[global201 6]
								)
							)
							(param1 finChance: 38)
							(param1 mustLose: 1)
							(cond
								((!= [global201 0] [global201 5])
									(param1
										finCard: (proc724_1 param1 5 param4)
									)
								)
								((!= [global201 0] [global201 6])
									(param1
										finCard: (proc724_1 param1 6 param4)
									)
								)
							)
							(if (== [global201 0] 1)
								(return 3)
							else
								(return 18)
							)
						)
						((== [global201 0] [global201 3])
							(param1 finChance: 25)
							(param1 mustLose: 1)
							(if (== [global201 0] 1)
								(return 3)
							else
								(return 18)
							)
						)
						(else
							(return 0)
						)
					)
				)
				((== [global201 4] [global201 5] [global201 6] [global201 0])
					(param1 mustLose: 2)
					(param1 finChance: 38)
					(if (== [global201 0] 1)
						(return 3)
					else
						(return 18)
					)
				)
				(else
					(return 0)
				)
			)
		)
		([global201 1]
			(param1 finChance: 50)
			(param1 mustLose: 1)
			(cond
				([global201 2]
					(cond
						([global201 3]
							(return 0)
						)
						(
							(and
								[global201 4]
								[global201 5]
								(!= [global201 1] [global201 2])
							)
							(if [global201 5]
								(param1 finCard: (proc724_1 param1 5 param4))
							)
							(return 13)
						)
						(
							(or
								[global201 5]
								(== [global201 1] [global201 4])
								(== [global201 2] [global201 4])
							)
							(if [global201 5]
								(param1 finCard: (proc724_1 param1 5 param4))
							)
							(if (== [global201 1] 1)
								(return 6)
							else
								(return 21)
							)
						)
						(
							(and
								[global201 4]
								(or
									(==
										[global201 1]
										[global201 2]
										[global201 4]
									)
									(and
										[global201 5]
										(== [global201 2] [global201 1])
										(or
											(== [global201 1] [global201 5])
											[global201 6]
										)
									)
								)
							)
							(param1 finChance: 75)
							(if [global201 5]
								(cond
									((!= [global201 1] [global201 4])
										(param1
											finCard: (proc724_1 param1 4 param4)
										)
									)
									((!= [global201 1] [global201 5])
										(param1
											finCard: (proc724_1 param1 5 param4)
										)
									)
									((!= [global201 1] [global201 6])
										(param1
											finCard: (proc724_1 param1 6 param4)
										)
									)
								)
							)
							(if (== [global201 0] 1)
								(return 4)
							else
								(return 19)
							)
						)
					)
				)
				([global201 3]
					(cond
						((and [global201 4] [global201 5])
							(param1 finChance: 75)
							(cond
								((!= [global201 3] [global201 1])
									(param1
										finCard: (proc724_1 param1 3 param4)
									)
									(if (== [global201 1] 1)
										(return 4)
									else
										(return 19)
									)
								)
								((!= [global201 4] [global201 1])
									(param1
										finCard: (proc724_1 param1 4 param4)
									)
									(if (== [global201 0] 1)
										(return 4)
									else
										(return 19)
									)
								)
								((!= [global201 5] [global201 1])
									(param1
										finCard: (proc724_1 param1 5 param4)
									)
									(if (== [global201 1] 1)
										(return 4)
									else
										(return 19)
									)
								)
								((== [global201 1] 1)
									(return 4)
								)
								(else
									(return 19)
								)
							)
						)
						([global201 4]
							(cond
								(
									(and
										(== [global201 3] [global201 4])
										(!= [global201 3] [global201 1])
									)
									(param1
										finCard: (proc724_1 param1 3 param4)
									)
									(if (== [global201 1] 1)
										(return 4)
									else
										(return 19)
									)
								)
								((== [global201 1] 1)
									(return 4)
								)
								(else
									(return 19)
								)
							)
						)
						([global201 5]
							(cond
								((== [global201 1] [global201 3] [global201 5])
									(param1 finChance: 25)
									(if (== [global201 1] 1)
										(return 6)
									else
										(return 21)
									)
								)
								(
									(and
										[global201 6]
										[global201 7]
										(== [global201 1] [global201 3])
									)
									(param1 finChance: 25)
									(cond
										((!= [global201 0] [global201 5])
											(param1
												finCard:
													(proc724_1 param1 5 param4)
											)
										)
										((!= [global201 0] [global201 6])
											(param1
												finCard:
													(proc724_1 param1 6 param4)
											)
										)
										((!= [global201 0] [global201 7])
											(param1
												finCard:
													(proc724_1 param1 7 param4)
											)
										)
									)
									(if (== [global201 1] 1)
										(return 6)
									else
										(return 21)
									)
								)
								(
									(and
										(== [global201 1] [global201 3])
										(== [global201 1] [global201 6])
									)
									(param1 finChance: 25)
									(param1
										finCard: (proc724_1 param1 5 param4)
									)
									(if (== [global201 0] 1)
										(return 3)
									else
										(return 18)
									)
								)
								(else
									(param1 finChance: 50)
									(cond
										((== [global201 1] [global201 3])
											(if (== [global201 1] 1)
												(return 4)
											else
												(return 19)
											)
										)
										((== [global201 1] 1)
											(return 5)
										)
										(else
											(return 20)
										)
									)
								)
							)
						)
						((== [global201 1] [global201 3])
							(param1 finChance: 50)
							(if (== [global201 1] 1)
								(return 4)
							else
								(return 19)
							)
						)
						((== [global201 1] 1)
							(return 2)
						)
						(else
							(return 17)
						)
					)
				)
				([global201 4]
					(cond
						((and [global201 5] [global201 6])
							(param1 finChance: 75)
							(param1 mustLose: 2)
							(cond
								((!= [global201 1] [global201 4])
									(param1
										finCard: (proc724_1 param1 4 param4)
									)
								)
								((!= [global201 1] [global201 5])
									(param1
										finCard: (proc724_1 param1 5 param4)
									)
								)
								((!= [global201 1] [global201 6])
									(param1
										finCard: (proc724_1 param1 6 param4)
									)
								)
							)
							(if (== [global201 1] 1)
								(return 6)
							else
								(return 21)
							)
						)
						(
							(and
								[global201 5]
								(== [global201 1] [global201 4])
								(== [global201 1] [global201 5])
							)
							(param1 finChance: 75)
							(param1 mustLose: 1)
							(if (== [global201 1] 1)
								(return 6)
							else
								(return 21)
							)
						)
						(else
							(param1 finChance: 50)
							(param1 mustLose: 1)
							(if (== [global201 1] 1)
								(return 5)
							else
								(return 20)
							)
						)
					)
				)
				(else
					(param1 finChance: 50)
					(param1 mustLose: 1)
					(if (== [global201 1] 1)
						(return 5)
					else
						(return 20)
					)
				)
			)
		)
		([global201 2]
			(param1 finChance: 25)
			(param1 mustLose: 2)
			(cond
				((and [global201 3] [global201 4])
					(return 0)
				)
				(
					(and
						[global201 5]
						[global201 6]
						(!= [global201 2] [global201 3])
						(or (!= [global201 5] [global201 6]) [global201 7])
					)
					(if (and [global201 7] (== [global201 5] [global201 6]))
						(param1 finCard: (proc724_1 param1 7 param4))
					)
					(return 14)
				)
				(
					(and
						(== [global201 2] [global201 3])
						[global201 5]
						(or (== [global201 5] [global201 2]) [global201 6])
					)
					(cond
						((!= [global201 2] [global201 5])
							(param1 finCard: (proc724_1 param1 5 param4))
						)
						(
							(!=
								[global201 2]
								[global201 6]
								(param1 finCard: (proc724_1 param1 6 param4))
							))
					)
					(if (== [global201 2] 1)
						(return 7)
					else
						(return 22)
					)
				)
				((and [global201 4] [global201 5] [global201 6])
					(param1 finChance: 50)
					(cond
						((!= [global201 2] [global201 4])
							(param1 finCard: (proc724_1 param1 4 param4))
						)
						((!= [global201 2] [global201 5])
							(param1 finCard: (proc724_1 param1 5 param4))
						)
						((!= [global201 2] [global201 6])
							(param1 finCard: (proc724_1 param1 6 param4))
						)
					)
					(if (== [global201 2] 1)
						(return 9)
					else
						(return 24)
					)
				)
				(
					(and
						[global201 4]
						[global201 5]
						(or
							(== [global201 2] [global201 4])
							(== [global201 2] [global201 5])
						)
					)
					(cond
						((!= [global201 2] [global201 4])
							(param1 finCard: (proc724_1 param1 4 param4))
						)
						((!= [global201 2] [global201 5])
							(param1 finCard: (proc724_1 param1 5 param4))
						)
					)
					(if (== [global201 2] 1)
						(return 9)
					else
						(return 24)
					)
				)
				((== [global201 2] [global201 4])
					(if (== [global201 2] 1)
						(return 9)
					else
						(return 24)
					)
				)
				((== [global201 2] 1)
					(return 8)
				)
				(else
					(return 23)
				)
			)
		)
		(else
			(return 0)
		)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use Print)
(use System)

(public
	dispatchPlayer 0
)

(instance dispatchPlayer of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(= temp0 0)
		(for ((= temp1 150)) (< temp1 3999) ((++ temp1))
			(ClearFlag temp1)
		)
		(ClearFlag 93)
		(ClearFlag 94)
		(ClearFlag 95)
		(ClearFlag 96)
		(ClearFlag 97)
		(ClearFlag 98)
		(ClearFlag 99)
		(ClearFlag 100)
		(ClearFlag 101)
		(ClearFlag 102)
		(ClearFlag 103)
		(SetFlag 76)
		(SetFlag 109)
		(if
			(and
				global102
				(Print
					addText: {Choose Scenerio, or contiune as normal:}
					addButton: 1 {Choose} 0 20
					addButton: 0 {Continue} 50 20
					init:
				)
				(not argc)
				global102
			)
			(repeat
				(if
					(==
						(= temp0
							(Print
								addText: {Choose Scenerio:}
								addButton: 2 {S1 Plot 1} 0 20
								addButton: 3 {S1 Plot 2} 50 20
								addButton: 4 {S2 Plot 1} 0 40
								addButton: 5 {S2 Plot 2} 50 40
								addButton: 6 {S3 Plot 1} 0 90
								addButton: 7 {S3 Plot 2} 50 90
								init:
							)
						)
						-1
					)
					(= temp0 0)
					(break)
				)
				(if (OneOf temp0 78 24)
					(if (SetFlag temp0)
						(ClearFlag temp0)
					)
				else
					(ClearFlag 107)
					(ClearFlag 108)
					(= global108 temp0)
					(break)
				)
			)
		)
		(= global102 0)
		(cond
			((or (and argc param1) temp0)
				(= global108 (if argc param1 else temp0))
			)
			((or (IsFlag 91) (IsFlag 92))
				(switch (Random 0 4)
					(0
						(= global108 2)
					)
					(1
						(= global108 3)
					)
					(2
						(= global108 4)
					)
					(3
						(= global108 5)
					)
					(4
						(if (IsFlag 24)
							(if (Random 0 1)
								(= global108 6)
							else
								(= global108 7)
							)
						else
							(= global108 6)
						)
					)
				)
			)
			((and (not (IsFlag 87)) (not (IsFlag 88)))
				(cond
					(global102
						(= global108 2)
						(if
							(and
								(not (== temp0 2))
								(or
									(== temp0 3)
									(and (IsFlag 77) (not (Random 0 1)))
								)
							)
							(= global108 3)
						)
					)
					((IsFlag 77)
						(if (Random 0 1)
							(= global108 2)
						else
							(= global108 3)
						)
					)
					(else
						(= global108 2)
					)
				)
			)
			((and (not (IsFlag 89)) (not (IsFlag 90)))
				(cond
					(global102
						(= global108 4)
						(if
							(and
								(not (== temp0 4))
								(or
									(== temp0 5)
									(and (IsFlag 121) (not (Random 0 1)))
								)
							)
							(= global108 5)
						)
					)
					((IsFlag 121)
						(if (Random 0 1)
							(= global108 4)
						else
							(= global108 5)
						)
					)
					(else
						(= global108 4)
					)
				)
			)
			((and (IsFlag 78) (IsFlag 24) (not (IsFlag 83)))
				(= global108 7)
			)
			((IsFlag 78)
				(if (IsFlag 24)
					(if (Random 0 1)
						(= global108 6)
					else
						(= global108 7)
					)
				else
					(= global108 6)
				)
			)
			((IsFlag 24)
				(= global108 7)
			)
			(else
				(= global108 6)
			)
		)
		(switch global108
			(2
				(gGame getDisc: 2)
				(gCurRoom newRoom: 4350) ; s1_4350
			)
			(3
				(gGame getDisc: 2)
				(gCurRoom newRoom: 4350) ; s1_4350
			)
			(4
				(gGame getDisc: 3)
				(if (IsFlag 121)
					(gCurRoom newRoom: 3000) ; s2_3000
				else
					(gCurRoom newRoom: 2980) ; s2_2980
				)
			)
			(5
				(gGame getDisc: 3)
				(gCurRoom newRoom: 3000) ; s2_3000
			)
			(else
				(gGame getDisc: 4)
				(gCurRoom newRoom: 1500)
			)
		)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 753)
(include sci.sh)
(use Interface)
(use System)

(public
	help 0
)

(local
	[local0 10] = [9237 9238 9239 9240 9241 9242 9243 9244 9245 9246]
)

(instance help of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp0 0)
		(repeat
			(DoAudio audPLAY (WordAt @local0 temp0))
			(cond
				((== temp0 0)
					(= temp1
						(Print
							601
							temp0
							82
							942
							0
							temp0
							0
							81
							{Next}
							1
							81
							{Exit}
							0
						)
					)
				)
				((< temp0 9)
					(= temp1
						(Print
							601
							temp0
							82
							942
							0
							temp0
							0
							81
							{Next}
							1
							81
							{Previous}
							2
							81
							{Exit}
							0
						)
					)
				)
				(else
					(= temp1
						(Print
							601
							temp0
							82
							942
							0
							temp0
							0
							81
							{Exit}
							0
							81
							{Previous}
							2
						)
					)
				)
			)
			(switch temp1
				(0
					(DoAudio audSTOP)
					(break)
				)
				(1
					(++ temp0)
				)
				(2
					(-- temp0)
				)
			)
		)
		(DisposeScript 753)
	)
)


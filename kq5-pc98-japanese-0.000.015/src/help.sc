;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 753)
(include sci.sh)
(use Interface)
(use System)

(public
	help 0
)

(instance help of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp0 0)
		(repeat
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


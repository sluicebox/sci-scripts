;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 770)
(include sci.sh)
(use System)

(public
	proc770_0 0
)

(procedure (proc770_0 param1 param2 param3 &tmp temp0 temp1 temp2)
	(if (> argc 1)
		(= temp0 (= temp1 0))
		(if (= temp2 (IsObject param2))
			(if (RespondsTo param2 #x)
				(= temp0 (param2 x:))
			)
			(if (RespondsTo param2 #y)
				(if (> argc 2)
					(if (!= param3 0)
						(= temp1 (+ (param2 y:) param3 32))
					)
				else
					(= temp1
						(-
							(param2 y:)
							(+
								33
								(if (RespondsTo param2 #cel)
									(/
										(CelHigh
											(param2 view:)
											(param2 loop:)
											(param2 cel:)
										)
										2
									)
								else
									10
								)
							)
						)
					)
				)
			)
		else
			(= temp0 param2)
			(if (> argc 2)
				(= temp1 param3)
			)
		)
		(Memory memPOKE (+ param1 2) (Min (Max 0 (- temp0 40)) 239))
		(if
			(or
				(and (< argc 3) temp2)
				(and (> argc 2) (or (not temp2) (and temp2 (!= param3 0))))
			)
			(Memory memPOKE (+ param1 4) (Min (Max 40 (- temp1 33)) 123))
		)
	)
	(DisposeScript 770)
)


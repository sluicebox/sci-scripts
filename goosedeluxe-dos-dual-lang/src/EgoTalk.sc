;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 114)
(include sci.sh)
(use Main)
(use TalkerHead)

(class EgoTalk of TalkerHead
	(properties)

	(method (setMyView &tmp temp0 temp1)
		(if (== global130 60)
			(= temp1 220)
		else
			(= temp1 520)
		)
		(switch (mod (client loop:) 4)
			(0
				(= temp0 (+ (client view:) temp1))
			)
			(1
				(= temp0 (+ (client view:) temp1 20))
			)
			(2
				(= temp0 (+ (client view:) temp1 40))
			)
			(3
				(= temp0 (+ (client view:) temp1 60))
			)
		)
		(self view: temp0)
	)

	(method (setMyLoop &tmp temp0)
		(switch (mod (client loop:) 4)
			(0
				(= temp0 (client cel:))
			)
			(1
				(= temp0 (+ (client cel:) 4))
			)
			(2
				(= temp0 (+ (client cel:) 2))
			)
			(3
				(= temp0 (+ (client cel:) 6))
			)
		)
		(if (== global130 60)
			(+= temp0 9)
		)
		(self loop: temp0)
	)
)


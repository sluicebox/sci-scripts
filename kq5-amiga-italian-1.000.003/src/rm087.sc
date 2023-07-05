;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 87)
(include sci.sh)
(use Main)
(use KQ5Room)

(public
	rm087 0
)

(instance rm087 of KQ5Room
	(properties
		picture 946
	)

	(method (init)
		(super init:)
		(self overlay: 87)
		(gEgo posn: 154 149 init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 0) $4000)
				(gCurRoom newRoom: 46)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)
)


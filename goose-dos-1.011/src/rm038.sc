;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use Game)

(public
	rm038 0
)

(instance rm038 of Rm
	(properties
		picture 38
		style 0
		horizon 131
	)

	(method (init)
		(HandsOn)
		(super init:)
		(= global207 1)
		(= global125 -1)
		(gEgo
			loop: 3
			x: (+ (/ (* (- (gEgo x:) 158) 46) 32) 158)
			y: 165
			init:
			setPri: 12
		)
		(proc0_10)
	)

	(method (doit)
		(if (== (gEgo onControl: 1) 16384)
			(gEgo setPri: -1)
			(self newRoom: 12)
		)
		(super doit:)
	)
)


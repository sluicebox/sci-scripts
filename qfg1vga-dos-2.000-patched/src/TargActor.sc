;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 812)
(include sci.sh)
(use Main)
(use Feature)
(use Actor)

(class TargActor of Actor
	(properties
		status 0
		targDeltaX 0
		targDeltaY 0
	)

	(method (doit)
		(if
			(and
				(not (IsFlag 281))
				(IsObject global426)
				(not ((global426 script:) register:))
				(self onMe: (global426 x:) (- (global426 y:) 34))
			)
			(switch (global426 view:)
				(522
					(self getHurt: (+ 5 (/ [gEgoStats 23] 3))) ; flameDartSpell
				)
				(524
					(self getHurt: (+ 5 (/ [gEgoStats 0] 10))) ; strength
				)
				(else
					(self getHurt: 1)
				)
			)
			(global426 setPri: 15)
			((global426 script:) changeState: 3)
			(= global426 0)
		)
		(super doit:)
	)

	(method (getHurt))
)

(class TargFeature of Feature
	(properties
		targDeltaX 0
		targDeltaY 0
	)

	(method (getHurt))
)


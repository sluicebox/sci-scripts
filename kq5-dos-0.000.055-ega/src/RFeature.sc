;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 973)
(include sci.sh)
(use Main)
(use Actor)

(class RFeature of Feature
	(properties
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
	)

	(method (init)
		(super init:)
		(self x: (+ nsLeft (/ (+ (- nsRight nsLeft) 1) 2)) y: nsBottom)
	)
)

(class RPicView of PV
	(properties
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
	)

	(method (init &tmp temp0)
		(= temp0 (/ (CelWide view loop cel) 2))
		(= nsBottom (- y z))
		(= nsLeft (- x temp0))
		(= nsRight (+ x temp0))
		(= nsTop (- y (+ z (CelHigh view loop cel))))
		(gCurRoom setFeatures: self)
		(gAddToPics add: self)
	)
)


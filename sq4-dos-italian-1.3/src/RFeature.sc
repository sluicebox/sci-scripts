;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 978)
(include sci.sh)
(use Feature)
(use Actor)

(class RFeature of Feature
	(properties)
)

(class RPicView of PicView
	(properties)

	(method (init &tmp halfWidth)
		(= halfWidth (/ (CelWide view loop cel) 2))
		(= nsBottom (- y z))
		(= nsLeft (- x halfWidth))
		(= nsRight (+ x halfWidth))
		(= nsTop (- y (+ z (CelHigh view loop cel))))
		(super init:)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 812)
(include sci.sh)
(use Motion)
(use Actor)

(class CyclingProp of Prop
	(properties
		signal 16384
	)

	(method (init)
		(self setPri: (if priority priority else -1) setCycle: Fwd)
		(super init:)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 807)
(include sci.sh)
(use Main)
(use System)

(class HandsOffScript of Script
	(properties
		oldIllBits 0
		saveIgnrAct 0
	)

	(method (init)
		(HandsOff)
		(= oldIllBits (gEgo illegalBits:))
		(= saveIgnrAct (& (gEgo signal:) $4000))
		(gEgo illegalBits: 0 ignoreActors: 1)
		(super init: &rest)
	)

	(method (dispose)
		(HandsOn)
		(gEgo illegalBits: oldIllBits ignoreActors: saveIgnrAct)
		(super dispose:)
	)
)


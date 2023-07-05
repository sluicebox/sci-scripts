;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1216)
(include sci.sh)
(use SpinProp)

(public
	cuGourd 0
)

(instance cuGourd of SpinProp
	(properties)

	(method (init)
		(= view (if (== (myInvObj verb:) 152) 20224 else 20225))
		(super init: &rest)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1205)
(include sci.sh)
(use Main)
(use InvInitialize)
(use InvInset)
(use SpinProp)

(public
	cuFilter 0
)

(instance cuFilter of SpinProp
	(properties)

	(method (init)
		(switch (proc70_7 myInvObj)
			(5
				(= view 20006)
			)
			(115
				(= view 20854)
			)
			(123
				(= view 20217)
			)
			(else
				(= view 20261)
			)
		)
		(super init: &rest)
		(self setPri: 200 setHotspot: 136)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(136
				(= temp0 (proc70_6 45))
				(switch (proc70_7 myInvObj)
					(5
						(temp0 cel: 12)
					)
					(115
						(temp0 cel: 14)
					)
					(123
						(temp0 cel: 16)
					)
					(else
						(temp0 cel: 10)
					)
				)
				(proc70_3 (proc70_7 myInvObj))
				(myInvObj owner: 45)
				(temp0 hide:)
				(self myInvObj: 0)
				(gTheCursor setInvCursor: temp0)
				(InvInset resetInvObj: temp0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)


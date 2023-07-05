;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1214)
(include sci.sh)
(use Main)
(use InvInitialize)
(use SpinProp)
(use Feature)
(use Actor)

(public
	cuVideoCam 0
)

(local
	[local0 6] = [-50 -42 -27 -12 6 21]
	[local6 6] = [-64 -58 -54 -54 -53 -57]
	local12
)

(procedure (localproc_0 param1)
	(return (and argc (<= 2 param1 7)))
)

(procedure (localproc_1 param1)
	(return (== (param1 view:) 20917))
)

(instance cuVideoCam of SpinProp
	(properties)

	(method (init)
		(super init: &rest)
		(self setPri: 200)
		(if (localproc_1 self)
			(itemFeat plane: (self plane:) init:)
		)
	)

	(method (doit)
		(if (and (localproc_1 self) (!= oldCel cel))
			(= oldCel cel)
			(cond
				((localproc_0 oldCel)
					(if (not (itemFeat scratch:))
						(itemFeat setHotspot: 2 11)
					)
					(= local12 (- cel 2))
					(itemFeat
						nsLeft: (+ (self x:) [local0 local12])
						nsTop: (+ (self y:) [local6 local12])
						nsRight: (+ (self x:) [local0 local12] 30)
						nsBottom: (+ (self y:) [local6 local12] 30)
					)
				)
				((itemFeat scratch:)
					(itemFeat deleteHotspot:)
				)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor:)
				(gTheCursor hilite:)
			)
			(2
				(if (== view 20917)
					(= view 20918)
					((self myInvObj:) closeView: 20918)
					(proc70_1 27)
					(itemFeat dispose:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(if (and plane ((plane theFtrs:) contains: itemFeat))
			(itemFeat dispose:)
		)
		(super dispose: &rest)
	)
)

(instance itemFeat of Feature
	(properties
		nsLeft 1000
		nsTop 100
		nsRight 1001
		nsBottom 101
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 11)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cuVideoCam doVerb: theVerb &rest)
			)
			(1
				(gTheCursor setTempCursor: handCursor 2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(self deleteHotspot:)
		(super dispose: &rest)
	)
)

(instance handCursor of View
	(properties
		view 600
		cel 10
	)
)


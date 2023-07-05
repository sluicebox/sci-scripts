;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use Feature)
(use Actor)
(use System)

(class TargFeature of Feature
	(properties
		signal 4096
	)

	(method (getHurt))

	(method (init)
		(super init:)
		(if (not gList)
			(= gList ((List new:) add: yourself:))
		)
		(if (not (gList contains: self))
			(gList add: self)
		)
	)

	(method (dispose)
		(gList delete: self)
		(if (and gList (not (gList size:)))
			(gList dispose:)
			(= gList 0)
		)
		(super dispose:)
	)
)

(class TargProp of Prop
	(properties
		signal 4096
	)

	(method (getHurt))

	(method (init)
		(super init:)
		(if (not gList)
			(= gList ((List new:) add: yourself:))
		)
		(if (not (gList contains: self))
			(gList add: self)
		)
	)

	(method (dispose)
		(gList delete: self)
		(if (and gList (not (gList size:)))
			(gList dispose:)
			(= gList 0)
		)
		(super dispose:)
	)
)

(class TargActor of Actor
	(properties
		signal 4096
	)

	(method (getHurt))

	(method (init)
		(super init:)
		(if (not gList)
			(= gList ((List new:) add: yourself:))
		)
		(if (not (gList contains: self))
			(gList add: self)
		)
	)

	(method (dispose)
		(gList delete: self)
		(if (and gList (not (gList size:)))
			(gList dispose:)
			(= gList 0)
		)
		(super dispose:)
	)
)


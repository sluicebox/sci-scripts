;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64950)
(include sci.sh)
(use Main)
(use Rectangle)
(use WriteFeature)
(use PlaneManager)

(class Feature of Obj
	(properties
		state 512
		plane 0
		priority -1
		responder 0
		target 0
	)

	(method (init param1 param2 param3 param4 param5 param6)
		(= plane
			(cond
				((and argc param1) param1)
				(plane plane)
				(else gThePlane)
			)
		)
		(if (> argc 1)
			(if (!= param2 -1)
				(= priority param2)
			)
			(cond
				((and (< argc 4) (> argc 2))
					(self addTarget: param3)
				)
				((> argc 2)
					(= target (Rectangle new: param3 param4 param5 param6))
				)
			)
		)
		(if (== priority -1)
			(= priority (plane bottom:))
		)
		(if (not target)
			(= target
				(Rectangle
					new:
						(plane left:)
						(plane top:)
						(plane right:)
						(plane bottom:)
				)
			)
		)
		((plane cast:) add: self)
		(super init:)
	)

	(method (dispose)
		(if target
			(target dispose:)
		)
		(if responder
			(responder dispose:)
		)
		((plane cast:) delete: self)
		(= responder (= plane (= target 0)))
		(super dispose:)
	)

	(method (addTarget param1 &tmp temp0)
		(if (or (not argc) (not (param1 respondsTo: #onMe)))
			(PrintDebug {Invalid target for %s(%d)\n} name self)
			(SetDebug self)
		)
		(if target
			(if (target isKindOf: OnMeList)
				(target add: param1)
			else
				(= temp0 (OnMeList new:))
				(temp0 add: target param1)
				(= target temp0)
			)
		else
			(= target param1)
		)
	)

	(method (handleEvent event)
		(if responder
			(responder handleEvent: event &rest)
		else
			(event claimed: self)
		)
	)

	(method (isHot param1)
		(if argc
			(cond
				(param1
					(if (not (& state $1000))
						(|= state $1000)
						(if (and plane (plane respondsTo: #hotObject))
							((plane cast:) addHot: self 1)
						)
					)
				)
				((& state $1000)
					(&= state $efff)
					(if (and plane (plane respondsTo: #hotObject))
						((plane cast:) addHot: self 0)
					)
				)
			)
		)
		(return (& state $1000))
	)

	(method (onMe)
		(return (target onMe: &rest))
	)
)


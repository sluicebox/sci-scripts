;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64943)
(include sci.sh)
(use Cel)
(use PlaneManager)

(class View of Cel
	(properties
		state 1792
		responder 0
		target 0
		script 0
	)

	(method (dispose)
		(if responder
			(responder dispose:)
			(= responder 0)
		)
		(if script
			(script dispose:)
		)
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

	(method (doit)
		(if (and (& -info- $0008) (not (& signal $0008)))
			(self update:)
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

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				(target
					(target onMe: temp0 temp1)
				)
				((& signal $0008) 0)
				((& signal $1000)
					(super onMe: temp0 temp1)
				)
				(else
					(IsOnMe temp0 temp1 self 1)
				)
			)
		)
	)

	(method (setLoop param1 param2 param3)
		(cond
			((not argc)
				(|= signal $0800)
			)
			((== param1 -1)
				(&= signal $f7ff)
			)
			(else
				(= loop param1)
				(if (> argc 1)
					(if param2
						(|= signal $0800)
					else
						(&= signal $f7ff)
					)
				)
			)
		)
		(if (and (> argc 2) param3)
			(self update:)
		)
	)

	(method (setScript param1)
		(if script
			(script dispose:)
		)
		(if (and argc param1)
			(param1 init: self &rest)
		)
	)
)


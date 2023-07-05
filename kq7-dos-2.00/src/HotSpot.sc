;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use useObj)
(use Motion)
(use System)

(public
	HotSpot 0
)

(class HotSpot of Obj
	(properties
		_respondVerbs 0
		theVerb 0
	)

	(method (setProps param1)
		(if (== [param1 0] 9998)
			(= _respondVerbs -1)
			(= theVerb 8)
		else
			(= theVerb [param1 0])
			(if (> argc 1)
				(self respondVerbs: &rest)
			)
		)
	)

	(method (addRespondVerb param1 &tmp temp0 temp1)
		(if (and argc gKqRespondCode [param1 0])
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				((ScriptID 0 4) addToEnd: [param1 temp0]) ; respondSet
				(= temp1 (gKqRespondCode doit: [param1 temp0]))
				(self _respondVerbs: (| (self _respondVerbs:) temp1))
			)
		)
	)

	(method (doit)
		(cond
			(global308
				(if (gUser useHotspots:)
					(if (global308 isMemberOf: useObj)
						(gTheCursor
							view: (global308 myCursorView:)
							loop: (global308 myCursorLoop:)
							setCel:
								(Max 0 (- (global308 myCursorCel:) 1))
						)
					else
						(gTheCursor
							view: (global308 cView:)
							loop: (global308 cLoop:)
							setCel: (Max 0 (- (global308 cCel:) 1))
						)
					)
				)
				(gUser message: (global308 verb:))
			)
			((not (global311 respondsTo: #exitDir))
				(if (gUser useHotspots:)
					(if (== gTheCursor gNormalCursor)
						(gTheCursor
							view: 999
							loop: 0
							setCycle: Fwd
							cycleSpeed: 6
							init:
						)
					else
						(gTheCursor view: 999 loop: 0 setCel: 0)
					)
				)
				(gUser message: theVerb)
			)
			(else
				(if (gUser useHotspots:)
					(if (== gTheCursor gNormalCursor)
						(gTheCursor
							view: 989
							loop: (global311 exitDir:)
							setCycle: 0
							setCel: 0
						)
					else
						(gTheCursor
							view: 989
							loop: (global311 exitDir:)
							setCel: 0
						)
					)
				)
				(gUser message: theVerb)
			)
		)
		(= global331 gTheCursor)
	)

	(method (respondVerbs param1 &tmp temp0 temp1)
		(if (!= [param1 0] 9999)
			(= _respondVerbs 0)
		)
		(if (and argc gKqRespondCode [param1 0])
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(if (== [param1 temp0] 9999)
					(Empty)
				else
					((ScriptID 0 4) addToEnd: [param1 temp0]) ; respondSet
					(= temp1 (gKqRespondCode doit: [param1 temp0]))
					(self _respondVerbs: (| (self _respondVerbs:) temp1))
				)
			)
		)
	)

	(method (deleteVerbs param1 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(if (== [param1 temp0] 9999)
				(Empty)
			else
				(= temp1 (gKqRespondCode doit: [param1 temp0]))
				(self _respondVerbs: (& (self _respondVerbs:) (~ temp1)))
			)
		)
	)
)


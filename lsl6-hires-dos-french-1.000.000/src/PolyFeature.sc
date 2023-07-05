;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Feature)
(use System)

(class PolyFeature of Feature
	(properties
		y 5
		listObj 0
		variableX 0
		variableY 0
	)

	(method (addPolygon param1 &tmp temp0)
		(cond
			(([param1 0] isKindOf: Collect)
				(= listObj [param1 0])
				(return)
			)
			((not listObj)
				((= listObj (Set new:)) add:)
			)
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(listObj add: [param1 temp0])
			(if (not ([param1 temp0] points:))
				([param1 temp0] init:)
			)
		)
	)

	(method (onMe param1 &tmp temp0 temp1 temp2)
		(for
			((= temp1 (listObj first:)))
			temp1
			((= temp1 (listObj next: temp1)))
			
			(= temp2 (NodeValue temp1))
			(if (temp2 onMe: (param1 x:) (param1 y:))
				(if variableX
					(= x (param1 x:))
				)
				(if variableY
					(= y (param1 y:))
				)
				(return 1)
			)
		)
		(return 0)
	)

	(method (dispose)
		(if listObj
			(listObj dispose:)
		)
		(super dispose:)
	)
)


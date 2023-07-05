;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use DuneMover)
(use Feature)
(use System)

(public
	Dune 0
)

(class DuneHandler of EventHandler
	(properties
		curDune 0
		oldWalkHandler 0
	)

	(method (init)
		(super init: &rest)
		(= oldWalkHandler gWalkHandler)
		(= gWalkHandler self)
		(if (not elements)
			(= elements (NewList))
		)
	)

	(method (dispose)
		(= gWalkHandler oldWalkHandler)
		(super dispose: &rest)
	)

	(method (add param1 &tmp temp0)
		(if (not elements)
			(self init:)
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(if ([param1 temp0] isKindOf: Dune)
				(if (not (self isDuplicate: [param1 temp0]))
					(AddToEnd elements (NewNode [param1 temp0] [param1 temp0]))
					(++ size)
					([param1 temp0] duneNumber: size)
				)
			else
				(oldWalkHandler add: [param1 temp0])
			)
		)
		(return self)
	)

	(method (delete param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(if ([param1 temp0] isKindOf: Dune)
				(if (and nextNode (== [param1 temp0] (NodeValue nextNode)))
					(= nextNode (NextNode (FindKey elements [param1 temp0])))
				)
				(if (DeleteKey elements [param1 temp0])
					(-- size)
				)
			else
				(oldWalkHandler delete: [param1 temp0])
			)
		)
		(return self)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(if
			(or
				(event claimed:)
				(self checkDunes: event)
				(oldWalkHandler handleEvent: event)
			)
			(= temp0 1)
		)
		(return temp0)
	)

	(method (checkDunes param1 &tmp temp0)
		(if
			(and
				(= temp0 (self firstTrue: #handleEvent param1))
				(temp0 isKindOf: Dune)
			)
			(gEgo setMotion: DuneMover (param1 x:) (param1 y:))
			(param1 claimed: 1)
		)
		(= temp0 0)
		(param1 claimed:)
	)

	(method (setup param1 &tmp temp0 temp1)
		(if (not argc)
			(= temp1 gEgo)
		else
			(= temp1 param1)
		)
		(= temp0 0)
		(if (>= argc 2)
			(= temp0 [param1 1])
		)
		(if (not temp0)
			(if (= temp0 (self firstTrue: #onMe (temp1 x:) (temp1 y:)))
				(if (== temp1 gEgo)
					(= curDune temp0)
				)
				(temp0 switchDune: temp1 0 0)
				(temp1
					scaleSignal: (| (temp1 scaleSignal:) $0001)
					scaleX: (temp0 duneScaleSize:)
					scaleY: (temp0 duneScaleSize:)
				)
			)
		else
			(temp0 switchDune: temp1 2 (temp0 egoOnBackside:))
		)
	)

	(method (getMoveToDune param1 param2)
		(self firstTrue: #onMe param1 param2)
	)
)

(class Dune of Feature
	(properties
		backPri -1
		forePri -1
		egoOnBackside 0
		ridgeValleyPoly 0
		roomPoly 0
		duneNumber 0
		duneScaleSize 128
	)

	(method (dispose &tmp temp0)
		(if ridgeValleyPoly
			(ridgeValleyPoly dispose:)
		)
		(if roomPoly
			(roomPoly dispose:)
		)
		(super dispose:)
	)

	(method (setPri param1)
		(if argc
			(= forePri [param1 0])
			(= backPri [param1 1])
		else
			(gEgo setPri: (if egoOnBackside backPri else forePri))
		)
	)

	(method (switchDune param1 param2 param3 &tmp [temp0 2])
		(if param3
			(param1 setLoop: setPri: backPri)
		else
			(param1 setLoop: -1 setPri: forePri)
		)
	)

	(method (findRidge param1 &tmp temp0 temp1)
		(for ((= temp0 -1)) (< temp0 200) ((++ temp0))
			(cond
				((ridgeValleyPoly isKindOf: List)
					(if (ridgeValleyPoly firstTrue: #onMe param1 temp0)
						(= temp1 1)
						(break)
					)
				)
				((ridgeValleyPoly onMe: param1 temp0)
					(= temp1 1)
					(break)
				)
			)
		)
		(return (if temp1 temp0 else -1))
	)

	(method (findValley param1 &tmp temp0 temp1)
		(for ((= temp0 200)) (> temp0 -1) ((-- temp0))
			(cond
				((ridgeValleyPoly isKindOf: List)
					(if (ridgeValleyPoly firstTrue: #onMe param1 temp0)
						(break)
					)
				)
				((ridgeValleyPoly onMe: param1 temp0)
					(break)
				)
			)
		)
		(return temp0)
	)
)


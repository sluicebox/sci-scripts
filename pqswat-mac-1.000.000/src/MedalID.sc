;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use ExitButton)
(use Str)
(use File)
(use System)

(class MedalID of Obj
	(properties
		dirExt 0
		medalMask 0
	)

	(method (writeData param1 &tmp temp0)
		(= temp0 (Str new:))
		(proc4_7 temp0 0 dirExt)
		(param1 write: temp0 2)
		(proc4_7 temp0 0 medalMask)
		(param1 write: temp0 2)
		(temp0 dispose:)
	)
)

(class MedalList of List
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (Str format: {%s%s} (gCurSaveDir data:) {medals.dat}))
		(if (= temp1 (FileIO fiEXISTS (temp0 data:)))
			(= temp3 (Str new: 10))
			(= temp5 (Str new: 10))
			((= temp2 (File new:)) name: (temp0 data:) open: 1 read: temp3 2)
			(while (!= (proc4_8 temp3 0) -1)
				(temp2 read: temp5 2)
				(self
					addToEnd:
						((= temp4 (MedalID new:))
							dirExt: (proc4_8 temp3 0)
							medalMask: (proc4_8 temp5 0)
							yourself:
						)
				)
				(temp2 read: temp3 2)
			)
			(temp3 dispose:)
			(temp5 dispose:)
			(temp2 close: dispose:)
		)
		(temp0 dispose:)
		(return temp1)
	)

	(method (add param1 &tmp temp0 temp1 temp2)
		(if (not elements)
			(= elements (KList 0)) ; New
		)
		((= temp2 (MedalID new:)) dirExt: param1 medalMask: (gEgo medals:))
		(if (not (self isDuplicate: (temp2 dirExt:)))
			(KList 11 elements (KList 2 temp2 temp2)) ; AddToEnd, NewNode
			(++ size)
		)
		(return temp1) ; UNINIT
	)

	(method (isDuplicate param1 &tmp temp0 temp1 temp2)
		(= temp2 0)
		(for ((= temp0 (KList 3 elements))) temp0 ((= temp0 (KList 6 temp0))) ; FirstNode, NextNode
			(= temp1 (KList 8 temp0)) ; NodeValue
			(if (= temp2 (== (temp1 dirExt:) param1))
				(break)
			)
		)
		(return temp2)
	)

	(method (deleteID param1 &tmp temp0 temp1 temp2 temp3)
		(if (>= param1 size)
			(return)
		)
		(= temp0 0)
		(for ((= temp3 (KList 3 elements))) temp3 ((= temp3 (KList 6 temp3))) ; FirstNode, NextNode
			(= temp0 (KList 8 temp3)) ; NodeValue
			(if (== (temp0 dirExt:) param1)
				(break)
			)
		)
		(self delete: temp0)
		(temp0 dispose:)
		(if size
			(self write:)
		else
			(= temp2 (Str format: {%s%s} (gCurSaveDir data:) {medals.dat}))
			((= temp1 (File new:)) name: (temp2 data:) delete: dispose:)
			(temp2 dispose:)
		)
	)

	(method (select param1 &tmp temp0 temp1)
		(if (not elements)
			(return)
		)
		(for ((= temp1 (KList 3 elements))) temp1 ((= temp1 (KList 6 temp1))) ; FirstNode, NextNode
			(= temp0 (KList 8 temp1)) ; NodeValue
			(if (== (temp0 dirExt:) param1)
				(break)
			)
		)
		(return
			(if temp0
				(temp0 medalMask:)
			else
				0
			)
		)
	)

	(method (write &tmp temp0 temp1 temp2 [temp3 2] temp5)
		(= temp0 (Str format: {%s%s} (gCurSaveDir data:) {medals.dat}))
		((= temp2 (File new:)) name: (temp0 data:) open: 2)
		(self eachElementDo: #writeData temp2)
		(= temp5 (Str new: 2))
		(temp5 at: 0 -1 -1)
		(temp2 write: temp5 2 close: dispose:)
		(temp5 dispose:)
		(temp0 dispose:)
	)
)


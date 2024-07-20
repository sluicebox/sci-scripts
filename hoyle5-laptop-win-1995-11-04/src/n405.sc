;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 405)
(include sci.sh)

(public
	proc405_0 0
)

(procedure (proc405_0 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp4 param1)
	(temp4 base1GroupNum: 0 base2GroupNum: 0 base3GroupNum: 0)
	(for ((= temp0 0)) (< temp0 (temp4 size:)) ((++ temp0))
		(= temp2 (temp4 at: temp0))
		(if (= temp1 (temp2 bestGroup:))
			(temp2 theGroup: temp1 rating: 0)
			(cond
				(
					(or
						(not (temp4 base1GroupNum:))
						(== temp1 (temp4 base1GroupNum:))
					)
					(temp4 base1GroupNum: temp1)
					((temp4 group1List:) add: temp2)
				)
				(
					(or
						(not (temp4 base2GroupNum:))
						(== temp1 (temp4 base2GroupNum:))
					)
					(temp4 base2GroupNum: temp1)
					((temp4 group2List:) add: temp2)
				)
				(else
					(temp4 base3GroupNum: temp1)
					((temp4 group3List:) add: temp2)
				)
			)
		else
			(temp2 rating: 1 theGroup: 0)
			((temp4 deadWoodList:) add: temp2)
		)
	)
)


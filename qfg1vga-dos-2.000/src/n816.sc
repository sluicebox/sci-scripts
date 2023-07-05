;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 816)
(include sci.sh)
(use Main)
(use Polygon)
(use System)

(public
	proc816_0 0
	proc816_1 1
)

(procedure (proc816_0 param1 param2 &tmp temp0 temp1 temp2)
	(if (< argc 2)
		(= param2 2)
	)
	(= temp1 (gCurRoom obstacles:))
	(= temp0 (MergePoly param1 (temp1 elements:) (temp1 size:)))
	(= temp2
		((Polygon new:)
			points: temp0
			size: (localproc_0 temp0)
			type: param2
			dynamic: 1
			yourself:
		)
	)
	(temp1 add: temp2)
	(return temp2)
)

(procedure (proc816_1 param1 &tmp temp0 temp1 temp2) ; UNUSED
	(= temp0 (gCurRoom obstacles:))
	(temp0 delete: param1)
	(for ((= temp1 0)) (< temp1 (temp0 size:)) ((++ temp1))
		(if (>= (= temp2 ((temp0 at: temp1) type:)) 16)
			((temp0 at: temp1) type: (- temp2 16))
		)
	)
)

(procedure (localproc_0 param1 &tmp temp0 [temp1 2] temp3 temp4)
	(= temp3 -100)
	(for ((= temp0 0)) (!= temp3 30583) ((++ temp0))
		(= temp3 (WordAt param1 (* 2 temp0)))
	)
	(-- temp0)
)


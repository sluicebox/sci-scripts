;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64899)
(include sci.sh)
(use Main)
(use PolyPath)
(use Motion)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
	(= temp0 (param1 client:))
	(= temp1 (Abs (= temp2 (- (param1 x:) (temp0 x:)))))
	(= temp5 (Abs (= temp6 (- (param1 y:) (temp0 y:)))))
	(= temp3 (temp0 xStep:))
	(= temp11
		(if (= temp7 (temp0 yStep:))
			1
		else
			(temp0 yMod:)
		)
	)
	(= temp4 (/ (+ temp1 temp3 -1) temp3))
	(= temp8 (* temp11 temp5))
	(= temp10 (> temp4 temp8))
	(param1 b-i1: (if temp10 temp8 else temp4))
	(param1 b-i2: (= temp9 (if temp10 temp4 else temp8)))
	(param1 b-di: (* -1 (/ (++ temp9) 2)))
	(if (<= temp2 0)
		(= temp3
			(if temp2
				(* temp3 -1)
			else
				0
			)
		)
	)
	(= temp7
		(if temp6
			(if (> temp6 0) 1 else -1)
		else
			0
		)
	)
	(param1 dx: temp3)
	(param1 dy: temp7)
	(param1 b-incr: temp11)
	(param1 b-cnt: 0)
	(param1 b-xAxis: temp10)
	(param1 b-DX: temp1)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
	(= temp0 (= temp1 0))
	(= temp9 (param1 b-cnt:))
	(= temp2 (+ (param1 b-di:) (param1 b-i1:)))
	(if (param1 b-xAxis:)
		(= temp0 (param1 dx:))
		(if (>= temp2 0)
			(-= temp2 (param1 b-i2:))
			(= temp4 (mod (+ temp9 1) (param1 b-incr:)))
			(param1 b-cnt: temp4)
			(if (not temp4)
				(= temp1 (param1 dy:))
			)
		)
	else
		(= temp4 (mod (+ temp9 1) (param1 b-incr:)))
		(param1 b-cnt: temp4)
		(if (not temp4)
			(= temp1 (param1 dy:))
		)
		(if (>= temp2 0)
			(-= temp2 (param1 b-i2:))
			(= temp0 (param1 dx:))
		)
	)
	(= temp5 (param1 client:))
	(if temp1
		(temp5 y: (+ (temp5 y:) temp1))
	)
	(if temp0
		(= temp6 (param1 b-DX:))
		(if (and (> (= temp7 (Abs temp0)) 1) (> temp7 temp6))
			(= temp7 temp6)
			(= temp0
				(if (< temp0 0)
					(* temp7 -1)
				else
					temp7
				)
			)
		)
		(param1 b-DX: (- temp6 temp7))
		(temp5 x: (+ (temp5 x:) temp0))
	)
	(if (= temp8 (temp5 cantBeHere:))
		(temp5 x: (- (temp5 x:) temp0))
		(temp5 y: (- (temp5 y:) temp1))
		(param1 b-cnt: temp9)
		(temp5 signal: (| (temp5 signal:) $0400))
	else
		(param1 b-di: temp2)
		(if (and (== (temp5 x:) (param1 x:)) (== (temp5 y:) (param1 y:)))
			(param1 moveDone:)
		)
	)
	(return temp8)
)

(class SMoveTo of MoveTo
	(properties
		b-cnt 0
		b-DX 0
	)

	(method (init)
		(super init: &rest)
		(localproc_0 self)
	)

	(method (doit &tmp [temp0 6])
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(localproc_1 self)
		)
	)
)

(class SPolyPath of PolyPath
	(properties
		b-cnt 0
		b-DX 0
	)

	(method (init)
		(super init: &rest)
		(localproc_0 self)
	)

	(method (doit &tmp [temp0 6])
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(localproc_1 self)
		)
	)
)

(class SMoveFwd of SPolyPath
	(properties)

	(method (init param1 param2 param3)
		(if argc
			(super
				init:
					param1
					(+ (param1 x:) (SinMult (param1 heading:) param2))
					(- (param1 y:) (CosMult (param1 heading:) param2))
					(and (>= argc 3) param3)
			)
		else
			(super init:)
		)
	)
)


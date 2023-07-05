;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 501)
(include sci.sh)
(use Main)
(use unknown_500_0)

(public
	unknown_501_0 0
	unknown_501_1 1
	unknown_501_2 2
	unknown_501_3 3
	unknown_501_4 4
	unknown_501_5 5
	unknown_501_6 6
	unknown_501_7 7
	unknown_501_8 8
	unknown_501_9 9
	unknown_501_10 10
	unknown_501_11 11
)

(procedure (localproc_0 &tmp temp0)
	(= temp0 0)
	(= global506 0)
	(if
		(and
			((global178 sel_64: 1) sel_655:)
			((global178 sel_64: 2) sel_655:)
			((global178 sel_64: 3) sel_655:)
		)
		(= global506 2)
		(= temp0 (Class_500_4 sel_682:))
	)
	(if
		(and
			((global178 sel_64: 2) sel_655:)
			((global178 sel_64: 3) sel_655:)
			((global178 sel_64: 4) sel_655:)
		)
		(= global506 3)
		(= temp0 (Class_500_4 sel_682:))
	)
	(return temp0)
)

(procedure (localproc_1 &tmp temp0)
	(= temp0 0)
	(= global506 0)
	(if (and ((global178 sel_64: 0) sel_655:) ((global178 sel_64: 4) sel_655:))
		(if
			(and
				((global178 sel_64: 1) sel_655:)
				((global178 sel_64: 2) sel_655:)
				(not ((global178 sel_64: 3) sel_655:))
			)
			(= global506 45)
		)
		(if
			(and
				((global178 sel_64: 1) sel_655:)
				((global178 sel_64: 3) sel_655:)
				(not ((global178 sel_64: 2) sel_655:))
			)
			(= global506 35)
		)
		(if
			(and
				((global178 sel_64: 2) sel_655:)
				((global178 sel_64: 3) sel_655:)
				(not ((global178 sel_64: 1) sel_655:))
			)
			(= global506 25)
		)
	)
	(if (and ((global178 sel_64: 1) sel_655:) ((global178 sel_64: 5) sel_655:))
		(if
			(and
				((global178 sel_64: 3) sel_655:)
				((global178 sel_64: 2) sel_655:)
				(not ((global178 sel_64: 4) sel_655:))
			)
			(= global506 56)
		)
		(if
			(and
				((global178 sel_64: 2) sel_655:)
				((global178 sel_64: 4) sel_655:)
				(not ((global178 sel_64: 3) sel_655:))
			)
			(= global506 46)
		)
		(if
			(and
				((global178 sel_64: 4) sel_655:)
				((global178 sel_64: 3) sel_655:)
				(not ((global178 sel_64: 2) sel_655:))
			)
			(= global506 36)
		)
	)
	(if (> global506 0)
		(= temp0 (Class_500_4 sel_682:))
	)
	(return temp0)
)

(procedure (localproc_2 &tmp temp0)
	(= temp0 0)
	(if (== ((global178 sel_64: 8) sel_657:) 2)
		(= temp0 2)
	)
	(return temp0)
)

(procedure (localproc_3 &tmp temp0)
	(= temp0 0)
	(= global506 0)
	(if
		(and
			(== global501 global502 global503)
			(!= global503 global504)
			(!= global503 global505)
		)
		(= global506 1)
	)
	(if
		(and
			(== global502 global503 global504)
			(!= global501 global502)
			(!= global504 global505)
		)
		(= global506 2)
	)
	(if
		(and
			(== global503 global504 global505)
			(!= global501 global503)
			(!= global502 global503)
		)
		(= global506 3)
	)
	(if (> global506 0)
		(= temp0 global503)
		(-= global506 1)
	)
	(return temp0)
)

(procedure (localproc_4 &tmp temp0)
	(= temp0 0)
	(= global506 0)
	(if
		(or
			(and
				(== global501 global502)
				(== global503 global504)
				(!= global502 global503)
				(!= global504 global505)
			)
			(and
				(== global501 global502)
				(== global504 global505)
				(!= global502 global503)
				(!= global503 global504)
			)
			(and
				(== global502 global503)
				(== global504 global505)
				(!= global501 global502)
				(!= global503 global504)
			)
		)
		(= temp0 global504)
		(= global506 global502)
	)
	(return temp0)
)

(procedure (localproc_5 &tmp temp0 temp1)
	(= temp0 0)
	(= global506 0)
	(if
		(and
			(== global501 global502)
			(!= global502 global503)
			(!= global502 global504)
			(!= global502 global505)
		)
		(= temp0 global501)
		(= temp1 1)
	)
	(if
		(and
			(== global502 global503)
			(!= global501 global502)
			(!= global503 global504)
			(!= global503 global505)
		)
		(= temp0 global502)
		(= temp1 2)
	)
	(if
		(and
			(== global503 global504)
			(!= global501 global503)
			(!= global502 global503)
			(!= global504 global505)
		)
		(= temp0 global503)
		(= temp1 3)
	)
	(if
		(and
			(== global504 global505)
			(!= global501 global504)
			(!= global502 global504)
			(!= global503 global504)
		)
		(= temp0 global504)
		(= temp1 4)
	)
	(if (> temp0 0)
		(= global506 (- temp1 1))
	)
	(return temp0)
)

(procedure (localproc_6 param1 &tmp temp0 temp1)
	(= temp1 0)
	(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
		(if
			(and
				(== param1 (+ temp0 1))
				(== ((global178 sel_64: temp0) sel_656:) -1)
			)
			(= temp1 1)
		)
	)
	(return temp1)
)

(procedure (localproc_7 &tmp temp0 temp1)
	(= temp1 0)
	(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
		(if
			(and
				(> ((global178 sel_64: temp0) sel_655:) 0)
				(== ((global178 sel_64: temp0) sel_656:) -1)
				(> ((global178 sel_64: temp0) sel_655:) temp1)
			)
			(= temp1 ((global178 sel_64: temp0) sel_656:))
		)
	)
	(return temp1)
)

(procedure (localproc_8 &tmp temp0 temp1)
	(= temp1 0)
	(for ((= temp0 6)) (<= temp0 10) ((++ temp0))
		(if
			(and
				(> ((global178 sel_64: temp0) sel_655:) 0)
				(== ((global178 sel_64: temp0) sel_656:) -1)
			)
			(++ temp1)
		)
	)
	(return temp1)
)

(instance unknown_501_0 of Class_500_0
	(properties
		sel_0 36
		sel_3 1
		sel_659 1
	)

	(method (sel_662)
		(= sel_655 (= sel_657 0))
		(= sel_655 (Class_500_4 sel_684: gUnknown_501_0 1))
		(= sel_657 1)
		(return sel_657)
	)

	(method (sel_663)
		(if (== sel_656 -1)
			(= sel_658 0)
			(if (or (== (global178 sel_527:) 0) (== (global178 sel_527:) 1))
				(switch sel_655
					(0
						(= sel_658 6)
					)
					(1
						(= sel_658 10)
					)
					(2
						(= sel_658 20)
					)
					(3
						(= sel_658 30)
					)
					(4
						(= sel_658 35)
					)
					(5
						(= sel_658 40)
					)
				)
			)
			(if (== (global178 sel_527:) 2)
				(if (== (global178 sel_671:) 0)
					(switch sel_655
						(0
							(= sel_658 12)
						)
						(1
							(= sel_658 16)
						)
						(2
							(= sel_658 26)
						)
						(3
							(= sel_658 30)
						)
						(4
							(= sel_658 35)
						)
						(5
							(= sel_658 40)
						)
					)
				)
				(if (== (global178 sel_671:) 1)
					(switch sel_655
						(0
							(= sel_658 12)
						)
						(1
							(= sel_658 16)
						)
						(2
							(= sel_658 26)
						)
						(3
							(= sel_658 30)
						)
						(4
							(= sel_658 35)
						)
						(5
							(= sel_658 40)
						)
					)
				)
				(if (== (global178 sel_671:) 2)
					(switch sel_655
						(0
							(= sel_658 12)
						)
						(1
							(= sel_658 16)
						)
						(2
							(= sel_658 21)
						)
						(3
							(= sel_658 30)
						)
						(4
							(= sel_658 35)
						)
						(5
							(= sel_658 40)
						)
					)
				)
			)
			(return sel_658)
		)
	)
)

(instance unknown_501_1 of Class_500_0
	(properties
		sel_0 47
		sel_3 2
		sel_659 2
	)

	(method (sel_662)
		(= sel_655 (= sel_657 0))
		(= sel_655 (Class_500_4 sel_684: gUnknown_501_1 2))
		(= sel_657 2)
		(return sel_657)
	)

	(method (sel_663)
		(if (== sel_656 -1)
			(= sel_658 0)
			(if (or (== (global178 sel_527:) 0) (== (global178 sel_527:) 1))
				(switch sel_655
					(0
						(= sel_658 5)
					)
					(2
						(= sel_658 11)
					)
					(4
						(= sel_658 21)
					)
					(6
						(= sel_658 30)
					)
					(8
						(= sel_658 35)
					)
					(10
						(= sel_658 40)
					)
				)
			)
			(if (== (global178 sel_527:) 2)
				(if (== (global178 sel_671:) 0)
					(switch sel_655
						(0
							(= sel_658 9)
						)
						(2
							(= sel_658 15)
						)
						(4
							(= sel_658 25)
						)
						(6
							(= sel_658 30)
						)
						(8
							(= sel_658 35)
						)
						(10
							(= sel_658 40)
						)
					)
				)
				(if (== (global178 sel_671:) 1)
					(switch sel_655
						(0
							(= sel_658 9)
						)
						(2
							(= sel_658 15)
						)
						(4
							(= sel_658 25)
						)
						(6
							(= sel_658 30)
						)
						(8
							(= sel_658 35)
						)
						(10
							(= sel_658 40)
						)
					)
				)
				(if (== (global178 sel_671:) 2)
					(switch sel_655
						(0
							(= sel_658 9)
						)
						(2
							(= sel_658 15)
						)
						(4
							(= sel_658 22)
						)
						(6
							(= sel_658 30)
						)
						(8
							(= sel_658 35)
						)
						(10
							(= sel_658 40)
						)
					)
				)
			)
			(return sel_658)
		)
	)
)

(instance unknown_501_2 of Class_500_0
	(properties
		sel_0 58
		sel_3 3
		sel_659 3
	)

	(method (sel_662)
		(= sel_655 (= sel_657 0))
		(= sel_655 (Class_500_4 sel_684: gUnknown_501_2 3))
		(= sel_657 3)
		(return sel_657)
	)

	(method (sel_663)
		(if (== sel_656 -1)
			(= sel_658 0)
			(if (or (== (global178 sel_527:) 0) (== (global178 sel_527:) 1))
				(switch sel_655
					(0
						(= sel_658 4)
					)
					(3
						(= sel_658 12)
					)
					(6
						(= sel_658 22)
					)
					(9
						(= sel_658 30)
					)
					(12
						(= sel_658 35)
					)
					(15
						(= sel_658 40)
					)
				)
			)
			(if (== (global178 sel_527:) 2)
				(if (== (global178 sel_671:) 0)
					(switch sel_655
						(0
							(= sel_658 8)
						)
						(3
							(= sel_658 14)
						)
						(6
							(= sel_658 24)
						)
						(9
							(= sel_658 30)
						)
						(12
							(= sel_658 35)
						)
						(15
							(= sel_658 40)
						)
					)
				)
				(if (== (global178 sel_671:) 1)
					(switch sel_655
						(0
							(= sel_658 8)
						)
						(3
							(= sel_658 14)
						)
						(6
							(= sel_658 24)
						)
						(9
							(= sel_658 30)
						)
						(12
							(= sel_658 35)
						)
						(15
							(= sel_658 40)
						)
					)
				)
				(if (== (global178 sel_671:) 2)
					(switch sel_655
						(0
							(= sel_658 8)
						)
						(3
							(= sel_658 14)
						)
						(6
							(= sel_658 23)
						)
						(9
							(= sel_658 30)
						)
						(12
							(= sel_658 35)
						)
						(15
							(= sel_658 40)
						)
					)
				)
			)
			(return sel_658)
		)
	)
)

(instance unknown_501_3 of Class_500_0
	(properties
		sel_0 69
		sel_3 4
		sel_659 4
	)

	(method (sel_662)
		(= sel_655 (= sel_657 0))
		(= sel_655 (Class_500_4 sel_684: gUnknown_501_3 4))
		(= sel_657 4)
		(return sel_657)
	)

	(method (sel_663)
		(if (== sel_656 -1)
			(= sel_658 0)
			(if (or (== (global178 sel_527:) 0) (== (global178 sel_527:) 1))
				(switch sel_655
					(0
						(= sel_658 3)
					)
					(4
						(= sel_658 13)
					)
					(8
						(= sel_658 23)
					)
					(12
						(= sel_658 30)
					)
					(16
						(= sel_658 35)
					)
					(20
						(= sel_658 40)
					)
				)
			)
			(if (== (global178 sel_527:) 2)
				(if (== (global178 sel_671:) 0)
					(switch sel_655
						(0
							(= sel_658 7)
						)
						(4
							(= sel_658 13)
						)
						(8
							(= sel_658 23)
						)
						(12
							(= sel_658 30)
						)
						(16
							(= sel_658 35)
						)
						(20
							(= sel_658 40)
						)
					)
				)
				(if (== (global178 sel_671:) 1)
					(switch sel_655
						(0
							(= sel_658 7)
						)
						(4
							(= sel_658 13)
						)
						(8
							(= sel_658 23)
						)
						(12
							(= sel_658 30)
						)
						(16
							(= sel_658 35)
						)
						(20
							(= sel_658 40)
						)
					)
				)
				(if (== (global178 sel_671:) 2)
					(switch sel_655
						(0
							(= sel_658 7)
						)
						(4
							(= sel_658 13)
						)
						(8
							(= sel_658 24)
						)
						(12
							(= sel_658 30)
						)
						(16
							(= sel_658 35)
						)
						(20
							(= sel_658 40)
						)
					)
				)
			)
			(return sel_658)
		)
	)
)

(instance unknown_501_4 of Class_500_0
	(properties
		sel_0 80
		sel_3 5
		sel_659 5
	)

	(method (sel_662)
		(= sel_655 (= sel_657 0))
		(= sel_655 (Class_500_4 sel_684: gUnknown_501_4 5))
		(= sel_657 5)
		(return sel_657)
	)

	(method (sel_663)
		(if (== sel_656 -1)
			(= sel_658 0)
			(if (or (== (global178 sel_527:) 0) (== (global178 sel_527:) 1))
				(switch sel_655
					(0
						(= sel_658 2)
					)
					(5
						(= sel_658 14)
					)
					(10
						(= sel_658 24)
					)
					(15
						(= sel_658 30)
					)
					(20
						(= sel_658 35)
					)
					(25
						(= sel_658 40)
					)
				)
			)
			(if (== (global178 sel_527:) 2)
				(if (== (global178 sel_671:) 0)
					(switch sel_655
						(0
							(= sel_658 6)
						)
						(5
							(= sel_658 12)
						)
						(10
							(= sel_658 22)
						)
						(15
							(= sel_658 30)
						)
						(20
							(= sel_658 35)
						)
						(25
							(= sel_658 40)
						)
					)
				)
				(if (== (global178 sel_671:) 1)
					(switch sel_655
						(0
							(= sel_658 6)
						)
						(5
							(= sel_658 12)
						)
						(10
							(= sel_658 22)
						)
						(15
							(= sel_658 30)
						)
						(20
							(= sel_658 35)
						)
						(25
							(= sel_658 40)
						)
					)
				)
				(if (== (global178 sel_671:) 2)
					(switch sel_655
						(0
							(= sel_658 6)
						)
						(5
							(= sel_658 12)
						)
						(10
							(= sel_658 25)
						)
						(15
							(= sel_658 30)
						)
						(20
							(= sel_658 35)
						)
						(25
							(= sel_658 40)
						)
					)
				)
			)
			(return sel_658)
		)
	)
)

(instance unknown_501_5 of Class_500_0
	(properties
		sel_0 91
		sel_3 6
		sel_659 6
	)

	(method (sel_662)
		(= sel_655 (= sel_657 0))
		(= sel_655 (Class_500_4 sel_684: gUnknown_501_5 6))
		(= sel_657 6)
		(return sel_657)
	)

	(method (sel_663)
		(if (== sel_656 -1)
			(= sel_658 0)
			(if (or (== (global178 sel_527:) 0) (== (global178 sel_527:) 1))
				(switch sel_655
					(0
						(= sel_658 1)
					)
					(6
						(= sel_658 15)
					)
					(12
						(= sel_658 25)
					)
					(18
						(= sel_658 30)
					)
					(24
						(= sel_658 35)
					)
					(30
						(= sel_658 40)
					)
				)
			)
			(if (== (global178 sel_527:) 2)
				(if (== (global178 sel_671:) 0)
					(switch sel_655
						(0
							(= sel_658 5)
						)
						(6
							(= sel_658 11)
						)
						(12
							(= sel_658 21)
						)
						(18
							(= sel_658 30)
						)
						(24
							(= sel_658 35)
						)
						(30
							(= sel_658 40)
						)
					)
				)
				(if (== (global178 sel_671:) 1)
					(switch sel_655
						(0
							(= sel_658 5)
						)
						(6
							(= sel_658 11)
						)
						(12
							(= sel_658 21)
						)
						(18
							(= sel_658 30)
						)
						(24
							(= sel_658 35)
						)
						(30
							(= sel_658 40)
						)
					)
				)
				(if (== (global178 sel_671:) 2)
					(switch sel_655
						(0
							(= sel_658 5)
						)
						(6
							(= sel_658 11)
						)
						(12
							(= sel_658 26)
						)
						(18
							(= sel_658 30)
						)
						(24
							(= sel_658 35)
						)
						(30
							(= sel_658 40)
						)
					)
				)
			)
			(return sel_658)
		)
	)
)

(instance unknown_501_6 of Class_500_0
	(properties
		sel_0 102
		sel_3 7
	)

	(method (sel_662)
		(= sel_655 (= sel_657 0))
		(if
			(or
				(== global501 global502 global503 global504)
				(== global502 global503 global504 global505)
			)
			(= sel_657 global502)
			(= sel_655 (Class_500_4 sel_682:))
		)
		(return sel_657)
	)

	(method (sel_663 &tmp temp0 temp1 temp2)
		(if (== sel_656 -1)
			(= sel_658 0)
			(if (== (global178 sel_527:) 0)
				(if (== (global178 sel_671:) 0)
					(if sel_655
						(= sel_658 50)
					else
						(= sel_658 3)
					)
				)
				(if (or (== (global178 sel_671:) 1) (== (global178 sel_671:) 2))
					(if (not (or (localproc_5) (localproc_4)))
						(= sel_658 2)
						(= sel_660 0)
					)
					(if (localproc_5)
						(= sel_658 16)
						(self sel_665: global506 (+ global506 1))
					)
					(if (localproc_4)
						(= sel_658 16)
						(= temp0 (localproc_4))
						(= temp0 (Class_500_4 sel_683: temp0))
						(self sel_665: temp0 (+ temp0 1))
					)
					(if (localproc_3)
						(= sel_658 32)
						(self
							sel_665: global506 (+ global506 1) (+ global506 2)
						)
					)
					(if sel_655
						(= sel_658 50)
						(self sel_665: 0 1 2 3 4)
					)
					(if ((global178 sel_64: 10) sel_657:)
						(= sel_658 50)
						(self sel_665: 0 1 2 3)
					)
				)
			)
			(if (== (global178 sel_527:) 1)
				(if (== (global178 sel_671:) 0)
					(if sel_655
						(= sel_658 50)
					else
						(= sel_658 3)
					)
				)
				(if (or (== (global178 sel_671:) 1) (== (global178 sel_671:) 2))
					(if (not (or (localproc_5) (localproc_4)))
						(= sel_658 2)
						(= sel_660 0)
					)
					(if (localproc_5)
						(= sel_658 16)
						(self sel_665: global506 (+ global506 1))
					)
					(if (localproc_4)
						(= sel_658 16)
						(= temp0 (localproc_4))
						(= temp0 (Class_500_4 sel_683: temp0))
						(self sel_665: temp0 (+ temp0 1))
					)
					(if (localproc_3)
						(= sel_658 32)
						(self
							sel_665: global506 (+ global506 1) (+ global506 2)
						)
					)
					(if sel_655
						(= sel_658 50)
						(self sel_665: 0 1 2 3 4)
					)
					(if ((global178 sel_64: 10) sel_657:)
						(= temp0 ((global178 sel_64: 10) sel_657:))
						(if (== ((global178 sel_64: 10) sel_656:) 50)
							(cond
								((>= temp0 4)
									(= sel_658 50)
									(self sel_665: 0 1 2 3 4)
								)
								(
									(and
										(localproc_6 temp0)
										(not (global178 sel_696:))
									)
									(= sel_658 30)
									(self sel_665: 0 1 2 3 4)
								)
								(else
									(if
										(or
											(== (global178 sel_671:) 1)
											(== (global178 sel_671:) 2)
										)
										(self sel_665: 0 1 2 3)
									else
										(self sel_665: 0 1 2 3 4)
									)
									(= sel_658 50)
								)
							)
						)
					)
				)
			)
			(if (== (global178 sel_527:) 2)
				(if (== (global178 sel_671:) 0)
					(if sel_655
						(cond
							((>= sel_655 14)
								(= sel_658 50)
							)
							((global178 sel_696:)
								(= sel_658 50)
							)
							(else
								(= sel_658 5)
							)
						)
						(= temp0 (Class_500_4 sel_683: sel_657))
					else
						(= sel_658 8)
					)
				)
				(if (or (== (global178 sel_671:) 1) (== (global178 sel_671:) 2))
					(if (not (or (localproc_5) (localproc_4)))
						(= sel_658 1)
						(= sel_660 0)
					)
					(if (localproc_5)
						(= temp0 (localproc_5))
						(if (and (localproc_6 temp0) (>= temp0 4))
							(= sel_658 20)
						else
							(= sel_658 5)
						)
						(self sel_665: global506 (+ global506 1))
					)
					(if (localproc_4)
						(= temp1 (localproc_4))
						(= temp2 global506)
						(cond
							((>= temp1 4)
								(if (localproc_6 temp1)
									(= sel_658 28)
								else
									(= sel_658 5)
								)
								(= temp0 (Class_500_4 sel_683: temp1))
								(self sel_665: temp0 (+ temp0 1))
							)
							((localproc_6 temp2)
								(= sel_658 20)
								(= temp0 (Class_500_4 sel_683: temp2))
								(self sel_665: temp0 (+ temp0 1))
							)
							(else
								(= sel_658 5)
								(= temp0 (Class_500_4 sel_683: temp1))
								(self sel_665: temp0 (+ temp0 1))
							)
						)
					)
					(if (localproc_3)
						(= temp0 (localproc_3))
						(cond
							((and (localproc_6 temp0) (>= temp0 3))
								(= sel_658 32)
							)
							((global178 sel_696:)
								(= sel_658 32)
							)
							(else
								(= sel_658 10)
							)
						)
						(self
							sel_665: global506 (+ global506 1) (+ global506 2)
						)
					)
					(if sel_655
						(cond
							((>= sel_655 14)
								(= sel_658 50)
							)
							((global178 sel_696:)
								(= sel_658 50)
							)
							(else
								(= sel_658 5)
							)
						)
						(cond
							((== (= temp0 (Class_500_4 sel_683: sel_657)) 0)
								(cond
									(
										(and
											(> global505 4)
											(==
												((global178 sel_64: 10)
													sel_656:
												)
												50
											)
										)
										(self sel_665: 0 1 2 3 4)
									)
									((> global505 4)
										(self sel_665: 0 1 2 3 4)
									)
									(else
										(self
											sel_665:
												temp0
												(+ temp0 1)
												(+ temp0 2)
												(+ temp0 3)
										)
									)
								)
							)
							(
								(and
									(> global501 4)
									(== ((global178 sel_64: 10) sel_656:) 50)
								)
								(self sel_665: 0 1 2 3 4)
							)
							((> global501 4)
								(self sel_665: 0 1 2 3 4)
							)
							(else
								(self
									sel_665:
										temp0
										(+ temp0 1)
										(+ temp0 2)
										(+ temp0 3)
								)
							)
						)
					)
					(if ((global178 sel_64: 10) sel_657:)
						(= temp0 ((global178 sel_64: 10) sel_657:))
						(if (== ((global178 sel_64: 10) sel_656:) 50)
							(cond
								((>= temp0 4)
									(= sel_658 50)
									(self sel_665: 0 1 2 3 4)
								)
								(
									(and
										(localproc_6 temp0)
										(not (global178 sel_696:))
									)
									(= sel_658 30)
									(self sel_665: 0 1 2 3 4)
								)
								(else
									(if
										(or
											(== (global178 sel_671:) 1)
											(== (global178 sel_671:) 2)
										)
										(self sel_665: 0 1 2 3)
									else
										(self sel_665: 0 1 2 3 4)
									)
									(= sel_658 50)
								)
							)
						)
					)
				)
			)
			(return sel_658)
		)
	)
)

(instance unknown_501_7 of Class_500_0
	(properties
		sel_0 113
		sel_3 8
	)

	(method (sel_662)
		(= sel_655 (= sel_657 0))
		(if
			(or
				(and
					(== global501 global502)
					(== global503 global504 global505)
					(!= global501 global505)
				)
				(and
					(== global501 global502 global503)
					(== global504 global505)
					(!= global501 global505)
				)
			)
			(= sel_657 global503)
			(= sel_655 (Class_500_4 sel_682:))
		)
		(return sel_657)
	)

	(method (sel_663 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== sel_656 -1)
			(= sel_658 0)
			(if (or (== (global178 sel_527:) 0) (== (global178 sel_527:) 1))
				(if (== (global178 sel_671:) 0)
					(if sel_655
						(= sel_658 35)
					else
						(= sel_658 2)
					)
				)
				(if (or (== (global178 sel_671:) 1) (== (global178 sel_671:) 2))
					(if (not (or (localproc_5) (localproc_4)))
						(= sel_660 0)
						(= sel_658 2)
					)
					(if (localproc_5)
						(if (== (global178 sel_671:) 1)
							(= sel_658 2)
						)
						(if (== (global178 sel_671:) 2)
							(= sel_658 2)
						)
						(self sel_665: global506 (+ global506 1))
					)
					(if
						(or
							(> (localproc_3) 3)
							(> ((global178 sel_64: 6) sel_657:) 3)
							(> ((global178 sel_64: 10) sel_657:) 3)
						)
						(if (== (global178 sel_671:) 1)
							(= sel_658 4)
						)
						(if (== (global178 sel_671:) 2)
							(= sel_658 4)
						)
						(if (localproc_3)
							(self
								sel_665:
									global506
									(+ global506 1)
									(+ global506 2)
							)
						)
						(if ((global178 sel_64: 6) sel_657:)
							(= temp4 (Class_500_4 sel_683: sel_657))
							(self sel_665: temp4 (+ temp4 1) (+ temp4 2))
						)
						(if ((global178 sel_64: 10) sel_657:)
							(self sel_665: 0 1 2)
						)
					)
					(if (localproc_4)
						(= temp0 (localproc_4))
						(= temp1 global506)
						(= temp3 (Class_500_4 sel_683: temp1))
						(= temp2 (Class_500_4 sel_683: temp0))
						(self sel_665: temp3 (+ temp3 1) temp2 (+ temp2 1))
						(= sel_658 19)
					)
					(if sel_655
						(= sel_658 35)
						(self sel_665: 0 1 2 3 4)
					)
				)
			)
			(if (== (global178 sel_527:) 2)
				(if (== (global178 sel_671:) 0)
					(if (> sel_655 0)
						(cond
							((>= sel_655 18)
								(= sel_658 45)
							)
							((global178 sel_696:)
								(= sel_658 40)
							)
							(else
								(= sel_658 20)
							)
						)
					else
						(= sel_658 2)
					)
				)
				(if (not (or (localproc_5) (localproc_4)))
					(if (== (global178 sel_671:) 1)
						(= sel_658 1)
					)
					(if (== (global178 sel_671:) 2)
						(= sel_658 1)
					)
					(= sel_660 0)
				)
				(if (localproc_5)
					(if (== (global178 sel_671:) 1)
						(= sel_658 2)
					)
					(if (== (global178 sel_671:) 2)
						(= sel_658 2)
					)
					(self sel_665: global506 (+ global506 1))
				)
				(if
					(or
						(and (>= (localproc_3) 1) (<= (localproc_3) 3))
						(and
							(>= ((global178 sel_64: 6) sel_657:) 1)
							(<= ((global178 sel_64: 6) sel_657:) 3)
						)
						(and
							(>= ((global178 sel_64: 10) sel_657:) 1)
							(<= ((global178 sel_64: 10) sel_657:) 3)
						)
					)
					(if (== (global178 sel_671:) 1)
						(= sel_658 3)
					)
					(if (== (global178 sel_671:) 2)
						(= sel_658 3)
					)
					(if (localproc_3)
						(self
							sel_665: global506 (+ global506 1) (+ global506 2)
						)
					)
					(if ((global178 sel_64: 6) sel_657:)
						(= temp4 (Class_500_4 sel_683: sel_657))
						(self sel_665: temp4 (+ temp4 1) (+ temp4 2))
					)
					(if ((global178 sel_64: 10) sel_657:)
						(self sel_665: 0 1 2)
					)
				)
				(if
					(or
						(> (localproc_3) 3)
						(> ((global178 sel_64: 6) sel_657:) 3)
						(> ((global178 sel_64: 10) sel_657:) 3)
					)
					(if (== (global178 sel_671:) 1)
						(= sel_658 4)
					)
					(if (== (global178 sel_671:) 2)
						(= sel_658 4)
					)
					(if (localproc_3)
						(self
							sel_665: global506 (+ global506 1) (+ global506 2)
						)
					)
					(if ((global178 sel_64: 6) sel_657:)
						(= temp4 (Class_500_4 sel_683: sel_657))
						(self sel_665: temp4 (+ temp4 1) (+ temp4 2))
					)
					(if ((global178 sel_64: 10) sel_657:)
						(self sel_665: 0 1 2)
					)
				)
				(if (localproc_4)
					(= temp0 (localproc_4))
					(= temp1 global506)
					(= temp3 (Class_500_4 sel_683: temp1))
					(= temp2 (Class_500_4 sel_683: temp0))
					(if (<= (+ (* temp0 2) (* temp1 2)) 14)
						(if (global178 sel_696:)
							(= sel_658 20)
						else
							(if (== (global178 sel_671:) 1)
								(= sel_658 5)
							)
							(if (== (global178 sel_671:) 2)
								(= sel_658 5)
							)
						)
					else
						(if (== (global178 sel_671:) 1)
							(= sel_658 20)
						)
						(if (== (global178 sel_671:) 2)
							(= sel_658 23)
						)
					)
					(self sel_665: temp3 (+ temp3 1) temp2 (+ temp2 1))
				)
				(if (> sel_655 0)
					(cond
						((<= sel_655 13)
							(if (== (global178 sel_671:) 1)
								(if (global178 sel_696:)
									(= sel_658 31)
								else
									(= sel_658 5)
								)
							)
							(if (== (global178 sel_671:) 2)
								(if (global178 sel_696:)
									(= sel_658 20)
								else
									(= sel_658 5)
								)
							)
						)
						((>= sel_655 18)
							(= sel_658 45)
						)
						((global178 sel_696:)
							(= sel_658 40)
						)
						(else
							(= sel_658 20)
						)
					)
					(self sel_665: 0 1 2 3 4)
				)
			)
			(return sel_658)
		)
	)
)

(instance unknown_501_8 of Class_500_0
	(properties
		sel_0 124
		sel_3 9
	)

	(method (sel_662)
		(= sel_655 (= sel_657 0))
		(if
			(and
				((global178 sel_64: 0) sel_655:)
				((global178 sel_64: 1) sel_655:)
				((global178 sel_64: 2) sel_655:)
				((global178 sel_64: 3) sel_655:)
			)
			(= sel_655 25)
			(= sel_657 1)
		)
		(if
			(and
				((global178 sel_64: 2) sel_655:)
				((global178 sel_64: 3) sel_655:)
				((global178 sel_64: 4) sel_655:)
				((global178 sel_64: 5) sel_655:)
			)
			(= sel_655 25)
			(= sel_657 3)
		)
		(if
			(and
				((global178 sel_64: 1) sel_655:)
				((global178 sel_64: 2) sel_655:)
				((global178 sel_64: 3) sel_655:)
				((global178 sel_64: 4) sel_655:)
			)
			(= sel_655 25)
			(= sel_657 2)
		)
		(return sel_657)
	)

	(method (sel_663)
		(if (== sel_656 -1)
			(= sel_658 0)
			(if (or (== (global178 sel_527:) 0) (== (global178 sel_527:) 1))
				(if (== (global178 sel_671:) 0)
					(if sel_655
						(= sel_658 50)
					else
						(= sel_658 2)
					)
				)
				(if (or (== (global178 sel_671:) 1) (== (global178 sel_671:) 2))
					(if (not sel_655)
						(= sel_658 2)
						(= sel_660 0)
					)
					(if (localproc_0)
						(= sel_658 29)
						(if (== global506 2)
							(self sel_665: global512 global513 global514)
						else
							(self sel_665: global513 global514 global515)
						)
					)
					(if sel_655
						(= sel_658 50)
						(self sel_665: 0 1 2 3 4)
					)
					(if (not sel_660)
						(self sel_665: global512 global513 global514 global515)
					)
				)
			)
			(if (== (global178 sel_527:) 2)
				(if (== (global178 sel_671:) 0)
					(if sel_655
						(= sel_658 85)
					else
						(= sel_658 2)
					)
				)
				(if (or (== (global178 sel_671:) 1) (== (global178 sel_671:) 2))
					(if (not sel_655)
						(= sel_658 4)
						(= sel_660 0)
					)
					(if (localproc_1)
						(= sel_658 5)
						(if (== global506 45)
							(self sel_665: global511 global512 global513)
						)
						(if (== global506 35)
							(self sel_665: global511 global512 global514)
						)
						(if (== global506 46)
							(self sel_665: global513 global515 global516)
						)
						(if (== global506 36)
							(self sel_665: global514 global515 global516)
						)
					)
					(if (localproc_0)
						(= sel_658 29)
						(if (== global506 2)
							(self sel_665: global512 global513 global514)
						else
							(self sel_665: global513 global514 global515)
						)
					)
					(if sel_655
						(= sel_658 50)
						(switch sel_657
							(1
								(self
									sel_665:
										global511
										global512
										global513
										global514
								)
							)
							(2
								(self
									sel_665:
										global512
										global513
										global514
										global515
								)
							)
							(3
								(self
									sel_665:
										global513
										global514
										global515
										global516
								)
							)
						)
					)
					(if ((global178 sel_64: 9) sel_655:)
						(= sel_658 50)
						(self sel_665: 0 1 2 3)
					)
					(if (and sel_655 (== ((global178 sel_64: 9) sel_656:) 30))
						(= sel_658 50)
						(self sel_665: 0 1 2 3 4)
					)
					(if (not sel_660)
						(self sel_665: global512 global513 global514 global515)
					)
				)
			)
			(return sel_658)
		)
	)
)

(instance unknown_501_9 of Class_500_0
	(properties
		sel_0 135
		sel_3 10
	)

	(method (sel_662)
		(= sel_655 (= sel_657 0))
		(if
			(and
				(> global505 global504 global503 global502 global501)
				(or
					(==
						(+ global501 global502 global503 global504 global505)
						15
					)
					(==
						(+ global501 global502 global503 global504 global505)
						20
					)
				)
			)
			(= sel_657 global501)
			(= sel_655 30)
		)
		(return sel_657)
	)

	(method (sel_663 &tmp temp0)
		(if (== sel_656 -1)
			(= sel_658 0)
			(if (== (global178 sel_527:) 0)
				(if (== (global178 sel_671:) 0)
					(if sel_655
						(= sel_658 60)
					else
						(= sel_658 4)
					)
				)
				(if (or (== (global178 sel_671:) 1) (== (global178 sel_671:) 2))
					(if (not sel_655)
						(= sel_660 0)
						(= sel_658 2)
					)
					(if ((global178 sel_64: 8) sel_655:)
						(= sel_658 55)
						(if (== ((global178 sel_64: 8) sel_657:) 1)
							(self
								sel_665: global511 global512 global513 global514
							)
						)
						(if (== ((global178 sel_64: 8) sel_657:) 3)
							(self
								sel_665: global513 global514 global515 global516
							)
						)
					)
					(if (localproc_2)
						(= sel_658 55)
						(self sel_665: global512 global513 global514 global515)
					)
					(if sel_655
						(= sel_658 60)
						(self sel_665: 0 1 2 3 4)
					)
				)
				(if (not sel_660)
					(self sel_665: global512 global513 global514 global515)
				)
			)
			(if (== (global178 sel_527:) 1)
				(if (== (global178 sel_671:) 0)
					(if sel_655
						(= sel_658 60)
					else
						(= sel_658 4)
					)
				)
				(if (or (== (global178 sel_671:) 1) (== (global178 sel_671:) 2))
					(if (not sel_655)
						(= sel_660 0)
						(= sel_658 2)
					)
					(if ((global178 sel_64: 8) sel_655:)
						(= sel_658 55)
						(if (== ((global178 sel_64: 8) sel_657:) 1)
							(self
								sel_665: global511 global512 global513 global514
							)
						)
						(if (== ((global178 sel_64: 8) sel_657:) 3)
							(self
								sel_665: global513 global514 global515 global516
							)
						)
					)
					(if (localproc_2)
						(= sel_658 55)
						(self sel_665: global512 global513 global514 global515)
					)
					(if sel_655
						(= sel_658 60)
						(self sel_665: 0 1 2 3 4)
					)
				)
				(if (not sel_660)
					(self sel_665: global512 global513 global514 global515)
				)
			)
			(if (== (global178 sel_527:) 2)
				(if (== (global178 sel_671:) 0)
					(if sel_655
						(= sel_658 95)
					else
						(= sel_658 5)
					)
				)
				(if (or (== (global178 sel_671:) 1) (== (global178 sel_671:) 2))
					(if (not sel_655)
						(= sel_658 2)
						(= sel_660 0)
					)
					(if (localproc_1)
						(= sel_658 15)
						(switch global506
							(45
								(self
									sel_665:
										global511
										global512
										global513
										global515
								)
							)
							(35
								(self
									sel_665:
										global511
										global512
										global514
										global515
								)
							)
							(25
								(self
									sel_665:
										global511
										global513
										global514
										global515
								)
							)
							(56
								(self
									sel_665:
										global512
										global513
										global514
										global516
								)
							)
							(46
								(self
									sel_665:
										global512
										global513
										global515
										global516
								)
							)
							(36
								(self
									sel_665:
										global512
										global514
										global515
										global516
								)
							)
						)
					)
					(if (localproc_0)
						(= sel_658 20)
						(switch global506
							(2
								(self sel_665: global512 global513 global514)
							)
							(3
								(self sel_665: global513 global514 global515)
							)
						)
					)
					(if ((global178 sel_64: 8) sel_655:)
						(cond
							((== ((global178 sel_64: 8) sel_656:) -1)
								(= sel_658 60)
							)
							((== (global178 sel_671:) 2)
								(= sel_658 60)
							)
							((and (== (global178 sel_671:) 1) (localproc_5))
								(= temp0 (localproc_5))
								(if (localproc_6 temp0)
									(= sel_658 20)
								else
									(= sel_658 60)
								)
							)
						)
						(if (== ((global178 sel_64: 8) sel_657:) 1)
							(self
								sel_665: global511 global512 global513 global514
							)
						)
						(if (== ((global178 sel_64: 8) sel_657:) 3)
							(self
								sel_665: global513 global514 global515 global516
							)
						)
					)
					(if (localproc_2)
						(if (== ((global178 sel_64: 8) sel_656:) -1)
							(= sel_658 85)
						else
							(= sel_658 85)
						)
						(self sel_665: global512 global513 global514 global515)
					)
					(if sel_655
						(= sel_658 100)
						(self sel_665: 0 1 2 3 4)
					)
				)
				(if (not sel_660)
					(self sel_665: global512 global513 global514 global515)
				)
			)
			(return sel_658)
		)
	)
)

(instance unknown_501_10 of Class_500_0
	(properties
		sel_0 146
		sel_3 11
	)

	(method (sel_662)
		(= sel_655 (= sel_657 0))
		(if (== global501 global502 global503 global504 global505)
			(= sel_657 global501)
			(= sel_655 50)
		)
		(return sel_657)
	)

	(method (sel_663 &tmp temp0)
		(if (== sel_656 -1)
			(= sel_658 0)
			(if (== (global178 sel_527:) 0)
				(if (== (global178 sel_671:) 0)
					(if sel_655
						(= sel_658 100)
					else
						(= sel_658 6)
					)
				)
				(if (or (== (global178 sel_671:) 1) (== (global178 sel_671:) 2))
					(if
						(not
							(or
								(localproc_3)
								((global178 sel_64: 6) sel_655:)
								sel_655
							)
						)
						(= sel_658 2)
						(= sel_660 0)
					)
					(if (global178 sel_696:)
						(if (localproc_5)
							(= sel_658 16)
							(self sel_665: global506 (+ global506 1))
						)
						(if (localproc_4)
							(= sel_658 16)
							(= temp0 (localproc_4))
							(= temp0 (Class_500_4 sel_683: temp0))
							(self sel_665: temp0 (+ temp0 1))
						)
					)
					(if (localproc_3)
						(= sel_658 28)
						(self
							sel_665: global506 (+ global506 1) (+ global506 2)
						)
					)
					(if ((global178 sel_64: 6) sel_655:)
						(= sel_658 55)
						(= temp0
							(Class_500_4
								sel_683: ((global178 sel_64: 6) sel_657:)
							)
						)
						(self
							sel_665: temp0 (+ temp0 1) (+ temp0 2) (+ temp0 3)
						)
					)
					(if sel_655
						(= sel_658 100)
						(self sel_665: 0 1 2 3 4)
					)
				)
			)
			(if (== (global178 sel_527:) 1)
				(if (== (global178 sel_671:) 0)
					(if sel_655
						(= sel_658 100)
					else
						(= sel_658 6)
					)
				)
				(if (or (== (global178 sel_671:) 1) (== (global178 sel_671:) 2))
					(if (not (or (localproc_5) (localproc_4)))
						(= sel_658 2)
						(= sel_660 0)
					)
					(if (localproc_5)
						(= sel_658 16)
						(self sel_665: global506 (+ global506 1))
					)
					(if (localproc_4)
						(= sel_658 16)
						(= temp0 (localproc_4))
						(= temp0 (Class_500_4 sel_683: temp0))
						(self sel_665: temp0 (+ temp0 1))
					)
					(if (localproc_3)
						(= sel_658 28)
						(self
							sel_665: global506 (+ global506 1) (+ global506 2)
						)
					)
					(if ((global178 sel_64: 6) sel_655:)
						(= sel_658 55)
						(= temp0
							(Class_500_4
								sel_683: ((global178 sel_64: 6) sel_657:)
							)
						)
						(self
							sel_665: temp0 (+ temp0 1) (+ temp0 2) (+ temp0 3)
						)
					)
					(if sel_655
						(= sel_658 100)
						(self sel_665: 0 1 2 3 4)
					)
				)
			)
			(if (== (global178 sel_527:) 2)
				(if (== (global178 sel_671:) 0)
					(cond
						(sel_655
							(= sel_658 100)
						)
						((global178 sel_696:)
							(= sel_658 10)
						)
						(else
							(= sel_658 4)
						)
					)
				)
				(if (or (== (global178 sel_671:) 1) (== (global178 sel_671:) 2))
					(if (not (or (localproc_5) (localproc_4)))
						(= sel_658 2)
						(= sel_660 0)
					)
					(if (localproc_5)
						(= sel_658 3)
						(self sel_665: global506 (+ global506 1))
					)
					(if (localproc_4)
						(= sel_658 3)
						(= temp0 (localproc_4))
						(= temp0 (Class_500_4 sel_683: temp0))
						(self sel_665: temp0 (+ temp0 1))
					)
					(if (localproc_3)
						(= temp0 (localproc_3))
						(if (localproc_6 temp0)
							(= sel_658 32)
						else
							(= sel_658 7)
						)
						(self
							sel_665: global506 (+ global506 1) (+ global506 2)
						)
					)
					(if ((global178 sel_64: 6) sel_655:)
						(= sel_658 55)
						(= temp0
							(Class_500_4
								sel_683: ((global178 sel_64: 6) sel_657:)
							)
						)
						(self
							sel_665: temp0 (+ temp0 1) (+ temp0 2) (+ temp0 3)
						)
					)
					(if sel_655
						(= sel_658 100)
						(self sel_665: 0 1 2 3 4)
					)
				)
			)
			(return sel_658)
		)
	)
)

(instance unknown_501_11 of Class_500_0
	(properties
		sel_0 157
		sel_3 12
	)

	(method (sel_662)
		(= sel_655 (= sel_657 0))
		(= sel_655 (Class_500_4 sel_682:))
		(= sel_657 5)
		(return sel_657)
	)

	(method (sel_663 &tmp temp0)
		(if (== sel_656 -1)
			(= sel_658 0)
			(if (== (global178 sel_527:) 0)
				(if (== (global178 sel_671:) 0)
					(= sel_658 sel_655)
				else
					(= sel_658 sel_655)
					(self sel_665:)
				)
			)
			(if (== (global178 sel_527:) 1)
				(if (== (global178 sel_671:) 0)
					(= sel_658 sel_655)
				else
					(= sel_658 sel_655)
					(self sel_665:)
				)
			)
			(if (== (global178 sel_527:) 2)
				(if (or (> (localproc_7) sel_655) (localproc_8))
					(= sel_658 1)
				else
					(= sel_658 sel_655)
				)
				(self sel_665:)
			)
			(return sel_658)
		)
	)

	(method (sel_665 &tmp temp0)
		(for ((= temp0 (= sel_660 0))) (< temp0 5) ((++ temp0))
			(if
				(>=
					((Class_500_4 sel_64: temp0) sel_482:)
					(if (== (global178 sel_671:) 0) 0 else 4)
				)
				(switch temp0
					(-1 0)
					(0
						(|= sel_660 $0001)
					)
					(1
						(|= sel_660 $0002)
					)
					(2
						(|= sel_660 $0004)
					)
					(3
						(|= sel_660 $0008)
					)
					(4
						(|= sel_660 $0010)
					)
				)
			)
		)
	)
)


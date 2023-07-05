;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use n1111)
(use Array)
(use Print)
(use Game)
(use System)

(public
	chapEndRm 0
)

(instance chapEndRm of ScaryRoom
	(properties)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(900
				(self setScript: chapBeginScr)
			)
			(else
				(self setScript: chapEndScr)
			)
		)
	)
)

(instance chapEndScr of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(proc1111_6)
				(Sounds eachElementDo: #stop)
				(= cycles 2)
			)
			(1
				(gCurrentControl select: 3 gNormalCursor)
				(gUser message: (gUser dftMessage:))
				(gNormalCursor loop: 0 setCel: 1)
				(gGame setCursor: gNormalCursor 1)
				(= temp0 (IntArray with: 0 0 0 0))
				(Text 0 (temp0 data:) {A} gUserFont 320)
				(= temp1 (+ (temp0 at: 3) 6))
				(temp0 dispose:)
				(= temp3 (= temp2 0))
				(cond
					(
						(==
							(= temp2
								(Print
									mode: 1
									addText: 0 0 1 1 1 (* 0 temp1) 44 ; "The chapter is finished."
									addButton: ; MISSING MESSAGE
										1
										0
										0
										2
										1
										1
										(* (++ temp3) temp1)
										1
										44
									addButton: ; MISSING MESSAGE
										2
										0
										0
										3
										1
										1
										(* (++ temp3) temp1)
										1
										44
									init:
								)
							)
							1
						)
						(gCurRoom setScript: chapBeginScr)
					)
					((== temp2 2)
						(= cycles 1)
					)
					(else
						(self init:)
					)
				)
			)
			(2
				(gGame setCursor: gNormalCursor 1)
				(= temp0 (IntArray with: 0 0 0 0))
				(Text 0 (temp0 data:) {A} gUserFont 320)
				(= temp1 (+ (temp0 at: 3) 6))
				(temp0 dispose:)
				(= temp3 (= temp2 0))
				(cond
					(
						(==
							(= temp2
								(Print
									addButton: 1 0 0 4 1 1 (* 0 temp1) 44 ; "Move bookmark to present location"
									addButton: ; "Leave bookmark at prior location"
										2
										0
										0
										5
										1
										1
										(* (++ temp3) temp1)
										44
									init:
								)
							)
							1
						)
						(SetFlag 226)
						(SetFlag 319)
						(gGame save:)
						(global114 stop: 1)
						(Sounds eachElementDo: #stop)
						(gCurRoom newRoom: 91) ; saveRest
					)
					((== temp2 2)
						(SetFlag 226)
						(SetFlag 319)
						(global114 stop: 1)
						(Sounds eachElementDo: #stop)
						(gCurRoom newRoom: 91) ; saveRest
					)
					(else
						(self init:)
					)
				)
			)
		)
	)
)

(instance chapBeginScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(switch (++ gChapter)
					(2
						(if (!= (gGame getDisc: 2) 99)
							(gCurRoom newRoom: 17100)
						)
					)
					(3
						(if (!= (gGame getDisc: 3) 99)
							(gCurRoom newRoom: 28860)
						)
					)
					(4
						(if (!= (gGame getDisc: 4) 99)
							(gCurRoom newRoom: 18200)
						)
					)
					(5
						(if (!= (gGame getDisc: 5) 99)
							(gCurRoom newRoom: 17100)
						)
					)
					(6
						(if (!= (gGame getDisc: 6) 99)
							(gCurRoom newRoom: 18200)
						)
					)
					(7
						(if (!= (gGame getDisc: 6) 99)
							(gCurRoom newRoom: 17000)
						)
					)
				)
			)
		)
	)
)


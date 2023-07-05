;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 854)
(include sci.sh)
(use Main)
(use n013)
(use System)

(public
	puzBoxMessage 0
)

(instance puzBoxMessage of Code
	(properties)

	(method (doit)
		(return
			(cond
				((== gCurRoomNum 530)
					(Say 1854 3) ; "This is far too dangerous a place to work on the puzzle box."
					1
				)
				((IsFlag 129)
					(Say 1854 1) ; "I've no time for the puzzle box now!"
					1
				)
				((or (== gCurRoomNum 110) (== gCurRoomNum 120))
					(Say 1854 2) ; "I need to be alert here. I'll work on the puzzle box in a safer place."
					1
				)
				((OneOf gCurRoomNum 580 590 600)
					(Say 1854 0) ; "The box can wait until I'm in a safer place."
					1
				)
				((and (OneOf gCurRoomNum 570 270 350 390 440) (== gDisguiseNum 5)) ; abbey monk
					(Say 1854 3) ; "This is far too dangerous a place to work on the puzzle box."
					1
				)
				((or (== gCurRoomNum 210) (== gCurRoomNum 250))
					(Say 1854 4) ; "I'd rather concentrate upon the puzzle box in another place."
					1
				)
				((== gDay 10)
					(cond
						((== gCurRoomNum 490) ; HedgeRow
							(Say 1854 1) ; "I've no time for the puzzle box now!"
							1
						)
						((OneOf gCurRoomNum 455 460 470 480)
							(Say 1854 1) ; "I've no time for the puzzle box now!"
							1
						)
						((OneOf gCurRoomNum 500 540)
							(Say 1854 5) ; "This isn't the time or place to work on the puzzle box."
							1
						)
						((OneOf gCurRoomNum 560 561 562) ; tunnel1, tunnel2, tunnel3
							(Say 1854 1) ; "I've no time for the puzzle box now!"
							1
						)
					)
				)
				((and (<= 5 gDay 6) (== gDisguiseNum 5)) ; abbey monk
					(cond
						((or (== gCurRoomNum 490) (== gCurRoomNum 500)) ; HedgeRow
							(Say 1854 6) ; "I'll wait for a safer place to work on the puzzle box."
							1
						)
						((OneOf gCurRoomNum 540 550 560 561 562 570) ; tunnel1, tunnel2, tunnel3
							(Say 1854 0) ; "The box can wait until I'm in a safer place."
							1
						)
					)
				)
				(else 0)
			)
		)
	)
)


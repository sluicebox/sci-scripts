;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 154)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	ione 0
)

(instance ione of Act
	(properties
		view 350
	)

	(method (init)
		(super init:)
		(self setCycle: Walk setScript: ioneWalk)
	)
)

(instance ioneWalk of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(if
					(or
						(== gPrevRoomNum 54)
						(and (>= (gEgo y:) 180) (< (gEgo x:) 150))
						(<= (gEgo x:) 20)
					)
					(= temp0 (Random 40 100))
					(= temp2 5)
				else
					(= temp0 (Random 200 280))
					(= temp2 320)
				)
				(= temp3 (+ (= temp1 (Random 165 180)) (Random 0 30)))
				(ione posn: temp0 temp1 setMotion: MoveTo temp2 temp1 self)
			)
			(1
				(ione dispose:)
				(= cycles 1)
			)
			(2
				(client setScript: 0)
				(ione delete:)
				(DisposeScript 154)
			)
		)
	)
)


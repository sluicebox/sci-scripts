;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	Room26 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(instance Room26 of Rm
	(properties
		picture 26
	)

	(method (init)
		(= north 20)
		(= south 2)
		(= east 27)
		(= west 25)
		(= horizon 75)
		(= gIndoors 0)
		(if gNight
			(= picture 126)
		)
		(gEgo edgeHit: 0)
		(self setRegions: 501 512 506 518) ; waterReg, riverReg, meadReg, regUnicorn
		(switch gPrevRoomNum
			(2
				(cond
					((> (gEgo x:) 251)
						(gEgo posn: 251 188)
					)
					((< (gEgo x:) 80)
						(gEgo posn: 82 188)
					)
					(else
						(gEgo posn: (gEgo x:) 188)
					)
				)
			)
			(21
				(cond
					((!= (gEgo view:) 2)
						(gEgo posn: 215 (+ horizon 2))
					)
					((< (gEgo y:) 155)
						(gEgo posn: 155 (+ horizon 2))
					)
					(else
						(gEgo posn: 255 77)
					)
				)
				(Animate (gCast elements:) 0)
			)
			(25 ; Room_25
				(gEgo posn: 1 (gEgo y:))
			)
			(20 ; Room_20
				(if (> (gEgo x:) 185)
					(gEgo posn: 185 (+ horizon (gEgo yStep:)))
				else
					(gEgo posn: (gEgo x:) (+ horizon (gEgo yStep:)))
				)
			)
			(27 ; Room_27
				(gEgo posn: 318 (gEgo y:))
			)
		)
		(gEgo init:)
		(super init:)
		(if (== gPrevRoomNum 0)
			(gEgo posn: 150 150)
		)
		(= local2 (Prop new:))
		(= local5 (Prop new:))
		(= local7 (Prop new:))
		(local2
			isExtra: 1
			view: 658
			loop: 2
			cel: 1
			posn: 184 119
			setPri: 0
			cycleSpeed: 1
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local5
			isExtra: 1
			view: 658
			loop: 5
			cel: 1
			posn: 117 170
			setPri: 0
			cycleSpeed: 1
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local7
			isExtra: 1
			view: 658
			loop: 7
			cel: 0
			posn: 68 182
			setPri: 0
			cycleSpeed: 1
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(= local4 (Prop new:))
		(= local1 (Prop new:))
		(= local3 (Prop new:))
		(local4
			isExtra: 1
			view: 658
			loop: 4
			cel: 1
			posn: 159 160
			setPri: 0
			cycleSpeed: 1
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local3
			isExtra: 1
			view: 658
			loop: 3
			cel: 1
			posn: 125 138
			setPri: 0
			cycleSpeed: 1
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local1
			isExtra: 1
			view: 658
			loop: 6
			cel: 1
			posn: 171 86
			setPri: 0
			cycleSpeed: 1
			setCycle: Fwd
			ignoreActors:
			init:
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (== (gEgo edgeHit:) 1) (> (gEgo x:) 202))
			(super newRoom: 21)
		else
			(super newRoom: newRoomNumber)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if
			(and
				(== (event type:) evSAID)
				(or
					(Said 'look/around')
					(Said 'look/room')
					(Said 'look[<around][/!*]')
				)
			)
			(Print 26 0) ; "A cold river carves its way through this lush flowery meadow."
		)
	)
)


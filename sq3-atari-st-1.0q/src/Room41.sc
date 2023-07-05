;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	Room41 0
)

(instance Room41 of Rm
	(properties
		picture 41
	)

	(method (init)
		(= east 42)
		(= south 45)
		(= west 44)
		(= north 54)
		(= horizon 85)
		(super init:)
		(= global109 0)
		(= global591 0)
		(gEgo init:)
		(switch gPrevRoomNum
			(54
				(NormalEgo)
				(gEgo view: 0 posn: (gEgo x:) (+ horizon 2))
			)
			(45
				(NormalEgo)
				(= global104 0)
				(gEgo view: 0 posn: (gEgo x:) 188)
			)
			(42
				(NormalEgo)
				(gEgo view: 0 posn: 318 (gEgo y:))
			)
			(44
				(NormalEgo)
				(gEgo view: 0 posn: 1 (gEgo y:))
			)
			(else
				(gEgo view: 0 posn: 160 188)
			)
		)
		(gEgo init:)
		(self setRegions: 501) ; regDune
		(switch global110
			(1
				(if (== (Random 1 4) 3)
					(= global111 (Act new:))
					(global111 posn: 1000 1000 init:)
					(= global114 (Random 2 12))
				)
			)
			(2
				(= global111 (Act new:))
				(global111 posn: 1000 1000 init:)
				(= global114 3)
			)
		)
		(if (gCast contains: global111)
			(global111
				view: 106
				setCycle: Walk
				observeControl: 2
				posn: 1000 1000
				init:
			)
			(switch gPrevRoomNum
				(east
					(global111 posn: 359 130)
				)
				(west
					(global111 posn: -40 130)
				)
				(south
					(global111 posn: 160 249)
				)
				(north
					(global111 posn: 160 (+ horizon 2))
				)
			)
			(= global110 1)
			((ScriptID 501 0) notify: 1) ; regDune
		else
			((ScriptID 501 0) notify: 4) ; regDune
		)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(gCast contains: global111)
				(< (gEgo distanceTo: global111) 120)
			)
			(= global110 2)
		)
		(if (not gHandsOff)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((or (Said '/area') (Said '/around') (Said '[<around][/!*]'))
					(Print 41 0) ; "You are in a large, flat expanse of desert. You see mountains to the north."
				)
				((Said '/dune')
					(Print 41 1) ; "You don't see many sand dunes here."
				)
			)
		)
	)
)


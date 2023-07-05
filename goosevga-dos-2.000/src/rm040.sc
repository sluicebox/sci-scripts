;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use n411)
(use PolyPath)
(use Polygon)
(use Game)
(use Actor)
(use System)

(public
	rm040 0
)

(instance rm040 of Rm
	(properties
		picture 40
		style 0
		horizon 1
		picAngle 50
	)

	(method (init)
		(Load rsVIEW 149)
		(if ((gGoals at: 15) egoReturned:)
			(Load rsVIEW 83)
		)
		(super init:)
		(= global345 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 219 123 190 116 212 98 192 89 185 97 144 82 131 83 113 93 57 109 94 132 116 119 158 131 181 124 208 133
					yourself:
				)
		)
		(proc0_3)
		(if (!= gPrevRoomNum 45) ; mapRoom
			(gEgo loop: 1 posn: 186 119)
		)
		(gEgo init:)
		(table init:)
		(proc0_8 205 94 215 126)
		(if global150
			(global150 z: 13)
		)
		(if (and global130 (> global130 47))
			(global129 z: 13)
		)
		(if ((gGoals at: 15) egoReturned:)
			(body init:)
			(man init:)
			(catMouse init: stopUpd:)
		)
	)

	(method (doit)
		(if (== (gEgo onControl: 0) 16384)
			(self newRoom: 15)
		)
		(super doit:)
	)
)

(instance converse6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 136)
				(proc411_0 man)
				(= cycles 1)
			)
			(1
				(proc0_20)
				(man say: 136 self)
			)
			(2
				(proc411_1)
				(DoSound sndMASTER_VOLUME global125)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance catMouse of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 83 posn: 103 70 setLoop: 15 setCel: 1 stopUpd:)
	)
)

(instance man of CDActor
	(properties
		x 116
		y 116
		view 83
		loop 10
		priority 15
		signal 16400
	)

	(method (init)
		(super init:)
		(= global341 converse6)
	)

	(method (doit)
		(if (not script)
			(self
				setLoop:
					(cond
						((< (gEgo x:) (- x 20)) 11)
						((> (gEgo x:) (+ x 20)) 9)
						(else 10)
					)
			)
		)
		(super doit:)
	)
)

(instance body of View
	(properties
		x 110
		y 131
		view 83
		loop 15
		priority 14
		signal 16400
	)
)

(instance table of View
	(properties
		view 149
		priority 2
		signal 16400
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(self posn: 205 94)
		(super init:)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 102 (gEgo x:) 187))
				(= temp1 75)
			)
			(2
				(= temp0 225)
				(= temp1 (proc0_13 89 (gEgo y:) 108))
			)
			(3
				(= temp0 (proc0_13 189 (gEgo x:) 218))
				(= temp1 156)
			)
			(4
				(= temp0 51)
				(= temp1 (proc0_13 98 (gEgo y:) 124))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)


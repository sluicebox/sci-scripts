;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use n411)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm040 0
)

(local
	[local0 51] = [2 0 0 0 -14078 81 200 122 180 117 182 112 205 100 185 98 177 98 143 85 128 85 126 91 116 95 104 -32690 -14243 82 114 96 89 105 77 101 61 107 95 128 115 115 161 131 182 119 199 124 137 -32602 0]
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
		(HandsOn)
		(if (!= gPrevRoomNum 45) ; mapRoom
			(gEgo loop: 1 posn: 186 119)
		)
		(gEgo setMotion: Freeway (= global75 @local0) init:)
		(table init:)
		(proc0_8 210 94 215 126)
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
				(HandsOn)
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
		y 116
		x 116
		view 83
		loop 10
		priority 15
		signal 16400
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

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((!= (event type:) evVERB)
				(return)
			)
			(script
				(return)
			)
			(else
				(event claimed: 1)
				(HandsOff)
				(self setScript: converse6 self 136)
			)
		)
	)
)

(instance body of View
	(properties
		y 131
		x 110
		view 83
		loop 15
		priority 14
		signal 16
	)
)

(instance table of View
	(properties
		view 149
		priority 2
		signal 16400
	)

	(method (init)
		(self posn: 210 94)
		(super init:)
	)
)


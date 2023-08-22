;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use Waters2)
(use n411)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm041 0
)

(local
	local0
	[local1 15] = [131 81 80 174 41 80 165 79 80 101 81 80 135 140 80]
)

(instance rm041 of Rm
	(properties
		picture 41
		style 0
		east 24
	)

	(method (init)
		(HandsOn)
		(super init:)
		(= global345 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 219 100 188 100 178 89 151 89 151 97 110 97 110 89 88 89 52 131 207 131 194 107 224 107
					yourself:
				)
		)
		(p0 init:)
		(clock init:)
		(clks init: nLoops: 5)
		(if (and global129 (== global130 44))
			(global129 setLoop: -1 setCel: -1)
		)
		(if (== gPrevRoomNum 45) ; mapRoom
			(gEgo init:)
		else
			(gEgo x: 165 y: 104 init:)
			(if global172
				(self setScript: converse)
			else
				(self setScript: comeIn)
			)
		)
		(= global341 converse)
		(= gPrevRoomNum east)
		(proc0_8 100 103 182 99)
		(gLongSong stop: number: 601 playBed:)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl:) $4000)
				(self setScript: gStdWalkOut 0 2)
			)
		)
	)

	(method (dispose)
		(DisposeScript 402)
		(gLongSong stop: number: 600 play:)
		(super dispose:)
	)
)

(instance comeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 218 104 setMotion: MoveTo 175 104 self)
			)
			(1
				(if (== global130 44)
					(gCurRoom setScript: global341)
				else
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance clock of CDActor
	(properties
		x 131
		y 58
		view 66
		loop 7
		signal 2080
		cycleSpeed 4
		illegalBits 0
	)

	(method (init)
		(if ((gGoals at: 1) egoReturned:)
			(= loop 8)
		)
		(super init:)
		(= global109 self)
	)

	(method (dispose)
		(= signal 0)
		(super dispose:)
	)
)

(instance p0 of Prop
	(properties
		x 81
		y 66
		view 66
		loop 5
		cycleSpeed 6
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance clks of Waters2
	(properties
		view 66
	)

	(method (getLoop)
		(= x [local1 pos])
		(= y [local1 (++ pos)])
		(= cel [local1 (++ pos)])
	)

	(method (saveLoop)
		(= [local1 pos] cel)
		(++ pos)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(HandsOff)
			(proc0_7 gEgo clock)
			(= temp0 (gGoals at: 1))
			(proc0_20)
			(proc411_0 (gEgo head:) clock)
			(cond
				(local0
					(switch local0
						(1
							(self setScript: converse2 self 114)
						)
						(2
							(self setScript: converse2 self 120)
						)
						(else
							(self setScript: converse6 self 122)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse6 self 123)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self 121)
					(temp0 egoReturned: 1)
					(if (== global123 4)
						(= global123 0)
					)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 115)
					(= global123 4)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self 107)
					(temp0 egoTold: 1)
					(= global123 4)
					(= local0 1)
				)
			)
		else
			(client setScript: 0)
			(DoSound sndMASTER_VOLUME global125)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(RedrawCast)
			(HandsOn)
		)
	)
)

(instance converse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(clock say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(clock say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(clock say: (++ register) self)
			)
			(6
				(gEgo say: (++ register) self)
			)
			(7
				(clock say: (++ register) self)
			)
			(8
				(proc411_1)
				(= global131 (+ (clock x:) 13))
				(= global132 (- (clock y:) 36))
				(= global128 100)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance converse2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(clock say: register self)
			)
			(2
				(proc411_1)
				(= global131 (+ (clock x:) 13))
				(= global132 (- (clock y:) 36))
				(= global128 100)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(= global123 4)
				(self dispose:)
			)
		)
	)
)

(instance converse3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(clock say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(clock say: (++ register) self)
			)
			(5
				(gEgo say: (++ register) self)
			)
			(6
				(proc411_1)
				(= global131 (+ (clock x:) 13))
				(= global132 (- (clock y:) 36))
				(= global128 100)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance converse5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(clock say: register self)
			)
			(2
				(proc411_1)
				(self setScript: (ScriptID 341) self) ; rhymeScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance converse6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(clock say: register self)
			)
			(2
				(proc411_1)
				(self dispose:)
			)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 88 (gEgo x:) 176))
				(= temp1 84)
			)
			(2
				(= temp0 235)
				(= temp1 (proc0_13 99 (gEgo y:) 110))
			)
			(3
				(= temp0 (proc0_13 55 (gEgo x:) 203))
				(= temp1 139)
			)
			(4
				(= temp0 55)
				(= temp1 (proc0_13 84 (gEgo y:) 128))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)


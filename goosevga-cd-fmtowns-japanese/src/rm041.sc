;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use Waters2)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm041 0
)

(local
	[local0 49] = [2 0 0 0 -14257 91 107 91 107 100 155 100 156 92 176 92 182 102 202 103 217 103 198 95 198 -32768 -14298 132 52 132 60 126 194 126 198 131 204 131 191 107 199 105 217 105 214 116 238 -32602 0]
	local49
	[local50 15] = [131 81 80 174 41 80 165 79 80 101 81 80 135 140 80]
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
		(p0 init:)
		(clock init:)
		(clks init: nLoops: 5)
		(if (and global129 (== global130 44))
			(global129 setLoop: -1 setCel: -1)
		)
		(gEgo setMotion: Freeway (= global75 @local0))
		(if (== gPrevRoomNum 45) ; mapRoom
			(gEgo init:)
		else
			(gEgo x: 165 y: 104 illegalBits: 0 init:)
			(if global172
				(self setScript: converse)
			else
				(self setScript: comeIn)
			)
		)
		(= gPrevRoomNum east)
		(proc0_8 100 103 182 99)
		(gLongSong stop: number: 2 playBed:)
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
				(self setScript: converse)
			)
		)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl:) $4000)
				(self setScript: gStdWalkOut 0 2)
			)
			((== (gEgo illegalBits:) 0)
				(gEgo illegalBits: $8000)
			)
		)
	)

	(method (dispose)
		(DisposeScript 402)
		(gLongSong stop: number: 1 play:)
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
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance clock of CDActor
	(properties
		y 58
		x 131
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
		y 66
		x 81
		view 66
		loop 5
		cycleSpeed 2
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
		(= x [local50 pos])
		(= y [local50 (++ pos)])
		(= cel [local50 (++ pos)])
	)

	(method (saveLoop)
		(= [local50 pos] cel)
		(++ pos)
	)
)

(instance converse of Script
	(properties)

	(method (cue)
		(client setScript: 0)
		(DoSound sndMASTER_VOLUME global125)
		(if global172
			(gCurRoom newRoom: 45) ; mapRoom
		)
		(HandsOn)
	)

	(method (init &tmp temp0)
		(HandsOff)
		(proc0_7 gEgo clock)
		(super init: &rest)
		(= temp0 (gGoals at: 1))
		(proc0_20)
		(cond
			(local49
				(switch local49
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
				(= local49 3)
			)
			((temp0 egoTold:)
				(self setScript: converse3 self 115)
				(= global123 4)
				(= local49 2)
			)
			(else
				(self setScript: converse1 self 107)
				(temp0 egoTold: 1)
				(= global123 4)
				(= local49 1)
			)
		)
	)
)

(instance converse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clock say: register self)
			)
			(1
				(gEgo say: (++ register) self)
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
				(clock say: (++ register) self)
			)
			(7
				(= global131 (+ (clock x:) 13))
				(= global132 (- (clock y:) 36))
				(= global128 100)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(8
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
				(clock say: register self)
			)
			(1
				(= global131 (+ (clock x:) 13))
				(= global132 (- (clock y:) 36))
				(= global128 100)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(2
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
				(gEgo say: register self)
			)
			(1
				(clock say: (++ register) self)
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
				(= global131 (+ (clock x:) 13))
				(= global132 (- (clock y:) 36))
				(= global128 100)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(6
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
				(clock say: register self)
			)
			(1
				(self dispose:)
			)
		)
	)
)


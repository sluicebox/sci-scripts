;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39)
(include sci.sh)
(use Main)
(use n411)
(use Path)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm039 0
)

(local
	[local0 32] = [1 0 0 -14216 151 122 112 116 109 76 108 86 98 97 98 94 106 169 106 177 102 183 102 193 107 151 111 146 116 152 -32617 0]
	local32
	local33
	[local34 35] = [73 113 97 82 126 61 150 53 168 52 179 55 185 57 189 61 191 66 188 72 183 76 176 79 166 79 146 77 134 72 121 64 112 55 -32768]
	[local69 33] = [73 113 97 73 101 58 100 51 96 48 92 48 87 50 84 54 82 60 84 68 89 74 96 77 105 77 116 74 128 68 141 59 -32768]
	[local102 13] = [73 113 104 88 142 74 174 69 204 71 226 74 -32768]
)

(instance rm039 of Rm
	(properties
		picture 39
		style 0
		south 13
		picAngle 50
	)

	(method (init)
		(super init:)
		(if (!= gPrevRoomNum 45) ; mapRoom
			(gEgo loop: 3 posn: 145 150)
		)
		(gEgo setMotion: Freeway (= global75 @local0))
		(gEgo init:)
		(table init:)
		(proc0_8 176 98 122 146)
		(if ((gGoals at: 4) egoReturned:)
			(mary init:)
		)
		(girl init:)
		(boy init:)
		(puller init:)
		(talker init:)
		(thrower init:)
		(dunce init:)
		(teacher init:)
		(board init:)
		(writing init:)
		(if global150
			(global150 z: 13)
		)
		(if (and global130 (> global130 47))
			(global129 z: 13)
		)
	)

	(method (dispose)
		(DisposeScript 983)
		(super dispose:)
	)
)

(instance mary of Prop
	(properties
		y 137
		x 203
		view 126
		loop 3
	)
)

(instance girl of View
	(properties
		y 112
		x 93
		view 126
		loop 3
		cel 1
		priority 10
		signal 273
	)
)

(instance boy of View
	(properties
		y 134
		x 80
		view 126
		loop 3
		cel 2
	)
)

(instance puller of Prop
	(properties
		y 114
		x 210
		view 126
		cel 9
		priority 10
		signal 2321
		cycleSpeed 2
	)
)

(instance bad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client signal: 2070 cel: 0 setCycle: End self)
			)
			(1
				(client signal: 2321)
			)
		)
	)
)

(instance talker of Prop
	(properties
		y 117
		x 71
		view 126
		loop 1
		cel 8
		priority 10
		signal 2321
		cycleSpeed 2
	)
)

(instance thrower of Prop
	(properties
		y 139
		x 55
		view 126
		loop 2
		cel 6
		signal 2321
		cycleSpeed 2
	)
)

(instance plane of Act
	(properties
		y 89
		x 118
		view 126
		loop 11
		signal 18432
		cycleSpeed 7
		illegalBits 0
	)
)

(instance flyCircle of Path
	(properties)

	(method (at param1)
		(return [local34 param1])
	)
)

(instance flyLoop of Path
	(properties)

	(method (at param1)
		(return [local69 param1])
	)
)

(instance flyOut of Path
	(properties)

	(method (at param1)
		(return [local102 param1])
	)
)

(instance throw of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(thrower signal: 2070 setCel: 0 setCycle: CT 5 1 self)
			)
			(1
				(plane
					init:
					posn: 60 129
					setPri: 14
					setScript: flyAround 0 register
				)
				(plane cel: 0 setCycle: End)
				(= cycles 4)
			)
			(2
				(thrower setCel: 6 signal: 2321)
			)
		)
	)
)

(instance flyAround of Script
	(properties)

	(method (changeState newState)
		(switch register
			(0
				(switch (= state newState)
					(0
						(plane setLoop: 11 setMotion: flyCircle self)
					)
					(1
						(plane setCel: 13)
						(= cycles 4)
					)
					(2
						(plane
							setCel: 255
							setPri: 6
							setMotion: MoveTo 118 89 self
						)
					)
					(3
						(plane dispose:)
						(self dispose:)
					)
				)
			)
			(1
				(switch (= state newState)
					(0
						(plane setLoop: 12 setMotion: flyLoop self)
					)
					(1
						(plane setCel: 10)
						(= cycles 4)
					)
					(2
						(plane
							setCel: 255
							setPri: 6
							setMotion: MoveTo 141 89 self
						)
					)
					(3
						(plane dispose:)
						(self dispose:)
					)
				)
			)
			(2
				(switch (= state newState)
					(0
						(plane setLoop: 13 setMotion: flyOut self)
					)
					(1
						(plane dispose:)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance dunce of Prop
	(properties
		y 93
		x 85
		view 126
		loop 5
		cycleSpeed 4
	)

	(method (init)
		(super init:)
		(self setCycle: End self)
	)

	(method (cue)
		(self stopUpd:)
		(|= signal $0100)
	)
)

(instance board of Prop
	(properties
		y 72
		x 134
		view 126
		loop 4
		cycleSpeed 8
	)
)

(instance writing of Prop
	(properties
		y 72
		x 116
		z 18
		view 126
		loop 10
		cycleSpeed 7
	)

	(method (init)
		(super init:)
		(self hide:)
	)
)

(instance teacher of Act
	(properties
		y 97
		x 150
		view 126
		loop 6
		cycleSpeed 2
		illegalBits 0
		xStep 1
		moveSpeed 1
	)

	(method (init)
		(super init:)
		(self setScript: teach)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((!= (event type:) evVERB)
				(return)
			)
			((gCurRoom script:)
				(return)
			)
			(((gGoals at: 4) egoReturned:)
				(event claimed: 1)
				(proc0_2)
				(= local32 1)
			)
		)
	)
)

(instance teach of Script
	(properties)

	(method (cue)
		(if local32
			(= local32 0)
			(self setScript: converse6 self 227)
		else
			(super cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(teacher setLoop: 6 cel: 0 setCycle: End self)
			)
			(1
				(teacher
					setLoop: 7
					cel: 0
					setMotion: MoveTo 115 97
					setCycle: Fwd
				)
				(board setCycle: End self)
			)
			(2
				(board addToPic:)
				(teacher setCycle: End self)
			)
			(3
				(teacher setLoop: 8 cel: 0 setCycle: End self)
			)
			(4
				(= seconds 3)
			)
			(5
				(teacher setCycle: Beg self)
			)
			(6
				(switch (Random 0 2)
					(0
						(puller setScript: bad)
					)
					(1
						(talker setScript: bad)
					)
				)
				(teacher
					moveSpeed: 2
					setLoop: 9
					cel: 0
					setMotion: MoveTo 134 97
					setCycle: Fwd
				)
				(= register (writing loop:))
				(writing
					show:
					setCycle: CT (if (== register 10) 6 else 255) 1 self
				)
			)
			(7
				(teacher setLoop: 8 cel: 0 setCycle: End self)
			)
			(8
				(= seconds 3)
			)
			(9
				(teacher setCycle: Beg self)
			)
			(10
				(if (== register 10)
					(writing setCycle: End)
					(teacher
						setLoop: 9
						cel: 0
						setMotion: MoveTo 144 97 self
						setCycle: Fwd
					)
				else
					(= cycles 1)
					(+= state 3)
				)
			)
			(11
				(teacher setLoop: 8 cel: 0 setCycle: End self)
			)
			(12
				(= seconds 3)
			)
			(13
				(teacher setCycle: Beg self)
			)
			(14
				(switch (Random 0 3)
					(0
						(puller setScript: bad)
					)
					(1
						(talker setScript: bad)
					)
					(2
						(thrower setScript: throw 0 (Random 0 2))
					)
				)
				(teacher
					setLoop: 7
					cel: 0
					setMotion: MoveTo 115 97
					setCycle: Fwd
				)
				(writing setCycle: Beg self)
			)
			(15
				(writing hide:)
				(teacher setCycle: End self)
			)
			(16
				(writing
					setLoop:
						(switch register
							(10 14)
							(14 15)
							(15 10)
						)
				)
				(= state 5)
				(= seconds 2)
			)
		)
	)
)

(instance table of View
	(properties
		view 149
		priority 2
		signal 16657
	)

	(method (init)
		(self posn: 176 98)
		(super init:)
	)
)

(instance converse6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_7 gEgo teacher)
				(proc411_0 (gEgo head:) teacher)
				(= cycles 1)
			)
			(1
				(proc0_20)
				(gEgo say: register self)
			)
			(2
				(teacher say: (++ register) self)
			)
			(3
				(proc411_1)
				(DoSound sndMASTER_VOLUME global125)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)


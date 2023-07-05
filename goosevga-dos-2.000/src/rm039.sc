;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39)
(include sci.sh)
(use Main)
(use SpeakWindow)
(use Interface)
(use n411)
(use PolyPath)
(use Polygon)
(use Path)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm039 0
)

(local
	local0
	local1
	[local2 33] = [73 113 97 82 150 53 168 52 179 55 185 57 189 61 191 66 188 72 183 76 176 79 166 79 146 77 134 72 121 64 112 55 -32768]
	[local35 33] = [73 113 97 73 101 58 100 51 96 48 92 48 87 50 84 54 82 60 84 68 89 74 96 77 105 77 116 74 128 68 141 59 -32768]
	[local68 13] = [73 113 104 88 142 74 174 69 204 71 226 74 -32768]
	local81
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
		(= global345 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 150 113 197 113 192 99 163 99 163 106 101 104 102 93 78 97 66 110 117 113 103 196 0 196 0 0 315 0 315 196 158 196
					yourself:
				)
		)
		(if (!= gPrevRoomNum 45) ; mapRoom
			(gEgo loop: 3 posn: 145 150)
		)
		(gEgo init:)
		(table init:)
		(= global341 converse6)
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
		x 203
		y 137
		view 126
		loop 3
	)

	(method (doVerb)
		(cond
			((gCurRoom script:) 0)
			(((gGoals at: 4) egoReturned:)
				(gCurRoom setScript: converse6)
			)
		)
	)
)

(instance girl of View
	(properties
		x 93
		y 112
		view 126
		loop 3
		cel 1
		priority 10
		signal 273
	)
)

(instance boy of View
	(properties
		x 80
		y 134
		view 126
		loop 3
		cel 2
	)
)

(instance puller of Prop
	(properties
		x 210
		y 114
		view 126
		cel 9
		priority 10
		signal 18705
		cycleSpeed 8
	)
)

(instance bad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					signal: (& (client signal:) $feff)
					startUpd:
					cel: 0
					setCycle: End self
				)
			)
			(1
				(client startUpd: signal: (| (client signal:) $0100))
			)
		)
	)
)

(instance talker of Prop
	(properties
		x 71
		y 117
		view 126
		loop 1
		cel 8
		priority 10
		signal 2321
		cycleSpeed 9
	)
)

(instance thrower of Prop
	(properties
		x 55
		y 139
		view 126
		loop 2
		cel 6
		signal 2065
		cycleSpeed 7
	)
)

(instance plane of Actor
	(properties
		x 118
		y 89
		view 126
		loop 11
		signal 18432
		cycleSpeed 0
		illegalBits 0
	)
)

(instance flyCircle of Path
	(properties)

	(method (at param1)
		(return [local2 param1])
	)
)

(instance flyLoop of Path
	(properties)

	(method (at param1)
		(return [local35 param1])
	)
)

(instance flyOut of Path
	(properties)

	(method (at param1)
		(return [local68 param1])
	)
)

(class CueTo of Fwd
	(properties)

	(method (doit))

	(method (cue)
		(super doit:)
	)
)

(instance throw of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(thrower startUpd: setCel: 0 setCycle: CT 5 1 self)
			)
			(1
				(plane
					init:
					posn: 60 129
					setPri: 14
					setCycle: CueTo
					cel: 0
					setScript: flyAround 0 register
				)
				(= ticks 12)
			)
			(2
				(thrower setCel: 6 stopUpd:)
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
						(plane
							setLoop: 11
							setMotion: flyCircle self (plane cycler:)
						)
					)
					(1
						(plane setCycle: 0 loop: 13 cel: 7)
						(= ticks 12)
					)
					(2
						(plane cel: 8 setPri: 6 setMotion: MoveTo 118 89 self)
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
						(plane
							setLoop: 12
							setMotion: flyLoop self (plane cycler:)
						)
					)
					(1
						(plane setCycle: 0 loop: 13 cel: 7)
						(= ticks 12)
					)
					(2
						(plane cel: 8 setPri: 6 setMotion: MoveTo 141 89 self)
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
						(plane
							setLoop: 13
							setMotion: flyOut self (plane cycler:)
						)
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
		x 85
		y 93
		view 126
		loop 5
		cycleSpeed 21
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
		x 134
		y 72
		view 126
		loop 4
		cycleSpeed 15
	)

	(method (dispose)
		(if (not (& signal $8000))
			(super dispose:)
		else
			(&= signal $ffdf)
		)
	)
)

(instance writing of Prop
	(properties
		x 116
		y 72
		z 18
		view 126
		loop 10
		cycleSpeed 10
	)

	(method (init)
		(super init:)
		(self hide:)
	)
)

(instance teacherHead of Head ; UNUSED
	(properties
		x 149
		y 52
		view 126
		loop 3
		cel 3
		moveHead 0
	)

	(method (init)
		(super init: teacher)
	)

	(method (doit)
		(super doit:)
		(= x (+ (teacher x:) 11))
		(= y (- (teacher y:) 30))
		(= cel 3)
	)
)

(instance teacher of Actor
	(properties
		x 150
		y 97
		view 126
		loop 6
		cycleSpeed 6
		illegalBits 0
		xStep 1
		moveSpeed 4
	)

	(method (init)
		(super init:)
		(self setScript: teach)
	)
)

(instance teach of Script
	(properties)

	(method (cue)
		(if local0
			(= local81 1)
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
					moveSpeed: 3
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
				(switch (Random 1 3)
					(1
						(puller setScript: bad)
					)
					(2
						(talker setScript: bad)
					)
					(3
						(thrower setScript: throw 0 (Random 0 2))
					)
				)
				(teacher
					setLoop: 7
					cel: 0
					moveSpeed: 2
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

	(method (onMe)
		(return 0)
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
				(proc0_2)
				(= local0 1)
				(if ((gGoals at: 4) egoReturned:)
					(= register 227)
					(proc0_7 gEgo mary)
				else
					(= register (+ 524 (Random 0 49)))
					(proc0_7 gEgo teacher)
				)
				(proc411_0 (gEgo head:))
				(= cycles 1)
			)
			(1
				(proc0_20)
				(gEgo say: register self)
			)
			(2
				(SpeakWindow speakingObj: teacher)
				(Print 900 228 #dispose self) ; "Shhhhh!"
			)
			(3
				(proc411_1)
				(DoSound sndMASTER_VOLUME global125)
				(= local0 0)
				(if local81
					(teach cue:)
					(= local81 0)
				)
				(proc0_3)
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
				(= temp0 (proc0_13 80 (gEgo x:) 192))
				(= temp1 87)
			)
			(2
				(= temp0 203)
				(= temp1 (proc0_13 86 (gEgo y:) 118))
			)
			(3
				(= temp0 (proc0_13 111 (gEgo x:) 155))
				(= temp1 158)
			)
			(4
				(= temp0 65)
				(= temp1 (proc0_13 86 (gEgo y:) 111))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)


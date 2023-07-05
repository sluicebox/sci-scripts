;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use PolyPath)
(use Polygon)
(use Path)
(use Motion)
(use Actor)
(use System)

(public
	rm039 0
)

(local
	local0
	local1
	[local2 33] = [73 113 97 82 150 53 168 52 179 55 185 57 189 61 191 66 188 72 183 76 176 79 166 79 146 77 134 72 121 64 112 55 32768]
	[local35 33] = [73 113 97 73 101 58 100 51 96 48 92 48 87 50 84 54 82 60 84 68 89 74 96 77 105 77 116 74 128 68 141 59 32768]
	[local68 13] = [73 113 104 88 142 74 174 69 204 71 226 74 32768]
	local81
)

(instance rm039 of MGRoom
	(properties
		picture 39
		south 13
		picAngle 50
		edgeN -1
		edgeE 320
		edgeW -1
	)

	(method (init)
		(= picture 39)
		(super init:)
		(= global305 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 147 110 193 110 188 100 163 100 163 106 101 106 102 93 78 97 66 110 117 110 110 170 151 170
					yourself:
				)
		)
		(gEgo init:)
		(table init:)
		(= global301 converse6)
		(proc0_8 176 99 122 146)
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
		(if (== gPrevRoomNum 45) ; mapRoom
			(gGame handsOn:)
		else
			(gEgo posn: 135 145)
			(= gPrevRoomNum 13)
			(self setScript: gStdWalkIn)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(teach dispose:)
		(super dispose:)
	)
)

(instance mary of Prop
	(properties
		x 200
		y 138
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
		x 91
		y 112
		priority 10
		view 126
		loop 3
		cel 1
	)
)

(instance boy of View
	(properties
		x 78
		y 134
		view 126
		loop 3
		cel 2
	)
)

(instance puller of Prop
	(properties
		x 208
		y 114
		priority 10
		view 126
		cel 9
		cycleSpeed 8
	)
)

(instance bad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: End self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance talker of Prop
	(properties
		x 70
		y 117
		priority 10
		view 126
		loop 1
		cel 8
		cycleSpeed 9
	)
)

(instance thrower of Prop
	(properties
		x 53
		y 139
		view 126
		loop 2
		cel 6
		cycleSpeed 7
	)
)

(instance myPlane of Actor
	(properties
		x 118
		y 89
		view 126
		loop 11
		cycleSpeed 0
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
				(thrower cel: 0 setCycle: CT 5 1 self)
			)
			(1
				(myPlane
					init:
					posn: 60 129
					setPri: 120
					setCycle: CueTo
					cel: 0
					ignoreActors:
					setScript: flyAround 0 register
				)
				(= ticks 12)
			)
			(2
				(thrower cel: 6)
			)
			(3
				(self dispose:)
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
						(myPlane
							setLoop: 11 1
							setMotion: flyCircle self (myPlane cycler:)
						)
					)
					(1
						(myPlane setCycle: 0 setLoop: 13 1 cel: 7)
						(= ticks 12)
					)
					(2
						(myPlane
							cel: 8
							setPri: 100
							setMotion: MoveTo 118 89 self
						)
					)
					(3
						(myPlane dispose:)
						(self dispose:)
					)
				)
			)
			(1
				(switch (= state newState)
					(0
						(myPlane
							setLoop: 12 1
							setMotion: flyLoop self (myPlane cycler:)
						)
					)
					(1
						(myPlane setCycle: 0 setLoop: 13 1 cel: 7)
						(= ticks 12)
					)
					(2
						(myPlane
							cel: 8
							setPri: 100
							setMotion: MoveTo 141 89 self
						)
					)
					(3
						(myPlane dispose:)
						(self dispose:)
					)
				)
			)
			(2
				(switch (= state newState)
					(0
						(myPlane
							setLoop: 13 1
							setMotion: flyOut self (myPlane cycler:)
						)
					)
					(1
						(myPlane dispose:)
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
		(self setScript: dunceScript)
	)

	(method (cue))
)

(instance dunceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(dunce setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance board of Prop
	(properties
		x 130
		y 72
		view 126
		loop 4
		cycleSpeed 15
	)

	(method (init)
		(if (or (== gLanguage 2) (== gLanguage 3))
			(= view (+ 126 (* gLanguage 1000)))
		)
		(super init: &rest)
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

(instance teacher of Actor
	(properties
		x 150
		y 97
		view 126
		loop 6
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
				(teacher setLoop: 6 1 cel: 0 setCycle: End self)
			)
			(1
				(teacher
					setLoop: 7 1
					cel: 0
					setMotion: MoveTo 115 97
					setCycle: Fwd
				)
				(board setCycle: End self)
			)
			(2
				(teacher setCycle: End self)
			)
			(3
				(teacher setLoop: 8 1 cel: 0 setCycle: End self)
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
					setLoop: 9 1
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
				(teacher setLoop: 8 1 cel: 0 setCycle: End self)
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
						setLoop: 9 1
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
				(teacher setLoop: 8 1 cel: 0 setCycle: End self)
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
					setLoop: 7 1
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
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(self posn: 176 99 setPri: 97)
		(super init:)
	)
)

(instance converse6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global516 gNarrator)
				(= gNarrator mgNarrator)
				(= local0 1)
				(if ((gGoals at: 4) egoReturned:)
					(proc0_7 gEgo mary)
					(gMessager say: 8 1 7 0 self 13) ; "Hi, Mary."
				else
					(proc0_7 gEgo teacher)
					(if (Random 0 1)
						(gMessager say: 1 1 33 (Random 1 29) self 0)
					else
						(gMessager say: 1 1 34 (Random 1 21) self 0)
					)
				)
			)
			(1
				(= local0 0)
				(if local81
					(teach cue:)
					(= local81 0)
				)
				(= gNarrator global516)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mgNarrator of MGNarrator
	(properties
		modeless 2
	)

	(method (startAudio param1)
		(switch global515
			(16 0)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(16 0)
			(9
				(self doEgoQuiet:)
			)
		)
		(super dispose:)
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
				(= temp1 166)
			)
			(4
				(= temp0 65)
				(= temp1 (proc0_13 86 (gEgo y:) 111))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)


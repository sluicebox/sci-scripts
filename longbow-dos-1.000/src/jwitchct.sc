;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 501)
(include sci.sh)
(use Main)
(use SlowDown)
(use FuzzyStop)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	jwitchct 0
)

(local
	local0
	[local1 8]
	[local9 8] = [106 118 57 67 188 227 199 35]
	[local17 8] = [55 64 172 146 150 116 125 104]
	[local25 8] = [12 10 10 12 12 12 10 12]
	[local33 8] = [1 0 0 2 1 1 0 2]
	[local41 11] = [0 0 0 0 0 0 1 0 0 0 0]
	local52
	local53
	local54
	local55
	local56
	local57
	local58
	local59
	local60
)

(instance jwitchct of Rm
	(properties
		style 8
	)

	(method (init)
		(HandsOff)
		(Load rsPIC 500)
		(LoadMany rsVIEW 393 501 756)
		(LoadMany rsSOUND 120)
		(door init: stopUpd:)
		(robinH init:)
		(marianM init:)
		(fire init:)
		(fire2 x: 430 y: 430 priority: 11 init:)
		(for ((= local0 0)) (< local0 8) ((++ local0))
			((= [local1 local0] (arrow new:))
				x: [local9 local0]
				y: [local17 local0]
				loop: [local25 local0]
				cel: [local33 local0]
			)
		)
		([local1 4] priority: 0)
		([local1 5] priority: 0)
		([local1 6] priority: 0)
		(switch global146
			(30
				(= local60 20)
			)
			(40
				(= local60 20)
			)
			(else
				(= local60 15)
			)
		)
		(if (and (== global151 0) (== gBlowCount 0))
			(= local60 20)
		)
		(if (or (!= global151 0) (!= gBlowCount 0))
			(knave init:)
			(knave2 x: 460 y: 460 init:)
			(knave3 x: 450 y: 450 init:)
			(knave setScript: kill)
			(knave2 setScript: kill2)
			(knave3 setScript: kill3)
			(switch (= local56 (Random 1 3))
				(1
					(= local57 knave)
					(= local58 knave2)
					(= local59 knave3)
				)
				(2
					(= local57 knave2)
					(= local58 knave3)
					(= local59 knave)
				)
				(else
					(= local57 knave3)
					(= local58 knave)
					(= local59 knave2)
				)
			)
			(local57 setScript: knavesDie)
		)
		(marianM setScript: marianBurns)
		(fire setCycle: Fwd)
		(fire2 setCycle: Fwd)
		(super init:)
		(fireSound play:)
		(gTheIconBar enable:)
		(gCurRoom drawPic: 500 6)
		(door x: 147 y: 102)
		(robinH x: 177 y: 100)
		(marianM x: 117 y: 118)
		(fire x: 113 y: 125)
		(fire2 x: 127 y: 123)
		(if (or (!= global151 0) (!= gBlowCount 0))
			(knave x: (Random 73 83) y: (Random 120 130))
			(knave2 x: (Random 44 54) y: (Random 146 156))
			(knave3 x: (Random 176 186) y: (Random 120 130))
		else
			(killer init: cel: 0 x: 133 y: 106 stopUpd:)
			(killer2 init: cel: 5 x: 210 y: 108 stopUpd:)
		)
		(gCurRoom setScript: musicScript)
	)

	(method (dispose)
		(for ((= local0 0)) (< local0 8) ((++ local0))
			(if (IsObject [local1 local0])
				([local1 local0] dispose: delete:)
			)
		)
		(fireSound dispose:)
		(if (IsFlag 168)
			(SetFlag 61)
		)
		(super dispose: &rest)
	)
)

(instance robinH of Actor
	(properties
		x 500
		y 500
		view 501
		loop 1
	)
)

(instance robinsHead of Prop
	(properties
		x 225
		y 82
		view 756
		loop 8
		priority 12
		signal 16
	)
)

(instance killer of Actor
	(properties
		x 600
		y 600
		view 756
		loop 1
	)
)

(instance killer2 of Actor
	(properties
		view 756
		loop 1
	)
)

(instance arrow of View
	(properties
		view 756
		loop 9
		priority 11
		signal 16401
	)
)

(instance door of Prop
	(properties
		x 575
		y 575
		view 501
		loop 10
		priority 6
		signal 16401
	)
)

(instance marianM of Prop
	(properties
		x 510
		y 510
		view 501
		loop 3
		priority 11
		signal 16
	)
)

(instance fire of Prop
	(properties
		x 550
		y 550
		view 501
		loop 2
		priority 12
		signal 16
	)
)

(instance fire2 of Prop
	(properties
		view 501
		loop 2
		priority 12
		signal 16
	)
)

(instance fireA of Prop
	(properties
		view 501
		loop 2
		priority 12
		signal 16
	)
)

(instance fireB of Prop
	(properties
		view 501
		loop 2
		priority 12
		signal 16
	)
)

(instance fireD of Prop
	(properties
		view 501
		loop 2
		priority 12
		signal 16
	)
)

(instance fireE of Prop
	(properties
		view 501
		loop 2
		priority 12
		signal 16
	)
)

(instance fireF of Prop
	(properties
		view 501
		loop 2
		priority 12
		signal 16
	)
)

(instance knave of Prop
	(properties
		x 470
		y 470
		sightAngle 90
		view 393
		loop 1
		signal 16384
	)
)

(instance knave2 of Prop
	(properties
		sightAngle 90
		view 393
		loop 1
		signal 16384
	)
)

(instance knave3 of Prop
	(properties
		sightAngle 90
		view 393
		loop 1
		signal 16384
	)
)

(instance marianBurns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(marianM cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(= ticks (* (= local56 (Random 1 3)) 12))
			)
			(2
				(marianM setCycle: Beg self)
			)
			(3
				(= ticks (* (= local56 (Random 1 3)) 12))
			)
			(4
				(marianM setCycle: CT 5 1 self)
			)
			(5
				(= ticks (* (= local56 (Random 4 9)) 12))
			)
			(6
				(marianM setCycle: CT 2 -1 self)
			)
			(7
				(= ticks (* (= local56 (Random 1 3)) 12))
			)
			(8
				(marianM setCycle: End self)
			)
			(9
				(= local56 (Random 4 8))
				(= state -1)
				(= ticks (* local56 12))
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance knavesDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				([local1 7] init: addToPic:)
				(local57 loop: 3 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(1
				(local57 stopUpd:)
				([local1 1] init: addToPic:)
				(= ticks (* (= local52 (Random 3 6)) 20))
			)
			(2
				([local1 6] init: addToPic:)
				([local1 0] init: addToPic:)
				(local58
					setScript: 0
					loop: 2
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(local58 stopUpd:)
				([local1 4] init: addToPic:)
				(= ticks (* (= local52 (Random 1 3)) 10))
			)
			(4
				([local1 3] init: addToPic:)
				([local1 5] init: addToPic:)
				(local59
					setScript: 0
					loop: 3
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(5
				([local1 2] init: addToPic:)
				(local59 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance openSesame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(robinH cycleSpeed: 18 setCycle: End)
				(door cycleSpeed: 18 setCycle: End self)
			)
			(1
				(door stopUpd:)
				(robinH
					view: 756
					loop: 5
					signal: (| (robinH signal:) $0800)
					cel: 0
					x: 183
					y: 98
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 145 116 self
				)
			)
			(2
				(if (not (IsFlag 168))
					(fireD x: 115 y: 112 init: setCycle: Fwd)
					(ignisMortis start: 3)
					(robinH setScript: ignisMortis)
				else
					(robinH
						view: 501
						loop: 8
						cel: 0
						cycleSpeed: 12
						x: 142
						y: 117
						setCycle: End self
					)
				)
			)
			(3
				(gRgnMusic2 number: 506 loop: 1 play: hold: 1)
				(robinH
					view: 756
					loop: 5
					cel: 2
					cycleSpeed: 6
					priority: 11
					signal: (| (robinH signal:) $0010)
					x: 140
					y: 114
					setCycle: Walk
					setMotion: MoveTo 146 121 self
				)
			)
			(4
				(robinH loop: 4 cel: 0)
				(= ticks 6)
			)
			(5
				(robinH view: 501 loop: 6 x: 132 y: 126 cycleSpeed: 18)
				(marianM dispose:)
				(= ticks 6)
			)
			(6
				(robinH setCycle: End self)
			)
			(7
				(robinH cel: 1)
				(= ticks 24)
			)
			(8
				(robinH cel: 2)
				(= ticks 12)
			)
			(9
				(robinH cel: 1)
				(= ticks 24)
			)
			(10
				(robinH cel: 2)
				(= ticks 12)
			)
			(11
				(robinH setCycle: Beg self)
			)
			(12
				(robinH
					cycleSpeed: 6
					loop: 7
					priority: 15
					signal: (| (robinH signal:) $0010)
					x: 132
					y: 124
					setCycle: End self
				)
			)
			(13
				(robinH
					view: 756
					loop: 3
					signal: (| (robinH signal:) $0800)
					cel: 0
					x: 126
					y: 131
					setCycle: End self
				)
			)
			(14
				(robinH
					loop: 2
					signal: (| (robinH signal:) $0800)
					y: 136
					setCycle: Walk
					setMotion: MoveTo 125 151 self
				)
			)
			(15
				(robinH
					view: 501
					loop: 9
					signal: (| (robinH signal:) $0800)
					cel: 0
					x: 128
					y: 159
					setCycle: End self
				)
			)
			(16
				(robinH
					view: 756
					loop: 2
					signal: (| (robinH signal:) $0800)
					cel: 2
					x: 130
					y: 161
					xStep: 6
					yStep: 4
					cycleSpeed: 3
					setCycle: Walk
					setMotion: MoveTo 117 249 self
				)
				(gRgnMusic2 release:)
			)
			(17
				(gCurRoom newRoom: 179) ; synop
				(self dispose:)
			)
		)
	)
)

(instance ignisMortis of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(robinH cycleSpeed: 18 setCycle: End)
				(door cycleSpeed: 18 setCycle: End self)
			)
			(1
				(fireD x: 115 y: 112 init: setCycle: Fwd)
				(= ticks 6)
			)
			(2
				(robinH
					view: 756
					loop: 7
					signal: (| (robinH signal:) $0800)
					cel: 0
					x: 183
					y: 98
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 145 116 self
				)
			)
			(3
				(robinH
					view: 501
					loop: 8
					cel: 0
					cycleSpeed: 12
					x: 142
					y: 117
					setCycle: End self
				)
			)
			(4
				(marianM setScript: 0)
				(fireE x: 121 y: 105 init: setCycle: Fwd)
				(= ticks 18)
			)
			(5
				(gRgnMusic2 number: 507 loop: 1 play:)
				(gSFX number: 931 loop: 1 play:)
				(fireF x: 125 y: 110 init: setCycle: Fwd)
				(= ticks 6)
			)
			(6
				(robinH
					view: 756
					loop: 5
					cel: 2
					cycleSpeed: 6
					priority: 11
					signal: (| (robinH signal:) $0010)
					x: 140
					y: 114
					setCycle: Walk
					setMotion: MoveTo 140 121 self
				)
			)
			(7
				(robinH loop: 4 cel: 0)
				(= ticks 6)
			)
			(8
				(robinH view: 501 loop: 4 cel: 2)
				(fireA x: 140 y: 107 init: setCycle: Fwd)
				(= ticks 12)
			)
			(9
				(robinH cel: 3)
				(= ticks 18)
			)
			(10
				(robinH cel: 4)
				(fireB x: 146 y: 97 init: setCycle: Fwd)
				(= ticks 18)
			)
			(11
				(robinH cel: 3)
				(= ticks 18)
			)
			(12
				(robinH cel: 4)
				(= ticks 12)
			)
			(13
				(robinH cel: 5)
				(fireA x: 142 y: 114)
				(fireB x: 146 y: 106)
				(= ticks 12)
			)
			(14
				(robinH cel: 6)
				(fireA x: 139 y: 115)
				(fireB x: 146 y: 118)
				(= ticks 60)
			)
			(15
				(= gDeathNum 37)
				(gCurRoom newRoom: 170) ; robinDeath
				(self dispose:)
			)
		)
	)
)

(instance fromTheGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(robinH
					view: 756
					loop: 6
					signal: (| (robinH signal:) $0800)
					x: 206
					y: 204
					setCycle: FuzzyStop @local41 self
					setMotion: SlowDown 224 124 0 12 12 4
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(robinsHead cel: 1 init:)
				(= ticks 18)
			)
			(3
				(robinsHead cel: 2)
				(= ticks 6)
			)
			(4
				(robinsHead cel: 3)
				(= ticks 18)
			)
			(5
				(robinsHead cel: 2)
				(= ticks 6)
			)
			(6
				(robinsHead cel: 1)
				(= ticks 18)
			)
			(7
				(robinsHead cel: 2)
				(= ticks 6)
			)
			(8
				(robinsHead cel: 3)
				(= ticks 18)
			)
			(9
				(robinsHead dispose:)
				(robinH
					loop: 7
					cel: 5
					x: 225
					y: 120
					xStep: 6
					yStep: 4
					cycleSpeed: 6
					setMotion: MoveTo 145 116 self
				)
			)
			(10
				(if (not (IsFlag 168))
					(fireD x: 115 y: 112 init: setCycle: Fwd)
					(ignisMortis start: 3)
					(robinH setScript: ignisMortis)
				else
					(openSesame start: 2)
					(robinH setScript: openSesame)
				)
				(= ticks 6)
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance kill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cycleSpeed: 8 cel: 0 setCycle: End self)
			)
			(1
				(= local53 (Random 4 8))
				(= state -1)
				(= ticks (* local53 10))
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance kill2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cycleSpeed: 8 cel: 0 setCycle: End self)
			)
			(1
				(= local54 (Random 7 10))
				(= state -1)
				(= ticks (* local54 10))
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance kill3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (* (= local55 (Random 5 9)) 10))
			)
			(1
				(client cycleSpeed: 8 cel: 0 setCycle: End self)
			)
			(2
				(= state -1)
				(= ticks 6)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance suddenDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(robinH cycleSpeed: 18 ignoreActors: 1 setCycle: End)
				(door cycleSpeed: 18 setPri: 8 setCycle: End self)
			)
			(1
				(robinH view: 756 setLoop: 5 setPri: 8 cel: 0)
				(= ticks 6)
			)
			(2
				(robinH
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 142 119 self
				)
				(killer
					setLoop: 0
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 123 116 self
				)
			)
			(3
				(killer2 setLoop: 0)
			)
			(4
				(killer x: 125 y: 117 loop: 1 setCycle: End self)
			)
			(5
				(robinH view: 501 setLoop: 4 setCycle: End self)
			)
			(6
				(= gDeathNum 26)
				(gCurRoom newRoom: 170) ; robinDeath
				(self dispose:)
			)
		)
	)
)

(instance musicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRgnMusic2 number: 505 loop: -1 play:)
				(= ticks 360)
			)
			(1
				(switch local60
					(15
						(robinH setScript: fromTheGate)
					)
					(else
						(if (and (== global151 0) (== gBlowCount 0))
							(robinH setScript: suddenDeath)
						else
							(robinH setScript: openSesame)
						)
					)
				)
			)
		)
	)
)

(instance fireSound of Sound
	(properties
		flags 1
		number 501
		loop -1
	)
)


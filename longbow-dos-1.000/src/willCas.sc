;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 177)
(include sci.sh)
(use Main)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	willCas 0
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
	local8
)

(instance willCas of Rm
	(properties
		style 8
	)

	(method (init)
		(LoadMany rsVIEW 80 111 114 115 394 393)
		(LoadMany rsSOUND 124)
		(Load rsPIC 390)
		(robin init: stopUpd:)
		(lilj init: stopUpd:)
		(wills init: stopUpd:)
		(muchm init: stopUpd:)
		(knave init:)
		(knave2 view: 393 x: 460 y: 460 loop: 0 cel: 0 init:)
		(knave3 view: 393 x: 450 y: 450 loop: 1 cel: 0 init:)
		(knave4 view: 114 x: 440 y: 440 loop: 3 cel: 4 init:)
		(victim init:)
		(fire init: hide: stopUpd:)
		(fire2 x: 173 y: 103 init: hide: stopUpd:)
		(fire3 x: 138 y: 113 init: hide: stopUpd:)
		(fire4 x: 166 y: 122 init: hide: stopUpd:)
		(knave setScript: kill1)
		(knave2 setScript: kill2)
		(knave3 setScript: kill3)
		(knave4 setScript: fight1)
		(victim setScript: fight2)
		(super init:)
		(gTheIconBar enable:)
		(= local7 (Random 1 3))
		(gRgnMusic
			number: 124
			loop: 1
			init:
			play:
				30
				(switch global146
					(12 musicScriptOne)
					(22 musicScriptOne)
					(11 musicScriptTwo)
					(21 musicScriptTwo)
					(10 musicScriptGood)
					(20 musicScriptGood)
					(else musicScriptBad)
				)
			fade: 127 60 8 0
			flags: (& (gRgnMusic flags:) $fffe)
		)
		(gCurRoom drawPic: 390 6)
		(corpse x: 167 y: 185)
		(corpse2 x: 148 y: 176)
		(gAddToPics
			add: corpse corpse2 frieze1 frieze2
			eachElementDo: #init
			doit:
		)
		(robin x: 45 y: 210)
		(lilj x: 299 y: 205)
		(wills x: 156 y: 235)
		(muchm x: 36 y: 187)
		(knave x: 166 y: 134)
		(knave2 x: 195 y: 180)
		(knave3 x: 127 y: 180)
		(knave4 x: 147 y: 171)
		(victim x: 246 y: 187)
	)

	(method (dispose)
		(gRgnMusic flags: (| (gRgnMusic flags:) $0001))
		(super dispose: &rest)
	)
)

(instance frieze1 of PicView
	(properties
		x 31
		y 189
		description {the battle frieze.}
		sightAngle 90
		lookStr {*** Robin's merrie men engage the Abbot's hoods in a fierce battle.}
		view 80
		priority 15
		signal 16400
	)
)

(instance frieze2 of PicView
	(properties
		x 288
		y 189
		description {the battle frieze.}
		sightAngle 90
		lookStr {*** Robin's merrie men engage the Abbott's hoods in a fierce battle.}
		view 80
		cel 1
		priority 15
		signal 16400
	)
)

(instance robin of Actor
	(properties
		x 500
		y 500
		view 394
		loop 1
		priority 12
		signal 16400
		illegalBits 0
	)
)

(instance lilj of Actor
	(properties
		x 600
		y 600
		view 394
		signal 16384
		illegalBits 0
	)
)

(instance wills of Actor
	(properties
		x 610
		y 610
		view 394
		loop 2
		signal 16384
		illegalBits 0
	)
)

(instance muchm of Prop
	(properties
		x 620
		y 620
		view 114
		loop 5
		cel 6
	)
)

(instance victim of Prop
	(properties
		x 560
		y 560
		view 393
		detailLevel 2
	)
)

(instance knave of Actor
	(properties
		x 470
		y 470
		sightAngle 90
		view 114
		loop 1
		detailLevel 2
		illegalBits 0
	)
)

(instance knave2 of Actor
	(properties
		sightAngle 90
		loop 1
		detailLevel 2
		illegalBits 0
	)
)

(instance knave3 of Actor
	(properties
		sightAngle 90
		loop 1
		detailLevel 2
		illegalBits 0
	)
)

(instance knave4 of Actor
	(properties
		sightAngle 90
		loop 1
		detailLevel 2
		illegalBits 0
	)
)

(instance corpse of PicView
	(properties
		sightAngle 90
		view 393
		loop 2
		cel 5
		priority 4
	)
)

(instance corpse2 of PicView
	(properties
		view 115
		loop 3
		cel 5
		priority 4
	)
)

(instance fire of Prop
	(properties
		x 179
		y 125
		view 111
		loop 5
		signal 16400
		detailLevel 2
	)
)

(instance fire2 of Prop
	(properties
		view 111
		loop 5
		signal 16400
		detailLevel 2
	)
)

(instance fire3 of Prop
	(properties
		view 111
		loop 5
		signal 16400
		detailLevel 2
	)
)

(instance fire4 of Prop
	(properties
		view 111
		loop 5
		signal 16400
		detailLevel 2
	)
)

(instance timer0 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client knave2)
					(= local1 4)
				else
					(= local1 5)
				)
				(= ticks 6)
			)
			(1
				(client loop: local1 cel: 0 setCycle: CT 6 1 self)
			)
			(2
				(client
					priority: 6
					signal: (| (client signal:) $0010)
					setCycle: End self
				)
			)
			(3
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance timer1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: 115 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(client cel: 4 y: 148)
				(= ticks 6)
			)
			(2
				(client cel: 5 y: 160)
				(= ticks 6)
			)
			(3
				(client cel: 6 y: 174)
				(= ticks 6)
			)
			(4
				(client stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance timer1fire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fire4 show: setCycle: Fwd checkDetail:)
				(client view: 115 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(fire4 y: 144)
				(client cel: 4 y: 148)
				(= ticks 6)
			)
			(2
				(fire4 y: 156)
				(client cel: 5 y: 160)
				(= ticks 6)
			)
			(3
				(fire4 y: 170 checkDetail:)
				(client cel: 6 y: 174)
				(= ticks 6)
			)
			(4
				(client stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance timer2A of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client loop: 2 setCycle: End self)
			)
			(1
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance timer3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 111
					priority: 0
					loop: 4
					signal: (| (client signal:) $0810)
					xStep: 6
					yStep: 4
					setCycle: Fwd
					setMotion: MoveTo 187 173 self
				)
			)
			(1
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance timer4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(knave priority: 0 signal: (| (knave signal:) $0010))
				(= ticks 6)
			)
			(1
				(robin
					loop: 1
					signal: (| (robin signal:) $0800)
					xStep: 6
					yStep: 4
					setCycle: Fwd
					setMotion: MoveTo 200 170 self
				)
			)
			(2
				(robin setCycle: 0 setMotion: 0 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance timer5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(muchm x: 58)
				(= ticks 6)
			)
			(1
				(muchm x: 62)
				(= ticks 6)
			)
			(2
				(muchm x: 66 stopUpd:)
				(= ticks 6)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance liljWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lilj
					loop: 0
					signal: (| (lilj signal:) $0800)
					setCycle: Fwd
					setMotion: MoveTo 240 205 self
				)
			)
			(1
				(lilj setCycle: 0 setMotion: 0 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance willsWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wills
					setCycle: Fwd
					xStep: 3
					yStep: 2
					setMotion: MoveTo 156 178 self
				)
			)
			(1
				(wills setCycle: 0 setMotion: 0 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance kill1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 cycleSpeed: 8 setCycle: End self checkDetail:)
			)
			(1
				(= ticks (* (= local2 (Random 3 6)) 10))
				(= state -1)
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
				(client cel: 0 cycleSpeed: 8 setCycle: End self checkDetail:)
			)
			(1
				(= ticks (* (= local3 (Random 3 6)) 10))
				(= state -1)
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
				(= ticks 42)
			)
			(1
				(client cel: 0 cycleSpeed: 8 setCycle: End self checkDetail:)
			)
			(2
				(= ticks (* (= local4 (Random 3 9)) 10))
				(= state -1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance fight1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cycleSpeed: 8 cel: 0 setCycle: End self checkDetail:)
			)
			(1
				(= ticks (* (= local5 (Random 3 9)) 10))
				(= state -1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance fight2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cycleSpeed: 8 cel: 0 setCycle: End self checkDetail:)
			)
			(1
				(= ticks (* (= local6 (Random 3 9)) 10))
				(= state -1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance musicScriptGood of Script
	(properties)

	(method (cue)
		(switch (gRgnMusic prevSignal:)
			(2
				(knave2 setScript: 0 loop: 2 cel: 0 setCycle: End)
			)
			(3
				(knave2 stopUpd:)
				(knave setScript: timer1)
			)
			(4
				(victim setScript: timer2A)
			)
			(5
				(knave4
					setScript: 0
					view: 115
					loop: 3
					cel: 0
					setCycle: End
					setPri: 0
				)
			)
			(6
				(if (not (== local7 2))
					(knave4 priority: 0 signal: (| (knave4 signal:) $0010))
				)
				(knave3 setScript: timer0)
			)
			(7
				(robin setScript: timer4)
			)
			(8
				(muchm setScript: timer5)
				(lilj setScript: liljWalk)
				(wills setScript: willsWalk)
			)
			(9
				(gCurRoom newRoom: 179) ; synop
			)
		)
	)
)

(instance musicScriptBad of Script
	(properties)

	(method (cue)
		(switch (gRgnMusic prevSignal:)
			(2
				(if (== (= local7 (Random 1 2)) 1)
					(knave2 setScript: timer0)
				else
					(knave4 priority: 0 signal: (| (knave4 signal:) $0010))
					(knave3 setScript: timer0)
				)
			)
			(3
				(knave setScript: timer1)
			)
			(4
				(victim setScript: timer2A)
			)
			(5
				(knave4 setScript: timer3)
			)
			(6
				(if (== local7 2)
					(knave2 setScript: timer0)
				else
					(knave3 setScript: timer0)
				)
			)
			(7
				(robin setScript: timer4)
			)
			(8
				(muchm setScript: timer5)
				(lilj setScript: liljWalk)
				(wills setScript: willsWalk)
			)
			(9
				(gCurRoom newRoom: 179) ; synop
			)
		)
	)
)

(instance musicScriptTwo of Script
	(properties)

	(method (cue)
		(switch (gRgnMusic prevSignal:)
			(1
				(knave4 priority: 0 signal: (| (knave4 signal:) $0010))
			)
			(2
				(if (== (= local8 (Random 1 2)) 1)
					(victim setScript: timer2A)
				else
					(knave setScript: timer1)
				)
			)
			(3
				(switch local7
					(1
						(knave4 setScript: timer3)
					)
					(2
						(knave2 setScript: timer0)
					)
					(else
						(knave3 setScript: timer0)
					)
				)
			)
			(4
				(if (== local7 1)
					(knave2 stopUpd:)
				else
					(knave4 stopUpd:)
				)
				(if (== local8 1)
					(knave setScript: timer1)
				else
					(victim setScript: timer2A)
				)
			)
			(5
				(switch local7
					(1
						(knave2
							setScript: 0
							loop: 2
							cel: 0
							setCycle: End
							setPri: 0
						)
					)
					(else
						(knave4
							setScript: 0
							view: 115
							loop: 3
							cel: 0
							setCycle: End
							setPri: 0
						)
					)
				)
			)
			(6
				(switch local7
					(3
						(knave2 setScript: timer0)
					)
					(else
						(knave3 setScript: timer0)
					)
				)
			)
			(7
				(robin setScript: timer4)
			)
			(8
				(muchm setScript: timer5)
				(lilj setScript: liljWalk)
				(wills setScript: willsWalk)
			)
			(9
				(gCurRoom newRoom: 179) ; synop
			)
		)
	)
)

(instance musicScriptOne of Script
	(properties)

	(method (cue)
		(switch (gRgnMusic prevSignal:)
			(1
				(knave4 priority: 0 signal: (| (knave4 signal:) $0010))
				(fire show: setCycle: Fwd checkDetail:)
			)
			(2
				(if (== (= local8 (Random 1 2)) 1)
					(victim setScript: timer2A)
				else
					(knave setScript: timer1fire)
				)
			)
			(3
				(switch local7
					(1
						(knave4 setScript: timer3)
					)
					(2
						(knave2 setScript: timer0)
					)
					(else
						(knave3 setScript: timer0)
					)
				)
			)
			(4
				(fire2 show: setCycle: Fwd checkDetail:)
				(if (== local7 1)
					(knave2 stopUpd:)
				else
					(knave4 stopUpd:)
				)
				(if (== local8 1)
					(knave setScript: timer1fire)
				else
					(victim setScript: timer2A)
				)
			)
			(5
				(switch local7
					(1
						(knave2
							setScript: 0
							loop: 2
							cel: 0
							setCycle: End
							setPri: 0
						)
					)
					(else
						(knave4
							setScript: 0
							view: 115
							loop: 3
							cel: 0
							setCycle: End
							setPri: 0
						)
					)
				)
			)
			(6
				(fire3 show: setCycle: Fwd checkDetail:)
				(switch local7
					(3
						(knave2 setScript: timer0)
					)
					(else
						(knave3 setScript: timer0)
					)
				)
			)
			(7
				(robin setScript: timer4)
			)
			(8
				(muchm setScript: timer5)
				(lilj setScript: liljWalk)
				(wills setScript: willsWalk)
			)
			(9
				(gCurRoom newRoom: 179) ; synop
			)
		)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 172)
(include sci.sh)
(use Main)
(use n013)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	tuckwobat 0
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
	local9
)

(instance tuckwobat of Rm
	(properties
		style 8
	)

	(method (init)
		(Load rsPIC 110)
		(LoadMany rsVIEW 5 10 80 111 114 115)
		(LoadMany rsSOUND 120 123)
		(robin init:)
		(archer init:)
		(archer2 x: 480 y: 480 cel: 4 init:)
		(knave cycleSpeed: 6 init:)
		(knave2 x: 460 y: 460 loop: 3 cel: 2 cycleSpeed: 12 init:)
		(knave3 x: 450 y: 450 loop: 1 cel: 4 setCycle: Fwd cycleSpeed: 6 init:)
		(outlaw2 x: 440 y: 440 cel: 4 init: stopUpd:)
		(victim2 view: 114 loop: 1 x: 510 y: 510 cycleSpeed: 12 init:)
		(archer setScript: kill)
		(archer2 setScript: kill2)
		(robin setScript: kill3)
		(knave setScript: shoot1)
		(knave2 setScript: shoot2)
		(knave3 setScript: shoot3)
		(victim2 setScript: shoot4)
		(= local1 32)
		(super init:)
		(gTheIconBar enable:)
		(gRgnMusic
			number: 120
			loop: 1
			init:
			play: musicScript
			flags: (& (gRgnMusic flags:) $fffe)
		)
		(gCurRoom drawPic: 110 6)
		(mule x: 210 y: 110)
		(mule2 x: 225 y: 100)
		(corpse loop: 1 cel: 6 x: (Random 220 230) y: (Random 109 119))
		(corpse2 loop: 1 cel: 6 x: (Random 159 169) y: (Random 106 116))
		(corpse3 loop: 1 cel: 6 x: (Random 250 260) y: (Random 106 116))
		(corpse4 loop: 1 cel: 6 x: (Random 136 146) y: (Random 123 133))
		(gAddToPics
			add: corpse corpse2 corpse3 corpse4 mule mule2 frieze1 frieze2
			eachElementDo: #init
			doit:
		)
		(robin x: 130 y: 189)
		(archer x: 78 y: 146)
		(archer2 x: (Random 85 95) y: (Random 165 175))
		(knave x: 125 y: 128)
		(knave2 x: 200 y: 100)
		(knave3 x: (Random 172 182) y: (Random 115 125))
		(outlaw2 x: 7 y: 108)
		(victim2 x: 210 y: 120)
		(gSFX
			number: 123
			loop: -1
			init:
			play:
			flags: (& (gSFX flags:) $fffe)
		)
		(gCurRoom setScript: timer0)
		(SetFlag 65)
	)
)

(instance frieze1 of PicView
	(properties
		x 31
		y 189
		description {*** the battle frieze.}
		sightAngle 90
		lookStr {*** Robin's merrie men engage the Abbot's hoods in a fierce battle.}
		view 80
		priority 15
	)
)

(instance frieze2 of PicView
	(properties
		x 288
		y 189
		description {*** the battle frieze.}
		sightAngle 90
		lookStr {*** Robin's merrie men engage the Abbott's hoods in a fierce battle.}
		view 80
		cel 1
		priority 15
	)
)

(instance robin of Prop
	(properties
		x 500
		y 500
		view 5
		loop 3
		cel 4
		cycleSpeed 8
	)
)

(instance victim of Prop ; UNUSED
	(properties
		x 180
		y 106
		view 115
		loop 3
		detailLevel 2
	)
)

(instance victim2 of Prop
	(properties
		view 115
		loop 3
		detailLevel 2
	)
)

(instance mule of PicView
	(properties
		x 520
		y 520
		view 115
		loop 7
	)
)

(instance mule2 of PicView
	(properties
		view 115
		loop 7
	)
)

(instance archer of Prop
	(properties
		x 490
		y 490
		sightAngle 90
		view 114
		loop 5
		detailLevel 2
	)
)

(instance archer2 of Prop
	(properties
		x 490
		y 490
		sightAngle 90
		view 114
		loop 5
		detailLevel 2
	)
)

(instance outlaw of Actor
	(properties
		x 7
		y 108
		sightAngle 90
		view 111
		detailLevel 2
		illegalBits 0
	)
)

(instance outlaw2 of Actor
	(properties
		sightAngle 90
		view 111
		detailLevel 2
		illegalBits 0
	)
)

(instance knave of Prop
	(properties
		x 470
		y 470
		description {*** one of the Abbott's thieving lackeys.}
		sightAngle 90
		view 114
		detailLevel 2
	)
)

(instance knave2 of Prop
	(properties
		sightAngle 90
		view 114
		detailLevel 2
	)
)

(instance knave3 of Prop
	(properties
		sightAngle 90
		view 114
		detailLevel 2
	)
)

(instance lancer of Actor
	(properties
		sightAngle 90
		view 111
		loop 1
		signal 2048
		detailLevel 2
		illegalBits 0
	)
)

(instance lancer2 of Actor
	(properties
		sightAngle 90
		view 111
		loop 1
		signal 2048
		detailLevel 2
		illegalBits 0
	)
)

(instance lancer3 of Actor
	(properties
		sightAngle 90
		view 111
		loop 1
		signal 2048
		detailLevel 2
		illegalBits 0
	)
)

(instance corpse of View
	(properties
		x 430
		y 430
		sightAngle 90
		view 115
		loop 3
		cel 5
	)
)

(instance corpse2 of View
	(properties
		sightAngle 90
		view 115
		loop 3
		cel 5
	)
)

(instance corpse3 of View
	(properties
		sightAngle 90
		view 115
		loop 3
		cel 5
	)
)

(instance corpse4 of View
	(properties
		sightAngle 90
		view 115
		loop 3
		cel 5
	)
)

(instance timer0 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lancer
					init:
					loop: 4
					x: 225
					y: 105
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 280 90 self
				)
			)
			(1
				(lancer dispose:)
				(self dispose:)
			)
		)
	)
)

(instance timer0A of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lancer2
					loop: 2
					x: 12
					y: 113
					moveSpeed: 4
					cycleSpeed: 4
					setCycle: Walk
					setMotion: MoveTo 203 79 self
					checkDetail:
				)
			)
			(1
				(lancer2 dispose:)
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
				(outlaw2
					moveSpeed: 4
					cycleSpeed: 4
					setCycle: Walk
					setMotion: MoveTo 203 79 self
					checkDetail:
				)
			)
			(1
				(outlaw2 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance timer2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(victim2 view: 115 cel: 0 setCycle: End self)
			)
			(1
				(victim2 stopUpd:)
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
				(lancer3
					loop: 2
					priority: 0
					signal: (| (lancer3 signal:) $0010)
					x: 12
					y: 113
					moveSpeed: 4
					cycleSpeed: 4
					setCycle: Walk
					setMotion: MoveTo 158 95 self
					checkDetail:
				)
			)
			(1
				(lancer3 dispose:)
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
				(outlaw
					init:
					priority: 0
					signal: (| (outlaw signal:) $0010)
					moveSpeed: 4
					cycleSpeed: 4
					setCycle: Walk
					setMotion: MoveTo 156 95 self
					checkDetail:
				)
			)
			(1
				(outlaw dispose:)
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
				(knave view: 115 cel: 0 setCycle: End self)
			)
			(1
				(knave stopUpd:)
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
				(= local0 1)
				(robin view: 10 cel: 0 setScript: 0 setCycle: End self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance timer6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(robin setCycle: Beg self)
			)
			(1
				(gRgnMusic flags: (| (gRgnMusic flags:) $0001))
				(gSFX flags: (| (gRgnMusic flags:) $0001) stop:)
				(archer setScript: 0 setCycle: 0)
				(archer2 setScript: 0 setCycle: 0)
				(knave2 setScript: 0)
				(knave3 setScript: 0)
				(= ticks 12)
			)
			(2
				(Say 172 0 self 108) ; "Seize the treasure!"
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom newRoom: 179) ; synop
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
				(client cycleSpeed: 8 cel: 0 setCycle: End self checkDetail:)
			)
			(1
				(= local6 (Random 4 8))
				(= state -1)
				(= ticks (* local6 10))
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
				(client cycleSpeed: 8 cel: 0 setCycle: End self checkDetail:)
			)
			(1
				(= local7 (Random 7 10))
				(= state -1)
				(= ticks (* local7 10))
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
				(client cycleSpeed: 8 cel: 0 setCycle: End self checkDetail:)
			)
			(1
				(= local8 (Random 5 9))
				(= state -1)
				(= ticks (* local8 10))
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance shoot1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 12)
			)
			(1
				(client cel: 0 cycleSpeed: 8 setCycle: End self checkDetail:)
			)
			(2
				(= local3 (Random 4 9))
				(= state -1)
				(= ticks (* local3 10))
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance shoot2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 cycleSpeed: 8 setCycle: End self checkDetail:)
			)
			(1
				(= local4 (Random 4 9))
				(= state -1)
				(= ticks (* local4 20))
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance shoot3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 cycleSpeed: 8 setCycle: End self checkDetail:)
			)
			(1
				(= local5 (Random 4 9))
				(= state -1)
				(= ticks (* local5 10))
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance shoot4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 cycleSpeed: 8 setCycle: End self checkDetail:)
			)
			(1
				(= local2 (Random 4 9))
				(= state -1)
				(= ticks (* local2 10))
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance musicScript of Script
	(properties)

	(method (cue)
		(switch (gRgnMusic prevSignal:)
			(1)
			(2
				(lancer2 init: setScript: timer0A)
			)
			(3
				(outlaw2 init: setScript: timer1)
			)
			(4
				(victim2 setScript: timer2)
			)
			(5
				(lancer3 init: setScript: timer2A)
			)
			(6
				(outlaw setScript: timer3)
			)
			(7
				(knave setScript: timer4)
			)
			(8
				(robin setScript: timer5)
			)
			(9
				(gSFX stop:)
				(robin setScript: timer6)
			)
			(-1
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)


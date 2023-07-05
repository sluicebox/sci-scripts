;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 315)
(include sci.sh)
(use Main)
(use Sync)
(use PolyPath)
(use Wander)
(use Chase)
(use Avd)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	local0
	local1
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(DoAudio audWPLAY 6)
				(gEgo
					observeControl: 16384
					setMotion:
						PolyPath
						(global109 x:)
						(+ (global109 y:) 20)
						self
				)
			)
			(1
				(proc0_9)
				(Load rsVIEW 44)
				(Load rsSCRIPT 970)
				(Load rsSCRIPT 972)
				(gEgo
					setMotion:
						PolyPath
						(- (gEgo x:) 10)
						(+ (gEgo y:) 10)
						self
				)
				(gLongSong stop:)
				(rhymeSync init: 6)
			)
			(2
				(proc0_7 gEgo global109)
				(gEgo ignoreControl: 16384 stopUpd:)
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(proc0_16 (Format @global300 315 0)) ; "There was a crooked man,"
				(global109
					setAvoider: ((Avd new:) offScreenOK: 1)
					setLoop: 1
					setCycle: Walk
					setScript: manActions
				)
				((global109 head:) hide:)
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				else
					(proc0_16 (Format @global300 315 1)) ; "Who went a crooked mile,"
				)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(proc0_16 (Format @global300 315 2)) ; "He found a crooked sixpence,"
				)
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(proc0_16 (Format @global300 315 3)) ; "Beside a crooked stile;"
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				else
					(proc0_16 (Format @global300 315 4)) ; "He bought a crooked cat"
					(= local0 1)
				)
				(= cycles 1)
			)
			(9
				(if (< (rhymeSync prevSignal:) 60)
					(-- state)
				else
					(proc0_16 (Format @global300 315 5)) ; "Which caught a crooked mouse,"
					(= local0 2)
				)
				(= cycles 1)
			)
			(10
				(if (< (rhymeSync prevSignal:) 70)
					(-- state)
				else
					(proc0_16 (Format @global300 315 6)) ; "And they all lived together"
				)
				(= cycles 1)
			)
			(11
				(if (< (rhymeSync prevSignal:) 80)
					(-- state)
				else
					(proc0_16 (Format @global300 315 7)) ; "In a crooked little house."
				)
				(= cycles 1)
			)
			(12
				(if (or (rhymeSync playing:) (global109 script:))
					(-- state)
					(= cycles 1)
				else
					(global109 dispose:)
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				)
			)
			(13
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 970)
		(DisposeScript 972)
		(DisposeScript 985)
		(DisposeScript 315)
	)
)

(instance manActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global109 setMotion: MoveTo 156 115 self)
			)
			(1
				(global110 setCycle: End self)
			)
			(2
				(mouse init: setScript: mouseActions self)
				(global109 setLoop: 0 setMotion: MoveTo 273 149 self)
			)
			(3)
			(4
				(if (not local0)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(mouse ignoreBlocks: mouseCage setMotion: MoveTo 194 141)
				(cat init:)
				(global109
					moveSpeed: 1
					setLoop: 1
					setMotion: MoveTo 219 128 self
				)
			)
			(6
				(if (< local0 2)
					(-- state)
				)
				(= cycles 1)
			)
			(7
				(mouse setAvoider: 0 setMotion: MoveTo 160 99)
				(cat xStep: 3 setMotion: Chase mouse 9 self)
			)
			(8
				(mouse hide:)
				(cat setAvoider: 0 setLoop: 7 cel: 0 setCycle: End self)
			)
			(9
				(cat setScript: enterHouse self)
			)
			(10
				(cat dispose:)
				(global109 hide:)
				(self dispose:)
			)
		)
	)
)

(instance mouseActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mouse setMotion: MoveTo 150 103 self)
			)
			(1
				(mouse setMotion: MoveTo 168 133 self)
			)
			(2
				(mouseCage init:)
				(mouse observeBlocks: mouseCage setMotion: Wander)
				(self dispose:)
			)
		)
	)
)

(instance enterHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cat
					ignoreControl: -1
					setLoop: 8
					setCycle: Walk
					setMotion: MoveTo 127 97 self
				)
				(global109 ignoreControl: -1 setMotion: MoveTo 160 117 self)
			)
			(1)
			(2
				(cat illegalBits: 0 setMotion: MoveTo 109 94)
				(mouse dispose:)
				(global109 ignoreControl: -1 setMotion: MoveTo 152 106 self)
			)
			(3
				(global109
					setLoop: 14
					setCel: 0
					setCycle: End self
					setMotion: MoveTo 110 97 self
				)
			)
			(4)
			(5
				(global110 setCycle: Beg self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance mouse of Actor
	(properties
		x 129
		y 103
		yStep 1
		view 44
		signal 16384
		xStep 1
	)

	(method (init)
		(super init:)
		(self setCycle: Walk)
	)
)

(instance cat of Actor
	(properties
		x 275
		y 110
		view 83
		loop 6
		signal 18432
		illegalBits 0
		xStep 4
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd setMotion: NewFollow global109 5)
	)
)

(instance mouseCage of Cage
	(properties
		top 95
		left 148
		bottom 145
		right 205
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)


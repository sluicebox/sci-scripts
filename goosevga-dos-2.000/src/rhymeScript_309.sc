;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 309)
(include sci.sh)
(use Main)
(use Sync)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	local0
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(DoAudio audWPLAY 15)
				(proc0_9)
				(Load rsVIEW 68)
				(gLongSong stop:)
				(rhymeSync init: 15)
				(global129
					moveSpeed: 2
					illegalBits: $8000
					setMotion: MoveTo 153 110 self
				)
			)
			(1
				(HandsOff)
				(global129
					view: 68
					setCel: 0
					setLoop: 0
					cycleSpeed: 4
					setCycle: End self
				)
				((global129 head:) dispose:)
			)
			(2
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(3
				(proc0_16 (Format @global300 309 0)) ; "Little Miss Muffet sat on a tuffet,"
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(proc0_16 (Format @global300 309 1)) ; "Eating of curds and whey;"
				(global129 setLoop: 1 setCel: 0 setCycle: Fwd)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(proc0_16 (Format @global300 309 2)) ; "Along came a spider,"
					(spider init: setMotion: MoveTo 131 83)
				)
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				else
					(proc0_16 (Format @global300 309 3)) ; "And sat down beside her,"
					(global129 setLoop: 2 setCel: 0 setCycle: End freakOut)
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 60)
					(-- state)
					(= cycles 1)
				else
					(proc0_16 (Format @global300 309 4)) ; "And frightened Miss Muffet away."
					(global129 setCel: 0 setLoop: 5 setCycle: End self)
				)
			)
			(9
				(global129
					setLoop: 6
					setCycle: Walk
					xStep: 3
					cycleSpeed: 2
					x: 163
					setMotion: MoveTo 207 62 self
				)
			)
			(10
				(global129 setPri: 0 setMotion: MoveTo 214 95 self)
			)
			(11
				(global129 hide:)
				(spider setMotion: MoveTo 131 44 self)
			)
			(12
				(if (== (rhymeSync playing:) 0)
					(proc0_16 0)
					(web dispose:)
					(spider dispose:)
					(= global129 0)
					(proc0_10)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(13
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(if (== gScore gPossibleScore)
					(gCurRoom setScript: (ScriptID 205)) ; walkTo
				else
					(HandsOn)
				)
				(self dispose:)
				(= local0 1)
			)
		)
		(= global166 0)
		(if local0
			(DisposeScript 309)
		)
	)
)

(instance spider of Actor
	(properties
		x 131
		y 44
		view 68
		loop 4
		priority 7
		signal 26640
		cycleSpeed 4
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
		(web init: self)
	)
)

(instance web of Prop
	(properties
		view 68
		loop 8
	)

	(method (doit)
		(self setPri: (spider priority:))
		(= x (spider x:))
		(= y (spider y:))
		(= z (CelHigh (spider view:) (spider loop:) (spider cel:)))
		(super doit:)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

(instance freakOut of Script
	(properties)

	(method (cue)
		((View new:) view: 68 setLoop: 7 setCel: 0 posn: 135 114 init: stopUpd:)
		(global129 setLoop: 3 setCycle: Fwd)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 318)
(include sci.sh)
(use Main)
(use Sync)
(use Avoid)
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
				(Load rsVIEW 90)
				(Load rsVIEW (- global114 300))
				(Load rsVIEW 60)
				(proc0_9)
				(Load rsSCRIPT 985)
				(Load rsCURSOR 69)
				(gLongSong stop:)
				(gEgo setScript: egoScript)
			)
			(1
				(rhymeSync init: 9)
				(= cycles 3)
			)
			(2
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				else
					(proc0_16 (Format @global300 318 0)) ; "Ride a cockhorse to Banbury Cross,"
					(horse init: setMotion: MoveTo 129 117)
				)
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(proc0_16 (Format @global300 318 1)) ; "To see a fine lady upon a white horse."
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				)
				(= cycles 1)
			)
			(6
				(proc0_16 (Format @global300 318 2)) ; "With rings on her fingers,"
				(horse setLoop: 1 setCel: 0 cycleSpeed: 3 setCycle: CT 5 1)
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(proc0_16 (Format @global300 318 3)) ; "And bells on her toes,"
					(if (== (horse cel:) 5)
						(horse setCel: 0)
					)
					(horse setCycle: End)
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				)
				(= cycles 1)
			)
			(9
				(proc0_16 (Format @global300 318 4)) ; "She shall have music wherever she goes."
				(cockHorse dispose:)
				(horse
					setLoop: 0
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 231 102 self
				)
			)
			(10
				(horse setMotion: MoveTo 290 96 self)
			)
			(11
				(if (== (rhymeSync playing:) 0)
					(proc0_16 0)
					(horse dispose:)
					(proc0_10)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(12
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 1 loop: -1 play:)
				(if (== gScore gPossibleScore)
					(gCurRoom setScript: (ScriptID 205)) ; walkTo
				else
					(HandsOn)
				)
				(self dispose:)
				(= local0 1)
			)
		)
		(if local0
			(DisposeScript 318)
		)
	)
)

(instance egoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 133 110 self
				)
			)
			(1
				(rhymeScript cue:)
				(cockHorse init:)
				(global129 put: ignoreActors: 1 hide:)
				(= [global200 18] -1)
				(= cycles 1)
			)
			(2
				(gEgo setAvoider: 0 setMotion: MoveTo 105 145 self)
			)
			(3
				(proc0_7 gEgo cockHorse)
				(gEgo stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance horse of Act
	(properties
		y 96
		x -34
		view 90
		cel 2
		illegalBits 0
		xStep 5
		moveSpeed 1
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCycle: Walk)
	)
)

(instance cockHorse of View
	(properties
		y 107
		x 134
		view 60
		signal 26881
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)


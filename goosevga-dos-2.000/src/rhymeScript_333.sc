;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 333)
(include sci.sh)
(use Main)
(use Sync)
(use PolyPath)
(use Timer)
(use Path)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	[local0 7] = [129 130 60 131 -14 128 -32768]
	local7
)

(instance runAcrossScreen of Path
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if global157
					(DoAudio audWPLAY 14)
				else
					(Load rsSOUND 14)
				)
				(Load rsSCRIPT 983)
				(Load rsSCRIPT 985)
				(Load rsVIEW 55)
				(Load rsVIEW 202)
				(HandsOff)
				(gEgo setScript: egoPlaceCandle)
				(global109 setScript: jackBeingNimble)
				(gLongSong stop:)
				(rhymeSync init: 14)
				(= seconds 2)
			)
			(1
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				else
					(proc0_16 (Format @global300 333 0)) ; "Jack be nimble,"
				)
				(= cycles 1)
			)
			(2
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				else
					(proc0_16 (Format @global300 333 1)) ; "Jack be quick,"
				)
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(proc0_16 (Format @global300 333 2)) ; "Jack jump over the candlestick."
				)
				(= cycles 1)
			)
			(4
				(if (or (global109 script:) (< (rhymeSync prevSignal:) 60))
					(-- state)
					(= cycles 1)
				else
					(if global130
						(egoPlaceCandle changeState: 1)
					)
					(global109
						posn: -14 122
						setLoop: 6
						cel: 1
						setMotion: MoveTo 34 122 self
					)
				)
			)
			(5
				(global109
					setPri: 15
					setLoop: 8
					setCycle: Fwd
					cycleSpeed: 6
					cel: 0
					setMotion: MoveTo 70 121 self
				)
			)
			(6
				(buttFire init:)
				(global109
					setLoop: 6
					setCycle: Walk
					cel: 1
					setMotion: MoveTo 130 121 self
				)
			)
			(7
				(global109
					setLoop: 9
					setCel: 0
					cycleSpeed: 5
					setCycle: CT 6 1 self
				)
			)
			(8
				(if (rhymeSync playing:)
					(-- state)
				)
				(= cycles 1)
			)
			(9
				(buttFire dispose:)
				(global109 setCycle: End self)
			)
			(10
				(proc0_16 0)
				(exaust init: setCycle: End self)
				(if global157
					(Timer set60ths: self (DoAudio audPLAY 23))
				else
					(gSfx number: 23 play: self)
				)
			)
			(11)
			(12
				(DoAudio audSTOP)
				(exaust dispose:)
				(if global157
					(Timer set60ths: self (DoAudio audPLAY 24))
				else
					(gSfx number: 24 play: self)
				)
			)
			(13
				(global109 yStep: 7 posn: 152 -1 setMotion: MoveTo 153 143 self)
				(if global157
					(DoAudio audWPLAY 28)
				)
			)
			(14
				(if global157
					(Timer set60ths: self (DoAudio audPLAY 28))
				else
					(gSfx number: 28 play: self)
				)
				(global109
					setLoop: 11
					setCel: 0
					posn: 153 150
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(15)
			(16
				(global109 setLoop: 12 setCel: 0 setCycle: End self)
			)
			(17
				(if
					(and
						(== (global109 cel:) (global109 lastCel:))
						(== (rhymeSync playing:) 0)
					)
					(global109 loop: 0 stopUpd:)
					(proc0_10)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(18
				(gEgo setScript: 0 setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(if (== gScore gPossibleScore)
					(gCurRoom setScript: (ScriptID 205)) ; walkTo
				else
					(HandsOn)
				)
				(self dispose:)
				(= local7 1)
			)
		)
		(if local7
			(DisposeScript 333)
		)
	)
)

(instance jackBeingNimble of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(global110 dispose:)
				(global109
					head: 0
					ignoreActors: 1
					cycleSpeed: 2
					setCycle: Walk
					setLoop: 6
					setMotion: MoveTo 268 95 self
				)
			)
			(2
				(global109 setLoop: 7 setMotion: runAcrossScreen self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance egoPlaceCandle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 60 119 self)
			)
			(1
				(global111 init:)
				(proc0_9)
				((gGoals at: 12) egoHas: 0)
				(gEgo setMotion: 0 ignoreControl: 4 posn: 60 119 setLoop: 2)
				(DisposeScript 985)
				(= seconds 2)
			)
			(2
				(gEgo setLoop: -1 setMotion: MoveTo 90 120 self)
			)
			(3
				(gEgo setMotion: MoveTo 185 105 self)
			)
			(4
				(proc0_7 gEgo global111)
				(gEgo stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance exaust of Prop
	(properties
		x 128
		y 124
		view 89
		loop 10
		priority 15
		signal 16
		cycleSpeed 11
	)

	(method (doit)
		(super doit:)
		(if (< cel 8)
			(global109 y: (+ 2 (- y (CelHigh view loop cel))))
		)
	)
)

(instance buttFire of Prop
	(properties
		x 65
		y 112
		view 89
		loop 3
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (doit)
		(super doit:)
		(= x (- (global109 x:) 5))
		(= y (- (global109 y:) 9))
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)


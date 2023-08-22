;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 333)
(include sci.sh)
(use Main)
(use Sync)
(use Path)
(use Avoid)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	[local0 7] = [129 130 60 131 -13 128 -32768]
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
				(Load rsCURSOR 69)
				(Load rsSCRIPT 983)
				(Load rsSCRIPT 985)
				(Load rsVIEW 55)
				(Load rsVIEW 202)
				(Load rsFONT 8)
				(Load rsFONT 9)
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
				)
				(= cycles 1)
			)
			(2
				(proc0_16 (Format @global300 333 0)) ; "Jack be nimble,"
				(= cycles 1)
			)
			(3
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(proc0_16 (Format @global300 333 1)) ; "Jack be quick,"
				(= cycles 1)
			)
			(5
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				)
				(= cycles 1)
			)
			(6
				(proc0_16 (Format @global300 333 2)) ; "Jack jump over the candlestick."
				(= cycles 1)
			)
			(7
				(if (or (global109 script:) (< (rhymeSync prevSignal:) 60))
					(-- state)
				)
				(= cycles 1)
			)
			(8
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
			(9
				(global109
					setPri: 15
					setLoop: 8
					cel: 0
					setMotion: MoveTo 70 121 self
				)
			)
			(10
				(buttFire init:)
				(global109 setLoop: 6 cel: 1 setMotion: MoveTo 130 121 self)
			)
			(11
				(global109
					setLoop: 9
					setCel: 0
					cycleSpeed: 5
					setCycle: CT 6 1 self
				)
			)
			(12
				(if (rhymeSync playing:)
					(-- state)
				)
				(= cycles 1)
			)
			(13
				(buttFire dispose:)
				(global109 setCycle: End self)
			)
			(14
				(proc0_16 0)
				(exaust init: setCycle: End self)
				(Timer set60ths: self (DoAudio audPLAY 23))
			)
			(15)
			(16
				(DoAudio audSTOP)
				(exaust dispose:)
				(Timer set60ths: self (DoAudio audPLAY 24))
			)
			(17
				(global109 yStep: 7 posn: 152 -1 setMotion: MoveTo 153 143 self)
				(DoAudio audWPLAY 28)
			)
			(18
				(Timer set60ths: self (DoAudio audPLAY 28))
				(global109
					setLoop: 11
					setCel: 0
					posn: 153 150
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(19)
			(20
				(global109 setLoop: 12 setCel: 0 setCycle: End self)
			)
			(21
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
			(22
				(gEgo setScript: 0 setMotion: 0 setLoop: -1)
				(gLongSong number: 1 loop: -1 play:)
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
				(gEgo
					observeControl: 4
					setAvoider: (Avoid new:)
					setMotion: MoveTo 60 119 self
				)
			)
			(1
				(global111 init:)
				(proc0_9)
				((gGoals at: 12) egoHas: 0)
				(gEgo
					setMotion: 0
					setAvoider: 0
					ignoreControl: 4
					posn: 60 119
					setLoop: 1
				)
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
		y 124
		x 128
		view 89
		loop 10
		priority 15
		signal 16
		cycleSpeed 3
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
		y 112
		x 65
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


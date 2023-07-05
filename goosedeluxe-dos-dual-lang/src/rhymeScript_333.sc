;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 333)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
(use PolyPath)
(use Path)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	[local0 7] = [129 130 60 131 -15 128 32768]
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

	(method (changeState newState &tmp temp0)
		(= temp0 (Str new: 50))
		(switch (= state newState)
			(0
				(= local7 0)
				(Load rsSCRIPT 64983)
				(Load rsVIEW 55)
				(Load rsVIEW 202)
				(gLongSong stop:)
				(proc0_9)
				(global109 setScript: jackBeingNimble)
				(gMessager say: 1 0 0 15 0 400) ; "JACK BE NIMBLE"
				(rhymeSync init: 400 1 0 0 15)
				(gEgo ignoreActors: 1 setMotion: PolyPath 50 130 self)
			)
			(1
				(global111
					posn: (gEgo x:) (gEgo y:)
					setPri: (- (gEgo priority:) 1)
					show:
				)
				((gGoals at: 12) egoHas: 0 egoReturned: 1)
				(gEgo
					setLoop: 0
					setCycle: Walk
					setMotion: PolyPath 90 120 self
				)
			)
			(2
				(cond
					((< (rhymeSync prevSignal:) 10)
						(-- state)
					)
					(gLanguage
						(proc0_16 (temp0 format: {Jack se #gil,}))
					)
					(else
						(proc0_16 (temp0 format: {Jack be nimble,}))
					)
				)
				(= cycles 1)
			)
			(3
				(cond
					((< (rhymeSync prevSignal:) 20)
						(-- state)
					)
					(gLanguage
						(proc0_16 (temp0 format: {Jack se r#pido,}))
					)
					(else
						(proc0_16 (temp0 format: {Jack be quick,}))
					)
				)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(if gLanguage
						(proc0_16
							(temp0 format: {Jack salt& sobre el candelero.})
						)
					else
						(proc0_16
							(temp0 format: {Jack jumped over the candlestick.})
						)
					)
					(gEgo setMotion: PolyPath 185 105 0 0)
				)
				(= cycles 1)
			)
			(5
				(cond
					((< (rhymeSync prevSignal:) 40)
						(-- state)
					)
					(gLanguage
						(proc0_16 (temp0 format: {Jack se #gil,}))
					)
					(else
						(proc0_16 (temp0 format: {Jack be nimble,}))
					)
				)
				(= cycles 1)
			)
			(6
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				else
					(if gLanguage
						(proc0_16 (temp0 format: {Jack se r#pido,}))
					else
						(proc0_16 (temp0 format: {Jack be quick,}))
					)
					(proc0_7 gEgo global111)
				)
				(= cycles 1)
			)
			(7
				(cond
					((< (rhymeSync prevSignal:) 60)
						(-- state)
					)
					(gLanguage
						(proc0_16
							(temp0 format: {Jack salt& sobre el candelero.})
						)
					)
					(else
						(proc0_16
							(temp0 format: {Jack jumped over the candlestick.})
						)
					)
				)
				(= cycles 1)
			)
			(8
				(if (or (global109 script:) (< (rhymeSync prevSignal:) 60))
					(-- state)
					(= cycles 1)
				else
					(global109
						posn: -3 122
						setLoop: 6 1
						cel: 1
						setMotion: MoveTo 34 130 self
					)
				)
			)
			(9
				(global109
					setPri: 201
					setLoop: 8 1
					setCycle: Fwd
					cycleSpeed: 6
					cel: 0
					setMotion: MoveTo 70 130 self
				)
			)
			(10
				(buttFire init:)
				(global109
					setLoop: 6 1
					setCycle: Walk
					cel: 1
					setMotion: MoveTo 125 114 self
				)
			)
			(11
				(global109
					setLoop: 9 1
					cel: 0
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
				(global109 setLoop: 10 1 cel: 0 cycleSpeed: 11 setCycle: End)
				(gSfx number: 23 play: self)
			)
			(15
				(global109 hide:)
				(gSfx number: 24 play: self)
			)
			(16
				(global109
					show:
					setLoop: 9 1
					cel: 11
					yStep: 7
					moveSpeed: (- (global109 moveSpeed:) 4)
					posn: 152 -1
					setMotion: MoveTo 153 143 self
				)
			)
			(17
				(gSfx number: 28 play: self)
				(gEgo setLoop: 2)
				(global109
					setLoop: 11 1
					cel: 0
					posn: 153 150
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(18
				(global109 hide:)
				(= seconds 1)
			)
			(19
				(global109 setLoop: 12 1 cel: 0 show: setCycle: End self)
			)
			(20
				(if
					(and
						(== (global109 cel:) (global109 lastCel:))
						(== (rhymeSync playing:) 0)
					)
					(global110
						view: 89
						setLoop: 0
						x: (global109 x:)
						y: (global109 y:)
						show:
					)
					(global109 hide:)
					(proc0_10)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(21
				(gEgo setScript: 0 setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(= local7 1)
			)
		)
		(temp0 dispose:)
		(if local7
			(if (>= gScore gPossibleScore)
				(gCurRoom setScript: (ScriptID 205)) ; walkTo
			)
			(self dispose:)
		)
	)
)

(instance jackBeingNimble of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global109
					cycleSpeed: 6
					setCycle: Fwd
					setLoop: 6 1
					setMotion: MoveTo 260 95 self
				)
			)
			(1
				(global109 setLoop: 7 1 setMotion: runAcrossScreen self)
			)
			(2
				(self dispose:)
			)
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


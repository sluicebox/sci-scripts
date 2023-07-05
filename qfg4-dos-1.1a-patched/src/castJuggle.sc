;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	castJuggle 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= temp1 32768)
	(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
		(if (& global200 temp1)
			(gTheIconBar disable: temp0)
		)
		(>>= temp1 $0001)
	)
)

(instance castJuggle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(self setScript: faceEgo self)
				else
					(gEgo setMotion: 0)
					(Face gEgo (+ (gEgo x:) 5) (+ (gEgo y:) 5))
					(= cycles (+ (gEgo cycleSpeed:) 5))
				)
			)
			(1
				(gLongSong3 number: 944 setLoop: 1 play:)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo view: 19 loop: 5 cel: 0 setCycle: End self)
				else
					(gEgo view: 15 loop: 0 setCycle: End self)
				)
			)
			(2
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(self cue:)
				else
					(gEgo setCycle: CT 4 -1 self)
				)
			)
			(3
				((= local1 (Prop new:))
					signal: 24577
					view: 99
					loop: 0
					cel: 0
					x: (gEgo x:)
					y: (gEgo y:)
					z: (/ (gEgo scaleY:) 2)
					setPri: (+ (gEgo priority:) 1)
					init:
					setScale:
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					setCycle: Fwd
				)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(self cue:)
				else
					(gEgo setCycle: CT 2 -1 self)
				)
			)
			(4
				(ClearFlag 6)
				(cond
					((or (< 2800 gClock 3600) (<= 0 gClock 771))
						(PalVary 1 4) ; PalVaryReverse
					)
					((< 2600 gClock 2801)
						(PalVary 1 4) ; PalVaryReverse
					)
					((< 770 gClock 871)
						(PalVary 1 4) ; PalVaryReverse
					)
				)
				(= seconds 9)
			)
			(5
				(local1 dispose:)
				(gEgo setCycle: CT 0 -1 self)
			)
			(6
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo view: 20 loop: 2 cel: 4)
				else
					(gEgo normalize: 4)
				)
				(proc0_16)
				(= ticks 3)
			)
			(7
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(SetFlag 6)
		(gGlory handsOn:)
		(localproc_0)
		(super dispose:)
	)
)

(instance faceEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo loop:) 2)
					(if (== (gEgo loop:) 6)
						(gEgo loop: 2 cel: 4)
					else
						(gEgo loop: (- (gEgo loop:) 1))
					)
				else
					(self dispose:)
				)
				(= cycles (gEgo cycleSpeed:))
			)
			(1
				(self init: client caller)
			)
		)
	)
)


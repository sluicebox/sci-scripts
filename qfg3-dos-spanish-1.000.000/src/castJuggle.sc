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
	(= temp1 -32768)
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
				(HandsOff)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(self setScript: faceEgo self)
				else
					(gEgo setMotion: 0)
					(Face gEgo (+ (gEgo x:) 5) (+ (gEgo y:) 5))
					(= cycles (+ (gEgo cycleSpeed:) 5))
				)
			)
			(1
				(gLongSong2 number: 900 setLoop: 1 play:)
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
					view: 111
					loop: 0
					cel: 0
					x: (gEgo x:)
					y: (gEgo nsTop:)
					priority: (+ (gEgo priority:) 1)
					signal: 16
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
					((== (= local0 (PalVary pvGET_CURRENT_STEP)) 0)
						(= local2 0)
						(= seconds 2)
					)
					((== local0 64)
						(= local2 1)
						(PalVary pvREVERSE 1)
					)
					((> local0 0)
						(= local2 2)
						(PalVary pvREVERSE 1)
					)
					(else
						(= local2 3)
						(PalVary pvREVERSE 1)
					)
				)
				(= seconds 2)
			)
			(5
				(= seconds 3)
			)
			(6
				(local1 dispose:)
				(gEgo setCycle: CT 0 -1 self)
			)
			(7
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo view: 20 loop: 2 cel: 4)
				else
					(gEgo normalize: 4)
				)
				(if (not local2)
					(self dispose:)
				else
					(PalVary pvINIT gCurRoomNum 2 64)
					(= ticks (* 2 (Abs local0)))
				)
			)
			(8
				(switch local2
					(2
						(PalVary pvCHANGE_TICKS (- 64 local0))
					)
					(3
						(PalVary pvREVERSE (Abs local0))
					)
					(else
						(self dispose:)
					)
				)
				(= seconds 1)
			)
			(9
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(SetFlag 6)
		(HandsOn)
		(localproc_0)
		(super dispose:)
		(DisposeScript 62)
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


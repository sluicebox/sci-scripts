;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	sierra 0
)

(local
	local0
	local1
	local2 = 120
	local3 = 40
	local4
	local5
)

(instance sierra of Rm
	(properties
		picture 900
		style 10
	)

	(method (init)
		(super init:)
		(= local4 0)
		(= local5 0)
		(Load rsVIEW 950)
		(self setScript: introScript)
		(gSong play: 1)
		(gSong setLoop: 1)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== (gSong prevSignal:) 20) (not local4))
				(= local4 1)
				(sparkle posn: 223 165 init:)
			)
			((and (== (gSong prevSignal:) 30) (not local5))
				(= local5 1)
				(sparkle posn: 75 165 init:)
			)
			((and (== (gSong prevSignal:) -1) (= local5 1))
				(introScript cue:)
			)
		)
		(Palette palANIMATE 95 218 -1)
		(if (fred mover:)
			(if (== (++ local1) 1)
				(= local0 (+ 180 (GetTime)))
			)
			(if (u< local0 (GetTime))
				(cond
					((< local1 local3)
						(= gHowFast 0)
					)
					((< local1 local2)
						(= gHowFast 1)
					)
					(else
						(= gHowFast 2)
					)
				)
				(fred setMotion: 0)
			)
		)
	)
)

(instance introScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(while (u> (GetTime) 65344)
				)
				(fred
					view: 950
					setLoop: 8
					illegalBits: 0
					posn: 5 8
					setStep: 1 1
					setMotion: MoveTo 300 8
					setPri: 0
					init:
				)
				(= local1 0)
			)
			(1
				(gSong setLoop: -1)
				(gCurRoom newRoom: 2) ; intro
			)
		)
	)
)

(instance sparkle of Prop
	(properties
		view 950
	)

	(method (init)
		(self setLoop: 2 cel: 0 ignoreActors: setPri: 14 setCycle: End)
		(super init:)
	)
)

(instance fred of Actor
	(properties)
)


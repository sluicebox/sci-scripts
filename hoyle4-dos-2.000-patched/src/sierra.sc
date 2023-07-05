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
)

(instance sierra of Rm
	(properties
		picture 900
		style 10
	)

	(method (init)
		(super init:)
		(Load rsVIEW 950)
		(= global119 0)
		(= global193 0)
		(= local4 0)
		(gGame setCursor: gTheCursor 1 319 199)
		(self setScript: introScript)
		(PlaySong play: 1 self 1)
		(gSong setLoop: 1)
	)

	(method (handleEvent event)
		(if (not (event claimed:))
			(event claimed:)
			((gCurRoom script:) state: 0 cue:)
		)
	)

	(method (doit &tmp [temp0 50])
		(super doit:)
		(Palette palANIMATE 112 223 -1)
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

	(method (cue)
		(switch local4
			(1
				(sparkle posn: 223 165 init:)
			)
			(2
				(sparkle posn: 75 165 init:)
			)
			(3
				(introScript cue:)
			)
		)
		(++ local4)
	)

	(method (dispose)
		(UnLoad 128 950)
		(super dispose:)
	)
)

(instance introScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(while (u> (GetTime) -192)
				)
				(fred
					view: 950
					setLoop: 1
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
				(PlaySong play: 0)
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
		(self setLoop: 0 cel: 0 ignoreActors: setPri: 14 setCycle: End)
		(super init:)
	)
)

(instance fred of Actor
	(properties)
)


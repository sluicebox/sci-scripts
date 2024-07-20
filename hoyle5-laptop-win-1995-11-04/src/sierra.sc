;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use Str)
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

(instance sierra of Room
	(properties
		style 14
	)

	(method (init &tmp temp0 temp1)
		(= picture 908)
		(super init:)
		(= temp0 (Str new:))
		(GetConfig {Game} temp0)
		(if (temp0 size:)
			(= temp1 (temp0 asInteger:))
		else
			(= temp1 0)
		)
		(temp0 dispose:)
		(Load rsVIEW 950)
		(= global119 0)
		(= gCardGameScriptNumber 0)
		(= local4 0)
		(gGame setCursor: gTheCursor 1 319 199)
		(if temp1
			(= gCardGameScriptNumber temp1)
			(= gNewRoomNum temp1)
			(gTheIconBar enable:)
			(return)
		)
		(self setScript: introScript)
		(PlaySong play: 1 self 1)
		(gSong setLoop: 1)
		(= local5 2)
	)

	(method (handleEvent event)
		(if (not (event claimed:))
			(event claimed:)
			(if (== (event type:) $0010) ; direction
				(switch (event message:)
					(JOY_DOWNLEFT
						(= local5 100)
					)
					(JOY_DOWN
						(= local5 200)
					)
					(JOY_DOWNRIGHT
						(= local5 300)
					)
					(JOY_LEFT
						(= local5 400)
					)
					(JOY_NULL
						(= local5 500)
					)
					(JOY_RIGHT
						(= local5 600)
					)
					(JOY_UPLEFT
						(= local5 700)
					)
					(JOY_UP
						(= local5 800)
					)
					(JOY_UPRIGHT
						(= local5 900)
					)
				)
				(gGame setCursor: 997 1)
			else
				((gCurRoom script:) state: 0 cue:)
			)
		)
	)

	(method (doit &tmp [temp0 50])
		(super doit:)
		(PalCycle 112 223 -1)
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
				(sparkle posn: 446 386 init:)
			)
			(2
				(sparkle posn: 150 386 init:)
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
				(while (u> (GetTime) 65344)
				)
				(fred
					view: 950
					setLoop: 1
					illegalBits: 0
					posn: 10 19
					setStep: 2 2
					setMotion: MoveTo 600 19
					setPri: 0
					init:
				)
				(= local1 0)
			)
			(1
				(gSong client: 0)
				(gSong stop:)
				(gSong setLoop: -1)
				(PlaySong play: 0)
				(= gNewRoomNum local5)
				(gTheIconBar enable:)
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

	(method (init)
		(gDirectionHandler add: self)
		(super init: &rest)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(gCurRoom handleEvent: event)
	)
)


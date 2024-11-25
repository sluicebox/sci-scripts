;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)

(public
	eRoom 0
)

(class eRoom of Rm
	(properties
		comingIn 1
		goingOut 0
	)

	(method (enterRoom param1 param2 param3 param4 param5)
		(HandsOff)
		(gEgo
			illegalBits: 0
			ignoreActors: 1
			loop: param5
			posn: param1 param2
			setMotion: MoveTo param3 param4 self
		)
	)

	(method (muleEnterRoom param1 param2 param3 param4 param5)
		(if (IsFlag 20)
			(gMuleObj
				loop: param5
				illegalBits: 0
				ignoreActors: 1
				posn: param1 param2
				setMotion: MoveTo param3 param4
			)
		)
	)

	(method (leaveRoom param1 param2 param3)
		(HandsOff)
		(= goingOut param1)
		(gEgo
			illegalBits: 0
			ignoreActors: 1
			setMotion: MoveTo param2 param3 self
		)
	)

	(method (cue)
		(cond
			(goingOut
				(gCurRoom setScript: 0 newRoom: goingOut)
			)
			(comingIn
				(= comingIn 0)
				(gEgo illegalBits: $8000 ignoreActors: 0)
				(if (IsFlag 20)
					(gMuleObj illegalBits: $8000 ignoreActors: 0)
				)
				(HandsOn)
				(if global124
					(User canInput: 0)
				)
			)
			(else
				(super cue:)
			)
		)
	)
)


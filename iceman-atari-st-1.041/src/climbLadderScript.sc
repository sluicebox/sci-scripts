;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 393)
(include sci.sh)
(use Main)
(use Interface)
(use Submarine_806)
(use n821)
(use Motion)
(use User)
(use System)

(public
	climbLadderScript 0
)

(instance climbLadderScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(User mapKeyToDir: 0)
		(gIceKeyDownHandler add: self)
	)

	(method (dispose)
		(gIceKeyDownHandler delete: self)
		(User mapKeyToDir: 1)
		(super dispose:)
		(DisposeScript 393)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setLoop: 6
					illegalBits: 0
					setMotion: MoveTo 298 (gEgo y:) self
				)
			)
			(1
				(gEgo
					view: 238
					setLoop: 0
					heading: 0
					setMotion: MoveTo 298 52 self
				)
			)
			(2
				(User canInput: 1)
				(Print 393 0) ; "The watertight hatch prevents you from climbing any further."
			)
			(3
				(User canInput: 0)
				(gEgo setMotion: MoveTo 298 42 self)
			)
			(4
				(gCurRoom newRoom: 28) ; bridgeRm
			)
		)
	)

	(method (handleEvent event)
		(cond
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_DOWN))
				(gEgo setScript: (ScriptID 391)) ; egoDownLadderScript
			)
			((super handleEvent: event))
			((Said 'open/hatch')
				(if (> (Submarine depth:) 20)
					(EgoDead 926 3 0 393 1) ; "Now that wasn't very smart, was it?"
				else
					(self cue:)
				)
			)
			((Said '[go,climb]<down')
				(gEgo setScript: (ScriptID 391)) ; egoDownLadderScript
			)
		)
	)
)


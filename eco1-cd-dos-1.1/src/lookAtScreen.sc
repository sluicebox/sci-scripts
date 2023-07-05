;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
(include sci.sh)
(use Main)
(use System)

(public
	lookAtScreen 0
)

(instance lookAtScreen of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 63)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCast eachElementDo: #hide)
				(gEgo stopUpd:)
				(= register ((ScriptID 400 11) script:)) ; junk
				((ScriptID 400 11) script: 0) ; junk
				(gCurRoom drawPic: 1 -32761)
				(= seconds 3)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 30 1 self) ; Adam, "I'd love to play King's Quest V for a while, but I've got other things to do!"
			)
			(2
				(= seconds 3)
			)
			(3
				(gCurRoom drawPic: 901)
				(= cycles 3)
			)
			(4
				(= cycles 3)
			)
			(5
				(gCurRoom drawPic: 400)
				(gCast eachElementDo: #show)
				((ScriptID 400 12) addToPic:) ; book
				((ScriptID 400 11) hide: script: register) ; junk
				(HandsOn)
				(gEgo startUpd:)
				(self dispose:)
			)
		)
	)
)


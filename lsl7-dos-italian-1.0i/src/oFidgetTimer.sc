;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use NewUser)
(use Timer)
(use Motion)
(use System)

(public
	oFidgetTimer 0
	proc60_1 1
	oFidgetClickHandler 2
)

(procedure (proc60_1 param1)
	(if (or (not argc) param1)
		((ScriptID 64017 0) clear: 201) ; oFlags
	else
		((ScriptID 64017 0) set: 201) ; oFlags
	)
)

(instance oFidgetTimer of Timer
	(properties)

	(method (cue)
		(if
			(or
				((ScriptID 64017 0) test: 201) ; oFlags
				((ScriptID 64017 0) test: 158) ; oFlags
				((ScriptID 64040 2) oPlane:) ; L7TalkWindow
				(and gTalkers (not (gTalkers isEmpty:)))
				(not (gUser canControl:))
				(gCurRoom script:)
				(gEgo script:)
				(not (gEgo plane:))
				(not (gEgo isNotHidden:))
				(not ((gEgo plane:) isEnabled:))
				(!= (gEgo view:) 60100)
				(!= (gEgo loop:) 8)
			)
			(self setReal: self 60)
			(return)
		)
		(gGame setScript: soFidget)
	)
)

(instance soFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: (Random 6001 6009)
					loop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(1
				(gEgo normalize: 2 1 setSpeed: register)
				(oFidgetTimer setReal: oFidgetTimer 20)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oFidgetClickHandler of EventCode
	(properties)

	(method (handleEvent event)
		(if (or (& (event type:) evMOUSEBUTTON) (& (event type:) evKEYBOARD))
			((ScriptID 60 0) setReal: (ScriptID 60 0) 90) ; oFidgetTimer, oFidgetTimer
		)
		(return 0)
	)
)


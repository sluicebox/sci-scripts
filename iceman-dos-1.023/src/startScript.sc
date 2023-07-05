;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 376)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(public
	startScript 0
	johnnyLost 1
)

(instance startScript of Script
	(properties
		seconds 2
	)

	(method (init)
		(super init: &rest)
		(gIceKeyDownHandler addToFront: self)
		(gIceMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gIceMouseDownHandler delete: self)
		(gIceKeyDownHandler delete: self)
		(super dispose: &rest)
		(DisposeScript 376)
	)

	(method (handleEvent event)
		(if
			(and
				(OneOf state 1 2)
				(or (== (event type:) evKEYBOARD) (== (event type:) evMOUSEBUTTON))
			)
			(event claimed: 1)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(Print 376 0 #at 35 10 #width 250 #dispose) ; "With a gleam in his eye and excitement in his voice, the Old Seaman says..."
				((ScriptID 39 9) loop: 0 cycleSpeed: 2 setCycle: Fwd) ; saltMouth
			)
			(2
				(Print 376 1 #at 35 10 #width 250 #dispose) ; "Let's roll 'em, Commander, and may lady luck be on yer side!"
			)
			(3
				(proc0_3)
				((ScriptID 39 9) loop: 1 cel: 1 setCycle: 0) ; saltMouth
				((ScriptID 39 0) notify: 10) ; diceRm
				(self dispose:)
			)
		)
	)
)

(instance johnnyLost of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 376)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 39 8) show: cycleSpeed: 1 setCycle: Fwd) ; johnnyMouth
				(= seconds 3)
			)
			(1
				(Print 376 2) ; "You meekly explain to the old Chief, "It appears, Chief Flanagan, that your hot hand has relieved me of all my money.""
				(= cycles 2)
			)
			(2
				((ScriptID 39 8) hide:) ; johnnyMouth
				(proc0_3)
				((ScriptID 39 9) loop: 0 cycleSpeed: 1 setCycle: Fwd) ; saltMouth
				(= seconds 3)
			)
			(3
				(Print 376 3) ; "Aye lad," Flanagan says, "I thank ya from the bottom of me ol' sea heart. Commander, yer a good sport!"
				(= cycles 2)
			)
			(4
				((ScriptID 39 9) loop: 1 cel: 1 setCycle: 0) ; saltMouth
				(SetCursor gTheCursor 1 310 180)
				(gCurRoom newRoom: 32) ; galleyRm
				(self dispose:)
			)
		)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 732)
(include sci.sh)
(use Main)
(use Conversation)
(use Motion)
(use Actor)
(use System)

(public
	enterFromBasement 0
)

(instance enterFromBasement of Script
	(properties)

	(method (init)
		(gGame handsOff:)
		(= register ((ScriptID 80 0) tstFlag: #rFlag1 2)) ; rgCastle
		(if (not register)
			((ScriptID 1015 6) talkWidth: 150 x: 15 y: 20) ; tlkGuardDog1
			((ScriptID 1015 7) talkWidth: 135 x: 160 y: 20) ; tlkGuardDog2
			((ScriptID 80 5) loop: 3 cel: 0 posn: 151 154 init:) ; guard1
			((ScriptID 80 6) loop: 0 cel: 0 posn: 133 146 init:) ; guard2
			(gGlobalSound fadeTo: 700 -1)
		else
			(gGlobalSound fade: 127 5 10 0)
		)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 732)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(gGlobalSound4 number: 901 loop: 1 play:)
				(if (not register)
					(= state 4)
				)
				((ScriptID 730 2) setCycle: CT 3 1 self) ; basementDoor
			)
			(2
				(EgoHead init:)
				(= seconds 3)
			)
			(3
				(gMessager say: 1 0 9 1 self) ; "Alexander looks cautiously around the grand hall, but there are no guard dogs to be seen."
			)
			(4
				(EgoHead dispose:)
				(= seconds 2)
			)
			(5
				((ScriptID 730 2) setCycle: End self) ; basementDoor
			)
			(6
				(gGlobalSound4 stop:)
				(gEgo setMotion: MoveTo 233 144 self)
			)
			(7
				((ScriptID 730 2) setCycle: Beg self) ; basementDoor
			)
			(8
				(gGlobalSound4 number: 902 loop: 1 play:)
				((ScriptID 730 2) stopUpd:) ; basementDoor
				(if (not register)
					(self setScript: guardsCaptureEgo)
				else
					(gMessager say: 1 0 9 2 self) ; "The wedding music is coming from behind those two large doors!"
				)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance guardsCaptureEgo of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound stop:)
				(gGlobalSound2 number: 710 loop: -1 play:)
				(roomConv
					add: -1 1 0 7 1 ; "Uh, oh! Guard dogs!"
					add: -1 1 0 7 2 ; "Look! An intruder! Grab him!"
					add: -1 1 0 7 3 ; "Uh...I was just looking for the kitchen...."
					init: self
				)
			)
			(1
				(gCurRoom moveOtherGuard: 1)
				((ScriptID 80 5) setScript: (ScriptID 80 4) self 1) ; guard1, guardsGetEgo
			)
			(2
				(gMessager say: 1 0 7 4 self oneOnly: 0) ; "I'll bet! You're the foreign saboteur the vizier warned us about!"
			)
			(3
				(gGlobalSound2 fade:)
				((ScriptID 80 0) setFlag: #rFlag1 8192) ; rgCastle
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance roomConv of Conversation
	(properties)
)

(instance EgoHead of View
	(properties
		x 248
		y 113
		view 730
		loop 5
	)
)


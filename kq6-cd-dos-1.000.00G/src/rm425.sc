;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 425)
(include sci.sh)
(use Main)
(use rLab)
(use n402)
(use n913)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	rm425 0
)

(local
	local0
)

(instance rm425 of LabRoom
	(properties
		style 10
		east 400
		west 411
	)

	(method (init)
		(proc402_1)
		(super init: &rest)
		(westDoor addToPic:)
		(westWing addToPic:)
		((ScriptID 30 3) init:) ; theTorch
		((ScriptID 30 0) initCrypt: 1) ; rLab
		((ScriptID 30 6) addToPic:) ; rightDoor
		((ScriptID 30 10) addToPic:) ; rightWing
		((ScriptID 30 8) addToPic:) ; bottomBlock
		(gCurRoom setScript: (ScriptID 30 1) self) ; walkIn
	)

	(method (cue)
		(if (not (IsFlag 1))
			(switch ((ScriptID 30 0) timesGenieHasAppeared:) ; rLab
				(0
					(genie init: setScript: genieMeeting)
					((ScriptID 30 0) geniePresent: 1) ; rLab
				)
				(1
					(genieMeeting start: 12)
					(genie init: setScript: genieMeeting)
					((ScriptID 30 0) geniePresent: 1) ; rLab
				)
				(2
					(genieMeeting start: 22)
					(genie init: setScript: genieMeeting)
					((ScriptID 30 0) geniePresent: 1) ; rLab
				)
				(else
					((ScriptID 30 0) ; rLab
						timesGenieHasAppeared:
							(+ ((ScriptID 30 0) timesGenieHasAppeared:) 1) ; rLab
					)
				)
			)
		)
	)

	(method (notify)
		(westDoor addToPic:)
		(westWing addToPic:)
		((ScriptID 30 6) addToPic:) ; rightDoor
		((ScriptID 30 10) addToPic:) ; rightWing
		((ScriptID 30 8) addToPic:) ; bottomBlock
		((ScriptID 30 3) show:) ; theTorch
	)

	(method (dispose)
		((ScriptID 30 0) geniePresent: 0) ; rLab
		(super dispose:)
	)
)

(instance genieMeeting of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(if (< (gEgo x:) 130)
					(gEgo setMotion: PolyPath 130 (gEgo y:) self)
				else
					(self cue:)
				)
			)
			(2
				((ScriptID 30 0) ; rLab
					timesGenieHasAppeared:
						(+ ((ScriptID 30 0) timesGenieHasAppeared:) 1) ; rLab
				)
				(= temp1 (GetAngle (gEgo x:) (gEgo y:) 85 158))
				(gEgo setHeading: temp1)
				(= local0 1)
				(genie
					posn: 26 158
					init:
					setCycle: Walk
					setMotion: PolyPath 85 158 self
				)
			)
			(3
				(glint init:)
			)
			(4
				(genie view: 442 setLoop: 6 cel: 0 setCycle: End self)
			)
			(5
				(= seconds 2)
			)
			(6
				(genie setCycle: Beg self)
			)
			(7
				(gMessager say: 1 0 20 0 self 400) ; "(URGENTLY, FRIGHTENED) Ah! You are a human only and not the monster himself! I heard you coming and thought you were the beast. Did my father send you here to save me?"
			)
			(8
				(genie view: 442 setLoop: 3 cel: 0 setCycle: End self)
			)
			(9
				(genie view: 442 setLoop: 4 cel: 0)
				(= cycles 2)
			)
			(10
				(genie
					view: 364
					setLoop: -1
					setCycle: Walk
					setMotion: PolyPath 26 164 self
				)
			)
			(11
				(gGame handsOn:)
				(= seconds 30)
			)
			(12
				(gGame handsOff:)
				(= seconds 3)
			)
			(13
				(genie posn: 26 158)
				(= cycles 2)
			)
			(14
				(if (< (gEgo x:) 130)
					(gEgo setMotion: PolyPath 130 (gEgo y:) self)
				else
					(self cue:)
				)
			)
			(15
				((ScriptID 30 0) ; rLab
					timesGenieHasAppeared:
						(+ ((ScriptID 30 0) timesGenieHasAppeared:) 1) ; rLab
				)
				(= temp1 (GetAngle (gEgo x:) (gEgo y:) 85 158))
				(gEgo setHeading: temp1)
				(= local0 1)
				(genie setCycle: Walk setMotion: PolyPath 85 158 self)
			)
			(16
				(glint init:)
			)
			(17
				(genie view: 442 setLoop: 6 cel: 0)
				(= cycles 10)
			)
			(18
				(gMessager say: 1 0 21 1 self 400) ; "(URGENT, CONFUSED, SLIGHTLY ANNOYED) There you are! Why do you not follow me? Do you wish for death by the minotaur? Hurry! We can tarry no longer!"
			)
			(19
				(genie
					view: 442
					setLoop: 2
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(20
				(genie
					view: 364
					setLoop: -1
					setCycle: Walk
					setMotion: PolyPath 26 164 self
				)
			)
			(21
				(gGame handsOn:)
				(= seconds 30)
			)
			(22
				(gGame handsOff:)
				(= seconds 3)
			)
			(23
				(genie posn: 26 164)
				(= cycles 2)
			)
			(24
				(if (< (gEgo x:) 130)
					(gEgo setMotion: PolyPath 130 (gEgo y:) self)
				else
					(self cue:)
				)
			)
			(25
				((ScriptID 30 0) ; rLab
					timesGenieHasAppeared:
						(+ ((ScriptID 30 0) timesGenieHasAppeared:) 1) ; rLab
				)
				(= temp1 (GetAngle (gEgo x:) (gEgo y:) 85 158))
				(gEgo setHeading: temp1)
				(= local0 1)
				(genie setCycle: Walk setMotion: PolyPath 85 158 self)
			)
			(26
				(glint init:)
			)
			(27
				(genie view: 442 setLoop: 6 cel: 0)
				(= cycles 10)
			)
			(28
				(gMessager say: 1 0 22 1 self 400) ; "(ANGRY) So, here you still are! You are a coward and a fool! I leave you to your fate!"
			)
			(29
				(genie
					view: 442
					setLoop: 5
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(30
				(genie setCycle: Beg self)
			)
			(31
				(genie
					view: 442
					setLoop: 2
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(32
				(genie
					view: 364
					setLoop: -1
					cycleSpeed: 6
					setCycle: Walk
					setMotion: PolyPath 26 164 self
				)
			)
			(33
				(gGame handsOn:)
				(genie dispose:)
			)
		)
	)
)

(instance backOut of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 270 self)
			)
			(1
				(gEgo
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(2
				(gEgo reset: 1)
				(self dispose:)
			)
		)
	)
)

(instance genie of Actor
	(properties
		modNum 400
		view 364
	)
)

(instance glint of Prop
	(properties
		view 902
		cycleSpeed 0
	)

	(method (init)
		(self
			posn: (+ (genie x:) 3) (- (genie y:) 44)
			setPri: 15
			setCycle: End self
		)
		(super init:)
	)

	(method (cue)
		(if (> cel 0)
			(self setCycle: Beg self)
		else
			(self dispose:)
			(genieMeeting cue:)
		)
	)
)

(instance exitSouth of View ; UNUSED
	(properties
		x 176
		y 166
		noun 6
		modNum 400
		view 408
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 1 9 0 0 400) ; "The walls of the catacombs are made of massive stone tiles."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance westDoor of View
	(properties
		x 63
		y 155
		modNum 400
		view 405
		cel 1
		priority 11
		signal 16400
	)

	(method (init)
		(self stopUpd:)
		(westWing init: stopUpd:)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local0
					(gMessager say: 14 1 25 1 0 400) ; "The beautiful Winged One girl left through that doorway. Alexander wonders where it leads."
				else
					(gMessager say: 4 1 0 1 0 400) ; "All of the doorways in the catacombs look alike, giving Alexander no clue as to their order, or purpose."
				)
			)
			(5 ; Do
				(if local0
					(gMessager say: 14 5 25 1 0 400) ; "If Alexander wants to follow the girl, he can simply walk through the open doorway."
				else
					(gMessager say: 4 5 0 1 0 400) ; "The doorway is unobstructed and requires no manipulation. Just walk through it."
				)
			)
			(2 ; Talk
				(if local0
					(gMessager say: 14 2 25 0 0 400) ; "Miss? Excuse me, but where are you going?"
				else
					(gMessager say: 4 2 0 1 0 400) ; "Perhaps Alexander should determine what's on the other side of the doorway before calling through it."
				)
			)
			(else
				(gMessager say: 4 0 0 1 0 400) ; "There's no reason to use that on the open doorway."
			)
		)
	)
)

(instance westWing of View
	(properties
		x 43
		y 168
		noun 14
		modNum 400
		view 405
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(westDoor doVerb: theVerb &rest)
	)
)


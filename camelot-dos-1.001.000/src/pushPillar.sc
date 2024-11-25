;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 191)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	pushPillar 0
)

(local
	local0
)

(instance theGlow of Prop
	(properties
		view 50
		loop 6
	)

	(method (init)
		(super init:)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(self setCycle: Fwd)
	)
)

(instance pushPillar of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(< 117 (gSFX number:) 120)
				(== (gSFX prevSignal:) 10)
				(== local0 0)
			)
			(= local0 1)
			(if (or (== state 16) (== state 26))
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 196)
				(SetFlag 222)
				(= global109 6)
				(gEgo illegalBits: 0 ignoreActors: 1)
				(if (> (gEgo x:) 215)
					(gEgo setMotion: MoveTo 215 (gEgo y:) self)
				else
					(self cue:)
				)
			)
			(1
				(if (and (!= (gEgo x:) 219) (!= (gEgo y:) 122))
					(gEgo setMotion: MoveTo 219 122 self)
				else
					(self cue:)
				)
			)
			(2
				(gRegMusic stop:)
				(gEgo
					ignoreActors: 1
					view: 50
					setLoop: 0
					cel: -1
					setCycle: CT 2 1 self
				)
			)
			(3
				(gSFX number: (proc0_20 111) loop: 1 play:)
				(gEgo setCycle: CT 4 1 self)
			)
			(4
				(= cycles 2)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				((ScriptID 75 1) ; pillar
					posn: 262 118
					setMotion:
						MoveTo
						(+ ((ScriptID 75 1) x:) 12) ; pillar
						((ScriptID 75 1) y:) ; pillar
						self
				)
				(gEgo
					cel: 0
					xStep: 2
					setMotion: MoveTo (+ (gEgo x:) 3) (gEgo y:)
					setCycle: End self
				)
			)
			(7
				(= cycles 2)
			)
			(8
				(ClearFlag 222)
				(Print 191 0) ; "Aye, it moves!"
				(gEgo setCycle: Beg self)
			)
			(9
				((ScriptID 75 1) stopUpd:) ; pillar
				(gEgo
					setLoop: -1
					setCycle: Walk
					xStep: 3
					view: 0
					setMotion: MoveTo 227 113 self
				)
			)
			(10
				(gEgo
					setPri: 6
					view: 50
					loop: 1
					cel: -1
					setCycle: CT 3 1 self
				)
			)
			(11
				(gEgo cel: 4)
				(egoHand init:)
				(= cycles 18)
			)
			(12
				(if (and (IsFlag 65) (== global200 2) (IsFlag 206))
					(gSFX number: 119 loop: 1 play:)
				else
					(gSFX number: 118 loop: 1 play:)
				)
				(egoHand dispose:)
				(SetScore 0 0 100 1 100 2 100)
				(gEgo loop: 3 cel: -1 setCycle: End self)
			)
			(13
				(Print 191 1 #at 60 23 #dispose) ; "You have found it! You have found the Grail!"
				(= seconds 8)
			)
			(14
				(clr)
				(gEgo setPri: -1)
				(egoHand init: setCycle: End self)
			)
			(15
				(gEgo cycleSpeed: 0)
				(if (and (IsFlag 65) (== global200 2) (IsFlag 206))
					(self cue:)
				else
					(self changeState: 26)
				)
			)
			(16
				(if local0
					(self cue:)
				)
			)
			(17
				(theGlow init:)
				(= seconds 2)
			)
			(18
				(Print 191 2 #at 30 30) ; "One hand barely touches the sacred cup through a tiny gap in the white cloth that covers it. The Grail's power pours through you and restores you instantly to perfect health!"
				(= seconds 2)
			)
			(19
				(theGlow dispose:)
				(egoHand setCycle: Beg self)
			)
			(20
				(egoHand dispose:)
				(gEgo loop: 4 cel: -1 setCycle: End self)
			)
			(21
				(Print 191 3 #at 30 37) ; "You are dazed with the Grail's power, but you must recover yourself and find a way out of here. Camelot must be saved before--"
				((ScriptID 75 2) ; thief
					init:
					setLoop: 0
					setCel: -1
					illegalBits: 0
					ignoreActors: 1
					posn: 263 88
					setStep: 6 4
					setPri: (- ((ScriptID 75 1) priority:) 1) ; pillar
					setCycle: End
					setMotion: MoveTo 252 107 self
				)
			)
			(22
				((ScriptID 75 2) setLoop: 1 setCel: 0 setCycle: End self) ; thief
			)
			(23
				(SetFlag 202)
				(gEgo view: 92 setLoop: -1 loop: 3 setStep: 6 4)
				((ScriptID 75 2) ; thief
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 210 83 self
				)
			)
			(24
				(gSFX stop:)
				(gRegMusic number: 115 loop: -1 play:)
				(Print 191 4 #at 70 130) ; "The Thief has struck again! Stop him!"
				((ScriptID 75 2) setMotion: MoveTo 0 83) ; thief
				(gEgo setCycle: Walk setMotion: MoveTo 210 115 self)
			)
			(25
				(gEgo setLoop: -1)
				(HandsOn)
				(SetFlag 197)
				(= global193 505)
				((ScriptID 75 2) setScript: (ScriptID 75 3)) ; thief, thiefKeepsGoing
				(gEgo illegalBits: $8000 ignoreActors: 0)
				(self dispose:)
			)
			(26
				(if local0
					(self cue:)
				)
			)
			(27
				(theGlow init: loop: 7)
				(= seconds 2)
			)
			(28
				(egoHand dispose:)
				(theGlow dispose:)
				(gEgo setPri: 7 view: 51 cel: 0 setCycle: End self)
			)
			(29
				(= seconds 2)
			)
			(30
				(Print 191 5) ; "Alas! The Grail has judged you and found you unworthy. Too great was the burden of sin upon your soul."
				(if (!= global200 2)
					(Print 191 6) ; "You let Gawaine die an ignoble death in the Forest Perilous."
				)
				(if (not (IsFlag 65))
					(Print 191 7) ; "You sacrificed Launcelot to the curse of your jealousy."
				)
				(if (not (IsFlag 206))
					(Print 191 8) ; "You did nothing to save the noble Galahad within the catacombs."
				)
				(EgoDead 191 9) ; "And so you, your kingdom, and all your poor people perish for lack of a king with moral strength. We end not in glory, but with the bitter taste of ashes and dust and black defeat."
			)
		)
	)

	(method (dispose)
		(SetFlag 219)
		(super dispose:)
	)
)

(instance egoHand of Prop
	(properties
		view 50
	)

	(method (init)
		(super init:)
		(if (< (pushPillar state:) 12)
			(self
				setPri: (gEgo priority:)
				posn: (+ (gEgo x:) 6) (- (gEgo y:) 14)
				setLoop: 2
				setCycle: Fwd
			)
			(gEgo setPri: (- (gEgo priority:) 1))
			((ScriptID 75 1) setPri: (- ((ScriptID 75 1) priority:) 1)) ; pillar, pillar
		else
			(self
				setPri: 15
				posn: (+ (gEgo x:) 13) (- (gEgo y:) 36)
				setLoop: 8
			)
		)
	)

	(method (dispose)
		(if (< (pushPillar state:) 13)
			(gEgo setPri: (+ (gEgo priority:) 1))
			((ScriptID 75 1) setPri: (+ ((ScriptID 75 1) priority:) 1)) ; pillar, pillar
		)
		(super dispose:)
	)
)


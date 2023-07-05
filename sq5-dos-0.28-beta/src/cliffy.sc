;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 227)
(include sci.sh)
(use Main)
(use Scaler)
(use Osc)
(use ForwardCounter)
(use StopWalk)
(use Grooper)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	cliffy 0
	sMeetCliffy 1
	cliffySound 2
	sCliffyNoise 3
	sSpikeComments 4
)

(instance sSpikeComments of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(gMessager say: 11 0 0 0 self) ; "There's definitely something in there, Cap'n."
			)
			(2
				((ScriptID 225 1) setCycle: End self) ; scienceDoor
				(cliffy setMotion: MoveTo 66 133 self)
			)
			(3 0)
			(4
				((ScriptID 225 1) setCycle: Beg self) ; scienceDoor
			)
			(5
				(gGame handsOn:)
				(cliffy dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sMeetCliffy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 60)
				(= cycles 1)
			)
			(1
				(gMessager say: 7 0 0 1 self) ; "Well, well, looky here. Our brand spankin' new squeaky clean, neatly pressed captain has arrived."
			)
			(2
				(gEgo setMotion: MoveTo 141 134 self)
			)
			(3
				(gEgo hide:)
				(cliffy
					view: 231
					setLoop: 0
					cel: 0
					cycleSpeed: 15
					posn: 151 138
				)
				(= cycles 1)
			)
			(4
				(cliffy setCycle: End self)
			)
			(5
				(gMessager say: 7 0 0 2 self) ; "Pleased to meet you... um..."
			)
			(6
				(cliffy setLoop: 1 setCycle: ForwardCounter 3 self)
			)
			(7
				(gMessager say: 7 0 0 3 self) ; "Please, my friends call me ''Cliffy'', but you can call me Clifford. I'm chief engineer for the Eureka."
			)
			(8
				(cliffy setLoop: 2 setCycle: End self)
			)
			(9
				(gMessager say: 7 0 0 4 self) ; "What the...?"
			)
			(10
				(cliffy setLoop: 3 setCycle: ForwardCounter 3 self)
			)
			(11
				(gMessager say: 7 0 0 5 self) ; "Sorry about the muck captain. I dropped my wrench down the head."
			)
			(12
				(cliffy setCel: 0)
				(= seconds 2)
			)
			(13
				(gMessager say: 7 0 0 6 self) ; "Now If you'll excuse me, sir, I have some work to get back to."
			)
			(14
				(cliffy setLoop: 4 setCycle: 0 ignoreActors: 1 posn: 166 138)
				(gEgo
					view: 231
					setLoop: 5
					cel: 0
					show:
					setScale: 0
					x: 151
					y: 135
					setCycle: End self
				)
			)
			(15
				(= seconds 1)
			)
			(16
				(NormalEgo 0 4)
				(gEgo x: 138 y: 135 setScale: Scaler 153 42 168 107)
				(cliffy
					view: 20
					loop: 8
					cel: 7
					posn: 170 138
					setStep: 3 3
					cycleSpeed: 7
					moveSpeed: 7
					setLoop: Grooper
					setScale: Scaler 153 42 168 107
					setCycle: StopWalk -1
					signal: (| $0004 (cliffy signal:))
				)
				(= cycles 2)
			)
			(17
				(cliffy setMotion: MoveTo 143 122 self)
			)
			(18
				(cliffy setMotion: MoveTo 142 111 self)
			)
			(19
				(cliffy heading: 90)
				(= seconds 1)
			)
			(20
				(cliffy
					view: 191
					loop: 6
					x: 142
					y: 111
					setScale: 0
					cycleSpeed: 12
					setPri: 6
					setScript: sCliffyNoise
				)
				(= global130 (= seconds 1))
			)
			(21
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cliffySound of Sound
	(properties)
)

(instance sCliffyNoise of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Random 10 15))
				(cliffy cel: 0 setLoop: (Random 6 9))
				(= cycles 1)
			)
			(1
				(cliffy cel: 0 setCycle: End self)
			)
			(2
				(cliffySound
					number:
						(switch (cliffy loop:)
							(6 2422)
							(7 230)
							(8 232)
							(9 233)
						)
					loop: 1
					play:
				)
				(if (-- register)
					(-= state 2)
				else
					(-= state 3)
				)
				(= cycles 1)
			)
		)
	)
)

(instance sTalkAboutSpike of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 1884 23) disposeWhenDone: 0) ; tkrCliffy
				(gMessager say: 4 2 7 0 self) ; "Captain, ya |f8|gotta|f| do something with that bed-wettin' beastie of yours!"
			)
			(1
				(if (== global126 3)
					(gMessager say: 4 2 8 0 self) ; "I think I saw that critter of yours loose in the lab a minute ago, Captain."
				else
					(= cycles 1)
				)
			)
			(2
				((ScriptID 1884 23) disposeWhenDone: 1) ; tkrCliffy
				(self dispose:)
			)
		)
	)
)

(instance cliffy of Actor
	(properties
		x 142
		y 111
		noun 4
		view 191
		loop 1
		cel 2
		signal 16384
		scaleSignal 1
	)

	(method (init)
		(cond
			((and (not (IsFlag 60)) (not (IsFlag 86)))
				(self view: 231 setLoop: 4 setCel: 0 posn: 166 138)
				(super init: &rest)
			)
			((== global130 1)
				(self ignoreActors: 1)
				(switch
					(if (or (== gPrevRoomNum 228) (== global126 1) (IsFlag 61))
						1
					else
						(Random 1 2)
					)
					(1
						(self
							view: 191
							setLoop: (Random 6 9)
							posn: 142 111
							cycleSpeed: 12
							setCycle: Osc
							setPri: 6
							setScale: 0
						)
						(if (!= global126 1)
							(self setScript: sCliffyNoise)
						)
					)
					(2
						(self
							view: 241
							setLoop: 0
							posn: 148 114
							cycleSpeed: 15
							setScale: 0
							setCycle: End
						)
					)
				)
				(super init: &rest)
			)
			((and (== global130 4) (== global126 1))
				(self
					view: 20
					posn: 96 133
					loop: 8
					cel: 0
					setStep: 3 3
					cycleSpeed: 7
					moveSpeed: 7
					setLoop: Grooper
					setScale: Scaler 153 42 168 107
					setCycle: StopWalk -1
					signal: (| $0004 (cliffy signal:))
				)
				(super init: &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gCurRoom setScript: sTalkToCliffy)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(cliffySound dispose:)
		(super dispose: &rest)
	)
)

(instance sTalkToCliffy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((IsFlag 61)
						(if (IsFlag 116)
							(gMessager say: 4 2 10 0 self) ; "Shouldn't you be going, sir? There's no sense in making the rest us suffer for your mistakes."
						else
							(SetFlag 116)
							(gMessager say: 4 2 9 0 self) ; "What in tarnation is going on sir?! Who locked a tractor beam onto us?"
						)
					)
					((IsFlag 115)
						(ClearFlag 115)
						(gMessager say: 4 2 6 0 self) ; "Captain, I think they want you for something up in the cockpit."
					)
					((and (> global126 1) (not (IsFlag 56)) (!= gPrevRoomNum 230))
						(self setScript: sTalkAboutSpike self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)


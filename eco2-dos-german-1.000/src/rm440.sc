;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use eRS)
(use Eco2Talker)
(use Talker)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm440 0
	EgoTalker 1
	Paquita 2
	Slauter 3
)

(local
	local0
)

(instance rm440 of Eco2Room
	(properties
		noun 1
		picture 440
		style 10
	)

	(method (init)
		(super init:)
		(gNarrator y: 133)
		(gGameSound1 number: 440 setLoop: -1 play:)
		(bat init: setOnMeCheck: 1 2)
		(gTheDoits addToFront: bat)
		(net init: setOnMeCheck: 1 4)
		((ScriptID 1039) setupTalker: 2) ; Slaughter
		(cover init:)
		(= local0 2)
		(adam init:)
		(self setScript: startupScr)
	)
)

(instance bat of Feature
	(properties
		x 141
		y 31
		noun 5
		sightAngle 40
		onMeCheck 2
	)

	(method (doit)
		(if (not (IsEcorderFlag 36))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 4 2 13) ; Do, Talk, amulet
				(if (and (== theVerb 13) (== local0 6)) ; amulet
					(= local0 3)
				)
				(if
					(or
						(and (== theVerb 13) (OneOf local0 2 3)) ; amulet
						(and (== theVerb 2) (OneOf local0 5 2)) ; Talk
					)
					(gGame points: 5)
				)
				(gMessager say: noun theVerb local0)
				(switch theVerb
					(4 ; Do
						(switch local0
							(2
								(= local0 3)
							)
							(5
								(= local0 11)
								(if (not (gCurRoom script:))
									(gCurRoom setScript: prompt)
								)
							)
						)
					)
					(13 ; amulet
						(= local0 11)
						(if (not (gCurRoom script:))
							(gCurRoom setScript: prompt)
						)
					)
					(2 ; Talk
						(switch local0
							(2
								(= local0 3)
							)
							(5
								(= local0 11)
								(if (not (gCurRoom script:))
									(gCurRoom setScript: prompt)
								)
							)
							(3
								(= local0 6)
							)
						)
					)
				)
			)
			((== theVerb 55) ; E-corder
				(if (not (IsEcorderFlag 36))
					(self perform: gWriteEcorderData theVerb 36)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance net of Feature
	(properties
		x 141
		y 31
		noun 2
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local0 11)
				(gGame points: 5)
				(gCurRoom setScript: capture)
			else
				(super doVerb: theVerb &rest)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance cover of View
	(properties
		x 80
		y 30
		z -2
		view 450
		signal 16401
	)

	(method (onMe)
		(return 0)
	)
)

(instance adam of Prop
	(properties
		x 80
		y 33
		view 450
		loop 1
		priority 5
		signal 20496
	)

	(method (doVerb)
		(gEgo doVerb: &rest)
	)
)

(instance prompt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(gMessager say: 1 0 12 0 self) ; "Hurry! When I, Paquita, decide to do something I do it! Untangle this net!"
			)
			(2
				(self init:)
			)
		)
	)
)

(instance capture of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameSound1 number: 447 setLoop: 1 play: self)
				(adam setCycle: End self)
			)
			(1
				(adam loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 1 0 1 0 self) ; "Gotcha! Tie him up and take him back to camp, boys!"
			)
			(3
				(= seconds 15)
			)
			(4
				(gCurRoom newRoom: 501)
			)
		)
	)
)

(instance EgoTalker of Eco2Talker
	(properties
		x 136
		y 82
		view 450
		loop 4
		talkWidth 150
		back 67
		textX -100
		textY 49
		dftBack 67
	)

	(method (init &tmp temp0)
		(= font gUserFont)
		(Prop view: 450 loop: 4 cel: 0)
		(super init: 0 0 Prop)
	)
)

(instance Paquita of Eco2Talker
	(properties
		x 182
		y 67
		view 450
		loop 3
		talkWidth 150
		back 56
		textX -50
		textY 64
		dftBack 56
	)

	(method (init &tmp temp0)
		(= font gUserFont)
		(Prop view: 450 loop: 3 cel: 0)
		(super init: 0 0 Prop)
	)
)

(instance Slauter of Narrator
	(properties
		x 10
		y 10
		talkWidth 150
		back 5
	)

	(method (init &tmp temp0)
		(= font gUserFont)
		(super init: 0 0 0)
	)
)

(instance startupScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 1 1 4 0 self) ; "Aaagh! A bat!"
			)
			(2
				(gTheIconBar enable: enable: 2 6 3 1 advanceCurIcon:)
				(gUser canControl: 1 canInput: 1)
				(self dispose:)
			)
		)
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 443)
(include sci.sh)
(use Main)
(use MuseumRgn)
(use Inset)
(use Scaler)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	boot 0
	blood 1
	inBoot 2
	inPippin 3
	armorPippin 4
)

(local
	local0
)

(instance sFindPippin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 442
					loop: 0
					cel: 0
					posn: 129 162
					setCycle: CT 5 1 self
				)
			)
			(2
				(noise number: 440 play:)
				(gEgo setCycle: End self)
			)
			(3
				(= seconds 3)
			)
			(4
				(gGame handsOn:)
				(= local0 1)
				(gEgo
					loop: 6
					normalize: (if (== gAct 5) 426 else 831)
					setScale: Scaler 155 0 190 90
				)
				(gCurRoom setInset: inPippin self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sGetBoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo view: 440 setLoop: 6 cycleSpeed: 16 setCycle: End self)
			)
			(2
				(boot dispose:)
				(gEgo get: 12) ; workBoot
				((ScriptID 21 0) doit: 781) ; addCluesCode, Work Boot
				(gEgo setCycle: Beg self)
			)
			(3
				(gGame points: 1 150)
				(= cycles 1)
			)
			(4
				(gEgo
					loop: 5
					posn: (+ (gEgo x:) 2) (gEgo y:)
					normalize: (if (== gAct 5) 426 else 831)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance boot of View
	(properties
		x 85
		y 169
		approachX 100
		approachY 162
		view 440
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gGame points: 1 150)
				(gCurRoom setInset: inBoot)
			)
			(4 ; Do
				(gCurRoom setScript: sGetBoot)
			)
			(8 ; magnifier
				(gGame points: 1 150)
				(gCurRoom setInset: inBoot)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance blood of View
	(properties
		x 89
		y 172
		noun 34
		approachX 100
		approachY 162
		view 440
		loop 1
		signal 16384
	)
)

(instance inBoot of Inset
	(properties
		view 440
		cel 1
		x 57
		y 154
		priority 15
		disposeNotOnMe 1
		modNum 15
		noun 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetBoot)
				(inBoot dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance inPippin of Inset
	(properties
		view 442
		loop 1
		x 100
		y 40
		priority 15
		disposeNotOnMe 1
		noun 11
	)

	(method (dispose)
		(noise dispose:)
		(super dispose:)
	)
)

(instance armorPippin of Feature
	(properties
		x 151
		y 128
		noun 10
		nsTop 96
		nsLeft 140
		nsBottom 160
		nsRight 164
		sightAngle 40
		onMeCheck 8192
		approachX 128
		approachY 165
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					(local0
						(if (MuseumRgn nobodyAround:)
							(gCurRoom setInset: inPippin)
						else
							(return 1)
						)
					)
					((>= gAct 3)
						(gMessager say: 10 1 1) ; "The faceplate on the armor is slightly open, as if something is protruding from the inside of the dark helm."
					)
					(else
						(gMessager say: 10 1 2) ; "The suit of armor is empty."
					)
				)
			)
			(8 ; magnifier
				(if (>= gAct 3)
					(gMessager say: 10 8 1) ; "Your close scrutiny reveals that there is indeed a body within the cramped confines of the suit of the armor."
				else
					(gMessager say: 10 8 2) ; "No matter how closely you look, you see nothing at all in the suit of armor."
				)
			)
			(4 ; Do
				(cond
					(local0
						(gCurRoom setInset: inPippin)
					)
					((>= gAct 3)
						(if (not (== (gEgo view:) 443))
							(if (MuseumRgn nobodyAround:)
								(gCurRoom setScript: sFindPippin)
							else
								(return 1)
							)
						else
							(super doVerb: theVerb)
						)
					)
					(else
						(gMessager say: 10 4 2) ; "The suit of armor feels like cold steel and it sounds hollow."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance noise of Sound
	(properties
		flags 1
	)
)


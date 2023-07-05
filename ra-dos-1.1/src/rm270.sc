;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use eRS)
(use ExitFeature)
(use Inset)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm270 0
)

(local
	local0
	local1
	local2
	local3 = 1
	local4 = 1
	local5 = 1
	local6 = 1
	local7 = 1
	local8 = 1
	local9 = 1
	local10 = 1
	local11 = 1
	local12 = 1
	local13 = 1
	local14 = 1
)

(instance rm270 of LBRoom
	(properties
		noun 10
		picture 270
		south 260
		vanishingX 3
		vanishingY 39
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(sGetDress cue:)
				(return 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(if (& (event type:) $0040) ; direction
			(sGetDress cue:)
			(return 0)
		else
			(super handleEvent: event)
		)
	)

	(method (init)
		(LoadMany rsVIEW 272 271)
		(LoadMany rsSOUND 270)
		(gEgo init: setScale: Scaler 125 0 190 29 normalize: 830)
		(switch gPrevRoomNum
			(south
				(gEgo posn: 160 230)
				(gCurRoom setScript: sEnter)
			)
			(else
				(gEgo posn: 160 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		((ScriptID 1881 2) x: 215 y: 95 textX: -170 textY: 5) ; Laura
		(gGameMusic1 number: 270 flags: 1 loop: -1 play:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 311 189 286 145 216 145 216 137 153 137 128 137 70 137 54 189 0 189 0 137
					yourself:
				)
		)
		(lofat init: approachVerbs: 1 6 2 4 7 8 setCycle: RandCycle) ; Look, Ask, Talk, Do, baseball, magnifier
		(if (not (gEgo has: 32)) ; eveningGown
			(dress init:)
		)
		(dress2 init: addToPic:)
		(dress3 init: addToPic:)
		(dress4 init: addToPic:)
		(dress5 init: addToPic:)
		(dress6 init: addToPic:)
		(southExitFeature init:)
		(dClothes init:)
		(cClothes init:)
		(lamp init:)
		(symbols init:)
		(jar1 init:)
		(jar2 init:)
		(counter1 init:)
		(counter2 init:)
	)

	(method (dispose)
		(gGameMusic1 fade: 0 30 12 1)
		(super dispose: &rest)
	)

	(method (doit)
		(cond
			(script)
			((StepOn gEgo 16)
				(self setScript: sEgoLeaveSouth)
			)
		)
		(super doit: &rest)
	)
)

(instance sEgoLeaveSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo heading: 180)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveFwd 80 self)
			)
			(2
				(gCurRoom newRoom: 260)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 160 160 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShowDress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (gNarrator x:))
				(= local1 (gNarrator y:))
				(= local2 (gNarrator talkWidth:))
				(gNarrator x: 160 y: 100 talkWidth: 120)
				(= cycles 2)
			)
			(1
				(gMessager say: 12 1 0 0 self) ; "An evening gown hangs on the rack behind Lo Fat. It's a couple of years out of date, but it appears to be your size."
			)
			(2
				(gNarrator x: local0 y: local1 talkWidth: local2)
				(gownInset dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sGetDress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lofat setCycle: End self)
			)
			(1
				(gEgo setMotion: PolyPath 142 138 self)
			)
			(2
				(gEgo view: 271 loop: 0 setCycle: CT 3 1 self)
			)
			(3
				(lofat loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(gMessager say: 1 5 0 1 self) ; "This claim ticket two years old today! You very lucky woman, almost give this clothes away."
			)
			(5
				(lofat setCycle: End self)
				(gEgo setCycle: End self)
				(smoke init: setCycle: Fwd)
			)
			(6 0)
			(7
				(gMessager say: 1 5 0 2 self) ; "It'll be ready Tuesday. Hahaha! Just kidding, ancient Chinese joke."
			)
			(8
				(lofat loop: 2 setCycle: End self)
			)
			(9
				(gMessager say: 1 5 0 3 self) ; "Actually, this isn't mine at all. I found this claim ticket just a little while ago."
			)
			(10
				(gMessager say: 1 5 0 4 self) ; "I'd feel badly if somebody were to come back for this."
				(dress dispose:)
			)
			(11
				(lofat loop: 3 setCycle: End self)
			)
			(12
				(gMessager say: 1 5 0 5) ; "You worry for nothing. Nobody come in for two-year-old laundry."
				(dress init: posn: 136 94)
				(gEgo get: -1 32) ; eveningGown
				(gEgo put: 1) ; claimTicket
				((ScriptID 21 0) doit: 801) ; addCluesCode, Evening Gown
				((ScriptID 21 1) doit: 770) ; dropCluesCode, Laundry Claim Ticket
				(lofat loop: 4 cel: 0 setCycle: End self)
			)
			(13
				(gMessager say: 1 5 0 6 self) ; "Lady who own this dress probably DEAD by now! Hahahaha!"
			)
			(14
				(gMessager say: 1 5 0 7 self) ; "You're a strange man, Mr. Fat, but I kind of like you."
			)
			(15
				(gEgo normalize: 830 setMotion: MoveTo 138 133 self)
			)
			(16
				(gEgo view: 271 loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(17
				(dress dispose:)
				(gEgo setCycle: End self)
			)
			(18
				(gEgo normalize: 830 setMotion: MoveTo 142 138 self)
			)
			(19
				(gGame handsOn:)
				(gWalkHandler addToFront: gCurRoom)
				(gDirectionHandler addToFront: gCurRoom)
				(southExitFeature dispose:)
			)
			(20
				(lofat loop: 5 cel: 0 setCycle: End self)
			)
			(21
				(smoke dispose:)
				(lofat loop: 0 setCycle: RandCycle)
				(gWalkHandler delete: gCurRoom)
				(gDirectionHandler delete: gCurRoom)
				(southExitFeature init:)
				(self dispose:)
			)
		)
	)
)

(instance lofat of Actor
	(properties
		x 113
		y 102
		noun 1
		approachX 142
		approachY 138
		view 272
		priority 8
		signal 16
		cycleSpeed 10
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(switch theVerb
			(5 ; claimTicket
				(gCurRoom setScript: sGetDress)
			)
			(4 ; Do
				(if local5
					(gMessager say: 1 4 98) ; "Please not to touch me! My wife, very jealous woman. No hanky-panky in store, OK?"
					(= local5 0)
				else
					(gMessager say: 1 4 2) ; "Please, please! Not want to offend, but please keep hand to self."
				)
			)
			(2 ; Talk
				(cond
					(local6
						(= temp1 16)
						(= local6 0)
					)
					((or (gEgo has: 32) (gEgo wearingGown:)) ; eveningGown
						(= temp1 67)
					)
					(else
						(= temp1 13)
					)
				)
				(gMessager say: 1 2 temp1)
			)
			(6 ; Ask
				(if
					(==
						(= temp0
							(if (== argc 2)
								invItem
							else
								(gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
							)
						)
						-1
					)
					(return)
				)
				(= temp2 (& temp0 $00ff))
				(= temp1
					(switch (& temp0 $ff00)
						(256
							(+ temp2 1)
						)
						(512
							(+ temp2 18)
						)
						(768
							(+ temp2 26)
						)
						(1024
							(+ temp2 61)
						)
					)
				)
				(switch temp0
					(775
						(if local11
							(gMessager say: 1 6 33) ; "Can you tell me anything about a free pass to get your clothes pressed?"
							(= local11 0)
						else
							(gMessager say: 1 6 91) ; "So this pass is good for a free pressing here?"
						)
					)
					(514
						(if local12
							(gMessager say: 1 6 20) ; "Spent any time at the Police Station recently?"
							(= local12 0)
						else
							(gMessager say: 1 6 93) ; "What else do you know about the Police Station?"
						)
					)
					(263
						(if local13
							(gMessager say: 1 6 8) ; "You wouldn't happen to know a rather striking young man named Steve Dorian, would you?"
							(= local13 0)
						else
							(gMessager say: 1 6 95) ; "Are you positive you don't know this Steve Dorian character?"
						)
					)
					(266
						(if local14
							(gMessager say: 1 6 11) ; "Do you know Yvette Delacroix?"
							(= local14 0)
						else
							(gMessager say: 1 6 96) ; "C'mon, tell me more about Yvette. You obviously know more than you're letting on."
						)
					)
					(770
						(if local8
							(gMessager say: 1 6 28) ; "What would you say if I told you I had a claim ticket for an item of laundry?"
							(= local8 0)
						else
							(gMessager say: 1 6 83) ; "What else do you know about the laundry claim ticket?"
						)
					)
					(517
						(if local9
							(gMessager say: 1 6 23) ; "Ever been to the Leyendecker Museum?"
							(= local9 0)
							((ScriptID 21 0) doit: 270) ; addCluesCode, Dr. Olympia Myklos
							((ScriptID 21 0) doit: 266) ; addCluesCode, Yvette Delacroix
							((ScriptID 21 0) doit: 265) ; addCluesCode, Wolf Heimlich
						else
							(gMessager say: 1 6 85) ; "So it's been awhile since you've been to the Museum?"
						)
					)
					(519
						(if local10
							(gMessager say: 1 6 25) ; "How do you like New York?"
							(= local10 0)
						else
							(gMessager say: 1 6 86) ; "Why do you live here if you don't like it?"
						)
					)
					(780
						(if local7
							(gMessager say: 1 6 38) ; "Have you ever heard of the Dagger of Amon Ra?"
							(= local7 0)
						else
							(gMessager say: 1 6 78) ; "Can you think of any customers you might have who would be interested in such a thing as a valuable ceremonial dagger?"
						)
					)
					(else
						(if (Message msgGET gCurRoomNum noun 6 temp1 1)
							(gMessager say: noun 6 temp1)
						else
							(gMessager say: noun 6 1) ; "I not good person to ask about that."
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 103
		y 100
		view 272
		loop 7
		signal 16384
	)
)

(instance dress2 of View
	(properties
		x 86
		y 94
		view 272
		loop 6
		cel 1
		signal 16384
	)
)

(instance dress3 of View
	(properties
		x 80
		y 94
		view 272
		loop 6
		cel 2
		signal 16384
	)
)

(instance dress4 of View
	(properties
		x 98
		y 94
		view 272
		loop 6
		cel 3
		signal 16384
	)
)

(instance dress5 of View
	(properties
		x 104
		y 94
		view 272
		loop 6
		cel 4
		signal 16384
	)
)

(instance dress6 of View
	(properties
		x 74
		y 94
		view 272
		loop 6
		cel 5
		signal 16384
	)
)

(instance dress of View
	(properties
		x 92
		y 94
		noun 12
		view 272
		loop 6
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(8 ; magnifier
				(gCurRoom setInset: gownInset)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance dClothes of Feature
	(properties
		x 250
		y 115
		noun 3
		nsTop 95
		nsLeft 224
		nsBottom 136
		nsRight 277
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if local3
					(gMessager say: 3 1 98) ; "This oversized cart is brimming with other people's dirty laundry."
					(= local3 0)
				else
					(gMessager say: 3 1 2) ; "You look over the dirty laundry, hoping to find something for the fundraiser, attractive but not too daring, and in just your size."
				)
			)
			(4 ; Do
				(if local4
					(gMessager say: 3 4 98) ; "Why pick through somebody else's dirty laundry?"
					(= local4 0)
				else
					(gMessager say: 3 4 2) ; "Lo Fat is watching you out of the corner of his eye. There's no way you can go through the dirty laundry without attracting his attention."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		x 38
		y 75
		noun 4
		nsTop 29
		nsBottom 122
		nsRight 76
		sightAngle 40
	)
)

(instance cClothes of Feature
	(properties
		x 214
		y 76
		noun 5
		nsTop 52
		nsLeft 177
		nsBottom 100
		nsRight 251
		sightAngle 40
	)
)

(instance symbols of Feature
	(properties
		y 2
		noun 6
		nsLeft 63
		nsBottom 106
		nsRight 104
	)
)

(instance jar1 of Feature
	(properties
		y 2
		noun 7
		nsTop 38
		nsLeft 185
		nsBottom 49
		nsRight 201
	)
)

(instance jar2 of Feature
	(properties
		y 2
		noun 8
		nsTop 34
		nsLeft 229
		nsBottom 48
		nsRight 242
	)
)

(instance counter1 of Feature
	(properties
		y 2
		noun 9
		nsTop 110
		nsLeft 50
		nsBottom 133
		nsRight 142
	)
)

(instance counter2 of Feature
	(properties
		y 2
		noun 11
		nsTop 111
		nsLeft 161
		nsBottom 132
		nsRight 227
	)
)

(instance gownInset of Inset
	(properties
		view 271
		loop 2
		x 62
		y 76
		priority 15
	)

	(method (init)
		(super init: &rest)
		(self setScript: sShowDress)
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 184
		nsLeft 90
		nsBottom 189
		nsRight 320
		cursor 11
		exitDir 3
		noun 13
	)
)


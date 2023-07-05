;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use eRS)
(use ExitFeature)
(use Print)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	local0
)

(instance rm320 of LBRoom
	(properties
		noun 7
		picture 320
		south 310
		vanishingY -60
	)

	(method (init)
		(LoadMany rsVIEW 321 322 318 831 830)
		(Load rsSOUND 321)
		(gEgo
			init:
			x: 133
			y: 182
			actions: aPutOnDress
			normalize: (if (gEgo wearingGown:) 831 else 830)
			setScale: Scaler 145 0 190 0
		)
		(switch gPrevRoomNum
			(south
				(if (not (IsFlag 24))
					(gCurRoom setScript: sEnterRm1stTime)
				else
					(gCurRoom setScript: sEnterRmNthTime)
				)
			)
			(else
				(gEgo posn: 160 130)
				(gGame handsOn:)
			)
		)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 236 150 199 102 146 102 120 102 107 109 144 109 128 134 110 146 77 146 78 189 182 189 181 150
					yourself:
				)
		)
		(gGameMusic2 number: 321 loop: -1 flags: 1 play:)
		(sleazy approachVerbs: 4 2 6 init: setScript: sSheAnimates) ; Do, Talk, Ask
		(smoke init: setScript: sDoSomethingLaura)
		(partition init:)
		(stalls init:)
		(sink init:)
		(rm320Window init:)
		(couch init:)
		(southExitFeature init:)
	)

	(method (doit)
		(cond
			(script)
			((StepOn gEgo 2)
				(gCurRoom setScript: sExitSouth)
			)
		)
		(super doit:)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					setHeading: 180
					setMotion: MoveTo (gEgo x:) 250 self
				)
			)
			(2
				(gGameMusic1 fade: 127 30 12 0)
				(gCurRoom newRoom: 310)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRm1stTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo posn: 137 151 setHeading: 1 setMotion: MoveFwd 10 self)
			)
			(2
				(gMessager say: 1 0 1 1 self) ; "Hiya, Dollface. Lookin' for a good time?"
			)
			(3
				(Print
					addText: 12 0 0 0 ; "You respond to the woman's remark."
					addButton: 1 13 0 0 1 5 25 ; "Not right now, but thank you for asking."
					addButton: 1 13 0 0 2 5 50 ; "You must be referring to someone else. My name is Laura, not Dollface."
					init:
				)
				(gMessager say: 1 0 1 2 self) ; "It's your loss, toots. I'll be right here if you change your mind."
			)
			(4
				(SetFlag 24)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRmNthTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo posn: 137 151 setHeading: 1 setMotion: MoveFwd 10 self)
			)
			(2
				(if (IsFlag 78)
					(gMessager say: 15 0 0 0 self) ; "If you're lookin' for your old clothes, ya won't find them. I threw them out."
					(ClearFlag 78)
				else
					(gMessager say: 1 0 3 0 self) ; "Va-va-voom!"
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLauraChanges of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo
					put: 32 ; eveningGown
					wearingGown: 1
					setMotion: PolyPath 208 150 self
				)
				((ScriptID 22 0) doit: $0010) ; triggerAndClock
				(gGame points: 1 132)
			)
			(2
				(gEgo setMotion: MoveTo 210 160 self)
			)
			(3
				(gEgo
					view: 321
					loop: 0
					posn: (- (gEgo x:) 3) (- (gEgo y:) 45)
					cycleSpeed: 10
					moveSpeed: 10
					setCycle: End self
				)
				(clothes init: setCycle: End)
			)
			(4
				(gMessager say: 2 0 0 0) ; "Nice body, but where did ya get those clothes? Salvation Army?"
				(gEgo view: 321 loop: 1 setCycle: End self)
			)
			(5
				(gEgo
					view: 831
					loop: 2
					posn: (+ (gEgo x:) 3) (+ (gEgo y:) 45)
				)
				(= cycles 1)
			)
			(6
				(gEgo setCycle: Walk setMotion: MoveTo 208 150 self)
			)
			(7
				(= local0 1)
				(clothes addToPic:)
				(gGame handsOn:)
				(SetFlag 78)
				((ScriptID 21 1) doit: 801) ; dropCluesCode, Evening Gown
				(gEgo normalize: 831)
				(self dispose:)
			)
		)
	)
)

(instance sSheAnimates of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 0 2)
					(0
						(self setScript: sSheMoves self)
					)
					(else
						(self setScript: sSheSmokes self)
					)
				)
			)
			(1
				(= cycles 70)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sSheSmokes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sleazy setLoop: 0 setCycle: CT 9 1 self)
			)
			(1
				(smoke setCycle: End self)
			)
			(2
				(sleazy setCycle: End self)
				(smoke cel: 0)
			)
			(3
				(= cycles (Random 30 70))
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sSheMoves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sleazy cel: 0 setLoop: 2 setCycle: End self)
			)
			(1
				(= cycles 100)
			)
			(2
				(switch (Random 0 2)
					(0
						(gMessager say: 10 0 0 1 self) ; "How about a free back rub? Or a neck rub? If ya like, I could even do your whole body."
					)
					(1
						(gMessager say: 10 0 0 2 self) ; "Ya look so cute in that outfit, it makes me want to scream."
					)
					(2
						(gMessager say: 10 0 0 3 self) ; "I have a cramp in my leg. Could ya massage it for me, honey?"
					)
				)
			)
			(3
				(sleazy setLoop: 3 setCycle: Fwd)
				(= cycles (Random 30 60))
			)
			(4
				(sleazy setCycle: End self)
			)
			(5
				(sleazy setLoop: 2)
				(= cycles 1)
			)
			(6
				(sleazy cel: (sleazy lastCel:) setCycle: Beg self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance sDoSomethingLaura of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 50)
			)
			(1
				(if (gEgo wearingGown:)
					(self dispose:)
				else
					(gMessager say: 11 0 0 1 self) ; "Whadda ya lookin' at, kid? Ain't ya ever seen a women's lounge before?"
				)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance aPutOnDress of Actions
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(42 ; eveningGown
				(gCurRoom setScript: sLauraChanges)
			)
			(else 0)
		)
	)
)

(instance sleazy of Prop
	(properties
		x 109
		y 113
		noun 3
		approachX 145
		approachY 124
		view 322
		priority 10
		signal 16
		cycleSpeed 10
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Talk
				((ScriptID 21 0) doit: 269) ; addCluesCode, Countess W-C
				(gMessager say: 3 2) ; "Ya haven't seen the Countess come into the speakeasy yet, have ya? I've been waitin' here for hours."
			)
			(6 ; Ask
				(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
					(269
						(gMessager say: 3 6 7) ; "What do you know about the Countess?"
					)
					(264
						(gMessager say: 3 6 4) ; "Ya won't find Ziggy in here, Dollface. This lounge is just for WOMEN, if ya know what I mean...."
					)
					(520
						(gMessager say: 3 6 9) ; "The Harlem Swinger's okay, but I seen better, if ya know what I mean...."
					)
					(-1 0)
					(else
						(gMessager say: 3 6 5) ; "Ya have a sexy voice, toots, but I don't know what yer talkin' about."
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
		x 113
		y 96
		view 318
		loop 6
	)

	(method (init)
		(self posn: (+ (sleazy x:) 4) (- (sleazy y:) 17))
		(super init:)
	)
)

(instance clothes of Prop
	(properties
		x 207
		y 114
		view 321
		loop 2
		cel 10
		priority 15
		signal 16400
	)
)

(instance partition of Feature
	(properties
		x 217
		y 130
		noun 4
		nsTop 109
		nsLeft 185
		nsBottom 151
		nsRight 250
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local0
					(gMessager say: 4 1 8) ; "A handy partition for changing your clothes in privacy. Currently, your old clothes are hanging here as well."
				else
					(gMessager say: 4 1 6) ; "A handy partition for changing your clothes in privacy."
				)
			)
			(4 ; Do
				(if local0
					(gMessager say: 4 4 8) ; "The partition is bolted to the floor, so you can't move it. You've also decided to leave your old clothes here, just in case some poor unfortunate should come along who needs them more than you do."
				else
					(gMessager say: 4 4 6) ; "The partition is bolted to the floor, so you can't move it."
				)
			)
			(42 ; eveningGown
				(gCurRoom setScript: sLauraChanges)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stalls of Feature
	(properties
		x 170
		y 68
		noun 5
		nsTop 40
		nsLeft 139
		nsBottom 96
		nsRight 202
		sightAngle 40
	)
)

(instance sink of Feature
	(properties
		x 221
		y 91
		noun 6
		nsTop 78
		nsLeft 203
		nsBottom 104
		nsRight 239
		sightAngle 40
	)
)

(instance rm320Window of Feature
	(properties
		x 239
		y 57
		noun 9
		nsTop 51
		nsLeft 229
		nsBottom 63
		nsRight 249
		sightAngle 40
	)
)

(instance couch of Feature
	(properties
		y 101
		noun 8
		onMeCheck 16384
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 149
		nsLeft 69
		nsBottom 154
		nsRight 192
		cursor 11
		exitDir 3
		noun 14
	)
)


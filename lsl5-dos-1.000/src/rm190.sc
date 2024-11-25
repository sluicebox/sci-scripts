;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Polygon)
(use Feature)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm190 0
)

(instance rm190 of LLRoom
	(properties
		lookStr {You are outside PPC's general headquarters, nestled in the smog beneath the Hollywood hills. Gawd, how you love being in show biz!}
		picture 190
		north 160
	)

	(method (init)
		(self setRegions: 40) ; HollywoodRgn
		(gEgo init: normalize: 552 setStep: 2 1)
		(HandsOn)
		(super init:)
		(if
			(and
				(gEgo has: 5) ; Michelle_Milken_s_Resume
				(gEgo has: 15) ; Lana_Luscious__Resume
				(gEgo has: 19) ; Chi_Chi_Lambada_s_Resume
				(gEgo has: 7) ; AeroDork_Gold_Card
			)
			(limo init: approachVerbs: 3) ; Do
		)
		(gTheMusic2 number: 193 setLoop: -1 play:)
		(fountain setCycle: Fwd init: approachVerbs: 3 10) ; Do, Zipper
		(waves setCycle: Fwd init: approachVerbs: 3) ; Do
		(statue init:)
		(logo init:)
		(sign --UNKNOWN-PROPERTY--)
		(tree init:)
		(buildings1 init:)
		(buildings2 init:)
		(windows1 init:)
		(windows2 init:)
		(doorATP init:)
		(debugFeature init:)
		(gCurRoom
			addObstacle:
				(if (gCast contains: limo)
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 179 0 179 132 76 132 64 125 5 125 5 133 61 133 76 136 65 143 24 145 4 150 4 158 147 158 202 175 218 187 309 187 309 167 276 163 273 156 315 146 315 122 253 136 243 143 225 143 216 134 192 134 192 0 319 0 319 189 0 189
						yourself:
					)
				else
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 179 0 179 133 71 133 64 125 5 125 5 140 23 140 23 146 5 150 5 158 151 158 202 175 218 187 313 187 309 167 276 163 273 156 315 146 315 122 253 137 243 143 225 143 216 134 192 134 192 0 319 0 319 189 0 189
						yourself:
					)
				)
		)
		(Delay 2 1 self)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 200)
			(gTheMusic fade:)
		else
			(gTheMusic fade: 127 25 10 0)
		)
		(gTheMusic2 fade:)
		(super newRoom: newRoomNumber)
	)

	(method (cue)
		(door init: approachVerbs: 3) ; Do
	)
)

(instance sEnterLimo of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 180 self)
			)
			(1
				(gEgo moveSpeed: 10 setMotion: MoveTo (gEgo x:) 137 self)
				(= ticks 10)
			)
			(2
				(gEgo hide:)
				(gTheMusic2 number: 191 setLoop: 1 play:)
				(= ticks 50)
			)
			(3)
			(4
				(gTheMusic2 number: 192 setLoop: 1 play:)
				(= ticks 100)
			)
			(5
				(= ticks 20)
			)
			(6
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance limo of View
	(properties
		x 10
		y 1138
		z 1000
		description {your limousine}
		approachX 29
		approachY 136
		lookStr {At last! You finally get to ride in a real limo.}
		view 190
		priority 9
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: sEnterLimo)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Door
	(properties
		x 175
		y 132
		heading 180
		description {the front door of PornProdCorp}
		approachX 185
		approachY 134
		lookStr {This door leads back into the PPC lobby.}
		view 192
		loop 2
		entranceTo 160
		moveToX 185
		moveToY 128
		enterType 1
		exitType 0
	)
)

(instance doorATP of PicView
	(properties
		x 185
		y 130
		view 190
		loop 1
	)
)

(instance fountain of Prop
	(properties
		x 92
		y 160
		description {the fountain}
		sightAngle 40
		lookStr {Passing the tinkling water makes you want to pass tinkling water.}
		view 192
		priority 15
		signal 16
		detailLevel 2
	)

	(method (doVerb theVerb invItem &tmp [str 30])
		(switch theVerb
			(3 ; Do
				(TPrint 190 0) ; "Carefully checking to make sure that no one can see you, you take full advantage of the PPC Memorial Fountain."
			)
			(4 ; Inventory
				(Format @str 190 1 ((Inv at: invItem) description:)) ; "Now %s is wet!"
				(TPrint @str)
			)
			(10 ; Zipper
				(TPrint 190 0) ; "Carefully checking to make sure that no one can see you, you take full advantage of the PPC Memorial Fountain."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance waves of Prop
	(properties
		x 89
		y 189
		sightAngle 40
		view 192
		loop 1
		priority 15
		signal 16
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(fountain doVerb: theVerb invItem &rest)
	)
)

(instance statue of Feature
	(properties
		x 95
		y 171
		z 75
		nsTop 64
		nsLeft 73
		nsBottom 129
		nsRight 117
		description {Chesty}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Points 1 90)
				(TPrint 190 2) ; "You remember her! She's PornProdCorp's founding mother: Chesty Turbo!"
			)
			(3 ; Do
				(TPrint 190 3) ; "You can't really do what you're thinking!"
			)
			(5 ; Talk
				(TPrint 190 4) ; ""I'm so lonely," you moan to the statue."
			)
			(10 ; Zipper
				(TPrint 190 5) ; "Larry! She's not that good!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance logo of Feature
	(properties
		x 193
		y 20
		nsTop 3
		nsLeft 180
		nsBottom 37
		nsRight 207
		description {that PornProdCorp logo}
		sightAngle 40
		lookStr {You presume PPC chose that logo because the tongue is the universal symbol of good taste.}
	)
)

(instance tree of Feature
	(properties
		x 263
		y 169
		z 100
		nsTop 4
		nsLeft 235
		nsBottom 134
		nsRight 292
		description {the palm tree}
		sightAngle 40
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 190 6) ; "For just a moment, you have the feeling that tree is the only thing in Hollywood that's straight!"
				(TPrint 190 7 #at -1 185) ; "(Then you notice it's leaning!)"
			)
			(3 ; Do
				(TPrint 190 8) ; "You love the feel of palms, don't you, Larry?"
			)
			(5 ; Talk
				(TPrint 190 9) ; ""I Talk to the Trees," you sing."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance HollywoodSign of Feature ; UNUSED
	(properties
		x 92
		y 80
		nsBottom 46
		nsRight 61
		description {the Hollywood sign}
		sightAngle 40
		lookStr {You love working here because everyone in this city tries so hard to treat you fairly.}
	)
)

(instance buildings1 of Feature
	(properties
		x 28
		y 92
		nsTop 71
		nsBottom 113
		nsRight 57
		description {the buildings}
		sightAngle 40
		lookStr {You wonder how many disco parties are going on in those office buildings over there!}
	)
)

(instance buildings2 of Feature
	(properties
		x 299
		y 87
		nsTop 69
		nsLeft 279
		nsBottom 105
		nsRight 319
		description {the buildings}
		sightAngle 40
		lookStr {You wonder how many disco parties are going on in those office buildings over there!}
	)
)

(instance windows1 of Feature
	(properties
		x 105
		y 106
		nsTop 97
		nsLeft 81
		nsBottom 116
		nsRight 129
		description {the windows}
		sightAngle 40
		lookStr {You just love voyeurism, don't you?}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 190 10) ; "Keep your hands off the glass."
			)
			(5 ; Talk
				(TPrint 190 11) ; ""Hello! Is anybody in there?" you shout through the glass."
				(TPrint 190 12 #at -1 185) ; "(There is no response.)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance windows2 of Feature
	(properties
		x 238
		y 100
		nsTop 89
		nsLeft 216
		nsBottom 112
		nsRight 260
		description {the windows}
		sightAngle 40
		lookStr {You just love voyeurism, don't you?}
	)

	(method (doVerb theVerb invItem)
		(windows1 doVerb: theVerb invItem &rest)
	)
)

(instance debugFeature of Feature
	(properties
		x 29
		y 33
		nsTop 31
		nsLeft 27
		nsBottom 35
		nsRight 31
		sightAngle 40
	)

	(method (init)
		(gMouseDownHandler addToEnd: self)
		(super init:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(== (event type:) evMOUSEBUTTON)
				(== gTheCursor 1)
				(== (event modifiers:) $000c) ; emALT | emCTRL
			)
			(= gDebugging 1)
		else
			(gCurRoom handleEvent: event)
		)
	)
)


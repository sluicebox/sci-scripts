;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 560)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use n819)
(use EcoFeature)
(use Talker)
(use PolyPath)
(use Polygon)
(use Motion)
(use User)
(use System)

(public
	RM560 0
)

(instance RM560 of EcoRoom
	(properties
		picture 560
		style -32761
		north 580
		south 540
		picAngle 70
		vanishingX 180
		vanishingY -24
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(EcoNarrator
					init: 1 0 0 (if (< ((User curEvent:) y:) 110) 25 else 24)
				)
			)
			(6 ; Recycle
				(EcoNarrator init: 1 0 0 39) ; "The divers removed the worst of the contaminated materials. The rest will decompose over time."
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 32) ; "The level of chemicals here makes it unsafe to touch anything."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(= global250 1)
		(= global251 1)
		(self
			setScript:
				(switch gPrevRoomNum
					(north fromShipScript)
					(561 talkToDelph)
					(else fromAlgaeCaveScript)
				)
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 207 189 306 165 189 165 187 154 260 141 140 141 207 121 165 125 126 125 163 108 97 108 122 6 15 6 63 130 155 157 40 189 0 189
					yourself:
				)
			setRegions: 51 ; bubblesRegion
		)
		(gFeatures
			add:
				deadFish
				deadPlant
				spiderWeb
				ceilingMoss
				stalagmite
				caveEntrance
			eachElementDo: #init
		)
		(super init:)
		(if (!= (gLongSong number:) 420)
			(gLongSong number: 420 loop: -1 play:)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((gEgo inRect: 56 97 115 134)
				(self setScript: toShipScript)
			)
		)
		(super doit: &rest)
	)
)

(instance fromAlgaeCaveScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 73))
					(NormalDelph)
					(gDelph init: posn: 65 290 190)
				)
				(NormalEgo)
				(gEgo
					ignoreHorizon: 1
					init:
					posn: 94 220
					z: 28
					setMotion: MoveTo 170 170 self
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance talkToDelph of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo)
				(gEgo
					ignoreHorizon: 1
					init:
					posn: 94 220
					z: 28
					setMotion: MoveTo 170 170 self
				)
			)
			(1
				(NormalDelph)
				(gDelph init: posn: 65 290 setMotion: MoveTo 150 190 self)
			)
			(2
				(SetScore 20 334)
				(gDelph setMotion: MoveTo 154 194 self)
			)
			(3
				((ScriptID 2 0) init: 2 0 0 1 1 self) ; Delphineus, "Adam, you did it! The poison is gone! The first part of the prophecy is fulfilled."
			)
			(4
				((ScriptID 2 1) init: 3 0 0 2 0 self) ; Adam, "They've taken it away, that's true. But I'm afraid it will be a long time before anything can survive here."
			)
			(5
				((ScriptID 2 1) init: 3 0 0 3 0 self) ; Adam, "We also have to worry about catching the people who did this. It looks to me like they've been using this spot for a while."
			)
			(6
				((ScriptID 2 1) init: 3 0 0 4 1 self) ; Adam, "But that's something I'll have to leave up to my dad."
			)
			(7
				((ScriptID 2 0) init: 2 0 0 2 1 self) ; Delphineus, "And we still haven't found Cetus."
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance fromShipScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(HandsOff)
				(NormalEgo)
				(gEgo ignoreHorizon: 1 init: z: 28)
				(if (IsFlag 132)
					(gEgo setScript: enterShark)
				else
					(gEgo
						heading: 125
						loop: 4
						posn: 93 79
						setMotion: PolyPath 119 126 self
					)
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterShark of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo loop: 1 posn: 161 91 setMotion: MoveTo 104 91 self)
				((ScriptID 521 0) init:) ; shark
			)
			(1
				(gEgo loop: 5 setMotion: MoveTo 90 105 self)
			)
			(2
				(gEgo loop: 4 setMotion: MoveTo 100 115)
				(self dispose:)
			)
		)
	)
)

(instance toShipScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 96 114 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance deadFish of EcoFeature
	(properties
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 (if (Random 0 1) 6 else 29))
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 (if (Random 0 1) 7 else 30))
			)
			(6 ; Recycle
				(EcoNarrator init: 1 0 0 39) ; "The divers removed the worst of the contaminated materials. The rest will decompose over time."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadPlant of EcoFeature
	(properties
		onMeCheck 8192
		lookStr 28
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 1 0 0 (if (mod x 2) 30 else 31))
			)
			(6 ; Recycle
				(EcoNarrator init: 1 0 0 39) ; "The divers removed the worst of the contaminated materials. The rest will decompose over time."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spiderWeb of EcoFeature
	(properties
		onMeCheck 4096
		lookStr 26
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 1 0 0 32) ; "The level of chemicals here makes it unsafe to touch anything."
			)
			(6 ; Recycle
				(EcoNarrator init: 1 0 0 39) ; "The divers removed the worst of the contaminated materials. The rest will decompose over time."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ceilingMoss of EcoFeature
	(properties
		onMeCheck 2048
		lookStr 27
	)

	(method (doVerb theVerb)
		(if (== theVerb 6) ; Recycle
			(EcoNarrator init: 1 0 0 39) ; "The divers removed the worst of the contaminated materials. The rest will decompose over time."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance stalagmite of EcoFeature
	(properties
		onMeCheck 1024
		lookStr 37
	)

	(method (doVerb theVerb)
		(if (== theVerb 6) ; Recycle
			(EcoNarrator init: 1 0 0 39) ; "The divers removed the worst of the contaminated materials. The rest will decompose over time."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance caveEntrance of EcoFeature
	(properties
		onMeCheck 512
		approachX 90
		approachY 85
		lookStr 23
	)

	(method (init)
		(self approachVerbs: 4) ; Do
	)
)


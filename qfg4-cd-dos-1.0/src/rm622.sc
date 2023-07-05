;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 622)
(include sci.sh)
(use Main)
(use GloryRm)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm622 0
)

(local
	local0
	local1
)

(instance rm622 of GloryRm
	(properties
		modNum 640
		picture 640
		east 642
	)

	(method (init)
		(gEgo init: setScaler: Scaler 137 83 189 95 normalize:)
		(switch gPrevRoomNum
			(642
				(gEgo setPri: 51 posn: 300 149 hide:)
			)
			(640
				(gEgo setPri: 51 posn: 12 121)
			)
			(else
				(gEgo setPri: 51 posn: 293 149)
			)
		)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 306 189 247 130 124 123 111 137 41 108 45 97 101 97 110 91 53 91 33 99 34 119 16 132 107 151 88 169 0 166
					yourself:
				)
		)
		(pDoor1 init: approachVerbs: 4) ; Do
		(pDoor2 init: approachVerbs: 4) ; Do
		(pDoor3 init: approachVerbs: 4) ; Do
		(vLeftSteps approachVerbs: 4 ignoreActors: init:) ; Do
		(vCupboard approachVerbs: 4 ignoreActors: init:) ; Do
		(vCeiling1 approachVerbs: 4 ignoreActors: init:) ; Do
		(vCeiling2 approachVerbs: 4 ignoreActors: init:) ; Do
		(vThePainting approachVerbs: 4 ignoreActors: init:) ; Do
		(fBowl init: approachVerbs: 4) ; Do
		(fSteps init: approachVerbs: 4) ; Do
		((ScriptID 645 0) init:) ; rm640Code
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 0 1 0 0 0 622) ; "You are in a chamber in the northern part of the castle. Stairs lead up to the western door and an empty platform. Despite its appearance, the platform is of no importance whatsoever."
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(if script
			(script dispose:)
		)
		(DisposeScript 645)
		(super dispose:)
	)
)

(instance sOpenUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (== local0 1)
					(gEgo setMotion: PolyPath 195 127 self)
				else
					(self cue:)
				)
			)
			(1
				(myDoorSound play:)
				(switch local0
					(1
						(pDoor1 setCycle: End self)
					)
					(2
						(pDoor2 setCycle: End self)
					)
					(3
						(pDoor3 setCycle: End self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(gEgo
					view: 4
					posn: (- (gEgo x:) 3) (gEgo y:)
					setLoop: (if (== local0 1) 1 else 0) 1
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(gMessager say: 7 4 14 0 self 640) ; "The cabinet is empty, save for a thick coating of dust."
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo posn: (+ (gEgo x:) 3) (gEgo y:) normalize:)
				(switch local0
					(1
						(pDoor1 setCycle: Beg self)
					)
					(2
						(pDoor2 setCycle: Beg self)
					)
					(3
						(pDoor3 setCycle: Beg self)
					)
				)
			)
			(6
				(shutSound play:)
				(= local0 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCastOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo trySkill: 20) ; openSpell
				(myDoorSound play:)
				(switch local0
					(1
						(pDoor1 setCycle: End self)
					)
					(2
						(pDoor2 setCycle: End self)
					)
					(3
						(pDoor3 setCycle: End self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(switch local0
					(1
						(gEgo setMotion: PolyPath 195 127 self)
					)
					(2
						(gEgo setMotion: PolyPath 204 128 self)
					)
					(3
						(gEgo setMotion: PolyPath 172 126 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(gEgo
					view: 4
					posn: (- (gEgo x:) 3) (gEgo y:)
					setLoop: (if (== local0 1) 1 else 0) 1
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(gMessager say: 7 4 14 0 self 640) ; "The cabinet is empty, save for a thick coating of dust."
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo posn: (+ (gEgo x:) 3) (gEgo y:) normalize:)
				(switch local0
					(1
						(pDoor1 setCycle: Beg self)
					)
					(2
						(pDoor2 setCycle: Beg self)
					)
					(3
						(pDoor3 setCycle: Beg self)
					)
				)
			)
			(6
				(shutSound play:)
				(= local0 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pDoor1 of Prop
	(properties
		noun 7
		modNum 640
		approachX 195
		approachY 127
		x 153
		y 99
		view 643
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local0 1)
				(gCurRoom setScript: sOpenUp)
			)
			(80 ; openSpell
				(= local0 1)
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sCastOpen)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pDoor2 of Prop
	(properties
		noun 7
		modNum 640
		approachX 204
		approachY 128
		x 237
		y 102
		view 643
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local0 2)
				(gCurRoom setScript: sOpenUp)
			)
			(80 ; openSpell
				(= local0 2)
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sCastOpen)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pDoor3 of Prop
	(properties
		noun 7
		modNum 640
		approachX 172
		approachY 126
		x 211
		y 100
		view 643
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local0 3)
				(gCurRoom setScript: sOpenUp)
			)
			(80 ; openSpell
				(= local0 3)
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sCastOpen)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vLeftSteps of View
	(properties
		noun 9
		modNum 640
		y 9
		z -80
		priority 75
		fixPriority 1
		view 693
	)
)

(instance vThePainting of View
	(properties
		noun 4
		modNum 640
		approachX 139
		approachY 125
		x 150
		y 34
		view 698
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(cond
				((IsFlag 178)
					(gMessager say: 3 6 11 1 0 640) ; "There is nothing else behind the painting."
				)
				((== gHeroType 2) ; Thief
					(SetFlag 178)
					(gEgo get: 0 6) ; thePurse
					(gMessager say: 3 6 10 1 0 640) ; "Behind the painting you find a small hidden compartment containing six Crowns. You invoke the salvage laws (also known as "Finders, Keepers") and are now six Crowns richer."
				)
				(else
					(gMessager say: 3 6 12 1 0 640) ; "You find nothing of value."
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance vCupboard of View
	(properties
		noun 7
		modNum 640
		approachX 163
		approachY 126
		x 147
		y 91
		view 643
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local0 1)
				(gCurRoom setScript: sOpenUp)
			)
			(80 ; openSpell
				(= local0 1)
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sCastOpen)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vCeiling1 of View
	(properties
		view 690
	)
)

(instance vCeiling2 of View
	(properties
		x 180
		view 690
		cel 1
	)
)

(instance fBowl of Feature
	(properties
		noun 11
		modNum 640
		nsLeft 157
		nsTop 89
		nsRight 179
		nsBottom 98
		sightAngle 180
		approachX 167
		approachY 127
		x 168
		y 93
	)
)

(instance fSteps of Feature
	(properties
		noun 8
		modNum 640
		nsTop 107
		nsRight 110
		nsBottom 160
		sightAngle 180
		x 40
		y 160
	)
)

(instance shutSound of Sound
	(properties
		number 960
	)
)

(instance myDoorSound of Sound
	(properties
		number 972
	)
)


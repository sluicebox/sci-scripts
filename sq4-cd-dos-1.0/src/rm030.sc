;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Feature)
(use Polygon)
(use ForwardCounter)
(use Sound)
(use Motion)
(use System)

(public
	rm030 0
)

(local
	[local0 28] = [0 172 22 177 36 174 64 174 80 181 120 173 149 179 168 174 205 180 232 180 256 185 319 184 319 189 0 189]
)

(instance rm030 of SQRoom
	(properties
		picture 30
		style 10
		east 35
		south 45
		west 25
	)

	(method (init)
		(Load rsSOUND 148)
		(Load rsSCRIPT 956)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 185 293 185 251 187 220 181 156 182 120 176 81 183 59 176 32 180 0 175
					yourself:
				)
		)
		(switch gPrevRoomNum
			(east
				(gEgo y: 186 setHeading: 270)
			)
			(west
				(gEgo y: 179 setHeading: 90)
			)
			(south 0)
			(else
				(gEgo posn: 160 185)
			)
		)
		(gEgo init:)
		(lightningScript start: 1)
		(lightning1 init: hide: setScript: lightningScript)
		(thunder init:)
		(theRubble init:)
		(theBackBldgs init:)
		(streetPoly points: @local0 size: 14)
		(theStreet init:)
		(opening init:)
		(superComputer init:)
		(theArea init:)
		(if (not (IsFlag 0))
			(self setRegions: 701) ; street
		)
		(super init:)
		(self setRegions: 705) ; bunny
	)
)

(instance lightningScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 20))
			)
			(1
				(self start: 0)
				(= seconds (Random 3 6))
			)
			(2
				(client show: setCel: 0 setCycle: Fwd)
				(= cycles 1)
			)
			(3
				(thunder play:)
				(client setCycle: ForwardCounter (Random 1 3) self)
			)
			(4
				(client hide:)
				(self init:)
			)
		)
	)
)

(instance thunder of Sound
	(properties
		number 150
		priority 15
	)
)

(instance lightning1 of Sq4Prop
	(properties
		x 240
		y 38
		view 32
	)
)

(instance theRubble of Sq4Feature
	(properties
		x 160
		y 5
		nsBottom 200
		nsRight 320
		onMeCheck 8192
		lookStr 1 ; "The clearing ends here. Jagged chunks of debris clog the north."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator say: 2) ; "The rubble is rough and jagged. No sense in risking injury this early in the adventure. There's plenty of time for that later."
			)
			(6 ; Smell
				(gNarrator say: 3) ; "It smells like the remains of a flourishing civilization blasted to smithereens by an evil entity of immense power."
			)
			(7 ; Taste
				(gNarrator say: 4) ; "It doesn't taste half bad, considering what it smells like."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theBackBldgs of Sq4Feature
	(properties
		x 160
		y 5
		nsBottom 200
		nsRight 320
		onMeCheck 64
		lookStr 5 ; "In the distance the skeletal remains of once proud structures jut weakly into the chemical-laden atmosphere."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Taste
				(gNarrator say: 6) ; "If your tongue were that long... well, you can guess the rest."
			)
			(6 ; Smell
				(gNarrator say: 7) ; "The ruined buildings smell of death and destruction."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theStreet of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		lookStr 8 ; "Creases from tank treads, craters from incoming ordnance, and gouges from fallen debris are the only deviations in an otherwise-smooth surface."
	)

	(method (init)
		(super init:)
		(self onMeCheck: streetPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator say: 9) ; "It has that unmistakeably tangy aroma of pressure-treated petrochemicals."
			)
			(7 ; Taste
				(gNarrator say: 10) ; "The taste of the street brings to mind all those wonderful times as a child that the local bully ground your face into the asphalt."
			)
			(9 ; rope
				((ScriptID 705 4) doVerb: theVerb) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance streetPoly of Polygon
	(properties)
)

(instance superComputer of Sq4Feature
	(properties
		x 160
		y 20
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck 1024
		lookStr 11 ; "The large structure in the background captures your curiosity."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Taste
				(gNarrator say: 12) ; "Nobody can reach that building from here with their tongue unless they're in a Leisure Suit Larry game."
			)
			(6 ; Smell
				(gNarrator say: 13) ; "It smells like trouble. What's going on in there?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance opening of Sq4Feature
	(properties
		x 160
		y 22
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck 2048
		lookStr 14 ; "There seems to be some light pouring through a row of three openings high up in the face of the distant structure."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theArea of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		lookStr 15 ; "You are at the northern boundary of a clearing in the midst of a battle-scarred city. An ominous-looking building is the only thing in sight which might contain life."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; rope
				((ScriptID 705 4) doVerb: theVerb) ; theRoom
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)


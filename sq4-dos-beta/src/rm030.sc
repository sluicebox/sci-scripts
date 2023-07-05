;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Actor)
(use System)

(public
	rm030 0
)

(procedure (localproc_0 param1) ; UNUSED
	(switch param1
		(4)
		(else
			(super doVerb: param1)
		)
	)
)

(instance rm030 of SQRoom
	(properties
		picture 30
		style 30
		east 35
		south 45
		west 25
	)

	(method (init)
		(Load rsSOUND 807)
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
		(lightning1 init: hide: setScript: lightningScript)
		(thunder init:)
		(theRubble init:)
		(theBackBldgs init:)
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
				(= seconds (Random 15 30))
			)
			(1
				(client
					show:
					setCel: 0
					setCycle: ForwardCounter (Random 1 3) self
				)
				(thunder play:)
			)
			(2
				(client hide:)
				(self init:)
			)
		)
	)
)

(instance thunder of Sound
	(properties
		number 807
		priority 15
	)
)

(instance lightning1 of Prop
	(properties
		x 240
		y 38
		view 32
	)
)

(instance theRubble of Feature
	(properties
		x 160
		y 5
		nsBottom 200
		nsRight 320
		description {rubble}
		onMeCheck 8192
		lookStr {The clearing ends here. Jagged chunks of debris clog the north.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 30 0) ; "The rubble is rough and jagged. No sense in risking injury this early in the adventure. There will be plenty of time for that later."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theBackBldgs of Feature
	(properties
		x 160
		y 5
		nsBottom 200
		nsRight 320
		description {back buildings}
		onMeCheck 64
		lookStr {In the distance the skeletal remains of once proud structures continue to defy to the end, jutting weakly into the chemical-laden atmosphere.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theArea of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {area}
		lookStr {You are at the northern boundary of a clearing in the midst of a battle-scarred city. Standing so large and ominous, the monstrous building is the only thing in sight which might contain some life.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4) ; Do
			(6 ; Inventory
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)


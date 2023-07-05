;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Elevator)
(use Osc)
(use Polygon)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm5 0
)

(local
	[local0 36] = [0 0 319 0 319 189 0 189 0 74 32 67 257 67 263 48 188 48 183 52 169 52 169 49 154 49 154 52 140 52 135 45 31 45 0 52]
	[local36 40] = [49 157 76 169 107 156 260 156 319 167 319 189 0 189 0 0 319 0 319 147 243 132 189 133 184 144 171 144 166 128 156 128 151 144 139 144 135 134 110 134]
)

(instance rm5 of SQRoom
	(properties
		lookStr {This is another hallway aboard the Arcada. There is an elevator door nearby.}
		picture 5
		east 6
		west 4
	)

	(method (init)
		(LoadMany rsVIEW 105 400 4)
		(upperPoly points: @local0 size: 18)
		(lowerPoly points: @local36 size: 20)
		(body init: stopUpd:)
		(alertSign setCycle: Fwd init:)
		(= style (if (== gPrevRoomNum west) 12 else 11))
		(gEgo init:)
		(super init:)
		(upperDoor
			exiting: (if (not (OneOf gPrevRoomNum west east)) 1 else 0)
			init:
			whereTo: lowerDoor
			polyCode: changeToUpper
		)
		(lowerDoor init: whereTo: upperDoor polyCode: changeToLower)
		(if (== global166 1)
			(switch gPrevRoomNum
				(west
					(self addObstacle: upperPoly)
				)
				(east
					(if (< (gEgo y:) 56)
						(gEgo y: 56)
					)
					(body approachVerbs: 2 3 5) ; Look, Do, Talk
					(upperDoor _approachVerbs: 26505)
					(lowerDoor _approachVerbs: 26505)
					(self
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 0 0 319 0 319 51 289 58 283 68 319 68 319 189 0 189
								yourself:
							)
					)
				)
			)
		else
			(switch gPrevRoomNum
				(west
					(upperDoor _approachVerbs: 26505)
					(lowerDoor _approachVerbs: 26505)
					(self
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 0 0 319 0 319 189 0 189 0 187 36 187 56 178 24 161 0 161
								yourself:
							)
					)
				)
				(east
					(self addObstacle: lowerPoly)
				)
			)
		)
		(self setRegions: 700) ; arcadaRegion
		(HandsOn)
	)

	(method (doit)
		(cond
			((== global166 2)
				(if (& (gEgo onControl:) $0010)
					(gEgo setPri: 1)
				else
					(gEgo setPri: -1)
				)
			)
			((& (gEgo onControl: 1) $0008)
				(gEgo setPri: 1)
			)
			(else
				(gEgo setPri: -1)
			)
		)
		(cond
			(script 0)
			((lowerDoor inFront:)
				(lowerDoor open:)
			)
			((upperDoor inFront:)
				(upperDoor open:)
			)
		)
		(super doit:)
	)
)

(instance changeToUpper of Code
	(properties)

	(method (doit)
		(= global166 1)
		((gCurRoom obstacles:) delete: lowerPoly add: upperPoly)
	)
)

(instance changeToLower of Code
	(properties)

	(method (doit)
		(= global166 2)
		((gCurRoom obstacles:) delete: upperPoly add: lowerPoly)
	)
)

(instance searchBody of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 0 self)
			)
			(1
				(if register
					(Printf ; "You search Jerry's body and find %s"
						5
						0
						(if (not (gEgo has: 1)) {a keycard.} else {nothing.}) ; keyCard
					)
					(if (not (gEgo has: 1)) ; keyCard
						(SetScore 1 132)
						(gEgo get: 1) ; keyCard
					)
					(= state 2)
				)
				(gEgo
					view: 4
					loop: 4
					cycleSpeed: 5
					moveSpeed: 5
					cel: register
					setCycle: (if register Beg else End) self
				)
			)
			(2
				(gEgo
					loop: (+ (gEgo loop:) 2)
					cel: 0
					setCycle: Osc 2 self
				)
				(= state 0)
				(= register 3)
			)
			(3
				(HandsOn)
				(= state -1)
				(= register 0)
				(NormalEgo 7 0 60)
				(self dispose:)
			)
		)
	)
)

(instance body of View
	(properties
		x 301
		y 54
		description {Jerry}
		sightAngle 45
		approachX 317
		approachY 58
		lookStr {It's all that remains of Jerry, one of the few technodudes aboard who sometimes tolerated your company. Your low clearance excluded you from visiting him during the performance of his duties in the elegant lower level airlock of the Arcada.}
		view 400
		loop 1
		cel 5
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(if (and (== gPrevRoomNum 6) (== global166 1))
			(switch theVerb
				(3 ; Do
					(if (!= _approachVerbs 26505)
						(gCurRoom setScript: searchBody)
					else
						(super doVerb: theVerb &rest)
					)
				)
				(5 ; Talk
					(Print 5 1) ; "Funny, no response."
				)
				(12 ; Smell
					(Print 5 2) ; "He smells like Jerry."
				)
				(11 ; Taste
					(Print 5 3) ; "I don't think you really want to taste Jerry. But then, who knows?"
				)
				(4 ; Inventory
					(switch invItem
						(10 ; buckazoid
							(Print 5 4) ; "Jerry won't be needing any cash soon."
						)
						(0 ; Cartridge
							(Print 5 5) ; "If Jerry ever knew how to read this cartridge, he's not telling now."
						)
						(1 ; keyCard
							(Print 5 6) ; "You really shouldn't put the keycard back -- you're going to need it later."
						)
						(15 ; Widget
							(Print 5 7) ; "Jerry is beyond the need for a widget."
						)
						(2 ; Gadget
							(Print 5 8) ; "Jerry doesn't appear to be saying anything for the translator gadget to translate."
						)
						(else
							(super doVerb: theVerb invItem)
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Print 5 9) ; "You can't do that from your current position."
		)
	)
)

(instance alertSign of Prop
	(properties
		x 225
		y 102
		description {alert sign}
		sightAngle 90
		lookStr {Gee! The sign seems to be flashing. Could it be a warning of some kind? Who knows? You're always slower than normal after a nap.}
		view 105
		loop 2
		cycleSpeed 8
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== global166 2)
			(super doVerb: theVerb &rest)
		else
			(Print 5 10) ; "You can't do that from this level."
		)
	)
)

(instance upperDoor of Elevator
	(properties
		x 162
		y 46
		description {elevator door}
		sightAngle 45
		lookStr {These appear to be doors to an elevator.}
		view 105
		cycleSpeed 4
		level 1
	)

	(method (doVerb theVerb)
		(if (== global166 level)
			(switch theVerb
				(2 ; Look
					(if (== _approachVerbs 26505)
						(Print 5 11) ; "This is an elevator to one of the lower levels."
					else
						(Print 5 12) ; "You can't do that from this here."
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Print 5 10) ; "You can't do that from this level."
		)
	)
)

(instance lowerDoor of Elevator
	(properties
		x 162
		y 138
		z 1
		description {elevator door}
		sightAngle 45
		lookStr {elevator}
		view 105
		cycleSpeed 4
		level 2
	)

	(method (doVerb theVerb)
		(if (== global166 level)
			(switch theVerb
				(2 ; Look
					(Print 5 13) ; "This is an elevator to one of the upper levels."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Print 5 10) ; "You can't do that from this level."
		)
	)
)

(instance upperPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance lowerPoly of Polygon
	(properties
		type PBarredAccess
	)
)


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use Interface)
(use arcadaRegion)
(use eRS)
(use Elevator)
(use Osc)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm6 0
)

(local
	[local0 24] = [0 0 319 0 319 78 219 78 133 54 74 53 68 33 56 33 54 53 42 53 38 47 0 47]
	[local24 12] = [0 66 112 66 215 94 319 94 319 189 0 189]
	[local36 40] = [0 147 0 0 319 0 319 131 269 151 211 151 192 139 194 126 177 126 181 138 160 151 96 151 85 158 74 158 69 138 58 138 55 158 42 158 32 151 21 151]
	[local76 20] = [0 167 49 176 159 176 165 173 211 173 219 176 286 176 319 159 319 189 0 189]
	[local96 8] = [95 160 148 160 148 165 95 165]
	local104
	local105
)

(instance rm6 of SQRoom
	(properties
		lookStr {More hallway extends through the Arcada. There is an elevator door nearby.}
		picture 6
		style 10
		east 3
		west 5
	)

	(method (init)
		(LoadMany rsVIEW 400 106 4)
		(upper1 points: @local0 size: 12)
		(upper2 points: @local24 size: 6)
		(lower1 points: @local36 size: 20)
		(lower2 points: @local76 size: 10)
		(lower3 points: @local96 size: 4)
		(deadMan init:)
		(deadMan2 init:)
		(gFeatures add: labDoor eachElementDo: #init)
		(if (== global166 1)
			(self addObstacle: upper1 upper2)
			((ScriptID 700 0) ; arcadaRegion
				sarienEntryDir: 2
				s1startY: 81
				s2startY: 93
				s1gotoX: 237
				s1gotoY: 82
				s2gotoX: 231
				s2gotoY: 94
			)
		else
			(self addObstacle: lower1 lower2 lower3)
			(deadMan startUpd: approachVerbs: 2 3) ; Look, Do
			(deadMan2 startUpd: approachVerbs: 2 3) ; Look, Do
			(if (== gPrevRoomNum 3)
				(gEgo setPri: 3)
			)
			((ScriptID 700 0) ; arcadaRegion
				sarienEntryDir: 1
				s1startY: 149
				s2startY: 163
				s1gotoX: 21
				s1gotoY: 158
				s2gotoX: 27
				s2gotoY: 171
			)
		)
		(self setRegions: 700) ; arcadaRegion
		((ScriptID 700 0) safeCode: egoSafe) ; arcadaRegion
		(gEgo init:)
		(if (OneOf gPrevRoomNum west east)
			(= style (if (== gPrevRoomNum west) 12 else 11))
		else
			(gEgo setPri: 3 posn: 183 140)
			(self setScript: enterFrom7)
		)
		(super init:)
		(upperDoor init: whereTo: lowerDoor polyCode: changeToUpper)
		(lowerDoor
			light: elevatorLight
			init:
			whereTo: upperDoor
			polyCode: changeToLower
		)
		(alertLight setCycle: Fwd init:)
		(if (OneOf gPrevRoomNum west east)
			(HandsOn)
		)
	)

	(method (doit)
		(if (== global166 2)
			(if (> (gEgo x:) 167)
				(gEgo setPri: 3)
			else
				(gEgo setPri: -1)
			)
		)
		(cond
			(script 0)
			((& (gEgo onControl: 1) $0008)
				(HandsOff)
				(gCurRoom newRoom: 7)
			)
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
		(deadMan stopUpd: _approachVerbs: 26505)
		(deadMan2 stopUpd: _approachVerbs: 26505)
		((gCurRoom obstacles:) delete: lower1 lower2 lower3)
		((gCurRoom obstacles:) add: upper1 upper2)
	)
)

(instance changeToLower of Code
	(properties)

	(method (doit)
		(= global166 2)
		(deadMan startUpd: approachVerbs: 2 3 5) ; Look, Do, Talk
		(deadMan2 startUpd: approachVerbs: 2 3 5) ; Look, Do, Talk
		((gCurRoom obstacles:) delete: upper1 upper2)
		((gCurRoom obstacles:) add: lower1 lower2 lower3)
	)
)

(instance egoSafe of Code
	(properties)

	(method (doit &tmp temp0)
		(= temp0 0)
		(if
			(or
				(lowerDoor busy:)
				(upperDoor busy:)
				(!= global166 global173)
				(& (gEgo onControl: 1) $000c)
			)
			(= temp0 1)
		)
		(return temp0)
	)
)

(instance enterFrom7 of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(if local104
			(if (gEgo moveHead:)
				(gEgo moveHead: 0)
			)
			(= temp0
				(GetAngle
					(gEgo x:)
					(gEgo y:)
					(panicDroid x:)
					(panicDroid y:)
				)
			)
			(cond
				((>= 220 temp0 135)
					((gEgo _head:) cel: 2)
				)
				((< temp0 135)
					((gEgo _head:) cel: 4)
				)
				(else
					((gEgo _head:) cel: 5)
				)
			)
		)
		(if (and (not local104) (not (gEgo moveHead:)))
			(gEgo moveHead: 1)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				0
				(= cycles 3)
			)
			(1
				(HandsOff)
				(gEgo setLoop: 2)
				(if (and (>= gHowFast 1) (not (proc700_1 553 2)))
					(= local104 1)
					(panicDroid init: setCycle: Fwd)
					((ScriptID 700 0) ; arcadaRegion
						rFlag1: (| ((ScriptID 700 0) rFlag1:) $0002) ; arcadaRegion
					)
					(gEgo setMotion: MoveTo 183 155)
				else
					(gEgo setMotion: MoveTo 183 155 self)
				)
			)
			(2
				(= local104 0)
				(HandsOn)
				((ScriptID 700 0) sarienState: 2 setCountDown: (Random 2 4)) ; arcadaRegion
				(NormalEgo)
				(gEgo ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance searchBody of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 180 self)
			)
			(1
				(if register
					(Printf 6 0 ((CueObj client:) description:)) ; "Your search of %s reveals nothing even you'd carry."
					(= state 2)
				)
				(gEgo
					view: 4
					loop: (if (< (gEgo x:) ((CueObj client:) x:)) 1 else 0)
					cycleSpeed: 5
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
				(NormalEgo 2 0 60)
				(self dispose:)
			)
		)
	)
)

(instance deadMan of View
	(properties
		x 121
		y 164
		description {David}
		sightAngle 45
		approachX 137
		approachY 162
		lookStr {A cursory glance indicates that Dave, a lab technician, is dead. Normally you wouldn't be able to tell, except that his intestines are hanging out of the scorched opening where his abdominal wall used to be. You remember that he was forced to serve in the Xenon National Guard (but he wasn't bitter).}
		view 400
		loop 1
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(if (== global166 2)
			(switch theVerb
				(3 ; Do
					(if (== global166 1)
						(Print 6 1) ; "You can't mess with anything that's not on your floor."
					else
						(gCurRoom setScript: searchBody)
					)
				)
				(5 ; Talk
					(Print 6 2) ; "Dead people sure are boring!"
				)
				(12 ; Smell
					(Print 6 3) ; "Gee, He doesn't smell bitter, taste him."
				)
				(11 ; Taste
					(Print 6 4) ; "Hmmmm, still not bitter, just like you thought."
				)
				(4 ; Inventory
					(switch invItem
						(10 ; buckazoid
							(Print 6 5) ; "You owed Dave a couple of Buckazoids, but there's not much point in repaying them now."
						)
						(0 ; Cartridge
							(Print 6 6) ; "Dave seems somehow disinterested in the cartridge."
						)
						(1 ; keyCard
							(Print 6 7) ; "Dave never had a keycard, and he sure doesn't need one now."
						)
						(15 ; Widget
							(Print 6 8) ; "Dave is remarkably unresponsive to your offer of a widget."
						)
						(2 ; Gadget
							(Print 6 9) ; "Dave has given up speaking for the rest of his life. Even the translator gadget won't help here."
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
			(Print 6 10) ; "You can't do that from this level."
		)
	)
)

(instance deadMan2 of View
	(properties
		x 188
		y 179
		description {Blanche}
		sightAngle 45
		approachX 178
		approachY 176
		lookStr {This is one of the head research scientists, Blanche. You wanted to get to know her a little better. However, seeing her ruptured chest wall reveals more about her than you were hoping to learn.}
		view 400
		cel 1
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(if (== global166 2)
			(switch theVerb
				(3 ; Do
					(if (== global166 1)
						(Print 6 11) ; "You can't manipulate anything not on your level."
					else
						(gCurRoom setScript: searchBody)
					)
				)
				(5 ; Talk
					(Print 6 2) ; "Dead people sure are boring!"
				)
				(11 ; Taste
					(Print 6 12) ; "Hey keep your tongue to yourself, slimeball."
				)
				(12 ; Smell
					(Print 6 13) ; "Hey, she's wearing that really great perfume again, Eau DePain."
				)
				(4 ; Inventory
					(switch invItem
						(10 ; buckazoid
							(Print 6 14) ; "It's unlikely Blanche would appreciate the gesture."
						)
						(0 ; Cartridge
							(Print 6 15) ; "Blanche pays as much attention to you as she ever has."
						)
						(1 ; keyCard
							(Print 6 16) ; "Blanche shows as much interest in the keycard as you might expect her to, being dead and all."
						)
						(15 ; Widget
							(Print 6 17) ; "Your shiny new widget is not making much of an impression of Blanche, that's for sure."
						)
						(2 ; Gadget
							(Print 6 18) ; "The translation gadget does not appear to work if there's no speech to translate, and Blanche is remarkably quite lately."
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
			(Print 6 10) ; "You can't do that from this level."
		)
	)
)

(instance elevatorLight of View
	(properties
		description {light}
		sightAngle 45
		lookStr {An arrow in the elevator light assembly points up.}
		view 106
		loop 2
		signal 1
	)

	(method (doVerb theVerb)
		(if (== global166 2)
			(super doVerb: theVerb &rest)
		else
			(Print 6 10) ; "You can't do that from this level."
		)
	)
)

(instance alertLight of Prop
	(properties
		x 280
		y 45
		description {alert light}
		sightAngle 90
		lookStr {In case you're trying to play this as a text adventure, the sign says 'RED ALERT' and it's flashing.}
		view 106
		loop 1
		signal 16400
		cycleSpeed 8
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(super doVerb: theVerb &rest)
		else
			(Print 6 10) ; "You can't do that from this level."
		)
	)
)

(instance upperDoor of Elevator
	(properties
		x 64
		y 48
		description {elevator door}
		sightAngle 45
		lookStr {This is an elevator to one of the other levels of the Arcada.}
		view 106
		cycleSpeed 4
		level 1
	)

	(method (doVerb theVerb)
		(if (== global166 level)
			(switch theVerb
				(2 ; Look
					(Print 6 19) ; "This elevator goes down."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Print 6 11) ; "You can't manipulate anything not on your level."
		)
	)
)

(instance lowerDoor of Elevator
	(properties
		x 65
		y 152
		description {elevator door}
		sightAngle 45
		lookStr {This is an elevator to one of the other levels of the Arcada.}
		view 106
		cycleSpeed 4
		level 2
	)

	(method (doVerb theVerb)
		(if (== global166 level)
			(switch theVerb
				(2 ; Look
					(Print 6 20) ; "This elevator goes up."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Print 6 10) ; "You can't do that from this level."
		)
	)
)

(instance panicDroid of Actor
	(properties
		x 345
		y 143
		description {panicking droid}
		lookStr {A fairly spazzed-out droid is on the loose in your immediate proprioceptic area.}
		yStep 6
		view 414
		cycleSpeed 4
		xStep 10
		moveSpeed 4
	)

	(method (init)
		(super init: &rest)
		(gLongSong2 number: 357 loop: -1 play: 0)
		(self
			setLoop: 0
			ignoreActors: 1
			setMotion: DPath 276 165 45 167 -34 147 self
		)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(super doit:)
		(if (> x 167)
			(self setPri: 3)
		else
			(self setPri: -1)
		)
		(if (< (= temp0 (Abs (- (panicDroid x:) (gEgo x:)))) 0)
			(= temp0 0)
		)
		(if (> temp0 90)
			(= temp0 90)
		)
		(if
			(>
				(= temp1 (Abs (- (+ (- (gEgo x:) (panicDroid x:)) 63) 127)))
				127
			)
			(= temp1 127)
		)
		(if (< temp1 0)
			(= temp1 0)
		)
		(gLongSong2
			send: 7 10 temp1
			send: 8 10 temp1
			send: 9 10 temp1
			setVol: (- 127 temp0)
		)
		(if (< (- x (gEgo x:)) 0)
			(if (< (-= local105 6) -512)
				(= local105 -512)
			)
			(gLongSong2
				send: 7 224 local105
				send: 8 224 local105
				send: 9 224 local105
				send: 11 224 local105
			)
		)
	)

	(method (dispose)
		(gLongSong2 loop: 0 stop:)
		(super dispose:)
	)

	(method (cue)
		(enterFrom7 cue:)
		(self dispose:)
	)
)

(instance labDoor of Feature
	(properties
		x 188
		y 136
		heading 180
		nsTop 96
		nsLeft 172
		nsBottom 138
		nsRight 202
		description {labDoor}
		sightAngle 45
		onMeCheck 72
		approachX 188
		approachY 149
		lookStr {This is the door to the top secret Star Generator Lab. It's been forcibly ventilated!}
	)

	(method (doVerb theVerb)
		(if (== global166 2)
			(super doVerb: theVerb &rest)
		else
			(Print 6 10) ; "You can't do that from this level."
		)
	)
)

(instance upper1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance upper2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance lower1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance lower2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance lower3 of Polygon
	(properties
		type PBarredAccess
	)
)


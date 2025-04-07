;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 634)
(include sci.sh)
(use Main)
(use Teller)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm640Code 0
)

(local
	local0
	local1
)

(instance rm640Code of Code
	(properties)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 69 319 189 303 189 266 144 259 136 46 122 5 146 5 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 85 131 224 139 220 162 135 173 89 164
					yourself:
				)
		)
		(if (< (gEgo x:) 10)
			(= local0 1)
		)
		(pRtDoor approachVerbs: 4 32 init:) ; Do, theOil
		(rightDoorTeller init: pRtDoor 640 2 155)
		(pLtDoor approachVerbs: 4 32 init:) ; Do, theOil
		(leftDoorTeller init: pLtDoor 640 2 155)
		(vRightDoor approachVerbs: 4 32 ignoreActors: init:) ; Do, theOil
		(vLeftDoor approachVerbs: 4 32 ignoreActors: init:) ; Do, theOil
		(if (not (== gCurRoomNum 631))
			(fSteps init: approachVerbs: 4) ; Do
		)
		(gCurRoom setScript: sEnter)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= ticks 24)
			)
			(1
				(doorSound play:)
				(if local0
					(pLtDoor setCycle: End self)
				else
					(pRtDoor setCycle: End self)
				)
			)
			(2
				(pLtDoor setPri: 86)
				(pRtDoor setPri: 86)
				(if local0
					(gEgo setMotion: MoveTo 80 155 self)
				else
					(gEgo setMotion: PolyPath 282 168 self)
				)
			)
			(3
				(if local0
					(pLtDoor setPri: 86 setCycle: Beg self)
				else
					(pRtDoor setPri: 86 setCycle: Beg self)
				)
			)
			(4
				(doorCloseSound play:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPeepingTom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(switch gCurRoomNum
					(631
						(gEgo setLoop: (if (< (gEgo x:) 60) 1 else 0) 1)
					)
					(else
						(gEgo setLoop: 0 1)
					)
				)
				(gEgo view: 4 setCel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 2 155 27 1 self 640) ; "You don't see any sign of life or movement beyond the door."
			)
			(2
				(= seconds 3)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenTheDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(doorSound play:)
				(if (< (gEgo x:) 160)
					(= local0 1)
					(switch gCurRoomNum
						(631
							(if (IsFlag 209)
								(self cue:)
							else
								(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
								(squeakSound play:)
							)
						)
						(else
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
							(squeakSound play:)
						)
					)
					(pLtDoor setCycle: End self)
				else
					(= local0 0)
					(switch gCurRoomNum
						(631
							(if (IsFlag 210)
								(self cue:)
							else
								(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
								(squeakSound play:)
							)
						)
						(else
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
							(squeakSound play:)
						)
					)
					(pRtDoor setCycle: End self)
				)
			)
			(1
				(doorCloseSound stop: dispose:)
				(squeakSound stop: dispose:)
				(doorSound stop: dispose:)
				(if local0
					(gEgo
						setMotion:
							MoveTo
							(- (gEgo x:) 2)
							(- (gEgo y:) 2)
							self
					)
				else
					(gEgo
						setMotion:
							MoveTo
							(+ (gEgo x:) 2)
							(- (gEgo y:) 2)
							self
					)
				)
			)
			(2
				(if local0
					(gCurRoom newRoom: 662)
				else
					(gCurRoom newRoom: (gCurRoom east:))
				)
			)
		)
	)
)

(instance sCastOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo trySkill: 20) ; openSpell
				(doorSound play:)
				(if local0
					(switch gCurRoomNum
						(631
							(if (IsFlag 209)
								(self cue:)
							else
								(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
								(squeakSound play:)
							)
						)
						(else
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
							(squeakSound play:)
						)
					)
					(pLtDoor setCycle: End self)
				else
					(switch gCurRoomNum
						(631
							(if (IsFlag 210)
								(self cue:)
							else
								(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
								(squeakSound play:)
							)
						)
						(else
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
							(squeakSound play:)
						)
					)
					(pRtDoor setCycle: End self)
				)
			)
			(1
				(doorCloseSound stop: dispose:)
				(squeakSound stop: dispose:)
				(doorSound stop: dispose:)
				(if local0
					(gEgo
						setMotion:
							PolyPath
							(pLtDoor approachX:)
							(pLtDoor approachY:)
							self
					)
				else
					(gEgo
						setMotion:
							PolyPath
							(pRtDoor approachX:)
							(pRtDoor approachY:)
							self
					)
				)
			)
			(2
				(if local0
					(gCurRoom newRoom: 662)
				else
					(gCurRoom newRoom: (gCurRoom east:))
				)
			)
		)
	)
)

(instance sPickLock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo trySkill: 9 global422) ; pick locks
				(gEgo trySkill: 9 global422) ; pick locks
				(if (== (gEgo trySkill: 9 global422) 1) ; pick locks
					(gGlory handsOff:)
					(gMessager say: 1 42 1 1 self 640) ; "You hear a gentle "Snick" -- the lock is open!"
				else
					(gMessager say: 1 42 2 1 0 640) ; "This is a tricky lock; you'll need to keep practicing."
					(self dispose:)
				)
			)
			(1
				(cond
					((and (== gCurRoomNum 631) (IsFlag 209))
						(self cue:)
					)
					((and (== gCurRoomNum 631) (IsFlag 210))
						(self cue:)
					)
					(else
						(squeakSound play:)
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(self cue:)
					)
				)
			)
			(2
				(doorSound play:)
				(if (< (gEgo x:) 160)
					(= local0 1)
					(pLtDoor setCycle: End self)
				else
					(= local0 0)
					(pRtDoor setCycle: End self)
				)
			)
			(3
				(doorCloseSound stop: dispose:)
				(squeakSound stop: dispose:)
				(doorSound stop: dispose:)
				(= cycles 5)
			)
			(4
				(if (< (gEgo x:) 160)
					(gCurRoom newRoom: 662)
				else
					(gCurRoom newRoom: (gCurRoom east:))
				)
			)
		)
	)
)

(instance sLeave of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(doorCloseSound stop: dispose:)
				(squeakSound stop: dispose:)
				(doorSound stop: dispose:)
				(gEgo
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 10) self
				)
			)
			(1
				(gCurRoom newRoom: (gCurRoom east:))
			)
		)
	)
)

(instance pLtDoor of Prop
	(properties
		noun 1
		modNum 640
		approachX 39
		approachY 134
		y 32
		priority 207
		fixPriority 1
		view 644
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local0 1)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(32 ; theOil
				(if (== gCurRoomNum 631)
					(SetFlag 209)
				)
				(gMessager say: 1 32 0 1 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(42 ; theToolkit
				(gCurRoom setScript: sPickLock)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pRtDoor of Prop
	(properties
		noun 1
		modNum 640
		approachX 262
		approachY 151
		x 270
		y 73
		z 10
		priority 207
		fixPriority 1
		view 644
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local0 0)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(32 ; theOil
				(if (== gCurRoomNum 631)
					(SetFlag 210)
				)
				(gMessager say: 1 32 0 1 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(42 ; theToolkit
				(gCurRoom setScript: sPickLock)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vRightDoor of View
	(properties
		noun 1
		modNum 640
		approachX 262
		approachY 151
		x 271
		y 65
		view 644
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local0 0)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(32 ; theOil
				(if (== gCurRoomNum 631)
					(SetFlag 210)
				)
				(gMessager say: 1 32 0 1 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(42 ; theToolkit
				(gCurRoom setScript: sPickLock)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vLeftDoor of View
	(properties
		noun 1
		modNum 640
		approachX 39
		approachY 134
		y 29
		view 644
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local0 1)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(32 ; theOil
				(if (== gCurRoomNum 631)
					(SetFlag 209)
				)
				(gMessager say: 1 32 0 1 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(42 ; theToolkit
				(gCurRoom setScript: sPickLock)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fSteps of Feature
	(properties
		noun 8
		modNum 640
		nsLeft 284
		nsTop 113
		nsRight 319
		nsBottom 134
		sightAngle 180
		x 301
		y 123
	)
)

(instance rightDoorTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				13 ; Look for Traps
				(and (== gHeroType 2) (IsFlag 242)) ; Thief
				7 ; Pick the Lock
				(and [gEgoStats 9] (gEgo has: 24)) ; pick locks, theToolkit
		)
	)

	(method (sayMessage)
		(switch iconValue
			(4 ; Open Door
				(if (== gHeroType 2) ; Thief
					(super sayMessage: 3 6 9 &rest) ; The door won't budge -- it's locked.
				else
					(self clean:)
					(gCurRoom setScript: sOpenTheDoor)
				)
			)
			(7 ; Pick the Lock
				(self clean:)
				(gCurRoom setScript: sPickLock)
			)
			(27 ; Peer Through Keyhole
				(self clean:)
				(gCurRoom setScript: sPeepingTom)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance leftDoorTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				13 ; Look for Traps
				(and (== gHeroType 2) (IsFlag 242)) ; Thief
				7 ; Pick the Lock
				(and [gEgoStats 9] (gEgo has: 24)) ; pick locks, theToolkit
		)
	)

	(method (sayMessage)
		(switch iconValue
			(4 ; Open Door
				(if (== gHeroType 2) ; Thief
					(super sayMessage: 3 6 9 &rest) ; The door won't budge -- it's locked.
				else
					(self clean:)
					(gCurRoom setScript: sOpenTheDoor)
				)
			)
			(7 ; Pick the Lock
				(self clean:)
				(gCurRoom setScript: sPickLock)
			)
			(27 ; Peer Through Keyhole
				(self clean:)
				(gCurRoom setScript: sPeepingTom)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance squeakSound of Sound
	(properties
		number 143
	)
)

(instance doorSound of Sound
	(properties
		number 972
	)
)

(instance doorCloseSound of Sound
	(properties
		number 973
	)
)


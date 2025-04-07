;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 645)
(include sci.sh)
(use Main)
(use Teller)
(use PolyPath)
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
	local2
	local3
)

(instance rm640Code of Code
	(properties)

	(method (init)
		(if (< (gEgo x:) 95)
			(= local0 1)
		)
		(switch gCurRoomNum
			(622
				(if local0
					(= local2 42)
					(= local3 116)
				else
					(= local2 247)
					(= local3 151)
				)
				(pLeftDoor
					approachVerbs: 4 32 ; Do, theOil
					ignoreActors:
					setPri: 64
					approachX: 46
					approachY: 115
					init:
				)
				(pRightDoor
					approachVerbs: 4 32 ; Do, theOil
					ignoreActors:
					approachX: 251
					approachY: 153
					init:
				)
				(rightDoorTeller init: pRightDoor 640 2 155)
				(leftDoorTeller init: pLeftDoor 640 2 155)
				(vLeftDoor approachVerbs: 4 32 ignoreActors: init:) ; Do, theOil
				(vRightDoor approachVerbs: 4 32 ignoreActors: init:) ; Do, theOil
				(gCurRoom setScript: sEnter)
			)
			(623
				(if local0
					(= local2 85)
					(= local3 91)
				else
					(= local2 298)
					(= local3 140)
				)
				(pLeftDoor
					view: 687
					setLoop: 0 1
					setCel: 0
					posn: 57 10
					approachX: 88
					approachY: 96
					approachVerbs: 4 32 ; Do, theOil
					ignoreActors:
					setPri: 97
					init:
				)
				(pRightDoor
					view: 695
					setLoop: 2 1
					setCel: 0
					posn: 261 52
					approachX: 310
					approachY: 140
					approachVerbs: 4 32 ; Do, theOil
					ignoreActors:
					init:
				)
				(rightDoorTeller init: pRightDoor 640 2 155)
				(leftDoorTeller init: pLeftDoor 640 2 155)
				(vLeftDoor
					view: 695
					setLoop: 0 1
					setCel: 0
					posn: 261 50
					approachVerbs: 4 32 ; Do, theOil
					ignoreActors:
					init:
				)
				(vRightDoor
					view: 687
					setLoop: 1 1
					setCel: 0
					posn: 57 7
					approachX: 310
					approachY: 123
					approachVerbs: 4 32 ; Do, theOil
					ignoreActors:
					init:
				)
				(gCurRoom setScript: sEnter)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 2)
			)
			(1
				(doorSound play:)
				(if local0
					(pLeftDoor setCycle: End self)
				else
					(pRightDoor setCycle: End self)
				)
			)
			(2
				(pLeftDoor setPri: 68)
				(doorSound dispose:)
				(gEgo setPri: 86 show: setMotion: MoveTo local2 local3 self)
			)
			(3
				(doorCloseSound play:)
				(gEgo setPri: -1)
				(if local0
					(pLeftDoor setCycle: Beg self)
				else
					(pRightDoor setCycle: Beg self)
				)
			)
			(4
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
					(622
						(if (> (gEgo x:) 100)
							(gEgo setLoop: 0 1)
						else
							(gEgo setLoop: 1 1)
						)
					)
					(623
						(gEgo setLoop: 1 1)
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
						(622
							(if (IsFlag 219)
								(self cue:)
							)
						)
						(623
							(if (IsFlag 213)
								(self cue:)
							)
						)
						(else
							(squeakSound play:)
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						)
					)
					(pLeftDoor setCycle: End self)
				else
					(= local0 0)
					(switch gCurRoomNum
						(622
							(if (IsFlag 217)
								(self cue:)
							)
						)
						(623
							(if (IsFlag 225)
								(self cue:)
							)
						)
						(else
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
							(squeakSound play:)
						)
					)
					(pRightDoor setCycle: End self)
				)
			)
			(1
				(squeakSound stop: dispose:)
				(doorSound stop: dispose:)
				(doorCloseSound stop: dispose:)
				(cond
					(local0
						(gEgo
							setMotion:
								MoveTo
								(- (gEgo x:) 2)
								(- (gEgo y:) 2)
								self
						)
					)
					((== gCurRoomNum 623)
						(gEgo
							setMotion:
								MoveTo
								(gEgo x:)
								(- (gEgo y:) 2)
								self
						)
					)
					(else
						(gEgo
							setMotion:
								MoveTo
								(+ (gEgo x:) 2)
								(- (gEgo y:) 2)
								self
						)
					)
				)
			)
			(2
				(if local0
					(if (== gCurRoomNum 622)
						(gCurRoom newRoom: 640)
					else
						(gCurRoom newRoom: (gCurRoom west:))
					)
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
				(doorSound play:)
				(if local0
					(switch gCurRoomNum
						(622
							(if (IsFlag 219)
								(self cue:)
							)
						)
						(623
							(if (IsFlag 213)
								(self cue:)
							)
						)
						(else
							(squeakSound play:)
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						)
					)
					(pLeftDoor setCycle: End self)
				else
					(switch gCurRoomNum
						(622
							(if (IsFlag 217)
								(self cue:)
							)
						)
						(623
							(if (IsFlag 225)
								(self cue:)
							)
						)
						(else
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
							(squeakSound play:)
						)
					)
					(pRightDoor setCycle: End self)
				)
			)
			(1
				(squeakSound stop: dispose:)
				(doorSound stop: dispose:)
				(doorCloseSound stop: dispose:)
				(if local0
					(gEgo
						setMotion:
							PolyPath
							(pLeftDoor approachX:)
							(pLeftDoor approachY:)
							self
					)
				else
					(gEgo
						setMotion:
							PolyPath
							(pRightDoor approachX:)
							(pRightDoor approachY:)
							self
					)
				)
			)
			(2
				(if local0
					(if (== gCurRoomNum 622)
						(gCurRoom newRoom: 640)
					else
						(gCurRoom newRoom: (gCurRoom west:))
					)
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
				(if (< (gEgo x:) 160)
					(= local0 1)
				)
				(switch gCurRoomNum
					(622
						(cond
							((and (IsFlag 217) local0)
								(self cue:)
							)
							((IsFlag 219)
								(self cue:)
							)
							(else
								(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
								(squeakSound play:)
								(self cue:)
							)
						)
					)
					(623
						(cond
							((and (IsFlag 213) local0)
								(self cue:)
							)
							((IsFlag 225)
								(self cue:)
							)
							(else
								(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
								(squeakSound play:)
								(self cue:)
							)
						)
					)
					(else
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(squeakSound play:)
						(self cue:)
					)
				)
			)
			(2
				(doorSound play:)
				(if (< (gEgo x:) 160)
					(= local0 1)
					(pLeftDoor setCycle: End self)
				else
					(= local0 0)
					(pRightDoor setCycle: End self)
				)
			)
			(3
				(squeakSound stop: dispose:)
				(doorSound stop: dispose:)
				(doorCloseSound stop: dispose:)
				(= cycles 5)
			)
			(4
				(if (< (gEgo x:) 160)
					(if (== gCurRoomNum 622)
						(gCurRoom newRoom: 640)
					else
						(gCurRoom newRoom: (gCurRoom west:))
					)
				else
					(gCurRoom newRoom: (gCurRoom east:))
				)
			)
		)
	)
)

(instance pLeftDoor of Prop
	(properties
		noun 1
		modNum 640
		approachX 31
		approachY 119
		y 29
		z 4
		priority 64
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
			(else
				(vLeftDoor doVerb: theVerb)
			)
		)
	)
)

(instance pRightDoor of Prop
	(properties
		noun 1
		modNum 640
		approachX 269
		approachY 152
		x 264
		y 61
		priority 86
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
			(else
				(vRightDoor doVerb: theVerb)
			)
		)
	)
)

(instance vRightDoor of View
	(properties
		noun 1
		modNum 640
		approachX 269
		approachY 152
		x 265
		y 59
		priority 64
		fixPriority 1
		view 644
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; theOil
				(switch gCurRoomNum
					(622
						(SetFlag 217)
					)
					(623
						(SetFlag 225)
					)
				)
				(gMessager say: 1 32 0 1 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(42 ; theToolkit
				(gCurRoom setScript: sPickLock)
			)
			(-80 ; openSpell (part 2)
				(= local0 0)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
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
		approachX 21
		approachY 119
		y 27
		priority 51
		fixPriority 1
		view 644
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; theOil
				(switch gCurRoomNum
					(622
						(SetFlag 219)
					)
					(623
						(SetFlag 213)
					)
				)
				(gMessager say: 1 32 0 1 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(42 ; theToolkit
				(gCurRoom setScript: sPickLock)
			)
			(-80 ; openSpell (part 2)
				(= local0 1)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(else
				(super doVerb: theVerb)
			)
		)
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


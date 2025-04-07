;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 626)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm626 0
)

(local
	local0
)

(instance rm626 of GloryRm
	(properties
		modNum 640
		picture 640
		horizon 66
		north 661
	)

	(method (init)
		(switch gPrevRoomNum
			(642
				(gEgo posn: -10 155)
			)
			(661
				(gEgo posn: 151 94)
			)
			(else
				(gEgo posn: 151 94)
			)
		)
		(gEgo init: setScaler: Scaler 100 42 115 58 normalize:)
		(if (< (gEgo x:) 10)
			(= local0 1)
		)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 59 116 4 150 4 189 -300 189 -300 0 619 0 619 189 285 189 237 140 215 138 185 118 158 59 143 59 97 121
					yourself:
				)
		)
		(pDoor init: approachVerbs: 4 32) ; Do, theOil
		(doorTeller init: pDoor 640 2 155)
		((pFire new:) posn: 254 76 setCel: 6 setCycle: Fwd init:)
		((pFire new:) posn: 280 84 setCel: 0 setCycle: Fwd init:)
		(vRightDoor ignoreActors: approachVerbs: 4 32 init:) ; Do, theOil
		(vEndLessHall ignoreActors: init:)
		(vColumn1 ignoreActors: init:)
		(vColumn2 ignoreActors: init:)
		(vBench ignoreActors: init:)
		(gCurRoom setScript: sEnter)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 0 1 0 0 0 626) ; "A long hall runs north and south between two of the castle rooms."
		else
			(super doVerb: theVerb)
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
				(if local0
					(doorSound play:)
					(pDoor setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if local0
					(gEgo setMotion: MoveTo 49 155 self)
				else
					(gEgo setMotion: PolyPath 146 141 self)
				)
			)
			(3
				(if local0
					(doorCloseSound play:)
					(pDoor setCycle: Beg self)
				else
					(self cue:)
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
				(gEgo view: 4 setCel: 0 setLoop: 0 1 setCycle: End self)
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
				(if (not (IsFlag 218))
					(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
					(squeakSound play:)
				)
				(pDoor setCycle: End self)
			)
			(1
				(squeakSound dispose:)
				(doorSound dispose:)
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(- (gEgo y:) 5)
						self
				)
			)
			(2
				(gCurRoom newRoom: 642)
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
				(if (not (IsFlag 218))
					(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
					(squeakSound play:)
				)
				(pDoor setCycle: End self)
			)
			(1
				(squeakSound dispose:)
				(doorSound dispose:)
				(gEgo
					setMotion:
						PolyPath
						(pDoor approachX:)
						(pDoor approachY:)
						self
				)
			)
			(2
				(gCurRoom newRoom: 642)
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
				(if (IsFlag 218)
					(self cue:)
				else
					(squeakSound play:)
					(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
					(self cue:)
				)
			)
			(2
				(doorSound play:)
				(pDoor setCycle: End self)
			)
			(3
				(squeakSound dispose:)
				(doorSound dispose:)
				(= cycles 5)
			)
			(4
				(gCurRoom newRoom: 642)
			)
		)
	)
)

(instance sSitAndRest of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 261 163 self)
			)
			(1
				(Face gEgo 10 170 self)
			)
			(2
				(gEgo
					view: 54
					setLoop: 4 1
					setCel: 0
					posn: 267 162
					setCycle: End self
				)
			)
			(3
				(= register gClock)
				((ScriptID 7 2) init:) ; doSleep
				(= register (> gClock register))
				(DisposeScript 7)
				(DisposeScript 34)
				(if register
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo posn: 261 162 normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pDoor of Prop
	(properties
		noun 1
		modNum 640
		approachX 10
		approachY 170
		x -8
		y 37
		priority 75
		fixPriority 1
		view 644
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(32 ; theOil
				(SetFlag 224)
				(gMessager say: 1 32 0 0 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(else
				(vRightDoor doVerb: theVerb)
			)
		)
	)
)

(instance pFire of Prop
	(properties
		noun 21
		modNum 640
		priority 75
		fixPriority 1
		view 699
		loop 8
		signal 16385
		detailLevel 2
	)
)

(instance vEndLessHall of View
	(properties
		modNum 640
		x 77
		y 3
		view 678
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance vRightDoor of View
	(properties
		noun 1
		modNum 640
		approachX 10
		approachY 170
		x -10
		y 35
		view 644
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; theOil
				(SetFlag 218)
				(gMessager say: 1 32 0 0 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(-80 ; openSpell (part 2)
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

(instance vColumn1 of View
	(properties
		modNum 640
		x 203
		priority 64
		fixPriority 1
		view 689
		loop 4
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance vColumn2 of View
	(properties
		modNum 640
		x 319
		view 689
		loop 1
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance vBench of View
	(properties
		noun 14
		modNum 640
		x 250
		y 129
		view 699
		loop 4
		cel 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sSitAndRest)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance doorTeller of Teller
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

(instance doorCloseSound of Sound
	(properties
		number 973
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


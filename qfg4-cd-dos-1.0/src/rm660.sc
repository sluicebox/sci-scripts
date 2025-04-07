;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 660)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
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
	rm660 0
)

(local
	local0
)

(instance rm660 of GloryRm
	(properties
		modNum 640
		picture 640
	)

	(method (init)
		(if (== gPrevRoomNum 663)
			(pSecretDoor setCel: 5)
			(gEgo posn: 209 114)
			(= local0 1)
		else
			(gEgo posn: 297 112)
		)
		(gEgo init: setScaler: Scaler 117 100 168 126 normalize:)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 85 111 77 115 176 125 142 188 -300 173 -300 0 619 0 619 137 619 138 295 138 297 139 289 145 258 144 241 127
					yourself:
				)
		)
		(pDoor approachVerbs: 4 32 init:) ; Do, theOil
		(pSecretDoor init: ignoreActors: 1)
		(vTheBed ignoreActors: init:)
		(vTheRug ignoreActors: init:)
		(vTheDoor ignoreActors: approachVerbs: 4 32 init:) ; Do, theOil
		(doorTeller init: vTheDoor 640 2 155)
		(vThePicture ignoreActors: init:)
		(fSteps init: approachVerbs: 4) ; Do
		(fCurtains init: approachVerbs: 4) ; Do
		(gCurRoom setScript: sComeOnIn)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 0 1 0 0 0 660) ; "This must be the rose bedroom. You're somewhere near the northeastern corner of the castle."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sComeOnIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= ticks 30)
			)
			(1
				(doorSound play:)
				(if local0
					(= seconds 2)
				else
					(if (not (IsFlag 223))
						(squeakSound play:)
					)
					(pDoor setCycle: End self)
				)
			)
			(2
				(pDoor setPri: 108)
				(vTheDoor setPri: 97)
				(if local0
					(gEgo setMotion: MoveTo 211 137 self)
				else
					(gEgo setMotion: MoveTo 296 174 self)
				)
			)
			(3
				(doorCloseSound play:)
				(if local0
					(pSecretDoor cycleSpeed: 12 setCycle: Beg self)
				else
					(pDoor setCycle: Beg self)
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
				(gEgo view: 4 setLoop: 1 1 setCel: 0 setCycle: End self)
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
				(if (not (IsFlag 223))
					(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
					(squeakSound play:)
				)
				(pDoor setCycle: End self)
			)
			(1
				(squeakSound dispose:)
				(doorSound dispose:)
				(gEgo setMotion: MoveTo (gEgo x:) (- (gEgo y:) 2) self)
			)
			(2
				(gCurRoom newRoom: 621)
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
				(if (not (IsFlag 223))
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
				(gCurRoom newRoom: 621)
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
				(if (IsFlag 223)
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
				(gEgo
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 2) self
				)
				(squeakSound dispose:)
				(doorSound dispose:)
			)
			(4
				(gCurRoom newRoom: 621)
			)
		)
	)
)

(instance sLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(doorSound play:)
				(pSecretDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 209 114 self)
			)
			(2
				(gCurRoom newRoom: 663)
			)
		)
	)
)

(instance pDoor of Prop
	(properties
		modNum 640
		approachX 311
		approachY 117
		x 261
		y 51
		priority 207
		fixPriority 1
		view 695
		loop 2
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
			(else
				(vTheDoor doVerb: theVerb)
			)
		)
	)
)

(instance pSecretDoor of Prop
	(properties
		modNum 640
		approachX 191
		approachY 110
		x 181
		y 73
		priority 75
		fixPriority 1
		view 660
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (or (< gMouseX 160) (< 37 gMouseY 92))
					(vThePicture doVerb: 1)
				else
					(gCurRoom doVerb: 1)
				)
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sLeave)
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

(instance vTheBed of View
	(properties
		noun 19
		modNum 640
		y 5
		priority 152
		fixPriority 1
		view 688
		signal 20481
	)
)

(instance vTheRug of View
	(properties
		noun 33
		modNum 640
		x 145
		y 139
		view 688
		loop 2
	)
)

(instance vTheDoor of View
	(properties
		noun 1
		modNum 640
		approachX 298
		approachY 137
		x 262
		y 59
		z 10
		priority 152
		fixPriority 1
		view 695
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; theOil
				(SetFlag 223)
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

(instance vThePicture of View
	(properties
		noun 4
		modNum 640
		x 93
		y 23
		priority 86
		fixPriority 1
		view 698
	)
)

(instance fSteps of Feature
	(properties
		noun 8
		modNum 640
		nsLeft 285
		nsTop 114
		nsRight 319
		nsBottom 136
		sightAngle 180
		x 302
		y 125
	)
)

(instance fCurtains of Feature
	(properties
		noun 18
		modNum 640
		nsTop 7
		nsRight 63
		nsBottom 93
		sightAngle 180
		x 31
		y 50
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


;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 642)
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
	rm642 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm642 of GloryRm
	(properties
		modNum 640
		picture 640
		north 624
		east 626
	)

	(method (init)
		(switch gPrevRoomNum
			(622
				(= local0 55)
				(= local1 135)
				(gEgo posn: 4 106)
			)
			(624
				(= local0 195)
				(= local1 133)
				(gEgo posn: 160 105)
			)
			(else
				(= local0 225)
				(= local1 175)
				(gEgo hide: posn: 296 159)
			)
		)
		(gEgo init: setScaler: Scaler 100 100 189 0 normalize:)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 303 189 258 139 230 135 220 126 171 123 143 122 88 119 68 125 42 122 27 132 13 131 5 155 6 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 52 142 196 142 190 165 136 183 98 186 52 184
					yourself:
				)
		)
		(pLeftDoor init: approachVerbs: 4 32) ; Do, theOil
		(leftDoorTeller init: pLeftDoor 640 2 155)
		(pBackDoor init: approachVerbs: 4 32) ; Do, theOil
		(backDoorTeller init: pBackDoor 640 2 155)
		(pRightDoor init: approachVerbs: 4 32) ; Do, theOil
		(rightDoorTeller init: pRightDoor 640 2 155)
		(pLeftSconce ignoreActors: setCycle: Fwd init:)
		(pRightSconce ignoreActors: setCycle: Fwd init:)
		(vLeftColumn ignoreActors: init:)
		(vRightColumn ignoreActors: init:)
		(vTheRug ignoreActors: init:)
		(vTheTable ignoreActors: approachVerbs: 4 init:) ; Do
		(vTheDoor ignoreActors: approachVerbs: 4 32 init:) ; Do, theOil
		(vLeftDoor ignoreActors: approachVerbs: 4 32 init:) ; Do, theOil
		(vRightDoor ignoreActors: approachVerbs: 4 32 init:) ; Do, theOil
		(fChair1 init: approachVerbs: 4) ; Do
		(fChair2 init: approachVerbs: 4) ; Do
		(fChair3 init: approachVerbs: 4) ; Do
		(gCurRoom setScript: sComeOnIn)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 0 1 0 0 0 642) ; "You are in a chamber two stories up from the Great Hall. The northern door will take you back down."
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
				(doorSound play:)
				(switch gPrevRoomNum
					(624
						(pBackDoor setCycle: End self)
					)
					(622
						(pLeftDoor setCycle: End self)
					)
					(else
						(pRightDoor setCycle: End self)
					)
				)
			)
			(1
				(vTheDoor setPri: 75)
				(pBackDoor setPri: 86)
				(pLeftDoor setPri: 75)
				(pRightDoor setPri: 75)
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(2
				(doorCloseSound play:)
				(switch gPrevRoomNum
					(624
						(pBackDoor setCycle: Beg self)
					)
					(622
						(pLeftDoor setCycle: Beg self)
					)
					(else
						(pRightDoor setCycle: Beg self)
					)
				)
			)
			(3
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
				(if (< (gEgo x:) 160)
					(if (< (gEgo y:) 124)
						(= local2 1)
						(if (not (IsFlag 216))
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
							(squeakSound play:)
						)
						(pBackDoor setCycle: End self)
					else
						(= local3 1)
						(if (not (IsFlag 217))
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
							(squeakSound play:)
						)
						(pLeftDoor setCycle: End self)
					)
				else
					(= local3 0)
					(if (not (IsFlag 218))
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(squeakSound play:)
					)
					(pRightDoor setCycle: End self)
				)
			)
			(1
				(squeakSound dispose:)
				(doorSound dispose:)
				(cond
					(local2
						(gEgo
							setMotion:
								MoveTo
								(gEgo x:)
								(- (gEgo y:) 2)
								self
						)
					)
					(local3
						(gEgo
							setMotion:
								MoveTo
								(- (gEgo x:) 2)
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
				(cond
					(local2
						(gCurRoom newRoom: 624)
					)
					(local3
						(gCurRoom newRoom: 622)
					)
					(else
						(gCurRoom newRoom: (gCurRoom east:))
					)
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
				(cond
					(local3
						(if (not (IsFlag 217))
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
							(squeakSound play:)
						)
						(pLeftDoor setCycle: End self)
					)
					(local2
						(if (not (IsFlag 216))
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
							(squeakSound play:)
						)
						(pBackDoor setCycle: End self)
					)
					(else
						(if (not (IsFlag 218))
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
							(squeakSound play:)
						)
						(pRightDoor setCycle: End self)
					)
				)
			)
			(1
				(squeakSound dispose:)
				(doorSound dispose:)
				(cond
					(local2
						(gEgo
							setMotion:
								PolyPath
								(pBackDoor approachX:)
								(pBackDoor approachY:)
								self
						)
					)
					(local3
						(gEgo
							setMotion:
								PolyPath
								(pLeftDoor approachX:)
								(pLeftDoor approachY:)
								self
						)
					)
					(else
						(gEgo
							setMotion:
								PolyPath
								(pRightDoor approachX:)
								(pRightDoor approachY:)
								self
						)
					)
				)
			)
			(2
				(cond
					(local2
						(gCurRoom newRoom: 624)
					)
					(local3
						(gCurRoom newRoom: 622)
					)
					(else
						(gCurRoom newRoom: (gCurRoom east:))
					)
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
					((IsFlag 216)
						(self cue:)
					)
					((IsFlag 217)
						(self cue:)
					)
					((IsFlag 218)
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
				(cond
					((< (gEgo x:) 100)
						(= local3 1)
						(pLeftDoor setCycle: End self)
					)
					((< (gEgo x:) 190)
						(= local2 1)
						(pBackDoor setCycle: End self)
					)
					(else
						(= local3 0)
						(pRightDoor setCycle: End self)
					)
				)
			)
			(3
				(squeakSound dispose:)
				(doorSound dispose:)
				(= cycles 5)
			)
			(4
				(cond
					((< (gEgo x:) 100)
						(gCurRoom newRoom: 622)
					)
					((< (gEgo x:) 190)
						(gCurRoom newRoom: 624)
					)
					(else
						(gCurRoom newRoom: (gCurRoom east:))
					)
				)
			)
		)
	)
)

(instance pLeftDoor of Prop
	(properties
		noun 1
		modNum 640
		approachX 10
		approachY 148
		x -1
		y 31
		priority 141
		fixPriority 1
		view 644
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local3 1)
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

(instance pBackDoor of Prop
	(properties
		noun 1
		modNum 640
		approachX 131
		approachY 122
		x 128
		y 40
		priority 163
		fixPriority 1
		view 687
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local2 1)
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

(instance pRightDoor of Prop
	(properties
		noun 1
		modNum 640
		approachX 272
		approachY 165
		x 270
		y 70
		priority 196
		fixPriority 1
		view 644
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local3 0)
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

(instance pLeftSconce of Prop
	(properties
		noun 21
		modNum 640
		x 51
		y 58
		priority 97
		fixPriority 1
		view 699
		loop 7
		cel 4
		detailLevel 2
	)
)

(instance pRightSconce of Prop
	(properties
		noun 21
		modNum 640
		x 243
		y 64
		view 699
		loop 7
		detailLevel 2
	)
)

(instance vLeftColumn of View
	(properties
		modNum 640
		x 41
		y -1
		priority 86
		fixPriority 1
		view 685
	)
)

(instance vRightColumn of View
	(properties
		modNum 640
		x 228
		y -1
		view 685
		loop 2
	)
)

(instance vTheRug of View
	(properties
		noun 33
		modNum 640
		x 8
		y 123
		view 692
	)
)

(instance vTheTable of View
	(properties
		noun 28
		modNum 640
		approachX 56
		approachY 113
		x 56
		y 109
		priority 163
		fixPriority 1
		view 697
	)
)

(instance vTheDoor of View
	(properties
		noun 1
		modNum 640
		approachX 131
		approachY 122
		x 126
		y 38
		priority 152
		fixPriority 1
		view 687
		loop 1
		signal 4097
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; theOil
				(SetFlag 216)
				(gMessager say: 1 32 0 1 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(42 ; theToolkit
				(gCurRoom setScript: sPickLock)
			)
			(-80 ; openSpell (part 2)
				(= local2 1)
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
		approachX 10
		approachY 148
		y 29
		view 644
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; theOil
				(SetFlag 217)
				(gMessager say: 1 32 0 1 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(42 ; theToolkit
				(gCurRoom setScript: sPickLock)
			)
			(-80 ; openSpell (part 2)
				(= local3 1)
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

(instance vRightDoor of View
	(properties
		noun 1
		modNum 640
		approachX 272
		approachY 165
		x 271
		y 65
		view 644
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; theOil
				(SetFlag 218)
				(gMessager say: 1 32 0 1 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(42 ; theToolkit
				(gCurRoom setScript: sPickLock)
			)
			(-80 ; openSpell (part 2)
				(= local3 0)
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

(instance fChair1 of Feature
	(properties
		noun 27
		modNum 640
		nsLeft 100
		nsTop 99
		nsRight 125
		nsBottom 133
		sightAngle 180
		x 100
		y 99
	)
)

(instance fChair2 of Feature
	(properties
		noun 27
		modNum 640
		nsLeft 137
		nsTop 114
		nsRight 174
		nsBottom 173
		sightAngle 180
		x 137
		y 173
	)
)

(instance fChair3 of Feature
	(properties
		noun 27
		modNum 640
		nsLeft 59
		nsTop 130
		nsRight 154
		nsBottom 172
		sightAngle 180
		x 63
		y 172
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

(instance backDoorTeller of Teller
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
			(27 ; Peer Through Keyhole
				(self clean:)
				(gCurRoom setScript: sPeepingTom)
			)
			(7 ; Pick the Lock
				(self clean:)
				(gCurRoom setScript: sPickLock)
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


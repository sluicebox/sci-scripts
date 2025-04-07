;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 661)
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
	rm661 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm661 of GloryRm
	(properties
		modNum 640
		picture 640
		style 1024
		west 626
	)

	(method (init)
		(switch gPrevRoomNum
			(626
				(= local0 68)
				(= local1 187)
				(gEgo setLoop: 0 1 posn: 0 173)
			)
			(663
				(= local2 1)
				(= local0 221)
				(= local1 125)
				(gEgo setLoop: 2 1 setCel: 3 posn: 190 115)
			)
			(else
				(= local0 308)
				(= local1 146)
				(gEgo posn: 333 129)
			)
		)
		(gEgo init: setScaler: Scaler 100 100 189 0 normalize: setPri: 0)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -300 0 619 0 619 189 312 189 314 148 283 127 272 127 255 119 143 122 98 124 91 131 68 131 24 189 13 189 -300 189
					yourself:
				)
		)
		(pRightDoor approachVerbs: 4 32 init:) ; Do, theOil
		(rightDoorTeller init: pRightDoor 640 2 155)
		(pLeftDoor approachVerbs: 4 32 init:) ; Do, theOil
		(leftDoorTeller init: pLeftDoor 640 2 155)
		(pHiddenDoor init: ignoreActors: setPri: 152)
		(pLeftSconce ignoreActors: setCycle: Fwd init:)
		(pRightSconce ignoreActors: setCycle: Fwd init:)
		(vTheShelf ignoreActors: approachVerbs: 4 init:) ; Do
		(vTheWindow ignoreActors: init:)
		(vLeftDoor ignoreActors: approachVerbs: 4 32 init:) ; Do, theOil
		(vRightDoor ignoreActors: approachVerbs: 4 32 init:) ; Do, theOil
		(vTheBook init: ignoreActors: approachVerbs: 4) ; Do
		(fWheel init: approachVerbs: 4) ; Do
		(fCresset1 init: approachVerbs: 4) ; Do
		(fCresset2 init: approachVerbs: 4) ; Do
		(gEgo setScript: sComeOnIn)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 0 1 0 0 0 661) ; "This room, somewhere in the northeastern section of the castle, is dominated by a huge set of bookshelves. One of the Boyars must have loved reading."
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
				(= ticks 60)
			)
			(1
				(doorSound play:)
				(cond
					(local2
						(pHiddenDoor setCycle: End self)
					)
					((< (gEgo x:) 60)
						(if (not (IsFlag 224))
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
							(squeakSound play:)
						)
						(pLeftDoor setCycle: End self)
					)
					(else
						(if (not (IsFlag 118))
							(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
							(squeakSound play:)
						)
						(pRightDoor setCycle: End self)
					)
				)
			)
			(2
				(pRightDoor setPri: 108)
				(pLeftDoor setPri: 108)
				(gEgo normalize: setMotion: MoveTo local0 local1 self)
			)
			(3
				(doorCloseSound play:)
				(pHiddenDoor setPri: 53)
				(cond
					(local2
						(pHiddenDoor setCycle: Beg self)
					)
					((< (gEgo x:) 160)
						(pLeftDoor setCycle: Beg self)
					)
					(else
						(pRightDoor setCycle: Beg self)
					)
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
				(if (< (gEgo x:) 60)
					(gEgo setLoop: 1 1)
				else
					(gEgo setLoop: 0 1)
				)
				(gEgo view: 4 setCel: 0 setCycle: End self)
			)
			(1
				(if (> (gEgo x:) 60)
					(gMessager say: 2 155 30 1 self 640) ; "You don't see any movement through the keyhole, but you think you hear movement from the bottom of the stairs."
				else
					(gMessager say: 2 155 27 1 self 640) ; "You don't see any sign of life or movement beyond the door."
				)
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
				(if (< (gEgo x:) 60)
					(if (not (IsFlag 224))
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(squeakSound play:)
					)
					(pLeftDoor setCycle: End self)
				else
					(if (not (IsFlag 118))
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(squeakSound play:)
					)
					(pRightDoor setCycle: End self)
				)
			)
			(1
				(squeakSound dispose:)
				(doorSound dispose:)
				(gEgo
					setMotion:
						MoveTo
						(if (< (gEgo x:) 60)
							(- (gEgo x:) 2)
						else
							(+ (gEgo x:) 2)
						)
						(- (gEgo y:) 2)
						self
				)
			)
			(2
				(if (< (gEgo x:) 100)
					(gCurRoom newRoom: (gCurRoom west:))
				else
					(gCurRoom newRoom: 629)
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
				(if local4
					(if (not (IsFlag 224))
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(squeakSound play:)
					)
					(pLeftDoor setCycle: End self)
				else
					(if (not (IsFlag 118))
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(squeakSound play:)
					)
					(pRightDoor setCycle: End self)
				)
			)
			(1
				(squeakSound dispose:)
				(doorSound dispose:)
				(if local4
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
				(if local4
					(gCurRoom newRoom: (gCurRoom west:))
				else
					(gCurRoom newRoom: 629)
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
					((IsFlag 224)
						(self cue:)
					)
					((IsFlag 118)
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
				(if (< (gEgo x:) 60)
					(pLeftDoor setCycle: End self)
				else
					(pRightDoor setCycle: End self)
				)
			)
			(3
				(gEgo
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 2) self
				)
				(squeakSound dispose:)
				(doorSound dispose:)
			)
			(4
				(if (< (gEgo x:) 100)
					(gCurRoom newRoom: 626)
				else
					(gCurRoom newRoom: 629)
				)
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
				(= ticks 24)
			)
			(1
				(doorSound play:)
				(pHiddenDoor setPri: 207 setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 198 115 self)
			)
			(3
				(gCurRoom newRoom: 663)
			)
		)
	)
)

(instance sSayMessage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 221 125 self)
			)
			(1
				(gEgo normalize:)
				(gMessager say: 3 6 22 1 self 640) ; "There is something strange about the volumes of "Tobin's Spirit Encyclopedia" (subtitled "To Pass Beyond the Veil") on these shelves."
			)
			(2
				(vTheBook setCycle: End self)
			)
			(3
				(pHiddenDoor cue:)
				(self dispose:)
			)
		)
	)
)

(instance pLeftDoor of Prop
	(properties
		noun 1
		modNum 640
		approachX 38
		approachY 186
		x -10
		y 89
		priority 207
		fixPriority 1
		view 644
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local4 1)
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
		approachX 296
		approachY 137
		x 299
		y 61
		priority 207
		fixPriority 1
		view 687
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local4 0)
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

(instance pHiddenDoor of Prop
	(properties
		noun 36
		modNum 640
		approachX 221
		approachY 125
		x 150
		y 61
		view 684
		loop 2
		signal 16385
	)

	(method (cue)
		(if ((ScriptID 664 0) init: show: dispose:) ; spellingPuz
			(DisposeScript 664)
			(gCurRoom setScript: sLeave)
		else
			(vTheBook setCycle: Beg)
			(DisposeScript 664)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sSayMessage)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pLeftSconce of Prop
	(properties
		noun 21
		modNum 640
		x 71
		y 78
		view 699
		loop 12
		cel 5
		detailLevel 2
	)
)

(instance pRightSconce of Prop
	(properties
		noun 21
		modNum 640
		x 279
		y 69
		view 699
		loop 11
		detailLevel 2
	)
)

(instance vTheBook of Prop
	(properties
		noun 35
		modNum 640
		approachX 220
		approachY 86
		x 150
		y 71
		z 10
		view 684
		loop 3
		signal 16385
	)
)

(instance vTheShelf of View
	(properties
		noun 36
		modNum 640
		approachX 220
		approachY 125
		x 291
		y 10
		z 10
		view 684
		loop 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gMessager say: 35 4 0 1 0 640) ; "Some of these books seem to be attached to the bookshelf! Let's see what you can do with them."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance vTheWindow of View
	(properties
		noun 16
		modNum 640
		x 206
		y -20
		view 698
		loop 5
		signal 16385
	)
)

(instance vLeftDoor of View
	(properties
		noun 1
		modNum 640
		approachX 38
		approachY 186
		x -10
		y 81
		view 644
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; theOil
				(SetFlag 224)
				(gMessager say: 1 32 0 1 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(42 ; theToolkit
				(gCurRoom setScript: sPickLock)
			)
			(-80 ; openSpell (part 2)
				(= local4 1)
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
		approachX 296
		approachY 137
		x 299
		y 59
		view 687
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; theOil
				(SetFlag 118)
				(gMessager say: 1 32 0 1 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(-80 ; openSpell (part 2)
				(= local4 0)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
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

(instance fWheel of Feature
	(properties
		noun 34
		modNum 640
		nsLeft 133
		nsRight 200
		nsBottom 39
		sightAngle 180
		x 166
		y 19
	)
)

(instance fCresset1 of Feature
	(properties
		noun 22
		modNum 640
		nsLeft 53
		nsTop 75
		nsRight 71
		nsBottom 100
		sightAngle 180
		x 62
		y 87
	)
)

(instance fCresset2 of Feature
	(properties
		noun 22
		modNum 640
		nsLeft 278
		nsTop 65
		nsRight 296
		nsBottom 92
		sightAngle 180
		x 287
		y 78
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


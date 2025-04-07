;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 643)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use DeathIcon)
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
	rm643 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm643 of GloryRm
	(properties
		modNum 640
		picture 640
		east 624
	)

	(method (init)
		(switch gPrevRoomNum
			(625
				(= local2 1)
				(= local0 55)
				(= local1 164)
				(gEgo posn: 9 130)
			)
			(else
				(= local0 257)
				(= local1 166)
				(gEgo posn: 288 146)
			)
		)
		(gEgo
			init:
			setScaler: Scaler 100 100 189 0
			normalize: (if (== gPrevRoomNum 625) 0 else 1)
		)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 309 189 272 171 240 130 137 133 125 145 56 149 28 137 4 154 4 189 0 189
					yourself:
				)
		)
		(pSafeDoor init: approachVerbs: 4) ; Do
		(pRightDoor init: approachVerbs: 4 32) ; Do, theOil
		(rightDoorTeller init: pRightDoor 640 2 155)
		(pLeftDoor init: approachVerbs: 4 32) ; Do, theOil
		(leftDoorTeller init: pLeftDoor 640 2 155)
		(vLeftCupDoor ignoreActors: approachVerbs: 4 init:) ; Do
		(vMidCupDoor ignoreActors: approachVerbs: 4 init:) ; Do
		(vRightCupDoor ignoreActors: approachVerbs: 4 init:) ; Do
		(vBackDoor ignoreActors: approachVerbs: 4 32 init:) ; Do, theOil
		(vLeftDoor ignoreActors: approachVerbs: 4 32 init:) ; Do, theOil
		(vTheRug ignoreActors: init:)
		(vCupBoard ignoreActors: approachVerbs: 4 init:) ; Do
		(vCeiling ignoreActors: init:)
		(vLeftCeiling ignoreActors: init:)
		(vSafe ignoreActors: approachVerbs: 4 init:) ; Do
		(vThePainting ignoreActors: init:)
		(fBowl init: approachVerbs: 4) ; Do
		(fChest init: approachVerbs: 4) ; Do
		(chestTeller init: fChest 640 2 167)
		(gCurRoom setScript: sComeOnIn)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 0 1 0 0 0 643) ; "This room, up from the Great Hall, is relatively empty (unless you count the low cabinet and the massive iron safe)."
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
				(= seconds 2)
			)
			(1
				(doorSound play:)
				(if local2
					(pLeftDoor setCycle: End self)
				else
					(pRightDoor setCycle: End self)
				)
			)
			(2
				(pRightDoor setPri: 141)
				(pLeftDoor setPri: 141)
				(gEgo setMotion: MoveTo local0 local1 self)
			)
			(3
				(doorCloseSound play:)
				(if local2
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
				(gEgo
					view: 4
					setLoop: (if (> (gEgo x:) 60) 0 else 1) 1
					setCel: 0
					setCycle: CT (if (> (gEgo x:) 60) 2 else 1) 1 self
				)
			)
			(1
				(if (> (gEgo x:) 60)
					(gMessager say: 2 155 27 1 self 640) ; "You don't see any sign of life or movement beyond the door."
				else
					(gMessager say: 2 155 28 1 self 640) ; "Your eyes must have deceived you! For a moment there you could swear you saw a ghost."
				)
			)
			(2
				(= ticks 120)
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
					(= local2 1)
					(if (not (IsFlag 214))
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(squeakSound play:)
					)
					(pLeftDoor setCycle: End self)
				else
					(if (not (IsFlag 215))
						(= local2 0)
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(squeakSound play:)
					)
					(pRightDoor setCycle: End self)
				)
			)
			(1
				(squeakSound dispose:)
				(doorSound dispose:)
				(if local2
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
				(if local2
					(gCurRoom newRoom: 625)
				else
					(gCurRoom newRoom: 624)
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
				(if local2
					(if (not (IsFlag 214))
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(squeakSound play:)
					)
					(pLeftDoor setCycle: End self)
				else
					(if (not (IsFlag 215))
						(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
						(squeakSound play:)
					)
					(pRightDoor setCycle: End self)
				)
			)
			(1
				(squeakSound dispose:)
				(doorSound dispose:)
				(if local2
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
				(if local2
					(gCurRoom newRoom: 625)
				else
					(gCurRoom newRoom: 624)
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
					((IsFlag 215)
						(self cue:)
					)
					((IsFlag 214)
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
					(= local2 1)
					(pLeftDoor setCycle: End self)
				else
					(= local2 0)
					(pRightDoor setCycle: End self)
				)
			)
			(3
				(squeakSound dispose:)
				(doorSound dispose:)
				(= cycles 5)
			)
			(4
				(if (< (gEgo x:) 160)
					(gCurRoom newRoom: 625)
				else
					(gCurRoom newRoom: 624)
				)
			)
		)
	)
)

(instance sDoTheChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if local4
					(self cue:)
				else
					(gMessager say: 6 4 9 1 self 640) ; "The chest is locked."
				)
			)
			(1
				(chestTeller doVerb: 4)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenTheChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (IsFlag 191)
					(self setScript: sAlreadyDone)
				else
					(self cue:)
				)
			)
			(1
				(if (< (gEgo distanceTo: fChest) 100)
					(= local5 1)
				)
				(if (not local3)
					(explosiveSound play:)
					(pExplosive init: setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(pExplosive dispose:)
				(pSafeDoor setCycle: End self)
			)
			(3
				(if (not local3)
					(if local5
						(gEgo takeDamage: 50)
					)
					(gMessager say: 3 6 16 0 self 640) ; "Ka-blooie! You got the chest open, but set off an explosion in the process -- the chest was trapped."
				else
					(self cue:)
				)
			)
			(4
				(if (<= [gEgoStats 17] 0) ; health
					(EgoDead 16 640) ; "You opened the case; the trap shut your eyes. It's hard to make a living when you're dying."
				else
					(= local4 1)
					(gEgo get: 0 15) ; thePurse
					(gEgo setMotion: PolyPath 107 149 self)
				)
			)
			(5
				(gEgo normalize:)
				(gMessager say: 6 4 21 1 0 640) ; "You take 15 Crowns from a pouch in the safe. The safe also contains several papers and some old clothes, but they have deteriorated with age and are worthless, so you leave them."
				(self cue:)
			)
			(6
				(pSafeDoor setCycle: Beg self)
			)
			(7
				(SetFlag 191)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAlreadyDone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pSafeDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: PolyPath 107 149 self)
			)
			(2
				(gEgo normalize:)
				(gMessager say: 6 4 19 1 self 640) ; "You've already taken everything of value from the chest."
			)
			(3
				(pSafeDoor setCycle: Beg self)
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenCupboard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(switch local6
					(1
						(vLeftCupDoor setCycle: End self)
					)
					(2
						(vMidCupDoor setCycle: End self)
					)
					(else
						(vRightCupDoor setCycle: End self)
					)
				)
			)
			(1
				(gEgo
					view: 4
					posn: (- (gEgo x:) 3) (gEgo y:)
					setLoop: (if (== local6 3) 0 else 1) 1
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(if (IsFlag 192)
					(gMessager say: 7 4 14 1 self 640) ; "The cabinet is empty, save for a thick coating of dust."
				else
					(SetFlag 192)
					(gEgo get: 0 6) ; thePurse
					(gMessager say: 7 4 15 1 self 640) ; "You take six kopeks that you find loose in the cabinet."
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(doorCloseSound play:)
				(gEgo posn: (+ (gEgo x:) 3) (gEgo y:) normalize:)
				(switch local6
					(1
						(vLeftCupDoor setCycle: Beg self)
					)
					(2
						(vMidCupDoor setCycle: Beg self)
					)
					(else
						(vRightCupDoor setCycle: Beg self)
					)
				)
			)
			(5
				(= local6 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCastOpenCupboard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo trySkill: 20) ; openSpell
				(switch local6
					(1
						(vLeftCupDoor setCycle: End self)
					)
					(2
						(vMidCupDoor setCycle: End self)
					)
					(else
						(vRightCupDoor setCycle: End self)
					)
				)
			)
			(1
				(switch local6
					(1
						(gEgo
							setMotion:
								PolyPath
								(vLeftCupDoor approachX:)
								(vLeftCupDoor approachY:)
								self
						)
					)
					(2
						(gEgo
							setMotion:
								PolyPath
								(vMidCupDoor approachX:)
								(vMidCupDoor approachY:)
								self
						)
					)
					(else
						(gEgo
							setMotion:
								PolyPath
								(vRightCupDoor approachX:)
								(vRightCupDoor approachY:)
								self
						)
					)
				)
			)
			(2
				(gEgo
					view: 4
					posn: (- (gEgo x:) 3) (gEgo y:)
					setLoop: (if (== local6 3) 0 else 1) 1
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(3
				(if (IsFlag 192)
					(gMessager say: 7 4 14 1 self 640) ; "The cabinet is empty, save for a thick coating of dust."
				else
					(SetFlag 192)
					(gEgo get: 0 6) ; thePurse
					(gMessager say: 7 4 15 1 self 640) ; "You take six kopeks that you find loose in the cabinet."
				)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(doorCloseSound play:)
				(gEgo posn: (+ (gEgo x:) 3) (gEgo y:) normalize:)
				(switch local6
					(1
						(vLeftCupDoor setCycle: Beg self)
					)
					(2
						(vMidCupDoor setCycle: Beg self)
					)
					(else
						(vRightCupDoor setCycle: Beg self)
					)
				)
			)
			(6
				(= local6 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pExplosive of Prop
	(properties
		x 110
		y 118
		priority 174
		fixPriority 1
		view 21
		loop 9
	)
)

(instance pSafeDoor of Prop
	(properties
		noun 17
		modNum 640
		approachX 131
		approachY 148
		x 126
		y 95
		priority 142
		fixPriority 1
		view 698
		loop 8
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sOpenTheChest)
			)
			(82 ; triggerSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 11) 0 self) ; castTriggerScript
			)
			(-82 ; triggerSpell (part 2)
				(gCurRoom setScript: sOpenTheChest)
			)
			(4 ; Do
				(if (IsFlag 191)
					(gCurRoom setScript: sAlreadyDone)
				else
					(gCurRoom setScript: sDoTheChest)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pLeftDoor of Prop
	(properties
		noun 1
		modNum 640
		approachX 37
		approachY 141
		x -1
		y 141
		z 101
		priority 163
		fixPriority 1
		view 644
		loop 1
		signal 16385
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
				(vLeftDoor doVerb: theVerb)
			)
		)
	)
)

(instance pRightDoor of Prop
	(properties
		noun 1
		modNum 640
		approachX 263
		approachY 163
		x 265
		y 163
		z 99
		priority 163
		fixPriority 1
		view 644
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local2 0)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(else
				(vBackDoor doVerb: theVerb)
			)
		)
	)
)

(instance vLeftCupDoor of Prop
	(properties
		noun 7
		modNum 640
		approachX 164
		approachY 135
		x 127
		y 104
		view 643
		loop 3
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local6 1)
				(gCurRoom setScript: sCastOpenCupboard)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(4 ; Do
				(= local6 1)
				(gCurRoom setScript: sOpenCupboard)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vMidCupDoor of Prop
	(properties
		noun 7
		modNum 640
		approachX 195
		approachY 131
		x 156
		y 103
		view 643
		loop 3
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local6 2)
				(gCurRoom setScript: sCastOpenCupboard)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(4 ; Do
				(= local6 2)
				(gCurRoom setScript: sOpenCupboard)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vRightCupDoor of Prop
	(properties
		noun 7
		modNum 640
		approachX 173
		approachY 133
		x 213
		y 102
		view 643
		loop 4
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local6 3)
				(gCurRoom setScript: sCastOpenCupboard)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(4 ; Do
				(= local6 3)
				(gCurRoom setScript: sOpenCupboard)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vBackDoor of View
	(properties
		noun 1
		modNum 640
		approachX 267
		approachY 163
		x 265
		y 62
		view 644
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local2 0)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(32 ; theOil
				(SetFlag 214)
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
		approachX 37
		approachY 141
		y 36
		view 644
		loop 3
		signal 16385
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
			(32 ; theOil
				(SetFlag 215)
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

(instance vTheRug of View
	(properties
		noun 33
		modNum 640
		x 302
		y 136
		view 692
		loop 3
	)
)

(instance vCupBoard of View
	(properties
		noun 7
		modNum 640
		approachX 142
		approachY 130
		x 219
		y 94
		view 643
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(= local6 1)
				(gCurRoom setScript: sCastOpenCupboard)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(4 ; Do
				(= local6 1)
				(gCurRoom setScript: sOpenCupboard)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vCeiling of View
	(properties
		modNum 640
		x 319
		priority 152
		fixPriority 1
		view 690
		loop 1
		signal 16385
	)
)

(instance vLeftCeiling of View
	(properties
		modNum 640
		x 139
		view 690
		loop 1
		cel 1
		signal 16385
	)
)

(instance vSafe of View
	(properties
		noun 17
		modNum 640
		approachX 131
		approachY 148
		x 125
		y 94
		priority 141
		fixPriority 1
		view 698
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sOpenTheChest)
			)
			(82 ; triggerSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 11) 0 self) ; castTriggerScript
			)
			(-82 ; triggerSpell (part 2)
				(gCurRoom setScript: sOpenTheChest)
			)
			(4 ; Do
				(if (IsFlag 191)
					(gCurRoom setScript: sAlreadyDone)
				else
					(gCurRoom setScript: sDoTheChest)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vThePainting of View
	(properties
		noun 4
		modNum 640
		x 213
		y 33
		view 698
		loop 1
	)
)

(instance fBowl of Feature
	(properties
		noun 11
		modNum 640
		nsLeft 188
		nsTop 93
		nsRight 208
		nsBottom 102
		sightAngle 180
		x 198
		y 97
	)
)

(instance fChest of Feature
	(properties
		noun 6
		modNum 640
		nsLeft 66
		nsTop 106
		nsRight 111
		nsBottom 74
		sightAngle 180
		approachX 131
		approachY 148
		x 80
		y 74
	)

	(method (doVerb theVerb)
		(switch theVerb
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sOpenTheChest)
			)
			(82 ; triggerSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 11) 0 self) ; castTriggerScript
			)
			(-82 ; triggerSpell (part 2)
				(gCurRoom setScript: sOpenTheChest)
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

(instance chestTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				13 ; Look for Traps
				(and (gEgo has: 24) (IsFlag 242)) ; theToolkit
				4 ; Open Chest
				(not local4)
				26 ; Pick Lock
				(and (gEgo has: 24) [gEgoStats 9] (not local4)) ; theToolkit, pick locks
				25 ; Bash Chest Open
				(not local4)
		)
	)

	(method (respond)
		(super respond: &rest)
		(if (or (not iconValue) (== iconValue -999))
			(sDoTheChest cue:)
		)
		(return 1)
	)

	(method (sayMessage)
		(switch iconValue
			(13 ; Look for Traps
				(gGlory handsOn:)
				(if local3
					(self clean:)
					(gCurRoom setScript: sOpenTheChest)
				else
					(cond
						(((ScriptID 648 0) init: show: dispose:) ; ticTacPuz
							(= local3 1)
							(self clean:)
							(DisposeScript 648)
							(gCurRoom setScript: sOpenTheChest)
						)
						((IsFlag 182)
							(self clean:)
							(gCurRoom setScript: sOpenTheChest)
						)
					)
					(DisposeScript 648)
				)
			)
			(25 ; Bash Chest Open
				(self clean:)
				(if (== (gEgo trySkill: 0 325) 1) ; strength
					(gCurRoom setScript: sOpenTheChest)
				else
					(gGlory handsOn:)
					(gMessager say: 3 6 17 1 0 640) ; "You are not nearly strong enough to break the chest open; you'll need to do some serious body-building if you want to keep using this approach."
				)
			)
			(26 ; Pick Lock
				(self clean:)
				(gCurRoom setScript: sOpenTheChest)
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

(instance explosiveSound of Sound
	(properties
		number 971
	)
)

(instance doorCloseSound of Sound
	(properties
		number 973
	)
)


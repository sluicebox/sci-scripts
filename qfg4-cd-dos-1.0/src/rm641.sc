;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 641)
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
	rm641 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm641 of GloryRm
	(properties
		modNum 640
		picture 640
	)

	(method (init)
		(gGlory handsOff:)
		(gEgo setScaler: Scaler 136 78 189 117)
		(RemapColors 2 253 140) ; ByPercent
		(RemapColors 2 254 60) ; ByPercent
		(if (== gPrevRoomNum 810) ; combat
			(pDoor setPri: 112)
			(gLongSong doSongs: 630 631 632)
			(switch gCombatResult
				(1
					(aGhost init: ignoreActors: 1 setCycle: Fwd)
					(gEgo posn: 160 170)
					(gCurRoom setScript: sEgosDead)
				)
				(2
					(gEgo posn: 160 170 normalize:)
					(SetFlag 185)
					(gGlory handsOn:)
				)
				(else
					(aGhost init: setCycle: End)
					(gEgo posn: 276 156)
					(ClearFlag 394)
					(gCurRoom setScript: sOpenTheDoor)
				)
			)
			(gEgo init: normalize:)
		else
			(ClearFlag 394)
			(gEgo
				posn: 298 116
				init:
				normalize:
				setPri: 64
				setScript: sComeOnIn
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -300 152 -300 0 619 0 619 146 317 137 295 137 287 148 263 148 253 135 231 135 208 147 191 147 171 153 112 153 103 148 69 139 77 125 38 125
					yourself:
				)
		)
		(super init: &rest)
		((pFlame new:) setCel: 0 posn: 46 70 setCycle: Fwd init:)
		((pFlame new:) setCel: 1 posn: 51 69 setCycle: Fwd init:)
		((pFlame new:) setCel: 2 posn: 55 67 setCycle: Fwd init:)
		((pFlame new:) setCel: 0 posn: 58 68 setCycle: Fwd init:)
		((pFlame new:) setCel: 2 posn: 62 72 setCycle: Fwd init:)
		((pFlame new:) setCel: 1 posn: 217 81 setCycle: Fwd init:)
		((pFlame new:) setCel: 0 posn: 220 77 setCycle: Fwd init:)
		((pFlame new:) setCel: 1 posn: 224 76 setCycle: Fwd init:)
		((pFlame new:) setCel: 0 posn: 227 78 setCycle: Fwd init:)
		((pFlame new:) setCel: 0 posn: 233 79 setCycle: Fwd init:)
		(if (or (IsFlag 394) (IsFlag 185))
			(if (IsFlag 394)
				(= local1 1)
			)
			(pChest setCel: (if (IsFlag 394) 4 else 0) init:)
		)
		(pDoor approachVerbs: 4 32 init:) ; Do, theOil
		(vTheBed signal: (| (vTheBed signal:) $1000) init:)
		(vTheRug ignoreActors: init:)
		(vLeftWindow ignoreActors: init:)
		(vRightDoor ignoreActors: approachVerbs: 4 32 init:) ; Do, theOil
		(doorTeller init: vRightDoor 640 2 155)
		(vLeftCandle ignoreActors: init:)
		(vRightCandle ignoreActors: init:)
		(fChest init: approachVerbs: 4) ; Do
		(fSteps init: approachVerbs: 4) ; Do
		(fBedHead init: approachVerbs: 4) ; Do
		(fCurtain1 init: approachVerbs: 4) ; Do
		(fCurtain2 init: approachVerbs: 4) ; Do
		(if (and (IsFlag 185) (== gPrevRoomNum 810) (== gCombatResult 2)) ; combat
			(gMessager say: 3 6 32 0 0 640) ; "Finally, the Wraith vanishes under the force of your onslaught, its ties to this world severed at last."
		)
		(if (and (!= gPrevRoomNum 810) (not (IsFlag 185))) ; combat
			(gGlory save: 1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 0) ; castOpenScript
			)
			(1 ; Look
				(gMessager say: 0 1 0 0 0 641) ; "This bedroom in the western end of the castle seems not to have been used in some time, judging from the layer of dust on the bedclothes. The window on the west wall has been mortared over, and admits no light."
			)
			(82 ; triggerSpell
				(if (IsFlag 185)
					(if (IsFlag 394)
						(gMessager say: 6 80 19 0 0 640) ; "The chest is already open."
					else
						(gCurRoom setScript: sOpenTheChest)
					)
				else
					(gCurRoom setScript: sGhostHere)
				)
			)
			(else
				(super doVerb: theVerb)
			)
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
				(pDoor setCycle: End self)
			)
			(2
				(pDoor setPri: 112)
				(gEgo setPri: -1 setMotion: PolyPath 304 149 self)
			)
			(3
				(doorCloseSound play:)
				(pDoor setCycle: Beg self)
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
				(= seconds 2)
			)
			(1
				(doorSound play:)
				(if (and (not (IsFlag 213)) (not (== gPrevRoomNum 810))) ; combat
					(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
					(squeakSound play:)
				)
				(pDoor setCycle: End self)
			)
			(2
				(squeakSound dispose:)
				(doorSound dispose:)
				(pDoor setPri: 75)
				(gEgo setMotion: MoveTo (gEgo x:) (- (gEgo y:) 2) self)
			)
			(3
				(gCurRoom newRoom: 623)
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
				(= seconds 2)
			)
			(1
				(doorSound play:)
				(if (and (not (IsFlag 213)) (not (== gPrevRoomNum 810))) ; combat
					(gMessager say: 1 4 3 1 0 640) ; "The door hinges squeak in protest as you open the door."
					(squeakSound play:)
				)
				(pDoor setCycle: End self)
			)
			(2
				(squeakSound dispose:)
				(doorSound dispose:)
				(pDoor setPri: 75)
				(gEgo
					setMotion:
						PolyPath
						(pDoor approachX:)
						(pDoor approachY:)
						self
				)
			)
			(3
				(gCurRoom newRoom: 623)
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
				(if (IsFlag 213)
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
				(if (>= global422 300)
					(= global422 300)
				else
					(++ global422)
				)
				(= ticks 24)
			)
			(4
				(gEgo
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 2) self
				)
				(squeakSound dispose:)
				(doorSound dispose:)
			)
			(5
				(gCurRoom newRoom: 623)
			)
		)
	)
)

(instance sEgosDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 3)
			)
			(1
				(EgoDead 24 640 43 End 852) ; "You've just had a close encounter with a spirit of the ghost kind. When all is said, however, your life's done."
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
				(gEgo trySkill: 20) ; openSpell
				(cond
					((IsFlag 187)
						(client setScript: sAlreadyDone)
					)
					(local1
						(self changeState: 4)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(if (< (gEgo distanceTo: fChest) 50)
					(= local0 1)
				)
				(if (not local2)
					(explosiveSound play:)
					(pExplosive init: setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if (not local2)
					(pExplosive dispose:)
				)
				(pChest
					init:
					signal: (| (pChest signal:) $0001)
					setCycle: End self
				)
			)
			(3
				(if (not local2)
					(if local0
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
					(gEgo setMotion: PolyPath 144 140 self)
				)
			)
			(5
				(= local1 1)
				(gEgo normalize:)
				(gMessager say: 6 4 20 1 self 640) ; "In the chest you find a small flask labelled "Healing" and 25 Crowns. Pretty nice for a few minutes work!"
				(gEgo get: 0 25) ; thePurse
				(gEgo get: 3 1) ; theHeals
			)
			(6
				(SetFlag 187)
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
				(if (== (pChest cel:) 4)
					(self cue:)
				else
					(pChest
						signal: (| (pChest signal:) $0001)
						setCycle: End self
					)
				)
			)
			(1
				(gEgo setMotion: PolyPath 144 140 self)
			)
			(2
				(gEgo normalize:)
				(pChest signal: (& (pChest signal:) $fffe))
				(gMessager say: 6 4 19 1 0 640) ; "You've already taken everything of value from the chest."
				(self cue:)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenGhostHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (< (gEgo distanceTo: fChest) 50)
					(= local0 1)
				)
				(if (not local2)
					(explosiveSound play:)
					(pExplosive init: setCycle: End self)
				else
					(self cue:)
				)
			)
			(1
				(if (not local2)
					(pExplosive dispose:)
				)
				(pChest
					init:
					signal: (| (pChest signal:) $0001)
					setCycle: End self
				)
			)
			(2
				(if (not local2)
					(if local0
						(gEgo takeDamage: 50)
					)
					(gMessager say: 3 6 16 0 self 640) ; "Ka-blooie! You got the chest open, but set off an explosion in the process -- the chest was trapped."
				else
					(self cue:)
				)
			)
			(3
				(SetFlag 394)
				(self setScript: sGhostHere)
			)
		)
	)
)

(instance sGhostHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(ghostSound play:)
				(aGhost init: setLoop: 3 1 setCel: 0 setCycle: End self)
			)
			(1
				(= gCombatMonsterNum 850) ; wraith
				(= global156 300)
				(aGhost
					setCel: 0
					setLoop: 4 1
					setCycle: Fwd
					setMotion:
						MoveTo
						(- (gEgo x:) 5)
						(- (gEgo y:) 20)
						self
				)
			)
			(2
				(ghostSound stop:)
				(gCurRoom newRoom: 810) ; combat
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
				(if local1
					(gMessager say: 6 80 19 1 self 640) ; "The chest is already open."
				else
					(gMessager say: 6 4 9 1 self 640) ; "The chest is locked."
				)
			)
			(1
				(chestTeller init: pChest 640 2 167)
				(chestTeller doVerb: 4)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aGhost of Actor
	(properties
		x 133
		y 99
		priority 174
		fixPriority 1
		view 686
		loop 3
	)
)

(instance pFlame of Prop
	(properties
		noun 15
		modNum 640
		view 699
		loop 6
		detailLevel 2
	)
)

(instance pExplosive of Prop
	(properties
		x 144
		y 127
		priority 174
		fixPriority 1
		view 21
		loop 9
	)
)

(instance pChest of Prop
	(properties
		noun 6
		modNum 640
		sightAngle 180
		x 113
		y 133
		z 12
		priority 146
		fixPriority 1
		view 686
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(80 ; openSpell
				(fChest doVerb: theVerb)
			)
			(4 ; Do
				(if cel
					(gCurRoom setScript: sOpenTheChest)
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

(instance pDoor of Prop
	(properties
		modNum 640
		approachX 309
		approachY 165
		x 261
		y 51
		priority 112
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
				(vRightDoor doVerb: theVerb)
			)
		)
	)
)

(instance vTheBed of View
	(properties
		noun 19
		modNum 640
		approachX 299
		approachY 123
		x 82
		y 124
		z 124
		priority 108
		fixPriority 1
		view 686
	)
)

(instance vTheRug of View
	(properties
		noun 33
		modNum 640
		x 10
		y 123
		priority 53
		fixPriority 1
		view 692
	)
)

(instance vLeftWindow of View
	(properties
		noun 16
		modNum 640
		x 6
		y 27
		view 697
		loop 2
	)
)

(instance vRightDoor of View
	(properties
		noun 1
		modNum 640
		approachX 303
		approachY 120
		x 261
		y 53
		z 4
		priority 108
		fixPriority 1
		view 695
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
				(SetFlag 213)
				(gMessager say: 1 32 0 0 0 640) ; "You carefully oil the door's slightly-rusty hinges."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vLeftCandle of View
	(properties
		noun 15
		modNum 640
		x 80
		y 68
		view 699
		loop 1
	)
)

(instance vRightCandle of View
	(properties
		noun 15
		modNum 640
		x 229
		y 77
		view 699
	)
)

(instance fChest of Feature
	(properties
		noun 6
		modNum 640
		nsLeft 116
		nsTop 116
		nsRight 178
		nsBottom 148
		sightAngle 180
		approachX 172
		approachY 154
		x 147
		y 132
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-80 ; openSpell (part 2)
				(if (IsFlag 185)
					(cond
						(local1
							(self doVerb: 4)
						)
						((IsFlag 394)
							(gMessager say: 6 80 19 0 0 640) ; "The chest is already open."
						)
						(else
							(gCurRoom setScript: sOpenTheChest)
						)
					)
				else
					(gCurRoom setScript: sOpenGhostHere)
				)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(4 ; Do
				(if (IsFlag 185)
					(gCurRoom setScript: sDoTheChest)
				else
					(gCurRoom setScript: sGhostHere)
				)
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
		nsLeft 283
		nsTop 116
		nsRight 319
		nsBottom 137
		sightAngle 180
		x 301
		y 126
	)
)

(instance fBedHead of Feature
	(properties
		noun 19
		modNum 640
		nsLeft 117
		nsTop 20
		nsRight 206
		nsBottom 80
		sightAngle 180
		x 161
		y 50
	)
)

(instance fCurtain1 of Feature
	(properties
		noun 18
		modNum 640
		nsLeft 87
		nsRight 114
		nsBottom 94
		sightAngle 180
		x 100
		y 47
	)
)

(instance fCurtain2 of Feature
	(properties
		noun 18
		modNum 640
		nsLeft 209
		nsRight 235
		nsBottom 123
		sightAngle 180
		x 222
		y 61
	)
)

(instance chestTeller of Teller
	(properties
		modNum 640
		actionVerb 4
	)

	(method (doVerb)
		(if (pChest cel:)
			(pChest doVerb: &rest)
		else
			(super doVerb: &rest)
		)
	)

	(method (showCases)
		(super
			showCases:
				13 ; Look for Traps
				(and (gEgo has: 24) (IsFlag 242) (not local1)) ; theToolkit
				4 ; Open Chest
				(not local1)
				26 ; Pick Lock
				(and [gEgoStats 9] (not local1)) ; pick locks
				25 ; Bash Chest Open
				(not local1)
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
				(if local2
					(self clean:)
					(gCurRoom setScript: sOpenTheChest)
				else
					(if ((ScriptID 648 0) init: show: dispose:) ; ticTacPuz
						(self clean:)
						(= local2 1)
						(DisposeScript 648)
						(gCurRoom setScript: sOpenTheChest)
					else
						(self clean:)
						(if (IsFlag 182)
							(ClearFlag 182)
							(gCurRoom setScript: sOpenTheChest)
						)
					)
					(DisposeScript 648)
				)
			)
			(25 ; Bash Chest Open
				(if (== (gEgo trySkill: 0 325) 1) ; strength
					(self clean:)
					(gCurRoom setScript: sOpenTheChest)
				else
					(super sayMessage: 3 6 17 &rest) ; You are not nearly strong enough to break the chest open; you'll need to do some serious body-building if you want to keep using this approach.
					(gGlory handsOn:)
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

(instance ghostSound of Sound
	(properties
		number 852
	)
)

(instance explosiveSound of Sound
	(properties
		number 971
	)
)

